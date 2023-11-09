package atakplugin.UASTool;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

class bsu implements bxr {

    /* renamed from: a */
    boolean f3591a;

    /* renamed from: b */
    final /* synthetic */ bwp f3592b;

    /* renamed from: c */
    final /* synthetic */ bsv f3593c;

    /* renamed from: d */
    final /* synthetic */ bwo f3594d;

    /* renamed from: e */
    final /* synthetic */ bss f3595e;

    bsu(bss bss, bwp bwp, bsv bsv, bwo bwo) {
        this.f3595e = bss;
        this.f3592b = bwp;
        this.f3593c = bsv;
        this.f3594d = bwo;
    }

    /* renamed from: a */
    public long mo3425a(bwl bwl, long j) {
        try {
            long a = this.f3592b.mo3425a(bwl, j);
            if (a == -1) {
                if (!this.f3591a) {
                    this.f3591a = true;
                    this.f3594d.close();
                }
                return -1;
            }
            bwl.mo3792a(this.f3594d.mo3811b(), bwl.mo3783a() - a, a);
            this.f3594d.mo3841f();
            return a;
        } catch (IOException e) {
            if (!this.f3591a) {
                this.f3591a = true;
                this.f3593c.mo3014a();
            }
            throw e;
        }
    }

    public bxs timeout() {
        return this.f3592b.timeout();
    }

    public void close() {
        if (!this.f3591a && !bsp.m9162a((bxr) this, 100, TimeUnit.MILLISECONDS)) {
            this.f3591a = true;
            this.f3593c.mo3014a();
        }
        this.f3592b.close();
    }
}
