package atakplugin.UASTool;

import com.atakmap.android.uastool.MAVLink.enums.MAV_CMD;

/* renamed from: atakplugin.UASTool.vi */
class C0960vi implements Comparable<C0960vi> {

    /* renamed from: a */
    private final int f7424a;

    /* renamed from: b */
    private final int f7425b;

    /* renamed from: c */
    private final int f7426c;

    C0960vi(int i, int i2, int i3) {
        if (i < 0 || i2 < 0 || i3 < 0) {
            throw new IllegalArgumentException("Major, minor and patch versions MUST be non-negative integers.");
        }
        this.f7424a = i;
        this.f7425b = i2;
        this.f7426c = i3;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo6029a() {
        return this.f7424a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo6031b() {
        return this.f7425b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public int mo6032c() {
        return this.f7426c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public C0960vi mo6034d() {
        return new C0960vi(this.f7424a + 1, 0, 0);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public C0960vi mo6035e() {
        return new C0960vi(this.f7424a, this.f7425b + 1, 0);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public C0960vi mo6037f() {
        return new C0960vi(this.f7424a, this.f7425b, this.f7426c + 1);
    }

    /* renamed from: a */
    public int compareTo(C0960vi viVar) {
        int i = this.f7424a - viVar.f7424a;
        if (i != 0) {
            return i;
        }
        int i2 = this.f7425b - viVar.f7425b;
        return i2 == 0 ? this.f7426c - viVar.f7426c : i2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof C0960vi) && compareTo((C0960vi) obj) == 0) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((((MAV_CMD.MAV_CMD_REQUEST_CAMERA_CAPTURE_STATUS + this.f7424a) * 31) + this.f7425b) * 31) + this.f7426c;
    }

    public String toString() {
        return String.format("%d.%d.%d", new Object[]{Integer.valueOf(this.f7424a), Integer.valueOf(this.f7425b), Integer.valueOf(this.f7426c)});
    }
}
