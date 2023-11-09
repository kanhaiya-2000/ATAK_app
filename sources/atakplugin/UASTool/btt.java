package atakplugin.UASTool;

import java.io.IOException;

class btt extends bso {

    /* renamed from: a */
    final /* synthetic */ boolean f3772a;

    /* renamed from: c */
    final /* synthetic */ int f3773c;

    /* renamed from: d */
    final /* synthetic */ int f3774d;

    /* renamed from: e */
    final /* synthetic */ bum f3775e;

    /* renamed from: f */
    final /* synthetic */ btq f3776f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    btt(btq btq, String str, Object[] objArr, boolean z, int i, int i2, bum bum) {
        super(str, objArr);
        this.f3776f = btq;
        this.f3772a = z;
        this.f3773c = i;
        this.f3774d = i2;
        this.f3775e = bum;
    }

    /* renamed from: d */
    public void mo3342d() {
        try {
            this.f3776f.m9381b(this.f3772a, this.f3773c, this.f3774d, this.f3775e);
        } catch (IOException unused) {
        }
    }
}
