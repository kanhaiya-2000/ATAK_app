package atakplugin.UASTool;

import indago.serialization.JsonKeyConstants;
import java.io.EOFException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

@aot(mo1534a = 1, mo1535b = {1, 1, 11}, mo1536c = {1, 0, 2}, mo1537d = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0001H\u0016J\b\u0010\u0011\u001a\u00020\u0001H\u0016J\b\u0010\u0012\u001a\u00020\u000fH\u0016J\b\u0010\u0013\u001a\u00020\rH\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u001eH\u0016J \u0010\u001a\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020\u001bH\u0016J\u0018\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010 \u001a\u00020!H\u0016J\u0010\u0010\u001a\u001a\u00020\u00012\u0006\u0010\"\u001a\u00020#H\u0016J\u0018\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020$2\u0006\u0010 \u001a\u00020!H\u0016J\u0010\u0010%\u001a\u00020!2\u0006\u0010\u001c\u001a\u00020$H\u0016J\u0010\u0010&\u001a\u00020\u00012\u0006\u0010'\u001a\u00020\u001bH\u0016J\u0010\u0010(\u001a\u00020\u00012\u0006\u0010)\u001a\u00020!H\u0016J\u0010\u0010*\u001a\u00020\u00012\u0006\u0010)\u001a\u00020!H\u0016J\u0010\u0010+\u001a\u00020\u00012\u0006\u0010,\u001a\u00020\u001bH\u0016J\u0010\u0010-\u001a\u00020\u00012\u0006\u0010,\u001a\u00020\u001bH\u0016J\u0010\u0010.\u001a\u00020\u00012\u0006\u0010)\u001a\u00020!H\u0016J\u0010\u0010/\u001a\u00020\u00012\u0006\u0010)\u001a\u00020!H\u0016J\u0010\u00100\u001a\u00020\u00012\u0006\u00101\u001a\u00020\u001bH\u0016J\u0010\u00102\u001a\u00020\u00012\u0006\u00101\u001a\u00020\u001bH\u0016J\u0018\u00103\u001a\u00020\u00012\u0006\u00104\u001a\u00020\u00192\u0006\u00105\u001a\u000206H\u0016J(\u00103\u001a\u00020\u00012\u0006\u00104\u001a\u00020\u00192\u0006\u00107\u001a\u00020\u001b2\u0006\u00108\u001a\u00020\u001b2\u0006\u00105\u001a\u000206H\u0016J\u0010\u00109\u001a\u00020\u00012\u0006\u00104\u001a\u00020\u0019H\u0016J \u00109\u001a\u00020\u00012\u0006\u00104\u001a\u00020\u00192\u0006\u00107\u001a\u00020\u001b2\u0006\u00108\u001a\u00020\u001bH\u0016J\u0010\u0010:\u001a\u00020\u00012\u0006\u0010;\u001a\u00020\u001bH\u0016R\u001b\u0010\u0005\u001a\u00020\u00068Ö\u0002X\u0004¢\u0006\f\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\r8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006<"}, mo1538e = {"Lokio/RealBufferedSink;", "Lokio/BufferedSink;", "sink", "Lokio/Sink;", "(Lokio/Sink;)V", "buffer", "Lokio/Buffer;", "buffer$annotations", "()V", "getBuffer", "()Lokio/Buffer;", "bufferField", "closed", "", "close", "", "emit", "emitCompleteSegments", "flush", "isOpen", "outputStream", "Ljava/io/OutputStream;", "timeout", "Lokio/Timeout;", "toString", "", "write", "", "source", "Ljava/nio/ByteBuffer;", "", "offset", "byteCount", "", "byteString", "Lokio/ByteString;", "Lokio/Source;", "writeAll", "writeByte", "b", "writeDecimalLong", "v", "writeHexadecimalUnsignedLong", "writeInt", "i", "writeIntLe", "writeLong", "writeLongLe", "writeShort", "s", "writeShortLe", "writeString", "string", "charset", "Ljava/nio/charset/Charset;", "beginIndex", "endIndex", "writeUtf8", "writeUtf8CodePoint", "codePoint", "jvm"})
public final class bxi implements bwo {

    /* renamed from: a */
    public final bwl f4188a = new bwl();

    /* renamed from: b */
    public boolean f4189b;

    /* renamed from: c */
    public final bxp f4190c;

    /* renamed from: a */
    public static /* synthetic */ void m10371a() {
    }

    public bxi(bxp bxp) {
        bfq.m6567f(bxp, "sink");
        this.f4190c = bxp;
    }

    /* renamed from: c */
    public bwl mo3825c() {
        return this.f4188a;
    }

    /* renamed from: b */
    public bwl mo3811b() {
        return this.f4188a;
    }

    public void write(bwl bwl, long j) {
        bfq.m6567f(bwl, JsonKeyConstants.SOURCE);
        if (!this.f4189b) {
            this.f4188a.write(bwl, j);
            mo3841f();
            return;
        }
        throw new IllegalStateException("closed".toString());
    }

    /* renamed from: b */
    public bwo mo3816b(bwq bwq) {
        bfq.m6567f(bwq, "byteString");
        if (!this.f4189b) {
            this.f4188a.mo3816b(bwq);
            return mo3841f();
        }
        throw new IllegalStateException("closed".toString());
    }

    /* renamed from: b */
    public bwo mo3817b(String str) {
        bfq.m6567f(str, "string");
        if (!this.f4189b) {
            this.f4188a.mo3817b(str);
            return mo3841f();
        }
        throw new IllegalStateException("closed".toString());
    }

    /* renamed from: b */
    public bwo mo3818b(String str, int i, int i2) {
        bfq.m6567f(str, "string");
        if (!this.f4189b) {
            this.f4188a.mo3818b(str, i, i2);
            return mo3841f();
        }
        throw new IllegalStateException("closed".toString());
    }

    /* renamed from: b */
    public bwo mo3815b(int i) {
        if (!this.f4189b) {
            this.f4188a.mo3815b(i);
            return mo3841f();
        }
        throw new IllegalStateException("closed".toString());
    }

    /* renamed from: b */
    public bwo mo3820b(String str, Charset charset) {
        bfq.m6567f(str, "string");
        bfq.m6567f(charset, "charset");
        if (!this.f4189b) {
            this.f4188a.mo3820b(str, charset);
            return mo3841f();
        }
        throw new IllegalStateException("closed".toString());
    }

    /* renamed from: b */
    public bwo mo3819b(String str, int i, int i2, Charset charset) {
        bfq.m6567f(str, "string");
        bfq.m6567f(charset, "charset");
        if (!this.f4189b) {
            this.f4188a.mo3819b(str, i, i2, charset);
            return mo3841f();
        }
        throw new IllegalStateException("closed".toString());
    }

    /* renamed from: d */
    public bwo mo3834d(byte[] bArr) {
        bfq.m6567f(bArr, JsonKeyConstants.SOURCE);
        if (!this.f4189b) {
            this.f4188a.mo3834d(bArr);
            return mo3841f();
        }
        throw new IllegalStateException("closed".toString());
    }

    /* renamed from: c */
    public bwo mo3828c(byte[] bArr, int i, int i2) {
        bfq.m6567f(bArr, JsonKeyConstants.SOURCE);
        if (!this.f4189b) {
            this.f4188a.mo3828c(bArr, i, i2);
            return mo3841f();
        }
        throw new IllegalStateException("closed".toString());
    }

    public int write(ByteBuffer byteBuffer) {
        bfq.m6567f(byteBuffer, JsonKeyConstants.SOURCE);
        if (!this.f4189b) {
            int write = this.f4188a.write(byteBuffer);
            mo3841f();
            return write;
        }
        throw new IllegalStateException("closed".toString());
    }

    /* renamed from: d */
    public bwo mo3833d(int i) {
        if (!this.f4189b) {
            this.f4188a.mo3833d(i);
            return mo3841f();
        }
        throw new IllegalStateException("closed".toString());
    }

    /* renamed from: f */
    public bwo mo3842f(int i) {
        if (!this.f4189b) {
            this.f4188a.mo3842f(i);
            return mo3841f();
        }
        throw new IllegalStateException("closed".toString());
    }

    /* renamed from: h */
    public bwo mo3850h(int i) {
        if (!this.f4189b) {
            this.f4188a.mo3850h(i);
            return mo3841f();
        }
        throw new IllegalStateException("closed".toString());
    }

    /* renamed from: j */
    public bwo mo3857j(int i) {
        if (!this.f4189b) {
            this.f4188a.mo3857j(i);
            return mo3841f();
        }
        throw new IllegalStateException("closed".toString());
    }

    /* renamed from: l */
    public bwo mo3864l(int i) {
        if (!this.f4189b) {
            this.f4188a.mo3864l(i);
            return mo3841f();
        }
        throw new IllegalStateException("closed".toString());
    }

    /* renamed from: l */
    public bwo mo3865l(long j) {
        if (!this.f4189b) {
            this.f4188a.mo3865l(j);
            return mo3841f();
        }
        throw new IllegalStateException("closed".toString());
    }

    /* renamed from: n */
    public bwo mo3869n(long j) {
        if (!this.f4189b) {
            this.f4188a.mo3869n(j);
            return mo3841f();
        }
        throw new IllegalStateException("closed".toString());
    }

    /* renamed from: p */
    public bwo mo3875p(long j) {
        if (!this.f4189b) {
            this.f4188a.mo3875p(j);
            return mo3841f();
        }
        throw new IllegalStateException("closed".toString());
    }

    /* renamed from: r */
    public bwo mo3879r(long j) {
        if (!this.f4189b) {
            this.f4188a.mo3879r(j);
            return mo3841f();
        }
        throw new IllegalStateException("closed".toString());
    }

    /* renamed from: f */
    public bwo mo3841f() {
        if (!this.f4189b) {
            long l = this.f4188a.mo3863l();
            if (l > 0) {
                this.f4190c.write(this.f4188a, l);
            }
            return this;
        }
        throw new IllegalStateException("closed".toString());
    }

    /* renamed from: h */
    public bwo mo3849h() {
        if (!this.f4189b) {
            long a = this.f4188a.mo3783a();
            if (a > 0) {
                this.f4190c.write(this.f4188a, a);
            }
            return this;
        }
        throw new IllegalStateException("closed".toString());
    }

    /* renamed from: d */
    public OutputStream mo3835d() {
        return new bxj(this);
    }

    public void flush() {
        if (!this.f4189b) {
            if (this.f4188a.mo3783a() > 0) {
                bxp bxp = this.f4190c;
                bwl bwl = this.f4188a;
                bxp.write(bwl, bwl.mo3783a());
            }
            this.f4190c.flush();
            return;
        }
        throw new IllegalStateException("closed".toString());
    }

    public boolean isOpen() {
        return !this.f4189b;
    }

    public void close() {
        if (!this.f4189b) {
            Throwable th = null;
            try {
                if (this.f4188a.mo3783a() > 0) {
                    bxp bxp = this.f4190c;
                    bwl bwl = this.f4188a;
                    bxp.write(bwl, bwl.mo3783a());
                }
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                this.f4190c.close();
            } catch (Throwable th3) {
                if (th == null) {
                    th = th3;
                }
            }
            this.f4189b = true;
            if (th != null) {
                throw th;
            }
        }
    }

    public bxs timeout() {
        return this.f4190c.timeout();
    }

    public String toString() {
        return "buffer(" + this.f4190c + ')';
    }

    /* renamed from: a */
    public long mo3789a(bxr bxr) {
        bfq.m6567f(bxr, JsonKeyConstants.SOURCE);
        long j = 0;
        while (true) {
            long a = bxr.mo3425a(this.f4188a, (long) 8192);
            if (a == -1) {
                return j;
            }
            j += a;
            mo3841f();
        }
    }

    /* renamed from: a */
    public bwo mo3803a(bxr bxr, long j) {
        bfq.m6567f(bxr, JsonKeyConstants.SOURCE);
        while (j > 0) {
            long a = bxr.mo3425a(this.f4188a, j);
            if (a != -1) {
                j -= a;
                mo3841f();
            } else {
                throw new EOFException();
            }
        }
        return this;
    }
}
