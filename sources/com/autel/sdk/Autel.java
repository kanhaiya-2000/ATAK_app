package com.autel.sdk;

import android.content.Context;
import android.util.Log;
import com.autel.common.CallbackWithNoParam;
import com.autel.internal.autel.SDKInitHelper;
import com.autel.internal.sdk.product.datapost.MsgPostManager;
import com.autel.sdk.AutelSdkConfig;
import com.autel.util.log.AutelLog;

public class Autel {
    private static final String NETWORK_LISTENER_TAG = "networkListenerTag";
    private static final String TAG = "Autel_SDK";

    public static void init(Context context, String str, CallbackWithNoParam callbackWithNoParam) {
        MsgPostManager.setPostOnUIThread(false);
        SDKInitHelper.init(context.getApplicationContext(), AutelSdkConfig.VersionDetect.ALL);
        SDKInitHelper.instance().attach(str, callbackWithNoParam);
    }

    public static void init(Context context, AutelSdkConfig autelSdkConfig, CallbackWithNoParam callbackWithNoParam) {
        if (autelSdkConfig != null) {
            MsgPostManager.setPostOnUIThread(autelSdkConfig.isPostOnUi());
            SDKInitHelper.init(context, autelSdkConfig.getVersionDetect());
            SDKInitHelper.instance().attach(autelSdkConfig, callbackWithNoParam);
        }
    }

    public static void setProductConnectListener(ProductConnectListener productConnectListener) {
        if (SDKInitHelper.instance() != null) {
            SDKInitHelper.instance().setProductConnectListener(productConnectListener);
        } else {
            Log.e("AutelSDK", "Autel SDK has not init!");
        }
    }

    public static void destroy() {
        AutelLog.debug_i(AutelLog.TMP_CONNECT_ATG, "Autel sdk destroy");
        if (SDKInitHelper.instance() != null) {
            SDKInitHelper.instance().detach();
        }
    }
}
