package atakplugin.UASTool;

import atakplugin.UASTool.bsy;
import java.io.IOException;
import java.util.Iterator;
import java.util.NoSuchElementException;

class bqo implements Iterator<String> {

    /* renamed from: a */
    final Iterator<bsy.C0239c> f3194a;

    /* renamed from: b */
    String f3195b;

    /* renamed from: c */
    boolean f3196c;

    /* renamed from: d */
    final /* synthetic */ bqm f3197d;

    bqo(bqm bqm) {
        this.f3197d = bqm;
        this.f3194a = bqm.f3166f.mo3441h();
    }

    public boolean hasNext() {
        if (this.f3195b != null) {
            return true;
        }
        this.f3196c = false;
        while (this.f3194a.hasNext()) {
            bsy.C0239c next = this.f3194a.next();
            try {
                this.f3195b = bxb.m10330a(next.mo3450a(0)).mo3890y();
                return true;
            } catch (IOException unused) {
            } finally {
                next.close();
            }
        }
        return false;
    }

    /* renamed from: a */
    public String next() {
        if (hasNext()) {
            String str = this.f3195b;
            this.f3195b = null;
            this.f3196c = true;
            return str;
        }
        throw new NoSuchElementException();
    }

    public void remove() {
        if (this.f3196c) {
            this.f3194a.remove();
            return;
        }
        throw new IllegalStateException("remove() before next()");
    }
}
