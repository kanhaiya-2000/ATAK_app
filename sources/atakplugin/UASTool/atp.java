package atakplugin.UASTool;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

@aot(mo1534a = 5, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u00002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0011\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\b\u001a\u0011\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001H\b\u001a\"\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\tH\b¢\u0006\u0002\u0010\n\u001a4\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u0006\"\u0004\b\u0000\u0010\u000b2\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u0006H\b¢\u0006\u0002\u0010\r\u001a\u001f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u000f\"\u0004\b\u0000\u0010\u000b2\u0006\u0010\u0010\u001a\u0002H\u000b¢\u0006\u0002\u0010\u0011\u001a1\u0010\u0012\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00070\u0006\"\u0004\b\u0000\u0010\u000b*\n\u0012\u0006\b\u0001\u0012\u0002H\u000b0\u00062\u0006\u0010\u0013\u001a\u00020\u0014H\u0000¢\u0006\u0002\u0010\u0015\u001a\u001f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u000f\"\u0004\b\u0000\u0010\u000b*\b\u0012\u0004\u0012\u0002H\u000b0\u0017H\b¨\u0006\u0018"}, mo1538e = {"checkCountOverflow", "", "count", "checkIndexOverflow", "index", "copyToArrayImpl", "", "", "collection", "", "(Ljava/util/Collection;)[Ljava/lang/Object;", "T", "array", "(Ljava/util/Collection;[Ljava/lang/Object;)[Ljava/lang/Object;", "listOf", "", "element", "(Ljava/lang/Object;)Ljava/util/List;", "copyToArrayOfAny", "isVarargs", "", "([Ljava/lang/Object;Z)[Ljava/lang/Object;", "toList", "Ljava/util/Enumeration;", "kotlin-stdlib"}, mo1539f = "kotlin/collections/CollectionsKt", mo1541h = 1)
class atp {
    /* renamed from: a */
    public static final <T> List<T> m4586a(T t) {
        List<T> singletonList = Collections.singletonList(t);
        bfq.m6554b(singletonList, "java.util.Collections.singletonList(element)");
        return singletonList;
    }

    /* renamed from: a */
    private static final <T> List<T> m4587a(Enumeration<T> enumeration) {
        ArrayList<T> list = Collections.list(enumeration);
        bfq.m6554b(list, "java.util.Collections.list(this)");
        return list;
    }

    /* renamed from: a */
    private static final Object[] m4588a(Collection<?> collection) {
        return bfc.m6477a(collection);
    }

    /* renamed from: a */
    private static final <T> T[] m4589a(Collection<?> collection, T[] tArr) {
        if (tArr != null) {
            T[] a = bfc.m6479a(collection, tArr);
            if (a != null) {
                return a;
            }
            throw new apx("null cannot be cast to non-null type kotlin.Array<T>");
        }
        throw new apx("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
    }

    /* renamed from: a */
    public static final <T> Object[] m4590a(T[] tArr, boolean z) {
        bfq.m6567f(tArr, "$this$copyToArrayOfAny");
        if (z && bfq.m6552a((Object) tArr.getClass(), (Object) Object[].class)) {
            return tArr;
        }
        Object[] copyOf = Arrays.copyOf(tArr, tArr.length, Object[].class);
        bfq.m6554b(copyOf, "java.util.Arrays.copyOf(… Array<Any?>::class.java)");
        return copyOf;
    }

    /* renamed from: a */
    private static final int m4585a(int i) {
        if (i < 0) {
            if (bbg.m6171a(1, 3, 0)) {
                ato.m4612b();
            } else {
                throw new ArithmeticException("Index overflow has happened.");
            }
        }
        return i;
    }

    /* renamed from: b */
    private static final int m4591b(int i) {
        if (i < 0) {
            if (bbg.m6171a(1, 3, 0)) {
                ato.m4616c();
            } else {
                throw new ArithmeticException("Count overflow has happened.");
            }
        }
        return i;
    }
}
