package atakplugin.UASTool;

import java.io.Closeable;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

/* renamed from: atakplugin.UASTool.ws */
public interface C1007ws extends Closeable {
    /* renamed from: a */
    int mo5650a(ByteBuffer byteBuffer);

    /* renamed from: a */
    long mo5651a();

    /* renamed from: a */
    long mo5652a(long j, long j2, WritableByteChannel writableByteChannel);

    /* renamed from: a */
    ByteBuffer mo5653a(long j, long j2);

    /* renamed from: a */
    void mo5654a(long j);

    /* renamed from: b */
    long mo5655b();

    void close();
}
