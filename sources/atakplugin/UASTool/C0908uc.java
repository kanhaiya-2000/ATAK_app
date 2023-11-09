package atakplugin.UASTool;

/* renamed from: atakplugin.UASTool.uc */
class C0908uc {

    /* renamed from: a */
    private int f7081a;

    /* renamed from: b */
    private int f7082b;

    C0908uc(int i, int i2) {
        this.f7081a = i;
        this.f7082b = i2;
    }

    C0908uc() {
        this.f7081a = 0;
        this.f7082b = 0;
    }

    /* renamed from: a */
    public void mo5905a(int i) {
        this.f7081a = i;
    }

    /* renamed from: b */
    public void mo5907b(int i) {
        this.f7082b = i;
    }

    /* renamed from: a */
    public int mo5904a() {
        return this.f7081a;
    }

    /* renamed from: b */
    public int mo5906b() {
        return this.f7082b;
    }

    public String toString() {
        return "Vendor: " + String.format("%04x", new Object[]{Integer.valueOf(this.f7081a)}) + ", Product: " + String.format("%04x", new Object[]{Integer.valueOf(this.f7082b)});
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0908uc)) {
            return false;
        }
        C0908uc ucVar = (C0908uc) obj;
        return this.f7081a == ucVar.f7081a && this.f7082b == ucVar.f7082b;
    }

    public int hashCode() {
        throw new UnsupportedOperationException();
    }
}
