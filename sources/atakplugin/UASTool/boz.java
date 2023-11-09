package atakplugin.UASTool;

import java.util.Iterator;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\b\u0004\n\u0002\u0010(\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00028\u00000\u0001J\u0015\u0010\u0003\u001a\u00028\u00002\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0002\u0010\u0005J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H\u0016¨\u0006\b"}, mo1538e = {"kotlin/text/StringsKt___StringsKt$groupingBy$1", "Lkotlin/collections/Grouping;", "", "keyOf", "element", "(C)Ljava/lang/Object;", "sourceIterator", "", "kotlin-stdlib"})
public final class boz implements aum<Character, K> {

    /* renamed from: a */
    final /* synthetic */ CharSequence f3069a;

    /* renamed from: b */
    final /* synthetic */ bdl f3070b;

    public boz(CharSequence charSequence, bdl bdl) {
        this.f3069a = charSequence;
        this.f3070b = bdl;
    }

    /* renamed from: a */
    public /* synthetic */ Object mo1861a(Object obj) {
        return mo2939a(((Character) obj).charValue());
    }

    /* renamed from: a */
    public Iterator<Character> mo1862a() {
        return boc.m8218e(this.f3069a);
    }

    /* renamed from: a */
    public K mo2939a(char c) {
        return this.f3070b.invoke(Character.valueOf(c));
    }
}
