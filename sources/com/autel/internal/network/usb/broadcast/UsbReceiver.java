package com.autel.internal.network.usb.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.hardware.usb.UsbManager;

public class UsbReceiver extends BroadcastReceiver {
    public static final String USB_ATTACH = "com.autel.maxifly.usb.attach";
    public static final String USB_DETTACH = "com.autel.maxifly.usb.dettach";
    public static final String USB_RESET = "com.autel.maxifly.usb.reset";
    private Object lock = new Object();
    private boolean mPermissionRequestPending;
    private UsbManager mUsbManager;

    public UsbReceiver(UsbManager usbManager) {
        this.mUsbManager = usbManager;
    }

    public boolean ismPermissionRequestPending() {
        return this.mPermissionRequestPending;
    }

    public void setmPermissionRequestPending(boolean z) {
        this.mPermissionRequestPending = z;
    }

    public void onReceive(Context context, Intent intent) {
        synchronized (this.lock) {
            if (intent.getAction().equals("android.hardware.usb.action.USB_STATE")) {
                context.sendBroadcast(new Intent(intent.getExtras().getBoolean("connected") ? USB_ATTACH : USB_DETTACH));
            }
        }
    }
}
