package atakplugin.UASTool;

class aio extends aif {

    /* renamed from: a */
    int f1427a = 80;

    /* renamed from: b */
    int f1428b = 24;

    /* renamed from: c */
    int f1429c = 640;

    /* renamed from: d */
    int f1430d = 480;

    aio() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo1024a(int i, int i2, int i3, int i4) {
        this.f1427a = i;
        this.f1428b = i2;
        this.f1429c = i3;
        this.f1430d = i4;
    }

    /* renamed from: a */
    public void mo1014a(air air, afy afy) {
        super.mo1014a(air, afy);
        afx afx = new afx();
        ahy ahy = new ahy(afx);
        ahy.mo996a();
        afx.mo618a((byte) 98);
        afx.mo619a(afy.mo648a());
        afx.mo627b(aji.m1820c("window-change"));
        afx.mo618a(mo1016a() ? (byte) 1 : 0);
        afx.mo619a(this.f1427a);
        afx.mo619a(this.f1428b);
        afx.mo619a(this.f1429c);
        afx.mo619a(this.f1430d);
        mo1013a(ahy);
    }
}
