package com.autel.common.camera.XT701;

import com.autel.common.camera.media.CameraAperture;
import com.autel.internal.sdk.camera.xb008.XB008ParameterRangeManager;

public interface XT701ParameterRangeManager extends XB008ParameterRangeManager {
    CameraAperture[] getCameraAperture();
}
