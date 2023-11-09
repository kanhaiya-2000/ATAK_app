package com.autel.internal.network.wifi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.autel.internal.network.interfaces.IAutelWifiConnectStatusListener;
import java.util.concurrent.ConcurrentHashMap;

public class AutelWifiConnectionManager {
    private static AutelWifiConnectionManager instance;
    BroadcastReceiver AutelWifiBroadcast = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                AutelWifiConnectionManager.this.callback(((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo());
            }
        }
    };
    private ConcurrentHashMap<String, IAutelWifiConnectStatusListener> listenerMaps = new ConcurrentHashMap<>();
    private Context mContext;

    public static AutelWifiConnectionManager getInstance(Context context) {
        if (instance == null) {
            instance = new AutelWifiConnectionManager(context);
        }
        return instance;
    }

    private AutelWifiConnectionManager(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public void registerReceiver() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        this.mContext.registerReceiver(this.AutelWifiBroadcast, intentFilter);
    }

    public void unregisterReceiver() {
        try {
            BroadcastReceiver broadcastReceiver = this.AutelWifiBroadcast;
            if (broadcastReceiver != null) {
                this.mContext.unregisterReceiver(broadcastReceiver);
            }
        } catch (Exception unused) {
        }
    }

    public void addIAutelWifiConnectStatusListener(String str, IAutelWifiConnectStatusListener iAutelWifiConnectStatusListener) {
        this.listenerMaps.put(str, iAutelWifiConnectStatusListener);
    }

    public void removeIAutelWifiConnectStatusListener(String str) {
        this.listenerMaps.remove(str);
    }

    /* access modifiers changed from: private */
    public void callback(NetworkInfo networkInfo) {
        if (!this.listenerMaps.isEmpty()) {
            for (IAutelWifiConnectStatusListener onReceive : this.listenerMaps.values()) {
                onReceive.onReceive(networkInfo);
            }
        }
    }
}
