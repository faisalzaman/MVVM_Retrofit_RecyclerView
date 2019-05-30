package com.pokemon.pokemontest.viewmodel;

import androidx.lifecycle.ViewModel;

import com.pokemon.pokemontest.view.callbacks.BaseCallBack;

/**
 * Created by faisalza on 6/4/2018.
 */

public abstract class BaseViewModel<C extends BaseCallBack> extends ViewModel {
    private C mCallback;

    public BaseViewModel() {

    }

    protected C getmCallback() {
        return mCallback;
    }

    public void setCallBack(C callBack) {
        this.mCallback = callBack;
    }


}
