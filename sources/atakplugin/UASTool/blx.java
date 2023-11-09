package atakplugin.UASTool;

import atakplugin.UASTool.bgo;
import java.util.Iterator;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0002¨\u0006\u0004"}, mo1538e = {"kotlin/sequences/SequencesKt___SequencesKt$minus$1", "Lkotlin/sequences/Sequence;", "iterator", "", "kotlin-stdlib"})
public final class blx implements bku<T> {

    /* renamed from: a */
    final /* synthetic */ bku f2875a;

    /* renamed from: b */
    final /* synthetic */ Object f2876b;

    blx(bku<? extends T> bku, Object obj) {
        this.f2875a = bku;
        this.f2876b = obj;
    }

    /* renamed from: a */
    public Iterator<T> mo1859a() {
        bgo.C0151a aVar = new bgo.C0151a();
        aVar.f2661a = false;
        return bkx.m7591j(this.f2875a, new bly(this, aVar)).mo1859a();
    }
}
