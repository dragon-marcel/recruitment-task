package com.example.Asseco.model;

import java.math.BigDecimal;

import com.example.Asseco.model.annotation.KoliberDescription;
import com.example.Asseco.model.annotation.KoliberFieldDescription;

@KoliberDescription(comment = "Opis")
public class Invoice {

    @KoliberFieldDescription(comment = "Numer")
    private String number;

    @KoliberFieldDescription(comment = "Kwota")
    private BigDecimal amount;

    @KoliberDescription(comment = "Waluta")
    private Currency currency;

    @KoliberDescription(comment = "Kontrahent")
    private Contractor contractor;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Contractor getContractor() {
        return contractor;
    }

    public void setContractor(Contractor contractor) {
        this.contractor = contractor;
    }
    

}
