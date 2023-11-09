package com.atakmap.android.atakgo.dji;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.atakmap.android.atakgo.dji.ITelemListener;
import com.atakmap.android.uastool.generic.IAircraftItem;
import com.atakmap.android.uastool.pagers.video_ui.default_ui.ThermalData;
import com.atakmap.android.uastool.tasks.route.UASRoute;
import java.util.ArrayList;
import java.util.List;

public interface IDjiAtakInterface extends IInterface {

    public static class Default implements IDjiAtakInterface {
        public void actionCustom(String str, String str2) {
        }

        public boolean areMotorsOn() {
            return false;
        }

        public IBinder asBinder() {
            return null;
        }

        public void checkOnboardSdkAvailable() {
        }

        public void checkUsbForPlatform() {
        }

        public void deleteSound(String str) {
        }

        public boolean enableLDM(boolean z) {
            return false;
        }

        public void formatInternalStart() {
        }

        public void formatSDCardStart() {
        }

        public String getAccelCalibStatus() {
            return null;
        }

        public String getAccelState() {
            return null;
        }

        public boolean getActiveAvoid() {
            return false;
        }

        public IAircraftItem getAircraftItem() {
            return null;
        }

        public boolean getCanZoom() {
            return false;
        }

        public boolean getCollAvoid() {
            return false;
        }

        public String getCompassCalibStatus() {
            return null;
        }

        public String getCompassState() {
            return null;
        }

        public String getConnLossBehav() {
            return null;
        }

        public String[] getCotMessages() {
            return null;
        }

        public String getFileListState() {
            return null;
        }

        public String getGimbalCalibStatus() {
            return null;
        }

        public String getGimbalMode() {
            return null;
        }

        public int getGoHomeAlt() {
            return 0;
        }

        public int getGoHomeBattPct() {
            return 0;
        }

        public String getGyroCalibStatus() {
            return null;
        }

        public String getGyroState() {
            return null;
        }

        public int getInterfaceVersionNumber() {
            return 0;
        }

        public boolean getLDMSupported() {
            return false;
        }

        public int getLandNowBattPct() {
            return 0;
        }

        public boolean getLandProt() {
            return false;
        }

        public String getLightBridgeChannelMode() {
            return null;
        }

        public int getLightBridgeChannelNumber() {
            return 0;
        }

        public int[] getLightBridgeChannelNumberRange() {
            return null;
        }

        public String getLightBridgeDataRate() {
            return null;
        }

        public String getLightBridgeFrequencyBand() {
            return null;
        }

        public String[] getLightBridgeFrequencyBands() {
            return null;
        }

        public String getLightBridgeTransmissionMode() {
            return null;
        }

        public List<String> getLoadedSoundNames() {
            return null;
        }

        public int getMSXLevel() {
            return 0;
        }

        public int getMaxAltitude() {
            return 0;
        }

        public int getMaxDistance() {
            return 0;
        }

        public float getMaxVideoDataRate() {
            return 0.0f;
        }

        public float getMinVideoDataRate() {
            return 0.0f;
        }

        public int getNumCameras() {
            return 0;
        }

        public String getOcuSyncChannelBandwidth() {
            return null;
        }

        public String[] getOcuSyncChannelBandwidths() {
            return null;
        }

        public String getOcuSyncChannelMode() {
            return null;
        }

        public int getOcuSyncChannelNumber() {
            return 0;
        }

        public int[] getOcuSyncChannelNumberRange() {
            return null;
        }

        public String getOcuSyncFrequencyBand() {
            return null;
        }

        public String[] getOcuSyncFrequencyBands() {
            return null;
        }

        public String getPlayMode() {
            return null;
        }

        public boolean getPrecLand() {
            return false;
        }

        public int getRcMode() {
            return 0;
        }

        public String getResFPS() {
            return null;
        }

        public List<String> getResFPSList() {
            return null;
        }

        public boolean getRestrictLandingGear() {
            return false;
        }

        public int getSpeakerVolume() {
            return 0;
        }

        public String getThermalGain() {
            return null;
        }

        public boolean getThermalIsoEnabled() {
            return false;
        }

        public int getThermalIsoTempHigh() {
            return 0;
        }

        public int getThermalIsoTempLow() {
            return 0;
        }

        public int getThermalIsoTempMax() {
            return 0;
        }

        public int getThermalIsoTempMid() {
            return 0;
        }

        public int getThermalIsoTempMin() {
            return 0;
        }

        public String getThermalIsoTempUnits() {
            return null;
        }

        public ThermalData getThermalMeterData(String str) {
            return null;
        }

        public boolean getThermalMetering() {
            return false;
        }

        public String getThermalPalette() {
            return null;
        }

        public String getThermalROI() {
            return null;
        }

        public String getThermalScene() {
            return null;
        }

        public float getVideoDataRate() {
            return 0.0f;
        }

        public boolean getVisionPos() {
            return false;
        }

        public String getWiFiChannelMode() {
            return null;
        }

        public int getWiFiChannelNumber() {
            return 0;
        }

        public int[] getWiFiChannelNumbers() {
            return null;
        }

        public String getWiFiDataRate() {
            return null;
        }

        public String getWiFiFrequencyBand() {
            return null;
        }

        public String getWiFiPassword() {
            return null;
        }

        public String getWiFiSSID() {
            return null;
        }

        public float getZoomLevel() {
            return 0.0f;
        }

        public float getZoomMax() {
            return 0.0f;
        }

        public float getZoomMin() {
            return 0.0f;
        }

        public boolean hasAuxLightBottom() {
            return false;
        }

        public boolean hasAuxLightTop() {
            return false;
        }

        public boolean hasBeacon() {
            return false;
        }

        public boolean hasLandingGear() {
            return false;
        }

        public boolean hasLightBridge() {
            return false;
        }

        public boolean hasOcuSync() {
            return false;
        }

        public boolean hasSpeaker() {
            return false;
        }

        public boolean hasSpotlight() {
            return false;
        }

        public boolean hasThermalCamera() {
            return false;
        }

        public boolean hasWiFi() {
            return false;
        }

        public void initPwmSettings(int i, int i2) {
        }

        public boolean isFlying() {
            return false;
        }

        public boolean isLDMEnabled() {
            return false;
        }

        public boolean isLDMSupported() {
            return false;
        }

        public boolean isPermissionsAccepted() {
            return false;
        }

        public boolean isSoundPlaying() {
            return false;
        }

        public void joystickPosition(float f, float f2, float f3, float f4) {
        }

        public void loadSound(String str) {
        }

        public void lookAtPoint(double d, double d2, double d3, double d4, double d5, double d6) {
        }

        public void pauseTask_aidl() {
        }

        public void pitchGimbal(double d) {
        }

        public void playSound(String str) {
        }

        public void quickAltitude_aidl(int i) {
        }

        public void quickLanding_aidl() {
        }

        public void quickRTH_aidl() {
        }

        public void quickStop_aidl() {
        }

        public void quickTakeoff_aidl(int i) {
        }

        public void refreshSoundList() {
        }

        public void register() {
        }

        public void registerListener(ITelemListener iTelemListener) {
        }

        public void resetGimbal() {
        }

        public void resumeTask_aidl() {
        }

        public void runRouteTask_aidl(UASRoute uASRoute) {
        }

        public String setActiveAvoid(boolean z) {
            return null;
        }

        public void setCallsign(String str) {
        }

        public String setCollAvoid(boolean z) {
            return null;
        }

        public String setConnLossBehav(String str) {
            return null;
        }

        public void setCurrentSound(String str) {
        }

        public String setGoHomeAlt(int i) {
            return null;
        }

        public String setGoHomeBattPct(int i) {
            return null;
        }

        public String setLandNowBattPct(int i) {
            return null;
        }

        public String setLandProt(boolean z) {
            return null;
        }

        public String setLightBridgeChannelMode(String str) {
            return null;
        }

        public String setLightBridgeChannelNumber(int i) {
            return null;
        }

        public String setLightBridgeDataRate(String str) {
            return null;
        }

        public String setLightBridgeFrequencyBand(String str) {
            return null;
        }

        public String setLightBridgeTransmissionMode(String str) {
            return null;
        }

        public int setMSXLevel(int i) {
            return 0;
        }

        public String setMaxAltitude(int i) {
            return null;
        }

        public String setMaxDistance(int i) {
            return null;
        }

        public String setOcuSyncChannelBandwidth(String str) {
            return null;
        }

        public String setOcuSyncChannelMode(String str) {
            return null;
        }

        public String setOcuSyncChannelNumber(int i) {
            return null;
        }

        public String setOcuSyncFrequencyBand(String str) {
            return null;
        }

        public void setPlatformActivated(boolean z) {
        }

        public void setPlayMode(String str) {
        }

        public String setPrecLand(boolean z) {
            return null;
        }

        public void setPwm(int i, int i2) {
        }

        public void setRcMode(int i) {
        }

        public String setResFPS(String str) {
            return null;
        }

        public boolean setRestrictLandingGear(boolean z) {
            return false;
        }

        public void setSpeakerVolume(int i, boolean z) {
        }

        public void setThermalGain(String str) {
        }

        public boolean setThermalIsoEnabled(boolean z) {
            return false;
        }

        public int setThermalIsoTempHigh(int i) {
            return 0;
        }

        public int setThermalIsoTempLow(int i) {
            return 0;
        }

        public int setThermalIsoTempMid(int i) {
            return 0;
        }

        public void setThermalPalette(String str) {
        }

        public void setThermalROI(String str) {
        }

        public void setThermalScene(String str) {
        }

        public void setVideoDataRate(float f) {
        }

        public boolean setVirtualStickMode(boolean z) {
            return false;
        }

        public String setVisionPos(boolean z) {
            return null;
        }

        public String setWiFiChannelMode(String str) {
            return null;
        }

        public String setWiFiChannelNumber(int i) {
            return null;
        }

        public String setWiFiDataRate(String str) {
            return null;
        }

        public String setWiFiFrequencyBand(String str) {
            return null;
        }

        public String setWiFiPassword(String str) {
            return null;
        }

        public String setWiFiSSID(String str) {
            return null;
        }

        public void spotlightBrightness(int i) {
        }

        public void startAccelCalib() {
        }

        public void startBroadcasting(String str, boolean z, boolean z2, String str2, int i, String str3, String str4, String str5, long j, String str6, int i2) {
        }

        public void startCompassCalib() {
        }

        public void startCot(String str, String str2) {
        }

        public void startGimbalCalib() {
        }

        public void startGyroCalib() {
        }

        public void startRCPairing() {
        }

        public void stopAtakGo() {
        }

        public void stopBroadcasting() {
        }

        public void stopCompassCalib() {
        }

        public void stopCot() {
        }

        public void stopRCPairing() {
        }

        public void stopSound() {
        }

        public void stopTask_aidl() {
        }

        public void switchToNextCamera() {
        }

        public void takeCameraPicture(String str, String str2, String str3) {
        }

        public void toggleAuxLightBottom() {
        }

        public void toggleAuxLightTop() {
        }

        public void toggleLEDs() {
        }

        public void toggleLight() {
        }

        public void toggleThermal() {
        }

        public boolean toggleThermalMetering() {
            return false;
        }

        public void turnOnThermalMetering() {
        }

        public void unlockPlatform() {
        }

        public boolean usesYUV() {
            return false;
        }

        public void yawGimbal(double d) {
        }

        public void zoomIn() {
        }

        public void zoomOut() {
        }
    }

    void actionCustom(String str, String str2);

    boolean areMotorsOn();

    void checkOnboardSdkAvailable();

    void checkUsbForPlatform();

    void deleteSound(String str);

    boolean enableLDM(boolean z);

    void formatInternalStart();

    void formatSDCardStart();

    String getAccelCalibStatus();

    String getAccelState();

    boolean getActiveAvoid();

    IAircraftItem getAircraftItem();

    boolean getCanZoom();

    boolean getCollAvoid();

    String getCompassCalibStatus();

    String getCompassState();

    String getConnLossBehav();

    String[] getCotMessages();

    String getFileListState();

    String getGimbalCalibStatus();

    String getGimbalMode();

    int getGoHomeAlt();

    int getGoHomeBattPct();

    String getGyroCalibStatus();

    String getGyroState();

    int getInterfaceVersionNumber();

    boolean getLDMSupported();

    int getLandNowBattPct();

    boolean getLandProt();

    String getLightBridgeChannelMode();

    int getLightBridgeChannelNumber();

    int[] getLightBridgeChannelNumberRange();

    String getLightBridgeDataRate();

    String getLightBridgeFrequencyBand();

    String[] getLightBridgeFrequencyBands();

    String getLightBridgeTransmissionMode();

    List<String> getLoadedSoundNames();

    int getMSXLevel();

    int getMaxAltitude();

    int getMaxDistance();

    float getMaxVideoDataRate();

    float getMinVideoDataRate();

    int getNumCameras();

    String getOcuSyncChannelBandwidth();

    String[] getOcuSyncChannelBandwidths();

    String getOcuSyncChannelMode();

    int getOcuSyncChannelNumber();

    int[] getOcuSyncChannelNumberRange();

    String getOcuSyncFrequencyBand();

    String[] getOcuSyncFrequencyBands();

    String getPlayMode();

    boolean getPrecLand();

    int getRcMode();

    String getResFPS();

    List<String> getResFPSList();

    boolean getRestrictLandingGear();

    int getSpeakerVolume();

    String getThermalGain();

    boolean getThermalIsoEnabled();

    int getThermalIsoTempHigh();

    int getThermalIsoTempLow();

    int getThermalIsoTempMax();

    int getThermalIsoTempMid();

    int getThermalIsoTempMin();

    String getThermalIsoTempUnits();

    ThermalData getThermalMeterData(String str);

    boolean getThermalMetering();

    String getThermalPalette();

    String getThermalROI();

    String getThermalScene();

    float getVideoDataRate();

    boolean getVisionPos();

    String getWiFiChannelMode();

    int getWiFiChannelNumber();

    int[] getWiFiChannelNumbers();

    String getWiFiDataRate();

    String getWiFiFrequencyBand();

    String getWiFiPassword();

    String getWiFiSSID();

    float getZoomLevel();

    float getZoomMax();

    float getZoomMin();

    boolean hasAuxLightBottom();

    boolean hasAuxLightTop();

    boolean hasBeacon();

    boolean hasLandingGear();

    boolean hasLightBridge();

    boolean hasOcuSync();

    boolean hasSpeaker();

    boolean hasSpotlight();

    boolean hasThermalCamera();

    boolean hasWiFi();

    void initPwmSettings(int i, int i2);

    boolean isFlying();

    boolean isLDMEnabled();

    boolean isLDMSupported();

    boolean isPermissionsAccepted();

    boolean isSoundPlaying();

    void joystickPosition(float f, float f2, float f3, float f4);

    void loadSound(String str);

    void lookAtPoint(double d, double d2, double d3, double d4, double d5, double d6);

    void pauseTask_aidl();

    void pitchGimbal(double d);

    void playSound(String str);

    void quickAltitude_aidl(int i);

    void quickLanding_aidl();

    void quickRTH_aidl();

    void quickStop_aidl();

    void quickTakeoff_aidl(int i);

    void refreshSoundList();

    void register();

    void registerListener(ITelemListener iTelemListener);

    void resetGimbal();

    void resumeTask_aidl();

    void runRouteTask_aidl(UASRoute uASRoute);

    String setActiveAvoid(boolean z);

    void setCallsign(String str);

    String setCollAvoid(boolean z);

    String setConnLossBehav(String str);

    void setCurrentSound(String str);

    String setGoHomeAlt(int i);

    String setGoHomeBattPct(int i);

    String setLandNowBattPct(int i);

    String setLandProt(boolean z);

    String setLightBridgeChannelMode(String str);

    String setLightBridgeChannelNumber(int i);

    String setLightBridgeDataRate(String str);

    String setLightBridgeFrequencyBand(String str);

    String setLightBridgeTransmissionMode(String str);

    int setMSXLevel(int i);

    String setMaxAltitude(int i);

    String setMaxDistance(int i);

    String setOcuSyncChannelBandwidth(String str);

    String setOcuSyncChannelMode(String str);

    String setOcuSyncChannelNumber(int i);

    String setOcuSyncFrequencyBand(String str);

    void setPlatformActivated(boolean z);

    void setPlayMode(String str);

    String setPrecLand(boolean z);

    void setPwm(int i, int i2);

    void setRcMode(int i);

    String setResFPS(String str);

    boolean setRestrictLandingGear(boolean z);

    void setSpeakerVolume(int i, boolean z);

    void setThermalGain(String str);

    boolean setThermalIsoEnabled(boolean z);

    int setThermalIsoTempHigh(int i);

    int setThermalIsoTempLow(int i);

    int setThermalIsoTempMid(int i);

    void setThermalPalette(String str);

    void setThermalROI(String str);

    void setThermalScene(String str);

    void setVideoDataRate(float f);

    boolean setVirtualStickMode(boolean z);

    String setVisionPos(boolean z);

    String setWiFiChannelMode(String str);

    String setWiFiChannelNumber(int i);

    String setWiFiDataRate(String str);

    String setWiFiFrequencyBand(String str);

    String setWiFiPassword(String str);

    String setWiFiSSID(String str);

    void spotlightBrightness(int i);

    void startAccelCalib();

    void startBroadcasting(String str, boolean z, boolean z2, String str2, int i, String str3, String str4, String str5, long j, String str6, int i2);

    void startCompassCalib();

    void startCot(String str, String str2);

    void startGimbalCalib();

    void startGyroCalib();

    void startRCPairing();

    void stopAtakGo();

    void stopBroadcasting();

    void stopCompassCalib();

    void stopCot();

    void stopRCPairing();

    void stopSound();

    void stopTask_aidl();

    void switchToNextCamera();

    void takeCameraPicture(String str, String str2, String str3);

    void toggleAuxLightBottom();

    void toggleAuxLightTop();

    void toggleLEDs();

    void toggleLight();

    void toggleThermal();

    boolean toggleThermalMetering();

    void turnOnThermalMetering();

    void unlockPlatform();

    boolean usesYUV();

    void yawGimbal(double d);

    void zoomIn();

    void zoomOut();

    public static abstract class Stub extends Binder implements IDjiAtakInterface {
        private static final String DESCRIPTOR = "com.atakmap.android.atakgo.dji.IDjiAtakInterface";
        static final int TRANSACTION_actionCustom = 19;
        static final int TRANSACTION_areMotorsOn = 14;
        static final int TRANSACTION_checkOnboardSdkAvailable = 190;
        static final int TRANSACTION_checkUsbForPlatform = 7;
        static final int TRANSACTION_deleteSound = 64;
        static final int TRANSACTION_enableLDM = 183;
        static final int TRANSACTION_formatInternalStart = 176;
        static final int TRANSACTION_formatSDCardStart = 175;
        static final int TRANSACTION_getAccelCalibStatus = 100;
        static final int TRANSACTION_getAccelState = 98;
        static final int TRANSACTION_getActiveAvoid = 126;
        static final int TRANSACTION_getAircraftItem = 12;
        static final int TRANSACTION_getCanZoom = 36;
        static final int TRANSACTION_getCollAvoid = 124;
        static final int TRANSACTION_getCompassCalibStatus = 107;
        static final int TRANSACTION_getCompassState = 104;
        static final int TRANSACTION_getConnLossBehav = 122;
        static final int TRANSACTION_getCotMessages = 11;
        static final int TRANSACTION_getFileListState = 56;
        static final int TRANSACTION_getGimbalCalibStatus = 110;
        static final int TRANSACTION_getGimbalMode = 108;
        static final int TRANSACTION_getGoHomeAlt = 118;
        static final int TRANSACTION_getGoHomeBattPct = 116;
        static final int TRANSACTION_getGyroCalibStatus = 103;
        static final int TRANSACTION_getGyroState = 101;
        static final int TRANSACTION_getInterfaceVersionNumber = 1;
        static final int TRANSACTION_getLDMSupported = 181;
        static final int TRANSACTION_getLandNowBattPct = 120;
        static final int TRANSACTION_getLandProt = 132;
        static final int TRANSACTION_getLightBridgeChannelMode = 160;
        static final int TRANSACTION_getLightBridgeChannelNumber = 162;
        static final int TRANSACTION_getLightBridgeChannelNumberRange = 163;
        static final int TRANSACTION_getLightBridgeDataRate = 165;
        static final int TRANSACTION_getLightBridgeFrequencyBand = 169;
        static final int TRANSACTION_getLightBridgeFrequencyBands = 170;
        static final int TRANSACTION_getLightBridgeTransmissionMode = 167;
        static final int TRANSACTION_getLoadedSoundNames = 58;
        static final int TRANSACTION_getMSXLevel = 93;
        static final int TRANSACTION_getMaxAltitude = 111;
        static final int TRANSACTION_getMaxDistance = 113;
        static final int TRANSACTION_getMaxVideoDataRate = 45;
        static final int TRANSACTION_getMinVideoDataRate = 44;
        static final int TRANSACTION_getNumCameras = 34;
        static final int TRANSACTION_getOcuSyncChannelBandwidth = 150;
        static final int TRANSACTION_getOcuSyncChannelBandwidths = 151;
        static final int TRANSACTION_getOcuSyncChannelMode = 148;
        static final int TRANSACTION_getOcuSyncChannelNumber = 153;
        static final int TRANSACTION_getOcuSyncChannelNumberRange = 154;
        static final int TRANSACTION_getOcuSyncFrequencyBand = 156;
        static final int TRANSACTION_getOcuSyncFrequencyBands = 157;
        static final int TRANSACTION_getPlayMode = 65;
        static final int TRANSACTION_getPrecLand = 130;
        static final int TRANSACTION_getRcMode = 32;
        static final int TRANSACTION_getResFPS = 174;
        static final int TRANSACTION_getResFPSList = 172;
        static final int TRANSACTION_getRestrictLandingGear = 184;
        static final int TRANSACTION_getSpeakerVolume = 67;
        static final int TRANSACTION_getThermalGain = 75;
        static final int TRANSACTION_getThermalIsoEnabled = 82;
        static final int TRANSACTION_getThermalIsoTempHigh = 85;
        static final int TRANSACTION_getThermalIsoTempLow = 83;
        static final int TRANSACTION_getThermalIsoTempMax = 81;
        static final int TRANSACTION_getThermalIsoTempMid = 84;
        static final int TRANSACTION_getThermalIsoTempMin = 80;
        static final int TRANSACTION_getThermalIsoTempUnits = 79;
        static final int TRANSACTION_getThermalMeterData = 92;
        static final int TRANSACTION_getThermalMetering = 90;
        static final int TRANSACTION_getThermalPalette = 71;
        static final int TRANSACTION_getThermalROI = 77;
        static final int TRANSACTION_getThermalScene = 73;
        static final int TRANSACTION_getVideoDataRate = 42;
        static final int TRANSACTION_getVisionPos = 128;
        static final int TRANSACTION_getWiFiChannelMode = 140;
        static final int TRANSACTION_getWiFiChannelNumber = 142;
        static final int TRANSACTION_getWiFiChannelNumbers = 143;
        static final int TRANSACTION_getWiFiDataRate = 145;
        static final int TRANSACTION_getWiFiFrequencyBand = 138;
        static final int TRANSACTION_getWiFiPassword = 136;
        static final int TRANSACTION_getWiFiSSID = 134;
        static final int TRANSACTION_getZoomLevel = 39;
        static final int TRANSACTION_getZoomMax = 38;
        static final int TRANSACTION_getZoomMin = 37;
        static final int TRANSACTION_hasAuxLightBottom = 52;
        static final int TRANSACTION_hasAuxLightTop = 51;
        static final int TRANSACTION_hasBeacon = 50;
        static final int TRANSACTION_hasLandingGear = 185;
        static final int TRANSACTION_hasLightBridge = 159;
        static final int TRANSACTION_hasOcuSync = 147;
        static final int TRANSACTION_hasSpeaker = 55;
        static final int TRANSACTION_hasSpotlight = 48;
        static final int TRANSACTION_hasThermalCamera = 69;
        static final int TRANSACTION_hasWiFi = 133;
        static final int TRANSACTION_initPwmSettings = 188;
        static final int TRANSACTION_isFlying = 13;
        static final int TRANSACTION_isLDMEnabled = 182;
        static final int TRANSACTION_isLDMSupported = 180;
        static final int TRANSACTION_isPermissionsAccepted = 31;
        static final int TRANSACTION_isSoundPlaying = 59;
        static final int TRANSACTION_joystickPosition = 178;
        static final int TRANSACTION_loadSound = 60;
        static final int TRANSACTION_lookAtPoint = 3;
        static final int TRANSACTION_pauseTask_aidl = 23;
        static final int TRANSACTION_pitchGimbal = 5;
        static final int TRANSACTION_playSound = 61;
        static final int TRANSACTION_quickAltitude_aidl = 30;
        static final int TRANSACTION_quickLanding_aidl = 27;
        static final int TRANSACTION_quickRTH_aidl = 29;
        static final int TRANSACTION_quickStop_aidl = 28;
        static final int TRANSACTION_quickTakeoff_aidl = 26;
        static final int TRANSACTION_refreshSoundList = 57;
        static final int TRANSACTION_register = 179;
        static final int TRANSACTION_registerListener = 2;
        static final int TRANSACTION_resetGimbal = 4;
        static final int TRANSACTION_resumeTask_aidl = 24;
        static final int TRANSACTION_runRouteTask_aidl = 22;
        static final int TRANSACTION_setActiveAvoid = 125;
        static final int TRANSACTION_setCallsign = 17;
        static final int TRANSACTION_setCollAvoid = 123;
        static final int TRANSACTION_setConnLossBehav = 121;
        static final int TRANSACTION_setCurrentSound = 62;
        static final int TRANSACTION_setGoHomeAlt = 117;
        static final int TRANSACTION_setGoHomeBattPct = 115;
        static final int TRANSACTION_setLandNowBattPct = 119;
        static final int TRANSACTION_setLandProt = 131;
        static final int TRANSACTION_setLightBridgeChannelMode = 161;
        static final int TRANSACTION_setLightBridgeChannelNumber = 164;
        static final int TRANSACTION_setLightBridgeDataRate = 166;
        static final int TRANSACTION_setLightBridgeFrequencyBand = 171;
        static final int TRANSACTION_setLightBridgeTransmissionMode = 168;
        static final int TRANSACTION_setMSXLevel = 94;
        static final int TRANSACTION_setMaxAltitude = 112;
        static final int TRANSACTION_setMaxDistance = 114;
        static final int TRANSACTION_setOcuSyncChannelBandwidth = 152;
        static final int TRANSACTION_setOcuSyncChannelMode = 149;
        static final int TRANSACTION_setOcuSyncChannelNumber = 155;
        static final int TRANSACTION_setOcuSyncFrequencyBand = 158;
        static final int TRANSACTION_setPlatformActivated = 9;
        static final int TRANSACTION_setPlayMode = 66;
        static final int TRANSACTION_setPrecLand = 129;
        static final int TRANSACTION_setPwm = 189;
        static final int TRANSACTION_setRcMode = 33;
        static final int TRANSACTION_setResFPS = 173;
        static final int TRANSACTION_setRestrictLandingGear = 186;
        static final int TRANSACTION_setSpeakerVolume = 68;
        static final int TRANSACTION_setThermalGain = 76;
        static final int TRANSACTION_setThermalIsoEnabled = 86;
        static final int TRANSACTION_setThermalIsoTempHigh = 89;
        static final int TRANSACTION_setThermalIsoTempLow = 87;
        static final int TRANSACTION_setThermalIsoTempMid = 88;
        static final int TRANSACTION_setThermalPalette = 72;
        static final int TRANSACTION_setThermalROI = 78;
        static final int TRANSACTION_setThermalScene = 74;
        static final int TRANSACTION_setVideoDataRate = 43;
        static final int TRANSACTION_setVirtualStickMode = 177;
        static final int TRANSACTION_setVisionPos = 127;
        static final int TRANSACTION_setWiFiChannelMode = 141;
        static final int TRANSACTION_setWiFiChannelNumber = 144;
        static final int TRANSACTION_setWiFiDataRate = 146;
        static final int TRANSACTION_setWiFiFrequencyBand = 139;
        static final int TRANSACTION_setWiFiPassword = 137;
        static final int TRANSACTION_setWiFiSSID = 135;
        static final int TRANSACTION_spotlightBrightness = 49;
        static final int TRANSACTION_startAccelCalib = 99;
        static final int TRANSACTION_startBroadcasting = 20;
        static final int TRANSACTION_startCompassCalib = 105;
        static final int TRANSACTION_startCot = 15;
        static final int TRANSACTION_startGimbalCalib = 109;
        static final int TRANSACTION_startGyroCalib = 102;
        static final int TRANSACTION_startRCPairing = 96;
        static final int TRANSACTION_stopAtakGo = 8;
        static final int TRANSACTION_stopBroadcasting = 21;
        static final int TRANSACTION_stopCompassCalib = 106;
        static final int TRANSACTION_stopCot = 16;
        static final int TRANSACTION_stopRCPairing = 97;
        static final int TRANSACTION_stopSound = 63;
        static final int TRANSACTION_stopTask_aidl = 25;
        static final int TRANSACTION_switchToNextCamera = 35;
        static final int TRANSACTION_takeCameraPicture = 18;
        static final int TRANSACTION_toggleAuxLightBottom = 54;
        static final int TRANSACTION_toggleAuxLightTop = 53;
        static final int TRANSACTION_toggleLEDs = 46;
        static final int TRANSACTION_toggleLight = 47;
        static final int TRANSACTION_toggleThermal = 70;
        static final int TRANSACTION_toggleThermalMetering = 91;
        static final int TRANSACTION_turnOnThermalMetering = 95;
        static final int TRANSACTION_unlockPlatform = 10;
        static final int TRANSACTION_usesYUV = 187;
        static final int TRANSACTION_yawGimbal = 6;
        static final int TRANSACTION_zoomIn = 40;
        static final int TRANSACTION_zoomOut = 41;

        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IDjiAtakInterface asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IDjiAtakInterface)) {
                return new Proxy(iBinder);
            }
            return (IDjiAtakInterface) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            int i3 = i;
            Parcel parcel3 = parcel;
            Parcel parcel4 = parcel2;
            if (i3 != 1598968902) {
                boolean z = false;
                switch (i3) {
                    case 1:
                        parcel3.enforceInterface(DESCRIPTOR);
                        int interfaceVersionNumber = getInterfaceVersionNumber();
                        parcel2.writeNoException();
                        parcel4.writeInt(interfaceVersionNumber);
                        return true;
                    case 2:
                        parcel3.enforceInterface(DESCRIPTOR);
                        registerListener(ITelemListener.Stub.asInterface(parcel.readStrongBinder()));
                        return true;
                    case 3:
                        parcel3.enforceInterface(DESCRIPTOR);
                        lookAtPoint(parcel.readDouble(), parcel.readDouble(), parcel.readDouble(), parcel.readDouble(), parcel.readDouble(), parcel.readDouble());
                        return true;
                    case 4:
                        parcel3.enforceInterface(DESCRIPTOR);
                        resetGimbal();
                        return true;
                    case 5:
                        parcel3.enforceInterface(DESCRIPTOR);
                        pitchGimbal(parcel.readDouble());
                        return true;
                    case 6:
                        parcel3.enforceInterface(DESCRIPTOR);
                        yawGimbal(parcel.readDouble());
                        return true;
                    case 7:
                        parcel3.enforceInterface(DESCRIPTOR);
                        checkUsbForPlatform();
                        return true;
                    case 8:
                        parcel3.enforceInterface(DESCRIPTOR);
                        stopAtakGo();
                        return true;
                    case 9:
                        parcel3.enforceInterface(DESCRIPTOR);
                        if (parcel.readInt() != 0) {
                            z = true;
                        }
                        setPlatformActivated(z);
                        return true;
                    case 10:
                        parcel3.enforceInterface(DESCRIPTOR);
                        unlockPlatform();
                        return true;
                    case 11:
                        parcel3.enforceInterface(DESCRIPTOR);
                        String[] cotMessages = getCotMessages();
                        parcel2.writeNoException();
                        parcel4.writeStringArray(cotMessages);
                        return true;
                    case 12:
                        parcel3.enforceInterface(DESCRIPTOR);
                        IAircraftItem aircraftItem = getAircraftItem();
                        parcel2.writeNoException();
                        if (aircraftItem != null) {
                            parcel4.writeInt(1);
                            aircraftItem.writeToParcel(parcel4, 1);
                        } else {
                            parcel4.writeInt(0);
                        }
                        return true;
                    case 13:
                        parcel3.enforceInterface(DESCRIPTOR);
                        boolean isFlying = isFlying();
                        parcel2.writeNoException();
                        parcel4.writeInt(isFlying ? 1 : 0);
                        return true;
                    case 14:
                        parcel3.enforceInterface(DESCRIPTOR);
                        boolean areMotorsOn = areMotorsOn();
                        parcel2.writeNoException();
                        parcel4.writeInt(areMotorsOn ? 1 : 0);
                        return true;
                    case 15:
                        parcel3.enforceInterface(DESCRIPTOR);
                        startCot(parcel.readString(), parcel.readString());
                        return true;
                    case 16:
                        parcel3.enforceInterface(DESCRIPTOR);
                        stopCot();
                        return true;
                    case 17:
                        parcel3.enforceInterface(DESCRIPTOR);
                        setCallsign(parcel.readString());
                        return true;
                    case 18:
                        parcel3.enforceInterface(DESCRIPTOR);
                        takeCameraPicture(parcel.readString(), parcel.readString(), parcel.readString());
                        return true;
                    case 19:
                        parcel3.enforceInterface(DESCRIPTOR);
                        actionCustom(parcel.readString(), parcel.readString());
                        return true;
                    case 20:
                        parcel3.enforceInterface(DESCRIPTOR);
                        String readString = parcel.readString();
                        boolean z2 = parcel.readInt() != 0;
                        if (parcel.readInt() != 0) {
                            z = true;
                        }
                        startBroadcasting(readString, z2, z, parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readLong(), parcel.readString(), parcel.readInt());
                        return true;
                    case 21:
                        parcel3.enforceInterface(DESCRIPTOR);
                        stopBroadcasting();
                        return true;
                    case 22:
                        parcel3.enforceInterface(DESCRIPTOR);
                        runRouteTask_aidl(parcel.readInt() != 0 ? UASRoute.CREATOR.createFromParcel(parcel3) : null);
                        return true;
                    case 23:
                        parcel3.enforceInterface(DESCRIPTOR);
                        pauseTask_aidl();
                        return true;
                    case 24:
                        parcel3.enforceInterface(DESCRIPTOR);
                        resumeTask_aidl();
                        return true;
                    case 25:
                        parcel3.enforceInterface(DESCRIPTOR);
                        stopTask_aidl();
                        return true;
                    case 26:
                        parcel3.enforceInterface(DESCRIPTOR);
                        quickTakeoff_aidl(parcel.readInt());
                        return true;
                    case 27:
                        parcel3.enforceInterface(DESCRIPTOR);
                        quickLanding_aidl();
                        return true;
                    case 28:
                        parcel3.enforceInterface(DESCRIPTOR);
                        quickStop_aidl();
                        return true;
                    case 29:
                        parcel3.enforceInterface(DESCRIPTOR);
                        quickRTH_aidl();
                        return true;
                    case 30:
                        parcel3.enforceInterface(DESCRIPTOR);
                        quickAltitude_aidl(parcel.readInt());
                        return true;
                    case 31:
                        parcel3.enforceInterface(DESCRIPTOR);
                        boolean isPermissionsAccepted = isPermissionsAccepted();
                        parcel2.writeNoException();
                        parcel4.writeInt(isPermissionsAccepted ? 1 : 0);
                        return true;
                    case 32:
                        parcel3.enforceInterface(DESCRIPTOR);
                        int rcMode = getRcMode();
                        parcel2.writeNoException();
                        parcel4.writeInt(rcMode);
                        return true;
                    case 33:
                        parcel3.enforceInterface(DESCRIPTOR);
                        setRcMode(parcel.readInt());
                        return true;
                    case 34:
                        parcel3.enforceInterface(DESCRIPTOR);
                        int numCameras = getNumCameras();
                        parcel2.writeNoException();
                        parcel4.writeInt(numCameras);
                        return true;
                    case 35:
                        parcel3.enforceInterface(DESCRIPTOR);
                        switchToNextCamera();
                        return true;
                    case 36:
                        parcel3.enforceInterface(DESCRIPTOR);
                        boolean canZoom = getCanZoom();
                        parcel2.writeNoException();
                        parcel4.writeInt(canZoom ? 1 : 0);
                        return true;
                    case 37:
                        parcel3.enforceInterface(DESCRIPTOR);
                        float zoomMin = getZoomMin();
                        parcel2.writeNoException();
                        parcel4.writeFloat(zoomMin);
                        return true;
                    case 38:
                        parcel3.enforceInterface(DESCRIPTOR);
                        float zoomMax = getZoomMax();
                        parcel2.writeNoException();
                        parcel4.writeFloat(zoomMax);
                        return true;
                    case 39:
                        parcel3.enforceInterface(DESCRIPTOR);
                        float zoomLevel = getZoomLevel();
                        parcel2.writeNoException();
                        parcel4.writeFloat(zoomLevel);
                        return true;
                    case 40:
                        parcel3.enforceInterface(DESCRIPTOR);
                        zoomIn();
                        return true;
                    case 41:
                        parcel3.enforceInterface(DESCRIPTOR);
                        zoomOut();
                        return true;
                    case 42:
                        parcel3.enforceInterface(DESCRIPTOR);
                        float videoDataRate = getVideoDataRate();
                        parcel2.writeNoException();
                        parcel4.writeFloat(videoDataRate);
                        return true;
                    case 43:
                        parcel3.enforceInterface(DESCRIPTOR);
                        setVideoDataRate(parcel.readFloat());
                        return true;
                    case 44:
                        parcel3.enforceInterface(DESCRIPTOR);
                        float minVideoDataRate = getMinVideoDataRate();
                        parcel2.writeNoException();
                        parcel4.writeFloat(minVideoDataRate);
                        return true;
                    case 45:
                        parcel3.enforceInterface(DESCRIPTOR);
                        float maxVideoDataRate = getMaxVideoDataRate();
                        parcel2.writeNoException();
                        parcel4.writeFloat(maxVideoDataRate);
                        return true;
                    case 46:
                        parcel3.enforceInterface(DESCRIPTOR);
                        toggleLEDs();
                        return true;
                    case 47:
                        parcel3.enforceInterface(DESCRIPTOR);
                        toggleLight();
                        return true;
                    case 48:
                        parcel3.enforceInterface(DESCRIPTOR);
                        boolean hasSpotlight = hasSpotlight();
                        parcel2.writeNoException();
                        parcel4.writeInt(hasSpotlight ? 1 : 0);
                        return true;
                    case 49:
                        parcel3.enforceInterface(DESCRIPTOR);
                        spotlightBrightness(parcel.readInt());
                        return true;
                    case 50:
                        parcel3.enforceInterface(DESCRIPTOR);
                        boolean hasBeacon = hasBeacon();
                        parcel2.writeNoException();
                        parcel4.writeInt(hasBeacon ? 1 : 0);
                        return true;
                    case 51:
                        parcel3.enforceInterface(DESCRIPTOR);
                        boolean hasAuxLightTop = hasAuxLightTop();
                        parcel2.writeNoException();
                        parcel4.writeInt(hasAuxLightTop ? 1 : 0);
                        return true;
                    case 52:
                        parcel3.enforceInterface(DESCRIPTOR);
                        boolean hasAuxLightBottom = hasAuxLightBottom();
                        parcel2.writeNoException();
                        parcel4.writeInt(hasAuxLightBottom ? 1 : 0);
                        return true;
                    case 53:
                        parcel3.enforceInterface(DESCRIPTOR);
                        toggleAuxLightTop();
                        return true;
                    case 54:
                        parcel3.enforceInterface(DESCRIPTOR);
                        toggleAuxLightBottom();
                        return true;
                    case 55:
                        parcel3.enforceInterface(DESCRIPTOR);
                        boolean hasSpeaker = hasSpeaker();
                        parcel2.writeNoException();
                        parcel4.writeInt(hasSpeaker ? 1 : 0);
                        return true;
                    case 56:
                        parcel3.enforceInterface(DESCRIPTOR);
                        String fileListState = getFileListState();
                        parcel2.writeNoException();
                        parcel4.writeString(fileListState);
                        return true;
                    case 57:
                        parcel3.enforceInterface(DESCRIPTOR);
                        refreshSoundList();
                        return true;
                    case 58:
                        parcel3.enforceInterface(DESCRIPTOR);
                        List<String> loadedSoundNames = getLoadedSoundNames();
                        parcel2.writeNoException();
                        parcel4.writeStringList(loadedSoundNames);
                        return true;
                    case 59:
                        parcel3.enforceInterface(DESCRIPTOR);
                        boolean isSoundPlaying = isSoundPlaying();
                        parcel2.writeNoException();
                        parcel4.writeInt(isSoundPlaying ? 1 : 0);
                        return true;
                    case 60:
                        parcel3.enforceInterface(DESCRIPTOR);
                        loadSound(parcel.readString());
                        return true;
                    case 61:
                        parcel3.enforceInterface(DESCRIPTOR);
                        playSound(parcel.readString());
                        return true;
                    case 62:
                        parcel3.enforceInterface(DESCRIPTOR);
                        setCurrentSound(parcel.readString());
                        return true;
                    case 63:
                        parcel3.enforceInterface(DESCRIPTOR);
                        stopSound();
                        return true;
                    case 64:
                        parcel3.enforceInterface(DESCRIPTOR);
                        deleteSound(parcel.readString());
                        return true;
                    case 65:
                        parcel3.enforceInterface(DESCRIPTOR);
                        String playMode = getPlayMode();
                        parcel2.writeNoException();
                        parcel4.writeString(playMode);
                        return true;
                    case 66:
                        parcel3.enforceInterface(DESCRIPTOR);
                        setPlayMode(parcel.readString());
                        return true;
                    case 67:
                        parcel3.enforceInterface(DESCRIPTOR);
                        int speakerVolume = getSpeakerVolume();
                        parcel2.writeNoException();
                        parcel4.writeInt(speakerVolume);
                        return true;
                    case 68:
                        parcel3.enforceInterface(DESCRIPTOR);
                        int readInt = parcel.readInt();
                        if (parcel.readInt() != 0) {
                            z = true;
                        }
                        setSpeakerVolume(readInt, z);
                        return true;
                    case 69:
                        parcel3.enforceInterface(DESCRIPTOR);
                        boolean hasThermalCamera = hasThermalCamera();
                        parcel2.writeNoException();
                        parcel4.writeInt(hasThermalCamera ? 1 : 0);
                        return true;
                    case 70:
                        parcel3.enforceInterface(DESCRIPTOR);
                        toggleThermal();
                        return true;
                    case 71:
                        parcel3.enforceInterface(DESCRIPTOR);
                        String thermalPalette = getThermalPalette();
                        parcel2.writeNoException();
                        parcel4.writeString(thermalPalette);
                        return true;
                    case 72:
                        parcel3.enforceInterface(DESCRIPTOR);
                        setThermalPalette(parcel.readString());
                        return true;
                    case 73:
                        parcel3.enforceInterface(DESCRIPTOR);
                        String thermalScene = getThermalScene();
                        parcel2.writeNoException();
                        parcel4.writeString(thermalScene);
                        return true;
                    case 74:
                        parcel3.enforceInterface(DESCRIPTOR);
                        setThermalScene(parcel.readString());
                        return true;
                    case 75:
                        parcel3.enforceInterface(DESCRIPTOR);
                        String thermalGain = getThermalGain();
                        parcel2.writeNoException();
                        parcel4.writeString(thermalGain);
                        return true;
                    case 76:
                        parcel3.enforceInterface(DESCRIPTOR);
                        setThermalGain(parcel.readString());
                        return true;
                    case 77:
                        parcel3.enforceInterface(DESCRIPTOR);
                        String thermalROI = getThermalROI();
                        parcel2.writeNoException();
                        parcel4.writeString(thermalROI);
                        return true;
                    case 78:
                        parcel3.enforceInterface(DESCRIPTOR);
                        setThermalROI(parcel.readString());
                        return true;
                    case 79:
                        parcel3.enforceInterface(DESCRIPTOR);
                        String thermalIsoTempUnits = getThermalIsoTempUnits();
                        parcel2.writeNoException();
                        parcel4.writeString(thermalIsoTempUnits);
                        return true;
                    case 80:
                        parcel3.enforceInterface(DESCRIPTOR);
                        int thermalIsoTempMin = getThermalIsoTempMin();
                        parcel2.writeNoException();
                        parcel4.writeInt(thermalIsoTempMin);
                        return true;
                    case 81:
                        parcel3.enforceInterface(DESCRIPTOR);
                        int thermalIsoTempMax = getThermalIsoTempMax();
                        parcel2.writeNoException();
                        parcel4.writeInt(thermalIsoTempMax);
                        return true;
                    case 82:
                        parcel3.enforceInterface(DESCRIPTOR);
                        boolean thermalIsoEnabled = getThermalIsoEnabled();
                        parcel2.writeNoException();
                        parcel4.writeInt(thermalIsoEnabled ? 1 : 0);
                        return true;
                    case 83:
                        parcel3.enforceInterface(DESCRIPTOR);
                        int thermalIsoTempLow = getThermalIsoTempLow();
                        parcel2.writeNoException();
                        parcel4.writeInt(thermalIsoTempLow);
                        return true;
                    case 84:
                        parcel3.enforceInterface(DESCRIPTOR);
                        int thermalIsoTempMid = getThermalIsoTempMid();
                        parcel2.writeNoException();
                        parcel4.writeInt(thermalIsoTempMid);
                        return true;
                    case 85:
                        parcel3.enforceInterface(DESCRIPTOR);
                        int thermalIsoTempHigh = getThermalIsoTempHigh();
                        parcel2.writeNoException();
                        parcel4.writeInt(thermalIsoTempHigh);
                        return true;
                    case 86:
                        parcel3.enforceInterface(DESCRIPTOR);
                        if (parcel.readInt() != 0) {
                            z = true;
                        }
                        boolean thermalIsoEnabled2 = setThermalIsoEnabled(z);
                        parcel2.writeNoException();
                        parcel4.writeInt(thermalIsoEnabled2 ? 1 : 0);
                        return true;
                    case 87:
                        parcel3.enforceInterface(DESCRIPTOR);
                        int thermalIsoTempLow2 = setThermalIsoTempLow(parcel.readInt());
                        parcel2.writeNoException();
                        parcel4.writeInt(thermalIsoTempLow2);
                        return true;
                    case 88:
                        parcel3.enforceInterface(DESCRIPTOR);
                        int thermalIsoTempMid2 = setThermalIsoTempMid(parcel.readInt());
                        parcel2.writeNoException();
                        parcel4.writeInt(thermalIsoTempMid2);
                        return true;
                    case 89:
                        parcel3.enforceInterface(DESCRIPTOR);
                        int thermalIsoTempHigh2 = setThermalIsoTempHigh(parcel.readInt());
                        parcel2.writeNoException();
                        parcel4.writeInt(thermalIsoTempHigh2);
                        return true;
                    case 90:
                        parcel3.enforceInterface(DESCRIPTOR);
                        boolean thermalMetering = getThermalMetering();
                        parcel2.writeNoException();
                        parcel4.writeInt(thermalMetering ? 1 : 0);
                        return true;
                    case 91:
                        parcel3.enforceInterface(DESCRIPTOR);
                        boolean z3 = toggleThermalMetering();
                        parcel2.writeNoException();
                        parcel4.writeInt(z3 ? 1 : 0);
                        return true;
                    case 92:
                        parcel3.enforceInterface(DESCRIPTOR);
                        ThermalData thermalMeterData = getThermalMeterData(parcel.readString());
                        parcel2.writeNoException();
                        if (thermalMeterData != null) {
                            parcel4.writeInt(1);
                            thermalMeterData.writeToParcel(parcel4, 1);
                        } else {
                            parcel4.writeInt(0);
                        }
                        return true;
                    case 93:
                        parcel3.enforceInterface(DESCRIPTOR);
                        int mSXLevel = getMSXLevel();
                        parcel2.writeNoException();
                        parcel4.writeInt(mSXLevel);
                        return true;
                    case 94:
                        parcel3.enforceInterface(DESCRIPTOR);
                        int mSXLevel2 = setMSXLevel(parcel.readInt());
                        parcel2.writeNoException();
                        parcel4.writeInt(mSXLevel2);
                        return true;
                    case 95:
                        parcel3.enforceInterface(DESCRIPTOR);
                        turnOnThermalMetering();
                        return true;
                    case 96:
                        parcel3.enforceInterface(DESCRIPTOR);
                        startRCPairing();
                        return true;
                    case 97:
                        parcel3.enforceInterface(DESCRIPTOR);
                        stopRCPairing();
                        return true;
                    case 98:
                        parcel3.enforceInterface(DESCRIPTOR);
                        String accelState = getAccelState();
                        parcel2.writeNoException();
                        parcel4.writeString(accelState);
                        return true;
                    case TRANSACTION_startAccelCalib /*99*/:
                        parcel3.enforceInterface(DESCRIPTOR);
                        startAccelCalib();
                        return true;
                    case 100:
                        parcel3.enforceInterface(DESCRIPTOR);
                        String accelCalibStatus = getAccelCalibStatus();
                        parcel2.writeNoException();
                        parcel4.writeString(accelCalibStatus);
                        return true;
                    case 101:
                        parcel3.enforceInterface(DESCRIPTOR);
                        String gyroState = getGyroState();
                        parcel2.writeNoException();
                        parcel4.writeString(gyroState);
                        return true;
                    case 102:
                        parcel3.enforceInterface(DESCRIPTOR);
                        startGyroCalib();
                        return true;
                    case 103:
                        parcel3.enforceInterface(DESCRIPTOR);
                        String gyroCalibStatus = getGyroCalibStatus();
                        parcel2.writeNoException();
                        parcel4.writeString(gyroCalibStatus);
                        return true;
                    case 104:
                        parcel3.enforceInterface(DESCRIPTOR);
                        String compassState = getCompassState();
                        parcel2.writeNoException();
                        parcel4.writeString(compassState);
                        return true;
                    case 105:
                        parcel3.enforceInterface(DESCRIPTOR);
                        startCompassCalib();
                        return true;
                    case 106:
                        parcel3.enforceInterface(DESCRIPTOR);
                        stopCompassCalib();
                        return true;
                    case 107:
                        parcel3.enforceInterface(DESCRIPTOR);
                        String compassCalibStatus = getCompassCalibStatus();
                        parcel2.writeNoException();
                        parcel4.writeString(compassCalibStatus);
                        return true;
                    case 108:
                        parcel3.enforceInterface(DESCRIPTOR);
                        String gimbalMode = getGimbalMode();
                        parcel2.writeNoException();
                        parcel4.writeString(gimbalMode);
                        return true;
                    case 109:
                        parcel3.enforceInterface(DESCRIPTOR);
                        startGimbalCalib();
                        return true;
                    case 110:
                        parcel3.enforceInterface(DESCRIPTOR);
                        String gimbalCalibStatus = getGimbalCalibStatus();
                        parcel2.writeNoException();
                        parcel4.writeString(gimbalCalibStatus);
                        return true;
                    case 111:
                        parcel3.enforceInterface(DESCRIPTOR);
                        int maxAltitude = getMaxAltitude();
                        parcel2.writeNoException();
                        parcel4.writeInt(maxAltitude);
                        return true;
                    case 112:
                        parcel3.enforceInterface(DESCRIPTOR);
                        String maxAltitude2 = setMaxAltitude(parcel.readInt());
                        parcel2.writeNoException();
                        parcel4.writeString(maxAltitude2);
                        return true;
                    case 113:
                        parcel3.enforceInterface(DESCRIPTOR);
                        int maxDistance = getMaxDistance();
                        parcel2.writeNoException();
                        parcel4.writeInt(maxDistance);
                        return true;
                    case 114:
                        parcel3.enforceInterface(DESCRIPTOR);
                        String maxDistance2 = setMaxDistance(parcel.readInt());
                        parcel2.writeNoException();
                        parcel4.writeString(maxDistance2);
                        return true;
                    case 115:
                        parcel3.enforceInterface(DESCRIPTOR);
                        String goHomeBattPct = setGoHomeBattPct(parcel.readInt());
                        parcel2.writeNoException();
                        parcel4.writeString(goHomeBattPct);
                        return true;
                    case 116:
                        parcel3.enforceInterface(DESCRIPTOR);
                        int goHomeBattPct2 = getGoHomeBattPct();
                        parcel2.writeNoException();
                        parcel4.writeInt(goHomeBattPct2);
                        return true;
                    case 117:
                        parcel3.enforceInterface(DESCRIPTOR);
                        String goHomeAlt = setGoHomeAlt(parcel.readInt());
                        parcel2.writeNoException();
                        parcel4.writeString(goHomeAlt);
                        return true;
                    case 118:
                        parcel3.enforceInterface(DESCRIPTOR);
                        int goHomeAlt2 = getGoHomeAlt();
                        parcel2.writeNoException();
                        parcel4.writeInt(goHomeAlt2);
                        return true;
                    case 119:
                        parcel3.enforceInterface(DESCRIPTOR);
                        String landNowBattPct = setLandNowBattPct(parcel.readInt());
                        parcel2.writeNoException();
                        parcel4.writeString(landNowBattPct);
                        return true;
                    case 120:
                        parcel3.enforceInterface(DESCRIPTOR);
                        int landNowBattPct2 = getLandNowBattPct();
                        parcel2.writeNoException();
                        parcel4.writeInt(landNowBattPct2);
                        return true;
                    case 121:
                        parcel3.enforceInterface(DESCRIPTOR);
                        String connLossBehav = setConnLossBehav(parcel.readString());
                        parcel2.writeNoException();
                        parcel4.writeString(connLossBehav);
                        return true;
                    case 122:
                        parcel3.enforceInterface(DESCRIPTOR);
                        String connLossBehav2 = getConnLossBehav();
                        parcel2.writeNoException();
                        parcel4.writeString(connLossBehav2);
                        return true;
                    case 123:
                        parcel3.enforceInterface(DESCRIPTOR);
                        if (parcel.readInt() != 0) {
                            z = true;
                        }
                        String collAvoid = setCollAvoid(z);
                        parcel2.writeNoException();
                        parcel4.writeString(collAvoid);
                        return true;
                    case 124:
                        parcel3.enforceInterface(DESCRIPTOR);
                        boolean collAvoid2 = getCollAvoid();
                        parcel2.writeNoException();
                        parcel4.writeInt(collAvoid2 ? 1 : 0);
                        return true;
                    case 125:
                        parcel3.enforceInterface(DESCRIPTOR);
                        if (parcel.readInt() != 0) {
                            z = true;
                        }
                        String activeAvoid = setActiveAvoid(z);
                        parcel2.writeNoException();
                        parcel4.writeString(activeAvoid);
                        return true;
                    case 126:
                        parcel3.enforceInterface(DESCRIPTOR);
                        boolean activeAvoid2 = getActiveAvoid();
                        parcel2.writeNoException();
                        parcel4.writeInt(activeAvoid2 ? 1 : 0);
                        return true;
                    case 127:
                        parcel3.enforceInterface(DESCRIPTOR);
                        if (parcel.readInt() != 0) {
                            z = true;
                        }
                        String visionPos = setVisionPos(z);
                        parcel2.writeNoException();
                        parcel4.writeString(visionPos);
                        return true;
                    case 128:
                        parcel3.enforceInterface(DESCRIPTOR);
                        boolean visionPos2 = getVisionPos();
                        parcel2.writeNoException();
                        parcel4.writeInt(visionPos2 ? 1 : 0);
                        return true;
                    case 129:
                        parcel3.enforceInterface(DESCRIPTOR);
                        if (parcel.readInt() != 0) {
                            z = true;
                        }
                        String precLand = setPrecLand(z);
                        parcel2.writeNoException();
                        parcel4.writeString(precLand);
                        return true;
                    case 130:
                        parcel3.enforceInterface(DESCRIPTOR);
                        boolean precLand2 = getPrecLand();
                        parcel2.writeNoException();
                        parcel4.writeInt(precLand2 ? 1 : 0);
                        return true;
                    case 131:
                        parcel3.enforceInterface(DESCRIPTOR);
                        if (parcel.readInt() != 0) {
                            z = true;
                        }
                        String landProt = setLandProt(z);
                        parcel2.writeNoException();
                        parcel4.writeString(landProt);
                        return true;
                    case 132:
                        parcel3.enforceInterface(DESCRIPTOR);
                        boolean landProt2 = getLandProt();
                        parcel2.writeNoException();
                        parcel4.writeInt(landProt2 ? 1 : 0);
                        return true;
                    case 133:
                        parcel3.enforceInterface(DESCRIPTOR);
                        boolean hasWiFi = hasWiFi();
                        parcel2.writeNoException();
                        parcel4.writeInt(hasWiFi ? 1 : 0);
                        return true;
                    case 134:
                        parcel3.enforceInterface(DESCRIPTOR);
                        String wiFiSSID = getWiFiSSID();
                        parcel2.writeNoException();
                        parcel4.writeString(wiFiSSID);
                        return true;
                    case 135:
                        parcel3.enforceInterface(DESCRIPTOR);
                        String wiFiSSID2 = setWiFiSSID(parcel.readString());
                        parcel2.writeNoException();
                        parcel4.writeString(wiFiSSID2);
                        return true;
                    case 136:
                        parcel3.enforceInterface(DESCRIPTOR);
                        String wiFiPassword = getWiFiPassword();
                        parcel2.writeNoException();
                        parcel4.writeString(wiFiPassword);
                        return true;
                    case 137:
                        parcel3.enforceInterface(DESCRIPTOR);
                        String wiFiPassword2 = setWiFiPassword(parcel.readString());
                        parcel2.writeNoException();
                        parcel4.writeString(wiFiPassword2);
                        return true;
                    case 138:
                        parcel3.enforceInterface(DESCRIPTOR);
                        String wiFiFrequencyBand = getWiFiFrequencyBand();
                        parcel2.writeNoException();
                        parcel4.writeString(wiFiFrequencyBand);
                        return true;
                    case 139:
                        parcel3.enforceInterface(DESCRIPTOR);
                        String wiFiFrequencyBand2 = setWiFiFrequencyBand(parcel.readString());
                        parcel2.writeNoException();
                        parcel4.writeString(wiFiFrequencyBand2);
                        return true;
                    case 140:
                        parcel3.enforceInterface(DESCRIPTOR);
                        String wiFiChannelMode = getWiFiChannelMode();
                        parcel2.writeNoException();
                        parcel4.writeString(wiFiChannelMode);
                        return true;
                    case 141:
                        parcel3.enforceInterface(DESCRIPTOR);
                        String wiFiChannelMode2 = setWiFiChannelMode(parcel.readString());
                        parcel2.writeNoException();
                        parcel4.writeString(wiFiChannelMode2);
                        return true;
                    case 142:
                        parcel3.enforceInterface(DESCRIPTOR);
                        int wiFiChannelNumber = getWiFiChannelNumber();
                        parcel2.writeNoException();
                        parcel4.writeInt(wiFiChannelNumber);
                        return true;
                    case 143:
                        parcel3.enforceInterface(DESCRIPTOR);
                        int[] wiFiChannelNumbers = getWiFiChannelNumbers();
                        parcel2.writeNoException();
                        parcel4.writeIntArray(wiFiChannelNumbers);
                        return true;
                    case 144:
                        parcel3.enforceInterface(DESCRIPTOR);
                        String wiFiChannelNumber2 = setWiFiChannelNumber(parcel.readInt());
                        parcel2.writeNoException();
                        parcel4.writeString(wiFiChannelNumber2);
                        return true;
                    case 145:
                        parcel3.enforceInterface(DESCRIPTOR);
                        String wiFiDataRate = getWiFiDataRate();
                        parcel2.writeNoException();
                        parcel4.writeString(wiFiDataRate);
                        return true;
                    case 146:
                        parcel3.enforceInterface(DESCRIPTOR);
                        String wiFiDataRate2 = setWiFiDataRate(parcel.readString());
                        parcel2.writeNoException();
                        parcel4.writeString(wiFiDataRate2);
                        return true;
                    case 147:
                        parcel3.enforceInterface(DESCRIPTOR);
                        boolean hasOcuSync = hasOcuSync();
                        parcel2.writeNoException();
                        parcel4.writeInt(hasOcuSync ? 1 : 0);
                        return true;
                    case 148:
                        parcel3.enforceInterface(DESCRIPTOR);
                        String ocuSyncChannelMode = getOcuSyncChannelMode();
                        parcel2.writeNoException();
                        parcel4.writeString(ocuSyncChannelMode);
                        return true;
                    case 149:
                        parcel3.enforceInterface(DESCRIPTOR);
                        String ocuSyncChannelMode2 = setOcuSyncChannelMode(parcel.readString());
                        parcel2.writeNoException();
                        parcel4.writeString(ocuSyncChannelMode2);
                        return true;
                    case 150:
                        parcel3.enforceInterface(DESCRIPTOR);
                        String ocuSyncChannelBandwidth = getOcuSyncChannelBandwidth();
                        parcel2.writeNoException();
                        parcel4.writeString(ocuSyncChannelBandwidth);
                        return true;
                    case 151:
                        parcel3.enforceInterface(DESCRIPTOR);
                        String[] ocuSyncChannelBandwidths = getOcuSyncChannelBandwidths();
                        parcel2.writeNoException();
                        parcel4.writeStringArray(ocuSyncChannelBandwidths);
                        return true;
                    case 152:
                        parcel3.enforceInterface(DESCRIPTOR);
                        String ocuSyncChannelBandwidth2 = setOcuSyncChannelBandwidth(parcel.readString());
                        parcel2.writeNoException();
                        parcel4.writeString(ocuSyncChannelBandwidth2);
                        return true;
                    case 153:
                        parcel3.enforceInterface(DESCRIPTOR);
                        int ocuSyncChannelNumber = getOcuSyncChannelNumber();
                        parcel2.writeNoException();
                        parcel4.writeInt(ocuSyncChannelNumber);
                        return true;
                    case 154:
                        parcel3.enforceInterface(DESCRIPTOR);
                        int[] ocuSyncChannelNumberRange = getOcuSyncChannelNumberRange();
                        parcel2.writeNoException();
                        parcel4.writeIntArray(ocuSyncChannelNumberRange);
                        return true;
                    case 155:
                        parcel3.enforceInterface(DESCRIPTOR);
                        String ocuSyncChannelNumber2 = setOcuSyncChannelNumber(parcel.readInt());
                        parcel2.writeNoException();
                        parcel4.writeString(ocuSyncChannelNumber2);
                        return true;
                    case 156:
                        parcel3.enforceInterface(DESCRIPTOR);
                        String ocuSyncFrequencyBand = getOcuSyncFrequencyBand();
                        parcel2.writeNoException();
                        parcel4.writeString(ocuSyncFrequencyBand);
                        return true;
                    case 157:
                        parcel3.enforceInterface(DESCRIPTOR);
                        String[] ocuSyncFrequencyBands = getOcuSyncFrequencyBands();
                        parcel2.writeNoException();
                        parcel4.writeStringArray(ocuSyncFrequencyBands);
                        return true;
                    case 158:
                        parcel3.enforceInterface(DESCRIPTOR);
                        String ocuSyncFrequencyBand2 = setOcuSyncFrequencyBand(parcel.readString());
                        parcel2.writeNoException();
                        parcel4.writeString(ocuSyncFrequencyBand2);
                        return true;
                    case 159:
                        parcel3.enforceInterface(DESCRIPTOR);
                        boolean hasLightBridge = hasLightBridge();
                        parcel2.writeNoException();
                        parcel4.writeInt(hasLightBridge ? 1 : 0);
                        return true;
                    case 160:
                        parcel3.enforceInterface(DESCRIPTOR);
                        String lightBridgeChannelMode = getLightBridgeChannelMode();
                        parcel2.writeNoException();
                        parcel4.writeString(lightBridgeChannelMode);
                        return true;
                    case 161:
                        parcel3.enforceInterface(DESCRIPTOR);
                        String lightBridgeChannelMode2 = setLightBridgeChannelMode(parcel.readString());
                        parcel2.writeNoException();
                        parcel4.writeString(lightBridgeChannelMode2);
                        return true;
                    case 162:
                        parcel3.enforceInterface(DESCRIPTOR);
                        int lightBridgeChannelNumber = getLightBridgeChannelNumber();
                        parcel2.writeNoException();
                        parcel4.writeInt(lightBridgeChannelNumber);
                        return true;
                    case 163:
                        parcel3.enforceInterface(DESCRIPTOR);
                        int[] lightBridgeChannelNumberRange = getLightBridgeChannelNumberRange();
                        parcel2.writeNoException();
                        parcel4.writeIntArray(lightBridgeChannelNumberRange);
                        return true;
                    case 164:
                        parcel3.enforceInterface(DESCRIPTOR);
                        String lightBridgeChannelNumber2 = setLightBridgeChannelNumber(parcel.readInt());
                        parcel2.writeNoException();
                        parcel4.writeString(lightBridgeChannelNumber2);
                        return true;
                    case 165:
                        parcel3.enforceInterface(DESCRIPTOR);
                        String lightBridgeDataRate = getLightBridgeDataRate();
                        parcel2.writeNoException();
                        parcel4.writeString(lightBridgeDataRate);
                        return true;
                    case 166:
                        parcel3.enforceInterface(DESCRIPTOR);
                        String lightBridgeDataRate2 = setLightBridgeDataRate(parcel.readString());
                        parcel2.writeNoException();
                        parcel4.writeString(lightBridgeDataRate2);
                        return true;
                    case 167:
                        parcel3.enforceInterface(DESCRIPTOR);
                        String lightBridgeTransmissionMode = getLightBridgeTransmissionMode();
                        parcel2.writeNoException();
                        parcel4.writeString(lightBridgeTransmissionMode);
                        return true;
                    case 168:
                        parcel3.enforceInterface(DESCRIPTOR);
                        String lightBridgeTransmissionMode2 = setLightBridgeTransmissionMode(parcel.readString());
                        parcel2.writeNoException();
                        parcel4.writeString(lightBridgeTransmissionMode2);
                        return true;
                    case 169:
                        parcel3.enforceInterface(DESCRIPTOR);
                        String lightBridgeFrequencyBand = getLightBridgeFrequencyBand();
                        parcel2.writeNoException();
                        parcel4.writeString(lightBridgeFrequencyBand);
                        return true;
                    case 170:
                        parcel3.enforceInterface(DESCRIPTOR);
                        String[] lightBridgeFrequencyBands = getLightBridgeFrequencyBands();
                        parcel2.writeNoException();
                        parcel4.writeStringArray(lightBridgeFrequencyBands);
                        return true;
                    case 171:
                        parcel3.enforceInterface(DESCRIPTOR);
                        String lightBridgeFrequencyBand2 = setLightBridgeFrequencyBand(parcel.readString());
                        parcel2.writeNoException();
                        parcel4.writeString(lightBridgeFrequencyBand2);
                        return true;
                    case 172:
                        parcel3.enforceInterface(DESCRIPTOR);
                        List<String> resFPSList = getResFPSList();
                        parcel2.writeNoException();
                        parcel4.writeStringList(resFPSList);
                        return true;
                    case 173:
                        parcel3.enforceInterface(DESCRIPTOR);
                        String resFPS = setResFPS(parcel.readString());
                        parcel2.writeNoException();
                        parcel4.writeString(resFPS);
                        return true;
                    case 174:
                        parcel3.enforceInterface(DESCRIPTOR);
                        String resFPS2 = getResFPS();
                        parcel2.writeNoException();
                        parcel4.writeString(resFPS2);
                        return true;
                    case 175:
                        parcel3.enforceInterface(DESCRIPTOR);
                        formatSDCardStart();
                        return true;
                    case 176:
                        parcel3.enforceInterface(DESCRIPTOR);
                        formatInternalStart();
                        return true;
                    case 177:
                        parcel3.enforceInterface(DESCRIPTOR);
                        if (parcel.readInt() != 0) {
                            z = true;
                        }
                        boolean virtualStickMode = setVirtualStickMode(z);
                        parcel2.writeNoException();
                        parcel4.writeInt(virtualStickMode ? 1 : 0);
                        return true;
                    case 178:
                        parcel3.enforceInterface(DESCRIPTOR);
                        joystickPosition(parcel.readFloat(), parcel.readFloat(), parcel.readFloat(), parcel.readFloat());
                        return true;
                    case 179:
                        parcel3.enforceInterface(DESCRIPTOR);
                        register();
                        parcel2.writeNoException();
                        return true;
                    case 180:
                        parcel3.enforceInterface(DESCRIPTOR);
                        boolean isLDMSupported = isLDMSupported();
                        parcel2.writeNoException();
                        parcel4.writeInt(isLDMSupported ? 1 : 0);
                        return true;
                    case 181:
                        parcel3.enforceInterface(DESCRIPTOR);
                        boolean lDMSupported = getLDMSupported();
                        parcel2.writeNoException();
                        parcel4.writeInt(lDMSupported ? 1 : 0);
                        return true;
                    case 182:
                        parcel3.enforceInterface(DESCRIPTOR);
                        boolean isLDMEnabled = isLDMEnabled();
                        parcel2.writeNoException();
                        parcel4.writeInt(isLDMEnabled ? 1 : 0);
                        return true;
                    case 183:
                        parcel3.enforceInterface(DESCRIPTOR);
                        if (parcel.readInt() != 0) {
                            z = true;
                        }
                        boolean enableLDM = enableLDM(z);
                        parcel2.writeNoException();
                        parcel4.writeInt(enableLDM ? 1 : 0);
                        return true;
                    case 184:
                        parcel3.enforceInterface(DESCRIPTOR);
                        boolean restrictLandingGear = getRestrictLandingGear();
                        parcel2.writeNoException();
                        parcel4.writeInt(restrictLandingGear ? 1 : 0);
                        return true;
                    case 185:
                        parcel3.enforceInterface(DESCRIPTOR);
                        boolean hasLandingGear = hasLandingGear();
                        parcel2.writeNoException();
                        parcel4.writeInt(hasLandingGear ? 1 : 0);
                        return true;
                    case 186:
                        parcel3.enforceInterface(DESCRIPTOR);
                        if (parcel.readInt() != 0) {
                            z = true;
                        }
                        boolean restrictLandingGear2 = setRestrictLandingGear(z);
                        parcel2.writeNoException();
                        parcel4.writeInt(restrictLandingGear2 ? 1 : 0);
                        return true;
                    case TRANSACTION_usesYUV /*187*/:
                        parcel3.enforceInterface(DESCRIPTOR);
                        boolean usesYUV = usesYUV();
                        parcel2.writeNoException();
                        parcel4.writeInt(usesYUV ? 1 : 0);
                        return true;
                    case 188:
                        parcel3.enforceInterface(DESCRIPTOR);
                        initPwmSettings(parcel.readInt(), parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 189:
                        parcel3.enforceInterface(DESCRIPTOR);
                        setPwm(parcel.readInt(), parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 190:
                        parcel3.enforceInterface(DESCRIPTOR);
                        checkOnboardSdkAvailable();
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
            } else {
                parcel4.writeString(DESCRIPTOR);
                return true;
            }
        }

        private static class Proxy implements IDjiAtakInterface {
            public static IDjiAtakInterface sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public int getInterfaceVersionNumber() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getInterfaceVersionNumber();
                    }
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    obtain2.recycle();
                    obtain.recycle();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void registerListener(ITelemListener iTelemListener) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iTelemListener != null ? iTelemListener.asBinder() : null);
                    if (this.mRemote.transact(2, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().registerListener(iTelemListener);
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public void lookAtPoint(double d, double d2, double d3, double d4, double d5, double d6) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeDouble(d);
                    obtain.writeDouble(d2);
                    obtain.writeDouble(d3);
                    obtain.writeDouble(d4);
                    obtain.writeDouble(d5);
                    obtain.writeDouble(d6);
                    try {
                        if (this.mRemote.transact(3, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                            obtain.recycle();
                            return;
                        }
                        Stub.getDefaultImpl().lookAtPoint(d, d2, d3, d4, d5, d6);
                        obtain.recycle();
                    } catch (Throwable th) {
                        th = th;
                        obtain.recycle();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    obtain.recycle();
                    throw th;
                }
            }

            public void resetGimbal() {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(4, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().resetGimbal();
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public void pitchGimbal(double d) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeDouble(d);
                    if (this.mRemote.transact(5, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().pitchGimbal(d);
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public void yawGimbal(double d) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeDouble(d);
                    if (this.mRemote.transact(6, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().yawGimbal(d);
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public void checkUsbForPlatform() {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(7, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().checkUsbForPlatform();
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public void stopAtakGo() {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(8, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().stopAtakGo();
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public void setPlatformActivated(boolean z) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(z ? 1 : 0);
                    if (this.mRemote.transact(9, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().setPlatformActivated(z);
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public void unlockPlatform() {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(10, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().unlockPlatform();
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public String[] getCotMessages() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(11, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getCotMessages();
                    }
                    obtain2.readException();
                    String[] createStringArray = obtain2.createStringArray();
                    obtain2.recycle();
                    obtain.recycle();
                    return createStringArray;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IAircraftItem getAircraftItem() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(12, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getAircraftItem();
                    }
                    obtain2.readException();
                    IAircraftItem createFromParcel = obtain2.readInt() != 0 ? IAircraftItem.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return createFromParcel;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean isFlying() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean z = false;
                    if (!this.mRemote.transact(13, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().isFlying();
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean areMotorsOn() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean z = false;
                    if (!this.mRemote.transact(14, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().areMotorsOn();
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void startCot(String str, String str2) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (this.mRemote.transact(15, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().startCot(str, str2);
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public void stopCot() {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(16, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().stopCot();
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public void setCallsign(String str) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (this.mRemote.transact(17, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().setCallsign(str);
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public void takeCameraPicture(String str, String str2, String str3) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    if (this.mRemote.transact(18, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().takeCameraPicture(str, str2, str3);
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public void actionCustom(String str, String str2) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (this.mRemote.transact(19, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().actionCustom(str, str2);
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public void startBroadcasting(String str, boolean z, boolean z2, String str2, int i, String str3, String str4, String str5, long j, String str6, int i2) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    int i3 = 0;
                    obtain.writeInt(z ? 1 : 0);
                    if (z2) {
                        i3 = 1;
                    }
                    obtain.writeInt(i3);
                    obtain.writeString(str2);
                    obtain.writeInt(i);
                    obtain.writeString(str3);
                    obtain.writeString(str4);
                    obtain.writeString(str5);
                    obtain.writeLong(j);
                    obtain.writeString(str6);
                    obtain.writeInt(i2);
                    try {
                        if (this.mRemote.transact(20, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                            obtain.recycle();
                            return;
                        }
                        Stub.getDefaultImpl().startBroadcasting(str, z, z2, str2, i, str3, str4, str5, j, str6, i2);
                        obtain.recycle();
                    } catch (Throwable th) {
                        th = th;
                        obtain.recycle();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    obtain.recycle();
                    throw th;
                }
            }

            public void stopBroadcasting() {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(21, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().stopBroadcasting();
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public void runRouteTask_aidl(UASRoute uASRoute) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (uASRoute != null) {
                        obtain.writeInt(1);
                        uASRoute.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(22, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().runRouteTask_aidl(uASRoute);
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public void pauseTask_aidl() {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(23, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().pauseTask_aidl();
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public void resumeTask_aidl() {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(24, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().resumeTask_aidl();
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public void stopTask_aidl() {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(25, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().stopTask_aidl();
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public void quickTakeoff_aidl(int i) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (this.mRemote.transact(26, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().quickTakeoff_aidl(i);
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public void quickLanding_aidl() {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(27, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().quickLanding_aidl();
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public void quickStop_aidl() {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(28, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().quickStop_aidl();
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public void quickRTH_aidl() {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(29, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().quickRTH_aidl();
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public void quickAltitude_aidl(int i) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (this.mRemote.transact(30, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().quickAltitude_aidl(i);
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public boolean isPermissionsAccepted() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean z = false;
                    if (!this.mRemote.transact(31, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().isPermissionsAccepted();
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int getRcMode() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(32, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getRcMode();
                    }
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    obtain2.recycle();
                    obtain.recycle();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setRcMode(int i) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (this.mRemote.transact(33, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().setRcMode(i);
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public int getNumCameras() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(34, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getNumCameras();
                    }
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    obtain2.recycle();
                    obtain.recycle();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void switchToNextCamera() {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(35, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().switchToNextCamera();
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public boolean getCanZoom() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean z = false;
                    if (!this.mRemote.transact(36, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getCanZoom();
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public float getZoomMin() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(37, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getZoomMin();
                    }
                    obtain2.readException();
                    float readFloat = obtain2.readFloat();
                    obtain2.recycle();
                    obtain.recycle();
                    return readFloat;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public float getZoomMax() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(38, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getZoomMax();
                    }
                    obtain2.readException();
                    float readFloat = obtain2.readFloat();
                    obtain2.recycle();
                    obtain.recycle();
                    return readFloat;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public float getZoomLevel() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(39, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getZoomLevel();
                    }
                    obtain2.readException();
                    float readFloat = obtain2.readFloat();
                    obtain2.recycle();
                    obtain.recycle();
                    return readFloat;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zoomIn() {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(40, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().zoomIn();
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public void zoomOut() {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(41, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().zoomOut();
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public float getVideoDataRate() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(42, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getVideoDataRate();
                    }
                    obtain2.readException();
                    float readFloat = obtain2.readFloat();
                    obtain2.recycle();
                    obtain.recycle();
                    return readFloat;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setVideoDataRate(float f) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeFloat(f);
                    if (this.mRemote.transact(43, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().setVideoDataRate(f);
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public float getMinVideoDataRate() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(44, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getMinVideoDataRate();
                    }
                    obtain2.readException();
                    float readFloat = obtain2.readFloat();
                    obtain2.recycle();
                    obtain.recycle();
                    return readFloat;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public float getMaxVideoDataRate() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(45, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getMaxVideoDataRate();
                    }
                    obtain2.readException();
                    float readFloat = obtain2.readFloat();
                    obtain2.recycle();
                    obtain.recycle();
                    return readFloat;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void toggleLEDs() {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(46, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().toggleLEDs();
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public void toggleLight() {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(47, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().toggleLight();
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public boolean hasSpotlight() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean z = false;
                    if (!this.mRemote.transact(48, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().hasSpotlight();
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void spotlightBrightness(int i) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (this.mRemote.transact(49, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().spotlightBrightness(i);
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public boolean hasBeacon() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean z = false;
                    if (!this.mRemote.transact(50, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().hasBeacon();
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean hasAuxLightTop() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean z = false;
                    if (!this.mRemote.transact(51, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().hasAuxLightTop();
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean hasAuxLightBottom() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean z = false;
                    if (!this.mRemote.transact(52, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().hasAuxLightBottom();
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void toggleAuxLightTop() {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(53, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().toggleAuxLightTop();
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public void toggleAuxLightBottom() {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(54, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().toggleAuxLightBottom();
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public boolean hasSpeaker() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean z = false;
                    if (!this.mRemote.transact(55, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().hasSpeaker();
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getFileListState() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(56, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getFileListState();
                    }
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void refreshSoundList() {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(57, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().refreshSoundList();
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public List<String> getLoadedSoundNames() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(58, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getLoadedSoundNames();
                    }
                    obtain2.readException();
                    ArrayList<String> createStringArrayList = obtain2.createStringArrayList();
                    obtain2.recycle();
                    obtain.recycle();
                    return createStringArrayList;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean isSoundPlaying() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean z = false;
                    if (!this.mRemote.transact(59, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().isSoundPlaying();
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void loadSound(String str) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (this.mRemote.transact(60, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().loadSound(str);
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public void playSound(String str) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (this.mRemote.transact(61, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().playSound(str);
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public void setCurrentSound(String str) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (this.mRemote.transact(62, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().setCurrentSound(str);
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public void stopSound() {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(63, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().stopSound();
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public void deleteSound(String str) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (this.mRemote.transact(64, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().deleteSound(str);
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public String getPlayMode() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(65, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getPlayMode();
                    }
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setPlayMode(String str) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (this.mRemote.transact(66, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().setPlayMode(str);
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public int getSpeakerVolume() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(67, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getSpeakerVolume();
                    }
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    obtain2.recycle();
                    obtain.recycle();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setSpeakerVolume(int i, boolean z) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    if (this.mRemote.transact(68, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().setSpeakerVolume(i, z);
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public boolean hasThermalCamera() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean z = false;
                    if (!this.mRemote.transact(69, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().hasThermalCamera();
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void toggleThermal() {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(70, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().toggleThermal();
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public String getThermalPalette() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(71, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getThermalPalette();
                    }
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setThermalPalette(String str) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (this.mRemote.transact(72, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().setThermalPalette(str);
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public String getThermalScene() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(73, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getThermalScene();
                    }
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setThermalScene(String str) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (this.mRemote.transact(74, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().setThermalScene(str);
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public String getThermalGain() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(75, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getThermalGain();
                    }
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setThermalGain(String str) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (this.mRemote.transact(76, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().setThermalGain(str);
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public String getThermalROI() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(77, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getThermalROI();
                    }
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setThermalROI(String str) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (this.mRemote.transact(78, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().setThermalROI(str);
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public String getThermalIsoTempUnits() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(79, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getThermalIsoTempUnits();
                    }
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int getThermalIsoTempMin() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(80, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getThermalIsoTempMin();
                    }
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    obtain2.recycle();
                    obtain.recycle();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int getThermalIsoTempMax() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(81, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getThermalIsoTempMax();
                    }
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    obtain2.recycle();
                    obtain.recycle();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean getThermalIsoEnabled() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean z = false;
                    if (!this.mRemote.transact(82, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getThermalIsoEnabled();
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int getThermalIsoTempLow() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(83, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getThermalIsoTempLow();
                    }
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    obtain2.recycle();
                    obtain.recycle();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int getThermalIsoTempMid() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(84, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getThermalIsoTempMid();
                    }
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    obtain2.recycle();
                    obtain.recycle();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int getThermalIsoTempHigh() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(85, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getThermalIsoTempHigh();
                    }
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    obtain2.recycle();
                    obtain.recycle();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean setThermalIsoEnabled(boolean z) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean z2 = true;
                    obtain.writeInt(z ? 1 : 0);
                    if (!this.mRemote.transact(86, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().setThermalIsoEnabled(z);
                    }
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z2 = false;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z2;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int setThermalIsoTempLow(int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(87, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().setThermalIsoTempLow(i);
                    }
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    obtain2.recycle();
                    obtain.recycle();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int setThermalIsoTempMid(int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(88, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().setThermalIsoTempMid(i);
                    }
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    obtain2.recycle();
                    obtain.recycle();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int setThermalIsoTempHigh(int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(89, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().setThermalIsoTempHigh(i);
                    }
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    obtain2.recycle();
                    obtain.recycle();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean getThermalMetering() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean z = false;
                    if (!this.mRemote.transact(90, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getThermalMetering();
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean toggleThermalMetering() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean z = false;
                    if (!this.mRemote.transact(91, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().toggleThermalMetering();
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public ThermalData getThermalMeterData(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (!this.mRemote.transact(92, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getThermalMeterData(str);
                    }
                    obtain2.readException();
                    ThermalData createFromParcel = obtain2.readInt() != 0 ? ThermalData.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return createFromParcel;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int getMSXLevel() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(93, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getMSXLevel();
                    }
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    obtain2.recycle();
                    obtain.recycle();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int setMSXLevel(int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(94, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().setMSXLevel(i);
                    }
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    obtain2.recycle();
                    obtain.recycle();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void turnOnThermalMetering() {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(95, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().turnOnThermalMetering();
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public void startRCPairing() {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(96, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().startRCPairing();
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public void stopRCPairing() {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(97, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().stopRCPairing();
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public String getAccelState() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(98, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getAccelState();
                    }
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void startAccelCalib() {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(Stub.TRANSACTION_startAccelCalib, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().startAccelCalib();
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public String getAccelCalibStatus() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(100, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getAccelCalibStatus();
                    }
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getGyroState() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(101, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getGyroState();
                    }
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void startGyroCalib() {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(102, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().startGyroCalib();
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public String getGyroCalibStatus() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(103, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getGyroCalibStatus();
                    }
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getCompassState() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(104, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getCompassState();
                    }
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void startCompassCalib() {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(105, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().startCompassCalib();
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public void stopCompassCalib() {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(106, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().stopCompassCalib();
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public String getCompassCalibStatus() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(107, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getCompassCalibStatus();
                    }
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getGimbalMode() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(108, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getGimbalMode();
                    }
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void startGimbalCalib() {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(109, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().startGimbalCalib();
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public String getGimbalCalibStatus() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(110, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getGimbalCalibStatus();
                    }
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int getMaxAltitude() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(111, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getMaxAltitude();
                    }
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    obtain2.recycle();
                    obtain.recycle();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String setMaxAltitude(int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(112, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().setMaxAltitude(i);
                    }
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int getMaxDistance() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(113, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getMaxDistance();
                    }
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    obtain2.recycle();
                    obtain.recycle();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String setMaxDistance(int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(114, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().setMaxDistance(i);
                    }
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String setGoHomeBattPct(int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(115, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().setGoHomeBattPct(i);
                    }
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int getGoHomeBattPct() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(116, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getGoHomeBattPct();
                    }
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    obtain2.recycle();
                    obtain.recycle();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String setGoHomeAlt(int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(117, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().setGoHomeAlt(i);
                    }
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int getGoHomeAlt() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(118, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getGoHomeAlt();
                    }
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    obtain2.recycle();
                    obtain.recycle();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String setLandNowBattPct(int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(119, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().setLandNowBattPct(i);
                    }
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int getLandNowBattPct() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(120, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getLandNowBattPct();
                    }
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    obtain2.recycle();
                    obtain.recycle();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String setConnLossBehav(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (!this.mRemote.transact(121, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().setConnLossBehav(str);
                    }
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getConnLossBehav() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(122, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getConnLossBehav();
                    }
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String setCollAvoid(boolean z) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(z ? 1 : 0);
                    if (!this.mRemote.transact(123, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().setCollAvoid(z);
                    }
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean getCollAvoid() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean z = false;
                    if (!this.mRemote.transact(124, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getCollAvoid();
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String setActiveAvoid(boolean z) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(z ? 1 : 0);
                    if (!this.mRemote.transact(125, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().setActiveAvoid(z);
                    }
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean getActiveAvoid() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean z = false;
                    if (!this.mRemote.transact(126, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getActiveAvoid();
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String setVisionPos(boolean z) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(z ? 1 : 0);
                    if (!this.mRemote.transact(127, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().setVisionPos(z);
                    }
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean getVisionPos() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean z = false;
                    if (!this.mRemote.transact(128, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getVisionPos();
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String setPrecLand(boolean z) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(z ? 1 : 0);
                    if (!this.mRemote.transact(129, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().setPrecLand(z);
                    }
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean getPrecLand() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean z = false;
                    if (!this.mRemote.transact(130, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getPrecLand();
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String setLandProt(boolean z) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(z ? 1 : 0);
                    if (!this.mRemote.transact(131, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().setLandProt(z);
                    }
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean getLandProt() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean z = false;
                    if (!this.mRemote.transact(132, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getLandProt();
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean hasWiFi() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean z = false;
                    if (!this.mRemote.transact(133, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().hasWiFi();
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getWiFiSSID() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(134, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getWiFiSSID();
                    }
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String setWiFiSSID(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (!this.mRemote.transact(135, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().setWiFiSSID(str);
                    }
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getWiFiPassword() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(136, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getWiFiPassword();
                    }
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String setWiFiPassword(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (!this.mRemote.transact(137, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().setWiFiPassword(str);
                    }
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getWiFiFrequencyBand() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(138, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getWiFiFrequencyBand();
                    }
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String setWiFiFrequencyBand(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (!this.mRemote.transact(139, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().setWiFiFrequencyBand(str);
                    }
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getWiFiChannelMode() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(140, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getWiFiChannelMode();
                    }
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String setWiFiChannelMode(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (!this.mRemote.transact(141, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().setWiFiChannelMode(str);
                    }
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int getWiFiChannelNumber() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(142, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getWiFiChannelNumber();
                    }
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    obtain2.recycle();
                    obtain.recycle();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int[] getWiFiChannelNumbers() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(143, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getWiFiChannelNumbers();
                    }
                    obtain2.readException();
                    int[] createIntArray = obtain2.createIntArray();
                    obtain2.recycle();
                    obtain.recycle();
                    return createIntArray;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String setWiFiChannelNumber(int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(144, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().setWiFiChannelNumber(i);
                    }
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getWiFiDataRate() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(145, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getWiFiDataRate();
                    }
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String setWiFiDataRate(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (!this.mRemote.transact(146, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().setWiFiDataRate(str);
                    }
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean hasOcuSync() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean z = false;
                    if (!this.mRemote.transact(147, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().hasOcuSync();
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getOcuSyncChannelMode() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(148, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getOcuSyncChannelMode();
                    }
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String setOcuSyncChannelMode(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (!this.mRemote.transact(149, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().setOcuSyncChannelMode(str);
                    }
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getOcuSyncChannelBandwidth() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(150, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getOcuSyncChannelBandwidth();
                    }
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String[] getOcuSyncChannelBandwidths() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(151, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getOcuSyncChannelBandwidths();
                    }
                    obtain2.readException();
                    String[] createStringArray = obtain2.createStringArray();
                    obtain2.recycle();
                    obtain.recycle();
                    return createStringArray;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String setOcuSyncChannelBandwidth(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (!this.mRemote.transact(152, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().setOcuSyncChannelBandwidth(str);
                    }
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int getOcuSyncChannelNumber() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(153, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getOcuSyncChannelNumber();
                    }
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    obtain2.recycle();
                    obtain.recycle();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int[] getOcuSyncChannelNumberRange() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(154, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getOcuSyncChannelNumberRange();
                    }
                    obtain2.readException();
                    int[] createIntArray = obtain2.createIntArray();
                    obtain2.recycle();
                    obtain.recycle();
                    return createIntArray;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String setOcuSyncChannelNumber(int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(155, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().setOcuSyncChannelNumber(i);
                    }
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getOcuSyncFrequencyBand() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(156, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getOcuSyncFrequencyBand();
                    }
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String[] getOcuSyncFrequencyBands() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(157, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getOcuSyncFrequencyBands();
                    }
                    obtain2.readException();
                    String[] createStringArray = obtain2.createStringArray();
                    obtain2.recycle();
                    obtain.recycle();
                    return createStringArray;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String setOcuSyncFrequencyBand(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (!this.mRemote.transact(158, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().setOcuSyncFrequencyBand(str);
                    }
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean hasLightBridge() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean z = false;
                    if (!this.mRemote.transact(159, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().hasLightBridge();
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getLightBridgeChannelMode() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(160, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getLightBridgeChannelMode();
                    }
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String setLightBridgeChannelMode(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (!this.mRemote.transact(161, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().setLightBridgeChannelMode(str);
                    }
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int getLightBridgeChannelNumber() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(162, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getLightBridgeChannelNumber();
                    }
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    obtain2.recycle();
                    obtain.recycle();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int[] getLightBridgeChannelNumberRange() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(163, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getLightBridgeChannelNumberRange();
                    }
                    obtain2.readException();
                    int[] createIntArray = obtain2.createIntArray();
                    obtain2.recycle();
                    obtain.recycle();
                    return createIntArray;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String setLightBridgeChannelNumber(int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(164, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().setLightBridgeChannelNumber(i);
                    }
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getLightBridgeDataRate() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(165, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getLightBridgeDataRate();
                    }
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String setLightBridgeDataRate(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (!this.mRemote.transact(166, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().setLightBridgeDataRate(str);
                    }
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getLightBridgeTransmissionMode() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(167, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getLightBridgeTransmissionMode();
                    }
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String setLightBridgeTransmissionMode(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (!this.mRemote.transact(168, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().setLightBridgeTransmissionMode(str);
                    }
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getLightBridgeFrequencyBand() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(169, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getLightBridgeFrequencyBand();
                    }
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String[] getLightBridgeFrequencyBands() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(170, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getLightBridgeFrequencyBands();
                    }
                    obtain2.readException();
                    String[] createStringArray = obtain2.createStringArray();
                    obtain2.recycle();
                    obtain.recycle();
                    return createStringArray;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String setLightBridgeFrequencyBand(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (!this.mRemote.transact(171, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().setLightBridgeFrequencyBand(str);
                    }
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public List<String> getResFPSList() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(172, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getResFPSList();
                    }
                    obtain2.readException();
                    ArrayList<String> createStringArrayList = obtain2.createStringArrayList();
                    obtain2.recycle();
                    obtain.recycle();
                    return createStringArrayList;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String setResFPS(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (!this.mRemote.transact(173, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().setResFPS(str);
                    }
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getResFPS() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(174, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getResFPS();
                    }
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void formatSDCardStart() {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(175, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().formatSDCardStart();
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public void formatInternalStart() {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(176, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().formatInternalStart();
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public boolean setVirtualStickMode(boolean z) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean z2 = true;
                    obtain.writeInt(z ? 1 : 0);
                    if (!this.mRemote.transact(177, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().setVirtualStickMode(z);
                    }
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z2 = false;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z2;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void joystickPosition(float f, float f2, float f3, float f4) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeFloat(f);
                    obtain.writeFloat(f2);
                    obtain.writeFloat(f3);
                    obtain.writeFloat(f4);
                    if (this.mRemote.transact(178, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().joystickPosition(f, f2, f3, f4);
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public void register() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(179, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().register();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean isLDMSupported() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean z = false;
                    if (!this.mRemote.transact(180, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().isLDMSupported();
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean getLDMSupported() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean z = false;
                    if (!this.mRemote.transact(181, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getLDMSupported();
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean isLDMEnabled() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean z = false;
                    if (!this.mRemote.transact(182, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().isLDMEnabled();
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean enableLDM(boolean z) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean z2 = true;
                    obtain.writeInt(z ? 1 : 0);
                    if (!this.mRemote.transact(183, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().enableLDM(z);
                    }
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z2 = false;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z2;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean getRestrictLandingGear() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean z = false;
                    if (!this.mRemote.transact(184, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getRestrictLandingGear();
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean hasLandingGear() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean z = false;
                    if (!this.mRemote.transact(185, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().hasLandingGear();
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean setRestrictLandingGear(boolean z) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean z2 = true;
                    obtain.writeInt(z ? 1 : 0);
                    if (!this.mRemote.transact(186, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().setRestrictLandingGear(z);
                    }
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z2 = false;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z2;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean usesYUV() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean z = false;
                    if (!this.mRemote.transact(Stub.TRANSACTION_usesYUV, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().usesYUV();
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void initPwmSettings(int i, int i2) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    if (this.mRemote.transact(188, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().initPwmSettings(i, i2);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setPwm(int i, int i2) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    if (this.mRemote.transact(189, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().setPwm(i, i2);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void checkOnboardSdkAvailable() {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(190, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().checkOnboardSdkAvailable();
                    }
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IDjiAtakInterface iDjiAtakInterface) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            } else if (iDjiAtakInterface == null) {
                return false;
            } else {
                Proxy.sDefaultImpl = iDjiAtakInterface;
                return true;
            }
        }

        public static IDjiAtakInterface getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
