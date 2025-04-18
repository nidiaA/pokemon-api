package com.pokemon.search.dto;

import java.io.Serializable;

public class FormDTO implements Serializable {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
