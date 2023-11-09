package com.aeryon.java.types;

import java.util.HashMap;
import java.util.Map;

public enum LIGHT_MODE {
    OFF(0),
    RED(1),
    GREEN(2),
    NAV(3),
    IR(4);
    
    private static final Map<Integer, LIGHT_MODE> map = null;
    private int mode;

    static {
        int i;
        map = new HashMap();
        for (LIGHT_MODE light_mode : values()) {
            map.put(Integer.valueOf(light_mode.toInt()), light_mode);
        }
    }

    private LIGHT_MODE(int i) {
        this.mode = i;
    }

    public int toInt() {
        return this.mode;
    }

    public static LIGHT_MODE fromInt(int i) {
        return map.get(Integer.valueOf(i));
    }
}
