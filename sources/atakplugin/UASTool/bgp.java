package atakplugin.UASTool;

import java.util.Arrays;
import java.util.Collections;

public class bgp {

    /* renamed from: a */
    static final String f2670a = " (Kotlin reflection is not available)";

    /* renamed from: b */
    private static final bgq f2671b;

    /* renamed from: c */
    private static final bji[] f2672c = new bji[0];

    static {
        bgq bgq = null;
        try {
            bgq = (bgq) Class.forName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl").newInstance();
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
        }
        if (bgq == null) {
            bgq = new bgq();
        }
        f2671b = bgq;
    }

    /* renamed from: a */
    public static bji m6700a(Class cls) {
        return f2671b.mo2487a(cls);
    }

    /* renamed from: a */
    public static bji m6701a(Class cls, String str) {
        return f2671b.mo2488a(cls, str);
    }

    /* renamed from: b */
    public static bjk m6716b(Class cls, String str) {
        return f2671b.mo2500b(cls, str);
    }

    /* renamed from: b */
    public static bji m6715b(Class cls) {
        return f2671b.mo2499b(cls);
    }

    /* renamed from: c */
    public static bji m6720c(Class cls, String str) {
        return f2671b.mo2501c(cls, str);
    }

    /* renamed from: a */
    public static bji[] m6714a(Class[] clsArr) {
        int length = clsArr.length;
        if (length == 0) {
            return f2672c;
        }
        bji[] bjiArr = new bji[length];
        for (int i = 0; i < length; i++) {
            bjiArr[i] = m6715b(clsArr[i]);
        }
        return bjiArr;
    }

    /* renamed from: a */
    public static String m6713a(bfr bfr) {
        return f2671b.mo2498a(bfr);
    }

    /* renamed from: a */
    public static String m6712a(bfj bfj) {
        return f2671b.mo2497a(bfj);
    }

    /* renamed from: a */
    public static bjl m6702a(bfl bfl) {
        return f2671b.mo2489a(bfl);
    }

    /* renamed from: a */
    public static bjs m6706a(bgi bgi) {
        return f2671b.mo2493a(bgi);
    }

    /* renamed from: a */
    public static bjn m6703a(bfz bfz) {
        return f2671b.mo2490a(bfz);
    }

    /* renamed from: a */
    public static bjt m6707a(bgk bgk) {
        return f2671b.mo2494a(bgk);
    }

    /* renamed from: a */
    public static bjo m6704a(bgb bgb) {
        return f2671b.mo2491a(bgb);
    }

    /* renamed from: a */
    public static bju m6708a(bgm bgm) {
        return f2671b.mo2495a(bgm);
    }

    /* renamed from: a */
    public static bjp m6705a(bgd bgd) {
        return f2671b.mo2492a(bgd);
    }

    /* renamed from: c */
    public static bjv m6721c(Class cls) {
        return f2671b.mo2496a(m6715b(cls), Collections.emptyList(), false);
    }

    /* renamed from: a */
    public static bjv m6709a(Class cls, bjx bjx) {
        return f2671b.mo2496a(m6715b(cls), Collections.singletonList(bjx), false);
    }

    /* renamed from: a */
    public static bjv m6710a(Class cls, bjx bjx, bjx bjx2) {
        return f2671b.mo2496a(m6715b(cls), Arrays.asList(new bjx[]{bjx, bjx2}), false);
    }

    /* renamed from: a */
    public static bjv m6711a(Class cls, bjx... bjxArr) {
        return f2671b.mo2496a(m6715b(cls), arv.m4437t((T[]) bjxArr), false);
    }

    /* renamed from: d */
    public static bjv m6722d(Class cls) {
        return f2671b.mo2496a(m6715b(cls), Collections.emptyList(), true);
    }

    /* renamed from: b */
    public static bjv m6717b(Class cls, bjx bjx) {
        return f2671b.mo2496a(m6715b(cls), Collections.singletonList(bjx), true);
    }

    /* renamed from: b */
    public static bjv m6718b(Class cls, bjx bjx, bjx bjx2) {
        return f2671b.mo2496a(m6715b(cls), Arrays.asList(new bjx[]{bjx, bjx2}), true);
    }

    /* renamed from: b */
    public static bjv m6719b(Class cls, bjx... bjxArr) {
        return f2671b.mo2496a(m6715b(cls), arv.m4437t((T[]) bjxArr), true);
    }
}
