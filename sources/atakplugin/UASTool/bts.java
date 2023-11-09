package atakplugin.UASTool;

import java.io.IOException;

class bts extends bso {

    /* renamed from: a */
    final /* synthetic */ int f3769a;

    /* renamed from: c */
    final /* synthetic */ long f3770c;

    /* renamed from: d */
    final /* synthetic */ btq f3771d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    bts(btq btq, String str, Object[] objArr, int i, long j) {
        super(str, objArr);
        this.f3771d = btq;
        this.f3769a = i;
        this.f3770c = j;
    }

    /* renamed from: d */
    public void mo3342d() {
        try {
            this.f3771d.f3741i.mo3509a(this.f3769a, this.f3770c);
        } catch (IOException unused) {
        }
    }
}
