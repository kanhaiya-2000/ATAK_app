package com.bbn.ccast.mavlink;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbDeviceConnection;
import android.hardware.usb.UsbManager;
import atakplugin.UASTool.C0842sq;
import com.atakmap.android.ipc.AtakBroadcast;
import com.atakmap.android.maps.MapView;
import com.atakmap.android.util.x;
import com.atakmap.coremap.log.Log;
import com.o3dr.services.android.lib.drone.connection.ConnectionType;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
import org.droidplanner.services.android.impl.core.drone.variables.HeartBeat;

public class SerialMavlinkTransport extends MavlinkTransport {
    public static final String ACTION_USB_PERMISSION = "com.atakmap.android.daisy.USB_PERMISSION";
    /* access modifiers changed from: private */
    public static final String TAG = "com.bbn.ccast.mavlink.SerialMavlinkTransport";
    /* access modifiers changed from: private */
    public final MapView _mapView = MapView.getMapView();
    private int baud;

    /* renamed from: br */
    private final BroadcastReceiver f8512br;
    private int numDataBits;
    private int numStopBits;
    private int parity;
    private String serialDevice;
    private final SerialScanner serialScanner;
    private final AtomicReference<C0842sq> usbSerialDevice = new AtomicReference<>();

    public void connect() {
    }

    public void reconnect() {
    }

    public String getSerialDevice() {
        return this.serialDevice;
    }

    public SerialMavlinkTransport setSerialDevice(String str) {
        this.serialDevice = str;
        return this;
    }

    public int getBaud() {
        return this.baud;
    }

    public SerialMavlinkTransport setBaud(int i) {
        this.baud = i;
        return this;
    }

    public int getNumDataBits() {
        return this.numDataBits;
    }

    public SerialMavlinkTransport setNumDataBits(int i) {
        this.numDataBits = i;
        return this;
    }

    public int getParity() {
        return this.parity;
    }

    public SerialMavlinkTransport setParity(int i) {
        this.parity = i;
        return this;
    }

    public int getNumStopBits() {
        return this.numStopBits;
    }

    public SerialMavlinkTransport setNumStopBits(int i) {
        this.numStopBits = i;
        return this;
    }

    public InputStream getInputStream() {
        C0842sq sqVar = this.usbSerialDevice.get();
        if (sqVar == null) {
            return null;
        }
        return sqVar.mo5756g();
    }

    public OutputStream getOutputStream() {
        C0842sq sqVar = this.usbSerialDevice.get();
        if (sqVar == null) {
            return null;
        }
        return sqVar.mo5757h();
    }

    public void close() {
        Log.d(TAG, "Closing serial connection.");
        C0842sq andSet = this.usbSerialDevice.getAndSet((Object) null);
        if (andSet != null) {
            andSet.mo5697d();
        }
        this.serialScanner.cancel();
    }

    public boolean isConnected() {
        C0842sq sqVar = this.usbSerialDevice.get();
        return sqVar != null && sqVar.mo5762m();
    }

    public static String comPortFromDevFile(String str) {
        return new File(str).getName();
    }

    public SerialMavlinkTransport(String str, int i, int i2, int i3, int i4) {
        C51061 r0 = new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {
                String access$100 = SerialMavlinkTransport.TAG;
                Log.d(access$100, "action: " + intent.getAction());
            }
        };
        this.f8512br = r0;
        setSerialDevice(str);
        setBaud(i);
        setNumDataBits(i2);
        setParity(i3);
        setNumStopBits(i4);
        SerialScanner serialScanner2 = new SerialScanner();
        this.serialScanner = serialScanner2;
        serialScanner2.start();
        AtakBroadcast.a().b(r0, new AtakBroadcast.DocumentedIntentFilter(ACTION_USB_PERMISSION));
    }

    public class SerialScanner extends Thread {
        private boolean cancelled = false;

        public SerialScanner() {
        }

        public void cancel() {
            this.cancelled = true;
            interrupt();
        }

        public void run() {
            UsbManager usbManager = (UsbManager) SerialMavlinkTransport.this._mapView.getContext().getSystemService("usb");
            while (!this.cancelled) {
                Iterator<UsbDevice> it = usbManager.getDeviceList().values().iterator();
                Log.d(SerialMavlinkTransport.TAG, "scanning for the MAVLink receiver");
                while (true) {
                    if (!it.hasNext() || SerialMavlinkTransport.this.isConnected()) {
                        break;
                    }
                    UsbDevice next = it.next();
                    String access$100 = SerialMavlinkTransport.TAG;
                    Log.d(access$100, "Found usb device " + next.getVendorId() + " " + next.getDeviceId());
                    if (next.getVendorId() == 1027 && next.getDeviceId() == 1002) {
                        String access$1002 = SerialMavlinkTransport.TAG;
                        Log.d(access$1002, "found MAVLink receiver: " + next);
                        if (usbManager.hasPermission(next)) {
                            x.a().a(86753, x.a.s.a(), "MAVLink device Connected", (String) null, "A MAVLink serial connection has been detected and data is being extracted.");
                            SerialMavlinkTransport.this.startReading(usbManager, next);
                            x.a().b(86753);
                        } else {
                            usbManager.requestPermission(next, PendingIntent.getBroadcast(SerialMavlinkTransport.this._mapView.getContext(), 0, new Intent(SerialMavlinkTransport.ACTION_USB_PERMISSION), 0));
                        }
                    }
                }
                try {
                    Thread.sleep(HeartBeat.HEARTBEAT_NORMAL_TIMEOUT);
                } catch (Exception unused) {
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void startReading(UsbManager usbManager, UsbDevice usbDevice) {
        try {
            UsbDeviceConnection openDevice = usbManager.openDevice(usbDevice);
            if (openDevice != null) {
                String serial = openDevice.getSerial();
                String str = TAG;
                Log.d(str, "serial number for the MAVLink receiver: " + serial);
            }
            C0842sq a = C0842sq.m13735a(usbDevice, openDevice);
            a.mo5696c();
            a.mo5682a((int) ConnectionType.DEFAULT_USB_BAUD_RATE);
            a.mo5692b(8);
            a.mo5694c(1);
            a.mo5698d(0);
            a.mo5699e(0);
            Log.d(TAG, "Opened connection to serial device.");
            this.usbSerialDevice.set(a);
        } catch (Exception e) {
            Log.e(TAG, "error occured", e);
        }
    }
}
