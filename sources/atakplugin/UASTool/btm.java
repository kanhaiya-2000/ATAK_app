package atakplugin.UASTool;

import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;

public final class btm {

    /* renamed from: a */
    public final bqj f3699a;

    /* renamed from: b */
    private bsl f3700b;

    /* renamed from: c */
    private final bra f3701c;

    /* renamed from: d */
    private final btl f3702d;

    /* renamed from: e */
    private int f3703e;

    /* renamed from: f */
    private bti f3704f;

    /* renamed from: g */
    private boolean f3705g;

    /* renamed from: h */
    private boolean f3706h;

    /* renamed from: i */
    private bvc f3707i;

    public btm(bra bra, bqj bqj) {
        this.f3701c = bra;
        this.f3699a = bqj;
        this.f3702d = new btl(bqj, m9323g());
    }

    /* renamed from: a */
    public bvc mo3484a(brw brw, boolean z) {
        bvc bvc;
        int a = brw.mo3271a();
        int b = brw.mo3272b();
        int c = brw.mo3273c();
        try {
            bti a2 = m9320a(a, b, c, brw.mo3289s(), z);
            if (a2.f3675b != null) {
                bvc = new bux(brw, this, a2.f3675b);
            } else {
                a2.mo3081b().setSoTimeout(b);
                a2.f3677d.timeout().mo3984a((long) b, TimeUnit.MILLISECONDS);
                a2.f3678e.timeout().mo3984a((long) c, TimeUnit.MILLISECONDS);
                bvc = new buv(brw, this, a2.f3677d, a2.f3678e);
            }
            synchronized (this.f3701c) {
                this.f3707i = bvc;
            }
            return bvc;
        } catch (IOException e) {
            throw new btk(e);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0018, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0012, code lost:
        if (r0.mo3471a(r8) != false) goto L_0x0018;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private atakplugin.UASTool.bti m9320a(int r4, int r5, int r6, boolean r7, boolean r8) {
        /*
            r3 = this;
        L_0x0000:
            atakplugin.UASTool.bti r0 = r3.m9319a(r4, r5, r6, r7)
            atakplugin.UASTool.bra r1 = r3.f3701c
            monitor-enter(r1)
            int r2 = r0.f3676c     // Catch:{ all -> 0x0019 }
            if (r2 != 0) goto L_0x000d
            monitor-exit(r1)     // Catch:{ all -> 0x0019 }
            return r0
        L_0x000d:
            monitor-exit(r1)     // Catch:{ all -> 0x0019 }
            boolean r1 = r0.mo3471a((boolean) r8)
            if (r1 != 0) goto L_0x0018
            r3.mo3490d()
            goto L_0x0000
        L_0x0018:
            return r0
        L_0x0019:
            r4 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0019 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.btm.m9320a(int, int, int, boolean, boolean):atakplugin.UASTool.bti");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x002c, code lost:
        if (r1 != null) goto L_0x0041;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x002e, code lost:
        r1 = r8.f3702d.mo3482b();
        r0 = r8.f3701c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0036, code lost:
        monitor-enter(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        r8.f3700b = r1;
        r8.f3703e = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x003c, code lost:
        monitor-exit(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0041, code lost:
        r0 = new atakplugin.UASTool.bti(r1);
        mo3485a(r0);
        r1 = r8.f3701c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x004b, code lost:
        monitor-enter(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
        atakplugin.UASTool.bsn.f3580a.mo3334b(r8.f3701c, r0);
        r8.f3704f = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0057, code lost:
        if (r8.f3706h != false) goto L_0x0074;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0059, code lost:
        monitor-exit(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x005a, code lost:
        r0.mo3468a(r9, r10, r11, r8.f3699a.mo2990f(), r12);
        m9323g().mo3476b(r0.mo3080a());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0073, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x007b, code lost:
        throw new java.io.IOException("Canceled");
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private atakplugin.UASTool.bti m9319a(int r9, int r10, int r11, boolean r12) {
        /*
            r8 = this;
            atakplugin.UASTool.bra r0 = r8.f3701c
            monitor-enter(r0)
            boolean r1 = r8.f3705g     // Catch:{ all -> 0x0097 }
            if (r1 != 0) goto L_0x008f
            atakplugin.UASTool.bvc r1 = r8.f3707i     // Catch:{ all -> 0x0097 }
            if (r1 != 0) goto L_0x0087
            boolean r1 = r8.f3706h     // Catch:{ all -> 0x0097 }
            if (r1 != 0) goto L_0x007f
            atakplugin.UASTool.bti r1 = r8.f3704f     // Catch:{ all -> 0x0097 }
            if (r1 == 0) goto L_0x0019
            boolean r2 = r1.f3681h     // Catch:{ all -> 0x0097 }
            if (r2 != 0) goto L_0x0019
            monitor-exit(r0)     // Catch:{ all -> 0x0097 }
            return r1
        L_0x0019:
            atakplugin.UASTool.bsn r1 = atakplugin.UASTool.bsn.f3580a     // Catch:{ all -> 0x0097 }
            atakplugin.UASTool.bra r2 = r8.f3701c     // Catch:{ all -> 0x0097 }
            atakplugin.UASTool.bqj r3 = r8.f3699a     // Catch:{ all -> 0x0097 }
            atakplugin.UASTool.bti r1 = r1.mo3325a((atakplugin.UASTool.bra) r2, (atakplugin.UASTool.bqj) r3, (atakplugin.UASTool.btm) r8)     // Catch:{ all -> 0x0097 }
            if (r1 == 0) goto L_0x0029
            r8.f3704f = r1     // Catch:{ all -> 0x0097 }
            monitor-exit(r0)     // Catch:{ all -> 0x0097 }
            return r1
        L_0x0029:
            atakplugin.UASTool.bsl r1 = r8.f3700b     // Catch:{ all -> 0x0097 }
            monitor-exit(r0)     // Catch:{ all -> 0x0097 }
            if (r1 != 0) goto L_0x0041
            atakplugin.UASTool.btl r0 = r8.f3702d
            atakplugin.UASTool.bsl r1 = r0.mo3482b()
            atakplugin.UASTool.bra r0 = r8.f3701c
            monitor-enter(r0)
            r8.f3700b = r1     // Catch:{ all -> 0x003e }
            r2 = 0
            r8.f3703e = r2     // Catch:{ all -> 0x003e }
            monitor-exit(r0)     // Catch:{ all -> 0x003e }
            goto L_0x0041
        L_0x003e:
            r9 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x003e }
            throw r9
        L_0x0041:
            atakplugin.UASTool.bti r0 = new atakplugin.UASTool.bti
            r0.<init>(r1)
            r8.mo3485a((atakplugin.UASTool.bti) r0)
            atakplugin.UASTool.bra r1 = r8.f3701c
            monitor-enter(r1)
            atakplugin.UASTool.bsn r2 = atakplugin.UASTool.bsn.f3580a     // Catch:{ all -> 0x007c }
            atakplugin.UASTool.bra r3 = r8.f3701c     // Catch:{ all -> 0x007c }
            r2.mo3334b(r3, r0)     // Catch:{ all -> 0x007c }
            r8.f3704f = r0     // Catch:{ all -> 0x007c }
            boolean r2 = r8.f3706h     // Catch:{ all -> 0x007c }
            if (r2 != 0) goto L_0x0074
            monitor-exit(r1)     // Catch:{ all -> 0x007c }
            atakplugin.UASTool.bqj r1 = r8.f3699a
            java.util.List r6 = r1.mo2990f()
            r2 = r0
            r3 = r9
            r4 = r10
            r5 = r11
            r7 = r12
            r2.mo3468a(r3, r4, r5, r6, r7)
            atakplugin.UASTool.btj r9 = r8.m9323g()
            atakplugin.UASTool.bsl r10 = r0.mo3080a()
            r9.mo3476b(r10)
            return r0
        L_0x0074:
            java.io.IOException r9 = new java.io.IOException     // Catch:{ all -> 0x007c }
            java.lang.String r10 = "Canceled"
            r9.<init>(r10)     // Catch:{ all -> 0x007c }
            throw r9     // Catch:{ all -> 0x007c }
        L_0x007c:
            r9 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x007c }
            throw r9
        L_0x007f:
            java.io.IOException r9 = new java.io.IOException     // Catch:{ all -> 0x0097 }
            java.lang.String r10 = "Canceled"
            r9.<init>(r10)     // Catch:{ all -> 0x0097 }
            throw r9     // Catch:{ all -> 0x0097 }
        L_0x0087:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0097 }
            java.lang.String r10 = "stream != null"
            r9.<init>(r10)     // Catch:{ all -> 0x0097 }
            throw r9     // Catch:{ all -> 0x0097 }
        L_0x008f:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0097 }
            java.lang.String r10 = "released"
            r9.<init>(r10)     // Catch:{ all -> 0x0097 }
            throw r9     // Catch:{ all -> 0x0097 }
        L_0x0097:
            r9 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0097 }
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.btm.m9319a(int, int, int, boolean):atakplugin.UASTool.bti");
    }

    /* renamed from: a */
    public void mo3487a(boolean z, bvc bvc) {
        synchronized (this.f3701c) {
            if (bvc != null) {
                if (bvc == this.f3707i) {
                    if (!z) {
                        this.f3704f.f3676c++;
                    }
                }
            }
            throw new IllegalStateException("expected " + this.f3707i + " but was " + bvc);
        }
        m9321a(z, false, true);
    }

    /* renamed from: a */
    public bvc mo3483a() {
        bvc bvc;
        synchronized (this.f3701c) {
            bvc = this.f3707i;
        }
        return bvc;
    }

    /* renamed from: g */
    private btj m9323g() {
        return bsn.f3580a.mo3326a(this.f3701c);
    }

    /* renamed from: b */
    public synchronized bti mo3488b() {
        return this.f3704f;
    }

    /* renamed from: c */
    public void mo3489c() {
        m9321a(false, true, false);
    }

    /* renamed from: d */
    public void mo3490d() {
        m9321a(true, false, false);
    }

    /* renamed from: a */
    private void m9321a(boolean z, boolean z2, boolean z3) {
        bti bti;
        bti bti2;
        synchronized (this.f3701c) {
            bti = null;
            if (z3) {
                try {
                    this.f3707i = null;
                } catch (Throwable th) {
                    while (true) {
                        throw th;
                    }
                }
            }
            if (z2) {
                this.f3705g = true;
            }
            bti bti3 = this.f3704f;
            if (bti3 != null) {
                if (z) {
                    bti3.f3681h = true;
                }
                if (this.f3707i == null && (this.f3705g || this.f3704f.f3681h)) {
                    m9322b(this.f3704f);
                    if (this.f3704f.f3680g.isEmpty()) {
                        this.f3704f.f3682i = System.nanoTime();
                        if (bsn.f3580a.mo3332a(this.f3701c, this.f3704f)) {
                            bti2 = this.f3704f;
                            this.f3704f = null;
                            bti = bti2;
                        }
                    }
                    bti2 = null;
                    this.f3704f = null;
                    bti = bti2;
                }
            }
        }
        if (bti != null) {
            bsp.m9161a(bti.mo3081b());
        }
    }

    /* renamed from: e */
    public void mo3491e() {
        bvc bvc;
        bti bti;
        synchronized (this.f3701c) {
            this.f3706h = true;
            bvc = this.f3707i;
            bti = this.f3704f;
        }
        if (bvc != null) {
            bvc.mo3684a();
        } else if (bti != null) {
            bti.mo3472e();
        }
    }

    /* renamed from: a */
    public void mo3486a(IOException iOException) {
        boolean z;
        synchronized (this.f3701c) {
            if (iOException instanceof bur) {
                bur bur = (bur) iOException;
                if (bur.f3967a == btn.REFUSED_STREAM) {
                    this.f3703e++;
                }
                if (bur.f3967a != btn.REFUSED_STREAM || this.f3703e > 1) {
                    this.f3700b = null;
                }
                z = false;
            } else {
                bti bti = this.f3704f;
                if (bti != null && !bti.mo3473f()) {
                    if (this.f3704f.f3676c == 0) {
                        bsl bsl = this.f3700b;
                        if (!(bsl == null || iOException == null)) {
                            this.f3702d.mo3480a(bsl, iOException);
                        }
                        this.f3700b = null;
                    }
                }
                z = false;
            }
            z = true;
        }
        m9321a(z, false, true);
    }

    /* renamed from: a */
    public void mo3485a(bti bti) {
        bti.f3680g.add(new WeakReference(this));
    }

    /* renamed from: b */
    private void m9322b(bti bti) {
        int size = bti.f3680g.size();
        for (int i = 0; i < size; i++) {
            if (bti.f3680g.get(i).get() == this) {
                bti.f3680g.remove(i);
                return;
            }
        }
        throw new IllegalStateException();
    }

    /* renamed from: f */
    public boolean mo3492f() {
        return this.f3700b != null || this.f3702d.mo3481a();
    }

    public String toString() {
        return this.f3699a.toString();
    }
}
