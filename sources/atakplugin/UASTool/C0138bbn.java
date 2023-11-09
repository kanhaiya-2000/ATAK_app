package atakplugin.UASTool;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.Charset;

@aot(mo1534a = 2, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000Z\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0017\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\b\u001a\u0017\u0010\u0000\u001a\u00020\u0005*\u00020\u00062\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\b\u001a\u0017\u0010\u0007\u001a\u00020\b*\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\nH\b\u001a\u0017\u0010\u000b\u001a\u00020\f*\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\nH\b\u001a\u0017\u0010\r\u001a\u00020\u000e*\u00020\u000f2\b\b\u0002\u0010\t\u001a\u00020\nH\b\u001a\u001c\u0010\u0010\u001a\u00020\u0011*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00062\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u001a\r\u0010\u0013\u001a\u00020\u000e*\u00020\u0014H\b\u001a\u001d\u0010\u0013\u001a\u00020\u000e*\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0004H\b\u001a\r\u0010\u0017\u001a\u00020\u0018*\u00020\u0001H\u0002\u001a\f\u0010\u0019\u001a\u00020\u0014*\u00020\u0002H\u0007\u001a\u0016\u0010\u0019\u001a\u00020\u0014*\u00020\u00022\b\b\u0002\u0010\u001a\u001a\u00020\u0004H\u0007\u001a\u0017\u0010\u001b\u001a\u00020\u001c*\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\nH\b\u001a\u0017\u0010\u001d\u001a\u00020\u001e*\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\nH\b¨\u0006\u001f"}, mo1538e = {"buffered", "Ljava/io/BufferedInputStream;", "Ljava/io/InputStream;", "bufferSize", "", "Ljava/io/BufferedOutputStream;", "Ljava/io/OutputStream;", "bufferedReader", "Ljava/io/BufferedReader;", "charset", "Ljava/nio/charset/Charset;", "bufferedWriter", "Ljava/io/BufferedWriter;", "byteInputStream", "Ljava/io/ByteArrayInputStream;", "", "copyTo", "", "out", "inputStream", "", "offset", "length", "iterator", "Lkotlin/collections/ByteIterator;", "readBytes", "estimatedSize", "reader", "Ljava/io/InputStreamReader;", "writer", "Ljava/io/OutputStreamWriter;", "kotlin-stdlib"})
/* renamed from: atakplugin.UASTool.bbn */
public final class C0138bbn {
    /* renamed from: a */
    public static final atm m6189a(BufferedInputStream bufferedInputStream) {
        bfq.m6567f(bufferedInputStream, "$this$iterator");
        return new bbo(bufferedInputStream);
    }

    /* renamed from: a */
    private static final ByteArrayInputStream m6193a(String str, Charset charset) {
        if (str != null) {
            byte[] bytes = str.getBytes(charset);
            bfq.m6554b(bytes, "(this as java.lang.String).getBytes(charset)");
            return new ByteArrayInputStream(bytes);
        }
        throw new apx("null cannot be cast to non-null type java.lang.String");
    }

    /* renamed from: a */
    static /* synthetic */ ByteArrayInputStream m6194a(String str, Charset charset, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = bnh.f2996a;
        }
        if (str != null) {
            byte[] bytes = str.getBytes(charset);
            bfq.m6554b(bytes, "(this as java.lang.String).getBytes(charset)");
            return new ByteArrayInputStream(bytes);
        }
        throw new apx("null cannot be cast to non-null type java.lang.String");
    }

    /* renamed from: a */
    private static final ByteArrayInputStream m6195a(byte[] bArr) {
        return new ByteArrayInputStream(bArr);
    }

    /* renamed from: a */
    private static final ByteArrayInputStream m6196a(byte[] bArr, int i, int i2) {
        return new ByteArrayInputStream(bArr, i, i2);
    }

    /* renamed from: b */
    private static final BufferedInputStream m6203b(InputStream inputStream, int i) {
        return inputStream instanceof BufferedInputStream ? (BufferedInputStream) inputStream : new BufferedInputStream(inputStream, i);
    }

    /* renamed from: a */
    private static final InputStreamReader m6197a(InputStream inputStream, Charset charset) {
        return new InputStreamReader(inputStream, charset);
    }

    /* renamed from: a */
    static /* synthetic */ InputStreamReader m6198a(InputStream inputStream, Charset charset, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = bnh.f2996a;
        }
        return new InputStreamReader(inputStream, charset);
    }

    /* renamed from: b */
    private static final BufferedReader m6204b(InputStream inputStream, Charset charset) {
        Reader inputStreamReader = new InputStreamReader(inputStream, charset);
        return inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
    }

    /* renamed from: b */
    static /* synthetic */ BufferedReader m6205b(InputStream inputStream, Charset charset, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = bnh.f2996a;
        }
        Reader inputStreamReader = new InputStreamReader(inputStream, charset);
        return inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
    }

    /* renamed from: a */
    private static final BufferedOutputStream m6191a(OutputStream outputStream, int i) {
        return outputStream instanceof BufferedOutputStream ? (BufferedOutputStream) outputStream : new BufferedOutputStream(outputStream, i);
    }

    /* renamed from: a */
    private static final OutputStreamWriter m6199a(OutputStream outputStream, Charset charset) {
        return new OutputStreamWriter(outputStream, charset);
    }

    /* renamed from: a */
    static /* synthetic */ OutputStreamWriter m6200a(OutputStream outputStream, Charset charset, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = bnh.f2996a;
        }
        return new OutputStreamWriter(outputStream, charset);
    }

    /* renamed from: b */
    private static final BufferedWriter m6206b(OutputStream outputStream, Charset charset) {
        Writer outputStreamWriter = new OutputStreamWriter(outputStream, charset);
        return outputStreamWriter instanceof BufferedWriter ? (BufferedWriter) outputStreamWriter : new BufferedWriter(outputStreamWriter, 8192);
    }

    /* renamed from: b */
    static /* synthetic */ BufferedWriter m6207b(OutputStream outputStream, Charset charset, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = bnh.f2996a;
        }
        Writer outputStreamWriter = new OutputStreamWriter(outputStream, charset);
        return outputStreamWriter instanceof BufferedWriter ? (BufferedWriter) outputStreamWriter : new BufferedWriter(outputStreamWriter, 8192);
    }

    /* renamed from: a */
    public static /* synthetic */ long m6188a(InputStream inputStream, OutputStream outputStream, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 8192;
        }
        return m6187a(inputStream, outputStream, i);
    }

    /* renamed from: a */
    public static final long m6187a(InputStream inputStream, OutputStream outputStream, int i) {
        bfq.m6567f(inputStream, "$this$copyTo");
        bfq.m6567f(outputStream, "out");
        byte[] bArr = new byte[i];
        int read = inputStream.read(bArr);
        long j = 0;
        while (read >= 0) {
            outputStream.write(bArr, 0, read);
            j += (long) read;
            read = inputStream.read(bArr);
        }
        return j;
    }

    /* renamed from: b */
    public static /* synthetic */ byte[] m6208b(InputStream inputStream, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 8192;
        }
        return m6202a(inputStream, i);
    }

    @anx(mo1516a = "Use readBytes() overload without estimatedSize parameter", mo1517b = @C0081api(mo1552a = "readBytes()", mo1553b = {}))
    /* renamed from: a */
    public static final byte[] m6202a(InputStream inputStream, int i) {
        bfq.m6567f(inputStream, "$this$readBytes");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(Math.max(i, inputStream.available()));
        m6188a(inputStream, byteArrayOutputStream, 0, 2, (Object) null);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        bfq.m6554b(byteArray, "buffer.toByteArray()");
        return byteArray;
    }

    /* renamed from: a */
    public static final byte[] m6201a(InputStream inputStream) {
        bfq.m6567f(inputStream, "$this$readBytes");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(Math.max(8192, inputStream.available()));
        m6188a(inputStream, byteArrayOutputStream, 0, 2, (Object) null);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        bfq.m6554b(byteArray, "buffer.toByteArray()");
        return byteArray;
    }

    /* renamed from: a */
    static /* synthetic */ BufferedInputStream m6190a(InputStream inputStream, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 8192;
        }
        return inputStream instanceof BufferedInputStream ? (BufferedInputStream) inputStream : new BufferedInputStream(inputStream, i);
    }

    /* renamed from: a */
    static /* synthetic */ BufferedOutputStream m6192a(OutputStream outputStream, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 8192;
        }
        return outputStream instanceof BufferedOutputStream ? (BufferedOutputStream) outputStream : new BufferedOutputStream(outputStream, i);
    }
}
