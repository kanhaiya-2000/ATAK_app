package com.atakmap.android.uastool.dji;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Pair;
import android.view.Surface;
import com.atakmap.android.maps.MapView;
import com.atakmap.android.uastool.Reflector;
import com.atakmap.android.uastool.SUASIntegratorMapComponent;
import com.atakmap.android.uastool.UASItem;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.android.uastool.prefs.UASToolPreferenceFragment;
import com.atakmap.android.uastool.utils.AROverlayMuxCallback;
import com.atakmap.android.uastool.utils.Utils;
import com.atakmap.coremap.log.Log;
import com.autel.internal.video.core.decoder2.common.VideoDefaultParams;
import com.partech.mobilevid.g;
import java.util.ArrayList;
import java.util.Iterator;

public class DJIReflector extends Reflector {
    private static final String INTENT_NAME_STARTPREVIEW = "com.atakmap.android.atakgo.misc.action.START_PREVIEW";
    private static final String INTENT_NAME_STOPBROADCASTING = "com.atakmap.android.atakgo.misc.action.STOP_BROADCASTING";
    private static final String INTENT_NAME_STOPPREVIEW = "com.atakmap.android.atakgo.misc.action.STOP_PREVIEW";
    private static final String INTENT_NAME_STREAMING = "com.atakmap.android.atakgo.misc.action.STREAMING";
    private static String callsign;
    private Thread cotProducerThread = null;
    private String destinationIP;
    private int destinationPort;
    private boolean sendVideo;
    private final ArrayList<Integer> suppressedDiagCodes;

    public DJIReflector(Context context, SharedPreferences sharedPreferences, UASItem uASItem) {
        super(context, sharedPreferences, uASItem, SUASIntegratorMapComponent.NOTIFICATION_ID);
        ArrayList<Integer> arrayList = new ArrayList<>();
        this.suppressedDiagCodes = arrayList;
        TAG = DJIReflector.class.getSimpleName();
        UASToolDropDownReceiver.getInstance().getOffscreenDirector().a(VideoDefaultParams.mFormatWidth, VideoDefaultParams.mFormatHeight);
        this.sharedPrefs.registerOnSharedPreferenceChangeListener(this);
        grabSettings();
        arrayList.add(0);
        arrayList.add(7001);
    }

    public void callsignChanged(String str) {
        callsign = str;
        try {
            AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
            if (serviceConnection != null) {
                serviceConnection.getService().setCallsign(callsign);
            }
        } catch (RemoteException e) {
            Log.e(TAG, e.toString());
        }
    }

    public boolean usesYUVTexture() {
        AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
        if (serviceConnection != null) {
            return serviceConnection.usesYUV();
        }
        UASToolDropDownReceiver.toast("Unable to get usesYUV");
        return true;
    }

    public void startPreview(Surface surface) {
        if (!isPreviewActive()) {
            this.previewSurface = surface;
            Intent intent = new Intent(INTENT_NAME_STARTPREVIEW);
            intent.putExtra("surface", surface);
            UASToolDropDownReceiver.sendIntentATAKGo(intent);
            this.previewActive = true;
            streamStarted();
        }
    }

    public boolean isPreviewActive() {
        return this.previewActive;
    }

    public void stopPreview() {
        if (this.previewActive) {
            UASToolDropDownReceiver.sendIntentATAKGo(new Intent(INTENT_NAME_STOPPREVIEW));
            this.previewActive = false;
            if (this.currentStatusListener != null) {
                this.currentStatusListener.onStreamStopped();
            }
        }
    }

    public String startLocalCOT() {
        if (!this.isSendingCOTLocal) {
            grabSettings();
            synchronized (this) {
                if (this.cotProducerThread == null) {
                    Log.d(TAG, "Starting the Cot Producer");
                    this.isSendingCOTLocal = true;
                    Thread thread = new Thread(new Reflector.CotProducer(this.uasItem));
                    this.cotProducerThread = thread;
                    thread.start();
                }
            }
            return null;
        }
        Log.d(TAG, "Reflector Local CoT already running");
        return null;
    }

    public void stopLocalCOT() {
        if (this.isSendingCOTLocal) {
            synchronized (this) {
                if (this.cotProducerThread != null) {
                    Log.d(TAG, "Stopping the Cot Producer");
                    this.cotProducerThread.interrupt();
                    this.cotProducerThread = null;
                }
            }
            this.isSendingCOTLocal = false;
        }
    }

    public void run() {
        Log.d(TAG, "Starting DJI Reflector");
        startBroadcast();
    }

    public void stop() {
        Log.d(TAG, "Stopping DJI Reflector");
        stopBroadcast();
    }

    public synchronized boolean isBroadcasting() {
        return this.isBroadcasting;
    }

    public String readyToBroadcast() {
        grabSettings();
        if (TextUtils.isEmpty(callsign)) {
            return "Unable to start broadcasting: " + "missing callsign";
        } else if (!this.sendVideo) {
            return null;
        } else {
            if (TextUtils.isEmpty(this.destinationIP)) {
                return "Unable to start broadcasting: " + "missing destination IP";
            } else if (this.destinationPort > 0) {
                return null;
            } else {
                return "Unable to start broadcasting: " + "bad destination port";
            }
        }
    }

    private void grabSettings() {
        String string = this.sharedPrefs.getString(UASToolPreferenceFragment.PREF_CALLSIGN, "");
        callsign = string;
        if (TextUtils.isEmpty(string)) {
            callsign = this.uasItem.getCallsign();
        }
        this.destinationIP = UASToolDropDownReceiver.getInstance().getVideoBroadcastDestinationIP();
        this.destinationPort = Utils.parseInt(UASToolDropDownReceiver.getInstance().getVideoBroadcastDestinationPort(), -1);
        this.sendVideo = true;
        deviceUID = MapView.getDeviceUid();
    }

    private synchronized void startBroadcast() {
        grabSettings();
        this.isBroadcasting = true;
    }

    private synchronized void stopBroadcast() {
        this.isBroadcasting = false;
    }

    public g getMuxCallback() {
        return new AROverlayMuxCallback(this.uasItem);
    }

    public void destroy() {
        stopLocalCOT();
        stopPreview();
        this.sharedPrefs.unregisterOnSharedPreferenceChangeListener(this);
    }

    public String takePicture(String str, String str2, String str3) {
        try {
            AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
            if (serviceConnection == null) {
                return null;
            }
            serviceConnection.getService().takeCameraPicture(str, str2, str3);
            return null;
        } catch (RemoteException e) {
            Log.e(TAG, e.toString());
            return e.getMessage();
        }
    }

    public void updateGeoreference(double d, double d2, double d3, double d4, double d5, double d6, double d7) {
        ((DJIUASItem) this.uasItem).updateGeoreference(d, d2, d3, d4, d5, d6, d7, homeDTEDElevation);
    }

    public void updateDiagnosticInfo(ArrayList<Pair<Integer, String>> arrayList) {
        Iterator<Pair<Integer, String>> it = arrayList.iterator();
        while (it.hasNext()) {
            Pair next = it.next();
            if (this.suppressedDiagCodes.contains(Integer.valueOf(((Integer) next.first).intValue()))) {
                arrayList.remove(next);
            }
        }
        ((DJIUASItem) this.uasItem).updateDiagnosticInfo(arrayList);
    }
}
