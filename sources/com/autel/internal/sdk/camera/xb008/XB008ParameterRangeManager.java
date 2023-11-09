package com.autel.internal.sdk.camera.xb008;

import com.autel.common.RangePair;
import com.autel.common.camera.media.CameraISO;
import com.autel.common.camera.media.ExposureMode;
import com.autel.common.camera.media.PhotoAspectRatio;
import com.autel.common.camera.media.PhotoBurstCount;
import com.autel.common.camera.media.PhotoTimelapseInterval;
import com.autel.common.camera.media.ShutterSpeed;
import com.autel.common.camera.media.VideoResolutionAndFps;
import com.autel.common.camera.media.WhiteBalanceType;
import java.util.List;

public interface XB008ParameterRangeManager {
    RangePair<Integer> getAutoFocusMeterNoX();

    RangePair<Integer> getAutoFocusMeterNoY();

    ExposureMode[] getCameraExposureMode();

    CameraISO[] getCameraISO();

    List<ShutterSpeed> getCameraShutterSpeed();

    WhiteBalanceType[] getCameraWhiteBalanceType();

    RangePair<Integer> getColorTemperature();

    RangePair<Integer> getDigitalZoomScale();

    RangePair<Integer> getFocusDistance();

    PhotoAspectRatio[] getPhotoAspectRatio();

    PhotoBurstCount[] getPhotoBurstCount();

    RangePair<Integer> getPhotoStyleContrast();

    RangePair<Integer> getPhotoStyleSaturation();

    RangePair<Integer> getPhotoStyleSharpness();

    List<PhotoTimelapseInterval> getPhotoTimelapseInterval();

    RangePair<Integer> getSpotMeteringAreaNoX();

    RangePair<Integer> getSpotMeteringAreaNoY();

    VideoResolutionAndFps[] getVideoResolutionAndFps();
}
