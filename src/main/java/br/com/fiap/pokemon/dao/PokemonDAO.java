package br.com.fiap.pokemon.dao;

import br.com.fiap.pokemon.enums.TipoPokemon;
import br.com.fiap.pokemon.model.Pokemon;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PokemonDAO {

    public List<Pokemon> listar() {
        List<Pokemon> pokemons = new ArrayList<>();
        String sql = "SELECT * FROM pokemon";

        try {
            Connection connection = ConnectionFactory.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Pokemon pokemon = new Pokemon();
                pokemon.setId(rs.getInt("id"));
                pokemon.setNome(rs.getString("nome"));
                pokemon.setAltura(rs.getInt("altura"));
                pokemon.setPeso(rs.getInt("peso"));
                pokemon.setExperiencia(rs.getInt("experiencia"));
                pokemon.setTipo(TipoPokemon.valueOf(rs.getString("tipo")));

                pokemons.add(pokemon);
            }

            return pokemons;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void cadastrar(Pokemon pokemon) {
        String sql = "INSERT INTO pokemon (nome, altura, peso, experiencia, tipo) VALUES (?, ?, ?, ?, ?)";

        try {
            Connection connection = ConnectionFactory.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, pokemon.getNome());
            stmt.setInt(2, pokemon.getAltura());
            stmt.setInt(3, pokemon.getPeso());
            stmt.setInt(4, pokemon.getExperiencia());
            stmt.setString(5, pokemon.getTipo().toString());

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Pokemon buscarPorPK(int id) {
        String sql = "SELECT * FROM pokemon WHERE id = ?";

        try {
            Connection connection = ConnectionFactory.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Pokemon pokemon = new Pokemon();
                pokemon.setId(rs.getInt("id"));
                pokemon.setNome(rs.getString("nome"));
                pokemon.setAltura(rs.getInt("altura"));
                pokemon.setPeso(rs.getInt("peso"));
                pokemon.setExperiencia(rs.getInt("experiencia"));
                pokemon.setTipo(TipoPokemon.valueOf(rs.getString("tipo")));
                return pokemon;
            }

            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Pokemon buscarPorNome(String nome) {
        String sql = "SELECT * FROM pokemon WHERE nome = ?";

        try {
            Connection connection = ConnectionFactory.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, nome);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Pokemon pokemon = new Pokemon();
                pokemon.setId(rs.getInt("id"));
                pokemon.setNome(rs.getString("nome"));
                pokemon.setAltura(rs.getInt("altura"));
                pokemon.setPeso(rs.getInt("peso"));
                pokemon.setExperiencia(rs.getInt("experiencia"));
                pokemon.setTipo(TipoPokemon.valueOf(rs.getString("tipo")));
                return pokemon;
            }

            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
