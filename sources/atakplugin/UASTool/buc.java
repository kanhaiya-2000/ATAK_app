package atakplugin.UASTool;

import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class buc {

    /* renamed from: d */
    static final /* synthetic */ boolean f3801d = true;

    /* renamed from: a */
    long f3802a = 0;

    /* renamed from: b */
    long f3803b;

    /* renamed from: c */
    final C0246a f3804c;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final int f3805e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public final btq f3806f;

    /* renamed from: g */
    private final List<bue> f3807g;

    /* renamed from: h */
    private List<bue> f3808h;

    /* renamed from: i */
    private final C0247b f3809i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public final C0248c f3810j = new C0248c();
    /* access modifiers changed from: private */

    /* renamed from: k */
    public final C0248c f3811k = new C0248c();
    /* access modifiers changed from: private */

    /* renamed from: l */
    public btn f3812l = null;

    buc(int i, btq btq, boolean z, boolean z2, List<bue> list) {
        Objects.requireNonNull(btq, "connection == null");
        Objects.requireNonNull(list, "requestHeaders == null");
        this.f3805e = i;
        this.f3806f = btq;
        this.f3803b = (long) btq.f3738f.mo3673l(65536);
        C0247b bVar = new C0247b((long) btq.f3737e.mo3673l(65536));
        this.f3809i = bVar;
        C0246a aVar = new C0246a();
        this.f3804c = aVar;
        boolean unused = bVar.f3825g = z2;
        boolean unused2 = aVar.f3818f = z;
        this.f3807g = list;
    }

    /* renamed from: a */
    public int mo3593a() {
        return this.f3805e;
    }

    /* renamed from: b */
    public synchronized boolean mo3600b() {
        if (this.f3812l != null) {
            return false;
        }
        if ((this.f3809i.f3825g || this.f3809i.f3824f) && ((this.f3804c.f3818f || this.f3804c.f3817e) && this.f3808h != null)) {
            return false;
        }
        return true;
    }

    /* renamed from: c */
    public boolean mo3602c() {
        if (this.f3806f.f3734b == ((this.f3805e & 1) == 1)) {
            return true;
        }
        return false;
    }

    /* renamed from: d */
    public btq mo3603d() {
        return this.f3806f;
    }

    /* renamed from: e */
    public List<bue> mo3604e() {
        return this.f3807g;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0025, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0026, code lost:
        r2.f3810j.mo3615b();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x002b, code lost:
        throw r0;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* renamed from: f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized java.util.List<atakplugin.UASTool.bue> mo3605f() {
        /*
            r2 = this;
            monitor-enter(r2)
            atakplugin.UASTool.buc$c r0 = r2.f3810j     // Catch:{ all -> 0x002c }
            r0.mo3760c_()     // Catch:{ all -> 0x002c }
        L_0x0006:
            java.util.List<atakplugin.UASTool.bue> r0 = r2.f3808h     // Catch:{ all -> 0x0025 }
            if (r0 != 0) goto L_0x0012
            atakplugin.UASTool.btn r0 = r2.f3812l     // Catch:{ all -> 0x0025 }
            if (r0 != 0) goto L_0x0012
            r2.m9521o()     // Catch:{ all -> 0x0025 }
            goto L_0x0006
        L_0x0012:
            atakplugin.UASTool.buc$c r0 = r2.f3810j     // Catch:{ all -> 0x002c }
            r0.mo3615b()     // Catch:{ all -> 0x002c }
            java.util.List<atakplugin.UASTool.bue> r0 = r2.f3808h     // Catch:{ all -> 0x002c }
            if (r0 == 0) goto L_0x001d
            monitor-exit(r2)
            return r0
        L_0x001d:
            atakplugin.UASTool.bur r0 = new atakplugin.UASTool.bur     // Catch:{ all -> 0x002c }
            atakplugin.UASTool.btn r1 = r2.f3812l     // Catch:{ all -> 0x002c }
            r0.<init>(r1)     // Catch:{ all -> 0x002c }
            throw r0     // Catch:{ all -> 0x002c }
        L_0x0025:
            r0 = move-exception
            atakplugin.UASTool.buc$c r1 = r2.f3810j     // Catch:{ all -> 0x002c }
            r1.mo3615b()     // Catch:{ all -> 0x002c }
            throw r0     // Catch:{ all -> 0x002c }
        L_0x002c:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.buc.mo3605f():java.util.List");
    }

    /* renamed from: g */
    public synchronized btn mo3606g() {
        return this.f3812l;
    }

    /* renamed from: a */
    public void mo3598a(List<bue> list, boolean z) {
        if (f3801d || !Thread.holdsLock(this)) {
            boolean z2 = false;
            synchronized (this) {
                if (list != null) {
                    try {
                        if (this.f3808h == null) {
                            this.f3808h = list;
                            if (!z) {
                                boolean unused = this.f3804c.f3818f = true;
                                z2 = true;
                            }
                        } else {
                            throw new IllegalStateException("reply already sent");
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                } else {
                    throw new NullPointerException("responseHeaders == null");
                }
            }
            this.f3806f.mo3528a(this.f3805e, z2, list);
            if (z2) {
                this.f3806f.mo3539e();
                return;
            }
            return;
        }
        throw new AssertionError();
    }

    /* renamed from: h */
    public bxs mo3607h() {
        return this.f3810j;
    }

    /* renamed from: i */
    public bxs mo3608i() {
        return this.f3811k;
    }

    /* renamed from: j */
    public bxr mo3609j() {
        return this.f3809i;
    }

    /* renamed from: k */
    public bxp mo3610k() {
        synchronized (this) {
            if (this.f3808h == null) {
                if (!mo3602c()) {
                    throw new IllegalStateException("reply before requesting the sink");
                }
            }
        }
        return this.f3804c;
    }

    /* renamed from: a */
    public void mo3595a(btn btn) {
        if (m9514d(btn)) {
            this.f3806f.mo3535b(this.f3805e, btn);
        }
    }

    /* renamed from: b */
    public void mo3599b(btn btn) {
        if (m9514d(btn)) {
            this.f3806f.mo3526a(this.f3805e, btn);
        }
    }

    /* renamed from: d */
    private boolean m9514d(btn btn) {
        if (f3801d || !Thread.holdsLock(this)) {
            synchronized (this) {
                if (this.f3812l != null) {
                    return false;
                }
                if (this.f3809i.f3825g && this.f3804c.f3818f) {
                    return false;
                }
                this.f3812l = btn;
                notifyAll();
                this.f3806f.mo3534b(this.f3805e);
                return true;
            }
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3597a(List<bue> list, buf buf) {
        if (f3801d || !Thread.holdsLock(this)) {
            btn btn = null;
            boolean z = true;
            synchronized (this) {
                if (this.f3808h == null) {
                    if (buf.mo3621c()) {
                        btn = btn.PROTOCOL_ERROR;
                    } else {
                        this.f3808h = list;
                        z = mo3600b();
                        notifyAll();
                    }
                } else if (buf.mo3622d()) {
                    btn = btn.STREAM_IN_USE;
                } else {
                    ArrayList arrayList = new ArrayList();
                    arrayList.addAll(this.f3808h);
                    arrayList.addAll(list);
                    this.f3808h = arrayList;
                }
            }
            if (btn != null) {
                mo3599b(btn);
            } else if (!z) {
                this.f3806f.mo3534b(this.f3805e);
            }
        } else {
            throw new AssertionError();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3596a(bwp bwp, int i) {
        if (f3801d || !Thread.holdsLock(this)) {
            this.f3809i.mo3612a(bwp, (long) i);
            return;
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: l */
    public void mo3611l() {
        boolean b;
        if (f3801d || !Thread.holdsLock(this)) {
            synchronized (this) {
                boolean unused = this.f3809i.f3825g = true;
                b = mo3600b();
                notifyAll();
            }
            if (!b) {
                this.f3806f.mo3534b(this.f3805e);
                return;
            }
            return;
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public synchronized void mo3601c(btn btn) {
        if (this.f3812l == null) {
            this.f3812l = btn;
            notifyAll();
        }
    }

    /* renamed from: atakplugin.UASTool.buc$b */
    private final class C0247b implements bxr {

        /* renamed from: a */
        static final /* synthetic */ boolean f3819a = true;

        /* renamed from: c */
        private final bwl f3821c;

        /* renamed from: d */
        private final bwl f3822d;

        /* renamed from: e */
        private final long f3823e;
        /* access modifiers changed from: private */

        /* renamed from: f */
        public boolean f3824f;
        /* access modifiers changed from: private */

        /* renamed from: g */
        public boolean f3825g;

        static {
            Class<buc> cls = buc.class;
        }

        private C0247b(long j) {
            this.f3821c = new bwl();
            this.f3822d = new bwl();
            this.f3823e = j;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0063, code lost:
            r11 = atakplugin.UASTool.buc.m9510a(r8.f3820b);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0069, code lost:
            monitor-enter(r11);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
            atakplugin.UASTool.buc.m9510a(r8.f3820b).f3735c += r9;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x008e, code lost:
            if (atakplugin.UASTool.buc.m9510a(r8.f3820b).f3735c < ((long) (atakplugin.UASTool.buc.m9510a(r8.f3820b).f3737e.mo3673l(65536) / 2))) goto L_0x00aa;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0090, code lost:
            atakplugin.UASTool.buc.m9510a(r8.f3820b).mo3525a(0, atakplugin.UASTool.buc.m9510a(r8.f3820b).f3735c);
            atakplugin.UASTool.buc.m9510a(r8.f3820b).f3735c = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x00aa, code lost:
            monitor-exit(r11);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x00ab, code lost:
            return r9;
         */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public long mo3425a(atakplugin.UASTool.bwl r9, long r10) {
            /*
                r8 = this;
                r0 = 0
                int r2 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
                if (r2 < 0) goto L_0x00b2
                atakplugin.UASTool.buc r2 = atakplugin.UASTool.buc.this
                monitor-enter(r2)
                r8.m9545a()     // Catch:{ all -> 0x00af }
                r8.m9548b()     // Catch:{ all -> 0x00af }
                atakplugin.UASTool.bwl r3 = r8.f3822d     // Catch:{ all -> 0x00af }
                long r3 = r3.mo3783a()     // Catch:{ all -> 0x00af }
                int r5 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
                if (r5 != 0) goto L_0x001d
                r9 = -1
                monitor-exit(r2)     // Catch:{ all -> 0x00af }
                return r9
            L_0x001d:
                atakplugin.UASTool.bwl r3 = r8.f3822d     // Catch:{ all -> 0x00af }
                long r4 = r3.mo3783a()     // Catch:{ all -> 0x00af }
                long r10 = java.lang.Math.min(r10, r4)     // Catch:{ all -> 0x00af }
                long r9 = r3.mo3425a((atakplugin.UASTool.bwl) r9, (long) r10)     // Catch:{ all -> 0x00af }
                atakplugin.UASTool.buc r11 = atakplugin.UASTool.buc.this     // Catch:{ all -> 0x00af }
                long r3 = r11.f3802a     // Catch:{ all -> 0x00af }
                long r3 = r3 + r9
                r11.f3802a = r3     // Catch:{ all -> 0x00af }
                atakplugin.UASTool.buc r11 = atakplugin.UASTool.buc.this     // Catch:{ all -> 0x00af }
                long r3 = r11.f3802a     // Catch:{ all -> 0x00af }
                atakplugin.UASTool.buc r11 = atakplugin.UASTool.buc.this     // Catch:{ all -> 0x00af }
                atakplugin.UASTool.btq r11 = r11.f3806f     // Catch:{ all -> 0x00af }
                atakplugin.UASTool.bup r11 = r11.f3737e     // Catch:{ all -> 0x00af }
                r5 = 65536(0x10000, float:9.18355E-41)
                int r11 = r11.mo3673l(r5)     // Catch:{ all -> 0x00af }
                int r11 = r11 / 2
                long r6 = (long) r11     // Catch:{ all -> 0x00af }
                int r11 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
                if (r11 < 0) goto L_0x0062
                atakplugin.UASTool.buc r11 = atakplugin.UASTool.buc.this     // Catch:{ all -> 0x00af }
                atakplugin.UASTool.btq r11 = r11.f3806f     // Catch:{ all -> 0x00af }
                atakplugin.UASTool.buc r3 = atakplugin.UASTool.buc.this     // Catch:{ all -> 0x00af }
                int r3 = r3.f3805e     // Catch:{ all -> 0x00af }
                atakplugin.UASTool.buc r4 = atakplugin.UASTool.buc.this     // Catch:{ all -> 0x00af }
                long r6 = r4.f3802a     // Catch:{ all -> 0x00af }
                r11.mo3525a((int) r3, (long) r6)     // Catch:{ all -> 0x00af }
                atakplugin.UASTool.buc r11 = atakplugin.UASTool.buc.this     // Catch:{ all -> 0x00af }
                r11.f3802a = r0     // Catch:{ all -> 0x00af }
            L_0x0062:
                monitor-exit(r2)     // Catch:{ all -> 0x00af }
                atakplugin.UASTool.buc r11 = atakplugin.UASTool.buc.this
                atakplugin.UASTool.btq r11 = r11.f3806f
                monitor-enter(r11)
                atakplugin.UASTool.buc r2 = atakplugin.UASTool.buc.this     // Catch:{ all -> 0x00ac }
                atakplugin.UASTool.btq r2 = r2.f3806f     // Catch:{ all -> 0x00ac }
                long r3 = r2.f3735c     // Catch:{ all -> 0x00ac }
                long r3 = r3 + r9
                r2.f3735c = r3     // Catch:{ all -> 0x00ac }
                atakplugin.UASTool.buc r2 = atakplugin.UASTool.buc.this     // Catch:{ all -> 0x00ac }
                atakplugin.UASTool.btq r2 = r2.f3806f     // Catch:{ all -> 0x00ac }
                long r2 = r2.f3735c     // Catch:{ all -> 0x00ac }
                atakplugin.UASTool.buc r4 = atakplugin.UASTool.buc.this     // Catch:{ all -> 0x00ac }
                atakplugin.UASTool.btq r4 = r4.f3806f     // Catch:{ all -> 0x00ac }
                atakplugin.UASTool.bup r4 = r4.f3737e     // Catch:{ all -> 0x00ac }
                int r4 = r4.mo3673l(r5)     // Catch:{ all -> 0x00ac }
                int r4 = r4 / 2
                long r4 = (long) r4     // Catch:{ all -> 0x00ac }
                int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r6 < 0) goto L_0x00aa
                atakplugin.UASTool.buc r2 = atakplugin.UASTool.buc.this     // Catch:{ all -> 0x00ac }
                atakplugin.UASTool.btq r2 = r2.f3806f     // Catch:{ all -> 0x00ac }
                r3 = 0
                atakplugin.UASTool.buc r4 = atakplugin.UASTool.buc.this     // Catch:{ all -> 0x00ac }
                atakplugin.UASTool.btq r4 = r4.f3806f     // Catch:{ all -> 0x00ac }
                long r4 = r4.f3735c     // Catch:{ all -> 0x00ac }
                r2.mo3525a((int) r3, (long) r4)     // Catch:{ all -> 0x00ac }
                atakplugin.UASTool.buc r2 = atakplugin.UASTool.buc.this     // Catch:{ all -> 0x00ac }
                atakplugin.UASTool.btq r2 = r2.f3806f     // Catch:{ all -> 0x00ac }
                r2.f3735c = r0     // Catch:{ all -> 0x00ac }
            L_0x00aa:
                monitor-exit(r11)     // Catch:{ all -> 0x00ac }
                return r9
            L_0x00ac:
                r9 = move-exception
                monitor-exit(r11)     // Catch:{ all -> 0x00ac }
                throw r9
            L_0x00af:
                r9 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x00af }
                throw r9
            L_0x00b2:
                java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "byteCount < 0: "
                r0.append(r1)
                r0.append(r10)
                java.lang.String r10 = r0.toString()
                r9.<init>(r10)
                throw r9
            */
            throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.buc.C0247b.mo3425a(atakplugin.UASTool.bwl, long):long");
        }

        /* renamed from: a */
        private void m9545a() {
            buc.this.f3810j.mo3760c_();
            while (this.f3822d.mo3783a() == 0 && !this.f3825g && !this.f3824f && buc.this.f3812l == null) {
                try {
                    buc.this.m9521o();
                } finally {
                    buc.this.f3810j.mo3615b();
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo3612a(bwp bwp, long j) {
            boolean z;
            boolean z2;
            boolean z3;
            if (f3819a || !Thread.holdsLock(buc.this)) {
                while (j > 0) {
                    synchronized (buc.this) {
                        z = this.f3825g;
                        z2 = true;
                        z3 = this.f3822d.mo3783a() + j > this.f3823e;
                    }
                    if (z3) {
                        bwp.mo3859j(j);
                        buc.this.mo3599b(btn.FLOW_CONTROL_ERROR);
                        return;
                    } else if (z) {
                        bwp.mo3859j(j);
                        return;
                    } else {
                        long a = bwp.mo3425a(this.f3821c, j);
                        if (a != -1) {
                            j -= a;
                            synchronized (buc.this) {
                                if (this.f3822d.mo3783a() != 0) {
                                    z2 = false;
                                }
                                this.f3822d.mo3789a((bxr) this.f3821c);
                                if (z2) {
                                    buc.this.notifyAll();
                                }
                            }
                        } else {
                            throw new EOFException();
                        }
                    }
                }
                return;
            }
            throw new AssertionError();
        }

        public bxs timeout() {
            return buc.this.f3810j;
        }

        public void close() {
            synchronized (buc.this) {
                this.f3824f = true;
                this.f3822d.mo3769B();
                buc.this.notifyAll();
            }
            buc.this.m9519m();
        }

        /* renamed from: b */
        private void m9548b() {
            if (this.f3824f) {
                throw new IOException("stream closed");
            } else if (buc.this.f3812l != null) {
                throw new bur(buc.this.f3812l);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: m */
    public void m9519m() {
        boolean z;
        boolean b;
        if (f3801d || !Thread.holdsLock(this)) {
            synchronized (this) {
                z = !this.f3809i.f3825g && this.f3809i.f3824f && (this.f3804c.f3818f || this.f3804c.f3817e);
                b = mo3600b();
            }
            if (z) {
                mo3595a(btn.CANCEL);
            } else if (!b) {
                this.f3806f.mo3534b(this.f3805e);
            }
        } else {
            throw new AssertionError();
        }
    }

    /* renamed from: atakplugin.UASTool.buc$a */
    final class C0246a implements bxp {

        /* renamed from: a */
        static final /* synthetic */ boolean f3813a = true;

        /* renamed from: c */
        private static final long f3814c = 16384;

        /* renamed from: d */
        private final bwl f3816d = new bwl();
        /* access modifiers changed from: private */

        /* renamed from: e */
        public boolean f3817e;
        /* access modifiers changed from: private */

        /* renamed from: f */
        public boolean f3818f;

        static {
            Class<buc> cls = buc.class;
        }

        C0246a() {
        }

        public void write(bwl bwl, long j) {
            if (f3813a || !Thread.holdsLock(buc.this)) {
                this.f3816d.write(bwl, j);
                while (this.f3816d.mo3783a() >= f3814c) {
                    m9541a(false);
                }
                return;
            }
            throw new AssertionError();
        }

        /* JADX INFO: finally extract failed */
        /* renamed from: a */
        private void m9541a(boolean z) {
            long min;
            synchronized (buc.this) {
                buc.this.f3811k.mo3760c_();
                while (buc.this.f3803b <= 0 && !this.f3818f && !this.f3817e && buc.this.f3812l == null) {
                    try {
                        buc.this.m9521o();
                    } catch (Throwable th) {
                        buc.this.f3811k.mo3615b();
                        throw th;
                    }
                }
                buc.this.f3811k.mo3615b();
                buc.this.m9520n();
                min = Math.min(buc.this.f3803b, this.f3816d.mo3783a());
                buc.this.f3803b -= min;
            }
            buc.this.f3811k.mo3760c_();
            try {
                buc.this.f3806f.mo3527a(buc.this.f3805e, z && min == this.f3816d.mo3783a(), this.f3816d, min);
            } finally {
                buc.this.f3811k.mo3615b();
            }
        }

        public void flush() {
            if (f3813a || !Thread.holdsLock(buc.this)) {
                synchronized (buc.this) {
                    buc.this.m9520n();
                }
                while (this.f3816d.mo3783a() > 0) {
                    m9541a(false);
                    buc.this.f3806f.mo3539e();
                }
                return;
            }
            throw new AssertionError();
        }

        public bxs timeout() {
            return buc.this.f3811k;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0024, code lost:
            if (r8.f3815b.f3804c.f3818f != false) goto L_0x0053;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0030, code lost:
            if (r8.f3816d.mo3783a() <= 0) goto L_0x0040;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x003a, code lost:
            if (r8.f3816d.mo3783a() <= 0) goto L_0x0053;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x003c, code lost:
            m9541a(true);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0040, code lost:
            atakplugin.UASTool.buc.m9510a(r8.f3815b).mo3527a(atakplugin.UASTool.buc.m9511b(r8.f3815b), true, (atakplugin.UASTool.bwl) null, 0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0053, code lost:
            r2 = r8.f3815b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0055, code lost:
            monitor-enter(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
            r8.f3817e = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0058, code lost:
            monitor-exit(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0059, code lost:
            atakplugin.UASTool.buc.m9510a(r8.f3815b).mo3539e();
            atakplugin.UASTool.buc.m9516f(r8.f3815b);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x0067, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void close() {
            /*
                r8 = this;
                boolean r0 = f3813a
                if (r0 != 0) goto L_0x0013
                atakplugin.UASTool.buc r0 = atakplugin.UASTool.buc.this
                boolean r0 = java.lang.Thread.holdsLock(r0)
                if (r0 != 0) goto L_0x000d
                goto L_0x0013
            L_0x000d:
                java.lang.AssertionError r0 = new java.lang.AssertionError
                r0.<init>()
                throw r0
            L_0x0013:
                atakplugin.UASTool.buc r0 = atakplugin.UASTool.buc.this
                monitor-enter(r0)
                boolean r1 = r8.f3817e     // Catch:{ all -> 0x006b }
                if (r1 == 0) goto L_0x001c
                monitor-exit(r0)     // Catch:{ all -> 0x006b }
                return
            L_0x001c:
                monitor-exit(r0)     // Catch:{ all -> 0x006b }
                atakplugin.UASTool.buc r0 = atakplugin.UASTool.buc.this
                atakplugin.UASTool.buc$a r0 = r0.f3804c
                boolean r0 = r0.f3818f
                r1 = 1
                if (r0 != 0) goto L_0x0053
                atakplugin.UASTool.bwl r0 = r8.f3816d
                long r2 = r0.mo3783a()
                r4 = 0
                int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r0 <= 0) goto L_0x0040
            L_0x0032:
                atakplugin.UASTool.bwl r0 = r8.f3816d
                long r2 = r0.mo3783a()
                int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r0 <= 0) goto L_0x0053
                r8.m9541a((boolean) r1)
                goto L_0x0032
            L_0x0040:
                atakplugin.UASTool.buc r0 = atakplugin.UASTool.buc.this
                atakplugin.UASTool.btq r2 = r0.f3806f
                atakplugin.UASTool.buc r0 = atakplugin.UASTool.buc.this
                int r3 = r0.f3805e
                r4 = 1
                r5 = 0
                r6 = 0
                r2.mo3527a((int) r3, (boolean) r4, (atakplugin.UASTool.bwl) r5, (long) r6)
            L_0x0053:
                atakplugin.UASTool.buc r2 = atakplugin.UASTool.buc.this
                monitor-enter(r2)
                r8.f3817e = r1     // Catch:{ all -> 0x0068 }
                monitor-exit(r2)     // Catch:{ all -> 0x0068 }
                atakplugin.UASTool.buc r0 = atakplugin.UASTool.buc.this
                atakplugin.UASTool.btq r0 = r0.f3806f
                r0.mo3539e()
                atakplugin.UASTool.buc r0 = atakplugin.UASTool.buc.this
                r0.m9519m()
                return
            L_0x0068:
                r0 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x0068 }
                throw r0
            L_0x006b:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x006b }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.buc.C0246a.close():void");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3594a(long j) {
        this.f3803b += j;
        if (j > 0) {
            notifyAll();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: n */
    public void m9520n() {
        if (this.f3804c.f3817e) {
            throw new IOException("stream closed");
        } else if (this.f3804c.f3818f) {
            throw new IOException("stream finished");
        } else if (this.f3812l != null) {
            throw new bur(this.f3812l);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: o */
    public void m9521o() {
        try {
            wait();
        } catch (InterruptedException unused) {
            throw new InterruptedIOException();
        }
    }

    /* renamed from: atakplugin.UASTool.buc$c */
    class C0248c extends bwh {
        C0248c() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo3614a() {
            buc.this.mo3599b(btn.CANCEL);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public IOException mo3613a(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        /* renamed from: b */
        public void mo3615b() {
            if (mo3761e_()) {
                throw mo3613a((IOException) null);
            }
        }
    }
}
