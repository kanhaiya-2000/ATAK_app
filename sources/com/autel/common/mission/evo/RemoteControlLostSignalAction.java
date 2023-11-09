package com.autel.common.mission.evo;

public enum RemoteControlLostSignalAction {
    INVALID(0),
    RETURN_HOME(1),
    CONTINUE(2),
    UNKNOWN(-1);
    
    private int value;

    private RemoteControlLostSignalAction(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }

    public static RemoteControlLostSignalAction find(int i) {
        RemoteControlLostSignalAction remoteControlLostSignalAction = INVALID;
        if (remoteControlLostSignalAction.value == i) {
            return remoteControlLostSignalAction;
        }
        RemoteControlLostSignalAction remoteControlLostSignalAction2 = RETURN_HOME;
        if (remoteControlLostSignalAction2.value == i) {
            return remoteControlLostSignalAction2;
        }
        RemoteControlLostSignalAction remoteControlLostSignalAction3 = CONTINUE;
        if (remoteControlLostSignalAction3.value == i) {
            return remoteControlLostSignalAction3;
        }
        return UNKNOWN;
    }
}
