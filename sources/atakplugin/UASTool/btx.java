package atakplugin.UASTool;

class btx extends bso {

    /* renamed from: a */
    final /* synthetic */ int f3789a;

    /* renamed from: c */
    final /* synthetic */ btn f3790c;

    /* renamed from: d */
    final /* synthetic */ btq f3791d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    btx(btq btq, String str, Object[] objArr, int i, btn btn) {
        super(str, objArr);
        this.f3791d = btq;
        this.f3789a = i;
        this.f3790c = btn;
    }

    /* renamed from: d */
    public void mo3342d() {
        this.f3791d.f3751u.mo3651a(this.f3789a, this.f3790c);
        synchronized (this.f3791d) {
            this.f3791d.f3754y.remove(Integer.valueOf(this.f3789a));
        }
    }
}
