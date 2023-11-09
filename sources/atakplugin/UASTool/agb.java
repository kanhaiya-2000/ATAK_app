package atakplugin.UASTool;

import java.io.InputStream;
import java.io.OutputStream;

public class agb extends afy {

    /* renamed from: F */
    private static final int f960F = 131072;

    /* renamed from: G */
    private static final int f961G = 16384;

    /* renamed from: H */
    private static final byte[] f962H = aji.m1820c("direct-tcpip");

    /* renamed from: B */
    String f963B;

    /* renamed from: C */
    int f964C;

    /* renamed from: D */
    String f965D = "127.0.0.1";

    /* renamed from: E */
    int f966E = 0;

    agb() {
        this.f904k = f962H;
        mo668c(131072);
        mo670d(131072);
        mo671e(16384);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo659b() {
        this.f910q = new ahc();
    }

    /* renamed from: b */
    public void mo660b(int i) {
        this.f919z = i;
        try {
            air p = mo686p();
            if (!p.mo1081h()) {
                throw new ahj("session is down");
            } else if (this.f910q.f1234a != null) {
                this.f911r = new Thread(this);
                Thread thread = this.f911r;
                thread.setName("DirectTCPIP thread " + p.mo1092p());
                if (p.f1472M) {
                    this.f911r.setDaemon(p.f1472M);
                }
                this.f911r.start();
            } else {
                mo691t();
            }
        } catch (Exception e) {
            this.f910q.mo865c();
            this.f910q = null;
            afy.m931a((afy) this);
            if (e instanceof ahj) {
                throw ((ahj) e);
            }
        }
    }

    public void run() {
        try {
            mo691t();
            afx afx = new afx(this.f909p);
            ahy ahy = new ahy(afx);
            air p = mo686p();
            while (true) {
                if (!mo684n() || this.f911r == null || this.f910q == null || this.f910q.f1234a == null) {
                    break;
                }
                int read = this.f910q.f1234a.read(afx.f888b, 14, (afx.f888b.length - 14) - 84);
                if (read <= 0) {
                    mo680j();
                    break;
                }
                ahy.mo996a();
                afx.mo618a((byte) 94);
                afx.mo619a(this.f903j);
                afx.mo619a(read);
                afx.mo626b(read);
                synchronized (this) {
                    if (!this.f914u) {
                        p.mo1042a(ahy, (afy) this, read);
                    }
                }
            }
            mo680j();
            mo683m();
        } catch (Exception unused) {
            if (!this.f915v) {
                this.f915v = true;
            }
            mo683m();
        }
    }

    /* renamed from: a */
    public void mo652a(InputStream inputStream) {
        this.f910q.mo855a(inputStream);
    }

    /* renamed from: a */
    public void mo654a(OutputStream outputStream) {
        this.f910q.mo857a(outputStream);
    }

    /* renamed from: c */
    public void mo701c(String str) {
        this.f963B = str;
    }

    /* renamed from: i */
    public void mo703i(int i) {
        this.f964C = i;
    }

    /* renamed from: d */
    public void mo702d(String str) {
        this.f965D = str;
    }

    /* renamed from: j */
    public void mo704j(int i) {
        this.f966E = i;
    }

    /* access modifiers changed from: protected */
    /* renamed from: s */
    public ahy mo690s() {
        afx afx = new afx(this.f963B.length() + 50 + this.f965D.length() + 84);
        ahy ahy = new ahy(afx);
        ahy.mo996a();
        afx.mo618a((byte) 90);
        afx.mo627b(this.f904k);
        afx.mo619a(this.f902i);
        afx.mo619a(this.f906m);
        afx.mo619a(this.f907n);
        afx.mo627b(aji.m1820c(this.f963B));
        afx.mo619a(this.f964C);
        afx.mo627b(aji.m1820c(this.f965D));
        afx.mo619a(this.f966E);
        return ahy;
    }
}
