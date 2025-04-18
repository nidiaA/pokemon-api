package com.pokemon.search.service;

import com.pokemon.search.dto.PokemonDTO;
import com.pokemon.search.dto.PokemonListDTO;
import com.pokemon.search.dto.PokemonListItemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class PokemonApiService {

    @Autowired
    private RestTemplate restTemplate;
    private static final String POKEMON_API_BASE_URL = "https://pokeapi.co/api/v2/";

    public PokemonDTO findPokemonByName(String name) {
        String url = POKEMON_API_BASE_URL + "pokemon/" + name.toLowerCase();
        try {
            return restTemplate.getForObject(url, PokemonDTO.class);
        } catch (RuntimeException e){
            System.err.println("Connection Time Error");
            return null;
        } catch (Exception e) {
            System.err.println("Error trying to get Pokemon: " + name + " - " + e.getMessage());
            return null;
        }
    }

    public List<PokemonDTO> getPokemonList() {
        String url = POKEMON_API_BASE_URL + "pokemon/?limit=100";
        List<PokemonDTO> pokemonList = new ArrayList<>();
        try {
            PokemonListDTO pokemonListDTO = restTemplate.getForObject(url, PokemonListDTO.class);
            for (PokemonListItemDTO pokemonListItemDTO : pokemonListDTO.getResults()) {
                PokemonDTO pokemonDTO = findPokemonByName(pokemonListItemDTO.getName());
                pokemonList.add(pokemonDTO);
            }
            return pokemonList;
        } catch (RuntimeException e){
            System.err.println("Connection Time Error");
            return Collections.emptyList();
        } catch (Exception e) {
            System.err.println("Error trying to obtain pokemon list");
            return Collections.emptyList();
        }
    }

    public List<PokemonDTO> filterPokemonByName(String name) {
        String url = POKEMON_API_BASE_URL + "pokemon?limit=100";
        List<PokemonDTO> pokemonList = new ArrayList<>();
        try {
            PokemonListDTO pokemonListDTO = restTemplate.getForObject(url, PokemonListDTO.class);
            for (PokemonListItemDTO pokemonListItemDTO : pokemonListDTO.getResults()) {
                if (pokemonListItemDTO.getName().toLowerCase().contains(name.toLowerCase())) {
                    PokemonDTO pokemonDTO = findPokemonByName(pokemonListItemDTO.getName());
                    pokemonList.add(pokemonDTO);
                }
            }
            return pokemonList;
        } catch (RuntimeException e){
            System.err.println("Connection Time Error");
            return Collections.emptyList();
        } catch (Exception e) {
            System.err.println("Error trying to obtain pokemon list");
            return Collections.emptyList();
        }
    }

}
