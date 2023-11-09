package atakplugin.UASTool;

import java.util.RandomAccess;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00060\u0003j\u0002`\u0004J\u0011\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002H\u0002J\u0016\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0006H\u0002¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\b\u0010\u0010\u001a\u00020\nH\u0016J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0002H\u0016R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, mo1538e = {"kotlin/collections/ArraysKt___ArraysJvmKt$asList$5", "Lkotlin/collections/AbstractList;", "", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "size", "", "getSize", "()I", "contains", "", "element", "get", "index", "(I)Ljava/lang/Float;", "indexOf", "isEmpty", "lastIndexOf", "kotlin-stdlib"})
public final class asd extends ari<Float> implements RandomAccess {

    /* renamed from: b */
    final /* synthetic */ float[] f2228b;

    asd(float[] fArr) {
        this.f2228b = fArr;
    }

    public final boolean contains(Object obj) {
        if (obj instanceof Float) {
            return mo1835a(((Number) obj).floatValue());
        }
        return false;
    }

    public final int indexOf(Object obj) {
        if (obj instanceof Float) {
            return mo1836b(((Number) obj).floatValue());
        }
        return -1;
    }

    public final int lastIndexOf(Object obj) {
        if (obj instanceof Float) {
            return mo1837c(((Number) obj).floatValue());
        }
        return -1;
    }

    /* renamed from: a */
    public int mo1694a() {
        return this.f2228b.length;
    }

    public boolean isEmpty() {
        return this.f2228b.length == 0;
    }

    /* renamed from: a */
    public boolean mo1835a(float f) {
        return arv.m3936b(this.f2228b, f);
    }

    /* renamed from: a */
    public Float get(int i) {
        return Float.valueOf(this.f2228b[i]);
    }

    /* renamed from: b */
    public int mo1836b(float f) {
        return arv.m3967c(this.f2228b, f);
    }

    /* renamed from: c */
    public int mo1837c(float f) {
        return arv.m4062d(this.f2228b, f);
    }
}
