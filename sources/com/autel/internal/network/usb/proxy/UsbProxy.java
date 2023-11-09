package com.autel.internal.network.usb.proxy;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.usb.UsbManager;
import com.autel.internal.network.usb.broadcast.UsbReceiver;
import com.autel.util.log.AutelLog;

public class UsbProxy {
    private static final String TAG_USB = "Autel_USB";
    private static UsbProxy instance;
    private boolean isInited = false;
    private Context mContext = null;
    private PendingIntent mPermissionIntent;
    private UsbManager mUsbManager;
    private UsbReceiver mUsbReceiver;

    public static UsbProxy getInstance(Context context) {
        if (instance == null) {
            instance = new UsbProxy(context);
        }
        return instance;
    }

    private UsbProxy(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public synchronized void initUsb() {
        this.mUsbManager = (UsbManager) this.mContext.getSystemService("usb");
        this.mPermissionIntent = PendingIntent.getBroadcast(this.mContext, 0, new Intent(UsbAccessoryService.ACTION_USB_PERMISSION), 0);
        this.mUsbReceiver = new UsbReceiver(this.mUsbManager);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(UsbAccessoryService.ACTION_USB_PERMISSION);
        intentFilter.addAction("android.hardware.usb.action.USB_ACCESSORY_DETACHED");
        intentFilter.addAction("android.hardware.usb.action.USB_STATE");
        this.mContext.registerReceiver(this.mUsbReceiver, intentFilter);
    }

    public synchronized void startProxy() {
        if (!this.isInited) {
            AutelLog.debug_i(AutelLog.TMP_CONNECT_ATG, "startProxy");
            UsbProxyService.instance().start();
            this.isInited = true;
        }
    }

    public synchronized void stopProxy() {
        if (this.isInited) {
            UsbProxyService.instance().destorySession();
            AutelUSBHelper.instance().closeAccessory();
            this.isInited = false;
        }
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void destroyUsb() {
        /*
            r2 = this;
            monitor-enter(r2)
            com.autel.internal.network.usb.broadcast.UsbReceiver r0 = r2.mUsbReceiver     // Catch:{ Exception -> 0x000e, all -> 0x000b }
            if (r0 == 0) goto L_0x000e
            android.content.Context r1 = r2.mContext     // Catch:{ Exception -> 0x000e, all -> 0x000b }
            r1.unregisterReceiver(r0)     // Catch:{ Exception -> 0x000e, all -> 0x000b }
            goto L_0x000e
        L_0x000b:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        L_0x000e:
            monitor-exit(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autel.internal.network.usb.proxy.UsbProxy.destroyUsb():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x005b, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void checkUsbDevice() {
        /*
            r4 = this;
            monitor-enter(r4)
            com.autel.internal.network.usb.proxy.AutelUSBHelper r0 = com.autel.internal.network.usb.proxy.AutelUSBHelper.instance()     // Catch:{ all -> 0x005c }
            boolean r0 = r0.isUsbOpened()     // Catch:{ all -> 0x005c }
            if (r0 == 0) goto L_0x000d
            monitor-exit(r4)
            return
        L_0x000d:
            android.content.Context r0 = r4.mContext     // Catch:{ all -> 0x005c }
            java.lang.String r1 = "usb"
            java.lang.Object r0 = r0.getSystemService(r1)     // Catch:{ all -> 0x005c }
            android.hardware.usb.UsbManager r0 = (android.hardware.usb.UsbManager) r0     // Catch:{ all -> 0x005c }
            r4.mUsbManager = r0     // Catch:{ all -> 0x005c }
            android.hardware.usb.UsbAccessory[] r0 = r0.getAccessoryList()     // Catch:{ all -> 0x005c }
            if (r0 == 0) goto L_0x005a
            int r1 = r0.length     // Catch:{ all -> 0x005c }
            if (r1 <= 0) goto L_0x005a
            r1 = 0
            r0 = r0[r1]     // Catch:{ all -> 0x005c }
            if (r0 == 0) goto L_0x005a
            android.hardware.usb.UsbManager r1 = r4.mUsbManager     // Catch:{ all -> 0x005c }
            boolean r1 = r1.hasPermission(r0)     // Catch:{ all -> 0x005c }
            if (r1 == 0) goto L_0x003d
            com.autel.internal.network.usb.proxy.AutelUSBHelper r1 = com.autel.internal.network.usb.proxy.AutelUSBHelper.instance()     // Catch:{ all -> 0x005c }
            android.hardware.usb.UsbManager r2 = r4.mUsbManager     // Catch:{ all -> 0x005c }
            android.os.ParcelFileDescriptor r0 = r2.openAccessory(r0)     // Catch:{ all -> 0x005c }
            r1.openAccessory(r0)     // Catch:{ all -> 0x005c }
            goto L_0x005a
        L_0x003d:
            com.autel.internal.network.usb.broadcast.UsbReceiver r1 = r4.mUsbReceiver     // Catch:{ all -> 0x005c }
            monitor-enter(r1)     // Catch:{ all -> 0x005c }
            com.autel.internal.network.usb.broadcast.UsbReceiver r2 = r4.mUsbReceiver     // Catch:{ all -> 0x0057 }
            boolean r2 = r2.ismPermissionRequestPending()     // Catch:{ all -> 0x0057 }
            if (r2 != 0) goto L_0x0055
            android.hardware.usb.UsbManager r2 = r4.mUsbManager     // Catch:{ all -> 0x0057 }
            android.app.PendingIntent r3 = r4.mPermissionIntent     // Catch:{ all -> 0x0057 }
            r2.requestPermission(r0, r3)     // Catch:{ all -> 0x0057 }
            com.autel.internal.network.usb.broadcast.UsbReceiver r0 = r4.mUsbReceiver     // Catch:{ all -> 0x0057 }
            r2 = 1
            r0.setmPermissionRequestPending(r2)     // Catch:{ all -> 0x0057 }
        L_0x0055:
            monitor-exit(r1)     // Catch:{ all -> 0x0057 }
            goto L_0x005a
        L_0x0057:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0057 }
            throw r0     // Catch:{ all -> 0x005c }
        L_0x005a:
            monitor-exit(r4)
            return
        L_0x005c:
            r0 = move-exception
            monitor-exit(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autel.internal.network.usb.proxy.UsbProxy.checkUsbDevice():void");
    }
}
