package net.osube.server;

import net.osube.model.Event;
import net.osube.model.User;
import net.osube.view.HtmlView;

import java.util.*;

/**
 * Created by: Sakisan (sakileon101 at gmail dot com)
 * Date: 28 Jan 2014
 */
public class Server {

    public static final TimeZone TIME_ZONE = TimeZone.getTimeZone("GMT+8:00");
    public static String HARP_DIR;

    public static void main(String[] args) {
        String key = args[0];
        HARP_DIR = args[1];
        RestApi api = new RestApi(key);

        // this list will go to a configuration file soon...
        String[] names = new String[]
                {
                        "DrakRainbow",
                        "GoldenWolf",
                        "KinkehW",
                        "Zetsubou",
                        "LarshMellow",
                        "Ouariasse",
                        "lorenzo50000",
                        "Sakisan",
                        "Yentis",
                        "Smexehh",
                        "cpt starbuck",
                        "DeathGaia",
                        "DenObscure",
                        "killmeebaby",
                        "Mithrane",
                        "Friendzone King",
                        "H e r o",
                        "Nonokeo",
                        "Yee",
                        "N3ON",
                        "walid373",
                        "EternalDream",
                        "evillander"
                };
        Set<User> users = new HashSet<>();
        for (String name : names) {
            users.add(api.getUser(name));
        }

        Set<Event> events = new HashSet<>();

        for (User user : users) {
            Collections.addAll(events, user.getEvents());
        }

        HtmlView htmlView = new HtmlView();
        htmlView.render(events);


    }
}
