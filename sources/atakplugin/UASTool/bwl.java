package atakplugin.UASTool;

import com.google.common.base.Ascii;
import com.o3dr.services.android.lib.drone.connection.ConnectionType;
import indago.serialization.JsonKeyConstants;
import java.io.Closeable;
import java.io.EOFException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.util.Arrays;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

@aot(mo1534a = 1, mo1535b = {1, 1, 11}, mo1536c = {1, 0, 2}, mo1537d = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\n\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0018\u0018\u0000 \u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0004\u0001\u0001B\u0005¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0000H\u0016J\u0006\u0010\u0011\u001a\u00020\u0012J\b\u0010\u0013\u001a\u00020\u0000H\u0016J\b\u0010\u0014\u001a\u00020\u0012H\u0016J\u0006\u0010\u0015\u001a\u00020\fJ$\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\f2\b\b\u0002\u0010\u001a\u001a\u00020\fH\u0007J\"\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0019\u001a\u00020\f2\b\b\u0002\u0010\u001a\u001a\u00020\fJ\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u0010\u001f\u001a\u00020\u0000H\u0016J\b\u0010 \u001a\u00020\u0000H\u0016J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u0002J\b\u0010%\u001a\u00020\"H\u0016J\b\u0010&\u001a\u00020\u0012H\u0016J\u0016\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\fH\u0002¢\u0006\u0002\b*J\u0015\u0010*\u001a\u00020(2\u0006\u0010+\u001a\u00020\fH\u0007¢\u0006\u0002\b,J\b\u0010-\u001a\u00020.H\u0016J\u0018\u0010/\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u00100\u001a\u00020\u001cH\u0002J\u000e\u00101\u001a\u00020\u001c2\u0006\u00100\u001a\u00020\u001cJ\u000e\u00102\u001a\u00020\u001c2\u0006\u00100\u001a\u00020\u001cJ\u000e\u00103\u001a\u00020\u001c2\u0006\u00100\u001a\u00020\u001cJ\u0010\u00104\u001a\u00020\f2\u0006\u00105\u001a\u00020(H\u0016J\u0018\u00104\u001a\u00020\f2\u0006\u00105\u001a\u00020(2\u0006\u00106\u001a\u00020\fH\u0016J \u00104\u001a\u00020\f2\u0006\u00105\u001a\u00020(2\u0006\u00106\u001a\u00020\f2\u0006\u00107\u001a\u00020\fH\u0016J\u0010\u00104\u001a\u00020\f2\u0006\u00108\u001a\u00020\u001cH\u0016J\u0018\u00104\u001a\u00020\f2\u0006\u00108\u001a\u00020\u001c2\u0006\u00106\u001a\u00020\fH\u0016J\u0010\u00109\u001a\u00020\f2\u0006\u0010:\u001a\u00020\u001cH\u0016J\u0018\u00109\u001a\u00020\f2\u0006\u0010:\u001a\u00020\u001c2\u0006\u00106\u001a\u00020\fH\u0016J\b\u0010;\u001a\u00020<H\u0016J\b\u0010=\u001a\u00020\"H\u0016J\u0006\u0010>\u001a\u00020\u001cJ\b\u0010?\u001a\u00020\u0018H\u0016J\b\u0010@\u001a\u00020\u0001H\u0016J\u0018\u0010A\u001a\u00020\"2\u0006\u0010\u0019\u001a\u00020\f2\u0006\u00108\u001a\u00020\u001cH\u0016J(\u0010A\u001a\u00020\"2\u0006\u0010\u0019\u001a\u00020\f2\u0006\u00108\u001a\u00020\u001c2\u0006\u0010B\u001a\u00020.2\u0006\u0010\u001a\u001a\u00020.H\u0016J0\u0010A\u001a\u00020\"2\u0006\u0010C\u001a\u00020\n2\u0006\u0010D\u001a\u00020.2\u0006\u00108\u001a\u00020E2\u0006\u0010B\u001a\u00020.2\u0006\u0010F\u001a\u00020.H\u0002J\u0010\u0010G\u001a\u00020.2\u0006\u0010H\u001a\u00020IH\u0016J\u0010\u0010G\u001a\u00020.2\u0006\u0010H\u001a\u00020EH\u0016J \u0010G\u001a\u00020.2\u0006\u0010H\u001a\u00020E2\u0006\u0010\u0019\u001a\u00020.2\u0006\u0010\u001a\u001a\u00020.H\u0016J\u0018\u0010G\u001a\u00020\f2\u0006\u0010H\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\fH\u0016J\u0010\u0010J\u001a\u00020\f2\u0006\u0010H\u001a\u00020KH\u0016J\u0012\u0010L\u001a\u00020M2\b\b\u0002\u0010N\u001a\u00020MH\u0007J\b\u0010O\u001a\u00020(H\u0016J\b\u0010P\u001a\u00020EH\u0016J\u0010\u0010P\u001a\u00020E2\u0006\u0010\u001a\u001a\u00020\fH\u0016J\b\u0010Q\u001a\u00020\u001cH\u0016J\u0010\u0010Q\u001a\u00020\u001c2\u0006\u0010\u001a\u001a\u00020\fH\u0016J\b\u0010R\u001a\u00020\fH\u0016J\u000e\u0010S\u001a\u00020\u00002\u0006\u0010T\u001a\u00020<J\u0016\u0010S\u001a\u00020\u00002\u0006\u0010T\u001a\u00020<2\u0006\u0010\u001a\u001a\u00020\fJ \u0010S\u001a\u00020\u00122\u0006\u0010T\u001a\u00020<2\u0006\u0010\u001a\u001a\u00020\f2\u0006\u0010U\u001a\u00020\"H\u0002J\u0010\u0010V\u001a\u00020\u00122\u0006\u0010H\u001a\u00020EH\u0016J\u0018\u0010V\u001a\u00020\u00122\u0006\u0010H\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\fH\u0016J\b\u0010W\u001a\u00020\fH\u0016J\b\u0010X\u001a\u00020.H\u0016J\b\u0010Y\u001a\u00020.H\u0016J\b\u0010Z\u001a\u00020\fH\u0016J\b\u0010[\u001a\u00020\fH\u0016J\b\u0010\\\u001a\u00020]H\u0016J\b\u0010^\u001a\u00020]H\u0016J\u0010\u0010_\u001a\u00020\u001e2\u0006\u0010`\u001a\u00020aH\u0016J\u0018\u0010_\u001a\u00020\u001e2\u0006\u0010\u001a\u001a\u00020\f2\u0006\u0010`\u001a\u00020aH\u0016J\u0012\u0010b\u001a\u00020M2\b\b\u0002\u0010N\u001a\u00020MH\u0007J\b\u0010c\u001a\u00020\u001eH\u0016J\u0010\u0010c\u001a\u00020\u001e2\u0006\u0010\u001a\u001a\u00020\fH\u0016J\b\u0010d\u001a\u00020.H\u0016J\n\u0010e\u001a\u0004\u0018\u00010\u001eH\u0016J\u0015\u0010e\u001a\u00020\u001e2\u0006\u0010f\u001a\u00020\fH\u0000¢\u0006\u0002\bgJ\b\u0010h\u001a\u00020\u001eH\u0016J\u0010\u0010h\u001a\u00020\u001e2\u0006\u0010i\u001a\u00020\fH\u0016J\u0010\u0010j\u001a\u00020\"2\u0006\u0010\u001a\u001a\u00020\fH\u0016J\u0010\u0010k\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\fH\u0016J8\u0010l\u001a\u0002Hm\"\u0004\b\u0000\u0010m2\u0006\u00106\u001a\u00020\f2\u001a\u0010n\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u0002Hm0oH\b¢\u0006\u0002\u0010pJ\u0010\u0010q\u001a\u00020.2\u0006\u0010r\u001a\u00020sH\u0016J\u001f\u0010t\u001a\u00020.2\u0006\u0010r\u001a\u00020s2\b\b\u0002\u0010u\u001a\u00020\"H\u0000¢\u0006\u0002\bvJ\u0006\u0010w\u001a\u00020\u001cJ\u0006\u0010x\u001a\u00020\u001cJ\u0006\u0010y\u001a\u00020\u001cJ\r\u0010\r\u001a\u00020\fH\u0007¢\u0006\u0002\bzJ\u0010\u0010{\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\fH\u0016J\u0006\u0010|\u001a\u00020\u001cJ\u000e\u0010|\u001a\u00020\u001c2\u0006\u0010\u001a\u001a\u00020.J\b\u0010}\u001a\u00020~H\u0016J\b\u0010\u001a\u00020\u001eH\u0016J\u0018\u0010\u0001\u001a\u00020\n2\u0007\u0010\u0001\u001a\u00020.H\u0000¢\u0006\u0003\b\u0001J\u0012\u0010\u0001\u001a\u00020.2\u0007\u0010\u0001\u001a\u00020IH\u0016J\u0012\u0010\u0001\u001a\u00020\u00002\u0007\u0010\u0001\u001a\u00020EH\u0016J\"\u0010\u0001\u001a\u00020\u00002\u0007\u0010\u0001\u001a\u00020E2\u0006\u0010\u0019\u001a\u00020.2\u0006\u0010\u001a\u001a\u00020.H\u0016J\u001a\u0010\u0001\u001a\u00020\u00122\u0007\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\fH\u0016J\u0012\u0010\u0001\u001a\u00020\u00002\u0007\u0010\u0001\u001a\u00020\u001cH\u0016J\u001b\u0010\u0001\u001a\u00020\u00022\b\u0010\u0001\u001a\u00030\u00012\u0006\u0010\u001a\u001a\u00020\fH\u0016J\u0013\u0010\u0001\u001a\u00020\f2\b\u0010\u0001\u001a\u00030\u0001H\u0016J\u0011\u0010\u0001\u001a\u00020\u00002\u0006\u00105\u001a\u00020.H\u0016J\u0012\u0010\u0001\u001a\u00020\u00002\u0007\u0010\u0001\u001a\u00020\fH\u0016J\u0012\u0010\u0001\u001a\u00020\u00002\u0007\u0010\u0001\u001a\u00020\fH\u0016J\u0012\u0010\u0001\u001a\u00020\u00002\u0007\u0010\u0001\u001a\u00020.H\u0016J\u0012\u0010\u0001\u001a\u00020\u00002\u0007\u0010\u0001\u001a\u00020.H\u0016J\u0012\u0010\u0001\u001a\u00020\u00002\u0007\u0010\u0001\u001a\u00020\fH\u0016J\u0012\u0010\u0001\u001a\u00020\u00002\u0007\u0010\u0001\u001a\u00020\fH\u0016J\u0012\u0010\u0001\u001a\u00020\u00002\u0007\u0010\u0001\u001a\u00020.H\u0016J\u0012\u0010\u0001\u001a\u00020\u00002\u0007\u0010\u0001\u001a\u00020.H\u0016J\u001a\u0010\u0001\u001a\u00020\u00002\u0007\u0010\u0001\u001a\u00020\u001e2\u0006\u0010`\u001a\u00020aH\u0016J,\u0010\u0001\u001a\u00020\u00002\u0007\u0010\u0001\u001a\u00020\u001e2\u0007\u0010\u0001\u001a\u00020.2\u0007\u0010\u0001\u001a\u00020.2\u0006\u0010`\u001a\u00020aH\u0016J\u001b\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u001a\u001a\u00020\fH\u0007J\u0012\u0010\u0001\u001a\u00020\u00002\u0007\u0010\u0001\u001a\u00020\u001eH\u0016J$\u0010\u0001\u001a\u00020\u00002\u0007\u0010\u0001\u001a\u00020\u001e2\u0007\u0010\u0001\u001a\u00020.2\u0007\u0010\u0001\u001a\u00020.H\u0016J\u0012\u0010\u0001\u001a\u00020\u00002\u0007\u0010\u0001\u001a\u00020.H\u0016R\u0014\u0010\u0006\u001a\u00020\u00008VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u0004\u0018\u00010\n8\u0000@\u0000X\u000e¢\u0006\u0002\n\u0000R&\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f8\u0007@@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0001"}, mo1538e = {"Lokio/Buffer;", "Lokio/BufferedSource;", "Lokio/BufferedSink;", "", "Ljava/nio/channels/ByteChannel;", "()V", "buffer", "getBuffer", "()Lokio/Buffer;", "head", "Lokio/Segment;", "<set-?>", "", "size", "()J", "setSize$jvm", "(J)V", "clear", "", "clone", "close", "completeSegmentByteCount", "copyTo", "out", "Ljava/io/OutputStream;", "offset", "byteCount", "digest", "Lokio/ByteString;", "algorithm", "", "emit", "emitCompleteSegments", "equals", "", "other", "", "exhausted", "flush", "get", "", "pos", "getByte", "index", "-deprecated_getByte", "hashCode", "", "hmac", "key", "hmacSha1", "hmacSha256", "hmacSha512", "indexOf", "b", "fromIndex", "toIndex", "bytes", "indexOfElement", "targetBytes", "inputStream", "Ljava/io/InputStream;", "isOpen", "md5", "outputStream", "peek", "rangeEquals", "bytesOffset", "segment", "segmentPos", "", "bytesLimit", "read", "sink", "Ljava/nio/ByteBuffer;", "readAll", "Lokio/Sink;", "readAndWriteUnsafe", "Lokio/Buffer$UnsafeCursor;", "unsafeCursor", "readByte", "readByteArray", "readByteString", "readDecimalLong", "readFrom", "input", "forever", "readFully", "readHexadecimalUnsignedLong", "readInt", "readIntLe", "readLong", "readLongLe", "readShort", "", "readShortLe", "readString", "charset", "Ljava/nio/charset/Charset;", "readUnsafe", "readUtf8", "readUtf8CodePoint", "readUtf8Line", "newline", "readUtf8Line$jvm", "readUtf8LineStrict", "limit", "request", "require", "seek", "T", "lambda", "Lkotlin/Function2;", "(JLkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "select", "options", "Lokio/Options;", "selectPrefix", "selectTruncated", "selectPrefix$jvm", "sha1", "sha256", "sha512", "-deprecated_size", "skip", "snapshot", "timeout", "Lokio/Timeout;", "toString", "writableSegment", "minimumCapacity", "writableSegment$jvm", "write", "source", "byteString", "Lokio/Source;", "writeAll", "writeByte", "writeDecimalLong", "v", "writeHexadecimalUnsignedLong", "writeInt", "i", "writeIntLe", "writeLong", "writeLongLe", "writeShort", "s", "writeShortLe", "writeString", "string", "beginIndex", "endIndex", "writeTo", "writeUtf8", "writeUtf8CodePoint", "codePoint", "Companion", "UnsafeCursor", "jvm"})
public final class bwl implements bwo, bwp, Cloneable, ByteChannel {

    /* renamed from: b */
    public static final C0275a f4120b = new C0275a((bfd) null);

    /* renamed from: d */
    private static final byte[] f4121d;

    /* renamed from: a */
    public bxm f4122a;

    /* renamed from: c */
    private long f4123c;

    /* renamed from: I */
    public final C0276b mo3776I() {
        return m9984a(this, (C0276b) null, 1, (Object) null);
    }

    /* renamed from: J */
    public final C0276b mo3777J() {
        return m9992b(this, (C0276b) null, 1, (Object) null);
    }

    /* renamed from: a */
    public final bwl mo3796a(OutputStream outputStream) {
        return m9987a(this, outputStream, 0, 0, 6, (Object) null);
    }

    /* renamed from: a */
    public final bwl mo3797a(OutputStream outputStream, long j) {
        return m9987a(this, outputStream, j, 0, 4, (Object) null);
    }

    /* renamed from: b */
    public bwl mo3811b() {
        return this;
    }

    /* renamed from: b */
    public final bwl mo3812b(OutputStream outputStream) {
        return m9986a(this, outputStream, 0, 2, (Object) null);
    }

    /* renamed from: c */
    public bwl mo3825c() {
        return this;
    }

    public void close() {
    }

    /* renamed from: e */
    public bwl mo3841f() {
        return this;
    }

    public void flush() {
    }

    /* renamed from: g */
    public bwl mo3849h() {
        return this;
    }

    public boolean isOpen() {
        return true;
    }

    /* renamed from: a */
    public final long mo3783a() {
        return this.f4123c;
    }

    /* renamed from: a */
    public final void mo3806a(long j) {
        this.f4123c = j;
    }

    /* renamed from: d */
    public OutputStream mo3835d() {
        return new bwn(this);
    }

    /* renamed from: i */
    public boolean mo3854i() {
        return this.f4123c == 0;
    }

    /* renamed from: b */
    public void mo3821b(long j) {
        if (this.f4123c < j) {
            throw new EOFException();
        }
    }

    /* renamed from: c */
    public boolean mo3829c(long j) {
        return this.f4123c >= j;
    }

    /* renamed from: j */
    public bwp mo3858j() {
        return bxb.m10330a((bxr) new bxe(this));
    }

    /* renamed from: k */
    public InputStream mo3862k() {
        return new bwm(this);
    }

    /* renamed from: a */
    public static /* bridge */ /* synthetic */ bwl m9987a(bwl bwl, OutputStream outputStream, long j, long j2, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 0;
        }
        long j3 = j;
        if ((i & 4) != 0) {
            j2 = bwl.f4123c - j3;
        }
        return bwl.mo3798a(outputStream, j3, j2);
    }

    /* renamed from: a */
    public final bwl mo3798a(OutputStream outputStream, long j, long j2) {
        bfq.m6567f(outputStream, "out");
        bwg.m9952a(this.f4123c, j, j2);
        if (j2 == 0) {
            return this;
        }
        bxm bxm = this.f4122a;
        while (true) {
            if (bxm == null) {
                bfq.m6538a();
            }
            if (j < ((long) (bxm.f4201c - bxm.f4200b))) {
                break;
            }
            j -= (long) (bxm.f4201c - bxm.f4200b);
            bxm = bxm.f4204f;
        }
        while (j2 > 0) {
            if (bxm == null) {
                bfq.m6538a();
            }
            int i = (int) (((long) bxm.f4200b) + j);
            int min = (int) Math.min((long) (bxm.f4201c - i), j2);
            outputStream.write(bxm.f4199a, i, min);
            j2 -= (long) min;
            bxm = bxm.f4204f;
            j = 0;
        }
        return this;
    }

    /* renamed from: a */
    public static /* bridge */ /* synthetic */ bwl m9985a(bwl bwl, bwl bwl2, long j, long j2, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 0;
        }
        long j3 = j;
        if ((i & 4) != 0) {
            j2 = bwl.f4123c - j3;
        }
        return bwl.mo3792a(bwl2, j3, j2);
    }

    /* renamed from: a */
    public final bwl mo3792a(bwl bwl, long j, long j2) {
        bfq.m6567f(bwl, "out");
        bwg.m9952a(this.f4123c, j, j2);
        if (j2 == 0) {
            return this;
        }
        bwl.f4123c += j2;
        bxm bxm = this.f4122a;
        while (true) {
            if (bxm == null) {
                bfq.m6538a();
            }
            if (j < ((long) (bxm.f4201c - bxm.f4200b))) {
                break;
            }
            j -= (long) (bxm.f4201c - bxm.f4200b);
            bxm = bxm.f4204f;
        }
        while (j2 > 0) {
            if (bxm == null) {
                bfq.m6538a();
            }
            bxm a = bxm.mo4059a();
            a.f4200b += (int) j;
            a.f4201c = Math.min(a.f4200b + ((int) j2), a.f4201c);
            bxm bxm2 = bwl.f4122a;
            if (bxm2 == null) {
                a.f4205g = a;
                a.f4204f = a.f4205g;
                bwl.f4122a = a.f4204f;
            } else {
                if (bxm2 == null) {
                    bfq.m6538a();
                }
                bxm bxm3 = bxm2.f4205g;
                if (bxm3 == null) {
                    bfq.m6538a();
                }
                bxm3.mo4061a(a);
            }
            j2 -= (long) (a.f4201c - a.f4200b);
            bxm = bxm.f4204f;
            j = 0;
        }
        return this;
    }

    /* renamed from: a */
    public static /* synthetic */ bwl m9986a(bwl bwl, OutputStream outputStream, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = bwl.f4123c;
        }
        return bwl.mo3813b(outputStream, j);
    }

    /* renamed from: b */
    public final bwl mo3813b(OutputStream outputStream, long j) {
        bfq.m6567f(outputStream, "out");
        bwg.m9952a(this.f4123c, 0, j);
        bxm bxm = this.f4122a;
        while (j > 0) {
            if (bxm == null) {
                bfq.m6538a();
            }
            int min = (int) Math.min(j, (long) (bxm.f4201c - bxm.f4200b));
            outputStream.write(bxm.f4199a, bxm.f4200b, min);
            bxm.f4200b += min;
            long j2 = (long) min;
            this.f4123c -= j2;
            j -= j2;
            if (bxm.f4200b == bxm.f4201c) {
                bxm c = bxm.mo4064c();
                this.f4122a = c;
                bxn.m10450a(bxm);
                bxm = c;
            }
        }
        return this;
    }

    /* renamed from: a */
    public final bwl mo3794a(InputStream inputStream) {
        bfq.m6567f(inputStream, "input");
        m9990a(inputStream, (long) bfu.f2629b, true);
        return this;
    }

    /* renamed from: a */
    public final bwl mo3795a(InputStream inputStream, long j) {
        bfq.m6567f(inputStream, "input");
        if (j >= 0) {
            m9990a(inputStream, j, false);
            return this;
        }
        throw new IllegalArgumentException(("byteCount < 0: " + j).toString());
    }

    /* renamed from: a */
    private final void m9990a(InputStream inputStream, long j, boolean z) {
        while (true) {
            if (j > 0 || z) {
                bxm m = mo3868m(1);
                int read = inputStream.read(m.f4199a, m.f4201c, (int) Math.min(j, (long) (8192 - m.f4201c)));
                if (read != -1) {
                    m.f4201c += read;
                    long j2 = (long) read;
                    this.f4123c += j2;
                    j -= j2;
                } else if (!z) {
                    throw new EOFException();
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    /* renamed from: l */
    public final long mo3863l() {
        long j = this.f4123c;
        if (j == 0) {
            return 0;
        }
        bxm bxm = this.f4122a;
        if (bxm == null) {
            bfq.m6538a();
        }
        bxm bxm2 = bxm.f4205g;
        if (bxm2 == null) {
            bfq.m6538a();
        }
        return (bxm2.f4201c >= 8192 || !bxm2.f4203e) ? j : j - ((long) (bxm2.f4201c - bxm2.f4200b));
    }

    /* renamed from: m */
    public byte mo3866m() {
        if (this.f4123c != 0) {
            bxm bxm = this.f4122a;
            if (bxm == null) {
                bfq.m6538a();
            }
            int i = bxm.f4200b;
            int i2 = bxm.f4201c;
            int i3 = i + 1;
            byte b = bxm.f4199a[i];
            this.f4123c--;
            if (i3 == i2) {
                this.f4122a = bxm.mo4064c();
                bxn.m10450a(bxm);
            } else {
                bxm.f4200b = i3;
            }
            return b;
        }
        throw new EOFException();
    }

    /* renamed from: d */
    public final byte mo3831d(long j) {
        bwg.m9952a(this.f4123c, j, 1);
        bxm bxm = this.f4122a;
        if (bxm == null) {
            bxm bxm2 = null;
            bfq.m6538a();
            return bxm2.f4199a[(int) ((((long) bxm2.f4200b) + j) - -1)];
        } else if (mo3783a() - j < j) {
            long a = mo3783a();
            while (a > j) {
                bxm = bxm.f4205g;
                if (bxm == null) {
                    bfq.m6538a();
                }
                a -= (long) (bxm.f4201c - bxm.f4200b);
            }
            if (bxm == null) {
                bfq.m6538a();
            }
            return bxm.f4199a[(int) ((((long) bxm.f4200b) + j) - a)];
        } else {
            long j2 = 0;
            while (true) {
                long j3 = ((long) (bxm.f4201c - bxm.f4200b)) + j2;
                if (j3 > j) {
                    break;
                }
                bxm = bxm.f4204f;
                if (bxm == null) {
                    bfq.m6538a();
                }
                j2 = j3;
            }
            if (bxm == null) {
                bfq.m6538a();
            }
            return bxm.f4199a[(int) ((((long) bxm.f4200b) + j) - j2)];
        }
    }

    /* renamed from: n */
    public short mo3871n() {
        if (this.f4123c >= 2) {
            bxm bxm = this.f4122a;
            if (bxm == null) {
                bfq.m6538a();
            }
            int i = bxm.f4200b;
            int i2 = bxm.f4201c;
            if (i2 - i < 2) {
                return (short) (((mo3866m() & 255) << 8) | (mo3866m() & 255));
            }
            byte[] bArr = bxm.f4199a;
            int i3 = i + 1;
            int i4 = i3 + 1;
            byte b = ((bArr[i] & 255) << 8) | (bArr[i3] & 255);
            this.f4123c -= 2;
            if (i4 == i2) {
                this.f4122a = bxm.mo4064c();
                bxn.m10450a(bxm);
            } else {
                bxm.f4200b = i4;
            }
            return (short) b;
        }
        throw new EOFException();
    }

    /* renamed from: o */
    public int mo3872o() {
        if (this.f4123c >= 4) {
            bxm bxm = this.f4122a;
            if (bxm == null) {
                bfq.m6538a();
            }
            int i = bxm.f4200b;
            int i2 = bxm.f4201c;
            if (((long) (i2 - i)) < 4) {
                return ((mo3866m() & 255) << Ascii.CAN) | ((mo3866m() & 255) << 16) | ((mo3866m() & 255) << 8) | (mo3866m() & 255);
            }
            byte[] bArr = bxm.f4199a;
            int i3 = i + 1;
            int i4 = i3 + 1;
            byte b = ((bArr[i] & 255) << Ascii.CAN) | ((bArr[i3] & 255) << 16);
            int i5 = i4 + 1;
            byte b2 = b | ((bArr[i4] & 255) << 8);
            int i6 = i5 + 1;
            byte b3 = b2 | (bArr[i5] & 255);
            this.f4123c -= 4;
            if (i6 == i2) {
                this.f4122a = bxm.mo4064c();
                bxn.m10450a(bxm);
            } else {
                bxm.f4200b = i6;
            }
            return b3;
        }
        throw new EOFException();
    }

    /* renamed from: p */
    public long mo3874p() {
        if (this.f4123c >= 8) {
            bxm bxm = this.f4122a;
            if (bxm == null) {
                bfq.m6538a();
            }
            int i = bxm.f4200b;
            int i2 = bxm.f4201c;
            if (((long) (i2 - i)) < 8) {
                return ((((long) mo3872o()) & 4294967295L) << 32) | (4294967295L & ((long) mo3872o()));
            }
            byte[] bArr = bxm.f4199a;
            int i3 = i + 1;
            int i4 = i3 + 1;
            int i5 = i4 + 1;
            long j = ((((long) bArr[i]) & 255) << 56) | ((((long) bArr[i3]) & 255) << 48) | ((((long) bArr[i4]) & 255) << 40);
            int i6 = i5 + 1;
            long j2 = ((((long) bArr[i5]) & 255) << 32) | j;
            int i7 = i6 + 1;
            int i8 = i7 + 1;
            long j3 = j2 | ((((long) bArr[i6]) & 255) << 24) | ((((long) bArr[i7]) & 255) << 16);
            int i9 = i8 + 1;
            int i10 = i9 + 1;
            long j4 = j3 | ((((long) bArr[i8]) & 255) << 8) | (((long) bArr[i9]) & 255);
            this.f4123c -= 8;
            if (i10 == i2) {
                this.f4122a = bxm.mo4064c();
                bxn.m10450a(bxm);
            } else {
                bxm.f4200b = i10;
            }
            return j4;
        }
        throw new EOFException();
    }

    /* renamed from: q */
    public short mo3877q() {
        return bwg.m9951a(mo3871n());
    }

    /* renamed from: r */
    public int mo3878r() {
        return bwg.m9946a(mo3872o());
    }

    /* renamed from: s */
    public long mo3882s() {
        return bwg.m9949a(mo3874p());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0050, code lost:
        if (r8 != false) goto L_0x0055;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0052, code lost:
        r1.mo3866m();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0071, code lost:
        throw new java.lang.NumberFormatException("Number too large: " + r1.mo3887w());
     */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00a3 A[EDGE_INSN: B:50:0x00a3->B:32:0x00a3 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:5:0x0013  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x001e  */
    /* renamed from: t */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long mo3883t() {
        /*
            r17 = this;
            r0 = r17
            long r1 = r0.f4123c
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x00c2
            r5 = -7
            r7 = 0
            r8 = 0
            r9 = 0
        L_0x000f:
            atakplugin.UASTool.bxm r10 = r0.f4122a
            if (r10 != 0) goto L_0x0016
            atakplugin.UASTool.bfq.m6538a()
        L_0x0016:
            byte[] r11 = r10.f4199a
            int r12 = r10.f4200b
            int r13 = r10.f4201c
        L_0x001c:
            if (r12 >= r13) goto L_0x00a3
            byte r15 = r11[r12]
            r14 = 48
            byte r14 = (byte) r14
            if (r15 < r14) goto L_0x0072
            r1 = 57
            byte r1 = (byte) r1
            if (r15 > r1) goto L_0x0072
            int r14 = r14 - r15
            r1 = -922337203685477580(0xf333333333333334, double:-8.390303882365713E246)
            int r16 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r16 < 0) goto L_0x0043
            if (r16 != 0) goto L_0x003c
            long r1 = (long) r14
            int r16 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r16 >= 0) goto L_0x003c
            goto L_0x0043
        L_0x003c:
            r1 = 10
            long r3 = r3 * r1
            long r1 = (long) r14
            long r3 = r3 + r1
            goto L_0x007d
        L_0x0043:
            atakplugin.UASTool.bwl r1 = new atakplugin.UASTool.bwl
            r1.<init>()
            atakplugin.UASTool.bwl r1 = r1.mo3875p(r3)
            atakplugin.UASTool.bwl r1 = r1.mo3833d((int) r15)
            if (r8 != 0) goto L_0x0055
            r1.mo3866m()
        L_0x0055:
            java.lang.NumberFormatException r2 = new java.lang.NumberFormatException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Number too large: "
            r3.append(r4)
            java.lang.String r1 = r1.mo3887w()
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r2.<init>(r1)
            java.lang.Throwable r2 = (java.lang.Throwable) r2
            throw r2
        L_0x0072:
            r1 = 45
            byte r1 = (byte) r1
            if (r15 != r1) goto L_0x0082
            if (r7 != 0) goto L_0x0082
            r1 = 1
            long r5 = r5 - r1
            r8 = 1
        L_0x007d:
            int r12 = r12 + 1
            int r7 = r7 + 1
            goto L_0x001c
        L_0x0082:
            if (r7 == 0) goto L_0x0086
            r9 = 1
            goto L_0x00a3
        L_0x0086:
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Expected leading [0-9] or '-' character but was 0x"
            r2.append(r3)
            java.lang.String r3 = java.lang.Integer.toHexString(r15)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x00a3:
            if (r12 != r13) goto L_0x00af
            atakplugin.UASTool.bxm r1 = r10.mo4064c()
            r0.f4122a = r1
            atakplugin.UASTool.bxn.m10450a(r10)
            goto L_0x00b1
        L_0x00af:
            r10.f4200b = r12
        L_0x00b1:
            if (r9 != 0) goto L_0x00b7
            atakplugin.UASTool.bxm r1 = r0.f4122a
            if (r1 != 0) goto L_0x000f
        L_0x00b7:
            long r1 = r0.f4123c
            long r5 = (long) r7
            long r1 = r1 - r5
            r0.f4123c = r1
            if (r8 == 0) goto L_0x00c0
            goto L_0x00c1
        L_0x00c0:
            long r3 = -r3
        L_0x00c1:
            return r3
        L_0x00c2:
            java.io.EOFException r1 = new java.io.EOFException
            r1.<init>()
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.bwl.mo3883t():long");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x009e, code lost:
        if (r8 != r9) goto L_0x00aa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00a0, code lost:
        r15.f4122a = r6.mo4064c();
        atakplugin.UASTool.bxn.m10450a(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00aa, code lost:
        r6.f4200b = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00ac, code lost:
        if (r1 != false) goto L_0x00b2;
     */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0081 A[SYNTHETIC] */
    /* renamed from: u */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long mo3885u() {
        /*
            r15 = this;
            long r0 = r15.f4123c
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto L_0x00b9
            r0 = 0
            r4 = r2
            r1 = 0
        L_0x000b:
            atakplugin.UASTool.bxm r6 = r15.f4122a
            if (r6 != 0) goto L_0x0012
            atakplugin.UASTool.bfq.m6538a()
        L_0x0012:
            byte[] r7 = r6.f4199a
            int r8 = r6.f4200b
            int r9 = r6.f4201c
        L_0x0018:
            if (r8 >= r9) goto L_0x009e
            byte r10 = r7[r8]
            r11 = 48
            byte r11 = (byte) r11
            if (r10 < r11) goto L_0x0029
            r12 = 57
            byte r12 = (byte) r12
            if (r10 > r12) goto L_0x0029
            int r11 = r10 - r11
            goto L_0x0043
        L_0x0029:
            r11 = 97
            byte r11 = (byte) r11
            if (r10 < r11) goto L_0x0038
            r12 = 102(0x66, float:1.43E-43)
            byte r12 = (byte) r12
            if (r10 > r12) goto L_0x0038
        L_0x0033:
            int r11 = r10 - r11
            int r11 = r11 + 10
            goto L_0x0043
        L_0x0038:
            r11 = 65
            byte r11 = (byte) r11
            if (r10 < r11) goto L_0x007d
            r12 = 70
            byte r12 = (byte) r12
            if (r10 > r12) goto L_0x007d
            goto L_0x0033
        L_0x0043:
            r12 = -1152921504606846976(0xf000000000000000, double:-3.105036184601418E231)
            long r12 = r12 & r4
            int r14 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r14 != 0) goto L_0x0053
            r10 = 4
            long r4 = r4 << r10
            long r10 = (long) r11
            long r4 = r4 | r10
            int r8 = r8 + 1
            int r0 = r0 + 1
            goto L_0x0018
        L_0x0053:
            atakplugin.UASTool.bwl r0 = new atakplugin.UASTool.bwl
            r0.<init>()
            atakplugin.UASTool.bwl r0 = r0.mo3879r(r4)
            atakplugin.UASTool.bwl r0 = r0.mo3833d((int) r10)
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Number too large: "
            r2.append(r3)
            java.lang.String r0 = r0.mo3887w()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x007d:
            if (r0 == 0) goto L_0x0081
            r1 = 1
            goto L_0x009e
        L_0x0081:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Expected leading [0-9a-fA-F] character but was 0x"
            r1.append(r2)
            java.lang.String r2 = java.lang.Integer.toHexString(r10)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            throw r0
        L_0x009e:
            if (r8 != r9) goto L_0x00aa
            atakplugin.UASTool.bxm r7 = r6.mo4064c()
            r15.f4122a = r7
            atakplugin.UASTool.bxn.m10450a(r6)
            goto L_0x00ac
        L_0x00aa:
            r6.f4200b = r8
        L_0x00ac:
            if (r1 != 0) goto L_0x00b2
            atakplugin.UASTool.bxm r6 = r15.f4122a
            if (r6 != 0) goto L_0x000b
        L_0x00b2:
            long r1 = r15.f4123c
            long r6 = (long) r0
            long r1 = r1 - r6
            r15.f4123c = r1
            return r4
        L_0x00b9:
            java.io.EOFException r0 = new java.io.EOFException
            r0.<init>()
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.bwl.mo3885u():long");
    }

    /* renamed from: v */
    public bwq mo3886v() {
        return new bwq(mo3768A());
    }

    /* renamed from: e */
    public bwq mo3838e(long j) {
        return new bwq(mo3855i(j));
    }

    /* renamed from: a */
    public int mo3779a(bxc bxc) {
        bfq.m6567f(bxc, "options");
        int a = m9983a(this, bxc, false, 2, (Object) null);
        if (a == -1) {
            return -1;
        }
        mo3859j((long) bxc.mo4020b()[a].mo3951n());
        return a;
    }

    /* renamed from: a */
    public static /* bridge */ /* synthetic */ int m9983a(bwl bwl, bxc bxc, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return bwl.mo3780a(bxc, z);
    }

    /* renamed from: a */
    public final int mo3780a(bxc bxc, boolean z) {
        int i;
        int i2;
        int i3;
        bxm bxm;
        int i4;
        bfq.m6567f(bxc, "options");
        bxm bxm2 = this.f4122a;
        int i5 = -2;
        if (bxm2 == null) {
            return z ? -2 : -1;
        }
        byte[] bArr = bxm2.f4199a;
        int i6 = bxm2.f4200b;
        int i7 = bxm2.f4201c;
        int[] c = bxc.mo4023c();
        bxm bxm3 = bxm2;
        int i8 = 0;
        int i9 = -1;
        loop0:
        while (true) {
            int i10 = i8 + 1;
            int i11 = c[i8];
            int i12 = i10 + 1;
            int i13 = c[i10];
            if (i13 != -1) {
                i9 = i13;
            }
            if (bxm3 == null) {
                break;
            }
            if (i11 < 0) {
                int i14 = i12 + (i11 * -1);
                while (true) {
                    int i15 = i6 + 1;
                    int i16 = i12 + 1;
                    if ((bArr[i6] & 255) != c[i12]) {
                        return i9;
                    }
                    boolean z2 = i16 == i14;
                    if (i15 == i7) {
                        if (bxm3 == null) {
                            bfq.m6538a();
                        }
                        bxm bxm4 = bxm3.f4204f;
                        if (bxm4 == null) {
                            bfq.m6538a();
                        }
                        i4 = bxm4.f4200b;
                        byte[] bArr2 = bxm4.f4199a;
                        i3 = bxm4.f4201c;
                        if (bxm4 == bxm2) {
                            if (!z2) {
                                break loop0;
                            }
                            bxm4 = null;
                        }
                        byte[] bArr3 = bArr2;
                        bxm = bxm4;
                        bArr = bArr3;
                    } else {
                        bxm bxm5 = bxm3;
                        i3 = i7;
                        i4 = i15;
                        bxm = bxm5;
                    }
                    if (z2) {
                        i = c[i16];
                        i2 = i4;
                        i7 = i3;
                        bxm3 = bxm;
                        break;
                    }
                    i6 = i4;
                    i7 = i3;
                    i12 = i16;
                    bxm3 = bxm;
                }
            } else {
                int i17 = i6 + 1;
                byte b = bArr[i6] & 255;
                int i18 = i12 + i11;
                while (i12 != i18) {
                    if (b == c[i12]) {
                        i = c[i12 + i11];
                        if (i17 == i7) {
                            bxm3 = bxm3.f4204f;
                            if (bxm3 == null) {
                                bfq.m6538a();
                            }
                            i2 = bxm3.f4200b;
                            bArr = bxm3.f4199a;
                            i7 = bxm3.f4201c;
                            if (bxm3 == bxm2) {
                                bxm3 = null;
                            }
                        } else {
                            i2 = i17;
                        }
                    } else {
                        i12++;
                    }
                }
                return i9;
            }
            if (i >= 0) {
                return i;
            }
            i8 = -i;
            i6 = i2;
            i5 = -2;
        }
        return z ? i5 : i9;
    }

    /* renamed from: b */
    public void mo3822b(bwl bwl, long j) {
        bfq.m6567f(bwl, "sink");
        long j2 = this.f4123c;
        if (j2 >= j) {
            bwl.write(this, j);
        } else {
            bwl.write(this, j2);
            throw new EOFException();
        }
    }

    /* renamed from: a */
    public long mo3788a(bxp bxp) {
        bfq.m6567f(bxp, "sink");
        long j = this.f4123c;
        if (j > 0) {
            bxp.write(this, j);
        }
        return j;
    }

    /* renamed from: w */
    public String mo3887w() {
        return mo3804a(this.f4123c, bnh.f2996a);
    }

    /* renamed from: f */
    public String mo3844f(long j) {
        return mo3804a(j, bnh.f2996a);
    }

    /* renamed from: a */
    public String mo3805a(Charset charset) {
        bfq.m6567f(charset, "charset");
        return mo3804a(this.f4123c, charset);
    }

    /* renamed from: a */
    public String mo3804a(long j, Charset charset) {
        bfq.m6567f(charset, "charset");
        int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (!(i >= 0 && j <= ((long) Integer.MAX_VALUE))) {
            throw new IllegalArgumentException(("byteCount: " + j).toString());
        } else if (this.f4123c < j) {
            throw new EOFException();
        } else if (i == 0) {
            return "";
        } else {
            bxm bxm = this.f4122a;
            if (bxm == null) {
                bfq.m6538a();
            }
            if (((long) bxm.f4200b) + j > ((long) bxm.f4201c)) {
                return new String(mo3855i(j), charset);
            }
            int i2 = (int) j;
            String str = new String(bxm.f4199a, bxm.f4200b, i2, charset);
            bxm.f4200b += i2;
            this.f4123c -= j;
            if (bxm.f4200b == bxm.f4201c) {
                this.f4122a = bxm.mo4064c();
                bxn.m10450a(bxm);
            }
            return str;
        }
    }

    /* renamed from: x */
    public String mo3889x() {
        long a = mo3784a((byte) 10);
        if (a != -1) {
            return mo3851h(a);
        }
        long j = this.f4123c;
        if (j != 0) {
            return mo3844f(j);
        }
        return null;
    }

    /* renamed from: y */
    public String mo3890y() {
        return mo3848g((long) bfu.f2629b);
    }

    /* renamed from: g */
    public String mo3848g(long j) {
        if (j >= 0) {
            long j2 = bfu.f2629b;
            if (j != bfu.f2629b) {
                j2 = j + 1;
            }
            byte b = (byte) 10;
            long a = mo3786a(b, 0, j2);
            if (a != -1) {
                return mo3851h(a);
            }
            if (j2 < this.f4123c && mo3831d(j2 - 1) == ((byte) 13) && mo3831d(j2) == b) {
                return mo3851h(j2);
            }
            bwl bwl = new bwl();
            mo3792a(bwl, 0, Math.min((long) 32, this.f4123c));
            throw new EOFException("\\n not found: limit=" + Math.min(this.f4123c, j) + " content=" + bwl.mo3886v().mo3947j() + bpg.f3083E);
        }
        throw new IllegalArgumentException(("limit < 0: " + j).toString());
    }

    /* renamed from: h */
    public final String mo3851h(long j) {
        if (j > 0) {
            long j2 = j - 1;
            if (mo3831d(j2) == ((byte) 13)) {
                String f = mo3844f(j2);
                mo3859j(2);
                return f;
            }
        }
        String f2 = mo3844f(j);
        mo3859j(1);
        return f2;
    }

    /* renamed from: z */
    public int mo3891z() {
        byte b;
        int i;
        byte b2;
        if (this.f4123c != 0) {
            byte d = mo3831d(0);
            int i2 = 1;
            if ((d & 128) == 0) {
                b2 = d & Byte.MAX_VALUE;
                i = 1;
                b = 0;
            } else if ((d & 224) == 192) {
                b2 = d & Ascii.f8526US;
                i = 2;
                b = 128;
            } else if ((d & 240) == 224) {
                b2 = d & Ascii.f8523SI;
                i = 3;
                b = 2048;
            } else if ((d & 248) == 240) {
                b2 = d & 7;
                i = 4;
                b = 65536;
            } else {
                mo3859j(1);
                return bxu.f4221c;
            }
            long j = (long) i;
            if (this.f4123c >= j) {
                while (i2 < i) {
                    long j2 = (long) i2;
                    byte d2 = mo3831d(j2);
                    if ((d2 & 192) == 128) {
                        b2 = (b2 << 6) | (d2 & bxu.f4219a);
                        i2++;
                    } else {
                        mo3859j(j2);
                        return bxu.f4221c;
                    }
                }
                mo3859j(j);
                if (b2 > 1114111) {
                    return bxu.f4221c;
                }
                if ((55296 <= b2 && 57343 >= b2) || b2 < b) {
                    return bxu.f4221c;
                }
                return b2;
            }
            throw new EOFException("size < " + i + ": " + this.f4123c + " (to read code point prefixed 0x" + Integer.toHexString(d) + ")");
        }
        throw new EOFException();
    }

    /* renamed from: A */
    public byte[] mo3768A() {
        return mo3855i(this.f4123c);
    }

    /* renamed from: i */
    public byte[] mo3855i(long j) {
        if (!(j >= 0 && j <= ((long) Integer.MAX_VALUE))) {
            throw new IllegalArgumentException(("byteCount: " + j).toString());
        } else if (this.f4123c >= j) {
            byte[] bArr = new byte[((int) j)];
            mo3823b(bArr);
            return bArr;
        } else {
            throw new EOFException();
        }
    }

    /* renamed from: a */
    public int mo3781a(byte[] bArr) {
        bfq.m6567f(bArr, "sink");
        return mo3782a(bArr, 0, bArr.length);
    }

    /* renamed from: b */
    public void mo3823b(byte[] bArr) {
        bfq.m6567f(bArr, "sink");
        int i = 0;
        while (i < bArr.length) {
            int a = mo3782a(bArr, i, bArr.length - i);
            if (a != -1) {
                i += a;
            } else {
                throw new EOFException();
            }
        }
    }

    /* renamed from: a */
    public int mo3782a(byte[] bArr, int i, int i2) {
        bfq.m6567f(bArr, "sink");
        bwg.m9952a((long) bArr.length, (long) i, (long) i2);
        bxm bxm = this.f4122a;
        if (bxm == null) {
            return -1;
        }
        int min = Math.min(i2, bxm.f4201c - bxm.f4200b);
        System.arraycopy(bxm.f4199a, bxm.f4200b, bArr, i, min);
        bxm.f4200b += min;
        this.f4123c -= (long) min;
        if (bxm.f4200b == bxm.f4201c) {
            this.f4122a = bxm.mo4064c();
            bxn.m10450a(bxm);
        }
        return min;
    }

    public int read(ByteBuffer byteBuffer) {
        bfq.m6567f(byteBuffer, "sink");
        bxm bxm = this.f4122a;
        if (bxm == null) {
            return -1;
        }
        int min = Math.min(byteBuffer.remaining(), bxm.f4201c - bxm.f4200b);
        byteBuffer.put(bxm.f4199a, bxm.f4200b, min);
        bxm.f4200b += min;
        this.f4123c -= (long) min;
        if (bxm.f4200b == bxm.f4201c) {
            this.f4122a = bxm.mo4064c();
            bxn.m10450a(bxm);
        }
        return min;
    }

    /* renamed from: B */
    public final void mo3769B() {
        mo3859j(this.f4123c);
    }

    /* renamed from: j */
    public void mo3859j(long j) {
        while (j > 0) {
            bxm bxm = this.f4122a;
            if (bxm != null) {
                int min = (int) Math.min(j, (long) (bxm.f4201c - bxm.f4200b));
                long j2 = (long) min;
                this.f4123c -= j2;
                j -= j2;
                bxm.f4200b += min;
                if (bxm.f4200b == bxm.f4201c) {
                    this.f4122a = bxm.mo4064c();
                    bxn.m10450a(bxm);
                }
            } else {
                throw new EOFException();
            }
        }
    }

    /* renamed from: a */
    public bwl mo3816b(bwq bwq) {
        bfq.m6567f(bwq, "byteString");
        bwq.mo3914a(this);
        return this;
    }

    /* renamed from: a */
    public bwl mo3817b(String str) {
        bfq.m6567f(str, "string");
        return mo3818b(str, 0, str.length());
    }

    /* renamed from: a */
    public bwl mo3818b(String str, int i, int i2) {
        int i3;
        char c;
        bfq.m6567f(str, "string");
        if (i >= 0) {
            if (i2 >= i) {
                if (i2 <= str.length()) {
                    while (i < i2) {
                        char charAt = str.charAt(i);
                        if (charAt < 128) {
                            bxm m = mo3868m(1);
                            byte[] bArr = m.f4199a;
                            int i4 = m.f4201c - i;
                            int min = Math.min(i2, 8192 - i4);
                            i3 = i + 1;
                            bArr[i + i4] = (byte) charAt;
                            while (i3 < min) {
                                char charAt2 = str.charAt(i3);
                                if (charAt2 >= 128) {
                                    break;
                                }
                                bArr[i3 + i4] = (byte) charAt2;
                                i3++;
                            }
                            int i5 = (i4 + i3) - m.f4201c;
                            m.f4201c += i5;
                            this.f4123c += (long) i5;
                        } else {
                            if (charAt < 2048) {
                                bxm m2 = mo3868m(2);
                                m2.f4199a[m2.f4201c] = (byte) ((charAt >> 6) | 192);
                                m2.f4199a[m2.f4201c + 1] = (byte) ((charAt & '?') | 128);
                                m2.f4201c += 2;
                                this.f4123c += 2;
                            } else if (charAt < 55296 || charAt > 57343) {
                                bxm m3 = mo3868m(3);
                                m3.f4199a[m3.f4201c] = (byte) ((charAt >> 12) | 224);
                                m3.f4199a[m3.f4201c + 1] = (byte) ((63 & (charAt >> 6)) | 128);
                                m3.f4199a[m3.f4201c + 2] = (byte) ((charAt & '?') | 128);
                                m3.f4201c += 3;
                                this.f4123c += 3;
                            } else {
                                i3 = i + 1;
                                if (i3 < i2) {
                                    c = str.charAt(i3);
                                } else {
                                    c = 0;
                                }
                                if (charAt > 56319 || 56320 > c || 57343 < c) {
                                    mo3833d(63);
                                } else {
                                    int i6 = (((charAt & 1023) << 10) | (c & 1023)) + 0;
                                    bxm m4 = mo3868m(4);
                                    m4.f4199a[m4.f4201c] = (byte) ((i6 >> 18) | 240);
                                    m4.f4199a[m4.f4201c + 1] = (byte) (((i6 >> 12) & 63) | 128);
                                    m4.f4199a[m4.f4201c + 2] = (byte) (((i6 >> 6) & 63) | 128);
                                    m4.f4199a[m4.f4201c + 3] = (byte) ((i6 & 63) | 128);
                                    m4.f4201c += 4;
                                    this.f4123c += 4;
                                    i += 2;
                                }
                            }
                            i++;
                        }
                        i = i3;
                    }
                    return this;
                }
                throw new IllegalArgumentException(("endIndex > string.length: " + i2 + " > " + str.length()).toString());
            }
            throw new IllegalArgumentException(("endIndex < beginIndex: " + i2 + " < " + i).toString());
        }
        throw new IllegalArgumentException(("beginIndex < 0: " + i).toString());
    }

    /* renamed from: a */
    public bwl mo3815b(int i) {
        if (i < 128) {
            mo3833d(i);
        } else if (i < 2048) {
            bxm m = mo3868m(2);
            m.f4199a[m.f4201c] = (byte) ((i >> 6) | 192);
            m.f4199a[m.f4201c + 1] = (byte) ((i & 63) | 128);
            m.f4201c += 2;
            this.f4123c += 2;
        } else if (55296 <= i && 57343 >= i) {
            mo3833d(63);
        } else if (i < 65536) {
            bxm m2 = mo3868m(3);
            m2.f4199a[m2.f4201c] = (byte) ((i >> 12) | 224);
            m2.f4199a[m2.f4201c + 1] = (byte) (((i >> 6) & 63) | 128);
            m2.f4199a[m2.f4201c + 2] = (byte) ((i & 63) | 128);
            m2.f4201c += 3;
            this.f4123c += 3;
        } else if (i <= 1114111) {
            bxm m3 = mo3868m(4);
            m3.f4199a[m3.f4201c] = (byte) ((i >> 18) | 240);
            m3.f4199a[m3.f4201c + 1] = (byte) (((i >> 12) & 63) | 128);
            m3.f4199a[m3.f4201c + 2] = (byte) (((i >> 6) & 63) | 128);
            m3.f4199a[m3.f4201c + 3] = (byte) ((i & 63) | 128);
            m3.f4201c += 4;
            this.f4123c += 4;
        } else {
            throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i));
        }
        return this;
    }

    /* renamed from: a */
    public bwl mo3820b(String str, Charset charset) {
        bfq.m6567f(str, "string");
        bfq.m6567f(charset, "charset");
        return mo3819b(str, 0, str.length(), charset);
    }

    /* renamed from: a */
    public bwl mo3819b(String str, int i, int i2, Charset charset) {
        bfq.m6567f(str, "string");
        bfq.m6567f(charset, "charset");
        boolean z = true;
        if (i >= 0) {
            if (i2 >= i) {
                if (i2 > str.length()) {
                    z = false;
                }
                if (!z) {
                    throw new IllegalArgumentException(("endIndex > string.length: " + i2 + " > " + str.length()).toString());
                } else if (bfq.m6552a((Object) charset, (Object) bnh.f2996a)) {
                    return mo3818b(str, i, i2);
                } else {
                    String substring = str.substring(i, i2);
                    bfq.m6554b(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    if (substring != null) {
                        byte[] bytes = substring.getBytes(charset);
                        bfq.m6554b(bytes, "(this as java.lang.String).getBytes(charset)");
                        return mo3828c(bytes, 0, bytes.length);
                    }
                    throw new apx("null cannot be cast to non-null type java.lang.String");
                }
            } else {
                throw new IllegalArgumentException(("endIndex < beginIndex: " + i2 + " < " + i).toString());
            }
        } else {
            throw new IllegalArgumentException(("beginIndex < 0: " + i).toString());
        }
    }

    /* renamed from: c */
    public bwl mo3834d(byte[] bArr) {
        bfq.m6567f(bArr, JsonKeyConstants.SOURCE);
        return mo3828c(bArr, 0, bArr.length);
    }

    /* renamed from: b */
    public bwl mo3828c(byte[] bArr, int i, int i2) {
        bfq.m6567f(bArr, JsonKeyConstants.SOURCE);
        long j = (long) i2;
        bwg.m9952a((long) bArr.length, (long) i, j);
        int i3 = i2 + i;
        while (i < i3) {
            bxm m = mo3868m(1);
            int min = Math.min(i3 - i, 8192 - m.f4201c);
            System.arraycopy(bArr, i, m.f4199a, m.f4201c, min);
            i += min;
            m.f4201c += min;
        }
        this.f4123c += j;
        return this;
    }

    public int write(ByteBuffer byteBuffer) {
        bfq.m6567f(byteBuffer, JsonKeyConstants.SOURCE);
        int remaining = byteBuffer.remaining();
        int i = remaining;
        while (i > 0) {
            bxm m = mo3868m(1);
            int min = Math.min(i, 8192 - m.f4201c);
            byteBuffer.get(m.f4199a, m.f4201c, min);
            i -= min;
            m.f4201c += min;
        }
        this.f4123c += (long) remaining;
        return remaining;
    }

    /* renamed from: a */
    public long mo3789a(bxr bxr) {
        bfq.m6567f(bxr, JsonKeyConstants.SOURCE);
        long j = 0;
        while (true) {
            long a = bxr.mo3425a(this, (long) 8192);
            if (a == -1) {
                return j;
            }
            j += a;
        }
    }

    /* renamed from: a */
    public bwo mo3803a(bxr bxr, long j) {
        bfq.m6567f(bxr, JsonKeyConstants.SOURCE);
        while (j > 0) {
            long a = bxr.mo3425a(this, j);
            if (a != -1) {
                j -= a;
            } else {
                throw new EOFException();
            }
        }
        return this;
    }

    /* renamed from: c */
    public bwl mo3833d(int i) {
        bxm m = mo3868m(1);
        byte[] bArr = m.f4199a;
        int i2 = m.f4201c;
        m.f4201c = i2 + 1;
        bArr[i2] = (byte) i;
        this.f4123c++;
        return this;
    }

    /* renamed from: e */
    public bwl mo3842f(int i) {
        bxm m = mo3868m(2);
        byte[] bArr = m.f4199a;
        int i2 = m.f4201c;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        bArr[i3] = (byte) (i & 255);
        m.f4201c = i3 + 1;
        this.f4123c += 2;
        return this;
    }

    /* renamed from: g */
    public bwl mo3850h(int i) {
        return mo3842f((int) bwg.m9951a((short) i));
    }

    /* renamed from: i */
    public bwl mo3857j(int i) {
        bxm m = mo3868m(4);
        byte[] bArr = m.f4199a;
        int i2 = m.f4201c;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 24) & 255);
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i >>> 16) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((i >>> 8) & 255);
        bArr[i5] = (byte) (i & 255);
        m.f4201c = i5 + 1;
        this.f4123c += 4;
        return this;
    }

    /* renamed from: k */
    public bwl mo3864l(int i) {
        return mo3857j(bwg.m9946a(i));
    }

    /* renamed from: k */
    public bwl mo3865l(long j) {
        bxm m = mo3868m(8);
        byte[] bArr = m.f4199a;
        int i = m.f4201c;
        int i2 = i + 1;
        bArr[i] = (byte) ((int) ((j >>> 56) & 255));
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((int) ((j >>> 48) & 255));
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((int) ((j >>> 40) & 255));
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((int) ((j >>> 32) & 255));
        int i6 = i5 + 1;
        bArr[i5] = (byte) ((int) ((j >>> 24) & 255));
        int i7 = i6 + 1;
        bArr[i6] = (byte) ((int) ((j >>> 16) & 255));
        int i8 = i7 + 1;
        bArr[i7] = (byte) ((int) ((j >>> 8) & 255));
        bArr[i8] = (byte) ((int) (j & 255));
        m.f4201c = i8 + 1;
        this.f4123c += 8;
        return this;
    }

    /* renamed from: m */
    public bwl mo3869n(long j) {
        return mo3865l(bwg.m9949a(j));
    }

    /* renamed from: o */
    public bwl mo3875p(long j) {
        int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (i == 0) {
            return mo3833d(48);
        }
        boolean z = false;
        int i2 = 1;
        if (i < 0) {
            j = -j;
            if (j < 0) {
                return mo3817b("-9223372036854775808");
            }
            z = true;
        }
        if (j >= 100000000) {
            i2 = j < 1000000000000L ? j < 10000000000L ? j < 1000000000 ? 9 : 10 : j < 100000000000L ? 11 : 12 : j < 1000000000000000L ? j < 10000000000000L ? 13 : j < 100000000000000L ? 14 : 15 : j < 100000000000000000L ? j < 10000000000000000L ? 16 : 17 : j < 1000000000000000000L ? 18 : 19;
        } else if (j >= ConnectionType.DEFAULT_UDP_PING_PERIOD) {
            i2 = j < 1000000 ? j < 100000 ? 5 : 6 : j < 10000000 ? 7 : 8;
        } else if (j >= 100) {
            i2 = j < 1000 ? 3 : 4;
        } else if (j >= 10) {
            i2 = 2;
        }
        if (z) {
            i2++;
        }
        bxm m = mo3868m(i2);
        byte[] bArr = m.f4199a;
        int i3 = m.f4201c + i2;
        while (j != 0) {
            long j2 = (long) 10;
            i3--;
            bArr[i3] = f4121d[(int) (j % j2)];
            j /= j2;
        }
        if (z) {
            bArr[i3 - 1] = (byte) 45;
        }
        m.f4201c += i2;
        this.f4123c += (long) i2;
        return this;
    }

    /* renamed from: q */
    public bwl mo3879r(long j) {
        if (j == 0) {
            return mo3833d(48);
        }
        int numberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j)) / 4) + 1;
        bxm m = mo3868m(numberOfTrailingZeros);
        byte[] bArr = m.f4199a;
        int i = m.f4201c;
        for (int i2 = (m.f4201c + numberOfTrailingZeros) - 1; i2 >= i; i2--) {
            bArr[i2] = f4121d[(int) (15 & j)];
            j >>>= 4;
        }
        m.f4201c += numberOfTrailingZeros;
        this.f4123c += (long) numberOfTrailingZeros;
        return this;
    }

    /* renamed from: m */
    public final bxm mo3868m(int i) {
        boolean z = true;
        if (i < 1 || i > 8192) {
            z = false;
        }
        if (z) {
            bxm bxm = this.f4122a;
            if (bxm == null) {
                bxm a = bxn.m10449a();
                this.f4122a = a;
                a.f4205g = a;
                a.f4204f = a;
                return a;
            }
            if (bxm == null) {
                bfq.m6538a();
            }
            bxm bxm2 = bxm.f4205g;
            if (bxm2 == null) {
                bfq.m6538a();
            }
            return (bxm2.f4201c + i > 8192 || !bxm2.f4203e) ? bxm2.mo4061a(bxn.m10449a()) : bxm2;
        }
        throw new IllegalArgumentException("unexpected capacity".toString());
    }

    public void write(bwl bwl, long j) {
        bxm bxm;
        bfq.m6567f(bwl, JsonKeyConstants.SOURCE);
        if (bwl != this) {
            bwg.m9952a(bwl.f4123c, 0, j);
            while (j > 0) {
                bxm bxm2 = bwl.f4122a;
                if (bxm2 == null) {
                    bfq.m6538a();
                }
                int i = bxm2.f4201c;
                bxm bxm3 = bwl.f4122a;
                if (bxm3 == null) {
                    bfq.m6538a();
                }
                if (j < ((long) (i - bxm3.f4200b))) {
                    bxm bxm4 = this.f4122a;
                    if (bxm4 != null) {
                        if (bxm4 == null) {
                            bfq.m6538a();
                        }
                        bxm = bxm4.f4205g;
                    } else {
                        bxm = null;
                    }
                    if (bxm != null && bxm.f4203e) {
                        if ((((long) bxm.f4201c) + j) - ((long) (bxm.f4202d ? 0 : bxm.f4200b)) <= ((long) 8192)) {
                            bxm bxm5 = bwl.f4122a;
                            if (bxm5 == null) {
                                bfq.m6538a();
                            }
                            bxm5.mo4062a(bxm, (int) j);
                            bwl.f4123c -= j;
                            this.f4123c += j;
                            return;
                        }
                    }
                    bxm bxm6 = bwl.f4122a;
                    if (bxm6 == null) {
                        bfq.m6538a();
                    }
                    bwl.f4122a = bxm6.mo4060a((int) j);
                }
                bxm bxm7 = bwl.f4122a;
                if (bxm7 == null) {
                    bfq.m6538a();
                }
                long j2 = (long) (bxm7.f4201c - bxm7.f4200b);
                bwl.f4122a = bxm7.mo4064c();
                bxm bxm8 = this.f4122a;
                if (bxm8 == null) {
                    this.f4122a = bxm7;
                    bxm7.f4205g = bxm7;
                    bxm7.f4204f = bxm7.f4205g;
                } else {
                    if (bxm8 == null) {
                        bfq.m6538a();
                    }
                    bxm bxm9 = bxm8.f4205g;
                    if (bxm9 == null) {
                        bfq.m6538a();
                    }
                    bxm9.mo4061a(bxm7).mo4065d();
                }
                bwl.f4123c -= j2;
                this.f4123c += j2;
                j -= j2;
            }
            return;
        }
        throw new IllegalArgumentException("source == this".toString());
    }

    /* renamed from: a */
    public long mo3425a(bwl bwl, long j) {
        bfq.m6567f(bwl, "sink");
        if (j >= 0) {
            long j2 = this.f4123c;
            if (j2 == 0) {
                return -1;
            }
            if (j > j2) {
                j = j2;
            }
            bwl.write(this, j);
            return j;
        }
        throw new IllegalArgumentException(("byteCount < 0: " + j).toString());
    }

    /* renamed from: a */
    public long mo3784a(byte b) {
        return mo3786a(b, 0, (long) bfu.f2629b);
    }

    /* renamed from: a */
    private final <T> T m9989a(long j, bdw<? super bxm, ? super Long, ? extends T> bdw) {
        bxm bxm = this.f4122a;
        if (bxm == null) {
            return bdw.mo2065a(null, -1L);
        }
        if (mo3783a() - j < j) {
            long a = mo3783a();
            while (a > j) {
                bxm = bxm.f4205g;
                if (bxm == null) {
                    bfq.m6538a();
                }
                a -= (long) (bxm.f4201c - bxm.f4200b);
            }
            return bdw.mo2065a(bxm, Long.valueOf(a));
        }
        long j2 = 0;
        while (true) {
            long j3 = ((long) (bxm.f4201c - bxm.f4200b)) + j2;
            if (j3 > j) {
                return bdw.mo2065a(bxm, Long.valueOf(j2));
            }
            bxm = bxm.f4204f;
            if (bxm == null) {
                bfq.m6538a();
            }
            j2 = j3;
        }
    }

    /* renamed from: a */
    public long mo3785a(byte b, long j) {
        return mo3786a(b, j, (long) bfu.f2629b);
    }

    /* renamed from: a */
    public long mo3786a(byte b, long j, long j2) {
        long j3;
        int i;
        long j4 = 0;
        if (0 <= j && j2 >= j) {
            long j5 = this.f4123c;
            if (j2 > j5) {
                j2 = j5;
            }
            if (j == j2) {
                return -1;
            }
            bxm bxm = this.f4122a;
            if (bxm != null) {
                if (mo3783a() - j < j) {
                    j3 = mo3783a();
                    while (j3 > j) {
                        bxm = bxm.f4205g;
                        if (bxm == null) {
                            bfq.m6538a();
                        }
                        j3 -= (long) (bxm.f4201c - bxm.f4200b);
                    }
                    if (bxm != null) {
                        while (j3 < j2) {
                            byte[] bArr = bxm.f4199a;
                            int min = (int) Math.min((long) bxm.f4201c, (((long) bxm.f4200b) + j2) - j3);
                            i = (int) ((((long) bxm.f4200b) + j) - j3);
                            while (i < min) {
                                if (bArr[i] != b) {
                                    i++;
                                }
                            }
                            j3 += (long) (bxm.f4201c - bxm.f4200b);
                            bxm = bxm.f4204f;
                            if (bxm == null) {
                                bfq.m6538a();
                            }
                            j = j3;
                        }
                    }
                    return -1;
                }
                while (true) {
                    long j6 = ((long) (bxm.f4201c - bxm.f4200b)) + j4;
                    if (j6 > j) {
                        break;
                    }
                    bxm = bxm.f4204f;
                    if (bxm == null) {
                        bfq.m6538a();
                    }
                    j4 = j6;
                }
                if (bxm != null) {
                    while (j3 < j2) {
                        byte[] bArr2 = bxm.f4199a;
                        int min2 = (int) Math.min((long) bxm.f4201c, (((long) bxm.f4200b) + j2) - j3);
                        int i2 = (int) ((((long) bxm.f4200b) + j) - j3);
                        while (i < min2) {
                            if (bArr2[i] != b) {
                                i2 = i + 1;
                            }
                        }
                        j4 = j3 + ((long) (bxm.f4201c - bxm.f4200b));
                        bxm = bxm.f4204f;
                        if (bxm == null) {
                            bfq.m6538a();
                        }
                        j = j4;
                    }
                }
                return -1;
                return ((long) (i - bxm.f4200b)) + j3;
            }
            bxm bxm2 = null;
            return -1;
        }
        throw new IllegalArgumentException(("size=" + this.f4123c + " fromIndex=" + j + " toIndex=" + j2).toString());
    }

    /* renamed from: c */
    public long mo3824c(bwq bwq) {
        bfq.m6567f(bwq, "bytes");
        return mo3787a(bwq, 0);
    }

    /* renamed from: a */
    public long mo3787a(bwq bwq, long j) {
        int i;
        bwl bwl = this;
        bwq bwq2 = bwq;
        long j2 = j;
        bfq.m6567f(bwq2, "bytes");
        boolean z = true;
        if (bwq.mo3951n() > 0) {
            long j3 = 0;
            if (j2 < 0) {
                z = false;
            }
            if (z) {
                bxm bxm = bwl.f4122a;
                if (bxm == null) {
                    bxm bxm2 = null;
                    return -1;
                } else if (mo3783a() - j2 < j2) {
                    long a = mo3783a();
                    while (a > j2) {
                        bxm = bxm.f4205g;
                        if (bxm == null) {
                            bfq.m6538a();
                        }
                        a -= (long) (bxm.f4201c - bxm.f4200b);
                    }
                    if (bxm == null) {
                        return -1;
                    }
                    byte d = bwq2.mo3931d(0);
                    int n = bwq.mo3951n();
                    long j4 = (bwl.f4123c - ((long) n)) + 1;
                    bxm bxm3 = bxm;
                    long j5 = a;
                    while (j5 < j4) {
                        byte[] bArr = bxm3.f4199a;
                        long j6 = j4;
                        int min = (int) Math.min((long) bxm3.f4201c, (((long) bxm3.f4200b) + j4) - j5);
                        for (int i2 = (int) ((((long) bxm3.f4200b) + j2) - j5); i2 < min; i2++) {
                            if (bArr[i2] == d) {
                                if (m9991a(bxm3, i2 + 1, bwq.mo3954q(), 1, n)) {
                                    return ((long) (i2 - bxm3.f4200b)) + j5;
                                }
                            }
                        }
                        j5 += (long) (bxm3.f4201c - bxm3.f4200b);
                        bxm3 = bxm3.f4204f;
                        if (bxm3 == null) {
                            bfq.m6538a();
                        }
                        j2 = j5;
                        j4 = j6;
                    }
                    return -1;
                } else {
                    while (true) {
                        long j7 = ((long) (bxm.f4201c - bxm.f4200b)) + j3;
                        if (j7 > j2) {
                            break;
                        }
                        bxm = bxm.f4204f;
                        if (bxm == null) {
                            bfq.m6538a();
                        }
                        bwl = this;
                        j3 = j7;
                    }
                    if (bxm == null) {
                        return -1;
                    }
                    byte d2 = bwq2.mo3931d(0);
                    int n2 = bwq.mo3951n();
                    long j8 = 1 + (bwl.f4123c - ((long) n2));
                    long j9 = j3;
                    bxm bxm4 = bxm;
                    while (j9 < j8) {
                        byte[] bArr2 = bxm4.f4199a;
                        int min2 = (int) Math.min((long) bxm4.f4201c, (((long) bxm4.f4200b) + j8) - j9);
                        int i3 = (int) ((((long) bxm4.f4200b) + j2) - j9);
                        while (i3 < min2) {
                            if (bArr2[i3] == d2) {
                                i = i3;
                                if (m9991a(bxm4, i3 + 1, bwq.mo3954q(), 1, n2)) {
                                    return ((long) (i - bxm4.f4200b)) + j9;
                                }
                            } else {
                                i = i3;
                            }
                            i3 = i + 1;
                        }
                        j9 += (long) (bxm4.f4201c - bxm4.f4200b);
                        bxm4 = bxm4.f4204f;
                        if (bxm4 == null) {
                            bfq.m6538a();
                        }
                        j2 = j9;
                    }
                    return -1;
                }
            } else {
                throw new IllegalArgumentException(("fromIndex < 0: " + j2).toString());
            }
        } else {
            throw new IllegalArgumentException("bytes is empty".toString());
        }
    }

    /* renamed from: d */
    public long mo3832d(bwq bwq) {
        bfq.m6567f(bwq, "targetBytes");
        return mo3809b(bwq, 0);
    }

    /* renamed from: a */
    public boolean mo3807a(long j, bwq bwq) {
        bfq.m6567f(bwq, "bytes");
        return mo3808a(j, bwq, 0, bwq.mo3951n());
    }

    /* renamed from: a */
    public boolean mo3808a(long j, bwq bwq, int i, int i2) {
        bfq.m6567f(bwq, "bytes");
        if (j < 0 || i < 0 || i2 < 0 || this.f4123c - j < ((long) i2) || bwq.mo3951n() - i < i2) {
            return false;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            if (mo3831d(((long) i3) + j) != bwq.mo3931d(i + i3)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    private final boolean m9991a(bxm bxm, int i, byte[] bArr, int i2, int i3) {
        int i4 = bxm.f4201c;
        byte[] bArr2 = bxm.f4199a;
        while (i2 < i3) {
            if (i == i4) {
                bxm = bxm.f4204f;
                if (bxm == null) {
                    bfq.m6538a();
                }
                byte[] bArr3 = bxm.f4199a;
                int i5 = bxm.f4200b;
                bArr2 = bArr3;
                i = i5;
                i4 = bxm.f4201c;
            }
            if (bArr2[i] != bArr[i2]) {
                return false;
            }
            i++;
            i2++;
        }
        return true;
    }

    public bxs timeout() {
        return bxs.f4214c;
    }

    /* renamed from: C */
    public final bwq mo3770C() {
        return m9993c("MD5");
    }

    /* renamed from: D */
    public final bwq mo3771D() {
        return m9993c("SHA-1");
    }

    /* renamed from: E */
    public final bwq mo3772E() {
        return m9993c("SHA-256");
    }

    /* renamed from: F */
    public final bwq mo3773F() {
        return m9993c("SHA-512");
    }

    /* renamed from: c */
    private final bwq m9993c(String str) {
        MessageDigest instance = MessageDigest.getInstance(str);
        bxm bxm = this.f4122a;
        if (bxm != null) {
            instance.update(bxm.f4199a, bxm.f4200b, bxm.f4201c - bxm.f4200b);
            bxm bxm2 = bxm.f4204f;
            if (bxm2 == null) {
                bfq.m6538a();
            }
            while (bxm2 != bxm) {
                instance.update(bxm2.f4199a, bxm2.f4200b, bxm2.f4201c - bxm2.f4200b);
                bxm2 = bxm2.f4204f;
                if (bxm2 == null) {
                    bfq.m6538a();
                }
            }
        }
        byte[] digest = instance.digest();
        bfq.m6554b(digest, "messageDigest.digest()");
        return new bwq(digest);
    }

    /* renamed from: e */
    public final bwq mo3839e(bwq bwq) {
        bfq.m6567f(bwq, "key");
        return m9988a("HmacSHA1", bwq);
    }

    /* renamed from: f */
    public final bwq mo3843f(bwq bwq) {
        bfq.m6567f(bwq, "key");
        return m9988a("HmacSHA256", bwq);
    }

    /* renamed from: g */
    public final bwq mo3847g(bwq bwq) {
        bfq.m6567f(bwq, "key");
        return m9988a("HmacSHA512", bwq);
    }

    /* renamed from: a */
    private final bwq m9988a(String str, bwq bwq) {
        try {
            Mac instance = Mac.getInstance(str);
            instance.init(new SecretKeySpec(bwq.mo3954q(), str));
            bxm bxm = this.f4122a;
            if (bxm != null) {
                instance.update(bxm.f4199a, bxm.f4200b, bxm.f4201c - bxm.f4200b);
                bxm bxm2 = bxm.f4204f;
                if (bxm2 == null) {
                    bfq.m6538a();
                }
                while (bxm2 != bxm) {
                    instance.update(bxm2.f4199a, bxm2.f4200b, bxm2.f4201c - bxm2.f4200b);
                    bxm2 = bxm2.f4204f;
                    if (bxm2 == null) {
                        bfq.m6538a();
                    }
                }
            }
            byte[] doFinal = instance.doFinal();
            bfq.m6554b(doFinal, "mac.doFinal()");
            return new bwq(doFinal);
        } catch (InvalidKeyException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public boolean equals(Object obj) {
        Object obj2 = obj;
        if (this == obj2) {
            return true;
        }
        if (!(obj2 instanceof bwl)) {
            return false;
        }
        long j = this.f4123c;
        bwl bwl = (bwl) obj2;
        if (j != bwl.f4123c) {
            return false;
        }
        if (j == 0) {
            return true;
        }
        bxm bxm = this.f4122a;
        if (bxm == null) {
            bfq.m6538a();
        }
        bxm bxm2 = bwl.f4122a;
        if (bxm2 == null) {
            bfq.m6538a();
        }
        int i = bxm.f4200b;
        int i2 = bxm2.f4200b;
        long j2 = 0;
        while (j2 < this.f4123c) {
            long min = (long) Math.min(bxm.f4201c - i, bxm2.f4201c - i2);
            long j3 = 0;
            while (j3 < min) {
                int i3 = i + 1;
                int i4 = i2 + 1;
                if (bxm.f4199a[i] != bxm2.f4199a[i2]) {
                    return false;
                }
                j3++;
                i = i3;
                i2 = i4;
            }
            if (i == bxm.f4201c) {
                bxm = bxm.f4204f;
                if (bxm == null) {
                    bfq.m6538a();
                }
                i = bxm.f4200b;
            }
            if (i2 == bxm2.f4201c) {
                bxm2 = bxm2.f4204f;
                if (bxm2 == null) {
                    bfq.m6538a();
                }
                i2 = bxm2.f4200b;
            }
            j2 += min;
        }
        return true;
    }

    public int hashCode() {
        bxm bxm = this.f4122a;
        if (bxm == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = bxm.f4201c;
            for (int i3 = bxm.f4200b; i3 < i2; i3++) {
                i = (i * 31) + bxm.f4199a[i3];
            }
            bxm = bxm.f4204f;
            if (bxm == null) {
                bfq.m6538a();
            }
        } while (bxm != this.f4122a);
        return i;
    }

    public String toString() {
        return mo3775H().toString();
    }

    /* renamed from: G */
    public bwl clone() {
        bwl bwl = new bwl();
        if (this.f4123c == 0) {
            return bwl;
        }
        bxm bxm = this.f4122a;
        if (bxm == null) {
            bfq.m6538a();
        }
        bxm a = bxm.mo4059a();
        bwl.f4122a = a;
        if (a == null) {
            bfq.m6538a();
        }
        a.f4205g = bwl.f4122a;
        bxm bxm2 = bwl.f4122a;
        if (bxm2 == null) {
            bfq.m6538a();
        }
        bxm bxm3 = bwl.f4122a;
        if (bxm3 == null) {
            bfq.m6538a();
        }
        bxm2.f4204f = bxm3.f4205g;
        bxm bxm4 = this.f4122a;
        if (bxm4 == null) {
            bfq.m6538a();
        }
        for (bxm bxm5 = bxm4.f4204f; bxm5 != this.f4122a; bxm5 = bxm5.f4204f) {
            bxm bxm6 = bwl.f4122a;
            if (bxm6 == null) {
                bfq.m6538a();
            }
            bxm bxm7 = bxm6.f4205g;
            if (bxm7 == null) {
                bfq.m6538a();
            }
            if (bxm5 == null) {
                bfq.m6538a();
            }
            bxm7.mo4061a(bxm5.mo4059a());
        }
        bwl.f4123c = this.f4123c;
        return bwl;
    }

    /* renamed from: H */
    public final bwq mo3775H() {
        long j = this.f4123c;
        if (j <= ((long) Integer.MAX_VALUE)) {
            return mo3870n((int) j);
        }
        throw new IllegalStateException(("size > Integer.MAX_VALUE: " + this.f4123c).toString());
    }

    /* renamed from: n */
    public final bwq mo3870n(int i) {
        return i == 0 ? bwq.f4133a : new bxo(this, i);
    }

    /* renamed from: a */
    public static /* synthetic */ C0276b m9984a(bwl bwl, C0276b bVar, int i, Object obj) {
        if ((i & 1) != 0) {
            bVar = new C0276b();
        }
        return bwl.mo3790a(bVar);
    }

    /* renamed from: a */
    public final C0276b mo3790a(C0276b bVar) {
        bfq.m6567f(bVar, "unsafeCursor");
        if (bVar.f4124a == null) {
            bVar.f4124a = this;
            bVar.f4125b = false;
            return bVar;
        }
        throw new IllegalStateException("already attached to a buffer".toString());
    }

    /* renamed from: b */
    public static /* synthetic */ C0276b m9992b(bwl bwl, C0276b bVar, int i, Object obj) {
        if ((i & 1) != 0) {
            bVar = new C0276b();
        }
        return bwl.mo3810b(bVar);
    }

    /* renamed from: b */
    public final C0276b mo3810b(C0276b bVar) {
        bfq.m6567f(bVar, "unsafeCursor");
        if (bVar.f4124a == null) {
            bVar.f4124a = this;
            bVar.f4125b = true;
            return bVar;
        }
        throw new IllegalStateException("already attached to a buffer".toString());
    }

    @anx(mo1516a = "moved to operator function", mo1517b = @C0081api(mo1552a = "this[index]", mo1553b = {}), mo1518c = any.ERROR)
    /* renamed from: s */
    public final byte mo3881s(long j) {
        return mo3831d(j);
    }

    @anx(mo1516a = "moved to val", mo1517b = @C0081api(mo1552a = "size", mo1553b = {}), mo1518c = any.ERROR)
    /* renamed from: K */
    public final long mo3778K() {
        return this.f4123c;
    }

    @aot(mo1534a = 1, mo1535b = {1, 1, 11}, mo1536c = {1, 0, 2}, mo1537d = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u000e\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\bJ\u0006\u0010\u0014\u001a\u00020\bJ\u000e\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\nJ\u000e\u0010\u0017\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\n8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00020\b8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, mo1538e = {"Lokio/Buffer$UnsafeCursor;", "Ljava/io/Closeable;", "()V", "buffer", "Lokio/Buffer;", "data", "", "end", "", "offset", "", "readWrite", "", "segment", "Lokio/Segment;", "start", "close", "", "expandBuffer", "minByteCount", "next", "resizeBuffer", "newSize", "seek", "jvm"})
    /* renamed from: atakplugin.UASTool.bwl$b */
    public static final class C0276b implements Closeable {

        /* renamed from: a */
        public bwl f4124a;

        /* renamed from: b */
        public boolean f4125b;

        /* renamed from: c */
        public long f4126c = -1;

        /* renamed from: d */
        public byte[] f4127d;

        /* renamed from: e */
        public int f4128e = -1;

        /* renamed from: f */
        public int f4129f = -1;

        /* renamed from: g */
        private bxm f4130g;

        /* renamed from: a */
        public final int mo3892a() {
            long j = this.f4126c;
            bwl bwl = this.f4124a;
            if (bwl == null) {
                bfq.m6538a();
            }
            if (j != bwl.mo3783a()) {
                long j2 = this.f4126c;
                return mo3893a(j2 == -1 ? 0 : j2 + ((long) (this.f4129f - this.f4128e)));
            }
            throw new IllegalStateException("no more bytes".toString());
        }

        /* renamed from: a */
        public final int mo3893a(long j) {
            bwl bwl = this.f4124a;
            if (bwl == null) {
                throw new IllegalStateException("not attached to a buffer".toString());
            } else if (j < ((long) -1) || j > bwl.mo3783a()) {
                bgu bgu = bgu.f2681a;
                String format = String.format("offset=%s > size=%s", Arrays.copyOf(new Object[]{Long.valueOf(j), Long.valueOf(bwl.mo3783a())}, 2));
                bfq.m6554b(format, "java.lang.String.format(format, *args)");
                throw new ArrayIndexOutOfBoundsException(format);
            } else if (j == -1 || j == bwl.mo3783a()) {
                this.f4130g = null;
                this.f4126c = j;
                this.f4127d = null;
                this.f4128e = -1;
                this.f4129f = -1;
                return -1;
            } else {
                long j2 = 0;
                long a = bwl.mo3783a();
                bxm bxm = bwl.f4122a;
                bxm bxm2 = bwl.f4122a;
                bxm bxm3 = this.f4130g;
                if (bxm3 != null) {
                    long j3 = this.f4126c;
                    int i = this.f4128e;
                    if (bxm3 == null) {
                        bfq.m6538a();
                    }
                    long j4 = j3 - ((long) (i - bxm3.f4200b));
                    if (j4 > j) {
                        bxm2 = this.f4130g;
                        a = j4;
                    } else {
                        bxm = this.f4130g;
                        j2 = j4;
                    }
                }
                if (a - j > j - j2) {
                    while (true) {
                        if (bxm == null) {
                            bfq.m6538a();
                        }
                        if (j < ((long) (bxm.f4201c - bxm.f4200b)) + j2) {
                            break;
                        }
                        j2 += (long) (bxm.f4201c - bxm.f4200b);
                        bxm = bxm.f4204f;
                    }
                } else {
                    while (a > j) {
                        if (bxm2 == null) {
                            bfq.m6538a();
                        }
                        bxm2 = bxm2.f4205g;
                        if (bxm2 == null) {
                            bfq.m6538a();
                        }
                        a -= (long) (bxm2.f4201c - bxm2.f4200b);
                    }
                    j2 = a;
                    bxm = bxm2;
                }
                if (this.f4125b) {
                    if (bxm == null) {
                        bfq.m6538a();
                    }
                    if (bxm.f4202d) {
                        bxm b = bxm.mo4063b();
                        if (bwl.f4122a == bxm) {
                            bwl.f4122a = b;
                        }
                        bxm = bxm.mo4061a(b);
                        bxm bxm4 = bxm.f4205g;
                        if (bxm4 == null) {
                            bfq.m6538a();
                        }
                        bxm4.mo4064c();
                    }
                }
                this.f4130g = bxm;
                this.f4126c = j;
                if (bxm == null) {
                    bfq.m6538a();
                }
                this.f4127d = bxm.f4199a;
                this.f4128e = bxm.f4200b + ((int) (j - j2));
                int i2 = bxm.f4201c;
                this.f4129f = i2;
                return i2 - this.f4128e;
            }
        }

        /* renamed from: b */
        public final long mo3895b(long j) {
            long j2 = j;
            bwl bwl = this.f4124a;
            if (bwl == null) {
                throw new IllegalStateException("not attached to a buffer".toString());
            } else if (this.f4125b) {
                long a = bwl.mo3783a();
                int i = 1;
                int i2 = (j2 > a ? 1 : (j2 == a ? 0 : -1));
                if (i2 <= 0) {
                    if (j2 >= 0) {
                        long j3 = a - j2;
                        while (true) {
                            if (j3 > 0) {
                                bxm bxm = bwl.f4122a;
                                if (bxm == null) {
                                    bfq.m6538a();
                                }
                                bxm bxm2 = bxm.f4205g;
                                if (bxm2 == null) {
                                    bfq.m6538a();
                                }
                                long j4 = (long) (bxm2.f4201c - bxm2.f4200b);
                                if (j4 > j3) {
                                    bxm2.f4201c -= (int) j3;
                                    break;
                                }
                                bwl.f4122a = bxm2.mo4064c();
                                bxn.m10450a(bxm2);
                                j3 -= j4;
                            } else {
                                break;
                            }
                        }
                        this.f4130g = null;
                        this.f4126c = j2;
                        this.f4127d = null;
                        this.f4128e = -1;
                        this.f4129f = -1;
                    } else {
                        throw new IllegalArgumentException(("newSize < 0: " + j2).toString());
                    }
                } else if (i2 > 0) {
                    long j5 = j2 - a;
                    boolean z = true;
                    while (j5 > 0) {
                        bxm m = bwl.mo3868m(i);
                        int min = (int) Math.min(j5, (long) (8192 - m.f4201c));
                        m.f4201c += min;
                        j5 -= (long) min;
                        if (z) {
                            this.f4130g = m;
                            this.f4126c = a;
                            this.f4127d = m.f4199a;
                            this.f4128e = m.f4201c - min;
                            this.f4129f = m.f4201c;
                            z = false;
                        }
                        i = 1;
                    }
                }
                bwl.mo3806a(j2);
                return a;
            } else {
                throw new IllegalStateException("resizeBuffer() only permitted for read/write buffers".toString());
            }
        }

        /* renamed from: a */
        public final long mo3894a(int i) {
            boolean z = true;
            if (i > 0) {
                if (i > 8192) {
                    z = false;
                }
                if (z) {
                    bwl bwl = this.f4124a;
                    if (bwl == null) {
                        throw new IllegalStateException("not attached to a buffer".toString());
                    } else if (this.f4125b) {
                        long a = bwl.mo3783a();
                        bxm m = bwl.mo3868m(i);
                        int i2 = 8192 - m.f4201c;
                        m.f4201c = 8192;
                        long j = (long) i2;
                        bwl.mo3806a(a + j);
                        this.f4130g = m;
                        this.f4126c = a;
                        this.f4127d = m.f4199a;
                        this.f4128e = 8192 - i2;
                        this.f4129f = 8192;
                        return j;
                    } else {
                        throw new IllegalStateException("expandBuffer() only permitted for read/write buffers".toString());
                    }
                } else {
                    throw new IllegalArgumentException(("minByteCount > Segment.SIZE: " + i).toString());
                }
            } else {
                throw new IllegalArgumentException(("minByteCount <= 0: " + i).toString());
            }
        }

        public void close() {
            if (this.f4124a != null) {
                this.f4124a = null;
                this.f4130g = null;
                this.f4126c = -1;
                this.f4127d = null;
                this.f4128e = -1;
                this.f4129f = -1;
                return;
            }
            throw new IllegalStateException("not attached to a buffer".toString());
        }
    }

    @aot(mo1534a = 1, mo1535b = {1, 1, 11}, mo1536c = {1, 0, 2}, mo1537d = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo1538e = {"Lokio/Buffer$Companion;", "", "()V", "DIGITS", "", "jvm"})
    /* renamed from: atakplugin.UASTool.bwl$a */
    public static final class C0275a {
        private C0275a() {
        }

        public /* synthetic */ C0275a(bfd bfd) {
            this();
        }
    }

    static {
        byte[] bytes = "0123456789abcdef".getBytes(bnh.f2996a);
        bfq.m6554b(bytes, "(this as java.lang.String).getBytes(charset)");
        f4121d = bytes;
    }

    /* renamed from: b */
    public long mo3809b(bwq bwq, long j) {
        long j2;
        int i;
        int i2;
        int i3;
        bfq.m6567f(bwq, "targetBytes");
        long j3 = 0;
        if (j >= 0) {
            bxm bxm = this.f4122a;
            if (bxm != null) {
                if (mo3783a() - j < j) {
                    j2 = mo3783a();
                    while (j2 > j) {
                        bxm = bxm.f4205g;
                        if (bxm == null) {
                            bfq.m6538a();
                        }
                        j2 -= (long) (bxm.f4201c - bxm.f4200b);
                    }
                    if (bxm != null) {
                        if (bwq.mo3951n() == 2) {
                            byte d = bwq.mo3931d(0);
                            byte d2 = bwq.mo3931d(1);
                            while (j2 < this.f4123c) {
                                byte[] bArr = bxm.f4199a;
                                i2 = (int) ((((long) bxm.f4200b) + j) - j2);
                                int i4 = bxm.f4201c;
                                while (i2 < i4) {
                                    byte b = bArr[i2];
                                    if (!(b == d || b == d2)) {
                                        i2++;
                                    }
                                }
                                j2 += (long) (bxm.f4201c - bxm.f4200b);
                                bxm = bxm.f4204f;
                                if (bxm == null) {
                                    bfq.m6538a();
                                }
                                j = j2;
                            }
                        } else {
                            byte[] q = bwq.mo3954q();
                            while (j2 < this.f4123c) {
                                byte[] bArr2 = bxm.f4199a;
                                i = (int) ((((long) bxm.f4200b) + j) - j2);
                                int i5 = bxm.f4201c;
                                while (i < i5) {
                                    byte b2 = bArr2[i];
                                    for (byte b3 : q) {
                                        if (b2 == b3) {
                                            i3 = bxm.f4200b;
                                            return ((long) (i2 - i3)) + j2;
                                        }
                                    }
                                    i++;
                                }
                                j2 += (long) (bxm.f4201c - bxm.f4200b);
                                bxm = bxm.f4204f;
                                if (bxm == null) {
                                    bfq.m6538a();
                                }
                                j = j2;
                            }
                        }
                    }
                    return -1;
                }
                while (true) {
                    long j4 = ((long) (bxm.f4201c - bxm.f4200b)) + j3;
                    if (j4 > j) {
                        break;
                    }
                    bxm = bxm.f4204f;
                    if (bxm == null) {
                        bfq.m6538a();
                    }
                    j3 = j4;
                }
                if (bxm != null) {
                    if (bwq.mo3951n() == 2) {
                        byte d3 = bwq.mo3931d(0);
                        byte d4 = bwq.mo3931d(1);
                        while (j2 < this.f4123c) {
                            byte[] bArr3 = bxm.f4199a;
                            int i6 = (int) ((((long) bxm.f4200b) + j) - j2);
                            int i7 = bxm.f4201c;
                            while (i2 < i7) {
                                byte b4 = bArr3[i2];
                                if (!(b4 == d3 || b4 == d4)) {
                                    i6 = i2 + 1;
                                }
                            }
                            j3 = j2 + ((long) (bxm.f4201c - bxm.f4200b));
                            bxm = bxm.f4204f;
                            if (bxm == null) {
                                bfq.m6538a();
                            }
                            j = j3;
                        }
                    } else {
                        byte[] q2 = bwq.mo3954q();
                        while (j2 < this.f4123c) {
                            byte[] bArr4 = bxm.f4199a;
                            int i8 = (int) ((((long) bxm.f4200b) + j) - j2);
                            int i9 = bxm.f4201c;
                            while (i < i9) {
                                byte b5 = bArr4[i];
                                for (byte b6 : q2) {
                                    if (b5 == b6) {
                                        i3 = bxm.f4200b;
                                        return ((long) (i2 - i3)) + j2;
                                    }
                                }
                                i8 = i + 1;
                            }
                            j3 = j2 + ((long) (bxm.f4201c - bxm.f4200b));
                            bxm = bxm.f4204f;
                            if (bxm == null) {
                                bfq.m6538a();
                            }
                            j = j3;
                        }
                    }
                }
                return -1;
                i3 = bxm.f4200b;
                return ((long) (i2 - i3)) + j2;
            }
            bxm bxm2 = null;
            return -1;
        }
        throw new IllegalArgumentException(("fromIndex < 0: " + j).toString());
    }
}
