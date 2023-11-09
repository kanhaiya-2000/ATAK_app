package com.autel.common.remotecontroller;

public enum RemoteControllerLanguage {
    ENGLISH(0),
    CHINESE(1),
    UNKNOWN(-1);
    
    private int value;

    private RemoteControllerLanguage(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }

    public static RemoteControllerLanguage find(int i) {
        RemoteControllerLanguage remoteControllerLanguage = ENGLISH;
        if (remoteControllerLanguage.getValue() == i) {
            return remoteControllerLanguage;
        }
        RemoteControllerLanguage remoteControllerLanguage2 = CHINESE;
        if (remoteControllerLanguage2.getValue() == i) {
            return remoteControllerLanguage2;
        }
        return null;
    }
}
