package com.web.shop.model;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Users")
//@NamedQuery(name = "User.getAll", query = "SELECT c from User c")
public class User implements Serializable {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "ID", nullable = false, length = 6)
    private Integer id;

//    @Enumerated(EnumType.STRING)
//    @Column(name="UserRole", length=15, unique=true, nullable=false)
//    private UserRole userRole = UserRole.USER;

    @Column(name = "FirstName", length = 30)
    @Size(min = 3, max = 30)
    @NotEmpty
    private String firstName;

    @Column(name = "SurnName", length = 30)
    @Size(min = 3, max = 30)
    private String surnName;

    @Column(name = "Birthday")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Past
    @NotNull
    private Date birthday;

    @Column(name = "Email", nullable = false, length = 120, unique = true)
    @Email
    @NotEmpty
    private String email;

    @Column(name = "Password", nullable = false, length = 120)
    @NotEmpty
    @Size(min = 4)
    private String password;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "appuserroles",
            joinColumns = { @JoinColumn(name = "userid") },
            inverseJoinColumns = { @JoinColumn(name = "roleid") })
    private Set<UserProfile> userProfiles = new HashSet<UserProfile>();

//    public User(UserRole userRoleID, String firstName, String surnName, Date birthDay, String eMail, String password){
//        this.userRole = userRoleID;
//        this.firstName = firstName;
//        this.surnName = surnName;
//        this.birthday = birthDay;
//        this.eMail = eMail;
//        this.password = password;
//    }

    public User() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

//    public UserRole getUserRole() {
//        return userRole;
//    }
//
//    public void setUserRole(UserRole userRole) {
//        this.userRole = userRole;
//    }

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

//    @Override
//    public String toString() {
//        return "User [id=" + id + ", userRoleID=" + userRoleID + ", firstName=" + firstName +
//                ", surnName=" + surnName + ", birthday=" + birthday + ", eMail=" + eMail +
//                ", password=" + password + "]";
//    }
}