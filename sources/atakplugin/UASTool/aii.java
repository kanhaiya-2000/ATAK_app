package atakplugin.UASTool;

class aii extends aif {

    /* renamed from: a */
    private byte[] f1418a = new byte[0];

    aii(byte[] bArr) {
        this.f1418a = bArr;
    }

    /* renamed from: a */
    public void mo1014a(air air, afy afy) {
        super.mo1014a(air, afy);
        afx afx = new afx();
        ahy ahy = new ahy(afx);
        ahy.mo996a();
        afx.mo618a((byte) 98);
        afx.mo619a(afy.mo648a());
        afx.mo627b(aji.m1820c("exec"));
        afx.mo618a(mo1016a() ? (byte) 1 : 0);
        afx.mo639f(this.f1418a.length + 4);
        afx.mo627b(this.f1418a);
        mo1013a(ahy);
    }
}
