package atakplugin.UASTool;

import java.io.IOException;

class btw extends bso {

    /* renamed from: a */
    final /* synthetic */ int f3784a;

    /* renamed from: c */
    final /* synthetic */ bwl f3785c;

    /* renamed from: d */
    final /* synthetic */ int f3786d;

    /* renamed from: e */
    final /* synthetic */ boolean f3787e;

    /* renamed from: f */
    final /* synthetic */ btq f3788f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    btw(btq btq, String str, Object[] objArr, int i, bwl bwl, int i2, boolean z) {
        super(str, objArr);
        this.f3788f = btq;
        this.f3784a = i;
        this.f3785c = bwl;
        this.f3786d = i2;
        this.f3787e = z;
    }

    /* renamed from: d */
    public void mo3342d() {
        try {
            boolean a = this.f3788f.f3751u.mo3652a(this.f3784a, this.f3785c, this.f3786d, this.f3787e);
            if (a) {
                this.f3788f.f3741i.mo3510a(this.f3784a, btn.CANCEL);
            }
            if (a || this.f3787e) {
                synchronized (this.f3788f) {
                    this.f3788f.f3754y.remove(Integer.valueOf(this.f3784a));
                }
            }
        } catch (IOException unused) {
        }
    }
}
