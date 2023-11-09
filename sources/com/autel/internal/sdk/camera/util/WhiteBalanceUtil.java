package com.autel.internal.sdk.camera.util;

import com.autel.common.camera.media.WhiteBalance;
import com.autel.common.camera.media.WhiteBalanceType;

public class WhiteBalanceUtil {
    public static boolean isValide(WhiteBalance whiteBalance) {
        return WhiteBalanceType.CUSTOM != whiteBalance.type || (whiteBalance.colorTemperature >= 2000 && whiteBalance.colorTemperature <= 10000);
    }
}
