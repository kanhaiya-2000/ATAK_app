package com.autel.AutelNet2.aircraft.base;

public class BaseRequestBean {

    /* renamed from: id */
    private int f8426id;
    private String method;

    public BaseRequestBean() {
    }

    public BaseRequestBean(int i, String str) {
        setId(i);
        setMethod(str);
    }

    public String getMethod() {
        return this.method;
    }

    public void setMethod(String str) {
        this.method = str;
    }

    public int getId() {
        return this.f8426id;
    }

    public void setId(int i) {
        this.f8426id = i;
    }
}
