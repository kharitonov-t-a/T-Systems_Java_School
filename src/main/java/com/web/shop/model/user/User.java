package com.web.shop.model.user;

import com.web.shop.model.order.Order;
import com.web.shop.validator.UniqueEmail;
import com.web.shop.validator.Year;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "User")
//@Setter
//@Getter
//@NamedQuery(name = "User.getAll", query = "SELECT c from User c")
public class User implements Serializable {



    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "ID", nullable = false, length = 6)
    private Integer id;

    @Column(name = "firstName", length = 30)
    @Size(min = 3, max = 30)
    @NotBlank
    private String firstName;

    @Column(name = "lastName", length = 30)
    @Size(min = 3, max = 30)
    private String lastName;

    @Column(name = "birthday")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Past
    @NotNull
    @Year(value=2000/*, message ="Date must be before 2000 year"*/)
    private Date birthday;

    @Column(name = "email", nullable = false, length = 120, unique = true)
    @Email
    @UniqueEmail
    @NotBlank
    private String email;

    @Column(name = "password", nullable = false, length = 120)
    @NotBlank
    @Size(min = 4)
    private String password;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "userRoles",
            joinColumns = { @JoinColumn(name = "userId") },
            inverseJoinColumns = { @JoinColumn(name = "roleId") })
    private Set<UserProfile> userProfileSet = new HashSet<UserProfile>();

    @OneToMany(mappedBy="user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Order> orderList;

    @OneToMany(mappedBy="user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<UserAddress> userAddressList;

//    public User(UserRole userRoleID, String firstName, String lastName, Date birthDay, String eMail, String password){
//        this.userRole = userRoleID;
//        this.firstName = firstName;
//        this.lastName = lastName;
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

    public Set<UserProfile> getUserProfileSet() {
        return userProfileSet;
    }

    public void setUserProfileSet(Set<UserProfile> userProfileSet) {
        this.userProfileSet = userProfileSet;
    }


    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    public List<UserAddress> getUserAddressList() {
        return userAddressList;
    }

    public void setUserAddressList(List<UserAddress> userAddressList) {
        this.userAddressList = userAddressList;
    }

//    @Override
//    public String toString() {
//        return "User{" +
//                "id=" + id +
//                ", firstName='" + firstName + '\'' +
//                ", lastName='" + lastName + '\'' +
//                ", birthday=" + birthday +
//                ", email='" + email + '\'' +
//                ", password='" + password + '\'' +
//                ", userProfileSet=" + userProfileSet +
//                ", orderList=" + orderList +
//                ", userAddressList=" + userAddressList +
//                '}';
//    }
}