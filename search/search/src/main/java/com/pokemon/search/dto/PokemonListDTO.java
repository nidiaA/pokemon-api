package com.pokemon.search.dto;

import java.io.Serializable;
import java.util.List;

public class PokemonListDTO implements Serializable {

    private int count;
    private String next;
    private String previous;
    private List<PokemonListItemDTO> results;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public List<PokemonListItemDTO> getResults() {
        return results;
    }

    public void setResults(List<PokemonListItemDTO> results) {
        this.results = results;
    }
}
