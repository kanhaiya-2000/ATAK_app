package atakplugin.UASTool;

import java.io.Closeable;
import java.io.File;

final class bsg extends bsd {

    /* renamed from: a */
    final /* synthetic */ bru f3540a;

    /* renamed from: b */
    final /* synthetic */ File f3541b;

    bsg(bru bru, File file) {
        this.f3540a = bru;
        this.f3541b = file;
    }

    public bru contentType() {
        return this.f3540a;
    }

    public long contentLength() {
        return this.f3541b.length();
    }

    public void writeTo(bwo bwo) {
        bxr bxr = null;
        try {
            bxr = bxb.m10343c(this.f3541b);
            bwo.mo3789a(bxr);
        } finally {
            bsp.m9158a((Closeable) bxr);
        }
    }
}
