package atakplugin.UASTool;

import java.util.Arrays;
import java.util.Iterator;
import java.util.RandomAccess;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010(\n\u0002\b\b\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00060\u0003j\u0002`\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u001d\u0012\u000e\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t\u0012\u0006\u0010\u000b\u001a\u00020\u0006¢\u0006\u0002\u0010\fJ\u0013\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00028\u0000¢\u0006\u0002\u0010\u0016J\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0018\u001a\u00020\u0006J\u0016\u0010\u0019\u001a\u00028\u00002\u0006\u0010\u001a\u001a\u00020\u0006H\u0002¢\u0006\u0002\u0010\u001bJ\u0006\u0010\u001c\u001a\u00020\u001dJ\u000f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u001fH\u0002J\u000e\u0010 \u001a\u00020\u00142\u0006\u0010!\u001a\u00020\u0006J\u0015\u0010\"\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tH\u0014¢\u0006\u0002\u0010#J'\u0010\"\u001a\b\u0012\u0004\u0012\u0002H\u00010\t\"\u0004\b\u0001\u0010\u00012\f\u0010$\u001a\b\u0012\u0004\u0012\u0002H\u00010\tH\u0014¢\u0006\u0002\u0010%J\u0015\u0010&\u001a\u00020\u0006*\u00020\u00062\u0006\u0010!\u001a\u00020\u0006H\bR\u0018\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tX\u0004¢\u0006\u0004\n\u0002\u0010\rR\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006@RX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, mo1538e = {"Lkotlin/collections/RingBuffer;", "T", "Lkotlin/collections/AbstractList;", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "capacity", "", "(I)V", "buffer", "", "", "filledSize", "([Ljava/lang/Object;I)V", "[Ljava/lang/Object;", "<set-?>", "size", "getSize", "()I", "startIndex", "add", "", "element", "(Ljava/lang/Object;)V", "expanded", "maxCapacity", "get", "index", "(I)Ljava/lang/Object;", "isFull", "", "iterator", "", "removeFirst", "n", "toArray", "()[Ljava/lang/Object;", "array", "([Ljava/lang/Object;)[Ljava/lang/Object;", "forward", "kotlin-stdlib"})
final class avi<T> extends ari<T> implements RandomAccess {
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final int f2292b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public int f2293c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public int f2294d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final Object[] f2295e;

    public avi(Object[] objArr, int i) {
        bfq.m6567f(objArr, "buffer");
        this.f2295e = objArr;
        boolean z = true;
        if (i >= 0) {
            if (i > objArr.length ? false : z) {
                this.f2292b = objArr.length;
                this.f2294d = i;
                return;
            }
            throw new IllegalArgumentException(("ring buffer filled size: " + i + " cannot be larger than the buffer size: " + objArr.length).toString());
        }
        throw new IllegalArgumentException(("ring buffer filled size should not be negative but it is " + i).toString());
    }

    public avi(int i) {
        this(new Object[i], 0);
    }

    /* renamed from: a */
    public int mo1694a() {
        return this.f2294d;
    }

    public T get(int i) {
        ari.f2206a.mo1730a(i, size());
        return this.f2295e[(this.f2293c + i) % this.f2292b];
    }

    /* renamed from: b */
    public final boolean mo2058b() {
        return size() == this.f2292b;
    }

    public Iterator<T> iterator() {
        return new avj(this);
    }

    public <T> T[] toArray(T[] tArr) {
        bfq.m6567f(tArr, "array");
        if (tArr.length < size()) {
            tArr = Arrays.copyOf(tArr, size());
            bfq.m6554b(tArr, "java.util.Arrays.copyOf(this, newSize)");
        }
        int size = size();
        int i = this.f2293c;
        int i2 = 0;
        int i3 = 0;
        while (i3 < size && i < this.f2292b) {
            tArr[i3] = this.f2295e[i];
            i3++;
            i++;
        }
        while (i3 < size) {
            tArr[i3] = this.f2295e[i2];
            i3++;
            i2++;
        }
        if (tArr.length > size()) {
            tArr[size()] = null;
        }
        if (tArr != null) {
            return tArr;
        }
        throw new apx("null cannot be cast to non-null type kotlin.Array<T>");
    }

    public Object[] toArray() {
        return toArray(new Object[size()]);
    }

    /* renamed from: a */
    public final avi<T> mo2055a(int i) {
        Object[] objArr;
        int i2 = this.f2292b;
        int d = biu.m7191d(i2 + (i2 >> 1) + 1, i);
        if (this.f2293c == 0) {
            objArr = Arrays.copyOf(this.f2295e, d);
            bfq.m6554b(objArr, "java.util.Arrays.copyOf(this, newSize)");
        } else {
            objArr = toArray(new Object[d]);
        }
        return new avi<>(objArr, size());
    }

    /* renamed from: a */
    public final void mo2056a(T t) {
        if (!mo2058b()) {
            this.f2295e[(this.f2293c + size()) % this.f2292b] = t;
            this.f2294d = size() + 1;
            return;
        }
        throw new IllegalStateException("ring buffer is full");
    }

    /* renamed from: b */
    public final void mo2057b(int i) {
        boolean z = true;
        if (i >= 0) {
            if (i > size()) {
                z = false;
            }
            if (!z) {
                throw new IllegalArgumentException(("n shouldn't be greater than the buffer size: n = " + i + ", size = " + size()).toString());
            } else if (i > 0) {
                int i2 = this.f2293c;
                int d = (i2 + i) % this.f2292b;
                if (i2 > d) {
                    arv.m3231b((T[]) this.f2295e, null, i2, this.f2292b);
                    arv.m3231b((T[]) this.f2295e, null, 0, d);
                } else {
                    arv.m3231b((T[]) this.f2295e, null, i2, d);
                }
                this.f2293c = d;
                this.f2294d = size() - i;
            }
        } else {
            throw new IllegalArgumentException(("n shouldn't be negative but it is " + i).toString());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final int m5075a(int i, int i2) {
        return (i + i2) % this.f2292b;
    }
}
