package net.osube.server;

import com.google.gson.*;

import java.lang.reflect.Type;

/**
 * Created by: Sakisan (sakileon101 at gmail dot com)
 * Date: 01 Feb 2014
 */
public class Event {


    // The Deserializer here is not even necessary.
//    static class Deserializer implements JsonDeserializer<Event> {
//        @Override
//        public Event deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
//            JsonObject jsonObject = jsonElement.getAsJsonObject();
//            Event event = new Event();
//            event.display_html = jsonObject.get("display_html").getAsString();
//            event.beatmap_id = jsonObject.get("beatmap_id").getAsString();
//            event.beatmapset_id = jsonObject.get("beatmapset_id").getAsString();
//            event.date = jsonObject.get("date").getAsString();
//            event.epicfactor = jsonObject.get("epicfactor").getAsString();
//            return event;
//        }
//    }

    private String display_html;
    private String beatmap_id;
    private String beatmapset_id;
    private String date;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getEpicfactor() {
        return epicfactor;
    }

    public void setEpicfactor(String epicfactor) {
        this.epicfactor = epicfactor;
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
