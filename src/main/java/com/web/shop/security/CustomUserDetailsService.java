package com.web.shop.security;

import java.util.ArrayList;
import java.util.List;

import com.web.shop.dto.UserDTO;
import com.web.shop.dto.UserProfileDTO;
import com.web.shop.model.User;
import com.web.shop.model.UserProfile;
import com.web.shop.model.enums.UserRoles;
import com.web.shop.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService{

    static final Logger logger = LoggerFactory.getLogger(CustomUserDetailsService.class);

    @Autowired
    private UserService userService;

    @Transactional(readOnly=true)
    public UserDetails loadUserByUsername(String eMail)
            throws UsernameNotFoundException {
        UserDTO user = userService.findByEmail(eMail);
        logger.info("User : {}", user);
        if(user==null){
            logger.info("User not found");
            throw new UsernameNotFoundException("Username not found");
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
                true, true, true, true, getGrantedAuthorities(user));
    }

    private List<GrantedAuthority> getGrantedAuthorities(UserDTO user){
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        for(UserProfileDTO userProfile : user.getUserProfiles()){
            logger.info("UserProfile : {}", userProfile);
            authorities.add(new SimpleGrantedAuthority("ROLE_"+userProfile.getRole()));
        }
        logger.info("authorities : {}", authorities);
        return authorities;
    }

    /**
     * This method returns the principal[user-name] of logged-in user.
     */
    public static String getPrincipal() {
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            userName = ((UserDetails) principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }


    public static boolean isCurrentUserInRole(UserRoles role) {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();
        if (authentication != null) {
            return authentication.getAuthorities().stream()
                    .anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals("ROLE_"+role.toString()));
        }
        return false;
    }

}