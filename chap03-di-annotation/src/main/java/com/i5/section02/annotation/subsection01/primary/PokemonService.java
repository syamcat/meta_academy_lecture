package com.i5.section02.annotation.subsection01.primary;

/*
 *   PokemonService.java
 *   Author : syamcat
 *   Created : 24. 6. 21.
 **/

import com.i5.section02.annotation.common.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("pokemonServicePrimary")
public class PokemonService {

    private final Pokemon pokemon;

    @Autowired
    public PokemonService(Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    public void pokemonAttack() {
        pokemon.attack();
    }
}
