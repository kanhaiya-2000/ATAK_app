package com.autel.AutelNet2.aircraft.engine;

public class ParamsReadInfo {
    private String ParamId;
    private double ParamIndex = -1.0d;

    public double getParamIndex() {
        return this.ParamIndex;
    }

    public void setParamIndex(double d) {
        this.ParamIndex = d;
    }

    public String getParamId() {
        return this.ParamId;
    }

    public void setParamId(String str) {
        this.ParamId = str;
    }
}
