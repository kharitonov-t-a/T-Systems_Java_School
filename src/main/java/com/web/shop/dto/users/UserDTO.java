package com.web.shop.dto.users;

import com.web.shop.validator.*;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.*;

@EnableMatchConstraint(groups = {UserDTO.ValidationPassword.class})
@EnableUniqueEmailConstraint(groups = {UserDTO.ValidationInfo.class})
public class UserDTO implements Serializable {

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
    @UniqueElements
    private String email;

    @NotBlank(groups = {ValidationPassword.class})
    @Size(min = 4, groups = {ValidationPassword.class})
    private String password;

    @Match(field = "password")
    private String confirmPassword;

    private Set<UserProfileDTO> userProfiles = new HashSet<UserProfileDTO>();

    public List<String> getFieldsList() {
        return fieldsList;
    }

    public Map<String, String> getFieldsMap() {
        return fieldsMap;
    }

    Map<String, String> fieldsMap = new LinkedHashMap <>();

    public UserDTO(){
        fieldsMap.put("id", "ID");
        fieldsMap.put("firstName", "First Name");
        fieldsMap.put("surnName", "Surn Name");
        fieldsMap.put("email", "Email address");
        fieldsMap.put("password", "Password");
        fieldsMap.put("confirmPassword", "Confirm password");
        fieldsMap.put("birthday", "Birthday");
    }
    private final List<String> fieldsList = Arrays.asList("id", "firstName", "surnName", "birthday", "email","password", "confirmPassword");

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
}
