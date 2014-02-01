package net.osube.model;

/**
 * Created by: Sakisan (sakileon101 at gmail dot com)
 * Date: 30 Jan 2014
 */
public enum Mode {

    STANDARD("0"),TAIKO("1"),CATCH_THE_BEAT("2"),MANIA("3");

    private String mode;

    private Mode(String mode) {
        this.mode = mode;
    }

    public String getMode() {
        return mode;
    }
}
