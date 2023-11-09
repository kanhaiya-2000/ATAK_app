package atakplugin.UASTool;

/* renamed from: atakplugin.UASTool.uk */
public class C0933uk {

    /* renamed from: a */
    protected String f7307a = "FT4222";

    /* renamed from: b */
    protected C0879tj f7308b;

    /* renamed from: c */
    protected C0940ur f7309c;

    /* renamed from: d */
    protected C0939uq f7310d;

    /* renamed from: e */
    protected C0943uu f7311e;

    public C0933uk(C0879tj tjVar) {
        this.f7308b = tjVar;
        this.f7309c = new C0940ur();
        this.f7310d = new C0939uq();
        this.f7311e = new C0943uu();
    }

    /* renamed from: a */
    public int mo5936a() {
        byte[] bArr = new byte[13];
        if (this.f7308b.mo5854b(32, 1, bArr, 13) != 13) {
            return 18;
        }
        this.f7309c.mo6000a(bArr);
        return 0;
    }

    /* renamed from: a */
    public int mo5937a(byte b) {
        if (b == this.f7309c.f7347f) {
            return 0;
        }
        int a = this.f7308b.mo5833a(33, (b << 8) | 4);
        if (a == 0) {
            this.f7309c.f7347f = b;
        }
        return a;
    }

    /* renamed from: a */
    public int mo5938a(byte[] bArr) {
        if (this.f7308b.mo5854b(32, 4, bArr, 1) < 0) {
            return 18;
        }
        this.f7309c.f7347f = bArr[0];
        return 0;
    }

    /* renamed from: b */
    public boolean mo5939b() {
        int l = this.f7308b.mo5870l();
        if (l <= 0) {
            return true;
        }
        return this.f7308b.mo5837a(new byte[l], l) == l;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public int mo5940c() {
        if (this.f7309c.f7344c != 0) {
            return 64;
        }
        byte b = this.f7309c.f7342a;
        return (b == 1 || b == 2) ? 256 : 512;
    }

    /* renamed from: d */
    public boolean mo5941d() {
        C0879tj tjVar = this.f7308b;
        if (tjVar == null) {
            return false;
        }
        short s = tjVar.mo5867i().f6629b & 65280;
        if (s == 5888) {
            this.f7308b.mo5867i().f6630c = 12;
            return true;
        } else if (s == 6144) {
            this.f7308b.mo5867i().f6630c = 10;
            return true;
        } else if (s != 6400) {
            return false;
        } else {
            this.f7308b.mo5867i().f6630c = 11;
            return true;
        }
    }

    /* renamed from: e */
    public C0946ux mo5942e() {
        if (!mo5941d()) {
            return null;
        }
        return new C0935um(this);
    }

    /* renamed from: f */
    public C0947uy mo5943f() {
        if (!mo5941d()) {
            return null;
        }
        return new C0936un(this);
    }

    /* renamed from: g */
    public C0948uz mo5944g() {
        if (!mo5941d()) {
            return null;
        }
        return new C0937uo(this);
    }

    /* renamed from: h */
    public C0950va mo5945h() {
        if (!mo5941d()) {
            return null;
        }
        return new C0938up(this);
    }

    /* renamed from: i */
    public C0945uw mo5946i() {
        if (!mo5941d()) {
            return null;
        }
        return new C0934ul(this);
    }
}
