package com.i5.section02.annotation.subsection03.collection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/*
 *   Application.java
 *   Author : syamcat
 *   Created : 24. 6. 21.
 **/
public class Application {

    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.i5.section02");

        PokemonService pokemonService =  context.getBean("pokemonServiceCollection", PokemonService.class);

        pokemonService.pokemonAttack();
    }
}
