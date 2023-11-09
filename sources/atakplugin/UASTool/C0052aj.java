package atakplugin.UASTool;

import java.util.Map;

/* renamed from: atakplugin.UASTool.aj */
final class C0052aj implements C0339cv<Map<K, A>, T> {

    /* renamed from: a */
    final /* synthetic */ C0391ei f1597a;

    /* renamed from: b */
    final /* synthetic */ C0000a f1598b;

    C0052aj(C0391ei eiVar, C0000a aVar) {
        this.f1597a = eiVar;
        this.f1598b = aVar;
    }

    /* renamed from: a */
    public void mo128a(Map<K, A> map, T t) {
        Object b = C0293ca.m10964b(this.f1597a.apply(t), "element cannot be mapped to a null key");
        A a = map.get(b);
        if (a == null) {
            a = this.f1598b.mo3a().mo107b();
            map.put(b, a);
        }
        this.f1598b.mo4b().mo128a(a, t);
    }
}
