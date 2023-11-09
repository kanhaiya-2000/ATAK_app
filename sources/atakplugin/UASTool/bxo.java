package atakplugin.UASTool;

import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;

@aot(mo1534a = 1, mo1535b = {1, 1, 11}, mo1536c = {1, 0, 2}, mo1537d = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\r\n\u0002\u0010\u0005\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0011\u001a\n \u0013*\u0004\u0018\u00010\u00120\u0012H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0016J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0002J\r\u0010\u001b\u001a\u00020\u0005H\u0010¢\u0006\u0002\b\u001cJ\b\u0010\u001d\u001a\u00020\u0005H\u0016J\b\u0010\u001e\u001a\u00020\u0015H\u0016J\u0010\u0010\u001f\u001a\u00020\u00012\u0006\u0010 \u001a\u00020\u0001H\u0016J\u0010\u0010!\u001a\u00020\u00012\u0006\u0010 \u001a\u00020\u0001H\u0016J\u0010\u0010\"\u001a\u00020\u00012\u0006\u0010 \u001a\u00020\u0001H\u0016J\u0018\u0010#\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\r2\u0006\u0010$\u001a\u00020\u0005H\u0016J\r\u0010%\u001a\u00020\rH\u0010¢\u0006\u0002\b&J\u0015\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u0005H\u0010¢\u0006\u0002\b*J\u0018\u0010+\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\r2\u0006\u0010$\u001a\u00020\u0005H\u0016J\b\u0010,\u001a\u00020\u0001H\u0016J(\u0010-\u001a\u00020\u00182\u0006\u0010.\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\r2\u0006\u0010/\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J(\u0010-\u001a\u00020\u00182\u0006\u0010.\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00012\u0006\u0010/\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u00100\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\u0005H\u0002J\b\u00101\u001a\u00020\u0001H\u0016J\b\u00102\u001a\u00020\u0001H\u0016J\b\u00103\u001a\u00020\u0001H\u0016J\u0010\u00104\u001a\u00020\u00152\u0006\u00105\u001a\u000206H\u0016J\u0018\u00107\u001a\u00020\u00012\u0006\u00108\u001a\u00020\u00052\u0006\u00109\u001a\u00020\u0005H\u0016J\b\u0010:\u001a\u00020\u0001H\u0016J\b\u0010;\u001a\u00020\u0001H\u0016J\b\u0010<\u001a\u00020\rH\u0016J\b\u0010=\u001a\u00020\u0001H\u0002J\b\u0010>\u001a\u00020\u0015H\u0016J\b\u0010?\u001a\u00020\u0015H\u0016J\u0010\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020CH\u0016J\u0015\u0010@\u001a\u00020A2\u0006\u0010\u0002\u001a\u00020\u0003H\u0010¢\u0006\u0002\bDJ\b\u0010E\u001a\u00020FH\u0002R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000f¨\u0006G"}, mo1538e = {"Lokio/SegmentedByteString;", "Lokio/ByteString;", "buffer", "Lokio/Buffer;", "byteCount", "", "(Lokio/Buffer;I)V", "directory", "", "getDirectory", "()[I", "segments", "", "", "getSegments", "()[[B", "[[B", "asByteBuffer", "Ljava/nio/ByteBuffer;", "kotlin.jvm.PlatformType", "base64", "", "base64Url", "equals", "", "other", "", "getSize", "getSize$jvm", "hashCode", "hex", "hmacSha1", "key", "hmacSha256", "hmacSha512", "indexOf", "fromIndex", "internalArray", "internalArray$jvm", "internalGet", "", "pos", "internalGet$jvm", "lastIndexOf", "md5", "rangeEquals", "offset", "otherOffset", "segment", "sha1", "sha256", "sha512", "string", "charset", "Ljava/nio/charset/Charset;", "substring", "beginIndex", "endIndex", "toAsciiLowercase", "toAsciiUppercase", "toByteArray", "toByteString", "toString", "utf8", "write", "", "out", "Ljava/io/OutputStream;", "write$jvm", "writeReplace", "Ljava/lang/Object;", "jvm"})
public final class bxo extends bwq {

    /* renamed from: c */
    private final transient byte[][] f4210c;

    /* renamed from: d */
    private final transient int[] f4211d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public bxo(bwl bwl, int i) {
        super(bwq.f4133a.mo3957t());
        bfq.m6567f(bwl, "buffer");
        bwg.m9952a(bwl.mo3783a(), 0, (long) i);
        bxm bxm = bwl.f4122a;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            if (bxm == null) {
                bfq.m6538a();
            }
            if (bxm.f4201c != bxm.f4200b) {
                i3 += bxm.f4201c - bxm.f4200b;
                i4++;
                bxm = bxm.f4204f;
            } else {
                throw new AssertionError("s.limit == s.pos");
            }
        }
        byte[][] bArr = new byte[i4][];
        this.f4211d = new int[(i4 * 2)];
        bxm bxm2 = bwl.f4122a;
        int i5 = 0;
        while (i2 < i) {
            if (bxm2 == null) {
                bfq.m6538a();
            }
            bArr[i5] = bxm2.f4199a;
            i2 += bxm2.f4201c - bxm2.f4200b;
            if (i2 > i) {
                i2 = i;
            }
            int[] iArr = this.f4211d;
            iArr[i5] = i2;
            iArr[((Object[]) bArr).length + i5] = bxm2.f4200b;
            bxm2.f4202d = true;
            i5++;
            bxm2 = bxm2.f4204f;
        }
        this.f4210c = bArr;
    }

    /* renamed from: u */
    public final byte[][] mo4066u() {
        return this.f4210c;
    }

    /* renamed from: v */
    public final int[] mo4067v() {
        return this.f4211d;
    }

    /* renamed from: c */
    public String mo3929c() {
        return m10452w().mo3929c();
    }

    /* renamed from: a */
    public String mo3912a(Charset charset) {
        bfq.m6567f(charset, "charset");
        return m10452w().mo3912a(charset);
    }

    /* renamed from: d */
    public String mo3933d() {
        return m10452w().mo3933d();
    }

    /* renamed from: j */
    public String mo3947j() {
        return m10452w().mo3947j();
    }

    /* renamed from: k */
    public bwq mo3948k() {
        return m10452w().mo3948k();
    }

    /* renamed from: l */
    public bwq mo3949l() {
        return m10452w().mo3949l();
    }

    /* renamed from: e */
    public bwq mo3936e() {
        return m10452w().mo3936e();
    }

    /* renamed from: f */
    public bwq mo3940f() {
        return m10452w().mo3940f();
    }

    /* renamed from: g */
    public bwq mo3942g() {
        return m10452w().mo3942g();
    }

    /* renamed from: h */
    public bwq mo3944h() {
        return m10452w().mo3944h();
    }

    /* renamed from: a */
    public bwq mo3911a(bwq bwq) {
        bfq.m6567f(bwq, "key");
        return m10452w().mo3911a(bwq);
    }

    /* renamed from: b */
    public bwq mo3923b(bwq bwq) {
        bfq.m6567f(bwq, "key");
        return m10452w().mo3923b(bwq);
    }

    /* renamed from: c */
    public bwq mo3928c(bwq bwq) {
        bfq.m6567f(bwq, "key");
        return m10452w().mo3928c(bwq);
    }

    /* renamed from: i */
    public String mo3946i() {
        return m10452w().mo3946i();
    }

    /* renamed from: a */
    public bwq mo3910a(int i, int i2) {
        return m10452w().mo3910a(i, i2);
    }

    /* renamed from: c */
    public byte mo3926c(int i) {
        int i2;
        bwg.m9952a((long) this.f4211d[((Object[]) this.f4210c).length - 1], (long) i, 1);
        int f = m10451f(i);
        if (f == 0) {
            i2 = 0;
        } else {
            i2 = this.f4211d[f - 1];
        }
        int[] iArr = this.f4211d;
        byte[][] bArr = this.f4210c;
        return bArr[f][(i - i2) + iArr[((Object[]) bArr).length + f]];
    }

    /* renamed from: f */
    private final int m10451f(int i) {
        int binarySearch = Arrays.binarySearch(this.f4211d, 0, ((Object[]) this.f4210c).length, i + 1);
        return binarySearch >= 0 ? binarySearch : ~binarySearch;
    }

    /* renamed from: o */
    public int mo3952o() {
        return this.f4211d[((Object[]) this.f4210c).length - 1];
    }

    /* renamed from: p */
    public byte[] mo3953p() {
        int[] iArr = this.f4211d;
        byte[][] bArr = this.f4210c;
        byte[] bArr2 = new byte[iArr[((Object[]) bArr).length - 1]];
        int length = ((Object[]) bArr).length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int[] iArr2 = this.f4211d;
            int i3 = iArr2[length + i];
            int i4 = iArr2[i];
            bwf.m9943a(this.f4210c[i], i3, bArr2, i2, i4 - i2);
            i++;
            i2 = i4;
        }
        return bArr2;
    }

    /* renamed from: r */
    public ByteBuffer mo3955r() {
        return ByteBuffer.wrap(mo3953p()).asReadOnlyBuffer();
    }

    /* renamed from: a */
    public void mo3915a(OutputStream outputStream) {
        bfq.m6567f(outputStream, "out");
        int length = ((Object[]) this.f4210c).length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int[] iArr = this.f4211d;
            int i3 = iArr[length + i];
            int i4 = iArr[i];
            outputStream.write(this.f4210c[i], i3, i4 - i2);
            i++;
            i2 = i4;
        }
    }

    /* renamed from: a */
    public void mo3914a(bwl bwl) {
        bfq.m6567f(bwl, "buffer");
        int length = ((Object[]) this.f4210c).length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int[] iArr = this.f4211d;
            int i3 = iArr[length + i];
            int i4 = iArr[i];
            bxm bxm = new bxm(this.f4210c[i], i3, (i3 + i4) - i2, true, false);
            if (bwl.f4122a == null) {
                bxm.f4205g = bxm;
                bxm.f4204f = bxm.f4205g;
                bwl.f4122a = bxm.f4204f;
            } else {
                bxm bxm2 = bwl.f4122a;
                if (bxm2 == null) {
                    bfq.m6538a();
                }
                bxm bxm3 = bxm2.f4205g;
                if (bxm3 == null) {
                    bfq.m6538a();
                }
                bxm3.mo4061a(bxm);
            }
            i++;
            i2 = i4;
        }
        bwl.mo3806a(bwl.mo3783a() + ((long) i2));
    }

    /* renamed from: a */
    public boolean mo3917a(int i, bwq bwq, int i2, int i3) {
        int i4;
        bfq.m6567f(bwq, "other");
        if (i < 0 || i > mo3951n() - i3) {
            return false;
        }
        int f = m10451f(i);
        while (i3 > 0) {
            if (f == 0) {
                i4 = 0;
            } else {
                i4 = this.f4211d[f - 1];
            }
            int min = Math.min(i3, ((this.f4211d[f] - i4) + i4) - i);
            int[] iArr = this.f4211d;
            byte[][] bArr = this.f4210c;
            if (!bwq.mo3918a(i2, bArr[f], (i - i4) + iArr[((Object[]) bArr).length + f], min)) {
                return false;
            }
            i += min;
            i2 += min;
            i3 -= min;
            f++;
        }
        return true;
    }

    /* renamed from: a */
    public boolean mo3918a(int i, byte[] bArr, int i2, int i3) {
        int i4;
        bfq.m6567f(bArr, "other");
        if (i < 0 || i > mo3951n() - i3 || i2 < 0 || i2 > bArr.length - i3) {
            return false;
        }
        int f = m10451f(i);
        while (i3 > 0) {
            if (f == 0) {
                i4 = 0;
            } else {
                i4 = this.f4211d[f - 1];
            }
            int min = Math.min(i3, ((this.f4211d[f] - i4) + i4) - i);
            int[] iArr = this.f4211d;
            byte[][] bArr2 = this.f4210c;
            if (!bwg.m9953a(bArr2[f], (i - i4) + iArr[((Object[]) bArr2).length + f], bArr, i2, min)) {
                return false;
            }
            i += min;
            i2 += min;
            i3 -= min;
            f++;
        }
        return true;
    }

    /* renamed from: a */
    public int mo3909a(byte[] bArr, int i) {
        bfq.m6567f(bArr, "other");
        return m10452w().mo3909a(bArr, i);
    }

    /* renamed from: b */
    public int mo3921b(byte[] bArr, int i) {
        bfq.m6567f(bArr, "other");
        return m10452w().mo3921b(bArr, i);
    }

    /* renamed from: w */
    private final bwq m10452w() {
        return new bwq(mo3953p());
    }

    /* renamed from: q */
    public byte[] mo3954q() {
        return mo3953p();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof bwq) {
            bwq bwq = (bwq) obj;
            if (bwq.mo3951n() != mo3951n() || !mo3917a(0, bwq, 0, mo3951n())) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        int a = mo3907a();
        if (a != 0) {
            return a;
        }
        int length = ((Object[]) this.f4210c).length;
        int i = 0;
        int i2 = 0;
        int i3 = 1;
        while (i < length) {
            byte[] bArr = this.f4210c[i];
            int[] iArr = this.f4211d;
            int i4 = iArr[length + i];
            int i5 = iArr[i];
            int i6 = (i5 - i2) + i4;
            while (i4 < i6) {
                i3 = (i3 * 31) + bArr[i4];
                i4++;
            }
            i++;
            i2 = i5;
        }
        mo3913a(i3);
        return i3;
    }

    public String toString() {
        return m10452w().toString();
    }

    /* renamed from: x */
    private final Object m10453x() {
        bwq w = m10452w();
        if (w != null) {
            return w;
        }
        throw new apx("null cannot be cast to non-null type java.lang.Object");
    }
}
