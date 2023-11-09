package atakplugin.UASTool;

class aip extends aif {
    aip() {
    }

    /* renamed from: a */
    public void mo1025a(String str) {
        agl.f1123B = aji.m1820c(str);
    }

    /* renamed from: a */
    public void mo1014a(air air, afy afy) {
        super.mo1014a(air, afy);
        afx afx = new afx();
        ahy ahy = new ahy(afx);
        ahy.mo996a();
        afx.mo618a((byte) 98);
        afx.mo619a(afy.mo648a());
        afx.mo627b(aji.m1820c("x11-req"));
        afx.mo618a(mo1016a() ? (byte) 1 : 0);
        afx.mo618a((byte) 0);
        afx.mo627b(aji.m1820c("MIT-MAGIC-COOKIE-1"));
        afx.mo627b(agl.m1220c(air));
        afx.mo619a(0);
        mo1013a(ahy);
        air.f1465D = true;
    }
}
