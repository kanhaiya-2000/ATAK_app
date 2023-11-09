package atakplugin.UASTool;

import atakplugin.UASTool.C0786qy;
import java.io.OutputStream;
import java.nio.channels.Channels;
import java.nio.channels.WritableByteChannel;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class alx implements alz {

    /* renamed from: f */
    static final /* synthetic */ boolean f2066f = true;

    /* renamed from: a */
    amc f2067a;

    /* renamed from: b */
    amh f2068b;

    /* renamed from: c */
    amk f2069c;

    /* renamed from: d */
    Date f2070d;

    /* renamed from: e */
    List<ama> f2071e = new ArrayList();

    /* renamed from: g */
    private final OutputStream f2072g;

    /* renamed from: h */
    private long f2073h;

    /* renamed from: i */
    private long f2074i = 0;

    /* renamed from: j */
    private long f2075j = 0;

    public void close() {
    }

    public alx(amc amc, OutputStream outputStream) {
        this.f2067a = amc;
        this.f2072g = outputStream;
        this.f2070d = new Date();
        this.f2068b = (amh) amc.mo1426a(amh.class);
        this.f2069c = (amk) amc.mo1426a(amk.class);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C0688nt mo1451a() {
        C0724oy oyVar = new C0724oy();
        oyVar.mo5158a_(1);
        oyVar.mo5252a(this.f2070d);
        oyVar.mo5254b(this.f2070d);
        oyVar.mo5253b(0);
        oyVar.mo5250a(this.f2067a.mo1470e());
        oyVar.mo5256c(2);
        return oyVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public C0688nt mo1453b() {
        C0711on onVar = new C0711on();
        onVar.mo5193b(this.f2067a.mo1471f());
        return onVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public C0688nt mo1455c() {
        C0720ou ouVar = new C0720ou();
        ouVar.mo5230a(this.f2070d);
        ouVar.mo5232b(this.f2070d);
        ouVar.mo5231b(0);
        ouVar.mo5228a(this.f2067a.mo1470e());
        ouVar.mo5229a(this.f2067a.mo1472g());
        return ouVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public C0688nt mo1457d() {
        C0719ot otVar = new C0719ot();
        otVar.mo170a(mo1455c());
        otVar.mo170a(mo1453b());
        otVar.mo170a(mo1458e());
        return otVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public C0688nt mo1458e() {
        C0721ov ovVar = new C0721ov();
        if (this.f2067a.mo1471f().equals("vide")) {
            ovVar.mo170a((C0688nt) new C0761qb());
        } else if (this.f2067a.mo1471f().equals("soun")) {
            ovVar.mo170a((C0688nt) new C0744po());
        } else if (this.f2067a.mo1471f().equals("text")) {
            ovVar.mo170a((C0688nt) new C0725oz());
        } else if (this.f2067a.mo1471f().equals("subt")) {
            ovVar.mo170a((C0688nt) new C0749pr());
        } else if (this.f2067a.mo1471f().equals("hint")) {
            ovVar.mo170a((C0688nt) new C0712oo());
        } else if (this.f2067a.mo1471f().equals("sbtl")) {
            ovVar.mo170a((C0688nt) new C0725oz());
        }
        ovVar.mo170a((C0688nt) mo1460h());
        ovVar.mo170a(mo1459g());
        return ovVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: g */
    public C0688nt mo1459g() {
        C0739pk pkVar = new C0739pk();
        pkVar.mo170a((C0688nt) this.f2067a.mo1432d());
        pkVar.mo170a((C0688nt) new C0751pt());
        pkVar.mo170a((C0688nt) new C0740pl());
        pkVar.mo170a((C0688nt) new C0738pj());
        pkVar.mo170a((C0688nt) new C0745pp());
        return pkVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: h */
    public C0700od mo1460h() {
        C0700od odVar = new C0700od();
        C0701oe oeVar = new C0701oe();
        odVar.mo170a((C0688nt) oeVar);
        C0698ob obVar = new C0698ob();
        obVar.mo5159b(1);
        oeVar.mo170a((C0688nt) obVar);
        return odVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: i */
    public C0688nt mo1461i() {
        C0754pv pvVar = new C0754pv();
        pvVar.mo170a((C0688nt) this.f2067a.mo1431c());
        pvVar.mo170a(mo1457d());
        return pvVar;
    }

    /* renamed from: j */
    public C0688nt mo1462j() {
        LinkedList linkedList = new LinkedList();
        linkedList.add("isom");
        linkedList.add("iso6");
        linkedList.add(C0801rj.f6084d);
        return new C0706oi("isom", 0, linkedList);
    }

    /* access modifiers changed from: protected */
    /* renamed from: k */
    public C0688nt mo1463k() {
        C0772ql qlVar = new C0772ql();
        C0773qm qmVar = new C0773qm();
        qmVar.mo5158a_(1);
        qmVar.mo5445a(0);
        qlVar.mo170a((C0688nt) qmVar);
        qlVar.mo170a(mo1464l());
        return qlVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: l */
    public C0688nt mo1464l() {
        C0780qt qtVar = new C0780qt();
        qtVar.mo5481a(this.f2067a.mo1431c().mo5394j());
        qtVar.mo5483b(1);
        qtVar.mo5484c(0);
        qtVar.mo5485d(0);
        C0778qr qrVar = new C0778qr();
        if ("soun".equals(this.f2067a.mo1471f()) || "subt".equals(this.f2067a.mo1471f())) {
            qrVar.mo5461b(2);
            qrVar.mo5463c(2);
        }
        qtVar.mo5482a(qrVar);
        return qtVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: m */
    public C0688nt mo1465m() {
        C0723ox oxVar = new C0723ox();
        oxVar.mo170a(mo1451a());
        oxVar.mo170a(mo1461i());
        oxVar.mo170a(mo1463k());
        return oxVar;
    }

    /* renamed from: f */
    public void mo1448f() {
        WritableByteChannel newChannel = Channels.newChannel(this.f2072g);
        mo1462j().mo18a(newChannel);
        mo1465m().mo18a(newChannel);
        while (true) {
            try {
                ama poll = this.f2067a.mo1427a().poll(100, TimeUnit.MILLISECONDS);
                if (poll != null) {
                    m2367a(poll, newChannel);
                } else if (!this.f2067a.mo1430b()) {
                    return;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    private void m2367a(ama ama, WritableByteChannel writableByteChannel) {
        amj amj = null;
        for (alw alw : ama.mo1469c()) {
            if (alw instanceof amj) {
                amj = (amj) alw;
            } else if (alw instanceof amg) {
                amg amg = (amg) alw;
            }
        }
        this.f2075j += ama.mo1468b();
        this.f2071e.add(ama);
        if (this.f2075j > this.f2074i + (this.f2067a.mo1470e() * 3) && this.f2071e.size() > 0) {
            if (this.f2069c == null || amj == null || amj.mo1492g()) {
                m2369n().mo18a(writableByteChannel);
                m2370o().mo18a(writableByteChannel);
                this.f2074i = this.f2075j;
                this.f2071e.clear();
            }
        }
    }

    /* renamed from: n */
    private C0688nt m2369n() {
        C0774qn qnVar = new C0774qn();
        m2368b(this.f2073h, qnVar);
        m2366a(this.f2073h, qnVar);
        C0786qy qyVar = qnVar.mo5450i().get(0);
        qyVar.mo5541c(1);
        qyVar.mo5541c((int) (qnVar.mo19f() + 8));
        return qnVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo1452a(C0782qv qvVar) {
        C0783qw qwVar = new C0783qw();
        qwVar.mo5494a(new C0778qr());
        qwVar.mo5496b(-1);
        amm amm = (amm) this.f2067a.mo1426a(amm.class);
        if (amm != null) {
            qwVar.mo5493a(amm.mo1494a());
        } else {
            qwVar.mo5493a(1);
        }
        qwVar.mo5497b(true);
        qvVar.mo170a((C0688nt) qwVar);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo1454b(C0782qv qvVar) {
        C0781qu quVar = new C0781qu();
        quVar.mo5158a_(1);
        quVar.mo5490a(this.f2074i);
        qvVar.mo170a((C0688nt) quVar);
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo1456c(C0782qv qvVar) {
        C0786qy qyVar = new C0786qy();
        boolean z = true;
        qyVar.mo5158a_(1);
        qyVar.mo5542c(true);
        qyVar.mo5540b(true);
        ArrayList arrayList = new ArrayList(this.f2071e.size());
        qyVar.mo5544e(this.f2067a.mo1426a(amh.class) != null);
        if (this.f2067a.mo1426a(amk.class) == null) {
            z = false;
        }
        qyVar.mo5543d(z);
        for (ama next : this.f2071e) {
            C0786qy.C0787a aVar = new C0786qy.C0787a();
            aVar.mo5560b((long) next.mo1467a().remaining());
            if (z) {
                amj amj = (amj) amb.m2396b(next, amj.class);
                if (f2066f || amj != null) {
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
            aVar.mo5557a(next.mo1468b());
            if (qyVar.mo5551p()) {
                amg amg = (amg) amb.m2396b(next, amg.class);
                if (f2066f || amg != null) {
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
    private void m2366a(long j, C0774qn qnVar) {
        C0782qv qvVar = new C0782qv();
        qnVar.mo170a((C0688nt) qvVar);
        mo1452a(qvVar);
        mo1454b(qvVar);
        mo1456c(qvVar);
        this.f2067a.mo1426a(amf.class);
    }

    /* renamed from: b */
    private void m2368b(long j, C0774qn qnVar) {
        C0775qo qoVar = new C0775qo();
        qoVar.mo5452a(j);
        qnVar.mo170a((C0688nt) qoVar);
    }

    /* renamed from: o */
    private C0688nt m2370o() {
        return new aly(this, C0788qz.f6010a);
    }
}
