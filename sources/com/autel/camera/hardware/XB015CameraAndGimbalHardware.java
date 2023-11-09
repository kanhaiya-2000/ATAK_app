package com.autel.camera.hardware;

import com.autel.common.camera.CameraProduct;
import com.autel.common.camera.base.MediaMode;
import com.autel.common.camera.media.PhotoAspectRatio;
import com.autel.common.camera.media.VideoResolution;
import com.autel.common.camera.media.VideoResolutionAndFps;
import com.autel.internal.sdk.camera.data.model.CameraXB015Data;

public class XB015CameraAndGimbalHardware extends BaseCameraAndGimbalHardware {
    private final float Diagonal_Angle_Photo_Normal = 93.0f;
    private final float Diagonal_Angle_Video_Above4k = 88.66f;
    private final float Diagonal_Angle_Video_Normal = 86.3f;
    private final float Horizontal_Angle_Photo_Normal = 80.7f;
    private final float Horizontal_Angle_Photo_Normal_16_9 = 78.4f;
    private final float Horizontal_Angle_Video_Above4k = 81.67f;
    private final float Horizontal_Angle_Video_Normal = 78.4f;
    private final float VFOV = 49.0f;
    private final float Vertical_Angle_Photo_Normal = 64.0f;
    private final float Vertical_Angle_Photo_Normal_16_9 = 48.4f;
    private final float Vertical_Angle_Video_Above4k = 49.0f;
    private final float Vertical_Angle_Video_Normal = 49.0f;

    /* renamed from: h */
    private final float f8456h = 3.7f;
    private final float pixelSize = 1.55f;

    /* access modifiers changed from: package-private */
    public float getDiagonal_Angle_Photo_Normal() {
        return 93.0f;
    }

    /* access modifiers changed from: package-private */
    public float getDiagonal_Angle_Video_Above4k() {
        return 88.66f;
    }

    /* access modifiers changed from: package-private */
    public float getDiagonal_Angle_Video_Normal() {
        return 86.3f;
    }

    public float getH() {
        return 3.7f;
    }

    /* access modifiers changed from: package-private */
    public float getHorizontal_Angle_Photo_Normal() {
        return 80.7f;
    }

    /* access modifiers changed from: package-private */
    public float getHorizontal_Angle_Photo_Normal_16_9() {
        return 78.4f;
    }

    /* access modifiers changed from: package-private */
    public float getHorizontal_Angle_Video_Above4k() {
        return 81.67f;
    }

    /* access modifiers changed from: package-private */
    public float getHorizontal_Angle_Video_Normal() {
        return 78.4f;
    }

    public float getPixelSize() {
        return 1.55f;
    }

    public float getVerticalFOV() {
        return 49.0f;
    }

    /* access modifiers changed from: package-private */
    public float getVertical_Angle_Photo_Normal() {
        return 64.0f;
    }

    /* access modifiers changed from: package-private */
    public float getVertical_Angle_Photo_Normal_16_9() {
        return 48.4f;
    }

    /* access modifiers changed from: package-private */
    public float getVertical_Angle_Video_Above4k() {
        return 49.0f;
    }

    /* access modifiers changed from: package-private */
    public float getVertical_Angle_Video_Normal() {
        return 49.0f;
    }

    public float getVerticalAngle() {
        MediaMode find = MediaMode.find(CameraXB015Data.instance().getCurrentMode());
        VideoResolutionAndFps videoMainResolutionAndFps = CameraXB015Data.instance().getVideoMainResolutionAndFps();
        VideoResolution videoResolution = videoMainResolutionAndFps == null ? VideoResolution.UNKNOWN : videoMainResolutionAndFps.resolution;
        PhotoAspectRatio find2 = PhotoAspectRatio.find(CameraXB015Data.instance().getPicResolution(), CameraProduct.XB015);
        if (find == MediaMode.UNKNOWN || videoResolution == VideoResolution.UNKNOWN || find2 == PhotoAspectRatio.UNKNOWN) {
            return 0.0f;
        }
        if (find.equals(MediaMode.VIDEO)) {
            if (videoMainResolutionAndFps.resolution.equals(VideoResolution.Resolution_4096x2160)) {
                return getVertical_Angle_Video_Above4k();
            }
            return getVertical_Angle_Video_Normal();
        } else if (PhotoAspectRatio.Aspect_16_9.equals(find2)) {
            return getVertical_Angle_Photo_Normal_16_9();
        } else {
            return getVertical_Angle_Photo_Normal();
        }
    }

    public float getHorizontalAngle() {
        MediaMode find = MediaMode.find(CameraXB015Data.instance().getCurrentMode());
        VideoResolutionAndFps videoMainResolutionAndFps = CameraXB015Data.instance().getVideoMainResolutionAndFps();
        VideoResolution videoResolution = videoMainResolutionAndFps == null ? VideoResolution.UNKNOWN : videoMainResolutionAndFps.resolution;
        PhotoAspectRatio find2 = PhotoAspectRatio.find(CameraXB015Data.instance().getPicResolution(), CameraProduct.XB015);
        if (find == MediaMode.UNKNOWN || videoResolution == VideoResolution.UNKNOWN || find2 == PhotoAspectRatio.UNKNOWN) {
            return 0.0f;
        }
        if (find.equals(MediaMode.VIDEO)) {
            if (videoMainResolutionAndFps.resolution.equals(VideoResolution.Resolution_4096x2160)) {
                return getHorizontal_Angle_Video_Above4k();
            }
            return getHorizontal_Angle_Video_Normal();
        } else if (PhotoAspectRatio.Aspect_16_9.equals(find2)) {
            return getHorizontal_Angle_Photo_Normal_16_9();
        } else {
            return getHorizontal_Angle_Photo_Normal();
        }
    }

    public float getDiagonalAngle() {
        MediaMode find = MediaMode.find(CameraXB015Data.instance().getCurrentMode());
        VideoResolutionAndFps videoMainResolutionAndFps = CameraXB015Data.instance().getVideoMainResolutionAndFps();
        VideoResolution videoResolution = videoMainResolutionAndFps == null ? VideoResolution.UNKNOWN : videoMainResolutionAndFps.resolution;
        PhotoAspectRatio find2 = PhotoAspectRatio.find(CameraXB015Data.instance().getPicResolution(), CameraProduct.XB015);
        if (find == MediaMode.UNKNOWN || videoResolution == VideoResolution.UNKNOWN || find2 == PhotoAspectRatio.UNKNOWN) {
            return 0.0f;
        }
        if (!find.equals(MediaMode.VIDEO)) {
            return getDiagonal_Angle_Photo_Normal();
        }
        if (videoMainResolutionAndFps.resolution.equals(VideoResolution.Resolution_4096x2160)) {
            return getDiagonal_Angle_Video_Above4k();
        }
        return getDiagonal_Angle_Video_Normal();
    }

    public float getValidClickAreaDottedLineHeightRatio() {
        return 20.0f / getVerticalAngle();
    }
}
