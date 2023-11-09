package atakplugin.UASTool;

@aot(mo1534a = 5, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0001\n\u0002\b\u0004\u001a\u001c\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\b\u0002\b\n\u0006\b\u0000\u001a\u0002\u0010\u0001\u001a*\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\b\u0002\b\n\u0006\b\u0000\u001a\u0002\u0010\u0001\u001a/\u0010\u0007\u001a\u0002H\b\"\b\b\u0000\u0010\b*\u00020\u00062\b\u0010\u0002\u001a\u0004\u0018\u0001H\bH\b\u0002\n\n\b\b\u0000\u001a\u0004\b\u0003\u0010\u0001¢\u0006\u0002\u0010\t\u001a=\u0010\u0007\u001a\u0002H\b\"\b\b\u0000\u0010\b*\u00020\u00062\b\u0010\u0002\u001a\u0004\u0018\u0001H\b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\b\u0002\n\n\b\b\u0000\u001a\u0004\b\u0003\u0010\u0001¢\u0006\u0002\u0010\n\u001a\u0011\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0006H\b\u001a\u001c\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\b\u0002\b\n\u0006\b\u0000\u001a\u0002\u0010\u0001\u001a*\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\b\u0002\b\n\u0006\b\u0000\u001a\u0002\u0010\u0001\u001a/\u0010\u000f\u001a\u0002H\b\"\b\b\u0000\u0010\b*\u00020\u00062\b\u0010\u0002\u001a\u0004\u0018\u0001H\bH\b\u0002\n\n\b\b\u0000\u001a\u0004\b\u0003\u0010\u0001¢\u0006\u0002\u0010\t\u001a=\u0010\u000f\u001a\u0002H\b\"\b\b\u0000\u0010\b*\u00020\u00062\b\u0010\u0002\u001a\u0004\u0018\u0001H\b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\b\u0002\n\n\b\b\u0000\u001a\u0004\b\u0003\u0010\u0001¢\u0006\u0002\u0010\n¨\u0006\u0010"}, mo1538e = {"check", "", "value", "", "lazyMessage", "Lkotlin/Function0;", "", "checkNotNull", "T", "(Ljava/lang/Object;)Ljava/lang/Object;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "error", "", "message", "require", "requireNotNull", "kotlin-stdlib"}, mo1539f = "kotlin/PreconditionsKt", mo1541h = 1)
class apg extends apf {
    /* renamed from: a */
    private static final void m2592a(boolean z) {
        if (!z) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }

    /* renamed from: a */
    private static final void m2593a(boolean z, bdk<? extends Object> bdk) {
        if (!z) {
            throw new IllegalArgumentException(bdk.invoke().toString());
        }
    }

    /* renamed from: a */
    private static final <T> T m2590a(T t) {
        if (t != null) {
            return t;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    /* renamed from: a */
    private static final <T> T m2591a(T t, bdk<? extends Object> bdk) {
        if (t != null) {
            return t;
        }
        throw new IllegalArgumentException(bdk.invoke().toString());
    }

    /* renamed from: b */
    private static final void m2596b(boolean z) {
        if (!z) {
            throw new IllegalStateException("Check failed.".toString());
        }
    }

    /* renamed from: b */
    private static final void m2597b(boolean z, bdk<? extends Object> bdk) {
        if (!z) {
            throw new IllegalStateException(bdk.invoke().toString());
        }
    }

    /* renamed from: b */
    private static final <T> T m2594b(T t) {
        if (t != null) {
            return t;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    /* renamed from: b */
    private static final <T> T m2595b(T t, bdk<? extends Object> bdk) {
        if (t != null) {
            return t;
        }
        throw new IllegalStateException(bdk.invoke().toString());
    }

    /* renamed from: c */
    private static final Void m2598c(Object obj) {
        throw new IllegalStateException(obj.toString());
    }
}
