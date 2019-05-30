package com.pokemon.pokemontest;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

public class Pokemon extends Application {

    private static Pokemon instance;

//    public SharedPreferences getPrefs() {
//        return prefs;
//    }

//    private SharedPreferences prefs;

    public static Pokemon getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();


        instance = this;

//        prefs = getSharedPreferences(SessionManager.PREF_NAME, Context.MODE_PRIVATE);

    }

}