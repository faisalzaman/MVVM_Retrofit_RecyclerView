package com.pokemon.pokemontest.viewmodel;

import android.content.Context;
import android.util.Log;

import com.pokemon.pokemontest.view.callbacks.MainCallBack;
import com.pokemon.pokemontest.view.ui.AVProgressDialog;


public class MainViewModel extends BaseViewModel<MainCallBack> {
    private AVProgressDialog mLoadingDialog;

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
