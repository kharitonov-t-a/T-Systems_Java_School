package com.web.shop.security;

import java.util.ArrayList;
import java.util.List;

import com.web.shop.dto.user.UserDTO;
import com.web.shop.dto.user.UserProfileDTO;
import com.web.shop.service.interfaces.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
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

        for(UserProfileDTO userProfile : user.getUserProfileSet()){
            logger.info("UserProfile : {}", userProfile);
            authorities.add(new SimpleGrantedAuthority("ROLE_"+userProfile.getRole()));
        }
        logger.info("authorities : {}", authorities);
        return authorities;
    }





}