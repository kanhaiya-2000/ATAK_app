package atakplugin.UASTool;

import atakplugin.UASTool.alo;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/* renamed from: atakplugin.UASTool.xd */
public class C1019xd extends C1023xg implements C1062yo {

    /* renamed from: d */
    static final /* synthetic */ boolean f7546d = true;

    /* renamed from: g */
    private List<alo> f7547g;

    /* renamed from: h */
    private UUID f7548h;

    /* renamed from: j */
    public boolean mo6148j() {
        return false;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C1019xd(String str, C0754pv pvVar, C0678nj... njVarArr) {
        super(str, pvVar, njVarArr);
        long j;
        int i;
        long j2;
        C0695nz nzVar;
        long j3;
        int i2;
        C0754pv pvVar2 = pvVar;
        C0743pn pnVar = (C0743pn) aft.m883a((C1003wo) pvVar2, "mdia[0]/minf[0]/stbl[0]/stsd[0]/enc.[0]/sinf[0]/schm[0]");
        if (f7546d || (pnVar != null && (pnVar.mo36c().equals("cenc") || pnVar.mo36c().equals("cbc1")))) {
            this.f7547g = new ArrayList();
            long j4 = pvVar.mo5377a().mo5394j();
            if (pvVar.mo1474e().mo202a(C0772ql.class).size() > 0) {
                Iterator<C0774qn> it = ((C0688nt) pvVar.mo1474e()).mo1474e().mo202a(C0774qn.class).iterator();
                while (it.hasNext()) {
                    C0774qn next = it.next();
                    Iterator<C0782qv> it2 = next.mo202a(C0782qv.class).iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            C0782qv next2 = it2.next();
                            if (next2.mo5492a().mo5504m() == j4) {
                                alr alr = (alr) aft.m883a((C1003wo) pvVar2, "mdia[0]/minf[0]/stbl[0]/stsd[0]/enc.[0]/sinf[0]/schi[0]/tenc[0]");
                                this.f7548h = alr.mo60j();
                                if (next2.mo5492a().mo36c()) {
                                    nzVar = ((C0688nt) pvVar.mo1474e()).mo1474e();
                                    j2 = next2.mo5492a().mo5505n();
                                } else {
                                    nzVar = next;
                                    j2 = 0;
                                }
                                C1020a c = new C1020a(next2).mo6153c();
                                akw b = c.mo6152b();
                                akx a = c.mo6151a();
                                boolean z = f7546d;
                                if (z || b != null) {
                                    long[] j5 = b.mo1196j();
                                    if (!z) {
                                        j3 = j4;
                                        if (j5.length != next2.mo202a(C0786qy.class).size()) {
                                            throw new AssertionError();
                                        }
                                    } else {
                                        j3 = j4;
                                    }
                                    if (z || a != null) {
                                        List<C0786qy> a2 = next2.mo202a(C0786qy.class);
                                        int i3 = 0;
                                        int i4 = 0;
                                        while (i3 < j5.length) {
                                            int size = a2.get(i3).mo36c().size();
                                            long j6 = j5[i3];
                                            List<C0786qy> list = a2;
                                            Iterator<C0774qn> it3 = it;
                                            int i5 = i4;
                                            C0774qn qnVar = next;
                                            Iterator<C0782qv> it4 = it2;
                                            long j7 = 0;
                                            while (true) {
                                                i2 = i4 + size;
                                                if (i5 >= i2) {
                                                    break;
                                                }
                                                long[] jArr = j5;
                                                int i6 = i4;
                                                j7 += (long) a.mo1200c(i5);
                                                i5++;
                                                i3 = i3;
                                            }
                                            long[] jArr2 = j5;
                                            ByteBuffer a3 = nzVar.mo201a(j2 + j6, j7);
                                            int i7 = i4;
                                            while (i7 < i2) {
                                                this.f7547g.add(m14488a(alr.mo43i(), a3, (long) a.mo1200c(i7)));
                                                i7++;
                                                i3 = i3;
                                            }
                                            i3++;
                                            a2 = list;
                                            i4 = i2;
                                            next = qnVar;
                                            it2 = it4;
                                            it = it3;
                                            j5 = jArr2;
                                        }
                                        j4 = j3;
                                    } else {
                                        throw new AssertionError();
                                    }
                                } else {
                                    throw new AssertionError();
                                }
                            }
                        }
                    }
                }
                return;
            }
            alr alr2 = (alr) aft.m883a((C1003wo) pvVar2, "mdia[0]/minf[0]/stbl[0]/stsd[0]/enc.[0]/sinf[0]/schi[0]/tenc[0]");
            this.f7548h = alr2.mo60j();
            C0690nv nvVar = (C0690nv) aft.m883a((C1003wo) pvVar2, "mdia[0]/minf[0]/stbl[0]/stco[0]");
            long[] c2 = pvVar.mo5378b().mo5324d().mo5331c((nvVar == null ? (C0690nv) aft.m883a((C1003wo) pvVar2, "mdia[0]/minf[0]/stbl[0]/co64[0]") : nvVar).mo5123a().length);
            C1020a c3 = new C1020a((C0695nz) aft.m883a((C1003wo) pvVar2, "mdia[0]/minf[0]/stbl[0]")).mo6153c();
            akw a4 = c3.f7553e;
            akx b2 = c3.f7552d;
            C0695nz e = ((C0723ox) pvVar.mo1474e()).mo1474e();
            if (a4.mo1196j().length == 1) {
                long j8 = a4.mo1196j()[0];
                if (b2.mo1203j() > 0) {
                    i = (b2.mo1205l() * b2.mo1203j()) + 0;
                } else {
                    i = 0;
                    for (int i8 = 0; i8 < b2.mo1205l(); i8++) {
                        i += b2.mo1204k()[i8];
                    }
                }
                ByteBuffer a5 = e.mo201a(j8, (long) i);
                for (int i9 = 0; i9 < b2.mo1205l(); i9++) {
                    this.f7547g.add(m14488a(alr2.mo43i(), a5, (long) b2.mo1200c(i9)));
                }
            } else if (a4.mo1196j().length == c2.length) {
                int i10 = 0;
                for (int i11 = 0; i11 < c2.length; i11++) {
                    long j9 = a4.mo1196j()[i11];
                    if (b2.mo1203j() > 0) {
                        j = (((long) b2.mo1205l()) * c2[i11]) + 0;
                    } else {
                        j = 0;
                        for (int i12 = 0; ((long) i12) < c2[i11]; i12++) {
                            j += (long) b2.mo1200c(i10 + i12);
                        }
                    }
                    ByteBuffer a6 = e.mo201a(j9, j);
                    for (int i13 = 0; ((long) i13) < c2[i11]; i13++) {
                        this.f7547g.add(m14488a(alr2.mo43i(), a6, (long) b2.mo1200c(i10 + i13)));
                    }
                    i10 = (int) (((long) i10) + c2[i11]);
                }
            } else {
                throw new RuntimeException("Number of saio offsets must be either 1 or number of chunks");
            }
        } else {
            throw new AssertionError("Track must be CENC (cenc or cbc1) encrypted");
        }
    }

    /* renamed from: a */
    private alo m14488a(int i, ByteBuffer byteBuffer, long j) {
        alo alo = new alo();
        if (j > 0) {
            alo.f1972a = new byte[i];
            byteBuffer.get(alo.f1972a);
            if (j > ((long) i)) {
                alo.f1973b = new alo.C0065j[C0679nk.m12497d(byteBuffer)];
                for (int i2 = 0; i2 < alo.f1973b.length; i2++) {
                    alo.f1973b[i2] = alo.mo1402a(C0679nk.m12497d(byteBuffer), C0679nk.m12495b(byteBuffer));
                }
            }
        }
        return alo;
    }

    /* renamed from: i */
    public UUID mo6147i() {
        return this.f7548h;
    }

    /* renamed from: k */
    public List<alo> mo6149k() {
        return this.f7547g;
    }

    public String toString() {
        return "CencMp4TrackImpl{handler='" + mo15p() + '\'' + '}';
    }

    /* renamed from: f */
    public String mo6144f() {
        return "enc(" + super.mo6144f() + ")";
    }

    /* renamed from: atakplugin.UASTool.xd$a */
    private class C1020a {

        /* renamed from: b */
        static final /* synthetic */ boolean f7549b = true;

        /* renamed from: c */
        private C0695nz f7551c;
        /* access modifiers changed from: private */

        /* renamed from: d */
        public akx f7552d;
        /* access modifiers changed from: private */

        /* renamed from: e */
        public akw f7553e;

        static {
            Class<C1019xd> cls = C1019xd.class;
        }

        public C1020a(C0695nz nzVar) {
            this.f7551c = nzVar;
        }

        /* renamed from: a */
        public akx mo6151a() {
            return this.f7552d;
        }

        /* renamed from: b */
        public akw mo6152b() {
            return this.f7553e;
        }

        /* renamed from: c */
        public C1020a mo6153c() {
            List<akx> a = this.f7551c.mo202a(akx.class);
            List<akw> a2 = this.f7551c.mo202a(akw.class);
            if (f7549b || a.size() == a2.size()) {
                this.f7552d = null;
                this.f7553e = null;
                for (int i = 0; i < a.size(); i++) {
                    if (!(this.f7552d == null && a.get(i).mo36c() == null) && !"cenc".equals(a.get(i).mo36c())) {
                        akx akx = this.f7552d;
                        if (akx == null || akx.mo36c() != null || !"cenc".equals(a.get(i).mo36c())) {
                            throw new RuntimeException("Are there two cenc labeled saiz?");
                        }
                        this.f7552d = a.get(i);
                    } else {
                        this.f7552d = a.get(i);
                    }
                    if (!(this.f7553e == null && a2.get(i).mo36c() == null) && !"cenc".equals(a2.get(i).mo36c())) {
                        akw akw = this.f7553e;
                        if (akw == null || akw.mo36c() != null || !"cenc".equals(a2.get(i).mo36c())) {
                            throw new RuntimeException("Are there two cenc labeled saio?");
                        }
                        this.f7553e = a2.get(i);
                    } else {
                        this.f7553e = a2.get(i);
                    }
                }
                return this;
            }
            throw new AssertionError();
        }
    }
}
