package atakplugin.UASTool;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, mo1538e = {"Lkotlin/reflect/KTypeProjection;", "", "variance", "Lkotlin/reflect/KVariance;", "type", "Lkotlin/reflect/KType;", "(Lkotlin/reflect/KVariance;Lkotlin/reflect/KType;)V", "getType", "()Lkotlin/reflect/KType;", "getVariance", "()Lkotlin/reflect/KVariance;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "kotlin-stdlib"})
public final class bjx {

    /* renamed from: a */
    public static final C0194a f2779a = new C0194a((bfd) null);
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static final bjx f2780d = new bjx((bjy) null, (bjv) null);

    /* renamed from: b */
    private final bjy f2781b;

    /* renamed from: c */
    private final bjv f2782c;

    /* renamed from: a */
    public static /* synthetic */ bjx m7358a(bjx bjx, bjy bjy, bjv bjv, int i, Object obj) {
        if ((i & 1) != 0) {
            bjy = bjx.f2781b;
        }
        if ((i & 2) != 0) {
            bjv = bjx.f2782c;
        }
        return bjx.mo2664a(bjy, bjv);
    }

    /* renamed from: a */
    public final bjx mo2664a(bjy bjy, bjv bjv) {
        return new bjx(bjy, bjv);
    }

    /* renamed from: d */
    public final bjy mo2667d() {
        return this.f2781b;
    }

    /* renamed from: e */
    public final bjv mo2668e() {
        return this.f2782c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof bjx)) {
            return false;
        }
        bjx bjx = (bjx) obj;
        return bfq.m6552a((Object) this.f2781b, (Object) bjx.f2781b) && bfq.m6552a((Object) this.f2782c, (Object) bjx.f2782c);
    }

    public int hashCode() {
        bjy bjy = this.f2781b;
        int i = 0;
        int hashCode = (bjy != null ? bjy.hashCode() : 0) * 31;
        bjv bjv = this.f2782c;
        if (bjv != null) {
            i = bjv.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "KTypeProjection(variance=" + this.f2781b + ", type=" + this.f2782c + ")";
    }

    public bjx(bjy bjy, bjv bjv) {
        this.f2781b = bjy;
        this.f2782c = bjv;
    }

    /* renamed from: a */
    public final bjy mo2665a() {
        return this.f2781b;
    }

    /* renamed from: b */
    public final bjv mo2666b() {
        return this.f2782c;
    }

    @aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\f"}, mo1538e = {"Lkotlin/reflect/KTypeProjection$Companion;", "", "()V", "STAR", "Lkotlin/reflect/KTypeProjection;", "getSTAR", "()Lkotlin/reflect/KTypeProjection;", "contravariant", "type", "Lkotlin/reflect/KType;", "covariant", "invariant", "kotlin-stdlib"})
    /* renamed from: atakplugin.UASTool.bjx$a */
    public static final class C0194a {
        private C0194a() {
        }

        public /* synthetic */ C0194a(bfd bfd) {
            this();
        }

        /* renamed from: a */
        public final bjx mo2672a() {
            return bjx.f2780d;
        }

        /* renamed from: a */
        public final bjx mo2673a(bjv bjv) {
            bfq.m6567f(bjv, "type");
            return new bjx(bjy.INVARIANT, bjv);
        }

        /* renamed from: b */
        public final bjx mo2674b(bjv bjv) {
            bfq.m6567f(bjv, "type");
            return new bjx(bjy.IN, bjv);
        }

        /* renamed from: c */
        public final bjx mo2675c(bjv bjv) {
            bfq.m6567f(bjv, "type");
            return new bjx(bjy.OUT, bjv);
        }
    }
}
