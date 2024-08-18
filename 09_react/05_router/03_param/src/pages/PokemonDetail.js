import {useParams} from 'react-router-dom';
import {useState, useEffect} from 'react';
import { getPokemonDetail } from '../apis/PokeAPI';


function PokemonDetail() {

    const {pokemonId} = useParams();
    
    const [pokemon, setPokemon] = useState({
        name: '',
        menuPrice: 0,
        categoryName: '',
        detail: {}
    });

    useEffect(
        () => {
            setPokemon(getPokemonDetail(pokemonId));
        },
        []
    );

    return (
        <>
            <h2>포켓몬 상세정보</h2>
            <h3>포켓몬 이름 : {pokemon.name}</h3>
            <h3>메뉴 가격 : {menu.menuPrice}</h3>
            <h3>메뉴 종류 : {menu.categoryName}</h3>
            <h3>메뉴 설명 : {menu.detail.description}</h3>
            <img src={pokemon.detail.image} style={{maxWidth: 500}}/>
        </>
    );
}

export default PokemonDetails;