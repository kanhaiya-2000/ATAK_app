package atakplugin.UASTool;

import atakplugin.UASTool.C0693ny;
import atakplugin.UASTool.C0735ph;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* renamed from: atakplugin.UASTool.zb */
public class C1079zb implements C1026xj {

    /* renamed from: a */
    C1026xj f7848a;

    /* renamed from: b */
    private int f7849b;

    public C1079zb(C1026xj xjVar, int i) {
        this.f7848a = xjVar;
        this.f7849b = i;
    }

    /* renamed from: a */
    static List<C0693ny.C0694a> m14894a(List<C0693ny.C0694a> list, int i) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (C0693ny.C0694a next : list) {
            arrayList.add(new C0693ny.C0694a(next.mo5142a(), next.mo5144b() * i));
        }
        return arrayList;
    }

    public void close() {
        this.f7848a.close();
    }

    /* renamed from: n */
    public C0737pi mo13n() {
        return this.f7848a.mo13n();
    }

    /* renamed from: a */
    public List<C0693ny.C0694a> mo6139a() {
        return m14894a(this.f7848a.mo6139a(), this.f7849b);
    }

    /* renamed from: b */
    public long[] mo6140b() {
        return this.f7848a.mo6140b();
    }

    /* renamed from: c */
    public List<C0735ph.C0736a> mo6141c() {
        return this.f7848a.mo6141c();
    }

    /* renamed from: o */
    public C1027xk mo14o() {
        C1027xk xkVar = (C1027xk) this.f7848a.mo14o().clone();
        xkVar.mo6174a(this.f7848a.mo14o().mo6178b() * ((long) this.f7849b));
        return xkVar;
    }

    /* renamed from: p */
    public String mo15p() {
        return this.f7848a.mo15p();
    }

    /* renamed from: l */
    public List<C1024xh> mo11l() {
        return this.f7848a.mo11l();
    }

    /* renamed from: m */
    public long[] mo12m() {
        long[] jArr = new long[this.f7848a.mo12m().length];
        for (int i = 0; i < this.f7848a.mo12m().length; i++) {
            jArr[i] = this.f7848a.mo12m()[i] * ((long) this.f7849b);
        }
        return jArr;
    }

    /* renamed from: d */
    public C0746pq mo6142d() {
        return this.f7848a.mo6142d();
    }

    /* renamed from: e */
    public long mo6143e() {
        return this.f7848a.mo6143e() * ((long) this.f7849b);
    }

    public String toString() {
        return "MultiplyTimeScaleTrack{source=" + this.f7848a + '}';
    }

    /* renamed from: f */
    public String mo6144f() {
        return "timscale(" + this.f7848a.mo6144f() + ")";
    }

    /* renamed from: g */
    public List<C1021xe> mo6145g() {
        return this.f7848a.mo6145g();
    }

    /* renamed from: h */
    public Map<adx, long[]> mo6146h() {
        return this.f7848a.mo6146h();
    }
}
