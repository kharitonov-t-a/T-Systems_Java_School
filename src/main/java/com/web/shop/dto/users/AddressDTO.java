package com.web.shop.dto.users;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

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

    @Size(min = 6, max = 6)
    @NotBlank
    private Integer zip;

    @Size(min = 3, max = 30)
    @NotBlank
    private String street;

    @Size(min = 1, max = 5)
    @NotBlank
    private Integer house;

    @Size(min = 1, max = 5)
    @NotBlank
    private Integer flat;

    private UserDTO user;

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

    @Override
    public String toString() {
        return "User [id=" + id + ", country=" + country + ", city=" + city +
                ", zip=" + zip + ", street=" + street + ", house=" + house +
                ", flat=" + flat + ", userId=" + user.getId() + "]";
    }

}
