package atakplugin.UASTool;

import java.io.IOException;
import java.io.InputStream;

@aot(mo1534a = 1, mo1535b = {1, 1, 11}, mo1536c = {1, 0, 2}, mo1537d = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\nH\u0016J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, mo1538e = {"Lokio/InputStreamSource;", "Lokio/Source;", "input", "Ljava/io/InputStream;", "timeout", "Lokio/Timeout;", "(Ljava/io/InputStream;Lokio/Timeout;)V", "close", "", "read", "", "sink", "Lokio/Buffer;", "byteCount", "toString", "", "jvm"})
final class bxa implements bxr {

    /* renamed from: a */
    private final InputStream f4165a;

    /* renamed from: b */
    private final bxs f4166b;

    public bxa(InputStream inputStream, bxs bxs) {
        bfq.m6567f(inputStream, "input");
        bfq.m6567f(bxs, "timeout");
        this.f4165a = inputStream;
        this.f4166b = bxs;
    }

    /* renamed from: a */
    public long mo3425a(bwl bwl, long j) {
        bfq.m6567f(bwl, "sink");
        int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (i == 0) {
            return 0;
        }
        if (i >= 0) {
            try {
                this.f4166b.mo3992i_();
                bxm m = bwl.mo3868m(1);
                int read = this.f4165a.read(m.f4199a, m.f4201c, (int) Math.min(j, (long) (8192 - m.f4201c)));
                if (read == -1) {
                    return -1;
                }
                m.f4201c += read;
                long j2 = (long) read;
                bwl.mo3806a(bwl.mo3783a() + j2);
                return j2;
            } catch (AssertionError e) {
                if (bxb.m10339a(e)) {
                    throw new IOException(e);
                }
                throw e;
            }
        } else {
            throw new IllegalArgumentException(("byteCount < 0: " + j).toString());
        }
    }

    public void close() {
        this.f4165a.close();
    }

    public bxs timeout() {
        return this.f4166b;
    }

    public String toString() {
        return "source(" + this.f4165a + ')';
    }
}
