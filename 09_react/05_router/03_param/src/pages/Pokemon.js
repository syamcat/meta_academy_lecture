import { getPokemonList } from "../apis/PokeAPI";
import { useState, useEffect } from 'react';
import MenuItem from '../components/MenuItem';

function Pokemon() {
	const [pokemons, setPokemons] = useState([]);

	useEffect(
		() => {
            setPokemons(getPokemonList());
        },
        []
	);
}