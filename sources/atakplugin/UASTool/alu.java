package atakplugin.UASTool;

import atakplugin.UASTool.C0786qy;
import java.io.OutputStream;
import java.nio.channels.Channels;
import java.nio.channels.WritableByteChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class alu implements alz {

    /* renamed from: f */
    static final /* synthetic */ boolean f2052f = true;

    /* renamed from: a */
    amc[] f2053a;

    /* renamed from: b */
    amh f2054b;

    /* renamed from: c */
    amk f2055c;

    /* renamed from: d */
    Date f2056d;

    /* renamed from: e */
    Map<amc, List<ama>> f2057e = new HashMap();

    /* renamed from: g */
    private final OutputStream f2058g;

    /* renamed from: h */
    private long f2059h = 1;

    /* renamed from: i */
    private long f2060i = 0;

    /* renamed from: j */
    private long f2061j = 0;

    public void close() {
    }

    public alu(amc[] amcArr, OutputStream outputStream) {
        this.f2053a = amcArr;
        this.f2058g = outputStream;
        this.f2056d = new Date();
        HashSet hashSet = new HashSet();
        for (amc amc : amcArr) {
            if (amc.mo1426a(amm.class) != null) {
                amm amm = (amm) amc.mo1426a(amm.class);
                if (!f2052f && amm == null) {
                    throw new AssertionError();
                } else if (hashSet.contains(Long.valueOf(amm.mo1494a()))) {
                    throw new RuntimeException("There may not be two tracks with the same trackID within one file");
                }
            }
        }
        for (amc amc2 : amcArr) {
            if (amc2.mo1426a(amm.class) != null) {
                ArrayList arrayList = new ArrayList(hashSet);
                Collections.sort(arrayList);
                amc2.mo1428a((amd) new amm(arrayList.size() > 0 ? ((Long) arrayList.get(arrayList.size() - 1)).longValue() + 1 : 1));
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C0688nt mo1433a() {
        C0724oy oyVar = new C0724oy();
        oyVar.mo5158a_(1);
        oyVar.mo5252a(this.f2056d);
        oyVar.mo5254b(this.f2056d);
        oyVar.mo5253b(0);
        long[] jArr = new long[0];
        amc[] amcArr = this.f2053a;
        int length = amcArr.length;
        for (int i = 0; i < length; i++) {
            afs.m880a(jArr, amcArr[i].mo1470e());
        }
        oyVar.mo5250a(afq.m873a(jArr));
        oyVar.mo5256c(2);
        return oyVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C0688nt mo1434a(amc amc) {
        C0711on onVar = new C0711on();
        onVar.mo5193b(amc.mo1471f());
        return onVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public C0688nt mo1437b(amc amc) {
        C0720ou ouVar = new C0720ou();
        ouVar.mo5230a(this.f2056d);
        ouVar.mo5232b(this.f2056d);
        ouVar.mo5231b(0);
        ouVar.mo5228a(amc.mo1470e());
        ouVar.mo5229a(amc.mo1472g());
        return ouVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public C0688nt mo1441c(amc amc) {
        C0719ot otVar = new C0719ot();
        otVar.mo170a(mo1437b(amc));
        otVar.mo170a(mo1434a(amc));
        otVar.mo170a(mo1444d(amc));
        return otVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public C0688nt mo1444d(amc amc) {
        C0721ov ovVar = new C0721ov();
        if (amc.mo1471f().equals("vide")) {
            ovVar.mo170a((C0688nt) new C0761qb());
        } else if (amc.mo1471f().equals("soun")) {
            ovVar.mo170a((C0688nt) new C0744po());
        } else if (amc.mo1471f().equals("text")) {
            ovVar.mo170a((C0688nt) new C0725oz());
        } else if (amc.mo1471f().equals("subt")) {
            ovVar.mo170a((C0688nt) new C0749pr());
        } else if (amc.mo1471f().equals("hint")) {
            ovVar.mo170a((C0688nt) new C0712oo());
        } else if (amc.mo1471f().equals("sbtl")) {
            ovVar.mo170a((C0688nt) new C0725oz());
        }
        ovVar.mo170a((C0688nt) mo1438b());
        ovVar.mo170a(mo1446e(amc));
        return ovVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public C0688nt mo1446e(amc amc) {
        C0739pk pkVar = new C0739pk();
        pkVar.mo170a((C0688nt) amc.mo1432d());
        pkVar.mo170a((C0688nt) new C0751pt());
        pkVar.mo170a((C0688nt) new C0740pl());
        pkVar.mo170a((C0688nt) new C0738pj());
        pkVar.mo170a((C0688nt) new C0745pp());
        return pkVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public C0700od mo1438b() {
        C0700od odVar = new C0700od();
        C0701oe oeVar = new C0701oe();
        odVar.mo170a((C0688nt) oeVar);
        C0698ob obVar = new C0698ob();
        obVar.mo5159b(1);
        oeVar.mo170a((C0688nt) obVar);
        return odVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public C0688nt mo1447f(amc amc) {
        C0754pv pvVar = new C0754pv();
        pvVar.mo170a((C0688nt) amc.mo1431c());
        pvVar.mo170a((C0688nt) amc.mo1431c());
        pvVar.mo170a(mo1441c(amc));
        return pvVar;
    }

    /* renamed from: c */
    public C0688nt mo1440c() {
        LinkedList linkedList = new LinkedList();
        linkedList.add("isom");
        linkedList.add("iso6");
        linkedList.add(C0801rj.f6084d);
        return new C0706oi("isom", 0, linkedList);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public C0688nt mo1443d() {
        C0772ql qlVar = new C0772ql();
        C0773qm qmVar = new C0773qm();
        qmVar.mo5158a_(1);
        qmVar.mo5445a(0);
        qlVar.mo170a((C0688nt) qmVar);
        for (amc g : this.f2053a) {
            qlVar.mo170a(mo1449g(g));
        }
        return qlVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: g */
    public C0688nt mo1449g(amc amc) {
        C0780qt qtVar = new C0780qt();
        qtVar.mo5481a(amc.mo1431c().mo5394j());
        qtVar.mo5483b(1);
        qtVar.mo5484c(0);
        qtVar.mo5485d(0);
        C0778qr qrVar = new C0778qr();
        if ("soun".equals(amc.mo1471f()) || "subt".equals(amc.mo1471f())) {
            qrVar.mo5461b(2);
            qrVar.mo5463c(2);
        }
        qtVar.mo5482a(qrVar);
        return qtVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public C0688nt mo1445e() {
        C0723ox oxVar = new C0723ox();
        oxVar.mo170a(mo1433a());
        for (amc f : this.f2053a) {
            oxVar.mo170a(mo1447f(f));
        }
        oxVar.mo170a(mo1443d());
        return oxVar;
    }

    /* renamed from: atakplugin.UASTool.alu$a */
    class C0070a implements Callable {

        /* renamed from: b */
        private amc f2063b;

        public C0070a(amc amc) {
            this.f2063b = amc;
        }

        public Object call() {
            while (true) {
                try {
                    ama poll = this.f2063b.mo1427a().poll(100, TimeUnit.MILLISECONDS);
                    if (poll != null) {
                        alu.this.m2344a(this.f2063b, poll);
                    } else if (!this.f2063b.mo1430b()) {
                        return null;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* renamed from: f */
    public void mo1448f() {
        WritableByteChannel newChannel = Channels.newChannel(this.f2058g);
        mo1440c().mo18a(newChannel);
        mo1445e().mo18a(newChannel);
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(this.f2053a.length);
        for (amc aVar : this.f2053a) {
            newFixedThreadPool.submit(new C0070a(aVar));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public synchronized void m2344a(amc amc, ama ama) {
        amj amj = null;
        for (alw alw : ama.mo1469c()) {
            if (alw instanceof amj) {
                amj = (amj) alw;
            } else if (alw instanceof amg) {
                amg amg = (amg) alw;
            }
        }
        this.f2061j += ama.mo1468b();
        this.f2057e.get(amc).add(ama);
        long j = this.f2061j;
        long j2 = this.f2060i;
        long e = amc.mo1470e();
        Long.signum(e);
        if (j > j2 + (e * 3)) {
            if (this.f2057e.size() > 0 && (this.f2055c == null || amj == null || amj.mo1492g())) {
                WritableByteChannel newChannel = Channels.newChannel(this.f2058g);
                m2346h(amc).mo18a(newChannel);
                m2347i(amc).mo18a(newChannel);
                this.f2060i = this.f2061j;
                this.f2057e.clear();
            }
        }
    }

    /* renamed from: h */
    private C0688nt m2346h(amc amc) {
        C0774qn qnVar = new C0774qn();
        m2342a(this.f2059h, qnVar);
        m2345a(amc, qnVar);
        C0786qy qyVar = qnVar.mo5450i().get(0);
        qyVar.mo5541c(1);
        qyVar.mo5541c((int) (qnVar.mo19f() + 8));
        this.f2059h++;
        return qnVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo1435a(amc amc, C0782qv qvVar) {
        C0783qw qwVar = new C0783qw();
        qwVar.mo5494a(new C0778qr());
        qwVar.mo5496b(-1);
        qwVar.mo5493a(((amm) amc.mo1426a(amm.class)).mo1494a());
        qwVar.mo5497b(true);
        qvVar.mo170a((C0688nt) qwVar);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo1436a(C0782qv qvVar) {
        C0781qu quVar = new C0781qu();
        quVar.mo5158a_(1);
        quVar.mo5490a(this.f2060i);
        qvVar.mo170a((C0688nt) quVar);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo1439b(amc amc, C0782qv qvVar) {
        C0786qy qyVar = new C0786qy();
        boolean z = true;
        qyVar.mo5158a_(1);
        qyVar.mo5542c(true);
        qyVar.mo5540b(true);
        ArrayList arrayList = new ArrayList(this.f2057e.size());
        qyVar.mo5544e(amc.mo1426a(amh.class) != null);
        if (amc.mo1426a(amk.class) == null) {
            z = false;
        }
        qyVar.mo5543d(z);
        for (ama ama : this.f2057e.get(amc)) {
            C0786qy.C0787a aVar = new C0786qy.C0787a();
            aVar.mo5560b((long) ama.mo1467a().remaining());
            if (z) {
                amj amj = (amj) amb.m2396b(ama, amj.class);
                if (f2052f || amj != null) {
                    C0778qr qrVar = new C0778qr();
                    qrVar.mo5456a(amj.mo1479a());
                    qrVar.mo5463c(amj.mo1485c());
                    qrVar.mo5461b(amj.mo1483b());
                    qrVar.mo5465d(amj.mo1487d());
                    qrVar.mo5459a(amj.mo1491f());
                    qrVar.mo5467e(amj.mo1489e());
                    qrVar.mo5470f(amj.mo1493h());
                    aVar.mo5558a(qrVar);
                } else {
                    throw new AssertionError("SampleDependencySampleExtension missing even though SampleDependencyTrackExtension was present");
                }
            }
            aVar.mo5557a(ama.mo1468b());
            if (qyVar.mo5551p()) {
                amg amg = (amg) amb.m2396b(ama, amg.class);
                if (f2052f || amg != null) {
                    aVar.mo5556a(amg.mo1477a());
                } else {
                    throw new AssertionError("CompositionTimeSampleExtension missing even though CompositionTimeTrackExtension was present");
                }
            }
            arrayList.add(aVar);
        }
        qyVar.mo5538a((List<C0786qy.C0787a>) arrayList);
        qvVar.mo170a((C0688nt) qyVar);
    }

    /* renamed from: a */
    private void m2345a(amc amc, C0774qn qnVar) {
        C0782qv qvVar = new C0782qv();
        qnVar.mo170a((C0688nt) qvVar);
        mo1435a(amc, qvVar);
        mo1436a(qvVar);
        mo1439b(amc, qvVar);
        amc.mo1426a(amf.class);
    }

    /* renamed from: a */
    private void m2342a(long j, C0774qn qnVar) {
        C0775qo qoVar = new C0775qo();
        qoVar.mo5452a(j);
        qnVar.mo170a((C0688nt) qoVar);
    }

    /* renamed from: i */
    private C0688nt m2347i(amc amc) {
        return new alv(this, C0788qz.f6010a, amc);
    }
}
