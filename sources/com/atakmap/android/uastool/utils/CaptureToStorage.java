package com.atakmap.android.uastool.utils;

import java.io.File;

public class CaptureToStorage {
    private static final String TAG = "CaptureToStorage";
    private boolean captureToStorage = false;
    private String filename = "suasCapture_";
    private boolean filesCreated = false;
    private int filesize = 0;
    private final String filetype = ".dat";
    private final String foldername = "SuasCaptures";
    private final String indexFiletype = ".idx";
    private File logFile = null;
    private File logIndexFile = null;

    public CaptureToStorage(String str) {
        if (!str.isEmpty()) {
            this.filename += str;
            this.filename += "_";
        }
    }

    public void setCaptureToStorage(boolean z) {
        this.captureToStorage = z;
        this.filesCreated = false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:44:0x012f, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0130, code lost:
        if (r3 != null) goto L_0x0132;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x013b, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x013e, code lost:
        throw r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void saveToFile(java.net.DatagramPacket r10) {
        /*
            r9 = this;
            java.lang.String r0 = "error"
            java.lang.String r1 = "CaptureToStorage"
            boolean r2 = r9.captureToStorage
            if (r2 != 0) goto L_0x0009
            return
        L_0x0009:
            boolean r2 = r9.filesCreated     // Catch:{ IOException -> 0x014d }
            r3 = 1
            if (r2 != 0) goto L_0x00ac
            java.io.File r2 = new java.io.File     // Catch:{ IOException -> 0x014d }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x014d }
            r4.<init>()     // Catch:{ IOException -> 0x014d }
            java.io.File r5 = com.atakmap.coremap.filesystem.FileSystemUtils.getRoot()     // Catch:{ IOException -> 0x014d }
            java.lang.String r5 = r5.getPath()     // Catch:{ IOException -> 0x014d }
            r4.append(r5)     // Catch:{ IOException -> 0x014d }
            char r5 = java.io.File.separatorChar     // Catch:{ IOException -> 0x014d }
            r4.append(r5)     // Catch:{ IOException -> 0x014d }
            java.lang.String r5 = "SuasCaptures"
            r4.append(r5)     // Catch:{ IOException -> 0x014d }
            java.lang.String r4 = r4.toString()     // Catch:{ IOException -> 0x014d }
            r2.<init>(r4)     // Catch:{ IOException -> 0x014d }
            boolean r4 = r2.exists()     // Catch:{ IOException -> 0x014d }
            if (r4 != 0) goto L_0x003a
            r2.mkdir()     // Catch:{ IOException -> 0x014d }
        L_0x003a:
            java.io.File r4 = new java.io.File     // Catch:{ IOException -> 0x014d }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x014d }
            r5.<init>()     // Catch:{ IOException -> 0x014d }
            java.lang.String r6 = r2.getPath()     // Catch:{ IOException -> 0x014d }
            r5.append(r6)     // Catch:{ IOException -> 0x014d }
            char r6 = java.io.File.separatorChar     // Catch:{ IOException -> 0x014d }
            r5.append(r6)     // Catch:{ IOException -> 0x014d }
            java.lang.String r6 = r9.filename     // Catch:{ IOException -> 0x014d }
            r5.append(r6)     // Catch:{ IOException -> 0x014d }
            java.lang.String r6 = com.atakmap.coremap.filesystem.FileSystemUtils.getLogDateString()     // Catch:{ IOException -> 0x014d }
            r5.append(r6)     // Catch:{ IOException -> 0x014d }
            java.lang.String r6 = ".dat"
            r5.append(r6)     // Catch:{ IOException -> 0x014d }
            java.lang.String r5 = r5.toString()     // Catch:{ IOException -> 0x014d }
            r4.<init>(r5)     // Catch:{ IOException -> 0x014d }
            r9.logFile = r4     // Catch:{ IOException -> 0x014d }
            boolean r4 = r4.exists()     // Catch:{ IOException -> 0x014d }
            if (r4 != 0) goto L_0x0072
            java.io.File r4 = r9.logFile     // Catch:{ IOException -> 0x014d }
            r4.createNewFile()     // Catch:{ IOException -> 0x014d }
        L_0x0072:
            java.io.File r4 = new java.io.File     // Catch:{ IOException -> 0x014d }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x014d }
            r5.<init>()     // Catch:{ IOException -> 0x014d }
            java.lang.String r2 = r2.getPath()     // Catch:{ IOException -> 0x014d }
            r5.append(r2)     // Catch:{ IOException -> 0x014d }
            char r2 = java.io.File.separatorChar     // Catch:{ IOException -> 0x014d }
            r5.append(r2)     // Catch:{ IOException -> 0x014d }
            java.lang.String r2 = r9.filename     // Catch:{ IOException -> 0x014d }
            r5.append(r2)     // Catch:{ IOException -> 0x014d }
            java.lang.String r2 = com.atakmap.coremap.filesystem.FileSystemUtils.getLogDateString()     // Catch:{ IOException -> 0x014d }
            r5.append(r2)     // Catch:{ IOException -> 0x014d }
            java.lang.String r2 = ".idx"
            r5.append(r2)     // Catch:{ IOException -> 0x014d }
            java.lang.String r2 = r5.toString()     // Catch:{ IOException -> 0x014d }
            r4.<init>(r2)     // Catch:{ IOException -> 0x014d }
            r9.logIndexFile = r4     // Catch:{ IOException -> 0x014d }
            boolean r2 = r4.exists()     // Catch:{ IOException -> 0x014d }
            if (r2 != 0) goto L_0x00aa
            java.io.File r2 = r9.logIndexFile     // Catch:{ IOException -> 0x014d }
            r2.createNewFile()     // Catch:{ IOException -> 0x014d }
        L_0x00aa:
            r9.filesCreated = r3     // Catch:{ IOException -> 0x014d }
        L_0x00ac:
            java.io.File r2 = r9.logFile     // Catch:{ IOException -> 0x014d }
            if (r2 == 0) goto L_0x00df
            boolean r2 = r2.exists()     // Catch:{ IOException -> 0x014d }
            if (r2 == 0) goto L_0x00df
            java.io.File r2 = r9.logFile     // Catch:{ IOException -> 0x014d }
            boolean r2 = r2.canWrite()     // Catch:{ IOException -> 0x014d }
            if (r2 == 0) goto L_0x00df
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x014d }
            java.io.File r4 = r9.logFile     // Catch:{ IOException -> 0x014d }
            r2.<init>(r4, r3)     // Catch:{ IOException -> 0x014d }
            byte[] r4 = r10.getData()     // Catch:{ IOException -> 0x00d8 }
            int r5 = r10.getOffset()     // Catch:{ IOException -> 0x00d8 }
            int r6 = r10.getLength()     // Catch:{ IOException -> 0x00d8 }
            r2.write(r4, r5, r6)     // Catch:{ IOException -> 0x00d8 }
            r2.flush()     // Catch:{ IOException -> 0x00d8 }
            goto L_0x00dc
        L_0x00d8:
            r4 = move-exception
            com.atakmap.coremap.log.Log.e(r1, r0, r4)     // Catch:{ IOException -> 0x014d }
        L_0x00dc:
            r2.close()     // Catch:{ IOException -> 0x014d }
        L_0x00df:
            java.io.File r2 = r9.logIndexFile     // Catch:{ IOException -> 0x014d }
            if (r2 == 0) goto L_0x0151
            boolean r2 = r2.exists()     // Catch:{ IOException -> 0x014d }
            if (r2 == 0) goto L_0x0151
            java.io.File r2 = r9.logIndexFile     // Catch:{ IOException -> 0x014d }
            boolean r2 = r2.canWrite()     // Catch:{ IOException -> 0x014d }
            if (r2 == 0) goto L_0x0151
            java.io.FileWriter r2 = new java.io.FileWriter     // Catch:{ IOException -> 0x013f }
            java.io.File r4 = r9.logIndexFile     // Catch:{ IOException -> 0x013f }
            r2.<init>(r4, r3)     // Catch:{ IOException -> 0x013f }
            java.util.Locale r4 = com.atakmap.coremap.locale.LocaleUtil.getCurrent()     // Catch:{ all -> 0x012d }
            java.lang.String r5 = "%d,%d,%d%n"
            r6 = 3
            java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch:{ all -> 0x012d }
            r7 = 0
            int r8 = r9.filesize     // Catch:{ all -> 0x012d }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x012d }
            r6[r7] = r8     // Catch:{ all -> 0x012d }
            long r7 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x012d }
            java.lang.Long r7 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x012d }
            r6[r3] = r7     // Catch:{ all -> 0x012d }
            r3 = 2
            int r7 = r10.getLength()     // Catch:{ all -> 0x012d }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ all -> 0x012d }
            r6[r3] = r7     // Catch:{ all -> 0x012d }
            java.lang.String r3 = java.lang.String.format(r4, r5, r6)     // Catch:{ all -> 0x012d }
            r2.write(r3)     // Catch:{ all -> 0x012d }
            r2.flush()     // Catch:{ all -> 0x012d }
            r2.close()     // Catch:{ IOException -> 0x013f }
            goto L_0x0143
        L_0x012d:
            r3 = move-exception
            throw r3     // Catch:{ all -> 0x012f }
        L_0x012f:
            r4 = move-exception
            if (r3 == 0) goto L_0x013b
            r2.close()     // Catch:{ all -> 0x0136 }
            goto L_0x013e
        L_0x0136:
            r2 = move-exception
            r3.addSuppressed(r2)     // Catch:{ IOException -> 0x013f }
            goto L_0x013e
        L_0x013b:
            r2.close()     // Catch:{ IOException -> 0x013f }
        L_0x013e:
            throw r4     // Catch:{ IOException -> 0x013f }
        L_0x013f:
            r2 = move-exception
            com.atakmap.coremap.log.Log.e(r1, r0, r2)     // Catch:{ IOException -> 0x014d }
        L_0x0143:
            int r2 = r9.filesize     // Catch:{ IOException -> 0x014d }
            int r10 = r10.getLength()     // Catch:{ IOException -> 0x014d }
            int r2 = r2 + r10
            r9.filesize = r2     // Catch:{ IOException -> 0x014d }
            goto L_0x0151
        L_0x014d:
            r10 = move-exception
            com.atakmap.coremap.log.Log.e(r1, r0, r10)
        L_0x0151:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.atakmap.android.uastool.utils.CaptureToStorage.saveToFile(java.net.DatagramPacket):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00da, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00db, code lost:
        if (r5 != null) goto L_0x00dd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00e6, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00e9, code lost:
        throw r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x013d, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x013e, code lost:
        if (r3 != null) goto L_0x0140;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0149, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x014c, code lost:
        throw r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void saveToFile(java.lang.String r11) {
        /*
            r10 = this;
            java.lang.String r0 = "error"
            java.lang.String r1 = "CaptureToStorage"
            boolean r2 = r10.captureToStorage
            if (r2 != 0) goto L_0x0009
            return
        L_0x0009:
            boolean r2 = r10.filesCreated     // Catch:{ IOException -> 0x015b }
            r3 = 1
            if (r2 != 0) goto L_0x00ac
            java.io.File r2 = new java.io.File     // Catch:{ IOException -> 0x015b }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x015b }
            r4.<init>()     // Catch:{ IOException -> 0x015b }
            java.io.File r5 = com.atakmap.coremap.filesystem.FileSystemUtils.getRoot()     // Catch:{ IOException -> 0x015b }
            java.lang.String r5 = r5.getPath()     // Catch:{ IOException -> 0x015b }
            r4.append(r5)     // Catch:{ IOException -> 0x015b }
            char r5 = java.io.File.separatorChar     // Catch:{ IOException -> 0x015b }
            r4.append(r5)     // Catch:{ IOException -> 0x015b }
            java.lang.String r5 = "SuasCaptures"
            r4.append(r5)     // Catch:{ IOException -> 0x015b }
            java.lang.String r4 = r4.toString()     // Catch:{ IOException -> 0x015b }
            r2.<init>(r4)     // Catch:{ IOException -> 0x015b }
            boolean r4 = r2.exists()     // Catch:{ IOException -> 0x015b }
            if (r4 != 0) goto L_0x003a
            r2.mkdir()     // Catch:{ IOException -> 0x015b }
        L_0x003a:
            java.io.File r4 = new java.io.File     // Catch:{ IOException -> 0x015b }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x015b }
            r5.<init>()     // Catch:{ IOException -> 0x015b }
            java.lang.String r6 = r2.getPath()     // Catch:{ IOException -> 0x015b }
            r5.append(r6)     // Catch:{ IOException -> 0x015b }
            char r6 = java.io.File.separatorChar     // Catch:{ IOException -> 0x015b }
            r5.append(r6)     // Catch:{ IOException -> 0x015b }
            java.lang.String r6 = r10.filename     // Catch:{ IOException -> 0x015b }
            r5.append(r6)     // Catch:{ IOException -> 0x015b }
            java.lang.String r6 = com.atakmap.coremap.filesystem.FileSystemUtils.getLogDateString()     // Catch:{ IOException -> 0x015b }
            r5.append(r6)     // Catch:{ IOException -> 0x015b }
            java.lang.String r6 = ".dat"
            r5.append(r6)     // Catch:{ IOException -> 0x015b }
            java.lang.String r5 = r5.toString()     // Catch:{ IOException -> 0x015b }
            r4.<init>(r5)     // Catch:{ IOException -> 0x015b }
            r10.logFile = r4     // Catch:{ IOException -> 0x015b }
            boolean r4 = r4.exists()     // Catch:{ IOException -> 0x015b }
            if (r4 != 0) goto L_0x0072
            java.io.File r4 = r10.logFile     // Catch:{ IOException -> 0x015b }
            r4.createNewFile()     // Catch:{ IOException -> 0x015b }
        L_0x0072:
            java.io.File r4 = new java.io.File     // Catch:{ IOException -> 0x015b }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x015b }
            r5.<init>()     // Catch:{ IOException -> 0x015b }
            java.lang.String r2 = r2.getPath()     // Catch:{ IOException -> 0x015b }
            r5.append(r2)     // Catch:{ IOException -> 0x015b }
            char r2 = java.io.File.separatorChar     // Catch:{ IOException -> 0x015b }
            r5.append(r2)     // Catch:{ IOException -> 0x015b }
            java.lang.String r2 = r10.filename     // Catch:{ IOException -> 0x015b }
            r5.append(r2)     // Catch:{ IOException -> 0x015b }
            java.lang.String r2 = com.atakmap.coremap.filesystem.FileSystemUtils.getLogDateString()     // Catch:{ IOException -> 0x015b }
            r5.append(r2)     // Catch:{ IOException -> 0x015b }
            java.lang.String r2 = ".idx"
            r5.append(r2)     // Catch:{ IOException -> 0x015b }
            java.lang.String r2 = r5.toString()     // Catch:{ IOException -> 0x015b }
            r4.<init>(r2)     // Catch:{ IOException -> 0x015b }
            r10.logIndexFile = r4     // Catch:{ IOException -> 0x015b }
            boolean r2 = r4.exists()     // Catch:{ IOException -> 0x015b }
            if (r2 != 0) goto L_0x00aa
            java.io.File r2 = r10.logIndexFile     // Catch:{ IOException -> 0x015b }
            r2.createNewFile()     // Catch:{ IOException -> 0x015b }
        L_0x00aa:
            r10.filesCreated = r3     // Catch:{ IOException -> 0x015b }
        L_0x00ac:
            java.io.File r2 = r10.logFile     // Catch:{ IOException -> 0x015b }
            r4 = 0
            if (r2 == 0) goto L_0x00ee
            boolean r2 = r2.exists()     // Catch:{ IOException -> 0x015b }
            if (r2 == 0) goto L_0x00ee
            java.io.File r2 = r10.logFile     // Catch:{ IOException -> 0x015b }
            boolean r2 = r2.canWrite()     // Catch:{ IOException -> 0x015b }
            if (r2 == 0) goto L_0x00ee
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x00ea }
            java.io.File r5 = r10.logFile     // Catch:{ IOException -> 0x00ea }
            r2.<init>(r5, r3)     // Catch:{ IOException -> 0x00ea }
            byte[] r5 = r11.getBytes()     // Catch:{ all -> 0x00d8 }
            int r6 = r11.length()     // Catch:{ all -> 0x00d8 }
            r2.write(r5, r4, r6)     // Catch:{ all -> 0x00d8 }
            r2.flush()     // Catch:{ all -> 0x00d8 }
            r2.close()     // Catch:{ IOException -> 0x00ea }
            goto L_0x00ee
        L_0x00d8:
            r5 = move-exception
            throw r5     // Catch:{ all -> 0x00da }
        L_0x00da:
            r6 = move-exception
            if (r5 == 0) goto L_0x00e6
            r2.close()     // Catch:{ all -> 0x00e1 }
            goto L_0x00e9
        L_0x00e1:
            r2 = move-exception
            r5.addSuppressed(r2)     // Catch:{ IOException -> 0x00ea }
            goto L_0x00e9
        L_0x00e6:
            r2.close()     // Catch:{ IOException -> 0x00ea }
        L_0x00e9:
            throw r6     // Catch:{ IOException -> 0x00ea }
        L_0x00ea:
            r2 = move-exception
            com.atakmap.coremap.log.Log.e(r1, r0, r2)     // Catch:{ IOException -> 0x015b }
        L_0x00ee:
            java.io.File r2 = r10.logIndexFile     // Catch:{ IOException -> 0x015b }
            if (r2 == 0) goto L_0x015f
            boolean r2 = r2.exists()     // Catch:{ IOException -> 0x015b }
            if (r2 == 0) goto L_0x015f
            java.io.File r2 = r10.logIndexFile     // Catch:{ IOException -> 0x015b }
            boolean r2 = r2.canWrite()     // Catch:{ IOException -> 0x015b }
            if (r2 == 0) goto L_0x015f
            java.io.FileWriter r2 = new java.io.FileWriter     // Catch:{ IOException -> 0x014d }
            java.io.File r5 = r10.logIndexFile     // Catch:{ IOException -> 0x014d }
            r2.<init>(r5, r3)     // Catch:{ IOException -> 0x014d }
            java.util.Locale r5 = com.atakmap.coremap.locale.LocaleUtil.getCurrent()     // Catch:{ all -> 0x013b }
            java.lang.String r6 = "%d,%d,%d%n"
            r7 = 3
            java.lang.Object[] r7 = new java.lang.Object[r7]     // Catch:{ all -> 0x013b }
            int r8 = r10.filesize     // Catch:{ all -> 0x013b }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x013b }
            r7[r4] = r8     // Catch:{ all -> 0x013b }
            long r8 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x013b }
            java.lang.Long r4 = java.lang.Long.valueOf(r8)     // Catch:{ all -> 0x013b }
            r7[r3] = r4     // Catch:{ all -> 0x013b }
            r3 = 2
            int r4 = r11.length()     // Catch:{ all -> 0x013b }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x013b }
            r7[r3] = r4     // Catch:{ all -> 0x013b }
            java.lang.String r3 = java.lang.String.format(r5, r6, r7)     // Catch:{ all -> 0x013b }
            r2.write(r3)     // Catch:{ all -> 0x013b }
            r2.flush()     // Catch:{ all -> 0x013b }
            r2.close()     // Catch:{ IOException -> 0x014d }
            goto L_0x0151
        L_0x013b:
            r3 = move-exception
            throw r3     // Catch:{ all -> 0x013d }
        L_0x013d:
            r4 = move-exception
            if (r3 == 0) goto L_0x0149
            r2.close()     // Catch:{ all -> 0x0144 }
            goto L_0x014c
        L_0x0144:
            r2 = move-exception
            r3.addSuppressed(r2)     // Catch:{ IOException -> 0x014d }
            goto L_0x014c
        L_0x0149:
            r2.close()     // Catch:{ IOException -> 0x014d }
        L_0x014c:
            throw r4     // Catch:{ IOException -> 0x014d }
        L_0x014d:
            r2 = move-exception
            com.atakmap.coremap.log.Log.e(r1, r0, r2)     // Catch:{ IOException -> 0x015b }
        L_0x0151:
            int r2 = r10.filesize     // Catch:{ IOException -> 0x015b }
            int r11 = r11.length()     // Catch:{ IOException -> 0x015b }
            int r2 = r2 + r11
            r10.filesize = r2     // Catch:{ IOException -> 0x015b }
            goto L_0x015f
        L_0x015b:
            r11 = move-exception
            com.atakmap.coremap.log.Log.e(r1, r0, r11)
        L_0x015f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.atakmap.android.uastool.utils.CaptureToStorage.saveToFile(java.lang.String):void");
    }
}
