package com.trilliumeng.android.orion.sdk;

import android.util.Log;
import java.net.InetAddress;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicReference;

public class OrionSdk {
    /* access modifiers changed from: private */
    public static final String TAG = "OrionSdk";
    AtomicReference<IAircraftItem> aci = new AtomicReference<>(new IAircraftItem());
    private String gimbalCommsIp;
    private OrionReader orionReader;
    private Thread orionReaderThread;
    private String videoURI = null;

    private native boolean setCallback();

    public native void autoFocus();

    public native void commandGimbal(int i, float f, float f2, boolean z, float f3);

    public native void commandGimbalHome();

    public native void commandGimbalStow();

    public native int currentMode();

    public native boolean focusAvailable();

    public native boolean geoPoint(double d, double d2, double d3);

    public native boolean geoPointAtCurrentImgPos();

    public native int getActiveCamera();

    public native float getFocus();

    public native float getZoom();

    public native float maxZoom();

    public void onTelemetryUpdate() {
    }

    public native boolean orionCommClose();

    public native boolean orionCommOpenIp(String str);

    public native boolean processData(IAircraftItem iAircraftItem);

    public native void setActiveCamera(int i);

    public native void setFocus(float f);

    public native void setZoom(float f);

    public native void toggleActiveCamera();

    static {
        System.loadLibrary("orion-sdk");
    }

    public OrionSdk() {
        setCallback();
        this.orionReader = new OrionReader(this);
        Thread thread = new Thread(this.orionReader);
        this.orionReaderThread = thread;
        thread.start();
    }

    public IAircraftItem getAci() {
        return this.aci.get();
    }

    public void stop() {
        this.orionReaderThread.interrupt();
    }

    public void connectToGimbal(String str) {
        this.orionReader.setGimbalCommsIp(str);
    }

    public String getVideoURI() {
        return this.videoURI;
    }

    public void onNetworkVideoUpdate(int i, short s) {
        try {
            InetAddress byAddress = InetAddress.getByAddress(ByteBuffer.allocate(4).putInt(i).array());
            this.videoURI = "udp://" + byAddress.getHostAddress() + ":" + s;
            this.aci.get().sensorModel = "udp://" + byAddress.getHostAddress() + ":" + s;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isConnected() {
        OrionReader orionReader2 = this.orionReader;
        if (orionReader2 == null) {
            return false;
        }
        return orionReader2.isConnected();
    }

    public IAircraftItem getAircraftItem() {
        AtomicReference<IAircraftItem> atomicReference = this.aci;
        if (atomicReference == null || atomicReference.get() == null) {
            return null;
        }
        return this.aci.get().copy();
    }

    protected static class OrionReader implements Runnable {
        private String m_GimbalCommsIp = "";
        private boolean m_IsConnected = false;
        private long m_LastPacketRxNanoTime = 0;
        private final OrionSdk orionSdk;

        public OrionReader(OrionSdk orionSdk2) {
            this.orionSdk = orionSdk2;
        }

        public void setGimbalCommsIp(String str) {
            setConnected(false);
            this.m_GimbalCommsIp = str;
        }

        public void run() {
            try {
                System.currentTimeMillis();
                while (!Thread.interrupted()) {
                    try {
                        long nanoTime = System.nanoTime();
                        long j = this.m_LastPacketRxNanoTime;
                        double d = ((double) (nanoTime - j)) / 1.0E9d;
                        if (j == 0 || d > 5.0d) {
                            setConnected(false);
                            if (this.m_LastPacketRxNanoTime == 0) {
                                Log.d(OrionSdk.TAG, String.format("Attempting to connect to gimbal at %s", new Object[]{this.m_GimbalCommsIp}));
                            } else {
                                Log.d(OrionSdk.TAG, String.format("We lost comms! It's been %s seconds.", new Object[]{Double.valueOf(d)}));
                            }
                            if (this.orionSdk.orionCommOpenIp(this.m_GimbalCommsIp)) {
                                this.m_LastPacketRxNanoTime = System.nanoTime();
                                setConnected(true);
                                String access$000 = OrionSdk.TAG;
                                Log.d(access$000, "Connected to gimbal at " + this.m_GimbalCommsIp);
                            } else {
                                String access$0002 = OrionSdk.TAG;
                                Log.d(access$0002, "Couldn't open " + this.m_GimbalCommsIp);
                                Thread.sleep(500);
                            }
                        }
                        OrionSdk orionSdk2 = this.orionSdk;
                        if (orionSdk2.processData(orionSdk2.aci.get())) {
                            setConnected(true);
                            this.m_LastPacketRxNanoTime = System.nanoTime();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    Thread.sleep(75);
                }
            } catch (InterruptedException unused) {
            }
        }

        private void setConnected(boolean z) {
            if (this.m_IsConnected && !z) {
                this.orionSdk.orionCommClose();
            }
            this.m_IsConnected = z;
        }

        public boolean isConnected() {
            return this.m_IsConnected;
        }
    }
}
