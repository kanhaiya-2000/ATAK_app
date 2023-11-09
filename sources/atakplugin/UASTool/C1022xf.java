package atakplugin.UASTool;

import java.util.LinkedList;
import java.util.List;

/* renamed from: atakplugin.UASTool.xf */
public class C1022xf {

    /* renamed from: a */
    afr f7558a = afr.f870j;

    /* renamed from: b */
    List<C1026xj> f7559b = new LinkedList();

    public C1022xf() {
    }

    public C1022xf(List<C1026xj> list) {
        this.f7559b = list;
    }

    /* renamed from: a */
    public List<C1026xj> mo6159a() {
        return this.f7559b;
    }

    /* renamed from: a */
    public void mo6162a(List<C1026xj> list) {
        this.f7559b = list;
    }

    /* renamed from: a */
    public void mo6161a(C1026xj xjVar) {
        if (mo6158a(xjVar.mo14o().mo6188g()) != null) {
            xjVar.mo14o().mo6181b(mo6163b());
        }
        this.f7559b.add(xjVar);
    }

    public String toString() {
        String str = "Movie{ ";
        for (C1026xj next : this.f7559b) {
            str = String.valueOf(str) + "track_" + next.mo14o().mo6188g() + " (" + next.mo15p() + ") ";
        }
        return String.valueOf(str) + '}';
    }

    /* renamed from: b */
    public long mo6163b() {
        long j = 0;
        for (C1026xj next : this.f7559b) {
            if (j < next.mo14o().mo6188g()) {
                j = next.mo14o().mo6188g();
            }
        }
        return j + 1;
    }

    /* renamed from: a */
    public C1026xj mo6158a(long j) {
        for (C1026xj next : this.f7559b) {
            if (next.mo14o().mo6188g() == j) {
                return next;
            }
        }
        return null;
    }

    /* renamed from: c */
    public long mo6164c() {
        long b = mo6159a().iterator().next().mo14o().mo6178b();
        for (C1026xj o : mo6159a()) {
            b = m14502a(o.mo14o().mo6178b(), b);
        }
        return b;
    }

    /* renamed from: d */
    public afr mo6165d() {
        return this.f7558a;
    }

    /* renamed from: a */
    public void mo6160a(afr afr) {
        this.f7558a = afr;
    }

    /* renamed from: a */
    public static long m14502a(long j, long j2) {
        return j2 == 0 ? j : m14502a(j2, j % j2);
    }
}
