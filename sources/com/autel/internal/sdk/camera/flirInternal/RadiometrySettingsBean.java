package com.autel.internal.sdk.camera.flirInternal;

import com.autel.internal.sdk.camera.flir.TemperatureUnit;

public class RadiometrySettingsBean {
    int AirTemp;
    int Emissivity;
    int Humidity;
    String SkyCond;
    int SpotMeter;
    int SubjectDistance;
    String TempUnit;

    public String getTempUnit() {
        return this.TempUnit;
    }

    public void setTempUnit(TemperatureUnit temperatureUnit) {
        this.TempUnit = temperatureUnit.getValue();
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

    public String getSkyCond() {
        return this.SkyCond;
    }

    public void setSkyCond(String str) {
        this.SkyCond = str;
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
