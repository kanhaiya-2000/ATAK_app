package com.autel.sdk10.AutelNet.AutelFirmWareInfo.engine.base;

public abstract class AbstractVersion {
    /* access modifiers changed from: protected */
    public abstract String getMethodName();

    /* access modifiers changed from: protected */
    public abstract int getRequestId();

    /* access modifiers changed from: protected */
    public abstract String getSocketIp();

    /* access modifiers changed from: protected */
    public abstract int getSocketPort();

    /* access modifiers changed from: protected */
    public abstract void jsonParser(String str);

    /* access modifiers changed from: protected */
    public abstract void setRequestId(int i);
}
