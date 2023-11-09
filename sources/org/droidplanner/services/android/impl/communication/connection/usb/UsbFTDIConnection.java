package org.droidplanner.services.android.impl.communication.connection.usb;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import atakplugin.UASTool.C0870td;
import atakplugin.UASTool.C0879tj;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicReference;
import org.droidplanner.services.android.impl.communication.connection.usb.UsbConnection;

class UsbFTDIConnection extends UsbConnection.UsbConnectionImpl {
    private static final byte LATENCY_TIMER = 32;
    private static final String TAG = "UsbFTDIConnection";
    private final AtomicReference<C0879tj> ftDevRef = new AtomicReference<>();

    protected UsbFTDIConnection(Context context, UsbConnection usbConnection, int i) {
        super(context, usbConnection, i);
    }

    /* access modifiers changed from: protected */
    public void openUsbConnection(Bundle bundle) {
        C0870td tdVar;
        String str;
        try {
            tdVar = C0870td.m13889a(this.mContext);
        } catch (C0870td.C0871a e) {
            this.mLogger.logErr(TAG, (Exception) e);
            tdVar = null;
        }
        if (tdVar != null) {
            int b = tdVar.mo5813b(this.mContext);
            String str2 = TAG;
            Log.d(str2, "Found " + b + " ftdi devices.");
            str = "No Devices found";
            if (b >= 1) {
                try {
                    C0879tj a = tdVar.mo5804a(this.mContext, 0);
                    if (a != null) {
                        Log.d(str2, "Opening using Baud rate " + this.mBaudRate);
                        a.mo5845a((byte) 0, (byte) 0);
                        a.mo5848a(this.mBaudRate);
                        a.mo5846a((byte) 8, (byte) 0, (byte) 0);
                        a.mo5852a(0, (byte) 0, (byte) 0);
                        a.mo5858b((byte) 32);
                        a.mo5844a((byte) 3);
                        if (a.mo5864f()) {
                            Log.d(str2, "COM open");
                            this.ftDevRef.set(a);
                            onUsbConnectionOpened(bundle);
                            return;
                        }
                        str = "Unable to open usb device connection.";
                        throw new IOException(str);
                    }
                    throw new IOException(str);
                } catch (NullPointerException e2) {
                    Log.e(TAG, e2.getMessage(), e2);
                    throw new IOException(str);
                } finally {
                    IOException iOException = new IOException(str);
                }
            } else {
                throw new IOException(str);
            }
        } else {
            throw new IOException("Unable to retrieve D2xxManager instance.");
        }
    }

    /* access modifiers changed from: protected */
    public int readDataBlock(byte[] bArr) {
        C0879tj tjVar = this.ftDevRef.get();
        if (tjVar == null || !tjVar.mo5864f()) {
            throw new IOException("Device is unavailable.");
        }
        int l = tjVar.mo5870l();
        if (l > 0) {
            if (l > 4096) {
                l = 4096;
            }
            try {
                tjVar.mo5837a(bArr, l);
            } catch (NullPointerException e) {
                String str = "Error Reading: " + e.getMessage() + "\nAssuming inaccessible USB device.  Closing connection.";
                Log.e(TAG, str, e);
                throw new IOException(str, e);
            }
        }
        if (l == 0) {
            return -1;
        }
        return l;
    }

    /* access modifiers changed from: protected */
    public void sendBuffer(byte[] bArr) {
        C0879tj tjVar = this.ftDevRef.get();
        if (tjVar != null && tjVar.mo5864f()) {
            try {
                tjVar.mo5855b(bArr);
            } catch (Exception e) {
                String str = TAG;
                Log.e(str, "Error Sending: " + e.getMessage(), e);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void closeUsbConnection() {
        C0879tj andSet = this.ftDevRef.getAndSet((Object) null);
        if (andSet != null) {
            try {
                andSet.mo5865g();
            } catch (Exception e) {
                Log.e(TAG, e.getMessage(), e);
            }
        }
    }

    public String toString() {
        return TAG;
    }
}
