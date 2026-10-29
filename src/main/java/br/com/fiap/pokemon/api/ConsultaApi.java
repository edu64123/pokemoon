package br.com.fiap.pokemon.api;

import br.com.fiap.pokemon.dto.DadosApiDTO;
import org.springframework.web.client.RestTemplate;

public class ConsultaApi {


    // a pokeAPI fornece informacoes sobre os pokemons.
    // neste trabalho usei id, nome, altura, peso e experiencia base.


    public DadosApiDTO buscar(String nome) {
        String url = "https://pokeapi.co/api/v2/pokemon/" + nome;

        RestTemplate restTemplate = new RestTemplate();
        DadosApiDTO pokemon = restTemplate.getForObject(url, DadosApiDTO.class);

        return pokemon;
    }
}
