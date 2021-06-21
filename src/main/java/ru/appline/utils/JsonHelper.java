package ru.appline.utils;

import org.json.simple.JSONObject;

public class JsonHelper extends JSONObject {

    private static JsonHelper helper = new JsonHelper();

    private JsonHelper() {

    }

    public static JsonHelper getHelper() {
        return helper;
    }

    public JsonHelper getSideWorld(String message) {
        helper.put("Side", message);
        return helper;
    }
}
