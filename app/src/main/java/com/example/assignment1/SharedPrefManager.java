package com.example.assignment1;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SharedPrefManager {
    private static final String PREF_NAME = "CartPref";
    private static final String CART_KEY = "cart_items";

    public static void saveCart(Context context, List<String> itemNames) {
        SharedPreferences pref = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(CART_KEY, String.join(",", itemNames));
        editor.apply();
    }

    public static List<String> loadCart(Context context) {
        SharedPreferences pref = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        String saved = pref.getString(CART_KEY, "");
        if (saved.isEmpty()) return new ArrayList<>();
        return new ArrayList<>(Arrays.asList(saved.split(",")));
    }

    public static void clearCart(Context context) {
        context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
                .edit()
                .remove(CART_KEY)
                .apply();
    }
}
