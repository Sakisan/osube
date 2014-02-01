package net.osube.server;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.commons.io.IOUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by: Sakisan (sakileon101 at gmail dot com)
 * Date: 30 Jan 2014
 */
public class RestApi {

    private final String base_url = "https://osu.ppy.sh/api/";
    private final String key;

    public RestApi(String key) {
        this.key = key;
    }

    private String getResponseText(String page, Map<String, String> parameters) {

        String query = "?";
        for (String key : parameters.keySet()) {
            query += key + "=" + parameters.get(key) + "&";
        }
        query = query.substring(0, query.length() - 1);
        String full_request = base_url + page + query;

        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpget = new HttpGet(full_request);

        String response_text = null;
        try {
            CloseableHttpResponse response = httpclient.execute(httpget);
            InputStream inputStream = response.getEntity().getContent();
            StringWriter writer = new StringWriter();
            IOUtils.copy(inputStream, writer, "UTF-8");
            response_text = writer.toString();
            response.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response_text;

    }

    private String removeListBracket(String response_text) {
        if (response_text.charAt(0) == '[') {
            response_text = response_text.substring(1);
        }
        if (response_text.charAt(response_text.length()-1) == ']') {
            response_text = response_text.substring(0,response_text.length()-1);
        }
        return response_text;
    }

    public User getUser(String user_name, Mode mode) {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("k", key);
        map.put("u", user_name);
        map.put("type", "string");
        map.put("m", mode.getMode());
        String json_response = removeListBracket(getResponseText("get_user", map));

        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(User.class, new User.Deserializer());
        Gson gson = gsonBuilder.create();

        User user = null;

        // The JSON data
        // http://docs.oracle.com/javase/tutorial/essential/exceptions/tryResourceClose.html
        try (Reader reader = new InputStreamReader(new ByteArrayInputStream(json_response.getBytes("UTF-8")), "UTF-8")) {
            // Parse JSON to Java
            user = gson.fromJson(reader, User.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return user;
    }

    public User getUser(String user) {
        return getUser(user, Mode.STANDARD);
    }
}
