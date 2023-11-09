package com.autel.internal.network.abstracts;

import java.io.FileInputStream;

public abstract class AbsUdpConnection {
    /* access modifiers changed from: protected */
    public abstract void closeConnection();

    /* access modifiers changed from: protected */
    public abstract String getTargetAddress();

    /* access modifiers changed from: protected */
    public abstract int getUdpPort();

    /* access modifiers changed from: protected */
    public abstract void openConnection(int i);

    /* access modifiers changed from: protected */
    public abstract int readDataBlock(byte[] bArr);

    /* access modifiers changed from: protected */
    public abstract void sendBuffer(byte[] bArr);

    /* access modifiers changed from: protected */
    public abstract void sendInputStream(FileInputStream fileInputStream);
}
