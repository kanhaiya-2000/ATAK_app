package atakplugin.UASTool;

import com.autel.util.log.LogTask;
import java.io.EOFException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

@aot(mo1534a = 1, mo1535b = {1, 1, 11}, mo1536c = {1, 0, 2}, mo1537d = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0019\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 X2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001XB\u000f\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0010H\u0016J\b\u0010\u0018\u001a\u00020\u0010H\u0016J\u0011\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u0000H\u0002J\u0010\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u0010H\u0002J\u000e\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0004J\u000e\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0000J\u0013\u0010 \u001a\u00020\u001e2\b\u0010\u001a\u001a\u0004\u0018\u00010!H\u0002J\u0016\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\tH\u0002¢\u0006\u0002\b%J\u0015\u0010%\u001a\u00020#2\u0006\u0010$\u001a\u00020\tH\u0007¢\u0006\u0002\b&J\r\u0010'\u001a\u00020\tH\u0010¢\u0006\u0002\b(J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010)\u001a\u00020\u0010H\u0016J\u0018\u0010*\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u00102\u0006\u0010+\u001a\u00020\u0000H\u0002J\u0010\u0010,\u001a\u00020\u00002\u0006\u0010+\u001a\u00020\u0000H\u0016J\u0010\u0010-\u001a\u00020\u00002\u0006\u0010+\u001a\u00020\u0000H\u0016J\u0010\u0010.\u001a\u00020\u00002\u0006\u0010+\u001a\u00020\u0000H\u0016J\u001a\u0010/\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00042\b\b\u0002\u00100\u001a\u00020\tH\u0017J\u001a\u0010/\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u00100\u001a\u00020\tH\u0007J\r\u00101\u001a\u00020\u0004H\u0010¢\u0006\u0002\b2J\u0015\u00103\u001a\u00020#2\u0006\u00104\u001a\u00020\tH\u0010¢\u0006\u0002\b5J\u001a\u00106\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00042\b\b\u0002\u00100\u001a\u00020\tH\u0017J\u001a\u00106\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u00100\u001a\u00020\tH\u0007J\b\u00107\u001a\u00020\u0000H\u0016J(\u00108\u001a\u00020\u001e2\u0006\u00109\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010:\u001a\u00020\t2\u0006\u0010;\u001a\u00020\tH\u0016J(\u00108\u001a\u00020\u001e2\u0006\u00109\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00002\u0006\u0010:\u001a\u00020\t2\u0006\u0010;\u001a\u00020\tH\u0016J\u0010\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020?H\u0002J\b\u0010@\u001a\u00020\u0000H\u0016J\b\u0010A\u001a\u00020\u0000H\u0016J\b\u0010B\u001a\u00020\u0000H\u0016J\r\u0010\u000e\u001a\u00020\tH\u0007¢\u0006\u0002\bCJ\u000e\u0010D\u001a\u00020\u001e2\u0006\u0010E\u001a\u00020\u0004J\u000e\u0010D\u001a\u00020\u001e2\u0006\u0010E\u001a\u00020\u0000J\u0010\u0010F\u001a\u00020\u00102\u0006\u0010G\u001a\u00020HH\u0016J\u001c\u0010I\u001a\u00020\u00002\b\b\u0002\u0010J\u001a\u00020\t2\b\b\u0002\u0010K\u001a\u00020\tH\u0017J\b\u0010L\u001a\u00020\u0000H\u0016J\b\u0010M\u001a\u00020\u0000H\u0016J\b\u0010N\u001a\u00020\u0004H\u0016J\b\u0010O\u001a\u00020\u0010H\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010P\u001a\u00020=2\u0006\u0010Q\u001a\u00020RH\u0016J\u0015\u0010P\u001a\u00020=2\u0006\u0010S\u001a\u00020TH\u0010¢\u0006\u0002\bUJ\u0010\u0010V\u001a\u00020=2\u0006\u0010Q\u001a\u00020WH\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001e\u0010\b\u001a\u00020\t8\u0000@\u0000X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\t8G¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000bR \u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0000@\u0000X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006Y"}, mo1538e = {"Lokio/ByteString;", "Ljava/io/Serializable;", "", "data", "", "([B)V", "getData$jvm", "()[B", "hashCode", "", "getHashCode$jvm", "()I", "setHashCode$jvm", "(I)V", "size", "utf8", "", "getUtf8$jvm", "()Ljava/lang/String;", "setUtf8$jvm", "(Ljava/lang/String;)V", "asByteBuffer", "Ljava/nio/ByteBuffer;", "base64", "base64Url", "compareTo", "other", "digest", "algorithm", "endsWith", "", "suffix", "equals", "", "get", "", "index", "getByte", "-deprecated_getByte", "getSize", "getSize$jvm", "hex", "hmac", "key", "hmacSha1", "hmacSha256", "hmacSha512", "indexOf", "fromIndex", "internalArray", "internalArray$jvm", "internalGet", "pos", "internalGet$jvm", "lastIndexOf", "md5", "rangeEquals", "offset", "otherOffset", "byteCount", "readObject", "", "in", "Ljava/io/ObjectInputStream;", "sha1", "sha256", "sha512", "-deprecated_size", "startsWith", "prefix", "string", "charset", "Ljava/nio/charset/Charset;", "substring", "beginIndex", "endIndex", "toAsciiLowercase", "toAsciiUppercase", "toByteArray", "toString", "write", "out", "Ljava/io/OutputStream;", "buffer", "Lokio/Buffer;", "write$jvm", "writeObject", "Ljava/io/ObjectOutputStream;", "Companion", "jvm"})
public class bwq implements Serializable, Comparable<bwq> {

    /* renamed from: a */
    public static final bwq f4133a = bxv.m10514a();

    /* renamed from: b */
    public static final C0277a f4134b = new C0277a((bfd) null);

    /* renamed from: f */
    private static final long f4135f = 1;

    /* renamed from: c */
    private transient int f4136c;

    /* renamed from: d */
    private transient String f4137d;

    /* renamed from: e */
    private final byte[] f4138e;

    @bcz
    /* renamed from: a */
    public static final bwq m10187a(InputStream inputStream, int i) {
        return f4134b.mo3959a(inputStream, i);
    }

    @bcz
    /* renamed from: a */
    public static final bwq m10189a(String str, Charset charset) {
        return f4134b.mo3961a(str, charset);
    }

    @bcz
    /* renamed from: a */
    public static final bwq m10190a(ByteBuffer byteBuffer) {
        return f4134b.mo3962a(byteBuffer);
    }

    @bcz
    /* renamed from: a */
    public static final bwq m10191a(byte[] bArr, int i, int i2) {
        return f4134b.mo3964a(bArr, i, i2);
    }

    @bcz
    /* renamed from: b */
    public static final bwq m10196b(String str) {
        return f4134b.mo3960a(str);
    }

    @bcz
    /* renamed from: c */
    public static final bwq m10197c(String str) {
        return f4134b.mo3966b(str);
    }

    @bcz
    /* renamed from: d */
    public static final bwq m10198d(String str) {
        return f4134b.mo3970c(str);
    }

    @bcz
    /* renamed from: e */
    public static final bwq m10200e(byte... bArr) {
        return f4134b.mo3963a(bArr);
    }

    /* renamed from: b */
    public bwq mo3922b(int i) {
        return m10186a(this, i, 0, 2, (Object) null);
    }

    /* renamed from: c */
    public int mo3927c(byte[] bArr) {
        return m10185a(this, bArr, 0, 2, (Object) null);
    }

    /* renamed from: d */
    public int mo3932d(byte[] bArr) {
        return m10195b(this, bArr, 0, 2, (Object) null);
    }

    /* renamed from: f */
    public final int mo3939f(bwq bwq) {
        return m10184a(this, bwq, 0, 2, (Object) null);
    }

    /* renamed from: g */
    public final int mo3941g(bwq bwq) {
        return m10194b(this, bwq, 0, 2, (Object) null);
    }

    /* renamed from: m */
    public bwq mo3950m() {
        return m10186a(this, 0, 0, 3, (Object) null);
    }

    public bwq(byte[] bArr) {
        bfq.m6567f(bArr, "data");
        this.f4138e = bArr;
    }

    /* renamed from: t */
    public final byte[] mo3957t() {
        return this.f4138e;
    }

    /* renamed from: a */
    public final int mo3907a() {
        return this.f4136c;
    }

    /* renamed from: a */
    public final void mo3913a(int i) {
        this.f4136c = i;
    }

    /* renamed from: a */
    public final void mo3916a(String str) {
        this.f4137d = str;
    }

    /* renamed from: b */
    public final String mo3924b() {
        return this.f4137d;
    }

    /* renamed from: c */
    public String mo3929c() {
        return bxv.m10518a(this);
    }

    /* renamed from: a */
    public String mo3912a(Charset charset) {
        bfq.m6567f(charset, "charset");
        return new String(this.f4138e, charset);
    }

    /* renamed from: d */
    public String mo3933d() {
        return bxv.m10525b(this);
    }

    /* renamed from: e */
    public bwq mo3936e() {
        return m10199e("MD5");
    }

    /* renamed from: f */
    public bwq mo3940f() {
        return m10199e("SHA-1");
    }

    /* renamed from: g */
    public bwq mo3942g() {
        return m10199e("SHA-256");
    }

    /* renamed from: h */
    public bwq mo3944h() {
        return m10199e("SHA-512");
    }

    /* renamed from: e */
    private final bwq m10199e(String str) {
        byte[] digest = MessageDigest.getInstance(str).digest(this.f4138e);
        bfq.m6554b(digest, "MessageDigest.getInstance(algorithm).digest(data)");
        return new bwq(digest);
    }

    /* renamed from: a */
    public bwq mo3911a(bwq bwq) {
        bfq.m6567f(bwq, "key");
        return m10188a("HmacSHA1", bwq);
    }

    /* renamed from: b */
    public bwq mo3923b(bwq bwq) {
        bfq.m6567f(bwq, "key");
        return m10188a("HmacSHA256", bwq);
    }

    /* renamed from: a */
    public static /* synthetic */ int m10184a(bwq bwq, bwq bwq2, int i, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                i = 0;
            }
            return bwq.mo3908a(bwq2, i);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: indexOf");
    }

    /* renamed from: a */
    public static /* synthetic */ int m10185a(bwq bwq, byte[] bArr, int i, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                i = 0;
            }
            return bwq.mo3909a(bArr, i);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: indexOf");
    }

    /* renamed from: c */
    public bwq mo3928c(bwq bwq) {
        bfq.m6567f(bwq, "key");
        return m10188a("HmacSHA512", bwq);
    }

    /* renamed from: a */
    private final bwq m10188a(String str, bwq bwq) {
        try {
            Mac instance = Mac.getInstance(str);
            instance.init(new SecretKeySpec(bwq.mo3953p(), str));
            byte[] doFinal = instance.doFinal(this.f4138e);
            bfq.m6554b(doFinal, "mac.doFinal(data)");
            return new bwq(doFinal);
        } catch (InvalidKeyException e) {
            throw new IllegalArgumentException(e);
        }
    }

    /* renamed from: i */
    public String mo3946i() {
        return bxv.m10530c(this);
    }

    /* renamed from: j */
    public String mo3947j() {
        return bxv.m10531d(this);
    }

    /* renamed from: k */
    public bwq mo3948k() {
        return bxv.m10532e(this);
    }

    /* renamed from: l */
    public bwq mo3949l() {
        return bxv.m10533f(this);
    }

    /* renamed from: a */
    public static /* synthetic */ bwq m10186a(bwq bwq, int i, int i2, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 1) != 0) {
                i = 0;
            }
            if ((i3 & 2) != 0) {
                i2 = bwq.mo3951n();
            }
            return bwq.mo3910a(i, i2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: substring");
    }

    /* renamed from: a */
    public bwq mo3910a(int i, int i2) {
        return bxv.m10515a(this, i, i2);
    }

    /* renamed from: c */
    public byte mo3926c(int i) {
        return bxv.m10510a(this, i);
    }

    /* renamed from: d */
    public final byte mo3931d(int i) {
        return mo3926c(i);
    }

    /* renamed from: n */
    public final int mo3951n() {
        return mo3952o();
    }

    /* renamed from: o */
    public int mo3952o() {
        return bxv.m10534g(this);
    }

    /* renamed from: p */
    public byte[] mo3953p() {
        return bxv.m10535h(this);
    }

    /* renamed from: q */
    public byte[] mo3954q() {
        return bxv.m10536i(this);
    }

    /* renamed from: r */
    public ByteBuffer mo3955r() {
        ByteBuffer asReadOnlyBuffer = ByteBuffer.wrap(this.f4138e).asReadOnlyBuffer();
        bfq.m6554b(asReadOnlyBuffer, "ByteBuffer.wrap(data).asReadOnlyBuffer()");
        return asReadOnlyBuffer;
    }

    /* renamed from: a */
    public void mo3915a(OutputStream outputStream) {
        bfq.m6567f(outputStream, "out");
        outputStream.write(this.f4138e);
    }

    /* renamed from: a */
    public void mo3914a(bwl bwl) {
        bfq.m6567f(bwl, "buffer");
        byte[] bArr = this.f4138e;
        bwl.mo3828c(bArr, 0, bArr.length);
    }

    /* renamed from: a */
    public boolean mo3917a(int i, bwq bwq, int i2, int i3) {
        bfq.m6567f(bwq, "other");
        return bxv.m10519a(this, i, bwq, i2, i3);
    }

    /* renamed from: a */
    public boolean mo3918a(int i, byte[] bArr, int i2, int i3) {
        bfq.m6567f(bArr, "other");
        return bxv.m10520a(this, i, bArr, i2, i3);
    }

    /* renamed from: d */
    public final boolean mo3934d(bwq bwq) {
        bfq.m6567f(bwq, "prefix");
        return bxv.m10521a(this, bwq);
    }

    /* renamed from: a */
    public final boolean mo3919a(byte[] bArr) {
        bfq.m6567f(bArr, "prefix");
        return bxv.m10523a(this, bArr);
    }

    /* renamed from: e */
    public final boolean mo3937e(bwq bwq) {
        bfq.m6567f(bwq, "suffix");
        return bxv.m10526b(this, bwq);
    }

    /* renamed from: b */
    public final boolean mo3925b(byte[] bArr) {
        bfq.m6567f(bArr, "suffix");
        return bxv.m10527b(this, bArr);
    }

    /* renamed from: a */
    public final int mo3908a(bwq bwq, int i) {
        bfq.m6567f(bwq, "other");
        return mo3909a(bwq.mo3954q(), i);
    }

    /* renamed from: a */
    public int mo3909a(byte[] bArr, int i) {
        bfq.m6567f(bArr, "other");
        return bxv.m10512a(this, bArr, i);
    }

    /* renamed from: b */
    public static /* synthetic */ int m10194b(bwq bwq, bwq bwq2, int i, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                i = bwq.mo3951n();
            }
            return bwq.mo3920b(bwq2, i);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: lastIndexOf");
    }

    /* renamed from: b */
    public final int mo3920b(bwq bwq, int i) {
        bfq.m6567f(bwq, "other");
        return mo3921b(bwq.mo3954q(), i);
    }

    /* renamed from: b */
    public static /* synthetic */ int m10195b(bwq bwq, byte[] bArr, int i, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                i = bwq.mo3951n();
            }
            return bwq.mo3921b(bArr, i);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: lastIndexOf");
    }

    /* renamed from: b */
    public int mo3921b(byte[] bArr, int i) {
        bfq.m6567f(bArr, "other");
        for (int min = Math.min(i, this.f4138e.length - bArr.length); min >= 0; min--) {
            if (bwg.m9953a(this.f4138e, min, bArr, 0, bArr.length)) {
                return min;
            }
        }
        return -1;
    }

    public boolean equals(Object obj) {
        return bxv.m10522a(this, obj);
    }

    public int hashCode() {
        return bxv.m10537j(this);
    }

    /* renamed from: h */
    public int compareTo(bwq bwq) {
        bfq.m6567f(bwq, "other");
        return bxv.m10528c(this, bwq);
    }

    public String toString() {
        return bxv.m10538k(this);
    }

    /* renamed from: a */
    private final void m10192a(ObjectInputStream objectInputStream) {
        bwq a = f4134b.mo3959a((InputStream) objectInputStream, objectInputStream.readInt());
        Field declaredField = bwq.class.getDeclaredField(LogTask.LOG_TYPE_ERROR);
        bfq.m6554b(declaredField, "field");
        declaredField.setAccessible(true);
        declaredField.set(this, a.f4138e);
    }

    /* renamed from: a */
    private final void m10193a(ObjectOutputStream objectOutputStream) {
        objectOutputStream.writeInt(this.f4138e.length);
        objectOutputStream.write(this.f4138e);
    }

    @anx(mo1516a = "moved to operator function", mo1517b = @C0081api(mo1552a = "this[index]", mo1553b = {}), mo1518c = any.ERROR)
    /* renamed from: e */
    public final byte mo3935e(int i) {
        return mo3931d(i);
    }

    @anx(mo1516a = "moved to val", mo1517b = @C0081api(mo1552a = "size", mo1553b = {}), mo1518c = any.ERROR)
    /* renamed from: s */
    public final int mo3956s() {
        return mo3951n();
    }

    @aot(mo1534a = 1, mo1535b = {1, 1, 11}, mo1536c = {1, 0, 2}, mo1537d = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0017\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\b\nJ\u0015\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\b\fJ\u001d\u0010\r\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007¢\u0006\u0002\b\u0010J\u0015\u0010\u0011\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\b\u0012J\u0015\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0015H\u0007¢\u0006\u0002\b\u0016J\u0014\u0010\u0013\u001a\u00020\u00042\n\u0010\u0017\u001a\u00020\u0018\"\u00020\u0019H\u0007J%\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001cH\u0007¢\u0006\u0002\b\u0016J\u001d\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\u001d\u001a\u00020\u001cH\u0007¢\u0006\u0002\b!J\u000e\u0010\u0007\u001a\u0004\u0018\u00010\u0004*\u00020\tH\u0007J\f\u0010\u000b\u001a\u00020\u0004*\u00020\tH\u0007J\u001b\u0010\"\u001a\u00020\u0004*\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0007¢\u0006\u0002\b\rJ\f\u0010\u0011\u001a\u00020\u0004*\u00020\tH\u0007J\u0019\u0010#\u001a\u00020\u0004*\u00020 2\u0006\u0010\u001d\u001a\u00020\u001cH\u0007¢\u0006\u0002\b\u001eJ\u0011\u0010$\u001a\u00020\u0004*\u00020\u0015H\u0007¢\u0006\u0002\b\u0013J%\u0010$\u001a\u00020\u0004*\u00020\u00182\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001cH\u0007¢\u0006\u0002\b\u0013R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006%"}, mo1538e = {"Lokio/ByteString$Companion;", "", "()V", "EMPTY", "Lokio/ByteString;", "serialVersionUID", "", "decodeBase64", "string", "", "-deprecated_decodeBase64", "decodeHex", "-deprecated_decodeHex", "encodeString", "charset", "Ljava/nio/charset/Charset;", "-deprecated_encodeString", "encodeUtf8", "-deprecated_encodeUtf8", "of", "buffer", "Ljava/nio/ByteBuffer;", "-deprecated_of", "data", "", "", "array", "offset", "", "byteCount", "read", "inputstream", "Ljava/io/InputStream;", "-deprecated_read", "encode", "readByteString", "toByteString", "jvm"})
    /* renamed from: atakplugin.UASTool.bwq$a */
    public static final class C0277a {
        private C0277a() {
        }

        public /* synthetic */ C0277a(bfd bfd) {
            this();
        }

        @bcz
        /* renamed from: a */
        public final bwq mo3963a(byte... bArr) {
            bfq.m6567f(bArr, "data");
            return bxv.m10517a(bArr);
        }

        @bcz
        /* renamed from: a */
        public static /* bridge */ /* synthetic */ bwq m10250a(C0277a aVar, byte[] bArr, int i, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = 0;
            }
            if ((i3 & 2) != 0) {
                i2 = bArr.length;
            }
            return aVar.mo3964a(bArr, i, i2);
        }

        @bcz
        /* renamed from: a */
        public final bwq mo3964a(byte[] bArr, int i, int i2) {
            bfq.m6567f(bArr, "$receiver");
            bwg.m9952a((long) bArr.length, (long) i, (long) i2);
            byte[] bArr2 = new byte[i2];
            bwf.m9943a(bArr, i, bArr2, 0, i2);
            return new bwq(bArr2);
        }

        @bcz
        /* renamed from: a */
        public final bwq mo3962a(ByteBuffer byteBuffer) {
            bfq.m6567f(byteBuffer, "$receiver");
            byte[] bArr = new byte[byteBuffer.remaining()];
            byteBuffer.get(bArr);
            return new bwq(bArr);
        }

        @bcz
        /* renamed from: a */
        public final bwq mo3960a(String str) {
            bfq.m6567f(str, "$receiver");
            return bxv.m10516a(str);
        }

        @bcz
        /* renamed from: a */
        public static /* bridge */ /* synthetic */ bwq m10249a(C0277a aVar, String str, Charset charset, int i, Object obj) {
            if ((i & 1) != 0) {
                charset = bnh.f2996a;
            }
            return aVar.mo3961a(str, charset);
        }

        @bcz
        /* renamed from: a */
        public final bwq mo3961a(String str, Charset charset) {
            bfq.m6567f(str, "$receiver");
            bfq.m6567f(charset, "charset");
            byte[] bytes = str.getBytes(charset);
            bfq.m6554b(bytes, "(this as java.lang.String).getBytes(charset)");
            return new bwq(bytes);
        }

        @bcz
        /* renamed from: b */
        public final bwq mo3966b(String str) {
            bfq.m6567f(str, "$receiver");
            return bxv.m10524b(str);
        }

        @bcz
        /* renamed from: c */
        public final bwq mo3970c(String str) {
            bfq.m6567f(str, "$receiver");
            return bxv.m10529c(str);
        }

        @bcz
        /* renamed from: a */
        public final bwq mo3959a(InputStream inputStream, int i) {
            bfq.m6567f(inputStream, "$receiver");
            int i2 = 0;
            if (i >= 0) {
                byte[] bArr = new byte[i];
                while (i2 < i) {
                    int read = inputStream.read(bArr, i2, i - i2);
                    if (read != -1) {
                        i2 += read;
                    } else {
                        throw new EOFException();
                    }
                }
                return new bwq(bArr);
            }
            throw new IllegalArgumentException(("byteCount < 0: " + i).toString());
        }

        @anx(mo1516a = "moved to extension function", mo1517b = @C0081api(mo1552a = "string.decodeBase64()", mo1553b = {"okio.ByteString.Companion.decodeBase64"}), mo1518c = any.ERROR)
        /* renamed from: d */
        public final bwq mo3971d(String str) {
            bfq.m6567f(str, "string");
            return mo3966b(str);
        }

        @anx(mo1516a = "moved to extension function", mo1517b = @C0081api(mo1552a = "string.decodeHex()", mo1553b = {"okio.ByteString.Companion.decodeHex"}), mo1518c = any.ERROR)
        /* renamed from: e */
        public final bwq mo3972e(String str) {
            bfq.m6567f(str, "string");
            return mo3970c(str);
        }

        @anx(mo1516a = "moved to extension function", mo1517b = @C0081api(mo1552a = "string.encode(charset)", mo1553b = {"okio.ByteString.Companion.encode"}), mo1518c = any.ERROR)
        /* renamed from: b */
        public final bwq mo3967b(String str, Charset charset) {
            bfq.m6567f(str, "string");
            bfq.m6567f(charset, "charset");
            return mo3961a(str, charset);
        }

        @anx(mo1516a = "moved to extension function", mo1517b = @C0081api(mo1552a = "string.encodeUtf8()", mo1553b = {"okio.ByteString.Companion.encodeUtf8"}), mo1518c = any.ERROR)
        /* renamed from: f */
        public final bwq mo3973f(String str) {
            bfq.m6567f(str, "string");
            return mo3960a(str);
        }

        @anx(mo1516a = "moved to extension function", mo1517b = @C0081api(mo1552a = "buffer.toByteString()", mo1553b = {"okio.ByteString.Companion.toByteString"}), mo1518c = any.ERROR)
        /* renamed from: b */
        public final bwq mo3968b(ByteBuffer byteBuffer) {
            bfq.m6567f(byteBuffer, "buffer");
            return mo3962a(byteBuffer);
        }

        @anx(mo1516a = "moved to extension function", mo1517b = @C0081api(mo1552a = "array.toByteString(offset, byteCount)", mo1553b = {"okio.ByteString.Companion.toByteString"}), mo1518c = any.ERROR)
        /* renamed from: b */
        public final bwq mo3969b(byte[] bArr, int i, int i2) {
            bfq.m6567f(bArr, "array");
            return mo3964a(bArr, i, i2);
        }

        @anx(mo1516a = "moved to extension function", mo1517b = @C0081api(mo1552a = "inputstream.readByteString(byteCount)", mo1553b = {"okio.ByteString.Companion.readByteString"}), mo1518c = any.ERROR)
        /* renamed from: b */
        public final bwq mo3965b(InputStream inputStream, int i) {
            bfq.m6567f(inputStream, "inputstream");
            return mo3959a(inputStream, i);
        }
    }
}
