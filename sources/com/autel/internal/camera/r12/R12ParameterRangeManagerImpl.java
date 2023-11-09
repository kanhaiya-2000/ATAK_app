package com.autel.internal.camera.r12;

import com.autel.common.RangePair;
import com.autel.common.camera.CameraProduct;
import com.autel.common.camera.base.MediaMode;
import com.autel.common.camera.media.CameraISO;
import com.autel.common.camera.media.ExposureMode;
import com.autel.common.camera.media.PhotoAspectRatio;
import com.autel.common.camera.media.PhotoTimelapseInterval;
import com.autel.common.camera.media.ShutterSpeed;
import com.autel.common.camera.media.VideoFps;
import com.autel.common.camera.media.VideoResolutionAndFps;
import com.autel.common.camera.media.VideoStandard;
import com.autel.common.camera.media.WhiteBalanceType;
import com.autel.common.camera.r12.R12ParameterRangeManager;
import com.autel.internal.sdk.camera.base.AutelCameraSettingInternal;
import com.autel.internal.sdk.camera.base.AutelCameraStatusInternal;
import com.autel.internal.sdk.camera.util.ResolutionFpsSupportUtil;
import java.util.ArrayList;
import java.util.List;

public class R12ParameterRangeManagerImpl implements R12ParameterRangeManager {
    private RangePair<Integer> digitalZoomScale = new RangePair<Integer>() {
        public Integer getValueFrom() {
            return 100;
        }

        public Integer getValueTo() {
            return 200;
        }
    };
    private RangePair<Integer> photoStyleContrast = new RangePair<Integer>() {
        public Integer getValueFrom() {
            return -3;
        }

        public Integer getValueTo() {
            return 3;
        }
    };
    private RangePair<Integer> photoStyleSaturation = new RangePair<Integer>() {
        public Integer getValueFrom() {
            return -3;
        }

        public Integer getValueTo() {
            return 3;
        }
    };
    private RangePair<Integer> photoStyleSharpness = new RangePair<Integer>() {
        public Integer getValueFrom() {
            return -3;
        }

        public Integer getValueTo() {
            return 3;
        }
    };
    private RangePair<Integer> rangePairNoX = new RangePair<Integer>() {
        public Integer getValueFrom() {
            return 1;
        }

        public Integer getValueTo() {
            return 5;
        }
    };
    private RangePair<Integer> rangePairNoY = new RangePair<Integer>() {
        public Integer getValueFrom() {
            return 1;
        }

        public Integer getValueTo() {
            return 9;
        }
    };

    public RangePair<Integer> getSpotMeteringAreaX() {
        return this.rangePairNoX;
    }

    public RangePair<Integer> getSpotMeteringAreaY() {
        return this.rangePairNoY;
    }

    public RangePair<Integer> getPhotoStyleContrast() {
        return this.photoStyleContrast;
    }

    public RangePair<Integer> getPhotoStyleSaturation() {
        return this.photoStyleSaturation;
    }

    public RangePair<Integer> getPhotoStyleSharpness() {
        return this.photoStyleSharpness;
    }

    public RangePair<Integer> getDigitalZoomScale() {
        return this.digitalZoomScale;
    }

    public CameraISO[] getCameraISO() {
        return new CameraISO[]{CameraISO.ISO_100, CameraISO.ISO_200, CameraISO.ISO_400, CameraISO.ISO_800, CameraISO.ISO_1600, CameraISO.ISO_3200, CameraISO.ISO_6400};
    }

    public VideoResolutionAndFps[] getVideoResolutionAndFps() {
        VideoStandard videoStandard = AutelCameraSettingInternal.instance().getVideoStandard();
        if (videoStandard != null) {
            if (VideoStandard.NTSC == videoStandard) {
                return ResolutionFpsSupportUtil.NTSCSupport(CameraProduct.R12);
            }
            if (VideoStandard.PAL == videoStandard) {
                return ResolutionFpsSupportUtil.PALSupport(CameraProduct.R12);
            }
        }
        return new VideoResolutionAndFps[0];
    }

    public PhotoAspectRatio[] getPhotoAspectRatio() {
        return new PhotoAspectRatio[]{PhotoAspectRatio.Aspect_4_3, PhotoAspectRatio.Aspect_16_9};
    }

    public WhiteBalanceType[] getCameraWhiteBalanceType() {
        return new WhiteBalanceType[]{WhiteBalanceType.AUTO, WhiteBalanceType.CLOUDY, WhiteBalanceType.FLUOROMETER, WhiteBalanceType.INCANDESCENT, WhiteBalanceType.SUNNY};
    }

    public ExposureMode[] getCameraExposureMode() {
        return new ExposureMode[]{ExposureMode.Auto, ExposureMode.Manual};
    }

    public List<ShutterSpeed> getCameraShutterSpeed() {
        ArrayList arrayList = new ArrayList();
        MediaMode currentMode = AutelCameraStatusInternal.instance().getCurrentMode();
        VideoResolutionAndFps videoResolution = AutelCameraSettingInternal.instance().getVideoResolution();
        if (videoResolution == null) {
            return arrayList;
        }
        VideoFps videoFps = videoResolution.fps;
        if (currentMode != MediaMode.VIDEO) {
            arrayList.add(ShutterSpeed.ShutterSpeed_8);
            arrayList.add(ShutterSpeed.ShutterSpeed_6);
            arrayList.add(ShutterSpeed.ShutterSpeed_5);
            arrayList.add(ShutterSpeed.ShutterSpeed_4);
            arrayList.add(ShutterSpeed.ShutterSpeed_3dot2);
            arrayList.add(ShutterSpeed.ShutterSpeed_3);
            arrayList.add(ShutterSpeed.ShutterSpeed_2dot5);
            arrayList.add(ShutterSpeed.ShutterSpeed_2);
            arrayList.add(ShutterSpeed.ShutterSpeed_1dot6);
            arrayList.add(ShutterSpeed.ShutterSpeed_1dot3);
            arrayList.add(ShutterSpeed.ShutterSpeed_1);
            arrayList.add(ShutterSpeed.ShutterSpeed_1_1dot25);
            arrayList.add(ShutterSpeed.ShutterSpeed_1_1dot67);
            arrayList.add(ShutterSpeed.ShutterSpeed_1_2);
            arrayList.add(ShutterSpeed.ShutterSpeed_1_2dot5);
            arrayList.add(ShutterSpeed.ShutterSpeed_1_3);
            arrayList.add(ShutterSpeed.ShutterSpeed_1_4);
            arrayList.add(ShutterSpeed.ShutterSpeed_1_5);
            arrayList.add(ShutterSpeed.ShutterSpeed_1_6dot25);
            arrayList.add(ShutterSpeed.ShutterSpeed_1_8);
            arrayList.add(ShutterSpeed.ShutterSpeed_1_10);
            arrayList.add(ShutterSpeed.ShutterSpeed_1_12dot5);
            arrayList.add(ShutterSpeed.ShutterSpeed_1_15);
            arrayList.add(ShutterSpeed.ShutterSpeed_1_20);
            arrayList.add(ShutterSpeed.ShutterSpeed_1_25);
            arrayList.add(ShutterSpeed.ShutterSpeed_1_30);
            arrayList.add(ShutterSpeed.ShutterSpeed_1_40);
            arrayList.add(ShutterSpeed.ShutterSpeed_1_50);
            arrayList.add(ShutterSpeed.ShutterSpeed_1_60);
            arrayList.add(ShutterSpeed.ShutterSpeed_1_80);
            arrayList.add(ShutterSpeed.ShutterSpeed_1_100);
            arrayList.add(ShutterSpeed.ShutterSpeed_1_120);
            arrayList.add(ShutterSpeed.ShutterSpeed_1_160);
            arrayList.add(ShutterSpeed.ShutterSpeed_1_200);
            arrayList.add(ShutterSpeed.ShutterSpeed_1_240);
            arrayList.add(ShutterSpeed.ShutterSpeed_1_320);
            arrayList.add(ShutterSpeed.ShutterSpeed_1_400);
            arrayList.add(ShutterSpeed.ShutterSpeed_1_500);
            arrayList.add(ShutterSpeed.ShutterSpeed_1_640);
            arrayList.add(ShutterSpeed.ShutterSpeed_1_800);
            arrayList.add(ShutterSpeed.ShutterSpeed_1_1000);
            arrayList.add(ShutterSpeed.ShutterSpeed_1_1250);
            arrayList.add(ShutterSpeed.ShutterSpeed_1_1600);
            arrayList.add(ShutterSpeed.ShutterSpeed_1_2000);
            arrayList.add(ShutterSpeed.ShutterSpeed_1_2500);
            arrayList.add(ShutterSpeed.ShutterSpeed_1_3200);
            arrayList.add(ShutterSpeed.ShutterSpeed_1_4000);
            arrayList.add(ShutterSpeed.ShutterSpeed_1_5000);
            arrayList.add(ShutterSpeed.ShutterSpeed_1_6000);
            arrayList.add(ShutterSpeed.ShutterSpeed_1_8000);
        } else if (videoFps != null) {
            for (ShutterSpeed shutterSpeed : ShutterSpeed.values()) {
                if (shutterSpeed.getFrequency() >= ((float) videoFps.fps())) {
                    arrayList.add(shutterSpeed);
                }
            }
        }
        return arrayList;
    }

    public PhotoTimelapseInterval[] getPhotoTimelapseInterval() {
        return new PhotoTimelapseInterval[]{PhotoTimelapseInterval.SECOND_5, PhotoTimelapseInterval.SECOND_7, PhotoTimelapseInterval.SECOND_10, PhotoTimelapseInterval.SECOND_20, PhotoTimelapseInterval.SECOND_30};
    }
}
