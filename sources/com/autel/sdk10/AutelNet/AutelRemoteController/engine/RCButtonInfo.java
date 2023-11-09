package com.autel.sdk10.AutelNet.AutelRemoteController.engine;

import com.autel.common.remotecontroller.RemoteControllerNavigateButtonEvent;

public class RCButtonInfo {
    private static final String ACTION_01 = "01";
    private static final String ACTION_02 = "02";
    private static final String ACTION_03 = "03";
    private static final String ACTION_04 = "04";
    private static final String ACTION_05 = "05";
    private static final String ACTION_FF = "ff";

    public RemoteControllerNavigateButtonEvent parseMessage(String str) {
        String[] split = str.split(" ");
        if (split.length > 8) {
            String str2 = split[7];
            if (ACTION_01.equals(str2)) {
                if (ACTION_FF.equals(split[9])) {
                    return RemoteControllerNavigateButtonEvent.CUSTOM_WHEEL_LEFT_SLIDE;
                }
                return RemoteControllerNavigateButtonEvent.CUSTOM_WHEEL_RIGHT_SLIDE;
            } else if (ACTION_02.equals(str2)) {
                return RemoteControllerNavigateButtonEvent.CUSTOM_BUTTON_CLICK;
            } else {
                if (ACTION_03.equals(str2)) {
                    return RemoteControllerNavigateButtonEvent.CUSTOM_WHEEL_CLICK;
                }
                if (ACTION_05.equals(str2)) {
                    return RemoteControllerNavigateButtonEvent.START_VIDEO;
                }
                if (ACTION_04.equals(str2)) {
                    return RemoteControllerNavigateButtonEvent.TAKEN_PHOTO;
                }
            }
        }
        return RemoteControllerNavigateButtonEvent.UNKNOWN;
    }
}
