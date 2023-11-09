package com.autel.internal.network.usb;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.autel.internal.network.interfaces.IAutelUsbConnectionStateListener;
import com.autel.internal.network.usb.broadcast.UsbReceiver;
import com.autel.internal.network.usb.proxy.UsbProxy;
import java.util.concurrent.ConcurrentHashMap;

public class UsbProxyManager {
    private static UsbProxyManager instance;
    private ConcurrentHashMap<String, IAutelUsbConnectionStateListener> listenerMaps = new ConcurrentHashMap<>();
    private Context mContext;
    private BroadcastReceiver mUsbReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            UsbProxyManager.this.callback(intent.getAction());
        }
    };

    public static UsbProxyManager getInstance(Context context) {
        if (instance == null) {
            instance = new UsbProxyManager(context);
        }
        return instance;
    }

    private UsbProxyManager(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public void registerReceiver() {
        UsbProxy.getInstance(this.mContext).initUsb();
        UsbProxy.getInstance(this.mContext).startProxy();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(UsbReceiver.USB_ATTACH);
        intentFilter.addAction(UsbReceiver.USB_DETTACH);
        intentFilter.addAction(UsbReceiver.USB_RESET);
        this.mContext.registerReceiver(this.mUsbReceiver, intentFilter);
    }

    public void unregisterReceiver() {
        UsbProxy.getInstance(this.mContext).stopProxy();
        UsbProxy.getInstance(this.mContext).destroyUsb();
        try {
            BroadcastReceiver broadcastReceiver = this.mUsbReceiver;
            if (broadcastReceiver != null) {
                this.mContext.unregisterReceiver(broadcastReceiver);
            }
        } catch (Exception unused) {
        }
    }

    public void addIAutelUsbConnectionStateListener(String str, IAutelUsbConnectionStateListener iAutelUsbConnectionStateListener) {
        this.listenerMaps.put(str, iAutelUsbConnectionStateListener);
    }

    public void removeIAutelUsbConnectionStateListener(String str) {
        this.listenerMaps.remove(str);
    }

    /* access modifiers changed from: private */
    public void callback(String str) {
        if (!this.listenerMaps.isEmpty()) {
            for (IAutelUsbConnectionStateListener next : this.listenerMaps.values()) {
                str.hashCode();
                if (str.equals(UsbReceiver.USB_ATTACH)) {
                    next.usbConnected();
                } else if (str.equals(UsbReceiver.USB_DETTACH)) {
                    next.usbDisConnect();
                }
            }
        }
    }
}
