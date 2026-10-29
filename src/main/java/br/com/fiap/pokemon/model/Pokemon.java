package br.com.fiap.pokemon.model;

import br.com.fiap.pokemon.enums.TipoPokemon;

public class Pokemon {
    private int id;
    private String nome;
    private int altura;
    private int peso;
    private int experiencia;
    private TipoPokemon tipo;

    public Pokemon() {
    }

    public Pokemon(int id, String nome, int altura, int peso, int experiencia, TipoPokemon tipo) {
        this.id = id;
        this.nome = nome;
        this.altura = altura;
        this.peso = peso;
        this.experiencia = experiencia;
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    public TipoPokemon getTipo() {
        return tipo;
    }

    public void setTipo(TipoPokemon tipo) {
        this.tipo = tipo;
    }
}
