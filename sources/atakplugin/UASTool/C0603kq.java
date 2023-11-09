package atakplugin.UASTool;

import atakplugin.UASTool.C0560jd;

/* renamed from: atakplugin.UASTool.kq */
public class C0603kq extends C0560jd.C0562b {

    /* renamed from: a */
    private final int f5156a;

    /* renamed from: b */
    private int f5157b;

    /* renamed from: c */
    private boolean f5158c;

    public C0603kq(int i, int i2) {
        this.f5156a = i2;
        this.f5157b = i;
        this.f5158c = i <= i2;
    }

    public boolean hasNext() {
        return this.f5158c;
    }

    /* renamed from: a */
    public int mo2940a() {
        int i = this.f5157b;
        int i2 = this.f5156a;
        if (i >= i2) {
            this.f5158c = false;
            return i2;
        }
        this.f5157b = i + 1;
        return i;
    }
}
