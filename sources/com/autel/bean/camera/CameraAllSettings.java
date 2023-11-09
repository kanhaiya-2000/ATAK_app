package com.autel.bean.camera;

import com.autel.camera.protocol.protocol20.entity.DehazeSetting;
import com.autel.camera.protocol.protocol20.entity.ImageRoiSetting;
import java.util.List;

public class CameraAllSettings {
    private AELock AELock;
    private AudioEncoderConfiguration AudioEncoderConfiguration;
    private AudioEncoderConfigurationOptions AudioEncoderConfigurationOptions;
    private AudioSourceConfiguration AudioSourceConfiguration;
    private CameraGear CameraGear;
    private CameraMode CameraMode;
    private DehazeSetting DehazeSetting;
    private DeviceInformation DeviceInformation;
    private DisplayMode DisplayMode;
    private FileNamingMode FileNamingMode;
    private Focus Focus;
    private GimbalLockState GimbalLockState;
    private HistogramSettings HistogramSettings;
    private IRIS IRIS;
    private ImageColor ImageColor;
    private ImageExposure ImageExposure;
    private ImageISO ImageISO;
    private ImageRoiSetting ImageRoiSetting;
    private ImageStyle ImageStyle;
    private IrColor IrColor;
    private IrPosition IrPosition;
    private IsoModeInfo IsoMode;
    private LocationMeter LocationMeter;
    private MMCStatus MMCStatus;
    private PanoramaStatus PanoramaStatus;
    private PhotoTakingSettings PhotoTakingSettings;
    private PictureInVideoStatus PictureInVideoStatus;
    private RecordingSettings RecordingSettings;
    private SDCardStatus SDCardStatus;
    private ShutterMode Shutter;
    private ShutterSpeed ShutterSpeed;
    private StorageType StorageType;
    private SystemDateAndTime SystemDateAndTime;
    private SystemStatus SystemStatus;
    private List<VideoEncoderConfiguration> VideoEncoderConfiguration;
    private VideoSourceConfiguration VideoSourceConfiguration;
    private VideoSourceConfigurationOptions VideoSourceConfigurationOptions;
    private WhiteBalance WhiteBalance;
    private WiFiConfiguration WiFiConfiguration;
    private WiFiStatus WiFiStatus;
    private YawPitch YawPitch;
    private ZoomFactor ZoomFactor;
    private HDRSetting hdrSetting;

    public void setIrPosition(IrPosition irPosition) {
    }

    public IsoModeInfo getIsoMode() {
        return this.IsoMode;
    }

    public void setIsoMode(IsoModeInfo isoModeInfo) {
        this.IsoMode = isoModeInfo;
    }

    public GimbalLockState getGimbalLockState() {
        return this.GimbalLockState;
    }

    public void setGimbalLockState(GimbalLockState gimbalLockState) {
        this.GimbalLockState = gimbalLockState;
    }

    public DehazeSetting getDehazeSetting() {
        return this.DehazeSetting;
    }

    public void setDehazeSetting(DehazeSetting dehazeSetting) {
        this.DehazeSetting = dehazeSetting;
    }

    public ImageRoiSetting getImageRoiSetting() {
        return this.ImageRoiSetting;
    }

    public void setImageRoiSetting(ImageRoiSetting imageRoiSetting) {
        this.ImageRoiSetting = imageRoiSetting;
    }

    public HDRSetting getHdrSetting() {
        return this.hdrSetting;
    }

    public void setHdrSetting(HDRSetting hDRSetting) {
        this.hdrSetting = hDRSetting;
    }

    public StorageType getStorageType() {
        return this.StorageType;
    }

    public void setStorageType(StorageType storageType) {
        this.StorageType = storageType;
    }

    public MMCStatus getMMCStatus() {
        return this.MMCStatus;
    }

    public void setMMCStatus(MMCStatus mMCStatus) {
        this.MMCStatus = mMCStatus;
    }

    public static class MMCStatus {
        private long CurrentRecordTime;
        private long FreeSpace;
        private String MMCStatus;
        private int RemainCaptureNum;
        private int RemainRecordTime;
        private long TotalSpace;

        public String getMMCStatus() {
            return this.MMCStatus;
        }

        public void setMMCStatus(String str) {
            this.MMCStatus = str;
        }

        public long getTotalSpace() {
            return this.TotalSpace;
        }

        public void setTotalSpace(long j) {
            this.TotalSpace = j;
        }

        public long getFreeSpace() {
            return this.FreeSpace;
        }

        public void setFreeSpace(long j) {
            this.FreeSpace = j;
        }

        public long getCurrentRecordTime() {
            return this.CurrentRecordTime;
        }

        public void setCurrentRecordTime(long j) {
            this.CurrentRecordTime = j;
        }

        public int getRemainRecordTime() {
            return this.RemainRecordTime;
        }

        public void setRemainRecordTime(int i) {
            this.RemainRecordTime = i;
        }

        public int getRemainCaptureNum() {
            return this.RemainCaptureNum;
        }

        public void setRemainCaptureNum(int i) {
            this.RemainCaptureNum = i;
        }
    }

    public static class StorageType {
        public int StorageType;

        public int getStorageType() {
            return this.StorageType;
        }

        public void setStorageType(int i) {
            this.StorageType = i;
        }
    }

    public DeviceInformation getDeviceInformation() {
        return this.DeviceInformation;
    }

    public void setDeviceInformation(DeviceInformation deviceInformation) {
        this.DeviceInformation = deviceInformation;
    }

    public SystemStatus getSystemStatus() {
        return this.SystemStatus;
    }

    public void setSystemStatus(SystemStatus systemStatus) {
        this.SystemStatus = systemStatus;
    }

    public SDCardStatus getSDCardStatus() {
        return this.SDCardStatus;
    }

    public void setSDCardStatus(SDCardStatus sDCardStatus) {
        this.SDCardStatus = sDCardStatus;
    }

    public SystemDateAndTime getSystemDateAndTime() {
        return this.SystemDateAndTime;
    }

    public void setSystemDateAndTime(SystemDateAndTime systemDateAndTime) {
        this.SystemDateAndTime = systemDateAndTime;
    }

    public List<VideoEncoderConfiguration> getVideoEncoderConfiguration() {
        return this.VideoEncoderConfiguration;
    }

    public void setVideoEncoderConfiguration(List<VideoEncoderConfiguration> list) {
        this.VideoEncoderConfiguration = list;
    }

    public VideoSourceConfiguration getVideoSourceConfiguration() {
        return this.VideoSourceConfiguration;
    }

    public void setVideoSourceConfiguration(VideoSourceConfiguration videoSourceConfiguration) {
        this.VideoSourceConfiguration = videoSourceConfiguration;
    }

    public VideoSourceConfigurationOptions getVideoSourceConfigurationOptions() {
        return this.VideoSourceConfigurationOptions;
    }

    public void setVideoSourceConfigurationOptions(VideoSourceConfigurationOptions videoSourceConfigurationOptions) {
        this.VideoSourceConfigurationOptions = videoSourceConfigurationOptions;
    }

    public AudioEncoderConfigurationOptions getAudioEncoderConfigurationOptions() {
        return this.AudioEncoderConfigurationOptions;
    }

    public void setAudioEncoderConfigurationOptions(AudioEncoderConfigurationOptions audioEncoderConfigurationOptions) {
        this.AudioEncoderConfigurationOptions = audioEncoderConfigurationOptions;
    }

    public AudioEncoderConfiguration getAudioEncoderConfiguration() {
        return this.AudioEncoderConfiguration;
    }

    public void setAudioEncoderConfiguration(AudioEncoderConfiguration audioEncoderConfiguration) {
        this.AudioEncoderConfiguration = audioEncoderConfiguration;
    }

    public CameraMode getCameraMode() {
        return this.CameraMode;
    }

    public void setCameraMode(CameraMode cameraMode) {
        this.CameraMode = cameraMode;
    }

    public PictureInVideoStatus getPictureInVideoStatus() {
        return this.PictureInVideoStatus;
    }

    public void setPictureInVideoStatus(PictureInVideoStatus pictureInVideoStatus) {
        this.PictureInVideoStatus = pictureInVideoStatus;
    }

    public PhotoTakingSettings getPhotoTakingSettings() {
        return this.PhotoTakingSettings;
    }

    public void setPhotoTakingSettings(PhotoTakingSettings photoTakingSettings) {
        this.PhotoTakingSettings = photoTakingSettings;
    }

    public YawPitch getYawPitch() {
        return this.YawPitch;
    }

    public void setYawPitch(YawPitch yawPitch) {
        this.YawPitch = yawPitch;
    }

    public RecordingSettings getRecordingSettings() {
        return this.RecordingSettings;
    }

    public void setRecordingSettings(RecordingSettings recordingSettings) {
        this.RecordingSettings = recordingSettings;
    }

    public HistogramSettings getHistogramSettings() {
        return this.HistogramSettings;
    }

    public void setHistogramSettings(HistogramSettings histogramSettings) {
        this.HistogramSettings = histogramSettings;
    }

    public LocationMeter getLocationMeter() {
        return this.LocationMeter;
    }

    public void setLocationMeter(LocationMeter locationMeter) {
        this.LocationMeter = locationMeter;
    }

    public ImageStyle getImageStyle() {
        return this.ImageStyle;
    }

    public void setImageStyle(ImageStyle imageStyle) {
        this.ImageStyle = imageStyle;
    }

    public WhiteBalance getWhiteBalance() {
        return this.WhiteBalance;
    }

    public void setWhiteBalance(WhiteBalance whiteBalance) {
        this.WhiteBalance = whiteBalance;
    }

    public ImageColor getImageColor() {
        return this.ImageColor;
    }

    public void setImageColor(ImageColor imageColor) {
        this.ImageColor = imageColor;
    }

    public ImageExposure getImageExposure() {
        return this.ImageExposure;
    }

    public void setImageExposure(ImageExposure imageExposure) {
        this.ImageExposure = imageExposure;
    }

    public ImageISO getImageISO() {
        return this.ImageISO;
    }

    public void setImageISO(ImageISO imageISO) {
        this.ImageISO = imageISO;
    }

    public WiFiConfiguration getWiFiConfiguration() {
        return this.WiFiConfiguration;
    }

    public void setWiFiConfiguration(WiFiConfiguration wiFiConfiguration) {
        this.WiFiConfiguration = wiFiConfiguration;
    }

    public AudioSourceConfiguration getAudioSourceConfiguration() {
        return this.AudioSourceConfiguration;
    }

    public WiFiStatus getWiFiStatus() {
        return this.WiFiStatus;
    }

    public void setWiFiStatus(WiFiStatus wiFiStatus) {
        this.WiFiStatus = wiFiStatus;
    }

    public void setAudioSourceConfiguration(AudioSourceConfiguration audioSourceConfiguration) {
        this.AudioSourceConfiguration = audioSourceConfiguration;
    }

    public CameraGear getCameraGear() {
        return this.CameraGear;
    }

    public void setCameraGear(CameraGear cameraGear) {
        this.CameraGear = cameraGear;
    }

    public AELock getAELock() {
        return this.AELock;
    }

    public void setAELock(AELock aELock) {
        this.AELock = aELock;
    }

    public ShutterSpeed getShutterSpeed() {
        return this.ShutterSpeed;
    }

    public void setShutterSpeed(ShutterSpeed shutterSpeed) {
        this.ShutterSpeed = shutterSpeed;
    }

    public FileNamingMode getFileNamingMode() {
        return this.FileNamingMode;
    }

    public void setFileNamingMode(FileNamingMode fileNamingMode) {
        this.FileNamingMode = fileNamingMode;
    }

    public PanoramaStatus getPanoramaStatus() {
        return this.PanoramaStatus;
    }

    public void setPanoramaStatus(PanoramaStatus panoramaStatus) {
        this.PanoramaStatus = panoramaStatus;
    }

    public Focus getFocus() {
        return this.Focus;
    }

    public ShutterMode getShutter() {
        return this.Shutter;
    }

    public void setShutter(ShutterMode shutterMode) {
        this.Shutter = shutterMode;
    }

    public void setFocus(Focus focus) {
        this.Focus = focus;
    }

    public IRIS getIRIS() {
        return this.IRIS;
    }

    public void setIRIS(IRIS iris) {
        this.IRIS = iris;
    }

    public ZoomFactor getZoomFactor() {
        return this.ZoomFactor;
    }

    public void setZoomFactor(ZoomFactor zoomFactor) {
        this.ZoomFactor = zoomFactor;
    }

    public DisplayMode getDisplayMode() {
        return this.DisplayMode;
    }

    public void setDisplayMode(DisplayMode displayMode) {
        this.DisplayMode = displayMode;
    }

    public IrColor getIrColor() {
        return this.IrColor;
    }

    public void setIrColor(IrColor irColor) {
        this.IrColor = irColor;
    }

    public IrPosition getIrPosition() {
        return this.IrPosition;
    }

    public class DeviceInformation {
        private String DeviceModel;
        private String DeviceType;
        private String FirmwareVersion;
        private String HardwareId;
        private String LensModel;
        private String LensSoftVersion;
        private String Manufacturer;
        private int ProtocolVersion;
        private String SerialNumber;

        public DeviceInformation() {
        }

        public String getLensModel() {
            return this.LensModel;
        }

        public void setLensModel(String str) {
            this.LensModel = str;
        }

        public String getLensSoftVersion() {
            return this.LensSoftVersion;
        }

        public void setLensSoftVersion(String str) {
            this.LensSoftVersion = str;
        }

        public String getDeviceType() {
            return this.DeviceType;
        }

        public void setDeviceType(String str) {
            this.DeviceType = str;
        }

        public String getDeviceModel() {
            return this.DeviceModel;
        }

        public void setDeviceModel(String str) {
            this.DeviceModel = str;
        }

        public int getProtocolVersion() {
            return this.ProtocolVersion;
        }

        public void setProtocolVersion(int i) {
            this.ProtocolVersion = i;
        }

        public String getManufacturer() {
            return this.Manufacturer;
        }

        public void setManufacturer(String str) {
            this.Manufacturer = str;
        }

        public String getFirmwareVersion() {
            return this.FirmwareVersion;
        }

        public void setFirmwareVersion(String str) {
            this.FirmwareVersion = str;
        }

        public String getSerialNumber() {
            return this.SerialNumber;
        }

        public void setSerialNumber(String str) {
            this.SerialNumber = str;
        }

        public String getHardwareId() {
            return this.HardwareId;
        }

        public void setHardwareId(String str) {
            this.HardwareId = str;
        }
    }

    public static class SystemStatus {
        private int BatteryLevel;
        private String CurrentMode;
        private String DisplayMode;
        private String PivState;
        private String PrevPhotoTakingMode;
        private String PrevRecordMode;
        private String SystemStatus;
        private int Temperature;

        public String getDisplayMode() {
            return this.DisplayMode;
        }

        public void setDisplayMode(String str) {
            this.DisplayMode = str;
        }

        public String getPivState() {
            return this.PivState;
        }

        public void setPivState(String str) {
            this.PivState = str;
        }

        public String getSystemStatus() {
            return this.SystemStatus;
        }

        public void setSystemStatus(String str) {
            this.SystemStatus = str;
        }

        public String getCurrentMode() {
            return this.CurrentMode;
        }

        public void setCurrentMode(String str) {
            this.CurrentMode = str;
        }

        public String getPrevRecordMode() {
            return this.PrevRecordMode;
        }

        public void setPrevRecordMode(String str) {
            this.PrevRecordMode = str;
        }

        public String getPrevPhotoTakingMode() {
            return this.PrevPhotoTakingMode;
        }

        public void setPrevPhotoTakingMode(String str) {
            this.PrevPhotoTakingMode = str;
        }

        public int getTemperature() {
            return this.Temperature;
        }

        public void setTemperature(int i) {
            this.Temperature = i;
        }

        public int getBatteryLevel() {
            return this.BatteryLevel;
        }

        public void setBatteryLevel(int i) {
            this.BatteryLevel = i;
        }
    }

    public static class SDCardStatus {
        private String CardStatus;
        private long CurrentRecordTime;
        private long FreeSpace;
        private int RemainCaptureNum;
        private int RemainRecordTime;
        private long TotalSpace;

        public String getCardStatus() {
            return this.CardStatus;
        }

        public void setCardStatus(String str) {
            this.CardStatus = str;
        }

        public long getTotalSpace() {
            return this.TotalSpace;
        }

        public void setTotalSpace(long j) {
            this.TotalSpace = j;
        }

        public long getFreeSpace() {
            return this.FreeSpace;
        }

        public void setFreeSpace(long j) {
            this.FreeSpace = j;
        }

        public long getCurrentRecordTime() {
            return this.CurrentRecordTime;
        }

        public void setCurrentRecordTime(long j) {
            this.CurrentRecordTime = j;
        }

        public int getRemainRecordTime() {
            return this.RemainRecordTime;
        }

        public void setRemainRecordTime(int i) {
            this.RemainRecordTime = i;
        }

        public int getRemainCaptureNum() {
            return this.RemainCaptureNum;
        }

        public void setRemainCaptureNum(int i) {
            this.RemainCaptureNum = i;
        }
    }

    public static class SystemDateAndTime {
        private String DateTime;
        private int TimeZone;

        public int getTimeZone() {
            return this.TimeZone;
        }

        public void setTimeZone(int i) {
            this.TimeZone = i;
        }

        public String getDateTime() {
            return this.DateTime;
        }

        public void setDateTime(String str) {
            this.DateTime = str;
        }
    }

    public static class VideoSourceConfiguration {
        private String AntiFlicker;
        private int Enable3DNR;
        private int Rotation;
        private String VideoStandard;

        public int getRotation() {
            return this.Rotation;
        }

        public void setRotation(int i) {
            this.Rotation = i;
        }

        public String getAntiFlicker() {
            return this.AntiFlicker;
        }

        public void setAntiFlicker(String str) {
            this.AntiFlicker = str;
        }

        public String getVideoStandard() {
            return this.VideoStandard;
        }

        public void setVideoStandard(String str) {
            this.VideoStandard = str;
        }

        public int getEnable3DNR() {
            return this.Enable3DNR;
        }

        public void setEnable3DNR(int i) {
            this.Enable3DNR = i;
        }
    }

    public class VideoSourceConfigurationOptions {
        private String[] SupportedRotations;
        private String[] SupportedShutters;

        public VideoSourceConfigurationOptions() {
        }

        public String[] getSupportedRotations() {
            return this.SupportedRotations;
        }

        public void setSupportedRotations(String[] strArr) {
            this.SupportedRotations = strArr;
        }

        public String[] getSupportedShutters() {
            return this.SupportedShutters;
        }

        public void setSupportedShutters(String[] strArr) {
            this.SupportedShutters = strArr;
        }
    }

    public class AudioEncoderConfigurationOptions {
        private BitrateLimit BitrateLimit;
        private SampleRateLimit SampleRateLimit;
        private String[] SupportedEncodings;

        public AudioEncoderConfigurationOptions() {
        }

        public BitrateLimit getBitrateLimit() {
            return this.BitrateLimit;
        }

        public void setBitrateLimit(BitrateLimit bitrateLimit) {
            this.BitrateLimit = bitrateLimit;
        }

        public SampleRateLimit getSampleRateLimit() {
            return this.SampleRateLimit;
        }

        public void setSampleRateLimit(SampleRateLimit sampleRateLimit) {
            this.SampleRateLimit = sampleRateLimit;
        }

        public String[] getSupportedEncodings() {
            return this.SupportedEncodings;
        }

        public void setSupportedEncodings(String[] strArr) {
            this.SupportedEncodings = strArr;
        }

        public class BitrateLimit {
            private int Max;
            private int Min;

            public BitrateLimit() {
            }

            public int getMin() {
                return this.Min;
            }

            public void setMin(int i) {
                this.Min = i;
            }

            public int getMax() {
                return this.Max;
            }

            public void setMax(int i) {
                this.Max = i;
            }
        }

        public class SampleRateLimit {
            private int Max;
            private int Min;

            public SampleRateLimit() {
            }

            public int getMin() {
                return this.Min;
            }

            public void setMin(int i) {
                this.Min = i;
            }

            public int getMax() {
                return this.Max;
            }

            public void setMax(int i) {
                this.Max = i;
            }
        }
    }

    public class AudioEncoderConfiguration {
        private int Bitrate;
        private String Encoding;
        private int SampleRate;

        public AudioEncoderConfiguration() {
        }

        public String getEncoding() {
            return this.Encoding;
        }

        public void setEncoding(String str) {
            this.Encoding = str;
        }

        public int getBitrate() {
            return this.Bitrate;
        }

        public void setBitrate(int i) {
            this.Bitrate = i;
        }

        public int getSampleRate() {
            return this.SampleRate;
        }

        public void setSampleRate(int i) {
            this.SampleRate = i;
        }
    }

    public static class CameraMode {
        private String Mode;

        public String getMode() {
            return this.Mode;
        }

        public void setMode(String str) {
            this.Mode = str;
        }
    }

    public class PictureInVideoStatus {
        private int Captured;
        private int Supported;
        private int TimeLeft;

        public PictureInVideoStatus() {
        }

        public int getSupported() {
            return this.Supported;
        }

        public void setSupported(int i) {
            this.Supported = i;
        }

        public int getCaptured() {
            return this.Captured;
        }

        public void setCaptured(int i) {
            this.Captured = i;
        }

        public int getTimeLeft() {
            return this.TimeLeft;
        }

        public void setTimeLeft(int i) {
            this.TimeLeft = i;
        }
    }

    public static class PhotoTakingSettings {
        private AEBModeSettings AEBModeSettings;
        private BurstModeSettings BurstModeSettings;
        private DelayShotModeSettings DelayShotModeSettings;
        private MotionDelayShotModeSettings MotionDelayShotModeSettings;
        private PanoramaModeSettings PanoramaModeSettings;
        private String PicType;
        private String Resolution;
        private SingleModeSettings SingleModeSettings;
        private TimelapseModeSettings TimelapseModeSettings;

        public TimelapseModeSettings getTimelapseModeSettings() {
            return this.TimelapseModeSettings;
        }

        public void setTimelapseModeSettings(TimelapseModeSettings timelapseModeSettings) {
            this.TimelapseModeSettings = timelapseModeSettings;
        }

        public AEBModeSettings getAEBModeSettings() {
            return this.AEBModeSettings;
        }

        public void setAEBModeSettings(AEBModeSettings aEBModeSettings) {
            this.AEBModeSettings = aEBModeSettings;
        }

        public PanoramaModeSettings getPanoramaModeSettings() {
            return this.PanoramaModeSettings;
        }

        public void setPanoramaModeSettings(PanoramaModeSettings panoramaModeSettings) {
            this.PanoramaModeSettings = panoramaModeSettings;
        }

        public DelayShotModeSettings getDelayShotModeSettings() {
            return this.DelayShotModeSettings;
        }

        public void setDelayShotModeSettings(DelayShotModeSettings delayShotModeSettings) {
            this.DelayShotModeSettings = delayShotModeSettings;
        }

        public MotionDelayShotModeSettings getMotionDelayShotModeSettings() {
            return this.MotionDelayShotModeSettings;
        }

        public void setMotionDelayShotModeSettings(MotionDelayShotModeSettings motionDelayShotModeSettings) {
            this.MotionDelayShotModeSettings = motionDelayShotModeSettings;
        }

        public SingleModeSettings getSingleModeSettings() {
            return this.SingleModeSettings;
        }

        public void setSingleModeSettings(SingleModeSettings singleModeSettings) {
            this.SingleModeSettings = singleModeSettings;
        }

        public BurstModeSettings getBurstModeSettings() {
            return this.BurstModeSettings;
        }

        public void setBurstModeSettings(BurstModeSettings burstModeSettings) {
            this.BurstModeSettings = burstModeSettings;
        }

        public String getPicType() {
            return this.PicType;
        }

        public void setPicType(String str) {
            this.PicType = str;
        }

        public String getResolution() {
            return this.Resolution;
        }

        public void setResolution(String str) {
            this.Resolution = str;
        }

        public class SingleModeSettings {
            private int DelaySeconds;
            private int EnableHDR;

            public SingleModeSettings() {
            }

            public int getDelaySeconds() {
                return this.DelaySeconds;
            }

            public void setDelaySeconds(int i) {
                this.DelaySeconds = i;
            }

            public int getEnableHDR() {
                return this.EnableHDR;
            }

            public void setEnableHDR(int i) {
                this.EnableHDR = i;
            }
        }

        public class BurstModeSettings {
            private int NumPhotosPerSecond;

            public BurstModeSettings() {
            }

            public int getNumPhotosPerSecond() {
                return this.NumPhotosPerSecond;
            }

            public void setNumPhotosPerSecond(int i) {
                this.NumPhotosPerSecond = i;
            }
        }

        public class TimelapseModeSettings {
            private int ComposeVideo;
            private int Duration;
            private int Interval;
            private int VideoFramerate;

            public TimelapseModeSettings() {
            }

            public int getInterval() {
                return this.Interval;
            }

            public void setInterval(int i) {
                this.Interval = i;
            }

            public int getDuration() {
                return this.Duration;
            }

            public void setDuration(int i) {
                this.Duration = i;
            }

            public int getComposeVideo() {
                return this.ComposeVideo;
            }

            public void setComposeVideo(int i) {
                this.ComposeVideo = i;
            }

            public int getVideoFramerate() {
                return this.VideoFramerate;
            }

            public void setVideoFramerate(int i) {
                this.VideoFramerate = i;
            }
        }

        public class AEBModeSettings {
            private int NumPhotosAtOnce;

            public AEBModeSettings() {
            }

            public int getNumPhotosAtOnce() {
                return this.NumPhotosAtOnce;
            }

            public void setNumPhotosAtOnce(int i) {
                this.NumPhotosAtOnce = i;
            }
        }

        public class PanoramaModeSettings {
            private int CaptureStep;
            private int TotalAngle;

            public PanoramaModeSettings() {
            }

            public int getTotalAngle() {
                return this.TotalAngle;
            }

            public void setTotalAngle(int i) {
                this.TotalAngle = i;
            }

            public int getCaptureStep() {
                return this.CaptureStep;
            }

            public void setCaptureStep(int i) {
                this.CaptureStep = i;
            }
        }

        public class DelayShotModeSettings {
            private int Duration;
            private int Framerate;
            private int Interval;
            private int KeepPhoto;

            public DelayShotModeSettings() {
            }

            public int getKeepPhoto() {
                return this.KeepPhoto;
            }

            public void setKeepPhoto(int i) {
                this.KeepPhoto = i;
            }

            public int getInterval() {
                return this.Interval;
            }

            public void setInterval(int i) {
                this.Interval = i;
            }

            public int getDuration() {
                return this.Duration;
            }

            public void setDuration(int i) {
                this.Duration = i;
            }

            public int getFramerate() {
                return this.Framerate;
            }

            public void setFramerate(int i) {
                this.Framerate = i;
            }
        }

        public class MotionDelayShotModeSettings {
            private int DelayMin;
            private int Framerate;
            private int Interval;
            private int RollingAngle;
            private String RollingDirection;

            public MotionDelayShotModeSettings() {
            }

            public int getDelayMin() {
                return this.DelayMin;
            }

            public void setDelayMin(int i) {
                this.DelayMin = i;
            }

            public int getRollingAngle() {
                return this.RollingAngle;
            }

            public void setRollingAngle(int i) {
                this.RollingAngle = i;
            }

            public String getRollingDirection() {
                return this.RollingDirection;
            }

            public void setRollingDirection(String str) {
                this.RollingDirection = str;
            }

            public int getInterval() {
                return this.Interval;
            }

            public void setInterval(int i) {
                this.Interval = i;
            }

            public int getFramerate() {
                return this.Framerate;
            }

            public void setFramerate(int i) {
                this.Framerate = i;
            }
        }
    }

    public class YawPitch {
        private String Direction;
        private String YawPitch;

        public YawPitch() {
        }

        public String getYawPitch() {
            return this.YawPitch;
        }

        public void setYawPitch(String str) {
            this.YawPitch = str;
        }

        public String getDirection() {
            return this.Direction;
        }

        public void setDirection(String str) {
            this.Direction = str;
        }
    }

    public static class RecordingSettings {
        private AutoSnapshot AutoSnapshot;
        private int EnableAudio;
        private int EnableSubtitle;
        private String FileFormat;
        private LoopRecordSettings LoopRecordSettings;
        private SlowMotionRecordSettings SlowMotionRecordSettings;

        public AutoSnapshot getAutoSnapshot() {
            return this.AutoSnapshot;
        }

        public void setAutoSnapshot(AutoSnapshot autoSnapshot) {
            this.AutoSnapshot = autoSnapshot;
        }

        public SlowMotionRecordSettings getSlowMotionRecordSettings() {
            return this.SlowMotionRecordSettings;
        }

        public void setSlowMotionRecordSettings(SlowMotionRecordSettings slowMotionRecordSettings) {
            this.SlowMotionRecordSettings = slowMotionRecordSettings;
        }

        public LoopRecordSettings getLoopRecordSettings() {
            return this.LoopRecordSettings;
        }

        public void setLoopRecordSettings(LoopRecordSettings loopRecordSettings) {
            this.LoopRecordSettings = loopRecordSettings;
        }

        public String getFileFormat() {
            return this.FileFormat;
        }

        public void setFileFormat(String str) {
            this.FileFormat = str;
        }

        public int getEnableAudio() {
            return this.EnableAudio;
        }

        public void setEnableAudio(int i) {
            this.EnableAudio = i;
        }

        public int getEnableSubtitle() {
            return this.EnableSubtitle;
        }

        public void setEnableSubtitle(int i) {
            this.EnableSubtitle = i;
        }

        public static class AutoSnapshot {
            private int Enable;
            private int Interval;

            public int getEnable() {
                return this.Enable;
            }

            public void setEnable(int i) {
                this.Enable = i;
            }

            public int getInterval() {
                return this.Interval;
            }

            public void setInterval(int i) {
                this.Interval = i;
            }
        }

        public class SlowMotionRecordSettings {
            private int PlaybackFramerate;
            private String Resolution;

            public SlowMotionRecordSettings() {
            }

            public int getPlaybackFramerate() {
                return this.PlaybackFramerate;
            }

            public void setPlaybackFramerate(int i) {
                this.PlaybackFramerate = i;
            }

            public String getResolution() {
                return this.Resolution;
            }

            public void setResolution(String str) {
                this.Resolution = str;
            }
        }

        public class LoopRecordSettings {
            private int MaxRecordTime;

            public LoopRecordSettings() {
            }

            public int getMaxRecordTime() {
                return this.MaxRecordTime;
            }

            public void setMaxRecordTime(int i) {
                this.MaxRecordTime = i;
            }
        }
    }

    public static class HistogramSettings {
        private int Enable;

        public int getEnable() {
            return this.Enable;
        }

        public void setEnable(int i) {
            this.Enable = i;
        }
    }

    public static class LocationMeter {

        /* renamed from: X */
        private int f8446X;

        /* renamed from: Y */
        private int f8447Y;

        public int getX() {
            return this.f8446X;
        }

        public void setX(int i) {
            this.f8446X = i;
        }

        public int getY() {
            return this.f8447Y;
        }

        public void setY(int i) {
            this.f8447Y = i;
        }
    }

    public static class ImageStyle {
        private int Brightness;
        private int Contrast;
        private int Hue;
        private int Saturation;
        private int Sharpness;
        private String Style;

        public String getStyle() {
            return this.Style;
        }

        public void setStyle(String str) {
            this.Style = str;
        }

        public int getBrightness() {
            return this.Brightness;
        }

        public void setBrightness(int i) {
            this.Brightness = i;
        }

        public int getContrast() {
            return this.Contrast;
        }

        public void setContrast(int i) {
            this.Contrast = i;
        }

        public int getSaturation() {
            return this.Saturation;
        }

        public void setSaturation(int i) {
            this.Saturation = i;
        }

        public int getHue() {
            return this.Hue;
        }

        public void setHue(int i) {
            this.Hue = i;
        }

        public int getSharpness() {
            return this.Sharpness;
        }

        public void setSharpness(int i) {
            this.Sharpness = i;
        }
    }

    public static class WhiteBalance {
        private int ColorTemperature;
        private String Mode;

        public String getMode() {
            return this.Mode;
        }

        public void setMode(String str) {
            this.Mode = str;
        }

        public int getColorTemperature() {
            return this.ColorTemperature;
        }

        public void setColorTemperature(int i) {
            this.ColorTemperature = i;
        }
    }

    public class ImageColor {
        private String Color;

        public ImageColor() {
        }

        public String getColor() {
            return this.Color;
        }

        public void setColor(String str) {
            this.Color = str;
        }
    }

    public static class ImageExposure {
        private double Exposure;

        public double getExposure() {
            return this.Exposure;
        }

        public void setExposure(double d) {
            this.Exposure = d;
        }
    }

    public static class ImageISO {
        private int ISO;

        public int getISO() {
            return this.ISO;
        }

        public void setISO(int i) {
            this.ISO = i;
        }
    }

    public class WiFiConfiguration {
        private int Band;
        private int FactoryMode;
        private String Password;
        private String SSID;

        public WiFiConfiguration() {
        }

        public String getSSID() {
            return this.SSID;
        }

        public void setSSID(String str) {
            this.SSID = str;
        }

        public String getPassword() {
            return this.Password;
        }

        public void setPassword(String str) {
            this.Password = str;
        }

        public int getBand() {
            return this.Band;
        }

        public void setBand(int i) {
            this.Band = i;
        }

        public int getFactoryMode() {
            return this.FactoryMode;
        }

        public void setFactoryMode(int i) {
            this.FactoryMode = i;
        }
    }

    public class WiFiStatus {
        private int SignalStrength;

        public WiFiStatus() {
        }

        public int getSignalStrength() {
            return this.SignalStrength;
        }

        public void setSignalStrength(int i) {
            this.SignalStrength = i;
        }
    }

    public static class AudioSourceConfiguration {
        private int CaptureTone = -1;
        private int EnableSpeaker = -1;
        private int MicVolume = -1;
        private int RecordTone = -1;
        private int SpeakerVolume = -1;

        public int getRecordTone() {
            return this.RecordTone;
        }

        public void setRecordTone(int i) {
            this.RecordTone = i;
        }

        public int getCaptureTone() {
            return this.CaptureTone;
        }

        public void setCaptureTone(int i) {
            this.CaptureTone = i;
        }

        public int getMicVolume() {
            return this.MicVolume;
        }

        public void setMicVolume(int i) {
            this.MicVolume = i;
        }

        public int getSpeakerVolume() {
            return this.SpeakerVolume;
        }

        public void setSpeakerVolume(int i) {
            this.SpeakerVolume = i;
        }

        public int getEnableSpeaker() {
            return this.EnableSpeaker;
        }

        public void setEnableSpeaker(int i) {
            this.EnableSpeaker = i;
        }
    }

    public static class CameraGear {
        private String Gear;

        public String getGear() {
            return this.Gear;
        }

        public void setGear(String str) {
            this.Gear = str;
        }
    }

    public static class AELock {
        private int Locked;

        public int getLocked() {
            return this.Locked;
        }

        public void setLocked(int i) {
            this.Locked = i;
        }
    }

    public static class ShutterSpeed {
        private String Shutter;

        public String getShutter() {
            return this.Shutter;
        }

        public void setShutter(String str) {
            this.Shutter = str;
        }
    }

    public class FileNamingMode {
        private String Mode;

        public FileNamingMode() {
        }

        public String getMode() {
            return this.Mode;
        }

        public void setMode(String str) {
            this.Mode = str;
        }
    }

    public class PanoramaStatus {
        private int CurrentStep = -1;
        private int TotalStep;

        public PanoramaStatus() {
        }

        public int getTotalStep() {
            return this.TotalStep;
        }

        public void setTotalStep(int i) {
            this.TotalStep = i;
        }

        public int getCurrentStep() {
            return this.CurrentStep;
        }

        public void setCurrentStep(int i) {
            this.CurrentStep = i;
        }
    }

    public static class Focus {
        private int AFAssistFocusEnable;
        private AFMeter AFMeter;
        private int MFAssistFocusEnable;
        private MFSpotArea MFSpotArea;
        private String Mode;
        private int ObjectDistance;

        public AFMeter getAFMeter() {
            return this.AFMeter;
        }

        public void setAFMeter(AFMeter aFMeter) {
            this.AFMeter = aFMeter;
        }

        public MFSpotArea getMFSpotArea() {
            return this.MFSpotArea;
        }

        public void setMFSpotArea(MFSpotArea mFSpotArea) {
            this.MFSpotArea = mFSpotArea;
        }

        public String getMode() {
            return this.Mode;
        }

        public void setMode(String str) {
            this.Mode = str;
        }

        public int getObjectDistance() {
            return this.ObjectDistance;
        }

        public void setObjectDistance(int i) {
            this.ObjectDistance = i;
        }

        public void setAFAssistFocusEnable(int i) {
            this.AFAssistFocusEnable = i;
        }

        public void setMFAssistFocusEnable(int i) {
            this.MFAssistFocusEnable = i;
        }

        public int getAFAssistFocusEnable() {
            return this.AFAssistFocusEnable;
        }

        public int getMFAssistFocusEnable() {
            return this.MFAssistFocusEnable;
        }

        public static class AFMeter {
            private String Mode;
            private List<SpotArea> SpotArea;

            public List<SpotArea> getSpotArea() {
                return this.SpotArea;
            }

            public void setSpotArea(List<SpotArea> list) {
                this.SpotArea = list;
            }

            public String getMode() {
                return this.Mode;
            }

            public void setMode(String str) {
                this.Mode = str;
            }

            public static class SpotArea {

                /* renamed from: X */
                private int f8442X;

                /* renamed from: Y */
                private int f8443Y;

                public int getX() {
                    return this.f8442X;
                }

                public void setX(int i) {
                    this.f8442X = i;
                }

                public int getY() {
                    return this.f8443Y;
                }

                public void setY(int i) {
                    this.f8443Y = i;
                }
            }
        }

        public static class MFSpotArea {

            /* renamed from: X */
            private int f8444X;

            /* renamed from: Y */
            private int f8445Y;

            public int getX() {
                return this.f8444X;
            }

            public void setX(int i) {
                this.f8444X = i;
            }

            public int getY() {
                return this.f8445Y;
            }

            public void setY(int i) {
                this.f8445Y = i;
            }
        }
    }

    public static class IRIS {
        private double IrisValue;

        public double getIrisValue() {
            return this.IrisValue;
        }

        public void setIrisValue(double d) {
            this.IrisValue = d;
        }
    }

    public static class ZoomFactor {
        private int ZoomValue;

        public int getZoomValue() {
            return this.ZoomValue;
        }

        public void setZoomValue(int i) {
            this.ZoomValue = i;
        }
    }

    public static class ShutterMode {
        private String Type;

        public String getType() {
            return this.Type;
        }

        public void setType(String str) {
            this.Type = str;
        }
    }

    public static class VideoEncoderConfiguration {
        private int Bitrate = -1;
        private String BitrateType;
        private String Encoding;
        private int GovLength = -1;
        private String Profile;
        private int Quality = -1;
        private String Resolution;

        public String getEncoding() {
            return this.Encoding;
        }

        public void setEncoding(String str) {
            this.Encoding = str;
        }

        public String getResolution() {
            return this.Resolution;
        }

        public void setResolution(String str) {
            this.Resolution = str;
        }

        public int getQuality() {
            return this.Quality;
        }

        public void setQuality(int i) {
            this.Quality = i;
        }

        public int getGovLength() {
            return this.GovLength;
        }

        public void setGovLength(int i) {
            this.GovLength = i;
        }

        public String getProfile() {
            return this.Profile;
        }

        public void setProfile(String str) {
            this.Profile = str;
        }

        public String getBitrateType() {
            return this.BitrateType;
        }

        public void setBitrateType(String str) {
            this.BitrateType = str;
        }

        public int getBitrate() {
            return this.Bitrate;
        }

        public void setBitrate(int i) {
            this.Bitrate = i;
        }
    }

    public static class DisplayMode {
        private String Mode;

        public void setMode(String str) {
        }

        public String getMode() {
            return this.Mode;
        }
    }

    public static class IrColor {
        private String Color;

        public void setColor(String str) {
        }

        public String getColor() {
            return this.Color;
        }
    }

    public static class IrPosition {
        private int DeltaX;
        private int DeltaY;

        public int getDeltaX() {
            return this.DeltaX;
        }

        public void setDeltaX(int i) {
            this.DeltaX = i;
        }

        public int getDeltaY() {
            return this.DeltaY;
        }

        public void setDeltaY(int i) {
            this.DeltaY = i;
        }
    }

    public static class HDRSetting {
        private String Status;

        public String getValue() {
            return this.Status;
        }

        public void setValue(String str) {
            this.Status = str;
        }
    }

    public static class IsoModeInfo {
        private String Mode;

        public String getMode() {
            return this.Mode;
        }

        public void setMode(String str) {
            this.Mode = str;
        }
    }
}
