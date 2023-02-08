package com.example.Asseco.model;

import com.example.Asseco.annotation.KoliberDescription;
import com.example.Asseco.annotation.KoliberFieldDescription;

@KoliberDescription(comment = "Waluta")
public class Currency {

    @KoliberFieldDescription(comment = "Kod")
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
