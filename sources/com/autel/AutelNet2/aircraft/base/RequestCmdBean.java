package com.autel.AutelNet2.aircraft.base;

public class RequestCmdBean<T> {
    private String command;

    /* renamed from: id */
    private int f8428id;
    private String method;
    private T params;

    public int getId() {
        return this.f8428id;
    }

    public void setId(int i) {
        this.f8428id = i;
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

    public String getCommand() {
        return this.command;
    }

    public void setCommand(String str) {
        this.command = str;
    }
}
