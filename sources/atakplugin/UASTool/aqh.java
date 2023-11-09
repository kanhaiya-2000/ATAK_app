package atakplugin.UASTool;

import java.util.Arrays;
import java.util.Collection;
import java.util.NoSuchElementException;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0016\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\b@\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001-B\u0014\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006B\u0014\b\u0001\u0012\u0006\u0010\u0007\u001a\u00020\bø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\tJ\u001b\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J \u0010\u0013\u001a\u00020\u000f2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u000f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\u001b\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0004H\u0002ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ\t\u0010\u001e\u001a\u00020\u0004HÖ\u0001J\u000f\u0010\u001f\u001a\u00020\u000fH\u0016¢\u0006\u0004\b \u0010!J\u0010\u0010\"\u001a\u00020#H\u0002¢\u0006\u0004\b$\u0010%J#\u0010&\u001a\u00020'2\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u0002H\u0002ø\u0001\u0000¢\u0006\u0004\b)\u0010*J\t\u0010+\u001a\u00020,HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0007\u001a\u00020\b8\u0000X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\f\u0010\rø\u0001\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006."}, mo1538e = {"Lkotlin/ULongArray;", "", "Lkotlin/ULong;", "size", "", "constructor-impl", "(I)[J", "storage", "", "([J)[J", "getSize-impl", "([J)I", "storage$annotations", "()V", "contains", "", "element", "contains-VKZWuLQ", "([JJ)Z", "containsAll", "elements", "containsAll-impl", "([JLjava/util/Collection;)Z", "equals", "other", "", "get", "index", "get-impl", "([JI)J", "hashCode", "isEmpty", "isEmpty-impl", "([J)Z", "iterator", "Lkotlin/collections/ULongIterator;", "iterator-impl", "([J)Lkotlin/collections/ULongIterator;", "set", "", "value", "set-k8EXiF4", "([JIJ)V", "toString", "", "Iterator", "kotlin-stdlib"})
public final class aqh implements bgz, Collection<aqg> {

    /* renamed from: a */
    private final long[] f2164a;

    /* renamed from: a */
    public static boolean m2891a(long[] jArr, Object obj) {
        return (obj instanceof aqh) && bfq.m6552a((Object) jArr, (Object) ((aqh) obj).mo1645d());
    }

    /* renamed from: a */
    public static final boolean m2893a(long[] jArr, long[] jArr2) {
        bfq.m6567f(jArr, "p1");
        bfq.m6567f(jArr2, "p2");
        throw null;
    }

    /* renamed from: c */
    public static /* synthetic */ void m2896c() {
    }

    /* renamed from: d */
    public static long[] m2898d(long[] jArr) {
        bfq.m6567f(jArr, "storage");
        return jArr;
    }

    /* renamed from: f */
    public static String m2900f(long[] jArr) {
        return "ULongArray(storage=" + Arrays.toString(jArr) + ")";
    }

    /* renamed from: g */
    public static int m2901g(long[] jArr) {
        if (jArr != null) {
            return Arrays.hashCode(jArr);
        }
        return 0;
    }

    /* renamed from: a */
    public int mo1636a() {
        return m2887a(this.f2164a);
    }

    /* renamed from: a */
    public boolean mo1637a(long j) {
        return m2890a(this.f2164a, j);
    }

    public /* synthetic */ boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean addAll(Collection<? extends aqg> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* renamed from: b */
    public awa iterator() {
        return m2895b(this.f2164a);
    }

    /* renamed from: b */
    public boolean mo1641b(long j) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean containsAll(Collection<? extends Object> collection) {
        return m2892a(this.f2164a, (Collection<aqg>) collection);
    }

    /* renamed from: d */
    public final /* synthetic */ long[] mo1645d() {
        return this.f2164a;
    }

    public boolean equals(Object obj) {
        return m2891a(this.f2164a, obj);
    }

    public int hashCode() {
        return m2901g(this.f2164a);
    }

    public boolean isEmpty() {
        return m2897c(this.f2164a);
    }

    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public Object[] toArray() {
        return bfc.m6477a(this);
    }

    public <T> T[] toArray(T[] tArr) {
        return bfc.m6479a(this, tArr);
    }

    public String toString() {
        return m2900f(this.f2164a);
    }

    public final boolean contains(Object obj) {
        if (obj instanceof aqg) {
            return mo1637a(((aqg) obj).mo1631b());
        }
        return false;
    }

    public final int size() {
        return mo1636a();
    }

    private /* synthetic */ aqh(long[] jArr) {
        bfq.m6567f(jArr, "storage");
        this.f2164a = jArr;
    }

    /* renamed from: a */
    public static long[] m2894a(int i) {
        return m2898d(new long[i]);
    }

    /* renamed from: a */
    public static final long m2888a(long[] jArr, int i) {
        return aqg.m2843b(jArr[i]);
    }

    /* renamed from: a */
    public static final void m2889a(long[] jArr, int i, long j) {
        jArr[i] = j;
    }

    /* renamed from: a */
    public static int m2887a(long[] jArr) {
        return jArr.length;
    }

    /* renamed from: b */
    public static awa m2895b(long[] jArr) {
        return new C0092a(jArr);
    }

    @aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0016\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\t\u001a\u00020\nH\u0016ø\u0001\u0000¢\u0006\u0002\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, mo1538e = {"Lkotlin/ULongArray$Iterator;", "Lkotlin/collections/ULongIterator;", "array", "", "([J)V", "index", "", "hasNext", "", "nextULong", "Lkotlin/ULong;", "()J", "kotlin-stdlib"})
    /* renamed from: atakplugin.UASTool.aqh$a */
    private static final class C0092a extends awa {

        /* renamed from: a */
        private int f2165a;

        /* renamed from: b */
        private final long[] f2166b;

        public C0092a(long[] jArr) {
            bfq.m6567f(jArr, "array");
            this.f2166b = jArr;
        }

        public boolean hasNext() {
            return this.f2165a < this.f2166b.length;
        }

        /* renamed from: a */
        public long mo1657a() {
            int i = this.f2165a;
            long[] jArr = this.f2166b;
            if (i < jArr.length) {
                this.f2165a = i + 1;
                return aqg.m2843b(jArr[i]);
            }
            throw new NoSuchElementException(String.valueOf(this.f2165a));
        }
    }

    /* renamed from: a */
    public static boolean m2890a(long[] jArr, long j) {
        return arv.m3938b(jArr, j);
    }

    /* renamed from: a */
    public static boolean m2892a(long[] jArr, Collection<aqg> collection) {
        boolean z;
        bfq.m6567f(collection, "elements");
        Iterable iterable = collection;
        if (!((Collection) iterable).isEmpty()) {
            for (Object next : iterable) {
                if (!(next instanceof aqg) || !arv.m3938b(jArr, ((aqg) next).mo1631b())) {
                    z = false;
                    continue;
                } else {
                    z = true;
                    continue;
                }
                if (!z) {
                    return false;
                }
            }
        }
        return true;
    }

    /* renamed from: c */
    public static boolean m2897c(long[] jArr) {
        return jArr.length == 0;
    }
}
