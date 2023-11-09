package com.autel.internal.network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.autel.internal.network.interfaces.IAutelNetworkConnectionListener;
import com.autel.internal.network.interfaces.IAutelUsbConnectionStateListener;
import com.autel.internal.network.interfaces.IAutelWifiConnectStatusListener;
import com.autel.internal.network.usb.UsbProxyManager;
import com.autel.internal.network.usb.proxy.AutelUSBHelper;
import com.autel.internal.network.usb.proxy.UsbProxy;
import com.autel.internal.network.wifi.AutelWifiConnectionManager;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class NetworkManager {
    public static final int RUNNABLE_CONNECTED = 1;
    public static final int RUNNABLE_DISCONNECTED = 0;
    private static NetworkManager instance;
    public Runnable checkNetworkRunnable = new Runnable() {
        public void run() {
            NetworkManager.this.mConnectionStatus.set(1);
            while (true) {
                try {
                    if (NetworkManager.this.mConnectionStatus.get() != 1) {
                        break;
                    }
                    Thread.sleep(1000);
                    if (NetworkManager.this.listenerMaps.isEmpty()) {
                        break;
                    }
                    int i = C47925.f8478x3fe4ea74[((ConnectStatus) NetworkManager.this.mConnectStatusTasks.take()).ordinal()];
                    if (i != 1) {
                        int i2 = 2;
                        if (i == 2) {
                            NetworkManager networkManager = NetworkManager.this;
                            if (networkManager.isWifiConnected()) {
                                i2 = 1;
                            }
                            networkManager.callback(i2);
                        } else if (i != 3) {
                            if (i == 4) {
                                if (!AutelUSBHelper.instance().isUsbOpened()) {
                                    NetworkManager.this.callback(2);
                                }
                            }
                        } else if (!AutelUSBHelper.instance().isUsbOpened()) {
                            NetworkManager.this.callback(1);
                        }
                    } else {
                        NetworkManager.this.callback(0);
                    }
                } catch (InterruptedException e) {
                    if (NetworkManager.this.mConnectionStatus.get() != 0) {
                        e.printStackTrace();
                    }
                } catch (Throwable th) {
                    NetworkManager.this.mConnectionStatus.set(0);
                    throw th;
                }
            }
            NetworkManager.this.mConnectionStatus.set(0);
        }
    };
    private Runnable checkUsbDevice = new Runnable() {
        public void run() {
            int i = 0;
            while (i < 30) {
                try {
                    Thread.sleep(2000);
                    UsbProxy.getInstance(NetworkManager.this.mContext).checkUsbDevice();
                    if (AutelUSBHelper.instance().isUsbOpened()) {
                        NetworkManager.this.mConnectStatusTasks.clear();
                        NetworkManager.this.mConnectStatusTasks.offer(ConnectStatus.USB_CONNECT);
                        return;
                    }
                    i++;
                } catch (Exception unused) {
                    return;
                }
            }
        }
    };
    private ExecutorService checkUsbDeviceThreadPool;
    /* access modifiers changed from: private */
    public ConcurrentHashMap<String, IAutelNetworkConnectionListener> listenerMaps = new ConcurrentHashMap<>();
    /* access modifiers changed from: private */
    public final LinkedBlockingQueue<ConnectStatus> mConnectStatusTasks = new LinkedBlockingQueue<>();
    /* access modifiers changed from: private */
    public final AtomicInteger mConnectionStatus = new AtomicInteger(0);
    /* access modifiers changed from: private */
    public Context mContext;
    private Thread mTaskThread;

    private enum ConnectStatus {
        USB_CONNECT(1),
        USB_DISCONNECT(2),
        WIFI_CONNECT(3),
        WIFI_DISCONNECT(4);
        
        private int value;

        private ConnectStatus(int i) {
            this.value = i;
        }

        public int getValue() {
            return this.value;
        }
    }

    public static NetworkManager getInstance(Context context) {
        if (instance == null) {
            instance = new NetworkManager(context);
        }
        return instance;
    }

    private NetworkManager(Context context) {
        this.mContext = context.getApplicationContext();
        AutelUSBHelper.instance().setContext(this.mContext);
        addIAutelWifiConnectStatusListener();
        registerUsbConnectionReceiver();
    }

    public void addIAutelNetworkConnectionListener(String str, IAutelNetworkConnectionListener iAutelNetworkConnectionListener) {
        this.listenerMaps.put(str, iAutelNetworkConnectionListener);
        if (this.listenerMaps.size() == 1) {
            startCheckNetworkRunnable();
        }
    }

    public void removeIAutelNetworkConnectionListener(String str) {
        this.listenerMaps.remove(str);
        if (this.listenerMaps.isEmpty()) {
            stopCheckNetworkRunnable();
        }
    }

    public void registerReceiver() {
        AutelWifiConnectionManager.getInstance(this.mContext).registerReceiver();
        UsbProxyManager.getInstance(this.mContext).registerReceiver();
    }

    public void unregisterReceiver() {
        AutelWifiConnectionManager.getInstance(this.mContext).unregisterReceiver();
        UsbProxyManager.getInstance(this.mContext).unregisterReceiver();
    }

    private void addIAutelWifiConnectStatusListener() {
        AutelWifiConnectionManager.getInstance(this.mContext).addIAutelWifiConnectStatusListener(this.mContext.getPackageName(), new IAutelWifiConnectStatusListener() {
            public void onReceive(NetworkInfo networkInfo) {
                if (!NetworkManager.this.listenerMaps.isEmpty()) {
                    boolean z = true;
                    if (networkInfo == null || networkInfo.getType() != 1) {
                        z = false;
                    }
                    NetworkManager.this.mConnectStatusTasks.offer(z ? ConnectStatus.WIFI_CONNECT : ConnectStatus.WIFI_DISCONNECT);
                }
            }
        });
    }

    private void registerUsbConnectionReceiver() {
        UsbProxyManager.getInstance(this.mContext).addIAutelUsbConnectionStateListener(this.mContext.getPackageName(), new IAutelUsbConnectionStateListener() {
            public void usbDisConnect() {
                NetworkManager.this.releaseAll();
            }

            public void usbConnected() {
                NetworkManager.this.releaseAll();
                NetworkManager.this.startCheckUsbDevice();
            }
        });
    }

    /* access modifiers changed from: private */
    public void releaseAll() {
        stopCheckUsbDevice();
        if (AutelUSBHelper.instance().isUsbOpened()) {
            AutelUSBHelper.instance().closeAccessory();
            this.mConnectStatusTasks.clear();
            this.mConnectStatusTasks.offer(ConnectStatus.USB_DISCONNECT);
        }
    }

    /* access modifiers changed from: private */
    public void startCheckUsbDevice() {
        UsbProxy.getInstance(this.mContext).startProxy();
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        this.checkUsbDeviceThreadPool = newSingleThreadExecutor;
        newSingleThreadExecutor.execute(this.checkUsbDevice);
    }

    private void stopCheckUsbDevice() {
        ExecutorService executorService = this.checkUsbDeviceThreadPool;
        if (executorService != null && !executorService.isShutdown()) {
            this.checkUsbDeviceThreadPool.shutdownNow();
            this.checkUsbDeviceThreadPool = null;
        }
    }

    public void startCheckNetworkRunnable() {
        if (this.mConnectionStatus.compareAndSet(0, 1)) {
            Thread thread = new Thread(this.checkNetworkRunnable, "Network-Connecting Thread");
            this.mTaskThread = thread;
            thread.start();
        }
    }

    public void stopCheckNetworkRunnable() {
        if (this.mConnectionStatus.get() != 0 && this.mTaskThread != null) {
            try {
                this.mConnectionStatus.set(0);
                if (this.mTaskThread.isAlive() && !this.mTaskThread.isInterrupted()) {
                    this.mTaskThread.interrupt();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: com.autel.internal.network.NetworkManager$5 */
    /* synthetic */ class C47925 {

        /* renamed from: $SwitchMap$com$autel$internal$network$NetworkManager$ConnectStatus */
        static final /* synthetic */ int[] f8478x3fe4ea74;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.autel.internal.network.NetworkManager$ConnectStatus[] r0 = com.autel.internal.network.NetworkManager.ConnectStatus.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f8478x3fe4ea74 = r0
                com.autel.internal.network.NetworkManager$ConnectStatus r1 = com.autel.internal.network.NetworkManager.ConnectStatus.USB_CONNECT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f8478x3fe4ea74     // Catch:{ NoSuchFieldError -> 0x001d }
                com.autel.internal.network.NetworkManager$ConnectStatus r1 = com.autel.internal.network.NetworkManager.ConnectStatus.USB_DISCONNECT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f8478x3fe4ea74     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.autel.internal.network.NetworkManager$ConnectStatus r1 = com.autel.internal.network.NetworkManager.ConnectStatus.WIFI_CONNECT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f8478x3fe4ea74     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.autel.internal.network.NetworkManager$ConnectStatus r1 = com.autel.internal.network.NetworkManager.ConnectStatus.WIFI_DISCONNECT     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.autel.internal.network.NetworkManager.C47925.<clinit>():void");
        }
    }

    /* access modifiers changed from: private */
    public void callback(int i) {
        if (!this.listenerMaps.isEmpty()) {
            for (IAutelNetworkConnectionListener next : this.listenerMaps.values()) {
                if (i == 0) {
                    next.onUsbConnected();
                } else if (i == 1) {
                    next.onWifiConnected();
                } else if (i == 2) {
                    next.disconnect();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public boolean isWifiConnected() {
        if (NetworkInfo.State.CONNECTED == ((ConnectivityManager) this.mContext.getSystemService("connectivity")).getNetworkInfo(1).getState()) {
            return true;
        }
        return false;
    }
}
