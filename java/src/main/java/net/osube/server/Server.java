package net.osube.server;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

/**
 * Created by: Antoine Snyers (antoine at atmire dot com)
 * Date: 28 Jan 2014
 */
public class Server {

    public static void main(String[] args) {

        String key = args[0];
        RestApi api = new RestApi(key);
        System.out.println(api.getUser("Sakisan"));

    }
}
