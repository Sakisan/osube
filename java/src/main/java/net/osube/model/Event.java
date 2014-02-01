package net.osube.model;

import com.google.gson.*;
import net.osube.server.Server;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by: Sakisan (sakileon101 at gmail dot com)
 * Date: 01 Feb 2014
 */
public class Event {

    public static class Deserializer implements JsonDeserializer<Event> {
        @Override
        public Event deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
            JsonObject jsonObject = jsonElement.getAsJsonObject();
            Event event = new Event();
            event.display_html = GsonUtils.getFieldAsString(jsonObject, "display_html");
            event.beatmap_id = GsonUtils.getFieldAsString(jsonObject, "beatmap_id");
            event.beatmapset_id = GsonUtils.getFieldAsString(jsonObject, "beatmapset_id");
            event.epicfactor =  GsonUtils.getFieldAsString(jsonObject, "epicfactor");

            String date_string =  GsonUtils.getFieldAsString(jsonObject, "date");
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            format.setTimeZone(Server.TIME_ZONE);
            try {
                event.date =  format.parse(date_string);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            return event;
        }
    }

    private User user;
    private String display_html;
    private String beatmap_id;
    private String beatmapset_id;
    private Date date;
    private String epicfactor;

    public String getDisplay_html() {
        return display_html;
    }

    public void setDisplay_html(String display_html) {
        this.display_html = display_html;
    }

    public String getBeatmap_id() {
        return beatmap_id;
    }

    public void setBeatmap_id(String beatmap_id) {
        this.beatmap_id = beatmap_id;
    }

    public String getBeatmapset_id() {
        return beatmapset_id;
    }

    public void setBeatmapset_id(String beatmapset_id) {
        this.beatmapset_id = beatmapset_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getEpicfactor() {
        return epicfactor;
    }

    public void setEpicfactor(String epicfactor) {
        this.epicfactor = epicfactor;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Event{" +
                "display_html='" + display_html + '\'' +
                ", beatmap_id='" + beatmap_id + '\'' +
                ", beatmapset_id='" + beatmapset_id + '\'' +
                ", date='" + date + '\'' +
                ", epicfactor='" + epicfactor + '\'' +
                '}';
    }
}
