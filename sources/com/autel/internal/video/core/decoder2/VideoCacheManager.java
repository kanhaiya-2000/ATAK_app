package com.autel.internal.video.core.decoder2;

import java.util.HashMap;

public class VideoCacheManager {
    private static VideoCacheManager s_instance;
    public HashMap<Long, Long> ptsMap = new HashMap<>();

    private VideoCacheManager() {
    }

    public static VideoCacheManager instance() {
        if (s_instance == null) {
            s_instance = new VideoCacheManager();
        }
        return s_instance;
    }
}
