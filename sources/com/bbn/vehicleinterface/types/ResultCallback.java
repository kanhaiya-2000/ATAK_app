package com.bbn.vehicleinterface.types;

import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.coremap.log.Log;

public class ResultCallback<T> {
    private static final String TAG = "ResultCallback";

    public void onResult(T t) {
    }

    public void onStart() {
    }

    public void onError(String str) {
        Log.d(TAG, str);
        UASToolDropDownReceiver.toast(str, 0);
    }

    public void onError(String str, String str2) {
        Log.d(str, str2);
        UASToolDropDownReceiver.toast(str2, 0);
    }
}
