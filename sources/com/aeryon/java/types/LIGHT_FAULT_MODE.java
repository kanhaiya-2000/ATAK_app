package com.aeryon.java.types;

import java.util.HashMap;
import java.util.Map;

public enum LIGHT_FAULT_MODE {
    Persist(0),
    OFF(1),
    FULL(2);
    
    private static final Map<Integer, LIGHT_FAULT_MODE> map = null;
    private int mode;

    static {
        int i;
        map = new HashMap();
        for (LIGHT_FAULT_MODE light_fault_mode : values()) {
            map.put(Integer.valueOf(light_fault_mode.toInt()), light_fault_mode);
        }
    }

    private LIGHT_FAULT_MODE(int i) {
        this.mode = i;
    }

    public int toInt() {
        return this.mode;
    }

    public static LIGHT_FAULT_MODE fromInt(int i) {
        return map.get(Integer.valueOf(i));
    }
}
