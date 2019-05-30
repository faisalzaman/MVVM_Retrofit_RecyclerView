package com.pokemon.pokemontest.utils;

import android.util.Log;

public class Logger {

    private static final String TAG_APP_INFO = "App_Info";
    private static final String TAG_APP_ERROR = "App_Errors";
    private static final String TAG_APP_DEBUG = "App_debug";

    private Logger() {
    }

    public static void info(String msg) {
        Log.i(TAG_APP_INFO, msg);
    }

    public static void debug(String msg) {
        Log.d(TAG_APP_DEBUG, msg);
    }

    public static void error(String msg) {
        Log.e(TAG_APP_ERROR, msg);
    }

    public static void info(String tag, String msg) {
        Log.i(tag, msg);
    }

    public static void debug(String tag, String msg) {
        Log.d(tag, msg);
    }

    public static void error(String tag, String msg) {
        Log.e(tag, msg);
    }

}
