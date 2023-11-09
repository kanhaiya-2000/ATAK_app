package com.atakmap.android.uastool.plugin;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.android.uastool.tasks.UASTask;
import com.atakmap.coremap.log.Log;

public class SendRouteReceiver extends BroadcastReceiver {
    private static final String TAG = "SendRouteReceiver";

    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action != null && action.equals("com.atakmap.android.uastool.SEND_ROUTE")) {
            String stringExtra = intent.getStringExtra(UASTask.COTDETAIL_UID);
            Log.d(TAG, "UID = " + stringExtra);
            UASToolDropDownReceiver instance = UASToolDropDownReceiver.getInstance();
            if (instance != null && instance.getPlatformMonitor() != null) {
                instance.getPlatformMonitor().onSendRouteReceived(stringExtra);
            }
        }
    }
}
