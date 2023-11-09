package atakplugin.UASTool;

final class bsf extends bsd {

    /* renamed from: a */
    final /* synthetic */ bru f3536a;

    /* renamed from: b */
    final /* synthetic */ int f3537b;

    /* renamed from: c */
    final /* synthetic */ byte[] f3538c;

    /* renamed from: d */
    final /* synthetic */ int f3539d;

    bsf(bru bru, int i, byte[] bArr, int i2) {
        this.f3536a = bru;
        this.f3537b = i;
        this.f3538c = bArr;
        this.f3539d = i2;
    }

    public bru contentType() {
        return this.f3536a;
    }

    public long contentLength() {
        return (long) this.f3537b;
    }

    public void writeTo(bwo bwo) {
        bwo.mo3828c(this.f3538c, this.f3539d, this.f3537b);
    }
}
