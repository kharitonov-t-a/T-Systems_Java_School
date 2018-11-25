package com.web.shop.model.user;

import com.web.shop.model.order.Order;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "UserAddress")
public class UserAddress implements Serializable {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "ID", nullable = false, length = 6)
    private Integer id;

    @Column(name = "country", length = 30)
    @Size(min = 3, max = 30)
    @NotBlank
    private String country;

    @Column(name = "city", length = 30)
    @Size(min = 3, max = 30)
    @NotBlank
    private String city;

    @Column(name = "zip", length = 6)
    @Digits(integer = 6, fraction = 0)
    @NotNull
    private Integer zip;

    @Column(name = "street", length = 30)
    @Size(min = 3, max = 30)
    @NotBlank
    private String street;

    @Column(name = "house", length = 5)
    @Digits(integer = 3, fraction = 0)
    @NotNull
    private Integer house;

    @Column(name = "flat", length = 5)
    @Digits(integer = 5, fraction = 0)
    @NotNull
    private Integer flat;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    @OneToMany(mappedBy="userAddress", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Order> orderList;

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

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

//    @Override
//    public String toString() {
//        return "UserAddress{" +
//                "id=" + id +
//                ", country='" + country + '\'' +
//                ", city='" + city + '\'' +
//                ", zip=" + zip +
//                ", street='" + street + '\'' +
//                ", house=" + house +
//                ", flat=" + flat +
//                ", user=" + user +
//                ", orderList=" + orderList +
//                '}';
//    }
}
