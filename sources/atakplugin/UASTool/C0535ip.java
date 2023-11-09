package atakplugin.UASTool;

/* renamed from: atakplugin.UASTool.ip */
final class C0535ip implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Runnable f5008a;

    /* renamed from: b */
    final /* synthetic */ Runnable f5009b;

    C0535ip(Runnable runnable, Runnable runnable2) {
        this.f5008a = runnable;
        this.f5009b = runnable2;
    }

    public void run() {
        try {
            this.f5008a.run();
            this.f5009b.run();
            return;
        } catch (Throwable unused) {
        }
        if (th instanceof RuntimeException) {
            throw th;
        }
        throw ((Error) th);
    }
}
