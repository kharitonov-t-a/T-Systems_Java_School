package com.web.shop.model.Users;

import com.web.shop.model.Users.User;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "Addresses")
//@Setter
//@Getter
public class Address implements Serializable {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "ID", nullable = false, length = 6)
    private Integer id;

    @Column(name = "Country", length = 30)
    @Size(min = 3, max = 30)
    @NotBlank
    private String country;

    @Column(name = "City", length = 30)
    @Size(min = 3, max = 30)
    @NotBlank
    private String city;

    @Column(name = "Zip", length = 6)
    @Size(min = 6, max = 6)
    @NotBlank
    private Integer zip;

    @Column(name = "Street", length = 30)
    @Size(min = 3, max = 30)
    @NotBlank
    private String street;

    @Column(name = "House", length = 5)
    @Size(min = 1, max = 5)
    @NotBlank
    private Integer house;

    @Column(name = "Flat", length = 5)
    @Size(min = 1, max = 5)
    @NotBlank
    private Integer flat;

    @OneToOne(fetch = FetchType.LAZY) //EAGER
    @JoinColumn(name = "UserId", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    public Address(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getZip() {
        return zip;
    }

    public void setZip(Integer zip) {
        this.zip = zip;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getHouse() {
        return house;
    }

    public void setHouse(Integer house) {
        this.house = house;
    }

    public Integer getFlat() {
        return flat;
    }

    public void setFlat(Integer flat) {
        this.flat = flat;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", country=" + country + ", city=" + city +
                ", zip=" + zip + ", street=" + street + ", house=" + house +
                ", flat=" + flat + ", userId=" + user.getId() + "]";
    }

}
