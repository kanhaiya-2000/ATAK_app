package com.autel.internal.sdk.camera.flirInternal;

import com.autel.internal.sdk.camera.flir.FLIRSkyCondition;
import com.autel.internal.sdk.camera.flir.TemperatureUnit;

public class FLIRRadiometrySetting {
    protected int AirTemp = -100;
    protected int Emissivity = -100;
    protected int Humidity = -1;
    protected FLIRSkyCondition SkyCond = FLIRSkyCondition.UNKNOWN;
    protected int SubjectDistance = -1;
    protected TemperatureUnit TempUnit = TemperatureUnit.UNKNOWN;
    protected boolean spotMeterEnable;

    public static FLIRRadiometrySetting create() {
        return new FlirRadiometrySettingInternal();
    }

    public TemperatureUnit getTempUnit() {
        return this.TempUnit;
    }

    public void setTempUnit(TemperatureUnit temperatureUnit) {
        this.TempUnit = temperatureUnit;
    }

    public boolean isSpotMeterEnable() {
        return this.spotMeterEnable;
    }

    public void setSpotMeter(boolean z) {
        this.spotMeterEnable = z;
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

    public FLIRSkyCondition getSkyCond() {
        return this.SkyCond;
    }

    public void setSkyCond(FLIRSkyCondition fLIRSkyCondition) {
        this.SkyCond = fLIRSkyCondition;
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

    public String toString() {
        return "TempUnit = " + this.TempUnit + "  spotMeterEnable = " + this.spotMeterEnable + "  Emissivity = " + this.Emissivity + "  AirTemp = " + this.AirTemp + " SkyCond = " + this.SkyCond + "  Humidity = " + this.Humidity + "  SubjectDistance = " + this.SubjectDistance;
    }

    public void clear() {
        this.TempUnit = TemperatureUnit.UNKNOWN;
        this.spotMeterEnable = false;
        this.Emissivity = -100;
        this.AirTemp = -100;
        this.SkyCond = FLIRSkyCondition.UNKNOWN;
        this.Humidity = -1;
        this.SubjectDistance = -1;
    }
}
