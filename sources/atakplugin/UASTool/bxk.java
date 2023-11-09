package atakplugin.UASTool;

import indago.serialization.JsonKeyConstants;
import java.io.EOFException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;

@aot(mo1534a = 1, mo1535b = {1, 1, 11}, mo1536c = {1, 0, 2}, mo1537d = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\rH\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0012H\u0016J \u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0012H\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u0012H\u0016J\u0010\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u0018H\u0016J\u0018\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u0012H\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\rH\u0016J\b\u0010\u001e\u001a\u00020\u0001H\u0016J\u0018\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J(\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"H\u0016J\u0010\u0010$\u001a\u00020\"2\u0006\u0010%\u001a\u00020&H\u0016J\u0010\u0010$\u001a\u00020\"2\u0006\u0010%\u001a\u00020'H\u0016J \u0010$\u001a\u00020\"2\u0006\u0010%\u001a\u00020'2\u0006\u0010 \u001a\u00020\"2\u0006\u0010#\u001a\u00020\"H\u0016J\u0018\u0010$\u001a\u00020\u00122\u0006\u0010%\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u0012H\u0016J\u0010\u0010(\u001a\u00020\u00122\u0006\u0010%\u001a\u00020)H\u0016J\b\u0010*\u001a\u00020\u0014H\u0016J\b\u0010+\u001a\u00020'H\u0016J\u0010\u0010+\u001a\u00020'2\u0006\u0010#\u001a\u00020\u0012H\u0016J\b\u0010,\u001a\u00020\u0018H\u0016J\u0010\u0010,\u001a\u00020\u00182\u0006\u0010#\u001a\u00020\u0012H\u0016J\b\u0010-\u001a\u00020\u0012H\u0016J\u0010\u0010.\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020'H\u0016J\u0018\u0010.\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u0012H\u0016J\b\u0010/\u001a\u00020\u0012H\u0016J\b\u00100\u001a\u00020\"H\u0016J\b\u00101\u001a\u00020\"H\u0016J\b\u00102\u001a\u00020\u0012H\u0016J\b\u00103\u001a\u00020\u0012H\u0016J\b\u00104\u001a\u000205H\u0016J\b\u00106\u001a\u000205H\u0016J\u0010\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:H\u0016J\u0018\u00107\u001a\u0002082\u0006\u0010#\u001a\u00020\u00122\u0006\u00109\u001a\u00020:H\u0016J\b\u0010;\u001a\u000208H\u0016J\u0010\u0010;\u001a\u0002082\u0006\u0010#\u001a\u00020\u0012H\u0016J\b\u0010<\u001a\u00020\"H\u0016J\n\u0010=\u001a\u0004\u0018\u000108H\u0016J\b\u0010>\u001a\u000208H\u0016J\u0010\u0010>\u001a\u0002082\u0006\u0010?\u001a\u00020\u0012H\u0016J\u0010\u0010@\u001a\u00020\r2\u0006\u0010#\u001a\u00020\u0012H\u0016J\u0010\u0010A\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020\u0012H\u0016J\u0010\u0010B\u001a\u00020\"2\u0006\u0010C\u001a\u00020DH\u0016J\u0010\u0010E\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020\u0012H\u0016J\b\u0010F\u001a\u00020GH\u0016J\b\u0010H\u001a\u000208H\u0016R\u001b\u0010\u0005\u001a\u00020\u00068Ö\u0002X\u0004¢\u0006\f\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\r8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006I"}, mo1538e = {"Lokio/RealBufferedSource;", "Lokio/BufferedSource;", "source", "Lokio/Source;", "(Lokio/Source;)V", "buffer", "Lokio/Buffer;", "buffer$annotations", "()V", "getBuffer", "()Lokio/Buffer;", "bufferField", "closed", "", "close", "", "exhausted", "indexOf", "", "b", "", "fromIndex", "toIndex", "bytes", "Lokio/ByteString;", "indexOfElement", "targetBytes", "inputStream", "Ljava/io/InputStream;", "isOpen", "peek", "rangeEquals", "offset", "bytesOffset", "", "byteCount", "read", "sink", "Ljava/nio/ByteBuffer;", "", "readAll", "Lokio/Sink;", "readByte", "readByteArray", "readByteString", "readDecimalLong", "readFully", "readHexadecimalUnsignedLong", "readInt", "readIntLe", "readLong", "readLongLe", "readShort", "", "readShortLe", "readString", "", "charset", "Ljava/nio/charset/Charset;", "readUtf8", "readUtf8CodePoint", "readUtf8Line", "readUtf8LineStrict", "limit", "request", "require", "select", "options", "Lokio/Options;", "skip", "timeout", "Lokio/Timeout;", "toString", "jvm"})
public final class bxk implements bwp {

    /* renamed from: a */
    public final bwl f4192a = new bwl();

    /* renamed from: b */
    public boolean f4193b;

    /* renamed from: c */
    public final bxr f4194c;

    /* renamed from: a */
    public static /* synthetic */ void m10396a() {
    }

    public bxk(bxr bxr) {
        bfq.m6567f(bxr, JsonKeyConstants.SOURCE);
        this.f4194c = bxr;
    }

    /* renamed from: c */
    public bwl mo3825c() {
        return this.f4192a;
    }

    /* renamed from: b */
    public bwl mo3811b() {
        return this.f4192a;
    }

    /* renamed from: a */
    public long mo3425a(bwl bwl, long j) {
        bfq.m6567f(bwl, "sink");
        if (!(j >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + j).toString());
        } else if (!(true ^ this.f4193b)) {
            throw new IllegalStateException("closed".toString());
        } else if (this.f4192a.mo3783a() == 0 && this.f4194c.mo3425a(this.f4192a, (long) 8192) == -1) {
            return -1;
        } else {
            return this.f4192a.mo3425a(bwl, Math.min(j, this.f4192a.mo3783a()));
        }
    }

    /* renamed from: i */
    public boolean mo3854i() {
        if (!(!this.f4193b)) {
            throw new IllegalStateException("closed".toString());
        } else if (!this.f4192a.mo3854i() || this.f4194c.mo3425a(this.f4192a, (long) 8192) != -1) {
            return false;
        } else {
            return true;
        }
    }

    /* renamed from: b */
    public void mo3821b(long j) {
        if (!mo3829c(j)) {
            throw new EOFException();
        }
    }

    /* renamed from: c */
    public boolean mo3829c(long j) {
        if (!(j >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + j).toString());
        } else if (!this.f4193b) {
            while (this.f4192a.mo3783a() < j) {
                if (this.f4194c.mo3425a(this.f4192a, (long) 8192) == -1) {
                    return false;
                }
            }
            return true;
        } else {
            throw new IllegalStateException("closed".toString());
        }
    }

    /* renamed from: m */
    public byte mo3866m() {
        mo3821b(1);
        return this.f4192a.mo3866m();
    }

    /* renamed from: e */
    public bwq mo3838e(long j) {
        mo3821b(j);
        return this.f4192a.mo3838e(j);
    }

    /* renamed from: a */
    public int mo3779a(bxc bxc) {
        bfq.m6567f(bxc, "options");
        if (!this.f4193b) {
            do {
                int a = this.f4192a.mo3780a(bxc, true);
                if (a != -2) {
                    if (a == -1) {
                        return -1;
                    }
                    this.f4192a.mo3859j((long) bxc.mo4020b()[a].mo3951n());
                    return a;
                }
            } while (this.f4194c.mo3425a(this.f4192a, (long) 8192) != -1);
            return -1;
        }
        throw new IllegalStateException("closed".toString());
    }

    /* renamed from: i */
    public byte[] mo3855i(long j) {
        mo3821b(j);
        return this.f4192a.mo3855i(j);
    }

    /* renamed from: a */
    public int mo3781a(byte[] bArr) {
        bfq.m6567f(bArr, "sink");
        return mo3782a(bArr, 0, bArr.length);
    }

    /* renamed from: b */
    public void mo3823b(byte[] bArr) {
        bfq.m6567f(bArr, "sink");
        try {
            mo3821b((long) bArr.length);
            this.f4192a.mo3823b(bArr);
        } catch (EOFException e) {
            int i = 0;
            while (this.f4192a.mo3783a() > 0) {
                bwl bwl = this.f4192a;
                int a = bwl.mo3782a(bArr, i, (int) bwl.mo3783a());
                if (a != -1) {
                    i += a;
                } else {
                    throw new AssertionError();
                }
            }
            throw e;
        }
    }

    /* renamed from: a */
    public int mo3782a(byte[] bArr, int i, int i2) {
        bfq.m6567f(bArr, "sink");
        long j = (long) i2;
        bwg.m9952a((long) bArr.length, (long) i, j);
        if (this.f4192a.mo3783a() == 0 && this.f4194c.mo3425a(this.f4192a, (long) 8192) == -1) {
            return -1;
        }
        return this.f4192a.mo3782a(bArr, i, (int) Math.min(j, this.f4192a.mo3783a()));
    }

    /* renamed from: b */
    public void mo3822b(bwl bwl, long j) {
        bfq.m6567f(bwl, "sink");
        try {
            mo3821b(j);
            this.f4192a.mo3822b(bwl, j);
        } catch (EOFException e) {
            bwl.mo3789a((bxr) this.f4192a);
            throw e;
        }
    }

    /* renamed from: a */
    public long mo3788a(bxp bxp) {
        bfq.m6567f(bxp, "sink");
        long j = 0;
        while (this.f4194c.mo3425a(this.f4192a, (long) 8192) != -1) {
            long l = this.f4192a.mo3863l();
            if (l > 0) {
                j += l;
                bxp.write(this.f4192a, l);
            }
        }
        if (this.f4192a.mo3783a() <= 0) {
            return j;
        }
        long a = j + this.f4192a.mo3783a();
        bwl bwl = this.f4192a;
        bxp.write(bwl, bwl.mo3783a());
        return a;
    }

    /* renamed from: f */
    public String mo3844f(long j) {
        mo3821b(j);
        return this.f4192a.mo3844f(j);
    }

    /* renamed from: a */
    public String mo3804a(long j, Charset charset) {
        bfq.m6567f(charset, "charset");
        mo3821b(j);
        return this.f4192a.mo3804a(j, charset);
    }

    /* renamed from: x */
    public String mo3889x() {
        long a = mo3784a((byte) 10);
        if (a != -1) {
            return this.f4192a.mo3851h(a);
        }
        if (this.f4192a.mo3783a() != 0) {
            return mo3844f(this.f4192a.mo3783a());
        }
        return null;
    }

    /* renamed from: y */
    public String mo3890y() {
        return mo3848g(bfu.f2629b);
    }

    /* renamed from: g */
    public String mo3848g(long j) {
        if (j >= 0) {
            long j2 = j == bfu.f2629b ? Long.MAX_VALUE : j + 1;
            byte b = (byte) 10;
            long a = mo3786a(b, 0, j2);
            if (a != -1) {
                return this.f4192a.mo3851h(a);
            }
            if (j2 < bfu.f2629b && mo3829c(j2) && this.f4192a.mo3831d(j2 - 1) == ((byte) 13) && mo3829c(1 + j2) && this.f4192a.mo3831d(j2) == b) {
                return this.f4192a.mo3851h(j2);
            }
            bwl bwl = new bwl();
            bwl bwl2 = this.f4192a;
            bwl2.mo3792a(bwl, 0, Math.min((long) 32, bwl2.mo3783a()));
            throw new EOFException("\\n not found: limit=" + Math.min(this.f4192a.mo3783a(), j) + " content=" + bwl.mo3886v().mo3947j() + "…");
        }
        throw new IllegalArgumentException(("limit < 0: " + j).toString());
    }

    /* renamed from: z */
    public int mo3891z() {
        mo3821b(1);
        byte d = this.f4192a.mo3831d(0);
        if ((d & 224) == 192) {
            mo3821b(2);
        } else if ((d & 240) == 224) {
            mo3821b(3);
        } else if ((d & 248) == 240) {
            mo3821b(4);
        }
        return this.f4192a.mo3891z();
    }

    /* renamed from: n */
    public short mo3871n() {
        mo3821b(2);
        return this.f4192a.mo3871n();
    }

    /* renamed from: q */
    public short mo3877q() {
        mo3821b(2);
        return this.f4192a.mo3877q();
    }

    /* renamed from: o */
    public int mo3872o() {
        mo3821b(4);
        return this.f4192a.mo3872o();
    }

    /* renamed from: r */
    public int mo3878r() {
        mo3821b(4);
        return this.f4192a.mo3878r();
    }

    /* renamed from: p */
    public long mo3874p() {
        mo3821b(8);
        return this.f4192a.mo3874p();
    }

    /* renamed from: s */
    public long mo3882s() {
        mo3821b(8);
        return this.f4192a.mo3882s();
    }

    /* renamed from: t */
    public long mo3883t() {
        int i;
        mo3821b(1);
        long j = 0;
        while (true) {
            long j2 = j + 1;
            if (!mo3829c(j2)) {
                break;
            }
            byte d = this.f4192a.mo3831d(j);
            if ((d >= ((byte) 48) && d <= ((byte) 57)) || (j == 0 && d == ((byte) 45))) {
                j = j2;
            } else if (i == 0) {
                bgu bgu = bgu.f2681a;
                String format = String.format("Expected leading [0-9] or '-' character but was %#x", Arrays.copyOf(new Object[]{Byte.valueOf(d)}, 1));
                bfq.m6554b(format, "java.lang.String.format(format, *args)");
                throw new NumberFormatException(format);
            }
        }
        return this.f4192a.mo3883t();
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x003b  */
    /* renamed from: u */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long mo3885u() {
        /*
            r6 = this;
            r0 = 1
            r6.mo3821b((long) r0)
            r0 = 0
            r1 = 0
        L_0x0007:
            int r2 = r1 + 1
            long r3 = (long) r2
            boolean r3 = r6.mo3829c((long) r3)
            if (r3 == 0) goto L_0x005d
            atakplugin.UASTool.bwl r3 = r6.f4192a
            long r4 = (long) r1
            byte r3 = r3.mo3831d((long) r4)
            r4 = 48
            byte r4 = (byte) r4
            if (r3 < r4) goto L_0x0021
            r4 = 57
            byte r4 = (byte) r4
            if (r3 <= r4) goto L_0x0036
        L_0x0021:
            r4 = 97
            byte r4 = (byte) r4
            if (r3 < r4) goto L_0x002b
            r4 = 102(0x66, float:1.43E-43)
            byte r4 = (byte) r4
            if (r3 <= r4) goto L_0x0036
        L_0x002b:
            r4 = 65
            byte r4 = (byte) r4
            if (r3 < r4) goto L_0x0038
            r4 = 70
            byte r4 = (byte) r4
            if (r3 <= r4) goto L_0x0036
            goto L_0x0038
        L_0x0036:
            r1 = r2
            goto L_0x0007
        L_0x0038:
            if (r1 == 0) goto L_0x003b
            goto L_0x005d
        L_0x003b:
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            atakplugin.UASTool.bgu r2 = atakplugin.UASTool.bgu.f2681a
            r2 = 1
            java.lang.Object[] r4 = new java.lang.Object[r2]
            java.lang.Byte r3 = java.lang.Byte.valueOf(r3)
            r4[r0] = r3
            java.lang.Object[] r0 = java.util.Arrays.copyOf(r4, r2)
            java.lang.String r2 = "Expected leading [0-9a-fA-F] character but was %#x"
            java.lang.String r0 = java.lang.String.format(r2, r0)
            java.lang.String r2 = "java.lang.String.format(format, *args)"
            atakplugin.UASTool.bfq.m6554b(r0, r2)
            r1.<init>(r0)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x005d:
            atakplugin.UASTool.bwl r0 = r6.f4192a
            long r0 = r0.mo3885u()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.bxk.mo3885u():long");
    }

    /* renamed from: j */
    public void mo3859j(long j) {
        if (!this.f4193b) {
            while (j > 0) {
                if (this.f4192a.mo3783a() == 0 && this.f4194c.mo3425a(this.f4192a, (long) 8192) == -1) {
                    throw new EOFException();
                }
                long min = Math.min(j, this.f4192a.mo3783a());
                this.f4192a.mo3859j(min);
                j -= min;
            }
            return;
        }
        throw new IllegalStateException("closed".toString());
    }

    /* renamed from: a */
    public long mo3784a(byte b) {
        return mo3786a(b, 0, (long) bfu.f2629b);
    }

    /* renamed from: a */
    public long mo3785a(byte b, long j) {
        return mo3786a(b, j, (long) bfu.f2629b);
    }

    /* renamed from: a */
    public long mo3786a(byte b, long j, long j2) {
        boolean z = true;
        if (!this.f4193b) {
            if (0 > j || j2 < j) {
                z = false;
            }
            if (z) {
                while (j < j2) {
                    long a = this.f4192a.mo3786a(b, j, j2);
                    if (a == -1) {
                        long a2 = this.f4192a.mo3783a();
                        if (a2 >= j2 || this.f4194c.mo3425a(this.f4192a, (long) 8192) == -1) {
                            break;
                        }
                        j = Math.max(j, a2);
                    } else {
                        return a;
                    }
                }
                return -1;
            }
            throw new IllegalArgumentException(("fromIndex=" + j + " toIndex=" + j2).toString());
        }
        throw new IllegalStateException("closed".toString());
    }

    /* renamed from: c */
    public long mo3824c(bwq bwq) {
        bfq.m6567f(bwq, "bytes");
        return mo3787a(bwq, 0);
    }

    /* renamed from: a */
    public long mo3787a(bwq bwq, long j) {
        bfq.m6567f(bwq, "bytes");
        if (!this.f4193b) {
            while (true) {
                long a = this.f4192a.mo3787a(bwq, j);
                if (a != -1) {
                    return a;
                }
                long a2 = this.f4192a.mo3783a();
                if (this.f4194c.mo3425a(this.f4192a, (long) 8192) == -1) {
                    return -1;
                }
                j = Math.max(j, (a2 - ((long) bwq.mo3951n())) + 1);
            }
        } else {
            throw new IllegalStateException("closed".toString());
        }
    }

    /* renamed from: d */
    public long mo3832d(bwq bwq) {
        bfq.m6567f(bwq, "targetBytes");
        return mo3809b(bwq, 0);
    }

    /* renamed from: b */
    public long mo3809b(bwq bwq, long j) {
        bfq.m6567f(bwq, "targetBytes");
        if (!this.f4193b) {
            while (true) {
                long b = this.f4192a.mo3809b(bwq, j);
                if (b != -1) {
                    return b;
                }
                long a = this.f4192a.mo3783a();
                if (this.f4194c.mo3425a(this.f4192a, (long) 8192) == -1) {
                    return -1;
                }
                j = Math.max(j, a);
            }
        } else {
            throw new IllegalStateException("closed".toString());
        }
    }

    /* renamed from: a */
    public boolean mo3807a(long j, bwq bwq) {
        bfq.m6567f(bwq, "bytes");
        return mo3808a(j, bwq, 0, bwq.mo3951n());
    }

    /* renamed from: a */
    public boolean mo3808a(long j, bwq bwq, int i, int i2) {
        bfq.m6567f(bwq, "bytes");
        if (!(!this.f4193b)) {
            throw new IllegalStateException("closed".toString());
        } else if (j < 0 || i < 0 || i2 < 0 || bwq.mo3951n() - i < i2) {
            return false;
        } else {
            for (int i3 = 0; i3 < i2; i3++) {
                long j2 = ((long) i3) + j;
                if (!mo3829c(1 + j2) || this.f4192a.mo3831d(j2) != bwq.mo3931d(i + i3)) {
                    return false;
                }
            }
            return true;
        }
    }

    /* renamed from: j */
    public bwp mo3858j() {
        return bxb.m10330a((bxr) new bxe(this));
    }

    /* renamed from: k */
    public InputStream mo3862k() {
        return new bxl(this);
    }

    public boolean isOpen() {
        return !this.f4193b;
    }

    public void close() {
        if (!this.f4193b) {
            this.f4193b = true;
            this.f4194c.close();
            this.f4192a.mo3769B();
        }
    }

    public bxs timeout() {
        return this.f4194c.timeout();
    }

    public String toString() {
        return "buffer(" + this.f4194c + ')';
    }

    /* renamed from: v */
    public bwq mo3886v() {
        this.f4192a.mo3789a(this.f4194c);
        return this.f4192a.mo3886v();
    }

    /* renamed from: A */
    public byte[] mo3768A() {
        this.f4192a.mo3789a(this.f4194c);
        return this.f4192a.mo3768A();
    }

    public int read(ByteBuffer byteBuffer) {
        bfq.m6567f(byteBuffer, "sink");
        if (this.f4192a.mo3783a() == 0 && this.f4194c.mo3425a(this.f4192a, (long) 8192) == -1) {
            return -1;
        }
        return this.f4192a.read(byteBuffer);
    }

    /* renamed from: w */
    public String mo3887w() {
        this.f4192a.mo3789a(this.f4194c);
        return this.f4192a.mo3887w();
    }

    /* renamed from: a */
    public String mo3805a(Charset charset) {
        bfq.m6567f(charset, "charset");
        this.f4192a.mo3789a(this.f4194c);
        return this.f4192a.mo3805a(charset);
    }
}
