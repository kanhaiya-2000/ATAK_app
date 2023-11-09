package atakplugin.UASTool;

import com.atakmap.android.uastool.tasks.UASTask;
import java.lang.reflect.Method;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\u00020\u0001:\u0001\u000bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0007\u001a\u00020\bR\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, mo1538e = {"Lkotlin/coroutines/jvm/internal/ModuleNameRetriever;", "", "()V", "cache", "Lkotlin/coroutines/jvm/internal/ModuleNameRetriever$Cache;", "notOnJava9", "buildCache", "continuation", "Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;", "getModuleName", "", "Cache", "kotlin-stdlib"})
final class bam {

    /* renamed from: a */
    public static C0135a f2487a;

    /* renamed from: b */
    public static final bam f2488b = new bam();

    /* renamed from: c */
    private static final C0135a f2489c = new C0135a((Method) null, (Method) null, (Method) null);

    @aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, mo1538e = {"Lkotlin/coroutines/jvm/internal/ModuleNameRetriever$Cache;", "", "getModuleMethod", "Ljava/lang/reflect/Method;", "getDescriptorMethod", "nameMethod", "(Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;)V", "kotlin-stdlib"})
    /* renamed from: atakplugin.UASTool.bam$a */
    private static final class C0135a {

        /* renamed from: a */
        public final Method f2490a;

        /* renamed from: b */
        public final Method f2491b;

        /* renamed from: c */
        public final Method f2492c;

        public C0135a(Method method, Method method2, Method method3) {
            this.f2490a = method;
            this.f2491b = method2;
            this.f2492c = method3;
        }
    }

    private bam() {
    }

    /* renamed from: a */
    public final String mo2230a(bae bae) {
        Method method;
        Object invoke;
        Method method2;
        Object invoke2;
        bfq.m6567f(bae, "continuation");
        C0135a aVar = f2487a;
        if (aVar == null) {
            aVar = m6149b(bae);
        }
        Object obj = null;
        if (aVar == f2489c || (method = aVar.f2490a) == null || (invoke = method.invoke(bae.getClass(), new Object[0])) == null || (method2 = aVar.f2491b) == null || (invoke2 = method2.invoke(invoke, new Object[0])) == null) {
            return null;
        }
        Method method3 = aVar.f2492c;
        Object invoke3 = method3 != null ? method3.invoke(invoke2, new Object[0]) : null;
        if (invoke3 instanceof String) {
            obj = invoke3;
        }
        return (String) obj;
    }

    /* renamed from: b */
    private final C0135a m6149b(bae bae) {
        try {
            C0135a aVar = new C0135a(Class.class.getDeclaredMethod("getModule", new Class[0]), bae.getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", new Class[0]), bae.getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod(UASTask.COTDETAIL_NAME, new Class[0]));
            f2487a = aVar;
            return aVar;
        } catch (Exception unused) {
            C0135a aVar2 = f2489c;
            f2487a = aVar2;
            return aVar2;
        }
    }
}
