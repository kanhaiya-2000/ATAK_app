package org.droidplanner.services.android.impl.communication.connection;

import android.content.Context;
import android.os.Bundle;
import org.droidplanner.services.android.impl.utils.connection.WifiConnectionHandler;

public abstract class AndroidIpConnection extends AndroidMavLinkConnection {
    private final WifiConnectionHandler wifiHandler;

    /* access modifiers changed from: protected */
    public abstract void onCloseConnection();

    /* access modifiers changed from: protected */
    public abstract void onOpenConnection(Bundle bundle);

    protected AndroidIpConnection(Context context, WifiConnectionHandler wifiConnectionHandler) {
        super(context);
        this.wifiHandler = wifiConnectionHandler;
    }

    /* access modifiers changed from: protected */
    public final void openConnection(Bundle bundle) {
        WifiConnectionHandler wifiConnectionHandler = this.wifiHandler;
        if (wifiConnectionHandler != null) {
            wifiConnectionHandler.start();
        }
        onOpenConnection(bundle);
    }

    /* access modifiers changed from: protected */
    public final void closeConnection() {
        onCloseConnection();
        WifiConnectionHandler wifiConnectionHandler = this.wifiHandler;
        if (wifiConnectionHandler != null) {
            wifiConnectionHandler.stop();
        }
    }
}
