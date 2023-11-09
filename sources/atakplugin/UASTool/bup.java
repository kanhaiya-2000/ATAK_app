package atakplugin.UASTool;

import java.util.Arrays;

public final class bup {

    /* renamed from: a */
    static final int f3923a = 65536;

    /* renamed from: b */
    static final int f3924b = 1;

    /* renamed from: c */
    static final int f3925c = 1;

    /* renamed from: d */
    static final int f3926d = 2;

    /* renamed from: e */
    static final int f3927e = 1;

    /* renamed from: f */
    static final int f3928f = 1;

    /* renamed from: g */
    static final int f3929g = 2;

    /* renamed from: h */
    static final int f3930h = 2;

    /* renamed from: i */
    static final int f3931i = 3;

    /* renamed from: j */
    static final int f3932j = 4;

    /* renamed from: k */
    static final int f3933k = 5;

    /* renamed from: l */
    static final int f3934l = 5;

    /* renamed from: m */
    static final int f3935m = 6;

    /* renamed from: n */
    static final int f3936n = 6;

    /* renamed from: o */
    static final int f3937o = 7;

    /* renamed from: p */
    static final int f3938p = 8;

    /* renamed from: q */
    static final int f3939q = 10;

    /* renamed from: r */
    static final int f3940r = 10;

    /* renamed from: s */
    static final int f3941s = 1;

    /* renamed from: t */
    private int f3942t;

    /* renamed from: u */
    private int f3943u;

    /* renamed from: v */
    private int f3944v;

    /* renamed from: w */
    private final int[] f3945w = new int[10];

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3656a() {
        this.f3944v = 0;
        this.f3943u = 0;
        this.f3942t = 0;
        Arrays.fill(this.f3945w, 0);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public bup mo3655a(int i, int i2, int i3) {
        int[] iArr = this.f3945w;
        if (i >= iArr.length) {
            return this;
        }
        int i4 = 1 << i;
        this.f3942t |= i4;
        if ((i2 & 1) != 0) {
            this.f3943u |= i4;
        } else {
            this.f3943u &= ~i4;
        }
        if ((i2 & 2) != 0) {
            this.f3944v |= i4;
        } else {
            this.f3944v &= ~i4;
        }
        iArr[i] = i3;
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo3658a(int i) {
        return ((1 << i) & this.f3942t) != 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo3661b(int i) {
        return this.f3945w[i];
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public int mo3663c(int i) {
        int i2 = mo3676o(i) ? 2 : 0;
        return mo3675n(i) ? i2 | 1 : i2;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo3660b() {
        return Integer.bitCount(this.f3942t);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public int mo3664d(int i) {
        return (this.f3942t & 2) != 0 ? this.f3945w[1] : i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public int mo3662c() {
        if ((this.f3942t & 2) != 0) {
            return this.f3945w[1];
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public int mo3666e(int i) {
        return (this.f3942t & 4) != 0 ? this.f3945w[2] : i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo3659a(boolean z) {
        return ((this.f3942t & 4) != 0 ? this.f3945w[2] : z ? 1 : 0) == 1;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public int mo3667f(int i) {
        return (this.f3942t & 8) != 0 ? this.f3945w[3] : i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public int mo3668g(int i) {
        return (this.f3942t & 16) != 0 ? this.f3945w[4] : i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public int mo3669h(int i) {
        return (this.f3942t & 32) != 0 ? this.f3945w[5] : i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public int mo3670i(int i) {
        return (this.f3942t & 32) != 0 ? this.f3945w[5] : i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public int mo3671j(int i) {
        return (this.f3942t & 64) != 0 ? this.f3945w[6] : i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: k */
    public int mo3672k(int i) {
        return (this.f3942t & 64) != 0 ? this.f3945w[6] : i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: l */
    public int mo3673l(int i) {
        return (this.f3942t & 128) != 0 ? this.f3945w[7] : i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: m */
    public int mo3674m(int i) {
        return (this.f3942t & 256) != 0 ? this.f3945w[8] : i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public boolean mo3665d() {
        return (((this.f3942t & 1024) != 0 ? this.f3945w[10] : 0) & 1) != 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: n */
    public boolean mo3675n(int i) {
        return ((1 << i) & this.f3943u) != 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o */
    public boolean mo3676o(int i) {
        return ((1 << i) & this.f3944v) != 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3657a(bup bup) {
        for (int i = 0; i < 10; i++) {
            if (bup.mo3658a(i)) {
                mo3655a(i, bup.mo3663c(i), bup.mo3661b(i));
            }
        }
    }
}
