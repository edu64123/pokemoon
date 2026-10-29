package br.com.fiap.pokemon.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DadosApiDTO {
    private int id;
    private String name;
    private int height;
    private int weight;

    @JsonProperty("base_experience")
    private int baseExperience;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getHeight() { return height; }
    public void setHeight(int height) { this.height = height; }
    public int getWeight() { return weight; }
    public void setWeight(int weight) { this.weight = weight; }
    public int getBaseExperience() { return baseExperience; }
    public void setBaseExperience(int baseExperience) { this.baseExperience = baseExperience; }
}
