package com.pokemon.pokemontest.view.fragments;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pokemon.pokemontest.viewmodel.BaseViewModel;


/**
 * Created by faisalza on 6/1/2018.
 */

public abstract class BaseFragment<V extends BaseViewModel> extends Fragment {
    private V mViewModel;
    public View mRootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mViewModel = initViewHolder();

        mRootView = inflater.inflate(getLayout(),
                container, false);
        return mRootView;
    }

    public V getViewModel() {
        return mViewModel;
    }

    public abstract int getLayout();

    public abstract V initViewHolder();
}
