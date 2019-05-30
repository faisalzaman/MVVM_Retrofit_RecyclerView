package com.pokemon.pokemontest.viewmodel;

import android.content.Context;
import android.util.Log;

import com.pokemon.pokemontest.data.SessionManager;
import com.pokemon.pokemontest.data.model.Data;
import com.pokemon.pokemontest.data.model.Pokemon;
import com.pokemon.pokemontest.network.RestApiInterface;
import com.pokemon.pokemontest.network.RestApiManager;
import com.pokemon.pokemontest.utils.Constants;
import com.pokemon.pokemontest.view.callbacks.MainCallBack;
import com.pokemon.pokemontest.view.callbacks.PokemonListCallBack;
import com.pokemon.pokemontest.view.ui.AVProgressDialog;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class PokemonListViewModel extends BaseViewModel<PokemonListCallBack> {
    private AVProgressDialog mLoadingDialog;



    public void getPokemonData() {

        RestApiInterface restService = RestApiManager.getClient().create(RestApiInterface.class);

        Call<Data> call = restService.getAllPokemon();
        call.enqueue(new Callback<Data>() {
            @Override
            public void onResponse(Call<Data> call, Response<Data> response) {

                if (response.code() == 400) {
                    getmCallback().showError("SERVER-ERROR!");
                    return;
                }


                if (response.body() != null) {

                    Constants.pokemonsArrayList = (ArrayList<Pokemon>) response.body().getPokemon();
                    getmCallback().populateData(Constants.pokemonsArrayList);
                }

            }

            @Override
            public void onFailure(Call<Data> call, Throwable t) {
                getmCallback().showError(t.getMessage());
            }
        });
    }


    private void showDialog(Context context) {
        mLoadingDialog = new AVProgressDialog(context);
        mLoadingDialog.show();
    }

    private void dismissDialog() {
        if (mLoadingDialog != null && mLoadingDialog.isShowing())
            mLoadingDialog.dismiss();
    }

}
