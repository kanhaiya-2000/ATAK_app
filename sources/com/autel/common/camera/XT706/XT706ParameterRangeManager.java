package com.autel.common.camera.XT706;

import com.autel.common.camera.media.CameraAperture;
import com.autel.internal.sdk.camera.xb008.XB008ParameterRangeManager;

public interface XT706ParameterRangeManager extends XB008ParameterRangeManager {
    CameraAperture[] getCameraAperture();
}
