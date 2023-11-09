package atakplugin.UASTool;

import java.util.Arrays;
import java.util.Collection;
import java.util.NoSuchElementException;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\b@\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001-B\u0014\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006B\u0014\b\u0001\u0012\u0006\u0010\u0007\u001a\u00020\bø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\tJ\u001b\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J \u0010\u0013\u001a\u00020\u000f2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u000f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\u001b\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0004H\u0002ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ\t\u0010\u001e\u001a\u00020\u0004HÖ\u0001J\u000f\u0010\u001f\u001a\u00020\u000fH\u0016¢\u0006\u0004\b \u0010!J\u0010\u0010\"\u001a\u00020#H\u0002¢\u0006\u0004\b$\u0010%J#\u0010&\u001a\u00020'2\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u0002H\u0002ø\u0001\u0000¢\u0006\u0004\b)\u0010*J\t\u0010+\u001a\u00020,HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0007\u001a\u00020\b8\u0000X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\f\u0010\rø\u0001\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006."}, mo1538e = {"Lkotlin/UByteArray;", "", "Lkotlin/UByte;", "size", "", "constructor-impl", "(I)[B", "storage", "", "([B)[B", "getSize-impl", "([B)I", "storage$annotations", "()V", "contains", "", "element", "contains-7apg3OU", "([BB)Z", "containsAll", "elements", "containsAll-impl", "([BLjava/util/Collection;)Z", "equals", "other", "", "get", "index", "get-impl", "([BI)B", "hashCode", "isEmpty", "isEmpty-impl", "([B)Z", "iterator", "Lkotlin/collections/UByteIterator;", "iterator-impl", "([B)Lkotlin/collections/UByteIterator;", "set", "", "value", "set-VurrAj0", "([BIB)V", "toString", "", "Iterator", "kotlin-stdlib"})
public final class apz implements bgz, Collection<apy> {

    /* renamed from: a */
    private final byte[] f2146a;

    /* renamed from: a */
    public static boolean m2731a(byte[] bArr, Object obj) {
        return (obj instanceof apz) && bfq.m6552a((Object) bArr, (Object) ((apz) obj).mo1589d());
    }

    /* renamed from: a */
    public static final boolean m2733a(byte[] bArr, byte[] bArr2) {
        bfq.m6567f(bArr, "p1");
        bfq.m6567f(bArr2, "p2");
        throw null;
    }

    /* renamed from: c */
    public static /* synthetic */ void m2736c() {
    }

    /* renamed from: d */
    public static byte[] m2738d(byte[] bArr) {
        bfq.m6567f(bArr, "storage");
        return bArr;
    }

    /* renamed from: f */
    public static String m2740f(byte[] bArr) {
        return "UByteArray(storage=" + Arrays.toString(bArr) + ")";
    }

    /* renamed from: g */
    public static int m2741g(byte[] bArr) {
        if (bArr != null) {
            return Arrays.hashCode(bArr);
        }
        return 0;
    }

    /* renamed from: a */
    public int mo1580a() {
        return m2728a(this.f2146a);
    }

    /* renamed from: a */
    public boolean mo1581a(byte b) {
        return m2730a(this.f2146a, b);
    }

    public /* synthetic */ boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean addAll(Collection<? extends apy> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* renamed from: b */
    public avw iterator() {
        return m2735b(this.f2146a);
    }

    /* renamed from: b */
    public boolean mo1585b(byte b) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean containsAll(Collection<? extends Object> collection) {
        return m2732a(this.f2146a, (Collection<apy>) collection);
    }

    /* renamed from: d */
    public final /* synthetic */ byte[] mo1589d() {
        return this.f2146a;
    }

    public boolean equals(Object obj) {
        return m2731a(this.f2146a, obj);
    }

    public int hashCode() {
        return m2741g(this.f2146a);
    }

    public boolean isEmpty() {
        return m2737c(this.f2146a);
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
        return m2740f(this.f2146a);
    }

    public final boolean contains(Object obj) {
        if (obj instanceof apy) {
            return mo1581a(((apy) obj).mo1575b());
        }
        return false;
    }

    public final int size() {
        return mo1580a();
    }

    private /* synthetic */ apz(byte[] bArr) {
        bfq.m6567f(bArr, "storage");
        this.f2146a = bArr;
    }

    /* renamed from: a */
    public static byte[] m2734a(int i) {
        return m2738d(new byte[i]);
    }

    /* renamed from: a */
    public static final byte m2727a(byte[] bArr, int i) {
        return apy.m2684b(bArr[i]);
    }

    /* renamed from: a */
    public static final void m2729a(byte[] bArr, int i, byte b) {
        bArr[i] = b;
    }

    /* renamed from: a */
    public static int m2728a(byte[] bArr) {
        return bArr.length;
    }

    /* renamed from: b */
    public static avw m2735b(byte[] bArr) {
        return new C0087a(bArr);
    }

    @aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\t\u001a\u00020\nH\u0016ø\u0001\u0000¢\u0006\u0002\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, mo1538e = {"Lkotlin/UByteArray$Iterator;", "Lkotlin/collections/UByteIterator;", "array", "", "([B)V", "index", "", "hasNext", "", "nextUByte", "Lkotlin/UByte;", "()B", "kotlin-stdlib"})
    /* renamed from: atakplugin.UASTool.apz$a */
    private static final class C0087a extends avw {

        /* renamed from: a */
        private int f2147a;

        /* renamed from: b */
        private final byte[] f2148b;

        public C0087a(byte[] bArr) {
            bfq.m6567f(bArr, "array");
            this.f2148b = bArr;
        }

        public boolean hasNext() {
            return this.f2147a < this.f2148b.length;
        }

        /* renamed from: a */
        public byte mo1601a() {
            int i = this.f2147a;
            byte[] bArr = this.f2148b;
            if (i < bArr.length) {
                this.f2147a = i + 1;
                return apy.m2684b(bArr[i]);
            }
            throw new NoSuchElementException(String.valueOf(this.f2147a));
        }
    }

    /* renamed from: a */
    public static boolean m2730a(byte[] bArr, byte b) {
        return arv.m3933b(bArr, b);
    }

    /* renamed from: a */
    public static boolean m2732a(byte[] bArr, Collection<apy> collection) {
        boolean z;
        bfq.m6567f(collection, "elements");
        Iterable iterable = collection;
        if (!((Collection) iterable).isEmpty()) {
            for (Object next : iterable) {
                if (!(next instanceof apy) || !arv.m3933b(bArr, ((apy) next).mo1575b())) {
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
    public static boolean m2737c(byte[] bArr) {
        return bArr.length == 0;
    }
}
