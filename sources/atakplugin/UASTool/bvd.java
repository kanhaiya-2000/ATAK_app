package atakplugin.UASTool;

import atakplugin.UASTool.brt;
import java.util.List;

public final class bvd implements brt.C0228a {

    /* renamed from: a */
    private final List<brt> f4023a;

    /* renamed from: b */
    private final btm f4024b;

    /* renamed from: c */
    private final bvc f4025c;

    /* renamed from: d */
    private final bqz f4026d;

    /* renamed from: e */
    private final int f4027e;

    /* renamed from: f */
    private final bsb f4028f;

    /* renamed from: g */
    private int f4029g;

    public bvd(List<brt> list, btm btm, bvc bvc, bqz bqz, int i, bsb bsb) {
        this.f4023a = list;
        this.f4026d = bqz;
        this.f4024b = btm;
        this.f4025c = bvc;
        this.f4027e = i;
        this.f4028f = bsb;
    }

    /* renamed from: b */
    public bqz mo3251b() {
        return this.f4026d;
    }

    /* renamed from: c */
    public btm mo3701c() {
        return this.f4024b;
    }

    /* renamed from: d */
    public bvc mo3702d() {
        return this.f4025c;
    }

    /* renamed from: a */
    public bsb mo3249a() {
        return this.f4028f;
    }

    /* renamed from: a */
    public bsh mo3250a(bsb bsb) {
        return mo3700a(bsb, this.f4024b, this.f4025c, this.f4026d);
    }

    /* renamed from: a */
    public bsh mo3700a(bsb bsb, btm btm, bvc bvc, bqz bqz) {
        if (this.f4027e < this.f4023a.size()) {
            this.f4029g++;
            if (this.f4025c != null && !m9798a(bsb.mo3343a())) {
                throw new IllegalStateException("network interceptor " + this.f4023a.get(this.f4027e - 1) + " must retain the same host and port");
            } else if (this.f4025c == null || this.f4029g <= 1) {
                bvd bvd = new bvd(this.f4023a, btm, bvc, bqz, this.f4027e + 1, bsb);
                brt brt = this.f4023a.get(this.f4027e);
                bsh a = brt.mo3248a(bvd);
                if (bvc != null && this.f4027e + 1 < this.f4023a.size() && bvd.f4029g != 1) {
                    throw new IllegalStateException("network interceptor " + brt + " must call proceed() exactly once");
                } else if (a != null) {
                    return a;
                } else {
                    throw new NullPointerException("interceptor " + brt + " returned null");
                }
            } else {
                throw new IllegalStateException("network interceptor " + this.f4023a.get(this.f4027e - 1) + " must call proceed() exactly once");
            }
        } else {
            throw new AssertionError();
        }
    }

    /* renamed from: a */
    private boolean m9798a(brr brr) {
        return brr.mo3204i().equals(this.f4026d.mo3080a().mo3416a().mo2984a().mo3204i()) && brr.mo3205j() == this.f4026d.mo3080a().mo3416a().mo2984a().mo3205j();
    }
}
