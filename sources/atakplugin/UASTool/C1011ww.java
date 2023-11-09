package atakplugin.UASTool;

import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

/* renamed from: atakplugin.UASTool.ww */
public class C1011ww implements C1007ws {

    /* renamed from: a */
    ByteBuffer f7535a;

    public void close() {
    }

    public C1011ww(byte[] bArr) {
        this.f7535a = ByteBuffer.wrap(bArr);
    }

    public C1011ww(ByteBuffer byteBuffer) {
        this.f7535a = byteBuffer;
    }

    /* renamed from: a */
    public int mo5650a(ByteBuffer byteBuffer) {
        if (this.f7535a.remaining() == 0 && byteBuffer.remaining() != 0) {
            return -1;
        }
        int min = Math.min(byteBuffer.remaining(), this.f7535a.remaining());
        if (byteBuffer.hasArray()) {
            byteBuffer.put(this.f7535a.array(), this.f7535a.position(), min);
            ByteBuffer byteBuffer2 = this.f7535a;
            byteBuffer2.position(byteBuffer2.position() + min);
        } else {
            byte[] bArr = new byte[min];
            this.f7535a.get(bArr);
            byteBuffer.put(bArr);
        }
        return min;
    }

    /* renamed from: a */
    public long mo5651a() {
        return (long) this.f7535a.capacity();
    }

    /* renamed from: b */
    public long mo5655b() {
        return (long) this.f7535a.position();
    }

    /* renamed from: a */
    public void mo5654a(long j) {
        this.f7535a.position(afi.m847a(j));
    }

    /* renamed from: a */
    public long mo5652a(long j, long j2, WritableByteChannel writableByteChannel) {
        return (long) writableByteChannel.write((ByteBuffer) ((ByteBuffer) this.f7535a.position(afi.m847a(j))).slice().limit(afi.m847a(j2)));
    }

    /* renamed from: a */
    public ByteBuffer mo5653a(long j, long j2) {
        int position = this.f7535a.position();
        this.f7535a.position(afi.m847a(j));
        ByteBuffer slice = this.f7535a.slice();
        slice.limit(afi.m847a(j2));
        this.f7535a.position(position);
        return slice;
    }
}
