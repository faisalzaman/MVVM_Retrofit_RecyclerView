/*
 *  Copyright (C) 2017 MINDORKS NEXTGEN PRIVATE LIMITED
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      https://mindorks.com/license/apache-v2
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License
 */

package com.pokemon.pokemontest.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import com.google.gson.Gson;
import com.pokemon.pokemontest.Pokemon;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by faisalza on 6/1/2018.
 */

public final class CommonUtils {

    private static Gson gson;

    // Method to get Gson Library to parse JSON
    public static Gson getGson() {
        if (gson == null)
            gson = new Gson();
        return gson;
    }

    private CommonUtils() {
        // This utility class is not publicly instantiable
    }

    public static boolean isNullOrEmpty(String str) {
        if (str == null || str.isEmpty())
            return true;

        return false;
    }

    public static boolean isPWDValid(String pwd) {
        Pattern pattern;
        Matcher matcher;
        final String PWD_PATTERN = "^(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-+]).{6,}$";
        pattern = Pattern.compile(PWD_PATTERN);
        matcher = pattern.matcher(pwd);
        return matcher.matches();
    }

    public static boolean isEmailValid(String email) {
        Pattern pattern;
        Matcher matcher;
        final String EMAIL_PATTERN =
                "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static boolean isValidPhone(String phone) {
        boolean check = false;
        if (!Pattern.matches("[a-zA-Z]+", phone)) {
            if (phone.length() < 11 || phone.length() > 11) {
                check = false;

            } else {
                check = true;

            }
        } else {
            check = false;
        }
        return check;
    }

    /**
     * This method converts dp unit to equivalent pixels, depending on device density.
     *
     * @param dp      A value in dp (density independent pixels) unit. Which we need to convert into pixels
     * @param context Context to get resources and device specific display metrics
     * @return A float value to represent px equivalent to dp depending on device density
     */
    public static float convertDpToPixel(float dp, Context context) {
        return dp * ((float) context.getResources().getDisplayMetrics().densityDpi / DisplayMetrics.DENSITY_DEFAULT);
    }

    /**
     * This method converts device specific pixels to density independent pixels.
     *
     * @param px      A value in px (pixels) unit. Which we need to convert into db
     * @param context Context to get resources and device specific display metrics
     * @return A float value to represent dp equivalent to px value
     */
    public static float convertPixelsToDp(float px, Context context) {
        return px / ((float) context.getResources().getDisplayMetrics().densityDpi / DisplayMetrics.DENSITY_DEFAULT);
    }


    public static boolean isAllSpaces(String str) {
        if (str.trim().length() == 0)
            return true;

        return false;
    }

    public static boolean passwordMatches(String password, String confirmPassword) {
        if (password.equals(confirmPassword))
            return true;
        return false;
    }

    public static boolean passwordLength(String password) {
        if (password.length() < 6 || password.length() > 8) {
            return false;
        }
        return true;
    }

    public static boolean birthdayFormat(String birthday) {
        return (birthday.equals("0 0 0"));
    }


    public static void showToast(final String msg) {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @SuppressLint("WrongConstant")
            public void run() {
                Toast.makeText(Pokemon.getInstance().getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
            }
        });
    }


//    public static void showSnackBarWithDefaultAction(final View view, final String msg) {
//        new Handler(Looper.getMainLooper()).post(new Runnable() {
//            @SuppressLint("WrongConstant")
//            public void run() {
//                Snackbar.make(view, msg, Snackbar.LENGTH_LONG)
////                        .setAction("Action", null)
//                        .show();
//            }
//        });
//    }


    public static String formatDate(String a) {
        String abc = "";
        String strDateTimeBoj = "Oct 11 2014 5:30PM";
        //first you need to use proper date formatter
        DateFormat df = new SimpleDateFormat("dd/mm/yyyy");
        Date date = null;// converting String to date
        try {
            date = df.parse(a);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        abc = df.format(date);
        return abc;
    }


    public static void hideKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        //Find the currently focused view, so we can grab the correct window token from it.
        View view = activity.getCurrentFocus();
        //If no view currently has focus, create a new one, just so we can grab a window token from it
        if (view == null) {
            view = new View(activity);
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }



    /**
     * Converts a string to title casing.
     * @param str
     *      The string to convert.
     * @return
     *      The converted string.
     */
    public static String toTitleCase(String str) {
        if (str == null) {
            return null;
        }
        boolean space = true;
        StringBuilder builder = new StringBuilder(str);
        final int len = builder.length();

        for (int i=0; i < len; ++i) {
            char c = builder.charAt(i);
            if (space) {
                if (!Character.isWhitespace(c)) {
                    // Convert to title case and switch out of whitespace mode.
                    builder.setCharAt(i, Character.toTitleCase(c));
                    space = false;
                }
            } else if (Character.isWhitespace(c)) {
                space = true;
            } else {
                builder.setCharAt(i, Character.toLowerCase(c));
            }
        }

        return builder.toString();
    }

}
