package com.autel.common.remotecontroller;

public enum RemoteControllerCommandStickMode {
    USA(0),
    CHINA(1),
    JAPAN(2),
    UNKNOWN(-1);
    
    private int value;

    private RemoteControllerCommandStickMode(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }

    public static RemoteControllerCommandStickMode find(int i) {
        RemoteControllerCommandStickMode remoteControllerCommandStickMode = USA;
        if (remoteControllerCommandStickMode.getValue() == i) {
            return remoteControllerCommandStickMode;
        }
        RemoteControllerCommandStickMode remoteControllerCommandStickMode2 = CHINA;
        if (remoteControllerCommandStickMode2.getValue() == i) {
            return remoteControllerCommandStickMode2;
        }
        RemoteControllerCommandStickMode remoteControllerCommandStickMode3 = JAPAN;
        if (remoteControllerCommandStickMode3.getValue() == i) {
            return remoteControllerCommandStickMode3;
        }
        return UNKNOWN;
    }
}
