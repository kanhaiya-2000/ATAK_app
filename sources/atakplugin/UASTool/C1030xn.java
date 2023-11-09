package atakplugin.UASTool;

import atakplugin.UASTool.C0693ny;
import atakplugin.UASTool.C0704oh;
import atakplugin.UASTool.C0740pl;
import atakplugin.UASTool.C0751pt;
import atakplugin.UASTool.aeb;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/* renamed from: atakplugin.UASTool.xn */
public class C1030xn implements C1038xu {

    /* renamed from: e */
    static final /* synthetic */ boolean f7587e = true;

    /* renamed from: f */
    private static Logger f7588f = Logger.getLogger(C1030xn.class.getName());

    /* renamed from: a */
    Map<C1026xj, C0745pp> f7589a = new HashMap();

    /* renamed from: b */
    Set<akw> f7590b = new HashSet();

    /* renamed from: c */
    HashMap<C1026xj, List<C1024xh>> f7591c = new HashMap<>();

    /* renamed from: d */
    HashMap<C1026xj, long[]> f7592d = new HashMap<>();

    /* renamed from: g */
    private C1037xt f7593g;

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public C0688nt mo6208c(C1022xf xfVar) {
        return null;
    }

    /* renamed from: a */
    private static long m14578a(int[] iArr) {
        long j = 0;
        for (int i : iArr) {
            j += (long) i;
        }
        return j;
    }

    /* renamed from: a */
    private static long m14579a(long[] jArr) {
        long j = 0;
        for (long j2 : jArr) {
            j += j2;
        }
        return j;
    }

    /* renamed from: a */
    public static long m14577a(long j, long j2) {
        return j2 == 0 ? j : m14577a(j2, j % j2);
    }

    /* renamed from: a */
    public void mo6202a(C1037xt xtVar) {
        this.f7593g = xtVar;
    }

    /* renamed from: a */
    public C0695nz mo6195a(C1022xf xfVar) {
        C0688nt next;
        if (this.f7593g == null) {
            this.f7593g = new C1041xx(xfVar, 2);
        }
        f7588f.fine("Creating movie " + xfVar);
        Iterator<C1026xj> it = xfVar.mo6159a().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            C1026xj next2 = it.next();
            List<C1024xh> l = next2.mo11l();
            mo6198a(next2, l);
            int size = l.size();
            long[] jArr = new long[size];
            for (int i = 0; i < size; i++) {
                jArr[i] = l.get(i).mo7a();
            }
            this.f7592d.put(next2, jArr);
        }
        C1005wq wqVar = new C1005wq();
        wqVar.mo170a((C0688nt) mo6205b(xfVar));
        HashMap hashMap = new HashMap();
        for (C1026xj next3 : xfVar.mo6159a()) {
            hashMap.put(next3, mo6207b(next3, xfVar));
        }
        C0723ox a = mo6196a(xfVar, (Map<C1026xj, int[]>) hashMap);
        wqVar.mo170a((C0688nt) a);
        long j = 0;
        for (C0738pj j2 : aft.m889b((C0688nt) a, "trak/mdia/minf/stbl/stsz")) {
            j += m14579a(j2.mo5320j());
        }
        C1031a aVar = new C1031a(this, xfVar, hashMap, j, (C1031a) null);
        wqVar.mo170a((C0688nt) aVar);
        long a2 = aVar.mo6215a();
        for (C0745pp a3 : this.f7589a.values()) {
            long[] a4 = a3.mo5123a();
            for (int i2 = 0; i2 < a4.length; i2++) {
                a4[i2] = a4[i2] + a2;
            }
        }
        for (akw next4 : this.f7590b) {
            long f = next4.mo19f() + 44;
            C0695nz nzVar = next4;
            while (true) {
                C0695nz e = nzVar.mo1474e();
                Iterator<C0688nt> it2 = e.mo36c().iterator();
                while (it2.hasNext() && (next = it2.next()) != nzVar) {
                    f += next.mo19f();
                }
                if (!(e instanceof C0688nt)) {
                    break;
                }
                nzVar = e;
            }
            long[] j3 = next4.mo1196j();
            for (int i3 = 0; i3 < j3.length; i3++) {
                j3[i3] = j3[i3] + f;
            }
            next4.mo1194a(j3);
        }
        return wqVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public List<C1024xh> mo6198a(C1026xj xjVar, List<C1024xh> list) {
        return this.f7591c.put(xjVar, list);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public C0706oi mo6205b(C1022xf xfVar) {
        LinkedList linkedList = new LinkedList();
        linkedList.add("mp42");
        linkedList.add("isom");
        return new C0706oi("mp42", 0, linkedList);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C0723ox mo6196a(C1022xf xfVar, Map<C1026xj, int[]> map) {
        long j;
        C0723ox oxVar = new C0723ox();
        C0724oy oyVar = new C0724oy();
        oyVar.mo5252a(new Date());
        oyVar.mo5254b(new Date());
        oyVar.mo5251a(xfVar.mo6165d());
        long d = mo6210d(xfVar);
        long j2 = 0;
        for (C1026xj next : xfVar.mo6159a()) {
            C1022xf xfVar2 = xfVar;
            Map<C1026xj, int[]> map2 = map;
            if (next.mo6145g() == null || next.mo6145g().isEmpty()) {
                j = (next.mo6143e() * d) / next.mo14o().mo6178b();
            } else {
                double d2 = 0.0d;
                for (C1021xe b : next.mo6145g()) {
                    d2 += (double) ((long) b.mo6155b());
                }
                j = (long) (d2 * ((double) d));
            }
            if (j > j2) {
                j2 = j;
            }
        }
        oyVar.mo5253b(j2);
        oyVar.mo5250a(d);
        long j3 = 0;
        for (C1026xj next2 : xfVar.mo6159a()) {
            C1022xf xfVar3 = xfVar;
            Map<C1026xj, int[]> map3 = map;
            if (j3 < next2.mo14o().mo6188g()) {
                j3 = next2.mo14o().mo6188g();
            }
        }
        oyVar.mo5256c(j3 + 1);
        oxVar.mo170a((C0688nt) oyVar);
        for (C1026xj a : xfVar.mo6159a()) {
            oxVar.mo170a((C0688nt) mo6197a(a, xfVar, map));
        }
        C0688nt c = mo6208c(xfVar);
        if (c != null) {
            oxVar.mo170a(c);
        }
        return oxVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C0754pv mo6197a(C1026xj xjVar, C1022xf xfVar, Map<C1026xj, int[]> map) {
        C0754pv pvVar = new C0754pv();
        C0755pw pwVar = new C0755pw();
        pwVar.mo5385a(true);
        pwVar.mo5389b(true);
        pwVar.mo5391c(true);
        pwVar.mo5393d(true);
        pwVar.mo5383a(xjVar.mo14o().mo6192k());
        pwVar.mo5392d(xjVar.mo14o().mo6191j());
        pwVar.mo5384a(xjVar.mo14o().mo6185d());
        if (xjVar.mo6145g() == null || xjVar.mo6145g().isEmpty()) {
            pwVar.mo5387b((xjVar.mo6143e() * mo6210d(xfVar)) / xjVar.mo14o().mo6178b());
        } else {
            long j = 0;
            for (C1021xe b : xjVar.mo6145g()) {
                j += (long) b.mo6155b();
            }
            pwVar.mo5387b(j * xjVar.mo14o().mo6178b());
        }
        pwVar.mo5386b(xjVar.mo14o().mo6187f());
        pwVar.mo5380a(xjVar.mo14o().mo6186e());
        pwVar.mo5390c(xjVar.mo14o().mo6189h());
        pwVar.mo5388b(new Date());
        pwVar.mo5382a(xjVar.mo14o().mo6188g());
        pwVar.mo5381a(xjVar.mo14o().mo6190i());
        pvVar.mo170a((C0688nt) pwVar);
        pvVar.mo170a(mo6194a(xjVar, xfVar));
        C0719ot otVar = new C0719ot();
        pvVar.mo170a((C0688nt) otVar);
        C0720ou ouVar = new C0720ou();
        ouVar.mo5230a(xjVar.mo14o().mo6185d());
        ouVar.mo5231b(xjVar.mo6143e());
        ouVar.mo5228a(xjVar.mo14o().mo6178b());
        ouVar.mo5229a(xjVar.mo14o().mo6170a());
        otVar.mo170a((C0688nt) ouVar);
        C0711on onVar = new C0711on();
        otVar.mo170a((C0688nt) onVar);
        onVar.mo5193b(xjVar.mo15p());
        C0721ov ovVar = new C0721ov();
        if (xjVar.mo15p().equals("vide")) {
            ovVar.mo170a((C0688nt) new C0761qb());
        } else if (xjVar.mo15p().equals("soun")) {
            ovVar.mo170a((C0688nt) new C0744po());
        } else if (xjVar.mo15p().equals("text")) {
            ovVar.mo170a((C0688nt) new C0725oz());
        } else if (xjVar.mo15p().equals("subt")) {
            ovVar.mo170a((C0688nt) new C0749pr());
        } else if (xjVar.mo15p().equals("hint")) {
            ovVar.mo170a((C0688nt) new C0712oo());
        } else if (xjVar.mo15p().equals("sbtl")) {
            ovVar.mo170a((C0688nt) new C0725oz());
        }
        C0700od odVar = new C0700od();
        C0701oe oeVar = new C0701oe();
        odVar.mo170a((C0688nt) oeVar);
        C0698ob obVar = new C0698ob();
        obVar.mo5159b(1);
        oeVar.mo170a((C0688nt) obVar);
        ovVar.mo170a((C0688nt) odVar);
        ovVar.mo170a(mo6204b(xjVar, xfVar, map));
        otVar.mo170a((C0688nt) ovVar);
        return pvVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C0688nt mo6194a(C1026xj xjVar, C1022xf xfVar) {
        if (xjVar.mo6145g() == null || xjVar.mo6145g().size() <= 0) {
            return null;
        }
        C0704oh ohVar = new C0704oh();
        ohVar.mo5158a_(0);
        ArrayList arrayList = new ArrayList();
        for (C1021xe next : xjVar.mo6145g()) {
            arrayList.add(new C0704oh.C0705a(ohVar, Math.round(next.mo6155b() * ((double) xfVar.mo6164c())), (next.mo6156c() * xjVar.mo14o().mo6178b()) / next.mo6154a(), next.mo6157d()));
        }
        ohVar.mo5163a((List<C0704oh.C0705a>) arrayList);
        C0703og ogVar = new C0703og();
        ogVar.mo170a((C0688nt) ohVar);
        return ogVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public C0688nt mo6204b(C1026xj xjVar, C1022xf xfVar, Map<C1026xj, int[]> map) {
        C1026xj xjVar2 = xjVar;
        Map<C1026xj, int[]> map2 = map;
        C0739pk pkVar = new C0739pk();
        mo6206b(xjVar2, pkVar);
        mo6214g(xjVar2, pkVar);
        mo6213f(xjVar2, pkVar);
        mo6212e(xjVar2, pkVar);
        mo6211d(xjVar2, pkVar);
        mo6201a(xjVar2, map2, pkVar);
        mo6209c(xjVar2, pkVar);
        mo6200a(xjVar2, xfVar, map2, pkVar);
        HashMap hashMap = new HashMap();
        for (Map.Entry next : xjVar.mo6146h().entrySet()) {
            String a = ((adx) next.getKey()).mo377a();
            List list = (List) hashMap.get(a);
            if (list == null) {
                list = new ArrayList();
                hashMap.put(a, list);
            }
            list.add((adx) next.getKey());
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            aea aea = new aea();
            aea.mo415a((List<adx>) (List) entry.getValue());
            aeb aeb = new aeb();
            aeb.mo420a((String) entry.getKey());
            aeb.C0016a aVar = null;
            for (int i = 0; i < xjVar.mo11l().size(); i++) {
                int i2 = 0;
                for (int i3 = 0; i3 < ((List) entry.getValue()).size(); i3++) {
                    if (Arrays.binarySearch(xjVar.mo6146h().get((adx) ((List) entry.getValue()).get(i3)), (long) i) >= 0) {
                        i2 = i3 + 1;
                    }
                }
                if (aVar == null || aVar.mo427b() != i2) {
                    aeb.C0016a aVar2 = new aeb.C0016a(1, i2);
                    aeb.mo423j().add(aVar2);
                    aVar = aVar2;
                } else {
                    aVar.mo426a(aVar.mo424a() + 1);
                }
            }
            pkVar.mo170a((C0688nt) aea);
            pkVar.mo170a((C0688nt) aeb);
        }
        if (xjVar2 instanceof C1062yo) {
            mo6203a((C1062yo) xjVar2, pkVar, map2.get(xjVar2));
        }
        mo6199a(xjVar2, pkVar);
        return pkVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo6199a(C1026xj xjVar, C0739pk pkVar) {
        if (xjVar.mo6142d() != null) {
            pkVar.mo170a((C0688nt) xjVar.mo6142d());
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo6203a(C1062yo yoVar, C0739pk pkVar, int[] iArr) {
        C0739pk pkVar2 = pkVar;
        int[] iArr2 = iArr;
        akx akx = new akx();
        akx.mo1197a("cenc");
        akx.mo5159b(1);
        List<alo> k = yoVar.mo6149k();
        if (yoVar.mo6148j()) {
            int size = k.size();
            short[] sArr = new short[size];
            for (int i = 0; i < size; i++) {
                sArr[i] = (short) k.get(i).mo1401a();
            }
            akx.mo1198a(sArr);
        } else {
            akx.mo1201d(8);
            akx.mo1202e(yoVar.mo11l().size());
        }
        akw akw = new akw();
        ada ada = new ada();
        ada.mo49a(yoVar.mo6148j());
        ada.mo48a(k);
        long c = (long) ada.mo36c();
        long[] jArr = new long[iArr2.length];
        int i2 = 0;
        for (int i3 = 0; i3 < iArr2.length; i3++) {
            jArr[i3] = c;
            int i4 = 0;
            while (i4 < iArr2[i3]) {
                c += (long) k.get(i2).mo1401a();
                i4++;
                i2++;
                ada = ada;
            }
        }
        akw.mo1194a(jArr);
        pkVar2.mo170a((C0688nt) akx);
        pkVar2.mo170a((C0688nt) akw);
        pkVar2.mo170a((C0688nt) ada);
        this.f7590b.add(akw);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo6206b(C1026xj xjVar, C0739pk pkVar) {
        pkVar.mo170a((C0688nt) xjVar.mo13n());
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo6200a(C1026xj xjVar, C1022xf xfVar, Map<C1026xj, int[]> map, C0739pk pkVar) {
        char c;
        int i;
        C1026xj xjVar2 = xjVar;
        Map<C1026xj, int[]> map2 = map;
        if (this.f7589a.get(xjVar2) == null) {
            if (f7588f.isLoggable(Level.FINE)) {
                f7588f.fine("Calculating chunk offsets for track_" + xjVar.mo14o().mo6188g());
            }
            ArrayList<C1026xj> arrayList = new ArrayList<>(map.keySet());
            Collections.sort(arrayList, new C1032xo(this));
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            HashMap hashMap3 = new HashMap();
            Iterator it = arrayList.iterator();
            while (true) {
                c = 0;
                if (!it.hasNext()) {
                    break;
                }
                ArrayList arrayList2 = arrayList;
                C1026xj xjVar3 = (C1026xj) it.next();
                hashMap.put(xjVar3, 0);
                hashMap2.put(xjVar3, 0);
                hashMap3.put(xjVar3, Double.valueOf(0.0d));
                this.f7589a.put(xjVar3, new C0745pp());
                arrayList = arrayList2;
            }
            long j = 0;
            while (true) {
                C1026xj xjVar4 = null;
                for (C1026xj xjVar5 : arrayList) {
                    ArrayList arrayList3 = arrayList;
                    if ((xjVar4 == null || ((Double) hashMap3.get(xjVar5)).doubleValue() < ((Double) hashMap3.get(xjVar4)).doubleValue()) && ((Integer) hashMap.get(xjVar5)).intValue() < map2.get(xjVar5).length) {
                        xjVar4 = xjVar5;
                    }
                    arrayList = arrayList3;
                    c = 0;
                }
                if (xjVar4 == null) {
                    break;
                }
                C0690nv nvVar = this.f7589a.get(xjVar4);
                long[] a = nvVar.mo5123a();
                long[] jArr = new long[1];
                jArr[c] = j;
                nvVar.mo5122a(afs.m880a(a, jArr));
                int intValue = ((Integer) hashMap.get(xjVar4)).intValue();
                int i2 = map2.get(xjVar4)[intValue];
                int intValue2 = ((Integer) hashMap2.get(xjVar4)).intValue();
                double doubleValue = ((Double) hashMap3.get(xjVar4)).doubleValue();
                int i3 = intValue2;
                while (true) {
                    i = intValue2 + i2;
                    if (i3 >= i) {
                        break;
                    }
                    long j2 = j + this.f7592d.get(xjVar4)[i3];
                    doubleValue += ((double) xjVar4.mo12m()[i3]) / ((double) xjVar4.mo14o().mo6178b());
                    i3++;
                    arrayList = arrayList;
                    intValue = intValue;
                    j = j2;
                }
                hashMap.put(xjVar4, Integer.valueOf(intValue + 1));
                hashMap2.put(xjVar4, Integer.valueOf(i));
                hashMap3.put(xjVar4, Double.valueOf(doubleValue));
                c = 0;
            }
        }
        pkVar.mo170a((C0688nt) this.f7589a.get(xjVar2));
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo6209c(C1026xj xjVar, C0739pk pkVar) {
        C0738pj pjVar = new C0738pj();
        pjVar.mo5318a(this.f7592d.get(xjVar));
        pkVar.mo170a((C0688nt) pjVar);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo6201a(C1026xj xjVar, Map<C1026xj, int[]> map, C0739pk pkVar) {
        int[] iArr = map.get(xjVar);
        C0740pl plVar = new C0740pl();
        plVar.mo5330a((List<C0740pl.C0741a>) new LinkedList());
        long j = -2147483648L;
        for (int i = 0; i < iArr.length; i++) {
            if (j != ((long) iArr[i])) {
                plVar.mo36c().add(new C0740pl.C0741a((long) (i + 1), (long) iArr[i], 1));
                j = (long) iArr[i];
            }
        }
        pkVar.mo170a((C0688nt) plVar);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public void mo6211d(C1026xj xjVar, C0739pk pkVar) {
        if (xjVar.mo6141c() != null && !xjVar.mo6141c().isEmpty()) {
            C0735ph phVar = new C0735ph();
            phVar.mo5303a(xjVar.mo6141c());
            pkVar.mo170a((C0688nt) phVar);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public void mo6212e(C1026xj xjVar, C0739pk pkVar) {
        long[] b = xjVar.mo6140b();
        if (b != null && b.length > 0) {
            C0750ps psVar = new C0750ps();
            psVar.mo5365a(b);
            pkVar.mo170a((C0688nt) psVar);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public void mo6213f(C1026xj xjVar, C0739pk pkVar) {
        List<C0693ny.C0694a> a = xjVar.mo6139a();
        if (a != null && !a.isEmpty()) {
            C0693ny nyVar = new C0693ny();
            nyVar.mo5141a(a);
            pkVar.mo170a((C0688nt) nyVar);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: g */
    public void mo6214g(C1026xj xjVar, C0739pk pkVar) {
        ArrayList arrayList = new ArrayList();
        C0751pt.C0752a aVar = null;
        for (long j : xjVar.mo12m()) {
            if (aVar == null || aVar.mo5371b() != j) {
                aVar = new C0751pt.C0752a(1, j);
                arrayList.add(aVar);
            } else {
                aVar.mo5370a(aVar.mo5369a() + 1);
            }
        }
        C0751pt ptVar = new C0751pt();
        ptVar.mo5367a((List<C0751pt.C0752a>) arrayList);
        pkVar.mo170a((C0688nt) ptVar);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int[] mo6207b(C1026xj xjVar, C1022xf xfVar) {
        long j;
        long[] a = this.f7593g.mo6257a(xjVar);
        int[] iArr = new int[a.length];
        int i = 0;
        while (i < a.length) {
            long j2 = a[i] - 1;
            int i2 = i + 1;
            if (a.length == i2) {
                j = (long) xjVar.mo11l().size();
            } else {
                j = a[i2] - 1;
            }
            iArr[i] = afi.m847a(j - j2);
            i = i2;
        }
        if (f7587e || ((long) this.f7591c.get(xjVar).size()) == m14578a(iArr)) {
            return iArr;
        }
        throw new AssertionError("The number of samples and the sum of all chunk lengths must be equal");
    }

    /* renamed from: d */
    public long mo6210d(C1022xf xfVar) {
        long b = xfVar.mo6159a().iterator().next().mo14o().mo6178b();
        for (C1026xj o : xfVar.mo6159a()) {
            b = afq.m875b(b, o.mo14o().mo6178b());
        }
        return b;
    }

    /* renamed from: atakplugin.UASTool.xn$a */
    private class C1031a implements C0688nt {

        /* renamed from: a */
        List<C1026xj> f7594a;

        /* renamed from: b */
        List<List<C1024xh>> f7595b;

        /* renamed from: c */
        C0695nz f7596c;

        /* renamed from: d */
        long f7597d;

        /* renamed from: e */
        final /* synthetic */ C1030xn f7598e;

        /* renamed from: a */
        private boolean m14601a(long j) {
            return j + 8 < 4294967296L;
        }

        /* renamed from: a */
        public void mo105a(C1007ws wsVar, ByteBuffer byteBuffer, long j, C0675ng ngVar) {
        }

        /* renamed from: h */
        public String mo1476h() {
            return C0788qz.f6010a;
        }

        private C1031a(C1030xn xnVar, C1022xf xfVar, Map<C1026xj, int[]> map, long j) {
            int i;
            Map<C1026xj, int[]> map2 = map;
            this.f7598e = xnVar;
            this.f7595b = new ArrayList();
            this.f7597d = j;
            this.f7594a = xfVar.mo6159a();
            ArrayList<C1026xj> arrayList = new ArrayList<>(map.keySet());
            Collections.sort(arrayList, new C1033xp(this));
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            HashMap hashMap3 = new HashMap();
            for (C1026xj xjVar : arrayList) {
                hashMap.put(xjVar, 0);
                hashMap2.put(xjVar, 0);
                hashMap3.put(xjVar, Double.valueOf(0.0d));
            }
            while (true) {
                C1026xj xjVar2 = null;
                for (C1026xj xjVar3 : arrayList) {
                    if ((xjVar2 == null || ((Double) hashMap3.get(xjVar3)).doubleValue() < ((Double) hashMap3.get(xjVar2)).doubleValue()) && ((Integer) hashMap.get(xjVar3)).intValue() < map2.get(xjVar3).length) {
                        xjVar2 = xjVar3;
                    }
                }
                if (xjVar2 != null) {
                    int intValue = ((Integer) hashMap.get(xjVar2)).intValue();
                    int i2 = map2.get(xjVar2)[intValue];
                    int intValue2 = ((Integer) hashMap2.get(xjVar2)).intValue();
                    double doubleValue = ((Double) hashMap3.get(xjVar2)).doubleValue();
                    int i3 = intValue2;
                    while (true) {
                        i = intValue2 + i2;
                        if (i3 >= i) {
                            break;
                        }
                        doubleValue += ((double) xjVar2.mo12m()[i3]) / ((double) xjVar2.mo14o().mo6178b());
                        i3++;
                        i2 = i2;
                        intValue = intValue;
                    }
                    this.f7595b.add(xjVar2.mo11l().subList(intValue2, i));
                    hashMap.put(xjVar2, Integer.valueOf(intValue + 1));
                    hashMap2.put(xjVar2, Integer.valueOf(i));
                    hashMap3.put(xjVar2, Double.valueOf(doubleValue));
                } else {
                    return;
                }
            }
        }

        /* synthetic */ C1031a(C1030xn xnVar, C1022xf xfVar, Map map, long j, C1031a aVar) {
            this(xnVar, xfVar, map, j);
        }

        /* renamed from: e */
        public C0695nz mo1474e() {
            return this.f7596c;
        }

        /* renamed from: a */
        public void mo1473a(C0695nz nzVar) {
            this.f7596c = nzVar;
        }

        /* renamed from: g */
        public long mo1475g() {
            throw new RuntimeException("Doesn't have any meaning for programmatically created boxes");
        }

        /* JADX WARNING: type inference failed for: r2v2, types: [atakplugin.UASTool.nz] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public long mo6215a() {
            /*
                r7 = this;
                r0 = 16
                r2 = r7
            L_0x0003:
                boolean r3 = r2 instanceof atakplugin.UASTool.C0688nt
                if (r3 != 0) goto L_0x0008
                return r0
            L_0x0008:
                r3 = r2
                atakplugin.UASTool.nt r3 = (atakplugin.UASTool.C0688nt) r3
                atakplugin.UASTool.nz r4 = r3.mo1474e()
                java.util.List r4 = r4.mo36c()
                java.util.Iterator r4 = r4.iterator()
            L_0x0017:
                boolean r5 = r4.hasNext()
                if (r5 != 0) goto L_0x001e
                goto L_0x0026
            L_0x001e:
                java.lang.Object r5 = r4.next()
                atakplugin.UASTool.nt r5 = (atakplugin.UASTool.C0688nt) r5
                if (r2 != r5) goto L_0x002b
            L_0x0026:
                atakplugin.UASTool.nz r2 = r3.mo1474e()
                goto L_0x0003
            L_0x002b:
                long r5 = r5.mo19f()
                long r0 = r0 + r5
                goto L_0x0017
            */
            throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.C1030xn.C1031a.mo6215a():long");
        }

        /* renamed from: f */
        public long mo19f() {
            return this.f7597d + 16;
        }

        /* renamed from: a */
        public void mo18a(WritableByteChannel writableByteChannel) {
            ByteBuffer allocate = ByteBuffer.allocate(16);
            long f = mo19f();
            if (m14601a(f)) {
                C0681nm.m12515b(allocate, f);
            } else {
                C0681nm.m12515b(allocate, 1);
            }
            allocate.put(C0678nj.m12488a(C0788qz.f6010a));
            if (m14601a(f)) {
                allocate.put(new byte[8]);
            } else {
                C0681nm.m12511a(allocate, f);
            }
            allocate.rewind();
            writableByteChannel.write(allocate);
            for (List<C1024xh> it : this.f7595b) {
                for (C1024xh a : it) {
                    a.mo8a(writableByteChannel);
                }
            }
        }
    }
}
