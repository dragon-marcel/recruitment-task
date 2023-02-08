package com.example.Asseco.model;

import com.example.Asseco.model.annotation.KoliberDescription;
import com.example.Asseco.model.annotation.KoliberFieldDescription;

@KoliberDescription(comment = "Adres")
public class Address {

    @KoliberFieldDescription(comment = "Miasto")
    private String city;

    @KoliberFieldDescription(comment = "Kod pocztowy")
    private String postalCode;

    @KoliberFieldDescription(comment = "Ulica")
    private String street;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

}
