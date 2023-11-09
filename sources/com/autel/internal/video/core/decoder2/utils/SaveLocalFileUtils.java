package com.autel.internal.video.core.decoder2.utils;

import android.os.Environment;
import java.util.concurrent.ArrayBlockingQueue;

public class SaveLocalFileUtils {
    /* access modifiers changed from: private */
    public ArrayBlockingQueue<byte[]> bufferList;
    /* access modifiers changed from: private */
    public boolean isStart;
    /* access modifiers changed from: private */
    public String localFilePath = (Environment.getExternalStorageDirectory() + "/Test.mp4");
    /* access modifiers changed from: private */
    public SaveThread saveThread;

    public SaveLocalFileUtils(String str) {
        this.localFilePath = str;
    }

    private class SaveThread extends Thread {
        private SaveThread() {
        }

        /* JADX WARNING: Removed duplicated region for block: B:36:0x008e A[SYNTHETIC, Splitter:B:36:0x008e] */
        /* JADX WARNING: Removed duplicated region for block: B:41:0x0099 A[Catch:{ IOException -> 0x0095 }] */
        /* JADX WARNING: Removed duplicated region for block: B:46:0x00b2 A[SYNTHETIC, Splitter:B:46:0x00b2] */
        /* JADX WARNING: Removed duplicated region for block: B:51:0x00bd A[Catch:{ IOException -> 0x00b9 }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r6 = this;
                r0 = 0
                java.io.File r1 = new java.io.File     // Catch:{ Exception -> 0x0086, all -> 0x0082 }
                com.autel.internal.video.core.decoder2.utils.SaveLocalFileUtils r2 = com.autel.internal.video.core.decoder2.utils.SaveLocalFileUtils.this     // Catch:{ Exception -> 0x0086, all -> 0x0082 }
                java.lang.String r2 = r2.localFilePath     // Catch:{ Exception -> 0x0086, all -> 0x0082 }
                r1.<init>(r2)     // Catch:{ Exception -> 0x0086, all -> 0x0082 }
                boolean r2 = r1.exists()     // Catch:{ Exception -> 0x0086, all -> 0x0082 }
                if (r2 != 0) goto L_0x0015
                r1.delete()     // Catch:{ Exception -> 0x0086, all -> 0x0082 }
            L_0x0015:
                r1.createNewFile()     // Catch:{ Exception -> 0x0086, all -> 0x0082 }
                java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0086, all -> 0x0082 }
                r2.<init>(r1)     // Catch:{ Exception -> 0x0086, all -> 0x0082 }
                java.io.BufferedOutputStream r1 = new java.io.BufferedOutputStream     // Catch:{ Exception -> 0x007e, all -> 0x007a }
                r1.<init>(r2)     // Catch:{ Exception -> 0x007e, all -> 0x007a }
                com.autel.internal.video.core.decoder2.utils.SaveLocalFileUtils r3 = com.autel.internal.video.core.decoder2.utils.SaveLocalFileUtils.this     // Catch:{ Exception -> 0x0074, all -> 0x006e }
                r4 = 1
                boolean unused = r3.isStart = r4     // Catch:{ Exception -> 0x0074, all -> 0x006e }
            L_0x0028:
                com.autel.internal.video.core.decoder2.utils.SaveLocalFileUtils r3 = com.autel.internal.video.core.decoder2.utils.SaveLocalFileUtils.this     // Catch:{ Exception -> 0x0074, all -> 0x006e }
                boolean r3 = r3.isStart     // Catch:{ Exception -> 0x0074, all -> 0x006e }
                if (r3 == 0) goto L_0x0056
                com.autel.internal.video.core.decoder2.utils.SaveLocalFileUtils r3 = com.autel.internal.video.core.decoder2.utils.SaveLocalFileUtils.this     // Catch:{ Exception -> 0x0074, all -> 0x006e }
                java.util.concurrent.ArrayBlockingQueue r3 = r3.bufferList     // Catch:{ Exception -> 0x0074, all -> 0x006e }
                if (r3 == 0) goto L_0x0028
                com.autel.internal.video.core.decoder2.utils.SaveLocalFileUtils r3 = com.autel.internal.video.core.decoder2.utils.SaveLocalFileUtils.this     // Catch:{ Exception -> 0x0074, all -> 0x006e }
                java.util.concurrent.ArrayBlockingQueue r3 = r3.bufferList     // Catch:{ Exception -> 0x0074, all -> 0x006e }
                int r3 = r3.size()     // Catch:{ Exception -> 0x0074, all -> 0x006e }
                if (r3 <= 0) goto L_0x0028
                com.autel.internal.video.core.decoder2.utils.SaveLocalFileUtils r3 = com.autel.internal.video.core.decoder2.utils.SaveLocalFileUtils.this     // Catch:{ Exception -> 0x0074, all -> 0x006e }
                java.util.concurrent.ArrayBlockingQueue r3 = r3.bufferList     // Catch:{ Exception -> 0x0074, all -> 0x006e }
                java.lang.Object r3 = r3.poll()     // Catch:{ Exception -> 0x0074, all -> 0x006e }
                byte[] r3 = (byte[]) r3     // Catch:{ Exception -> 0x0074, all -> 0x006e }
                if (r3 == 0) goto L_0x0028
                r1.write(r3)     // Catch:{ Exception -> 0x0074, all -> 0x006e }
                goto L_0x0028
            L_0x0056:
                r1.flush()     // Catch:{ IOException -> 0x0095 }
                r1.close()     // Catch:{ IOException -> 0x0095 }
                r2.close()     // Catch:{ IOException -> 0x0095 }
                com.autel.internal.video.core.decoder2.utils.SaveLocalFileUtils r1 = com.autel.internal.video.core.decoder2.utils.SaveLocalFileUtils.this     // Catch:{ IOException -> 0x0095 }
                com.autel.internal.video.core.decoder2.utils.SaveLocalFileUtils.SaveThread unused = r1.saveThread = r0     // Catch:{ IOException -> 0x0095 }
                com.autel.internal.video.core.decoder2.utils.SaveLocalFileUtils r0 = com.autel.internal.video.core.decoder2.utils.SaveLocalFileUtils.this     // Catch:{ IOException -> 0x0095 }
                java.util.concurrent.ArrayBlockingQueue r0 = r0.bufferList     // Catch:{ IOException -> 0x0095 }
                r0.clear()     // Catch:{ IOException -> 0x0095 }
                goto L_0x00ae
            L_0x006e:
                r3 = move-exception
                r5 = r2
                r2 = r1
                r1 = r3
                r3 = r5
                goto L_0x00b0
            L_0x0074:
                r3 = move-exception
                r5 = r2
                r2 = r1
                r1 = r3
                r3 = r5
                goto L_0x0089
            L_0x007a:
                r1 = move-exception
                r3 = r2
                r2 = r0
                goto L_0x00b0
            L_0x007e:
                r1 = move-exception
                r3 = r2
                r2 = r0
                goto L_0x0089
            L_0x0082:
                r1 = move-exception
                r2 = r0
                r3 = r2
                goto L_0x00b0
            L_0x0086:
                r1 = move-exception
                r2 = r0
                r3 = r2
            L_0x0089:
                r1.printStackTrace()     // Catch:{ all -> 0x00af }
                if (r2 == 0) goto L_0x0097
                r2.flush()     // Catch:{ IOException -> 0x0095 }
                r2.close()     // Catch:{ IOException -> 0x0095 }
                goto L_0x0097
            L_0x0095:
                r0 = move-exception
                goto L_0x00ab
            L_0x0097:
                if (r3 == 0) goto L_0x009c
                r3.close()     // Catch:{ IOException -> 0x0095 }
            L_0x009c:
                com.autel.internal.video.core.decoder2.utils.SaveLocalFileUtils r1 = com.autel.internal.video.core.decoder2.utils.SaveLocalFileUtils.this     // Catch:{ IOException -> 0x0095 }
                com.autel.internal.video.core.decoder2.utils.SaveLocalFileUtils.SaveThread unused = r1.saveThread = r0     // Catch:{ IOException -> 0x0095 }
                com.autel.internal.video.core.decoder2.utils.SaveLocalFileUtils r0 = com.autel.internal.video.core.decoder2.utils.SaveLocalFileUtils.this     // Catch:{ IOException -> 0x0095 }
                java.util.concurrent.ArrayBlockingQueue r0 = r0.bufferList     // Catch:{ IOException -> 0x0095 }
                r0.clear()     // Catch:{ IOException -> 0x0095 }
                goto L_0x00ae
            L_0x00ab:
                r0.printStackTrace()
            L_0x00ae:
                return
            L_0x00af:
                r1 = move-exception
            L_0x00b0:
                if (r2 == 0) goto L_0x00bb
                r2.flush()     // Catch:{ IOException -> 0x00b9 }
                r2.close()     // Catch:{ IOException -> 0x00b9 }
                goto L_0x00bb
            L_0x00b9:
                r0 = move-exception
                goto L_0x00cf
            L_0x00bb:
                if (r3 == 0) goto L_0x00c0
                r3.close()     // Catch:{ IOException -> 0x00b9 }
            L_0x00c0:
                com.autel.internal.video.core.decoder2.utils.SaveLocalFileUtils r2 = com.autel.internal.video.core.decoder2.utils.SaveLocalFileUtils.this     // Catch:{ IOException -> 0x00b9 }
                com.autel.internal.video.core.decoder2.utils.SaveLocalFileUtils.SaveThread unused = r2.saveThread = r0     // Catch:{ IOException -> 0x00b9 }
                com.autel.internal.video.core.decoder2.utils.SaveLocalFileUtils r0 = com.autel.internal.video.core.decoder2.utils.SaveLocalFileUtils.this     // Catch:{ IOException -> 0x00b9 }
                java.util.concurrent.ArrayBlockingQueue r0 = r0.bufferList     // Catch:{ IOException -> 0x00b9 }
                r0.clear()     // Catch:{ IOException -> 0x00b9 }
                goto L_0x00d2
            L_0x00cf:
                r0.printStackTrace()
            L_0x00d2:
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.autel.internal.video.core.decoder2.utils.SaveLocalFileUtils.SaveThread.run():void");
        }
    }

    public void addBeta(byte[] bArr) {
        SaveThread saveThread2 = this.saveThread;
        if (saveThread2 != null && saveThread2.isAlive() && !this.bufferList.offer(bArr)) {
            this.bufferList.poll();
            this.bufferList.offer(bArr);
        }
    }

    public void startSaveMp4() {
        this.bufferList = new ArrayBlockingQueue<>(10);
        SaveThread saveThread2 = this.saveThread;
        if (saveThread2 == null || !saveThread2.isAlive()) {
            SaveThread saveThread3 = new SaveThread();
            this.saveThread = saveThread3;
            saveThread3.start();
        }
    }

    public void stopSaveMp4() {
        this.isStart = false;
    }
}
