package com.autel.internal.sdk.camera.data.model;

import com.autel.common.camera.XT706.IrPosition;
import com.autel.common.camera.base.HDRStatus;
import com.autel.common.camera.media.FlashCardStatus;
import com.autel.common.camera.media.SpotMeteringArea;
import com.autel.common.camera.media.VideoEncoderConfiguration;
import com.autel.internal.sdk.camera.data.base.CameraData;
import java.util.List;

public class CameraXB015Data extends CameraData {
    private int AFAssistFocusEnable;
    private String AFMode;
    private double ApertureValue;
    private int AutoSnapshotEnable;
    private int AutoSnapshotInterval;
    private int Captured;
    private boolean DeFogStatus;
    private int DeFogStrength;
    private String DisplayMode;
    private String FocusMode;
    private float HFOV;
    private String ISOMode;
    private boolean ImageRoiStatus;
    private int ImageRoiStrength;
    private String IrColor;
    private IrPosition IrPosition;
    private String LensModel;
    private int MFAssistFocusEnable;
    private long MMCFreeSpace;
    private String MMCStatus;
    private long MMCTotalSpace;
    private int ObjectDistance;
    private String ShutterMode;
    private List<SpotMeteringArea> SpotArea;
    private int StorageType;
    private int Supported;
    private int TimeLeft;
    private float VFOV;
    private FlashCardStatus flashCardStatus;
    private HDRStatus hdrStatus;
    private List<VideoEncoderConfiguration> videoEncoderConfiguration;

    private CameraXB015Data() {
    }

    private static class CameraXB015DataHolder {
        /* access modifiers changed from: private */
        public static final CameraXB015Data s_instance = new CameraXB015Data();

        private CameraXB015DataHolder() {
        }
    }

    public static CameraXB015Data instance() {
        return CameraXB015DataHolder.s_instance;
    }

    public String getISOMode() {
        return this.ISOMode;
    }

    public void setISOMode(String str) {
        this.ISOMode = str;
    }

    public float getVFOV() {
        return this.VFOV;
    }

    public void setVFOV(float f) {
        this.VFOV = f;
    }

    public float getHFOV() {
        return this.HFOV;
    }

    public void setHFOV(float f) {
        this.HFOV = f;
    }

    public String getLensModel() {
        return this.LensModel;
    }

    public void setLensModel(String str) {
        this.LensModel = str;
    }

    public IrPosition getIrPosition() {
        return this.IrPosition;
    }

    public void setIrPosition(IrPosition irPosition) {
        this.IrPosition = irPosition;
    }

    public int getImageRoiStrength() {
        return this.ImageRoiStrength;
    }

    public void setImageRoiStrength(int i) {
        this.ImageRoiStrength = i;
    }

    public int getDeFogStrength() {
        return this.DeFogStrength;
    }

    public void setDeFogStrength(int i) {
        this.DeFogStrength = i;
    }

    public boolean isDeFogStatus() {
        return this.DeFogStatus;
    }

    public void setDeFogStatus(boolean z) {
        this.DeFogStatus = z;
    }

    public boolean isImageRoiStatus() {
        return this.ImageRoiStatus;
    }

    public void setImageRoiStatus(boolean z) {
        this.ImageRoiStatus = z;
    }

    public HDRStatus getHdrStatus() {
        return this.hdrStatus;
    }

    public void setHdrStatus(HDRStatus hDRStatus) {
        this.hdrStatus = hDRStatus;
    }

    public String getMMCStatus() {
        return this.MMCStatus;
    }

    public void setMMCStatus(String str) {
        this.MMCStatus = str;
    }

    public long getMMCTotalSpace() {
        return this.MMCTotalSpace;
    }

    public void setMMCTotalSpace(long j) {
        this.MMCTotalSpace = j;
    }

    public long getMMCFreeSpace() {
        return this.MMCFreeSpace;
    }

    public void setMMCFreeSpace(long j) {
        this.MMCFreeSpace = j;
    }

    public FlashCardStatus getFlashCardStatus() {
        return this.flashCardStatus;
    }

    public void setFlashCardStatus(FlashCardStatus flashCardStatus2) {
        this.flashCardStatus = flashCardStatus2;
    }

    public int getStorageType() {
        return this.StorageType;
    }

    public void setStorageType(int i) {
        this.StorageType = i;
    }

    public int getAFAssistFocusEnable() {
        return this.AFAssistFocusEnable;
    }

    public void setAFAssistFocusEnable(int i) {
        this.AFAssistFocusEnable = i;
    }

    public int getMFAssistFocusEnable() {
        return this.MFAssistFocusEnable;
    }

    public void setMFAssistFocusEnable(int i) {
        this.MFAssistFocusEnable = i;
    }

    public String getShutterMode() {
        return this.ShutterMode;
    }

    public void setShutterMode(String str) {
        this.ShutterMode = str;
    }

    public double getApertureValue() {
        return this.ApertureValue;
    }

    public void setApertureValue(double d) {
        this.ApertureValue = d;
    }

    public String getFocusMode() {
        return this.FocusMode;
    }

    public void setFocusMode(String str) {
        this.FocusMode = str;
    }

    public String getAFMode() {
        return this.AFMode;
    }

    public void setAFMode(String str) {
        this.AFMode = str;
    }

    public List<SpotMeteringArea> getSpotArea() {
        return this.SpotArea;
    }

    public void setSpotArea(List<SpotMeteringArea> list) {
        this.SpotArea = list;
    }

    public int getObjectDistance() {
        return this.ObjectDistance;
    }

    public void setObjectDistance(int i) {
        this.ObjectDistance = i;
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

    public int getAutoSnapshotEnable() {
        return this.AutoSnapshotEnable;
    }

    public void setAutoSnapshotEnable(int i) {
        this.AutoSnapshotEnable = i;
    }

    public int getAutoSnapshotInterval() {
        return this.AutoSnapshotInterval;
    }

    public void setAutoSnapshotInterval(int i) {
        this.AutoSnapshotInterval = i;
    }

    public List<VideoEncoderConfiguration> getVideoEncoderConfiguration() {
        return this.videoEncoderConfiguration;
    }

    public void setVideoEncoderConfiguration(List<VideoEncoderConfiguration> list) {
        this.videoEncoderConfiguration = list;
    }

    public String getDisplayMode() {
        return this.DisplayMode;
    }

    public void setDisplayMode(String str) {
        this.DisplayMode = str;
    }

    public String getIrColor() {
        return this.IrColor;
    }

    public void setIrColor(String str) {
        this.IrColor = str;
    }
}
