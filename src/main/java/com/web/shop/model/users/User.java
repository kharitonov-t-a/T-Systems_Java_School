package com.web.shop.model.users;

import com.web.shop.model.orders.Order;
import com.web.shop.validator.Year;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "Users")
//@Setter
//@Getter
//@NamedQuery(name = "User.getAll", query = "SELECT c from User c")
public class User implements Serializable {



    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "ID", nullable = false, length = 6)
    private Integer id;

    @Column(name = "FirstName", length = 30)
    @Size(min = 3, max = 30)
    @NotBlank
    private String firstName;

    @Column(name = "SurnName", length = 30)
    @Size(min = 3, max = 30)
    private String surnName;

    @Column(name = "Birthday")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Past
    @NotNull
    @Year(value=2000/*, message ="Date must be before 2000 year"*/)
    private Date birthday;

    @Column(name = "Email", nullable = false, length = 120, unique = true)
    @Email
    @NotBlank
    private String email;

    @Column(name = "Password", nullable = false, length = 120)
    @NotBlank
    @Size(min = 4)
    private String password;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "appuserroles",
            joinColumns = { @JoinColumn(name = "userid") },
            inverseJoinColumns = { @JoinColumn(name = "roleid") })
    private Set<UserProfile> userProfiles = new HashSet<UserProfile>();

    @OneToMany(mappedBy="user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Order> orders;

    @OneToMany(mappedBy="user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Address> addresses;

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

    public Set<UserProfile> getUserProfiles() {
        return userProfiles;
    }

    public void setUserProfiles(Set<UserProfile> userProfiles) {
        this.userProfiles = userProfiles;
    }


    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

//    @Override
//    public String toString() {
//        return "User{" +
//                "id=" + id +
//                ", firstName='" + firstName + '\'' +
//                ", surnName='" + surnName + '\'' +
//                ", birthday=" + birthday +
//                ", email='" + email + '\'' +
//                ", password='" + password + '\'' +
//                ", userProfiles=" + userProfiles +
//                ", orders=" + orders +
//                ", addresses=" + addresses +
//                '}';
//    }
}