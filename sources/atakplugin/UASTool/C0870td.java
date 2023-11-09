package atakplugin.UASTool;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbManager;
import android.util.Log;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* renamed from: atakplugin.UASTool.td */
public class C0870td {

    /* renamed from: A */
    public static final byte f6560A = 4;

    /* renamed from: B */
    public static final byte f6561B = 8;

    /* renamed from: C */
    public static final byte f6562C = 1;

    /* renamed from: D */
    public static final byte f6563D = 2;

    /* renamed from: E */
    public static final int f6564E = 0;

    /* renamed from: F */
    public static final int f6565F = 1;

    /* renamed from: G */
    public static final int f6566G = 3;

    /* renamed from: H */
    public static final int f6567H = 4;

    /* renamed from: I */
    public static final int f6568I = 5;

    /* renamed from: J */
    public static final int f6569J = 5;

    /* renamed from: K */
    public static final int f6570K = 6;

    /* renamed from: L */
    public static final int f6571L = 7;

    /* renamed from: M */
    public static final int f6572M = 8;

    /* renamed from: N */
    public static final int f6573N = 9;

    /* renamed from: O */
    public static final int f6574O = 10;

    /* renamed from: P */
    public static final int f6575P = 11;

    /* renamed from: Q */
    public static final int f6576Q = 12;

    /* renamed from: R */
    public static final byte f6577R = 0;

    /* renamed from: S */
    public static final byte f6578S = 1;

    /* renamed from: T */
    public static final byte f6579T = 2;

    /* renamed from: U */
    public static final byte f6580U = 4;

    /* renamed from: V */
    public static final byte f6581V = 8;

    /* renamed from: W */
    public static final byte f6582W = 16;

    /* renamed from: X */
    public static final byte f6583X = 32;

    /* renamed from: Y */
    public static final byte f6584Y = 64;

    /* renamed from: Z */
    public static final int f6585Z = 0;

    /* renamed from: a */
    protected static final String f6586a = "com.ftdi.j2xx";

    /* renamed from: aa */
    public static final int f6587aa = 16384;

    /* renamed from: ab */
    private static C0870td f6588ab = null;

    /* renamed from: ac */
    private static final String f6589ac = "D2xx::";

    /* renamed from: ad */
    private static Context f6590ad = null;

    /* renamed from: ae */
    private static PendingIntent f6591ae = null;

    /* renamed from: af */
    private static IntentFilter f6592af = null;

    /* renamed from: ag */
    private static List<C0908uc> f6593ag = new ArrayList(Arrays.asList(new C0908uc[]{new C0908uc(1027, 24597), new C0908uc(1027, 24596), new C0908uc(1027, 24593), new C0908uc(1027, 24592), new C0908uc(1027, 24577), new C0908uc(1027, 24582), new C0908uc(1027, 24604), new C0908uc(1027, 64193), new C0908uc(1027, 64194), new C0908uc(1027, 64195), new C0908uc(1027, 64196), new C0908uc(1027, 64197), new C0908uc(1027, 64198), new C0908uc(1027, 24594), new C0908uc(2220, 4133), new C0908uc(5590, 1), new C0908uc(1027, 24599)}));

    /* renamed from: ai */
    private static UsbManager f6594ai = null;

    /* renamed from: ak */
    private static BroadcastReceiver f6595ak = new C0875tf();

    /* renamed from: b */
    public static final byte f6596b = 7;

    /* renamed from: c */
    public static final byte f6597c = 8;

    /* renamed from: d */
    public static final byte f6598d = 0;

    /* renamed from: e */
    public static final byte f6599e = 2;

    /* renamed from: f */
    public static final byte f6600f = 0;

    /* renamed from: g */
    public static final byte f6601g = 1;

    /* renamed from: h */
    public static final byte f6602h = 2;

    /* renamed from: i */
    public static final byte f6603i = 3;

    /* renamed from: j */
    public static final byte f6604j = 4;

    /* renamed from: k */
    public static final short f6605k = 0;

    /* renamed from: l */
    public static final short f6606l = 256;

    /* renamed from: m */
    public static final short f6607m = 512;

    /* renamed from: n */
    public static final short f6608n = 1024;

    /* renamed from: o */
    public static final byte f6609o = 1;

    /* renamed from: p */
    public static final byte f6610p = 2;

    /* renamed from: q */
    public static final byte f6611q = 16;

    /* renamed from: r */
    public static final byte f6612r = 32;

    /* renamed from: s */
    public static final byte f6613s = 64;

    /* renamed from: t */
    public static final byte f6614t = Byte.MIN_VALUE;

    /* renamed from: u */
    public static final byte f6615u = 2;

    /* renamed from: v */
    public static final byte f6616v = 4;

    /* renamed from: w */
    public static final byte f6617w = 8;

    /* renamed from: x */
    public static final byte f6618x = 16;

    /* renamed from: y */
    public static final byte f6619y = 1;

    /* renamed from: z */
    public static final byte f6620z = 2;
    /* access modifiers changed from: private */

    /* renamed from: ah */
    public ArrayList<C0879tj> f6621ah;

    /* renamed from: aj */
    private BroadcastReceiver f6622aj = new C0874te(this);

    /* renamed from: atakplugin.UASTool.td$c */
    public static class C0873c {

        /* renamed from: a */
        public int f6628a;

        /* renamed from: b */
        public short f6629b;

        /* renamed from: c */
        public int f6630c;

        /* renamed from: d */
        public byte f6631d;

        /* renamed from: e */
        public int f6632e;

        /* renamed from: f */
        public int f6633f;

        /* renamed from: g */
        public String f6634g;

        /* renamed from: h */
        public String f6635h;

        /* renamed from: i */
        public int f6636i;

        /* renamed from: j */
        public int f6637j;

        /* renamed from: k */
        public short f6638k;

        /* renamed from: l */
        public short f6639l;
    }

    /* renamed from: b */
    public static int m13893b() {
        return 537919488;
    }

    /* renamed from: atakplugin.UASTool.td$b */
    public static class C0872b {

        /* renamed from: a */
        private int f6624a = 16384;

        /* renamed from: b */
        private int f6625b = 16384;

        /* renamed from: c */
        private int f6626c = 16;

        /* renamed from: d */
        private int f6627d = 5000;

        /* renamed from: a */
        public boolean mo5820a(int i) {
            if (i < 64 || i > 262144) {
                Log.e(C0870td.f6589ac, "***bufferSize Out of correct range***");
                return false;
            }
            this.f6624a = i;
            return true;
        }

        /* renamed from: a */
        public int mo5819a() {
            return this.f6624a;
        }

        /* renamed from: b */
        public boolean mo5822b(int i) {
            if (i < 64 || i > 262144) {
                Log.e(C0870td.f6589ac, "***maxTransferSize Out of correct range***");
                return false;
            }
            this.f6625b = i;
            return true;
        }

        /* renamed from: b */
        public int mo5821b() {
            return this.f6625b;
        }

        /* renamed from: c */
        public boolean mo5824c(int i) {
            if (i < 2 || i > 16) {
                Log.e(C0870td.f6589ac, "***nrBuffers Out of correct range***");
                return false;
            }
            this.f6626c = i;
            return true;
        }

        /* renamed from: c */
        public int mo5823c() {
            return this.f6626c;
        }

        /* renamed from: d */
        public boolean mo5826d(int i) {
            this.f6627d = i;
            return true;
        }

        /* renamed from: d */
        public int mo5825d() {
            return this.f6627d;
        }
    }

    /* renamed from: atakplugin.UASTool.td$a */
    public static class C0871a extends IOException {

        /* renamed from: a */
        private static final long f6623a = 1;

        public C0871a() {
        }

        public C0871a(String str) {
            super(str);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public C0879tj m13894c(UsbDevice usbDevice) {
        C0879tj tjVar;
        synchronized (this.f6621ah) {
            int size = this.f6621ah.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    tjVar = null;
                    break;
                }
                C0879tj tjVar2 = this.f6621ah.get(i);
                if (tjVar2.mo5866h().equals(usbDevice)) {
                    tjVar = tjVar2;
                    break;
                }
                i++;
            }
        }
        return tjVar;
    }

    /* renamed from: a */
    public boolean mo5811a(UsbDevice usbDevice) {
        if (f6590ad == null) {
            return false;
        }
        C0908uc ucVar = new C0908uc(usbDevice.getVendorId(), usbDevice.getProductId());
        boolean contains = f6593ag.contains(ucVar);
        Log.v(f6589ac, ucVar.toString());
        return contains;
    }

    /* renamed from: c */
    private static synchronized boolean m13896c(Context context) {
        synchronized (C0870td.class) {
            if (context == null) {
                return false;
            }
            if (f6590ad != context) {
                f6590ad = context;
                f6591ae = PendingIntent.getBroadcast(context.getApplicationContext(), 0, new Intent(f6586a), 134217728);
                f6592af = new IntentFilter(f6586a);
                f6590ad.getApplicationContext().registerReceiver(f6595ak, f6592af);
            }
            return true;
        }
    }

    /* renamed from: d */
    private boolean m13898d(UsbDevice usbDevice) {
        if (!f6594ai.hasPermission(usbDevice)) {
            f6594ai.requestPermission(usbDevice, f6591ae);
        }
        return f6594ai.hasPermission(usbDevice);
    }

    private C0870td(Context context) {
        Log.v(f6589ac, "Start constructor");
        if (context != null) {
            m13896c(context);
            if (m13895c()) {
                this.f6621ah = new ArrayList<>();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.hardware.usb.action.USB_DEVICE_ATTACHED");
                intentFilter.addAction("android.hardware.usb.action.USB_DEVICE_DETACHED");
                context.getApplicationContext().registerReceiver(this.f6622aj, intentFilter);
                Log.v(f6589ac, "End constructor");
                return;
            }
            throw new C0871a("D2xx init failed: Can not find UsbManager!");
        }
        throw new C0871a("D2xx init failed: Can not find parentContext!");
    }

    /* renamed from: a */
    public static synchronized C0870td m13889a(Context context) {
        C0870td tdVar;
        synchronized (C0870td.class) {
            if (f6588ab == null) {
                f6588ab = new C0870td(context);
            }
            if (context != null) {
                m13896c(context);
            }
            tdVar = f6588ab;
        }
        return tdVar;
    }

    /* renamed from: c */
    private static boolean m13895c() {
        Context context;
        if (f6594ai == null && (context = f6590ad) != null) {
            f6594ai = (UsbManager) context.getApplicationContext().getSystemService("usb");
        }
        return f6594ai != null;
    }

    /* renamed from: a */
    public boolean mo5810a(int i, int i2) {
        if (i == 0 || i2 == 0) {
            Log.d(f6589ac, "Invalid parameter to setVIDPID");
        } else {
            C0908uc ucVar = new C0908uc(i, i2);
            if (f6593ag.contains(ucVar)) {
                Log.i(f6589ac, "Existing vid:" + i + "  pid:" + i2);
                return true;
            } else if (f6593ag.add(ucVar)) {
                return true;
            } else {
                Log.d(f6589ac, "Failed to add VID/PID combination to list.");
            }
        }
        return false;
    }

    /* renamed from: a */
    public int[][] mo5812a() {
        int size = f6593ag.size();
        int[] iArr = new int[2];
        iArr[1] = size;
        iArr[0] = 2;
        int[][] iArr2 = (int[][]) Array.newInstance(int.class, iArr);
        for (int i = 0; i < size; i++) {
            C0908uc ucVar = f6593ag.get(i);
            iArr2[0][i] = ucVar.mo5904a();
            iArr2[1][i] = ucVar.mo5906b();
        }
        return iArr2;
    }

    /* renamed from: d */
    private void m13897d() {
        synchronized (this.f6621ah) {
            int size = this.f6621ah.size();
            for (int i = 0; i < size; i++) {
                this.f6621ah.remove(i);
            }
        }
    }

    /* renamed from: b */
    public int mo5813b(Context context) {
        int size;
        ArrayList<C0879tj> arrayList = new ArrayList<>();
        if (context == null) {
            return 0;
        }
        m13896c(context);
        for (UsbDevice next : f6594ai.getDeviceList().values()) {
            if (mo5811a(next)) {
                int interfaceCount = next.getInterfaceCount();
                for (int i = 0; i < interfaceCount; i++) {
                    if (m13898d(next)) {
                        synchronized (this.f6621ah) {
                            C0879tj c = m13894c(next);
                            if (c == null) {
                                c = new C0879tj(context, f6594ai, next, next.getInterface(i));
                            } else {
                                this.f6621ah.remove(c);
                                c.mo5850a(context);
                            }
                            arrayList.add(c);
                        }
                    }
                }
                continue;
            }
        }
        synchronized (this.f6621ah) {
            m13897d();
            this.f6621ah = arrayList;
            size = arrayList.size();
        }
        return size;
    }

    /* renamed from: a */
    public synchronized int mo5802a(int i, C0873c[] cVarArr) {
        for (int i2 = 0; i2 < i; i2++) {
            cVarArr[i2] = this.f6621ah.get(i2).f6672g;
        }
        return this.f6621ah.size();
    }

    /* renamed from: a */
    public synchronized C0873c mo5803a(int i) {
        if (i <= this.f6621ah.size()) {
            if (i >= 0) {
                return this.f6621ah.get(i).f6672g;
            }
        }
        return null;
    }

    /* renamed from: a */
    private boolean m13892a(Context context, C0879tj tjVar, C0872b bVar) {
        if (tjVar == null || context == null) {
            return false;
        }
        tjVar.mo5850a(context);
        if (bVar != null) {
            tjVar.mo5842a(bVar);
        }
        if (!tjVar.mo5851a(f6594ai) || !tjVar.mo5864f()) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    public synchronized C0879tj mo5807a(Context context, UsbDevice usbDevice, C0872b bVar) {
        C0879tj tjVar;
        tjVar = null;
        if (mo5811a(usbDevice)) {
            C0879tj c = m13894c(usbDevice);
            if (m13892a(context, c, bVar)) {
                tjVar = c;
            }
        }
        return tjVar;
    }

    /* renamed from: a */
    public synchronized C0879tj mo5806a(Context context, UsbDevice usbDevice) {
        return mo5807a(context, usbDevice, (C0872b) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001e, code lost:
        return r0;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized atakplugin.UASTool.C0879tj mo5805a(android.content.Context r3, int r4, atakplugin.UASTool.C0870td.C0872b r5) {
        /*
            r2 = this;
            monitor-enter(r2)
            r0 = 0
            if (r4 >= 0) goto L_0x0006
            monitor-exit(r2)
            return r0
        L_0x0006:
            if (r3 != 0) goto L_0x000a
            monitor-exit(r2)
            return r0
        L_0x000a:
            m13896c((android.content.Context) r3)     // Catch:{ all -> 0x001f }
            java.util.ArrayList<atakplugin.UASTool.tj> r1 = r2.f6621ah     // Catch:{ all -> 0x001f }
            java.lang.Object r4 = r1.get(r4)     // Catch:{ all -> 0x001f }
            atakplugin.UASTool.tj r4 = (atakplugin.UASTool.C0879tj) r4     // Catch:{ all -> 0x001f }
            boolean r3 = r2.m13892a((android.content.Context) r3, (atakplugin.UASTool.C0879tj) r4, (atakplugin.UASTool.C0870td.C0872b) r5)     // Catch:{ all -> 0x001f }
            if (r3 != 0) goto L_0x001c
            goto L_0x001d
        L_0x001c:
            r0 = r4
        L_0x001d:
            monitor-exit(r2)
            return r0
        L_0x001f:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.C0870td.mo5805a(android.content.Context, int, atakplugin.UASTool.td$b):atakplugin.UASTool.tj");
    }

    /* renamed from: a */
    public synchronized C0879tj mo5804a(Context context, int i) {
        return mo5805a(context, i, (C0872b) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x003b, code lost:
        return r0;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized atakplugin.UASTool.C0879tj mo5809a(android.content.Context r5, java.lang.String r6, atakplugin.UASTool.C0870td.C0872b r7) {
        /*
            r4 = this;
            monitor-enter(r4)
            r0 = 0
            if (r5 != 0) goto L_0x0006
            monitor-exit(r4)
            return r0
        L_0x0006:
            m13896c((android.content.Context) r5)     // Catch:{ all -> 0x003f }
            r1 = 0
        L_0x000a:
            java.util.ArrayList<atakplugin.UASTool.tj> r2 = r4.f6621ah     // Catch:{ all -> 0x003f }
            int r2 = r2.size()     // Catch:{ all -> 0x003f }
            if (r1 < r2) goto L_0x0014
            r2 = r0
            goto L_0x0032
        L_0x0014:
            java.util.ArrayList<atakplugin.UASTool.tj> r2 = r4.f6621ah     // Catch:{ all -> 0x003f }
            java.lang.Object r2 = r2.get(r1)     // Catch:{ all -> 0x003f }
            atakplugin.UASTool.tj r2 = (atakplugin.UASTool.C0879tj) r2     // Catch:{ all -> 0x003f }
            if (r2 == 0) goto L_0x003c
            atakplugin.UASTool.td$c r3 = r2.f6672g     // Catch:{ all -> 0x003f }
            if (r3 != 0) goto L_0x002a
            java.lang.String r2 = "D2xx::"
            java.lang.String r3 = "***devInfo cannot be null***"
            android.util.Log.d(r2, r3)     // Catch:{ all -> 0x003f }
            goto L_0x003c
        L_0x002a:
            java.lang.String r3 = r3.f6634g     // Catch:{ all -> 0x003f }
            boolean r3 = r3.equals(r6)     // Catch:{ all -> 0x003f }
            if (r3 == 0) goto L_0x003c
        L_0x0032:
            boolean r5 = r4.m13892a((android.content.Context) r5, (atakplugin.UASTool.C0879tj) r2, (atakplugin.UASTool.C0870td.C0872b) r7)     // Catch:{ all -> 0x003f }
            if (r5 != 0) goto L_0x0039
            goto L_0x003a
        L_0x0039:
            r0 = r2
        L_0x003a:
            monitor-exit(r4)
            return r0
        L_0x003c:
            int r1 = r1 + 1
            goto L_0x000a
        L_0x003f:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.C0870td.mo5809a(android.content.Context, java.lang.String, atakplugin.UASTool.td$b):atakplugin.UASTool.tj");
    }

    /* renamed from: a */
    public synchronized C0879tj mo5808a(Context context, String str) {
        return mo5809a(context, str, (C0872b) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x003b, code lost:
        return r0;
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized atakplugin.UASTool.C0879tj mo5818b(android.content.Context r5, java.lang.String r6, atakplugin.UASTool.C0870td.C0872b r7) {
        /*
            r4 = this;
            monitor-enter(r4)
            r0 = 0
            if (r5 != 0) goto L_0x0006
            monitor-exit(r4)
            return r0
        L_0x0006:
            m13896c((android.content.Context) r5)     // Catch:{ all -> 0x003f }
            r1 = 0
        L_0x000a:
            java.util.ArrayList<atakplugin.UASTool.tj> r2 = r4.f6621ah     // Catch:{ all -> 0x003f }
            int r2 = r2.size()     // Catch:{ all -> 0x003f }
            if (r1 < r2) goto L_0x0014
            r2 = r0
            goto L_0x0032
        L_0x0014:
            java.util.ArrayList<atakplugin.UASTool.tj> r2 = r4.f6621ah     // Catch:{ all -> 0x003f }
            java.lang.Object r2 = r2.get(r1)     // Catch:{ all -> 0x003f }
            atakplugin.UASTool.tj r2 = (atakplugin.UASTool.C0879tj) r2     // Catch:{ all -> 0x003f }
            if (r2 == 0) goto L_0x003c
            atakplugin.UASTool.td$c r3 = r2.f6672g     // Catch:{ all -> 0x003f }
            if (r3 != 0) goto L_0x002a
            java.lang.String r2 = "D2xx::"
            java.lang.String r3 = "***devInfo cannot be null***"
            android.util.Log.d(r2, r3)     // Catch:{ all -> 0x003f }
            goto L_0x003c
        L_0x002a:
            java.lang.String r3 = r3.f6635h     // Catch:{ all -> 0x003f }
            boolean r3 = r3.equals(r6)     // Catch:{ all -> 0x003f }
            if (r3 == 0) goto L_0x003c
        L_0x0032:
            boolean r5 = r4.m13892a((android.content.Context) r5, (atakplugin.UASTool.C0879tj) r2, (atakplugin.UASTool.C0870td.C0872b) r7)     // Catch:{ all -> 0x003f }
            if (r5 != 0) goto L_0x0039
            goto L_0x003a
        L_0x0039:
            r0 = r2
        L_0x003a:
            monitor-exit(r4)
            return r0
        L_0x003c:
            int r1 = r1 + 1
            goto L_0x000a
        L_0x003f:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.C0870td.mo5818b(android.content.Context, java.lang.String, atakplugin.UASTool.td$b):atakplugin.UASTool.tj");
    }

    /* renamed from: b */
    public synchronized C0879tj mo5817b(Context context, String str) {
        return mo5818b(context, str, (C0872b) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0037, code lost:
        return r0;
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized atakplugin.UASTool.C0879tj mo5816b(android.content.Context r5, int r6, atakplugin.UASTool.C0870td.C0872b r7) {
        /*
            r4 = this;
            monitor-enter(r4)
            r0 = 0
            if (r5 != 0) goto L_0x0006
            monitor-exit(r4)
            return r0
        L_0x0006:
            m13896c((android.content.Context) r5)     // Catch:{ all -> 0x003b }
            r1 = 0
        L_0x000a:
            java.util.ArrayList<atakplugin.UASTool.tj> r2 = r4.f6621ah     // Catch:{ all -> 0x003b }
            int r2 = r2.size()     // Catch:{ all -> 0x003b }
            if (r1 < r2) goto L_0x0014
            r2 = r0
            goto L_0x002e
        L_0x0014:
            java.util.ArrayList<atakplugin.UASTool.tj> r2 = r4.f6621ah     // Catch:{ all -> 0x003b }
            java.lang.Object r2 = r2.get(r1)     // Catch:{ all -> 0x003b }
            atakplugin.UASTool.tj r2 = (atakplugin.UASTool.C0879tj) r2     // Catch:{ all -> 0x003b }
            if (r2 == 0) goto L_0x0038
            atakplugin.UASTool.td$c r3 = r2.f6672g     // Catch:{ all -> 0x003b }
            if (r3 != 0) goto L_0x002a
            java.lang.String r2 = "D2xx::"
            java.lang.String r3 = "***devInfo cannot be null***"
            android.util.Log.d(r2, r3)     // Catch:{ all -> 0x003b }
            goto L_0x0038
        L_0x002a:
            int r3 = r3.f6633f     // Catch:{ all -> 0x003b }
            if (r3 != r6) goto L_0x0038
        L_0x002e:
            boolean r5 = r4.m13892a((android.content.Context) r5, (atakplugin.UASTool.C0879tj) r2, (atakplugin.UASTool.C0870td.C0872b) r7)     // Catch:{ all -> 0x003b }
            if (r5 != 0) goto L_0x0035
            goto L_0x0036
        L_0x0035:
            r0 = r2
        L_0x0036:
            monitor-exit(r4)
            return r0
        L_0x0038:
            int r1 = r1 + 1
            goto L_0x000a
        L_0x003b:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.C0870td.mo5816b(android.content.Context, int, atakplugin.UASTool.td$b):atakplugin.UASTool.tj");
    }

    /* renamed from: b */
    public synchronized C0879tj mo5815b(Context context, int i) {
        return mo5816b(context, i, (C0872b) null);
    }

    /* renamed from: b */
    public int mo5814b(UsbDevice usbDevice) {
        if (!mo5811a(usbDevice)) {
            return 0;
        }
        int interfaceCount = usbDevice.getInterfaceCount();
        int i = 0;
        for (int i2 = 0; i2 < interfaceCount; i2++) {
            if (m13898d(usbDevice)) {
                synchronized (this.f6621ah) {
                    C0879tj c = m13894c(usbDevice);
                    if (c == null) {
                        c = new C0879tj(f6590ad, f6594ai, usbDevice, usbDevice.getInterface(i2));
                    } else {
                        c.mo5850a(f6590ad);
                    }
                    this.f6621ah.add(c);
                    i++;
                }
            }
        }
        return i;
    }
}
