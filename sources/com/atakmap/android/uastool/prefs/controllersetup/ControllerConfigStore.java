package com.atakmap.android.uastool.prefs.controllersetup;

import com.atakmap.coremap.filesystem.FileSystemUtils;
import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ControllerConfigStore {
    private static final String DIRPATH_JOYSTICK_CALIB = (FileSystemUtils.getRoot().getPath() + File.separatorChar + "tools" + File.separatorChar + "uastool" + File.separator + "joystick");
    private static final String JOYSTICK_FILE = "joystick.json";
    private static final String TAG = "ControllerConfig";
    private static final ControllerConfigStore _instance = new ControllerConfigStore();
    private HashMap<String, ControllerConfig> configs;
    private final ReentrantReadWriteLock fileAccessLock = new ReentrantReadWriteLock();
    private final Type hashMapType = new TypeToken<HashMap<String, ControllerConfig>>() {
    }.getType();

    public static ControllerConfigStore getInstance() {
        return _instance;
    }

    private ControllerConfigStore() {
        initialize();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0044, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0045, code lost:
        if (r1 != null) goto L_0x0047;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0050, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0053, code lost:
        throw r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void initialize() {
        /*
            r5 = this;
            java.io.File r0 = new java.io.File
            java.lang.String r1 = DIRPATH_JOYSTICK_CALIB
            r0.<init>(r1)
            com.google.gson.Gson r1 = new com.google.gson.Gson
            r1.<init>()
            boolean r2 = r0.mkdirs()
            java.lang.String r3 = "ControllerConfig"
            if (r2 == 0) goto L_0x0019
            java.lang.String r2 = "Dirpath created"
            android.util.Log.d(r3, r2)
        L_0x0019:
            java.io.File r2 = new java.io.File
            java.lang.String r4 = "joystick.json"
            r2.<init>(r0, r4)
            boolean r0 = r2.exists()
            if (r0 == 0) goto L_0x007e
            java.util.concurrent.locks.ReentrantReadWriteLock r0 = r5.fileAccessLock
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r0 = r0.readLock()
            r0.lock()
            java.io.FileReader r0 = new java.io.FileReader     // Catch:{ IOException -> 0x0064, JsonIOException -> 0x005d, JsonSyntaxException -> 0x0056 }
            r0.<init>(r2)     // Catch:{ IOException -> 0x0064, JsonIOException -> 0x005d, JsonSyntaxException -> 0x0056 }
            java.lang.reflect.Type r2 = r5.hashMapType     // Catch:{ all -> 0x0042 }
            java.lang.Object r1 = r1.fromJson((java.io.Reader) r0, (java.lang.reflect.Type) r2)     // Catch:{ all -> 0x0042 }
            java.util.HashMap r1 = (java.util.HashMap) r1     // Catch:{ all -> 0x0042 }
            r5.configs = r1     // Catch:{ all -> 0x0042 }
            r0.close()     // Catch:{ IOException -> 0x0064, JsonIOException -> 0x005d, JsonSyntaxException -> 0x0056 }
            goto L_0x006a
        L_0x0042:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x0044 }
        L_0x0044:
            r2 = move-exception
            if (r1 == 0) goto L_0x0050
            r0.close()     // Catch:{ all -> 0x004b }
            goto L_0x0053
        L_0x004b:
            r0 = move-exception
            r1.addSuppressed(r0)     // Catch:{ IOException -> 0x0064, JsonIOException -> 0x005d, JsonSyntaxException -> 0x0056 }
            goto L_0x0053
        L_0x0050:
            r0.close()     // Catch:{ IOException -> 0x0064, JsonIOException -> 0x005d, JsonSyntaxException -> 0x0056 }
        L_0x0053:
            throw r2     // Catch:{ IOException -> 0x0064, JsonIOException -> 0x005d, JsonSyntaxException -> 0x0056 }
        L_0x0054:
            r0 = move-exception
            goto L_0x0074
        L_0x0056:
            r0 = move-exception
            java.lang.String r1 = "The Json syntax was invalid when read from the data context"
            android.util.Log.e(r3, r1, r0)     // Catch:{ all -> 0x0054 }
            goto L_0x006a
        L_0x005d:
            r0 = move-exception
            java.lang.String r1 = "Data context was not readable"
            android.util.Log.e(r3, r1, r0)     // Catch:{ all -> 0x0054 }
            goto L_0x006a
        L_0x0064:
            r0 = move-exception
            java.lang.String r1 = "IO Error while trying to read JSON file"
            android.util.Log.e(r3, r1, r0)     // Catch:{ all -> 0x0054 }
        L_0x006a:
            java.util.concurrent.locks.ReentrantReadWriteLock r0 = r5.fileAccessLock
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r0 = r0.readLock()
            r0.unlock()
            goto L_0x007e
        L_0x0074:
            java.util.concurrent.locks.ReentrantReadWriteLock r1 = r5.fileAccessLock
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r1 = r1.readLock()
            r1.unlock()
            throw r0
        L_0x007e:
            java.util.HashMap<java.lang.String, com.atakmap.android.uastool.prefs.controllersetup.ControllerConfig> r0 = r5.configs
            if (r0 != 0) goto L_0x0089
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            r5.configs = r0
        L_0x0089:
            java.util.HashMap<java.lang.String, com.atakmap.android.uastool.prefs.controllersetup.ControllerConfig> r0 = r5.configs
            java.util.Set r0 = r0.keySet()
            java.util.Iterator r0 = r0.iterator()
        L_0x0093:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x00b5
            java.lang.Object r1 = r0.next()
            java.lang.String r1 = (java.lang.String) r1
            java.util.HashMap<java.lang.String, com.atakmap.android.uastool.prefs.controllersetup.ControllerConfig> r2 = r5.configs
            java.lang.Object r2 = r2.get(r1)
            com.atakmap.android.uastool.prefs.controllersetup.ControllerConfig r2 = (com.atakmap.android.uastool.prefs.controllersetup.ControllerConfig) r2
            if (r2 == 0) goto L_0x00af
            boolean r2 = r2.isValid()
            if (r2 != 0) goto L_0x0093
        L_0x00af:
            java.util.HashMap<java.lang.String, com.atakmap.android.uastool.prefs.controllersetup.ControllerConfig> r2 = r5.configs
            r2.remove(r1)
            goto L_0x0093
        L_0x00b5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.atakmap.android.uastool.prefs.controllersetup.ControllerConfigStore.initialize():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x005d, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x005e, code lost:
        if (r8 != null) goto L_0x0060;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        r7.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0069, code lost:
        r7.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x006c, code lost:
        throw r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean writeControllerConfig(com.atakmap.android.uastool.prefs.controllersetup.ControllerConfig r7, java.lang.String r8) {
        /*
            r6 = this;
            r0 = 0
            java.lang.String r1 = "ControllerConfig"
            if (r8 == 0) goto L_0x0087
            boolean r2 = r8.isEmpty()
            if (r2 != 0) goto L_0x0087
            if (r7 != 0) goto L_0x000f
            goto L_0x0087
        L_0x000f:
            java.io.File r2 = new java.io.File
            java.lang.String r3 = DIRPATH_JOYSTICK_CALIB
            r2.<init>(r3)
            com.google.gson.GsonBuilder r3 = new com.google.gson.GsonBuilder
            r3.<init>()
            com.google.gson.GsonBuilder r3 = r3.setPrettyPrinting()
            r3.serializeSpecialFloatingPointValues()
            com.google.gson.Gson r3 = r3.create()
            java.util.concurrent.locks.ReentrantReadWriteLock r4 = r6.fileAccessLock
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r4 = r4.writeLock()
            r4.lock()
            boolean r4 = r2.mkdirs()     // Catch:{ all -> 0x007c }
            if (r4 == 0) goto L_0x003a
            java.lang.String r4 = "Dirpath created"
            android.util.Log.d(r1, r4)     // Catch:{ all -> 0x007c }
        L_0x003a:
            java.io.File r4 = new java.io.File     // Catch:{ all -> 0x007c }
            java.lang.String r5 = "joystick.json"
            r4.<init>(r2, r5)     // Catch:{ all -> 0x007c }
            java.util.HashMap<java.lang.String, com.atakmap.android.uastool.prefs.controllersetup.ControllerConfig> r2 = r6.configs     // Catch:{ all -> 0x007c }
            com.atakmap.android.uastool.prefs.controllersetup.ControllerConfig r7 = r7.makeDeepCopy()     // Catch:{ all -> 0x007c }
            r2.put(r8, r7)     // Catch:{ all -> 0x007c }
            java.io.FileWriter r7 = new java.io.FileWriter     // Catch:{ JsonIOException | IOException -> 0x006d }
            r7.<init>(r4, r0)     // Catch:{ JsonIOException | IOException -> 0x006d }
            java.util.HashMap<java.lang.String, com.atakmap.android.uastool.prefs.controllersetup.ControllerConfig> r8 = r6.configs     // Catch:{ all -> 0x005b }
            java.lang.reflect.Type r2 = r6.hashMapType     // Catch:{ all -> 0x005b }
            r3.toJson((java.lang.Object) r8, (java.lang.reflect.Type) r2, (java.lang.Appendable) r7)     // Catch:{ all -> 0x005b }
            r0 = 1
            r7.close()     // Catch:{ JsonIOException | IOException -> 0x006d }
            goto L_0x0072
        L_0x005b:
            r8 = move-exception
            throw r8     // Catch:{ all -> 0x005d }
        L_0x005d:
            r2 = move-exception
            if (r8 == 0) goto L_0x0069
            r7.close()     // Catch:{ all -> 0x0064 }
            goto L_0x006c
        L_0x0064:
            r7 = move-exception
            r8.addSuppressed(r7)     // Catch:{ JsonIOException | IOException -> 0x006d }
            goto L_0x006c
        L_0x0069:
            r7.close()     // Catch:{ JsonIOException | IOException -> 0x006d }
        L_0x006c:
            throw r2     // Catch:{ JsonIOException | IOException -> 0x006d }
        L_0x006d:
            java.lang.String r7 = "Could not write joystick config to JSON file"
            android.util.Log.e(r1, r7)     // Catch:{ all -> 0x007c }
        L_0x0072:
            java.util.concurrent.locks.ReentrantReadWriteLock r7 = r6.fileAccessLock
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r7 = r7.writeLock()
            r7.unlock()
            return r0
        L_0x007c:
            r7 = move-exception
            java.util.concurrent.locks.ReentrantReadWriteLock r8 = r6.fileAccessLock
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r8 = r8.writeLock()
            r8.unlock()
            throw r7
        L_0x0087:
            java.lang.String r7 = "Controller configuration not written because it was invalid or the device name was not acceptable"
            android.util.Log.d(r1, r7)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.atakmap.android.uastool.prefs.controllersetup.ControllerConfigStore.writeControllerConfig(com.atakmap.android.uastool.prefs.controllersetup.ControllerConfig, java.lang.String):boolean");
    }

    public static ControllerConfig getControllerConfig(String str) {
        if (str == null || getInstance().configs == null || !getInstance().configs.containsKey(str)) {
            return ControllerConfig.defaultConfig;
        }
        return getInstance().configs.get(str);
    }
}
