package com.autel.bean.camera;

import com.autel.internal.sdk.camera.flir.FLIRSkyCondition;
import com.autel.internal.sdk.camera.flir.TemperatureUnit;
import java.util.List;

public class FlirCameraAllSettings {
    private CameraMode CameraMode;
    private DeviceInformation DeviceInformation;
    private DisplayMode DisplayMode;
    private IRColorPalette IRColorPalette;
    private MSXSettings MSXSettings;
    private PhotoTakingSettings PhotoTakingSettings;
    private PictureInVideoStatus PictureInVideoStatus;
    private PipPosition PipPosition;
    private RadiometrySettings RadiometrySettings;
    private RecordingSettings RecordingSettings;
    private SDCardStatus SDCardStatus;
    private SystemDateAndTime SystemDateAndTime;
    private SystemStatus SystemStatus;

    public PipPosition getPipPosition() {
        return this.PipPosition;
    }

    public void setPipPosition(PipPosition pipPosition) {
        this.PipPosition = pipPosition;
    }

    public RadiometrySettings getRadiometrySettings() {
        return this.RadiometrySettings;
    }

    public void setRadiometrySettings(RadiometrySettings radiometrySettings) {
        this.RadiometrySettings = radiometrySettings;
    }

    public DisplayMode getDisplayMode() {
        return this.DisplayMode;
    }

    public void setDisplayMode(DisplayMode displayMode) {
        this.DisplayMode = displayMode;
    }

    public IRColorPalette getIRColorPalette() {
        return this.IRColorPalette;
    }

    public void setIRColorPalette(IRColorPalette iRColorPalette) {
        this.IRColorPalette = iRColorPalette;
    }

    public MSXSettings getMSXSettings() {
        return this.MSXSettings;
    }

    public void setMSXSettings(MSXSettings mSXSettings) {
        this.MSXSettings = mSXSettings;
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

    public RecordingSettings getRecordingSettings() {
        return this.RecordingSettings;
    }

    public void setRecordingSettings(RecordingSettings recordingSettings) {
        this.RecordingSettings = recordingSettings;
    }

    public class DeviceInformation {
        private String DeviceModel;
        private String DeviceType;
        private String FirmwareVersion;
        private String HardwareId;
        private String LensSoftVersion;
        private String Manufacturer;
        private int ProtocolVersion;
        private String SerialNumber;

        public DeviceInformation() {
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

    public class SystemStatus {
        private int BatteryLevel;
        private String CurrentMode;
        private String PrevPhotoTakingMode;
        private String PrevRecordMode;
        private String SystemStatus;
        private int Temperature;

        public SystemStatus() {
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

    public class SDCardStatus {
        private String CardStatus;
        private long CurrentRecordTime;
        private long FreeSpace;
        private int RemainCaptureNum;
        private int RemainRecordTime;
        private long TotalSpace;

        public SDCardStatus() {
        }

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

    public class VideoSourceConfiguration {
        private String AntiFlicker;
        private double ApertureValue;
        private int Enable3DNR;
        private double FocalLength;
        private int Rotation;
        private String VideoStandard;

        public VideoSourceConfiguration() {
        }

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

        public double getApertureValue() {
            return this.ApertureValue;
        }

        public void setApertureValue(double d) {
            this.ApertureValue = d;
        }

        public double getFocalLength() {
            return this.FocalLength;
        }

        public void setFocalLength(double d) {
            this.FocalLength = d;
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
        private String PicType;
        private TimelapseModeSettings TimelapseModeSettings;

        public TimelapseModeSettings getTimelapseModeSettings() {
            return this.TimelapseModeSettings;
        }

        public void setTimelapseModeSettings(TimelapseModeSettings timelapseModeSettings) {
            this.TimelapseModeSettings = timelapseModeSettings;
        }

        public String getPicType() {
            return this.PicType;
        }

        public void setPicType(String str) {
            this.PicType = str;
        }

        public static class TimelapseModeSettings {
            private int Duration;
            private int Interval;

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
        private String FileFormat;
        private String RecordedVideo;

        public String getFileFormat() {
            return this.FileFormat;
        }

        public void setFileFormat(String str) {
            this.FileFormat = str;
        }

        public String getRecordedVideo() {
            return this.RecordedVideo;
        }

        public void setRecordedVideo(String str) {
            this.RecordedVideo = str;
        }
    }

    public class HistogramSettings {
        private int Enable;

        public HistogramSettings() {
        }

        public int getEnable() {
            return this.Enable;
        }

        public void setEnable(int i) {
            this.Enable = i;
        }
    }

    public static class LocationMeter {

        /* renamed from: X */
        private int f8450X;

        /* renamed from: Y */
        private int f8451Y;

        public int getX() {
            return this.f8450X;
        }

        public void setX(int i) {
            this.f8450X = i;
        }

        public int getY() {
            return this.f8451Y;
        }

        public void setY(int i) {
            this.f8451Y = i;
        }
    }

    public class ImageStyle {
        private int Brightness;
        private int Contrast;
        private int Hue;
        private int Saturation;
        private int Sharpness;
        private String Style;

        public ImageStyle() {
        }

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

    public class AudioSourceConfiguration {
        private int CaptureTone = -1;
        private int EnableSpeaker = -1;
        private int MicVolume = -1;
        private int RecordTone = -1;
        private int SpeakerVolume = -1;

        public AudioSourceConfiguration() {
        }

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

    public class CameraGear {
        private String Gear;

        public CameraGear() {
        }

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

    public class Focus {
        private AFMeter AFMeter;
        private String Mode;
        private int ObjectDistance;

        public Focus() {
        }

        public AFMeter getAFMeter() {
            return this.AFMeter;
        }

        public void setAFMeter(AFMeter aFMeter) {
            this.AFMeter = aFMeter;
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

        public class AFMeter {
            private String Mode;
            private List<SpotArea> SpotArea;

            public AFMeter() {
            }

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

            public class SpotArea {

                /* renamed from: X */
                private int f8448X;

                /* renamed from: Y */
                private int f8449Y;

                public SpotArea() {
                }

                public int getX() {
                    return this.f8448X;
                }

                public void setX(int i) {
                    this.f8448X = i;
                }

                public int getY() {
                    return this.f8449Y;
                }

                public void setY(int i) {
                    this.f8449Y = i;
                }
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

    public class ZoomFactor {
        private int ZoomValue;

        public ZoomFactor() {
        }

        public int getZoomValue() {
            return this.ZoomValue;
        }

        public void setZoomValue(int i) {
            this.ZoomValue = i;
        }
    }

    public class VideoEncoderConfiguration {
        private String Bitrate;
        private String BitrateType;
        private String Encoding;
        private String GovLength;
        private String Profile;
        private String Quality;
        private String Resolution;

        public VideoEncoderConfiguration() {
        }

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

        public String getQuality() {
            return this.Quality;
        }

        public void setQuality(String str) {
            this.Quality = str;
        }

        public String getGovLength() {
            return this.GovLength;
        }

        public void setGovLength(String str) {
            this.GovLength = str;
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

        public String getBitrate() {
            return this.Bitrate;
        }

        public void setBitrate(String str) {
            this.Bitrate = str;
        }
    }

    public static class DisplayMode {
        private String DisplayMode;

        public String getDisplayMode() {
            return this.DisplayMode;
        }

        public void setDisplayMode(String str) {
            this.DisplayMode = str;
        }
    }

    public static class IRColorPalette {
        private String IRColorPalette;

        public String getIRColorPalette() {
            return this.IRColorPalette;
        }

        public void setIRColorPalette(String str) {
            this.IRColorPalette = str;
        }
    }

    public static class MSXSettings {
        private int Enable;
        private int PosX;
        private int PosY;
        private int Strength;

        public int getEnable() {
            return this.Enable;
        }

        public void setEnable(int i) {
            this.Enable = i;
        }

        public int getStrength() {
            return this.Strength;
        }

        public void setStrength(int i) {
            this.Strength = i;
        }

        public int getPosX() {
            return this.PosX;
        }

        public void setPosX(int i) {
            this.PosX = i;
        }

        public int getPosY() {
            return this.PosY;
        }

        public void setPosY(int i) {
            this.PosY = i;
        }
    }

    public static class RadiometrySettings {
        int AirTemp = -100;
        int Emissivity = -100;
        int Humidity = -1;
        String SkyCond = FLIRSkyCondition.UNKNOWN.getValue();
        int SpotMeter = -1;
        int SubjectDistance = -1;
        String TempUnit = TemperatureUnit.UNKNOWN.getValue();

        public String getTempUnit() {
            return this.TempUnit;
        }

        public void setTempUnit(String str) {
            this.TempUnit = str;
        }

        public String getSkyCond() {
            return this.SkyCond;
        }

        public void setSkyCond(String str) {
            this.SkyCond = str;
        }

        public int getSpotMeter() {
            return this.SpotMeter;
        }

        public void setSpotMeter(int i) {
            this.SpotMeter = i;
        }

        public int getEmissivity() {
            return this.Emissivity;
        }

        public void setEmissivity(int i) {
            this.Emissivity = i;
        }

        public int getAirTemp() {
            return this.AirTemp;
        }

        public void setAirTemp(int i) {
            this.AirTemp = i;
        }

        public int getHumidity() {
            return this.Humidity;
        }

        public void setHumidity(int i) {
            this.Humidity = i;
        }

        public int getSubjectDistance() {
            return this.SubjectDistance;
        }

        public void setSubjectDistance(int i) {
            this.SubjectDistance = i;
        }
    }

    public static class PipPosition {
        private String Position;

        public String getPosition() {
            return this.Position;
        }

        public void setPosition(String str) {
            this.Position = str;
        }
    }
}
