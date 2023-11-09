package atakplugin.UASTool;

import java.io.Serializable;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b@\u0018\u0000 \u001e*\u0006\b\u0000\u0010\u0001 \u00012\u00060\u0002j\u0002`\u0003:\u0002\u001e\u001fB\u0016\b\u0001\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\u0010\u001a\u00020\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÖ\u0003J\u000f\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\u0012\u0010\u0016\u001a\u0004\u0018\u00018\u0000H\b¢\u0006\u0004\b\u0017\u0010\u0007J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\u000f\u0010\u001a\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001c\u0010\u001dR\u0011\u0010\b\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0000X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u000e\u0010\u000fø\u0001\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006 "}, mo1538e = {"Lkotlin/Result;", "T", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "value", "", "constructor-impl", "(Ljava/lang/Object;)Ljava/lang/Object;", "isFailure", "", "isFailure-impl", "(Ljava/lang/Object;)Z", "isSuccess", "isSuccess-impl", "value$annotations", "()V", "equals", "other", "exceptionOrNull", "", "exceptionOrNull-impl", "(Ljava/lang/Object;)Ljava/lang/Throwable;", "getOrNull", "getOrNull-impl", "hashCode", "", "toString", "", "toString-impl", "(Ljava/lang/Object;)Ljava/lang/String;", "Companion", "Failure", "kotlin-stdlib"})
public final class apj<T> implements Serializable {

    /* renamed from: a */
    public static final C0082a f2126a = new C0082a((bfd) null);

    /* renamed from: b */
    private final Object f2127b;

    /* renamed from: a */
    public static /* synthetic */ void m2601a() {
    }

    /* renamed from: a */
    public static boolean m2603a(Object obj, Object obj2) {
        return (obj2 instanceof apj) && bfq.m6552a(obj, ((apj) obj2).mo1554b());
    }

    /* renamed from: b */
    public static final boolean m2605b(Object obj, Object obj2) {
        throw null;
    }

    /* renamed from: e */
    public static Object m2608e(Object obj) {
        return obj;
    }

    /* renamed from: f */
    public static final /* synthetic */ apj m2609f(Object obj) {
        return new apj(obj);
    }

    /* renamed from: g */
    public static int m2610g(Object obj) {
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    /* renamed from: b */
    public final /* synthetic */ Object mo1554b() {
        return this.f2127b;
    }

    public boolean equals(Object obj) {
        return m2603a(this.f2127b, obj);
    }

    public int hashCode() {
        return m2610g(this.f2127b);
    }

    public String toString() {
        return m2607d(this.f2127b);
    }

    private /* synthetic */ apj(Object obj) {
        this.f2127b = obj;
    }

    /* renamed from: a */
    public static final boolean m2602a(Object obj) {
        return !(obj instanceof C0083b);
    }

    /* renamed from: b */
    public static final boolean m2604b(Object obj) {
        return obj instanceof C0083b;
    }

    /* renamed from: h */
    private static final T m2611h(Object obj) {
        if (m2604b(obj)) {
            return null;
        }
        return obj;
    }

    /* renamed from: c */
    public static final Throwable m2606c(Object obj) {
        if (obj instanceof C0083b) {
            return ((C0083b) obj).f2128a;
        }
        return null;
    }

    /* renamed from: d */
    public static String m2607d(Object obj) {
        if (obj instanceof C0083b) {
            return obj.toString();
        }
        return "Success(" + obj + ')';
    }

    @aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J%\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0001\u0010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\bø\u0001\u0000¢\u0006\u0002\u0010\bJ%\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0001\u0010\u00052\u0006\u0010\n\u001a\u0002H\u0005H\bø\u0001\u0000¢\u0006\u0002\u0010\u000b\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, mo1538e = {"Lkotlin/Result$Companion;", "", "()V", "failure", "Lkotlin/Result;", "T", "exception", "", "(Ljava/lang/Throwable;)Ljava/lang/Object;", "success", "value", "(Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-stdlib"})
    /* renamed from: atakplugin.UASTool.apj$a */
    public static final class C0082a {
        private C0082a() {
        }

        public /* synthetic */ C0082a(bfd bfd) {
            this();
        }

        /* renamed from: a */
        private final <T> Object m2613a(T t) {
            return apj.m2608e(t);
        }

        /* renamed from: a */
        private final <T> Object m2614a(Throwable th) {
            return apj.m2608e(apk.m2619a(th));
        }
    }

    @aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00060\u0001j\u0002`\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0013\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0002J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0016R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, mo1538e = {"Lkotlin/Result$Failure;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "exception", "", "(Ljava/lang/Throwable;)V", "equals", "", "other", "", "hashCode", "", "toString", "", "kotlin-stdlib"})
    /* renamed from: atakplugin.UASTool.apj$b */
    public static final class C0083b implements Serializable {

        /* renamed from: a */
        public final Throwable f2128a;

        public C0083b(Throwable th) {
            bfq.m6567f(th, "exception");
            this.f2128a = th;
        }

        public boolean equals(Object obj) {
            return (obj instanceof C0083b) && bfq.m6552a((Object) this.f2128a, (Object) ((C0083b) obj).f2128a);
        }

        public int hashCode() {
            return this.f2128a.hashCode();
        }

        public String toString() {
            return "Failure(" + this.f2128a + ')';
        }
    }
}
