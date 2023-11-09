package org.droidplanner.services.android.impl.communication.connection;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.o3dr.services.android.lib.gcs.link.LinkConnectionStatus;
import java.io.IOException;
import java.net.InetAddress;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.droidplanner.services.android.impl.core.MAVLink.connection.UdpConnection;
import org.droidplanner.services.android.impl.core.model.Logger;
import org.droidplanner.services.android.impl.utils.connection.WifiConnectionHandler;

public class AndroidUdpConnection extends AndroidIpConnection {
    /* access modifiers changed from: private */
    public static final String TAG = "AndroidUdpConnection";
    /* access modifiers changed from: private */
    public final UdpConnection mConnectionImpl;
    private ScheduledExecutorService pingRunner;
    private final HashSet<PingTask> pingTasks;
    /* access modifiers changed from: private */
    public final int serverPort;

    public AndroidUdpConnection(Context context, int i, WifiConnectionHandler wifiConnectionHandler) {
        super(context, wifiConnectionHandler);
        this.pingTasks = new HashSet<>();
        this.serverPort = i;
        this.mConnectionImpl = new UdpConnection(context) {
            /* access modifiers changed from: protected */
            public int loadServerPort() {
                return AndroidUdpConnection.this.serverPort;
            }

            /* access modifiers changed from: protected */
            public Logger initLogger() {
                return AndroidUdpConnection.this.initLogger();
            }

            /* access modifiers changed from: protected */
            public void onConnectionOpened(Bundle bundle) {
                AndroidUdpConnection.this.onConnectionOpened(bundle);
            }

            /* access modifiers changed from: protected */
            public void onConnectionStatus(LinkConnectionStatus linkConnectionStatus) {
                AndroidUdpConnection.this.onConnectionStatus(linkConnectionStatus);
            }
        };
    }

    public AndroidUdpConnection(Context context, int i) {
        this(context, i, (WifiConnectionHandler) null);
    }

    public void addPingTarget(InetAddress inetAddress, int i, long j, byte[] bArr) {
        ScheduledExecutorService scheduledExecutorService;
        if (inetAddress != null && bArr != null && j > 0) {
            PingTask pingTask = new PingTask(inetAddress, i, j, bArr);
            this.pingTasks.add(pingTask);
            if (getConnectionStatus() == 2 && (scheduledExecutorService = this.pingRunner) != null && !scheduledExecutorService.isShutdown()) {
                this.pingRunner.scheduleWithFixedDelay(pingTask, 0, j, TimeUnit.MILLISECONDS);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onCloseConnection() {
        String str = TAG;
        Log.d(str, "Closing udp connection.");
        if (this.pingRunner != null) {
            Log.d(str, "Shutting down pinging tasks.");
            this.pingRunner.shutdownNow();
            this.pingRunner = null;
        }
        this.mConnectionImpl.closeConnection();
    }

    /* access modifiers changed from: protected */
    public void loadPreferences() {
        this.mConnectionImpl.loadPreferences();
    }

    /* access modifiers changed from: protected */
    public void onOpenConnection(Bundle bundle) {
        Log.d(TAG, "Opening udp connection");
        this.mConnectionImpl.openConnection(bundle);
        ScheduledExecutorService scheduledExecutorService = this.pingRunner;
        if (scheduledExecutorService == null || scheduledExecutorService.isShutdown()) {
            this.pingRunner = Executors.newSingleThreadScheduledExecutor();
        }
        Iterator<PingTask> it = this.pingTasks.iterator();
        while (it.hasNext()) {
            PingTask next = it.next();
            this.pingRunner.scheduleWithFixedDelay(next, 0, next.period, TimeUnit.MILLISECONDS);
        }
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

    private class PingTask implements Runnable {
        private final InetAddress address;
        private final byte[] payload;
        /* access modifiers changed from: private */
        public final long period;
        private final int port;

        private PingTask(InetAddress inetAddress, int i, long j, byte[] bArr) {
            this.address = inetAddress;
            this.port = i;
            this.period = j;
            this.payload = bArr;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PingTask)) {
                return false;
            }
            PingTask pingTask = (PingTask) obj;
            if (this.address.equals(pingTask.address) && this.port == pingTask.port && this.period == pingTask.period) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return toString().hashCode();
        }

        public void run() {
            try {
                AndroidUdpConnection.this.mConnectionImpl.sendBuffer(this.address, this.port, this.payload);
            } catch (IOException e) {
                Log.e(AndroidUdpConnection.TAG, "Error occurred while sending ping message.", e);
            }
        }

        public String toString() {
            return "[" + this.address.toString() + "; " + this.port + "; " + this.period + "]";
        }
    }
}
