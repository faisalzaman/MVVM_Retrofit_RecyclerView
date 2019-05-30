package com.pokemon.pokemontest.view.ui;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.pokemon.pokemontest.viewmodel.BaseViewModel;

/**
 * Created by faisalza on 6/4/2018.
 */

public abstract class BaseActivity<VM extends BaseViewModel> extends AppCompatActivity {
    private VM mViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        mViewModel = initViewModel();

    }

    public VM getViewModel() {
        return mViewModel;
    }

    public abstract int getLayout();

    public abstract VM initViewModel();

    public void hideKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager)
                    getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}
