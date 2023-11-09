package com.autel.common.remotecontroller;

public enum RemoteControllerPairState {
    Pairing(0),
    Not_Pairing(1),
    UNKNOWN(-1);
    
    private int value;

    public int getValue() {
        return this.value;
    }

    private RemoteControllerPairState(int i) {
        this.value = i;
    }

    public static RemoteControllerPairState find(int i) {
        RemoteControllerPairState remoteControllerPairState = Pairing;
        if (i == remoteControllerPairState.getValue()) {
            return remoteControllerPairState;
        }
        RemoteControllerPairState remoteControllerPairState2 = Not_Pairing;
        if (i == remoteControllerPairState2.getValue()) {
            return remoteControllerPairState2;
        }
        return UNKNOWN;
    }
}
