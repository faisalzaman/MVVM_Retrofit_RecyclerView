package com.pokemon.pokemontest.view.fragments;

import android.os.Bundle;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.pokemon.pokemontest.Pokemon;
import com.pokemon.pokemontest.R;
import com.pokemon.pokemontest.view.adapters.PokemonAdapter;
import com.pokemon.pokemontest.view.callbacks.PokemonListCallBack;
import com.pokemon.pokemontest.viewmodel.PokemonListViewModel;

import java.util.ArrayList;
import java.util.List;


public class Frg_PokemonList extends BaseFragment<PokemonListViewModel> implements PokemonListCallBack {

    RecyclerView rv_pokemonlist;
    PokemonAdapter adapter;
    List<com.pokemon.pokemontest.data.model.Pokemon> pokemonList = new ArrayList<>();

    static Frg_PokemonList instance;
    public static Frg_PokemonList getInstance() {
        if(instance == null)
            instance = new Frg_PokemonList();
        return instance;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        getViewModel().setCallBack(this);

        initViews();


        return mRootView;
    }

    @Override
    public int getLayout() {
        return R.layout.fragment_frg__pokemon_list;
    }

    @Override
    public PokemonListViewModel initViewHolder() {
        return new PokemonListViewModel();
    }

    @Override
    public void showError(String msg) {
        Toast.makeText(getActivity(),""+msg,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showSuccess(String msg) {
        Toast.makeText(getActivity(),""+msg,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void populateData(ArrayList<com.pokemon.pokemontest.data.model.Pokemon> pokemon) {

        rv_pokemonlist.setHasFixedSize(true);
        adapter = new PokemonAdapter(getActivity(), pokemon);
        rv_pokemonlist.setAdapter(adapter);
    }

    @Override
    public void initViews() {
        rv_pokemonlist = mRootView.findViewById(R.id.rv_pokemonlist);

        initRecyclerView();

        //Hitting server data from view model
        getViewModel().getPokemonData();
    }

    private void initRecyclerView() {

        GridLayoutManager layoutManager = new GridLayoutManager(Pokemon.getInstance(), 2);
        rv_pokemonlist.setLayoutManager(layoutManager);
        adapter = new PokemonAdapter(getActivity(), pokemonList);

        rv_pokemonlist.setAdapter(adapter);

    }
}
