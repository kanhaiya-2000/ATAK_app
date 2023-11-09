package atakplugin.UASTool;

import indago.serialization.JsonKeyConstants;
import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

@aot(mo1534a = 1, mo1535b = {1, 1, 11}, mo1536c = {1, 0, 2}, mo1537d = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0017\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0006\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0007J\b\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000fH\u0016J\u0006\u0010\u0013\u001a\u00020\u000bJ\b\u0010\u0014\u001a\u00020\rH\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, mo1538e = {"Lokio/InflaterSource;", "Lokio/Source;", "source", "inflater", "Ljava/util/zip/Inflater;", "(Lokio/Source;Ljava/util/zip/Inflater;)V", "Lokio/BufferedSource;", "(Lokio/BufferedSource;Ljava/util/zip/Inflater;)V", "bufferBytesHeldByInflater", "", "closed", "", "close", "", "read", "", "sink", "Lokio/Buffer;", "byteCount", "refill", "releaseInflatedBytes", "timeout", "Lokio/Timeout;", "jvm"})
public final class bwz implements bxr {

    /* renamed from: a */
    private int f4160a;

    /* renamed from: b */
    private boolean f4161b;

    /* renamed from: c */
    private final bwp f4162c;

    /* renamed from: d */
    private final Inflater f4163d;

    public bwz(bwp bwp, Inflater inflater) {
        bfq.m6567f(bwp, JsonKeyConstants.SOURCE);
        bfq.m6567f(inflater, "inflater");
        this.f4162c = bwp;
        this.f4163d = inflater;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public bwz(bxr bxr, Inflater inflater) {
        this(bxb.m10330a(bxr), inflater);
        bfq.m6567f(bxr, JsonKeyConstants.SOURCE);
        bfq.m6567f(inflater, "inflater");
    }

    /* renamed from: a */
    public long mo3425a(bwl bwl, long j) {
        bxm m;
        bfq.m6567f(bwl, "sink");
        int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (!(i >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + j).toString());
        } else if (!(!this.f4161b)) {
            throw new IllegalStateException("closed".toString());
        } else if (i == 0) {
            return 0;
        } else {
            while (true) {
                boolean a = mo4013a();
                try {
                    m = bwl.mo3868m(1);
                    int inflate = this.f4163d.inflate(m.f4199a, m.f4201c, (int) Math.min(j, (long) (8192 - m.f4201c)));
                    if (inflate > 0) {
                        m.f4201c += inflate;
                        long j2 = (long) inflate;
                        bwl.mo3806a(bwl.mo3783a() + j2);
                        return j2;
                    } else if (this.f4163d.finished()) {
                        break;
                    } else if (this.f4163d.needsDictionary()) {
                        break;
                    } else if (a) {
                        throw new EOFException("source exhausted prematurely");
                    }
                } catch (DataFormatException e) {
                    throw new IOException(e);
                }
            }
            m10324b();
            if (m.f4200b != m.f4201c) {
                return -1;
            }
            bwl.f4122a = m.mo4064c();
            bxn.m10450a(m);
            return -1;
        }
    }

    /* renamed from: a */
    public final boolean mo4013a() {
        if (!this.f4163d.needsInput()) {
            return false;
        }
        m10324b();
        if (!(this.f4163d.getRemaining() == 0)) {
            throw new IllegalStateException("?".toString());
        } else if (this.f4162c.mo3854i()) {
            return true;
        } else {
            bxm bxm = this.f4162c.mo3825c().f4122a;
            if (bxm == null) {
                bfq.m6538a();
            }
            this.f4160a = bxm.f4201c - bxm.f4200b;
            this.f4163d.setInput(bxm.f4199a, bxm.f4200b, this.f4160a);
            return false;
        }
    }

    /* renamed from: b */
    private final void m10324b() {
        int i = this.f4160a;
        if (i != 0) {
            int remaining = i - this.f4163d.getRemaining();
            this.f4160a -= remaining;
            this.f4162c.mo3859j((long) remaining);
        }
    }

    public bxs timeout() {
        return this.f4162c.timeout();
    }

    public void close() {
        if (!this.f4161b) {
            this.f4163d.end();
            this.f4161b = true;
            this.f4162c.close();
        }
    }
}
