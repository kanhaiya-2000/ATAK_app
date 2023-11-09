package atakplugin.UASTool;

import java.nio.charset.Charset;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u000e\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u000bR\u0010\u0010\u0010\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, mo1538e = {"Lkotlin/text/Charsets;", "", "()V", "ISO_8859_1", "Ljava/nio/charset/Charset;", "US_ASCII", "UTF_16", "UTF_16BE", "UTF_16LE", "UTF_32", "UTF32", "()Ljava/nio/charset/Charset;", "UTF_32BE", "UTF32_BE", "UTF_32LE", "UTF32_LE", "UTF_8", "utf_32", "utf_32be", "utf_32le", "kotlin-stdlib"})
public final class bnh {

    /* renamed from: a */
    public static final Charset f2996a;

    /* renamed from: b */
    public static final Charset f2997b;

    /* renamed from: c */
    public static final Charset f2998c;

    /* renamed from: d */
    public static final Charset f2999d;

    /* renamed from: e */
    public static final Charset f3000e;

    /* renamed from: f */
    public static final Charset f3001f;

    /* renamed from: g */
    public static final bnh f3002g = new bnh();

    /* renamed from: h */
    private static Charset f3003h;

    /* renamed from: i */
    private static Charset f3004i;

    /* renamed from: j */
    private static Charset f3005j;

    static {
        Charset forName = Charset.forName("UTF-8");
        bfq.m6554b(forName, "Charset.forName(\"UTF-8\")");
        f2996a = forName;
        Charset forName2 = Charset.forName(bxz.f4231c);
        bfq.m6554b(forName2, "Charset.forName(\"UTF-16\")");
        f2997b = forName2;
        Charset forName3 = Charset.forName(bxz.f4232d);
        bfq.m6554b(forName3, "Charset.forName(\"UTF-16BE\")");
        f2998c = forName3;
        Charset forName4 = Charset.forName(bxz.f4233e);
        bfq.m6554b(forName4, "Charset.forName(\"UTF-16LE\")");
        f2999d = forName4;
        Charset forName5 = Charset.forName(bxz.f4230b);
        bfq.m6554b(forName5, "Charset.forName(\"US-ASCII\")");
        f3000e = forName5;
        Charset forName6 = Charset.forName(bxz.f4229a);
        bfq.m6554b(forName6, "Charset.forName(\"ISO-8859-1\")");
        f3001f = forName6;
    }

    private bnh() {
    }

    /* renamed from: a */
    public final Charset mo2818a() {
        Charset charset = f3003h;
        if (charset != null) {
            return charset;
        }
        bnh bnh = this;
        Charset forName = Charset.forName("UTF-32");
        bfq.m6554b(forName, "Charset.forName(\"UTF-32\")");
        f3003h = forName;
        return forName;
    }

    /* renamed from: b */
    public final Charset mo2819b() {
        Charset charset = f3004i;
        if (charset != null) {
            return charset;
        }
        bnh bnh = this;
        Charset forName = Charset.forName("UTF-32LE");
        bfq.m6554b(forName, "Charset.forName(\"UTF-32LE\")");
        f3004i = forName;
        return forName;
    }

    /* renamed from: c */
    public final Charset mo2820c() {
        Charset charset = f3005j;
        if (charset != null) {
            return charset;
        }
        bnh bnh = this;
        Charset forName = Charset.forName("UTF-32BE");
        bfq.m6554b(forName, "Charset.forName(\"UTF-32BE\")");
        f3005j = forName;
        return forName;
    }
}
