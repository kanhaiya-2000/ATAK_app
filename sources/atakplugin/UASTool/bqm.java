package atakplugin.UASTool;

import atakplugin.UASTool.brp;
import atakplugin.UASTool.bsb;
import atakplugin.UASTool.bsh;
import atakplugin.UASTool.bsy;
import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class bqm implements Closeable, Flushable {

    /* renamed from: b */
    private static final int f3161b = 201105;

    /* renamed from: c */
    private static final int f3162c = 0;

    /* renamed from: d */
    private static final int f3163d = 1;

    /* renamed from: e */
    private static final int f3164e = 2;

    /* renamed from: a */
    final btf f3165a;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public final bsy f3166f;

    /* renamed from: g */
    private int f3167g;

    /* renamed from: h */
    private int f3168h;

    /* renamed from: i */
    private int f3169i;

    /* renamed from: j */
    private int f3170j;

    /* renamed from: k */
    private int f3171k;

    /* renamed from: c */
    static /* synthetic */ int m8589c(bqm bqm) {
        int i = bqm.f3167g;
        bqm.f3167g = i + 1;
        return i;
    }

    /* renamed from: d */
    static /* synthetic */ int m8591d(bqm bqm) {
        int i = bqm.f3168h;
        bqm.f3168h = i + 1;
        return i;
    }

    public bqm(File file, long j) {
        this(file, j, bvj.f4043a);
    }

    bqm(File file, long j, bvj bvj) {
        this.f3165a = new bqn(this);
        this.f3166f = bsy.m9200a(bvj, file, f3161b, 2, j);
    }

    /* renamed from: b */
    private static String m8588b(bsb bsb) {
        return bsp.m9151a(bsb.mo3343a().toString());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public bsh mo2998a(bsb bsb) {
        try {
            bsy.C0239c a = this.f3166f.mo3428a(m8588b(bsb));
            if (a == null) {
                return null;
            }
            try {
                C0216c cVar = new C0216c(a.mo3450a(0));
                bsh a2 = cVar.mo3019a(a);
                if (cVar.mo3021a(bsb, a2)) {
                    return a2;
                }
                bsp.m9158a((Closeable) a2.mo3384h());
                return null;
            } catch (IOException unused) {
                bsp.m9158a((Closeable) a);
                return null;
            }
        } catch (IOException unused2) {
            return null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public bsv m8578a(bsh bsh) {
        bsy.C0237a aVar;
        String b = bsh.mo3372a().mo3345b();
        if (bvb.m9788a(bsh.mo3372a().mo3345b())) {
            try {
                m8590c(bsh.mo3372a());
            } catch (IOException unused) {
            }
            return null;
        } else if (!b.equals("GET") || bva.m9783b(bsh)) {
            return null;
        } else {
            C0216c cVar = new C0216c(bsh);
            try {
                aVar = this.f3166f.mo3431b(m8588b(bsh.mo3372a()));
                if (aVar == null) {
                    return null;
                }
                try {
                    cVar.mo3020a(aVar);
                    return new C0214a(aVar);
                } catch (IOException unused2) {
                    m8585a(aVar);
                    return null;
                }
            } catch (IOException unused3) {
                aVar = null;
                m8585a(aVar);
                return null;
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m8590c(bsb bsb) {
        this.f3166f.mo3434c(m8588b(bsb));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m8583a(bsh bsh, bsh bsh2) {
        bsy.C0237a aVar;
        C0216c cVar = new C0216c(bsh2);
        try {
            aVar = ((C0215b) bsh.mo3384h()).f3177a.mo3453b();
            if (aVar != null) {
                try {
                    cVar.mo3020a(aVar);
                    aVar.mo3445b();
                } catch (IOException unused) {
                }
            }
        } catch (IOException unused2) {
            aVar = null;
            m8585a(aVar);
        }
    }

    /* renamed from: a */
    private void m8585a(bsy.C0237a aVar) {
        if (aVar != null) {
            try {
                aVar.mo3446c();
            } catch (IOException unused) {
            }
        }
    }

    /* renamed from: a */
    public void mo2999a() {
        this.f3166f.mo3429a();
    }

    /* renamed from: b */
    public void mo3000b() {
        this.f3166f.mo3438f();
    }

    /* renamed from: c */
    public void mo3001c() {
        this.f3166f.mo3440g();
    }

    /* renamed from: d */
    public Iterator<String> mo3003d() {
        return new bqo(this);
    }

    /* renamed from: e */
    public synchronized int mo3004e() {
        return this.f3168h;
    }

    /* renamed from: f */
    public synchronized int mo3005f() {
        return this.f3167g;
    }

    /* renamed from: g */
    public long mo3007g() {
        return this.f3166f.mo3436d();
    }

    /* renamed from: h */
    public long mo3008h() {
        return this.f3166f.mo3433c();
    }

    public void flush() {
        this.f3166f.flush();
    }

    public void close() {
        this.f3166f.close();
    }

    /* renamed from: i */
    public File mo3009i() {
        return this.f3166f.mo3432b();
    }

    /* renamed from: j */
    public boolean mo3010j() {
        return this.f3166f.mo3437e();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public synchronized void m8584a(bsw bsw) {
        this.f3171k++;
        if (bsw.f3596a != null) {
            this.f3169i++;
        } else if (bsw.f3597b != null) {
            this.f3170j++;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: n */
    public synchronized void m8592n() {
        this.f3170j++;
    }

    /* renamed from: k */
    public synchronized int mo3011k() {
        return this.f3169i;
    }

    /* renamed from: l */
    public synchronized int mo3012l() {
        return this.f3170j;
    }

    /* renamed from: m */
    public synchronized int mo3013m() {
        return this.f3171k;
    }

    /* renamed from: atakplugin.UASTool.bqm$a */
    private final class C0214a implements bsv {

        /* renamed from: b */
        private final bsy.C0237a f3173b;

        /* renamed from: c */
        private bxp f3174c;
        /* access modifiers changed from: private */

        /* renamed from: d */
        public boolean f3175d;

        /* renamed from: e */
        private bxp f3176e;

        public C0214a(bsy.C0237a aVar) {
            this.f3173b = aVar;
            bxp b = aVar.mo3444b(1);
            this.f3174c = b;
            this.f3176e = new bqp(this, b, bqm.this, aVar);
        }

        /* renamed from: a */
        public void mo3014a() {
            synchronized (bqm.this) {
                if (!this.f3175d) {
                    this.f3175d = true;
                    bqm.m8591d(bqm.this);
                    bsp.m9158a((Closeable) this.f3174c);
                    try {
                        this.f3173b.mo3446c();
                    } catch (IOException unused) {
                    }
                }
            }
        }

        /* renamed from: b */
        public bxp mo3015b() {
            return this.f3176e;
        }
    }

    /* renamed from: atakplugin.UASTool.bqm$c */
    private static final class C0216c {

        /* renamed from: a */
        private static final String f3181a = (bvp.m9870b().mo3733c() + "-Sent-Millis");

        /* renamed from: b */
        private static final String f3182b = (bvp.m9870b().mo3733c() + "-Received-Millis");

        /* renamed from: c */
        private final String f3183c;

        /* renamed from: d */
        private final brp f3184d;

        /* renamed from: e */
        private final String f3185e;

        /* renamed from: f */
        private final bry f3186f;

        /* renamed from: g */
        private final int f3187g;

        /* renamed from: h */
        private final String f3188h;

        /* renamed from: i */
        private final brp f3189i;

        /* renamed from: j */
        private final bro f3190j;

        /* renamed from: k */
        private final long f3191k;

        /* renamed from: l */
        private final long f3192l;

        public C0216c(bxr bxr) {
            try {
                bwp a = bxb.m10330a(bxr);
                this.f3183c = a.mo3890y();
                this.f3185e = a.mo3890y();
                brp.C0225a aVar = new brp.C0225a();
                int a2 = bqm.m8586b(a);
                for (int i = 0; i < a2; i++) {
                    aVar.mo3180a(a.mo3890y());
                }
                this.f3184d = aVar.mo3182a();
                bvh a3 = bvh.m9824a(a.mo3890y());
                this.f3186f = a3.f4040d;
                this.f3187g = a3.f4041e;
                this.f3188h = a3.f4042f;
                brp.C0225a aVar2 = new brp.C0225a();
                int a4 = bqm.m8586b(a);
                for (int i2 = 0; i2 < a4; i2++) {
                    aVar2.mo3180a(a.mo3890y());
                }
                String str = f3181a;
                String d = aVar2.mo3187d(str);
                String str2 = f3182b;
                String d2 = aVar2.mo3187d(str2);
                aVar2.mo3185c(str);
                aVar2.mo3185c(str2);
                long j = 0;
                this.f3191k = d != null ? Long.parseLong(d) : 0;
                this.f3192l = d2 != null ? Long.parseLong(d2) : j;
                this.f3189i = aVar2.mo3182a();
                bsm bsm = null;
                if (m8617a()) {
                    String y = a.mo3890y();
                    if (y.length() <= 0) {
                        this.f3190j = bro.m8771a(!a.mo3854i() ? bsm.m9130a(a.mo3890y()) : bsm, bqy.m8668a(a.mo3890y()), m8615a(a), m8615a(a));
                    } else {
                        throw new IOException("expected \"\" but was \"" + y + "\"");
                    }
                } else {
                    this.f3190j = null;
                }
            } finally {
                bxr.close();
            }
        }

        public C0216c(bsh bsh) {
            this.f3183c = bsh.mo3372a().mo3343a().toString();
            this.f3184d = bva.m9784c(bsh);
            this.f3185e = bsh.mo3372a().mo3345b();
            this.f3186f = bsh.mo3376b();
            this.f3187g = bsh.mo3378c();
            this.f3188h = bsh.mo3381e();
            this.f3189i = bsh.mo3383g();
            this.f3190j = bsh.mo3382f();
            this.f3191k = bsh.mo3392p();
            this.f3192l = bsh.mo3393q();
        }

        /* renamed from: a */
        public void mo3020a(bsy.C0237a aVar) {
            bwo a = bxb.m10329a(aVar.mo3444b(0));
            a.mo3817b(this.f3183c).mo3833d(10);
            a.mo3817b(this.f3185e).mo3833d(10);
            a.mo3875p((long) this.f3184d.mo3168a()).mo3833d(10);
            int a2 = this.f3184d.mo3168a();
            for (int i = 0; i < a2; i++) {
                a.mo3817b(this.f3184d.mo3169a(i)).mo3817b(": ").mo3817b(this.f3184d.mo3171b(i)).mo3833d(10);
            }
            a.mo3817b(new bvh(this.f3186f, this.f3187g, this.f3188h).toString()).mo3833d(10);
            a.mo3875p((long) (this.f3189i.mo3168a() + 2)).mo3833d(10);
            int a3 = this.f3189i.mo3168a();
            for (int i2 = 0; i2 < a3; i2++) {
                a.mo3817b(this.f3189i.mo3169a(i2)).mo3817b(": ").mo3817b(this.f3189i.mo3171b(i2)).mo3833d(10);
            }
            a.mo3817b(f3181a).mo3817b(": ").mo3875p(this.f3191k).mo3833d(10);
            a.mo3817b(f3182b).mo3817b(": ").mo3875p(this.f3192l).mo3833d(10);
            if (m8617a()) {
                a.mo3833d(10);
                a.mo3817b(this.f3190j.mo3161b().mo3078a()).mo3833d(10);
                m8616a(a, this.f3190j.mo3162c());
                m8616a(a, this.f3190j.mo3164e());
                if (this.f3190j.mo3160a() != null) {
                    a.mo3817b(this.f3190j.mo3160a().mo3422a()).mo3833d(10);
                }
            }
            a.close();
        }

        /* renamed from: a */
        private boolean m8617a() {
            return this.f3183c.startsWith("https://");
        }

        /* renamed from: a */
        private List<Certificate> m8615a(bwp bwp) {
            int a = bqm.m8586b(bwp);
            if (a == -1) {
                return Collections.emptyList();
            }
            try {
                CertificateFactory instance = CertificateFactory.getInstance("X.509");
                ArrayList arrayList = new ArrayList(a);
                for (int i = 0; i < a; i++) {
                    String y = bwp.mo3890y();
                    bwl bwl = new bwl();
                    bwl.mo3816b(bwq.m10197c(y));
                    arrayList.add(instance.generateCertificate(bwl.mo3862k()));
                }
                return arrayList;
            } catch (CertificateException e) {
                throw new IOException(e.getMessage());
            }
        }

        /* renamed from: a */
        private void m8616a(bwo bwo, List<Certificate> list) {
            try {
                bwo.mo3875p((long) list.size()).mo3833d(10);
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    bwo.mo3817b(bwq.m10200e(list.get(i).getEncoded()).mo3933d()).mo3833d(10);
                }
            } catch (CertificateEncodingException e) {
                throw new IOException(e.getMessage());
            }
        }

        /* renamed from: a */
        public boolean mo3021a(bsb bsb, bsh bsh) {
            return this.f3183c.equals(bsb.mo3343a().toString()) && this.f3185e.equals(bsb.mo3345b()) && bva.m9780a(bsh, this.f3184d, bsb);
        }

        /* renamed from: a */
        public bsh mo3019a(bsy.C0239c cVar) {
            String a = this.f3189i.mo3170a("Content-Type");
            String a2 = this.f3189i.mo3170a("Content-Length");
            return new bsh.C0235a().mo3400a(new bsb.C0234a().mo3360a(this.f3183c).mo3361a(this.f3185e, (bsd) null).mo3356a(this.f3184d).mo3371d()).mo3399a(this.f3186f).mo3395a(this.f3187g).mo3403a(this.f3188h).mo3398a(this.f3189i).mo3402a((bsj) new C0215b(cVar, a, a2)).mo3397a(this.f3190j).mo3396a(this.f3191k).mo3406b(this.f3192l).mo3405a();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static int m8586b(bwp bwp) {
        try {
            long t = bwp.mo3883t();
            String y = bwp.mo3890y();
            if (t >= 0 && t <= 2147483647L && y.isEmpty()) {
                return (int) t;
            }
            throw new IOException("expected an int but was \"" + t + y + "\"");
        } catch (NumberFormatException e) {
            throw new IOException(e.getMessage());
        }
    }

    /* renamed from: atakplugin.UASTool.bqm$b */
    private static class C0215b extends bsj {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public final bsy.C0239c f3177a;

        /* renamed from: b */
        private final bwp f3178b;

        /* renamed from: c */
        private final String f3179c;

        /* renamed from: d */
        private final String f3180d;

        public C0215b(bsy.C0239c cVar, String str, String str2) {
            this.f3177a = cVar;
            this.f3179c = str;
            this.f3180d = str2;
            this.f3178b = bxb.m10330a((bxr) new bqq(this, cVar.mo3450a(1), cVar));
        }

        /* renamed from: a */
        public bru mo3016a() {
            String str = this.f3179c;
            if (str != null) {
                return bru.m8896a(str);
            }
            return null;
        }

        /* renamed from: b */
        public long mo3017b() {
            try {
                String str = this.f3180d;
                if (str != null) {
                    return Long.parseLong(str);
                }
                return -1;
            } catch (NumberFormatException unused) {
                return -1;
            }
        }

        /* renamed from: c */
        public bwp mo3018c() {
            return this.f3178b;
        }
    }
}
