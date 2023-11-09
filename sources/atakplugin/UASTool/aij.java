package atakplugin.UASTool;

class aij extends aif {

    /* renamed from: a */
    private String f1419a = "vt100";

    /* renamed from: b */
    private int f1420b = 80;

    /* renamed from: c */
    private int f1421c = 24;

    /* renamed from: d */
    private int f1422d = 640;

    /* renamed from: e */
    private int f1423e = 480;

    /* renamed from: f */
    private byte[] f1424f = aji.f1621a;

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo1019a(String str) {
    }

    aij() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo1021b(String str) {
        this.f1419a = str;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo1020a(byte[] bArr) {
        this.f1424f = bArr;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo1018a(int i, int i2, int i3, int i4) {
        this.f1420b = i;
        this.f1421c = i2;
        this.f1422d = i3;
        this.f1423e = i4;
    }

    /* renamed from: a */
    public void mo1014a(air air, afy afy) {
        super.mo1014a(air, afy);
        afx afx = new afx();
        ahy ahy = new ahy(afx);
        ahy.mo996a();
        afx.mo618a((byte) 98);
        afx.mo619a(afy.mo648a());
        afx.mo627b(aji.m1820c("pty-req"));
        afx.mo618a(mo1016a() ? (byte) 1 : 0);
        afx.mo627b(aji.m1820c(this.f1419a));
        afx.mo619a(this.f1420b);
        afx.mo619a(this.f1421c);
        afx.mo619a(this.f1422d);
        afx.mo619a(this.f1423e);
        afx.mo627b(this.f1424f);
        mo1013a(ahy);
    }
}
