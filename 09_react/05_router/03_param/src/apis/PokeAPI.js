export function getPokemonList() {

	const result = fetch(`https://pokeapi.co/api/v2/pokemon?limit=5&offset=${offset}`)
					.then(response => response.json())
					.then(info => {
						const pokemonPromises = info.results.map(pokemon => fetch(pokemon.url).then(res => res.json()));
						Promise.all(pokemonPromises).then(results => setPokemons(results));
					});

    return result;
}

export function getPokemonDetail(pokemonId) {

	if (keyword) {
		setIsSearching(true);
		return fetch(`https://pokeapi.co/api/v2/pokemon/${keyword.toLowerCase()}`)
			.then(response => response.json())
			.then(info => setPokemons([info]))
			.catch(err => {
				alert('포켓몬을 찾을 수 없습니다.');
				setIsSearching(false);
			});
	} else {
		setIsSearching(false);
		setPage(1);
	}
}