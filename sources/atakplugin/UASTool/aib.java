package atakplugin.UASTool;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class aib implements aia {

    /* renamed from: a */
    private static int f1389a = 80;

    /* renamed from: b */
    private String f1390b;

    /* renamed from: c */
    private int f1391c;

    /* renamed from: d */
    private InputStream f1392d;

    /* renamed from: e */
    private OutputStream f1393e;

    /* renamed from: f */
    private Socket f1394f;

    /* renamed from: g */
    private String f1395g;

    /* renamed from: h */
    private String f1396h;

    public aib(String str) {
        int i = f1389a;
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
        this.f1390b = str;
        this.f1391c = i;
    }

    public aib(String str, int i) {
        this.f1390b = str;
        this.f1391c = i;
    }

    /* renamed from: a */
    public void mo1009a(String str, String str2) {
        this.f1395g = str;
        this.f1396h = str2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0170, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0171, code lost:
        throw r7;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0170 A[ExcHandler: RuntimeException (r7v1 'e' java.lang.RuntimeException A[CUSTOM_DECLARE]), Splitter:B:2:0x0004] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo1005a(atakplugin.UASTool.aiz r7, java.lang.String r8, int r9, int r10) {
        /*
            r6 = this;
            java.lang.String r0 = ":"
            if (r7 != 0) goto L_0x001d
            java.lang.String r7 = r6.f1390b     // Catch:{ RuntimeException -> 0x0170, Exception -> 0x0141 }
            int r1 = r6.f1391c     // Catch:{ RuntimeException -> 0x0170, Exception -> 0x0141 }
            java.net.Socket r7 = atakplugin.UASTool.aji.m1805a((java.lang.String) r7, (int) r1, (int) r10)     // Catch:{ RuntimeException -> 0x0170, Exception -> 0x0141 }
            r6.f1394f = r7     // Catch:{ RuntimeException -> 0x0170, Exception -> 0x0141 }
            java.io.InputStream r7 = r7.getInputStream()     // Catch:{ RuntimeException -> 0x0170, Exception -> 0x0141 }
            r6.f1392d = r7     // Catch:{ RuntimeException -> 0x0170, Exception -> 0x0141 }
            java.net.Socket r7 = r6.f1394f     // Catch:{ RuntimeException -> 0x0170, Exception -> 0x0141 }
            java.io.OutputStream r7 = r7.getOutputStream()     // Catch:{ RuntimeException -> 0x0170, Exception -> 0x0141 }
            r6.f1393e = r7     // Catch:{ RuntimeException -> 0x0170, Exception -> 0x0141 }
            goto L_0x0035
        L_0x001d:
            java.lang.String r1 = r6.f1390b     // Catch:{ RuntimeException -> 0x0170, Exception -> 0x0141 }
            int r2 = r6.f1391c     // Catch:{ RuntimeException -> 0x0170, Exception -> 0x0141 }
            java.net.Socket r1 = r7.createSocket(r1, r2)     // Catch:{ RuntimeException -> 0x0170, Exception -> 0x0141 }
            r6.f1394f = r1     // Catch:{ RuntimeException -> 0x0170, Exception -> 0x0141 }
            java.io.InputStream r1 = r7.getInputStream(r1)     // Catch:{ RuntimeException -> 0x0170, Exception -> 0x0141 }
            r6.f1392d = r1     // Catch:{ RuntimeException -> 0x0170, Exception -> 0x0141 }
            java.net.Socket r1 = r6.f1394f     // Catch:{ RuntimeException -> 0x0170, Exception -> 0x0141 }
            java.io.OutputStream r7 = r7.getOutputStream(r1)     // Catch:{ RuntimeException -> 0x0170, Exception -> 0x0141 }
            r6.f1393e = r7     // Catch:{ RuntimeException -> 0x0170, Exception -> 0x0141 }
        L_0x0035:
            if (r10 <= 0) goto L_0x003c
            java.net.Socket r7 = r6.f1394f     // Catch:{ RuntimeException -> 0x0170, Exception -> 0x0141 }
            r7.setSoTimeout(r10)     // Catch:{ RuntimeException -> 0x0170, Exception -> 0x0141 }
        L_0x003c:
            java.net.Socket r7 = r6.f1394f     // Catch:{ RuntimeException -> 0x0170, Exception -> 0x0141 }
            r10 = 1
            r7.setTcpNoDelay(r10)     // Catch:{ RuntimeException -> 0x0170, Exception -> 0x0141 }
            java.io.OutputStream r7 = r6.f1393e     // Catch:{ RuntimeException -> 0x0170, Exception -> 0x0141 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ RuntimeException -> 0x0170, Exception -> 0x0141 }
            r1.<init>()     // Catch:{ RuntimeException -> 0x0170, Exception -> 0x0141 }
            java.lang.String r2 = "CONNECT "
            r1.append(r2)     // Catch:{ RuntimeException -> 0x0170, Exception -> 0x0141 }
            r1.append(r8)     // Catch:{ RuntimeException -> 0x0170, Exception -> 0x0141 }
            r1.append(r0)     // Catch:{ RuntimeException -> 0x0170, Exception -> 0x0141 }
            r1.append(r9)     // Catch:{ RuntimeException -> 0x0170, Exception -> 0x0141 }
            java.lang.String r8 = " HTTP/1.0\r\n"
            r1.append(r8)     // Catch:{ RuntimeException -> 0x0170, Exception -> 0x0141 }
            java.lang.String r8 = r1.toString()     // Catch:{ RuntimeException -> 0x0170, Exception -> 0x0141 }
            byte[] r8 = atakplugin.UASTool.aji.m1820c((java.lang.String) r8)     // Catch:{ RuntimeException -> 0x0170, Exception -> 0x0141 }
            r7.write(r8)     // Catch:{ RuntimeException -> 0x0170, Exception -> 0x0141 }
            java.lang.String r7 = r6.f1395g     // Catch:{ RuntimeException -> 0x0170, Exception -> 0x0141 }
            java.lang.String r8 = "\r\n"
            r9 = 0
            if (r7 == 0) goto L_0x00aa
            java.lang.String r7 = r6.f1396h     // Catch:{ RuntimeException -> 0x0170, Exception -> 0x0141 }
            if (r7 == 0) goto L_0x00aa
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ RuntimeException -> 0x0170, Exception -> 0x0141 }
            r7.<init>()     // Catch:{ RuntimeException -> 0x0170, Exception -> 0x0141 }
            java.lang.String r1 = r6.f1395g     // Catch:{ RuntimeException -> 0x0170, Exception -> 0x0141 }
            r7.append(r1)     // Catch:{ RuntimeException -> 0x0170, Exception -> 0x0141 }
            r7.append(r0)     // Catch:{ RuntimeException -> 0x0170, Exception -> 0x0141 }
            java.lang.String r0 = r6.f1396h     // Catch:{ RuntimeException -> 0x0170, Exception -> 0x0141 }
            r7.append(r0)     // Catch:{ RuntimeException -> 0x0170, Exception -> 0x0141 }
            java.lang.String r7 = r7.toString()     // Catch:{ RuntimeException -> 0x0170, Exception -> 0x0141 }
            byte[] r7 = atakplugin.UASTool.aji.m1820c((java.lang.String) r7)     // Catch:{ RuntimeException -> 0x0170, Exception -> 0x0141 }
            int r0 = r7.length     // Catch:{ RuntimeException -> 0x0170, Exception -> 0x0141 }
            byte[] r7 = atakplugin.UASTool.aji.m1817b(r7, r9, r0)     // Catch:{ RuntimeException -> 0x0170, Exception -> 0x0141 }
            java.io.OutputStream r0 = r6.f1393e     // Catch:{ RuntimeException -> 0x0170, Exception -> 0x0141 }
            java.lang.String r1 = "Proxy-Authorization: Basic "
            byte[] r1 = atakplugin.UASTool.aji.m1820c((java.lang.String) r1)     // Catch:{ RuntimeException -> 0x0170, Exception -> 0x0141 }
            r0.write(r1)     // Catch:{ RuntimeException -> 0x0170, Exception -> 0x0141 }
            java.io.OutputStream r0 = r6.f1393e     // Catch:{ RuntimeException -> 0x0170, Exception -> 0x0141 }
            r0.write(r7)     // Catch:{ RuntimeException -> 0x0170, Exception -> 0x0141 }
            java.io.OutputStream r7 = r6.f1393e     // Catch:{ RuntimeException -> 0x0170, Exception -> 0x0141 }
            byte[] r0 = atakplugin.UASTool.aji.m1820c((java.lang.String) r8)     // Catch:{ RuntimeException -> 0x0170, Exception -> 0x0141 }
            r7.write(r0)     // Catch:{ RuntimeException -> 0x0170, Exception -> 0x0141 }
        L_0x00aa:
            java.io.OutputStream r7 = r6.f1393e     // Catch:{ RuntimeException -> 0x0170, Exception -> 0x0141 }
            byte[] r8 = atakplugin.UASTool.aji.m1820c((java.lang.String) r8)     // Catch:{ RuntimeException -> 0x0170, Exception -> 0x0141 }
            r7.write(r8)     // Catch:{ RuntimeException -> 0x0170, Exception -> 0x0141 }
            java.io.OutputStream r7 = r6.f1393e     // Catch:{ RuntimeException -> 0x0170, Exception -> 0x0141 }
            r7.flush()     // Catch:{ RuntimeException -> 0x0170, Exception -> 0x0141 }
            java.lang.StringBuffer r7 = new java.lang.StringBuffer     // Catch:{ RuntimeException -> 0x0170, Exception -> 0x0141 }
            r7.<init>()     // Catch:{ RuntimeException -> 0x0170, Exception -> 0x0141 }
            r8 = 0
        L_0x00be:
            r0 = 10
            r1 = 13
            if (r8 < 0) goto L_0x00da
            java.io.InputStream r8 = r6.f1392d     // Catch:{ RuntimeException -> 0x0170, Exception -> 0x0141 }
            int r8 = r8.read()     // Catch:{ RuntimeException -> 0x0170, Exception -> 0x0141 }
            if (r8 == r1) goto L_0x00d1
            char r0 = (char) r8     // Catch:{ RuntimeException -> 0x0170, Exception -> 0x0141 }
            r7.append(r0)     // Catch:{ RuntimeException -> 0x0170, Exception -> 0x0141 }
            goto L_0x00be
        L_0x00d1:
            java.io.InputStream r8 = r6.f1392d     // Catch:{ RuntimeException -> 0x0170, Exception -> 0x0141 }
            int r8 = r8.read()     // Catch:{ RuntimeException -> 0x0170, Exception -> 0x0141 }
            if (r8 == r0) goto L_0x00da
            goto L_0x00be
        L_0x00da:
            if (r8 < 0) goto L_0x013b
            java.lang.String r7 = r7.toString()     // Catch:{ RuntimeException -> 0x0170, Exception -> 0x0141 }
            java.lang.String r2 = "Unknow reason"
            r3 = -1
            r4 = 32
            int r8 = r7.indexOf(r4)     // Catch:{ Exception -> 0x00fd, RuntimeException -> 0x0170 }
            int r5 = r8 + 1
            int r4 = r7.indexOf(r4, r5)     // Catch:{ Exception -> 0x00fd, RuntimeException -> 0x0170 }
            java.lang.String r5 = r7.substring(r5, r4)     // Catch:{ Exception -> 0x00fd, RuntimeException -> 0x0170 }
            int r3 = java.lang.Integer.parseInt(r5)     // Catch:{ Exception -> 0x00fd, RuntimeException -> 0x0170 }
            int r4 = r4 + r10
            java.lang.String r2 = r7.substring(r4)     // Catch:{ Exception -> 0x00fd, RuntimeException -> 0x0170 }
            goto L_0x00fe
        L_0x00fd:
        L_0x00fe:
            r7 = 200(0xc8, float:2.8E-43)
            if (r3 != r7) goto L_0x0124
        L_0x0102:
            r7 = 0
        L_0x0103:
            if (r8 < 0) goto L_0x0119
            java.io.InputStream r8 = r6.f1392d     // Catch:{ RuntimeException -> 0x0170, Exception -> 0x0141 }
            int r8 = r8.read()     // Catch:{ RuntimeException -> 0x0170, Exception -> 0x0141 }
            if (r8 == r1) goto L_0x0110
            int r7 = r7 + 1
            goto L_0x0103
        L_0x0110:
            java.io.InputStream r8 = r6.f1392d     // Catch:{ RuntimeException -> 0x0170, Exception -> 0x0141 }
            int r8 = r8.read()     // Catch:{ RuntimeException -> 0x0170, Exception -> 0x0141 }
            if (r8 == r0) goto L_0x0119
            goto L_0x0103
        L_0x0119:
            if (r8 < 0) goto L_0x011e
            if (r7 != 0) goto L_0x0102
            return
        L_0x011e:
            java.io.IOException r7 = new java.io.IOException     // Catch:{ RuntimeException -> 0x0170, Exception -> 0x0141 }
            r7.<init>()     // Catch:{ RuntimeException -> 0x0170, Exception -> 0x0141 }
            throw r7     // Catch:{ RuntimeException -> 0x0170, Exception -> 0x0141 }
        L_0x0124:
            java.io.IOException r7 = new java.io.IOException     // Catch:{ RuntimeException -> 0x0170, Exception -> 0x0141 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ RuntimeException -> 0x0170, Exception -> 0x0141 }
            r8.<init>()     // Catch:{ RuntimeException -> 0x0170, Exception -> 0x0141 }
            java.lang.String r9 = "proxy error: "
            r8.append(r9)     // Catch:{ RuntimeException -> 0x0170, Exception -> 0x0141 }
            r8.append(r2)     // Catch:{ RuntimeException -> 0x0170, Exception -> 0x0141 }
            java.lang.String r8 = r8.toString()     // Catch:{ RuntimeException -> 0x0170, Exception -> 0x0141 }
            r7.<init>(r8)     // Catch:{ RuntimeException -> 0x0170, Exception -> 0x0141 }
            throw r7     // Catch:{ RuntimeException -> 0x0170, Exception -> 0x0141 }
        L_0x013b:
            java.io.IOException r7 = new java.io.IOException     // Catch:{ RuntimeException -> 0x0170, Exception -> 0x0141 }
            r7.<init>()     // Catch:{ RuntimeException -> 0x0170, Exception -> 0x0141 }
            throw r7     // Catch:{ RuntimeException -> 0x0170, Exception -> 0x0141 }
        L_0x0141:
            r7 = move-exception
            java.net.Socket r8 = r6.f1394f     // Catch:{ Exception -> 0x014a }
            if (r8 == 0) goto L_0x014b
            r8.close()     // Catch:{ Exception -> 0x014a }
            goto L_0x014b
        L_0x014a:
        L_0x014b:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "ProxyHTTP: "
            r8.append(r9)
            java.lang.String r9 = r7.toString()
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            boolean r9 = r7 instanceof java.lang.Throwable
            if (r9 == 0) goto L_0x016a
            atakplugin.UASTool.ahj r9 = new atakplugin.UASTool.ahj
            r9.<init>(r8, r7)
            throw r9
        L_0x016a:
            atakplugin.UASTool.ahj r7 = new atakplugin.UASTool.ahj
            r7.<init>(r8)
            throw r7
        L_0x0170:
            r7 = move-exception
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.aib.mo1005a(atakplugin.UASTool.aiz, java.lang.String, int, int):void");
    }

    /* renamed from: a */
    public InputStream mo1004a() {
        return this.f1392d;
    }

    /* renamed from: b */
    public OutputStream mo1006b() {
        return this.f1393e;
    }

    /* renamed from: c */
    public Socket mo1007c() {
        return this.f1394f;
    }

    /* renamed from: d */
    public void mo1008d() {
        try {
            InputStream inputStream = this.f1392d;
            if (inputStream != null) {
                inputStream.close();
            }
            OutputStream outputStream = this.f1393e;
            if (outputStream != null) {
                outputStream.close();
            }
            Socket socket = this.f1394f;
            if (socket != null) {
                socket.close();
            }
        } catch (Exception unused) {
        }
        this.f1392d = null;
        this.f1393e = null;
        this.f1394f = null;
    }

    /* renamed from: e */
    public static int m1581e() {
        return f1389a;
    }
}
