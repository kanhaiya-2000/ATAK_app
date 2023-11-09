package com.autel.camera.protocol.protocol20.entity.base;

public class RequestBean<P> {

    /* renamed from: id */
    private int f8462id;
    private String method;
    private P params;

    public String getMethod() {
        return this.method;
    }

    public void setMethod(String str) {
        this.method = str;
    }

    public int getId() {
        return this.f8462id;
    }

    public void setId(int i) {
        this.f8462id = i;
    }

    public P getParams() {
        return this.params;
    }

    public void setParams(P p) {
        this.params = p;
    }
}
