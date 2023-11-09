package atakplugin.UASTool;

import atakplugin.UASTool.bto;
import java.io.Closeable;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class btq implements Closeable {

    /* renamed from: k */
    static final /* synthetic */ boolean f3730k = true;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public static final ExecutorService f3731l = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), bsp.m9156a("OkHttp FramedConnection", true));

    /* renamed from: w */
    private static final int f3732w = 16777216;

    /* renamed from: a */
    final bry f3733a;

    /* renamed from: b */
    final boolean f3734b;

    /* renamed from: c */
    long f3735c;

    /* renamed from: d */
    long f3736d;

    /* renamed from: e */
    bup f3737e;

    /* renamed from: f */
    final bup f3738f;

    /* renamed from: g */
    final bus f3739g;

    /* renamed from: h */
    final Socket f3740h;

    /* renamed from: i */
    final btp f3741i;

    /* renamed from: j */
    final C0244c f3742j;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public final C0243b f3743m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public final Map<Integer, buc> f3744n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public final String f3745o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public int f3746p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public int f3747q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public boolean f3748r;

    /* renamed from: s */
    private final ExecutorService f3749s;

    /* renamed from: t */
    private Map<Integer, bum> f3750t;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public final bun f3751u;

    /* renamed from: v */
    private int f3752v;
    /* access modifiers changed from: private */

    /* renamed from: x */
    public boolean f3753x;
    /* access modifiers changed from: private */

    /* renamed from: y */
    public final Set<Integer> f3754y;

    /* renamed from: atakplugin.UASTool.btq$b */
    public static abstract class C0243b {

        /* renamed from: j */
        public static final C0243b f3763j = new bty();

        /* renamed from: a */
        public void mo3469a(btq btq) {
        }

        /* renamed from: a */
        public abstract void mo3470a(buc buc);
    }

    /* synthetic */ btq(C0242a aVar, btr btr) {
        this(aVar);
    }

    private btq(C0242a aVar) {
        this.f3744n = new HashMap();
        this.f3735c = 0;
        this.f3737e = new bup();
        bup bup = new bup();
        this.f3738f = bup;
        this.f3753x = false;
        this.f3754y = new LinkedHashSet();
        bry a = aVar.f3760f;
        this.f3733a = a;
        this.f3751u = aVar.f3761g;
        boolean c = aVar.f3762h;
        this.f3734b = c;
        this.f3743m = aVar.f3759e;
        int i = 2;
        this.f3747q = aVar.f3762h ? 1 : 2;
        if (aVar.f3762h && a == bry.HTTP_2) {
            this.f3747q += 2;
        }
        this.f3752v = aVar.f3762h ? 1 : i;
        if (aVar.f3762h) {
            this.f3737e.mo3655a(7, 0, 16777216);
        }
        String e = aVar.f3756b;
        this.f3745o = e;
        if (a == bry.HTTP_2) {
            this.f3739g = new buh();
            this.f3749s = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), bsp.m9156a(bsp.m9152a("OkHttp %s Push Observer", e), true));
            bup.mo3655a(7, 0, 65535);
            bup.mo3655a(5, 0, 16384);
        } else if (a == bry.SPDY_3) {
            this.f3739g = new buq();
            this.f3749s = null;
        } else {
            throw new AssertionError(a);
        }
        this.f3736d = (long) bup.mo3673l(65536);
        this.f3740h = aVar.f3755a;
        this.f3741i = this.f3739g.mo3634a(aVar.f3758d, c);
        this.f3742j = new C0244c(this, this.f3739g.mo3633a(aVar.f3757c, c), (btr) null);
    }

    /* renamed from: a */
    public bry mo3521a() {
        return this.f3733a;
    }

    /* renamed from: b */
    public synchronized int mo3533b() {
        return this.f3744n.size();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized buc mo3522a(int i) {
        return this.f3744n.get(Integer.valueOf(i));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public synchronized buc mo3534b(int i) {
        buc remove;
        remove = this.f3744n.remove(Integer.valueOf(i));
        notifyAll();
        return remove;
    }

    /* renamed from: c */
    public synchronized int mo3536c() {
        return this.f3738f.mo3668g(Integer.MAX_VALUE);
    }

    /* renamed from: a */
    public buc mo3523a(int i, List<bue> list, boolean z) {
        if (this.f3734b) {
            throw new IllegalStateException("Client cannot push requests.");
        } else if (this.f3733a == bry.HTTP_2) {
            return m9364a(i, list, z, false);
        } else {
            throw new IllegalStateException("protocol != HTTP_2");
        }
    }

    /* renamed from: a */
    public buc mo3524a(List<bue> list, boolean z, boolean z2) {
        return m9364a(0, list, z, z2);
    }

    /* renamed from: a */
    private buc m9364a(int i, List<bue> list, boolean z, boolean z2) {
        int i2;
        buc buc;
        boolean z3 = !z;
        boolean z4 = true;
        boolean z5 = !z2;
        synchronized (this.f3741i) {
            synchronized (this) {
                if (!this.f3748r) {
                    i2 = this.f3747q;
                    this.f3747q = i2 + 2;
                    buc = new buc(i2, this, z3, z5, list);
                    if (z && this.f3736d != 0) {
                        if (buc.f3803b != 0) {
                            z4 = false;
                        }
                    }
                    if (buc.mo3600b()) {
                        this.f3744n.put(Integer.valueOf(i2), buc);
                    }
                } else {
                    throw new IOException("shutdown");
                }
            }
            if (i == 0) {
                this.f3741i.mo3517a(z3, z5, i2, i, list);
            } else if (!this.f3734b) {
                this.f3741i.mo3508a(i, i2, list);
            } else {
                throw new IllegalArgumentException("client streams shouldn't have associated stream IDs");
            }
        }
        if (z4) {
            this.f3741i.mo3518b();
        }
        return buc;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3528a(int i, boolean z, List<bue> list) {
        this.f3741i.mo3516a(z, i, list);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:26|27|28) */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        r3 = java.lang.Math.min((int) java.lang.Math.min(r12, r3), r8.f3741i.mo3520c());
        r6 = (long) r3;
        r8.f3736d -= r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x005d, code lost:
        throw new java.io.InterruptedIOException();
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x0058 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo3527a(int r9, boolean r10, atakplugin.UASTool.bwl r11, long r12) {
        /*
            r8 = this;
            r0 = 0
            r1 = 0
            int r3 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r3 != 0) goto L_0x000d
            atakplugin.UASTool.btp r12 = r8.f3741i
            r12.mo3515a(r10, r9, r11, r0)
            return
        L_0x000d:
            int r3 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r3 <= 0) goto L_0x0060
            monitor-enter(r8)
        L_0x0012:
            long r3 = r8.f3736d     // Catch:{ InterruptedException -> 0x0058 }
            int r5 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r5 > 0) goto L_0x0030
            java.util.Map<java.lang.Integer, atakplugin.UASTool.buc> r3 = r8.f3744n     // Catch:{ InterruptedException -> 0x0058 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r9)     // Catch:{ InterruptedException -> 0x0058 }
            boolean r3 = r3.containsKey(r4)     // Catch:{ InterruptedException -> 0x0058 }
            if (r3 == 0) goto L_0x0028
            r8.wait()     // Catch:{ InterruptedException -> 0x0058 }
            goto L_0x0012
        L_0x0028:
            java.io.IOException r9 = new java.io.IOException     // Catch:{ InterruptedException -> 0x0058 }
            java.lang.String r10 = "stream closed"
            r9.<init>(r10)     // Catch:{ InterruptedException -> 0x0058 }
            throw r9     // Catch:{ InterruptedException -> 0x0058 }
        L_0x0030:
            long r3 = java.lang.Math.min(r12, r3)     // Catch:{ all -> 0x0056 }
            int r4 = (int) r3     // Catch:{ all -> 0x0056 }
            atakplugin.UASTool.btp r3 = r8.f3741i     // Catch:{ all -> 0x0056 }
            int r3 = r3.mo3520c()     // Catch:{ all -> 0x0056 }
            int r3 = java.lang.Math.min(r4, r3)     // Catch:{ all -> 0x0056 }
            long r4 = r8.f3736d     // Catch:{ all -> 0x0056 }
            long r6 = (long) r3     // Catch:{ all -> 0x0056 }
            long r4 = r4 - r6
            r8.f3736d = r4     // Catch:{ all -> 0x0056 }
            monitor-exit(r8)     // Catch:{ all -> 0x0056 }
            long r12 = r12 - r6
            atakplugin.UASTool.btp r4 = r8.f3741i
            if (r10 == 0) goto L_0x0051
            int r5 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r5 != 0) goto L_0x0051
            r5 = 1
            goto L_0x0052
        L_0x0051:
            r5 = 0
        L_0x0052:
            r4.mo3515a(r5, r9, r11, r3)
            goto L_0x000d
        L_0x0056:
            r9 = move-exception
            goto L_0x005e
        L_0x0058:
            java.io.InterruptedIOException r9 = new java.io.InterruptedIOException     // Catch:{ all -> 0x0056 }
            r9.<init>()     // Catch:{ all -> 0x0056 }
            throw r9     // Catch:{ all -> 0x0056 }
        L_0x005e:
            monitor-exit(r8)     // Catch:{ all -> 0x0056 }
            throw r9
        L_0x0060:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.btq.mo3527a(int, boolean, atakplugin.UASTool.bwl, long):void");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3529a(long j) {
        this.f3736d += j;
        if (j > 0) {
            notifyAll();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3526a(int i, btn btn) {
        f3731l.submit(new btr(this, "OkHttp %s stream %d", new Object[]{this.f3745o, Integer.valueOf(i)}, i, btn));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo3535b(int i, btn btn) {
        this.f3741i.mo3510a(i, btn);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3525a(int i, long j) {
        f3731l.execute(new bts(this, "OkHttp Window Update %s stream %d", new Object[]{this.f3745o, Integer.valueOf(i)}, i, j));
    }

    /* renamed from: d */
    public bum mo3538d() {
        int i;
        bum bum = new bum();
        synchronized (this) {
            if (!this.f3748r) {
                i = this.f3752v;
                this.f3752v = i + 2;
                if (this.f3750t == null) {
                    this.f3750t = new HashMap();
                }
                this.f3750t.put(Integer.valueOf(i), bum);
            } else {
                throw new IOException("shutdown");
            }
        }
        m9381b(false, i, 1330343787, bum);
        return bum;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m9375a(boolean z, int i, int i2, bum bum) {
        f3731l.execute(new btt(this, "OkHttp %s ping %08x%08x", new Object[]{this.f3745o, Integer.valueOf(i), Integer.valueOf(i2)}, z, i, i2, bum));
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m9381b(boolean z, int i, int i2, bum bum) {
        synchronized (this.f3741i) {
            if (bum != null) {
                bum.mo3647a();
            }
            this.f3741i.mo3514a(z, i, i2);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public synchronized bum m9385c(int i) {
        Map<Integer, bum> map;
        map = this.f3750t;
        return map != null ? map.remove(Integer.valueOf(i)) : null;
    }

    /* renamed from: e */
    public void mo3539e() {
        this.f3741i.mo3518b();
    }

    /* renamed from: a */
    public void mo3530a(btn btn) {
        synchronized (this.f3741i) {
            synchronized (this) {
                if (!this.f3748r) {
                    this.f3748r = true;
                    int i = this.f3746p;
                    this.f3741i.mo3511a(i, btn, bsp.f3582a);
                }
            }
        }
    }

    public void close() {
        m9368a(btn.NO_ERROR, btn.CANCEL);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m9368a(btn btn, btn btn2) {
        buc[] bucArr;
        if (f3730k || !Thread.holdsLock(this)) {
            bum[] bumArr = null;
            try {
                mo3530a(btn);
                e = null;
            } catch (IOException e) {
                e = e;
            }
            synchronized (this) {
                if (!this.f3744n.isEmpty()) {
                    bucArr = (buc[]) this.f3744n.values().toArray(new buc[this.f3744n.size()]);
                    this.f3744n.clear();
                } else {
                    bucArr = null;
                }
                Map<Integer, bum> map = this.f3750t;
                if (map != null) {
                    this.f3750t = null;
                    bumArr = (bum[]) map.values().toArray(new bum[this.f3750t.size()]);
                }
            }
            if (bucArr != null) {
                for (buc a : bucArr) {
                    try {
                        a.mo3595a(btn2);
                    } catch (IOException e2) {
                        if (e != null) {
                            e = e2;
                        }
                    }
                }
            }
            if (bumArr != null) {
                for (bum c : bumArr) {
                    c.mo3649c();
                }
            }
            try {
                this.f3741i.close();
            } catch (IOException e3) {
                if (e == null) {
                    e = e3;
                }
            }
            try {
                this.f3740h.close();
            } catch (IOException e4) {
                e = e4;
            }
            if (e != null) {
                throw e;
            }
            return;
        }
        throw new AssertionError();
    }

    /* renamed from: f */
    public void mo3540f() {
        mo3532a(true);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3532a(boolean z) {
        if (z) {
            this.f3741i.mo3507a();
            this.f3741i.mo3519b(this.f3737e);
            int l = this.f3737e.mo3673l(65536);
            if (l != 65536) {
                this.f3741i.mo3509a(0, (long) (l - 65536));
            }
        }
        new Thread(this.f3742j).start();
    }

    /* renamed from: a */
    public void mo3531a(bup bup) {
        synchronized (this.f3741i) {
            synchronized (this) {
                if (!this.f3748r) {
                    this.f3737e.mo3657a(bup);
                    this.f3741i.mo3519b(bup);
                } else {
                    throw new IOException("shutdown");
                }
            }
        }
    }

    /* renamed from: atakplugin.UASTool.btq$a */
    public static class C0242a {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public Socket f3755a;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public String f3756b;
        /* access modifiers changed from: private */

        /* renamed from: c */
        public bwp f3757c;
        /* access modifiers changed from: private */

        /* renamed from: d */
        public bwo f3758d;
        /* access modifiers changed from: private */

        /* renamed from: e */
        public C0243b f3759e = C0243b.f3763j;
        /* access modifiers changed from: private */

        /* renamed from: f */
        public bry f3760f = bry.SPDY_3;
        /* access modifiers changed from: private */

        /* renamed from: g */
        public bun f3761g = bun.f3922a;
        /* access modifiers changed from: private */

        /* renamed from: h */
        public boolean f3762h;

        public C0242a(boolean z) {
            this.f3762h = z;
        }

        /* renamed from: a */
        public C0242a mo3544a(Socket socket) {
            return mo3545a(socket, ((InetSocketAddress) socket.getRemoteSocketAddress()).getHostName(), bxb.m10330a(bxb.m10341b(socket)), bxb.m10329a(bxb.m10336a(socket)));
        }

        /* renamed from: a */
        public C0242a mo3545a(Socket socket, String str, bwp bwp, bwo bwo) {
            this.f3755a = socket;
            this.f3756b = str;
            this.f3757c = bwp;
            this.f3758d = bwo;
            return this;
        }

        /* renamed from: a */
        public C0242a mo3542a(C0243b bVar) {
            this.f3759e = bVar;
            return this;
        }

        /* renamed from: a */
        public C0242a mo3541a(bry bry) {
            this.f3760f = bry;
            return this;
        }

        /* renamed from: a */
        public C0242a mo3543a(bun bun) {
            this.f3761g = bun;
            return this;
        }

        /* renamed from: a */
        public btq mo3546a() {
            return new btq(this, (btr) null);
        }
    }

    /* renamed from: atakplugin.UASTool.btq$c */
    class C0244c extends bso implements bto.C0241a {

        /* renamed from: a */
        final bto f3764a;

        /* renamed from: a */
        public void mo3496a() {
        }

        /* renamed from: a */
        public void mo3497a(int i, int i2, int i3, boolean z) {
        }

        /* renamed from: a */
        public void mo3502a(int i, String str, bwq bwq, String str2, int i2, long j) {
        }

        /* synthetic */ C0244c(btq btq, bto bto, btr btr) {
            this(bto);
        }

        private C0244c(bto bto) {
            super("OkHttp %s", btq.this.f3745o);
            this.f3764a = bto;
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x001f, code lost:
            r2 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            r0 = atakplugin.UASTool.btn.PROTOCOL_ERROR;
            r1 = atakplugin.UASTool.btn.PROTOCOL_ERROR;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
            r2 = r4.f3765c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
            atakplugin.UASTool.btq.m9373a(r4.f3765c, r0, r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0035, code lost:
            atakplugin.UASTool.bsp.m9158a((java.io.Closeable) r4.f3764a);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x003a, code lost:
            throw r2;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0021 */
        /* renamed from: d */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void mo3342d() {
            /*
                r4 = this;
                atakplugin.UASTool.btn r0 = atakplugin.UASTool.btn.INTERNAL_ERROR
                atakplugin.UASTool.btn r1 = atakplugin.UASTool.btn.INTERNAL_ERROR
                atakplugin.UASTool.btq r2 = atakplugin.UASTool.btq.this     // Catch:{ IOException -> 0x0021 }
                boolean r2 = r2.f3734b     // Catch:{ IOException -> 0x0021 }
                if (r2 != 0) goto L_0x000f
                atakplugin.UASTool.bto r2 = r4.f3764a     // Catch:{ IOException -> 0x0021 }
                r2.mo3494a()     // Catch:{ IOException -> 0x0021 }
            L_0x000f:
                atakplugin.UASTool.bto r2 = r4.f3764a     // Catch:{ IOException -> 0x0021 }
                boolean r2 = r2.mo3495a(r4)     // Catch:{ IOException -> 0x0021 }
                if (r2 == 0) goto L_0x0018
                goto L_0x000f
            L_0x0018:
                atakplugin.UASTool.btn r0 = atakplugin.UASTool.btn.NO_ERROR     // Catch:{ IOException -> 0x0021 }
                atakplugin.UASTool.btn r1 = atakplugin.UASTool.btn.CANCEL     // Catch:{ IOException -> 0x0021 }
                atakplugin.UASTool.btq r2 = atakplugin.UASTool.btq.this     // Catch:{ IOException -> 0x002a }
                goto L_0x0027
            L_0x001f:
                r2 = move-exception
                goto L_0x0030
            L_0x0021:
                atakplugin.UASTool.btn r0 = atakplugin.UASTool.btn.PROTOCOL_ERROR     // Catch:{ all -> 0x001f }
                atakplugin.UASTool.btn r1 = atakplugin.UASTool.btn.PROTOCOL_ERROR     // Catch:{ all -> 0x001f }
                atakplugin.UASTool.btq r2 = atakplugin.UASTool.btq.this     // Catch:{ IOException -> 0x002a }
            L_0x0027:
                r2.m9368a((atakplugin.UASTool.btn) r0, (atakplugin.UASTool.btn) r1)     // Catch:{ IOException -> 0x002a }
            L_0x002a:
                atakplugin.UASTool.bto r0 = r4.f3764a
                atakplugin.UASTool.bsp.m9158a((java.io.Closeable) r0)
                return
            L_0x0030:
                atakplugin.UASTool.btq r3 = atakplugin.UASTool.btq.this     // Catch:{ IOException -> 0x0035 }
                r3.m9368a((atakplugin.UASTool.btn) r0, (atakplugin.UASTool.btn) r1)     // Catch:{ IOException -> 0x0035 }
            L_0x0035:
                atakplugin.UASTool.bto r0 = r4.f3764a
                atakplugin.UASTool.bsp.m9158a((java.io.Closeable) r0)
                throw r2
            */
            throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.btq.C0244c.mo3342d():void");
        }

        /* renamed from: a */
        public void mo3504a(boolean z, int i, bwp bwp, int i2) {
            if (btq.this.m9389d(i)) {
                btq.this.m9366a(i, bwp, i2, z);
                return;
            }
            buc a = btq.this.mo3522a(i);
            if (a == null) {
                btq.this.mo3526a(i, btn.INVALID_STREAM);
                bwp.mo3859j((long) i2);
                return;
            }
            a.mo3596a(bwp, i2);
            if (z) {
                a.mo3611l();
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:31:0x008f, code lost:
            if (r14.mo3620b() == false) goto L_0x009c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x0091, code lost:
            r0.mo3599b(atakplugin.UASTool.btn.PROTOCOL_ERROR);
            r8.f3765c.mo3534b(r11);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x009b, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x009c, code lost:
            r0.mo3597a(r13, r14);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x009f, code lost:
            if (r10 == false) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x00a1, code lost:
            r0.mo3611l();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:45:?, code lost:
            return;
         */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void mo3506a(boolean r9, boolean r10, int r11, int r12, java.util.List<atakplugin.UASTool.bue> r13, atakplugin.UASTool.buf r14) {
            /*
                r8 = this;
                atakplugin.UASTool.btq r12 = atakplugin.UASTool.btq.this
                boolean r12 = r12.m9389d((int) r11)
                if (r12 == 0) goto L_0x000e
                atakplugin.UASTool.btq r9 = atakplugin.UASTool.btq.this
                r9.m9379b(r11, r13, r10)
                return
            L_0x000e:
                atakplugin.UASTool.btq r12 = atakplugin.UASTool.btq.this
                monitor-enter(r12)
                atakplugin.UASTool.btq r0 = atakplugin.UASTool.btq.this     // Catch:{ all -> 0x00a5 }
                boolean r0 = r0.f3748r     // Catch:{ all -> 0x00a5 }
                if (r0 == 0) goto L_0x001b
                monitor-exit(r12)     // Catch:{ all -> 0x00a5 }
                return
            L_0x001b:
                atakplugin.UASTool.btq r0 = atakplugin.UASTool.btq.this     // Catch:{ all -> 0x00a5 }
                atakplugin.UASTool.buc r0 = r0.mo3522a((int) r11)     // Catch:{ all -> 0x00a5 }
                if (r0 != 0) goto L_0x008a
                boolean r14 = r14.mo3619a()     // Catch:{ all -> 0x00a5 }
                if (r14 == 0) goto L_0x0032
                atakplugin.UASTool.btq r9 = atakplugin.UASTool.btq.this     // Catch:{ all -> 0x00a5 }
                atakplugin.UASTool.btn r10 = atakplugin.UASTool.btn.INVALID_STREAM     // Catch:{ all -> 0x00a5 }
                r9.mo3526a((int) r11, (atakplugin.UASTool.btn) r10)     // Catch:{ all -> 0x00a5 }
                monitor-exit(r12)     // Catch:{ all -> 0x00a5 }
                return
            L_0x0032:
                atakplugin.UASTool.btq r14 = atakplugin.UASTool.btq.this     // Catch:{ all -> 0x00a5 }
                int r14 = r14.f3746p     // Catch:{ all -> 0x00a5 }
                if (r11 > r14) goto L_0x003c
                monitor-exit(r12)     // Catch:{ all -> 0x00a5 }
                return
            L_0x003c:
                int r14 = r11 % 2
                atakplugin.UASTool.btq r0 = atakplugin.UASTool.btq.this     // Catch:{ all -> 0x00a5 }
                int r0 = r0.f3747q     // Catch:{ all -> 0x00a5 }
                r1 = 2
                int r0 = r0 % r1
                if (r14 != r0) goto L_0x004a
                monitor-exit(r12)     // Catch:{ all -> 0x00a5 }
                return
            L_0x004a:
                atakplugin.UASTool.buc r14 = new atakplugin.UASTool.buc     // Catch:{ all -> 0x00a5 }
                atakplugin.UASTool.btq r4 = atakplugin.UASTool.btq.this     // Catch:{ all -> 0x00a5 }
                r2 = r14
                r3 = r11
                r5 = r9
                r6 = r10
                r7 = r13
                r2.<init>(r3, r4, r5, r6, r7)     // Catch:{ all -> 0x00a5 }
                atakplugin.UASTool.btq r9 = atakplugin.UASTool.btq.this     // Catch:{ all -> 0x00a5 }
                int unused = r9.f3746p = r11     // Catch:{ all -> 0x00a5 }
                atakplugin.UASTool.btq r9 = atakplugin.UASTool.btq.this     // Catch:{ all -> 0x00a5 }
                java.util.Map r9 = r9.f3744n     // Catch:{ all -> 0x00a5 }
                java.lang.Integer r10 = java.lang.Integer.valueOf(r11)     // Catch:{ all -> 0x00a5 }
                r9.put(r10, r14)     // Catch:{ all -> 0x00a5 }
                java.util.concurrent.ExecutorService r9 = atakplugin.UASTool.btq.f3731l     // Catch:{ all -> 0x00a5 }
                atakplugin.UASTool.btz r10 = new atakplugin.UASTool.btz     // Catch:{ all -> 0x00a5 }
                java.lang.String r13 = "OkHttp %s stream %d"
                java.lang.Object[] r0 = new java.lang.Object[r1]     // Catch:{ all -> 0x00a5 }
                r1 = 0
                atakplugin.UASTool.btq r2 = atakplugin.UASTool.btq.this     // Catch:{ all -> 0x00a5 }
                java.lang.String r2 = r2.f3745o     // Catch:{ all -> 0x00a5 }
                r0[r1] = r2     // Catch:{ all -> 0x00a5 }
                r1 = 1
                java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ all -> 0x00a5 }
                r0[r1] = r11     // Catch:{ all -> 0x00a5 }
                r10.<init>(r8, r13, r0, r14)     // Catch:{ all -> 0x00a5 }
                r9.execute(r10)     // Catch:{ all -> 0x00a5 }
                monitor-exit(r12)     // Catch:{ all -> 0x00a5 }
                return
            L_0x008a:
                monitor-exit(r12)     // Catch:{ all -> 0x00a5 }
                boolean r9 = r14.mo3620b()
                if (r9 == 0) goto L_0x009c
                atakplugin.UASTool.btn r9 = atakplugin.UASTool.btn.PROTOCOL_ERROR
                r0.mo3599b((atakplugin.UASTool.btn) r9)
                atakplugin.UASTool.btq r9 = atakplugin.UASTool.btq.this
                r9.mo3534b((int) r11)
                return
            L_0x009c:
                r0.mo3597a((java.util.List<atakplugin.UASTool.bue>) r13, (atakplugin.UASTool.buf) r14)
                if (r10 == 0) goto L_0x00a4
                r0.mo3611l()
            L_0x00a4:
                return
            L_0x00a5:
                r9 = move-exception
                monitor-exit(r12)     // Catch:{ all -> 0x00a5 }
                throw r9
            */
            throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.btq.C0244c.mo3506a(boolean, boolean, int, int, java.util.List, atakplugin.UASTool.buf):void");
        }

        /* renamed from: a */
        public void mo3500a(int i, btn btn) {
            if (btq.this.m9389d(i)) {
                btq.this.m9387c(i, btn);
                return;
            }
            buc b = btq.this.mo3534b(i);
            if (b != null) {
                b.mo3601c(btn);
            }
        }

        /* JADX WARNING: type inference failed for: r1v13, types: [java.lang.Object[]] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void mo3505a(boolean r11, atakplugin.UASTool.bup r12) {
            /*
                r10 = this;
                atakplugin.UASTool.btq r0 = atakplugin.UASTool.btq.this
                monitor-enter(r0)
                atakplugin.UASTool.btq r1 = atakplugin.UASTool.btq.this     // Catch:{ all -> 0x00ab }
                atakplugin.UASTool.bup r1 = r1.f3738f     // Catch:{ all -> 0x00ab }
                r2 = 65536(0x10000, float:9.18355E-41)
                int r1 = r1.mo3673l(r2)     // Catch:{ all -> 0x00ab }
                if (r11 == 0) goto L_0x0016
                atakplugin.UASTool.btq r11 = atakplugin.UASTool.btq.this     // Catch:{ all -> 0x00ab }
                atakplugin.UASTool.bup r11 = r11.f3738f     // Catch:{ all -> 0x00ab }
                r11.mo3656a()     // Catch:{ all -> 0x00ab }
            L_0x0016:
                atakplugin.UASTool.btq r11 = atakplugin.UASTool.btq.this     // Catch:{ all -> 0x00ab }
                atakplugin.UASTool.bup r11 = r11.f3738f     // Catch:{ all -> 0x00ab }
                r11.mo3657a((atakplugin.UASTool.bup) r12)     // Catch:{ all -> 0x00ab }
                atakplugin.UASTool.btq r11 = atakplugin.UASTool.btq.this     // Catch:{ all -> 0x00ab }
                atakplugin.UASTool.bry r11 = r11.mo3521a()     // Catch:{ all -> 0x00ab }
                atakplugin.UASTool.bry r3 = atakplugin.UASTool.bry.HTTP_2     // Catch:{ all -> 0x00ab }
                if (r11 != r3) goto L_0x002a
                r10.m9431a(r12)     // Catch:{ all -> 0x00ab }
            L_0x002a:
                atakplugin.UASTool.btq r11 = atakplugin.UASTool.btq.this     // Catch:{ all -> 0x00ab }
                atakplugin.UASTool.bup r11 = r11.f3738f     // Catch:{ all -> 0x00ab }
                int r11 = r11.mo3673l(r2)     // Catch:{ all -> 0x00ab }
                r12 = -1
                r2 = 0
                r4 = 1
                r5 = 0
                if (r11 == r12) goto L_0x0079
                if (r11 == r1) goto L_0x0079
                int r11 = r11 - r1
                long r11 = (long) r11     // Catch:{ all -> 0x00ab }
                atakplugin.UASTool.btq r1 = atakplugin.UASTool.btq.this     // Catch:{ all -> 0x00ab }
                boolean r1 = r1.f3753x     // Catch:{ all -> 0x00ab }
                if (r1 != 0) goto L_0x004f
                atakplugin.UASTool.btq r1 = atakplugin.UASTool.btq.this     // Catch:{ all -> 0x00ab }
                r1.mo3529a((long) r11)     // Catch:{ all -> 0x00ab }
                atakplugin.UASTool.btq r1 = atakplugin.UASTool.btq.this     // Catch:{ all -> 0x00ab }
                boolean unused = r1.f3753x = r4     // Catch:{ all -> 0x00ab }
            L_0x004f:
                atakplugin.UASTool.btq r1 = atakplugin.UASTool.btq.this     // Catch:{ all -> 0x00ab }
                java.util.Map r1 = r1.f3744n     // Catch:{ all -> 0x00ab }
                boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x00ab }
                if (r1 != 0) goto L_0x007a
                atakplugin.UASTool.btq r1 = atakplugin.UASTool.btq.this     // Catch:{ all -> 0x00ab }
                java.util.Map r1 = r1.f3744n     // Catch:{ all -> 0x00ab }
                java.util.Collection r1 = r1.values()     // Catch:{ all -> 0x00ab }
                atakplugin.UASTool.btq r5 = atakplugin.UASTool.btq.this     // Catch:{ all -> 0x00ab }
                java.util.Map r5 = r5.f3744n     // Catch:{ all -> 0x00ab }
                int r5 = r5.size()     // Catch:{ all -> 0x00ab }
                atakplugin.UASTool.buc[] r5 = new atakplugin.UASTool.buc[r5]     // Catch:{ all -> 0x00ab }
                java.lang.Object[] r1 = r1.toArray(r5)     // Catch:{ all -> 0x00ab }
                r5 = r1
                atakplugin.UASTool.buc[] r5 = (atakplugin.UASTool.buc[]) r5     // Catch:{ all -> 0x00ab }
                goto L_0x007a
            L_0x0079:
                r11 = r2
            L_0x007a:
                java.util.concurrent.ExecutorService r1 = atakplugin.UASTool.btq.f3731l     // Catch:{ all -> 0x00ab }
                atakplugin.UASTool.bua r6 = new atakplugin.UASTool.bua     // Catch:{ all -> 0x00ab }
                java.lang.String r7 = "OkHttp %s settings"
                java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ all -> 0x00ab }
                atakplugin.UASTool.btq r8 = atakplugin.UASTool.btq.this     // Catch:{ all -> 0x00ab }
                java.lang.String r8 = r8.f3745o     // Catch:{ all -> 0x00ab }
                r9 = 0
                r4[r9] = r8     // Catch:{ all -> 0x00ab }
                r6.<init>(r10, r7, r4)     // Catch:{ all -> 0x00ab }
                r1.execute(r6)     // Catch:{ all -> 0x00ab }
                monitor-exit(r0)     // Catch:{ all -> 0x00ab }
                if (r5 == 0) goto L_0x00aa
                int r0 = (r11 > r2 ? 1 : (r11 == r2 ? 0 : -1))
                if (r0 == 0) goto L_0x00aa
                int r0 = r5.length
            L_0x009b:
                if (r9 >= r0) goto L_0x00aa
                r1 = r5[r9]
                monitor-enter(r1)
                r1.mo3594a((long) r11)     // Catch:{ all -> 0x00a7 }
                monitor-exit(r1)     // Catch:{ all -> 0x00a7 }
                int r9 = r9 + 1
                goto L_0x009b
            L_0x00a7:
                r11 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x00a7 }
                throw r11
            L_0x00aa:
                return
            L_0x00ab:
                r11 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x00ab }
                throw r11
            */
            throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.btq.C0244c.mo3505a(boolean, atakplugin.UASTool.bup):void");
        }

        /* renamed from: a */
        private void m9431a(bup bup) {
            btq.f3731l.execute(new bub(this, "OkHttp %s ACK Settings", new Object[]{btq.this.f3745o}, bup));
        }

        /* renamed from: a */
        public void mo3503a(boolean z, int i, int i2) {
            if (z) {
                bum c = btq.this.m9385c(i);
                if (c != null) {
                    c.mo3648b();
                    return;
                }
                return;
            }
            btq.this.m9375a(true, i, i2, (bum) null);
        }

        /* renamed from: a */
        public void mo3501a(int i, btn btn, bwq bwq) {
            buc[] bucArr;
            bwq.mo3951n();
            synchronized (btq.this) {
                bucArr = (buc[]) btq.this.f3744n.values().toArray(new buc[btq.this.f3744n.size()]);
                boolean unused = btq.this.f3748r = true;
            }
            for (buc buc : bucArr) {
                if (buc.mo3593a() > i && buc.mo3602c()) {
                    buc.mo3601c(btn.REFUSED_STREAM);
                    btq.this.mo3534b(buc.mo3593a());
                }
            }
        }

        /* renamed from: a */
        public void mo3499a(int i, long j) {
            if (i == 0) {
                synchronized (btq.this) {
                    btq.this.f3736d += j;
                    btq.this.notifyAll();
                }
                return;
            }
            buc a = btq.this.mo3522a(i);
            if (a != null) {
                synchronized (a) {
                    a.mo3594a(j);
                }
            }
        }

        /* renamed from: a */
        public void mo3498a(int i, int i2, List<bue> list) {
            btq.this.m9367a(i2, list);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public boolean m9389d(int i) {
        return this.f3733a == bry.HTTP_2 && i != 0 && (i & 1) == 0;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m9367a(int i, List<bue> list) {
        synchronized (this) {
            if (this.f3754y.contains(Integer.valueOf(i))) {
                mo3526a(i, btn.PROTOCOL_ERROR);
                return;
            }
            this.f3754y.add(Integer.valueOf(i));
            this.f3749s.execute(new btu(this, "OkHttp %s Push Request[%s]", new Object[]{this.f3745o, Integer.valueOf(i)}, i, list));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m9379b(int i, List<bue> list, boolean z) {
        this.f3749s.execute(new btv(this, "OkHttp %s Push Headers[%s]", new Object[]{this.f3745o, Integer.valueOf(i)}, i, list, z));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m9366a(int i, bwp bwp, int i2, boolean z) {
        bwl bwl = new bwl();
        long j = (long) i2;
        bwp.mo3821b(j);
        bwp.mo3425a(bwl, j);
        if (bwl.mo3783a() == j) {
            this.f3749s.execute(new btw(this, "OkHttp %s Push Data[%s]", new Object[]{this.f3745o, Integer.valueOf(i)}, i, bwl, i2, z));
            return;
        }
        throw new IOException(bwl.mo3783a() + " != " + i2);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m9387c(int i, btn btn) {
        this.f3749s.execute(new btx(this, "OkHttp %s Push Reset[%s]", new Object[]{this.f3745o, Integer.valueOf(i)}, i, btn));
    }
}
