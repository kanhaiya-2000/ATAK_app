package atakplugin.UASTool;

import indago.serialization.JsonKeyConstants;
import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

@aot(mo1534a = 1, mo1535b = {1, 1, 11}, mo1536c = {1, 0, 2}, mo1537d = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003J \u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\b\u0010\u0014\u001a\u00020\u000eH\u0016J\b\u0010\u0015\u001a\u00020\u000eH\u0002J\b\u0010\u0016\u001a\u00020\u000eH\u0002J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0018H\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0016J \u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u0018H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, mo1538e = {"Lokio/GzipSource;", "Lokio/Source;", "source", "(Lokio/Source;)V", "crc", "Ljava/util/zip/CRC32;", "inflater", "Ljava/util/zip/Inflater;", "inflaterSource", "Lokio/InflaterSource;", "section", "", "Lokio/RealBufferedSource;", "checkEqual", "", "name", "", "expected", "", "actual", "close", "consumeHeader", "consumeTrailer", "read", "", "sink", "Lokio/Buffer;", "byteCount", "timeout", "Lokio/Timeout;", "updateCrc", "buffer", "offset", "jvm"})
public final class bww implements bxr {

    /* renamed from: a */
    private byte f4149a;

    /* renamed from: b */
    private final bxk f4150b;

    /* renamed from: c */
    private final Inflater f4151c;

    /* renamed from: d */
    private final bwz f4152d;

    /* renamed from: e */
    private final CRC32 f4153e = new CRC32();

    public bww(bxr bxr) {
        bfq.m6567f(bxr, JsonKeyConstants.SOURCE);
        bxk bxk = new bxk(bxr);
        this.f4150b = bxk;
        Inflater inflater = new Inflater(true);
        this.f4151c = inflater;
        this.f4152d = new bwz((bwp) bxk, inflater);
    }

    /* renamed from: a */
    public long mo3425a(bwl bwl, long j) {
        bfq.m6567f(bwl, "sink");
        int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (!(i >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + j).toString());
        } else if (i == 0) {
            return 0;
        } else {
            if (this.f4149a == 0) {
                m10286a();
                this.f4149a = 1;
            }
            if (this.f4149a == 1) {
                long a = bwl.mo3783a();
                long a2 = this.f4152d.mo3425a(bwl, j);
                if (a2 != -1) {
                    m10287a(bwl, a, a2);
                    return a2;
                }
                this.f4149a = 2;
            }
            if (this.f4149a == 2) {
                m10289b();
                this.f4149a = 3;
                if (!this.f4150b.mo3854i()) {
                    throw new IOException("gzip finished without exhausting source");
                }
            }
            return -1;
        }
    }

    /* renamed from: a */
    private final void m10286a() {
        this.f4150b.mo3821b(10);
        byte d = this.f4150b.f4192a.mo3831d(3);
        boolean z = true;
        boolean z2 = ((d >> 1) & 1) == 1;
        if (z2) {
            m10287a(this.f4150b.f4192a, 0, 10);
        }
        m10288a("ID1ID2", 8075, (int) this.f4150b.mo3871n());
        this.f4150b.mo3859j(8);
        if (((d >> 2) & 1) == 1) {
            this.f4150b.mo3821b(2);
            if (z2) {
                m10287a(this.f4150b.f4192a, 0, 2);
            }
            long q = (long) this.f4150b.f4192a.mo3877q();
            this.f4150b.mo3821b(q);
            if (z2) {
                m10287a(this.f4150b.f4192a, 0, q);
            }
            this.f4150b.mo3859j(q);
        }
        if (((d >> 3) & 1) == 1) {
            long a = this.f4150b.mo3784a((byte) 0);
            if (a != -1) {
                if (z2) {
                    m10287a(this.f4150b.f4192a, 0, a + 1);
                }
                this.f4150b.mo3859j(a + 1);
            } else {
                throw new EOFException();
            }
        }
        if (((d >> 4) & 1) != 1) {
            z = false;
        }
        if (z) {
            long a2 = this.f4150b.mo3784a((byte) 0);
            if (a2 != -1) {
                if (z2) {
                    m10287a(this.f4150b.f4192a, 0, a2 + 1);
                }
                this.f4150b.mo3859j(a2 + 1);
            } else {
                throw new EOFException();
            }
        }
        if (z2) {
            m10288a("FHCRC", (int) this.f4150b.mo3877q(), (int) (short) ((int) this.f4153e.getValue()));
            this.f4153e.reset();
        }
    }

    /* renamed from: b */
    private final void m10289b() {
        m10288a("CRC", this.f4150b.mo3878r(), (int) this.f4153e.getValue());
        m10288a("ISIZE", this.f4150b.mo3878r(), (int) this.f4151c.getBytesWritten());
    }

    public bxs timeout() {
        return this.f4150b.timeout();
    }

    public void close() {
        this.f4152d.close();
    }

    /* renamed from: a */
    private final void m10287a(bwl bwl, long j, long j2) {
        bxm bxm = bwl.f4122a;
        if (bxm == null) {
            bfq.m6538a();
        }
        while (j >= ((long) (bxm.f4201c - bxm.f4200b))) {
            j -= (long) (bxm.f4201c - bxm.f4200b);
            bxm = bxm.f4204f;
            if (bxm == null) {
                bfq.m6538a();
            }
        }
        while (j2 > 0) {
            int i = (int) (((long) bxm.f4200b) + j);
            int min = (int) Math.min((long) (bxm.f4201c - i), j2);
            this.f4153e.update(bxm.f4199a, i, min);
            j2 -= (long) min;
            bxm = bxm.f4204f;
            if (bxm == null) {
                bfq.m6538a();
            }
            j = 0;
        }
    }

    /* renamed from: a */
    private final void m10288a(String str, int i, int i2) {
        if (i2 != i) {
            String format = String.format("%s: actual 0x%08x != expected 0x%08x", Arrays.copyOf(new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i)}, 3));
            bfq.m6554b(format, "java.lang.String.format(this, *args)");
            throw new IOException(format);
        }
    }
}
