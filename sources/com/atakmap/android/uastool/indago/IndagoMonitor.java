package com.atakmap.android.uastool.indago;

import android.content.Context;
import android.content.SharedPreferences;
import com.atakmap.android.uastool.UASItem;
import com.atakmap.android.uastool.plugin.PlatformMonitor;
import com.atakmap.coremap.log.Log;
import indago.connection.ConnectionStateCallback;
import indago.connection.VehicleConnection;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public final class IndagoMonitor extends PlatformMonitor {
    /* access modifiers changed from: private */
    public static final String INDAGO_UUID = UUID.randomUUID().toString();
    /* access modifiers changed from: private */
    public static final String TAG = "IndagoMonitor";
    private boolean isChecking = false;
    /* access modifiers changed from: private */
    public final List<UASItem> items = new CopyOnWriteArrayList();
    private final AtomicInteger pingCount = new AtomicInteger(0);
    private final SharedPreferences sharedPrefs;
    private boolean shouldCaptureToStorage = false;

    public IndagoMonitor(Context context, SharedPreferences sharedPreferences) {
        super(context, IndagoUASItem.DISPLAY_NAME);
        this.sharedPrefs = sharedPreferences;
    }

    public boolean monitors(String str) {
        return this.platform.equals(str);
    }

    public void setCaptureToStorage(boolean z) {
        this.shouldCaptureToStorage = z;
    }

    /* access modifiers changed from: protected */
    public List<UASItem> getDetectedUasList() {
        String str = TAG;
        Log.v(str, "Monitoring for Indagos");
        if (!this.items.isEmpty() || this.isChecking || this.pingCount.incrementAndGet() < 4) {
            Log.d(str, "Bailing due to apparent race condition");
            return this.items;
        }
        this.isChecking = true;
        Log.d(str, "Attempting to make vehicle connection");
        String string = this.sharedPrefs.getString(IndagoPrefHandler.PREF_VCT_IP, IndagoPrefHandler.DEFAULT_VCT_IP);
        String string2 = this.sharedPrefs.getString(IndagoPrefHandler.PREF_VCT_PORT, IndagoPrefHandler.DEFAULT_VCT_PORT);
        VehicleConnection build = new VehicleConnection.Builder("http://" + string + ":" + string2).connectionTimeoutMillis(1000).ignoreErrorsInOutgoingMessages(true).ignoreIncomingMalformedData(true).ignoreUnknownIncomingMessages(true).build();
        final Object obj = new Object();
        build.addConnectionStateListener(new ConnectionStateCallback() {
            public void onConnected(VehicleConnection vehicleConnection) {
                Log.d(IndagoMonitor.TAG, "Connected");
                synchronized (obj) {
                    IndagoUASItem indagoUASItem = new IndagoUASItem(IndagoMonitor.INDAGO_UUID, "", true);
                    indagoUASItem.setConnection(vehicleConnection);
                    IndagoMonitor.this.items.add(indagoUASItem);
                    obj.notifyAll();
                }
            }

            public void onDisconnected(VehicleConnection vehicleConnection, Throwable th) {
                String access$000 = IndagoMonitor.TAG;
                StringBuilder sb = new StringBuilder();
                sb.append("Not Connected. Error: ");
                sb.append(th != null ? th.getLocalizedMessage() : "None");
                Log.d(access$000, sb.toString(), th);
                synchronized (obj) {
                    IndagoMonitor.this.items.clear();
                    obj.notifyAll();
                }
            }
        });
        Log.d(str, "Connecting");
        build.connect();
        Log.d(str, "Waiting for connection result");
        try {
            synchronized (obj) {
                obj.wait();
                this.isChecking = false;
            }
        } catch (Exception unused) {
            Log.e(TAG, "Error");
        }
        return this.items;
    }

    public void endMonitoring() {
        super.endMonitoring();
        for (UASItem next : this.items) {
            if (next instanceof IndagoUASItem) {
                IndagoUASItem indagoUASItem = (IndagoUASItem) next;
                if (indagoUASItem.getConnection() != null) {
                    indagoUASItem.getConnection().disconnect();
                }
            }
        }
    }
}
