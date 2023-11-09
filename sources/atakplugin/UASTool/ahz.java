package atakplugin.UASTool;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Vector;

class ahz implements Runnable {

    /* renamed from: i */
    private static Vector f1378i = new Vector();

    /* renamed from: j */
    private static InetAddress f1379j;

    /* renamed from: a */
    air f1380a;

    /* renamed from: b */
    int f1381b;

    /* renamed from: c */
    int f1382c;

    /* renamed from: d */
    String f1383d;

    /* renamed from: e */
    InetAddress f1384e;

    /* renamed from: f */
    Runnable f1385f;

    /* renamed from: g */
    ServerSocket f1386g;

    /* renamed from: h */
    int f1387h = 0;

    static {
        f1379j = null;
        try {
            f1379j = InetAddress.getByName("0.0.0.0");
        } catch (UnknownHostException unused) {
        }
    }

    /* renamed from: a */
    static String[] m1570a(air air) {
        int i;
        Vector vector = new Vector();
        synchronized (f1378i) {
            for (int i2 = 0; i2 < f1378i.size(); i2++) {
                ahz ahz = (ahz) f1378i.elementAt(i2);
                if (ahz.f1380a == air) {
                    vector.addElement(ahz.f1381b + ":" + ahz.f1383d + ":" + ahz.f1382c);
                }
            }
        }
        String[] strArr = new String[vector.size()];
        for (i = 0; i < vector.size(); i++) {
            strArr[i] = (String) vector.elementAt(i);
        }
        return strArr;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0037, code lost:
        return r2;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static atakplugin.UASTool.ahz m1567a(atakplugin.UASTool.air r5, java.lang.String r6, int r7) {
        /*
            java.net.InetAddress r6 = java.net.InetAddress.getByName(r6)     // Catch:{ UnknownHostException -> 0x0041 }
            java.util.Vector r0 = f1378i
            monitor-enter(r0)
            r1 = 0
        L_0x0008:
            java.util.Vector r2 = f1378i     // Catch:{ all -> 0x003e }
            int r2 = r2.size()     // Catch:{ all -> 0x003e }
            if (r1 >= r2) goto L_0x003b
            java.util.Vector r2 = f1378i     // Catch:{ all -> 0x003e }
            java.lang.Object r2 = r2.elementAt(r1)     // Catch:{ all -> 0x003e }
            atakplugin.UASTool.ahz r2 = (atakplugin.UASTool.ahz) r2     // Catch:{ all -> 0x003e }
            atakplugin.UASTool.ahz r2 = (atakplugin.UASTool.ahz) r2     // Catch:{ all -> 0x003e }
            atakplugin.UASTool.air r3 = r2.f1380a     // Catch:{ all -> 0x003e }
            if (r3 != r5) goto L_0x0038
            int r3 = r2.f1381b     // Catch:{ all -> 0x003e }
            if (r3 != r7) goto L_0x0038
            java.net.InetAddress r3 = f1379j     // Catch:{ all -> 0x003e }
            if (r3 == 0) goto L_0x002e
            java.net.InetAddress r4 = r2.f1384e     // Catch:{ all -> 0x003e }
            boolean r3 = r4.equals(r3)     // Catch:{ all -> 0x003e }
            if (r3 != 0) goto L_0x0036
        L_0x002e:
            java.net.InetAddress r3 = r2.f1384e     // Catch:{ all -> 0x003e }
            boolean r3 = r3.equals(r6)     // Catch:{ all -> 0x003e }
            if (r3 == 0) goto L_0x0038
        L_0x0036:
            monitor-exit(r0)     // Catch:{ all -> 0x003e }
            return r2
        L_0x0038:
            int r1 = r1 + 1
            goto L_0x0008
        L_0x003b:
            r5 = 0
            monitor-exit(r0)     // Catch:{ all -> 0x003e }
            return r5
        L_0x003e:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x003e }
            throw r5
        L_0x0041:
            r5 = move-exception
            atakplugin.UASTool.ahj r7 = new atakplugin.UASTool.ahj
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "PortForwardingL: invalid address "
            r0.append(r1)
            r0.append(r6)
            java.lang.String r6 = " specified."
            r0.append(r6)
            java.lang.String r6 = r0.toString()
            r7.<init>(r6, r5)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.ahz.m1567a(atakplugin.UASTool.air, java.lang.String, int):atakplugin.UASTool.ahz");
    }

    /* renamed from: a */
    private static String m1569a(String str) {
        if (str == null) {
            return str;
        }
        if (str.length() == 0 || str.equals("*")) {
            return "0.0.0.0";
        }
        return str.equals("localhost") ? "127.0.0.1" : str;
    }

    /* renamed from: a */
    static ahz m1568a(air air, String str, int i, String str2, int i2, aiq aiq) {
        String a = m1569a(str);
        if (m1567a(air, a, i) == null) {
            ahz ahz = new ahz(air, a, i, str2, i2, aiq);
            f1378i.addElement(ahz);
            return ahz;
        }
        throw new ahj("PortForwardingL: local port " + a + ":" + i + " is already registered.");
    }

    /* renamed from: b */
    static void m1572b(air air, String str, int i) {
        String a = m1569a(str);
        ahz a2 = m1567a(air, a, i);
        if (a2 != null) {
            a2.mo1000a();
            f1378i.removeElement(a2);
            return;
        }
        throw new ahj("PortForwardingL: local port " + a + ":" + i + " is not registered.");
    }

    /* renamed from: b */
    static void m1571b(air air) {
        synchronized (f1378i) {
            ahz[] ahzArr = new ahz[f1378i.size()];
            int i = 0;
            for (int i2 = 0; i2 < f1378i.size(); i2++) {
                ahz ahz = (ahz) f1378i.elementAt(i2);
                if (ahz.f1380a == air) {
                    ahz.mo1000a();
                    ahzArr[i] = ahz;
                    i++;
                }
            }
            for (int i3 = 0; i3 < i; i3++) {
                f1378i.removeElement(ahzArr[i3]);
            }
        }
    }

    ahz(air air, String str, int i, String str2, int i2, aiq aiq) {
        int localPort;
        this.f1380a = air;
        this.f1381b = i;
        this.f1383d = str2;
        this.f1382c = i2;
        try {
            InetAddress byName = InetAddress.getByName(str);
            this.f1384e = byName;
            ServerSocket serverSocket = aiq == null ? new ServerSocket(i, 0, this.f1384e) : aiq.mo1026a(i, 0, byName);
            this.f1386g = serverSocket;
            if (i == 0 && (localPort = serverSocket.getLocalPort()) != -1) {
                this.f1381b = localPort;
            }
        } catch (Exception e) {
            String str3 = "PortForwardingL: local port " + str + ":" + i + " cannot be bound.";
            if (e instanceof Throwable) {
                throw new ahj(str3, e);
            }
            throw new ahj(str3);
        }
    }

    public void run() {
        this.f1385f = this;
        while (this.f1385f != null) {
            try {
                Socket accept = this.f1386g.accept();
                accept.setTcpNoDelay(true);
                InputStream inputStream = accept.getInputStream();
                OutputStream outputStream = accept.getOutputStream();
                agb agb = new agb();
                agb.mo659b();
                agb.mo652a(inputStream);
                agb.mo654a(outputStream);
                this.f1380a.mo1038a((afy) agb);
                agb.mo701c(this.f1383d);
                agb.mo703i(this.f1382c);
                agb.mo702d(accept.getInetAddress().getHostAddress());
                agb.mo704j(accept.getPort());
                agb.mo660b(this.f1387h);
                int i = agb.f917x;
            } catch (Exception unused) {
            }
        }
        mo1000a();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo1000a() {
        this.f1385f = null;
        try {
            ServerSocket serverSocket = this.f1386g;
            if (serverSocket != null) {
                serverSocket.close();
            }
            this.f1386g = null;
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo1001a(int i) {
        this.f1387h = i;
    }
}
