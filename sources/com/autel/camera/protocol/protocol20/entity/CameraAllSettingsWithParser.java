package com.autel.camera.protocol.protocol20.entity;

import android.util.Log;
import com.autel.bean.camera.CameraAllSettings;
import com.autel.bean.camera.CameraSystemStatus;
import com.autel.bean.camera.FlirCameraAllSettings;
import com.autel.camera.protocol.protocol20.CameraManager;
import com.autel.common.camera.media.SpotMeteringArea;
import com.autel.common.camera.media.VideoBitrateType;
import com.autel.common.camera.media.VideoEncodeFormat;
import com.autel.common.camera.media.VideoEncodeType;
import com.autel.common.camera.media.VideoEncoderConfiguration;
import com.autel.common.camera.media.VideoResolutionAndFps;
import com.autel.internal.sdk.camera.data.CameraModelDataManager;
import com.autel.internal.sdk.camera.data.base.BaseCameraData;
import com.autel.internal.sdk.camera.data.model.CameraFlirData;
import com.autel.internal.sdk.camera.data.model.CameraXB008Data;
import com.autel.internal.sdk.camera.data.model.CameraXB015Data;
import com.autel.util.log.AutelLog;
import java.util.ArrayList;
import java.util.List;

public class CameraAllSettingsWithParser {
    private static CameraAllSettingsWithParser s_instance;
    private CameraAllSettings cameraAllSettings;

    private CameraAllSettingsWithParser() {
    }

    public static CameraAllSettingsWithParser instance() {
        if (s_instance == null) {
            s_instance = new CameraAllSettingsWithParser();
        }
        return s_instance;
    }

    public void updateCameraSetting(CameraAllSettings cameraAllSettings2) {
        if (cameraAllSettings2 != null) {
            setCameraAllSettings(cameraAllSettings2);
            try {
                BaseCameraData baseCameraData = CameraModelDataManager.instance().getBaseCameraData();
                if (baseCameraData instanceof CameraXB008Data) {
                    Log.d("camera", "current camera:CameraXB008Data");
                    putXb08CameraValue(cameraAllSettings2);
                } else if (baseCameraData instanceof CameraXB015Data) {
                    Log.d("camera", "current camera:CameraXB015Data");
                    putXb015CameraValue(cameraAllSettings2);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void putXb015CameraValue(CameraAllSettings cameraAllSettings2) {
        if (cameraAllSettings2.getGimbalLockState() != null) {
            CameraXB015Data.instance().setGimbalLockState(cameraAllSettings2.getGimbalLockState().getLockState());
        }
        if (cameraAllSettings2.getIsoMode() != null) {
            CameraXB015Data.instance().setISOMode(cameraAllSettings2.getIsoMode().getMode());
        }
        CameraXB015Data.instance().setLensModel(cameraAllSettings2.getDeviceInformation().getLensModel());
        CameraXB015Data.instance().setDisplayMode(cameraAllSettings2.getSystemStatus().getDisplayMode());
        CameraXB015Data.instance().setPivState(cameraAllSettings2.getSystemStatus().getSystemStatus());
        CameraXB015Data.instance().setSystemStatus(cameraAllSettings2.getSystemStatus().getSystemStatus());
        CameraXB015Data.instance().setBatteryLevel(cameraAllSettings2.getSystemStatus().getBatteryLevel());
        CameraXB015Data.instance().setCurrentMode(cameraAllSettings2.getSystemStatus().getCurrentMode());
        CameraXB015Data.instance().setPrevPhotoTakingMode(cameraAllSettings2.getSystemStatus().getPrevPhotoTakingMode());
        CameraXB015Data.instance().setTemperature(cameraAllSettings2.getSystemStatus().getTemperature());
        CameraXB015Data.instance().setTotalSpace(cameraAllSettings2.getSDCardStatus().getTotalSpace());
        CameraXB015Data.instance().setCardStatus(cameraAllSettings2.getSDCardStatus().getCardStatus());
        CameraXB015Data.instance().setCurrentRecordTime(cameraAllSettings2.getSDCardStatus().getCurrentRecordTime());
        CameraXB015Data.instance().setFreeSpace(cameraAllSettings2.getSDCardStatus().getFreeSpace());
        CameraXB015Data.instance().setRemainCaptureNum(cameraAllSettings2.getSDCardStatus().getRemainCaptureNum());
        CameraXB015Data.instance().setPicType(cameraAllSettings2.getPhotoTakingSettings().getPicType());
        CameraXB015Data.instance().setPicResolution(cameraAllSettings2.getPhotoTakingSettings().getResolution());
        CameraXB015Data.instance().setDateTime(cameraAllSettings2.getSystemDateAndTime().getDateTime());
        CameraXB015Data.instance().setTimeZone(cameraAllSettings2.getSystemDateAndTime().getTimeZone());
        CameraXB015Data.instance().setDeviceModel(cameraAllSettings2.getDeviceInformation().getDeviceModel());
        CameraXB015Data.instance().setDeviceType(cameraAllSettings2.getDeviceInformation().getDeviceType());
        CameraXB015Data.instance().setProtocolVersion(cameraAllSettings2.getDeviceInformation().getProtocolVersion());
        CameraXB015Data.instance().setManufacturer(cameraAllSettings2.getDeviceInformation().getManufacturer());
        CameraXB015Data.instance().setFirmwareVersion(cameraAllSettings2.getDeviceInformation().getFirmwareVersion());
        CameraXB015Data.instance().setSerialNumber(cameraAllSettings2.getDeviceInformation().getSerialNumber());
        CameraXB015Data.instance().setHardwareId(cameraAllSettings2.getDeviceInformation().getHardwareId());
        CameraXB015Data.instance().setLensSoftVersion(cameraAllSettings2.getDeviceInformation().getLensSoftVersion());
        CameraXB015Data.instance().setCameraMode(cameraAllSettings2.getCameraMode().getMode());
        CameraXB015Data.instance().setImageExposure(cameraAllSettings2.getImageExposure().getExposure());
        CameraXB015Data.instance().setImageISO(cameraAllSettings2.getImageISO().getISO());
        CameraXB015Data.instance().setShutter(cameraAllSettings2.getShutterSpeed().getShutter());
        CameraXB015Data.instance().setVideoRotation(cameraAllSettings2.getVideoSourceConfiguration().getRotation());
        CameraXB015Data.instance().setAntiFlicker(cameraAllSettings2.getVideoSourceConfiguration().getAntiFlicker());
        CameraXB015Data.instance().setVideoStandard(cameraAllSettings2.getVideoSourceConfiguration().getVideoStandard());
        CameraXB015Data.instance().setVideoFileFormat(cameraAllSettings2.getRecordingSettings().getFileFormat());
        CameraXB015Data.instance().setBurstNumPerSecond(cameraAllSettings2.getPhotoTakingSettings().getBurstModeSettings().getNumPhotosPerSecond());
        CameraXB015Data.instance().setTimelapseInterval(cameraAllSettings2.getPhotoTakingSettings().getTimelapseModeSettings().getInterval());
        CameraXB015Data.instance().setAebNumPerSecond(cameraAllSettings2.getPhotoTakingSettings().getAEBModeSettings().getNumPhotosAtOnce());
        CameraXB015Data.instance().setHistogramEnable(cameraAllSettings2.getHistogramSettings().getEnable());
        CameraXB015Data.instance().setLocation_X(cameraAllSettings2.getLocationMeter().getX());
        CameraXB015Data.instance().setLocation_Y(cameraAllSettings2.getLocationMeter().getY());
        CameraXB015Data.instance().setStyle(cameraAllSettings2.getImageStyle().getStyle());
        CameraXB015Data.instance().setBrightness(cameraAllSettings2.getImageStyle().getBrightness());
        CameraXB015Data.instance().setContrast(cameraAllSettings2.getImageStyle().getContrast());
        CameraXB015Data.instance().setSaturation(cameraAllSettings2.getImageStyle().getSaturation());
        CameraXB015Data.instance().setHue(cameraAllSettings2.getImageStyle().getHue());
        CameraXB015Data.instance().setSharpness(cameraAllSettings2.getImageStyle().getSharpness());
        CameraXB015Data.instance().setWBColorTemperature(cameraAllSettings2.getWhiteBalance().getColorTemperature());
        CameraXB015Data.instance().setWhiteBalanceMode(cameraAllSettings2.getWhiteBalance().getMode());
        CameraXB015Data.instance().setImageColor(cameraAllSettings2.getImageColor().getColor());
        CameraXB015Data.instance().setImageExposure(cameraAllSettings2.getImageExposure().getExposure());
        CameraXB015Data.instance().setImageISO(cameraAllSettings2.getImageISO().getISO());
        CameraXB015Data.instance().setCameraGear(cameraAllSettings2.getCameraGear().getGear());
        CameraXB015Data.instance().setAeLocked(cameraAllSettings2.getAELock().getLocked());
        CameraXB015Data.instance().setShutter(cameraAllSettings2.getShutterSpeed().getShutter());
        CameraXB015Data.instance().setZoomValue(cameraAllSettings2.getZoomFactor().getZoomValue());
        CameraXB015Data.instance().setAutoSnapshotEnable(cameraAllSettings2.getRecordingSettings().getAutoSnapshot().getEnable());
        CameraXB015Data.instance().setAutoSnapshotInterval(cameraAllSettings2.getRecordingSettings().getAutoSnapshot().getInterval());
        final List<CameraAllSettings.VideoEncoderConfiguration> videoEncoderConfiguration = cameraAllSettings2.getVideoEncoderConfiguration();
        ArrayList arrayList = new ArrayList();
        AutelLog.debug_i("camera", "videoEncoderConfiguration.size:" + arrayList.size());
        for (final int i = 0; i < videoEncoderConfiguration.size(); i++) {
            if (i == 0) {
                CameraXB015Data.instance().setVideoMainResolutionAndFps(VideoResolutionAndFps.create(videoEncoderConfiguration.get(i).getResolution()));
                CameraXB015Data.instance().setVideoMainEncoding(videoEncoderConfiguration.get(i).getEncoding());
            } else {
                CameraXB015Data.instance().setVideoOtherResolutionAndFps(VideoResolutionAndFps.create(videoEncoderConfiguration.get(i).getResolution()));
                CameraXB015Data.instance().setVideoOtherEncoding(videoEncoderConfiguration.get(i).getEncoding());
            }
            arrayList.add(new VideoEncoderConfiguration() {
                public VideoEncodeFormat getEncoding() {
                    return VideoEncodeFormat.find(((CameraAllSettings.VideoEncoderConfiguration) videoEncoderConfiguration.get(i)).getEncoding());
                }

                public VideoResolutionAndFps getVideoResolutionAndFps() {
                    return VideoResolutionAndFps.create(((CameraAllSettings.VideoEncoderConfiguration) videoEncoderConfiguration.get(i)).getResolution());
                }

                public int getQuality() {
                    return ((CameraAllSettings.VideoEncoderConfiguration) videoEncoderConfiguration.get(i)).getQuality();
                }

                public int getIntervalOfIFrame() {
                    return ((CameraAllSettings.VideoEncoderConfiguration) videoEncoderConfiguration.get(i)).getGovLength();
                }

                public int getBitrate() {
                    return ((CameraAllSettings.VideoEncoderConfiguration) videoEncoderConfiguration.get(i)).getBitrate();
                }

                public VideoBitrateType getBitrateType() {
                    return VideoBitrateType.find(((CameraAllSettings.VideoEncoderConfiguration) videoEncoderConfiguration.get(i)).getBitrateType());
                }

                public VideoEncodeType getEncodeType() {
                    return VideoEncodeType.find(((CameraAllSettings.VideoEncoderConfiguration) videoEncoderConfiguration.get(i)).getProfile());
                }
            });
        }
        CameraXB015Data.instance().setVideoEncoderConfiguration(arrayList);
        if (cameraAllSettings2.getIRIS() != null) {
            CameraXB015Data.instance().setApertureValue(cameraAllSettings2.getIRIS().getIrisValue());
        }
        if (cameraAllSettings2.getFocus() != null) {
            CameraXB015Data.instance().setFocusMode(cameraAllSettings2.getFocus().getMode());
        }
        if (!(cameraAllSettings2.getFocus() == null || cameraAllSettings2.getFocus().getAFMeter() == null)) {
            CameraXB015Data.instance().setAFMode(cameraAllSettings2.getFocus().getAFMeter().getMode());
        }
        if (cameraAllSettings2.getFocus() != null) {
            CameraXB015Data.instance().setObjectDistance(cameraAllSettings2.getFocus().getObjectDistance());
        }
        if (cameraAllSettings2.getShutter() != null) {
            CameraXB015Data.instance().setShutterMode(cameraAllSettings2.getShutter().getType());
        }
        if (cameraAllSettings2.getStorageType() != null) {
            CameraXB015Data.instance().setStorageType(cameraAllSettings2.getStorageType().StorageType);
        }
        if (cameraAllSettings2.getSystemStatus() != null) {
            CameraXB015Data.instance().setDisplayMode(cameraAllSettings2.getSystemStatus().getDisplayMode());
        }
        if (cameraAllSettings2.getIrColor() != null) {
            CameraXB015Data.instance().setIrColor(cameraAllSettings2.getIrColor().getColor());
        }
        if (cameraAllSettings2.getImageRoiSetting() != null) {
            CameraXB015Data.instance().setImageRoiStatus(CameraParamsConfig.param_Enable.equals(cameraAllSettings2.getImageRoiSetting().getStatus()));
        }
        if (!(cameraAllSettings2.getImageRoiSetting() == null || cameraAllSettings2.getImageRoiSetting().getRoiRegion() == null || cameraAllSettings2.getImageRoiSetting().getRoiRegion().size() <= 0)) {
            CameraXB015Data.instance().setImageRoiStrength(cameraAllSettings2.getImageRoiSetting().getRoiRegion().get(0).getStrength());
        }
        if (cameraAllSettings2.getDehazeSetting() != null) {
            CameraXB015Data.instance().setDeFogStatus(CameraParamsConfig.param_Enable.equals(cameraAllSettings2.getDehazeSetting().getStatus()));
            CameraXB015Data.instance().setDeFogStrength(cameraAllSettings2.getDehazeSetting().getStrength());
        }
    }

    private void putXb08CameraValue(CameraAllSettings cameraAllSettings2) {
        CameraXB008Data.instance().setSystemStatus(cameraAllSettings2.getSystemStatus().getSystemStatus());
        CameraXB008Data.instance().setBatteryLevel(cameraAllSettings2.getSystemStatus().getBatteryLevel());
        CameraXB008Data.instance().setCurrentMode(cameraAllSettings2.getSystemStatus().getCurrentMode());
        CameraXB008Data.instance().setPrevPhotoTakingMode(cameraAllSettings2.getSystemStatus().getPrevPhotoTakingMode());
        CameraXB008Data.instance().setTemperature(cameraAllSettings2.getSystemStatus().getTemperature());
        CameraXB008Data.instance().setTotalSpace(cameraAllSettings2.getSDCardStatus().getTotalSpace());
        CameraXB008Data.instance().setCardStatus(cameraAllSettings2.getSDCardStatus().getCardStatus());
        CameraXB008Data.instance().setCurrentRecordTime(cameraAllSettings2.getSDCardStatus().getCurrentRecordTime());
        CameraXB008Data.instance().setFreeSpace(cameraAllSettings2.getSDCardStatus().getFreeSpace());
        CameraXB008Data.instance().setRemainCaptureNum(cameraAllSettings2.getSDCardStatus().getRemainCaptureNum());
        CameraXB008Data.instance().setPicType(cameraAllSettings2.getPhotoTakingSettings().getPicType());
        CameraXB008Data.instance().setPicResolution(cameraAllSettings2.getPhotoTakingSettings().getResolution());
        CameraXB008Data.instance().setDateTime(cameraAllSettings2.getSystemDateAndTime().getDateTime());
        CameraXB008Data.instance().setTimeZone(cameraAllSettings2.getSystemDateAndTime().getTimeZone());
        CameraXB008Data.instance().setDeviceModel(cameraAllSettings2.getDeviceInformation().getDeviceModel());
        CameraXB008Data.instance().setDeviceType(cameraAllSettings2.getDeviceInformation().getDeviceType());
        CameraXB008Data.instance().setProtocolVersion(cameraAllSettings2.getDeviceInformation().getProtocolVersion());
        CameraXB008Data.instance().setManufacturer(cameraAllSettings2.getDeviceInformation().getManufacturer());
        CameraXB008Data.instance().setFirmwareVersion(cameraAllSettings2.getDeviceInformation().getFirmwareVersion());
        CameraXB008Data.instance().setSerialNumber(cameraAllSettings2.getDeviceInformation().getSerialNumber());
        CameraXB008Data.instance().setHardwareId(cameraAllSettings2.getDeviceInformation().getHardwareId());
        CameraXB008Data.instance().setLensSoftVersion(cameraAllSettings2.getDeviceInformation().getLensSoftVersion());
        CameraXB008Data.instance().setCameraMode(cameraAllSettings2.getCameraMode().getMode());
        CameraXB008Data.instance().setImageExposure(cameraAllSettings2.getImageExposure().getExposure());
        CameraXB008Data.instance().setImageISO(cameraAllSettings2.getImageISO().getISO());
        CameraXB008Data.instance().setShutter(cameraAllSettings2.getShutterSpeed().getShutter());
        CameraXB008Data.instance().setVideoRotation(cameraAllSettings2.getVideoSourceConfiguration().getRotation());
        CameraXB008Data.instance().setAntiFlicker(cameraAllSettings2.getVideoSourceConfiguration().getAntiFlicker());
        CameraXB008Data.instance().setVideoStandard(cameraAllSettings2.getVideoSourceConfiguration().getVideoStandard());
        CameraXB008Data.instance().setVideoFileFormat(cameraAllSettings2.getRecordingSettings().getFileFormat());
        CameraXB015Data.instance().setBurstNumPerSecond(cameraAllSettings2.getPhotoTakingSettings().getBurstModeSettings().getNumPhotosPerSecond());
        CameraXB015Data.instance().setTimelapseInterval(cameraAllSettings2.getPhotoTakingSettings().getTimelapseModeSettings().getInterval());
        CameraXB015Data.instance().setAebNumPerSecond(cameraAllSettings2.getPhotoTakingSettings().getAEBModeSettings().getNumPhotosAtOnce());
        CameraXB008Data.instance().setEnableSubtitle(cameraAllSettings2.getRecordingSettings().getEnableSubtitle());
        CameraXB008Data.instance().setEnableSubtitle(cameraAllSettings2.getRecordingSettings().getEnableSubtitle());
        CameraXB008Data.instance().setAudioEncoding(cameraAllSettings2.getAudioEncoderConfiguration().getEncoding());
        CameraXB008Data.instance().setBitrate(cameraAllSettings2.getAudioEncoderConfiguration().getBitrate());
        CameraXB008Data.instance().setSampleRate(cameraAllSettings2.getAudioEncoderConfiguration().getSampleRate());
        CameraXB008Data.instance().setHistogramEnable(cameraAllSettings2.getHistogramSettings().getEnable());
        CameraXB008Data.instance().setLocation_X(cameraAllSettings2.getLocationMeter().getX());
        CameraXB008Data.instance().setLocation_Y(cameraAllSettings2.getLocationMeter().getY());
        CameraXB008Data.instance().setStyle(cameraAllSettings2.getImageStyle().getStyle());
        CameraXB008Data.instance().setBrightness(cameraAllSettings2.getImageStyle().getBrightness());
        CameraXB008Data.instance().setContrast(cameraAllSettings2.getImageStyle().getContrast());
        CameraXB008Data.instance().setSaturation(cameraAllSettings2.getImageStyle().getSaturation());
        CameraXB008Data.instance().setHue(cameraAllSettings2.getImageStyle().getHue());
        CameraXB008Data.instance().setSharpness(cameraAllSettings2.getImageStyle().getSharpness());
        CameraXB008Data.instance().setWBColorTemperature(cameraAllSettings2.getWhiteBalance().getColorTemperature());
        CameraXB008Data.instance().setWhiteBalanceMode(cameraAllSettings2.getWhiteBalance().getMode());
        CameraXB008Data.instance().setImageColor(cameraAllSettings2.getImageColor().getColor());
        CameraXB008Data.instance().setImageExposure(cameraAllSettings2.getImageExposure().getExposure());
        CameraXB008Data.instance().setImageISO(cameraAllSettings2.getImageISO().getISO());
        CameraXB008Data.instance().setCameraGear(cameraAllSettings2.getCameraGear().getGear());
        CameraXB008Data.instance().setAeLocked(cameraAllSettings2.getAELock().getLocked());
        CameraXB008Data.instance().setShutter(cameraAllSettings2.getShutterSpeed().getShutter());
        CameraXB008Data.instance().setZoomValue(cameraAllSettings2.getZoomFactor().getZoomValue());
        CameraXB008Data.instance().setEnableAudio(cameraAllSettings2.getRecordingSettings().getEnableAudio());
        CameraXB008Data.instance().setEnableSubtitle(cameraAllSettings2.getRecordingSettings().getEnableSubtitle());
        CameraXB008Data.instance().setFocusMode(cameraAllSettings2.getFocus().getMode());
        CameraXB008Data.instance().setAFMode(cameraAllSettings2.getFocus().getAFMeter().getMode());
        CameraXB008Data.instance().setObjectDistance(cameraAllSettings2.getFocus().getObjectDistance());
        CameraXB008Data.instance().setIrisValue(cameraAllSettings2.getIRIS().getIrisValue());
        CameraXB008Data.instance().setEnable3DNR(cameraAllSettings2.getVideoSourceConfiguration().getEnable3DNR());
        List<CameraAllSettings.Focus.AFMeter.SpotArea> spotArea = cameraAllSettings2.getFocus().getAFMeter().getSpotArea();
        ArrayList arrayList = new ArrayList();
        for (CameraAllSettings.Focus.AFMeter.SpotArea next : spotArea) {
            SpotMeteringArea spotMeteringArea = new SpotMeteringArea();
            spotMeteringArea.f8467X = next.getX();
            spotMeteringArea.f8468Y = next.getY();
            arrayList.add(spotMeteringArea);
        }
        CameraXB008Data.instance().setSpotArea(arrayList);
        final List<CameraAllSettings.VideoEncoderConfiguration> videoEncoderConfiguration = cameraAllSettings2.getVideoEncoderConfiguration();
        ArrayList arrayList2 = new ArrayList();
        for (final int i = 0; i < videoEncoderConfiguration.size(); i++) {
            if (i == 0) {
                CameraXB008Data.instance().setVideoMainResolutionAndFps(VideoResolutionAndFps.create(videoEncoderConfiguration.get(i).getResolution()));
                CameraXB008Data.instance().setVideoMainEncoding(videoEncoderConfiguration.get(i).getEncoding());
            } else {
                CameraXB008Data.instance().setVideoOtherResolutionAndFps(VideoResolutionAndFps.create(videoEncoderConfiguration.get(i).getResolution()));
                CameraXB008Data.instance().setVideoOtherEncoding(videoEncoderConfiguration.get(i).getEncoding());
            }
            arrayList2.add(new VideoEncoderConfiguration() {
                public VideoEncodeFormat getEncoding() {
                    return VideoEncodeFormat.find(((CameraAllSettings.VideoEncoderConfiguration) videoEncoderConfiguration.get(i)).getEncoding());
                }

                public VideoResolutionAndFps getVideoResolutionAndFps() {
                    return VideoResolutionAndFps.create(((CameraAllSettings.VideoEncoderConfiguration) videoEncoderConfiguration.get(i)).getResolution());
                }

                public int getQuality() {
                    return ((CameraAllSettings.VideoEncoderConfiguration) videoEncoderConfiguration.get(i)).getQuality();
                }

                public int getIntervalOfIFrame() {
                    return ((CameraAllSettings.VideoEncoderConfiguration) videoEncoderConfiguration.get(i)).getGovLength();
                }

                public int getBitrate() {
                    return ((CameraAllSettings.VideoEncoderConfiguration) videoEncoderConfiguration.get(i)).getBitrate();
                }

                public VideoBitrateType getBitrateType() {
                    return VideoBitrateType.find(((CameraAllSettings.VideoEncoderConfiguration) videoEncoderConfiguration.get(i)).getBitrateType());
                }

                public VideoEncodeType getEncodeType() {
                    return VideoEncodeType.find(((CameraAllSettings.VideoEncoderConfiguration) videoEncoderConfiguration.get(i)).getProfile());
                }
            });
        }
        CameraXB008Data.instance().setVideoEncoderConfiguration(arrayList2);
    }

    public void updateFlirSetting(FlirCameraAllSettings flirCameraAllSettings) {
        if (flirCameraAllSettings != null) {
            CameraFlirData.instance().setSystemStatus(flirCameraAllSettings.getSystemStatus().getSystemStatus());
            CameraFlirData.instance().setBatteryLevel(flirCameraAllSettings.getSystemStatus().getBatteryLevel());
            CameraFlirData.instance().setCurrentMode(flirCameraAllSettings.getSystemStatus().getCurrentMode());
            CameraFlirData.instance().setPrevPhotoTakingMode(flirCameraAllSettings.getSystemStatus().getPrevPhotoTakingMode());
            CameraFlirData.instance().setTemperature(flirCameraAllSettings.getSystemStatus().getTemperature());
            CameraFlirData.instance().setTotalSpace(flirCameraAllSettings.getSDCardStatus().getTotalSpace());
            CameraFlirData.instance().setCardStatus(flirCameraAllSettings.getSDCardStatus().getCardStatus());
            CameraFlirData.instance().setCurrentRecordTime(flirCameraAllSettings.getSDCardStatus().getCurrentRecordTime());
            CameraFlirData.instance().setFreeSpace(flirCameraAllSettings.getSDCardStatus().getFreeSpace());
            CameraFlirData.instance().setRemainCaptureNum(flirCameraAllSettings.getSDCardStatus().getRemainCaptureNum());
            CameraFlirData.instance().setPicType(flirCameraAllSettings.getPhotoTakingSettings().getPicType());
            CameraFlirData.instance().setDateTime(flirCameraAllSettings.getSystemDateAndTime().getDateTime());
            CameraFlirData.instance().setTimeZone(flirCameraAllSettings.getSystemDateAndTime().getTimeZone());
            CameraFlirData.instance().setDeviceModel(flirCameraAllSettings.getDeviceInformation().getDeviceModel());
            CameraFlirData.instance().setDeviceType(flirCameraAllSettings.getDeviceInformation().getDeviceType());
            CameraFlirData.instance().setProtocolVersion(flirCameraAllSettings.getDeviceInformation().getProtocolVersion());
            CameraFlirData.instance().setManufacturer(flirCameraAllSettings.getDeviceInformation().getManufacturer());
            CameraFlirData.instance().setFirmwareVersion(flirCameraAllSettings.getDeviceInformation().getFirmwareVersion());
            CameraFlirData.instance().setSerialNumber(flirCameraAllSettings.getDeviceInformation().getSerialNumber());
            CameraFlirData.instance().setHardwareId(flirCameraAllSettings.getDeviceInformation().getHardwareId());
            CameraFlirData.instance().setLensSoftVersion(flirCameraAllSettings.getDeviceInformation().getLensSoftVersion());
            CameraFlirData.instance().setCameraMode(flirCameraAllSettings.getCameraMode().getMode());
            CameraFlirData.instance().setLensSoftVersion(flirCameraAllSettings.getDeviceInformation().getLensSoftVersion());
            CameraFlirData.instance().setLensSoftVersion(flirCameraAllSettings.getDeviceInformation().getLensSoftVersion());
            CameraFlirData.instance().setSupported(flirCameraAllSettings.getPictureInVideoStatus().getSupported());
            CameraFlirData.instance().setCaptured(flirCameraAllSettings.getPictureInVideoStatus().getCaptured());
            CameraFlirData.instance().setTimeLeft(flirCameraAllSettings.getPictureInVideoStatus().getTimeLeft());
            CameraFlirData.instance().setPicType(flirCameraAllSettings.getPhotoTakingSettings().getPicType());
            CameraFlirData.instance().setTimelapseDuration(flirCameraAllSettings.getPhotoTakingSettings().getTimelapseModeSettings().getDuration());
            CameraFlirData.instance().setTimelapseInterval(flirCameraAllSettings.getPhotoTakingSettings().getTimelapseModeSettings().getInterval());
            CameraFlirData.instance().setFileFormat(flirCameraAllSettings.getRecordingSettings().getFileFormat());
            CameraFlirData.instance().setRecordedVideo(flirCameraAllSettings.getRecordingSettings().getRecordedVideo());
            CameraFlirData.instance().setDisplayMode(flirCameraAllSettings.getDisplayMode().getDisplayMode());
            CameraFlirData.instance().setIRColorPalette(flirCameraAllSettings.getIRColorPalette().getIRColorPalette());
            CameraFlirData.instance().setMsxEnable(flirCameraAllSettings.getMSXSettings().getEnable());
            CameraFlirData.instance().setMsxStrength(flirCameraAllSettings.getMSXSettings().getStrength());
            CameraFlirData.instance().setMsxPosX(flirCameraAllSettings.getMSXSettings().getPosX());
            CameraFlirData.instance().setMsxPosY(flirCameraAllSettings.getMSXSettings().getPosY());
            CameraFlirData.instance().setTempUnit(flirCameraAllSettings.getRadiometrySettings().getTempUnit());
            CameraFlirData.instance().setSkyCond(flirCameraAllSettings.getRadiometrySettings().getSkyCond());
            CameraFlirData.instance().setSpotMeter(flirCameraAllSettings.getRadiometrySettings().getSpotMeter());
            CameraFlirData.instance().setEmissivity(flirCameraAllSettings.getRadiometrySettings().getEmissivity());
            CameraFlirData.instance().setAirTemp(flirCameraAllSettings.getRadiometrySettings().getAirTemp());
            CameraFlirData.instance().setHumidity(flirCameraAllSettings.getRadiometrySettings().getHumidity());
            CameraFlirData.instance().setSubjectDistance(flirCameraAllSettings.getRadiometrySettings().getSubjectDistance());
            CameraFlirData.instance().setPosition(flirCameraAllSettings.getPipPosition().getPosition());
        }
    }

    public void putCameraStatusValue(CameraSystemStatus cameraSystemStatus) {
        BaseCameraData baseCameraData = CameraModelDataManager.instance().getBaseCameraData();
        if (baseCameraData instanceof CameraXB008Data) {
            CameraXB008Data.instance().setSystemStatus(cameraSystemStatus.getSystemStatus());
            CameraXB008Data.instance().setBatteryLevel(cameraSystemStatus.getBatteryLevel());
            CameraXB008Data.instance().setCurrentMode(cameraSystemStatus.getCurrentMode());
            CameraXB008Data.instance().setPrevPhotoTakingMode(cameraSystemStatus.getPrevPhotoTakingMode());
            CameraXB008Data.instance().setTemperature(cameraSystemStatus.getTemperature());
            CameraXB008Data.instance().setTotalSpace(cameraSystemStatus.getTotalSpace());
            CameraXB008Data.instance().setCardStatus(cameraSystemStatus.getSDCardStatus());
            CameraXB008Data.instance().setCurrentRecordTime(cameraSystemStatus.getCurrentRecordTime());
            CameraXB008Data.instance().setFreeSpace(cameraSystemStatus.getFreeSpace());
            CameraXB008Data.instance().setRemainCaptureNum(cameraSystemStatus.getRemainCaptureNum());
            CameraXB008Data.instance().setImageExposure(cameraSystemStatus.getExposureValue());
            CameraXB008Data.instance().setImageISO(cameraSystemStatus.getISOValue());
            CameraXB008Data.instance().setShutter(cameraSystemStatus.getShutterSpeed());
        } else if (baseCameraData instanceof CameraXB015Data) {
            if (cameraSystemStatus.getMMCStatus() != null) {
                CameraXB015Data.instance().setMMCStatus(cameraSystemStatus.getMMCStatus());
            }
            CameraXB015Data.instance().setMMCFreeSpace(cameraSystemStatus.getMMCFreeSpace());
            CameraXB015Data.instance().setMMCTotalSpace(cameraSystemStatus.getMMCTotalSpace());
            CameraXB015Data.instance().setPivState(cameraSystemStatus.getPivState());
            CameraXB015Data.instance().setSystemStatus(cameraSystemStatus.getSystemStatus());
            CameraXB015Data.instance().setBatteryLevel(cameraSystemStatus.getBatteryLevel());
            CameraXB015Data.instance().setCurrentMode(cameraSystemStatus.getCurrentMode());
            CameraXB015Data.instance().setPrevPhotoTakingMode(cameraSystemStatus.getPrevPhotoTakingMode());
            CameraXB015Data.instance().setTemperature(cameraSystemStatus.getTemperature());
            CameraXB015Data.instance().setTotalSpace(cameraSystemStatus.getTotalSpace());
            CameraXB015Data.instance().setCardStatus(cameraSystemStatus.getSDCardStatus());
            CameraXB015Data.instance().setCurrentRecordTime(cameraSystemStatus.getCurrentRecordTime());
            CameraXB015Data.instance().setFreeSpace(cameraSystemStatus.getFreeSpace());
            CameraXB015Data.instance().setRemainCaptureNum(cameraSystemStatus.getRemainCaptureNum());
            CameraXB015Data.instance().setImageExposure(cameraSystemStatus.getExposureValue());
            CameraXB015Data.instance().setImageISO(cameraSystemStatus.getISOValue());
            CameraXB015Data.instance().setShutter(cameraSystemStatus.getShutterSpeed());
            CameraXB015Data.instance().setVFOV(cameraSystemStatus.getFovV());
            CameraXB015Data.instance().setHFOV(cameraSystemStatus.getFovH());
        }
        updateAllSettingStatus(cameraSystemStatus);
    }

    private void updateAllSettingStatus(CameraSystemStatus cameraSystemStatus) {
        try {
            if (CameraManager.instance().isParameterValid()) {
                CameraAllSettings.SystemStatus systemStatus = new CameraAllSettings.SystemStatus();
                systemStatus.setBatteryLevel(cameraSystemStatus.getBatteryLevel());
                systemStatus.setCurrentMode(cameraSystemStatus.getCurrentMode());
                systemStatus.setPivState(cameraSystemStatus.getPivState());
                systemStatus.setPrevPhotoTakingMode(cameraSystemStatus.getPrevPhotoTakingMode());
                systemStatus.setSystemStatus(cameraSystemStatus.getSystemStatus());
                systemStatus.setPrevRecordMode(cameraSystemStatus.getPrevRecordMode());
                systemStatus.setTemperature(cameraSystemStatus.getTemperature());
                this.cameraAllSettings.setSystemStatus(systemStatus);
                CameraAllSettings.ImageISO imageISO = new CameraAllSettings.ImageISO();
                imageISO.setISO(cameraSystemStatus.getISOValue());
                this.cameraAllSettings.setImageISO(imageISO);
                CameraAllSettings.CameraMode cameraMode = new CameraAllSettings.CameraMode();
                cameraMode.setMode(cameraSystemStatus.getCurrentMode());
                this.cameraAllSettings.setCameraMode(cameraMode);
                CameraAllSettings.SDCardStatus sDCardStatus = new CameraAllSettings.SDCardStatus();
                sDCardStatus.setCardStatus(cameraSystemStatus.getSDCardStatus());
                sDCardStatus.setFreeSpace(cameraSystemStatus.getFreeSpace());
                sDCardStatus.setRemainCaptureNum(cameraSystemStatus.getRemainCaptureNum());
                sDCardStatus.setCurrentRecordTime(cameraSystemStatus.getCurrentRecordTime());
                sDCardStatus.setTotalSpace(cameraSystemStatus.getTotalSpace());
                this.cameraAllSettings.setSDCardStatus(sDCardStatus);
                CameraAllSettings.ImageExposure imageExposure = new CameraAllSettings.ImageExposure();
                imageExposure.setExposure(cameraSystemStatus.getExposureValue());
                this.cameraAllSettings.setImageExposure(imageExposure);
                CameraAllSettings.ShutterSpeed shutterSpeed = new CameraAllSettings.ShutterSpeed();
                shutterSpeed.setShutter(cameraSystemStatus.getShutterSpeed());
                this.cameraAllSettings.setShutterSpeed(shutterSpeed);
                CameraAllSettings.ZoomFactor zoomFactor = new CameraAllSettings.ZoomFactor();
                zoomFactor.setZoomValue(cameraSystemStatus.getZoomValue());
                this.cameraAllSettings.setZoomFactor(zoomFactor);
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.d("Camera", "update AllSetting Exception " + e.getMessage());
        }
    }

    public CameraAllSettings getCameraAllSettings() {
        return this.cameraAllSettings;
    }

    public void setCameraAllSettings(CameraAllSettings cameraAllSettings2) {
        this.cameraAllSettings = cameraAllSettings2;
    }
}
