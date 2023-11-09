package com.o3dr.services.android.lib.util;

import android.content.Context;
import android.net.Uri;
import java.io.InputStream;
import java.io.OutputStream;

public class UriUtils {
    private UriUtils() {
    }

    public static OutputStream getOutputStream(Context context, Uri uri) {
        return context.getContentResolver().openOutputStream(uri);
    }

    public static InputStream getInputStream(Context context, Uri uri) {
        return context.getContentResolver().openInputStream(uri);
    }
}
