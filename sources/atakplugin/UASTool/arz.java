package atakplugin.UASTool;

import java.util.RandomAccess;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00060\u0003j\u0002`\u0004J\u0011\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002H\u0002J\u0016\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0006H\u0002¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\b\u0010\u0010\u001a\u00020\nH\u0016J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0002H\u0016R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, mo1538e = {"kotlin/collections/ArraysKt___ArraysJvmKt$asList$1", "Lkotlin/collections/AbstractList;", "", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "size", "", "getSize", "()I", "contains", "", "element", "get", "index", "(I)Ljava/lang/Byte;", "indexOf", "isEmpty", "lastIndexOf", "kotlin-stdlib"})
public final class arz extends ari<Byte> implements RandomAccess {

    /* renamed from: b */
    final /* synthetic */ byte[] f2224b;

    arz(byte[] bArr) {
        this.f2224b = bArr;
    }

    public final boolean contains(Object obj) {
        if (obj instanceof Byte) {
            return mo1818a(((Number) obj).byteValue());
        }
        return false;
    }

    public final int indexOf(Object obj) {
        if (obj instanceof Byte) {
            return mo1819b(((Number) obj).byteValue());
        }
        return -1;
    }

    public final int lastIndexOf(Object obj) {
        if (obj instanceof Byte) {
            return mo1820c(((Number) obj).byteValue());
        }
        return -1;
    }

    /* renamed from: a */
    public int mo1694a() {
        return this.f2224b.length;
    }

    public boolean isEmpty() {
        return this.f2224b.length == 0;
    }

    /* renamed from: a */
    public boolean mo1818a(byte b) {
        return arv.m3933b(this.f2224b, b);
    }

    /* renamed from: a */
    public Byte get(int i) {
        return Byte.valueOf(this.f2224b[i]);
    }

    /* renamed from: b */
    public int mo1819b(byte b) {
        return arv.m3961c(this.f2224b, b);
    }

    /* renamed from: c */
    public int mo1820c(byte b) {
        return arv.m4056d(this.f2224b, b);
    }
}
