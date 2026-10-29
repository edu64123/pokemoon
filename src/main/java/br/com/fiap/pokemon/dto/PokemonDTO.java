package br.com.fiap.pokemon.dto;

import br.com.fiap.pokemon.enums.TipoPokemon;

public record PokemonDTO(
        int id,
        String nome,
        int altura,
        int peso,
        int experiencia,
        TipoPokemon tipo
) {
}
