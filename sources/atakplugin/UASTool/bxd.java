package atakplugin.UASTool;

import indago.serialization.JsonKeyConstants;
import java.io.OutputStream;

@aot(mo1534a = 1, mo1535b = {1, 1, 11}, mo1536c = {1, 0, 2}, mo1537d = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, mo1538e = {"Lokio/OutputStreamSink;", "Lokio/Sink;", "out", "Ljava/io/OutputStream;", "timeout", "Lokio/Timeout;", "(Ljava/io/OutputStream;Lokio/Timeout;)V", "close", "", "flush", "toString", "", "write", "source", "Lokio/Buffer;", "byteCount", "", "jvm"})
final class bxd implements bxp {

    /* renamed from: a */
    private final OutputStream f4170a;

    /* renamed from: b */
    private final bxs f4171b;

    public bxd(OutputStream outputStream, bxs bxs) {
        bfq.m6567f(outputStream, "out");
        bfq.m6567f(bxs, "timeout");
        this.f4170a = outputStream;
        this.f4171b = bxs;
    }

    public void write(bwl bwl, long j) {
        bfq.m6567f(bwl, JsonKeyConstants.SOURCE);
        bwg.m9952a(bwl.mo3783a(), 0, j);
        while (j > 0) {
            this.f4171b.mo3992i_();
            bxm bxm = bwl.f4122a;
            if (bxm == null) {
                bfq.m6538a();
            }
            int min = (int) Math.min(j, (long) (bxm.f4201c - bxm.f4200b));
            this.f4170a.write(bxm.f4199a, bxm.f4200b, min);
            bxm.f4200b += min;
            long j2 = (long) min;
            j -= j2;
            bwl.mo3806a(bwl.mo3783a() - j2);
            if (bxm.f4200b == bxm.f4201c) {
                bwl.f4122a = bxm.mo4064c();
                bxn.m10450a(bxm);
            }
        }
    }

    public void flush() {
        this.f4170a.flush();
    }

    public void close() {
        this.f4170a.close();
    }

    public bxs timeout() {
        return this.f4171b;
    }

    public String toString() {
        return "sink(" + this.f4170a + ')';
    }
}
