package com.o3dr.services.android.lib.drone.connection;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

public class ConnectionParameter implements Parcelable {
    public static final Parcelable.Creator<ConnectionParameter> CREATOR = new Parcelable.Creator<ConnectionParameter>() {
        public ConnectionParameter createFromParcel(Parcel parcel) {
            return new ConnectionParameter(parcel);
        }

        public ConnectionParameter[] newArray(int i) {
            return new ConnectionParameter[i];
        }
    };
    private static final long DEFAULT_EVENTS_DISPATCHING_PERIOD = 0;
    private final int connectionType;
    private final long eventsDispatchingPeriod;
    private final Bundle paramsBundle;
    private final Uri tlogLoggingUri;

    public int describeContents() {
        return 0;
    }

    public static ConnectionParameter newUsbConnection(Uri uri) {
        return newUsbConnection(ConnectionType.DEFAULT_USB_BAUD_RATE, uri);
    }

    public static ConnectionParameter newUsbConnection(int i, Uri uri) {
        return newUsbConnection(i, uri, 0);
    }

    public static ConnectionParameter newUsbConnection(int i, Uri uri, long j) {
        Bundle bundle = new Bundle(1);
        bundle.putInt(ConnectionType.EXTRA_USB_BAUD_RATE, i);
        return new ConnectionParameter(0, bundle, uri, j);
    }

    public static ConnectionParameter newUdpConnection(Uri uri) {
        return newUdpConnection(14550, uri);
    }

    public static ConnectionParameter newUdpConnection(int i, Uri uri) {
        return newUdpConnection(i, uri, 0);
    }

    public static ConnectionParameter newUdpConnection(int i, Uri uri, long j) {
        Bundle bundle = new Bundle();
        bundle.putInt(ConnectionType.EXTRA_UDP_SERVER_PORT, i);
        return new ConnectionParameter(1, bundle, uri, j);
    }

    public static ConnectionParameter newUdpWithPingConnection(int i, String str, int i2, byte[] bArr, Uri uri) {
        return newUdpWithPingConnection(i, str, i2, bArr, ConnectionType.DEFAULT_UDP_PING_PERIOD, uri);
    }

    public static ConnectionParameter newUdpWithPingConnection(int i, String str, int i2, byte[] bArr, long j, Uri uri) {
        return newUdpWithPingConnection(i, str, i2, bArr, j, uri, 0);
    }

    public static ConnectionParameter newUdpWithPingConnection(int i, String str, int i2, byte[] bArr, long j, Uri uri, long j2) {
        Bundle bundle = new Bundle();
        bundle.putInt(ConnectionType.EXTRA_UDP_SERVER_PORT, i);
        if (!TextUtils.isEmpty(str)) {
            bundle.putString(ConnectionType.EXTRA_UDP_PING_RECEIVER_IP, str);
            bundle.putInt(ConnectionType.EXTRA_UDP_PING_RECEIVER_PORT, i2);
            bundle.putByteArray(ConnectionType.EXTRA_UDP_PING_PAYLOAD, bArr);
            bundle.putLong(ConnectionType.EXTRA_UDP_PING_PERIOD, j);
        }
        return new ConnectionParameter(1, bundle, uri, j2);
    }

    public static ConnectionParameter newTcpConnection(String str, Uri uri) {
        return newTcpConnection(str, ConnectionType.DEFAULT_TCP_SERVER_PORT, uri);
    }

    public static ConnectionParameter newTcpConnection(String str, int i, Uri uri) {
        return newTcpConnection(str, i, uri, 0);
    }

    public static ConnectionParameter newTcpConnection(String str, int i, Uri uri, long j) {
        Bundle bundle = new Bundle(2);
        bundle.putString(ConnectionType.EXTRA_TCP_SERVER_IP, str);
        bundle.putInt(ConnectionType.EXTRA_TCP_SERVER_PORT, i);
        return new ConnectionParameter(2, bundle, uri, j);
    }

    public static ConnectionParameter newBluetoothConnection(String str, Uri uri) {
        return newBluetoothConnection(str, uri, 0);
    }

    public static ConnectionParameter newBluetoothConnection(String str, Uri uri, long j) {
        Bundle bundle = new Bundle(1);
        bundle.putString(ConnectionType.EXTRA_BLUETOOTH_ADDRESS, str);
        return new ConnectionParameter(3, bundle, uri, j);
    }

    public static ConnectionParameter newSoloConnection(String str, String str2, Uri uri) {
        return newSoloConnection(str, str2, uri, 0);
    }

    public static ConnectionParameter newSoloConnection(String str, String str2, Uri uri, long j) {
        String replaceAll = str.replaceAll("^\"|\"$", "");
        Bundle bundle = new Bundle(2);
        bundle.putString(ConnectionType.EXTRA_SOLO_LINK_ID, replaceAll);
        bundle.putString(ConnectionType.EXTRA_SOLO_LINK_PASSWORD, str2);
        return new ConnectionParameter(101, bundle, uri, j);
    }

    private ConnectionParameter(int i, Bundle bundle) {
        this(i, bundle, (Uri) null);
    }

    private ConnectionParameter(int i, Bundle bundle, Uri uri) {
        this(i, bundle, uri, 0);
    }

    private ConnectionParameter(int i, Bundle bundle, Uri uri, long j) {
        this.connectionType = i;
        this.paramsBundle = bundle;
        this.tlogLoggingUri = uri;
        this.eventsDispatchingPeriod = j;
    }

    public long getEventsDispatchingPeriod() {
        return this.eventsDispatchingPeriod;
    }

    public int getConnectionType() {
        return this.connectionType;
    }

    public Bundle getParamsBundle() {
        return this.paramsBundle;
    }

    public Uri getTLogLoggingUri() {
        return this.tlogLoggingUri;
    }

    public String getUniqueId() {
        String str;
        int i = this.connectionType;
        String str2 = "";
        if (i == 0) {
            return "usb";
        }
        if (i == 1) {
            int i2 = 14550;
            Bundle bundle = this.paramsBundle;
            if (bundle != null) {
                i2 = bundle.getInt(ConnectionType.EXTRA_UDP_SERVER_PORT, 14550);
            }
            return "udp:" + i2;
        } else if (i == 2) {
            int i3 = ConnectionType.DEFAULT_TCP_SERVER_PORT;
            Bundle bundle2 = this.paramsBundle;
            if (bundle2 != null) {
                str2 = bundle2.getString(ConnectionType.EXTRA_TCP_SERVER_IP, str2);
                i3 = this.paramsBundle.getInt(ConnectionType.EXTRA_TCP_SERVER_PORT, ConnectionType.DEFAULT_TCP_SERVER_PORT);
            }
            return "tcp:" + str2 + ":" + i3;
        } else if (i == 3) {
            Bundle bundle3 = this.paramsBundle;
            if (bundle3 != null) {
                str2 = bundle3.getString(ConnectionType.EXTRA_BLUETOOTH_ADDRESS, str2);
            }
            if (TextUtils.isEmpty(str2)) {
                str = "bluetooth";
            } else {
                str = "bluetooth:" + str2;
            }
            return str;
        } else if (i != 101) {
            return str2;
        } else {
            Bundle bundle4 = this.paramsBundle;
            if (bundle4 != null) {
                str2 = bundle4.getString(ConnectionType.EXTRA_SOLO_LINK_ID, str2);
            }
            return "solo:" + str2;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ConnectionParameter)) {
            return false;
        }
        return getUniqueId().equals(((ConnectionParameter) obj).getUniqueId());
    }

    public int hashCode() {
        return getUniqueId().hashCode();
    }

    public String toString() {
        String str = "ConnectionParameter{connectionType=" + this.connectionType + ", paramsBundle=[";
        Bundle bundle = this.paramsBundle;
        if (bundle != null && !bundle.isEmpty()) {
            boolean z = true;
            for (String str2 : this.paramsBundle.keySet()) {
                if (z) {
                    z = false;
                } else {
                    str = str + ", ";
                }
                str = str + str2 + "=" + this.paramsBundle.get(str2);
            }
        }
        return str + "]}";
    }

    public ConnectionParameter clone() {
        return new ConnectionParameter(this.connectionType, this.paramsBundle);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.connectionType);
        parcel.writeBundle(this.paramsBundle);
        parcel.writeParcelable(this.tlogLoggingUri, i);
        parcel.writeLong(this.eventsDispatchingPeriod);
    }

    private ConnectionParameter(Parcel parcel) {
        this.connectionType = parcel.readInt();
        this.paramsBundle = parcel.readBundle(getClass().getClassLoader());
        this.tlogLoggingUri = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.eventsDispatchingPeriod = parcel.readLong();
    }
}
