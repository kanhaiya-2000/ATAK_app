package com.atakmap.android.uastool.utils;

import android.net.nsd.NsdManager;
import android.net.nsd.NsdServiceInfo;
import android.util.ArrayMap;
import com.atakmap.coremap.log.Log;
import java.util.ArrayList;

public class DiscoveryListenerMultiplexer {
    private static final String LOG_TAG = "DiscoveryListenerMx";
    private static final ArrayMap<String, DiscoveryListenerSet> sListeners = new ArrayMap<>();

    public static void addListener(NsdManager nsdManager, String str, NsdManager.DiscoveryListener discoveryListener) {
        ArrayMap<String, DiscoveryListenerSet> arrayMap = sListeners;
        synchronized (arrayMap) {
            DiscoveryListenerSet discoveryListenerSet = arrayMap.get(str);
            if (discoveryListenerSet == null) {
                ArrayList arrayList = new ArrayList(1);
                DiscoveryListenerSet discoveryListenerSet2 = new DiscoveryListenerSet(arrayList, new MultiListener(arrayList));
                arrayMap.put(str, discoveryListenerSet2);
                discoveryListenerSet = discoveryListenerSet2;
            }
            synchronized (discoveryListenerSet.subListeners) {
                if (discoveryListenerSet.subListeners.isEmpty()) {
                    nsdManager.discoverServices(str, 1, discoveryListenerSet.mainListener);
                }
                discoveryListenerSet.subListeners.add(discoveryListener);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002f, code lost:
        r2 = r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean removeListener(android.net.nsd.NsdManager r4, android.net.nsd.NsdManager.DiscoveryListener r5) {
        /*
            android.util.ArrayMap<java.lang.String, com.atakmap.android.uastool.utils.DiscoveryListenerMultiplexer$DiscoveryListenerSet> r0 = sListeners
            monitor-enter(r0)
            java.util.Collection r1 = r0.values()     // Catch:{ all -> 0x0039 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x0039 }
            r2 = 0
        L_0x000c:
            boolean r3 = r1.hasNext()     // Catch:{ all -> 0x0039 }
            if (r3 == 0) goto L_0x0037
            java.lang.Object r2 = r1.next()     // Catch:{ all -> 0x0039 }
            com.atakmap.android.uastool.utils.DiscoveryListenerMultiplexer$DiscoveryListenerSet r2 = (com.atakmap.android.uastool.utils.DiscoveryListenerMultiplexer.DiscoveryListenerSet) r2     // Catch:{ all -> 0x0039 }
            monitor-enter(r2)     // Catch:{ all -> 0x0039 }
            java.util.ArrayList<android.net.nsd.NsdManager$DiscoveryListener> r3 = r2.subListeners     // Catch:{ all -> 0x0034 }
            boolean r3 = r3.remove(r5)     // Catch:{ all -> 0x0034 }
            if (r3 == 0) goto L_0x0031
            java.util.ArrayList<android.net.nsd.NsdManager$DiscoveryListener> r5 = r2.subListeners     // Catch:{ all -> 0x0034 }
            boolean r5 = r5.isEmpty()     // Catch:{ all -> 0x0034 }
            if (r5 == 0) goto L_0x002e
            com.atakmap.android.uastool.utils.DiscoveryListenerMultiplexer$MultiListener r5 = r2.mainListener     // Catch:{ all -> 0x0034 }
            r4.stopServiceDiscovery(r5)     // Catch:{ all -> 0x0034 }
        L_0x002e:
            monitor-exit(r2)     // Catch:{ all -> 0x0034 }
            r2 = r3
            goto L_0x0037
        L_0x0031:
            monitor-exit(r2)     // Catch:{ all -> 0x0034 }
            r2 = r3
            goto L_0x000c
        L_0x0034:
            r4 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0034 }
            throw r4     // Catch:{ all -> 0x0039 }
        L_0x0037:
            monitor-exit(r0)     // Catch:{ all -> 0x0039 }
            return r2
        L_0x0039:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0039 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.atakmap.android.uastool.utils.DiscoveryListenerMultiplexer.removeListener(android.net.nsd.NsdManager, android.net.nsd.NsdManager$DiscoveryListener):boolean");
    }

    private static class DiscoveryListenerSet {
        final MultiListener mainListener;
        final ArrayList<NsdManager.DiscoveryListener> subListeners;

        private DiscoveryListenerSet(ArrayList<NsdManager.DiscoveryListener> arrayList, MultiListener multiListener) {
            this.subListeners = arrayList;
            this.mainListener = multiListener;
        }
    }

    private static class MultiListener implements NsdManager.DiscoveryListener {
        private final ArrayList<NsdManager.DiscoveryListener> mListeners;

        public void onDiscoveryStarted(String str) {
        }

        public void onDiscoveryStopped(String str) {
        }

        public MultiListener(ArrayList<NsdManager.DiscoveryListener> arrayList) {
            this.mListeners = arrayList;
        }

        public void onStartDiscoveryFailed(String str, int i) {
            Log.w(DiscoveryListenerMultiplexer.LOG_TAG, "Failed to start network discovery for type " + str + ": " + i);
        }

        public void onStopDiscoveryFailed(String str, int i) {
            Log.w(DiscoveryListenerMultiplexer.LOG_TAG, "Failed to stop network discovery for type " + str + ": " + i);
        }

        public void onServiceFound(NsdServiceInfo nsdServiceInfo) {
            synchronized (this.mListeners) {
                int size = this.mListeners.size();
                for (int i = 0; i < size; i++) {
                    this.mListeners.get(i).onServiceFound(nsdServiceInfo);
                }
            }
        }

        public void onServiceLost(NsdServiceInfo nsdServiceInfo) {
            synchronized (this.mListeners) {
                int size = this.mListeners.size();
                for (int i = 0; i < size; i++) {
                    this.mListeners.get(i).onServiceLost(nsdServiceInfo);
                }
            }
        }
    }
}
