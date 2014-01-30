package net.osube.server;

/**
 * Created by: Antoine Snyers (antoine at atmire dot com)
 * Date: 30 Jan 2014
 */
public enum Mode {

    STANDARD(0),TAIKO(1),CATCH_THE_BEAT(2),MANIA(3);

    private int mode;

    private Mode(int mode) {
        this.mode = mode;
    }

    public int getMode() {
        return mode;
    }
}
