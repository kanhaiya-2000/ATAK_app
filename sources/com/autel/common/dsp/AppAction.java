package com.autel.common.dsp;

public enum AppAction {
    DRAW_START("drawStart"),
    TRACKING_START("trackingStart"),
    ENTER("enter"),
    EXIT("exit"),
    UNKNOWN("UNKNOWN");
    
    private String value;

    private AppAction(String str) {
        this.value = str;
    }

    public String getValue() {
        return this.value;
    }

    public static AppAction find(String str) {
        AppAction appAction = DRAW_START;
        if (appAction.value.equals(str)) {
            return appAction;
        }
        AppAction appAction2 = TRACKING_START;
        if (appAction2.value.equals(str)) {
            return appAction2;
        }
        AppAction appAction3 = ENTER;
        if (appAction3.value.equals(str)) {
            return appAction3;
        }
        AppAction appAction4 = EXIT;
        if (appAction4.value.equals(str)) {
            return appAction4;
        }
        return UNKNOWN;
    }
}
