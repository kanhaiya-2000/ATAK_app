package com.autel.AutelNet2.aircraft.flycontroller.engine;

public class ParamsAckInfo {
    private int ParamCount;
    private String ParamId;
    private int ParamIndex;
    private int ParamType;
    private float ParamValue;

    public float getParamValue() {
        return this.ParamValue;
    }

    public void setParamValue(float f) {
        this.ParamValue = f;
    }

    public int getParamCount() {
        return this.ParamCount;
    }

    public void setParamCount(int i) {
        this.ParamCount = i;
    }

    public int getParamIndex() {
        return this.ParamIndex;
    }

    public void setParamIndex(int i) {
        this.ParamIndex = i;
    }

    public String getParamId() {
        return this.ParamId;
    }

    public void setParamId(String str) {
        this.ParamId = str;
    }

    public int getParamType() {
        return this.ParamType;
    }

    public void setParamType(int i) {
        this.ParamType = i;
    }
}
