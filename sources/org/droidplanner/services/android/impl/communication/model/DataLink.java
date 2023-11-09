package org.droidplanner.services.android.impl.communication.model;

import android.os.Bundle;
import com.o3dr.services.android.lib.gcs.link.LinkConnectionStatus;
import com.o3dr.services.android.lib.model.ICommandListener;

public class DataLink {

    public interface DataLinkListener<T> {
        void notifyReceivedData(T t);

        void onConnectionStatus(LinkConnectionStatus linkConnectionStatus);
    }

    public interface DataLinkProvider<T> {
        void closeConnection();

        Bundle getConnectionExtras();

        boolean isConnected();

        void openConnection();

        void sendMessage(T t, ICommandListener iCommandListener);
    }
}
