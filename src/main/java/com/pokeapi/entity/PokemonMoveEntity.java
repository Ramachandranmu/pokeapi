package com.pokeapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PokemonMoveEntity {
	
	String name;
	
	int accuracy;
	
	int power;	

	public String getName() {
		return name;
	}

	public void setMoveName(String moveName) {
		this.name = name;
	}

	public int getAccuracy() {
		return accuracy;
	}

	public void setAccuracy(int accuracy) {
		this.accuracy = accuracy;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

}
