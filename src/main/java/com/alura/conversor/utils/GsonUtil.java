package com.alura.conversor.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonUtil {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    public static Gson getGson() {
        return GSON;
    }
}
