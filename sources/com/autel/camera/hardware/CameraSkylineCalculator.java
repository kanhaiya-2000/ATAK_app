package com.autel.camera.hardware;

import com.autel.common.camera.media.VideoResolution;

public class CameraSkylineCalculator {
    private BaseCameraAndGimbalHardware mBaseCameraAndGimbalHardware;

    public CameraSkylineCalculator(BaseCameraAndGimbalHardware baseCameraAndGimbalHardware) {
        this.mBaseCameraAndGimbalHardware = baseCameraAndGimbalHardware;
    }

    public int getSkylineYInView(VideoResolution videoResolution, int i, int i2) {
        if (videoResolution == null || VideoResolution.UNKNOWN == videoResolution) {
            return 0;
        }
        return (int) (this.mBaseCameraAndGimbalHardware.updateHorizontalLineHeight(Integer.valueOf(videoResolution.value().split("\\*")[1]).intValue(), (float) i) * ((float) i2));
    }

    public int getValidBoundaryDistanceInView(int i) {
        return (int) (this.mBaseCameraAndGimbalHardware.getValidClickAreaDottedLineHeightRatio() * ((float) i));
    }
}
