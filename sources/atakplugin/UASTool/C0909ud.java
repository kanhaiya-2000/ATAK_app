package atakplugin.UASTool;

import java.nio.ByteBuffer;

/* renamed from: atakplugin.UASTool.ud */
class C0909ud {

    /* renamed from: a */
    private int f7083a;

    /* renamed from: b */
    private ByteBuffer f7084b;

    /* renamed from: c */
    private int f7085c;

    /* renamed from: d */
    private boolean f7086d;

    public C0909ud(int i) {
        this.f7084b = ByteBuffer.allocate(i);
        mo5914b(0);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5912a(int i) {
        this.f7083a = i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo5911a() {
        return this.f7083a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public ByteBuffer mo5913b() {
        return this.f7084b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public int mo5915c() {
        return this.f7085c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo5914b(int i) {
        this.f7085c = i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public synchronized void mo5917d() {
        this.f7084b.clear();
        mo5914b(0);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public synchronized boolean mo5919e() {
        return this.f7086d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public synchronized ByteBuffer mo5916c(int i) {
        ByteBuffer byteBuffer;
        byteBuffer = null;
        if (!this.f7086d) {
            this.f7086d = true;
            this.f7083a = i;
            byteBuffer = this.f7084b;
        }
        return byteBuffer;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public synchronized boolean mo5918d(int i) {
        boolean z;
        z = false;
        if (this.f7086d && i == this.f7083a) {
            this.f7086d = false;
            z = true;
        }
        return z;
    }
}
