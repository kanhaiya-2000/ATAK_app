package atakplugin.UASTool;

import atakplugin.UASTool.C0130b;
import java.util.HashMap;
import java.util.Map;

/* renamed from: atakplugin.UASTool.an */
final class C0075an implements C0391ei<C0130b.C0133c<A>, Map<Boolean, D>> {

    /* renamed from: a */
    final /* synthetic */ C0000a f2098a;

    C0075an(C0000a aVar) {
        this.f2098a = aVar;
    }

    /* renamed from: a */
    public Map<Boolean, D> apply(C0130b.C0133c<A> cVar) {
        C0391ei c = this.f2098a.mo5c();
        if (c == null) {
            c = C0130b.m6098g();
        }
        HashMap hashMap = new HashMap(2);
        hashMap.put(Boolean.TRUE, c.apply(cVar.f2466a));
        hashMap.put(Boolean.FALSE, c.apply(cVar.f2467b));
        return hashMap;
    }
}
