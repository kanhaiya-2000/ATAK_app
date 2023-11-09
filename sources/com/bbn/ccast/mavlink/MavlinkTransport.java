package com.bbn.ccast.mavlink;

import com.atakmap.coremap.log.Log;
import java.io.InputStream;
import java.io.OutputStream;

public abstract class MavlinkTransport {
    private static final int DEFAULT_BAUD = 57600;
    private static final int DEFAULT_NUM_BITS = 8;
    private static final int DEFAULT_PARITY = 0;
    private static final int DEFAULT_STOP_BITS = 1;
    private static final String TAG = "MavlinkTransport";
    private static final byte[] mySecretKey = "demotime".getBytes();

    public abstract void close();

    public abstract void connect();

    public abstract InputStream getInputStream();

    public abstract OutputStream getOutputStream();

    public abstract boolean isConnected();

    public abstract void reconnect();

    protected MavlinkTransport() {
    }

    public void write(byte[] bArr) {
        if (getOutputStream() != null && isConnected()) {
            try {
                getOutputStream().write(bArr);
                getOutputStream().flush();
            } catch (Exception e) {
                reconnect();
                Log.d(TAG, "could not write to stream", e);
            }
        }
    }

    public int read() {
        return getInputStream().read();
    }

    public static MavlinkTransport fromFCU(String str) {
        if (str != null && str.toLowerCase().contains("tcp")) {
            String str2 = TAG;
            Log.d(str2, "FCU is TCP: " + str);
            String[] split = str.split(":");
            return new TcpMavlinkTransport(split[1], Integer.parseInt(split[2].trim()), split[0].toLowerCase().contains("in"));
        } else if (str != null && str.toLowerCase().contains("udp")) {
            String str3 = TAG;
            Log.d(str3, "FCU is UDP: " + str);
            String[] split2 = str.split(":");
            String str4 = split2[1];
            return new UdpMavlinkTransport(Integer.parseInt(split2[2].trim()));
        } else if (str == null || str.trim().isEmpty()) {
            String str5 = TAG;
            Log.d(str5, "Invalid MAVLink FCU - not connecting to MAVLink: " + str);
            return null;
        } else {
            String str6 = TAG;
            Log.d(str6, "FCU is Serial: " + str);
            String[] split3 = str.split(",");
            return new SerialMavlinkTransport(split3[0], split3.length > 1 ? Integer.parseInt(split3[1].trim()) : 57600, 8, 0, 1);
        }
    }
}
