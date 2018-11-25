package com.web.shop.dto.user;

import com.web.shop.dto.order.OrderDTO;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.List;

//@Setter
//@Getter
public class UserAddressDTO implements Serializable {

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

    private List<OrderDTO> orderList;

    public UserAddressDTO() {
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

    public List<OrderDTO> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<OrderDTO> orderList) {
        this.orderList = orderList;
    }

//    @Override
//    public String toString() {
//        return "UserAddressDTO{" +
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
