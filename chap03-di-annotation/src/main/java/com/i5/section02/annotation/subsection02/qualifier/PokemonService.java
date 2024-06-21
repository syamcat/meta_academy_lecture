package com.i5.section02.annotation.subsection02.qualifier;

import com.i5.section02.annotation.common.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/*
 *   PokemonService.java
 *   Author : syamcat
 *   Created : 24. 6. 21.
 **/
@Service("pokemonServiceQualifier")
public class PokemonService {

//    @Autowired
//    @Qualifier("pikachu")
    private Pokemon pokemon;

    @Autowired
    public PokemonService(@Qualifier("squirtle") Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    public void pokemonAttack() {
        pokemon.attack();
    }
}
