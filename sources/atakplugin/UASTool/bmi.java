package atakplugin.UASTool;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0002¨\u0006\u0004"}, mo1538e = {"kotlin/sequences/SequencesKt___SequencesKt$sortedWith$1", "Lkotlin/sequences/Sequence;", "iterator", "", "kotlin-stdlib"})
public final class bmi implements bku<T> {

    /* renamed from: a */
    final /* synthetic */ bku f2893a;

    /* renamed from: b */
    final /* synthetic */ Comparator f2894b;

    bmi(bku<? extends T> bku, Comparator comparator) {
        this.f2893a = bku;
        this.f2894b = comparator;
    }

    /* renamed from: a */
    public Iterator<T> mo1859a() {
        List r = bkx.m7608r(this.f2893a);
        ato.m4640a(r, this.f2894b);
        return r.iterator();
    }
}
