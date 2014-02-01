package net.osube.view;

import net.osube.model.Event;
import net.osube.server.Server;
import org.apache.commons.lang3.StringUtils;

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

            html.append("<div class='");
            html.append(classes(event));
            html.append("'>");
            html.append(displayHtml(event));
            html.append("<span class='date'>");
            html.append(event.getDate().toString());
            html.append("</span>");
            html.append("</div>");
        }
        try {
            String dir_path = Server.HARP_DIR + File.separator + "public" + File.separator + "_events";
            String file_path = dir_path + File.separator + "events.jade";
            File file = new File(file_path);
            if (file.exists()) {
                file.delete();
            }
            file.createNewFile();
            try (OutputStream stream = new FileOutputStream(file)) {
                stream.write(html.toString().getBytes());
                stream.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private String classes(Event event) {
        StringBuilder classes = new StringBuilder();
        classes.append("event ");
        classes.append(event.getUser().getUsername());
        classes.append(" epic-factor-");
        classes.append(event.getEpicfactor());

        int i = event.getDisplay_html().indexOf("src/images/") + "src/images/".length();
        int j = event.getDisplay_html().indexOf("_", i);
        String rank = event.getDisplay_html().substring(i, j);

        classes.append(" rank-");
        classes.append(rank);

        return classes.toString().trim();
    }

    private String displayHtml(Event event) {
        String display_html = event.getDisplay_html();
        display_html = StringUtils.replace(display_html, "src='/", "src='http://osu.ppy.sh/");
        display_html = StringUtils.replace(display_html, "href='/", "href='http://osu.ppy.sh/");
        return display_html;
    }
}