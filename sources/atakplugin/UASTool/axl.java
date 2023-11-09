package atakplugin.UASTool;

@aot(mo1534a = 2, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aJ\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f\u001a0\u0010\u000e\u001a\u0002H\u000f\"\b\b\u0000\u0010\u000f*\u00020\u0010*\b\u0012\u0004\u0012\u0002H\u000f0\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u000f0\fH\b¢\u0006\u0002\u0010\u0013¨\u0006\u0014"}, mo1538e = {"thread", "Ljava/lang/Thread;", "start", "", "isDaemon", "contextClassLoader", "Ljava/lang/ClassLoader;", "name", "", "priority", "", "block", "Lkotlin/Function0;", "", "getOrSet", "T", "", "Ljava/lang/ThreadLocal;", "default", "(Ljava/lang/ThreadLocal;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "kotlin-stdlib"})
public final class axl {
    /* renamed from: a */
    public static /* synthetic */ Thread m5810a(boolean z, boolean z2, ClassLoader classLoader, String str, int i, bdk bdk, int i2, Object obj) {
        boolean z3 = (i2 & 1) != 0 ? true : z;
        boolean z4 = (i2 & 2) != 0 ? false : z2;
        if ((i2 & 4) != 0) {
            classLoader = null;
        }
        ClassLoader classLoader2 = classLoader;
        if ((i2 & 8) != 0) {
            str = null;
        }
        return m5809a(z3, z4, classLoader2, str, (i2 & 16) != 0 ? -1 : i, bdk);
    }

    /* renamed from: a */
    public static final Thread m5809a(boolean z, boolean z2, ClassLoader classLoader, String str, int i, bdk<aqr> bdk) {
        bfq.m6567f(bdk, "block");
        axm axm = new axm(bdk);
        if (z2) {
            axm.setDaemon(true);
        }
        if (i > 0) {
            axm.setPriority(i);
        }
        if (str != null) {
            axm.setName(str);
        }
        if (classLoader != null) {
            axm.setContextClassLoader(classLoader);
        }
        if (z) {
            axm.start();
        }
        return axm;
    }

    /* renamed from: a */
    private static final <T> T m5808a(ThreadLocal<T> threadLocal, bdk<? extends T> bdk) {
        T t = threadLocal.get();
        if (t != null) {
            return t;
        }
        T invoke = bdk.invoke();
        threadLocal.set(invoke);
        return invoke;
    }
}
