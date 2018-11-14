package com.web.shop.model.users;

import com.web.shop.model.orders.Order;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

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
    @Digits(integer = 6, fraction = 0)
    @NotNull
    private Integer zip;

    @Column(name = "Street", length = 30)
    @Size(min = 3, max = 30)
    @NotBlank
    private String street;

    @Column(name = "House", length = 5)
    @Digits(integer = 3, fraction = 0)
    @NotNull
    private Integer house;

    @Column(name = "Flat", length = 5)
    @Digits(integer = 5, fraction = 0)
    @NotNull
    private Integer flat;

    @ManyToOne
    @JoinColumn(name = "UserId", nullable = false)
    private User user;

    @OneToMany(mappedBy="address", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private List<Order> orders;

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

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

//    @Override
//    public String toString() {
//        return "Address{" +
//                "id=" + id +
//                ", country='" + country + '\'' +
//                ", city='" + city + '\'' +
//                ", zip=" + zip +
//                ", street='" + street + '\'' +
//                ", house=" + house +
//                ", flat=" + flat +
//                ", user=" + user +
//                ", orders=" + orders +
//                '}';
//    }
}