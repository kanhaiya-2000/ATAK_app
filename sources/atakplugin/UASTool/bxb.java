package atakplugin.UASTool;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.Arrays;

@aot(mo1534a = 2, mo1535b = {1, 1, 11}, mo1536c = {1, 0, 2}, mo1537d = {"\u0000R\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\r\u0010\u0005\u001a\u00020\u0006H\u0007¢\u0006\u0002\b\u0007\u001a\n\u0010\b\u001a\u00020\u0006*\u00020\t\u001a\n\u0010\n\u001a\u00020\u000b*\u00020\u0006\u001a\n\u0010\n\u001a\u00020\f*\u00020\r\u001a\u0016\u0010\u000e\u001a\u00020\u0006*\u00020\t2\b\b\u0002\u0010\u000f\u001a\u00020\u0001H\u0007\u001a\n\u0010\u000e\u001a\u00020\u0006*\u00020\u0010\u001a\n\u0010\u000e\u001a\u00020\u0006*\u00020\u0011\u001a%\u0010\u000e\u001a\u00020\u0006*\u00020\u00122\u0012\u0010\u0013\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00150\u0014\"\u00020\u0015H\u0007¢\u0006\u0002\u0010\u0016\u001a\n\u0010\u0017\u001a\u00020\r*\u00020\t\u001a\n\u0010\u0017\u001a\u00020\r*\u00020\u0018\u001a\n\u0010\u0017\u001a\u00020\r*\u00020\u0011\u001a%\u0010\u0017\u001a\u00020\r*\u00020\u00122\u0012\u0010\u0013\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00150\u0014\"\u00020\u0015H\u0007¢\u0006\u0002\u0010\u0019\"\u001c\u0010\u0000\u001a\u00020\u0001*\u00060\u0002j\u0002`\u00038@X\u0004¢\u0006\u0006\u001a\u0004\b\u0000\u0010\u0004¨\u0006\u001a"}, mo1538e = {"isAndroidGetsocknameError", "", "Ljava/lang/AssertionError;", "Lkotlin/AssertionError;", "(Ljava/lang/AssertionError;)Z", "blackholeSink", "Lokio/Sink;", "blackhole", "appendingSink", "Ljava/io/File;", "buffer", "Lokio/BufferedSink;", "Lokio/BufferedSource;", "Lokio/Source;", "sink", "append", "Ljava/io/OutputStream;", "Ljava/net/Socket;", "Ljava/nio/file/Path;", "options", "", "Ljava/nio/file/OpenOption;", "(Ljava/nio/file/Path;[Ljava/nio/file/OpenOption;)Lokio/Sink;", "source", "Ljava/io/InputStream;", "(Ljava/nio/file/Path;[Ljava/nio/file/OpenOption;)Lokio/Source;", "jvm"})
public final class bxb {
    /* renamed from: a */
    public static final bxp m10332a(File file) {
        return m10334a(file, false, 1, (Object) null);
    }

    /* renamed from: a */
    public static final bwp m10330a(bxr bxr) {
        bfq.m6567f(bxr, "$receiver");
        return new bxk(bxr);
    }

    /* renamed from: a */
    public static final bwo m10329a(bxp bxp) {
        bfq.m6567f(bxp, "$receiver");
        return new bxi(bxp);
    }

    /* renamed from: a */
    public static final bxp m10335a(OutputStream outputStream) {
        bfq.m6567f(outputStream, "$receiver");
        return new bxd(outputStream, new bxs());
    }

    /* renamed from: a */
    public static final bxr m10338a(InputStream inputStream) {
        bfq.m6567f(inputStream, "$receiver");
        return new bxa(inputStream, new bxs());
    }

    /* renamed from: a */
    public static final bxp m10331a() {
        return new bwk();
    }

    /* renamed from: a */
    public static final bxp m10336a(Socket socket) {
        bfq.m6567f(socket, "$receiver");
        bxq bxq = new bxq(socket);
        OutputStream outputStream = socket.getOutputStream();
        bfq.m6554b(outputStream, "getOutputStream()");
        return bxq.mo3756a((bxp) new bxd(outputStream, bxq));
    }

    /* renamed from: b */
    public static final bxr m10341b(Socket socket) {
        bfq.m6567f(socket, "$receiver");
        bxq bxq = new bxq(socket);
        InputStream inputStream = socket.getInputStream();
        bfq.m6554b(inputStream, "getInputStream()");
        return bxq.mo3757a((bxr) new bxa(inputStream, bxq));
    }

    /* renamed from: a */
    public static final bxp m10333a(File file, boolean z) {
        bfq.m6567f(file, "$receiver");
        return m10335a((OutputStream) new FileOutputStream(file, z));
    }

    /* renamed from: a */
    public static /* bridge */ /* synthetic */ bxp m10334a(File file, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return m10333a(file, z);
    }

    /* renamed from: b */
    public static final bxp m10340b(File file) {
        bfq.m6567f(file, "$receiver");
        return m10335a((OutputStream) new FileOutputStream(file, true));
    }

    /* renamed from: c */
    public static final bxr m10343c(File file) {
        bfq.m6567f(file, "$receiver");
        return m10338a((InputStream) new FileInputStream(file));
    }

    /* renamed from: a */
    public static final bxp m10337a(Path path, OpenOption... openOptionArr) {
        bfq.m6567f(path, "$receiver");
        bfq.m6567f(openOptionArr, "options");
        OutputStream newOutputStream = Files.newOutputStream(path, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length));
        bfq.m6554b(newOutputStream, "Files.newOutputStream(this, *options)");
        return m10335a(newOutputStream);
    }

    /* renamed from: b */
    public static final bxr m10342b(Path path, OpenOption... openOptionArr) {
        bfq.m6567f(path, "$receiver");
        bfq.m6567f(openOptionArr, "options");
        InputStream newInputStream = Files.newInputStream(path, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length));
        bfq.m6554b(newInputStream, "Files.newInputStream(this, *options)");
        return m10338a(newInputStream);
    }

    /* renamed from: a */
    public static final boolean m10339a(AssertionError assertionError) {
        bfq.m6567f(assertionError, "$receiver");
        if (assertionError.getCause() == null) {
            return false;
        }
        String message = assertionError.getMessage();
        return message != null ? boc.m8222e((CharSequence) message, (CharSequence) "getsockname failed", false, 2, (Object) null) : false;
    }
}
