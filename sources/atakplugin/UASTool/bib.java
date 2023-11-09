package atakplugin.UASTool;

import java.util.Random;

@aot(mo1534a = 2, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\t\u0010\u0000\u001a\u00020\u0001H\b\u001a\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0000\u001a\f\u0010\u0007\u001a\u00020\b*\u00020\u0001H\u0007\u001a\f\u0010\t\u001a\u00020\u0001*\u00020\bH\u0007¨\u0006\n"}, mo1538e = {"defaultPlatformRandom", "Lkotlin/random/Random;", "doubleFromParts", "", "hi26", "", "low27", "asJavaRandom", "Ljava/util/Random;", "asKotlinRandom", "kotlin-stdlib"})
public final class bib {
    /* renamed from: a */
    public static final double m6937a(int i, int i2) {
        return ((double) ((((long) i) << 27) + ((long) i2))) / ((double) 9007199254740992L);
    }

    /* renamed from: a */
    public static final Random m6940a(bic bic) {
        Random a;
        bfq.m6567f(bic, "$this$asJavaRandom");
        bhw bhw = (bhw) (!(bic instanceof bhw) ? null : bic);
        return (bhw == null || (a = bhw.mo2526a()) == null) ? new bhz(bic) : a;
    }

    /* renamed from: a */
    public static final bic m6939a(Random random) {
        bic a;
        bfq.m6567f(random, "$this$asKotlinRandom");
        bhz bhz = (bhz) (!(random instanceof bhz) ? null : random);
        return (bhz == null || (a = bhz.mo2536a()) == null) ? new bia(random) : a;
    }

    /* renamed from: a */
    private static final bic m6938a() {
        return bbg.f2499a.mo2236a();
    }
}
