package atakplugin.UASTool;

import java.util.RandomAccess;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00060\u0003j\u0002`\u0004J\u0011\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0002H\u0002J\u0016\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002H\u0002¢\u0006\u0002\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002H\u0016J\b\u0010\u000f\u001a\u00020\tH\u0016J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002H\u0016R\u0014\u0010\u0005\u001a\u00020\u00028VX\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, mo1538e = {"kotlin/collections/ArraysKt___ArraysJvmKt$asList$3", "Lkotlin/collections/AbstractList;", "", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "size", "getSize", "()I", "contains", "", "element", "get", "index", "(I)Ljava/lang/Integer;", "indexOf", "isEmpty", "lastIndexOf", "kotlin-stdlib"})
public final class asb extends ari<Integer> implements RandomAccess {

    /* renamed from: b */
    final /* synthetic */ int[] f2226b;

    asb(int[] iArr) {
        this.f2226b = iArr;
    }

    public final boolean contains(Object obj) {
        if (obj instanceof Integer) {
            return mo1826a(((Number) obj).intValue());
        }
        return false;
    }

    public final int indexOf(Object obj) {
        if (obj instanceof Integer) {
            return mo1828c(((Number) obj).intValue());
        }
        return -1;
    }

    public final int lastIndexOf(Object obj) {
        if (obj instanceof Integer) {
            return mo1829d(((Number) obj).intValue());
        }
        return -1;
    }

    /* renamed from: a */
    public int mo1694a() {
        return this.f2226b.length;
    }

    public boolean isEmpty() {
        return this.f2226b.length == 0;
    }

    /* renamed from: a */
    public boolean mo1826a(int i) {
        return arv.m3937b(this.f2226b, i);
    }

    /* renamed from: b */
    public Integer get(int i) {
        return Integer.valueOf(this.f2226b[i]);
    }

    /* renamed from: c */
    public int mo1828c(int i) {
        return arv.m4064d(this.f2226b, i);
    }

    /* renamed from: d */
    public int mo1829d(int i) {
        return arv.m4124e(this.f2226b, i);
    }
}
