package atakplugin.UASTool;

import atakplugin.UASTool.C0693ny;
import atakplugin.UASTool.C0735ph;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* renamed from: atakplugin.UASTool.yw */
public class C1071yw implements C1026xj {

    /* renamed from: a */
    C1026xj f7791a;

    /* renamed from: b */
    private int f7792b;

    public C1071yw(C1026xj xjVar, int i) {
        this.f7791a = xjVar;
        this.f7792b = i;
    }

    public void close() {
        this.f7791a.close();
    }

    /* renamed from: n */
    public C0737pi mo13n() {
        return this.f7791a.mo13n();
    }

    /* renamed from: m */
    public long[] mo12m() {
        long[] jArr = new long[this.f7791a.mo12m().length];
        for (int i = 0; i < this.f7791a.mo12m().length; i++) {
            jArr[i] = this.f7791a.mo12m()[i] / ((long) this.f7792b);
        }
        return jArr;
    }

    /* renamed from: a */
    public List<C0693ny.C0694a> mo6139a() {
        return mo6300i();
    }

    /* renamed from: b */
    public long[] mo6140b() {
        return this.f7791a.mo6140b();
    }

    /* renamed from: c */
    public List<C0735ph.C0736a> mo6141c() {
        return this.f7791a.mo6141c();
    }

    /* renamed from: o */
    public C1027xk mo14o() {
        C1027xk xkVar = (C1027xk) this.f7791a.mo14o().clone();
        xkVar.mo6174a(this.f7791a.mo14o().mo6178b() / ((long) this.f7792b));
        return xkVar;
    }

    /* renamed from: p */
    public String mo15p() {
        return this.f7791a.mo15p();
    }

    /* renamed from: l */
    public List<C1024xh> mo11l() {
        return this.f7791a.mo11l();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public List<C0693ny.C0694a> mo6300i() {
        List<C0693ny.C0694a> a = this.f7791a.mo6139a();
        if (a == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(a.size());
        for (C0693ny.C0694a next : a) {
            arrayList.add(new C0693ny.C0694a(next.mo5142a(), next.mo5144b() / this.f7792b));
        }
        return arrayList;
    }

    /* renamed from: d */
    public C0746pq mo6142d() {
        return this.f7791a.mo6142d();
    }

    /* renamed from: e */
    public long mo6143e() {
        long j = 0;
        for (long j2 : mo12m()) {
            j += j2;
        }
        return j;
    }

    public String toString() {
        return "MultiplyTimeScaleTrack{source=" + this.f7791a + '}';
    }

    /* renamed from: f */
    public String mo6144f() {
        return "timscale(" + this.f7791a.mo6144f() + ")";
    }

    /* renamed from: g */
    public List<C1021xe> mo6145g() {
        return this.f7791a.mo6145g();
    }

    /* renamed from: h */
    public Map<adx, long[]> mo6146h() {
        return this.f7791a.mo6146h();
    }
}
