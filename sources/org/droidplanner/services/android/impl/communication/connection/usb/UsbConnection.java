package org.droidplanner.services.android.impl.communication.connection.usb;

import android.content.Context;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbManager;
import android.os.Bundle;
import android.util.Log;
import com.o3dr.services.android.lib.gcs.link.LinkConnectionStatus;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.droidplanner.services.android.impl.communication.connection.AndroidMavLinkConnection;
import org.droidplanner.services.android.impl.core.model.Logger;
import org.droidplanner.services.android.impl.utils.AndroidLogger;

public class UsbConnection extends AndroidMavLinkConnection {
    private static final int FTDI_DEVICE_VENDOR_ID = 1027;
    private static final String TAG = "UsbConnection";
    protected final int mBaudRate;
    private UsbConnectionImpl mUsbConnection;

    public int getConnectionType() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public void loadPreferences() {
    }

    public UsbConnection(Context context, int i) {
        super(context);
        this.mBaudRate = i;
    }

    /* access modifiers changed from: protected */
    public void closeConnection() {
        UsbConnectionImpl usbConnectionImpl = this.mUsbConnection;
        if (usbConnectionImpl != null) {
            usbConnectionImpl.closeUsbConnection();
        }
    }

    /* access modifiers changed from: protected */
    public void openConnection(Bundle bundle) {
        UsbConnectionImpl usbConnectionImpl = this.mUsbConnection;
        if (usbConnectionImpl != null) {
            try {
                usbConnectionImpl.openUsbConnection(bundle);
                Log.d(TAG, "Reusing previous usb connection.");
                return;
            } catch (IOException e) {
                Log.e(TAG, "Previous usb connection is not usable.", e);
                this.mUsbConnection = null;
            }
        }
        if (isFTDIdevice(this.context)) {
            UsbFTDIConnection usbFTDIConnection = new UsbFTDIConnection(this.context, this, this.mBaudRate);
            try {
                usbFTDIConnection.openUsbConnection(bundle);
                this.mUsbConnection = usbFTDIConnection;
                Log.d(TAG, "Using FTDI usb connection.");
            } catch (IOException e2) {
                Log.d(TAG, "Unable to open a ftdi usb connection. Falling back to the open usb-library.", e2);
            }
        }
        if (this.mUsbConnection == null) {
            UsbCDCConnection usbCDCConnection = new UsbCDCConnection(this.context, this, this.mBaudRate);
            usbCDCConnection.openUsbConnection(bundle);
            this.mUsbConnection = usbCDCConnection;
            Log.d(TAG, "Using open-source usb connection.");
        }
    }

    private static boolean isFTDIdevice(Context context) {
        HashMap<String, UsbDevice> deviceList = ((UsbManager) context.getSystemService("usb")).getDeviceList();
        if (deviceList != null && !deviceList.isEmpty()) {
            for (Map.Entry<String, UsbDevice> value : deviceList.entrySet()) {
                if (((UsbDevice) value.getValue()).getVendorId() == FTDI_DEVICE_VENDOR_ID) {
                    return true;
                }
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public int readDataBlock(byte[] bArr) {
        UsbConnectionImpl usbConnectionImpl = this.mUsbConnection;
        if (usbConnectionImpl != null) {
            return usbConnectionImpl.readDataBlock(bArr);
        }
        throw new IOException("Uninitialized usb connection.");
    }

    /* access modifiers changed from: protected */
    public void sendBuffer(byte[] bArr) {
        UsbConnectionImpl usbConnectionImpl = this.mUsbConnection;
        if (usbConnectionImpl != null) {
            usbConnectionImpl.sendBuffer(bArr);
            return;
        }
        throw new IOException("Uninitialized usb connection.");
    }

    public String toString() {
        UsbConnectionImpl usbConnectionImpl = this.mUsbConnection;
        if (usbConnectionImpl == null) {
            return TAG;
        }
        return usbConnectionImpl.toString();
    }

    static abstract class UsbConnectionImpl {
        protected final int mBaudRate;
        protected final Context mContext;
        protected final Logger mLogger = AndroidLogger.getLogger();
        private final UsbConnection parentConnection;

        /* access modifiers changed from: protected */
        public abstract void closeUsbConnection();

        /* access modifiers changed from: protected */
        public abstract void openUsbConnection(Bundle bundle);

        /* access modifiers changed from: protected */
        public abstract int readDataBlock(byte[] bArr);

        /* access modifiers changed from: protected */
        public abstract void sendBuffer(byte[] bArr);

        protected UsbConnectionImpl(Context context, UsbConnection usbConnection, int i) {
            this.mContext = context;
            this.parentConnection = usbConnection;
            this.mBaudRate = i;
        }

        /* access modifiers changed from: protected */
        public void onUsbConnectionOpened(Bundle bundle) {
            this.parentConnection.onConnectionOpened(bundle);
        }

        /* access modifiers changed from: protected */
        public void onUsbConnectionStatus(LinkConnectionStatus linkConnectionStatus) {
            this.parentConnection.onConnectionStatus(linkConnectionStatus);
        }
    }
}
