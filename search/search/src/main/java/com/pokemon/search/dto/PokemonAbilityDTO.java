package com.pokemon.search.dto;

import java.io.Serializable;
import java.util.List;

public class PokemonAbilityDTO implements Serializable {

    private Boolean isHidden;
    private Integer slot;
    private AbilityDTO ability;

    public Boolean getHidden() {
        return isHidden;
    }

    public void setHidden(Boolean hidden) {
        isHidden = hidden;
    }

    public Integer getSlot() {
        return slot;
    }

    public void setSlot(Integer slot) {
        this.slot = slot;
    }

    public AbilityDTO getAbility() {
        return ability;
    }

    public void setAbility(AbilityDTO ability) {
        this.ability = ability;
    }
}
