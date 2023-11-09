package atakplugin.UASTool;

import java.util.NoSuchElementException;
import java.util.function.C5916a;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public final class cic {
    /* renamed from: a */
    public static <T> T m11629a(T t, T t2) {
        return t != null ? t : t2;
    }

    @cir(mo4683a = {"#1"}, mo4684b = true)
    /* renamed from: b */
    public static boolean m11635b(Object obj) {
        return obj != null;
    }

    private cic() {
        throw new AssertionError("shouldn't be instantiated");
    }

    /* renamed from: a */
    public static <T> T m11628a(T t) {
        if (t != null) {
            return t;
        }
        throw new NoSuchElementException("No value present");
    }

    /* renamed from: a */
    public static <T> void m11633a(T t, C5916a<? super T> aVar) {
        if (t != null) {
            aVar.accept(t);
        }
    }

    /* renamed from: a */
    public static <T> T m11631a(T t, Predicate<? super T> predicate) {
        if (t == null) {
            return null;
        }
        if (predicate.test(t)) {
            return t;
        }
        return null;
    }

    /* renamed from: a */
    public static <T, U> U m11630a(T t, Function<? super T, ? extends U> function) {
        if (t == null) {
            return null;
        }
        return function.apply(t);
    }

    /* renamed from: a */
    public static <T> T m11632a(T t, Supplier<? extends T> supplier) {
        return t != null ? t : supplier.get();
    }

    /* renamed from: b */
    public static <T, X extends Throwable> T m11634b(T t, Supplier<? extends X> supplier) {
        if (t != null) {
            return t;
        }
        throw ((Throwable) supplier.get());
    }
}
