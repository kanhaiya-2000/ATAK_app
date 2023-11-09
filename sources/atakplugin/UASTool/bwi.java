package atakplugin.UASTool;

import indago.serialization.JsonKeyConstants;
import java.io.IOException;

@aot(mo1534a = 1, mo1535b = {1, 1, 11}, mo1536c = {1, 0, 2}, mo1537d = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016¨\u0006\u000e"}, mo1538e = {"okio/AsyncTimeout$sink$1", "Lokio/Sink;", "close", "", "flush", "timeout", "Lokio/AsyncTimeout;", "toString", "", "write", "source", "Lokio/Buffer;", "byteCount", "", "jvm"})
public final class bwi implements bxp {

    /* renamed from: a */
    final /* synthetic */ bwh f4116a;

    /* renamed from: b */
    final /* synthetic */ bxp f4117b;

    bwi(bwh bwh, bxp bxp) {
        this.f4116a = bwh;
        this.f4117b = bxp;
    }

    public void write(bwl bwl, long j) {
        bfq.m6567f(bwl, JsonKeyConstants.SOURCE);
        bwg.m9952a(bwl.mo3783a(), 0, j);
        while (true) {
            long j2 = 0;
            if (j > 0) {
                bxm bxm = bwl.f4122a;
                if (bxm == null) {
                    bfq.m6538a();
                }
                while (true) {
                    if (j2 >= ((long) 65536)) {
                        break;
                    }
                    j2 += (long) (bxm.f4201c - bxm.f4200b);
                    if (j2 >= j) {
                        j2 = j;
                        break;
                    }
                    bxm = bxm.f4204f;
                    if (bxm == null) {
                        bfq.m6538a();
                    }
                }
                this.f4116a.mo3760c_();
                try {
                    this.f4117b.write(bwl, j2);
                    j -= j2;
                    this.f4116a.mo3758a(true);
                } catch (IOException e) {
                    throw this.f4116a.mo3759b(e);
                } catch (Throwable th) {
                    this.f4116a.mo3758a(false);
                    throw th;
                }
            } else {
                return;
            }
        }
    }

    public void flush() {
        this.f4116a.mo3760c_();
        try {
            this.f4117b.flush();
            this.f4116a.mo3758a(true);
        } catch (IOException e) {
            throw this.f4116a.mo3759b(e);
        } catch (Throwable th) {
            this.f4116a.mo3758a(false);
            throw th;
        }
    }

    public void close() {
        this.f4116a.mo3760c_();
        try {
            this.f4117b.close();
            this.f4116a.mo3758a(true);
        } catch (IOException e) {
            throw this.f4116a.mo3759b(e);
        } catch (Throwable th) {
            this.f4116a.mo3758a(false);
            throw th;
        }
    }

    /* renamed from: a */
    public bwh timeout() {
        return this.f4116a;
    }

    public String toString() {
        return "AsyncTimeout.sink(" + this.f4117b + ')';
    }
}
