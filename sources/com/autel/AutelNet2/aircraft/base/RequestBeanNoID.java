package com.autel.AutelNet2.aircraft.base;

public class RequestBeanNoID<T> {
    private String method;
    private T params;

    public RequestBeanNoID(T t) {
        setParams(t);
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
