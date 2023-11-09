package atakplugin.UASTool;

abstract class aif {

    /* renamed from: a */
    private boolean f1413a = false;

    /* renamed from: b */
    private air f1414b = null;

    /* renamed from: c */
    private afy f1415c = null;

    aif() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo1014a(air air, afy afy) {
        this.f1414b = air;
        this.f1415c = afy;
        if (afy.f919z > 0) {
            mo1015a(true);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo1016a() {
        return this.f1413a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo1015a(boolean z) {
        this.f1413a = z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo1013a(ahy ahy) {
        if (this.f1413a) {
            this.f1415c.f918y = -1;
        }
        this.f1414b.mo1061b(ahy);
        if (this.f1413a) {
            long currentTimeMillis = System.currentTimeMillis();
            long j = (long) this.f1415c.f919z;
            while (this.f1415c.mo684n() && this.f1415c.f918y == -1) {
                try {
                    Thread.sleep(10);
                } catch (Exception unused) {
                }
                if (j > 0 && System.currentTimeMillis() - currentTimeMillis > j) {
                    this.f1415c.f918y = 0;
                    throw new ahj("channel request: timeout");
                }
            }
            if (this.f1415c.f918y == 0) {
                throw new ahj("failed to send channel request");
            }
        }
    }
}
