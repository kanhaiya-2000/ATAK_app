package com.autel.util.log;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import java.util.concurrent.LinkedBlockingQueue;

public class LogClient {
    public static final String ACTION_MSG = "ACTION_MSG";
    public static final String IP_ADDR = "192.168.1.11";
    public static final int PORT = 12345;
    public static final String TAG = "LogClient";
    static BroadcastReceiver mReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            if (LogClient.ACTION_MSG.equals(intent.getAction())) {
                String stringExtra = intent.getStringExtra("strMsg");
                if (!TextUtils.isEmpty(stringExtra)) {
                    LogClient.taskList.offer(stringExtra);
                }
            }
        }
    };
    /* access modifiers changed from: private */
    public static LinkedBlockingQueue<String> taskList;

    /* JADX WARNING: Removed duplicated region for block: B:15:0x005d A[SYNTHETIC, Splitter:B:15:0x005d] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0064 A[SYNTHETIC, Splitter:B:21:0x0064] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0022 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void start(android.content.Context r4) {
        /*
            android.content.IntentFilter r0 = new android.content.IntentFilter
            r0.<init>()
            java.lang.String r1 = "ACTION_MSG"
            r0.addAction(r1)
            java.util.concurrent.LinkedBlockingQueue r1 = new java.util.concurrent.LinkedBlockingQueue
            r1.<init>()
            taskList = r1
            android.content.BroadcastReceiver r1 = mReceiver
            r4.registerReceiver(r1, r0)
            java.lang.String r4 = "LogClient"
            java.lang.String r0 = "客户端启动..."
            com.autel.util.log.AutelLog.m15084e((java.lang.String) r4, (java.lang.String) r0)
            java.lang.String r0 = "当接收到服务器端字符为 \"OK\" 的时候, 客户端将终止\n"
            com.autel.util.log.AutelLog.m15084e((java.lang.String) r4, (java.lang.String) r0)
        L_0x0022:
            r4 = 0
            java.net.Socket r0 = new java.net.Socket     // Catch:{ Exception -> 0x0061, all -> 0x0057 }
            java.lang.String r1 = "192.168.1.11"
            r2 = 12345(0x3039, float:1.7299E-41)
            r0.<init>(r1, r2)     // Catch:{ Exception -> 0x0061, all -> 0x0057 }
            java.io.DataInputStream r4 = new java.io.DataInputStream     // Catch:{ Exception -> 0x0055, all -> 0x0053 }
            java.io.InputStream r1 = r0.getInputStream()     // Catch:{ Exception -> 0x0055, all -> 0x0053 }
            r4.<init>(r1)     // Catch:{ Exception -> 0x0055, all -> 0x0053 }
            java.io.DataOutputStream r1 = new java.io.DataOutputStream     // Catch:{ Exception -> 0x0055, all -> 0x0053 }
            java.io.OutputStream r2 = r0.getOutputStream()     // Catch:{ Exception -> 0x0055, all -> 0x0053 }
            r1.<init>(r2)     // Catch:{ Exception -> 0x0055, all -> 0x0053 }
            java.util.concurrent.LinkedBlockingQueue<java.lang.String> r2 = taskList     // Catch:{ Exception -> 0x0055, all -> 0x0053 }
            java.lang.Object r2 = r2.take()     // Catch:{ Exception -> 0x0055, all -> 0x0053 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x0055, all -> 0x0053 }
            r1.writeUTF(r2)     // Catch:{ Exception -> 0x0055, all -> 0x0053 }
            r1.close()     // Catch:{ Exception -> 0x0055, all -> 0x0053 }
            r4.close()     // Catch:{ Exception -> 0x0055, all -> 0x0053 }
            r0.close()     // Catch:{ IOException -> 0x0022 }
            goto L_0x0022
        L_0x0053:
            r4 = move-exception
            goto L_0x005b
        L_0x0055:
            r4 = r0
            goto L_0x0062
        L_0x0057:
            r0 = move-exception
            r3 = r0
            r0 = r4
            r4 = r3
        L_0x005b:
            if (r0 == 0) goto L_0x0060
            r0.close()     // Catch:{ IOException -> 0x0060 }
        L_0x0060:
            throw r4
        L_0x0061:
        L_0x0062:
            if (r4 == 0) goto L_0x0022
            r4.close()     // Catch:{ IOException -> 0x0022 }
            goto L_0x0022
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autel.util.log.LogClient.start(android.content.Context):void");
    }
}
