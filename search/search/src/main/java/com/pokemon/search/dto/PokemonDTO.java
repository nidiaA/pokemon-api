package com.pokemon.search.dto;

import java.io.Serializable;
import java.util.List;

public class PokemonDTO implements Serializable {

    private String name;

    private List<PokemonAbilityDTO> abilities;

    private List<FormDTO> forms;

    private String height;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PokemonAbilityDTO> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<PokemonAbilityDTO> abilities) {
        this.abilities = abilities;
    }

    public List<FormDTO> getForms() {
        return forms;
    }

    public void setForms(List<FormDTO> forms) {
        this.forms = forms;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }
}
