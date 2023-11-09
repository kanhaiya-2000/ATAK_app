package atakplugin.UASTool;

import atakplugin.UASTool.bsy;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

class btb implements Iterator<bsy.C0239c> {

    /* renamed from: a */
    final Iterator<bsy.C0238b> f3663a;

    /* renamed from: b */
    bsy.C0239c f3664b;

    /* renamed from: c */
    bsy.C0239c f3665c;

    /* renamed from: d */
    final /* synthetic */ bsy f3666d;

    btb(bsy bsy) {
        this.f3666d = bsy;
        this.f3663a = new ArrayList(bsy.f3639w.values()).iterator();
    }

    public boolean hasNext() {
        if (this.f3664b != null) {
            return true;
        }
        synchronized (this.f3666d) {
            if (this.f3666d.f3623A) {
                return false;
            }
            while (this.f3663a.hasNext()) {
                bsy.C0239c a = this.f3663a.next().mo3448a();
                if (a != null) {
                    this.f3664b = a;
                    return true;
                }
            }
            return false;
        }
    }

    /* renamed from: a */
    public bsy.C0239c next() {
        if (hasNext()) {
            bsy.C0239c cVar = this.f3664b;
            this.f3665c = cVar;
            this.f3664b = null;
            return cVar;
        }
        throw new NoSuchElementException();
    }

    public void remove() {
        bsy.C0239c cVar = this.f3665c;
        if (cVar != null) {
            try {
                this.f3666d.mo3434c(cVar.f3656b);
            } catch (IOException unused) {
            } catch (Throwable th) {
                this.f3665c = null;
                throw th;
            }
            this.f3665c = null;
            return;
        }
        throw new IllegalStateException("remove() before next()");
    }
}
