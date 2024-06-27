package com.i5.section02.annotation.subsection03.collection;

import com.i5.section02.annotation.common.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/*
 *   PokemonService.java
 *   Author : syamcat
 *   Created : 24. 6. 21.
 **/
@Service("pokemonServiceCollection")
public class PokemonService {

//    private List<Pokemon> pokemons;

//    @Autowired
//    public PokemonService(List<Pokemon> pokemons) {
//        this.pokemons = pokemons;
//    }
//
//    public void pokemonAttack() {
//        pokemons.forEach(Pokemon::attack);
//    }

    private final Map<String, Pokemon> pokemonMap;

    @Autowired
    public PokemonService(Map<String, Pokemon> pokemonMap) {
        this.pokemonMap = pokemonMap;
    }

    public void pokemonAttack() {
        pokemonMap.forEach((k, v) -> {
            System.out.println("key: " + k);
            System.out.println("공격: ");
            v.attack();
        });
    }
}
