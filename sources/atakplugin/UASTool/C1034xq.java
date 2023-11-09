package atakplugin.UASTool;

import atakplugin.UASTool.C0693ny;
import atakplugin.UASTool.C0704oh;
import atakplugin.UASTool.C0735ph;
import atakplugin.UASTool.C0786qy;
import atakplugin.UASTool.aeb;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/* renamed from: atakplugin.UASTool.xq */
public class C1034xq implements C1038xu {

    /* renamed from: b */
    static final /* synthetic */ boolean f7601b = true;

    /* renamed from: c */
    private static final Logger f7602c = Logger.getLogger(C1034xq.class.getName());

    /* renamed from: a */
    protected C1037xt f7603a;

    /* renamed from: a */
    public Date mo6226a() {
        return new Date();
    }

    /* renamed from: b */
    public C0688nt mo6235b(C1022xf xfVar) {
        LinkedList linkedList = new LinkedList();
        linkedList.add("isom");
        linkedList.add("iso2");
        linkedList.add(C0801rj.f6084d);
        return new C0706oi("isom", 0, linkedList);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public List<C1026xj> mo6228a(List<C1026xj> list, int i, Map<C1026xj, long[]> map) {
        LinkedList linkedList = new LinkedList(list);
        Collections.sort(linkedList, new C1035xr(this, map, i));
        return linkedList;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v20, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v3, resolved type: atakplugin.UASTool.xj} */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<atakplugin.UASTool.C0688nt> mo6246c(atakplugin.UASTool.C1022xf r27) {
        /*
            r26 = this;
            java.util.LinkedList r8 = new java.util.LinkedList
            r8.<init>()
            java.util.HashMap r9 = new java.util.HashMap
            r9.<init>()
            java.util.HashMap r10 = new java.util.HashMap
            r10.<init>()
            java.util.List r0 = r27.mo6159a()
            java.util.Iterator r0 = r0.iterator()
        L_0x0017:
            boolean r1 = r0.hasNext()
            if (r1 != 0) goto L_0x00eb
            r11 = 1
            r12 = 1
        L_0x001f:
            boolean r0 = r9.isEmpty()
            if (r0 == 0) goto L_0x0026
            return r8
        L_0x0026:
            r0 = 0
            r1 = 9218868437227405311(0x7fefffffffffffff, double:1.7976931348623157E308)
            java.util.Set r3 = r10.entrySet()
            java.util.Iterator r3 = r3.iterator()
            r13 = r0
        L_0x0035:
            boolean r0 = r3.hasNext()
            if (r0 != 0) goto L_0x00be
            boolean r0 = f7601b
            if (r0 != 0) goto L_0x0048
            if (r13 == 0) goto L_0x0042
            goto L_0x0048
        L_0x0042:
            java.lang.AssertionError r0 = new java.lang.AssertionError
            r0.<init>()
            throw r0
        L_0x0048:
            java.lang.Object r0 = r9.get(r13)
            r14 = r0
            long[] r14 = (long[]) r14
            r15 = 0
            r4 = r14[r15]
            int r0 = r14.length
            if (r0 <= r11) goto L_0x0058
            r6 = r14[r11]
            goto L_0x0062
        L_0x0058:
            java.util.List r0 = r13.mo11l()
            int r0 = r0.size()
            int r0 = r0 + r11
            long r6 = (long) r0
        L_0x0062:
            long[] r0 = r13.mo12m()
            atakplugin.UASTool.xk r3 = r13.mo14o()
            r16 = r12
            long r11 = r3.mo6178b()
            r17 = r1
            r1 = r4
        L_0x0073:
            int r3 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r3 < 0) goto L_0x00a3
            r0 = r26
            r1 = r8
            r2 = r13
            r3 = r4
            r5 = r6
            r7 = r16
            r0.mo6220a((java.util.List<atakplugin.UASTool.C0688nt>) r1, (atakplugin.UASTool.C1026xj) r2, (long) r3, (long) r5, (int) r7)
            int r0 = r14.length
            r3 = 1
            if (r0 != r3) goto L_0x008d
            r9.remove(r13)
            r10.remove(r13)
            goto L_0x009e
        L_0x008d:
            int r0 = r14.length
            int r0 = r0 - r3
            long[] r1 = new long[r0]
            java.lang.System.arraycopy(r14, r3, r1, r15, r0)
            r9.put(r13, r1)
            java.lang.Double r0 = java.lang.Double.valueOf(r17)
            r10.put(r13, r0)
        L_0x009e:
            int r12 = r16 + 1
            r11 = 1
            goto L_0x001f
        L_0x00a3:
            r3 = 1
            r19 = 1
            long r21 = r1 - r19
            int r21 = atakplugin.UASTool.afi.m847a(r21)
            r22 = r4
            r3 = r0[r21]
            double r3 = (double) r3
            r24 = r6
            double r5 = (double) r11
            double r3 = r3 / r5
            double r17 = r17 + r3
            long r1 = r1 + r19
            r4 = r22
            r6 = r24
            goto L_0x0073
        L_0x00be:
            r16 = r12
            r4 = 1
            java.lang.Object r0 = r3.next()
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
            java.lang.Object r5 = r0.getValue()
            java.lang.Double r5 = (java.lang.Double) r5
            double r5 = r5.doubleValue()
            int r7 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r7 >= 0) goto L_0x00e6
            java.lang.Object r1 = r0.getValue()
            java.lang.Double r1 = (java.lang.Double) r1
            double r1 = r1.doubleValue()
            java.lang.Object r0 = r0.getKey()
            r13 = r0
            atakplugin.UASTool.xj r13 = (atakplugin.UASTool.C1026xj) r13
        L_0x00e6:
            r12 = r16
            r11 = 1
            goto L_0x0035
        L_0x00eb:
            java.lang.Object r1 = r0.next()
            atakplugin.UASTool.xj r1 = (atakplugin.UASTool.C1026xj) r1
            r2 = r26
            atakplugin.UASTool.xt r3 = r2.f7603a
            long[] r3 = r3.mo6257a(r1)
            r9.put(r1, r3)
            r3 = 0
            java.lang.Double r3 = java.lang.Double.valueOf(r3)
            r10.put(r1, r3)
            goto L_0x0017
        */
        throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.C1034xq.mo6246c(atakplugin.UASTool.xf):java.util.List");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public int mo6220a(List<C0688nt> list, C1026xj xjVar, long j, long j2, int i) {
        if (j != j2) {
            long j3 = j;
            long j4 = j2;
            C1026xj xjVar2 = xjVar;
            int i2 = i;
            list.add(mo6243c(j3, j4, xjVar2, i2));
            list.add(mo6221a(j3, j4, xjVar2, i2));
        }
        return i;
    }

    /* renamed from: a */
    public C0695nz mo6195a(C1022xf xfVar) {
        Logger logger = f7602c;
        logger.fine("Creating movie " + xfVar);
        if (this.f7603a == null) {
            C1026xj xjVar = null;
            Iterator<C1026xj> it = xfVar.mo6159a().iterator();
            while (true) {
                if (it.hasNext()) {
                    C1026xj next = it.next();
                    if (next.mo15p().equals("vide")) {
                        xjVar = next;
                        break;
                    }
                } else {
                    break;
                }
            }
            this.f7603a = new C1040xw(xfVar, xjVar, -1);
        }
        C1005wq wqVar = new C1005wq();
        wqVar.mo170a(mo6235b(xfVar));
        wqVar.mo170a(mo6251e(xfVar));
        for (C0688nt a : mo6246c(xfVar)) {
            wqVar.mo170a(a);
        }
        wqVar.mo170a(mo6222a(xfVar, (C0695nz) wqVar));
        return wqVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C0688nt mo6221a(long j, long j2, C1026xj xjVar, int i) {
        return new C1036xs(this, j, j2, xjVar);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo6230a(long j, long j2, C1026xj xjVar, int i, C0782qv qvVar) {
        C0783qw qwVar = new C0783qw();
        qwVar.mo5494a(new C0778qr());
        qwVar.mo5496b(-1);
        qwVar.mo5493a(xjVar.mo14o().mo6188g());
        qwVar.mo5497b(true);
        qvVar.mo170a((C0688nt) qwVar);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo6229a(long j, long j2, C1026xj xjVar, int i, C0774qn qnVar) {
        C0775qo qoVar = new C0775qo();
        qoVar.mo5452a((long) i);
        qnVar.mo170a((C0688nt) qoVar);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo6239b(long j, long j2, C1026xj xjVar, int i, C0774qn qnVar) {
        long j3 = j;
        C1026xj xjVar2 = xjVar;
        C0782qv qvVar = new C0782qv();
        qnVar.mo170a((C0688nt) qvVar);
        long j4 = j;
        long j5 = j2;
        C1026xj xjVar3 = xjVar;
        int i2 = i;
        C0782qv qvVar2 = qvVar;
        mo6230a(j4, j5, xjVar3, i2, qvVar2);
        mo6232a(j3, xjVar2, qvVar);
        mo6240b(j4, j5, xjVar3, i2, qvVar2);
        if (xjVar2 instanceof C1062yo) {
            long j6 = j;
            long j7 = j2;
            C1062yo yoVar = (C1062yo) xjVar2;
            int i3 = i;
            C0782qv qvVar3 = qvVar;
            mo6247c(j6, j7, yoVar, i3, qvVar3);
            mo6231a(j6, j7, yoVar, i3, qvVar3);
            mo6241b(j6, j7, yoVar, i3, qvVar3);
        }
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
        Iterator it = hashMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            aea aea = new aea();
            aea.mo415a((List<adx>) (List) entry.getValue());
            aeb aeb = new aeb();
            aeb.mo420a((String) entry.getKey());
            long j8 = 1;
            aeb.C0016a aVar = null;
            for (int a2 = afi.m847a(j3 - 1); a2 < afi.m847a(j2 - j8); a2++) {
                int i4 = 0;
                int i5 = 0;
                while (i4 < ((List) entry.getValue()).size()) {
                    Iterator it2 = it;
                    i5 = Arrays.binarySearch(xjVar.mo6146h().get((adx) ((List) entry.getValue()).get(i4)), (long) a2) >= 0 ? i4 + 1 : i5;
                    i4++;
                    it = it2;
                    j8 = 1;
                }
                if (aVar == null || aVar.mo427b() != i5) {
                    aeb.C0016a aVar2 = new aeb.C0016a(j8, i5);
                    aeb.mo423j().add(aVar2);
                    aVar = aVar2;
                } else {
                    aVar.mo426a(aVar.mo424a() + j8);
                }
            }
            qvVar.mo170a((C0688nt) aea);
            qvVar.mo170a((C0688nt) aeb);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo6231a(long j, long j2, C1062yo yoVar, int i, C0782qv qvVar) {
        ada ada = new ada();
        ada.mo49a(yoVar.mo6148j());
        ada.mo48a(yoVar.mo6149k().subList(afi.m847a(j - 1), afi.m847a(j2 - 1)));
        qvVar.mo170a((C0688nt) ada);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo6241b(long j, long j2, C1062yo yoVar, int i, C0782qv qvVar) {
        C0688nt next;
        C0743pn pnVar = (C0743pn) aft.m883a((C1003wo) yoVar.mo13n(), "enc.[0]/sinf[0]/schm[0]");
        akw akw = new akw();
        qvVar.mo170a((C0688nt) akw);
        if (f7601b || qvVar.mo202a(C0786qy.class).size() == 1) {
            akw.mo1193a("cenc");
            akw.mo5159b(1);
            long j3 = 8;
            Iterator<C0688nt> it = qvVar.mo36c().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                C0688nt next2 = it.next();
                if (next2 instanceof ada) {
                    j3 += (long) ((ada) next2).mo36c();
                    break;
                }
                j3 += next2.mo19f();
            }
            long j4 = j3 + 16;
            Iterator<C0688nt> it2 = ((C0774qn) qvVar.mo1474e()).mo36c().iterator();
            while (it2.hasNext() && (next = it2.next()) != qvVar) {
                j4 += next.mo19f();
            }
            akw.mo1194a(new long[]{j4});
            return;
        }
        throw new AssertionError("Don't know how to deal with multiple Track Run Boxes when encrypting");
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo6247c(long j, long j2, C1062yo yoVar, int i, C0782qv qvVar) {
        C0737pi n = yoVar.mo13n();
        C0743pn pnVar = (C0743pn) aft.m883a((C1003wo) n, "enc.[0]/sinf[0]/schm[0]");
        alr alr = (alr) aft.m883a((C1003wo) n, "enc.[0]/sinf[0]/schi[0]/tenc[0]");
        akx akx = new akx();
        akx.mo1197a("cenc");
        akx.mo5159b(1);
        if (yoVar.mo6148j()) {
            int a = afi.m847a(j2 - j);
            short[] sArr = new short[a];
            List<alo> subList = yoVar.mo6149k().subList(afi.m847a(j - 1), afi.m847a(j2 - 1));
            for (int i2 = 0; i2 < a; i2++) {
                sArr[i2] = (short) subList.get(i2).mo1401a();
            }
            akx.mo1198a(sArr);
        } else {
            akx.mo1201d(alr.mo43i());
            akx.mo1202e(afi.m847a(j2 - j));
        }
        qvVar.mo170a((C0688nt) akx);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public List<C1024xh> mo6227a(long j, long j2, C1026xj xjVar) {
        return xjVar.mo11l().subList(afi.m847a(j) - 1, afi.m847a(j2) - 1);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public long[] mo6242b(long j, long j2, C1026xj xjVar, int i) {
        List<C1024xh> a = mo6227a(j, j2, xjVar);
        int size = a.size();
        long[] jArr = new long[size];
        for (int i2 = 0; i2 < size; i2++) {
            jArr[i2] = a.get(i2).mo7a();
        }
        return jArr;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo6232a(long j, C1026xj xjVar, C0782qv qvVar) {
        C0781qu quVar = new C0781qu();
        quVar.mo5158a_(1);
        long[] m = xjVar.mo12m();
        long j2 = 0;
        for (int i = 1; ((long) i) < j; i++) {
            j2 += m[i - 1];
        }
        quVar.mo5490a(j2);
        qvVar.mo170a((C0688nt) quVar);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo6240b(long j, long j2, C1026xj xjVar, int i, C0782qv qvVar) {
        long[] jArr;
        long j3;
        C0786qy qyVar = new C0786qy();
        qyVar.mo5158a_(1);
        long[] b = mo6242b(j, j2, xjVar, i);
        qyVar.mo5542c(true);
        qyVar.mo5540b(true);
        ArrayList arrayList = new ArrayList(afi.m847a(j2 - j));
        List<C0693ny.C0694a> a = xjVar.mo6139a();
        C0693ny.C0694a[] aVarArr = (a == null || a.size() <= 0) ? null : (C0693ny.C0694a[]) a.toArray(new C0693ny.C0694a[a.size()]);
        long a2 = (long) (aVarArr != null ? aVarArr[0].mo5142a() : -1);
        qyVar.mo5544e(a2 > 0);
        long j4 = 1;
        int i2 = 0;
        while (j4 < j) {
            long[] jArr2 = b;
            if (aVarArr != null) {
                a2--;
                j3 = 0;
                if (a2 == 0) {
                    if (aVarArr.length - i2 > 1) {
                        i2++;
                        a2 = (long) aVarArr[i2].mo5142a();
                    }
                    j4++;
                    long j5 = j3;
                    b = jArr2;
                }
            } else {
                j3 = 0;
            }
            j4++;
            long j52 = j3;
            b = jArr2;
        }
        boolean z = (xjVar.mo6141c() != null && !xjVar.mo6141c().isEmpty()) || !(xjVar.mo6140b() == null || xjVar.mo6140b().length == 0);
        qyVar.mo5543d(z);
        int i3 = 0;
        while (i3 < b.length) {
            C0782qv qvVar2 = qvVar;
            C0786qy.C0787a aVar = new C0786qy.C0787a();
            aVar.mo5560b(b[i3]);
            if (z) {
                C0778qr qrVar = new C0778qr();
                if (xjVar.mo6141c() != null && !xjVar.mo6141c().isEmpty()) {
                    C0735ph.C0736a aVar2 = xjVar.mo6141c().get(i3);
                    qrVar.mo5461b(aVar2.mo5307b());
                    qrVar.mo5463c(aVar2.mo5309c());
                    qrVar.mo5465d(aVar2.mo5311d());
                }
                if (xjVar.mo6140b() == null || xjVar.mo6140b().length <= 0) {
                    jArr = b;
                } else {
                    jArr = b;
                    if (Arrays.binarySearch(xjVar.mo6140b(), j + ((long) i3)) >= 0) {
                        qrVar.mo5459a(false);
                        qrVar.mo5461b(2);
                    } else {
                        qrVar.mo5459a(true);
                        qrVar.mo5461b(1);
                    }
                }
                aVar.mo5558a(qrVar);
            } else {
                jArr = b;
            }
            aVar.mo5557a(xjVar.mo12m()[afi.m847a((j + ((long) i3)) - 1)]);
            if (aVarArr != null) {
                aVar.mo5556a(aVarArr[i2].mo5144b());
                a2--;
                if (a2 == 0 && aVarArr.length - i2 > 1) {
                    i2++;
                    a2 = (long) aVarArr[i2].mo5142a();
                }
            }
            arrayList.add(aVar);
            i3++;
            b = jArr;
        }
        qyVar.mo5538a((List<C0786qy.C0787a>) arrayList);
        qvVar.mo170a((C0688nt) qyVar);
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public C0688nt mo6243c(long j, long j2, C1026xj xjVar, int i) {
        C0774qn qnVar = new C0774qn();
        long j3 = j;
        long j4 = j2;
        C1026xj xjVar2 = xjVar;
        int i2 = i;
        C0774qn qnVar2 = qnVar;
        mo6229a(j3, j4, xjVar2, i2, qnVar2);
        mo6239b(j3, j4, xjVar2, i2, qnVar2);
        C0786qy qyVar = qnVar.mo5450i().get(0);
        qyVar.mo5541c(1);
        qyVar.mo5541c((int) (qnVar.mo19f() + 8));
        return qnVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public C0688nt mo6248d(C1022xf xfVar) {
        C0724oy oyVar = new C0724oy();
        oyVar.mo5158a_(1);
        oyVar.mo5252a(mo6226a());
        oyVar.mo5254b(mo6226a());
        long j = 0;
        oyVar.mo5253b(0);
        oyVar.mo5250a(xfVar.mo6164c());
        for (C1026xj next : xfVar.mo6159a()) {
            if (j < next.mo14o().mo6188g()) {
                j = next.mo14o().mo6188g();
            }
        }
        oyVar.mo5256c(j + 1);
        return oyVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public C0688nt mo6251e(C1022xf xfVar) {
        C0723ox oxVar = new C0723ox();
        oxVar.mo170a(mo6248d(xfVar));
        for (C1026xj d : xfVar.mo6159a()) {
            oxVar.mo170a(mo6250d(d, xfVar));
        }
        oxVar.mo170a(mo6254f(xfVar));
        return oxVar;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v18, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v16, resolved type: atakplugin.UASTool.qt} */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public atakplugin.UASTool.C0688nt mo6224a(atakplugin.UASTool.C1026xj r34, atakplugin.UASTool.C0695nz r35) {
        /*
            r33 = this;
            atakplugin.UASTool.qx r0 = new atakplugin.UASTool.qx
            r0.<init>()
            r1 = 1
            r0.mo5158a_(r1)
            java.util.LinkedList r1 = new java.util.LinkedList
            r1.<init>()
            java.lang.String r2 = "moov/mvex/trex"
            r3 = r35
            java.util.List r2 = atakplugin.UASTool.aft.m890b((atakplugin.UASTool.C0695nz) r3, (java.lang.String) r2)
            java.util.Iterator r2 = r2.iterator()
            r4 = 0
        L_0x001b:
            boolean r5 = r2.hasNext()
            if (r5 != 0) goto L_0x01b6
            java.util.List r2 = r35.mo36c()
            java.util.Iterator r5 = r2.iterator()
            r2 = 0
            r6 = r2
        L_0x002c:
            boolean r8 = r5.hasNext()
            if (r8 != 0) goto L_0x0041
            r0.mo5514a((java.util.List<atakplugin.UASTool.C0784qx.C0785a>) r1)
            atakplugin.UASTool.xk r1 = r34.mo14o()
            long r1 = r1.mo6188g()
            r0.mo5513a((long) r1)
            return r0
        L_0x0041:
            java.lang.Object r8 = r5.next()
            r15 = r8
            atakplugin.UASTool.nt r15 = (atakplugin.UASTool.C0688nt) r15
            boolean r8 = r15 instanceof atakplugin.UASTool.C0774qn
            if (r8 == 0) goto L_0x019d
            r8 = r15
            atakplugin.UASTool.qn r8 = (atakplugin.UASTool.C0774qn) r8
            java.lang.Class<atakplugin.UASTool.qv> r9 = atakplugin.UASTool.C0782qv.class
            java.util.List r13 = r8.mo202a(r9)
            r14 = 0
            r11 = 0
        L_0x0057:
            int r8 = r13.size()
            if (r11 < r8) goto L_0x005f
            goto L_0x019d
        L_0x005f:
            java.lang.Object r8 = r13.get(r11)
            atakplugin.UASTool.qv r8 = (atakplugin.UASTool.C0782qv) r8
            atakplugin.UASTool.qw r9 = r8.mo5492a()
            long r9 = r9.mo5504m()
            atakplugin.UASTool.xk r12 = r34.mo14o()
            long r16 = r12.mo6188g()
            int r12 = (r9 > r16 ? 1 : (r9 == r16 ? 0 : -1))
            if (r12 != 0) goto L_0x017e
            java.lang.Class<atakplugin.UASTool.qy> r9 = atakplugin.UASTool.C0786qy.class
            java.util.List r12 = r8.mo202a(r9)
            r9 = 0
        L_0x0080:
            int r8 = r12.size()
            if (r9 < r8) goto L_0x0088
            goto L_0x017e
        L_0x0088:
            java.util.LinkedList r10 = new java.util.LinkedList
            r10.<init>()
            java.lang.Object r8 = r12.get(r9)
            r17 = r8
            atakplugin.UASTool.qy r17 = (atakplugin.UASTool.C0786qy) r17
            r18 = r6
            r7 = 0
        L_0x0098:
            java.util.List r6 = r17.mo36c()
            int r6 = r6.size()
            if (r7 < r6) goto L_0x00cc
            int r6 = r10.size()
            java.util.List r7 = r17.mo36c()
            int r7 = r7.size()
            if (r6 != r7) goto L_0x00c4
            java.util.List r6 = r17.mo36c()
            int r6 = r6.size()
            if (r6 <= 0) goto L_0x00c4
            java.lang.Object r6 = r10.get(r14)
            atakplugin.UASTool.qx$a r6 = (atakplugin.UASTool.C0784qx.C0785a) r6
            r1.add(r6)
            goto L_0x00c7
        L_0x00c4:
            r1.addAll(r10)
        L_0x00c7:
            int r9 = r9 + 1
            r6 = r18
            goto L_0x0080
        L_0x00cc:
            java.util.List r6 = r17.mo36c()
            java.lang.Object r6 = r6.get(r7)
            r20 = r6
            atakplugin.UASTool.qy$a r20 = (atakplugin.UASTool.C0786qy.C0787a) r20
            if (r7 != 0) goto L_0x00e5
            boolean r6 = r17.mo5547l()
            if (r6 == 0) goto L_0x00e5
            atakplugin.UASTool.qr r6 = r17.mo5553r()
            goto L_0x00f4
        L_0x00e5:
            boolean r6 = r17.mo5550o()
            if (r6 == 0) goto L_0x00f0
            atakplugin.UASTool.qr r6 = r20.mo5561c()
            goto L_0x00f4
        L_0x00f0:
            atakplugin.UASTool.qr r6 = r4.mo5488l()
        L_0x00f4:
            if (r6 != 0) goto L_0x010b
            java.lang.String r8 = r34.mo15p()
            java.lang.String r14 = "vide"
            boolean r8 = r8.equals(r14)
            if (r8 != 0) goto L_0x0103
            goto L_0x010b
        L_0x0103:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            java.lang.String r1 = "Cannot find SampleFlags for video track but it's required to build tfra"
            r0.<init>(r1)
            throw r0
        L_0x010b:
            if (r6 == 0) goto L_0x012c
            int r6 = r6.mo5462c()
            r8 = 2
            if (r6 != r8) goto L_0x0115
            goto L_0x012c
        L_0x0115:
            r21 = r0
            r22 = r1
            r23 = r4
            r24 = r5
            r27 = r7
            r28 = r9
            r4 = r10
            r30 = r11
            r31 = r12
            r0 = r13
            r25 = r15
            r32 = 0
            goto L_0x0161
        L_0x012c:
            atakplugin.UASTool.qx$a r14 = new atakplugin.UASTool.qx$a
            int r6 = r11 + 1
            r21 = r0
            r22 = r1
            long r0 = (long) r6
            int r6 = r9 + 1
            r23 = r4
            r24 = r5
            long r4 = (long) r6
            int r6 = r7 + 1
            r25 = r4
            long r4 = (long) r6
            r6 = r14
            r27 = r7
            r7 = r18
            r28 = r9
            r29 = r10
            r9 = r2
            r30 = r11
            r31 = r12
            r11 = r0
            r0 = r13
            r1 = r14
            r32 = 0
            r13 = r25
            r25 = r15
            r15 = r4
            r6.<init>(r7, r9, r11, r13, r15)
            r4 = r29
            r4.add(r1)
        L_0x0161:
            long r5 = r20.mo5555a()
            long r18 = r18 + r5
            int r7 = r27 + 1
            r13 = r0
            r10 = r4
            r0 = r21
            r1 = r22
            r4 = r23
            r5 = r24
            r15 = r25
            r9 = r28
            r11 = r30
            r12 = r31
            r14 = 0
            goto L_0x0098
        L_0x017e:
            r21 = r0
            r22 = r1
            r23 = r4
            r24 = r5
            r30 = r11
            r0 = r13
            r25 = r15
            r32 = 0
            int r11 = r30 + 1
            r13 = r0
            r0 = r21
            r1 = r22
            r4 = r23
            r5 = r24
            r15 = r25
            r14 = 0
            goto L_0x0057
        L_0x019d:
            r21 = r0
            r22 = r1
            r23 = r4
            r24 = r5
            r25 = r15
            long r0 = r25.mo19f()
            long r2 = r2 + r0
            r0 = r21
            r1 = r22
            r4 = r23
            r5 = r24
            goto L_0x002c
        L_0x01b6:
            r21 = r0
            r22 = r1
            r23 = r4
            java.lang.Object r0 = r2.next()
            r4 = r0
            atakplugin.UASTool.qt r4 = (atakplugin.UASTool.C0780qt) r4
            long r0 = r4.mo36c()
            atakplugin.UASTool.xk r5 = r34.mo14o()
            long r5 = r5.mo6188g()
            int r7 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            r0 = r21
            r1 = r22
            if (r7 != 0) goto L_0x01d9
            goto L_0x001b
        L_0x01d9:
            r4 = r23
            goto L_0x001b
        */
        throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.C1034xq.mo6224a(atakplugin.UASTool.xj, atakplugin.UASTool.nz):atakplugin.UASTool.nt");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C0688nt mo6222a(C1022xf xfVar, C0695nz nzVar) {
        C0776qp qpVar = new C0776qp();
        for (C1026xj a : xfVar.mo6159a()) {
            qpVar.mo170a(mo6224a(a, nzVar));
        }
        C0777qq qqVar = new C0777qq();
        qpVar.mo170a((C0688nt) qqVar);
        qqVar.mo5454a(qpVar.mo19f());
        return qpVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C0688nt mo6223a(C1022xf xfVar, C1026xj xjVar) {
        C0780qt qtVar = new C0780qt();
        qtVar.mo5481a(xjVar.mo14o().mo6188g());
        qtVar.mo5483b(1);
        qtVar.mo5484c(0);
        qtVar.mo5485d(0);
        C0778qr qrVar = new C0778qr();
        if ("soun".equals(xjVar.mo15p()) || "subt".equals(xjVar.mo15p())) {
            qrVar.mo5461b(2);
            qrVar.mo5463c(2);
        }
        qtVar.mo5482a(qrVar);
        return qtVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public C0688nt mo6254f(C1022xf xfVar) {
        C0772ql qlVar = new C0772ql();
        C0773qm qmVar = new C0773qm();
        qmVar.mo5158a_(1);
        for (C1026xj f : xfVar.mo6159a()) {
            long f2 = m14612f(xfVar, f);
            if (qmVar.mo36c() < f2) {
                qmVar.mo5445a(f2);
            }
        }
        qlVar.mo170a((C0688nt) qmVar);
        for (C1026xj a : xfVar.mo6159a()) {
            qlVar.mo170a(mo6223a(xfVar, a));
        }
        return qlVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public C0688nt mo6236b(C1022xf xfVar, C1026xj xjVar) {
        C0755pw pwVar = new C0755pw();
        pwVar.mo5158a_(1);
        pwVar.mo5159b(7);
        pwVar.mo5392d(xjVar.mo14o().mo6191j());
        pwVar.mo5384a(xjVar.mo14o().mo6185d());
        pwVar.mo5387b(0);
        pwVar.mo5386b(xjVar.mo14o().mo6187f());
        pwVar.mo5380a(xjVar.mo14o().mo6186e());
        pwVar.mo5390c(xjVar.mo14o().mo6189h());
        pwVar.mo5388b(mo6226a());
        pwVar.mo5382a(xjVar.mo14o().mo6188g());
        pwVar.mo5381a(xjVar.mo14o().mo6190i());
        return pwVar;
    }

    /* renamed from: f */
    private long m14612f(C1022xf xfVar, C1026xj xjVar) {
        return (xjVar.mo6143e() * xfVar.mo6164c()) / xjVar.mo14o().mo6178b();
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public C0688nt mo6244c(C1022xf xfVar, C1026xj xjVar) {
        C0720ou ouVar = new C0720ou();
        ouVar.mo5230a(xjVar.mo14o().mo6185d());
        ouVar.mo5232b(mo6226a());
        ouVar.mo5231b(0);
        ouVar.mo5228a(xjVar.mo14o().mo6178b());
        ouVar.mo5229a(xjVar.mo14o().mo6170a());
        return ouVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public C0688nt mo6249d(C1022xf xfVar, C1026xj xjVar) {
        C0739pk pkVar = new C0739pk();
        mo6233a(xjVar, pkVar);
        pkVar.mo170a((C0688nt) new C0751pt());
        pkVar.mo170a((C0688nt) new C0740pl());
        pkVar.mo170a((C0688nt) new C0738pj());
        pkVar.mo170a((C0688nt) new C0745pp());
        return pkVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo6233a(C1026xj xjVar, C0739pk pkVar) {
        pkVar.mo170a((C0688nt) xjVar.mo13n());
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C0688nt mo6225a(C1026xj xjVar, C1022xf xfVar) {
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
        ovVar.mo170a((C0688nt) mo6253e(xfVar, xjVar));
        ovVar.mo170a(mo6249d(xfVar, xjVar));
        return ovVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public C0688nt mo6237b(C1026xj xjVar, C1022xf xfVar) {
        C0711on onVar = new C0711on();
        onVar.mo5193b(xjVar.mo15p());
        return onVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public C0688nt mo6245c(C1026xj xjVar, C1022xf xfVar) {
        C0719ot otVar = new C0719ot();
        otVar.mo170a(mo6244c(xfVar, xjVar));
        otVar.mo170a(mo6237b(xjVar, xfVar));
        otVar.mo170a(mo6225a(xjVar, xfVar));
        return otVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public C0688nt mo6250d(C1026xj xjVar, C1022xf xfVar) {
        Logger logger = f7602c;
        logger.fine("Creating Track " + xjVar);
        C0754pv pvVar = new C0754pv();
        pvVar.mo170a(mo6236b(xfVar, xjVar));
        C0688nt e = mo6252e(xjVar, xfVar);
        if (e != null) {
            pvVar.mo170a(e);
        }
        pvVar.mo170a(mo6245c(xjVar, xfVar));
        return pvVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public C0688nt mo6252e(C1026xj xjVar, C1022xf xfVar) {
        if (xjVar.mo6145g() == null || xjVar.mo6145g().size() <= 0) {
            return null;
        }
        C0704oh ohVar = new C0704oh();
        ohVar.mo5158a_(1);
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
    /* renamed from: e */
    public C0700od mo6253e(C1022xf xfVar, C1026xj xjVar) {
        C0700od odVar = new C0700od();
        C0701oe oeVar = new C0701oe();
        odVar.mo170a((C0688nt) oeVar);
        C0698ob obVar = new C0698ob();
        obVar.mo5159b(1);
        oeVar.mo170a((C0688nt) obVar);
        return odVar;
    }

    /* renamed from: b */
    public C1037xt mo6238b() {
        return this.f7603a;
    }

    /* renamed from: a */
    public void mo6234a(C1037xt xtVar) {
        this.f7603a = xtVar;
    }
}
