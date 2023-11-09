package atakplugin.UASTool;

import indago.serialization.JsonKeyConstants;
import java.util.zip.CRC32;
import java.util.zip.Deflater;

@aot(mo1534a = 1, mo1535b = {1, 1, 11}, mo1536c = {1, 0, 2}, mo1537d = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\r\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\b\u0010J\b\u0010\u0011\u001a\u00020\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0018\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0018\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u001b\u001a\u00020\u000fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\b\u001a\u00020\t8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, mo1538e = {"Lokio/GzipSink;", "Lokio/Sink;", "sink", "(Lokio/Sink;)V", "closed", "", "crc", "Ljava/util/zip/CRC32;", "deflater", "Ljava/util/zip/Deflater;", "()Ljava/util/zip/Deflater;", "deflaterSink", "Lokio/DeflaterSink;", "Lokio/RealBufferedSink;", "close", "", "-deprecated_deflater", "flush", "timeout", "Lokio/Timeout;", "updateCrc", "buffer", "Lokio/Buffer;", "byteCount", "", "write", "source", "writeFooter", "jvm"})
public final class bwv implements bxp {

    /* renamed from: a */
    private final bxi f4144a;

    /* renamed from: b */
    private final Deflater f4145b;

    /* renamed from: c */
    private final bwr f4146c;

    /* renamed from: d */
    private boolean f4147d;

    /* renamed from: e */
    private final CRC32 f4148e = new CRC32();

    public bwv(bxp bxp) {
        bfq.m6567f(bxp, "sink");
        bxi bxi = new bxi(bxp);
        this.f4144a = bxi;
        Deflater deflater = new Deflater(-1, true);
        this.f4145b = deflater;
        this.f4146c = new bwr((bwo) bxi, deflater);
        bwl bwl = bxi.f4188a;
        bwl.mo3842f(8075);
        bwl.mo3833d(8);
        bwl.mo3833d(0);
        bwl.mo3857j(0);
        bwl.mo3833d(0);
        bwl.mo3833d(0);
    }

    /* renamed from: a */
    public final Deflater mo3993a() {
        return this.f4145b;
    }

    public void write(bwl bwl, long j) {
        bfq.m6567f(bwl, JsonKeyConstants.SOURCE);
        int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (!(i >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + j).toString());
        } else if (i != 0) {
            m10282a(bwl, j);
            this.f4146c.write(bwl, j);
        }
    }

    public void flush() {
        this.f4146c.flush();
    }

    public bxs timeout() {
        return this.f4144a.timeout();
    }

    public void close() {
        if (!this.f4147d) {
            Throwable th = null;
            try {
                this.f4146c.mo3974a();
                m10283c();
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                this.f4145b.end();
            } catch (Throwable th3) {
                if (th == null) {
                    th = th3;
                }
            }
            try {
                this.f4144a.close();
            } catch (Throwable th4) {
                if (th == null) {
                    th = th4;
                }
            }
            this.f4147d = true;
            if (th != null) {
                throw th;
            }
        }
    }

    /* renamed from: c */
    private final void m10283c() {
        this.f4144a.mo3864l((int) this.f4148e.getValue());
        this.f4144a.mo3864l((int) this.f4145b.getBytesRead());
    }

    /* renamed from: a */
    private final void m10282a(bwl bwl, long j) {
        bxm bxm = bwl.f4122a;
        if (bxm == null) {
            bfq.m6538a();
        }
        while (j > 0) {
            int min = (int) Math.min(j, (long) (bxm.f4201c - bxm.f4200b));
            this.f4148e.update(bxm.f4199a, bxm.f4200b, min);
            j -= (long) min;
            bxm = bxm.f4204f;
            if (bxm == null) {
                bfq.m6538a();
            }
        }
    }

    @anx(mo1516a = "moved to val", mo1517b = @C0081api(mo1552a = "deflater", mo1553b = {}), mo1518c = any.ERROR)
    /* renamed from: b */
    public final Deflater mo3994b() {
        return this.f4145b;
    }
}
