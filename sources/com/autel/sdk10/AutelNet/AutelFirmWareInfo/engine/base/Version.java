package com.autel.sdk10.AutelNet.AutelFirmWareInfo.engine.base;

public class Version extends AbstractVersion {
    protected final int STATUS_OK = 0;

    /* renamed from: id */
    private int f8507id;

    public String getMethodName() {
        return null;
    }

    public String getSocketIp() {
        return null;
    }

    public int getSocketPort() {
        return 0;
    }

    public void jsonParser(String str) {
    }

    /* access modifiers changed from: protected */
    public void setRequestId(int i) {
        this.f8507id = i;
    }

    public int getRequestId() {
        return this.f8507id;
    }
}
