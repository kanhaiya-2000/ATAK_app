package com.o3dr.services.android.lib.util.version;

import android.content.Context;
import com.o3dr.android.client.C5729R;

public class VersionUtils {
    public static int getCoreLibVersion(Context context) {
        return context.getResources().getInteger(C5729R.integer.core_lib_version);
    }

    private VersionUtils() {
    }
}
