package com.example.Asseco.model;

import java.util.List;

import com.example.Asseco.annotation.KoliberDescription;
import com.example.Asseco.annotation.KoliberFieldDescription;

@KoliberDescription(comment = "Kontrahent")
public class Contractor {

    @KoliberFieldDescription(comment = "Nazwa")
    private String name;

    @KoliberFieldDescription(comment = "NIP")
    private String nip;

    @KoliberDescription(comment = "Adresy")
    private List<Address> addresses;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

}
