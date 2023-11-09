package com.autel.common.camera.XT705;

import com.autel.common.camera.media.CameraAperture;
import com.autel.internal.sdk.camera.xb008.XB008ParameterRangeManager;

public interface XT705ParameterRangeManager extends XB008ParameterRangeManager {
    CameraAperture[] getCameraAperture();
}
