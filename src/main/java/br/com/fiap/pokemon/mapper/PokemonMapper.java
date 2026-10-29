package br.com.fiap.pokemon.mapper;

import br.com.fiap.pokemon.dto.PokemonDTO;
import br.com.fiap.pokemon.model.Pokemon;

public class PokemonMapper {

    public static PokemonDTO paraDTO(Pokemon pokemon) {
        return new PokemonDTO(
                pokemon.getId(),
                pokemon.getNome(),
                pokemon.getAltura(),
                pokemon.getPeso(),
                pokemon.getExperiencia(),
                pokemon.getTipo()
        );
    }

    public static Pokemon paraModel(PokemonDTO dto) {
        return new Pokemon(
                dto.id(),
                dto.nome(),
                dto.altura(),
                dto.peso(),
                dto.experiencia(),
                dto.tipo()
        );
    }
}
