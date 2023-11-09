package atakplugin.UASTool;

class aim extends aif {

    /* renamed from: a */
    private String f1425a = "KILL";

    aim() {
    }

    /* renamed from: a */
    public void mo1022a(String str) {
        this.f1425a = str;
    }

    /* renamed from: a */
    public void mo1014a(air air, afy afy) {
        super.mo1014a(air, afy);
        afx afx = new afx();
        ahy ahy = new ahy(afx);
        ahy.mo996a();
        afx.mo618a((byte) 98);
        afx.mo619a(afy.mo648a());
        afx.mo627b(aji.m1820c("signal"));
        afx.mo618a(mo1016a() ? (byte) 1 : 0);
        afx.mo627b(aji.m1820c(this.f1425a));
        mo1013a(ahy);
    }
}
