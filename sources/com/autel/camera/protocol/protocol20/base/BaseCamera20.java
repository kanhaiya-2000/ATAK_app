package com.autel.camera.protocol.protocol20.base;

import android.util.Log;
import com.autel.AutelNet2.core.ConnectionManager2;
import com.autel.AutelNet2.core.PacketDisPatcher;
import com.autel.bean.camera.CameraAllSettings;
import com.autel.bean.camera.CameraSystemStatus;
import com.autel.camera.communication.CameraConnection;
import com.autel.camera.communication.http.events.CameraMessageDisPatcher;
import com.autel.camera.protocol.protocol20.CameraManager;
import com.autel.camera.protocol.protocol20.constant.CameraConstant20;
import com.autel.camera.protocol.protocol20.entity.CameraDeviceStatus;
import com.autel.camera.protocol.protocol20.entity.CameraEvents;
import com.autel.camera.protocol.protocol20.entity.CameraParamsConfig;
import com.autel.camera.protocol.protocol20.interfaces.base.BaseCameraService;
import com.autel.camera.protocol.protocol20.request.BaseCameraRequest;
import com.autel.camera.protocol.protocol20.request.RequestManager;
import com.autel.camera.protocol.protocol20.util.TrackingUtils;
import com.autel.common.CallbackWithNoParam;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.CallbackWithTwoParams;
import com.autel.common.camera.CameraProduct;
import com.autel.common.camera.base.CameraPattern;
import com.autel.common.camera.base.MediaMode;
import com.autel.common.camera.base.MediaStatus;
import com.autel.common.camera.base.PhotoFormat;
import com.autel.common.camera.base.SDCardState;
import com.autel.common.camera.base.SettingEvent;
import com.autel.common.camera.media.VideoBitrateType;
import com.autel.common.camera.media.VideoEncodeFormat;
import com.autel.common.camera.media.VideoEncodeType;
import com.autel.common.camera.media.VideoEncoderConfiguration;
import com.autel.common.camera.media.VideoFormat;
import com.autel.common.camera.media.VideoResolutionAndFps;
import com.autel.common.camera.media.VideoStandard;
import com.autel.common.error.AutelError;
import com.autel.internal.AutelListenerManager;
import com.autel.internal.network.interfaces.IConnectionListener;
import com.autel.internal.sdk.album.AlbumMediaItem;
import com.autel.internal.sdk.camera.base.AutelCameraStatusInternal;
import com.autel.internal.sdk.camera.base.AutelSwitchState;
import com.autel.internal.sdk.camera.base.ConnectConnectStatus;
import com.autel.internal.sdk.camera.data.CameraModelDataManager;
import com.autel.internal.sdk.camera.data.base.BaseCameraData;
import com.autel.internal.sdk.camera.data.model.CameraFlirData;
import com.autel.internal.sdk.camera.data.model.CameraXB008Data;
import com.autel.internal.sdk.camera.data.model.CameraXB015Data;
import com.autel.internal.sdk.product.datapost.MsgPostManager;
import com.autel.internal.sdk.product.datapost.PostRunnable;
import com.autel.util.log.AutelLog;
import com.autel.util.okhttp.utils.MessageParser;
import java.util.HashMap;
import java.util.List;

public class BaseCamera20 implements BaseCameraService {
    private static final String TAG = "BaseCamera20";
    /* access modifiers changed from: private */
    public MessageParser messageParser = RequestManager.instance().messageParser;
    /* access modifiers changed from: private */
    public volatile String sdCardStatus = SDCardState.UNKNOWN.getValue08();

    public void addCameraEventsListener(String str, CallbackWithOneParam<CameraEvents> callbackWithOneParam) {
        if (callbackWithOneParam == null) {
            BaseCameraRequest.instance().removeCameraEventsListener(str);
        } else {
            BaseCameraRequest.instance().addCameraEventsListener(str, callbackWithOneParam);
        }
    }

    public void setSettingChangedListener(final CallbackWithOneParam<SettingEvent> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            BaseCameraRequest.instance().addCameraEventsListener(AutelListenerManager.SettingChangedListener, new CallbackWithOneParam<CameraEvents>() {
                public void onFailure(AutelError autelError) {
                    callbackWithOneParam.onFailure(autelError);
                }

                public void onSuccess(CameraEvents cameraEvents) {
                    AutelLog.m15082d("RequestManager", "var1.getType():" + cameraEvents.getType());
                    if (CameraConstant20.SettingChanged.equals(cameraEvents.getType())) {
                        HashMap<String, String> map = cameraEvents.getMap();
                        SettingEvent settingEvent = SettingEvent.UNKNOWN;
                        if (map != null && map.keySet().iterator().hasNext()) {
                            String next = map.keySet().iterator().next();
                            AutelLog.m15082d("RequestManager", "hashMap -> json:" + map.get(next));
                            try {
                                if (map.containsKey(SettingEvent.VideoEncoderConfiguration.name())) {
                                    settingEvent = SettingEvent.VideoEncoderConfiguration;
                                    final CameraAllSettings.VideoEncoderConfiguration videoEncoderConfiguration = (CameraAllSettings.VideoEncoderConfiguration) BaseCamera20.this.messageParser.getObject(map.get(next), CameraAllSettings.VideoEncoderConfiguration.class);
                                    List<VideoEncoderConfiguration> videoEncoderConfiguration2 = CameraXB015Data.instance().getVideoEncoderConfiguration();
                                    videoEncoderConfiguration2.add(0, new VideoEncoderConfiguration() {
                                        public VideoEncodeFormat getEncoding() {
                                            CameraXB015Data.instance().setVideoMainEncoding(videoEncoderConfiguration.getEncoding());
                                            return VideoEncodeFormat.find(videoEncoderConfiguration.getEncoding());
                                        }

                                        public VideoResolutionAndFps getVideoResolutionAndFps() {
                                            CameraXB015Data.instance().setVideoMainResolutionAndFps(VideoResolutionAndFps.create(videoEncoderConfiguration.getResolution()));
                                            return VideoResolutionAndFps.create(videoEncoderConfiguration.getResolution());
                                        }

                                        public int getQuality() {
                                            return videoEncoderConfiguration.getQuality();
                                        }

                                        public int getIntervalOfIFrame() {
                                            return videoEncoderConfiguration.getGovLength();
                                        }

                                        public int getBitrate() {
                                            return videoEncoderConfiguration.getBitrate();
                                        }

                                        public VideoBitrateType getBitrateType() {
                                            return VideoBitrateType.find(videoEncoderConfiguration.getBitrateType());
                                        }

                                        public VideoEncodeType getEncodeType() {
                                            return VideoEncodeType.find(videoEncoderConfiguration.getProfile());
                                        }
                                    });
                                    CameraXB015Data.instance().setVideoMainResolutionAndFps(VideoResolutionAndFps.create(videoEncoderConfiguration.getResolution()));
                                    CameraXB015Data.instance().setVideoEncoderConfiguration(videoEncoderConfiguration2);
                                } else if (map.containsKey(SettingEvent.VideoSourceConfiguration.name())) {
                                    settingEvent = SettingEvent.VideoSourceConfiguration;
                                    CameraAllSettings.VideoSourceConfiguration videoSourceConfiguration = (CameraAllSettings.VideoSourceConfiguration) BaseCamera20.this.messageParser.getObject(map.get(next), CameraAllSettings.VideoSourceConfiguration.class);
                                    CameraXB015Data.instance().setVideoRotation(videoSourceConfiguration.getRotation());
                                    CameraXB015Data.instance().setAntiFlicker(videoSourceConfiguration.getAntiFlicker());
                                    CameraXB015Data.instance().setVideoStandard(videoSourceConfiguration.getVideoStandard());
                                } else if (map.containsKey(SettingEvent.CameraGear.name())) {
                                    settingEvent = SettingEvent.CameraGear;
                                    CameraXB015Data.instance().setCameraGear(((CameraAllSettings.CameraGear) BaseCamera20.this.messageParser.getObject(map.get(next), CameraAllSettings.CameraGear.class)).getGear());
                                } else if (map.containsKey(SettingEvent.CameraMode.name())) {
                                    settingEvent = SettingEvent.CameraMode;
                                    CameraXB015Data.instance().setCameraMode(((CameraAllSettings.CameraMode) BaseCamera20.this.messageParser.getObject(map.get(next), CameraAllSettings.CameraMode.class)).getMode());
                                } else if (map.containsKey(SettingEvent.PhotoTakingSettings.name())) {
                                    settingEvent = SettingEvent.PhotoTakingSettings;
                                    CameraAllSettings.PhotoTakingSettings photoTakingSettings = (CameraAllSettings.PhotoTakingSettings) BaseCamera20.this.messageParser.getObject(map.get(next), CameraAllSettings.PhotoTakingSettings.class);
                                    CameraXB015Data.instance().setPicType(photoTakingSettings.getPicType());
                                    CameraXB015Data.instance().setPicResolution(photoTakingSettings.getResolution());
                                    CameraXB015Data.instance().setBurstNumPerSecond(photoTakingSettings.getBurstModeSettings().getNumPhotosPerSecond());
                                    CameraXB015Data.instance().setTimelapseInterval(photoTakingSettings.getTimelapseModeSettings().getInterval());
                                    CameraXB015Data.instance().setAebNumPerSecond(photoTakingSettings.getAEBModeSettings().getNumPhotosAtOnce());
                                } else if (map.containsKey(SettingEvent.RecordingSettings.name())) {
                                    settingEvent = SettingEvent.RecordingSettings;
                                    CameraAllSettings.RecordingSettings recordingSettings = (CameraAllSettings.RecordingSettings) BaseCamera20.this.messageParser.getObject(map.get(next), CameraAllSettings.RecordingSettings.class);
                                    CameraXB015Data.instance().setVideoFileFormat(recordingSettings.getFileFormat());
                                    CameraXB015Data.instance().setAutoSnapshotInterval(recordingSettings.getAutoSnapshot().getInterval());
                                    CameraXB015Data.instance().setAutoSnapshotEnable(recordingSettings.getAutoSnapshot().getEnable());
                                    CameraXB015Data.instance().setEnableSubtitle(recordingSettings.getEnableSubtitle());
                                } else if (map.containsKey(SettingEvent.LocationMeter.name())) {
                                    settingEvent = SettingEvent.LocationMeter;
                                    CameraAllSettings.LocationMeter locationMeter = (CameraAllSettings.LocationMeter) BaseCamera20.this.messageParser.getObject(map.get(next), CameraAllSettings.LocationMeter.class);
                                    CameraXB015Data.instance().setLocation_X(locationMeter.getX());
                                    CameraXB015Data.instance().setLocation_Y(locationMeter.getY());
                                } else if (map.containsKey(SettingEvent.ImageStyle.name())) {
                                    settingEvent = SettingEvent.ImageStyle;
                                    CameraAllSettings.ImageStyle imageStyle = (CameraAllSettings.ImageStyle) BaseCamera20.this.messageParser.getObject(map.get(next), CameraAllSettings.ImageStyle.class);
                                    CameraXB015Data.instance().setBrightness(imageStyle.getBrightness());
                                    CameraXB015Data.instance().setContrast(imageStyle.getContrast());
                                    CameraXB015Data.instance().setHue(imageStyle.getHue());
                                    CameraXB015Data.instance().setSaturation(imageStyle.getSaturation());
                                    CameraXB015Data.instance().setSharpness(imageStyle.getSharpness());
                                    CameraXB015Data.instance().setStyle(imageStyle.getStyle());
                                } else if (map.containsKey(SettingEvent.WhiteBalance.name())) {
                                    settingEvent = SettingEvent.WhiteBalance;
                                    CameraAllSettings.WhiteBalance whiteBalance = (CameraAllSettings.WhiteBalance) BaseCamera20.this.messageParser.getObject(map.get(next), CameraAllSettings.WhiteBalance.class);
                                    CameraXB015Data.instance().setWBColorTemperature(whiteBalance.getColorTemperature());
                                    CameraXB015Data.instance().setWhiteBalanceMode(whiteBalance.getMode());
                                } else if (map.containsKey(SettingEvent.ImageColor.name())) {
                                    settingEvent = SettingEvent.ImageColor;
                                    CameraXB015Data.instance().setImageColor(((CameraAllSettings.ImageColor) BaseCamera20.this.messageParser.getObject(map.get(next), CameraAllSettings.ImageColor.class)).getColor());
                                } else if (map.containsKey(SettingEvent.ImageExposure.name())) {
                                    settingEvent = SettingEvent.ImageExposure;
                                    CameraXB015Data.instance().setImageExposure(((CameraAllSettings.ImageExposure) BaseCamera20.this.messageParser.getObject(map.get(next), CameraAllSettings.ImageExposure.class)).getExposure());
                                } else if (map.containsKey(SettingEvent.ImageISO.name())) {
                                    settingEvent = SettingEvent.ImageISO;
                                    CameraXB015Data.instance().setImageISO(((CameraAllSettings.ImageISO) BaseCamera20.this.messageParser.getObject(map.get(next), CameraAllSettings.ImageISO.class)).getISO());
                                } else if (map.containsKey(SettingEvent.AELock.name())) {
                                    settingEvent = SettingEvent.AELock;
                                    CameraXB015Data.instance().setAeLocked(((CameraAllSettings.AELock) BaseCamera20.this.messageParser.getObject(map.get(next), CameraAllSettings.AELock.class)).getLocked());
                                } else if (map.containsKey(SettingEvent.ShutterSpeed.name())) {
                                    settingEvent = SettingEvent.ShutterSpeed;
                                    CameraXB015Data.instance().setShutter(((CameraAllSettings.ShutterSpeed) BaseCamera20.this.messageParser.getObject(map.get(next), CameraAllSettings.ShutterSpeed.class)).getShutter());
                                } else if (map.containsKey(SettingEvent.HistogramSettings.name())) {
                                    settingEvent = SettingEvent.HistogramSettings;
                                    CameraXB015Data.instance().setHistogramEnable(((CameraAllSettings.HistogramSettings) BaseCamera20.this.messageParser.getObject(map.get(next), CameraAllSettings.HistogramSettings.class)).getEnable());
                                } else if (map.containsKey(SettingEvent.Focus.name())) {
                                    settingEvent = SettingEvent.Focus;
                                    CameraAllSettings.Focus focus = (CameraAllSettings.Focus) BaseCamera20.this.messageParser.getObject(map.get(next), CameraAllSettings.Focus.class);
                                    CameraXB015Data.instance().setFocusMode(focus.getMode());
                                    CameraXB015Data.instance().setAFAssistFocusEnable(focus.getAFAssistFocusEnable());
                                    CameraXB015Data.instance().setMFAssistFocusEnable(focus.getMFAssistFocusEnable());
                                    CameraXB015Data.instance().setObjectDistance(focus.getObjectDistance());
                                } else if (map.containsKey(SettingEvent.IRIS.name())) {
                                    settingEvent = SettingEvent.IRIS;
                                    CameraXB015Data.instance().setApertureValue(((CameraAllSettings.IRIS) BaseCamera20.this.messageParser.getObject(map.get(next), CameraAllSettings.IRIS.class)).getIrisValue());
                                } else if (map.containsKey(SettingEvent.ZoomFactor.name())) {
                                    settingEvent = SettingEvent.ZoomFactor;
                                    CameraXB015Data.instance().setZoomValue(((CameraAllSettings.ZoomFactor) BaseCamera20.this.messageParser.getObject(map.get(next), CameraAllSettings.ZoomFactor.class)).getZoomValue());
                                } else if (map.containsKey(SettingEvent.StorageType.name())) {
                                    settingEvent = SettingEvent.StorageType;
                                    CameraXB015Data.instance().setStorageType(((CameraAllSettings.StorageType) BaseCamera20.this.messageParser.getObject(map.get(next), CameraAllSettings.StorageType.class)).getStorageType());
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                        callbackWithOneParam.onSuccess(settingEvent);
                    }
                }
            });
        } else {
            BaseCameraRequest.instance().removeCameraEventsListener(AutelListenerManager.SettingChangedListener);
        }
    }

    public void setConnectStateListener(final CallbackWithOneParam<Boolean> callbackWithOneParam) {
        if (callbackWithOneParam == null) {
            PacketDisPatcher.getInstance().setCameraHeartBeatListener((IConnectionListener) null);
            CameraMessageDisPatcher.instance().unRegisterConnectListener(TAG);
            ConnectionManager2.getInstance_().unRegisterConnectListener(TAG);
            return;
        }
        CameraMessageDisPatcher.instance().registerConnectListener(TAG, new IConnectionListener() {
            public void onConnectStatus(ConnectConnectStatus connectConnectStatus) {
                AutelLog.m15090w("xxxx", "camera  " + connectConnectStatus);
                int i = C235814.f8460xf111a7b7[connectConnectStatus.ordinal()];
                if (i == 1) {
                    AutelLog.m15090w("xxxx", "camera CONNECTED ");
                    callbackWithOneParam.onSuccess(true);
                } else if (i == 2 || i == 3) {
                    AutelLog.m15090w("xxxx", "camera timeout: DISCONNECT ");
                    callbackWithOneParam.onSuccess(false);
                }
            }
        });
        PacketDisPatcher.getInstance().setCameraHeartBeatListener(new IConnectionListener() {
            public void onConnectStatus(ConnectConnectStatus connectConnectStatus) {
                int i = C235814.f8460xf111a7b7[connectConnectStatus.ordinal()];
                if (i == 1) {
                    AutelLog.m15090w("xxxx", "camera onConnectStatus CONNECTED ");
                    callbackWithOneParam.onSuccess(true);
                } else if (i == 2 || i == 3) {
                    callbackWithOneParam.onSuccess(false);
                    AutelLog.m15090w("xxxx", "camera timeout: DISCONNECT ");
                }
            }
        });
        ConnectionManager2.getInstance_().registerConnectListener(TAG, new com.autel.AutelNet2.core.interfaces.IConnectionListener() {
            public void startConnect() {
            }

            public void onConnected() {
                AutelLog.m15090w("xxxx", "camera onConnected ");
            }

            public void onDisconnected() {
                callbackWithOneParam.onSuccess(false);
                AutelLog.m15090w("xxxx", "camera timeout: onDisconnected ");
            }

            public void onConnectError(String str) {
                callbackWithOneParam.onSuccess(false);
                AutelLog.m15090w("xxxx", "camera timeout: onConnectError ");
            }
        });
    }

    /* renamed from: com.autel.camera.protocol.protocol20.base.BaseCamera20$14 */
    /* synthetic */ class C235814 {

        /* renamed from: $SwitchMap$com$autel$internal$sdk$camera$base$ConnectConnectStatus */
        static final /* synthetic */ int[] f8460xf111a7b7;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.autel.internal.sdk.camera.base.ConnectConnectStatus[] r0 = com.autel.internal.sdk.camera.base.ConnectConnectStatus.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f8460xf111a7b7 = r0
                com.autel.internal.sdk.camera.base.ConnectConnectStatus r1 = com.autel.internal.sdk.camera.base.ConnectConnectStatus.CONNECTED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f8460xf111a7b7     // Catch:{ NoSuchFieldError -> 0x001d }
                com.autel.internal.sdk.camera.base.ConnectConnectStatus r1 = com.autel.internal.sdk.camera.base.ConnectConnectStatus.ERROR     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f8460xf111a7b7     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.autel.internal.sdk.camera.base.ConnectConnectStatus r1 = com.autel.internal.sdk.camera.base.ConnectConnectStatus.DISCONNECT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.autel.camera.protocol.protocol20.base.BaseCamera20.C235814.<clinit>():void");
        }
    }

    public void setSetSDCardStateListener(final CallbackWithOneParam<SDCardState> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            BaseCameraRequest.instance().addCameraEventsListener("setSetSDCardStateListener", new CallbackWithOneParam<CameraEvents>() {
                public void onFailure(AutelError autelError) {
                    callbackWithOneParam.onFailure(autelError);
                }

                public void onSuccess(CameraEvents cameraEvents) {
                    if (CameraConstant20.CAMERA_TYPE_SDCARD_STATUS.equals(cameraEvents.getType())) {
                        Log.d("sdcard", "type:" + cameraEvents.getType() + " status:" + cameraEvents.getMap().get(CameraConstant20.CAMERA_TYPE_SDCARD_STATUS));
                        callbackWithOneParam.onSuccess(SDCardState.find(cameraEvents.getMap().get(CameraConstant20.CAMERA_TYPE_SDCARD_STATUS)));
                    } else if (CameraConstant20.SDCardError.equals(cameraEvents.getType())) {
                        Log.d("sdcard", "type:" + cameraEvents.getType() + " SDCardError status:" + cameraEvents.getMap().get("Error"));
                        callbackWithOneParam.onSuccess(SDCardState.find(cameraEvents.getMap().get("Error")));
                    }
                }
            });
            BaseCameraRequest.instance().addCameraSystemStatusListener("setCameraSystemStatusListener", new CallbackWithOneParam<CameraSystemStatus>() {
                public void onFailure(AutelError autelError) {
                    callbackWithOneParam.onFailure(autelError);
                }

                public void onSuccess(CameraSystemStatus cameraSystemStatus) {
                    if (CameraXB015Data.instance().getStorageType() != 1 && !BaseCamera20.this.sdCardStatus.equalsIgnoreCase(cameraSystemStatus.getSDCardStatus())) {
                        String unused = BaseCamera20.this.sdCardStatus = cameraSystemStatus.getSDCardStatus();
                        callbackWithOneParam.onSuccess(SDCardState.find(cameraSystemStatus.getSDCardStatus()));
                    }
                }
            });
            return;
        }
        BaseCameraRequest.instance().removeCameraEventsListener("setSetSDCardStateListener");
        BaseCameraRequest.instance().removeCameraSystemStatusListener("setCameraSystemStatusListener");
    }

    public void setMediaModeListener(final CallbackWithOneParam<MediaMode> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            BaseCameraRequest.instance().addCameraEventsListener("setMediaModeListener", new CallbackWithOneParam<CameraEvents>() {
                public void onFailure(AutelError autelError) {
                    callbackWithOneParam.onFailure(autelError);
                }

                public void onSuccess(CameraEvents cameraEvents) {
                    if (CameraConstant20.ModeChanged.equals(cameraEvents.getType())) {
                        callbackWithOneParam.onSuccess(MediaMode.find(cameraEvents.getMap().get(CameraConstant20.CURRENT_MODE)));
                    }
                }
            });
        } else {
            BaseCameraRequest.instance().removeCameraEventsListener("setMediaModeListener");
        }
    }

    public void setMediaStateListener(final CallbackWithTwoParams<MediaStatus, String> callbackWithTwoParams) {
        if (callbackWithTwoParams != null) {
            BaseCameraRequest.instance().addCameraEventsListener("setMediaStateListener", new CallbackWithOneParam<CameraEvents>() {
                public void onFailure(AutelError autelError) {
                    callbackWithTwoParams.onFailure(autelError);
                }

                public void onSuccess(CameraEvents cameraEvents) {
                    boolean z = true;
                    if (CameraXB015Data.instance().getStorageType() != 1) {
                        z = false;
                    }
                    if (CameraConstant20.CAMERA_TYPE_PHOTO_TAKING_STARTED.equals(cameraEvents.getType())) {
                        AutelCameraStatusInternal.instance().setCameraStatus(CameraConstant20.TAKING_PHOTO);
                        if (MediaMode.SINGLE.getValue20().equals(cameraEvents.getMap().get(CameraConstant20.CURRENT_MODE))) {
                            callbackWithTwoParams.onSuccess(MediaStatus.SINGLE_START, null);
                        } else if (MediaMode.BURST.getValue20().equals(cameraEvents.getMap().get(CameraConstant20.CURRENT_MODE))) {
                            callbackWithTwoParams.onSuccess(MediaStatus.BURST_START, null);
                        } else if (MediaMode.AEB.getValue20().equals(cameraEvents.getMap().get(CameraConstant20.CURRENT_MODE))) {
                            callbackWithTwoParams.onSuccess(MediaStatus.AUTO_EXPOSURE_BURST_START, null);
                        } else if (MediaMode.TIMELAPSE.getValue20().equals(cameraEvents.getMap().get(CameraConstant20.CURRENT_MODE))) {
                            callbackWithTwoParams.onSuccess(MediaStatus.TIME_LAPSE_START, null);
                        } else if (MediaMode.VIDEO.getValue20().equals(cameraEvents.getMap().get(CameraConstant20.CURRENT_MODE))) {
                            callbackWithTwoParams.onSuccess(MediaStatus.SINGLE_START, null);
                        } else if (MediaMode.HDR.getValue20().equals(cameraEvents.getMap().get(CameraConstant20.CURRENT_MODE))) {
                            callbackWithTwoParams.onSuccess(MediaStatus.HDR_START, null);
                        } else if (MediaMode.MFNR.getValue20().equals(cameraEvents.getMap().get(CameraConstant20.CURRENT_MODE))) {
                            callbackWithTwoParams.onSuccess(MediaStatus.MFNR_START, null);
                        }
                    } else if (CameraConstant20.CAMERA_TYPE_PHOTO_TAKING_STOPPED.equals(cameraEvents.getType())) {
                        AutelCameraStatusInternal.instance().setCameraStatus(CameraConstant20.IDLE);
                        if (!cameraEvents.getMap().get(CameraConstant20.Complete).equals("Success")) {
                            callbackWithTwoParams.onFailure(AutelError.TAKE_PHOTO_FAILED);
                        } else if (MediaMode.BURST.getValue20().equals(cameraEvents.getMap().get(CameraConstant20.CURRENT_MODE))) {
                            callbackWithTwoParams.onSuccess(MediaStatus.BURST_STOP, null);
                        } else if (MediaMode.AEB.getValue20().equals(cameraEvents.getMap().get(CameraConstant20.CURRENT_MODE))) {
                            callbackWithTwoParams.onSuccess(MediaStatus.AUTO_EXPOSURE_BURST_STOP, null);
                        } else if (MediaMode.TIMELAPSE.getValue20().equals(cameraEvents.getMap().get(CameraConstant20.CURRENT_MODE))) {
                            callbackWithTwoParams.onSuccess(MediaStatus.TIME_LAPSE_STOP, null);
                        }
                    } else if (CameraConstant20.CAMERA_TYPE_PHOTO_OK.equals(cameraEvents.getType())) {
                        AutelCameraStatusInternal.instance().setCameraStatus(CameraConstant20.IDLE);
                        callbackWithTwoParams.onSuccess(MediaStatus.PHOTO_CAT, null);
                    } else if (CameraConstant20.CAMERA_TYPE_PHOTO_SAVED_ONE.equals(cameraEvents.getType())) {
                        callbackWithTwoParams.onSuccess(MediaStatus.PHOTO_SAVE, new AlbumMediaItem(z, cameraEvents.getMap().get(CameraConstant20.CAMERA_TYPE_FILE_PATH)).getSmallThumbnail());
                    } else if (CameraConstant20.CAMERA_TYPE_PHOTO_TAKEN.equals(cameraEvents.getType())) {
                        AutelCameraStatusInternal.instance().setCameraStatus(CameraConstant20.IDLE);
                        callbackWithTwoParams.onSuccess(MediaStatus.PHOTO_TAKEN_DONE, new AlbumMediaItem(z, cameraEvents.getMap().get(CameraConstant20.CAMERA_TYPE_FILE_PATH)).getSmallThumbnail());
                    } else if (CameraConstant20.CAMERA_TYPE_RECORDING_STARTED.equals(cameraEvents.getType())) {
                        AutelCameraStatusInternal.instance().setCameraStatus(CameraConstant20.RECORDING);
                        callbackWithTwoParams.onSuccess(MediaStatus.RECORD_START, null);
                    } else if (CameraConstant20.CAMERA_TYPE_RECORDING_STOPPED.equals(cameraEvents.getType())) {
                        AutelCameraStatusInternal.instance().setCameraStatus(CameraConstant20.IDLE);
                        String str = cameraEvents.getMap().get(CameraConstant20.Complete);
                        if (str.equals(MediaStatus.RECORD_FAILED_SDCARD_REMOVED.value())) {
                            callbackWithTwoParams.onSuccess(MediaStatus.RECORD_FAILED_SDCARD_REMOVED, new AlbumMediaItem(z, cameraEvents.getMap().get(CameraConstant20.CAMERA_TYPE_FILE_PATH)).getSmallThumbnail());
                        } else if (str.equals(MediaStatus.RECORD_BUFFER_FULL.value())) {
                            callbackWithTwoParams.onSuccess(MediaStatus.RECORD_BUFFER_FULL, new AlbumMediaItem(z, cameraEvents.getMap().get(CameraConstant20.CAMERA_TYPE_FILE_PATH)).getSmallThumbnail());
                        } else if (str.equals(MediaStatus.RECORD_FAILED_WRITE_ERROR.value())) {
                            callbackWithTwoParams.onSuccess(MediaStatus.RECORD_FAILED_WRITE_ERROR, new AlbumMediaItem(z, cameraEvents.getMap().get(CameraConstant20.CAMERA_TYPE_FILE_PATH)).getSmallThumbnail());
                        } else {
                            callbackWithTwoParams.onSuccess(MediaStatus.RECORD_STOP, new AlbumMediaItem(z, cameraEvents.getMap().get(CameraConstant20.CAMERA_TYPE_FILE_PATH)).getSmallThumbnail());
                        }
                    } else if (CameraConstant20.CAMERA_TYPE_MOVIE_RECOVER.equals(cameraEvents.getType())) {
                        String str2 = cameraEvents.getMap().get("RecoverStatus");
                        if ("Begin".equals(str2)) {
                            callbackWithTwoParams.onSuccess(MediaStatus.RECOVER_START, null);
                        } else if (CameraConstant20.Complete.equals(str2)) {
                            callbackWithTwoParams.onSuccess(MediaStatus.RECOVER_COMPLETE, null);
                        }
                    } else if ("UpgradeStarted".equals(cameraEvents.getType())) {
                        callbackWithTwoParams.onSuccess(MediaStatus.UPDATE_START, null);
                    } else if ("UpgradeStopped".equals(cameraEvents.getType())) {
                        if ("Success".equals(cameraEvents.getMap().get("Reason"))) {
                            callbackWithTwoParams.onSuccess(MediaStatus.UPDATE_COMPLETE, null);
                        } else {
                            callbackWithTwoParams.onSuccess(MediaStatus.UPDATE_FAILED, null);
                        }
                    } else if (!CameraConstant20.FactoryResetDone.equals(cameraEvents.getType())) {
                    } else {
                        if ("Success".equals(cameraEvents.getMap().get(CameraParamsConfig.param_Status))) {
                            callbackWithTwoParams.onSuccess(MediaStatus.RESET_SUCCESS, null);
                        } else {
                            callbackWithTwoParams.onSuccess(MediaStatus.RESET_FAILED, null);
                        }
                    }
                }
            });
        } else {
            BaseCameraRequest.instance().removeCameraEventsListener("setMediaStateListener");
        }
    }

    public void formatSDCard(CallbackWithNoParam callbackWithNoParam) {
        BaseCameraRequest.instance().formatSDCard(callbackWithNoParam);
    }

    public void resetDefaults(final CallbackWithNoParam callbackWithNoParam) {
        BaseCameraRequest.instance().resetCamera(new CallbackWithNoParam() {
            public void onSuccess() {
                CameraManager.instance().setParameterValid(false);
                callbackWithNoParam.onSuccess();
                AutelLog.m15082d("AbsTcpConnection", "reset camera success");
                CameraConnection.instance().disconnect();
                MsgPostManager.instance().removeCallbacks();
                MsgPostManager.instance().postDelayed(new PostRunnable() {
                    /* access modifiers changed from: protected */
                    public void task() {
                        CameraConnection.instance().connect();
                    }
                }, 8000);
            }

            public void onFailure(AutelError autelError) {
                callbackWithNoParam.onFailure(autelError);
            }
        });
    }

    public <T> void getSDCardStatus(Class<T> cls, CallbackWithOneParam<T> callbackWithOneParam) {
        BaseCameraRequest.instance().getSDCardStatus(cls, callbackWithOneParam);
    }

    public void getDeviceInformation(CallbackWithOneParam<CameraAllSettings.DeviceInformation> callbackWithOneParam) {
        BaseCameraRequest.instance().getCameraDeviceInformation(callbackWithOneParam);
    }

    public <T> void getCameraAllSetting(Class<T> cls, CallbackWithOneParam<T> callbackWithOneParam) {
        BaseCameraRequest.instance().getCameraAllSettings(cls, callbackWithOneParam);
    }

    public void getCameraSystemStatus(CallbackWithOneParam<CameraAllSettings.SystemStatus> callbackWithOneParam) {
        BaseCameraRequest.instance().getCameraSystemStatus(callbackWithOneParam);
    }

    public CameraProduct getProduct() {
        return CameraProduct.find(CameraManager.instance().getCameraModel());
    }

    public void setMediaMode(final MediaMode mediaMode, final CallbackWithNoParam callbackWithNoParam) {
        BaseCameraRequest.instance().setCameraMode(mediaMode, new CallbackWithNoParam() {
            public void onSuccess() {
                BaseCameraData baseCameraData = CameraModelDataManager.instance().getBaseCameraData();
                if (baseCameraData instanceof CameraXB015Data) {
                    CameraXB015Data.instance().setCurrentMode(mediaMode.getValue20());
                } else if (baseCameraData instanceof CameraXB008Data) {
                    CameraXB008Data.instance().setCurrentMode(mediaMode.getValue20());
                } else if (baseCameraData instanceof CameraFlirData) {
                    CameraFlirData.instance().setCurrentMode(mediaMode.getValue20());
                }
                callbackWithNoParam.onSuccess();
            }

            public void onFailure(AutelError autelError) {
                callbackWithNoParam.onFailure(autelError);
            }
        });
    }

    public void setAspectRatio(String str, CallbackWithNoParam callbackWithNoParam) {
        BaseCameraRequest.instance().setCameraAspectRatio(str, callbackWithNoParam);
    }

    public void setPhotoFormat(PhotoFormat photoFormat, CallbackWithNoParam callbackWithNoParam) {
        BaseCameraRequest.instance().setPhotoFormat(photoFormat, callbackWithNoParam);
    }

    public void setVideoResolutionAndFrameRate(final VideoResolutionAndFps videoResolutionAndFps, final CallbackWithNoParam callbackWithNoParam) {
        BaseCameraRequest.instance().setVideoResolutionAndFrameRate(videoResolutionAndFps, new CallbackWithNoParam() {
            public void onSuccess() {
                AutelLog.m15082d("RequestManager", "setVideoResolutionAndFrameRate suc -> " + videoResolutionAndFps.fps + " value.resolution -> " + videoResolutionAndFps.resolution);
                CameraXB015Data.instance().setVideoMainResolutionAndFps(videoResolutionAndFps);
                callbackWithNoParam.onSuccess();
            }

            public void onFailure(AutelError autelError) {
                callbackWithNoParam.onFailure(autelError);
            }
        });
    }

    public void setVideoFormat(VideoFormat videoFormat, CallbackWithNoParam callbackWithNoParam) {
        BaseCameraRequest.instance().setVideoFormat(videoFormat, callbackWithNoParam);
    }

    public void setVideoStandard(VideoStandard videoStandard, CallbackWithNoParam callbackWithNoParam) {
        BaseCameraRequest.instance().setVideoStandard(videoStandard, callbackWithNoParam);
    }

    public void startTakePhoto(CallbackWithNoParam callbackWithNoParam) {
        BaseCameraRequest.instance().takePhoto(0, callbackWithNoParam);
    }

    public void startRecordVideo(final CallbackWithNoParam callbackWithNoParam) {
        BaseCameraRequest.instance().startRecordVideo(new CallbackWithNoParam() {
            public void onSuccess() {
                TrackingUtils.isRecording = true;
                callbackWithNoParam.onSuccess();
            }

            public void onFailure(AutelError autelError) {
                callbackWithNoParam.onFailure(autelError);
            }
        });
    }

    public void stopRecordVideo(final CallbackWithNoParam callbackWithNoParam) {
        BaseCameraRequest.instance().stopRecordVideo(new CallbackWithNoParam() {
            public void onSuccess() {
                TrackingUtils.isRecording = false;
                TrackingUtils.index = 0;
                callbackWithNoParam.onSuccess();
            }

            public void onFailure(AutelError autelError) {
                callbackWithNoParam.onFailure(autelError);
            }
        });
    }

    public void stopTakePhoto(CallbackWithNoParam callbackWithNoParam) {
        BaseCameraRequest.instance().stopTimelapse(callbackWithNoParam);
    }

    public void setCameraCurrentDate(CallbackWithNoParam callbackWithNoParam) {
        BaseCameraRequest.instance().setCameraCurrentDate(callbackWithNoParam);
    }

    public void getCameraDeviceStatus(CallbackWithOneParam<CameraDeviceStatus> callbackWithOneParam) {
        BaseCameraRequest.instance().getDeviceStatus(callbackWithOneParam);
    }

    public void setCameraPattern(CameraPattern cameraPattern, CallbackWithNoParam callbackWithNoParam) {
        BaseCameraRequest.instance().setCameraPattern(cameraPattern, callbackWithNoParam);
    }

    public void lockGimbalWhenTakePhoto(AutelSwitchState autelSwitchState, CallbackWithNoParam callbackWithNoParam) {
        BaseCameraRequest.instance().lockGimbalWhenTakePhoto(autelSwitchState, callbackWithNoParam);
    }
}
