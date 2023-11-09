package org.droidplanner.services.android.impl.communication.connection;

import android.content.Context;
import android.os.Bundle;
import com.o3dr.services.android.lib.gcs.link.LinkConnectionStatus;
import org.droidplanner.services.android.impl.core.MAVLink.connection.TcpConnection;
import org.droidplanner.services.android.impl.core.model.Logger;
import org.droidplanner.services.android.impl.utils.connection.WifiConnectionHandler;

public class AndroidTcpConnection extends AndroidIpConnection {
    private final TcpConnection mConnectionImpl;
    /* access modifiers changed from: private */
    public final String serverIp;
    /* access modifiers changed from: private */
    public final int serverPort;

    public AndroidTcpConnection(Context context, String str, int i, WifiConnectionHandler wifiConnectionHandler) {
        super(context, wifiConnectionHandler);
        this.serverIp = str;
        this.serverPort = i;
        this.mConnectionImpl = new TcpConnection(context) {
            /* access modifiers changed from: protected */
            public int loadServerPort() {
                return AndroidTcpConnection.this.serverPort;
            }

            /* access modifiers changed from: protected */
            public String loadServerIP() {
                return AndroidTcpConnection.this.serverIp;
            }

            /* access modifiers changed from: protected */
            public Logger initLogger() {
                return AndroidTcpConnection.this.initLogger();
            }

            /* access modifiers changed from: protected */
            public void onConnectionOpened(Bundle bundle) {
                AndroidTcpConnection.this.onConnectionOpened(bundle);
            }

            /* access modifiers changed from: protected */
            public void onConnectionStatus(LinkConnectionStatus linkConnectionStatus) {
                AndroidTcpConnection.this.onConnectionStatus(linkConnectionStatus);
            }
        };
    }

    public AndroidTcpConnection(Context context, String str, int i) {
        this(context, str, i, (WifiConnectionHandler) null);
    }

    /* access modifiers changed from: protected */
    public void onCloseConnection() {
        this.mConnectionImpl.closeConnection();
    }

    /* access modifiers changed from: protected */
    public void loadPreferences() {
        this.mConnectionImpl.loadPreferences();
    }

    /* access modifiers changed from: protected */
    public void onOpenConnection(Bundle bundle) {
        this.mConnectionImpl.openConnection(bundle);
    }

    /* access modifiers changed from: protected */
    public int readDataBlock(byte[] bArr) {
        return this.mConnectionImpl.readDataBlock(bArr);
    }

    /* access modifiers changed from: protected */
    public void sendBuffer(byte[] bArr) {
        this.mConnectionImpl.sendBuffer(bArr);
    }

    public int getConnectionType() {
        return this.mConnectionImpl.getConnectionType();
    }
}
