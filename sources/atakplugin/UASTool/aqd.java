package atakplugin.UASTool;

import java.util.Arrays;
import java.util.Collection;
import java.util.NoSuchElementException;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\b@\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001-B\u0014\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006B\u0014\b\u0001\u0012\u0006\u0010\u0007\u001a\u00020\bø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\tJ\u001b\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J \u0010\u0013\u001a\u00020\u000f2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u000f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\u001b\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0004H\u0002ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ\t\u0010\u001e\u001a\u00020\u0004HÖ\u0001J\u000f\u0010\u001f\u001a\u00020\u000fH\u0016¢\u0006\u0004\b \u0010!J\u0010\u0010\"\u001a\u00020#H\u0002¢\u0006\u0004\b$\u0010%J#\u0010&\u001a\u00020'2\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u0002H\u0002ø\u0001\u0000¢\u0006\u0004\b)\u0010*J\t\u0010+\u001a\u00020,HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0007\u001a\u00020\b8\u0000X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\f\u0010\rø\u0001\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006."}, mo1538e = {"Lkotlin/UIntArray;", "", "Lkotlin/UInt;", "size", "", "constructor-impl", "(I)[I", "storage", "", "([I)[I", "getSize-impl", "([I)I", "storage$annotations", "()V", "contains", "", "element", "contains-WZ4Q5Ns", "([II)Z", "containsAll", "elements", "containsAll-impl", "([ILjava/util/Collection;)Z", "equals", "other", "", "get", "index", "get-impl", "([II)I", "hashCode", "isEmpty", "isEmpty-impl", "([I)Z", "iterator", "Lkotlin/collections/UIntIterator;", "iterator-impl", "([I)Lkotlin/collections/UIntIterator;", "set", "", "value", "set-VXSXFK8", "([III)V", "toString", "", "Iterator", "kotlin-stdlib"})
public final class aqd implements bgz, Collection<aqc> {

    /* renamed from: a */
    private final int[] f2155a;

    /* renamed from: a */
    public static boolean m2809a(int[] iArr, Object obj) {
        return (obj instanceof aqd) && bfq.m6552a((Object) iArr, (Object) ((aqd) obj).mo1617d());
    }

    /* renamed from: a */
    public static final boolean m2811a(int[] iArr, int[] iArr2) {
        bfq.m6567f(iArr, "p1");
        bfq.m6567f(iArr2, "p2");
        throw null;
    }

    /* renamed from: c */
    public static /* synthetic */ void m2815c() {
    }

    /* renamed from: d */
    public static int[] m2817d(int[] iArr) {
        bfq.m6567f(iArr, "storage");
        return iArr;
    }

    /* renamed from: f */
    public static String m2819f(int[] iArr) {
        return "UIntArray(storage=" + Arrays.toString(iArr) + ")";
    }

    /* renamed from: g */
    public static int m2820g(int[] iArr) {
        if (iArr != null) {
            return Arrays.hashCode(iArr);
        }
        return 0;
    }

    /* renamed from: a */
    public int mo1608a() {
        return m2806a(this.f2155a);
    }

    /* renamed from: a */
    public boolean mo1609a(int i) {
        return m2813b(this.f2155a, i);
    }

    public /* synthetic */ boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean addAll(Collection<? extends aqc> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* renamed from: b */
    public avz iterator() {
        return m2812b(this.f2155a);
    }

    /* renamed from: c */
    public boolean mo1613c(int i) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean containsAll(Collection<? extends Object> collection) {
        return m2810a(this.f2155a, (Collection<aqc>) collection);
    }

    /* renamed from: d */
    public final /* synthetic */ int[] mo1617d() {
        return this.f2155a;
    }

    public boolean equals(Object obj) {
        return m2809a(this.f2155a, obj);
    }

    public int hashCode() {
        return m2820g(this.f2155a);
    }

    public boolean isEmpty() {
        return m2816c(this.f2155a);
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
        return m2819f(this.f2155a);
    }

    public final boolean contains(Object obj) {
        if (obj instanceof aqc) {
            return mo1609a(((aqc) obj).mo1603b());
        }
        return false;
    }

    public final int size() {
        return mo1608a();
    }

    private /* synthetic */ aqd(int[] iArr) {
        bfq.m6567f(iArr, "storage");
        this.f2155a = iArr;
    }

    /* renamed from: b */
    public static int[] m2814b(int i) {
        return m2817d(new int[i]);
    }

    /* renamed from: a */
    public static final int m2807a(int[] iArr, int i) {
        return aqc.m2761b(iArr[i]);
    }

    /* renamed from: a */
    public static final void m2808a(int[] iArr, int i, int i2) {
        iArr[i] = i2;
    }

    /* renamed from: a */
    public static int m2806a(int[] iArr) {
        return iArr.length;
    }

    /* renamed from: b */
    public static avz m2812b(int[] iArr) {
        return new C0090a(iArr);
    }

    @aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\t\u001a\u00020\nH\u0016ø\u0001\u0000¢\u0006\u0002\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, mo1538e = {"Lkotlin/UIntArray$Iterator;", "Lkotlin/collections/UIntIterator;", "array", "", "([I)V", "index", "", "hasNext", "", "nextUInt", "Lkotlin/UInt;", "()I", "kotlin-stdlib"})
    /* renamed from: atakplugin.UASTool.aqd$a */
    private static final class C0090a extends avz {

        /* renamed from: a */
        private int f2156a;

        /* renamed from: b */
        private final int[] f2157b;

        public C0090a(int[] iArr) {
            bfq.m6567f(iArr, "array");
            this.f2157b = iArr;
        }

        public boolean hasNext() {
            return this.f2156a < this.f2157b.length;
        }

        /* renamed from: a */
        public int mo1629a() {
            int i = this.f2156a;
            int[] iArr = this.f2157b;
            if (i < iArr.length) {
                this.f2156a = i + 1;
                return aqc.m2761b(iArr[i]);
            }
            throw new NoSuchElementException(String.valueOf(this.f2156a));
        }
    }

    /* renamed from: b */
    public static boolean m2813b(int[] iArr, int i) {
        return arv.m3937b(iArr, i);
    }

    /* renamed from: a */
    public static boolean m2810a(int[] iArr, Collection<aqc> collection) {
        boolean z;
        bfq.m6567f(collection, "elements");
        Iterable iterable = collection;
        if (!((Collection) iterable).isEmpty()) {
            for (Object next : iterable) {
                if (!(next instanceof aqc) || !arv.m3937b(iArr, ((aqc) next).mo1603b())) {
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
    public static boolean m2816c(int[] iArr) {
        return iArr.length == 0;
    }
}
