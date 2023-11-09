package atakplugin.UASTool;

import java.util.RandomAccess;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00060\u0003j\u0002`\u0004J\u001b\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002H\u0002ø\u0001\u0000¢\u0006\u0004\b\f\u0010\rJ\u0014\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0006H\u0002ø\u0001\u0000J\u001a\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0002H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0013\u001a\u00020\nH\u0016J\u001a\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0002H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0012R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bø\u0001\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0016"}, mo1538e = {"kotlin/collections/unsigned/UArraysKt___UArraysJvmKt$asList$3", "Lkotlin/collections/AbstractList;", "Lkotlin/UByte;", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "size", "", "getSize", "()I", "contains", "", "element", "contains-7apg3OU", "(B)Z", "get", "index", "indexOf", "indexOf-7apg3OU", "(B)I", "isEmpty", "lastIndexOf", "lastIndexOf-7apg3OU", "kotlin-stdlib"})
public final class awg extends ari<apy> implements RandomAccess {

    /* renamed from: b */
    final /* synthetic */ byte[] f2329b;

    awg(byte[] bArr) {
        this.f2329b = bArr;
    }

    public final boolean contains(Object obj) {
        if (obj instanceof apy) {
            return mo2098a(((apy) obj).mo1575b());
        }
        return false;
    }

    public final int indexOf(Object obj) {
        if (obj instanceof apy) {
            return mo2099b(((apy) obj).mo1575b());
        }
        return -1;
    }

    public final int lastIndexOf(Object obj) {
        if (obj instanceof apy) {
            return mo2100c(((apy) obj).mo1575b());
        }
        return -1;
    }

    /* renamed from: a */
    public int mo1694a() {
        return apz.m2728a(this.f2329b);
    }

    public boolean isEmpty() {
        return apz.m2737c(this.f2329b);
    }

    /* renamed from: a */
    public boolean mo2098a(byte b) {
        return apz.m2730a(this.f2329b, b);
    }

    /* renamed from: a */
    public apy get(int i) {
        return apy.m2693c(apz.m2727a(this.f2329b, i));
    }

    /* renamed from: b */
    public int mo2099b(byte b) {
        return arv.m3961c(this.f2329b, b);
    }

    /* renamed from: c */
    public int mo2100c(byte b) {
        return arv.m4056d(this.f2329b, b);
    }
}
