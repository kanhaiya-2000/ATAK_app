package com.autel.AutelNet2.dsp.message;

public class AppInfo {
    private String action;

    /* renamed from: id */
    private String f8437id;
    private int[] params;

    public String getAction() {
        return this.action;
    }

    public void setAction(String str) {
        this.action = str;
    }

    public String getId() {
        return this.f8437id;
    }

    public void setId(String str) {
        this.f8437id = str;
    }

    public int[] getParams() {
        return this.params;
    }

    public void setParams(int[] iArr) {
        this.params = iArr;
    }
}
