package atakplugin.UASTool;

import java.util.Enumeration;
import java.util.Hashtable;

class age extends afy {

    /* renamed from: B */
    private static byte[] f983B = aji.m1820c("session");

    /* renamed from: C */
    protected boolean f984C = false;

    /* renamed from: D */
    protected boolean f985D = false;

    /* renamed from: E */
    protected Hashtable f986E = null;

    /* renamed from: F */
    protected boolean f987F = false;

    /* renamed from: G */
    protected String f988G = "vt100";

    /* renamed from: H */
    protected int f989H = 80;

    /* renamed from: I */
    protected int f990I = 24;

    /* renamed from: J */
    protected int f991J = 640;

    /* renamed from: K */
    protected int f992K = 480;

    /* renamed from: L */
    protected byte[] f993L = null;

    age() {
        this.f904k = f983B;
        this.f910q = new ahc();
    }

    /* renamed from: c */
    public void mo715c(boolean z) {
        this.f984C = z;
    }

    /* renamed from: a */
    public void mo656a(boolean z) {
        this.f985D = z;
    }

    /* renamed from: a */
    public void mo708a(Hashtable hashtable) {
        synchronized (this) {
            this.f986E = hashtable;
        }
    }

    /* renamed from: a */
    public void mo707a(String str, String str2) {
        mo709a(aji.m1820c(str), aji.m1820c(str2));
    }

    /* renamed from: a */
    public void mo709a(byte[] bArr, byte[] bArr2) {
        synchronized (this) {
            mo718u().put(bArr, bArr2);
        }
    }

    /* renamed from: u */
    private Hashtable mo718u() {
        if (this.f986E == null) {
            this.f986E = new Hashtable();
        }
        return this.f986E;
    }

    /* renamed from: b */
    public void mo710b(boolean z) {
        this.f987F = z;
    }

    /* renamed from: c */
    public void mo716c(byte[] bArr) {
        this.f993L = bArr;
    }

    /* renamed from: a */
    public void mo705a(int i, int i2, int i3, int i4) {
        mo706a(this.f988G, i, i2, i3, i4);
        if (this.f987F && mo684n()) {
            try {
                aio aio = new aio();
                aio.mo1024a(i, i2, i3, i4);
                aio.mo1014a(mo686p(), this);
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: d */
    public void mo717d(String str) {
        mo706a(str, 80, 24, 640, 480);
    }

    /* renamed from: a */
    public void mo706a(String str, int i, int i2, int i3, int i4) {
        this.f988G = str;
        this.f989H = i;
        this.f990I = i2;
        this.f991J = i3;
        this.f992K = i4;
    }

    /* access modifiers changed from: protected */
    /* renamed from: v */
    public void mo720v() {
        air p = mo686p();
        if (this.f984C) {
            new aig().mo1014a(p, this);
        }
        if (this.f985D) {
            new aip().mo1014a(p, this);
        }
        if (this.f987F) {
            aij aij = new aij();
            aij aij2 = aij;
            aij2.mo1021b(this.f988G);
            aij2.mo1018a(this.f989H, this.f990I, this.f991J, this.f992K);
            byte[] bArr = this.f993L;
            if (bArr != null) {
                aij2.mo1020a(bArr);
            }
            aij.mo1014a(p, this);
        }
        Hashtable hashtable = this.f986E;
        if (hashtable != null) {
            Enumeration keys = hashtable.keys();
            while (keys.hasMoreElements()) {
                Object nextElement = keys.nextElement();
                Object obj = this.f986E.get(nextElement);
                aih aih = new aih();
                aih.mo1017a(m1022a(nextElement), m1022a(obj));
                aih.mo1014a(p, this);
            }
        }
    }

    /* renamed from: a */
    private byte[] m1022a(Object obj) {
        if (obj instanceof String) {
            return aji.m1820c((String) obj);
        }
        return (byte[]) obj;
    }

    public void run() {
        afx afx = new afx(this.f909p);
        ahy ahy = new ahy(afx);
        while (true) {
            try {
                if (!mo684n() || this.f911r == null || this.f910q == null || this.f910q.f1234a == null) {
                    break;
                }
                int read = this.f910q.f1234a.read(afx.f888b, 14, (afx.f888b.length - 14) - 84);
                if (read != 0) {
                    if (read == -1) {
                        mo680j();
                        break;
                    } else if (this.f914u) {
                        break;
                    } else {
                        ahy.mo996a();
                        afx.mo618a((byte) 94);
                        afx.mo619a(this.f903j);
                        afx.mo619a(read);
                        afx.mo626b(read);
                        mo686p().mo1042a(ahy, (afy) this, read);
                    }
                }
            } catch (Exception unused) {
            }
        }
        Thread thread = this.f911r;
        if (thread != null) {
            synchronized (thread) {
                thread.notifyAll();
            }
        }
        this.f911r = null;
    }
}
