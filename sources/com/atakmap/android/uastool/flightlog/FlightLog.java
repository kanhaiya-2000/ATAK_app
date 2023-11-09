package com.atakmap.android.uastool.flightlog;

import android.util.JsonReader;
import com.atakmap.coremap.log.Log;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FlightLog implements Comparable<FlightLog> {
    private static final String TAG = "FlightLog";
    private String callsign;
    private final String fileName;
    private final String filePath;
    private final String fileTitle;
    private final List<FlightLogItem> flightLogItems;
    private String platformType;
    private String timeStamp;
    private String uid;
    private String version;

    public FlightLog(String str) {
        this.filePath = str;
        File file = new File(str);
        String name = file.getName();
        this.fileName = name;
        int lastIndexOf = name.lastIndexOf(".");
        if (lastIndexOf <= 0 || lastIndexOf >= name.length() - 1) {
            this.fileTitle = name;
        } else {
            this.fileTitle = name.substring(0, lastIndexOf);
        }
        this.flightLogItems = new ArrayList();
        readInLog(file);
    }

    public int compareTo(FlightLog flightLog) {
        String str = this.timeStamp;
        if (str != null && flightLog.timeStamp != null) {
            return str.compareTo(flightLog.getTimeStamp());
        }
        if (str == null) {
            return 1;
        }
        return flightLog.timeStamp == null ? -1 : 0;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void readInLog(java.io.File r21) {
        /*
            r20 = this;
            r1 = r20
            java.io.FileReader r0 = new java.io.FileReader     // Catch:{ FileNotFoundException -> 0x01dd, IOException -> 0x01d4, IllegalStateException -> 0x01ba }
            r2 = r21
            r0.<init>(r2)     // Catch:{ FileNotFoundException -> 0x01dd, IOException -> 0x01d4, IllegalStateException -> 0x01ba }
            android.util.JsonReader r2 = new android.util.JsonReader     // Catch:{ FileNotFoundException -> 0x01dd, IOException -> 0x01d4, IllegalStateException -> 0x01ba }
            r2.<init>(r0)     // Catch:{ FileNotFoundException -> 0x01dd, IOException -> 0x01d4, IllegalStateException -> 0x01ba }
            java.lang.String r0 = TAG     // Catch:{ FileNotFoundException -> 0x01dd, IOException -> 0x01d4, IllegalStateException -> 0x01ba }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x01dd, IOException -> 0x01d4, IllegalStateException -> 0x01ba }
            r3.<init>()     // Catch:{ FileNotFoundException -> 0x01dd, IOException -> 0x01d4, IllegalStateException -> 0x01ba }
            java.lang.String r4 = "Reading FlightLog: "
            r3.append(r4)     // Catch:{ FileNotFoundException -> 0x01dd, IOException -> 0x01d4, IllegalStateException -> 0x01ba }
            java.lang.String r4 = r1.filePath     // Catch:{ FileNotFoundException -> 0x01dd, IOException -> 0x01d4, IllegalStateException -> 0x01ba }
            r3.append(r4)     // Catch:{ FileNotFoundException -> 0x01dd, IOException -> 0x01d4, IllegalStateException -> 0x01ba }
            java.lang.String r3 = r3.toString()     // Catch:{ FileNotFoundException -> 0x01dd, IOException -> 0x01d4, IllegalStateException -> 0x01ba }
            com.atakmap.coremap.log.Log.d(r0, r3)     // Catch:{ FileNotFoundException -> 0x01dd, IOException -> 0x01d4, IllegalStateException -> 0x01ba }
            r2.beginObject()     // Catch:{ FileNotFoundException -> 0x01dd, IOException -> 0x01d4, IllegalStateException -> 0x01ba }
        L_0x0029:
            boolean r0 = r2.hasNext()     // Catch:{ FileNotFoundException -> 0x01dd, IOException -> 0x01d4, IllegalStateException -> 0x01ba }
            if (r0 == 0) goto L_0x01b6
            java.lang.String r0 = r1.getName(r2)     // Catch:{ FileNotFoundException -> 0x01dd, IOException -> 0x01d4, IllegalStateException -> 0x01ba }
            int r3 = r0.hashCode()     // Catch:{ FileNotFoundException -> 0x01dd, IOException -> 0x01d4, IllegalStateException -> 0x01ba }
            r5 = -1
            r6 = 5
            r7 = 4
            r8 = 3
            r9 = 2
            r10 = 1
            switch(r3) {
                case -1197189282: goto L_0x0073;
                case -171706085: goto L_0x0069;
                case 84016: goto L_0x005f;
                case 55126294: goto L_0x0055;
                case 351608024: goto L_0x004b;
                case 1874684019: goto L_0x0041;
                default: goto L_0x0040;
            }     // Catch:{ FileNotFoundException -> 0x01dd, IOException -> 0x01d4, IllegalStateException -> 0x01ba }
        L_0x0040:
            goto L_0x007d
        L_0x0041:
            java.lang.String r3 = "platform"
            boolean r3 = r0.equals(r3)     // Catch:{ FileNotFoundException -> 0x01dd, IOException -> 0x01d4, IllegalStateException -> 0x01ba }
            if (r3 == 0) goto L_0x007d
            r3 = 2
            goto L_0x007e
        L_0x004b:
            java.lang.String r3 = "version"
            boolean r3 = r0.equals(r3)     // Catch:{ FileNotFoundException -> 0x01dd, IOException -> 0x01d4, IllegalStateException -> 0x01ba }
            if (r3 == 0) goto L_0x007d
            r3 = 4
            goto L_0x007e
        L_0x0055:
            java.lang.String r3 = "timestamp"
            boolean r3 = r0.equals(r3)     // Catch:{ FileNotFoundException -> 0x01dd, IOException -> 0x01d4, IllegalStateException -> 0x01ba }
            if (r3 == 0) goto L_0x007d
            r3 = 3
            goto L_0x007e
        L_0x005f:
            java.lang.String r3 = "UID"
            boolean r3 = r0.equals(r3)     // Catch:{ FileNotFoundException -> 0x01dd, IOException -> 0x01d4, IllegalStateException -> 0x01ba }
            if (r3 == 0) goto L_0x007d
            r3 = 0
            goto L_0x007e
        L_0x0069:
            java.lang.String r3 = "callsign"
            boolean r3 = r0.equals(r3)     // Catch:{ FileNotFoundException -> 0x01dd, IOException -> 0x01d4, IllegalStateException -> 0x01ba }
            if (r3 == 0) goto L_0x007d
            r3 = 1
            goto L_0x007e
        L_0x0073:
            java.lang.String r3 = "locations"
            boolean r3 = r0.equals(r3)     // Catch:{ FileNotFoundException -> 0x01dd, IOException -> 0x01d4, IllegalStateException -> 0x01ba }
            if (r3 == 0) goto L_0x007d
            r3 = 5
            goto L_0x007e
        L_0x007d:
            r3 = -1
        L_0x007e:
            if (r3 == 0) goto L_0x01ae
            if (r3 == r10) goto L_0x01a6
            if (r3 == r9) goto L_0x019e
            if (r3 == r8) goto L_0x0196
            if (r3 == r7) goto L_0x018e
            if (r3 == r6) goto L_0x00a4
            java.lang.String r3 = TAG     // Catch:{ FileNotFoundException -> 0x01dd, IOException -> 0x01d4, IllegalStateException -> 0x01ba }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x01dd, IOException -> 0x01d4, IllegalStateException -> 0x01ba }
            r4.<init>()     // Catch:{ FileNotFoundException -> 0x01dd, IOException -> 0x01d4, IllegalStateException -> 0x01ba }
            java.lang.String r5 = "Unknown FlightLog JSON: "
            r4.append(r5)     // Catch:{ FileNotFoundException -> 0x01dd, IOException -> 0x01d4, IllegalStateException -> 0x01ba }
            r4.append(r0)     // Catch:{ FileNotFoundException -> 0x01dd, IOException -> 0x01d4, IllegalStateException -> 0x01ba }
            java.lang.String r0 = r4.toString()     // Catch:{ FileNotFoundException -> 0x01dd, IOException -> 0x01d4, IllegalStateException -> 0x01ba }
            com.atakmap.coremap.log.Log.e(r3, r0)     // Catch:{ FileNotFoundException -> 0x01dd, IOException -> 0x01d4, IllegalStateException -> 0x01ba }
            r2.skipValue()     // Catch:{ FileNotFoundException -> 0x01dd, IOException -> 0x01d4, IllegalStateException -> 0x01ba }
            goto L_0x0029
        L_0x00a4:
            r2.beginArray()     // Catch:{ FileNotFoundException -> 0x01dd, IOException -> 0x01d4, IllegalStateException -> 0x01ba }
        L_0x00a7:
            boolean r0 = r2.hasNext()     // Catch:{ FileNotFoundException -> 0x01dd, IOException -> 0x01d4, IllegalStateException -> 0x01ba }
            if (r0 == 0) goto L_0x0189
            r2.beginObject()     // Catch:{ FileNotFoundException -> 0x01dd, IOException -> 0x01d4, IllegalStateException -> 0x01ba }
            java.lang.String r0 = ""
            r12 = r0
            r13 = r12
            r14 = r13
            r15 = r14
            r16 = r15
            r17 = r16
            r18 = r17
            r19 = r18
        L_0x00be:
            boolean r0 = r2.hasNext()     // Catch:{ FileNotFoundException -> 0x01dd, IOException -> 0x01d4, IllegalStateException -> 0x01ba }
            if (r0 == 0) goto L_0x0179
            java.lang.String r0 = r1.getName(r2)     // Catch:{ FileNotFoundException -> 0x01dd, IOException -> 0x01d4, IllegalStateException -> 0x01ba }
            int r3 = r0.hashCode()     // Catch:{ FileNotFoundException -> 0x01dd, IOException -> 0x01d4, IllegalStateException -> 0x01ba }
            switch(r3) {
                case 96681: goto L_0x0116;
                case 106911: goto L_0x010c;
                case 107339: goto L_0x0102;
                case 114087: goto L_0x00f8;
                case 3076014: goto L_0x00ee;
                case 795311618: goto L_0x00e4;
                case 950394699: goto L_0x00da;
                case 954925063: goto L_0x00d0;
                default: goto L_0x00cf;
            }     // Catch:{ FileNotFoundException -> 0x01dd, IOException -> 0x01d4, IllegalStateException -> 0x01ba }
        L_0x00cf:
            goto L_0x0120
        L_0x00d0:
            java.lang.String r3 = "message"
            boolean r3 = r0.equals(r3)     // Catch:{ FileNotFoundException -> 0x01dd, IOException -> 0x01d4, IllegalStateException -> 0x01ba }
            if (r3 == 0) goto L_0x0120
            r3 = 6
            goto L_0x0121
        L_0x00da:
            java.lang.String r3 = "command"
            boolean r3 = r0.equals(r3)     // Catch:{ FileNotFoundException -> 0x01dd, IOException -> 0x01d4, IllegalStateException -> 0x01ba }
            if (r3 == 0) goto L_0x0120
            r3 = 7
            goto L_0x0121
        L_0x00e4:
            java.lang.String r3 = "heading"
            boolean r3 = r0.equals(r3)     // Catch:{ FileNotFoundException -> 0x01dd, IOException -> 0x01d4, IllegalStateException -> 0x01ba }
            if (r3 == 0) goto L_0x0120
            r3 = 5
            goto L_0x0121
        L_0x00ee:
            java.lang.String r3 = "date"
            boolean r3 = r0.equals(r3)     // Catch:{ FileNotFoundException -> 0x01dd, IOException -> 0x01d4, IllegalStateException -> 0x01ba }
            if (r3 == 0) goto L_0x0120
            r3 = 0
            goto L_0x0121
        L_0x00f8:
            java.lang.String r3 = "spd"
            boolean r3 = r0.equals(r3)     // Catch:{ FileNotFoundException -> 0x01dd, IOException -> 0x01d4, IllegalStateException -> 0x01ba }
            if (r3 == 0) goto L_0x0120
            r3 = 4
            goto L_0x0121
        L_0x0102:
            java.lang.String r3 = "lon"
            boolean r3 = r0.equals(r3)     // Catch:{ FileNotFoundException -> 0x01dd, IOException -> 0x01d4, IllegalStateException -> 0x01ba }
            if (r3 == 0) goto L_0x0120
            r3 = 2
            goto L_0x0121
        L_0x010c:
            java.lang.String r3 = "lat"
            boolean r3 = r0.equals(r3)     // Catch:{ FileNotFoundException -> 0x01dd, IOException -> 0x01d4, IllegalStateException -> 0x01ba }
            if (r3 == 0) goto L_0x0120
            r3 = 1
            goto L_0x0121
        L_0x0116:
            java.lang.String r3 = "alt"
            boolean r3 = r0.equals(r3)     // Catch:{ FileNotFoundException -> 0x01dd, IOException -> 0x01d4, IllegalStateException -> 0x01ba }
            if (r3 == 0) goto L_0x0120
            r3 = 3
            goto L_0x0121
        L_0x0120:
            r3 = -1
        L_0x0121:
            switch(r3) {
                case 0: goto L_0x0159;
                case 1: goto L_0x0152;
                case 2: goto L_0x014b;
                case 3: goto L_0x0144;
                case 4: goto L_0x013c;
                case 5: goto L_0x0135;
                case 6: goto L_0x012e;
                case 7: goto L_0x0127;
                default: goto L_0x0124;
            }     // Catch:{ FileNotFoundException -> 0x01dd, IOException -> 0x01d4, IllegalStateException -> 0x01ba }
        L_0x0124:
            java.lang.String r3 = TAG     // Catch:{ FileNotFoundException -> 0x01dd, IOException -> 0x01d4, IllegalStateException -> 0x01ba }
            goto L_0x0160
        L_0x0127:
            java.lang.String r0 = r1.getString(r2)     // Catch:{ FileNotFoundException -> 0x01dd, IOException -> 0x01d4, IllegalStateException -> 0x01ba }
            r19 = r0
            goto L_0x00be
        L_0x012e:
            java.lang.String r0 = r1.getString(r2)     // Catch:{ FileNotFoundException -> 0x01dd, IOException -> 0x01d4, IllegalStateException -> 0x01ba }
            r18 = r0
            goto L_0x00be
        L_0x0135:
            java.lang.String r0 = r1.getString(r2)     // Catch:{ FileNotFoundException -> 0x01dd, IOException -> 0x01d4, IllegalStateException -> 0x01ba }
            r17 = r0
            goto L_0x00be
        L_0x013c:
            java.lang.String r0 = r1.getString(r2)     // Catch:{ FileNotFoundException -> 0x01dd, IOException -> 0x01d4, IllegalStateException -> 0x01ba }
            r16 = r0
            goto L_0x00be
        L_0x0144:
            java.lang.String r0 = r1.getString(r2)     // Catch:{ FileNotFoundException -> 0x01dd, IOException -> 0x01d4, IllegalStateException -> 0x01ba }
            r15 = r0
            goto L_0x00be
        L_0x014b:
            java.lang.String r0 = r1.getString(r2)     // Catch:{ FileNotFoundException -> 0x01dd, IOException -> 0x01d4, IllegalStateException -> 0x01ba }
            r14 = r0
            goto L_0x00be
        L_0x0152:
            java.lang.String r0 = r1.getString(r2)     // Catch:{ FileNotFoundException -> 0x01dd, IOException -> 0x01d4, IllegalStateException -> 0x01ba }
            r13 = r0
            goto L_0x00be
        L_0x0159:
            java.lang.String r0 = r1.getString(r2)     // Catch:{ FileNotFoundException -> 0x01dd, IOException -> 0x01d4, IllegalStateException -> 0x01ba }
            r12 = r0
            goto L_0x00be
        L_0x0160:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x01dd, IOException -> 0x01d4, IllegalStateException -> 0x01ba }
            r11.<init>()     // Catch:{ FileNotFoundException -> 0x01dd, IOException -> 0x01d4, IllegalStateException -> 0x01ba }
            java.lang.String r4 = "Unknown FlightLog JSON (array): "
            r11.append(r4)     // Catch:{ FileNotFoundException -> 0x01dd, IOException -> 0x01d4, IllegalStateException -> 0x01ba }
            r11.append(r0)     // Catch:{ FileNotFoundException -> 0x01dd, IOException -> 0x01d4, IllegalStateException -> 0x01ba }
            java.lang.String r0 = r11.toString()     // Catch:{ FileNotFoundException -> 0x01dd, IOException -> 0x01d4, IllegalStateException -> 0x01ba }
            com.atakmap.coremap.log.Log.e(r3, r0)     // Catch:{ FileNotFoundException -> 0x01dd, IOException -> 0x01d4, IllegalStateException -> 0x01ba }
            r2.skipValue()     // Catch:{ FileNotFoundException -> 0x01dd, IOException -> 0x01d4, IllegalStateException -> 0x01ba }
            goto L_0x00be
        L_0x0179:
            r2.endObject()     // Catch:{ FileNotFoundException -> 0x01dd, IOException -> 0x01d4, IllegalStateException -> 0x01ba }
            java.util.List<com.atakmap.android.uastool.flightlog.FlightLogItem> r0 = r1.flightLogItems     // Catch:{ FileNotFoundException -> 0x01dd, IOException -> 0x01d4, IllegalStateException -> 0x01ba }
            com.atakmap.android.uastool.flightlog.FlightLogItem r3 = new com.atakmap.android.uastool.flightlog.FlightLogItem     // Catch:{ FileNotFoundException -> 0x01dd, IOException -> 0x01d4, IllegalStateException -> 0x01ba }
            r11 = r3
            r11.<init>(r12, r13, r14, r15, r16, r17, r18, r19)     // Catch:{ FileNotFoundException -> 0x01dd, IOException -> 0x01d4, IllegalStateException -> 0x01ba }
            r0.add(r3)     // Catch:{ FileNotFoundException -> 0x01dd, IOException -> 0x01d4, IllegalStateException -> 0x01ba }
            goto L_0x00a7
        L_0x0189:
            r2.endArray()     // Catch:{ FileNotFoundException -> 0x01dd, IOException -> 0x01d4, IllegalStateException -> 0x01ba }
            goto L_0x0029
        L_0x018e:
            java.lang.String r0 = r1.getString(r2)     // Catch:{ FileNotFoundException -> 0x01dd, IOException -> 0x01d4, IllegalStateException -> 0x01ba }
            r1.version = r0     // Catch:{ FileNotFoundException -> 0x01dd, IOException -> 0x01d4, IllegalStateException -> 0x01ba }
            goto L_0x0029
        L_0x0196:
            java.lang.String r0 = r1.getString(r2)     // Catch:{ FileNotFoundException -> 0x01dd, IOException -> 0x01d4, IllegalStateException -> 0x01ba }
            r1.timeStamp = r0     // Catch:{ FileNotFoundException -> 0x01dd, IOException -> 0x01d4, IllegalStateException -> 0x01ba }
            goto L_0x0029
        L_0x019e:
            java.lang.String r0 = r1.getString(r2)     // Catch:{ FileNotFoundException -> 0x01dd, IOException -> 0x01d4, IllegalStateException -> 0x01ba }
            r1.platformType = r0     // Catch:{ FileNotFoundException -> 0x01dd, IOException -> 0x01d4, IllegalStateException -> 0x01ba }
            goto L_0x0029
        L_0x01a6:
            java.lang.String r0 = r1.getString(r2)     // Catch:{ FileNotFoundException -> 0x01dd, IOException -> 0x01d4, IllegalStateException -> 0x01ba }
            r1.callsign = r0     // Catch:{ FileNotFoundException -> 0x01dd, IOException -> 0x01d4, IllegalStateException -> 0x01ba }
            goto L_0x0029
        L_0x01ae:
            java.lang.String r0 = r1.getString(r2)     // Catch:{ FileNotFoundException -> 0x01dd, IOException -> 0x01d4, IllegalStateException -> 0x01ba }
            r1.uid = r0     // Catch:{ FileNotFoundException -> 0x01dd, IOException -> 0x01d4, IllegalStateException -> 0x01ba }
            goto L_0x0029
        L_0x01b6:
            r2.close()     // Catch:{ FileNotFoundException -> 0x01dd, IOException -> 0x01d4, IllegalStateException -> 0x01ba }
            goto L_0x01f6
        L_0x01ba:
            r0 = move-exception
            java.lang.String r2 = TAG
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Flightlog read error in JSON element: "
            r3.append(r4)
            java.lang.String r4 = r1.filePath
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            com.atakmap.coremap.log.Log.e(r2, r3, r0)
            goto L_0x01f6
        L_0x01d4:
            r0 = move-exception
            java.lang.String r2 = TAG
            java.lang.String r3 = "FlightLog IOException"
            com.atakmap.coremap.log.Log.e(r2, r3, r0)
            goto L_0x01f6
        L_0x01dd:
            r0 = move-exception
            java.lang.String r2 = TAG
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Bad FlightLog file: "
            r3.append(r4)
            java.lang.String r4 = r1.filePath
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            com.atakmap.coremap.log.Log.e(r2, r3, r0)
        L_0x01f6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.atakmap.android.uastool.flightlog.FlightLog.readInLog(java.io.File):void");
    }

    private String getName(JsonReader jsonReader) {
        try {
            return jsonReader.nextName();
        } catch (IllegalStateException e) {
            Log.e(TAG, "FlightLog parsing error in name element", e);
            return "";
        }
    }

    private String getString(JsonReader jsonReader) {
        try {
            return jsonReader.nextString();
        } catch (IllegalStateException e) {
            Log.e(TAG, "FlightLog parsing error in string element", e);
            jsonReader.skipValue();
            return "";
        }
    }

    public String getFilePath() {
        return this.filePath;
    }

    public String getFileName() {
        return this.fileName;
    }

    public String getFileTitle() {
        return this.fileTitle;
    }

    public String getUid() {
        return this.uid;
    }

    public String getCallsign() {
        return this.callsign;
    }

    public String getPlatformType() {
        return this.platformType;
    }

    public String getTimeStamp() {
        return this.timeStamp;
    }

    public String getVersion() {
        return this.version;
    }

    public int getItemCount() {
        List<FlightLogItem> list = this.flightLogItems;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public FlightLogItem getItem(int i) {
        if (i < getItemCount()) {
            return this.flightLogItems.get(i);
        }
        return null;
    }

    public long getTimeSpan() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy");
        Date date = null;
        Date date2 = null;
        for (FlightLogItem next : this.flightLogItems) {
            try {
                Date parse = simpleDateFormat.parse(next.getDateTime());
                if (date == null || date.after(parse)) {
                    date = parse;
                }
                if (date2 == null || date2.before(parse)) {
                    date2 = parse;
                }
            } catch (ParseException e) {
                Log.e(TAG, "Bad DateTime (" + next.getDateTime() + ") in log file: " + this.fileTitle, e);
            }
        }
        if (date == null || date2 == null) {
            return 0;
        }
        return (date2.getTime() - date.getTime()) / 1000;
    }
}
