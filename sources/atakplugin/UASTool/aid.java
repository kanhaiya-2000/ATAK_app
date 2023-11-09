package atakplugin.UASTool;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class aid implements aia {

    /* renamed from: a */
    private static int f1405a = 1080;

    /* renamed from: b */
    private String f1406b;

    /* renamed from: c */
    private int f1407c;

    /* renamed from: d */
    private InputStream f1408d;

    /* renamed from: e */
    private OutputStream f1409e;

    /* renamed from: f */
    private Socket f1410f;

    /* renamed from: g */
    private String f1411g;

    /* renamed from: h */
    private String f1412h;

    public aid(String str) {
        int i = f1405a;
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
        this.f1406b = str;
        this.f1407c = i;
    }

    public aid(String str, int i) {
        this.f1406b = str;
        this.f1407c = i;
    }

    /* renamed from: a */
    public void mo1011a(String str, String str2) {
        this.f1411g = str;
        this.f1412h = str2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0175, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0176, code lost:
        throw r9;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x0120 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:38:0x013e */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00c1 A[Catch:{ RuntimeException -> 0x0175, Exception -> 0x0146 }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0139 A[SYNTHETIC, Splitter:B:36:0x0139] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0175 A[ExcHandler: RuntimeException (r9v1 'e' java.lang.RuntimeException A[CUSTOM_DECLARE]), Splitter:B:1:0x0002] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:33:0x0120=Splitter:B:33:0x0120, B:38:0x013e=Splitter:B:38:0x013e} */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo1005a(atakplugin.UASTool.aiz r9, java.lang.String r10, int r11, int r12) {
        /*
            r8 = this;
            if (r9 != 0) goto L_0x001b
            java.lang.String r9 = r8.f1406b     // Catch:{ RuntimeException -> 0x0175, Exception -> 0x0146 }
            int r0 = r8.f1407c     // Catch:{ RuntimeException -> 0x0175, Exception -> 0x0146 }
            java.net.Socket r9 = atakplugin.UASTool.aji.m1805a((java.lang.String) r9, (int) r0, (int) r12)     // Catch:{ RuntimeException -> 0x0175, Exception -> 0x0146 }
            r8.f1410f = r9     // Catch:{ RuntimeException -> 0x0175, Exception -> 0x0146 }
            java.io.InputStream r9 = r9.getInputStream()     // Catch:{ RuntimeException -> 0x0175, Exception -> 0x0146 }
            r8.f1408d = r9     // Catch:{ RuntimeException -> 0x0175, Exception -> 0x0146 }
            java.net.Socket r9 = r8.f1410f     // Catch:{ RuntimeException -> 0x0175, Exception -> 0x0146 }
            java.io.OutputStream r9 = r9.getOutputStream()     // Catch:{ RuntimeException -> 0x0175, Exception -> 0x0146 }
            r8.f1409e = r9     // Catch:{ RuntimeException -> 0x0175, Exception -> 0x0146 }
            goto L_0x0033
        L_0x001b:
            java.lang.String r0 = r8.f1406b     // Catch:{ RuntimeException -> 0x0175, Exception -> 0x0146 }
            int r1 = r8.f1407c     // Catch:{ RuntimeException -> 0x0175, Exception -> 0x0146 }
            java.net.Socket r0 = r9.createSocket(r0, r1)     // Catch:{ RuntimeException -> 0x0175, Exception -> 0x0146 }
            r8.f1410f = r0     // Catch:{ RuntimeException -> 0x0175, Exception -> 0x0146 }
            java.io.InputStream r0 = r9.getInputStream(r0)     // Catch:{ RuntimeException -> 0x0175, Exception -> 0x0146 }
            r8.f1408d = r0     // Catch:{ RuntimeException -> 0x0175, Exception -> 0x0146 }
            java.net.Socket r0 = r8.f1410f     // Catch:{ RuntimeException -> 0x0175, Exception -> 0x0146 }
            java.io.OutputStream r9 = r9.getOutputStream(r0)     // Catch:{ RuntimeException -> 0x0175, Exception -> 0x0146 }
            r8.f1409e = r9     // Catch:{ RuntimeException -> 0x0175, Exception -> 0x0146 }
        L_0x0033:
            if (r12 <= 0) goto L_0x003a
            java.net.Socket r9 = r8.f1410f     // Catch:{ RuntimeException -> 0x0175, Exception -> 0x0146 }
            r9.setSoTimeout(r12)     // Catch:{ RuntimeException -> 0x0175, Exception -> 0x0146 }
        L_0x003a:
            java.net.Socket r9 = r8.f1410f     // Catch:{ RuntimeException -> 0x0175, Exception -> 0x0146 }
            r12 = 1
            r9.setTcpNoDelay(r12)     // Catch:{ RuntimeException -> 0x0175, Exception -> 0x0146 }
            r9 = 1024(0x400, float:1.435E-42)
            byte[] r9 = new byte[r9]     // Catch:{ RuntimeException -> 0x0175, Exception -> 0x0146 }
            r0 = 5
            r1 = 0
            r9[r1] = r0     // Catch:{ RuntimeException -> 0x0175, Exception -> 0x0146 }
            r2 = 2
            r9[r12] = r2     // Catch:{ RuntimeException -> 0x0175, Exception -> 0x0146 }
            r9[r2] = r1     // Catch:{ RuntimeException -> 0x0175, Exception -> 0x0146 }
            r3 = 3
            r9[r3] = r2     // Catch:{ RuntimeException -> 0x0175, Exception -> 0x0146 }
            java.io.OutputStream r4 = r8.f1409e     // Catch:{ RuntimeException -> 0x0175, Exception -> 0x0146 }
            r5 = 4
            r4.write(r9, r1, r5)     // Catch:{ RuntimeException -> 0x0175, Exception -> 0x0146 }
            java.io.InputStream r4 = r8.f1408d     // Catch:{ RuntimeException -> 0x0175, Exception -> 0x0146 }
            r8.m1595a(r4, r9, r2)     // Catch:{ RuntimeException -> 0x0175, Exception -> 0x0146 }
            byte r4 = r9[r12]     // Catch:{ RuntimeException -> 0x0175, Exception -> 0x0146 }
            r4 = r4 & 255(0xff, float:3.57E-43)
            if (r4 == 0) goto L_0x00be
            if (r4 == r2) goto L_0x0064
            goto L_0x00bc
        L_0x0064:
            java.lang.String r4 = r8.f1411g     // Catch:{ RuntimeException -> 0x0175, Exception -> 0x0146 }
            if (r4 == 0) goto L_0x00bc
            java.lang.String r6 = r8.f1412h     // Catch:{ RuntimeException -> 0x0175, Exception -> 0x0146 }
            if (r6 != 0) goto L_0x006d
            goto L_0x00bc
        L_0x006d:
            r9[r1] = r12     // Catch:{ RuntimeException -> 0x0175, Exception -> 0x0146 }
            int r4 = r4.length()     // Catch:{ RuntimeException -> 0x0175, Exception -> 0x0146 }
            byte r4 = (byte) r4     // Catch:{ RuntimeException -> 0x0175, Exception -> 0x0146 }
            r9[r12] = r4     // Catch:{ RuntimeException -> 0x0175, Exception -> 0x0146 }
            java.lang.String r4 = r8.f1411g     // Catch:{ RuntimeException -> 0x0175, Exception -> 0x0146 }
            byte[] r4 = atakplugin.UASTool.aji.m1820c((java.lang.String) r4)     // Catch:{ RuntimeException -> 0x0175, Exception -> 0x0146 }
            java.lang.String r6 = r8.f1411g     // Catch:{ RuntimeException -> 0x0175, Exception -> 0x0146 }
            int r6 = r6.length()     // Catch:{ RuntimeException -> 0x0175, Exception -> 0x0146 }
            java.lang.System.arraycopy(r4, r1, r9, r2, r6)     // Catch:{ RuntimeException -> 0x0175, Exception -> 0x0146 }
            java.lang.String r4 = r8.f1411g     // Catch:{ RuntimeException -> 0x0175, Exception -> 0x0146 }
            int r4 = r4.length()     // Catch:{ RuntimeException -> 0x0175, Exception -> 0x0146 }
            int r4 = r4 + r2
            int r6 = r4 + 1
            java.lang.String r7 = r8.f1412h     // Catch:{ RuntimeException -> 0x0175, Exception -> 0x0146 }
            int r7 = r7.length()     // Catch:{ RuntimeException -> 0x0175, Exception -> 0x0146 }
            byte r7 = (byte) r7     // Catch:{ RuntimeException -> 0x0175, Exception -> 0x0146 }
            r9[r4] = r7     // Catch:{ RuntimeException -> 0x0175, Exception -> 0x0146 }
            java.lang.String r4 = r8.f1412h     // Catch:{ RuntimeException -> 0x0175, Exception -> 0x0146 }
            byte[] r4 = atakplugin.UASTool.aji.m1820c((java.lang.String) r4)     // Catch:{ RuntimeException -> 0x0175, Exception -> 0x0146 }
            java.lang.String r7 = r8.f1412h     // Catch:{ RuntimeException -> 0x0175, Exception -> 0x0146 }
            int r7 = r7.length()     // Catch:{ RuntimeException -> 0x0175, Exception -> 0x0146 }
            java.lang.System.arraycopy(r4, r1, r9, r6, r7)     // Catch:{ RuntimeException -> 0x0175, Exception -> 0x0146 }
            java.lang.String r4 = r8.f1412h     // Catch:{ RuntimeException -> 0x0175, Exception -> 0x0146 }
            int r4 = r4.length()     // Catch:{ RuntimeException -> 0x0175, Exception -> 0x0146 }
            int r6 = r6 + r4
            java.io.OutputStream r4 = r8.f1409e     // Catch:{ RuntimeException -> 0x0175, Exception -> 0x0146 }
            r4.write(r9, r1, r6)     // Catch:{ RuntimeException -> 0x0175, Exception -> 0x0146 }
            java.io.InputStream r4 = r8.f1408d     // Catch:{ RuntimeException -> 0x0175, Exception -> 0x0146 }
            r8.m1595a(r4, r9, r2)     // Catch:{ RuntimeException -> 0x0175, Exception -> 0x0146 }
            byte r4 = r9[r12]     // Catch:{ RuntimeException -> 0x0175, Exception -> 0x0146 }
            if (r4 != 0) goto L_0x00bc
            goto L_0x00be
        L_0x00bc:
            r4 = 0
            goto L_0x00bf
        L_0x00be:
            r4 = 1
        L_0x00bf:
            if (r4 == 0) goto L_0x0139
            r9[r1] = r0     // Catch:{ RuntimeException -> 0x0175, Exception -> 0x0146 }
            r9[r12] = r12     // Catch:{ RuntimeException -> 0x0175, Exception -> 0x0146 }
            r9[r2] = r1     // Catch:{ RuntimeException -> 0x0175, Exception -> 0x0146 }
            byte[] r10 = atakplugin.UASTool.aji.m1820c((java.lang.String) r10)     // Catch:{ RuntimeException -> 0x0175, Exception -> 0x0146 }
            int r4 = r10.length     // Catch:{ RuntimeException -> 0x0175, Exception -> 0x0146 }
            r9[r3] = r3     // Catch:{ RuntimeException -> 0x0175, Exception -> 0x0146 }
            byte r6 = (byte) r4     // Catch:{ RuntimeException -> 0x0175, Exception -> 0x0146 }
            r9[r5] = r6     // Catch:{ RuntimeException -> 0x0175, Exception -> 0x0146 }
            java.lang.System.arraycopy(r10, r1, r9, r0, r4)     // Catch:{ RuntimeException -> 0x0175, Exception -> 0x0146 }
            int r0 = r0 + r4
            int r10 = r0 + 1
            int r4 = r11 >>> 8
            byte r4 = (byte) r4     // Catch:{ RuntimeException -> 0x0175, Exception -> 0x0146 }
            r9[r0] = r4     // Catch:{ RuntimeException -> 0x0175, Exception -> 0x0146 }
            int r0 = r10 + 1
            r11 = r11 & 255(0xff, float:3.57E-43)
            byte r11 = (byte) r11     // Catch:{ RuntimeException -> 0x0175, Exception -> 0x0146 }
            r9[r10] = r11     // Catch:{ RuntimeException -> 0x0175, Exception -> 0x0146 }
            java.io.OutputStream r10 = r8.f1409e     // Catch:{ RuntimeException -> 0x0175, Exception -> 0x0146 }
            r10.write(r9, r1, r0)     // Catch:{ RuntimeException -> 0x0175, Exception -> 0x0146 }
            java.io.InputStream r10 = r8.f1408d     // Catch:{ RuntimeException -> 0x0175, Exception -> 0x0146 }
            r8.m1595a(r10, r9, r5)     // Catch:{ RuntimeException -> 0x0175, Exception -> 0x0146 }
            byte r10 = r9[r12]     // Catch:{ RuntimeException -> 0x0175, Exception -> 0x0146 }
            if (r10 != 0) goto L_0x011b
            byte r10 = r9[r3]     // Catch:{ RuntimeException -> 0x0175, Exception -> 0x0146 }
            r10 = r10 & 255(0xff, float:3.57E-43)
            if (r10 == r12) goto L_0x0114
            if (r10 == r3) goto L_0x0104
            if (r10 == r5) goto L_0x00fc
            goto L_0x011a
        L_0x00fc:
            java.io.InputStream r10 = r8.f1408d     // Catch:{ RuntimeException -> 0x0175, Exception -> 0x0146 }
            r11 = 18
            r8.m1595a(r10, r9, r11)     // Catch:{ RuntimeException -> 0x0175, Exception -> 0x0146 }
            goto L_0x011a
        L_0x0104:
            java.io.InputStream r10 = r8.f1408d     // Catch:{ RuntimeException -> 0x0175, Exception -> 0x0146 }
            r8.m1595a(r10, r9, r12)     // Catch:{ RuntimeException -> 0x0175, Exception -> 0x0146 }
            java.io.InputStream r10 = r8.f1408d     // Catch:{ RuntimeException -> 0x0175, Exception -> 0x0146 }
            byte r11 = r9[r1]     // Catch:{ RuntimeException -> 0x0175, Exception -> 0x0146 }
            r11 = r11 & 255(0xff, float:3.57E-43)
            int r11 = r11 + r2
            r8.m1595a(r10, r9, r11)     // Catch:{ RuntimeException -> 0x0175, Exception -> 0x0146 }
            goto L_0x011a
        L_0x0114:
            java.io.InputStream r10 = r8.f1408d     // Catch:{ RuntimeException -> 0x0175, Exception -> 0x0146 }
            r11 = 6
            r8.m1595a(r10, r9, r11)     // Catch:{ RuntimeException -> 0x0175, Exception -> 0x0146 }
        L_0x011a:
            return
        L_0x011b:
            java.net.Socket r10 = r8.f1410f     // Catch:{ Exception -> 0x0120, RuntimeException -> 0x0175 }
            r10.close()     // Catch:{ Exception -> 0x0120, RuntimeException -> 0x0175 }
        L_0x0120:
            atakplugin.UASTool.ahj r10 = new atakplugin.UASTool.ahj     // Catch:{ RuntimeException -> 0x0175, Exception -> 0x0146 }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ RuntimeException -> 0x0175, Exception -> 0x0146 }
            r11.<init>()     // Catch:{ RuntimeException -> 0x0175, Exception -> 0x0146 }
            java.lang.String r0 = "ProxySOCKS5: server returns "
            r11.append(r0)     // Catch:{ RuntimeException -> 0x0175, Exception -> 0x0146 }
            byte r9 = r9[r12]     // Catch:{ RuntimeException -> 0x0175, Exception -> 0x0146 }
            r11.append(r9)     // Catch:{ RuntimeException -> 0x0175, Exception -> 0x0146 }
            java.lang.String r9 = r11.toString()     // Catch:{ RuntimeException -> 0x0175, Exception -> 0x0146 }
            r10.<init>(r9)     // Catch:{ RuntimeException -> 0x0175, Exception -> 0x0146 }
            throw r10     // Catch:{ RuntimeException -> 0x0175, Exception -> 0x0146 }
        L_0x0139:
            java.net.Socket r9 = r8.f1410f     // Catch:{ Exception -> 0x013e, RuntimeException -> 0x0175 }
            r9.close()     // Catch:{ Exception -> 0x013e, RuntimeException -> 0x0175 }
        L_0x013e:
            atakplugin.UASTool.ahj r9 = new atakplugin.UASTool.ahj     // Catch:{ RuntimeException -> 0x0175, Exception -> 0x0146 }
            java.lang.String r10 = "fail in SOCKS5 proxy"
            r9.<init>(r10)     // Catch:{ RuntimeException -> 0x0175, Exception -> 0x0146 }
            throw r9     // Catch:{ RuntimeException -> 0x0175, Exception -> 0x0146 }
        L_0x0146:
            r9 = move-exception
            java.net.Socket r10 = r8.f1410f     // Catch:{ Exception -> 0x014f }
            if (r10 == 0) goto L_0x0150
            r10.close()     // Catch:{ Exception -> 0x014f }
            goto L_0x0150
        L_0x014f:
        L_0x0150:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "ProxySOCKS5: "
            r10.append(r11)
            java.lang.String r11 = r9.toString()
            r10.append(r11)
            java.lang.String r10 = r10.toString()
            boolean r11 = r9 instanceof java.lang.Throwable
            if (r11 == 0) goto L_0x016f
            atakplugin.UASTool.ahj r11 = new atakplugin.UASTool.ahj
            r11.<init>(r10, r9)
            throw r11
        L_0x016f:
            atakplugin.UASTool.ahj r9 = new atakplugin.UASTool.ahj
            r9.<init>(r10)
            throw r9
        L_0x0175:
            r9 = move-exception
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.aid.mo1005a(atakplugin.UASTool.aiz, java.lang.String, int, int):void");
    }

    /* renamed from: a */
    public InputStream mo1004a() {
        return this.f1408d;
    }

    /* renamed from: b */
    public OutputStream mo1006b() {
        return this.f1409e;
    }

    /* renamed from: c */
    public Socket mo1007c() {
        return this.f1410f;
    }

    /* renamed from: d */
    public void mo1008d() {
        try {
            InputStream inputStream = this.f1408d;
            if (inputStream != null) {
                inputStream.close();
            }
            OutputStream outputStream = this.f1409e;
            if (outputStream != null) {
                outputStream.close();
            }
            Socket socket = this.f1410f;
            if (socket != null) {
                socket.close();
            }
        } catch (Exception unused) {
        }
        this.f1408d = null;
        this.f1409e = null;
        this.f1410f = null;
    }

    /* renamed from: e */
    public static int m1596e() {
        return f1405a;
    }

    /* renamed from: a */
    private void m1595a(InputStream inputStream, byte[] bArr, int i) {
        int i2 = 0;
        while (i2 < i) {
            int read = inputStream.read(bArr, i2, i - i2);
            if (read > 0) {
                i2 += read;
            } else {
                throw new ahj("ProxySOCKS5: stream is closed");
            }
        }
    }
}
