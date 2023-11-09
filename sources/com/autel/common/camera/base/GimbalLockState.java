package com.autel.common.camera.base;

public enum GimbalLockState {
    LOCK(1),
    UNLOCK(0);
    
    private int value;

    private GimbalLockState(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }

    public static GimbalLockState find(int i) {
        GimbalLockState gimbalLockState = LOCK;
        if (gimbalLockState.value == i) {
            return gimbalLockState;
        }
        return UNLOCK;
    }
}
