package atakplugin.UASTool;

public class ain extends aif {

    /* renamed from: a */
    private String f1426a = null;

    /* renamed from: a */
    public void mo1023a(air air, afy afy, String str, boolean z) {
        mo1015a(z);
        this.f1426a = str;
        mo1014a(air, afy);
    }

    /* renamed from: a */
    public void mo1014a(air air, afy afy) {
        super.mo1014a(air, afy);
        afx afx = new afx();
        ahy ahy = new ahy(afx);
        ahy.mo996a();
        afx.mo618a((byte) 98);
        afx.mo619a(afy.mo648a());
        afx.mo627b(aji.m1820c("subsystem"));
        afx.mo618a(mo1016a() ? (byte) 1 : 0);
        afx.mo627b(aji.m1820c(this.f1426a));
        mo1013a(ahy);
    }
}
