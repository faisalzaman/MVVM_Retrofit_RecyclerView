package com.pokemon.pokemontest.view.fragments;


import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.pokemon.pokemontest.R;
import com.pokemon.pokemontest.data.model.Pokemon;
import com.pokemon.pokemontest.utils.Constants;
import com.pokemon.pokemontest.view.adapters.TypeAdapter;
import com.pokemon.pokemontest.view.adapters.WeaknessAdapter;
import com.pokemon.pokemontest.view.callbacks.PokemonDetailCallBack;
import com.pokemon.pokemontest.viewmodel.PokemonDetailViewModel;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class Frg_PokemonDetail extends BaseFragment<PokemonDetailViewModel> implements PokemonDetailCallBack, View.OnClickListener {


    ImageView image;
    TextView name,height,weight;
    Pokemon pokemon;
    RecyclerView rv_type,rv_weakness;

    static Frg_PokemonDetail instance;
    public static Frg_PokemonDetail getInstance() {
        if(instance == null)
            instance = new Frg_PokemonDetail();
        return instance;
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
        return R.layout.fragment_frg__pokemon_detail;
    }

    @Override
    public PokemonDetailViewModel initViewHolder() {
        return new PokemonDetailViewModel();
    }

    @Override
    public void onClick(View view) {

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
    public void initViews() {

        image       = mRootView.findViewById(R.id.image);
        name        = mRootView.findViewById(R.id.name);
        height      = mRootView.findViewById(R.id.height);
        weight      = mRootView.findViewById(R.id.weight);
        rv_type     = mRootView.findViewById(R.id.rv_type);
        rv_weakness = mRootView.findViewById(R.id.rv_weakness);
        initTypeAndWeaknessViews();

        if(getArguments().get("num") == null)

            pokemon = Constants.pokemonsArrayList.get(getArguments().getInt("position"));

        populateData(pokemon);

        }

    private void populateData(Pokemon pokemon) {

        Glide.with(getActivity()).load(pokemon.getImg()).into(image);

        name.setText(pokemon.getName());
        height.setText(pokemon.getHeight());
        weight.setText(pokemon.getWeight());

        TypeAdapter typeAdapter=new TypeAdapter(getActivity(), pokemon.getType());
        rv_type.setAdapter(typeAdapter);

        WeaknessAdapter weaknessAdapter=new WeaknessAdapter(getActivity(), pokemon.getWeaknesses());
        rv_weakness.setAdapter(weaknessAdapter);
    }

    private void initTypeAndWeaknessViews() {

        rv_type.setHasFixedSize(true);
        rv_type.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));

        rv_weakness.setHasFixedSize(true);
        rv_weakness.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));

    }
}
