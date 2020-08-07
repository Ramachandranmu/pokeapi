package com.pokeapi;

import com.pokeapi.pokemon.controller.PokemonController;

public class PokemonTestClass {
	//Test class to invoke controller and check the output
	public static void main(String[] args) {
		PokemonController pokemonController = new PokemonController();
		// Sample Pokemon Id or Name to test the pokeapi 
		final String test_pokemon_id_or_name = "magikarp";
		String test_result;
		try {
			//test_result holds the greatest Move Name and the Power of a Pokemon
			test_result = pokemonController.getMaxMove(test_pokemon_id_or_name);
			System.out.println(test_result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
