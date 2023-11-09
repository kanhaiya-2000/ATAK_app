package atakplugin.UASTool;

import java.util.List;

public class bgq {

    /* renamed from: a */
    private static final String f2673a = "kotlin.jvm.functions.";

    /* renamed from: a */
    public bjl mo2489a(bfl bfl) {
        return bfl;
    }

    /* renamed from: a */
    public bjn mo2490a(bfz bfz) {
        return bfz;
    }

    /* renamed from: a */
    public bjo mo2491a(bgb bgb) {
        return bgb;
    }

    /* renamed from: a */
    public bjp mo2492a(bgd bgd) {
        return bgd;
    }

    /* renamed from: a */
    public bjs mo2493a(bgi bgi) {
        return bgi;
    }

    /* renamed from: a */
    public bjt mo2494a(bgk bgk) {
        return bgk;
    }

    /* renamed from: a */
    public bju mo2495a(bgm bgm) {
        return bgm;
    }

    /* renamed from: a */
    public bji mo2487a(Class cls) {
        return new bfb(cls);
    }

    /* renamed from: a */
    public bji mo2488a(Class cls, String str) {
        return new bfb(cls);
    }

    /* renamed from: b */
    public bjk mo2500b(Class cls, String str) {
        return new bgf(cls, str);
    }

    /* renamed from: b */
    public bji mo2499b(Class cls) {
        return new bfb(cls);
    }

    /* renamed from: c */
    public bji mo2501c(Class cls, String str) {
        return new bfb(cls);
    }

    /* renamed from: a */
    public String mo2498a(bfr bfr) {
        return mo2497a((bfj) bfr);
    }

    /* renamed from: a */
    public String mo2497a(bfj bfj) {
        String obj = bfj.getClass().getGenericInterfaces()[0].toString();
        return obj.startsWith(f2673a) ? obj.substring(21) : obj;
    }

    /* renamed from: a */
    public bjv mo2496a(bjj bjj, List<bjx> list, boolean z) {
        return new bgw(bjj, list, z);
    }
}
