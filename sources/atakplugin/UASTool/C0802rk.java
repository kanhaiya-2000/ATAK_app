package atakplugin.UASTool;

import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

/* renamed from: atakplugin.UASTool.rk */
class C0802rk implements C1007ws {

    /* renamed from: a */
    final /* synthetic */ C0801rj f6099a;

    /* renamed from: b */
    private final /* synthetic */ long f6100b;

    /* renamed from: c */
    private final /* synthetic */ C1007ws f6101c;

    C0802rk(C0801rj rjVar, long j, C1007ws wsVar) {
        this.f6099a = rjVar;
        this.f6100b = j;
        this.f6101c = wsVar;
    }

    /* renamed from: a */
    public int mo5650a(ByteBuffer byteBuffer) {
        if (this.f6100b == this.f6101c.mo5655b()) {
            return -1;
        }
        if (((long) byteBuffer.remaining()) <= this.f6100b - this.f6101c.mo5655b()) {
            return this.f6101c.mo5650a(byteBuffer);
        }
        ByteBuffer allocate = ByteBuffer.allocate(afi.m847a(this.f6100b - this.f6101c.mo5655b()));
        this.f6101c.mo5650a(allocate);
        byteBuffer.put((ByteBuffer) allocate.rewind());
        return allocate.capacity();
    }

    /* renamed from: a */
    public long mo5651a() {
        return this.f6100b;
    }

    /* renamed from: b */
    public long mo5655b() {
        return this.f6101c.mo5655b();
    }

    /* renamed from: a */
    public void mo5654a(long j) {
        this.f6101c.mo5654a(j);
    }

    /* renamed from: a */
    public long mo5652a(long j, long j2, WritableByteChannel writableByteChannel) {
        return this.f6101c.mo5652a(j, j2, writableByteChannel);
    }

    /* renamed from: a */
    public ByteBuffer mo5653a(long j, long j2) {
        return this.f6101c.mo5653a(j, j2);
    }

    public void close() {
        this.f6101c.close();
    }
}
