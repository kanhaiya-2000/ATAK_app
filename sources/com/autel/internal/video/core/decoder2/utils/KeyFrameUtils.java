package com.autel.internal.video.core.decoder2.utils;

import com.autel.internal.sdk.AutelBaseApplication;
import java.io.InputStream;

public class KeyFrameUtils {
    public static byte[] getDefaultKeyFrame(int i) {
        if (i < 0) {
            return null;
        }
        InputStream openRawResource = AutelBaseApplication.getAppContext().getResources().openRawResource(i);
        byte[] bArr = new byte[openRawResource.available()];
        openRawResource.read(bArr);
        openRawResource.close();
        return bArr;
    }
}
