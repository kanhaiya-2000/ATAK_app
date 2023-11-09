package com.autel.sdk10.AutelNet.AutelGimbal;

import com.autel.internal.sdk.gimbal.AutelGimbalInfo;
import com.autel.sdk10.AutelNet.AutelGimbal.parser.GimbalInfoParser;
import com.autel.sdk10.AutelNet.AutelGimbal.requestmanager.AutelGimbalRequestManager;

public final class GimbalManager {
    private static AutelGimbalRequestManager manager;

    private GimbalManager() {
    }

    public static AutelGimbalRequestManager getAutelGimbalRequestManager() {
        if (manager == null) {
            manager = new AutelGimbalRequestManager();
        }
        return manager;
    }

    public static AutelGimbalInfo getAutelGimbalInfo() {
        return GimbalInfoParser.getInstance_();
    }

    public static GimbalInfoParser getAutelGimbalInfoParser() {
        return GimbalInfoParser.getInstance_();
    }
}
