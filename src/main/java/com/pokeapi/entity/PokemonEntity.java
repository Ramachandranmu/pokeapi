package com.pokeapi.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PokemonEntity {
	
	int id;
	
	String name;
	
	int base_experience;
	
	int height;
	
	List<Moves> moves;
	
	PokemonEntity(){		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBase_experience() {
		return base_experience;
	}

	public void setBase_experience(int base_experience) {
		this.base_experience = base_experience;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public List<Moves> getMoves() {
		return moves;
	}

	public void setMoves(List<Moves> moves) {
		this.moves = moves;
	}
}
