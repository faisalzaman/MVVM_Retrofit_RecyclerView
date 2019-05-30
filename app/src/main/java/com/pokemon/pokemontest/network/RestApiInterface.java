package com.pokemon.pokemontest.network;


import com.pokemon.pokemontest.data.model.Data;


import retrofit2.Call;
import retrofit2.http.GET;
import rx.Observable;

public interface RestApiInterface {


    @GET("pokedex.json")
    Call<Data> getAllPokemon();


}

