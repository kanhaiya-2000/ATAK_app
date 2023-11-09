package com.o3dr.services.android.lib.drone.companion.solo.tlv;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class SoloGoproConstants {
    public static final byte CAPTURE_MODE_BURST = 2;
    public static final byte CAPTURE_MODE_MULTI_SHOT = 4;
    public static final byte CAPTURE_MODE_PHOTO = 1;
    public static final byte CAPTURE_MODE_PLAYBACK = 5;
    public static final byte CAPTURE_MODE_SETUP = 6;
    public static final byte CAPTURE_MODE_TIME_LAPSE = 3;
    public static final byte CAPTURE_MODE_VIDEO = 0;
    public static final byte RECORDING_OFF = 0;
    public static final byte RECORDING_ON = 1;
    public static final int START_RECORDING = 1;
    public static final byte STATUS_ERROR_NO_STORAGE = 4;
    public static final byte STATUS_ERROR_OVER_TEMPERATURE = 3;
    public static final byte STATUS_GOPRO_CONNECTED = 2;
    public static final byte STATUS_INCOMPATIBLE_GOPRO = 1;
    public static final byte STATUS_NO_GOPRO = 0;
    public static final int STOP_RECORDING = 0;
    public static final int TOGGLE_RECORDING = 2;

    @Retention(RetentionPolicy.SOURCE)
    public @interface CaptureMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface GoproStatus {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface RecordCommand {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface RecordingStatus {
    }

    private SoloGoproConstants() {
    }
}
