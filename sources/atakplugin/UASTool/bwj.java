package atakplugin.UASTool;

import java.io.IOException;

@aot(mo1534a = 1, mo1535b = {1, 1, 11}, mo1536c = {1, 0, 2}, mo1537d = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, mo1538e = {"okio/AsyncTimeout$source$1", "Lokio/Source;", "close", "", "read", "", "sink", "Lokio/Buffer;", "byteCount", "timeout", "Lokio/AsyncTimeout;", "toString", "", "jvm"})
public final class bwj implements bxr {

    /* renamed from: a */
    final /* synthetic */ bwh f4118a;

    /* renamed from: b */
    final /* synthetic */ bxr f4119b;

    bwj(bwh bwh, bxr bxr) {
        this.f4118a = bwh;
        this.f4119b = bxr;
    }

    /* renamed from: a */
    public long mo3425a(bwl bwl, long j) {
        bfq.m6567f(bwl, "sink");
        this.f4118a.mo3760c_();
        try {
            long a = this.f4119b.mo3425a(bwl, j);
            this.f4118a.mo3758a(true);
            return a;
        } catch (IOException e) {
            throw this.f4118a.mo3759b(e);
        } catch (Throwable th) {
            this.f4118a.mo3758a(false);
            throw th;
        }
    }

    public void close() {
        try {
            this.f4119b.close();
            this.f4118a.mo3758a(true);
        } catch (IOException e) {
            throw this.f4118a.mo3759b(e);
        } catch (Throwable th) {
            this.f4118a.mo3758a(false);
            throw th;
        }
    }

    /* renamed from: a */
    public bwh timeout() {
        return this.f4118a;
    }

    public String toString() {
        return "AsyncTimeout.source(" + this.f4119b + ')';
    }
}
