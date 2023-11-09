package com.atakmap.android.uastool.plugin;

import java.io.File;

class PluginNativeLoader {
    private static final String TAG = "NativeLoader";
    private static String ndl;

    PluginNativeLoader() {
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:5|6|7|8|9) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0019 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void init(android.content.Context r3) {
        /*
            java.lang.Class<com.atakmap.android.uastool.plugin.PluginNativeLoader> r0 = com.atakmap.android.uastool.plugin.PluginNativeLoader.class
            monitor-enter(r0)
            java.lang.String r1 = ndl     // Catch:{ all -> 0x0023 }
            if (r1 != 0) goto L_0x0021
            android.content.pm.PackageManager r1 = r3.getPackageManager()     // Catch:{ Exception -> 0x0019 }
            java.lang.String r3 = r3.getPackageName()     // Catch:{ Exception -> 0x0019 }
            r2 = 0
            android.content.pm.ApplicationInfo r3 = r1.getApplicationInfo(r3, r2)     // Catch:{ Exception -> 0x0019 }
            java.lang.String r3 = r3.nativeLibraryDir     // Catch:{ Exception -> 0x0019 }
            ndl = r3     // Catch:{ Exception -> 0x0019 }
            goto L_0x0021
        L_0x0019:
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x0023 }
            java.lang.String r1 = "native library loading will fail, unable to grab the nativeLibraryDir from the package name"
            r3.<init>(r1)     // Catch:{ all -> 0x0023 }
            throw r3     // Catch:{ all -> 0x0023 }
        L_0x0021:
            monitor-exit(r0)
            return
        L_0x0023:
            r3 = move-exception
            monitor-exit(r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.atakmap.android.uastool.plugin.PluginNativeLoader.init(android.content.Context):void");
    }

    public static void loadLibrary(String str) {
        if (ndl != null) {
            String str2 = ndl + File.separator + System.mapLibraryName(str);
            if (new File(str2).exists()) {
                System.load(str2);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("NativeLoader not initialized");
    }
}
