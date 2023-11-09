package atakplugin.UASTool;

import java.util.RandomAccess;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00060\u0003j\u0002`\u0004J\u0011\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002H\u0002J\u0016\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0006H\u0002¢\u0006\u0002\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0002H\u0016J\b\u0010\u000f\u001a\u00020\u0002H\u0016J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0002H\u0016R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u0011"}, mo1538e = {"kotlin/collections/ArraysKt___ArraysJvmKt$asList$7", "Lkotlin/collections/AbstractList;", "", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "size", "", "getSize", "()I", "contains", "element", "get", "index", "(I)Ljava/lang/Boolean;", "indexOf", "isEmpty", "lastIndexOf", "kotlin-stdlib"})
public final class asf extends ari<Boolean> implements RandomAccess {

    /* renamed from: b */
    final /* synthetic */ boolean[] f2230b;

    asf(boolean[] zArr) {
        this.f2230b = zArr;
    }

    public final boolean contains(Object obj) {
        if (obj instanceof Boolean) {
            return mo1843a(((Boolean) obj).booleanValue());
        }
        return false;
    }

    public final int indexOf(Object obj) {
        if (obj instanceof Boolean) {
            return mo1844b(((Boolean) obj).booleanValue());
        }
        return -1;
    }

    public final int lastIndexOf(Object obj) {
        if (obj instanceof Boolean) {
            return mo1845c(((Boolean) obj).booleanValue());
        }
        return -1;
    }

    /* renamed from: a */
    public int mo1694a() {
        return this.f2230b.length;
    }

    public boolean isEmpty() {
        return this.f2230b.length == 0;
    }

    /* renamed from: a */
    public boolean mo1843a(boolean z) {
        return arv.m3943b(this.f2230b, z);
    }

    /* renamed from: a */
    public Boolean get(int i) {
        return Boolean.valueOf(this.f2230b[i]);
    }

    /* renamed from: b */
    public int mo1844b(boolean z) {
        return arv.m3980c(this.f2230b, z);
    }

    /* renamed from: c */
    public int mo1845c(boolean z) {
        return arv.m4074d(this.f2230b, z);
    }
}
