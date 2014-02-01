package net.osube.server;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.Arrays;

/**
 * Created by: Sakisan (sakileon101 at gmail dot com)
 * Date: 30 Jan 2014
 */

public class User {

    static class Deserializer implements JsonDeserializer<User> {
        @Override
        public User deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
            JsonObject jsonObject = jsonElement.getAsJsonObject();
            User user = new User();
            user.user_id = jsonObject.get("user_id").getAsString();
            user.username = jsonObject.get("username").getAsString();
            user.count300 = jsonObject.get("count300").getAsString();
            user.count100 = jsonObject.get("count100").getAsString();
            user.count50 = jsonObject.get("count50").getAsString();
            user.playcount = jsonObject.get("playcount").getAsString();
            user.ranked_score = jsonObject.get("ranked_score").getAsString();
            user.total_score = jsonObject.get("total_score").getAsString();
            user.pp_rank = jsonObject.get("pp_rank").getAsString();
            user.level = jsonObject.get("level").getAsString();
            user.pp_raw = jsonObject.get("pp_raw").getAsString();
            user.accuracy = jsonObject.get("accuracy").getAsString();
            user.count_rank_ss = jsonObject.get("count_rank_ss").getAsString();
            user.count_rank_s = jsonObject.get("count_rank_s").getAsString();
            user.count_rank_a = jsonObject.get("count_rank_a").getAsString();
            user.country = jsonObject.get("country").getAsString();

            user.events = jsonDeserializationContext.deserialize(jsonObject.get("events"), Event[].class);
            for (Event event : user.events) {
                event.setUser(user);
            }
            return user;
        }
    }

    // http://www.javacreed.com/gson-deserialiser-example/

    private String user_id;
    private String username;
    private String count300;
    private String count100;
    private String count50;
    private String playcount;
    private String ranked_score;
    private String total_score;
    private String pp_rank;
    private String level;
    private String pp_raw;
    private String accuracy;
    private String count_rank_ss;
    private String count_rank_s;
    private String count_rank_a;
    private String country;
    private Event[] events;

    public String getCount_rank_a() {
        return count_rank_a;
    }

    public void setCount_rank_a(String count_rank_a) {
        this.count_rank_a = count_rank_a;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCount300() {
        return count300;
    }

    public void setCount300(String count300) {
        this.count300 = count300;
    }

    public String getCount100() {
        return count100;
    }

    public void setCount100(String count100) {
        this.count100 = count100;
    }

    public String getCount50() {
        return count50;
    }

    public void setCount50(String count50) {
        this.count50 = count50;
    }

    public String getPlaycount() {
        return playcount;
    }

    public void setPlaycount(String playcount) {
        this.playcount = playcount;
    }

    public String getRanked_score() {
        return ranked_score;
    }

    public void setRanked_score(String ranked_score) {
        this.ranked_score = ranked_score;
    }

    public String getTotal_score() {
        return total_score;
    }

    public void setTotal_score(String total_score) {
        this.total_score = total_score;
    }

    public String getPp_rank() {
        return pp_rank;
    }

    public void setPp_rank(String pp_rank) {
        this.pp_rank = pp_rank;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getPp_raw() {
        return pp_raw;
    }

    public void setPp_raw(String pp_raw) {
        this.pp_raw = pp_raw;
    }

    public String getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(String accuracy) {
        this.accuracy = accuracy;
    }

    public String getCount_rank_ss() {
        return count_rank_ss;
    }

    public void setCount_rank_ss(String count_rank_ss) {
        this.count_rank_ss = count_rank_ss;
    }

    public String getCount_rank_s() {
        return count_rank_s;
    }

    public void setCount_rank_s(String count_rank_s) {
        this.count_rank_s = count_rank_s;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Event[] getEvents() {
        return events;
    }

    public void setEvents(Event[] events) {
        this.events = events;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id='" + user_id + '\'' +
                ", username='" + username + '\'' +
                ", count300='" + count300 + '\'' +
                ", count100='" + count100 + '\'' +
                ", count50='" + count50 + '\'' +
                ", playcount='" + playcount + '\'' +
                ", ranked_score='" + ranked_score + '\'' +
                ", total_score='" + total_score + '\'' +
                ", pp_rank='" + pp_rank + '\'' +
                ", level='" + level + '\'' +
                ", pp_raw='" + pp_raw + '\'' +
                ", accuracy='" + accuracy + '\'' +
                ", count_rank_ss='" + count_rank_ss + '\'' +
                ", count_rank_s='" + count_rank_s + '\'' +
                ", count_rank_a='" + count_rank_a + '\'' +
                ", country='" + country + '\'' +
                ", events=" + Arrays.toString(events) +
                '}';
    }
}
