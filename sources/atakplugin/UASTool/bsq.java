package atakplugin.UASTool;

import java.util.concurrent.ThreadFactory;

final class bsq implements ThreadFactory {

    /* renamed from: a */
    final /* synthetic */ String f3587a;

    /* renamed from: b */
    final /* synthetic */ boolean f3588b;

    bsq(String str, boolean z) {
        this.f3587a = str;
        this.f3588b = z;
    }

    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, this.f3587a);
        thread.setDaemon(this.f3588b);
        return thread;
    }
}
