package com.atakmap.android.uastool.paladin;

import com.atakmap.android.uastool.flightlog.FlightLogger;
import com.atakmap.coremap.log.Log;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CommandParser {
    private static final String ACK = "ack";
    private static final String ACK_IP = "ip";
    private static final String ACK_PORT = "port";
    private static final String CAPABILITIES = "capabilities";
    private static final String COMMAND = "command";
    private static final String COMMANDS = "commands";
    private static final String COMMAND_TITLE = "commandTitle";
    private static final String FEATURE_TITLE = "title";
    private static final String OPTIONS = "options";
    private static final String STATUS = "status";
    private static final String STATUS_COMMAND = "command";
    private static final String TAG = "CommandParser";
    private File cmdFile = null;
    private String fileString = "";

    public static class FeatureCommand {
        private final ArrayList<String> commandDisplayName;
        private final ArrayList<String> commandName;
        private final ArrayList<LinkedHashMap<String, String>> commandSet;
        private final String title;

        public FeatureCommand(String str, ArrayList<String> arrayList, ArrayList<String> arrayList2, ArrayList<LinkedHashMap<String, String>> arrayList3) {
            this.title = str;
            this.commandName = arrayList;
            this.commandDisplayName = arrayList2;
            this.commandSet = arrayList3;
        }

        public String getTitle() {
            return this.title;
        }

        public int getNumCommands() {
            return this.commandName.size();
        }

        public String getCommandName(int i) {
            return this.commandName.get(i);
        }

        public String getCommandDisplayName(int i) {
            return this.commandDisplayName.get(i);
        }

        public String getCommandDisplayName(String str) {
            if (!this.commandName.contains(str)) {
                return "";
            }
            return this.commandDisplayName.get(this.commandName.indexOf(str));
        }

        public LinkedHashMap<String, String> getCommandSet(int i) {
            return this.commandSet.get(i);
        }
    }

    public CommandParser(File file) {
        this.cmdFile = file;
        try {
            readFile();
        } catch (IOException e) {
            Log.e(TAG, "error", e);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:58:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void readFile() {
        /*
            r7 = this;
            java.io.File r0 = r7.cmdFile
            if (r0 == 0) goto L_0x0098
            boolean r0 = r0.exists()
            if (r0 != 0) goto L_0x000c
            goto L_0x0098
        L_0x000c:
            r0 = 0
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x006b, all -> 0x0065 }
            java.io.File r2 = r7.cmdFile     // Catch:{ FileNotFoundException -> 0x006b, all -> 0x0065 }
            r1.<init>(r2)     // Catch:{ FileNotFoundException -> 0x006b, all -> 0x0065 }
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x0058, FileNotFoundException -> 0x0053, all -> 0x004e }
            java.nio.charset.Charset r3 = com.atakmap.coremap.filesystem.FileSystemUtils.UTF8_CHARSET     // Catch:{ Exception -> 0x0058, FileNotFoundException -> 0x0053, all -> 0x004e }
            r2.<init>(r1, r3)     // Catch:{ Exception -> 0x0058, FileNotFoundException -> 0x0053, all -> 0x004e }
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch:{ Exception -> 0x004b, FileNotFoundException -> 0x0046, all -> 0x0040 }
            r3.<init>(r2)     // Catch:{ Exception -> 0x004b, FileNotFoundException -> 0x0046, all -> 0x0040 }
            java.lang.String r0 = r3.readLine()     // Catch:{ Exception -> 0x004c, FileNotFoundException -> 0x003e }
        L_0x0024:
            if (r0 == 0) goto L_0x005a
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x004c, FileNotFoundException -> 0x003e }
            r4.<init>()     // Catch:{ Exception -> 0x004c, FileNotFoundException -> 0x003e }
            java.lang.String r5 = r7.fileString     // Catch:{ Exception -> 0x004c, FileNotFoundException -> 0x003e }
            r4.append(r5)     // Catch:{ Exception -> 0x004c, FileNotFoundException -> 0x003e }
            r4.append(r0)     // Catch:{ Exception -> 0x004c, FileNotFoundException -> 0x003e }
            java.lang.String r0 = r4.toString()     // Catch:{ Exception -> 0x004c, FileNotFoundException -> 0x003e }
            r7.fileString = r0     // Catch:{ Exception -> 0x004c, FileNotFoundException -> 0x003e }
            java.lang.String r0 = r3.readLine()     // Catch:{ Exception -> 0x004c, FileNotFoundException -> 0x003e }
            goto L_0x0024
        L_0x003e:
            r0 = move-exception
            goto L_0x0070
        L_0x0040:
            r3 = move-exception
            r6 = r3
            r3 = r0
            r0 = r6
            goto L_0x0088
        L_0x0046:
            r3 = move-exception
            r6 = r3
            r3 = r0
            r0 = r6
            goto L_0x0070
        L_0x004b:
            r3 = r0
        L_0x004c:
            r0 = r2
            goto L_0x0059
        L_0x004e:
            r2 = move-exception
            r3 = r0
            r0 = r2
            r2 = r3
            goto L_0x0088
        L_0x0053:
            r2 = move-exception
            r3 = r0
            r0 = r2
            r2 = r3
            goto L_0x0070
        L_0x0058:
            r3 = r0
        L_0x0059:
            r2 = r0
        L_0x005a:
            if (r3 == 0) goto L_0x005f
            r3.close()
        L_0x005f:
            if (r2 == 0) goto L_0x0083
            r2.close()
            goto L_0x0083
        L_0x0065:
            r1 = move-exception
            r2 = r0
            r3 = r2
            r0 = r1
            r1 = r3
            goto L_0x0088
        L_0x006b:
            r1 = move-exception
            r2 = r0
            r3 = r2
            r0 = r1
            r1 = r3
        L_0x0070:
            java.lang.String r4 = "CommandParser"
            java.lang.String r5 = "error"
            com.atakmap.coremap.log.Log.e(r4, r5, r0)     // Catch:{ all -> 0x0087 }
            if (r3 == 0) goto L_0x007c
            r3.close()
        L_0x007c:
            if (r2 == 0) goto L_0x0081
            r2.close()
        L_0x0081:
            if (r1 == 0) goto L_0x0086
        L_0x0083:
            r1.close()
        L_0x0086:
            return
        L_0x0087:
            r0 = move-exception
        L_0x0088:
            if (r3 == 0) goto L_0x008d
            r3.close()
        L_0x008d:
            if (r2 == 0) goto L_0x0092
            r2.close()
        L_0x0092:
            if (r1 == 0) goto L_0x0097
            r1.close()
        L_0x0097:
            throw r0
        L_0x0098:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.atakmap.android.uastool.paladin.CommandParser.readFile():void");
    }

    public LinkedHashMap<String, FeatureCommand> getFeatureMap() {
        LinkedHashMap<String, FeatureCommand> linkedHashMap = new LinkedHashMap<>();
        try {
            JSONArray jSONArray = new JSONObject(this.fileString).getJSONArray(CAPABILITIES);
            if (jSONArray == null) {
                return linkedHashMap;
            }
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                String string = jSONObject.getString(FEATURE_TITLE);
                JSONArray jSONArray2 = jSONObject.getJSONArray(COMMANDS);
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                ArrayList arrayList3 = new ArrayList();
                for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                    JSONObject jSONObject2 = jSONArray2.getJSONObject(i2);
                    arrayList2.add(jSONObject2.getString(FlightLogger.LOCS_COMMAND));
                    arrayList.add(jSONObject2.getString(COMMAND_TITLE));
                    LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                    JSONObject jSONObject3 = jSONObject2.getJSONObject(OPTIONS);
                    Iterator<String> keys = jSONObject3.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        linkedHashMap2.put(next, jSONObject3.get(next).toString());
                    }
                    arrayList3.add(linkedHashMap2);
                }
                linkedHashMap.put(string, new FeatureCommand(string, arrayList2, arrayList, arrayList3));
            }
            return linkedHashMap;
        } catch (JSONException e) {
            Log.e(TAG, "error", e);
        }
    }

    private JSONObject getAck() {
        if (this.fileString.length() == 0) {
            return null;
        }
        try {
            return new JSONObject(this.fileString).getJSONObject(ACK);
        } catch (JSONException e) {
            Log.e(TAG, "error", e);
            return null;
        }
    }

    public String getAckIP() {
        JSONObject ack = getAck();
        if (ack == null) {
            return "";
        }
        try {
            return ack.get(ACK_IP).toString();
        } catch (JSONException e) {
            Log.e(TAG, "error", e);
            return "";
        }
    }

    public int getAckPort() {
        JSONObject ack = getAck();
        if (ack == null) {
            return 0;
        }
        try {
            return Integer.parseInt(ack.get(ACK_PORT).toString());
        } catch (JSONException e) {
            Log.e(TAG, "error", e);
            return 0;
        }
    }

    private JSONObject getStatus() {
        if (this.fileString.length() == 0) {
            return null;
        }
        try {
            return new JSONObject(this.fileString).getJSONObject("status");
        } catch (JSONException e) {
            Log.e(TAG, "error", e);
            return null;
        }
    }

    public String getStatusCommand() {
        JSONObject status = getStatus();
        if (status == null) {
            return "";
        }
        try {
            return status.get(FlightLogger.LOCS_COMMAND).toString();
        } catch (JSONException e) {
            Log.e(TAG, "error", e);
            return "";
        }
    }
}
