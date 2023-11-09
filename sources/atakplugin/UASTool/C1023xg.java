package atakplugin.UASTool;

import atakplugin.UASTool.C0693ny;
import atakplugin.UASTool.C0704oh;
import atakplugin.UASTool.C0735ph;
import atakplugin.UASTool.C0746pq;
import atakplugin.UASTool.C0751pt;
import atakplugin.UASTool.C0786qy;
import atakplugin.UASTool.aeb;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: atakplugin.UASTool.xg */
public class C1023xg extends C1018xc {

    /* renamed from: d */
    private List<C1024xh> f7560d;

    /* renamed from: e */
    C0754pv f7561e;

    /* renamed from: f */
    C0678nj[] f7562f;

    /* renamed from: g */
    private C0737pi f7563g;

    /* renamed from: h */
    private long[] f7564h;

    /* renamed from: i */
    private List<C0693ny.C0694a> f7565i;

    /* renamed from: j */
    private long[] f7566j = null;

    /* renamed from: k */
    private List<C0735ph.C0736a> f7567k;

    /* renamed from: l */
    private C1027xk f7568l = new C1027xk();

    /* renamed from: m */
    private String f7569m;

    /* renamed from: n */
    private C0746pq f7570n = null;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C1023xg(String str, C0754pv pvVar, C0678nj... njVarArr) {
        super(str);
        Iterator<C0786qy> it;
        Iterator<C0786qy.C0787a> it2;
        ArrayList arrayList;
        Iterator it3;
        C0778qr qrVar;
        int i;
        C0754pv pvVar2 = pvVar;
        C0678nj[] njVarArr2 = njVarArr;
        long j = pvVar.mo5377a().mo5394j();
        this.f7560d = new C0790ra(pvVar2, njVarArr2);
        C0739pk a = pvVar.mo5379d().mo5225a().mo5237a();
        this.f7569m = pvVar.mo5379d().mo5227d().mo36c();
        ArrayList arrayList2 = new ArrayList();
        this.f7565i = new ArrayList();
        this.f7567k = new ArrayList();
        arrayList2.addAll(a.mo5326j().mo36c());
        if (a.mo5328l() != null) {
            this.f7565i.addAll(a.mo5328l().mo5140a());
        }
        if (a.mo5329m() != null) {
            this.f7567k.addAll(a.mo5329m().mo36c());
        }
        if (a.mo5327k() != null) {
            this.f7566j = a.mo5327k().mo36c();
        }
        String str2 = C0746pq.f5712a;
        this.f7570n = (C0746pq) aft.m883a((C1003wo) a, str2);
        ArrayList<C0774qn> arrayList3 = new ArrayList<>();
        arrayList3.addAll(((C0688nt) pvVar.mo1474e()).mo1474e().mo202a(C0774qn.class));
        int length = njVarArr2.length;
        int i2 = 0;
        int i3 = 0;
        while (i3 < length) {
            long j2 = j;
            String str3 = str2;
            ArrayList arrayList4 = arrayList3;
            arrayList4.addAll(njVarArr2[i3].mo202a(C0774qn.class));
            i3++;
            arrayList3 = arrayList4;
            j = j2;
            i2 = 0;
        }
        this.f7563g = a.mo5322a();
        List<C0772ql> a2 = pvVar.mo1474e().mo202a(C0772ql.class);
        if (a2.size() > 0) {
            Iterator<C0772ql> it4 = a2.iterator();
            while (it4.hasNext()) {
                for (C0780qt next : it4.next().mo202a(C0780qt.class)) {
                    if (next.mo36c() == j) {
                        if (aft.m890b(((C0688nt) pvVar.mo1474e()).mo1474e(), "/moof/traf/subs").size() > 0) {
                            this.f7570n = new C0746pq();
                        }
                        Iterator it5 = arrayList3.iterator();
                        long j3 = 1;
                        while (it5.hasNext()) {
                            for (C0782qv next2 : ((C0774qn) it5.next()).mo202a(C0782qv.class)) {
                                if (next2.mo5492a().mo5504m() == j) {
                                    C0746pq pqVar = (C0746pq) aft.m883a((C1003wo) next2, str2);
                                    Iterator<C0772ql> it6 = it4;
                                    long j4 = j;
                                    if (pqVar != null) {
                                        long j5 = (j3 - ((long) i2)) - 1;
                                        Iterator<C0746pq.C0747a> it7 = pqVar.mo36c().iterator();
                                        while (it7.hasNext()) {
                                            C0746pq.C0747a next3 = it7.next();
                                            C0746pq.C0747a aVar = new C0746pq.C0747a();
                                            Iterator<C0746pq.C0747a> it8 = it7;
                                            String str4 = str2;
                                            aVar.mo5353c().addAll(next3.mo5353c());
                                            long j6 = 0;
                                            if (j5 != 0) {
                                                aVar.mo5351a(j5 + next3.mo5350a());
                                            } else {
                                                j6 = j5;
                                                aVar.mo5351a(next3.mo5350a());
                                            }
                                            j5 = j6;
                                            this.f7570n.mo36c().add(aVar);
                                            it7 = it8;
                                            str2 = str4;
                                        }
                                    }
                                    String str5 = str2;
                                    Iterator<C0786qy> it9 = next2.mo202a(C0786qy.class).iterator();
                                    while (it9.hasNext()) {
                                        C0786qy next4 = it9.next();
                                        C0783qw a3 = ((C0782qv) next4.mo1474e()).mo5492a();
                                        Iterator<C0786qy.C0787a> it10 = next4.mo36c().iterator();
                                        int i4 = 1;
                                        boolean z = true;
                                        while (it10.hasNext()) {
                                            C0786qy.C0787a next5 = it10.next();
                                            if (next4.mo5549n()) {
                                                if (arrayList2.size() != 0) {
                                                    it = it9;
                                                    if (((C0751pt.C0752a) arrayList2.get(arrayList2.size() - 1)).mo5371b() == next5.mo5555a()) {
                                                        C0751pt.C0752a aVar2 = (C0751pt.C0752a) arrayList2.get(arrayList2.size() - i4);
                                                        it2 = it10;
                                                        arrayList = arrayList3;
                                                        it3 = it5;
                                                        aVar2.mo5370a(aVar2.mo5369a() + 1);
                                                    }
                                                } else {
                                                    it = it9;
                                                }
                                                it2 = it10;
                                                arrayList = arrayList3;
                                                it3 = it5;
                                                arrayList2.add(new C0751pt.C0752a(1, next5.mo5555a()));
                                            } else {
                                                it = it9;
                                                it2 = it10;
                                                arrayList = arrayList3;
                                                it3 = it5;
                                                if (a3.mo5501j()) {
                                                    arrayList2.add(new C0751pt.C0752a(1, a3.mo5507p()));
                                                } else {
                                                    arrayList2.add(new C0751pt.C0752a(1, next.mo5486j()));
                                                }
                                            }
                                            if (next4.mo5551p()) {
                                                if (this.f7565i.size() != 0) {
                                                    List<C0693ny.C0694a> list = this.f7565i;
                                                    i = 1;
                                                    if (((long) list.get(list.size() - 1).mo5144b()) == next5.mo5562d()) {
                                                        List<C0693ny.C0694a> list2 = this.f7565i;
                                                        C0693ny.C0694a aVar3 = list2.get(list2.size() - 1);
                                                        aVar3.mo5143a(aVar3.mo5142a() + 1);
                                                    }
                                                } else {
                                                    i = 1;
                                                }
                                                this.f7565i.add(new C0693ny.C0694a(i, afi.m847a(next5.mo5562d())));
                                            }
                                            if (next4.mo5550o()) {
                                                qrVar = next5.mo5561c();
                                            } else if (z && next4.mo5547l()) {
                                                qrVar = next4.mo5553r();
                                            } else if (a3.mo5503l()) {
                                                qrVar = a3.mo5509r();
                                            } else {
                                                qrVar = next.mo5488l();
                                            }
                                            if (qrVar == null || qrVar.mo5471g()) {
                                                z = false;
                                            } else {
                                                z = false;
                                                this.f7566j = afs.m880a(this.f7566j, j3);
                                            }
                                            j3++;
                                            it9 = it;
                                            it5 = it3;
                                            arrayList3 = arrayList;
                                            it10 = it2;
                                            i4 = 1;
                                        }
                                    }
                                    it4 = it6;
                                    j = j4;
                                    str2 = str5;
                                }
                                i2 = 0;
                            }
                        }
                    }
                }
            }
            new ArrayList();
            new ArrayList();
            for (C0774qn a4 : arrayList3) {
                for (C0782qv next6 : a4.mo202a(C0782qv.class)) {
                    if (next6.mo5492a().mo5504m() == j) {
                        this.f7545i_ = m14511a(aft.m890b((C0695nz) next6, aea.f612a), aft.m890b((C0695nz) next6, aeb.f622a), this.f7545i_);
                    }
                }
            }
        } else {
            this.f7545i_ = m14511a(a.mo202a(aea.class), a.mo202a(aeb.class), this.f7545i_);
        }
        this.f7564h = C0751pt.m12977b((List<C0751pt.C0752a>) arrayList2);
        C0720ou b = pvVar.mo5379d().mo5226b();
        C0755pw a5 = pvVar.mo5377a();
        this.f7568l.mo6181b(a5.mo5394j());
        this.f7568l.mo6182b(b.mo36c());
        this.f7568l.mo6176a(b.mo5235l());
        this.f7568l.mo6177a(b.mo43i());
        this.f7568l.mo6174a(b.mo5233j());
        this.f7568l.mo6179b(a5.mo5401q());
        this.f7568l.mo6171a(a5.mo5400p());
        this.f7568l.mo6173a(a5.mo5396l());
        this.f7568l.mo6175a(a5.mo5399o());
        this.f7568l.mo6172a(a5.mo5398n());
        C0704oh ohVar = (C0704oh) aft.m883a((C1003wo) pvVar2, "edts/elst");
        C0724oy oyVar = (C0724oy) aft.m883a((C1003wo) pvVar2, "../mvhd");
        if (ohVar != null) {
            for (Iterator<C0704oh.C0705a> it11 = ohVar.mo36c().iterator(); it11.hasNext(); it11 = it11) {
                C0704oh.C0705a next7 = it11.next();
                this.f7544h_.add(new C1021xe(next7.mo5169b(), b.mo5233j(), next7.mo5171c(), ((double) next7.mo5165a()) / ((double) oyVar.mo5262j())));
                b = b;
            }
        }
    }

    /* renamed from: a */
    private Map<adx, long[]> m14511a(List<aea> list, List<aeb> list2, Map<adx, long[]> map) {
        Map<adx, long[]> map2 = map;
        for (aea next : list) {
            boolean z = false;
            for (aeb next2 : list2) {
                if (next2.mo36c().equals(next.mo43i().get(0).mo377a())) {
                    int i = 0;
                    for (aeb.C0016a next3 : next2.mo423j()) {
                        if (next3.mo427b() > 0) {
                            adx adx = next.mo43i().get(next3.mo427b() - 1);
                            long[] jArr = map2.get(adx);
                            if (jArr == null) {
                                jArr = new long[0];
                            }
                            long[] jArr2 = new long[(afi.m847a(next3.mo424a()) + jArr.length)];
                            System.arraycopy(jArr, 0, jArr2, 0, jArr.length);
                            for (int i2 = 0; ((long) i2) < next3.mo424a(); i2++) {
                                jArr2[jArr.length + i2] = (long) (i + i2);
                            }
                            map2.put(adx, jArr2);
                        }
                        i = (int) (((long) i) + next3.mo424a());
                    }
                    z = true;
                }
            }
            if (!z) {
                throw new RuntimeException("Could not find SampleToGroupBox for " + next.mo43i().get(0).mo377a() + ".");
            }
        }
        return map2;
    }

    public void close() {
        C0695nz e = this.f7561e.mo1474e();
        if (e instanceof C1005wq) {
            ((C1005wq) e).close();
        }
        for (C0678nj close : this.f7562f) {
            close.close();
        }
    }

    /* renamed from: l */
    public List<C1024xh> mo11l() {
        return this.f7560d;
    }

    /* renamed from: m */
    public synchronized long[] mo12m() {
        return this.f7564h;
    }

    /* renamed from: n */
    public C0737pi mo13n() {
        return this.f7563g;
    }

    /* renamed from: a */
    public List<C0693ny.C0694a> mo6139a() {
        return this.f7565i;
    }

    /* renamed from: b */
    public long[] mo6140b() {
        long[] jArr = this.f7566j;
        if (jArr == null || jArr.length == this.f7560d.size()) {
            return null;
        }
        return this.f7566j;
    }

    /* renamed from: c */
    public List<C0735ph.C0736a> mo6141c() {
        return this.f7567k;
    }

    /* renamed from: o */
    public C1027xk mo14o() {
        return this.f7568l;
    }

    /* renamed from: p */
    public String mo15p() {
        return this.f7569m;
    }

    /* renamed from: d */
    public C0746pq mo6142d() {
        return this.f7570n;
    }
}
