package net.osube.view;

import net.osube.model.Event;
import net.osube.server.Server;

import java.io.*;
import java.util.*;

/**
 * Created by: Sakisan (sakileon101 at gmail dot com)
 * Date: 01 Feb 2014
 */
public class HtmlView {

    public void render(Set<Event> events) {

        Set<Event> sorted_events = new TreeSet<>(new Comparator<Event>() {
            @Override
            public int compare(Event e1, Event e2) {
                // order by date DESC
                return -e1.getDate().compareTo(e2.getDate());
            }
        });
        sorted_events.addAll(events);

        StringBuilder html = new StringBuilder();
        Iterator<Event> iterator = sorted_events.iterator();
        while (iterator.hasNext()) {
            Event event = iterator.next();

            html.append("<div>");
            html.append(event.getDisplay_html());
            html.append("</div>");
        }
        try {
            String dir_path = Server.HARP_DIR + File.separator + "public" + File.separator + "_events";
            String file_path = dir_path + File.separator + "events.jade";
            File file = new File(file_path);
            file.createNewFile();
            try (OutputStream stream = new FileOutputStream(file)) {
                stream.write(html.toString().getBytes());
                stream.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}