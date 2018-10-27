package com.web.shop.dto;

import com.web.shop.model.UserProfile;
import com.web.shop.validator.EnableMatchConstraint;
import com.web.shop.validator.Match;
import com.web.shop.validator.UniqueEmail;
import com.web.shop.validator.Year;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.GeneratedValue;
import javax.validation.constraints.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@EnableMatchConstraint
public class UserDTO {

    private Integer id;

//    @Enumerated(EnumType.STRING)
//    @Column(name="UserRole", length=15, unique=true, nullable=false)
//    private UserRole userRole = UserRole.USER;

    @Size(min = 3, max = 30)
    @NotBlank
    private String firstName;

    @Size(min = 3, max = 30)
    private String surnName;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Past
    @Year(value=2000/*, message ="Date must be before 2000 year"*/)
    @NotNull
    private Date birthday;

    @NotBlank
    @Email
    @UniqueEmail
    private String email;

    @NotBlank
    @Size(min = 4)
    private String password;

    @Match(field = "password")
    private String confirmPassword;

    private Set<UserProfileDTO> userProfiles = new HashSet<UserProfileDTO>();

//    public User(UserRole userRoleID, String firstName, String surnName, Date birthDay, String eMail, String password){
//        this.userRole = userRoleID;
//        this.firstName = firstName;
//        this.surnName = surnName;
//        this.birthday = birthDay;
//        this.eMail = eMail;
//        this.password = password;
//    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurnName() {
        return surnName;
    }

    public void setSurnName(String surnName) {
        this.surnName = surnName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<UserProfileDTO> getUserProfiles() {
        return userProfiles;
    }

    public void setUserProfiles(Set<UserProfileDTO> userProfiles) {
        this.userProfiles = userProfiles;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
