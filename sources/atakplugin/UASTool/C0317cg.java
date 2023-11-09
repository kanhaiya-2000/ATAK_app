package atakplugin.UASTool;

import java.util.Random;

/* renamed from: atakplugin.UASTool.cg */
public final class C0317cg {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final Random f4638a;

    public C0317cg() {
        this.f4638a = new Random();
    }

    public C0317cg(long j) {
        this.f4638a = new Random(j);
    }

    public C0317cg(Random random) {
        this.f4638a = random;
    }

    /* renamed from: a */
    public Random mo4644a() {
        return this.f4638a;
    }

    /* renamed from: a */
    public C0206bo mo4640a(long j) {
        int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (i < 0) {
            throw new IllegalArgumentException();
        } else if (i == 0) {
            return C0206bo.m7862a();
        } else {
            return mo4645b().mo2887a(j);
        }
    }

    /* renamed from: b */
    public C0245bu mo4646b(long j) {
        int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (i < 0) {
            throw new IllegalArgumentException();
        } else if (i == 0) {
            return C0245bu.m9453a();
        } else {
            return mo4648c().mo3567b(j);
        }
    }

    /* renamed from: c */
    public C0150bg mo4647c(long j) {
        int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (i < 0) {
            throw new IllegalArgumentException();
        } else if (i == 0) {
            return C0150bg.m6604a();
        } else {
            return mo4649d().mo2411a(j);
        }
    }

    /* renamed from: b */
    public C0206bo mo4645b() {
        return C0206bo.m7868a((C0461gf) new C0318ch(this));
    }

    /* renamed from: c */
    public C0245bu mo4648c() {
        return C0245bu.m9459a((C0484gx) new C0319ci(this));
    }

    /* renamed from: d */
    public C0150bg mo4649d() {
        return C0150bg.m6609a((C0383ec) new C0320cj(this));
    }

    /* renamed from: a */
    public C0206bo mo4641a(long j, int i, int i2) {
        int i3 = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (i3 < 0) {
            throw new IllegalArgumentException();
        } else if (i3 == 0) {
            return C0206bo.m7862a();
        } else {
            return mo4639a(i, i2).mo2887a(j);
        }
    }

    /* renamed from: a */
    public C0245bu mo4643a(long j, long j2, long j3) {
        int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (i < 0) {
            throw new IllegalArgumentException();
        } else if (i == 0) {
            return C0245bu.m9453a();
        } else {
            return mo4642a(j2, j3).mo3567b(j);
        }
    }

    /* renamed from: a */
    public C0150bg mo4638a(long j, double d, double d2) {
        int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (i < 0) {
            throw new IllegalArgumentException();
        } else if (i == 0) {
            return C0150bg.m6604a();
        } else {
            return mo4637a(d, d2).mo2411a(j);
        }
    }

    /* renamed from: a */
    public C0206bo mo4639a(int i, int i2) {
        if (i < i2) {
            return C0206bo.m7868a((C0461gf) new C0322ck(this, i2, i));
        }
        throw new IllegalArgumentException();
    }

    /* renamed from: a */
    public C0245bu mo4642a(long j, long j2) {
        if (j < j2) {
            return C0245bu.m9459a((C0484gx) new C0323cl(this, j2, j));
        }
        throw new IllegalArgumentException();
    }

    /* renamed from: a */
    public C0150bg mo4637a(double d, double d2) {
        if (d < d2) {
            return C0150bg.m6609a((C0383ec) new C0324cm(this, d2, d));
        }
        throw new IllegalArgumentException();
    }
}
