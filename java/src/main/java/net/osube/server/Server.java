package net.osube.server;

/**
 * Created by: Sakisan (sakileon101 at gmail dot com)
 * Date: 28 Jan 2014
 */
public class Server {

    public static void main(String[] args) {

        String key = args[0];
        RestApi api = new RestApi(key);
        System.out.println(api.getUser("Sakisan"));

    }
}
