package atakplugin.UASTool;

import indago.serialization.JsonKeyConstants;
import java.io.IOException;

@aot(mo1534a = 1, mo1535b = {1, 1, 11}, mo1536c = {1, 0, 2}, mo1537d = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, mo1538e = {"okio/Pipe$sink$1", "Lokio/Sink;", "timeout", "Lokio/Timeout;", "close", "", "flush", "write", "source", "Lokio/Buffer;", "byteCount", "", "jvm"})
public final class bxg implements bxp {

    /* renamed from: a */
    final /* synthetic */ bxf f4184a;

    /* renamed from: b */
    private final bxs f4185b = new bxs();

    bxg(bxf bxf) {
        this.f4184a = bxf;
    }

    public void write(bwl bwl, long j) {
        bfq.m6567f(bwl, JsonKeyConstants.SOURCE);
        synchronized (this.f4184a.mo4033a()) {
            if (!this.f4184a.mo4036b()) {
                while (j > 0) {
                    if (!this.f4184a.mo4037c()) {
                        long h = this.f4184a.mo4042h() - this.f4184a.mo4033a().mo3783a();
                        if (h == 0) {
                            this.f4185b.mo4068a((Object) this.f4184a.mo4033a());
                        } else {
                            long min = Math.min(h, j);
                            this.f4184a.mo4033a().write(bwl, min);
                            j -= min;
                            bwl a = this.f4184a.mo4033a();
                            if (a != null) {
                                a.notifyAll();
                            } else {
                                throw new apx("null cannot be cast to non-null type java.lang.Object");
                            }
                        }
                    } else {
                        throw new IOException("source is closed");
                    }
                }
                aqr aqr = aqr.f2177a;
            } else {
                throw new IllegalStateException("closed".toString());
            }
        }
    }

    public void flush() {
        synchronized (this.f4184a.mo4033a()) {
            if (!this.f4184a.mo4036b()) {
                if (this.f4184a.mo4037c()) {
                    if (this.f4184a.mo4033a().mo3783a() > 0) {
                        throw new IOException("source is closed");
                    }
                }
                aqr aqr = aqr.f2177a;
            } else {
                throw new IllegalStateException("closed".toString());
            }
        }
    }

    public void close() {
        synchronized (this.f4184a.mo4033a()) {
            if (!this.f4184a.mo4036b()) {
                if (this.f4184a.mo4037c()) {
                    if (this.f4184a.mo4033a().mo3783a() > 0) {
                        throw new IOException("source is closed");
                    }
                }
                this.f4184a.mo4034a(true);
                bwl a = this.f4184a.mo4033a();
                if (a != null) {
                    a.notifyAll();
                    aqr aqr = aqr.f2177a;
                    return;
                }
                throw new apx("null cannot be cast to non-null type java.lang.Object");
            }
        }
    }

    public bxs timeout() {
        return this.f4185b;
    }
}
