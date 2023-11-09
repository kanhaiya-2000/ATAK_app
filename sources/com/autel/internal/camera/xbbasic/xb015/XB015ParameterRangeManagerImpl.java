package com.autel.internal.camera.xbbasic.xb015;

import atakplugin.UASTool.C0827sg;
import com.autel.common.RangePair;
import com.autel.common.camera.CameraProduct;
import com.autel.common.camera.base.MediaMode;
import com.autel.common.camera.base.PhotoFormat;
import com.autel.common.camera.media.AntiFlicker;
import com.autel.common.camera.media.CameraAperture;
import com.autel.common.camera.media.CameraISO;
import com.autel.common.camera.media.ExposureMode;
import com.autel.common.camera.media.PhotoAspectRatio;
import com.autel.common.camera.media.PhotoBurstCount;
import com.autel.common.camera.media.PhotoTimelapseInterval;
import com.autel.common.camera.media.ShutterSpeed;
import com.autel.common.camera.media.VideoFps;
import com.autel.common.camera.media.VideoResolutionAndFps;
import com.autel.common.camera.media.VideoStandard;
import com.autel.common.camera.media.WhiteBalanceType;
import com.autel.common.camera.xb015.XB015ParameterRangeManager;
import com.autel.internal.sdk.camera.data.CameraModelDataManager;
import com.autel.internal.sdk.camera.data.model.CameraXB015Data;
import com.autel.internal.sdk.camera.util.ResolutionFpsSupportUtil;
import java.util.ArrayList;
import java.util.List;

public class XB015ParameterRangeManagerImpl implements XB015ParameterRangeManager {
    private RangePair<Integer> autoFocusMeterNoX = new RangePair<Integer>() {
        public Integer getValueFrom() {
            return 1;
        }

        public Integer getValueTo() {
            return 100;
        }
    };
    private RangePair<Integer> autoFocusMeterNoY = new RangePair<Integer>() {
        public Integer getValueFrom() {
            return 1;
        }

        public Integer getValueTo() {
            return 100;
        }
    };
    private RangePair<Integer> colorTemperature = new RangePair<Integer>() {
        public Integer getValueFrom() {
            return 2000;
        }

        public Integer getValueTo() {
            return Integer.valueOf(C0827sg.f6324a);
        }
    };
    private RangePair<Integer> digitalZoomScale = new RangePair<Integer>() {
        public Integer getValueFrom() {
            return 100;
        }

        public Integer getValueTo() {
            return 800;
        }
    };
    private RangePair<Integer> meteringRangePairNoX = new RangePair<Integer>() {
        public Integer getValueFrom() {
            return 1;
        }

        public Integer getValueTo() {
            return 23;
        }
    };
    private RangePair<Integer> meteringRangePairNoY = new RangePair<Integer>() {
        public Integer getValueFrom() {
            return 1;
        }

        public Integer getValueTo() {
            return 15;
        }
    };
    private RangePair<Integer> objectDistance = new RangePair<Integer>() {
        public Integer getValueFrom() {
            return 100;
        }

        public Integer getValueTo() {
            return Integer.valueOf(C0827sg.f6324a);
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

    public RangePair<Integer> getSpotMeteringAreaX() {
        return this.meteringRangePairNoX;
    }

    public RangePair<Integer> getSpotMeteringAreaY() {
        return this.meteringRangePairNoY;
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

    public RangePair<Integer> getFocusDistance() {
        return this.objectDistance;
    }

    public RangePair<Integer> getAutoFocusMeterX() {
        return this.autoFocusMeterNoX;
    }

    public RangePair<Integer> getAutoFocusMeterY() {
        return this.autoFocusMeterNoY;
    }

    public RangePair<Integer> getColorTemperature() {
        return this.colorTemperature;
    }

    public AntiFlicker[] getAntiFlicker() {
        if (MediaMode.VIDEO != getMediaMode() || CameraXB015Data.instance().getVideoMainResolutionAndFps().fps.fps() <= 100) {
            return new AntiFlicker[]{AntiFlicker.ANTI_FLICKER_60HZ, AntiFlicker.ANTI_FLICKER_50HZ, AntiFlicker.AUTO};
        }
        return new AntiFlicker[]{AntiFlicker.ANTI_FLICKER_60HZ};
    }

    public CameraAperture[] getCameraAperture() {
        return new CameraAperture[]{CameraAperture.Aperture_1p8, CameraAperture.Aperture_2p0, CameraAperture.Aperture_2p2, CameraAperture.Aperture_2p5, CameraAperture.Aperture_2p8, CameraAperture.Aperture_3p2, CameraAperture.Aperture_3p6, CameraAperture.Aperture_4p0, CameraAperture.Aperture_4p5, CameraAperture.Aperture_5p1, CameraAperture.Aperture_5p6, CameraAperture.Aperture_5p7, CameraAperture.Aperture_6p4, CameraAperture.Aperture_7p2, CameraAperture.Aperture_8p0, CameraAperture.Aperture_9p0, CameraAperture.Aperture_10, CameraAperture.Aperture_11};
    }

    public PhotoBurstCount[] getPhotoBurstCount() {
        return new PhotoBurstCount[]{PhotoBurstCount.BURST_3, PhotoBurstCount.BURST_5, PhotoBurstCount.BURST_7, PhotoBurstCount.BURST_10, PhotoBurstCount.BURST_14};
    }

    public CameraISO[] getCameraISO() {
        if (ExposureMode.find(CameraXB015Data.instance().getCameraGear()) == ExposureMode.Manual) {
            return new CameraISO[]{CameraISO.ISO_100, CameraISO.ISO_200, CameraISO.ISO_400, CameraISO.ISO_800, CameraISO.ISO_1600, CameraISO.ISO_3200};
        }
        return new CameraISO[]{CameraISO.ISO_100, CameraISO.ISO_200, CameraISO.ISO_400, CameraISO.ISO_800, CameraISO.ISO_1600};
    }

    public VideoResolutionAndFps[] getVideoResolutionAndFps() {
        VideoStandard find = VideoStandard.find(CameraXB015Data.instance().getVideoStandard());
        if (find != null) {
            if (VideoStandard.NTSC == find) {
                return ResolutionFpsSupportUtil.NTSCSupport(CameraProduct.XB015);
            }
            if (VideoStandard.PAL == find) {
                return ResolutionFpsSupportUtil.PALSupport(CameraProduct.XB015);
            }
        }
        return new VideoResolutionAndFps[0];
    }

    public PhotoAspectRatio[] getPhotoAspectRatio() {
        return new PhotoAspectRatio[]{PhotoAspectRatio.Aspect_4_3, PhotoAspectRatio.Aspect_16_9};
    }

    public WhiteBalanceType[] getCameraWhiteBalanceType() {
        return new WhiteBalanceType[]{WhiteBalanceType.AUTO, WhiteBalanceType.CLOUDY, WhiteBalanceType.FLUOROMETER, WhiteBalanceType.INCANDESCENT, WhiteBalanceType.SUNNY, WhiteBalanceType.CUSTOM};
    }

    public ExposureMode[] getCameraExposureMode() {
        return new ExposureMode[]{ExposureMode.Auto, ExposureMode.Manual};
    }

    public List<ShutterSpeed> getCameraShutterSpeed() {
        ArrayList arrayList = new ArrayList();
        MediaMode mediaMode = getMediaMode();
        VideoResolutionAndFps videoMainResolutionAndFps = CameraXB015Data.instance().getVideoMainResolutionAndFps();
        if (videoMainResolutionAndFps == null) {
            return arrayList;
        }
        VideoFps videoFps = videoMainResolutionAndFps.fps;
        if (mediaMode != MediaMode.VIDEO) {
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

    public List<PhotoTimelapseInterval> getPhotoTimelapseInterval() {
        ArrayList arrayList = new ArrayList();
        PhotoFormat find = PhotoFormat.find(CameraXB015Data.instance().getPicType());
        if (ExposureMode.find(CameraXB015Data.instance().getCameraGear()) == ExposureMode.Manual) {
            float frequency = ShutterSpeed.find(CameraXB015Data.instance().getShutter()).getFrequency();
            float f = 0.0f;
            int i = C314911.$SwitchMap$com$autel$common$camera$base$PhotoFormat[find.ordinal()];
            if (i == 1) {
                f = 1.5f;
            } else if (i == 2) {
                f = 2.0f;
            } else if (i == 3) {
                f = 3.0f;
            }
            for (PhotoTimelapseInterval photoTimelapseInterval : PhotoTimelapseInterval.values()) {
                if (photoTimelapseInterval != PhotoTimelapseInterval.UNKNOWN && (Float.valueOf(photoTimelapseInterval.value20()).floatValue() * frequency) - (f * frequency) >= 1.0f) {
                    arrayList.add(photoTimelapseInterval);
                }
            }
            return arrayList;
        } else if (find == PhotoFormat.RAW || find == PhotoFormat.RawAndJPEG) {
            arrayList.add(PhotoTimelapseInterval.SECOND_5);
            arrayList.add(PhotoTimelapseInterval.SECOND_7);
            arrayList.add(PhotoTimelapseInterval.SECOND_10);
            arrayList.add(PhotoTimelapseInterval.SECOND_20);
            arrayList.add(PhotoTimelapseInterval.SECOND_30);
            arrayList.add(PhotoTimelapseInterval.SECOND_60);
            return arrayList;
        } else {
            arrayList.add(PhotoTimelapseInterval.SECOND_2);
            arrayList.add(PhotoTimelapseInterval.SECOND_5);
            arrayList.add(PhotoTimelapseInterval.SECOND_7);
            arrayList.add(PhotoTimelapseInterval.SECOND_10);
            arrayList.add(PhotoTimelapseInterval.SECOND_20);
            arrayList.add(PhotoTimelapseInterval.SECOND_30);
            arrayList.add(PhotoTimelapseInterval.SECOND_60);
            return arrayList;
        }
    }

    /* renamed from: com.autel.internal.camera.xbbasic.xb015.XB015ParameterRangeManagerImpl$11 */
    /* synthetic */ class C314911 {
        static final /* synthetic */ int[] $SwitchMap$com$autel$common$camera$base$PhotoFormat;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.autel.common.camera.base.PhotoFormat[] r0 = com.autel.common.camera.base.PhotoFormat.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$autel$common$camera$base$PhotoFormat = r0
                com.autel.common.camera.base.PhotoFormat r1 = com.autel.common.camera.base.PhotoFormat.JPEG     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$autel$common$camera$base$PhotoFormat     // Catch:{ NoSuchFieldError -> 0x001d }
                com.autel.common.camera.base.PhotoFormat r1 = com.autel.common.camera.base.PhotoFormat.RAW     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$autel$common$camera$base$PhotoFormat     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.autel.common.camera.base.PhotoFormat r1 = com.autel.common.camera.base.PhotoFormat.RawAndJPEG     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.autel.internal.camera.xbbasic.xb015.XB015ParameterRangeManagerImpl.C314911.<clinit>():void");
        }
    }

    private float compare(PhotoTimelapseInterval photoTimelapseInterval, float f) {
        if (photoTimelapseInterval == PhotoTimelapseInterval.UNKNOWN) {
            return -1.0f;
        }
        return ((float) Integer.valueOf(photoTimelapseInterval.value20()).intValue()) - f;
    }

    private MediaMode getMediaMode() {
        return MediaMode.find(CameraModelDataManager.instance().getBaseCameraData().getCurrentMode());
    }
}
