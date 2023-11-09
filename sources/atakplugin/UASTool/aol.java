package atakplugin.UASTool;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0017B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\u0011\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0000H\u0002J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u000e\u001a\u0004\u0018\u00010\u0011H\u0002J\b\u0010\u0012\u001a\u00020\u0003H\u0016J\u0016\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003J\u001e\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003J\b\u0010\u0014\u001a\u00020\u0015H\u0016J \u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u000e\u0010\f\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, mo1538e = {"Lkotlin/KotlinVersion;", "", "major", "", "minor", "(II)V", "patch", "(III)V", "getMajor", "()I", "getMinor", "getPatch", "version", "compareTo", "other", "equals", "", "", "hashCode", "isAtLeast", "toString", "", "versionOf", "Companion", "kotlin-stdlib"})
public final class aol implements Comparable<aol> {

    /* renamed from: a */
    public static final int f2112a = 255;

    /* renamed from: b */
    public static final aol f2113b = new aol(1, 3, 61);

    /* renamed from: c */
    public static final C0079a f2114c = new C0079a((bfd) null);

    /* renamed from: d */
    private final int f2115d;

    /* renamed from: e */
    private final int f2116e;

    /* renamed from: f */
    private final int f2117f;

    /* renamed from: g */
    private final int f2118g;

    public aol(int i, int i2, int i3) {
        this.f2116e = i;
        this.f2117f = i2;
        this.f2118g = i3;
        this.f2115d = m2480b(i, i2, i3);
    }

    /* renamed from: a */
    public final int mo1524a() {
        return this.f2116e;
    }

    /* renamed from: b */
    public final int mo1528b() {
        return this.f2117f;
    }

    /* renamed from: c */
    public final int mo1529c() {
        return this.f2118g;
    }

    public aol(int i, int i2) {
        this(i, i2, 0);
    }

    /* renamed from: b */
    private final int m2480b(int i, int i2, int i3) {
        if (i >= 0 && 255 >= i && i2 >= 0 && 255 >= i2 && i3 >= 0 && 255 >= i3) {
            return (i << 16) + (i2 << 8) + i3;
        }
        throw new IllegalArgumentException(("Version components are out of range: " + i + '.' + i2 + '.' + i3).toString());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f2116e);
        sb.append('.');
        sb.append(this.f2117f);
        sb.append('.');
        sb.append(this.f2118g);
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof aol)) {
            obj = null;
        }
        aol aol = (aol) obj;
        if (aol == null || this.f2115d != aol.f2115d) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.f2115d;
    }

    /* renamed from: a */
    public int compareTo(aol aol) {
        bfq.m6567f(aol, "other");
        return this.f2115d - aol.f2115d;
    }

    /* renamed from: a */
    public final boolean mo1526a(int i, int i2) {
        int i3 = this.f2116e;
        return i3 > i || (i3 == i && this.f2117f >= i2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0006, code lost:
        r2 = r1.f2117f;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean mo1527a(int r2, int r3, int r4) {
        /*
            r1 = this;
            int r0 = r1.f2116e
            if (r0 > r2) goto L_0x0013
            if (r0 != r2) goto L_0x0011
            int r2 = r1.f2117f
            if (r2 > r3) goto L_0x0013
            if (r2 != r3) goto L_0x0011
            int r2 = r1.f2118g
            if (r2 < r4) goto L_0x0011
            goto L_0x0013
        L_0x0011:
            r2 = 0
            goto L_0x0014
        L_0x0013:
            r2 = 1
        L_0x0014:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.aol.mo1527a(int, int, int):boolean");
    }

    @aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, mo1538e = {"Lkotlin/KotlinVersion$Companion;", "", "()V", "CURRENT", "Lkotlin/KotlinVersion;", "MAX_COMPONENT_VALUE", "", "kotlin-stdlib"})
    /* renamed from: atakplugin.UASTool.aol$a */
    public static final class C0079a {
        private C0079a() {
        }

        public /* synthetic */ C0079a(bfd bfd) {
            this();
        }
    }
}
