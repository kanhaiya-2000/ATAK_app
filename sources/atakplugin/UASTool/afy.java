package atakplugin.UASTool;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.Vector;

public abstract class afy implements Runnable {

    /* renamed from: B */
    private static Vector f891B = new Vector();

    /* renamed from: a */
    static final int f892a = 91;

    /* renamed from: b */
    static final int f893b = 92;

    /* renamed from: c */
    static final int f894c = 93;

    /* renamed from: d */
    static final int f895d = 1;

    /* renamed from: e */
    static final int f896e = 2;

    /* renamed from: f */
    static final int f897f = 3;

    /* renamed from: g */
    static final int f898g = 4;

    /* renamed from: h */
    static int f899h;

    /* renamed from: A */
    int f900A = 0;

    /* renamed from: C */
    private air f901C;

    /* renamed from: i */
    int f902i;

    /* renamed from: j */
    volatile int f903j = -1;

    /* renamed from: k */
    protected byte[] f904k = aji.m1820c("foo");

    /* renamed from: l */
    volatile int f905l = 1048576;

    /* renamed from: m */
    volatile int f906m = this.f905l;

    /* renamed from: n */
    volatile int f907n = 16384;

    /* renamed from: o */
    volatile long f908o = 0;

    /* renamed from: p */
    volatile int f909p = 0;

    /* renamed from: q */
    ahc f910q = null;

    /* renamed from: r */
    Thread f911r = null;

    /* renamed from: s */
    volatile boolean f912s = false;

    /* renamed from: t */
    volatile boolean f913t = false;

    /* renamed from: u */
    volatile boolean f914u = false;

    /* renamed from: v */
    volatile boolean f915v = false;

    /* renamed from: w */
    volatile boolean f916w = false;

    /* renamed from: x */
    volatile int f917x = -1;

    /* renamed from: y */
    volatile int f918y = 0;

    /* renamed from: z */
    volatile int f919z = 0;

    /* renamed from: a */
    public void mo656a(boolean z) {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo659b() {
    }

    /* renamed from: d */
    public void mo669d() {
    }

    public void run() {
    }

    /* renamed from: a */
    static afy m930a(String str) {
        if (str.equals("session")) {
            return new age();
        }
        if (str.equals("shell")) {
            return new agj();
        }
        if (str.equals("exec")) {
            return new agc();
        }
        if (str.equals("x11")) {
            return new agl();
        }
        if (str.equals("auth-agent@openssh.com")) {
            return new aga();
        }
        if (str.equals("direct-tcpip")) {
            return new agb();
        }
        if (str.equals("forwarded-tcpip")) {
            return new agd();
        }
        if (str.equals("sftp")) {
            return new agf();
        }
        if (str.equals("subsystem")) {
            return new agk();
        }
        return null;
    }

    /* renamed from: a */
    static afy m929a(int i, air air) {
        synchronized (f891B) {
            for (int i2 = 0; i2 < f891B.size(); i2++) {
                afy afy = (afy) f891B.elementAt(i2);
                if (afy.f902i == i && afy.f901C == air) {
                    return afy;
                }
            }
            return null;
        }
    }

    /* renamed from: a */
    static void m931a(afy afy) {
        synchronized (f891B) {
            f891B.removeElement(afy);
        }
    }

    afy() {
        synchronized (f891B) {
            int i = f899h;
            f899h = i + 1;
            this.f902i = i;
            f891B.addElement(this);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized void mo649a(int i) {
        this.f903j = i;
        if (this.f900A > 0) {
            notifyAll();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo648a() {
        return this.f903j;
    }

    /* renamed from: c */
    public void mo667c() {
        mo660b(0);
    }

    /* renamed from: b */
    public void mo660b(int i) {
        this.f919z = i;
        try {
            mo691t();
            mo669d();
        } catch (Exception e) {
            this.f915v = false;
            mo683m();
            if (e instanceof ahj) {
                throw ((ahj) e);
            }
            throw new ahj(e.toString(), e);
        }
    }

    /* renamed from: e */
    public boolean mo672e() {
        return this.f913t;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo651a(afx afx) {
        mo649a(afx.mo633d());
        mo650a(afx.mo637e());
        mo674f(afx.mo633d());
    }

    /* renamed from: a */
    public void mo652a(InputStream inputStream) {
        this.f910q.mo856a(inputStream, false);
    }

    /* renamed from: a */
    public void mo653a(InputStream inputStream, boolean z) {
        this.f910q.mo856a(inputStream, z);
    }

    /* renamed from: a */
    public void mo654a(OutputStream outputStream) {
        this.f910q.mo858a(outputStream, false);
    }

    /* renamed from: a */
    public void mo655a(OutputStream outputStream, boolean z) {
        this.f910q.mo858a(outputStream, z);
    }

    /* renamed from: b */
    public void mo663b(OutputStream outputStream) {
        this.f910q.mo863b(outputStream, false);
    }

    /* renamed from: b */
    public void mo664b(OutputStream outputStream, boolean z) {
        this.f910q.mo863b(outputStream, z);
    }

    /* renamed from: f */
    public InputStream mo673f() {
        int i;
        try {
            i = Integer.parseInt(mo686p().mo1083i("max_input_buffer_size"));
        } catch (Exception unused) {
            i = 32768;
        }
        C0028a aVar = new C0028a(this, 32768, i);
        this.f910q.mo858a((OutputStream) new C0030c(aVar, 32768 < i), false);
        return aVar;
    }

    /* renamed from: g */
    public InputStream mo675g() {
        int i;
        try {
            i = Integer.parseInt(mo686p().mo1083i("max_input_buffer_size"));
        } catch (Exception unused) {
            i = 32768;
        }
        C0028a aVar = new C0028a(this, 32768, i);
        this.f910q.mo863b(new C0030c(aVar, 32768 < i), false);
        return aVar;
    }

    /* renamed from: h */
    public OutputStream mo677h() {
        return new afz(this, this);
    }

    /* renamed from: atakplugin.UASTool.afy$a */
    class C0028a extends PipedInputStream {

        /* renamed from: b */
        private int f921b;

        /* renamed from: c */
        private int f922c;

        C0028a() {
            this.f921b = 1024;
            this.f922c = 1024;
        }

        C0028a(int i) {
            this.f921b = 1024;
            this.f922c = 1024;
            this.buffer = new byte[i];
            this.f921b = i;
            this.f922c = i;
        }

        C0028a(afy afy, int i, int i2) {
            this(i);
            this.f922c = i2;
        }

        C0028a(PipedOutputStream pipedOutputStream) {
            super(pipedOutputStream);
            this.f921b = 1024;
            this.f922c = 1024;
        }

        C0028a(PipedOutputStream pipedOutputStream, int i) {
            super(pipedOutputStream);
            this.f921b = 1024;
            this.f922c = 1024;
            this.buffer = new byte[i];
            this.f921b = i;
        }

        /* renamed from: a */
        public synchronized void mo692a() {
            if (available() == 0) {
                this.in = 0;
                this.out = 0;
                byte[] bArr = this.buffer;
                int i = this.in;
                this.in = i + 1;
                bArr[i] = 0;
                read();
            }
        }

        /* renamed from: b */
        private int m976b() {
            int i;
            int i2;
            if (this.out < this.in) {
                i = this.buffer.length;
                i2 = this.in;
            } else if (this.in >= this.out) {
                return 0;
            } else {
                if (this.in == -1) {
                    return this.buffer.length;
                }
                i = this.out;
                i2 = this.in;
            }
            return i - i2;
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:39:0x008e, code lost:
            return;
         */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public synchronized void mo693a(int r7) {
            /*
                r6 = this;
                monitor-enter(r6)
                int r0 = r6.m976b()     // Catch:{ all -> 0x008f }
                if (r0 >= r7) goto L_0x007a
                byte[] r1 = r6.buffer     // Catch:{ all -> 0x008f }
                int r1 = r1.length     // Catch:{ all -> 0x008f }
                int r1 = r1 - r0
                byte[] r0 = r6.buffer     // Catch:{ all -> 0x008f }
                int r0 = r0.length     // Catch:{ all -> 0x008f }
            L_0x000e:
                int r2 = r0 - r1
                if (r2 >= r7) goto L_0x0015
                int r0 = r0 * 2
                goto L_0x000e
            L_0x0015:
                int r2 = r6.f922c     // Catch:{ all -> 0x008f }
                if (r0 <= r2) goto L_0x001a
                r0 = r2
            L_0x001a:
                int r1 = r0 - r1
                if (r1 >= r7) goto L_0x0020
                monitor-exit(r6)
                return
            L_0x0020:
                byte[] r7 = new byte[r0]     // Catch:{ all -> 0x008f }
                int r1 = r6.out     // Catch:{ all -> 0x008f }
                int r2 = r6.in     // Catch:{ all -> 0x008f }
                r3 = 0
                if (r1 >= r2) goto L_0x0032
                byte[] r0 = r6.buffer     // Catch:{ all -> 0x008f }
                byte[] r1 = r6.buffer     // Catch:{ all -> 0x008f }
                int r1 = r1.length     // Catch:{ all -> 0x008f }
                java.lang.System.arraycopy(r0, r3, r7, r3, r1)     // Catch:{ all -> 0x008f }
                goto L_0x0077
            L_0x0032:
                int r1 = r6.in     // Catch:{ all -> 0x008f }
                int r2 = r6.out     // Catch:{ all -> 0x008f }
                if (r1 >= r2) goto L_0x0064
                int r1 = r6.in     // Catch:{ all -> 0x008f }
                r2 = -1
                if (r1 != r2) goto L_0x003e
                goto L_0x0077
            L_0x003e:
                byte[] r1 = r6.buffer     // Catch:{ all -> 0x008f }
                int r2 = r6.in     // Catch:{ all -> 0x008f }
                java.lang.System.arraycopy(r1, r3, r7, r3, r2)     // Catch:{ all -> 0x008f }
                byte[] r1 = r6.buffer     // Catch:{ all -> 0x008f }
                int r2 = r6.out     // Catch:{ all -> 0x008f }
                byte[] r3 = r6.buffer     // Catch:{ all -> 0x008f }
                int r3 = r3.length     // Catch:{ all -> 0x008f }
                int r4 = r6.out     // Catch:{ all -> 0x008f }
                int r3 = r3 - r4
                int r3 = r0 - r3
                byte[] r4 = r6.buffer     // Catch:{ all -> 0x008f }
                int r4 = r4.length     // Catch:{ all -> 0x008f }
                int r5 = r6.out     // Catch:{ all -> 0x008f }
                int r4 = r4 - r5
                java.lang.System.arraycopy(r1, r2, r7, r3, r4)     // Catch:{ all -> 0x008f }
                byte[] r1 = r6.buffer     // Catch:{ all -> 0x008f }
                int r1 = r1.length     // Catch:{ all -> 0x008f }
                int r2 = r6.out     // Catch:{ all -> 0x008f }
                int r1 = r1 - r2
                int r0 = r0 - r1
                r6.out = r0     // Catch:{ all -> 0x008f }
                goto L_0x0077
            L_0x0064:
                int r0 = r6.in     // Catch:{ all -> 0x008f }
                int r1 = r6.out     // Catch:{ all -> 0x008f }
                if (r0 != r1) goto L_0x0077
                byte[] r0 = r6.buffer     // Catch:{ all -> 0x008f }
                byte[] r1 = r6.buffer     // Catch:{ all -> 0x008f }
                int r1 = r1.length     // Catch:{ all -> 0x008f }
                java.lang.System.arraycopy(r0, r3, r7, r3, r1)     // Catch:{ all -> 0x008f }
                byte[] r0 = r6.buffer     // Catch:{ all -> 0x008f }
                int r0 = r0.length     // Catch:{ all -> 0x008f }
                r6.in = r0     // Catch:{ all -> 0x008f }
            L_0x0077:
                r6.buffer = r7     // Catch:{ all -> 0x008f }
                goto L_0x008d
            L_0x007a:
                byte[] r7 = r6.buffer     // Catch:{ all -> 0x008f }
                int r7 = r7.length     // Catch:{ all -> 0x008f }
                if (r7 != r0) goto L_0x008d
                int r7 = r6.f921b     // Catch:{ all -> 0x008f }
                if (r0 <= r7) goto L_0x008d
                int r0 = r0 / 2
                if (r0 >= r7) goto L_0x0088
                goto L_0x0089
            L_0x0088:
                r7 = r0
            L_0x0089:
                byte[] r7 = new byte[r7]     // Catch:{ all -> 0x008f }
                r6.buffer = r7     // Catch:{ all -> 0x008f }
            L_0x008d:
                monitor-exit(r6)
                return
            L_0x008f:
                r7 = move-exception
                monitor-exit(r6)
                throw r7
            */
            throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.afy.C0028a.mo693a(int):void");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo668c(int i) {
        this.f905l = i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo670d(int i) {
        this.f906m = i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public void mo671e(int i) {
        this.f907n = i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized void mo650a(long j) {
        this.f908o = j;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public synchronized void mo661b(long j) {
        this.f908o += j;
        if (this.f900A > 0) {
            notifyAll();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public void mo674f(int i) {
        this.f909p = i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo657a(byte[] bArr) {
        mo658a(bArr, 0, bArr.length);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo658a(byte[] bArr, int i, int i2) {
        try {
            this.f910q.mo860a(bArr, i, i2);
        } catch (NullPointerException unused) {
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo666b(byte[] bArr, int i, int i2) {
        try {
            this.f910q.mo864b(bArr, i, i2);
        } catch (NullPointerException unused) {
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public void mo679i() {
        this.f913t = true;
        try {
            this.f910q.mo861b();
        } catch (NullPointerException unused) {
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public void mo680j() {
        if (!this.f912s) {
            this.f912s = true;
            int a = mo648a();
            if (a != -1) {
                try {
                    afx afx = new afx(100);
                    ahy ahy = new ahy(afx);
                    ahy.mo996a();
                    afx.mo618a((byte) 96);
                    afx.mo619a(a);
                    synchronized (this) {
                        if (!this.f914u) {
                            mo686p().mo1061b(ahy);
                        }
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: k */
    public void mo681k() {
        if (!this.f914u) {
            this.f914u = true;
            this.f913t = true;
            this.f912s = true;
            int a = mo648a();
            if (a != -1) {
                try {
                    afx afx = new afx(100);
                    ahy ahy = new ahy(afx);
                    ahy.mo996a();
                    afx.mo618a((byte) 97);
                    afx.mo619a(a);
                    synchronized (this) {
                        mo686p().mo1061b(ahy);
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    /* renamed from: l */
    public boolean mo682l() {
        return this.f914u;
    }

    /* renamed from: a */
    static void m932a(air air) {
        afy[] afyArr;
        int i;
        int i2;
        synchronized (f891B) {
            afyArr = new afy[f891B.size()];
            i2 = 0;
            for (int i3 = 0; i3 < f891B.size(); i3++) {
                try {
                    afy afy = (afy) f891B.elementAt(i3);
                    if (afy.f901C == air) {
                        int i4 = i2 + 1;
                        try {
                            afyArr[i2] = afy;
                        } catch (Exception unused) {
                        }
                        i2 = i4;
                    }
                } catch (Exception unused2) {
                }
            }
        }
        for (i = 0; i < i2; i++) {
            afyArr[i].mo683m();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        mo681k();
        r1.f912s = true;
        r1.f913t = true;
        r1.f911r = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        r0 = r1.f910q;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x001b, code lost:
        if (r0 == null) goto L_0x0020;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x001d, code lost:
        r0.mo865c();
     */
    /* renamed from: m */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo683m() {
        /*
            r1 = this;
            monitor-enter(r1)     // Catch:{ all -> 0x0027 }
            boolean r0 = r1.f915v     // Catch:{ all -> 0x0024 }
            if (r0 != 0) goto L_0x000a
            monitor-exit(r1)     // Catch:{ all -> 0x0024 }
            m931a((atakplugin.UASTool.afy) r1)
            return
        L_0x000a:
            r0 = 0
            r1.f915v = r0     // Catch:{ all -> 0x0024 }
            monitor-exit(r1)     // Catch:{ all -> 0x0024 }
            r1.mo681k()     // Catch:{ all -> 0x0027 }
            r0 = 1
            r1.f912s = r0     // Catch:{ all -> 0x0027 }
            r1.f913t = r0     // Catch:{ all -> 0x0027 }
            r0 = 0
            r1.f911r = r0     // Catch:{ all -> 0x0027 }
            atakplugin.UASTool.ahc r0 = r1.f910q     // Catch:{ Exception -> 0x0020 }
            if (r0 == 0) goto L_0x0020
            r0.mo865c()     // Catch:{ Exception -> 0x0020 }
        L_0x0020:
            m931a((atakplugin.UASTool.afy) r1)
            return
        L_0x0024:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0024 }
            throw r0     // Catch:{ all -> 0x0027 }
        L_0x0027:
            r0 = move-exception
            m931a((atakplugin.UASTool.afy) r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.afy.mo683m():void");
    }

    /* renamed from: n */
    public boolean mo684n() {
        air air = this.f901C;
        if (air == null || !air.mo1081h() || !this.f915v) {
            return false;
        }
        return true;
    }

    /* renamed from: b */
    public void mo665b(String str) {
        aim aim = new aim();
        aim.mo1022a(str);
        aim.mo1014a(mo686p(), this);
    }

    /* renamed from: atakplugin.UASTool.afy$b */
    class C0029b extends C0028a {

        /* renamed from: b */
        PipedOutputStream f923b;

        C0029b(PipedOutputStream pipedOutputStream, int i) {
            super(pipedOutputStream, i);
            this.f923b = pipedOutputStream;
        }

        C0029b(PipedOutputStream pipedOutputStream) {
            super(pipedOutputStream);
            this.f923b = pipedOutputStream;
        }

        public void close() {
            PipedOutputStream pipedOutputStream = this.f923b;
            if (pipedOutputStream != null) {
                pipedOutputStream.close();
            }
            this.f923b = null;
        }
    }

    /* renamed from: atakplugin.UASTool.afy$c */
    class C0030c extends PipedOutputStream {

        /* renamed from: b */
        private C0028a f926b = null;

        C0030c(PipedInputStream pipedInputStream, boolean z) {
            super(pipedInputStream);
            if (z && (pipedInputStream instanceof C0028a)) {
                this.f926b = (C0028a) pipedInputStream;
            }
        }

        public void write(int i) {
            C0028a aVar = this.f926b;
            if (aVar != null) {
                aVar.mo693a(1);
            }
            super.write(i);
        }

        public void write(byte[] bArr, int i, int i2) {
            C0028a aVar = this.f926b;
            if (aVar != null) {
                aVar.mo693a(i2);
            }
            super.write(bArr, i, i2);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public void mo676g(int i) {
        this.f917x = i;
    }

    /* renamed from: o */
    public int mo685o() {
        return this.f917x;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo662b(air air) {
        this.f901C = air;
    }

    /* renamed from: p */
    public air mo686p() {
        air air = this.f901C;
        if (air != null) {
            return air;
        }
        throw new ahj("session is not available");
    }

    /* renamed from: q */
    public int mo687q() {
        return this.f902i;
    }

    /* access modifiers changed from: protected */
    /* renamed from: r */
    public void mo688r() {
        afx afx = new afx(100);
        ahy ahy = new ahy(afx);
        ahy.mo996a();
        afx.mo618a((byte) 91);
        afx.mo619a(mo648a());
        afx.mo619a(this.f902i);
        afx.mo619a(this.f906m);
        afx.mo619a(this.f907n);
        mo686p().mo1061b(ahy);
    }

    /* access modifiers changed from: protected */
    /* renamed from: h */
    public void mo678h(int i) {
        try {
            afx afx = new afx(100);
            ahy ahy = new ahy(afx);
            ahy.mo996a();
            afx.mo618a((byte) 92);
            afx.mo619a(mo648a());
            afx.mo619a(i);
            afx.mo627b(aji.m1820c("open failed"));
            afx.mo627b(aji.f1621a);
            mo686p().mo1061b(ahy);
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: s */
    public ahy mo690s() {
        afx afx = new afx(100);
        ahy ahy = new ahy(afx);
        ahy.mo996a();
        afx.mo618a((byte) 90);
        afx.mo627b(this.f904k);
        afx.mo619a(this.f902i);
        afx.mo619a(this.f906m);
        afx.mo619a(this.f907n);
        return ahy;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x004b */
    /* renamed from: t */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo691t() {
        /*
            r12 = this;
            atakplugin.UASTool.air r0 = r12.mo686p()
            boolean r1 = r0.mo1081h()
            if (r1 == 0) goto L_0x0084
            atakplugin.UASTool.ahy r1 = r12.mo690s()
            r0.mo1061b((atakplugin.UASTool.ahy) r1)
            r1 = 2000(0x7d0, float:2.803E-42)
            long r2 = java.lang.System.currentTimeMillis()
            int r4 = r12.f919z
            long r4 = (long) r4
            r6 = 0
            r8 = 1
            int r9 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r9 == 0) goto L_0x0022
            r1 = 1
        L_0x0022:
            monitor-enter(r12)
            r6 = 0
        L_0x0024:
            int r7 = r12.mo648a()     // Catch:{ all -> 0x0081 }
            r10 = -1
            if (r7 != r10) goto L_0x0055
            boolean r7 = r0.mo1081h()     // Catch:{ all -> 0x0081 }
            if (r7 == 0) goto L_0x0055
            if (r1 <= 0) goto L_0x0055
            if (r9 <= 0) goto L_0x0040
            long r10 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0081 }
            long r10 = r10 - r2
            int r7 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r7 <= 0) goto L_0x0040
            r1 = 0
            goto L_0x0024
        L_0x0040:
            if (r9 != 0) goto L_0x0045
            r10 = 10
            goto L_0x0046
        L_0x0045:
            r10 = r4
        L_0x0046:
            r12.f900A = r8     // Catch:{ InterruptedException -> 0x004b, all -> 0x004e }
            r12.wait(r10)     // Catch:{ InterruptedException -> 0x004b, all -> 0x004e }
        L_0x004b:
            r12.f900A = r6     // Catch:{ all -> 0x0081 }
            goto L_0x0052
        L_0x004e:
            r0 = move-exception
            r12.f900A = r6     // Catch:{ all -> 0x0081 }
            throw r0     // Catch:{ all -> 0x0081 }
        L_0x0052:
            int r1 = r1 + -1
            goto L_0x0024
        L_0x0055:
            monitor-exit(r12)     // Catch:{ all -> 0x0081 }
            boolean r0 = r0.mo1081h()
            if (r0 == 0) goto L_0x0079
            int r0 = r12.mo648a()
            if (r0 == r10) goto L_0x0071
            boolean r0 = r12.f916w
            if (r0 == 0) goto L_0x0069
            r12.f915v = r8
            return
        L_0x0069:
            atakplugin.UASTool.ahj r0 = new atakplugin.UASTool.ahj
            java.lang.String r1 = "channel is not opened."
            r0.<init>(r1)
            throw r0
        L_0x0071:
            atakplugin.UASTool.ahj r0 = new atakplugin.UASTool.ahj
            java.lang.String r1 = "channel is not opened."
            r0.<init>(r1)
            throw r0
        L_0x0079:
            atakplugin.UASTool.ahj r0 = new atakplugin.UASTool.ahj
            java.lang.String r1 = "session is down"
            r0.<init>(r1)
            throw r0
        L_0x0081:
            r0 = move-exception
            monitor-exit(r12)     // Catch:{ all -> 0x0081 }
            throw r0
        L_0x0084:
            atakplugin.UASTool.ahj r0 = new atakplugin.UASTool.ahj
            java.lang.String r1 = "session is down"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.afy.mo691t():void");
    }
}
