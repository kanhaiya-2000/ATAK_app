package atakplugin.UASTool;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/* renamed from: atakplugin.UASTool.in */
public final class C0533in {

    /* renamed from: a */
    static final long f5006a = 2147483639;

    /* renamed from: b */
    private static final String f5007b = "Stream size exceeds max array size";

    /* renamed from: a */
    public static <T> Queue<T> m12276a() {
        try {
            return new ArrayDeque();
        } catch (NoClassDefFoundError unused) {
            return new LinkedList();
        }
    }

    @SafeVarargs
    /* renamed from: a */
    public static <E> E[] m12278a(int i, E... eArr) {
        try {
            return Arrays.copyOf(eArr, i);
        } catch (NoSuchMethodError unused) {
            return m12279a(eArr, i);
        }
    }

    /* renamed from: a */
    public static <E> E[] m12279a(E[] eArr, int i) {
        E[] eArr2 = (Object[]) Array.newInstance(eArr.getClass().getComponentType(), i);
        System.arraycopy(eArr, 0, eArr2, 0, Math.min(i, eArr.length));
        return eArr2;
    }

    /* renamed from: a */
    static void m12277a(long j) {
        if (j >= f5006a) {
            throw new IllegalArgumentException(f5007b);
        }
    }
}
