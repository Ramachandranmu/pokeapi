package com.pokeapi.pokemon.controller;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.pokeapi.entity.PokemonEntity;
import com.pokeapi.entity.PokemonMoveEntity;

@RestController
@RequestMapping("/pokeapi/v1")
public class PokemonController {
  /**
   * 	
   * @param pokemonNameOrId accepts a pokemon name or id
   * @return Returns the greatest Move Name and the Power of a Pokemon
   * @throws Exception in case of incorrect pokemon name or id
   */
  @GetMapping("/main")
  public String getMaxMove(@RequestParam String pokemonNameOrId) throws Exception {
	StringBuffer pokemon_uri = new StringBuffer("https://pokeapi.co/api/v2/pokemon/");
	pokemon_uri.append(pokemonNameOrId);
	HttpHeaders headers = new HttpHeaders();
	headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
	HttpEntity <String> entity = new HttpEntity<String>(headers); 
	RestTemplate restTemplate = new RestTemplate();
	PokemonEntity result = restTemplate.exchange(pokemon_uri.toString(), HttpMethod.GET, entity, PokemonEntity.class).getBody(); 
	List<PokemonMoveEntity> pokemonMoveEntityList = result.getMoves().stream().map(moveEntity->{
	  	return restTemplate.exchange(moveEntity.getMove().getUrl(), HttpMethod.GET, entity, PokemonMoveEntity.class).getBody();
	}).collect(Collectors.toList());	    
	PokemonMoveEntity maxMove = Collections.max(pokemonMoveEntityList,Comparator.comparing(s -> s.getPower()));
    return maxMove.getName() + " : " + maxMove.getPower() ;
  }
}  
