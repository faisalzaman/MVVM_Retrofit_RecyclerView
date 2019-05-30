package com.pokemon.pokemontest.viewmodel;

import android.content.Context;
import android.util.Log;

import com.pokemon.pokemontest.data.model.Data;
import com.pokemon.pokemontest.data.model.Pokemon;
import com.pokemon.pokemontest.network.RestApiInterface;
import com.pokemon.pokemontest.network.RestApiManager;
import com.pokemon.pokemontest.view.callbacks.PokemonDetailCallBack;
import com.pokemon.pokemontest.view.callbacks.PokemonListCallBack;
import com.pokemon.pokemontest.view.ui.AVProgressDialog;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class PokemonDetailViewModel extends BaseViewModel<PokemonDetailCallBack> {
    private AVProgressDialog mLoadingDialog;

    private ArrayList<Pokemon> pokemonslist;

    //TODO BUSINESS LOGIC HERE


    private void showDialog(Context context) {
        mLoadingDialog = new AVProgressDialog(context);
        mLoadingDialog.show();
    }

    private void dismissDialog() {
        if (mLoadingDialog != null && mLoadingDialog.isShowing())
            mLoadingDialog.dismiss();
    }

}
