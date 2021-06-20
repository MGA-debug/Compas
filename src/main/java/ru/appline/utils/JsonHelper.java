package ru.appline.utils;

import org.json.simple.JSONObject;

public class JsonHelper extends JSONObject {

    private static JsonHelper helper = new JsonHelper();

    private JsonHelper() {

    }

    public static JsonHelper getHelper() {
        return helper;
    }

    public JsonHelper getResult(String message) {
        helper.remove("Side");
        helper.put("Message", message);
        return helper;
    }
}
