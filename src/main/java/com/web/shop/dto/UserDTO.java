package com.web.shop.dto;

import com.web.shop.model.UserProfile;
import com.web.shop.validator.*;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@EnableMatchConstraint(groups = {UserDTO.ValidationPassword.class})
@EnableUniqueEmailConstraint(groups = {UserDTO.ValidationInfo.class})
public class UserDTO {

    public interface ValidationPassword {
    }

    public interface ValidationInfo {
    }

    private Integer id;

    @Size(min = 3, max = 30, groups = {ValidationInfo.class})
    @NotBlank(groups = {ValidationInfo.class})
    private String firstName;

    @Size(min = 3, max = 30, groups = {ValidationInfo.class})
    private String surnName;

    @DateTimeFormat(pattern = "yyyy-MM-dd"/*, groups = {ValidationInfo.class}*/)
    @Past(groups = {ValidationInfo.class})
    @Year(value=2000, groups = {ValidationInfo.class})
    @NotNull(groups = {ValidationInfo.class})
    private Date birthday;

    @NotBlank(groups = {ValidationInfo.class})
    @Email(groups = {ValidationInfo.class})
    @UniqueEmail
    private String email;

    @NotBlank(groups = {ValidationPassword.class})
    @Size(min = 4, groups = {ValidationPassword.class})
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

    @Override
    public String toString() {
        StringBuilder userProfilesString = new StringBuilder();
        userProfiles.parallelStream().forEach(e -> userProfilesString.append(e.getRole() + ", "));
        return "User [id=" + id + ", firstName=" + firstName +
                ", surnName=" + surnName + ", birthday=" + birthday + ", eMail=" + email +
                ", password=" + password + ", roles:" + userProfilesString + "]";
    }
























//    public UserPasswordDTO getUserPasswordDTO() {
//        return userPasswordDTO;
//    }
//
//    public void setUserPasswordDTO(UserPasswordDTO userPasswordDTO) {
//        this.userPasswordDTO = userPasswordDTO;
//    }
//
//    @Embedded
//    private UserPasswordDTO userPasswordDTO;
//
//    public UserInfoDTO getUserInfoDTO() {
//        return userInfoDTO;
//    }
//
//    public void setUserInfoDTO(UserInfoDTO userInfoDTO) {
//        this.userInfoDTO = userInfoDTO;
//    }
//
//    @Embedded
//    private UserInfoDTO userInfoDTO;
//
//
//
////    public User(UserRole userRoleID, String firstName, String surnName, Date birthDay, String eMail, String password){
////        this.userRole = userRoleID;
////        this.firstName = firstName;
////        this.surnName = surnName;
////        this.birthday = birthDay;
////        this.eMail = eMail;
////        this.password = password;
////    }
//
//
//
//
//
//
//    @Override
//    public String toString() {
//        return "User [" + userInfoDTO + ", password=" + userPasswordDTO + "]";
//    }
}
