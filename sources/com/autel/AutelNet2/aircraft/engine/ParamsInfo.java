package com.autel.AutelNet2.aircraft.engine;

public class ParamsInfo {
    private String ParamId;
    private int ParamType;
    private float ParamValue;

    public double getParamValue() {
        return (double) this.ParamValue;
    }

    public void setParamValue(float f) {
        this.ParamValue = f;
    }

    public int getParamType() {
        return this.ParamType;
    }

    public void setParamType(int i) {
        this.ParamType = i;
    }

    public String getParamId() {
        return this.ParamId;
    }

    public void setParamId(String str) {
        this.ParamId = str;
    }
}
