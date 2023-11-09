package atakplugin.UASTool;

import java.io.IOException;

class bta extends bte {

    /* renamed from: a */
    static final /* synthetic */ boolean f3661a = true;

    /* renamed from: b */
    final /* synthetic */ bsy f3662b;

    static {
        Class<bsy> cls = bsy.class;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    bta(bsy bsy, bxp bxp) {
        super(bxp);
        this.f3662b = bsy;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo3458a(IOException iOException) {
        if (f3661a || Thread.holdsLock(this.f3662b)) {
            boolean unused = this.f3662b.f3641y = true;
            return;
        }
        throw new AssertionError();
    }
}
