package atakplugin.UASTool;

import atakplugin.UASTool.bsy;
import java.io.IOException;

class btd extends bte {

    /* renamed from: a */
    final /* synthetic */ bsy.C0237a f3667a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    btd(bsy.C0237a aVar, bxp bxp) {
        super(bxp);
        this.f3667a = aVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo3458a(IOException iOException) {
        synchronized (bsy.this) {
            this.f3667a.mo3443a();
        }
    }
}
