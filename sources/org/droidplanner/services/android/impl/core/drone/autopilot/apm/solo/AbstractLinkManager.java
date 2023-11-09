package org.droidplanner.services.android.impl.core.drone.autopilot.apm.solo;

import android.content.Context;
import android.os.Handler;
import android.os.RemoteException;
import android.text.TextUtils;
import atakplugin.UASTool.cqb;
import com.o3dr.android.client.utils.connection.AbstractIpConnection;
import com.o3dr.android.client.utils.connection.IpConnectionListener;
import com.o3dr.services.android.lib.model.ICommandListener;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.droidplanner.services.android.impl.communication.model.DataLink;
import org.droidplanner.services.android.impl.core.drone.autopilot.apm.solo.AbstractLinkManager.LinkListener;
import org.droidplanner.services.android.impl.utils.connection.SshConnection;

public abstract class AbstractLinkManager<T extends LinkListener> implements IpConnectionListener {
    protected static final long RECONNECT_COUNTDOWN = 1000;
    protected static final String SOLO_MAC_ADDRESS_COMMAND = "/sbin/ifconfig wlan0 | awk '/HWaddr/ {print $NF}'";
    private final ExecutorService asyncExecutor;
    protected final Context context;
    /* access modifiers changed from: protected */
    public final Handler handler;
    private final AtomicBoolean isStarted = new AtomicBoolean(false);
    protected final AbstractIpConnection linkConn;
    private T linkListener;
    /* access modifiers changed from: protected */
    public final DataLink.DataLinkProvider linkProvider;
    private final AtomicReference<String> macAddress = new AtomicReference<>("");
    private final Runnable macAddressRetriever = new Runnable() {
        public void run() {
            try {
                String execute = AbstractLinkManager.this.getSshLink().execute(AbstractLinkManager.SOLO_MAC_ADDRESS_COMMAND);
                AbstractLinkManager.this.setMacAddress(TextUtils.isEmpty(execute) ? "" : execute.trim());
            } catch (IOException e) {
                cqb.m12015e(e, "Error occurred while retrieving sololink mac address", new Object[0]);
            }
        }
    };
    /* access modifiers changed from: private */
    public final Runnable reconnectTask = new Runnable() {
        public void run() {
            AbstractLinkManager.this.handler.removeCallbacks(AbstractLinkManager.this.reconnectTask);
            AbstractLinkManager.this.linkConn.connect(AbstractLinkManager.this.linkProvider.getConnectionExtras());
        }
    };
    private final AtomicBoolean wasConnected = new AtomicBoolean(false);

    public interface LinkListener {
        void onLinkConnected();

        void onLinkDisconnected();

        void onMacAddressUpdated();

        void onVersionsUpdated();
    }

    /* access modifiers changed from: protected */
    public abstract SshConnection getSshLink();

    public abstract void refreshState();

    /* access modifiers changed from: protected */
    public boolean shouldReconnect() {
        return true;
    }

    public AbstractLinkManager(Context context2, AbstractIpConnection abstractIpConnection, Handler handler2, ExecutorService executorService, DataLink.DataLinkProvider dataLinkProvider) {
        this.context = context2;
        this.linkConn = abstractIpConnection;
        abstractIpConnection.setIpConnectionListener(this);
        this.handler = handler2;
        this.asyncExecutor = executorService;
        this.linkProvider = dataLinkProvider;
    }

    /* access modifiers changed from: protected */
    public void postAsyncTask(Runnable runnable) {
        ExecutorService executorService = this.asyncExecutor;
        if (executorService != null && !executorService.isShutdown()) {
            this.asyncExecutor.execute(runnable);
        }
    }

    /* access modifiers changed from: protected */
    public void postSuccessEvent(final ICommandListener iCommandListener) {
        Handler handler2 = this.handler;
        if (handler2 != null && iCommandListener != null) {
            handler2.post(new Runnable() {
                public void run() {
                    try {
                        iCommandListener.onSuccess();
                    } catch (RemoteException e) {
                        cqb.m12015e(e, e.getMessage(), new Object[0]);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public void postTimeoutEvent(final ICommandListener iCommandListener) {
        Handler handler2 = this.handler;
        if (handler2 != null && iCommandListener != null) {
            handler2.post(new Runnable() {
                public void run() {
                    try {
                        iCommandListener.onTimeout();
                    } catch (RemoteException e) {
                        cqb.m12015e(e, e.getMessage(), new Object[0]);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public void postErrorEvent(final int i, final ICommandListener iCommandListener) {
        Handler handler2 = this.handler;
        if (handler2 != null && iCommandListener != null) {
            handler2.post(new Runnable() {
                public void run() {
                    try {
                        iCommandListener.onError(i);
                    } catch (RemoteException e) {
                        cqb.m12015e(e, e.getMessage(), new Object[0]);
                    }
                }
            });
        }
    }

    public boolean isLinkConnected() {
        return this.linkConn.getConnectionStatus() == 2;
    }

    public void start(T t) {
        this.handler.removeCallbacks(this.reconnectTask);
        this.isStarted.set(true);
        this.linkConn.connect(this.linkProvider.getConnectionExtras());
        this.linkListener = t;
    }

    public void stop() {
        this.handler.removeCallbacks(this.reconnectTask);
        this.isStarted.set(false);
        this.linkConn.disconnect();
    }

    public void onIpConnected() {
        this.handler.removeCallbacks(this.reconnectTask);
        this.wasConnected.set(true);
        refreshState();
        T t = this.linkListener;
        if (t != null) {
            t.onLinkConnected();
        }
    }

    /* access modifiers changed from: protected */
    public boolean isStarted() {
        return this.isStarted.get();
    }

    public void onIpDisconnected() {
        if (this.isStarted.get() && shouldReconnect()) {
            this.handler.postDelayed(this.reconnectTask, RECONNECT_COUNTDOWN);
        }
        if (this.linkListener != null && this.wasConnected.compareAndSet(true, false)) {
            this.linkListener.onLinkDisconnected();
        }
    }

    /* access modifiers changed from: protected */
    public void loadMacAddress() {
        postAsyncTask(this.macAddressRetriever);
    }

    /* access modifiers changed from: private */
    public void setMacAddress(String str) {
        cqb.m12010c("Retrieved mac address: %s", str);
        this.macAddress.set(str);
        T t = this.linkListener;
        if (t != null) {
            t.onMacAddressUpdated();
        }
    }

    public String getMacAddress() {
        return this.macAddress.get();
    }
}
