package atakplugin.UASTool;

import java.util.Vector;

public interface ahf {

    /* renamed from: a */
    public static final int f1243a = 0;

    /* renamed from: b */
    public static final int f1244b = 1;

    /* renamed from: c */
    public static final int f1245c = 2;

    /* renamed from: a */
    String mo876a();

    /* renamed from: a */
    boolean mo877a(byte[] bArr);

    /* renamed from: b */
    int mo878b();

    /* renamed from: b */
    boolean mo879b(byte[] bArr);

    /* renamed from: c */
    Vector mo880c();

    /* renamed from: d */
    void mo881d();

    /* renamed from: atakplugin.UASTool.ahf$a */
    public static class C0043a implements ahf {

        /* renamed from: d */
        private ahf f1246d;

        /* renamed from: e */
        private Vector f1247e;

        /* renamed from: f */
        private boolean f1248f;

        C0043a(ahf ahf) {
            this(ahf, false);
        }

        C0043a(ahf ahf, boolean z) {
            this.f1247e = new Vector();
            this.f1248f = false;
            this.f1246d = ahf;
            this.f1248f = z;
        }

        /* renamed from: a */
        public String mo876a() {
            return this.f1246d.mo876a();
        }

        /* renamed from: b */
        public int mo878b() {
            return this.f1246d.mo878b();
        }

        /* renamed from: a */
        public boolean mo877a(byte[] bArr) {
            return this.f1246d.mo877a(bArr);
        }

        /* renamed from: b */
        public boolean mo879b(byte[] bArr) {
            return this.f1246d.mo879b(bArr);
        }

        /* renamed from: d */
        public void mo881d() {
            this.f1247e.removeAllElements();
            this.f1246d.mo881d();
        }

        /* renamed from: c */
        public Vector mo880c() {
            Vector vector = new Vector();
            for (int i = 0; i < this.f1247e.size(); i++) {
                vector.add((ahd) this.f1247e.elementAt(i));
            }
            Vector c = this.f1246d.mo880c();
            for (int i2 = 0; i2 < c.size(); i2++) {
                vector.add(c.elementAt(i2));
            }
            return vector;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo882a(ahd ahd) {
            if (this.f1248f || ahd.mo873e() || !(ahd instanceof ahe)) {
                this.f1247e.addElement(ahd);
                return;
            }
            try {
                this.f1246d.mo877a(((ahe) ahd).mo875g().mo944e());
            } catch (ahj unused) {
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: e */
        public void mo883e() {
            if (this.f1247e.size() > 0) {
                Object[] array = this.f1247e.toArray();
                for (Object obj : array) {
                    ahd ahd = (ahd) obj;
                    this.f1247e.removeElement(ahd);
                    mo882a(ahd);
                }
            }
        }
    }
}
