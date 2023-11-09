package atakplugin.UASTool;

import com.autel.downloader.bean.DownloadTask;
import indago.serialization.JsonKeyConstants;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.Arrays;

@aot(mo1534a = 1, mo1535b = {1, 1, 11}, mo1536c = {1, 0, 2}, mo1537d = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\b\u0010\u0007\u001a\u00020\u0004H\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0004H\u0007J\u0010\u0010\b\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J)\u0010\n\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00132\u0012\u0010\u0014\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00160\u0015\"\u00020\u0016H\u0007¢\u0006\u0002\u0010\u0017J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0019H\u0007J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J)\u0010\f\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00132\u0012\u0010\u0014\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00160\u0015\"\u00020\u0016H\u0007¢\u0006\u0002\u0010\u001a¨\u0006\u001b"}, mo1538e = {"Lokio/-DeprecatedOkio;", "", "()V", "appendingSink", "Lokio/Sink;", "file", "Ljava/io/File;", "blackhole", "buffer", "Lokio/BufferedSink;", "sink", "Lokio/BufferedSource;", "source", "Lokio/Source;", "outputStream", "Ljava/io/OutputStream;", "socket", "Ljava/net/Socket;", "path", "Ljava/nio/file/Path;", "options", "", "Ljava/nio/file/OpenOption;", "(Ljava/nio/file/Path;[Ljava/nio/file/OpenOption;)Lokio/Sink;", "inputStream", "Ljava/io/InputStream;", "(Ljava/nio/file/Path;[Ljava/nio/file/OpenOption;)Lokio/Source;", "jvm"})
public final class bvz {

    /* renamed from: a */
    public static final bvz f4095a = new bvz();

    private bvz() {
    }

    @anx(mo1516a = "moved to extension function", mo1517b = @C0081api(mo1552a = "file.appendingSink()", mo1553b = {"okio.appendingSink"}), mo1518c = any.ERROR)
    /* renamed from: a */
    public final bxp mo3744a(File file) {
        bfq.m6567f(file, "file");
        return bxb.m10340b(file);
    }

    @anx(mo1516a = "moved to extension function", mo1517b = @C0081api(mo1552a = "sink.buffer()", mo1553b = {"okio.buffer"}), mo1518c = any.ERROR)
    /* renamed from: a */
    public final bwo mo3741a(bxp bxp) {
        bfq.m6567f(bxp, "sink");
        return bxb.m10329a(bxp);
    }

    @anx(mo1516a = "moved to extension function", mo1517b = @C0081api(mo1552a = "source.buffer()", mo1553b = {"okio.buffer"}), mo1518c = any.ERROR)
    /* renamed from: a */
    public final bwp mo3742a(bxr bxr) {
        bfq.m6567f(bxr, JsonKeyConstants.SOURCE);
        return bxb.m10330a(bxr);
    }

    @anx(mo1516a = "moved to extension function", mo1517b = @C0081api(mo1552a = "file.sink()", mo1553b = {"okio.sink"}), mo1518c = any.ERROR)
    /* renamed from: b */
    public final bxp mo3749b(File file) {
        bfq.m6567f(file, "file");
        return bxb.m10334a(file, false, 1, (Object) null);
    }

    @anx(mo1516a = "moved to extension function", mo1517b = @C0081api(mo1552a = "outputStream.sink()", mo1553b = {"okio.sink"}), mo1518c = any.ERROR)
    /* renamed from: a */
    public final bxp mo3745a(OutputStream outputStream) {
        bfq.m6567f(outputStream, "outputStream");
        return bxb.m10335a(outputStream);
    }

    @anx(mo1516a = "moved to extension function", mo1517b = @C0081api(mo1552a = "path.sink(*options)", mo1553b = {"okio.sink"}), mo1518c = any.ERROR)
    /* renamed from: a */
    public final bxp mo3747a(Path path, OpenOption... openOptionArr) {
        bfq.m6567f(path, DownloadTask.PATH);
        bfq.m6567f(openOptionArr, "options");
        return bxb.m10337a(path, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length));
    }

    @anx(mo1516a = "moved to extension function", mo1517b = @C0081api(mo1552a = "socket.sink()", mo1553b = {"okio.sink"}), mo1518c = any.ERROR)
    /* renamed from: a */
    public final bxp mo3746a(Socket socket) {
        bfq.m6567f(socket, "socket");
        return bxb.m10336a(socket);
    }

    @anx(mo1516a = "moved to extension function", mo1517b = @C0081api(mo1552a = "file.source()", mo1553b = {"okio.source"}), mo1518c = any.ERROR)
    /* renamed from: c */
    public final bxr mo3752c(File file) {
        bfq.m6567f(file, "file");
        return bxb.m10343c(file);
    }

    @anx(mo1516a = "moved to extension function", mo1517b = @C0081api(mo1552a = "inputStream.source()", mo1553b = {"okio.source"}), mo1518c = any.ERROR)
    /* renamed from: a */
    public final bxr mo3748a(InputStream inputStream) {
        bfq.m6567f(inputStream, "inputStream");
        return bxb.m10338a(inputStream);
    }

    @anx(mo1516a = "moved to extension function", mo1517b = @C0081api(mo1552a = "path.source(*options)", mo1553b = {"okio.source"}), mo1518c = any.ERROR)
    /* renamed from: b */
    public final bxr mo3751b(Path path, OpenOption... openOptionArr) {
        bfq.m6567f(path, DownloadTask.PATH);
        bfq.m6567f(openOptionArr, "options");
        return bxb.m10342b(path, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length));
    }

    @anx(mo1516a = "moved to extension function", mo1517b = @C0081api(mo1552a = "socket.source()", mo1553b = {"okio.source"}), mo1518c = any.ERROR)
    /* renamed from: b */
    public final bxr mo3750b(Socket socket) {
        bfq.m6567f(socket, "socket");
        return bxb.m10341b(socket);
    }

    @anx(mo1516a = "moved to extension function", mo1517b = @C0081api(mo1552a = "blackholeSink()", mo1553b = {"okio.blackholeSink"}), mo1518c = any.ERROR)
    /* renamed from: a */
    public final bxp mo3743a() {
        return bxb.m10331a();
    }
}
