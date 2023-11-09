package atakplugin.UASTool;

import java.io.InputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;

@aot(mo1534a = 2, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\u0010\u0005\n\u0002\u0010\f\n\u0002\u0010\u0019\n\u0002\u0010\u0006\n\u0002\u0010\u0007\n\u0002\u0010\t\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\b\u001a\u0011\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\rH\b\u001a\u0011\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000eH\b\u001a\u0011\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000fH\b\u001a\u0011\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0010H\b\u001a\u0011\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0011H\b\u001a\u0011\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0012H\b\u001a\u0011\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0001H\b\u001a\u0011\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0013H\b\u001a\u0011\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0014H\b\u001a\t\u0010\u0015\u001a\u00020\nH\b\u001a\u0013\u0010\u0015\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\b\u001a\u0011\u0010\u0015\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\rH\b\u001a\u0011\u0010\u0015\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000eH\b\u001a\u0011\u0010\u0015\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000fH\b\u001a\u0011\u0010\u0015\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0010H\b\u001a\u0011\u0010\u0015\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0011H\b\u001a\u0011\u0010\u0015\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0012H\b\u001a\u0011\u0010\u0015\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0001H\b\u001a\u0011\u0010\u0015\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0013H\b\u001a\u0011\u0010\u0015\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0014H\b\u001a\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u001a\u001a\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0003\u001a\u00020\u0004H\u0000\u001a\f\u0010\u001a\u001a\u00020\r*\u00020\u001bH\u0002\u001a\f\u0010\u001c\u001a\u00020\n*\u00020\u001dH\u0002\u001a\u0018\u0010\u001e\u001a\u00020\n*\u00020\u001b2\n\u0010\u001f\u001a\u00060 j\u0002`!H\u0002\u001a$\u0010\"\u001a\u00020\r*\u00020\u00042\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u001b2\u0006\u0010&\u001a\u00020\rH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006'"}, mo1538e = {"BUFFER_SIZE", "", "LINE_SEPARATOR_MAX_LENGTH", "decoder", "Ljava/nio/charset/CharsetDecoder;", "getDecoder", "()Ljava/nio/charset/CharsetDecoder;", "decoder$delegate", "Lkotlin/Lazy;", "print", "", "message", "", "", "", "", "", "", "", "", "", "println", "readLine", "", "inputStream", "Ljava/io/InputStream;", "endsWithLineSeparator", "Ljava/nio/CharBuffer;", "flipBack", "Ljava/nio/Buffer;", "offloadPrefixTo", "builder", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "tryDecode", "byteBuffer", "Ljava/nio/ByteBuffer;", "charBuffer", "isEndOfStream", "kotlin-stdlib"})
public final class bbq {

    /* renamed from: a */
    static final /* synthetic */ bjr[] f2508a = {bgp.m6706a((bgi) new bgj(bgp.m6716b(bbq.class, "kotlin-stdlib"), "decoder", "getDecoder()Ljava/nio/charset/CharsetDecoder;"))};

    /* renamed from: b */
    private static final int f2509b = 32;

    /* renamed from: c */
    private static final int f2510c = 2;

    /* renamed from: d */
    private static final aon f2511d = aoo.m2492a(bbr.f2512a);

    /* renamed from: c */
    private static final CharsetDecoder m6246c() {
        aon aon = f2511d;
        bjr bjr = f2508a[0];
        return (CharsetDecoder) aon.mo1522b();
    }

    /* renamed from: a */
    private static final void m6227a(Object obj) {
        System.out.print(obj);
    }

    /* renamed from: a */
    private static final void m6225a(int i) {
        System.out.print(i);
    }

    /* renamed from: a */
    private static final void m6226a(long j) {
        System.out.print(j);
    }

    /* renamed from: a */
    private static final void m6221a(byte b) {
        System.out.print(Byte.valueOf(b));
    }

    /* renamed from: a */
    private static final void m6230a(short s) {
        System.out.print(Short.valueOf(s));
    }

    /* renamed from: a */
    private static final void m6222a(char c) {
        System.out.print(c);
    }

    /* renamed from: a */
    private static final void m6231a(boolean z) {
        System.out.print(z);
    }

    /* renamed from: a */
    private static final void m6224a(float f) {
        System.out.print(f);
    }

    /* renamed from: a */
    private static final void m6223a(double d) {
        System.out.print(d);
    }

    /* renamed from: a */
    private static final void m6232a(char[] cArr) {
        System.out.print(cArr);
    }

    /* renamed from: b */
    private static final void m6242b(Object obj) {
        System.out.println(obj);
    }

    /* renamed from: b */
    private static final void m6240b(int i) {
        System.out.println(i);
    }

    /* renamed from: b */
    private static final void m6241b(long j) {
        System.out.println(j);
    }

    /* renamed from: b */
    private static final void m6236b(byte b) {
        System.out.println(Byte.valueOf(b));
    }

    /* renamed from: b */
    private static final void m6243b(short s) {
        System.out.println(Short.valueOf(s));
    }

    /* renamed from: b */
    private static final void m6237b(char c) {
        System.out.println(c);
    }

    /* renamed from: b */
    private static final void m6244b(boolean z) {
        System.out.println(z);
    }

    /* renamed from: b */
    private static final void m6239b(float f) {
        System.out.println(f);
    }

    /* renamed from: b */
    private static final void m6238b(double d) {
        System.out.println(d);
    }

    /* renamed from: b */
    private static final void m6245b(char[] cArr) {
        System.out.println(cArr);
    }

    /* renamed from: b */
    private static final void m6235b() {
        System.out.println();
    }

    /* renamed from: a */
    public static final String m6219a() {
        InputStream inputStream = System.in;
        bfq.m6554b(inputStream, "System.`in`");
        return m6220a(inputStream, m6246c());
    }

    /* renamed from: a */
    public static final String m6220a(InputStream inputStream, CharsetDecoder charsetDecoder) {
        bfq.m6567f(inputStream, "inputStream");
        bfq.m6567f(charsetDecoder, "decoder");
        if (charsetDecoder.maxCharsPerByte() <= ((float) 1)) {
            ByteBuffer allocate = ByteBuffer.allocate(32);
            CharBuffer allocate2 = CharBuffer.allocate(4);
            StringBuilder sb = new StringBuilder();
            int read = inputStream.read();
            if (read == -1) {
                return null;
            }
            do {
                allocate.put((byte) read);
                bfq.m6554b(allocate, "byteBuffer");
                bfq.m6554b(allocate2, "charBuffer");
                if (m6234a(charsetDecoder, allocate, allocate2, false)) {
                    if (m6233a(allocate2)) {
                        break;
                    } else if (allocate2.remaining() < 2) {
                        m6229a(allocate2, sb);
                    }
                }
                read = inputStream.read();
            } while (read != -1);
            m6234a(charsetDecoder, allocate, allocate2, true);
            charsetDecoder.reset();
            int position = allocate2.position();
            if (position > 0 && allocate2.get(position - 1) == 10 && position - 1 > 0 && allocate2.get(position - 1) == 13) {
                position--;
            }
            allocate2.flip();
            for (int i = 0; i < position; i++) {
                sb.append(allocate2.get());
            }
            return sb.toString();
        }
        throw new IllegalArgumentException("Encodings with multiple chars per byte are not supported".toString());
    }

    /* renamed from: a */
    private static final boolean m6234a(CharsetDecoder charsetDecoder, ByteBuffer byteBuffer, CharBuffer charBuffer, boolean z) {
        int position = charBuffer.position();
        byteBuffer.flip();
        CoderResult decode = charsetDecoder.decode(byteBuffer, charBuffer, z);
        if (decode.isError()) {
            decode.throwException();
        }
        boolean z2 = charBuffer.position() > position;
        if (z2) {
            byteBuffer.clear();
        } else {
            m6228a((Buffer) byteBuffer);
        }
        return z2;
    }

    /* renamed from: a */
    private static final boolean m6233a(CharBuffer charBuffer) {
        int position = charBuffer.position();
        if (position <= 0 || charBuffer.get(position - 1) != 10) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    private static final void m6228a(Buffer buffer) {
        buffer.position(buffer.limit());
        buffer.limit(buffer.capacity());
    }

    /* renamed from: a */
    private static final void m6229a(CharBuffer charBuffer, StringBuilder sb) {
        charBuffer.flip();
        int limit = charBuffer.limit() - 1;
        for (int i = 0; i < limit; i++) {
            sb.append(charBuffer.get());
        }
        charBuffer.compact();
    }
}
