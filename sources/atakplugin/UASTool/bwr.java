package atakplugin.UASTool;

import indago.serialization.JsonKeyConstants;
import java.util.zip.Deflater;

@aot(mo1534a = 1, mo1535b = {1, 1, 11}, mo1536c = {1, 0, 2}, mo1537d = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\u0018\u00002\u00020\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0017\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0006\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0007J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\tH\u0003J\r\u0010\u000e\u001a\u00020\u000bH\u0000¢\u0006\u0002\b\u000fJ\b\u0010\u0010\u001a\u00020\u000bH\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, mo1538e = {"Lokio/DeflaterSink;", "Lokio/Sink;", "sink", "deflater", "Ljava/util/zip/Deflater;", "(Lokio/Sink;Ljava/util/zip/Deflater;)V", "Lokio/BufferedSink;", "(Lokio/BufferedSink;Ljava/util/zip/Deflater;)V", "closed", "", "close", "", "deflate", "syncFlush", "finishDeflate", "finishDeflate$jvm", "flush", "timeout", "Lokio/Timeout;", "toString", "", "write", "source", "Lokio/Buffer;", "byteCount", "", "jvm"})
public final class bwr implements bxp {

    /* renamed from: a */
    private boolean f4139a;

    /* renamed from: b */
    private final bwo f4140b;

    /* renamed from: c */
    private final Deflater f4141c;

    public bwr(bwo bwo, Deflater deflater) {
        bfq.m6567f(bwo, "sink");
        bfq.m6567f(deflater, "deflater");
        this.f4140b = bwo;
        this.f4141c = deflater;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public bwr(bxp bxp, Deflater deflater) {
        this(bxb.m10329a(bxp), deflater);
        bfq.m6567f(bxp, "sink");
        bfq.m6567f(deflater, "deflater");
    }

    public void write(bwl bwl, long j) {
        bfq.m6567f(bwl, JsonKeyConstants.SOURCE);
        bwg.m9952a(bwl.mo3783a(), 0, j);
        while (j > 0) {
            bxm bxm = bwl.f4122a;
            if (bxm == null) {
                bfq.m6538a();
            }
            int min = (int) Math.min(j, (long) (bxm.f4201c - bxm.f4200b));
            this.f4141c.setInput(bxm.f4199a, bxm.f4200b, min);
            m10266a(false);
            long j2 = (long) min;
            bwl.mo3806a(bwl.mo3783a() - j2);
            bxm.f4200b += min;
            if (bxm.f4200b == bxm.f4201c) {
                bwl.f4122a = bxm.mo4064c();
                bxn.m10450a(bxm);
            }
            j -= j2;
        }
    }

    /* renamed from: a */
    private final void m10266a(boolean z) {
        bxm m;
        int i;
        bwl c = this.f4140b.mo3825c();
        while (true) {
            m = c.mo3868m(1);
            if (z) {
                i = this.f4141c.deflate(m.f4199a, m.f4201c, 8192 - m.f4201c, 2);
            } else {
                i = this.f4141c.deflate(m.f4199a, m.f4201c, 8192 - m.f4201c);
            }
            if (i > 0) {
                m.f4201c += i;
                c.mo3806a(c.mo3783a() + ((long) i));
                this.f4140b.mo3841f();
            } else if (this.f4141c.needsInput()) {
                break;
            }
        }
        if (m.f4200b == m.f4201c) {
            c.f4122a = m.mo4064c();
            bxn.m10450a(m);
        }
    }

    public void flush() {
        m10266a(true);
        this.f4140b.flush();
    }

    /* renamed from: a */
    public final void mo3974a() {
        this.f4141c.finish();
        m10266a(false);
    }

    public void close() {
        if (!this.f4139a) {
            Throwable th = null;
            try {
                mo3974a();
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                this.f4141c.end();
            } catch (Throwable th3) {
                if (th == null) {
                    th = th3;
                }
            }
            try {
                this.f4140b.close();
            } catch (Throwable th4) {
                if (th == null) {
                    th = th4;
                }
            }
            this.f4139a = true;
            if (th != null) {
                throw th;
            }
        }
    }

    public bxs timeout() {
        return this.f4140b.timeout();
    }

    public String toString() {
        return "DeflaterSink(" + this.f4140b + ')';
    }
}
