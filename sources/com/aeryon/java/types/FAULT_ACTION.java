package com.aeryon.java.types;

import java.util.HashMap;
import java.util.Map;

public enum FAULT_ACTION {
    HOME(0),
    HOVER(1),
    HOME_AND_HOVER(2);
    
    private static final Map<Integer, FAULT_ACTION> map = null;
    private int mode;

    static {
        int i;
        map = new HashMap();
        for (FAULT_ACTION fault_action : values()) {
            map.put(Integer.valueOf(fault_action.toInt()), fault_action);
        }
    }

    private FAULT_ACTION(int i) {
        this.mode = i;
    }

    public int toInt() {
        return this.mode;
    }

    public static FAULT_ACTION fromInt(int i) {
        return map.get(Integer.valueOf(i));
    }
}
