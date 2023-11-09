package atakplugin.UASTool;

import java.io.Closeable;
import java.io.Flushable;

@aot(mo1534a = 1, mo1535b = {1, 1, 11}, mo1536c = {1, 0, 2}, mo1537d = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\bf\u0018\u00002\u00020\u00012\u00020\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH&¨\u0006\r"}, mo1538e = {"Lokio/Sink;", "Ljava/io/Closeable;", "Ljava/io/Flushable;", "close", "", "flush", "timeout", "Lokio/Timeout;", "write", "source", "Lokio/Buffer;", "byteCount", "", "jvm"})
public interface bxp extends Closeable, Flushable {
    void close();

    void flush();

    bxs timeout();

    void write(bwl bwl, long j);
}
