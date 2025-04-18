package com.pokemon.search.controller;

import com.pokemon.search.dto.PokemonDTO;
import com.pokemon.search.service.PokemonApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/pokemon")
public class PokemonController {

    @Autowired
    private PokemonApiService pokemonApiService;

    @GetMapping("/{name}")
    public ResponseEntity<PokemonDTO> getPokemonByName(@PathVariable String name) {
        PokemonDTO pokemon = pokemonApiService.findPokemonByName(name);
        if (pokemon != null) {
            return new ResponseEntity<>(pokemon, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/list")
    public ResponseEntity<List<PokemonDTO>> getPokemonList() {
        List<PokemonDTO> pokemonList = pokemonApiService.getPokemonList();
        if (!pokemonList.isEmpty()) {
            return new ResponseEntity<>(pokemonList, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/filter/{filter}")
    public ResponseEntity<List<PokemonDTO>> getPokemonListByFilter(@PathVariable String filter) {
        List<PokemonDTO> pokemonList = pokemonApiService.filterPokemonByName(filter);
        if (!pokemonList.isEmpty()) {
            return new ResponseEntity<>(pokemonList, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
