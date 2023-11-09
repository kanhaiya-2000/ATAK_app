package com.atakmap.android.uastool.utils;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.nsd.NsdManager;
import android.net.nsd.NsdServiceInfo;
import android.preference.PreferenceManager;
import com.atakmap.android.maps.MapView;
import com.atakmap.android.uastool.pagers.avahi.AvahiServiceInfo;
import com.atakmap.android.uastool.prefs.NetworkPreferenceFragment;
import com.atakmap.coremap.log.Log;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public class AvahiService {
    public static final String SERVICE_TYPE_BH3_4586 = "_stanag4586._udp";
    public static final String SERVICE_TYPE_BH3_GUI = "_stanag4609._udp";
    public static final String SERVICE_TYPE_COT_TCP = "_cot._tcp";
    public static final String SERVICE_TYPE_COT_UDP = "_cot._udp";
    public static final String SERVICE_TYPE_HTTPS_TCP = "_https._tcp";
    public static final String SERVICE_TYPE_HTTP_TCP = "_http._tcp";
    public static final String SERVICE_TYPE_MAVLINK_TCP = "_mavlink._tcp.";
    public static final String SERVICE_TYPE_MAVLINK_UDP = "_mavlink._udp.";
    public static final String SERVICE_TYPE_MAVLINK_UDPC = "_mavlinkclient._udp.";
    public static final String SERVICE_TYPE_rtp = "_rtp._udp.";
    public static final String SERVICE_TYPE_rtsp = "_rtsp._udp.";
    /* access modifiers changed from: private */
    public static final String TAG = "AvahiService";
    private final Context atakContext;
    public ArrayList<AvahiListListener> listChangeListeners = new ArrayList<>();
    public HashMap<String, NsdManager.DiscoveryListener> mDiscoveryListeners = new HashMap<>();
    /* access modifiers changed from: private */
    public NsdManager mNsdManager;
    public ArrayList<AvahiServiceInfo> mServiceInfo = new ArrayList<>();
    private final ArrayList<String> mServices;
    /* access modifiers changed from: private */
    public ResolveThread resolveThread;
    private Thread resolver;
    AtomicBoolean resolverIsBusy = new AtomicBoolean(false);
    public final Object syncRoot = new Object();

    public interface AvahiListListener {
        void onListChanged();
    }

    public AvahiService(Context context, ArrayList<String> arrayList) {
        this.atakContext = context;
        this.mServices = arrayList;
        start();
    }

    public void dispose() {
        clear();
        this.listChangeListeners.clear();
        stop();
    }

    public void clear() {
        ((Activity) MapView.getMapView().getContext()).runOnUiThread(new Runnable() {
            public void run() {
                AvahiService.this.mServiceInfo.clear();
                AvahiService.this.listChanged();
            }
        });
    }

    public void start() {
        Log.d(TAG, "Start()");
        try {
            Thread thread = this.resolver;
            if (thread != null) {
                thread.interrupt();
            }
            ResolveThread resolveThread2 = new ResolveThread(this);
            this.resolveThread = resolveThread2;
            Thread thread2 = new Thread(resolveThread2);
            this.resolver = thread2;
            thread2.start();
            this.mNsdManager = (NsdManager) this.atakContext.getSystemService("servicediscovery");
            Iterator<String> it = this.mServices.iterator();
            while (it.hasNext()) {
                this.mDiscoveryListeners.put(it.next(), initializeDiscoveryListener());
            }
            for (String next : this.mDiscoveryListeners.keySet()) {
                this.mNsdManager.discoverServices(next, 1, this.mDiscoveryListeners.get(next));
            }
        } catch (Exception e) {
            Log.d(TAG, "start exception: ", e);
        }
    }

    public void stop() {
        try {
            Thread thread = this.resolver;
            if (thread != null) {
                thread.interrupt();
            }
            this.resolverIsBusy.set(false);
            this.resolver = null;
            for (NsdManager.DiscoveryListener stopServiceDiscovery : this.mDiscoveryListeners.values()) {
                this.mNsdManager.stopServiceDiscovery(stopServiceDiscovery);
            }
        } catch (Exception e) {
            Log.d(TAG, "stop exception: ", e);
        }
    }

    private NsdManager.DiscoveryListener initializeDiscoveryListener() {
        return new NsdManager.DiscoveryListener() {
            public void onDiscoveryStopped(String str) {
            }

            public void onServiceLost(NsdServiceInfo nsdServiceInfo) {
            }

            public void onDiscoveryStarted(String str) {
                Log.d(AvahiService.TAG, "onDiscoveryStarted");
            }

            public void onServiceFound(NsdServiceInfo nsdServiceInfo) {
                String serviceName = nsdServiceInfo.getServiceName();
                String serviceType = nsdServiceInfo.getServiceType();
                String access$000 = AvahiService.TAG;
                Log.d(access$000, "Service Name=" + serviceName);
                String access$0002 = AvahiService.TAG;
                Log.d(access$0002, "Service Type=" + serviceType + " port: " + nsdServiceInfo.getPort());
                AvahiService.this.resolveThread.resolveQueue.add(nsdServiceInfo);
            }

            public void onStartDiscoveryFailed(String str, int i) {
                Log.e(AvahiService.TAG, "onStartDiscoveryFailed");
            }

            public void onStopDiscoveryFailed(String str, int i) {
                Log.e(AvahiService.TAG, "onStopDiscoveryFailed");
            }
        };
    }

    /* access modifiers changed from: private */
    public void resolve(final NsdServiceInfo nsdServiceInfo) {
        new Thread(new Runnable() {
            public void run() {
                AvahiService.this.resolverIsBusy.set(true);
                try {
                    Thread.sleep(100);
                } catch (Exception unused) {
                }
                String access$000 = AvahiService.TAG;
                Log.d(access$000, "Resolving '" + nsdServiceInfo.getServiceName() + "'");
                AvahiService.this.mNsdManager.resolveService(nsdServiceInfo, new NsdManager.ResolveListener() {
                    public void onResolveFailed(NsdServiceInfo nsdServiceInfo, int i) {
                        String access$000 = AvahiService.TAG;
                        Log.e(access$000, nsdServiceInfo.getServiceName() + " Resolve failed" + i);
                        synchronized (AvahiService.this.syncRoot) {
                            AvahiService.this.resolverIsBusy.set(false);
                            AvahiService.this.syncRoot.notifyAll();
                        }
                    }

                    public void onServiceResolved(final NsdServiceInfo nsdServiceInfo) {
                        ((Activity) MapView.getMapView().getContext()).runOnUiThread(new Runnable() {
                            public void run() {
                                AvahiServiceInfo avahiServiceInfo = new AvahiServiceInfo(nsdServiceInfo);
                                int access$200 = AvahiService.this.find(avahiServiceInfo);
                                if (access$200 >= 0) {
                                    avahiServiceInfo.setVisible(AvahiService.this.mServiceInfo.get(access$200).isVisible());
                                    AvahiService.this.mServiceInfo.set(access$200, avahiServiceInfo);
                                } else {
                                    AvahiService.this.mServiceInfo.add(avahiServiceInfo);
                                }
                                String hostAddress = nsdServiceInfo.getHost().getHostAddress();
                                nsdServiceInfo.getServiceType();
                                String access$000 = AvahiService.TAG;
                                Log.d(access$000, "Resolved address = " + hostAddress);
                                String access$0002 = AvahiService.TAG;
                                Log.d(access$0002, "Resolved port = " + nsdServiceInfo.getPort());
                                Map<String, byte[]> attributes = nsdServiceInfo.getAttributes();
                                if (attributes != null) {
                                    for (String str : attributes.keySet()) {
                                        String access$0003 = AvahiService.TAG;
                                        Log.d(access$0003, str + ": ");
                                    }
                                }
                                AvahiService.this.listChanged();
                            }
                        });
                        synchronized (AvahiService.this.syncRoot) {
                            AvahiService.this.resolverIsBusy.set(false);
                            AvahiService.this.syncRoot.notifyAll();
                        }
                    }
                });
            }
        }).run();
    }

    /* access modifiers changed from: private */
    public int find(AvahiServiceInfo avahiServiceInfo) {
        for (int i = 0; i < this.mServiceInfo.size(); i++) {
            AvahiServiceInfo avahiServiceInfo2 = this.mServiceInfo.get(i);
            if (avahiServiceInfo2.getServiceType().equals(avahiServiceInfo.getServiceType()) && avahiServiceInfo2.getServiceName().equals(avahiServiceInfo.getServiceName())) {
                return i;
            }
        }
        return -1;
    }

    public ArrayList<AvahiServiceInfo> getList() {
        return this.mServiceInfo;
    }

    public void listChanged() {
        Iterator<AvahiListListener> it = this.listChangeListeners.iterator();
        while (it.hasNext()) {
            AvahiListListener next = it.next();
            if (next != null) {
                try {
                    next.onListChanged();
                } catch (Exception unused) {
                }
            }
        }
    }

    protected static class ResolveThread implements Runnable {
        AvahiService avahiService;
        public LinkedBlockingQueue<NsdServiceInfo> resolveQueue = new LinkedBlockingQueue<>();

        public ResolveThread(AvahiService avahiService2) {
            this.avahiService = avahiService2;
        }

        public void run() {
            while (!Thread.interrupted()) {
                try {
                    if (this.avahiService.resolverIsBusy.get()) {
                        synchronized (this.avahiService.syncRoot) {
                            this.avahiService.syncRoot.wait();
                        }
                    }
                    this.avahiService.resolve(this.resolveQueue.take());
                } catch (InterruptedException e) {
                    Log.d(AvahiService.TAG, "Resolve queue", e);
                } catch (Exception e2) {
                    Log.d(AvahiService.TAG, "AVAHI: Other Error Occured", e2);
                }
            }
        }
    }

    public void save() {
        String json = new Gson().toJson((Object) getList());
        Log.d(TAG, json);
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(MapView.getMapView().getContext()).edit();
        edit.putString(NetworkPreferenceFragment.PREF_AVAHI_SERVICE_LIST, json);
        edit.apply();
    }

    public static ArrayList<AvahiServiceInfo> getSavedServiceList() {
        String string = PreferenceManager.getDefaultSharedPreferences(MapView.getMapView().getContext()).getString(NetworkPreferenceFragment.PREF_AVAHI_SERVICE_LIST, (String) null);
        if (string == null) {
            return null;
        }
        ArrayList<AvahiServiceInfo> arrayList = (ArrayList) new Gson().fromJson(string, new ArrayList().getClass());
        String str = TAG;
        Log.d(str, "read in " + arrayList.size());
        return arrayList;
    }
}
