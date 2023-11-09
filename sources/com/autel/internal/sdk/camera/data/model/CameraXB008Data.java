package com.autel.internal.sdk.camera.data.model;

import com.autel.common.camera.media.SpotMeteringArea;
import com.autel.common.camera.media.VideoEncoderConfiguration;
import com.autel.internal.sdk.camera.data.base.CameraData;
import java.util.List;

public class CameraXB008Data extends CameraData {
    private String AFMode;
    private int Enable3DNR;
    private int EnableAudio;
    private int EnableSubtitle;
    private String FocusMode;
    private double IrisValue;
    private int ObjectDistance;
    private List<SpotMeteringArea> SpotArea;
    private List<VideoEncoderConfiguration> videoEncoderConfiguration;

    private static class CameraXB008DataHolder {
        /* access modifiers changed from: private */
        public static final CameraXB008Data s_instance = new CameraXB008Data();

        private CameraXB008DataHolder() {
        }
    }

    private CameraXB008Data() {
    }

    public static CameraXB008Data instance() {
        return CameraXB008DataHolder.s_instance;
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

    public double getIrisValue() {
        return this.IrisValue;
    }

    public void setIrisValue(double d) {
        this.IrisValue = d;
    }

    public int getEnable3DNR() {
        return this.Enable3DNR;
    }

    public void setEnable3DNR(int i) {
        this.Enable3DNR = i;
    }

    public List<VideoEncoderConfiguration> getVideoEncoderConfiguration() {
        return this.videoEncoderConfiguration;
    }

    public void setVideoEncoderConfiguration(List<VideoEncoderConfiguration> list) {
        this.videoEncoderConfiguration = list;
    }
}
