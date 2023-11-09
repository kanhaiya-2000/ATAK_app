package atakplugin.UASTool;

import atakplugin.UASTool.C0693ny;
import atakplugin.UASTool.C0735ph;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: atakplugin.UASTool.xc */
public abstract class C1018xc implements C1026xj {

    /* renamed from: g_ */
    String f7543g_;

    /* renamed from: h_ */
    List<C1021xe> f7544h_ = new ArrayList();

    /* renamed from: i_ */
    Map<adx, long[]> f7545i_ = new HashMap();

    /* renamed from: a */
    public List<C0693ny.C0694a> mo6139a() {
        return null;
    }

    /* renamed from: b */
    public long[] mo6140b() {
        return null;
    }

    /* renamed from: c */
    public List<C0735ph.C0736a> mo6141c() {
        return null;
    }

    /* renamed from: d */
    public C0746pq mo6142d() {
        return null;
    }

    public C1018xc(String str) {
        this.f7543g_ = str;
    }

    /* renamed from: e */
    public long mo6143e() {
        long j = 0;
        for (long j2 : mo12m()) {
            j += j2;
        }
        return j;
    }

    /* renamed from: f */
    public String mo6144f() {
        return this.f7543g_;
    }

    /* renamed from: g */
    public List<C1021xe> mo6145g() {
        return this.f7544h_;
    }

    /* renamed from: h */
    public Map<adx, long[]> mo6146h() {
        return this.f7545i_;
    }
}
