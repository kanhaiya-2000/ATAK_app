package atakplugin.UASTool;

import java.util.Map;

/* renamed from: atakplugin.UASTool.ai */
final class C0048ai implements C0391ei<Map<K, A>, M> {

    /* renamed from: a */
    final /* synthetic */ C0391ei f1388a;

    C0048ai(C0391ei eiVar) {
        this.f1388a = eiVar;
    }

    /* renamed from: a */
    public M apply(Map<K, A> map) {
        for (Map.Entry next : map.entrySet()) {
            next.setValue(this.f1388a.apply(next.getValue()));
        }
        return map;
    }
}
