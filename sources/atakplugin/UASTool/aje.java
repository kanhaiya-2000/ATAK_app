package atakplugin.UASTool;

class aje extends ajb {

    /* renamed from: l */
    private static final int f1618l = 6;

    /* renamed from: m */
    private String f1619m = null;

    aje() {
    }

    /* renamed from: a */
    public boolean mo1167a(air air) {
        super.mo1167a(air);
        this.f1607i.mo996a();
        this.f1608j.mo618a((byte) 5);
        this.f1608j.mo627b(aji.m1820c("ssh-userauth"));
        air.mo1061b(this.f1607i);
        if (ahg.m1351f().mo908a(1)) {
            ahg.m1351f().mo907a(1, "SSH_MSG_SERVICE_REQUEST sent");
        }
        this.f1608j = air.mo1031a(this.f1608j);
        boolean z = this.f1608j.mo647n() == 6;
        if (ahg.m1351f().mo908a(1)) {
            ahg.m1351f().mo907a(1, "SSH_MSG_SERVICE_ACCEPT received");
        }
        if (!z) {
            return false;
        }
        byte[] c = aji.m1820c(this.f1609k);
        this.f1607i.mo996a();
        this.f1608j.mo618a((byte) 50);
        this.f1608j.mo627b(c);
        this.f1608j.mo627b(aji.m1820c("ssh-connection"));
        this.f1608j.mo627b(aji.m1820c("none"));
        air.mo1061b(this.f1607i);
        while (true) {
            this.f1608j = air.mo1031a(this.f1608j);
            byte n = this.f1608j.mo647n() & 255;
            if (n == 52) {
                return true;
            }
            if (n == 53) {
                this.f1608j.mo633d();
                this.f1608j.mo640g();
                this.f1608j.mo640g();
                byte[] j = this.f1608j.mo643j();
                this.f1608j.mo643j();
                String b = aji.m1813b(j);
                if (this.f1606h != null) {
                    try {
                        this.f1606h.mo1174d(b);
                    } catch (RuntimeException unused) {
                    }
                }
            } else if (n == 51) {
                this.f1608j.mo633d();
                this.f1608j.mo640g();
                this.f1608j.mo640g();
                byte[] j2 = this.f1608j.mo643j();
                this.f1608j.mo640g();
                this.f1619m = aji.m1813b(j2);
                return false;
            } else {
                throw new ahj("USERAUTH fail (" + n + ")");
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String mo1168a() {
        return this.f1619m;
    }
}
