package atakplugin.UASTool;

import java.util.List;

@aot(mo1534a = 2, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\u001a2\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0002H\u00022\u0006\u0010\u0004\u001a\u0002H\u0003H\u0004¢\u0006\u0002\u0010\u0005\u001a\"\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\b0\u0007\"\u0004\b\u0000\u0010\b*\u000e\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u0002H\b0\u0001\u001a(\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\b0\u0007\"\u0004\b\u0000\u0010\b*\u0014\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u0002H\b0\t¨\u0006\n"}, mo1538e = {"to", "Lkotlin/Pair;", "A", "B", "that", "(Ljava/lang/Object;Ljava/lang/Object;)Lkotlin/Pair;", "toList", "", "T", "Lkotlin/Triple;", "kotlin-stdlib"})
public final class apv {
    /* renamed from: a */
    public static final <A, B> apc<A, B> m2659a(A a, B b) {
        return new apc<>(a, b);
    }

    /* renamed from: a */
    public static final <T> List<T> m2660a(apc<? extends T, ? extends T> apc) {
        bfq.m6567f(apc, "$this$toList");
        return ato.m4611b((T[]) new Object[]{apc.mo1544a(), apc.mo1545b()});
    }

    /* renamed from: a */
    public static final <T> List<T> m2661a(apu<? extends T, ? extends T, ? extends T> apu) {
        bfq.m6567f(apu, "$this$toList");
        return ato.m4611b((T[]) new Object[]{apu.mo1566a(), apu.mo1567b(), apu.mo1568c()});
    }
}
