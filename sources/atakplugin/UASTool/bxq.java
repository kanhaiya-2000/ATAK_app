package atakplugin.UASTool;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

@aot(mo1534a = 1, mo1535b = {1, 1, 11}, mo1536c = {1, 0, 2}, mo1537d = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0014J\b\u0010\u000b\u001a\u00020\fH\u0014R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, mo1538e = {"Lokio/SocketAsyncTimeout;", "Lokio/AsyncTimeout;", "socket", "Ljava/net/Socket;", "(Ljava/net/Socket;)V", "logger", "Ljava/util/logging/Logger;", "kotlin.jvm.PlatformType", "newTimeoutException", "Ljava/io/IOException;", "cause", "timedOut", "", "jvm"})
final class bxq extends bwh {

    /* renamed from: a */
    private final Logger f4212a = Logger.getLogger("okio.Okio");

    /* renamed from: e */
    private final Socket f4213e;

    public bxq(Socket socket) {
        bfq.m6567f(socket, "socket");
        this.f4213e = socket;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public IOException mo3613a(IOException iOException) {
        SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
        if (iOException != null) {
            socketTimeoutException.initCause(iOException);
        }
        return socketTimeoutException;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo3614a() {
        try {
            this.f4213e.close();
        } catch (Exception e) {
            Logger logger = this.f4212a;
            Level level = Level.WARNING;
            logger.log(level, "Failed to close timed out socket " + this.f4213e, e);
        } catch (AssertionError e2) {
            if (bxb.m10339a(e2)) {
                Logger logger2 = this.f4212a;
                Level level2 = Level.WARNING;
                logger2.log(level2, "Failed to close timed out socket " + this.f4213e, e2);
                return;
            }
            throw e2;
        }
    }
}
