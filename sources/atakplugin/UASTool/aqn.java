package atakplugin.UASTool;

import java.util.Arrays;
import java.util.Collection;
import java.util.NoSuchElementException;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0017\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\b@\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001-B\u0014\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006B\u0014\b\u0001\u0012\u0006\u0010\u0007\u001a\u00020\bø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\tJ\u001b\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J \u0010\u0013\u001a\u00020\u000f2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u000f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\u001b\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0004H\u0002ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ\t\u0010\u001e\u001a\u00020\u0004HÖ\u0001J\u000f\u0010\u001f\u001a\u00020\u000fH\u0016¢\u0006\u0004\b \u0010!J\u0010\u0010\"\u001a\u00020#H\u0002¢\u0006\u0004\b$\u0010%J#\u0010&\u001a\u00020'2\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u0002H\u0002ø\u0001\u0000¢\u0006\u0004\b)\u0010*J\t\u0010+\u001a\u00020,HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0007\u001a\u00020\b8\u0000X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\f\u0010\rø\u0001\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006."}, mo1538e = {"Lkotlin/UShortArray;", "", "Lkotlin/UShort;", "size", "", "constructor-impl", "(I)[S", "storage", "", "([S)[S", "getSize-impl", "([S)I", "storage$annotations", "()V", "contains", "", "element", "contains-xj2QHRw", "([SS)Z", "containsAll", "elements", "containsAll-impl", "([SLjava/util/Collection;)Z", "equals", "other", "", "get", "index", "get-impl", "([SI)S", "hashCode", "isEmpty", "isEmpty-impl", "([S)Z", "iterator", "Lkotlin/collections/UShortIterator;", "iterator-impl", "([S)Lkotlin/collections/UShortIterator;", "set", "", "value", "set-01HTLdE", "([SIS)V", "toString", "", "Iterator", "kotlin-stdlib"})
public final class aqn implements bgz, Collection<aqm> {

    /* renamed from: a */
    private final short[] f2174a;

    /* renamed from: a */
    public static boolean m2997a(short[] sArr, Object obj) {
        return (obj instanceof aqn) && bfq.m6552a((Object) sArr, (Object) ((aqn) obj).mo1673d());
    }

    /* renamed from: a */
    public static final boolean m3000a(short[] sArr, short[] sArr2) {
        bfq.m6567f(sArr, "p1");
        bfq.m6567f(sArr2, "p2");
        throw null;
    }

    /* renamed from: c */
    public static /* synthetic */ void m3003c() {
    }

    /* renamed from: d */
    public static short[] m3005d(short[] sArr) {
        bfq.m6567f(sArr, "storage");
        return sArr;
    }

    /* renamed from: f */
    public static String m3007f(short[] sArr) {
        return "UShortArray(storage=" + Arrays.toString(sArr) + ")";
    }

    /* renamed from: g */
    public static int m3008g(short[] sArr) {
        if (sArr != null) {
            return Arrays.hashCode(sArr);
        }
        return 0;
    }

    /* renamed from: a */
    public int mo1664a() {
        return m2994a(this.f2174a);
    }

    /* renamed from: a */
    public boolean mo1665a(short s) {
        return m2999a(this.f2174a, s);
    }

    public /* synthetic */ boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean addAll(Collection<? extends aqm> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* renamed from: b */
    public awb iterator() {
        return m3002b(this.f2174a);
    }

    /* renamed from: b */
    public boolean mo1669b(short s) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean containsAll(Collection<? extends Object> collection) {
        return m2998a(this.f2174a, (Collection<aqm>) collection);
    }

    /* renamed from: d */
    public final /* synthetic */ short[] mo1673d() {
        return this.f2174a;
    }

    public boolean equals(Object obj) {
        return m2997a(this.f2174a, obj);
    }

    public int hashCode() {
        return m3008g(this.f2174a);
    }

    public boolean isEmpty() {
        return m3004c(this.f2174a);
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
        return m3007f(this.f2174a);
    }

    public final boolean contains(Object obj) {
        if (obj instanceof aqm) {
            return mo1665a(((aqm) obj).mo1659b());
        }
        return false;
    }

    public final int size() {
        return mo1664a();
    }

    private /* synthetic */ aqn(short[] sArr) {
        bfq.m6567f(sArr, "storage");
        this.f2174a = sArr;
    }

    /* renamed from: a */
    public static short[] m3001a(int i) {
        return m3005d(new short[i]);
    }

    /* renamed from: a */
    public static final short m2995a(short[] sArr, int i) {
        return aqm.m2955b(sArr[i]);
    }

    /* renamed from: a */
    public static final void m2996a(short[] sArr, int i, short s) {
        sArr[i] = s;
    }

    /* renamed from: a */
    public static int m2994a(short[] sArr) {
        return sArr.length;
    }

    /* renamed from: b */
    public static awb m3002b(short[] sArr) {
        return new C0094a(sArr);
    }

    @aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0017\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\t\u001a\u00020\nH\u0016ø\u0001\u0000¢\u0006\u0002\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, mo1538e = {"Lkotlin/UShortArray$Iterator;", "Lkotlin/collections/UShortIterator;", "array", "", "([S)V", "index", "", "hasNext", "", "nextUShort", "Lkotlin/UShort;", "()S", "kotlin-stdlib"})
    /* renamed from: atakplugin.UASTool.aqn$a */
    private static final class C0094a extends awb {

        /* renamed from: a */
        private int f2175a;

        /* renamed from: b */
        private final short[] f2176b;

        public C0094a(short[] sArr) {
            bfq.m6567f(sArr, "array");
            this.f2176b = sArr;
        }

        public boolean hasNext() {
            return this.f2175a < this.f2176b.length;
        }

        /* renamed from: a */
        public short mo1685a() {
            int i = this.f2175a;
            short[] sArr = this.f2176b;
            if (i < sArr.length) {
                this.f2175a = i + 1;
                return aqm.m2955b(sArr[i]);
            }
            throw new NoSuchElementException(String.valueOf(this.f2175a));
        }
    }

    /* renamed from: a */
    public static boolean m2999a(short[] sArr, short s) {
        return arv.m3940b(sArr, s);
    }

    /* renamed from: a */
    public static boolean m2998a(short[] sArr, Collection<aqm> collection) {
        boolean z;
        bfq.m6567f(collection, "elements");
        Iterable iterable = collection;
        if (!((Collection) iterable).isEmpty()) {
            for (Object next : iterable) {
                if (!(next instanceof aqm) || !arv.m3940b(sArr, ((aqm) next).mo1659b())) {
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
    public static boolean m3004c(short[] sArr) {
        return sArr.length == 0;
    }
}
