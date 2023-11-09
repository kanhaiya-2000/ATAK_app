package atakplugin.UASTool;

import atakplugin.UASTool.brp;
import atakplugin.UASTool.bsh;
import com.google.common.net.HttpHeaders;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;

public final class buv implements bvc {

    /* renamed from: b */
    private static final int f3970b = 0;

    /* renamed from: c */
    private static final int f3971c = 1;

    /* renamed from: d */
    private static final int f3972d = 2;

    /* renamed from: e */
    private static final int f3973e = 3;

    /* renamed from: f */
    private static final int f3974f = 4;

    /* renamed from: g */
    private static final int f3975g = 5;

    /* renamed from: h */
    private static final int f3976h = 6;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public final brw f3977i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public final btm f3978j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public final bwp f3979k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public final bwo f3980l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public int f3981m = 0;

    public buv(brw brw, btm btm, bwp bwp, bwo bwo) {
        this.f3977i = brw;
        this.f3978j = btm;
        this.f3979k = bwp;
        this.f3980l = bwo;
    }

    /* renamed from: a */
    public bxp mo3682a(bsb bsb, long j) {
        if ("chunked".equalsIgnoreCase(bsb.mo3344a(HttpHeaders.TRANSFER_ENCODING))) {
            return mo3693g();
        }
        if (j != -1) {
            return mo3681a(j);
        }
        throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
    }

    /* renamed from: a */
    public void mo3684a() {
        bti b = this.f3978j.mo3488b();
        if (b != null) {
            b.mo3472e();
        }
    }

    /* renamed from: a */
    public void mo3686a(bsb bsb) {
        mo3685a(bsb.mo3347c(), bvf.m9809a(bsb, this.f3978j.mo3488b().mo3080a().mo3417b().type()));
    }

    /* renamed from: b */
    public bsh.C0235a mo3687b() {
        return mo3691e();
    }

    /* renamed from: a */
    public bsj mo3680a(bsh bsh) {
        return new bve(bsh.mo3383g(), bxb.m10330a(m9732b(bsh)));
    }

    /* renamed from: b */
    private bxr m9732b(bsh bsh) {
        if (!bva.m9786d(bsh)) {
            return mo3688b(0);
        }
        if ("chunked".equalsIgnoreCase(bsh.mo3377b(HttpHeaders.TRANSFER_ENCODING))) {
            return mo3683a(bsh.mo3372a().mo3343a());
        }
        long a = bva.m9775a(bsh);
        if (a != -1) {
            return mo3688b(a);
        }
        return mo3694h();
    }

    /* renamed from: c */
    public boolean mo3689c() {
        return this.f3981m == 6;
    }

    /* renamed from: d */
    public void mo3690d() {
        this.f3980l.flush();
    }

    /* renamed from: a */
    public void mo3685a(brp brp, String str) {
        if (this.f3981m == 0) {
            this.f3980l.mo3817b(str).mo3817b("\r\n");
            int a = brp.mo3168a();
            for (int i = 0; i < a; i++) {
                this.f3980l.mo3817b(brp.mo3169a(i)).mo3817b(": ").mo3817b(brp.mo3171b(i)).mo3817b("\r\n");
            }
            this.f3980l.mo3817b("\r\n");
            this.f3981m = 1;
            return;
        }
        throw new IllegalStateException("state: " + this.f3981m);
    }

    /* renamed from: e */
    public bsh.C0235a mo3691e() {
        bvh a;
        bsh.C0235a a2;
        int i = this.f3981m;
        if (i == 1 || i == 3) {
            do {
                try {
                    a = bvh.m9824a(this.f3979k.mo3890y());
                    a2 = new bsh.C0235a().mo3399a(a.f4040d).mo3395a(a.f4041e).mo3403a(a.f4042f).mo3398a(mo3692f());
                } catch (EOFException e) {
                    IOException iOException = new IOException("unexpected end of stream on " + this.f3978j);
                    iOException.initCause(e);
                    throw iOException;
                }
            } while (a.f4041e == 100);
            this.f3981m = 4;
            return a2;
        }
        throw new IllegalStateException("state: " + this.f3981m);
    }

    /* renamed from: f */
    public brp mo3692f() {
        brp.C0225a aVar = new brp.C0225a();
        while (true) {
            String y = this.f3979k.mo3890y();
            if (y.length() == 0) {
                return aVar.mo3182a();
            }
            bsn.f3580a.mo3329a(aVar, y);
        }
    }

    /* renamed from: g */
    public bxp mo3693g() {
        if (this.f3981m == 1) {
            this.f3981m = 2;
            return new C0259b();
        }
        throw new IllegalStateException("state: " + this.f3981m);
    }

    /* renamed from: a */
    public bxp mo3681a(long j) {
        if (this.f3981m == 1) {
            this.f3981m = 2;
            return new C0261d(j);
        }
        throw new IllegalStateException("state: " + this.f3981m);
    }

    /* renamed from: b */
    public bxr mo3688b(long j) {
        if (this.f3981m == 4) {
            this.f3981m = 5;
            return new C0262e(j);
        }
        throw new IllegalStateException("state: " + this.f3981m);
    }

    /* renamed from: a */
    public bxr mo3683a(brr brr) {
        if (this.f3981m == 4) {
            this.f3981m = 5;
            return new C0260c(brr);
        }
        throw new IllegalStateException("state: " + this.f3981m);
    }

    /* renamed from: h */
    public bxr mo3694h() {
        if (this.f3981m == 4) {
            btm btm = this.f3978j;
            if (btm != null) {
                this.f3981m = 5;
                btm.mo3490d();
                return new C0263f();
            }
            throw new IllegalStateException("streamAllocation == null");
        }
        throw new IllegalStateException("state: " + this.f3981m);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m9730a(bwu bwu) {
        bxs g = bwu.mo3989g();
        bwu.mo3982a(bxs.f4214c);
        g.mo3991h_();
        g.mo3987d();
    }

    /* renamed from: atakplugin.UASTool.buv$d */
    private final class C0261d implements bxp {

        /* renamed from: b */
        private final bwu f3994b;

        /* renamed from: c */
        private boolean f3995c;

        /* renamed from: d */
        private long f3996d;

        private C0261d(long j) {
            this.f3994b = new bwu(buv.this.f3980l.timeout());
            this.f3996d = j;
        }

        public bxs timeout() {
            return this.f3994b;
        }

        public void write(bwl bwl, long j) {
            if (!this.f3995c) {
                bsp.m9157a(bwl.mo3783a(), 0, j);
                if (j <= this.f3996d) {
                    buv.this.f3980l.write(bwl, j);
                    this.f3996d -= j;
                    return;
                }
                throw new ProtocolException("expected " + this.f3996d + " bytes but received " + j);
            }
            throw new IllegalStateException("closed");
        }

        public void flush() {
            if (!this.f3995c) {
                buv.this.f3980l.flush();
            }
        }

        public void close() {
            if (!this.f3995c) {
                this.f3995c = true;
                if (this.f3996d <= 0) {
                    buv.this.m9730a(this.f3994b);
                    int unused = buv.this.f3981m = 3;
                    return;
                }
                throw new ProtocolException("unexpected end of stream");
            }
        }
    }

    /* renamed from: atakplugin.UASTool.buv$b */
    private final class C0259b implements bxp {

        /* renamed from: b */
        private final bwu f3986b;

        /* renamed from: c */
        private boolean f3987c;

        private C0259b() {
            this.f3986b = new bwu(buv.this.f3980l.timeout());
        }

        public bxs timeout() {
            return this.f3986b;
        }

        public void write(bwl bwl, long j) {
            if (this.f3987c) {
                throw new IllegalStateException("closed");
            } else if (j != 0) {
                buv.this.f3980l.mo3879r(j);
                buv.this.f3980l.mo3817b("\r\n");
                buv.this.f3980l.write(bwl, j);
                buv.this.f3980l.mo3817b("\r\n");
            }
        }

        public synchronized void flush() {
            if (!this.f3987c) {
                buv.this.f3980l.flush();
            }
        }

        public synchronized void close() {
            if (!this.f3987c) {
                this.f3987c = true;
                buv.this.f3980l.mo3817b("0\r\n\r\n");
                buv.this.m9730a(this.f3986b);
                int unused = buv.this.f3981m = 3;
            }
        }
    }

    /* renamed from: atakplugin.UASTool.buv$a */
    private abstract class C0258a implements bxr {

        /* renamed from: a */
        protected final bwu f3982a;

        /* renamed from: b */
        protected boolean f3983b;

        private C0258a() {
            this.f3982a = new bwu(buv.this.f3979k.timeout());
        }

        public bxs timeout() {
            return this.f3982a;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public final void mo3695a(boolean z) {
            if (buv.this.f3981m != 6) {
                if (buv.this.f3981m == 5) {
                    buv.this.m9730a(this.f3982a);
                    int unused = buv.this.f3981m = 6;
                    if (buv.this.f3978j != null) {
                        buv.this.f3978j.mo3487a(!z, (bvc) buv.this);
                        return;
                    }
                    return;
                }
                throw new IllegalStateException("state: " + buv.this.f3981m);
            }
        }
    }

    /* renamed from: atakplugin.UASTool.buv$e */
    private class C0262e extends C0258a {

        /* renamed from: e */
        private long f3998e;

        public C0262e(long j) {
            super();
            this.f3998e = j;
            if (j == 0) {
                mo3695a(true);
            }
        }

        /* renamed from: a */
        public long mo3425a(bwl bwl, long j) {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            } else if (this.f3983b) {
                throw new IllegalStateException("closed");
            } else if (this.f3998e == 0) {
                return -1;
            } else {
                long a = buv.this.f3979k.mo3425a(bwl, Math.min(this.f3998e, j));
                if (a != -1) {
                    long j2 = this.f3998e - a;
                    this.f3998e = j2;
                    if (j2 == 0) {
                        mo3695a(true);
                    }
                    return a;
                }
                mo3695a(false);
                throw new ProtocolException("unexpected end of stream");
            }
        }

        public void close() {
            if (!this.f3983b) {
                if (this.f3998e != 0 && !bsp.m9162a((bxr) this, 100, TimeUnit.MILLISECONDS)) {
                    mo3695a(false);
                }
                this.f3983b = true;
            }
        }
    }

    /* renamed from: atakplugin.UASTool.buv$c */
    private class C0260c extends C0258a {

        /* renamed from: e */
        private static final long f3988e = -1;

        /* renamed from: f */
        private final brr f3990f;

        /* renamed from: g */
        private long f3991g = -1;

        /* renamed from: h */
        private boolean f3992h = true;

        C0260c(brr brr) {
            super();
            this.f3990f = brr;
        }

        /* renamed from: a */
        public long mo3425a(bwl bwl, long j) {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            } else if (this.f3983b) {
                throw new IllegalStateException("closed");
            } else if (!this.f3992h) {
                return -1;
            } else {
                long j2 = this.f3991g;
                if (j2 == 0 || j2 == -1) {
                    m9752a();
                    if (!this.f3992h) {
                        return -1;
                    }
                }
                long a = buv.this.f3979k.mo3425a(bwl, Math.min(j, this.f3991g));
                if (a != -1) {
                    this.f3991g -= a;
                    return a;
                }
                mo3695a(false);
                throw new ProtocolException("unexpected end of stream");
            }
        }

        /* renamed from: a */
        private void m9752a() {
            if (this.f3991g != -1) {
                buv.this.f3979k.mo3890y();
            }
            try {
                this.f3991g = buv.this.f3979k.mo3885u();
                String trim = buv.this.f3979k.mo3890y().trim();
                if (this.f3991g < 0 || (!trim.isEmpty() && !trim.startsWith(";"))) {
                    throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.f3991g + trim + "\"");
                } else if (this.f3991g == 0) {
                    this.f3992h = false;
                    bva.m9779a(buv.this.f3977i.mo3276f(), this.f3990f, buv.this.mo3692f());
                    mo3695a(true);
                }
            } catch (NumberFormatException e) {
                throw new ProtocolException(e.getMessage());
            }
        }

        public void close() {
            if (!this.f3983b) {
                if (this.f3992h && !bsp.m9162a((bxr) this, 100, TimeUnit.MILLISECONDS)) {
                    mo3695a(false);
                }
                this.f3983b = true;
            }
        }
    }

    /* renamed from: atakplugin.UASTool.buv$f */
    private class C0263f extends C0258a {

        /* renamed from: e */
        private boolean f4000e;

        private C0263f() {
            super();
        }

        /* renamed from: a */
        public long mo3425a(bwl bwl, long j) {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            } else if (this.f3983b) {
                throw new IllegalStateException("closed");
            } else if (this.f4000e) {
                return -1;
            } else {
                long a = buv.this.f3979k.mo3425a(bwl, j);
                if (a != -1) {
                    return a;
                }
                this.f4000e = true;
                mo3695a(true);
                return -1;
            }
        }

        public void close() {
            if (!this.f3983b) {
                if (!this.f4000e) {
                    mo3695a(false);
                }
                this.f3983b = true;
            }
        }
    }
}
