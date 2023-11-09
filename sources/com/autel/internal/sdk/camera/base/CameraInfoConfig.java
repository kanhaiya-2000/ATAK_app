package com.autel.internal.sdk.camera.base;

public class CameraInfoConfig {

    public static final class COUNT_LIMIT {
        public static final int DEL_LIMIT = 50;
        public static final int QUERY_LIMIT = 500;
    }

    public static final class DEVICE_TYPE {
        public static final int TYPE_CAMPRO = 1;
        public static final int TYPE_VVID = 100;
    }

    public static final class FILE_TYPE {
        public static final int FILE_TYPE_PHOTO = 30;
        public static final int FILE_TYPE_TEMP = 50;
        public static final int FILE_TYPE_THUMB0 = 10;
        public static final int FILE_TYPE_THUMB1 = 20;
        public static final int FILE_TYPE_VIDEO = 40;
    }

    public static final class USB {

        /* renamed from: IP */
        public static final String f8481IP = "127.0.0.1";
        public static final String PLAY_PORT = "8081";
        public static final String PORT = "8081";
    }
}
