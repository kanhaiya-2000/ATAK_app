package org.droidplanner.services.android.impl.utils.connection;

import android.net.Network;
import android.os.Build;
import android.os.Bundle;
import atakplugin.UASTool.ahg;
import atakplugin.UASTool.air;
import atakplugin.UASTool.aiz;
import atakplugin.UASTool.cqb;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import javax.net.SocketFactory;
import org.droidplanner.services.android.impl.communication.model.DataLink;
import org.droidplanner.services.android.impl.core.MAVLink.connection.MavLinkConnection;

public class SshConnection {
    private static final int CONNECTION_TIMEOUT = 15000;
    private static final String EXEC_CHANNEL_TYPE = "exec";
    private static final String TAG = "SshConnection";
    private final String host;
    private final ahg jsch = new ahg();
    private final DataLink.DataLinkProvider linkProvider;
    private final String password;
    private final String username;

    public interface DownloadListener {
        void onDownloaded(String str, long j);

        void onFileSizeCalculated(long j);
    }

    public interface UploadListener {
        void onUploaded(File file, long j, long j2);

        boolean shouldContinueUpload();
    }

    public SshConnection(String str, String str2, String str3, DataLink.DataLinkProvider dataLinkProvider) {
        this.host = str;
        this.username = str2;
        this.password = str3;
        this.linkProvider = dataLinkProvider;
    }

    private air getSession() {
        Network network;
        air a = this.jsch.mo886a(this.username, this.host);
        Bundle connectionExtras = this.linkProvider.getConnectionExtras();
        if (connectionExtras != null && !connectionExtras.isEmpty() && Build.VERSION.SDK_INT >= 21 && (network = (Network) connectionExtras.getParcelable(MavLinkConnection.EXTRA_NETWORK)) != null) {
            a.mo1044a((aiz) new SshSocketFactory(network.getSocketFactory()));
        }
        a.mo1051a("StrictHostKeyChecking", "no");
        a.mo1080h(this.password);
        a.mo1034a(15000);
        return a;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0013, code lost:
        return false;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean ping() {
        /*
            r3 = this;
            atakplugin.UASTool.air r0 = r3.getSession()     // Catch:{ ahj -> 0x0013, all -> 0x0011 }
            r1 = 1
            if (r0 == 0) goto L_0x0010
            boolean r2 = r0.mo1081h()
            if (r2 == 0) goto L_0x0010
            r0.mo1067d()
        L_0x0010:
            return r1
        L_0x0011:
            r0 = move-exception
            throw r0
        L_0x0013:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.droidplanner.services.android.impl.utils.connection.SshConnection.ping():boolean");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: atakplugin.UASTool.afy} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: atakplugin.UASTool.afy} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: atakplugin.UASTool.air} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: atakplugin.UASTool.afy} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: atakplugin.UASTool.afy} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: atakplugin.UASTool.afy} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: atakplugin.UASTool.afy} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: atakplugin.UASTool.air} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: atakplugin.UASTool.air} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: atakplugin.UASTool.afy} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: atakplugin.UASTool.air} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v8, resolved type: atakplugin.UASTool.air} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v9, resolved type: atakplugin.UASTool.afy} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String execute(java.lang.String r9) {
        /*
            r8 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r9)
            r1 = 0
            if (r0 == 0) goto L_0x0008
            return r1
        L_0x0008:
            atakplugin.UASTool.air r0 = r8.getSession()     // Catch:{ ahj -> 0x0093, all -> 0x0090 }
            java.lang.String r2 = "exec"
            atakplugin.UASTool.afy r2 = r0.mo1032a((java.lang.String) r2)     // Catch:{ ahj -> 0x008c, all -> 0x008a }
            r3 = r2
            atakplugin.UASTool.agc r3 = (atakplugin.UASTool.agc) r3     // Catch:{ ahj -> 0x0088, all -> 0x0086 }
            r3.mo714c((java.lang.String) r9)     // Catch:{ ahj -> 0x0088, all -> 0x0086 }
            r2.mo652a((java.io.InputStream) r1)     // Catch:{ ahj -> 0x0088, all -> 0x0086 }
            java.io.InputStream r9 = r2.mo673f()     // Catch:{ ahj -> 0x0088, all -> 0x0086 }
            r1 = 15000(0x3a98, float:2.102E-41)
            r2.mo660b((int) r1)     // Catch:{ ahj -> 0x0088, all -> 0x0086 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ ahj -> 0x0088, all -> 0x0086 }
            r1.<init>()     // Catch:{ ahj -> 0x0088, all -> 0x0086 }
            r3 = 1024(0x400, float:1.435E-42)
            byte[] r4 = new byte[r3]     // Catch:{ ahj -> 0x0088, all -> 0x0086 }
        L_0x002d:
            int r5 = r9.available()     // Catch:{ ahj -> 0x0088, all -> 0x0086 }
            r6 = 0
            if (r5 <= 0) goto L_0x0044
            int r5 = r9.read(r4, r6, r3)     // Catch:{ ahj -> 0x0088, all -> 0x0086 }
            if (r5 >= 0) goto L_0x003b
            goto L_0x0044
        L_0x003b:
            java.lang.String r7 = new java.lang.String     // Catch:{ ahj -> 0x0088, all -> 0x0086 }
            r7.<init>(r4, r6, r5)     // Catch:{ ahj -> 0x0088, all -> 0x0086 }
            r1.append(r7)     // Catch:{ ahj -> 0x0088, all -> 0x0086 }
            goto L_0x002d
        L_0x0044:
            boolean r5 = r2.mo682l()     // Catch:{ ahj -> 0x0088, all -> 0x0086 }
            if (r5 == 0) goto L_0x002d
            int r5 = r9.available()     // Catch:{ ahj -> 0x0088, all -> 0x0086 }
            if (r5 <= 0) goto L_0x0051
            goto L_0x002d
        L_0x0051:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ ahj -> 0x0088, all -> 0x0086 }
            r9.<init>()     // Catch:{ ahj -> 0x0088, all -> 0x0086 }
            java.lang.String r3 = "SSH command exit status: "
            r9.append(r3)     // Catch:{ ahj -> 0x0088, all -> 0x0086 }
            int r3 = r2.mo685o()     // Catch:{ ahj -> 0x0088, all -> 0x0086 }
            r9.append(r3)     // Catch:{ ahj -> 0x0088, all -> 0x0086 }
            java.lang.String r9 = r9.toString()     // Catch:{ ahj -> 0x0088, all -> 0x0086 }
            java.lang.Object[] r3 = new java.lang.Object[r6]     // Catch:{ ahj -> 0x0088, all -> 0x0086 }
            atakplugin.UASTool.cqb.m12007b(r9, r3)     // Catch:{ ahj -> 0x0088, all -> 0x0086 }
            java.lang.String r9 = r1.toString()     // Catch:{ ahj -> 0x0088, all -> 0x0086 }
            if (r2 == 0) goto L_0x007a
            boolean r1 = r2.mo684n()
            if (r1 == 0) goto L_0x007a
            r2.mo683m()
        L_0x007a:
            if (r0 == 0) goto L_0x0085
            boolean r1 = r0.mo1081h()
            if (r1 == 0) goto L_0x0085
            r0.mo1067d()
        L_0x0085:
            return r9
        L_0x0086:
            r9 = move-exception
            goto L_0x009d
        L_0x0088:
            r9 = move-exception
            goto L_0x008e
        L_0x008a:
            r9 = move-exception
            goto L_0x009e
        L_0x008c:
            r9 = move-exception
            r2 = r1
        L_0x008e:
            r1 = r0
            goto L_0x0095
        L_0x0090:
            r9 = move-exception
            r0 = r1
            goto L_0x009e
        L_0x0093:
            r9 = move-exception
            r2 = r1
        L_0x0095:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x009b }
            r0.<init>(r9)     // Catch:{ all -> 0x009b }
            throw r0     // Catch:{ all -> 0x009b }
        L_0x009b:
            r9 = move-exception
            r0 = r1
        L_0x009d:
            r1 = r2
        L_0x009e:
            if (r1 == 0) goto L_0x00a9
            boolean r2 = r1.mo684n()
            if (r2 == 0) goto L_0x00a9
            r1.mo683m()
        L_0x00a9:
            if (r0 == 0) goto L_0x00b4
            boolean r1 = r0.mo1081h()
            if (r1 == 0) goto L_0x00b4
            r0.mo1067d()
        L_0x00b4:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: org.droidplanner.services.android.impl.utils.connection.SshConnection.execute(java.lang.String):java.lang.String");
    }

    public boolean downloadFile(String str, String str2) {
        return downloadFile(str, str2, (DownloadListener) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:101:0x0159, code lost:
        if (r6.mo1081h() == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x015b, code lost:
        r6.mo1067d();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x01a2, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x01a4, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x01a6, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x01a7, code lost:
        r12 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x01a8, code lost:
        r4 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x01aa, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x01ab, code lost:
        r12 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x01ac, code lost:
        r4 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:167:?, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:168:?, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:169:?, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x011e, code lost:
        r4.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0125, code lost:
        if (checkAck(r12) == 0) goto L_0x013d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0127, code lost:
        if (r1 == null) goto L_0x012c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x0129, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x012c, code lost:
        if (r12 == null) goto L_0x0131;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x012e, code lost:
        r12.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x0131, code lost:
        if (r6 == null) goto L_0x013c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x0137, code lost:
        if (r6.mo1081h() == false) goto L_0x013c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x0139, code lost:
        r6.mo1067d();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x013c, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:?, code lost:
        r9[0] = 0;
        r1.write(r9, 0, 1);
        r1.flush();
        r6.mo1067d();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x0149, code lost:
        if (r1 == null) goto L_0x014e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x014b, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x014e, code lost:
        if (r12 == null) goto L_0x0153;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x0150, code lost:
        r12.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x0153, code lost:
        if (r6 == null) goto L_?;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x01a6 A[ExcHandler: all (th java.lang.Throwable), PHI: r8 
      PHI: (r8v5 java.io.InputStream) = (r8v3 java.io.InputStream), (r8v3 java.io.InputStream), (r8v6 java.io.InputStream), (r8v6 java.io.InputStream), (r8v6 java.io.InputStream), (r8v6 java.io.InputStream) binds: [B:13:0x0054, B:27:0x0083, B:40:0x00a4, B:52:0x00c4, B:48:0x00bb, B:49:?] A[DONT_GENERATE, DONT_INLINE], Splitter:B:13:0x0054] */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x01d3  */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x01d8  */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x01dd  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean downloadFile(java.lang.String r23, java.lang.String r24, org.droidplanner.services.android.impl.utils.connection.SshConnection.DownloadListener r25) {
        /*
            r22 = this;
            r0 = r23
            r1 = r24
            r2 = r25
            r3 = 0
            if (r0 == 0) goto L_0x01ec
            if (r1 != 0) goto L_0x000d
            goto L_0x01ec
        L_0x000d:
            java.io.File r5 = new java.io.File     // Catch:{ ahj -> 0x01c1, all -> 0x01bb }
            r5.<init>(r0)     // Catch:{ ahj -> 0x01c1, all -> 0x01bb }
            boolean r5 = r5.isDirectory()     // Catch:{ ahj -> 0x01c1, all -> 0x01bb }
            if (r5 == 0) goto L_0x002a
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ ahj -> 0x01c1, all -> 0x01bb }
            r5.<init>()     // Catch:{ ahj -> 0x01c1, all -> 0x01bb }
            r5.append(r0)     // Catch:{ ahj -> 0x01c1, all -> 0x01bb }
            java.lang.String r6 = java.io.File.separator     // Catch:{ ahj -> 0x01c1, all -> 0x01bb }
            r5.append(r6)     // Catch:{ ahj -> 0x01c1, all -> 0x01bb }
            java.lang.String r5 = r5.toString()     // Catch:{ ahj -> 0x01c1, all -> 0x01bb }
            goto L_0x002b
        L_0x002a:
            r5 = 0
        L_0x002b:
            atakplugin.UASTool.air r6 = r22.getSession()     // Catch:{ ahj -> 0x01c1, all -> 0x01bb }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ ahj -> 0x01b7, all -> 0x01b3 }
            r7.<init>()     // Catch:{ ahj -> 0x01b7, all -> 0x01b3 }
            java.lang.String r8 = "scp -f "
            r7.append(r8)     // Catch:{ ahj -> 0x01b7, all -> 0x01b3 }
            r7.append(r1)     // Catch:{ ahj -> 0x01b7, all -> 0x01b3 }
            java.lang.String r1 = r7.toString()     // Catch:{ ahj -> 0x01b7, all -> 0x01b3 }
            java.lang.String r7 = "exec"
            atakplugin.UASTool.afy r7 = r6.mo1032a((java.lang.String) r7)     // Catch:{ ahj -> 0x01b7, all -> 0x01b3 }
            r8 = r7
            atakplugin.UASTool.agc r8 = (atakplugin.UASTool.agc) r8     // Catch:{ ahj -> 0x01b7, all -> 0x01b3 }
            r8.mo714c((java.lang.String) r1)     // Catch:{ ahj -> 0x01b7, all -> 0x01b3 }
            java.io.OutputStream r1 = r7.mo677h()     // Catch:{ ahj -> 0x01b7, all -> 0x01b3 }
            java.io.InputStream r8 = r7.mo673f()     // Catch:{ ahj -> 0x01b0, all -> 0x01ae }
            r7.mo667c()     // Catch:{ ahj -> 0x01aa, all -> 0x01a6 }
            r7 = 1024(0x400, float:1.435E-42)
            byte[] r9 = new byte[r7]     // Catch:{ ahj -> 0x01aa, all -> 0x01a6 }
            r9[r3] = r3     // Catch:{ ahj -> 0x01aa, all -> 0x01a6 }
            r10 = 1
            r1.write(r9, r3, r10)     // Catch:{ ahj -> 0x01aa, all -> 0x01a6 }
            r1.flush()     // Catch:{ ahj -> 0x01aa, all -> 0x01a6 }
            int r11 = checkAck(r8)     // Catch:{ ahj -> 0x01aa, all -> 0x01a6 }
            r12 = 67
            if (r11 == r12) goto L_0x0082
            if (r1 == 0) goto L_0x0071
            r1.close()
        L_0x0071:
            if (r8 == 0) goto L_0x0076
            r8.close()
        L_0x0076:
            if (r6 == 0) goto L_0x0081
            boolean r0 = r6.mo1081h()
            if (r0 == 0) goto L_0x0081
            r6.mo1067d()
        L_0x0081:
            return r3
        L_0x0082:
            r11 = 5
            r8.read(r9, r3, r11)     // Catch:{ ahj -> 0x01aa, all -> 0x01a6 }
            r13 = 0
        L_0x0088:
            int r15 = r8.read(r9, r3, r10)     // Catch:{ ahj -> 0x01aa, all -> 0x01a6 }
            if (r15 >= 0) goto L_0x00a4
            if (r1 == 0) goto L_0x0093
            r1.close()
        L_0x0093:
            if (r8 == 0) goto L_0x0098
            r8.close()
        L_0x0098:
            if (r6 == 0) goto L_0x00a3
            boolean r0 = r6.mo1081h()
            if (r0 == 0) goto L_0x00a3
            r6.mo1067d()
        L_0x00a3:
            return r3
        L_0x00a4:
            byte r15 = r9[r3]     // Catch:{ ahj -> 0x01aa, all -> 0x01a6 }
            r4 = 32
            if (r15 != r4) goto L_0x018d
            r4 = 0
        L_0x00ab:
            r8.read(r9, r4, r10)     // Catch:{ ahj -> 0x01aa, all -> 0x01a6 }
            byte r15 = r9[r4]     // Catch:{ ahj -> 0x01aa, all -> 0x01a6 }
            r11 = 10
            if (r15 != r11) goto L_0x0181
            java.lang.String r11 = new java.lang.String     // Catch:{ ahj -> 0x01aa, all -> 0x01a6 }
            r11.<init>(r9, r3, r4)     // Catch:{ ahj -> 0x01aa, all -> 0x01a6 }
            if (r2 == 0) goto L_0x00c4
            r2.onFileSizeCalculated(r13)     // Catch:{ ahj -> 0x00bf, all -> 0x01a6 }
            goto L_0x00c4
        L_0x00bf:
            r0 = move-exception
            r4 = r6
            r12 = r8
            goto L_0x01c5
        L_0x00c4:
            r9[r3] = r3     // Catch:{ ahj -> 0x01aa, all -> 0x01a6 }
            r1.write(r9, r3, r10)     // Catch:{ ahj -> 0x01aa, all -> 0x01a6 }
            r1.flush()     // Catch:{ ahj -> 0x01aa, all -> 0x01a6 }
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch:{ ahj -> 0x01aa, all -> 0x01a6 }
            if (r5 != 0) goto L_0x00d2
            r5 = r0
            goto L_0x00e1
        L_0x00d2:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ ahj -> 0x01aa, all -> 0x01a6 }
            r12.<init>()     // Catch:{ ahj -> 0x01aa, all -> 0x01a6 }
            r12.append(r5)     // Catch:{ ahj -> 0x01aa, all -> 0x01a6 }
            r12.append(r11)     // Catch:{ ahj -> 0x01aa, all -> 0x01a6 }
            java.lang.String r5 = r12.toString()     // Catch:{ ahj -> 0x01aa, all -> 0x01a6 }
        L_0x00e1:
            r4.<init>(r5)     // Catch:{ ahj -> 0x01aa, all -> 0x01a6 }
            r11 = 0
        L_0x00e6:
            r18 = r11
            long r10 = (long) r7
            int r5 = (r10 > r13 ? 1 : (r10 == r13 ? 0 : -1))
            if (r5 >= 0) goto L_0x00f0
            r5 = 1024(0x400, float:1.435E-42)
            goto L_0x00f1
        L_0x00f0:
            int r5 = (int) r13
        L_0x00f1:
            int r5 = r8.read(r9, r3, r5)     // Catch:{ ahj -> 0x017b, all -> 0x0177 }
            if (r5 >= 0) goto L_0x0110
            r4.close()
            if (r1 == 0) goto L_0x00ff
            r1.close()
        L_0x00ff:
            if (r8 == 0) goto L_0x0104
            r8.close()
        L_0x0104:
            if (r6 == 0) goto L_0x010f
            boolean r0 = r6.mo1081h()
            if (r0 == 0) goto L_0x010f
            r6.mo1067d()
        L_0x010f:
            return r3
        L_0x0110:
            long r10 = (long) r5
            r12 = r8
            long r7 = r18 + r10
            r4.write(r9, r3, r5)     // Catch:{ ahj -> 0x0175, all -> 0x0172 }
            long r13 = r13 - r10
            r10 = 0
            int r5 = (r13 > r10 ? 1 : (r13 == r10 ? 0 : -1))
            if (r5 != 0) goto L_0x0161
            r4.close()     // Catch:{ ahj -> 0x0175, all -> 0x0172 }
            int r0 = checkAck(r12)     // Catch:{ ahj -> 0x01a4, all -> 0x01a2 }
            if (r0 == 0) goto L_0x013d
            if (r1 == 0) goto L_0x012c
            r1.close()
        L_0x012c:
            if (r12 == 0) goto L_0x0131
            r12.close()
        L_0x0131:
            if (r6 == 0) goto L_0x013c
            boolean r0 = r6.mo1081h()
            if (r0 == 0) goto L_0x013c
            r6.mo1067d()
        L_0x013c:
            return r3
        L_0x013d:
            r9[r3] = r3     // Catch:{ ahj -> 0x01a4, all -> 0x01a2 }
            r0 = 1
            r1.write(r9, r3, r0)     // Catch:{ ahj -> 0x01a4, all -> 0x01a2 }
            r1.flush()     // Catch:{ ahj -> 0x01a4, all -> 0x01a2 }
            r6.mo1067d()     // Catch:{ ahj -> 0x01a4, all -> 0x01a2 }
            if (r1 == 0) goto L_0x014e
            r1.close()
        L_0x014e:
            if (r12 == 0) goto L_0x0153
            r12.close()
        L_0x0153:
            if (r6 == 0) goto L_0x015e
            boolean r0 = r6.mo1081h()
            if (r0 == 0) goto L_0x015e
            r6.mo1067d()
        L_0x015e:
            r17 = 1
            return r17
        L_0x0161:
            r17 = 1
            if (r2 == 0) goto L_0x0168
            r2.onDownloaded(r0, r7)     // Catch:{ ahj -> 0x0175, all -> 0x0172 }
        L_0x0168:
            r10 = 1
            r20 = r7
            r8 = r12
            r11 = r20
            r7 = 1024(0x400, float:1.435E-42)
            goto L_0x00e6
        L_0x0172:
            r0 = move-exception
            goto L_0x01d1
        L_0x0175:
            r0 = move-exception
            goto L_0x017d
        L_0x0177:
            r0 = move-exception
            r12 = r8
            goto L_0x01d1
        L_0x017b:
            r0 = move-exception
            r12 = r8
        L_0x017d:
            r16 = r4
            r4 = r6
            goto L_0x01c7
        L_0x0181:
            r12 = r8
            r10 = 0
            r17 = 1
            int r4 = r4 + 1
            r7 = 1024(0x400, float:1.435E-42)
            r10 = 1
            goto L_0x00ab
        L_0x018d:
            r12 = r8
            r10 = 0
            r17 = 1
            r7 = 10
            long r13 = r13 * r7
            byte r4 = r9[r3]     // Catch:{ ahj -> 0x01a4, all -> 0x01a2 }
            int r4 = r4 + -48
            long r7 = (long) r4
            long r13 = r13 + r7
            r8 = r12
            r7 = 1024(0x400, float:1.435E-42)
            r10 = 1
            goto L_0x0088
        L_0x01a2:
            r0 = move-exception
            goto L_0x01a8
        L_0x01a4:
            r0 = move-exception
            goto L_0x01ac
        L_0x01a6:
            r0 = move-exception
            r12 = r8
        L_0x01a8:
            r4 = 0
            goto L_0x01d1
        L_0x01aa:
            r0 = move-exception
            r12 = r8
        L_0x01ac:
            r4 = r6
            goto L_0x01c5
        L_0x01ae:
            r0 = move-exception
            goto L_0x01b5
        L_0x01b0:
            r0 = move-exception
            r4 = r6
            goto L_0x01c4
        L_0x01b3:
            r0 = move-exception
            r1 = 0
        L_0x01b5:
            r4 = 0
            goto L_0x01bf
        L_0x01b7:
            r0 = move-exception
            r4 = r6
            r1 = 0
            goto L_0x01c4
        L_0x01bb:
            r0 = move-exception
            r1 = 0
            r4 = 0
            r6 = 0
        L_0x01bf:
            r12 = 0
            goto L_0x01d1
        L_0x01c1:
            r0 = move-exception
            r1 = 0
            r4 = 0
        L_0x01c4:
            r12 = 0
        L_0x01c5:
            r16 = 0
        L_0x01c7:
            java.io.IOException r2 = new java.io.IOException     // Catch:{ all -> 0x01cd }
            r2.<init>(r0)     // Catch:{ all -> 0x01cd }
            throw r2     // Catch:{ all -> 0x01cd }
        L_0x01cd:
            r0 = move-exception
            r6 = r4
            r4 = r16
        L_0x01d1:
            if (r4 == 0) goto L_0x01d6
            r4.close()
        L_0x01d6:
            if (r1 == 0) goto L_0x01db
            r1.close()
        L_0x01db:
            if (r12 == 0) goto L_0x01e0
            r12.close()
        L_0x01e0:
            if (r6 == 0) goto L_0x01eb
            boolean r1 = r6.mo1081h()
            if (r1 == 0) goto L_0x01eb
            r6.mo1067d()
        L_0x01eb:
            throw r0
        L_0x01ec:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: org.droidplanner.services.android.impl.utils.connection.SshConnection.downloadFile(java.lang.String, java.lang.String, org.droidplanner.services.android.impl.utils.connection.SshConnection$DownloadListener):boolean");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v0, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v0, resolved type: java.io.OutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v0, resolved type: atakplugin.UASTool.air} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v1, resolved type: java.io.OutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v2, resolved type: java.io.OutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v3, resolved type: java.io.OutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v4, resolved type: java.io.OutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v3, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v4, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v5, resolved type: atakplugin.UASTool.afy} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v5, resolved type: java.io.OutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v6, resolved type: atakplugin.UASTool.afy} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v6, resolved type: atakplugin.UASTool.air} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v6, resolved type: java.io.OutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v6, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v7, resolved type: java.io.OutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v8, resolved type: java.io.OutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v7, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v9, resolved type: java.io.OutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v11, resolved type: atakplugin.UASTool.afy} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v10, resolved type: java.io.OutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v11, resolved type: java.io.OutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v12, resolved type: java.io.OutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v8, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v9, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v11, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v7, resolved type: atakplugin.UASTool.air} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v8, resolved type: atakplugin.UASTool.air} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v9, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v11, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v12, resolved type: atakplugin.UASTool.air} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v13, resolved type: atakplugin.UASTool.air} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v14, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v16, resolved type: java.io.InputStream} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x01ce  */
    /* JADX WARNING: Removed duplicated region for block: B:160:0x01d3  */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x01d8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean uploadFile(java.io.File r20, java.lang.String r21, org.droidplanner.services.android.impl.utils.connection.SshConnection.UploadListener r22) {
        /*
            r19 = this;
            r0 = r20
            r7 = 0
            if (r0 == 0) goto L_0x01f2
            boolean r1 = r20.isFile()
            if (r1 == 0) goto L_0x01f2
            if (r22 == 0) goto L_0x0015
            boolean r1 = r22.shouldContinueUpload()
            if (r1 != 0) goto L_0x0015
            goto L_0x01f2
        L_0x0015:
            r1 = 0
            atakplugin.UASTool.air r8 = r19.getSession()     // Catch:{ ahj -> 0x01be, all -> 0x01b8 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ ahj -> 0x01b1, all -> 0x01ae }
            r2.<init>()     // Catch:{ ahj -> 0x01b1, all -> 0x01ae }
            java.lang.String r3 = "scp -t "
            r2.append(r3)     // Catch:{ ahj -> 0x01b1, all -> 0x01ae }
            r3 = r21
            r2.append(r3)     // Catch:{ ahj -> 0x01b1, all -> 0x01ae }
            java.lang.String r2 = r2.toString()     // Catch:{ ahj -> 0x01b1, all -> 0x01ae }
            java.lang.String r3 = "exec"
            atakplugin.UASTool.afy r9 = r8.mo1032a((java.lang.String) r3)     // Catch:{ ahj -> 0x01b1, all -> 0x01ae }
            r3 = r9
            atakplugin.UASTool.agc r3 = (atakplugin.UASTool.agc) r3     // Catch:{ ahj -> 0x01ab, all -> 0x01a8 }
            r3.mo714c((java.lang.String) r2)     // Catch:{ ahj -> 0x01ab, all -> 0x01a8 }
            java.io.OutputStream r10 = r9.mo677h()     // Catch:{ ahj -> 0x01ab, all -> 0x01a8 }
            java.io.InputStream r11 = r9.mo673f()     // Catch:{ ahj -> 0x01a5, all -> 0x01a2 }
            r2 = 15000(0x3a98, float:2.102E-41)
            r9.mo660b((int) r2)     // Catch:{ ahj -> 0x019f, all -> 0x019d }
            int r2 = checkAck(r11)     // Catch:{ ahj -> 0x019f, all -> 0x019d }
            if (r2 == 0) goto L_0x006d
            if (r10 == 0) goto L_0x0051
            r10.close()
        L_0x0051:
            if (r11 == 0) goto L_0x0056
            r11.close()
        L_0x0056:
            if (r9 == 0) goto L_0x0061
            boolean r0 = r9.mo684n()
            if (r0 == 0) goto L_0x0061
            r9.mo683m()
        L_0x0061:
            if (r8 == 0) goto L_0x006c
            boolean r0 = r8.mo1081h()
            if (r0 == 0) goto L_0x006c
            r8.mo1067d()
        L_0x006c:
            return r7
        L_0x006d:
            if (r22 == 0) goto L_0x0096
            boolean r2 = r22.shouldContinueUpload()     // Catch:{ ahj -> 0x019f, all -> 0x019d }
            if (r2 != 0) goto L_0x0096
            if (r10 == 0) goto L_0x007a
            r10.close()
        L_0x007a:
            if (r11 == 0) goto L_0x007f
            r11.close()
        L_0x007f:
            if (r9 == 0) goto L_0x008a
            boolean r0 = r9.mo684n()
            if (r0 == 0) goto L_0x008a
            r9.mo683m()
        L_0x008a:
            if (r8 == 0) goto L_0x0095
            boolean r0 = r8.mo1081h()
            if (r0 == 0) goto L_0x0095
            r8.mo1067d()
        L_0x0095:
            return r7
        L_0x0096:
            long r12 = r20.length()     // Catch:{ ahj -> 0x019f, all -> 0x019d }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ ahj -> 0x019f, all -> 0x019d }
            r2.<init>()     // Catch:{ ahj -> 0x019f, all -> 0x019d }
            java.lang.String r3 = "C0644 "
            r2.append(r3)     // Catch:{ ahj -> 0x019f, all -> 0x019d }
            r2.append(r12)     // Catch:{ ahj -> 0x019f, all -> 0x019d }
            java.lang.String r3 = " "
            r2.append(r3)     // Catch:{ ahj -> 0x019f, all -> 0x019d }
            java.lang.String r3 = r20.getName()     // Catch:{ ahj -> 0x019f, all -> 0x019d }
            r2.append(r3)     // Catch:{ ahj -> 0x019f, all -> 0x019d }
            java.lang.String r3 = "\n"
            r2.append(r3)     // Catch:{ ahj -> 0x019f, all -> 0x019d }
            java.lang.String r2 = r2.toString()     // Catch:{ ahj -> 0x019f, all -> 0x019d }
            byte[] r2 = r2.getBytes()     // Catch:{ ahj -> 0x019f, all -> 0x019d }
            r10.write(r2)     // Catch:{ ahj -> 0x019f, all -> 0x019d }
            r10.flush()     // Catch:{ ahj -> 0x019f, all -> 0x019d }
            int r2 = checkAck(r11)     // Catch:{ ahj -> 0x019f, all -> 0x019d }
            if (r2 == 0) goto L_0x00ed
            if (r10 == 0) goto L_0x00d1
            r10.close()
        L_0x00d1:
            if (r11 == 0) goto L_0x00d6
            r11.close()
        L_0x00d6:
            if (r9 == 0) goto L_0x00e1
            boolean r0 = r9.mo684n()
            if (r0 == 0) goto L_0x00e1
            r9.mo683m()
        L_0x00e1:
            if (r8 == 0) goto L_0x00ec
            boolean r0 = r8.mo1081h()
            if (r0 == 0) goto L_0x00ec
            r8.mo1067d()
        L_0x00ec:
            return r7
        L_0x00ed:
            java.io.FileInputStream r14 = new java.io.FileInputStream     // Catch:{ ahj -> 0x019f, all -> 0x019d }
            r14.<init>(r0)     // Catch:{ ahj -> 0x019f, all -> 0x019d }
            r15 = 8192(0x2000, float:1.14794E-41)
            byte[] r5 = new byte[r15]     // Catch:{ ahj -> 0x019b, all -> 0x0199 }
            r1 = 0
        L_0x00f8:
            int r3 = r14.read(r5, r7, r15)     // Catch:{ ahj -> 0x019b, all -> 0x0199 }
            if (r3 > 0) goto L_0x0153
            r10.write(r7)     // Catch:{ ahj -> 0x019b, all -> 0x0199 }
            r10.flush()     // Catch:{ ahj -> 0x019b, all -> 0x0199 }
            int r0 = checkAck(r11)     // Catch:{ ahj -> 0x019b, all -> 0x0199 }
            if (r0 == 0) goto L_0x012e
            r14.close()
            if (r10 == 0) goto L_0x0112
            r10.close()
        L_0x0112:
            if (r11 == 0) goto L_0x0117
            r11.close()
        L_0x0117:
            if (r9 == 0) goto L_0x0122
            boolean r0 = r9.mo684n()
            if (r0 == 0) goto L_0x0122
            r9.mo683m()
        L_0x0122:
            if (r8 == 0) goto L_0x012d
            boolean r0 = r8.mo1081h()
            if (r0 == 0) goto L_0x012d
            r8.mo1067d()
        L_0x012d:
            return r7
        L_0x012e:
            r0 = 1
            r14.close()
            if (r10 == 0) goto L_0x0137
            r10.close()
        L_0x0137:
            if (r11 == 0) goto L_0x013c
            r11.close()
        L_0x013c:
            if (r9 == 0) goto L_0x0147
            boolean r1 = r9.mo684n()
            if (r1 == 0) goto L_0x0147
            r9.mo683m()
        L_0x0147:
            if (r8 == 0) goto L_0x0152
            boolean r1 = r8.mo1081h()
            if (r1 == 0) goto L_0x0152
            r8.mo1067d()
        L_0x0152:
            return r0
        L_0x0153:
            r10.write(r5, r7, r3)     // Catch:{ ahj -> 0x019b, all -> 0x0199 }
            long r3 = (long) r3     // Catch:{ ahj -> 0x019b, all -> 0x0199 }
            long r16 = r1 + r3
            if (r22 == 0) goto L_0x0191
            r1 = r22
            r2 = r20
            r3 = r16
            r18 = r5
            r5 = r12
            r1.onUploaded(r2, r3, r5)     // Catch:{ ahj -> 0x019b, all -> 0x0199 }
            boolean r1 = r22.shouldContinueUpload()     // Catch:{ ahj -> 0x019b, all -> 0x0199 }
            if (r1 != 0) goto L_0x0193
            r14.close()
            if (r10 == 0) goto L_0x0175
            r10.close()
        L_0x0175:
            if (r11 == 0) goto L_0x017a
            r11.close()
        L_0x017a:
            if (r9 == 0) goto L_0x0185
            boolean r0 = r9.mo684n()
            if (r0 == 0) goto L_0x0185
            r9.mo683m()
        L_0x0185:
            if (r8 == 0) goto L_0x0190
            boolean r0 = r8.mo1081h()
            if (r0 == 0) goto L_0x0190
            r8.mo1067d()
        L_0x0190:
            return r7
        L_0x0191:
            r18 = r5
        L_0x0193:
            r1 = r16
            r5 = r18
            goto L_0x00f8
        L_0x0199:
            r0 = move-exception
            goto L_0x01cb
        L_0x019b:
            r0 = move-exception
            goto L_0x01b6
        L_0x019d:
            r0 = move-exception
            goto L_0x01cc
        L_0x019f:
            r0 = move-exception
            r14 = r1
            goto L_0x01b6
        L_0x01a2:
            r0 = move-exception
            r11 = r1
            goto L_0x01cc
        L_0x01a5:
            r0 = move-exception
            r11 = r1
            goto L_0x01b5
        L_0x01a8:
            r0 = move-exception
            r10 = r1
            goto L_0x01bc
        L_0x01ab:
            r0 = move-exception
            r10 = r1
            goto L_0x01b4
        L_0x01ae:
            r0 = move-exception
            r9 = r1
            goto L_0x01bb
        L_0x01b1:
            r0 = move-exception
            r9 = r1
            r10 = r9
        L_0x01b4:
            r11 = r10
        L_0x01b5:
            r14 = r11
        L_0x01b6:
            r1 = r8
            goto L_0x01c3
        L_0x01b8:
            r0 = move-exception
            r8 = r1
            r9 = r8
        L_0x01bb:
            r10 = r9
        L_0x01bc:
            r11 = r10
            goto L_0x01cc
        L_0x01be:
            r0 = move-exception
            r9 = r1
            r10 = r9
            r11 = r10
            r14 = r11
        L_0x01c3:
            java.io.IOException r2 = new java.io.IOException     // Catch:{ all -> 0x01c9 }
            r2.<init>(r0)     // Catch:{ all -> 0x01c9 }
            throw r2     // Catch:{ all -> 0x01c9 }
        L_0x01c9:
            r0 = move-exception
            r8 = r1
        L_0x01cb:
            r1 = r14
        L_0x01cc:
            if (r1 == 0) goto L_0x01d1
            r1.close()
        L_0x01d1:
            if (r10 == 0) goto L_0x01d6
            r10.close()
        L_0x01d6:
            if (r11 == 0) goto L_0x01db
            r11.close()
        L_0x01db:
            if (r9 == 0) goto L_0x01e6
            boolean r1 = r9.mo684n()
            if (r1 == 0) goto L_0x01e6
            r9.mo683m()
        L_0x01e6:
            if (r8 == 0) goto L_0x01f1
            boolean r1 = r8.mo1081h()
            if (r1 == 0) goto L_0x01f1
            r8.mo1067d()
        L_0x01f1:
            throw r0
        L_0x01f2:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: org.droidplanner.services.android.impl.utils.connection.SshConnection.uploadFile(java.io.File, java.lang.String, org.droidplanner.services.android.impl.utils.connection.SshConnection$UploadListener):boolean");
    }

    private static int checkAck(InputStream inputStream) {
        int read;
        int read2 = inputStream.read();
        if (read2 == 1 || read2 == 2) {
            StringBuilder sb = new StringBuilder();
            do {
                read = inputStream.read();
                sb.append((char) read);
            } while (read != 10);
            if (sb.length() > 0) {
                cqb.m12014e(sb.toString(), new Object[0]);
            }
        }
        return read2;
    }

    private static class SshSocketFactory implements aiz {
        private final SocketFactory socketFactory;

        private SshSocketFactory(SocketFactory socketFactory2) {
            this.socketFactory = socketFactory2;
        }

        public Socket createSocket(String str, int i) {
            return this.socketFactory.createSocket(str, i);
        }

        public InputStream getInputStream(Socket socket) {
            return socket.getInputStream();
        }

        public OutputStream getOutputStream(Socket socket) {
            return socket.getOutputStream();
        }
    }
}
