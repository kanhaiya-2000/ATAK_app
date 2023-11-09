package com.autel.util.okhttp.utils;

import android.util.Log;
import atakplugin.UASTool.brm;
import atakplugin.UASTool.brp;
import atakplugin.UASTool.bru;
import atakplugin.UASTool.bsd;
import com.autel.util.okhttp.model.FormParams;
import com.autel.util.okhttp.model.Headers;
import com.autel.util.okhttp.model.InputStreamRequestBody;
import java.io.File;
import java.io.InputStream;

public class RequestFactory {
    private static final String TAG = "RequestFactory";

    public static brp generateHeaders(Headers headers) {
        return brp.m8779a(headers.Headers());
    }

    public static <T> bsd generateRequestBody(String str, T t) {
        if (t == null) {
            throw new IllegalArgumentException("body can not be null");
        } else if (t instanceof FormParams) {
            FormParams formParams = (FormParams) t;
            brm.C0224a aVar = new brm.C0224a();
            if (!formParams.Forms().isEmpty()) {
                for (String next : formParams.Forms().keySet()) {
                    aVar.mo3157a(next, formParams.Forms().get(next));
                }
            }
            return aVar.mo3158a();
        } else if (str != null) {
            bru a = bru.m8896a(str);
            if (t instanceof String) {
                Log.d(TAG, "--------string-------" + t);
                return bsd.create(a, (String) t);
            } else if (t instanceof File) {
                Log.d(TAG, "--------File-------");
                return bsd.create(a, (File) t);
            } else if (t instanceof byte[]) {
                Log.d(TAG, "--------byte-------");
                return bsd.create(a, (byte[]) t);
            } else if (!(t instanceof InputStream)) {
                return null;
            } else {
                Log.d(TAG, "--------inputstream-------");
                return InputStreamRequestBody.create(a, (InputStream) t);
            }
        } else {
            throw new IllegalArgumentException("postmediaType can not be null");
        }
    }
}
