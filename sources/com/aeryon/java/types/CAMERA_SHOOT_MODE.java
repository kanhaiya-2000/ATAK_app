package com.aeryon.java.types;

import java.util.HashMap;
import java.util.Map;

public enum CAMERA_SHOOT_MODE {
    STILL(0),
    VIDEO(1),
    UNKNOWN(2);
    
    private static final Map<Integer, CAMERA_SHOOT_MODE> map = null;
    private int mode;

    static {
        int i;
        map = new HashMap();
        for (CAMERA_SHOOT_MODE camera_shoot_mode : values()) {
            map.put(Integer.valueOf(camera_shoot_mode.toInt()), camera_shoot_mode);
        }
    }

    private CAMERA_SHOOT_MODE(int i) {
        this.mode = i;
    }

    public int toInt() {
        return this.mode;
    }

    public static CAMERA_SHOOT_MODE fromInt(int i) {
        return map.get(Integer.valueOf(i));
    }
}
