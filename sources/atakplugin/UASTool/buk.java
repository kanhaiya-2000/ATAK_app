package atakplugin.UASTool;

class buk extends bwt {

    /* renamed from: a */
    final /* synthetic */ buj f3917a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    buk(buj buj, bxr bxr) {
        super(bxr);
        this.f3917a = buj;
    }

    /* renamed from: a */
    public long mo3425a(bwl bwl, long j) {
        if (this.f3917a.f3915b == 0) {
            return -1;
        }
        long a = super.mo3425a(bwl, Math.min(j, (long) this.f3917a.f3915b));
        if (a == -1) {
            return -1;
        }
        buj buj = this.f3917a;
        int unused = buj.f3915b = (int) (((long) buj.f3915b) - a);
        return a;
    }
}
