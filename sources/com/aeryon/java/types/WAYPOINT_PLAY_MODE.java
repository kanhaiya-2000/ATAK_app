package com.aeryon.java.types;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public enum WAYPOINT_PLAY_MODE {
    ADK_WAYPOINT_PLAY_MODE_Forward(0),
    ADK_WAYPOINT_PLAY_MODE_ForwardLooping(1),
    ADK_WAYPOINT_PLAY_MODE_Reverse(2),
    ADK_WAYPOINT_PLAY_MODE_ReverseLooping(3),
    ADK_WAYPOINT_PLAY_MODE_Last(4);
    
    private static final Map<Integer, WAYPOINT_PLAY_MODE> map = null;
    private final int value;

    static {
        int i;
        HashMap hashMap = new HashMap();
        for (WAYPOINT_PLAY_MODE waypoint_play_mode : values()) {
            hashMap.put(Integer.valueOf(waypoint_play_mode.getValue()), waypoint_play_mode);
        }
        map = Collections.unmodifiableMap(hashMap);
    }

    private WAYPOINT_PLAY_MODE(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }

    public static WAYPOINT_PLAY_MODE lookup(int i) {
        WAYPOINT_PLAY_MODE waypoint_play_mode = map.get(Integer.valueOf(i));
        return waypoint_play_mode == null ? ADK_WAYPOINT_PLAY_MODE_Forward : waypoint_play_mode;
    }
}
