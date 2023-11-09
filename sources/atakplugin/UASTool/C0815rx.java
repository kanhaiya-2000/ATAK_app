package atakplugin.UASTool;

/* renamed from: atakplugin.UASTool.rx */
abstract class C0815rx extends Thread {

    /* renamed from: a */
    boolean f6157a = true;

    /* renamed from: b */
    private volatile boolean f6158b = true;

    /* renamed from: c */
    private volatile Thread f6159c;

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public abstract void mo5680b();

    C0815rx() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5679a() {
        this.f6158b = false;
        if (this.f6159c != null) {
            this.f6159c.interrupt();
        }
    }

    public final void run() {
        if (this.f6158b) {
            this.f6159c = Thread.currentThread();
            while (this.f6158b && !this.f6159c.isInterrupted()) {
                mo5680b();
            }
        }
    }
}
