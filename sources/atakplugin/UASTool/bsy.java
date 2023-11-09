package atakplugin.UASTool;

import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.Flushable;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

public final class bsy implements Closeable, Flushable {
    /* access modifiers changed from: private */

    /* renamed from: G */
    public static final bxp f3610G = new btc();

    /* renamed from: a */
    static final String f3611a = "journal";

    /* renamed from: b */
    static final String f3612b = "journal.tmp";

    /* renamed from: c */
    static final String f3613c = "journal.bkp";

    /* renamed from: d */
    static final String f3614d = "libcore.io.DiskLruCache";

    /* renamed from: e */
    static final String f3615e = "1";

    /* renamed from: f */
    static final long f3616f = -1;

    /* renamed from: g */
    static final Pattern f3617g = Pattern.compile("[a-z0-9_-]{1,120}");

    /* renamed from: h */
    static final /* synthetic */ boolean f3618h = true;

    /* renamed from: i */
    private static final String f3619i = "CLEAN";

    /* renamed from: j */
    private static final String f3620j = "DIRTY";

    /* renamed from: k */
    private static final String f3621k = "REMOVE";

    /* renamed from: l */
    private static final String f3622l = "READ";
    /* access modifiers changed from: private */

    /* renamed from: A */
    public boolean f3623A;
    /* access modifiers changed from: private */

    /* renamed from: B */
    public boolean f3624B;
    /* access modifiers changed from: private */

    /* renamed from: C */
    public boolean f3625C;

    /* renamed from: D */
    private long f3626D = 0;

    /* renamed from: E */
    private final Executor f3627E;

    /* renamed from: F */
    private final Runnable f3628F = new bsz(this);
    /* access modifiers changed from: private */

    /* renamed from: m */
    public final bvj f3629m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public final File f3630n;

    /* renamed from: o */
    private final File f3631o;

    /* renamed from: p */
    private final File f3632p;

    /* renamed from: q */
    private final File f3633q;

    /* renamed from: r */
    private final int f3634r;

    /* renamed from: s */
    private long f3635s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public final int f3636t;

    /* renamed from: u */
    private long f3637u = 0;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public bwo f3638v;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public final LinkedHashMap<String, C0238b> f3639w = new LinkedHashMap<>(0, 0.75f, true);
    /* access modifiers changed from: private */

    /* renamed from: x */
    public int f3640x;
    /* access modifiers changed from: private */

    /* renamed from: y */
    public boolean f3641y;
    /* access modifiers changed from: private */

    /* renamed from: z */
    public boolean f3642z;

    bsy(bvj bvj, File file, int i, int i2, long j, Executor executor) {
        this.f3629m = bvj;
        this.f3630n = file;
        this.f3634r = i;
        this.f3631o = new File(file, f3611a);
        this.f3632p = new File(file, f3612b);
        this.f3633q = new File(file, f3613c);
        this.f3636t = i2;
        this.f3635s = j;
        this.f3627E = executor;
    }

    /* renamed from: a */
    public synchronized void mo3429a() {
        if (!f3618h) {
            if (!Thread.holdsLock(this)) {
                throw new AssertionError();
            }
        }
        if (!this.f3642z) {
            if (this.f3629m.mo3715e(this.f3633q)) {
                if (this.f3629m.mo3715e(this.f3631o)) {
                    this.f3629m.mo3714d(this.f3633q);
                } else {
                    this.f3629m.mo3711a(this.f3633q, this.f3631o);
                }
            }
            if (this.f3629m.mo3715e(this.f3631o)) {
                try {
                    m9221j();
                    m9223l();
                    this.f3642z = true;
                    return;
                } catch (IOException e) {
                    bvp b = bvp.m9870b();
                    b.mo3721a(5, "DiskLruCache " + this.f3630n + " is corrupt: " + e.getMessage() + ", removing", (Throwable) e);
                    mo3438f();
                    this.f3623A = false;
                }
            }
            m9224m();
            this.f3642z = true;
        }
    }

    /* renamed from: a */
    public static bsy m9200a(bvj bvj, File file, int i, int i2, long j) {
        if (j <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        } else if (i2 > 0) {
            return new bsy(bvj, file, i, i2, j, new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), bsp.m9156a("OkHttp DiskLruCache", true)));
        } else {
            throw new IllegalArgumentException("valueCount <= 0");
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:16|17|(1:19)(1:20)|21|22) */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        r9.f3640x = r0 - r9.f3639w.size();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x006a, code lost:
        if (r1.mo3854i() == false) goto L_0x006c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x006c, code lost:
        m9224m();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0070, code lost:
        r9.f3638v = m9222k();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0079, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x005d */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:23:0x007a=Splitter:B:23:0x007a, B:16:0x005d=Splitter:B:16:0x005d} */
    /* renamed from: j */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m9221j() {
        /*
            r9 = this;
            java.lang.String r0 = ", "
            atakplugin.UASTool.bvj r1 = r9.f3629m
            java.io.File r2 = r9.f3631o
            atakplugin.UASTool.bxr r1 = r1.mo3710a(r2)
            atakplugin.UASTool.bwp r1 = atakplugin.UASTool.bxb.m10330a((atakplugin.UASTool.bxr) r1)
            java.lang.String r2 = r1.mo3890y()     // Catch:{ all -> 0x00a8 }
            java.lang.String r3 = r1.mo3890y()     // Catch:{ all -> 0x00a8 }
            java.lang.String r4 = r1.mo3890y()     // Catch:{ all -> 0x00a8 }
            java.lang.String r5 = r1.mo3890y()     // Catch:{ all -> 0x00a8 }
            java.lang.String r6 = r1.mo3890y()     // Catch:{ all -> 0x00a8 }
            java.lang.String r7 = "libcore.io.DiskLruCache"
            boolean r7 = r7.equals(r2)     // Catch:{ all -> 0x00a8 }
            if (r7 == 0) goto L_0x007a
            java.lang.String r7 = "1"
            boolean r7 = r7.equals(r3)     // Catch:{ all -> 0x00a8 }
            if (r7 == 0) goto L_0x007a
            int r7 = r9.f3634r     // Catch:{ all -> 0x00a8 }
            java.lang.String r7 = java.lang.Integer.toString(r7)     // Catch:{ all -> 0x00a8 }
            boolean r4 = r7.equals(r4)     // Catch:{ all -> 0x00a8 }
            if (r4 == 0) goto L_0x007a
            int r4 = r9.f3636t     // Catch:{ all -> 0x00a8 }
            java.lang.String r4 = java.lang.Integer.toString(r4)     // Catch:{ all -> 0x00a8 }
            boolean r4 = r4.equals(r5)     // Catch:{ all -> 0x00a8 }
            if (r4 == 0) goto L_0x007a
            java.lang.String r4 = ""
            boolean r4 = r4.equals(r6)     // Catch:{ all -> 0x00a8 }
            if (r4 == 0) goto L_0x007a
            r0 = 0
        L_0x0053:
            java.lang.String r2 = r1.mo3890y()     // Catch:{ EOFException -> 0x005d }
            r9.m9212d((java.lang.String) r2)     // Catch:{ EOFException -> 0x005d }
            int r0 = r0 + 1
            goto L_0x0053
        L_0x005d:
            java.util.LinkedHashMap<java.lang.String, atakplugin.UASTool.bsy$b> r2 = r9.f3639w     // Catch:{ all -> 0x00a8 }
            int r2 = r2.size()     // Catch:{ all -> 0x00a8 }
            int r0 = r0 - r2
            r9.f3640x = r0     // Catch:{ all -> 0x00a8 }
            boolean r0 = r1.mo3854i()     // Catch:{ all -> 0x00a8 }
            if (r0 != 0) goto L_0x0070
            r9.m9224m()     // Catch:{ all -> 0x00a8 }
            goto L_0x0076
        L_0x0070:
            atakplugin.UASTool.bwo r0 = r9.m9222k()     // Catch:{ all -> 0x00a8 }
            r9.f3638v = r0     // Catch:{ all -> 0x00a8 }
        L_0x0076:
            atakplugin.UASTool.bsp.m9158a((java.io.Closeable) r1)
            return
        L_0x007a:
            java.io.IOException r4 = new java.io.IOException     // Catch:{ all -> 0x00a8 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a8 }
            r7.<init>()     // Catch:{ all -> 0x00a8 }
            java.lang.String r8 = "unexpected journal header: ["
            r7.append(r8)     // Catch:{ all -> 0x00a8 }
            r7.append(r2)     // Catch:{ all -> 0x00a8 }
            r7.append(r0)     // Catch:{ all -> 0x00a8 }
            r7.append(r3)     // Catch:{ all -> 0x00a8 }
            r7.append(r0)     // Catch:{ all -> 0x00a8 }
            r7.append(r5)     // Catch:{ all -> 0x00a8 }
            r7.append(r0)     // Catch:{ all -> 0x00a8 }
            r7.append(r6)     // Catch:{ all -> 0x00a8 }
            java.lang.String r0 = "]"
            r7.append(r0)     // Catch:{ all -> 0x00a8 }
            java.lang.String r0 = r7.toString()     // Catch:{ all -> 0x00a8 }
            r4.<init>(r0)     // Catch:{ all -> 0x00a8 }
            throw r4     // Catch:{ all -> 0x00a8 }
        L_0x00a8:
            r0 = move-exception
            atakplugin.UASTool.bsp.m9158a((java.io.Closeable) r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.bsy.m9221j():void");
    }

    /* renamed from: k */
    private bwo m9222k() {
        return bxb.m10329a((bxp) new bta(this, this.f3629m.mo3713c(this.f3631o)));
    }

    /* renamed from: d */
    private void m9212d(String str) {
        String str2;
        int indexOf = str.indexOf(32);
        if (indexOf != -1) {
            int i = indexOf + 1;
            int indexOf2 = str.indexOf(32, i);
            if (indexOf2 == -1) {
                str2 = str.substring(i);
                if (indexOf == 6 && str.startsWith(f3621k)) {
                    this.f3639w.remove(str2);
                    return;
                }
            } else {
                str2 = str.substring(i, indexOf2);
            }
            C0238b bVar = this.f3639w.get(str2);
            if (bVar == null) {
                bVar = new C0238b(this, str2, (bsz) null);
                this.f3639w.put(str2, bVar);
            }
            if (indexOf2 != -1 && indexOf == 5 && str.startsWith(f3619i)) {
                String[] split = str.substring(indexOf2 + 1).split(" ");
                boolean unused = bVar.f3652f = true;
                C0237a unused2 = bVar.f3653g = null;
                bVar.m9252a(split);
            } else if (indexOf2 == -1 && indexOf == 5 && str.startsWith(f3620j)) {
                C0237a unused3 = bVar.f3653g = new C0237a(this, bVar, (bsz) null);
            } else if (indexOf2 != -1 || indexOf != 4 || !str.startsWith(f3622l)) {
                throw new IOException("unexpected journal line: " + str);
            }
        } else {
            throw new IOException("unexpected journal line: " + str);
        }
    }

    /* renamed from: l */
    private void m9223l() {
        this.f3629m.mo3714d(this.f3632p);
        Iterator<C0238b> it = this.f3639w.values().iterator();
        while (it.hasNext()) {
            C0238b next = it.next();
            int i = 0;
            if (next.f3653g == null) {
                while (i < this.f3636t) {
                    this.f3637u += next.f3649c[i];
                    i++;
                }
            } else {
                C0237a unused = next.f3653g = null;
                while (i < this.f3636t) {
                    this.f3629m.mo3714d(next.f3650d[i]);
                    this.f3629m.mo3714d(next.f3651e[i]);
                    i++;
                }
                it.remove();
            }
        }
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: private */
    /* renamed from: m */
    public synchronized void m9224m() {
        bwo bwo = this.f3638v;
        if (bwo != null) {
            bwo.close();
        }
        bwo a = bxb.m10329a(this.f3629m.mo3712b(this.f3632p));
        try {
            a.mo3817b(f3614d).mo3833d(10);
            a.mo3817b(f3615e).mo3833d(10);
            a.mo3875p((long) this.f3634r).mo3833d(10);
            a.mo3875p((long) this.f3636t).mo3833d(10);
            a.mo3833d(10);
            for (C0238b next : this.f3639w.values()) {
                if (next.f3653g != null) {
                    a.mo3817b(f3620j).mo3833d(32);
                    a.mo3817b(next.f3648b);
                    a.mo3833d(10);
                } else {
                    a.mo3817b(f3619i).mo3833d(32);
                    a.mo3817b(next.f3648b);
                    next.mo3449a(a);
                    a.mo3833d(10);
                }
            }
            a.close();
            if (this.f3629m.mo3715e(this.f3631o)) {
                this.f3629m.mo3711a(this.f3631o, this.f3633q);
            }
            this.f3629m.mo3711a(this.f3632p, this.f3631o);
            this.f3629m.mo3714d(this.f3633q);
            this.f3638v = m9222k();
            this.f3641y = false;
            this.f3625C = false;
        } catch (Throwable th) {
            a.close();
            throw th;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004f, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0051, code lost:
        return null;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized atakplugin.UASTool.bsy.C0239c mo3428a(java.lang.String r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            r3.mo3429a()     // Catch:{ all -> 0x0052 }
            r3.m9226o()     // Catch:{ all -> 0x0052 }
            r3.m9215e((java.lang.String) r4)     // Catch:{ all -> 0x0052 }
            java.util.LinkedHashMap<java.lang.String, atakplugin.UASTool.bsy$b> r0 = r3.f3639w     // Catch:{ all -> 0x0052 }
            java.lang.Object r0 = r0.get(r4)     // Catch:{ all -> 0x0052 }
            atakplugin.UASTool.bsy$b r0 = (atakplugin.UASTool.bsy.C0238b) r0     // Catch:{ all -> 0x0052 }
            r1 = 0
            if (r0 == 0) goto L_0x0050
            boolean r2 = r0.f3652f     // Catch:{ all -> 0x0052 }
            if (r2 != 0) goto L_0x001c
            goto L_0x0050
        L_0x001c:
            atakplugin.UASTool.bsy$c r0 = r0.mo3448a()     // Catch:{ all -> 0x0052 }
            if (r0 != 0) goto L_0x0024
            monitor-exit(r3)
            return r1
        L_0x0024:
            int r1 = r3.f3640x     // Catch:{ all -> 0x0052 }
            int r1 = r1 + 1
            r3.f3640x = r1     // Catch:{ all -> 0x0052 }
            atakplugin.UASTool.bwo r1 = r3.f3638v     // Catch:{ all -> 0x0052 }
            java.lang.String r2 = "READ"
            atakplugin.UASTool.bwo r1 = r1.mo3817b((java.lang.String) r2)     // Catch:{ all -> 0x0052 }
            r2 = 32
            atakplugin.UASTool.bwo r1 = r1.mo3833d((int) r2)     // Catch:{ all -> 0x0052 }
            atakplugin.UASTool.bwo r4 = r1.mo3817b((java.lang.String) r4)     // Catch:{ all -> 0x0052 }
            r1 = 10
            r4.mo3833d((int) r1)     // Catch:{ all -> 0x0052 }
            boolean r4 = r3.m9225n()     // Catch:{ all -> 0x0052 }
            if (r4 == 0) goto L_0x004e
            java.util.concurrent.Executor r4 = r3.f3627E     // Catch:{ all -> 0x0052 }
            java.lang.Runnable r1 = r3.f3628F     // Catch:{ all -> 0x0052 }
            r4.execute(r1)     // Catch:{ all -> 0x0052 }
        L_0x004e:
            monitor-exit(r3)
            return r0
        L_0x0050:
            monitor-exit(r3)
            return r1
        L_0x0052:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.bsy.mo3428a(java.lang.String):atakplugin.UASTool.bsy$c");
    }

    /* renamed from: b */
    public C0237a mo3431b(String str) {
        return m9199a(str, -1);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0024, code lost:
        return null;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized atakplugin.UASTool.bsy.C0237a m9199a(java.lang.String r6, long r7) {
        /*
            r5 = this;
            monitor-enter(r5)
            r5.mo3429a()     // Catch:{ all -> 0x0079 }
            r5.m9226o()     // Catch:{ all -> 0x0079 }
            r5.m9215e((java.lang.String) r6)     // Catch:{ all -> 0x0079 }
            java.util.LinkedHashMap<java.lang.String, atakplugin.UASTool.bsy$b> r0 = r5.f3639w     // Catch:{ all -> 0x0079 }
            java.lang.Object r0 = r0.get(r6)     // Catch:{ all -> 0x0079 }
            atakplugin.UASTool.bsy$b r0 = (atakplugin.UASTool.bsy.C0238b) r0     // Catch:{ all -> 0x0079 }
            r1 = -1
            r3 = 0
            int r4 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r4 == 0) goto L_0x0025
            if (r0 == 0) goto L_0x0023
            long r1 = r0.f3654h     // Catch:{ all -> 0x0079 }
            int r4 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r4 == 0) goto L_0x0025
        L_0x0023:
            monitor-exit(r5)
            return r3
        L_0x0025:
            if (r0 == 0) goto L_0x002f
            atakplugin.UASTool.bsy$a r7 = r0.f3653g     // Catch:{ all -> 0x0079 }
            if (r7 == 0) goto L_0x002f
            monitor-exit(r5)
            return r3
        L_0x002f:
            boolean r7 = r5.f3624B     // Catch:{ all -> 0x0079 }
            if (r7 != 0) goto L_0x0070
            boolean r7 = r5.f3625C     // Catch:{ all -> 0x0079 }
            if (r7 == 0) goto L_0x0038
            goto L_0x0070
        L_0x0038:
            atakplugin.UASTool.bwo r7 = r5.f3638v     // Catch:{ all -> 0x0079 }
            java.lang.String r8 = "DIRTY"
            atakplugin.UASTool.bwo r7 = r7.mo3817b((java.lang.String) r8)     // Catch:{ all -> 0x0079 }
            r8 = 32
            atakplugin.UASTool.bwo r7 = r7.mo3833d((int) r8)     // Catch:{ all -> 0x0079 }
            atakplugin.UASTool.bwo r7 = r7.mo3817b((java.lang.String) r6)     // Catch:{ all -> 0x0079 }
            r8 = 10
            r7.mo3833d((int) r8)     // Catch:{ all -> 0x0079 }
            atakplugin.UASTool.bwo r7 = r5.f3638v     // Catch:{ all -> 0x0079 }
            r7.flush()     // Catch:{ all -> 0x0079 }
            boolean r7 = r5.f3641y     // Catch:{ all -> 0x0079 }
            if (r7 == 0) goto L_0x005a
            monitor-exit(r5)
            return r3
        L_0x005a:
            if (r0 != 0) goto L_0x0066
            atakplugin.UASTool.bsy$b r0 = new atakplugin.UASTool.bsy$b     // Catch:{ all -> 0x0079 }
            r0.<init>(r5, r6, r3)     // Catch:{ all -> 0x0079 }
            java.util.LinkedHashMap<java.lang.String, atakplugin.UASTool.bsy$b> r7 = r5.f3639w     // Catch:{ all -> 0x0079 }
            r7.put(r6, r0)     // Catch:{ all -> 0x0079 }
        L_0x0066:
            atakplugin.UASTool.bsy$a r6 = new atakplugin.UASTool.bsy$a     // Catch:{ all -> 0x0079 }
            r6.<init>(r5, r0, r3)     // Catch:{ all -> 0x0079 }
            atakplugin.UASTool.bsy.C0237a unused = r0.f3653g = r6     // Catch:{ all -> 0x0079 }
            monitor-exit(r5)
            return r6
        L_0x0070:
            java.util.concurrent.Executor r6 = r5.f3627E     // Catch:{ all -> 0x0079 }
            java.lang.Runnable r7 = r5.f3628F     // Catch:{ all -> 0x0079 }
            r6.execute(r7)     // Catch:{ all -> 0x0079 }
            monitor-exit(r5)
            return r3
        L_0x0079:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.bsy.m9199a(java.lang.String, long):atakplugin.UASTool.bsy$a");
    }

    /* renamed from: b */
    public File mo3432b() {
        return this.f3630n;
    }

    /* renamed from: c */
    public synchronized long mo3433c() {
        return this.f3635s;
    }

    /* renamed from: a */
    public synchronized void mo3430a(long j) {
        this.f3635s = j;
        if (this.f3642z) {
            this.f3627E.execute(this.f3628F);
        }
    }

    /* renamed from: d */
    public synchronized long mo3436d() {
        mo3429a();
        return this.f3637u;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0111, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void m9202a(atakplugin.UASTool.bsy.C0237a r10, boolean r11) {
        /*
            r9 = this;
            monitor-enter(r9)
            atakplugin.UASTool.bsy$b r0 = r10.f3644b     // Catch:{ all -> 0x0118 }
            atakplugin.UASTool.bsy$a r1 = r0.f3653g     // Catch:{ all -> 0x0118 }
            if (r1 != r10) goto L_0x0112
            r1 = 0
            if (r11 == 0) goto L_0x0051
            boolean r2 = r0.f3652f     // Catch:{ all -> 0x0118 }
            if (r2 != 0) goto L_0x0051
            r2 = 0
        L_0x0015:
            int r3 = r9.f3636t     // Catch:{ all -> 0x0118 }
            if (r2 >= r3) goto L_0x0051
            boolean[] r3 = r10.f3645c     // Catch:{ all -> 0x0118 }
            boolean r3 = r3[r2]     // Catch:{ all -> 0x0118 }
            if (r3 == 0) goto L_0x0037
            atakplugin.UASTool.bvj r3 = r9.f3629m     // Catch:{ all -> 0x0118 }
            java.io.File[] r4 = r0.f3651e     // Catch:{ all -> 0x0118 }
            r4 = r4[r2]     // Catch:{ all -> 0x0118 }
            boolean r3 = r3.mo3715e(r4)     // Catch:{ all -> 0x0118 }
            if (r3 != 0) goto L_0x0034
            r10.mo3446c()     // Catch:{ all -> 0x0118 }
            monitor-exit(r9)
            return
        L_0x0034:
            int r2 = r2 + 1
            goto L_0x0015
        L_0x0037:
            r10.mo3446c()     // Catch:{ all -> 0x0118 }
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0118 }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x0118 }
            r11.<init>()     // Catch:{ all -> 0x0118 }
            java.lang.String r0 = "Newly created entry didn't create value for index "
            r11.append(r0)     // Catch:{ all -> 0x0118 }
            r11.append(r2)     // Catch:{ all -> 0x0118 }
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x0118 }
            r10.<init>(r11)     // Catch:{ all -> 0x0118 }
            throw r10     // Catch:{ all -> 0x0118 }
        L_0x0051:
            int r10 = r9.f3636t     // Catch:{ all -> 0x0118 }
            if (r1 >= r10) goto L_0x0091
            java.io.File[] r10 = r0.f3651e     // Catch:{ all -> 0x0118 }
            r10 = r10[r1]     // Catch:{ all -> 0x0118 }
            if (r11 == 0) goto L_0x0089
            atakplugin.UASTool.bvj r2 = r9.f3629m     // Catch:{ all -> 0x0118 }
            boolean r2 = r2.mo3715e(r10)     // Catch:{ all -> 0x0118 }
            if (r2 == 0) goto L_0x008e
            java.io.File[] r2 = r0.f3650d     // Catch:{ all -> 0x0118 }
            r2 = r2[r1]     // Catch:{ all -> 0x0118 }
            atakplugin.UASTool.bvj r3 = r9.f3629m     // Catch:{ all -> 0x0118 }
            r3.mo3711a(r10, r2)     // Catch:{ all -> 0x0118 }
            long[] r10 = r0.f3649c     // Catch:{ all -> 0x0118 }
            r3 = r10[r1]     // Catch:{ all -> 0x0118 }
            atakplugin.UASTool.bvj r10 = r9.f3629m     // Catch:{ all -> 0x0118 }
            long r5 = r10.mo3716f(r2)     // Catch:{ all -> 0x0118 }
            long[] r10 = r0.f3649c     // Catch:{ all -> 0x0118 }
            r10[r1] = r5     // Catch:{ all -> 0x0118 }
            long r7 = r9.f3637u     // Catch:{ all -> 0x0118 }
            long r7 = r7 - r3
            long r7 = r7 + r5
            r9.f3637u = r7     // Catch:{ all -> 0x0118 }
            goto L_0x008e
        L_0x0089:
            atakplugin.UASTool.bvj r2 = r9.f3629m     // Catch:{ all -> 0x0118 }
            r2.mo3714d(r10)     // Catch:{ all -> 0x0118 }
        L_0x008e:
            int r1 = r1 + 1
            goto L_0x0051
        L_0x0091:
            int r10 = r9.f3640x     // Catch:{ all -> 0x0118 }
            r1 = 1
            int r10 = r10 + r1
            r9.f3640x = r10     // Catch:{ all -> 0x0118 }
            r10 = 0
            atakplugin.UASTool.bsy.C0237a unused = r0.f3653g = r10     // Catch:{ all -> 0x0118 }
            boolean r10 = r0.f3652f     // Catch:{ all -> 0x0118 }
            r10 = r10 | r11
            r2 = 10
            r3 = 32
            if (r10 == 0) goto L_0x00d4
            boolean unused = r0.f3652f = r1     // Catch:{ all -> 0x0118 }
            atakplugin.UASTool.bwo r10 = r9.f3638v     // Catch:{ all -> 0x0118 }
            java.lang.String r1 = "CLEAN"
            atakplugin.UASTool.bwo r10 = r10.mo3817b((java.lang.String) r1)     // Catch:{ all -> 0x0118 }
            r10.mo3833d((int) r3)     // Catch:{ all -> 0x0118 }
            atakplugin.UASTool.bwo r10 = r9.f3638v     // Catch:{ all -> 0x0118 }
            java.lang.String r1 = r0.f3648b     // Catch:{ all -> 0x0118 }
            r10.mo3817b((java.lang.String) r1)     // Catch:{ all -> 0x0118 }
            atakplugin.UASTool.bwo r10 = r9.f3638v     // Catch:{ all -> 0x0118 }
            r0.mo3449a((atakplugin.UASTool.bwo) r10)     // Catch:{ all -> 0x0118 }
            atakplugin.UASTool.bwo r10 = r9.f3638v     // Catch:{ all -> 0x0118 }
            r10.mo3833d((int) r2)     // Catch:{ all -> 0x0118 }
            if (r11 == 0) goto L_0x00f6
            long r10 = r9.f3626D     // Catch:{ all -> 0x0118 }
            r1 = 1
            long r1 = r1 + r10
            r9.f3626D = r1     // Catch:{ all -> 0x0118 }
            long unused = r0.f3654h = r10     // Catch:{ all -> 0x0118 }
            goto L_0x00f6
        L_0x00d4:
            java.util.LinkedHashMap<java.lang.String, atakplugin.UASTool.bsy$b> r10 = r9.f3639w     // Catch:{ all -> 0x0118 }
            java.lang.String r11 = r0.f3648b     // Catch:{ all -> 0x0118 }
            r10.remove(r11)     // Catch:{ all -> 0x0118 }
            atakplugin.UASTool.bwo r10 = r9.f3638v     // Catch:{ all -> 0x0118 }
            java.lang.String r11 = "REMOVE"
            atakplugin.UASTool.bwo r10 = r10.mo3817b((java.lang.String) r11)     // Catch:{ all -> 0x0118 }
            r10.mo3833d((int) r3)     // Catch:{ all -> 0x0118 }
            atakplugin.UASTool.bwo r10 = r9.f3638v     // Catch:{ all -> 0x0118 }
            java.lang.String r11 = r0.f3648b     // Catch:{ all -> 0x0118 }
            r10.mo3817b((java.lang.String) r11)     // Catch:{ all -> 0x0118 }
            atakplugin.UASTool.bwo r10 = r9.f3638v     // Catch:{ all -> 0x0118 }
            r10.mo3833d((int) r2)     // Catch:{ all -> 0x0118 }
        L_0x00f6:
            atakplugin.UASTool.bwo r10 = r9.f3638v     // Catch:{ all -> 0x0118 }
            r10.flush()     // Catch:{ all -> 0x0118 }
            long r10 = r9.f3637u     // Catch:{ all -> 0x0118 }
            long r0 = r9.f3635s     // Catch:{ all -> 0x0118 }
            int r2 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r2 > 0) goto L_0x0109
            boolean r10 = r9.m9225n()     // Catch:{ all -> 0x0118 }
            if (r10 == 0) goto L_0x0110
        L_0x0109:
            java.util.concurrent.Executor r10 = r9.f3627E     // Catch:{ all -> 0x0118 }
            java.lang.Runnable r11 = r9.f3628F     // Catch:{ all -> 0x0118 }
            r10.execute(r11)     // Catch:{ all -> 0x0118 }
        L_0x0110:
            monitor-exit(r9)
            return
        L_0x0112:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0118 }
            r10.<init>()     // Catch:{ all -> 0x0118 }
            throw r10     // Catch:{ all -> 0x0118 }
        L_0x0118:
            r10 = move-exception
            monitor-exit(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.bsy.m9202a(atakplugin.UASTool.bsy$a, boolean):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: n */
    public boolean m9225n() {
        int i = this.f3640x;
        return i >= 2000 && i >= this.f3639w.size();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0028, code lost:
        return r7;
     */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean mo3434c(java.lang.String r7) {
        /*
            r6 = this;
            monitor-enter(r6)
            r6.mo3429a()     // Catch:{ all -> 0x0029 }
            r6.m9226o()     // Catch:{ all -> 0x0029 }
            r6.m9215e((java.lang.String) r7)     // Catch:{ all -> 0x0029 }
            java.util.LinkedHashMap<java.lang.String, atakplugin.UASTool.bsy$b> r0 = r6.f3639w     // Catch:{ all -> 0x0029 }
            java.lang.Object r7 = r0.get(r7)     // Catch:{ all -> 0x0029 }
            atakplugin.UASTool.bsy$b r7 = (atakplugin.UASTool.bsy.C0238b) r7     // Catch:{ all -> 0x0029 }
            r0 = 0
            if (r7 != 0) goto L_0x0017
            monitor-exit(r6)
            return r0
        L_0x0017:
            boolean r7 = r6.m9204a((atakplugin.UASTool.bsy.C0238b) r7)     // Catch:{ all -> 0x0029 }
            if (r7 == 0) goto L_0x0027
            long r1 = r6.f3637u     // Catch:{ all -> 0x0029 }
            long r3 = r6.f3635s     // Catch:{ all -> 0x0029 }
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 > 0) goto L_0x0027
            r6.f3624B = r0     // Catch:{ all -> 0x0029 }
        L_0x0027:
            monitor-exit(r6)
            return r7
        L_0x0029:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.bsy.mo3434c(java.lang.String):boolean");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m9204a(C0238b bVar) {
        if (bVar.f3653g != null) {
            bVar.f3653g.mo3443a();
        }
        for (int i = 0; i < this.f3636t; i++) {
            this.f3629m.mo3714d(bVar.f3650d[i]);
            this.f3637u -= bVar.f3649c[i];
            bVar.f3649c[i] = 0;
        }
        this.f3640x++;
        this.f3638v.mo3817b(f3621k).mo3833d(32).mo3817b(bVar.f3648b).mo3833d(10);
        this.f3639w.remove(bVar.f3648b);
        if (m9225n()) {
            this.f3627E.execute(this.f3628F);
        }
        return true;
    }

    /* renamed from: e */
    public synchronized boolean mo3437e() {
        return this.f3623A;
    }

    /* renamed from: o */
    private synchronized void m9226o() {
        if (mo3437e()) {
            throw new IllegalStateException("cache is closed");
        }
    }

    public synchronized void flush() {
        if (this.f3642z) {
            m9226o();
            m9227p();
            this.f3638v.flush();
        }
    }

    public synchronized void close() {
        if (this.f3642z) {
            if (!this.f3623A) {
                for (C0238b bVar : (C0238b[]) this.f3639w.values().toArray(new C0238b[this.f3639w.size()])) {
                    if (bVar.f3653g != null) {
                        bVar.f3653g.mo3446c();
                    }
                }
                m9227p();
                this.f3638v.close();
                this.f3638v = null;
                this.f3623A = true;
                return;
            }
        }
        this.f3623A = true;
    }

    /* access modifiers changed from: private */
    /* renamed from: p */
    public void m9227p() {
        while (this.f3637u > this.f3635s) {
            m9204a(this.f3639w.values().iterator().next());
        }
        this.f3624B = false;
    }

    /* renamed from: f */
    public void mo3438f() {
        close();
        this.f3629m.mo3717g(this.f3630n);
    }

    /* renamed from: g */
    public synchronized void mo3440g() {
        mo3429a();
        for (C0238b a : (C0238b[]) this.f3639w.values().toArray(new C0238b[this.f3639w.size()])) {
            m9204a(a);
        }
        this.f3624B = false;
    }

    /* renamed from: e */
    private void m9215e(String str) {
        if (!f3617g.matcher(str).matches()) {
            throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
        }
    }

    /* renamed from: h */
    public synchronized Iterator<C0239c> mo3441h() {
        mo3429a();
        return new btb(this);
    }

    /* renamed from: atakplugin.UASTool.bsy$c */
    public final class C0239c implements Closeable {
        /* access modifiers changed from: private */

        /* renamed from: b */
        public final String f3656b;

        /* renamed from: c */
        private final long f3657c;

        /* renamed from: d */
        private final bxr[] f3658d;

        /* renamed from: e */
        private final long[] f3659e;

        /* synthetic */ C0239c(bsy bsy, String str, long j, bxr[] bxrArr, long[] jArr, bsz bsz) {
            this(str, j, bxrArr, jArr);
        }

        private C0239c(String str, long j, bxr[] bxrArr, long[] jArr) {
            this.f3656b = str;
            this.f3657c = j;
            this.f3658d = bxrArr;
            this.f3659e = jArr;
        }

        /* renamed from: a */
        public String mo3451a() {
            return this.f3656b;
        }

        /* renamed from: b */
        public C0237a mo3453b() {
            return bsy.this.m9199a(this.f3656b, this.f3657c);
        }

        /* renamed from: a */
        public bxr mo3450a(int i) {
            return this.f3658d[i];
        }

        /* renamed from: b */
        public long mo3452b(int i) {
            return this.f3659e[i];
        }

        public void close() {
            for (bxr a : this.f3658d) {
                bsp.m9158a((Closeable) a);
            }
        }
    }

    /* renamed from: atakplugin.UASTool.bsy$a */
    public final class C0237a {
        /* access modifiers changed from: private */

        /* renamed from: b */
        public final C0238b f3644b;
        /* access modifiers changed from: private */

        /* renamed from: c */
        public final boolean[] f3645c;

        /* renamed from: d */
        private boolean f3646d;

        /* synthetic */ C0237a(bsy bsy, C0238b bVar, bsz bsz) {
            this(bVar);
        }

        private C0237a(C0238b bVar) {
            this.f3644b = bVar;
            this.f3645c = bVar.f3652f ? null : new boolean[bsy.this.f3636t];
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo3443a() {
            if (this.f3644b.f3653g == this) {
                for (int i = 0; i < bsy.this.f3636t; i++) {
                    try {
                        bsy.this.f3629m.mo3714d(this.f3644b.f3651e[i]);
                    } catch (IOException unused) {
                    }
                }
                C0237a unused2 = this.f3644b.f3653g = null;
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0030, code lost:
            return null;
         */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public atakplugin.UASTool.bxr mo3442a(int r5) {
            /*
                r4 = this;
                atakplugin.UASTool.bsy r0 = atakplugin.UASTool.bsy.this
                monitor-enter(r0)
                boolean r1 = r4.f3646d     // Catch:{ all -> 0x0037 }
                if (r1 != 0) goto L_0x0031
                atakplugin.UASTool.bsy$b r1 = r4.f3644b     // Catch:{ all -> 0x0037 }
                boolean r1 = r1.f3652f     // Catch:{ all -> 0x0037 }
                r2 = 0
                if (r1 == 0) goto L_0x002f
                atakplugin.UASTool.bsy$b r1 = r4.f3644b     // Catch:{ all -> 0x0037 }
                atakplugin.UASTool.bsy$a r1 = r1.f3653g     // Catch:{ all -> 0x0037 }
                if (r1 == r4) goto L_0x0019
                goto L_0x002f
            L_0x0019:
                atakplugin.UASTool.bsy r1 = atakplugin.UASTool.bsy.this     // Catch:{ FileNotFoundException -> 0x002d }
                atakplugin.UASTool.bvj r1 = r1.f3629m     // Catch:{ FileNotFoundException -> 0x002d }
                atakplugin.UASTool.bsy$b r3 = r4.f3644b     // Catch:{ FileNotFoundException -> 0x002d }
                java.io.File[] r3 = r3.f3650d     // Catch:{ FileNotFoundException -> 0x002d }
                r5 = r3[r5]     // Catch:{ FileNotFoundException -> 0x002d }
                atakplugin.UASTool.bxr r5 = r1.mo3710a(r5)     // Catch:{ FileNotFoundException -> 0x002d }
                monitor-exit(r0)     // Catch:{ all -> 0x0037 }
                return r5
            L_0x002d:
                monitor-exit(r0)     // Catch:{ all -> 0x0037 }
                return r2
            L_0x002f:
                monitor-exit(r0)     // Catch:{ all -> 0x0037 }
                return r2
            L_0x0031:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0037 }
                r5.<init>()     // Catch:{ all -> 0x0037 }
                throw r5     // Catch:{ all -> 0x0037 }
            L_0x0037:
                r5 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0037 }
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.bsy.C0237a.mo3442a(int):atakplugin.UASTool.bxr");
        }

        /* renamed from: b */
        public bxp mo3444b(int i) {
            synchronized (bsy.this) {
                if (this.f3646d) {
                    throw new IllegalStateException();
                } else if (this.f3644b.f3653g != this) {
                    bxp i2 = bsy.f3610G;
                    return i2;
                } else {
                    if (!this.f3644b.f3652f) {
                        this.f3645c[i] = true;
                    }
                    try {
                        btd btd = new btd(this, bsy.this.f3629m.mo3712b(this.f3644b.f3651e[i]));
                        return btd;
                    } catch (FileNotFoundException unused) {
                        return bsy.f3610G;
                    }
                }
            }
        }

        /* renamed from: b */
        public void mo3445b() {
            synchronized (bsy.this) {
                if (!this.f3646d) {
                    if (this.f3644b.f3653g == this) {
                        bsy.this.m9202a(this, true);
                    }
                    this.f3646d = true;
                } else {
                    throw new IllegalStateException();
                }
            }
        }

        /* renamed from: c */
        public void mo3446c() {
            synchronized (bsy.this) {
                if (!this.f3646d) {
                    if (this.f3644b.f3653g == this) {
                        bsy.this.m9202a(this, false);
                    }
                    this.f3646d = true;
                } else {
                    throw new IllegalStateException();
                }
            }
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(5:2|3|(2:7|8)|9|10) */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0015 */
        /* renamed from: d */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void mo3447d() {
            /*
                r3 = this;
                atakplugin.UASTool.bsy r0 = atakplugin.UASTool.bsy.this
                monitor-enter(r0)
                boolean r1 = r3.f3646d     // Catch:{ all -> 0x0017 }
                if (r1 != 0) goto L_0x0015
                atakplugin.UASTool.bsy$b r1 = r3.f3644b     // Catch:{ all -> 0x0017 }
                atakplugin.UASTool.bsy$a r1 = r1.f3653g     // Catch:{ all -> 0x0017 }
                if (r1 != r3) goto L_0x0015
                atakplugin.UASTool.bsy r1 = atakplugin.UASTool.bsy.this     // Catch:{ IOException -> 0x0015 }
                r2 = 0
                r1.m9202a((atakplugin.UASTool.bsy.C0237a) r3, (boolean) r2)     // Catch:{ IOException -> 0x0015 }
            L_0x0015:
                monitor-exit(r0)     // Catch:{ all -> 0x0017 }
                return
            L_0x0017:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0017 }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.bsy.C0237a.mo3447d():void");
        }
    }

    /* renamed from: atakplugin.UASTool.bsy$b */
    private final class C0238b {
        /* access modifiers changed from: private */

        /* renamed from: b */
        public final String f3648b;
        /* access modifiers changed from: private */

        /* renamed from: c */
        public final long[] f3649c;
        /* access modifiers changed from: private */

        /* renamed from: d */
        public final File[] f3650d;
        /* access modifiers changed from: private */

        /* renamed from: e */
        public final File[] f3651e;
        /* access modifiers changed from: private */

        /* renamed from: f */
        public boolean f3652f;
        /* access modifiers changed from: private */

        /* renamed from: g */
        public C0237a f3653g;
        /* access modifiers changed from: private */

        /* renamed from: h */
        public long f3654h;

        /* synthetic */ C0238b(bsy bsy, String str, bsz bsz) {
            this(str);
        }

        private C0238b(String str) {
            this.f3648b = str;
            this.f3649c = new long[bsy.this.f3636t];
            this.f3650d = new File[bsy.this.f3636t];
            this.f3651e = new File[bsy.this.f3636t];
            StringBuilder sb = new StringBuilder(str);
            sb.append('.');
            int length = sb.length();
            for (int i = 0; i < bsy.this.f3636t; i++) {
                sb.append(i);
                this.f3650d[i] = new File(bsy.this.f3630n, sb.toString());
                sb.append(".tmp");
                this.f3651e[i] = new File(bsy.this.f3630n, sb.toString());
                sb.setLength(length);
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public void m9252a(String[] strArr) {
            if (strArr.length == bsy.this.f3636t) {
                int i = 0;
                while (i < strArr.length) {
                    try {
                        this.f3649c[i] = Long.parseLong(strArr[i]);
                        i++;
                    } catch (NumberFormatException unused) {
                        throw m9254b(strArr);
                    }
                }
                return;
            }
            throw m9254b(strArr);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo3449a(bwo bwo) {
            for (long p : this.f3649c) {
                bwo.mo3833d(32).mo3875p(p);
            }
        }

        /* renamed from: b */
        private IOException m9254b(String[] strArr) {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public C0239c mo3448a() {
            if (Thread.holdsLock(bsy.this)) {
                bxr[] bxrArr = new bxr[bsy.this.f3636t];
                long[] jArr = (long[]) this.f3649c.clone();
                int i = 0;
                int i2 = 0;
                while (i2 < bsy.this.f3636t) {
                    try {
                        bxrArr[i2] = bsy.this.f3629m.mo3710a(this.f3650d[i2]);
                        i2++;
                    } catch (FileNotFoundException unused) {
                        while (i < bsy.this.f3636t && bxrArr[i] != null) {
                            bsp.m9158a((Closeable) bxrArr[i]);
                            i++;
                        }
                        try {
                            boolean unused2 = bsy.this.m9204a(this);
                            return null;
                        } catch (IOException unused3) {
                            return null;
                        }
                    }
                }
                return new C0239c(bsy.this, this.f3648b, this.f3654h, bxrArr, jArr, (bsz) null);
            }
            throw new AssertionError();
        }
    }
}
