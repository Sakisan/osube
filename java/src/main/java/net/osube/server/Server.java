package net.osube.server;

import java.util.*;

/**
 * Created by: Sakisan (sakileon101 at gmail dot com)
 * Date: 28 Jan 2014
 */
public class Server {

    public static final TimeZone TIME_ZONE = TimeZone.getTimeZone("GMT+8:00");

    public static void main(String[] args) {
        String key = args[0];
        RestApi api = new RestApi(key);

        String[] names = new String[]{"Sakisan", "KinkehW", "LarshMellow"};
        Set<User> users = new HashSet<>();
        for (String name : names) {
            users.add(api.getUser(name));
        }

        Set<Event> events = new TreeSet<>(new Comparator<Event>() {
            @Override
            public int compare(Event e1, Event e2) {
                // order by date DESC
                return - e1.getDate().compareTo(e2.getDate());
            }
        });

        for (User user : users) {
            Collections.addAll(events, user.getEvents());
        }

        Iterator<Event> iterator = events.iterator();
        while (iterator.hasNext()) {
            System.out.println("---");
            Event event = iterator.next();
            System.out.println(event.getDate());
            System.out.println(event.getUser().getUsername());
            System.out.println(event.getDisplay_html());
        }

    }
}
