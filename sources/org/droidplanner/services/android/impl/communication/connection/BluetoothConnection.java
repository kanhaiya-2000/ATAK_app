package org.droidplanner.services.android.impl.communication.connection;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Context;
import android.os.Bundle;
import android.os.ParcelUuid;
import android.util.Log;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.UnknownHostException;
import java.util.Set;
import java.util.UUID;

public class BluetoothConnection extends AndroidMavLinkConnection {
    private static final String BLUE = "BLUETOOTH";
    private static final String UUID_SPP_DEVICE = "00001101-0000-1000-8000-00805F9B34FB";
    private final String bluetoothAddress;
    private BluetoothSocket bluetoothSocket;

    /* renamed from: in */
    private InputStream f8618in;
    private BluetoothAdapter mBluetoothAdapter;
    private OutputStream out;

    public int getConnectionType() {
        return 3;
    }

    /* access modifiers changed from: protected */
    public void loadPreferences() {
    }

    public BluetoothConnection(Context context, String str) {
        super(context);
        this.bluetoothAddress = str;
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        this.mBluetoothAdapter = defaultAdapter;
        if (defaultAdapter == null) {
            Log.d(BLUE, "Null adapters");
        }
    }

    /* access modifiers changed from: protected */
    public void openConnection(Bundle bundle) {
        BluetoothDevice bluetoothDevice;
        Log.d(BLUE, "Connect");
        resetConnection();
        try {
            bluetoothDevice = this.mBluetoothAdapter.getRemoteDevice(this.bluetoothAddress);
        } catch (IllegalArgumentException unused) {
            bluetoothDevice = null;
        }
        if (bluetoothDevice == null) {
            bluetoothDevice = findSerialBluetoothBoard();
        }
        Log.d(BLUE, "Trying to connect to device with address " + bluetoothDevice.getAddress());
        Log.d(BLUE, "BT Create Socket Call...");
        this.bluetoothSocket = bluetoothDevice.createInsecureRfcommSocketToServiceRecord(UUID.fromString(UUID_SPP_DEVICE));
        Log.d(BLUE, "BT Cancel Discovery Call...");
        this.mBluetoothAdapter.cancelDiscovery();
        Log.d(BLUE, "BT Connect Call...");
        this.bluetoothSocket.connect();
        Log.d(BLUE, "## BT Connected ##");
        this.out = this.bluetoothSocket.getOutputStream();
        this.f8618in = this.bluetoothSocket.getInputStream();
        onConnectionOpened(bundle);
    }

    private BluetoothDevice findSerialBluetoothBoard() {
        Set<BluetoothDevice> bondedDevices = this.mBluetoothAdapter.getBondedDevices();
        if (bondedDevices.size() > 0) {
            for (BluetoothDevice next : bondedDevices) {
                Log.d(BLUE, next.getName() + " #" + next.getAddress() + "#");
                ParcelUuid[] uuids = next.getUuids();
                if (uuids != null && uuids.length > 0) {
                    for (ParcelUuid parcelUuid : next.getUuids()) {
                        Log.d(BLUE, "id:" + parcelUuid.toString());
                        if (parcelUuid.toString().equalsIgnoreCase(UUID_SPP_DEVICE)) {
                            Log.d(BLUE, ">> Selected: " + next.getName() + " Using: " + parcelUuid.toString());
                            return next;
                        }
                    }
                    continue;
                }
            }
        }
        throw new UnknownHostException("No Bluetooth Device found");
    }

    /* access modifiers changed from: protected */
    public int readDataBlock(byte[] bArr) {
        return this.f8618in.read(bArr);
    }

    /* access modifiers changed from: protected */
    public void sendBuffer(byte[] bArr) {
        OutputStream outputStream = this.out;
        if (outputStream != null) {
            outputStream.write(bArr);
        }
    }

    /* access modifiers changed from: protected */
    public void closeConnection() {
        resetConnection();
        Log.d(BLUE, "## BT Closed ##");
    }

    private void resetConnection() {
        InputStream inputStream = this.f8618in;
        if (inputStream != null) {
            inputStream.close();
            this.f8618in = null;
        }
        OutputStream outputStream = this.out;
        if (outputStream != null) {
            outputStream.close();
            this.out = null;
        }
        BluetoothSocket bluetoothSocket2 = this.bluetoothSocket;
        if (bluetoothSocket2 != null) {
            bluetoothSocket2.close();
            this.bluetoothSocket = null;
        }
    }
}
