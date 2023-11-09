package com.autel.common.camera.r12;

import com.autel.common.RangePair;
import com.autel.common.camera.media.CameraISO;
import com.autel.common.camera.media.ExposureMode;
import com.autel.common.camera.media.PhotoAspectRatio;
import com.autel.common.camera.media.PhotoTimelapseInterval;
import com.autel.common.camera.media.ShutterSpeed;
import com.autel.common.camera.media.VideoResolutionAndFps;
import com.autel.common.camera.media.WhiteBalanceType;
import java.util.List;

public interface R12ParameterRangeManager {
    ExposureMode[] getCameraExposureMode();

    CameraISO[] getCameraISO();

    List<ShutterSpeed> getCameraShutterSpeed();

    WhiteBalanceType[] getCameraWhiteBalanceType();

    RangePair<Integer> getDigitalZoomScale();

    PhotoAspectRatio[] getPhotoAspectRatio();

    RangePair<Integer> getPhotoStyleContrast();

    RangePair<Integer> getPhotoStyleSaturation();

    RangePair<Integer> getPhotoStyleSharpness();

    PhotoTimelapseInterval[] getPhotoTimelapseInterval();

    RangePair<Integer> getSpotMeteringAreaX();

    RangePair<Integer> getSpotMeteringAreaY();

    VideoResolutionAndFps[] getVideoResolutionAndFps();
}
