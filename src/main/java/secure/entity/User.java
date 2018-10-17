package secure.entity;
import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
//@lombok.Setter
//@lombok.Getter
@Table(name = "User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false, updatable = false)
    private int id;
    @Column(name = "UserRoleID", nullable = false)
    private int userRoleID;
    @Column(name = "FirstName", length = 32)
    private String firstName;
    @Column(name = "SurnName", length = 32)
    private String surnName;
    @Column(name = "Birthday")
    private Date birthday;
    @Column(name = "Email", nullable = false, length = 120)
    private String eMail;
    @Column(name = "password", nullable = false, length = 32)
    private String password;

//    public User(int userRoleID, String firstName, String surnName, Date birthDay, String eMail, String password){
//        this.userRoleID = userRoleID;
//        this.firstName = firstName;
//        this.surnName = surnName;
//        this.birthday = birthDay;
//        this.eMail = eMail;
//        this.password = password;
//    }

    public User() {

    }

    public int getUserRoleID() {
        return userRoleID;
    }

    public void setUserRoleID(int userRoleID) {
        this.userRoleID = userRoleID;
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

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}