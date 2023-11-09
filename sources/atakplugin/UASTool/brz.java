package atakplugin.UASTool;

import java.io.IOException;
import java.util.ArrayList;

final class brz implements bqt {

    /* renamed from: a */
    bsb f3516a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final brw f3517b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final bvg f3518c;

    /* renamed from: d */
    private boolean f3519d;

    protected brz(brw brw, bsb bsb) {
        this.f3517b = brw;
        this.f3516a = bsb;
        this.f3518c = new bvg(brw);
    }

    /* renamed from: a */
    public bsb mo3054a() {
        return this.f3516a;
    }

    /* renamed from: b */
    public bsh mo3056b() {
        synchronized (this) {
            if (!this.f3519d) {
                this.f3519d = true;
            } else {
                throw new IllegalStateException("Already Executed");
            }
        }
        try {
            this.f3517b.mo3290t().mo3136a(this);
            bsh j = m8996j();
            if (j != null) {
                return j;
            }
            throw new IOException("Canceled");
        } finally {
            this.f3517b.mo3290t().mo3141b(this);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public synchronized void mo3336f() {
        if (!this.f3519d) {
            this.f3518c.mo3704a(true);
        } else {
            throw new IllegalStateException("Already Executed");
        }
    }

    /* renamed from: a */
    public void mo3055a(bqu bqu) {
        synchronized (this) {
            if (!this.f3519d) {
                this.f3519d = true;
            } else {
                throw new IllegalStateException("Already Executed");
            }
        }
        this.f3517b.mo3290t().mo3135a(new C0232a(bqu));
    }

    /* renamed from: c */
    public void mo3057c() {
        this.f3518c.mo3703a();
    }

    /* renamed from: d */
    public synchronized boolean mo3058d() {
        return this.f3519d;
    }

    /* renamed from: e */
    public boolean mo3059e() {
        return this.f3518c.mo3705b();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public btm mo3337g() {
        return this.f3518c.mo3708e();
    }

    /* renamed from: atakplugin.UASTool.brz$a */
    final class C0232a extends bso {

        /* renamed from: c */
        private final bqu f3521c;

        private C0232a(bqu bqu) {
            super("OkHttp %s", brz.this.mo3338h().toString());
            this.f3521c = bqu;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public String mo3339a() {
            return brz.this.f3516a.mo3343a().mo3204i();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public bsb mo3340b() {
            return brz.this.f3516a;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public brz mo3341c() {
            return brz.this;
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Removed duplicated region for block: B:12:0x0034 A[SYNTHETIC, Splitter:B:12:0x0034] */
        /* JADX WARNING: Removed duplicated region for block: B:14:0x0054 A[Catch:{ all -> 0x002d }] */
        /* renamed from: d */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void mo3342d() {
            /*
                r5 = this;
                r0 = 1
                r1 = 0
                atakplugin.UASTool.brz r2 = atakplugin.UASTool.brz.this     // Catch:{ IOException -> 0x002f }
                atakplugin.UASTool.bsh r2 = r2.m8996j()     // Catch:{ IOException -> 0x002f }
                atakplugin.UASTool.brz r3 = atakplugin.UASTool.brz.this     // Catch:{ IOException -> 0x002f }
                atakplugin.UASTool.bvg r3 = r3.f3518c     // Catch:{ IOException -> 0x002f }
                boolean r1 = r3.mo3705b()     // Catch:{ IOException -> 0x002f }
                if (r1 == 0) goto L_0x0023
                atakplugin.UASTool.bqu r1 = r5.f3521c     // Catch:{ IOException -> 0x002b }
                atakplugin.UASTool.brz r2 = atakplugin.UASTool.brz.this     // Catch:{ IOException -> 0x002b }
                java.io.IOException r3 = new java.io.IOException     // Catch:{ IOException -> 0x002b }
                java.lang.String r4 = "Canceled"
                r3.<init>(r4)     // Catch:{ IOException -> 0x002b }
                r1.onFailure(r2, r3)     // Catch:{ IOException -> 0x002b }
                goto L_0x005b
            L_0x0023:
                atakplugin.UASTool.bqu r1 = r5.f3521c     // Catch:{ IOException -> 0x002b }
                atakplugin.UASTool.brz r3 = atakplugin.UASTool.brz.this     // Catch:{ IOException -> 0x002b }
                r1.onResponse(r3, r2)     // Catch:{ IOException -> 0x002b }
                goto L_0x005b
            L_0x002b:
                r1 = move-exception
                goto L_0x0032
            L_0x002d:
                r0 = move-exception
                goto L_0x0069
            L_0x002f:
                r0 = move-exception
                r1 = r0
                r0 = 0
            L_0x0032:
                if (r0 == 0) goto L_0x0054
                atakplugin.UASTool.bvp r0 = atakplugin.UASTool.bvp.m9870b()     // Catch:{ all -> 0x002d }
                r2 = 4
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x002d }
                r3.<init>()     // Catch:{ all -> 0x002d }
                java.lang.String r4 = "Callback failure for "
                r3.append(r4)     // Catch:{ all -> 0x002d }
                atakplugin.UASTool.brz r4 = atakplugin.UASTool.brz.this     // Catch:{ all -> 0x002d }
                java.lang.String r4 = r4.m8995i()     // Catch:{ all -> 0x002d }
                r3.append(r4)     // Catch:{ all -> 0x002d }
                java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x002d }
                r0.mo3721a((int) r2, (java.lang.String) r3, (java.lang.Throwable) r1)     // Catch:{ all -> 0x002d }
                goto L_0x005b
            L_0x0054:
                atakplugin.UASTool.bqu r0 = r5.f3521c     // Catch:{ all -> 0x002d }
                atakplugin.UASTool.brz r2 = atakplugin.UASTool.brz.this     // Catch:{ all -> 0x002d }
                r0.onFailure(r2, r1)     // Catch:{ all -> 0x002d }
            L_0x005b:
                atakplugin.UASTool.brz r0 = atakplugin.UASTool.brz.this
                atakplugin.UASTool.brw r0 = r0.f3517b
                atakplugin.UASTool.brj r0 = r0.mo3290t()
                r0.mo3140b((atakplugin.UASTool.brz.C0232a) r5)
                return
            L_0x0069:
                atakplugin.UASTool.brz r1 = atakplugin.UASTool.brz.this
                atakplugin.UASTool.brw r1 = r1.f3517b
                atakplugin.UASTool.brj r1 = r1.mo3290t()
                r1.mo3140b((atakplugin.UASTool.brz.C0232a) r5)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.brz.C0232a.mo3342d():void");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public String m8995i() {
        String str = this.f3518c.mo3705b() ? "canceled call" : "call";
        return str + " to " + mo3338h();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public brr mo3338h() {
        return this.f3516a.mo3343a().mo3196e("/...");
    }

    /* access modifiers changed from: private */
    /* renamed from: j */
    public bsh m8996j() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f3517b.mo3293w());
        arrayList.add(this.f3518c);
        arrayList.add(new but(this.f3517b.mo3276f()));
        arrayList.add(new bss(this.f3517b.mo3278h()));
        arrayList.add(new btg(this.f3517b));
        if (!this.f3518c.mo3707d()) {
            arrayList.addAll(this.f3517b.mo3294x());
        }
        arrayList.add(new buu(this.f3518c.mo3707d()));
        return new bvd(arrayList, (btm) null, (bvc) null, (bqz) null, 0, this.f3516a).mo3250a(this.f3516a);
    }
}
