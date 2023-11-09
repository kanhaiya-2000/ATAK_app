package com.autel.internal.sdk.firmware;

public class AutelAircraftComponentVersionInfoInternal extends AutelVersionInfo implements AircraftComponentVersionInfo {
    private String Battery;
    private String Camera;
    private String DSP;
    private String Fmu;
    private String FocESC1;
    private String FocESC2;
    private String FocESC3;
    private String FocESC4;
    private String Gimbal;
    private String GimbalBootloader;
    private String GimbalPitchESC;
    private String GimbalRollESC;
    private String GimbalYawESC;
    private String LensVersion;
    private String OpticalFlow;
    private String RfRx;
    private String Router;
    private String Sonar;

    /* renamed from: TB */
    private String f8484TB;

    public void setDSP(String str) {
        this.DSP = str;
    }

    public String getDSPVersion() {
        return this.DSP;
    }

    public String[] getFocESCsVersion() {
        return new String[]{this.FocESC1, this.FocESC2, this.FocESC3, this.FocESC4};
    }

    public String getTransferBoardVersion() {
        return this.f8484TB;
    }

    public void setFocESC4(String str) {
        this.FocESC4 = str;
    }

    public String getFocESC4() {
        return this.FocESC4;
    }

    public void setFocESC3(String str) {
        this.FocESC3 = str;
    }

    public String getFocESC3() {
        return this.FocESC3;
    }

    public void setFocESC2(String str) {
        this.FocESC2 = str;
    }

    public String getFocESC2() {
        return this.FocESC2;
    }

    public void setFocESC1(String str) {
        this.FocESC1 = str;
    }

    public String getFocESC1() {
        return this.FocESC1;
    }

    public void setTB(String str) {
        this.f8484TB = str;
    }

    public String getTB() {
        return this.f8484TB;
    }

    public void setRfRx(String str) {
        this.RfRx = str;
    }

    public String getRFRXVersion() {
        return this.RfRx;
    }

    public void setGimbalYawESC(String str) {
        this.GimbalYawESC = str;
    }

    public String getGimbalYawESCVersion() {
        return this.GimbalYawESC;
    }

    public void setGimbalRollESC(String str) {
        this.GimbalRollESC = str;
    }

    public String getGimbalRollESCVersion() {
        return this.GimbalRollESC;
    }

    public void setGimbalPitchESC(String str) {
        this.GimbalPitchESC = str;
    }

    public String getGimbalPitchESCVersion() {
        return this.GimbalPitchESC;
    }

    public void setGimbalBootloader(String str) {
        this.GimbalBootloader = str;
    }

    public String getGimbalBootloaderVersion() {
        return this.GimbalBootloader;
    }

    public void setSonar(String str) {
        this.Sonar = str;
    }

    public String getSonarVersion() {
        return this.Sonar;
    }

    public void setOpticalFlow(String str) {
        this.OpticalFlow = str;
    }

    public String getOpticalFlowVersion() {
        return this.OpticalFlow;
    }

    public void setGimbal(String str) {
        this.Gimbal = str;
    }

    public String getGimbalVersion() {
        return this.Gimbal;
    }

    public void setRouter(String str) {
        this.Router = str;
    }

    public String getRouterVersion() {
        return this.Router;
    }

    public void setCamera(String str) {
        this.Camera = str;
    }

    public String getCameraVersion() {
        return this.Camera;
    }

    public void setBattery(String str) {
        this.Battery = str;
    }

    public String getBatteryVersion() {
        return this.Battery;
    }

    public synchronized void setFmu(String str) {
        this.Fmu = str;
    }

    public String getFmuVersion() {
        return this.Fmu;
    }

    public String getLensVersion() {
        return this.LensVersion;
    }

    public void setLensVersion(String str) {
        this.LensVersion = str;
    }

    public String toString() {
        return "DSP : " + this.DSP + ", Fmu : " + this.Fmu + ", Battery : " + this.Battery + ", Camera : " + this.Camera + ", LensVersion : " + this.LensVersion + ", Router : " + this.Router + ", Gimbal : " + this.Gimbal + ", OpticalFlow : " + this.OpticalFlow + ", Sonar : " + this.Sonar + ", GimbalBootloader : " + this.GimbalBootloader + ", GimbalPitchESC : " + this.GimbalPitchESC + ", GimbalRollESC : " + this.GimbalRollESC + ", GimbalYawESC : " + this.GimbalYawESC + ", RfRx : " + this.RfRx + ", TB : " + this.f8484TB + ", FocESC1 : " + this.FocESC1 + ", FocESC2 : " + this.FocESC2 + ", FocESC3 : " + this.FocESC3 + ", FocESC4 : " + this.FocESC4;
    }
}
