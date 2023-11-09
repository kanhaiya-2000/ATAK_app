package com.atakmap.android.uastool.flightlog;

import android.util.JsonReader;
import android.util.Pair;
import atak.core.ko;
import com.atakmap.coremap.log.Log;
import com.autel.util.okhttp.model.HttpMediaType;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;

public class FlightLogImporter extends ko {
    public static final String CONTENT_TYPE = "Flight Log";
    public static final String LOG_FILE_ID = "UAS_Flight_Log_";
    public static final String LOG_UID = "UID";
    private static final String TAG = "FlightLogImporter";

    public File getDestinationPath(File file) {
        return file;
    }

    public String getDisplayableName() {
        return CONTENT_TYPE;
    }

    public FlightLogImporter(String str) {
        super(str, (String) null, true, false);
    }

    public boolean match(File file) {
        return FlightLogImporter.super.match(file) && isValidFile(file);
    }

    public boolean beginImport(File file) {
        return beginImport(file, Collections.emptySet());
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0091  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean beginImport(java.io.File r5, java.util.Set<atak.core.ko.a> r6) {
        /*
            r4 = this;
            java.lang.String r6 = r5.getName()
            java.io.File r0 = new java.io.File
            java.lang.String r1 = com.atakmap.android.uastool.flightlog.FlightLogger.DIRPATH_LOGS
            r0.<init>(r1)
            boolean r1 = r0.exists()
            r2 = 0
            if (r1 != 0) goto L_0x002f
            boolean r1 = r0.mkdirs()
            if (r1 != 0) goto L_0x002f
            java.lang.String r5 = TAG
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "Failed to flight log directory: "
            r1.append(r3)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            com.atakmap.coremap.log.Log.e(r5, r0)
            goto L_0x0072
        L_0x002f:
            boolean r0 = android.text.TextUtils.isEmpty(r6)
            if (r0 != 0) goto L_0x0072
            java.io.File r0 = new java.io.File     // Catch:{ Exception -> 0x005b }
            java.lang.String r1 = com.atakmap.android.uastool.flightlog.FlightLogger.DIRPATH_LOGS     // Catch:{ Exception -> 0x005b }
            r0.<init>(r1, r6)     // Catch:{ Exception -> 0x005b }
            boolean r5 = r5.renameTo(r0)     // Catch:{ Exception -> 0x005b }
            if (r5 != 0) goto L_0x0059
            java.lang.String r5 = TAG     // Catch:{ Exception -> 0x005b }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x005b }
            r0.<init>()     // Catch:{ Exception -> 0x005b }
            java.lang.String r1 = "Unable to move flight log: "
            r0.append(r1)     // Catch:{ Exception -> 0x005b }
            r0.append(r6)     // Catch:{ Exception -> 0x005b }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x005b }
            com.atakmap.coremap.log.Log.w(r5, r0)     // Catch:{ Exception -> 0x005b }
            goto L_0x0072
        L_0x0059:
            r5 = 1
            goto L_0x0073
        L_0x005b:
            r5 = move-exception
            java.lang.String r0 = TAG
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "Exception while moving flight log "
            r1.append(r3)
            r1.append(r6)
            java.lang.String r1 = r1.toString()
            com.atakmap.coremap.log.Log.e(r0, r1, r5)
        L_0x0072:
            r5 = 0
        L_0x0073:
            if (r5 == 0) goto L_0x0091
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Imported an new flight log file: "
            r0.append(r1)
            r0.append(r6)
            java.lang.String r6 = r0.toString()
            com.atakmap.android.uastool.UASToolDropDownReceiver.toast(r6, r2)
            com.atakmap.android.uastool.UASToolDropDownReceiver r6 = com.atakmap.android.uastool.UASToolDropDownReceiver.getInstance()
            r6.refreshFlightLogs()
            goto L_0x00a5
        L_0x0091:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Unable to import flight log file: "
            r0.append(r1)
            r0.append(r6)
            java.lang.String r6 = r0.toString()
            com.atakmap.android.uastool.UASToolDropDownReceiver.toast(r6, r2)
        L_0x00a5:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.atakmap.android.uastool.flightlog.FlightLogImporter.beginImport(java.io.File, java.util.Set):boolean");
    }

    private boolean isValidFile(File file) {
        boolean z = false;
        try {
            JsonReader jsonReader = new JsonReader(new FileReader(file));
            jsonReader.beginObject();
            while (true) {
                if (!jsonReader.hasNext()) {
                    break;
                } else if (!jsonReader.nextName().equals("UID")) {
                    jsonReader.skipValue();
                } else if (jsonReader.nextString().contains(LOG_FILE_ID)) {
                    z = true;
                }
            }
            jsonReader.close();
        } catch (FileNotFoundException e) {
            String str = TAG;
            Log.e(str, "Bad flight log file: " + file.getName(), e);
        } catch (IOException e2) {
            Log.e(TAG, "Flight log IOException", e2);
        }
        return z;
    }

    public Pair<String, String> getContentMIME() {
        return new Pair<>(CONTENT_TYPE, HttpMediaType.MEDIA_TYPE_STREAM);
    }
}
