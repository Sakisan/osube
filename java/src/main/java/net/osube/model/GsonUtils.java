package net.osube.model;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

/**
 * Created by: Sakisan (sakileon101 at gmail dot com)
 * Date: 01 Feb 2014
 */
public class GsonUtils {

    public static String getFieldAsString(JsonObject jsonObject, String field) {
        String result = null;
        JsonElement jsonElement = jsonObject.get(field);
        if (!jsonElement.isJsonNull()) {
            result = jsonElement.getAsString();
        }
        return result;
    }

}
