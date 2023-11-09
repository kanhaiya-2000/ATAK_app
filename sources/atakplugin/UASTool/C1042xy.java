package atakplugin.UASTool;

import java.io.File;

/* renamed from: atakplugin.UASTool.xy */
public class C1042xy {
    /* renamed from: a */
    public static C1022xf m14668a(String str) {
        return m14667a((C1007ws) new C1009wu(new File(str)));
    }

    /* renamed from: a */
    public static C1022xf m14667a(C1007ws wsVar) {
        C0678nj njVar = new C0678nj(wsVar);
        C1022xf xfVar = new C1022xf();
        for (C0754pv next : njVar.mo5107b().mo202a(C0754pv.class)) {
            C0743pn pnVar = (C0743pn) aft.m883a((C1003wo) next, "mdia[0]/minf[0]/stbl[0]/stsd[0]/enc.[0]/sinf[0]/schm[0]");
            if (pnVar == null || (!pnVar.mo36c().equals("cenc") && !pnVar.mo36c().equals("cbc1"))) {
                xfVar.mo6161a((C1026xj) new C1023xg(String.valueOf(wsVar.toString()) + "[" + next.mo5377a().mo5394j() + "]", next, new C0678nj[0]));
            } else {
                xfVar.mo6161a((C1026xj) new C1019xd(String.valueOf(wsVar.toString()) + "[" + next.mo5377a().mo5394j() + "]", next, new C0678nj[0]));
            }
        }
        xfVar.mo6160a(njVar.mo5107b().mo5247d().mo5266n());
        return xfVar;
    }
}
