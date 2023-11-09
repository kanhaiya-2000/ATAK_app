package atakplugin.UASTool;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0006\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0000X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00048\u0000X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00048\u0000X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\u00048\u0000X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\u00048\u0000X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\u00048\u0000X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, mo1538e = {"Lkotlin/math/Constants;", "", "()V", "LN2", "", "epsilon", "taylor_2_bound", "taylor_n_bound", "upper_taylor_2_bound", "upper_taylor_n_bound", "kotlin-stdlib"})
final class bhi {

    /* renamed from: a */
    public static final double f2687a = Math.log(2.0d);

    /* renamed from: b */
    public static final double f2688b;

    /* renamed from: c */
    public static final double f2689c;

    /* renamed from: d */
    public static final double f2690d;

    /* renamed from: e */
    public static final double f2691e;

    /* renamed from: f */
    public static final double f2692f;

    /* renamed from: g */
    public static final bhi f2693g = new bhi();

    static {
        double ulp = Math.ulp(1.0d);
        f2688b = ulp;
        double sqrt = Math.sqrt(ulp);
        f2689c = sqrt;
        double sqrt2 = Math.sqrt(sqrt);
        f2690d = sqrt2;
        double d = (double) 1;
        f2691e = d / sqrt;
        f2692f = d / sqrt2;
    }

    private bhi() {
    }
}
