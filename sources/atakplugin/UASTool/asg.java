package atakplugin.UASTool;

import java.util.RandomAccess;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00060\u0003j\u0002`\u0004J\u0011\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002H\u0002J\u0016\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0006H\u0002¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\b\u0010\u0010\u001a\u00020\nH\u0016J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0002H\u0016R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, mo1538e = {"kotlin/collections/ArraysKt___ArraysJvmKt$asList$8", "Lkotlin/collections/AbstractList;", "", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "size", "", "getSize", "()I", "contains", "", "element", "get", "index", "(I)Ljava/lang/Character;", "indexOf", "isEmpty", "lastIndexOf", "kotlin-stdlib"})
public final class asg extends ari<Character> implements RandomAccess {

    /* renamed from: b */
    final /* synthetic */ char[] f2231b;

    asg(char[] cArr) {
        this.f2231b = cArr;
    }

    public final boolean contains(Object obj) {
        if (obj instanceof Character) {
            return mo1847a(((Character) obj).charValue());
        }
        return false;
    }

    public final int indexOf(Object obj) {
        if (obj instanceof Character) {
            return mo1848b(((Character) obj).charValue());
        }
        return -1;
    }

    public final int lastIndexOf(Object obj) {
        if (obj instanceof Character) {
            return mo1849c(((Character) obj).charValue());
        }
        return -1;
    }

    /* renamed from: a */
    public int mo1694a() {
        return this.f2231b.length;
    }

    public boolean isEmpty() {
        return this.f2231b.length == 0;
    }

    /* renamed from: a */
    public boolean mo1847a(char c) {
        return arv.m3934b(this.f2231b, c);
    }

    /* renamed from: a */
    public Character get(int i) {
        return Character.valueOf(this.f2231b[i]);
    }

    /* renamed from: b */
    public int mo1848b(char c) {
        return arv.m3963c(this.f2231b, c);
    }

    /* renamed from: c */
    public int mo1849c(char c) {
        return arv.m4058d(this.f2231b, c);
    }
}
