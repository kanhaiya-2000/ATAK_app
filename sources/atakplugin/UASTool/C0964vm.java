package atakplugin.UASTool;

import java.util.Comparator;

/* renamed from: atakplugin.UASTool.vm */
public class C0964vm implements Comparable<C0964vm> {

    /* renamed from: a */
    public static final Comparator<C0964vm> f7430a = new C0966a();

    /* renamed from: e */
    private static final String f7431e = "-";

    /* renamed from: f */
    private static final String f7432f = "+";

    /* renamed from: b */
    private final C0960vi f7433b;

    /* renamed from: c */
    private final C0958vh f7434c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final C0958vh f7435d;

    /* renamed from: atakplugin.UASTool.vm$b */
    public static class C0967b {

        /* renamed from: a */
        private String f7436a;

        /* renamed from: b */
        private String f7437b;

        /* renamed from: c */
        private String f7438c;

        public C0967b() {
        }

        public C0967b(String str) {
            this.f7436a = str;
        }

        /* renamed from: a */
        public C0967b mo6075a(String str) {
            this.f7436a = str;
            return this;
        }

        /* renamed from: b */
        public C0967b mo6077b(String str) {
            this.f7437b = str;
            return this;
        }

        /* renamed from: c */
        public C0967b mo6078c(String str) {
            this.f7438c = str;
            return this;
        }

        /* renamed from: a */
        public C0964vm mo6076a() {
            StringBuilder sb = new StringBuilder();
            if (m14274d(this.f7436a)) {
                sb.append(this.f7436a);
            }
            if (m14274d(this.f7437b)) {
                sb.append(C0964vm.f7431e);
                sb.append(this.f7437b);
            }
            if (m14274d(this.f7438c)) {
                sb.append(C0964vm.f7432f);
                sb.append(this.f7438c);
            }
            return C0968vn.m14284c(sb.toString());
        }

        /* renamed from: d */
        private boolean m14274d(String str) {
            return str != null && !str.isEmpty();
        }
    }

    /* renamed from: atakplugin.UASTool.vm$a */
    private static class C0966a implements Comparator<C0964vm> {
        private C0966a() {
        }

        /* renamed from: a */
        public int compare(C0964vm vmVar, C0964vm vmVar2) {
            int e = vmVar.compareTo(vmVar2);
            if (e != 0) {
                return e;
            }
            int a = vmVar.f7435d.compareTo(vmVar2.f7435d);
            return (vmVar.f7435d == C0958vh.f7422a || vmVar2.f7435d == C0958vh.f7422a) ? a * -1 : a;
        }
    }

    C0964vm(C0960vi viVar) {
        this(viVar, C0958vh.f7422a, C0958vh.f7422a);
    }

    C0964vm(C0960vi viVar, C0958vh vhVar) {
        this(viVar, vhVar, C0958vh.f7422a);
    }

    C0964vm(C0960vi viVar, C0958vh vhVar, C0958vh vhVar2) {
        this.f7433b = viVar;
        this.f7434c = vhVar;
        this.f7435d = vhVar2;
    }

    /* renamed from: a */
    public static C0964vm m14247a(String str) {
        return C0968vn.m14284c(str);
    }

    /* renamed from: a */
    public static C0964vm m14244a(int i) {
        return new C0964vm(new C0960vi(i, 0, 0));
    }

    /* renamed from: a */
    public static C0964vm m14245a(int i, int i2) {
        return new C0964vm(new C0960vi(i, i2, 0));
    }

    /* renamed from: a */
    public static C0964vm m14246a(int i, int i2, int i3) {
        return new C0964vm(new C0960vi(i, i2, i3));
    }

    /* renamed from: b */
    public boolean mo6050b(String str) {
        return mo6047a(C0983vz.m14334a().mo6041a(str));
    }

    /* renamed from: a */
    public boolean mo6047a(C0982vy vyVar) {
        return vyVar.mo6088a(this);
    }

    /* renamed from: a */
    public C0964vm mo6045a() {
        return new C0964vm(this.f7433b.mo6034d());
    }

    /* renamed from: c */
    public C0964vm mo6052c(String str) {
        return new C0964vm(this.f7433b.mo6034d(), C0968vn.m14289e(str));
    }

    /* renamed from: b */
    public C0964vm mo6048b() {
        return new C0964vm(this.f7433b.mo6035e());
    }

    /* renamed from: d */
    public C0964vm mo6056d(String str) {
        return new C0964vm(this.f7433b.mo6035e(), C0968vn.m14289e(str));
    }

    /* renamed from: c */
    public C0964vm mo6051c() {
        return new C0964vm(this.f7433b.mo6037f());
    }

    /* renamed from: e */
    public C0964vm mo6060e(String str) {
        return new C0964vm(this.f7433b.mo6037f(), C0968vn.m14289e(str));
    }

    /* renamed from: d */
    public C0964vm mo6055d() {
        return new C0964vm(this.f7433b, this.f7434c.mo6024a());
    }

    /* renamed from: e */
    public C0964vm mo6059e() {
        return new C0964vm(this.f7433b, this.f7434c, this.f7435d.mo6024a());
    }

    /* renamed from: f */
    public C0964vm mo6064f(String str) {
        return new C0964vm(this.f7433b, C0968vn.m14289e(str));
    }

    /* renamed from: g */
    public C0964vm mo6066g(String str) {
        return new C0964vm(this.f7433b, this.f7434c, C0968vn.m14290f(str));
    }

    /* renamed from: f */
    public int mo6062f() {
        return this.f7433b.mo6029a();
    }

    /* renamed from: g */
    public int mo6065g() {
        return this.f7433b.mo6031b();
    }

    /* renamed from: h */
    public int mo6067h() {
        return this.f7433b.mo6032c();
    }

    /* renamed from: i */
    public String mo6069i() {
        return this.f7433b.toString();
    }

    /* renamed from: j */
    public String mo6070j() {
        return this.f7434c.toString();
    }

    /* renamed from: k */
    public String mo6071k() {
        return this.f7435d.toString();
    }

    /* renamed from: a */
    public boolean mo6046a(C0964vm vmVar) {
        return compareTo(vmVar) > 0;
    }

    /* renamed from: b */
    public boolean mo6049b(C0964vm vmVar) {
        return compareTo(vmVar) >= 0;
    }

    /* renamed from: c */
    public boolean mo6053c(C0964vm vmVar) {
        return compareTo(vmVar) < 0;
    }

    /* renamed from: d */
    public boolean mo6057d(C0964vm vmVar) {
        return compareTo(vmVar) <= 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof C0964vm) && compareTo((C0964vm) obj) == 0) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((485 + this.f7433b.hashCode()) * 97) + this.f7434c.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(mo6069i());
        if (!mo6070j().isEmpty()) {
            sb.append(f7431e);
            sb.append(mo6070j());
        }
        if (!mo6071k().isEmpty()) {
            sb.append(f7432f);
            sb.append(mo6071k());
        }
        return sb.toString();
    }

    /* renamed from: e */
    public int compareTo(C0964vm vmVar) {
        int a = this.f7433b.compareTo(vmVar.f7433b);
        return a == 0 ? this.f7434c.compareTo(vmVar.f7434c) : a;
    }

    /* renamed from: f */
    public int mo6063f(C0964vm vmVar) {
        return f7430a.compare(this, vmVar);
    }
}
