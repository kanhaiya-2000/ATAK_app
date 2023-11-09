package com.autel.AutelNet2.aircraft.base;

public class RequestBean<T> {

    /* renamed from: id */
    private int f8427id;
    private String method;
    private T params;

    public RequestBean(T t) {
        setParams(t);
    }

    public int getId() {
        return this.f8427id;
    }

    public void setId(int i) {
        this.f8427id = i;
    }

    public String getMethod() {
        return this.method;
    }

    public void setMethod(String str) {
        this.method = str;
    }

    public T getParams() {
        return this.params;
    }

    public void setParams(T t) {
        this.params = t;
    }
}
