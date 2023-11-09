package atakplugin.UASTool;

import java.util.Vector;

class aht implements ahf {

    /* renamed from: d */
    private static final String f1361d = "Local Identity Repository";

    /* renamed from: e */
    private Vector f1362e = new Vector();

    /* renamed from: f */
    private ahg f1363f;

    /* renamed from: a */
    public String mo876a() {
        return f1361d;
    }

    /* renamed from: b */
    public int mo878b() {
        return 2;
    }

    aht(ahg ahg) {
        this.f1363f = ahg;
    }

    /* renamed from: c */
    public synchronized Vector mo880c() {
        Vector vector;
        vector = new Vector();
        for (int i = 0; i < this.f1362e.size(); i++) {
            vector.addElement(this.f1362e.elementAt(i));
        }
        return vector;
    }

    /* renamed from: a */
    public synchronized void mo986a(ahd ahd) {
        if (!this.f1362e.contains(ahd)) {
            this.f1362e.addElement(ahd);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0017, code lost:
        return false;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean mo877a(byte[] r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            java.lang.String r0 = "from remote:"
            r1 = 0
            atakplugin.UASTool.ahg r2 = r3.f1363f     // Catch:{ ahj -> 0x0015, all -> 0x0012 }
            atakplugin.UASTool.ahe r4 = atakplugin.UASTool.ahe.m1323a(r0, r4, r1, r2)     // Catch:{ ahj -> 0x0015, all -> 0x0012 }
            java.util.Vector r0 = r3.f1362e     // Catch:{ ahj -> 0x0015, all -> 0x0012 }
            r0.addElement(r4)     // Catch:{ ahj -> 0x0015, all -> 0x0012 }
            r4 = 1
            monitor-exit(r3)
            return r4
        L_0x0012:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        L_0x0015:
            r4 = 0
            monitor-exit(r3)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.aht.mo877a(byte[]):boolean");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public synchronized void mo987b(ahd ahd) {
        this.f1362e.removeElement(ahd);
    }

    /* renamed from: b */
    public synchronized boolean mo879b(byte[] bArr) {
        if (bArr == null) {
            return false;
        }
        for (int i = 0; i < this.f1362e.size(); i++) {
            ahd ahd = (ahd) this.f1362e.elementAt(i);
            byte[] a = ahd.mo868a();
            if (a != null) {
                if (aji.m1815b(bArr, a)) {
                    this.f1362e.removeElement(ahd);
                    ahd.mo874f();
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: d */
    public synchronized void mo881d() {
        for (int i = 0; i < this.f1362e.size(); i++) {
            ((ahd) this.f1362e.elementAt(i)).mo874f();
        }
        this.f1362e.removeAllElements();
    }
}
