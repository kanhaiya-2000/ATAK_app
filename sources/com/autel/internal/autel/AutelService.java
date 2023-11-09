package com.autel.internal.autel;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.autel.sdk.Autel;

public class AutelService extends Service {
    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onTaskRemoved(Intent intent) {
        Autel.destroy();
    }
}
