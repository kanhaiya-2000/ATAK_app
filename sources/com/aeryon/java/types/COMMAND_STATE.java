package com.aeryon.java.types;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public enum COMMAND_STATE {
    None(0),
    Starting(1),
    Active(2),
    ActiveWaiting(3),
    Cancelled(4),
    Complete(5),
    Failed(6),
    Timeout(7),
    AUTH_RELEASE(96),
    AUTH_SUCCESSFUL(97),
    AUTH_FAILED(98),
    NOT_CONNECTED(99),
    UNKNOWN(100);
    
    private static final Map<Integer, COMMAND_STATE> map = null;
    private final int value;

    static {
        int i;
        HashMap hashMap = new HashMap();
        for (COMMAND_STATE command_state : values()) {
            hashMap.put(Integer.valueOf(command_state.getValue()), command_state);
        }
        map = Collections.unmodifiableMap(hashMap);
    }

    private COMMAND_STATE(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }

    public static COMMAND_STATE lookup(int i) {
        COMMAND_STATE command_state = map.get(Integer.valueOf(i));
        return command_state == null ? UNKNOWN : command_state;
    }
}
