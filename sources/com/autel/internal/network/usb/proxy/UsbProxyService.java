package com.autel.internal.network.usb.proxy;

import android.content.Context;
import android.content.Intent;
import com.autel.internal.network.usb.broadcast.UsbReceiver;
import com.autel.video.NetWorkProxyJni;

public class UsbProxyService {
    private static UsbProxyService instance;
    /* access modifiers changed from: private */
    public int mFailedCount;
    private Thread mReceiveProxyThread = null;

    static /* synthetic */ int access$008(UsbProxyService usbProxyService) {
        int i = usbProxyService.mFailedCount;
        usbProxyService.mFailedCount = i + 1;
        return i;
    }

    public static UsbProxyService instance() {
        if (instance == null) {
            instance = new UsbProxyService();
        }
        return instance;
    }

    public void start() {
        destorySession();
        Thread thread = new Thread(new UsbRvcThread(), "mReceiveProxyThread");
        this.mReceiveProxyThread = thread;
        thread.start();
    }

    class UsbRvcThread implements Runnable {
        UsbRvcThread() {
        }

        public void run() {
            byte[] bArr = new byte[6000];
            while (!Thread.currentThread().isInterrupted()) {
                int readProxyData = NetWorkProxyJni.readProxyData(bArr, 6000, 500);
                if (readProxyData > 0 && !AutelUSBHelper.instance().writeUsbData(bArr, readProxyData)) {
                    UsbProxyService.access$008(UsbProxyService.this);
                    if (UsbProxyService.this.mFailedCount > 100) {
                        int unused = UsbProxyService.this.mFailedCount = 0;
                        Context context = AutelUSBHelper.instance().getContext();
                        if (context != null) {
                            context.sendBroadcast(new Intent(UsbReceiver.USB_RESET));
                        }
                    }
                }
            }
        }
    }

    public void destorySession() {
        Thread thread = this.mReceiveProxyThread;
        if (thread != null && !thread.isInterrupted()) {
            this.mReceiveProxyThread.interrupt();
            this.mReceiveProxyThread = null;
        }
    }
}
