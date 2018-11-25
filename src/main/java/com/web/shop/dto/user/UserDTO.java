package com.web.shop.dto.user;

import com.web.shop.dto.order.OrderDTO;
import com.web.shop.validator.email.EnableUniqueEmailConstraint;
import com.web.shop.validator.email.UniqueEmail;
import com.web.shop.validator.match.EnableMatchConstraint;
import com.web.shop.validator.match.Match;
import com.web.shop.validator.year.Year;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.*;

@EnableMatchConstraint(groups = {UserDTO.ValidationPassword.class})
@EnableUniqueEmailConstraint(groups = {UserDTO.ValidationInfo.class})
public class UserDTO implements Serializable {

    public UserDTO(){
        fieldsMap.put("id", "ID");
        fieldsMap.put("firstName", "First Name");
        fieldsMap.put("lastName", "Last Name");
        fieldsMap.put("email", "Email address");
        fieldsMap.put("password", "Password");
        fieldsMap.put("confirmPassword", "Confirm password");
        fieldsMap.put("birthday", "Birthday");
    }

//    @Override
//    public String toString() {
//        return "UserDTO{" +
//                "id=" + id +
//                ", firstName='" + firstName + '\'' +
//                ", lastName='" + lastName + '\'' +
//                ", birthday=" + birthday +
//                ", email='" + email + '\'' +
//                ", password='" + password + '\'' +
//                ", confirmPassword='" + confirmPassword + '\'' +
//                ", userProfileSet=" + userProfileSet +
//                ", orderList=" + orderList +
//                ", userAddressList=" + userAddressList +
//                ", fieldsMap=" + fieldsMap +
//                ", fieldsList=" + fieldsList +
//                '}';
//    }

    public interface ValidationPassword {
    }

    public interface ValidationInfo {
    }

    private Integer id;

    @Size(min = 3, max = 30, groups = {ValidationInfo.class})
    @NotBlank(groups = {ValidationInfo.class})
    private String firstName;

    @Size(min = 3, max = 30, groups = {ValidationInfo.class})
    private String lastName;

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

    private Set<UserProfileDTO> userProfileSet = new HashSet<UserProfileDTO>();

    private List<OrderDTO> orderList;

    private List<UserAddressDTO> userAddressList;

    Map<String, String> fieldsMap = new LinkedHashMap <>();

    public Map<String, String> getFieldsMap() {
        return fieldsMap;
    }

//    public List<String> getFieldsList() {
//        return fieldsList;
//    }

//    private final List<String> fieldsList = Arrays.asList("id", "firstName", "lastName", "birthday", "email","password", "confirmPassword");


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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public Set<UserProfileDTO> getUserProfileSet() {
        return userProfileSet;
    }

    public void setUserProfileSet(Set<UserProfileDTO> userProfileSet) {
        this.userProfileSet = userProfileSet;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public List<OrderDTO> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<OrderDTO> orderList) {
        this.orderList = orderList;
    }

    public List<UserAddressDTO> getUserAddressList() {
        return userAddressList;
    }

    public void setUserAddressList(List<UserAddressDTO> userAddressList) {
        this.userAddressList = userAddressList;
    }

}
