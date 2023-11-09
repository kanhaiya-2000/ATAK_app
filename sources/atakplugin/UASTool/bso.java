package atakplugin.UASTool;

public abstract class bso implements Runnable {

    /* renamed from: b */
    protected final String f3581b;

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public abstract void mo3342d();

    public bso(String str, Object... objArr) {
        this.f3581b = bsp.m9152a(str, objArr);
    }

    public final void run() {
        String name = Thread.currentThread().getName();
        Thread.currentThread().setName(this.f3581b);
        try {
            mo3342d();
        } finally {
            Thread.currentThread().setName(name);
        }
    }
}
