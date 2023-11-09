package atakplugin.UASTool;

/* renamed from: atakplugin.UASTool.cl */
class C0323cl implements C0484gx {

    /* renamed from: a */
    final /* synthetic */ long f4671a;

    /* renamed from: b */
    final /* synthetic */ long f4672b;

    /* renamed from: c */
    final /* synthetic */ C0317cg f4673c;

    /* renamed from: d */
    private final long f4674d;

    /* renamed from: e */
    private final long f4675e;

    C0323cl(C0317cg cgVar, long j, long j2) {
        this.f4673c = cgVar;
        this.f4671a = j;
        this.f4672b = j2;
        long j3 = j - j2;
        this.f4674d = j3;
        this.f4675e = j3 - 1;
    }

    /* renamed from: a */
    public long mo4673a() {
        long j;
        long j2;
        long nextLong = this.f4673c.f4638a.nextLong();
        long j3 = this.f4674d;
        long j4 = this.f4675e;
        if ((j3 & j4) == 0) {
            j = nextLong & j4;
            j2 = this.f4672b;
        } else if (j3 > 0) {
            while (true) {
                long j5 = nextLong >>> 1;
                long j6 = this.f4675e + j5;
                j = j5 % this.f4674d;
                if (j6 - j >= 0) {
                    break;
                }
                nextLong = this.f4673c.f4638a.nextLong();
            }
            j2 = this.f4672b;
        } else {
            while (true) {
                if (this.f4672b < nextLong && nextLong < this.f4671a) {
                    return nextLong;
                }
                nextLong = this.f4673c.f4638a.nextLong();
            }
        }
        return j + j2;
    }
}
