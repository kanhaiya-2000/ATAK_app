package atakplugin.UASTool;

import java.io.Closeable;

/* renamed from: atakplugin.UASTool.iq */
final class C0536iq implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Closeable f5010a;

    /* renamed from: b */
    final /* synthetic */ Closeable f5011b;

    C0536iq(Closeable closeable, Closeable closeable2) {
        this.f5010a = closeable;
        this.f5011b = closeable2;
    }

    public void run() {
        try {
            this.f5010a.close();
            try {
                this.f5011b.close();
                return;
            } catch (Throwable th) {
                if (th instanceof RuntimeException) {
                    throw ((RuntimeException) th);
                } else if (th instanceof Error) {
                    throw th;
                } else {
                    throw new RuntimeException(th);
                }
            }
        } catch (Throwable unused) {
        }
        if (th instanceof RuntimeException) {
            throw th;
        }
        throw ((Error) th);
    }
}
