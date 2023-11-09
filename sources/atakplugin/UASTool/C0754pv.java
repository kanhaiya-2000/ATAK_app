package atakplugin.UASTool;

import java.util.List;

/* renamed from: atakplugin.UASTool.pv */
public class C0754pv extends C1003wo {

    /* renamed from: a */
    public static final String f5747a = "trak";

    /* renamed from: b */
    private C0739pk f5748b;

    public C0754pv() {
        super(f5747a);
    }

    /* renamed from: a */
    public C0755pw mo5377a() {
        for (C0688nt next : mo36c()) {
            if (next instanceof C0755pw) {
                return (C0755pw) next;
            }
        }
        return null;
    }

    /* renamed from: b */
    public C0739pk mo5378b() {
        C0721ov a;
        C0739pk pkVar = this.f5748b;
        if (pkVar != null) {
            return pkVar;
        }
        C0719ot d = mo5379d();
        if (d == null || (a = d.mo5225a()) == null) {
            return null;
        }
        C0739pk a2 = a.mo5237a();
        this.f5748b = a2;
        return a2;
    }

    /* renamed from: d */
    public C0719ot mo5379d() {
        for (C0688nt next : mo36c()) {
            if (next instanceof C0719ot) {
                return (C0719ot) next;
            }
        }
        return null;
    }

    /* renamed from: a */
    public void mo172a(List<C0688nt> list) {
        super.mo172a(list);
        this.f5748b = null;
    }
}
