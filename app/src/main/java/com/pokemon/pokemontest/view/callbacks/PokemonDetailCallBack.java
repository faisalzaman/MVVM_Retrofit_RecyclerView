package com.pokemon.pokemontest.view.callbacks;


import com.pokemon.pokemontest.data.model.Pokemon;

import java.util.ArrayList;

public interface PokemonDetailCallBack extends BaseCallBack {
    public void showError(String msg);
    public void showSuccess(String msg);
//    public void populateData(ArrayList<Pokemon> pokemon);

}
