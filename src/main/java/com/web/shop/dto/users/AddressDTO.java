package com.web.shop.dto.users;

import com.web.shop.dto.orders.OrderDTO;
import com.web.shop.model.orders.Order;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.List;

//@Setter
//@Getter
public class AddressDTO implements Serializable {

    private Integer id;

    @Size(min = 3, max = 30)
    @NotBlank
    private String country;

    @Size(min = 3, max = 30)
    @NotBlank
    private String city;

    @Digits(integer = 6, fraction = 0)
    @NotNull
    private Integer zip;

    @Size(min = 3, max = 30)
    @NotBlank
    private String street;

    @Digits(integer = 3, fraction = 0)
    @NotNull
    private Integer house;

    @Digits(integer = 5, fraction = 0)
    @NotNull
    private Integer flat;

    private UserDTO user;

    private List<OrderDTO> orders;

    public AddressDTO() {
    }

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

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public List<OrderDTO> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderDTO> orders) {
        this.orders = orders;
    }

//    @Override
//    public String toString() {
//        return "AddressDTO{" +
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
