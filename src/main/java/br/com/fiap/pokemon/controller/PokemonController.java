package br.com.fiap.pokemon.controller;

import br.com.fiap.pokemon.api.ConsultaApi;
import br.com.fiap.pokemon.dao.PokemonDAO;
import br.com.fiap.pokemon.dto.DadosApiDTO;
import br.com.fiap.pokemon.dto.PokemonDTO;
import br.com.fiap.pokemon.mapper.PokemonMapper;
import br.com.fiap.pokemon.model.Pokemon;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {

    private PokemonDAO pokemonDAO = new PokemonDAO();
    private ConsultaApi consultaApi = new ConsultaApi();

    @GetMapping
    public List<PokemonDTO> listar() {
        List<Pokemon> pokemons = pokemonDAO.listar();
        List<PokemonDTO> pokemonsDTO = new ArrayList<>();

        for (Pokemon pokemon : pokemons) {
            pokemonsDTO.add(PokemonMapper.paraDTO(pokemon));
        }

        return pokemonsDTO;
    }

    @PostMapping
    public String cadastrar(@RequestBody PokemonDTO dto) {
        Pokemon pokemon = PokemonMapper.paraModel(dto);
        pokemonDAO.cadastrar(pokemon);
        return "Pokemon cadastrado com sucesso";
    }

    @GetMapping("/{id}")
    public PokemonDTO buscarPorId(@PathVariable int id) {
        Pokemon pokemon = pokemonDAO.buscarPorPK(id);

        if (pokemon == null) {
            return null;
        }

        return PokemonMapper.paraDTO(pokemon);
    }

    @GetMapping("/nome/{nome}")
    public PokemonDTO buscarPorNome(@PathVariable String nome) {
        Pokemon pokemon = pokemonDAO.buscarPorNome(nome);

        if (pokemon == null) {
            return null;
        }

        return PokemonMapper.paraDTO(pokemon);
    }

    @GetMapping("/api/{nome}")
    public DadosApiDTO buscarNaApi(@PathVariable String nome) {
        return consultaApi.buscar(nome);
    }
}
