package org.droidplanner.services.android.impl.utils.file;

import android.content.res.AssetManager;

public class AssetUtil {
    public static boolean exists(AssetManager assetManager, String str, String str2) {
        for (String equals : assetManager.list(str)) {
            if (equals.equals(str2)) {
                return true;
            }
        }
        return false;
    }
}
