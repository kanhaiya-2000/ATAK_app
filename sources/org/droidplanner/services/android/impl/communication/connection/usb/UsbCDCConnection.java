package org.droidplanner.services.android.impl.communication.connection.usb;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbManager;
import android.os.Bundle;
import android.util.Log;
import atakplugin.UASTool.cqb;
import com.hoho.android.usbserial.driver.UsbSerialDriver;
import com.hoho.android.usbserial.driver.UsbSerialProber;
import com.o3dr.services.android.lib.gcs.link.LinkConnectionStatus;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import org.droidplanner.services.android.impl.communication.connection.usb.UsbConnection;

class UsbCDCConnection extends UsbConnection.UsbConnectionImpl {
    private static final String ACTION_USB_PERMISSION = "com.android.example.USB_PERMISSION";
    /* access modifiers changed from: private */
    public static final String TAG = "UsbCDCConnection";
    private static final IntentFilter intentFilter = new IntentFilter(ACTION_USB_PERMISSION);
    private final BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            if (UsbCDCConnection.ACTION_USB_PERMISSION.equals(intent.getAction())) {
                UsbCDCConnection.this.removeWatchdog();
                UsbDevice usbDevice = (UsbDevice) intent.getParcelableExtra("device");
                if (!intent.getBooleanExtra("permission", false)) {
                    String access$300 = UsbCDCConnection.TAG;
                    Log.d(access$300, "permission denied for device " + usbDevice);
                    UsbCDCConnection.this.onUsbConnectionStatus(LinkConnectionStatus.newFailedConnectionStatus(-3, "USB Permission denied."));
                } else if (usbDevice != null) {
                    try {
                        UsbCDCConnection usbCDCConnection = UsbCDCConnection.this;
                        usbCDCConnection.openUsbDevice(usbDevice, (Bundle) usbCDCConnection.extrasHolder.get());
                    } catch (IOException e) {
                        Log.e(UsbCDCConnection.TAG, e.getMessage(), e);
                    }
                } else {
                    UsbCDCConnection.this.onUsbConnectionStatus(LinkConnectionStatus.newFailedConnectionStatus(-2, "Unable to access usb device."));
                }
            }
        }
    };
    /* access modifiers changed from: private */
    public final AtomicReference<Bundle> extrasHolder = new AtomicReference<>();
    private final Runnable permissionWatchdog = new Runnable() {
        public void run() {
            Log.d(UsbCDCConnection.TAG, "Permission request timeout.");
            UsbCDCConnection.this.onUsbConnectionStatus(LinkConnectionStatus.newFailedConnectionStatus(-5, "Unable to get usb access."));
            UsbCDCConnection.this.removeWatchdog();
        }
    };
    private ScheduledExecutorService scheduler;
    private final AtomicReference<UsbSerialDriver> serialDriverRef = new AtomicReference<>();
    private final PendingIntent usbPermissionIntent;

    protected UsbCDCConnection(Context context, UsbConnection usbConnection, int i) {
        super(context, usbConnection, i);
        this.usbPermissionIntent = PendingIntent.getBroadcast(context, 0, new Intent(ACTION_USB_PERMISSION), 0);
    }

    private void registerUsbPermissionBroadcastReceiver() {
        this.mContext.registerReceiver(this.broadcastReceiver, intentFilter);
    }

    private void unregisterUsbPermissionBroadcastReceiver() {
        try {
            this.mContext.unregisterReceiver(this.broadcastReceiver);
        } catch (IllegalArgumentException e) {
            cqb.m12015e(e, "Receiver was not registered.", new Object[0]);
        }
    }

    /* access modifiers changed from: private */
    public void removeWatchdog() {
        ScheduledExecutorService scheduledExecutorService = this.scheduler;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.shutdown();
            this.scheduler = null;
        }
    }

    /* access modifiers changed from: protected */
    public void openUsbConnection(Bundle bundle) {
        this.extrasHolder.set(bundle);
        registerUsbPermissionBroadcastReceiver();
        UsbManager usbManager = (UsbManager) this.mContext.getSystemService("usb");
        List availableSupportedDevices = UsbSerialProber.getAvailableSupportedDevices(usbManager);
        if (!availableSupportedDevices.isEmpty()) {
            UsbDevice usbDevice = (UsbDevice) availableSupportedDevices.get(0);
            if (usbManager.hasPermission(usbDevice)) {
                openUsbDevice(usbDevice, bundle);
                return;
            }
            removeWatchdog();
            ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
            this.scheduler = newSingleThreadScheduledExecutor;
            newSingleThreadScheduledExecutor.schedule(this.permissionWatchdog, 15, TimeUnit.SECONDS);
            String str = TAG;
            Log.d(str, "Requesting permission to access usb device " + usbDevice.getDeviceName());
            usbManager.requestPermission(usbDevice, this.usbPermissionIntent);
            return;
        }
        Log.d(TAG, "No Devices found");
        throw new IOException("No Devices found");
    }

    /* access modifiers changed from: private */
    public void openUsbDevice(UsbDevice usbDevice, Bundle bundle) {
        UsbSerialDriver openUsbDevice = UsbSerialProber.openUsbDevice((UsbManager) this.mContext.getSystemService("usb"), usbDevice);
        if (openUsbDevice != null) {
            String str = TAG;
            Log.d(str, "Opening using Baud rate " + this.mBaudRate);
            try {
                openUsbDevice.open();
                openUsbDevice.setParameters(this.mBaudRate, 8, 1, 0);
                this.serialDriverRef.set(openUsbDevice);
                onUsbConnectionOpened(bundle);
            } catch (IOException e) {
                String str2 = TAG;
                Log.e(str2, "Error setting up device: " + e.getMessage(), e);
                try {
                    openUsbDevice.close();
                } catch (IOException unused) {
                }
            }
        } else {
            Log.d(TAG, "No Devices found");
            throw new IOException("No Devices found");
        }
    }

    /* access modifiers changed from: protected */
    public int readDataBlock(byte[] bArr) {
        UsbSerialDriver usbSerialDriver = this.serialDriverRef.get();
        if (usbSerialDriver != null) {
            try {
                int read = usbSerialDriver.read(bArr, 200);
                if (read == 0) {
                    return -1;
                }
                return read;
            } catch (NullPointerException e) {
                String str = "Error Reading: " + e.getMessage() + "\nAssuming inaccessible USB device.  Closing connection.";
                Log.e(TAG, str, e);
                throw new IOException(str, e);
            }
        } else {
            throw new IOException("Device is unavailable.");
        }
    }

    /* access modifiers changed from: protected */
    public void sendBuffer(byte[] bArr) {
        UsbSerialDriver usbSerialDriver = this.serialDriverRef.get();
        if (usbSerialDriver != null) {
            try {
                usbSerialDriver.write(bArr, 500);
            } catch (IOException e) {
                String str = TAG;
                Log.e(str, "Error Sending: " + e.getMessage(), e);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void closeUsbConnection() {
        unregisterUsbPermissionBroadcastReceiver();
        UsbSerialDriver andSet = this.serialDriverRef.getAndSet((Object) null);
        if (andSet != null) {
            try {
                andSet.close();
            } catch (IOException e) {
                Log.e(TAG, e.getMessage(), e);
            }
        }
    }

    public String toString() {
        return TAG;
    }
}
