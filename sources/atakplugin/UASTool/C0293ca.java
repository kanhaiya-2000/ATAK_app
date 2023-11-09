package atakplugin.UASTool;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Objects;

/* renamed from: atakplugin.UASTool.ca */
public final class C0293ca {
    /* renamed from: a */
    public static int m10953a(int i, int i2) {
        if (i < i2) {
            return -1;
        }
        return i == i2 ? 0 : 1;
    }

    /* renamed from: a */
    public static int m10954a(long j, long j2) {
        int i = (j > j2 ? 1 : (j == j2 ? 0 : -1));
        if (i < 0) {
            return -1;
        }
        return i == 0 ? 0 : 1;
    }

    /* renamed from: c */
    public static boolean m10967c(Object obj) {
        return obj == null;
    }

    /* renamed from: d */
    public static boolean m10968d(Object obj) {
        return obj != null;
    }

    private C0293ca() {
    }

    /* renamed from: a */
    public static boolean m10961a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    /* renamed from: b */
    public static boolean m10965b(Object obj, Object obj2) {
        if (obj != obj2) {
            if (obj == null || obj2 == null) {
                return false;
            }
            return Arrays.deepEquals(new Object[]{obj}, new Object[]{obj2});
        }
    }

    /* renamed from: a */
    public static int m10955a(Object obj) {
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    /* renamed from: a */
    public static int m10957a(Object... objArr) {
        if (objArr == null) {
            return 0;
        }
        int i = 1;
        for (Object a : objArr) {
            i = (i * 31) + m10955a(a);
        }
        return i;
    }

    /* renamed from: a */
    public static String m10959a(Object obj, String str) {
        return obj != null ? obj.toString() : str;
    }

    /* renamed from: a */
    public static <T> int m10956a(T t, T t2, Comparator<? super T> comparator) {
        if (t == t2) {
            return 0;
        }
        return comparator.compare(t, t2);
    }

    /* renamed from: b */
    public static <T> T m10962b(T t) {
        Objects.requireNonNull(t);
        return t;
    }

    /* renamed from: b */
    public static <T> T m10964b(T t, String str) {
        Objects.requireNonNull(t, str);
        return t;
    }

    /* renamed from: a */
    public static <T> T m10958a(T t, C0506hp<String> hpVar) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(hpVar.mo107b());
    }

    /* renamed from: c */
    public static <T> T m10966c(T t, T t2) {
        return t != null ? t : m10964b(t2, "defaultObj");
    }

    /* renamed from: b */
    public static <T> T m10963b(T t, C0506hp<? extends T> hpVar) {
        if (t != null) {
            return t;
        }
        return m10964b(((C0506hp) m10964b(hpVar, "supplier")).mo107b(), "supplier.get()");
    }

    /* renamed from: a */
    public static <T> Collection<T> m10960a(Collection<T> collection) {
        m10962b(collection);
        for (T b : collection) {
            m10962b(b);
        }
        return collection;
    }
}
