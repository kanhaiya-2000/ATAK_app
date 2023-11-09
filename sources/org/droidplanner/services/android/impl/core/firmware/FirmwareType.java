package org.droidplanner.services.android.impl.core.firmware;

import com.atakmap.android.uastool.generic.GenericUASItem;

public enum FirmwareType {
    ARDU_PLANE(3, "ArduPlane", "ArduPlane"),
    ARDU_COPTER(3, "ArduCopter2", "ArduCopter"),
    ARDU_ROVER(3, "ArduRover", "ArduRover"),
    ARDU_SOLO(3, "ArduCopter2", "ArduSolo"),
    PX4_NATIVE(12, "", "PX4 Native"),
    GENERIC(0, "", GenericUASItem.DISPLAY_NAME);
    
    private final int family;
    private final String parameterMetadataGroup;
    private final String type;

    private FirmwareType(int i, String str, String str2) {
        this.family = i;
        this.type = str2;
        this.parameterMetadataGroup = str;
    }

    public String getType() {
        return this.type;
    }

    public int getFamily() {
        return this.family;
    }

    public String getParameterMetadataGroup() {
        return this.parameterMetadataGroup;
    }

    public String toString() {
        return this.type;
    }
}
