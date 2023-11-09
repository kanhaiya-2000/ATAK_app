package atakplugin.UASTool;

final class bse extends bsd {

    /* renamed from: a */
    final /* synthetic */ bru f3534a;

    /* renamed from: b */
    final /* synthetic */ bwq f3535b;

    bse(bru bru, bwq bwq) {
        this.f3534a = bru;
        this.f3535b = bwq;
    }

    public bru contentType() {
        return this.f3534a;
    }

    public long contentLength() {
        return (long) this.f3535b.mo3951n();
    }

    public void writeTo(bwo bwo) {
        bwo.mo3816b(this.f3535b);
    }
}
