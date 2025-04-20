package com.example.assignment1;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SharedPrefManager {
    private static final String PREF_NAME = "CartPref";
    private static final String CART_KEY = "cart_items";

    public static void saveCart(Context context, List<Item> items) {
        SharedPreferences pref = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();

        List<String> serialized = new ArrayList<>();
        for (Item item : items) {
            serialized.add(item.getName() + ":" + item.getPrice());
        }

        editor.putString(CART_KEY, String.join(",", serialized));
        editor.apply();
    }

    public static List<Item> loadCart(Context context) {
        List<Item> items = new ArrayList<>();
        SharedPreferences pref = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        String saved = pref.getString(CART_KEY, "");

        if (!saved.isEmpty()) {
            List<String> serialized = Arrays.asList(saved.split(","));
            for (String s : serialized) {
                String[] parts = s.split(":");
                if (parts.length == 2) {
                    items.add(new Item(parts[0], parts[1]));
                }
            }
        }

        return items;
    }

    public static void clearCart(Context context) {
        context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
                .edit()
                .remove(CART_KEY)
                .apply();
    }
}
