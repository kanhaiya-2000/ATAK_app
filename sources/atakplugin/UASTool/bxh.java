package atakplugin.UASTool;

@aot(mo1534a = 1, mo1535b = {1, 1, 11}, mo1536c = {1, 0, 2}, mo1537d = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007H\u0016J\b\u0010\u0002\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, mo1538e = {"okio/Pipe$source$1", "Lokio/Source;", "timeout", "Lokio/Timeout;", "close", "", "read", "", "sink", "Lokio/Buffer;", "byteCount", "jvm"})
public final class bxh implements bxr {

    /* renamed from: a */
    final /* synthetic */ bxf f4186a;

    /* renamed from: b */
    private final bxs f4187b = new bxs();

    bxh(bxf bxf) {
        this.f4186a = bxf;
    }

    /* renamed from: a */
    public long mo3425a(bwl bwl, long j) {
        bfq.m6567f(bwl, "sink");
        synchronized (this.f4186a.mo4033a()) {
            if (!this.f4186a.mo4037c()) {
                while (this.f4186a.mo4033a().mo3783a() == 0) {
                    if (this.f4186a.mo4036b()) {
                        return -1;
                    }
                    this.f4187b.mo4068a((Object) this.f4186a.mo4033a());
                }
                long a = this.f4186a.mo4033a().mo3425a(bwl, j);
                bwl a2 = this.f4186a.mo4033a();
                if (a2 != null) {
                    a2.notifyAll();
                    return a;
                }
                throw new apx("null cannot be cast to non-null type java.lang.Object");
            }
            throw new IllegalStateException("closed".toString());
        }
    }

    public void close() {
        synchronized (this.f4186a.mo4033a()) {
            this.f4186a.mo4035b(true);
            bwl a = this.f4186a.mo4033a();
            if (a != null) {
                a.notifyAll();
                aqr aqr = aqr.f2177a;
            } else {
                throw new apx("null cannot be cast to non-null type java.lang.Object");
            }
        }
    }

    public bxs timeout() {
        return this.f4187b;
    }
}
