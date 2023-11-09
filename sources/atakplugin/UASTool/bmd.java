package atakplugin.UASTool;

import java.util.HashSet;
import java.util.Iterator;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0002¨\u0006\u0004"}, mo1538e = {"kotlin/sequences/SequencesKt___SequencesKt$minus$4", "Lkotlin/sequences/Sequence;", "iterator", "", "kotlin-stdlib"})
public final class bmd implements bku<T> {

    /* renamed from: a */
    final /* synthetic */ bku f2887a;

    /* renamed from: b */
    final /* synthetic */ bku f2888b;

    bmd(bku<? extends T> bku, bku bku2) {
        this.f2887a = bku;
        this.f2888b = bku2;
    }

    /* renamed from: a */
    public Iterator<T> mo1859a() {
        HashSet p = bkx.m7603p(this.f2888b);
        if (p.isEmpty()) {
            return this.f2887a.mo1859a();
        }
        return bkx.m7593k(this.f2887a, new bme(p)).mo1859a();
    }
}
