package atakplugin.UASTool;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class aic implements aia {

    /* renamed from: a */
    private static int f1397a = 1080;

    /* renamed from: b */
    private String f1398b;

    /* renamed from: c */
    private int f1399c;

    /* renamed from: d */
    private InputStream f1400d;

    /* renamed from: e */
    private OutputStream f1401e;

    /* renamed from: f */
    private Socket f1402f;

    /* renamed from: g */
    private String f1403g;

    /* renamed from: h */
    private String f1404h;

    public aic(String str) {
        int i = f1397a;
        if (str.indexOf(58) != -1) {
            try {
                String substring = str.substring(0, str.indexOf(58));
                try {
                    i = Integer.parseInt(str.substring(str.indexOf(58) + 1));
                } catch (Exception unused) {
                }
                str = substring;
            } catch (Exception unused2) {
            }
        }
        this.f1398b = str;
        this.f1399c = i;
    }

    public aic(String str, int i) {
        this.f1398b = str;
        this.f1399c = i;
    }

    /* renamed from: a */
    public void mo1010a(String str, String str2) {
        this.f1403g = str;
        this.f1404h = str2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0125, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0126, code lost:
        throw r7;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:34:0x00b8 */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0125 A[ExcHandler: RuntimeException (r7v1 'e' java.lang.RuntimeException A[CUSTOM_DECLARE]), Splitter:B:2:0x0004] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo1005a(atakplugin.UASTool.aiz r7, java.lang.String r8, int r9, int r10) {
        /*
            r6 = this;
            java.lang.String r0 = "ProxySOCKS4: "
            if (r7 != 0) goto L_0x001d
            java.lang.String r7 = r6.f1398b     // Catch:{ RuntimeException -> 0x0125, Exception -> 0x0104 }
            int r1 = r6.f1399c     // Catch:{ RuntimeException -> 0x0125, Exception -> 0x0104 }
            java.net.Socket r7 = atakplugin.UASTool.aji.m1805a((java.lang.String) r7, (int) r1, (int) r10)     // Catch:{ RuntimeException -> 0x0125, Exception -> 0x0104 }
            r6.f1402f = r7     // Catch:{ RuntimeException -> 0x0125, Exception -> 0x0104 }
            java.io.InputStream r7 = r7.getInputStream()     // Catch:{ RuntimeException -> 0x0125, Exception -> 0x0104 }
            r6.f1400d = r7     // Catch:{ RuntimeException -> 0x0125, Exception -> 0x0104 }
            java.net.Socket r7 = r6.f1402f     // Catch:{ RuntimeException -> 0x0125, Exception -> 0x0104 }
            java.io.OutputStream r7 = r7.getOutputStream()     // Catch:{ RuntimeException -> 0x0125, Exception -> 0x0104 }
            r6.f1401e = r7     // Catch:{ RuntimeException -> 0x0125, Exception -> 0x0104 }
            goto L_0x0035
        L_0x001d:
            java.lang.String r1 = r6.f1398b     // Catch:{ RuntimeException -> 0x0125, Exception -> 0x0104 }
            int r2 = r6.f1399c     // Catch:{ RuntimeException -> 0x0125, Exception -> 0x0104 }
            java.net.Socket r1 = r7.createSocket(r1, r2)     // Catch:{ RuntimeException -> 0x0125, Exception -> 0x0104 }
            r6.f1402f = r1     // Catch:{ RuntimeException -> 0x0125, Exception -> 0x0104 }
            java.io.InputStream r1 = r7.getInputStream(r1)     // Catch:{ RuntimeException -> 0x0125, Exception -> 0x0104 }
            r6.f1400d = r1     // Catch:{ RuntimeException -> 0x0125, Exception -> 0x0104 }
            java.net.Socket r1 = r6.f1402f     // Catch:{ RuntimeException -> 0x0125, Exception -> 0x0104 }
            java.io.OutputStream r7 = r7.getOutputStream(r1)     // Catch:{ RuntimeException -> 0x0125, Exception -> 0x0104 }
            r6.f1401e = r7     // Catch:{ RuntimeException -> 0x0125, Exception -> 0x0104 }
        L_0x0035:
            if (r10 <= 0) goto L_0x003c
            java.net.Socket r7 = r6.f1402f     // Catch:{ RuntimeException -> 0x0125, Exception -> 0x0104 }
            r7.setSoTimeout(r10)     // Catch:{ RuntimeException -> 0x0125, Exception -> 0x0104 }
        L_0x003c:
            java.net.Socket r7 = r6.f1402f     // Catch:{ RuntimeException -> 0x0125, Exception -> 0x0104 }
            r10 = 1
            r7.setTcpNoDelay(r10)     // Catch:{ RuntimeException -> 0x0125, Exception -> 0x0104 }
            r7 = 1024(0x400, float:1.435E-42)
            byte[] r7 = new byte[r7]     // Catch:{ RuntimeException -> 0x0125, Exception -> 0x0104 }
            r1 = 4
            r2 = 0
            r7[r2] = r1     // Catch:{ RuntimeException -> 0x0125, Exception -> 0x0104 }
            r3 = 2
            r7[r10] = r10     // Catch:{ RuntimeException -> 0x0125, Exception -> 0x0104 }
            r4 = 3
            int r5 = r9 >>> 8
            byte r5 = (byte) r5     // Catch:{ RuntimeException -> 0x0125, Exception -> 0x0104 }
            r7[r3] = r5     // Catch:{ RuntimeException -> 0x0125, Exception -> 0x0104 }
            r9 = r9 & 255(0xff, float:3.57E-43)
            byte r9 = (byte) r9     // Catch:{ RuntimeException -> 0x0125, Exception -> 0x0104 }
            r7[r4] = r9     // Catch:{ RuntimeException -> 0x0125, Exception -> 0x0104 }
            java.net.InetAddress r8 = java.net.InetAddress.getByName(r8)     // Catch:{ UnknownHostException -> 0x00ea }
            byte[] r8 = r8.getAddress()     // Catch:{ UnknownHostException -> 0x00ea }
            r9 = 0
        L_0x0061:
            int r3 = r8.length     // Catch:{ UnknownHostException -> 0x00ea }
            if (r9 >= r3) goto L_0x006e
            int r3 = r1 + 1
            byte r4 = r8[r9]     // Catch:{ UnknownHostException -> 0x00ea }
            r7[r1] = r4     // Catch:{ UnknownHostException -> 0x00ea }
            int r9 = r9 + 1
            r1 = r3
            goto L_0x0061
        L_0x006e:
            java.lang.String r8 = r6.f1403g     // Catch:{ RuntimeException -> 0x0125, Exception -> 0x0104 }
            if (r8 == 0) goto L_0x0086
            byte[] r8 = atakplugin.UASTool.aji.m1820c((java.lang.String) r8)     // Catch:{ RuntimeException -> 0x0125, Exception -> 0x0104 }
            java.lang.String r9 = r6.f1403g     // Catch:{ RuntimeException -> 0x0125, Exception -> 0x0104 }
            int r9 = r9.length()     // Catch:{ RuntimeException -> 0x0125, Exception -> 0x0104 }
            java.lang.System.arraycopy(r8, r2, r7, r1, r9)     // Catch:{ RuntimeException -> 0x0125, Exception -> 0x0104 }
            java.lang.String r8 = r6.f1403g     // Catch:{ RuntimeException -> 0x0125, Exception -> 0x0104 }
            int r8 = r8.length()     // Catch:{ RuntimeException -> 0x0125, Exception -> 0x0104 }
            int r1 = r1 + r8
        L_0x0086:
            int r8 = r1 + 1
            r7[r1] = r2     // Catch:{ RuntimeException -> 0x0125, Exception -> 0x0104 }
            java.io.OutputStream r9 = r6.f1401e     // Catch:{ RuntimeException -> 0x0125, Exception -> 0x0104 }
            r9.write(r7, r2, r8)     // Catch:{ RuntimeException -> 0x0125, Exception -> 0x0104 }
            r8 = 0
        L_0x0090:
            r9 = 8
            if (r8 >= r9) goto L_0x00a8
            java.io.InputStream r9 = r6.f1400d     // Catch:{ RuntimeException -> 0x0125, Exception -> 0x0104 }
            int r1 = 8 - r8
            int r9 = r9.read(r7, r8, r1)     // Catch:{ RuntimeException -> 0x0125, Exception -> 0x0104 }
            if (r9 <= 0) goto L_0x00a0
            int r8 = r8 + r9
            goto L_0x0090
        L_0x00a0:
            atakplugin.UASTool.ahj r7 = new atakplugin.UASTool.ahj     // Catch:{ RuntimeException -> 0x0125, Exception -> 0x0104 }
            java.lang.String r8 = "ProxySOCKS4: stream is closed"
            r7.<init>(r8)     // Catch:{ RuntimeException -> 0x0125, Exception -> 0x0104 }
            throw r7     // Catch:{ RuntimeException -> 0x0125, Exception -> 0x0104 }
        L_0x00a8:
            byte r8 = r7[r2]     // Catch:{ RuntimeException -> 0x0125, Exception -> 0x0104 }
            if (r8 != 0) goto L_0x00d1
            byte r8 = r7[r10]     // Catch:{ RuntimeException -> 0x0125, Exception -> 0x0104 }
            r9 = 90
            if (r8 != r9) goto L_0x00b3
            return
        L_0x00b3:
            java.net.Socket r8 = r6.f1402f     // Catch:{ Exception -> 0x00b8, RuntimeException -> 0x0125 }
            r8.close()     // Catch:{ Exception -> 0x00b8, RuntimeException -> 0x0125 }
        L_0x00b8:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ RuntimeException -> 0x0125, Exception -> 0x0104 }
            r8.<init>()     // Catch:{ RuntimeException -> 0x0125, Exception -> 0x0104 }
            java.lang.String r9 = "ProxySOCKS4: server returns CD "
            r8.append(r9)     // Catch:{ RuntimeException -> 0x0125, Exception -> 0x0104 }
            byte r7 = r7[r10]     // Catch:{ RuntimeException -> 0x0125, Exception -> 0x0104 }
            r8.append(r7)     // Catch:{ RuntimeException -> 0x0125, Exception -> 0x0104 }
            java.lang.String r7 = r8.toString()     // Catch:{ RuntimeException -> 0x0125, Exception -> 0x0104 }
            atakplugin.UASTool.ahj r8 = new atakplugin.UASTool.ahj     // Catch:{ RuntimeException -> 0x0125, Exception -> 0x0104 }
            r8.<init>(r7)     // Catch:{ RuntimeException -> 0x0125, Exception -> 0x0104 }
            throw r8     // Catch:{ RuntimeException -> 0x0125, Exception -> 0x0104 }
        L_0x00d1:
            atakplugin.UASTool.ahj r8 = new atakplugin.UASTool.ahj     // Catch:{ RuntimeException -> 0x0125, Exception -> 0x0104 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ RuntimeException -> 0x0125, Exception -> 0x0104 }
            r9.<init>()     // Catch:{ RuntimeException -> 0x0125, Exception -> 0x0104 }
            java.lang.String r10 = "ProxySOCKS4: server returns VN "
            r9.append(r10)     // Catch:{ RuntimeException -> 0x0125, Exception -> 0x0104 }
            byte r7 = r7[r2]     // Catch:{ RuntimeException -> 0x0125, Exception -> 0x0104 }
            r9.append(r7)     // Catch:{ RuntimeException -> 0x0125, Exception -> 0x0104 }
            java.lang.String r7 = r9.toString()     // Catch:{ RuntimeException -> 0x0125, Exception -> 0x0104 }
            r8.<init>(r7)     // Catch:{ RuntimeException -> 0x0125, Exception -> 0x0104 }
            throw r8     // Catch:{ RuntimeException -> 0x0125, Exception -> 0x0104 }
        L_0x00ea:
            r7 = move-exception
            atakplugin.UASTool.ahj r8 = new atakplugin.UASTool.ahj     // Catch:{ RuntimeException -> 0x0125, Exception -> 0x0104 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ RuntimeException -> 0x0125, Exception -> 0x0104 }
            r9.<init>()     // Catch:{ RuntimeException -> 0x0125, Exception -> 0x0104 }
            r9.append(r0)     // Catch:{ RuntimeException -> 0x0125, Exception -> 0x0104 }
            java.lang.String r10 = r7.toString()     // Catch:{ RuntimeException -> 0x0125, Exception -> 0x0104 }
            r9.append(r10)     // Catch:{ RuntimeException -> 0x0125, Exception -> 0x0104 }
            java.lang.String r9 = r9.toString()     // Catch:{ RuntimeException -> 0x0125, Exception -> 0x0104 }
            r8.<init>(r9, r7)     // Catch:{ RuntimeException -> 0x0125, Exception -> 0x0104 }
            throw r8     // Catch:{ RuntimeException -> 0x0125, Exception -> 0x0104 }
        L_0x0104:
            r7 = move-exception
            java.net.Socket r8 = r6.f1402f     // Catch:{ Exception -> 0x010c }
            if (r8 == 0) goto L_0x010c
            r8.close()     // Catch:{ Exception -> 0x010c }
        L_0x010c:
            atakplugin.UASTool.ahj r8 = new atakplugin.UASTool.ahj
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r9.append(r0)
            java.lang.String r7 = r7.toString()
            r9.append(r7)
            java.lang.String r7 = r9.toString()
            r8.<init>(r7)
            throw r8
        L_0x0125:
            r7 = move-exception
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.aic.mo1005a(atakplugin.UASTool.aiz, java.lang.String, int, int):void");
    }

    /* renamed from: a */
    public InputStream mo1004a() {
        return this.f1400d;
    }

    /* renamed from: b */
    public OutputStream mo1006b() {
        return this.f1401e;
    }

    /* renamed from: c */
    public Socket mo1007c() {
        return this.f1402f;
    }

    /* renamed from: d */
    public void mo1008d() {
        try {
            InputStream inputStream = this.f1400d;
            if (inputStream != null) {
                inputStream.close();
            }
            OutputStream outputStream = this.f1401e;
            if (outputStream != null) {
                outputStream.close();
            }
            Socket socket = this.f1402f;
            if (socket != null) {
                socket.close();
            }
        } catch (Exception unused) {
        }
        this.f1400d = null;
        this.f1401e = null;
        this.f1402f = null;
    }

    /* renamed from: e */
    public static int m1588e() {
        return f1397a;
    }
}
