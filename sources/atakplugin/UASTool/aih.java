package atakplugin.UASTool;

class aih extends aif {

    /* renamed from: a */
    byte[] f1416a = new byte[0];

    /* renamed from: b */
    byte[] f1417b = new byte[0];

    aih() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo1017a(byte[] bArr, byte[] bArr2) {
        this.f1416a = bArr;
        this.f1417b = bArr2;
    }

    /* renamed from: a */
    public void mo1014a(air air, afy afy) {
        super.mo1014a(air, afy);
        afx afx = new afx();
        ahy ahy = new ahy(afx);
        ahy.mo996a();
        afx.mo618a((byte) 98);
        afx.mo619a(afy.mo648a());
        afx.mo627b(aji.m1820c("env"));
        afx.mo618a(mo1016a() ? (byte) 1 : 0);
        afx.mo627b(this.f1416a);
        afx.mo627b(this.f1417b);
        mo1013a(ahy);
    }
}
