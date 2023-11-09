package atakplugin.UASTool;

import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

public class akv extends C0791rb {

    /* renamed from: b */
    protected byte[] f1737b;

    public akv(String str) {
        super(str);
    }

    /* renamed from: a */
    public void mo105a(C1007ws wsVar, ByteBuffer byteBuffer, long j, C0675ng ngVar) {
        ByteBuffer allocate = ByteBuffer.allocate(8);
        wsVar.mo5650a(allocate);
        allocate.position(6);
        this.f6018a = C0679nk.m12497d(allocate);
        byte[] bArr = new byte[afi.m847a(j - 8)];
        this.f1737b = bArr;
        wsVar.mo5650a(ByteBuffer.wrap(bArr));
    }

    /* renamed from: a */
    public void mo18a(WritableByteChannel writableByteChannel) {
        writableByteChannel.write(mo6124t());
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.position(6);
        C0681nm.m12514b(allocate, this.f6018a);
        allocate.rewind();
        writableByteChannel.write(allocate);
        writableByteChannel.write(ByteBuffer.wrap(this.f1737b));
    }

    /* renamed from: b */
    public byte[] mo1192b() {
        return this.f1737b;
    }

    /* renamed from: a */
    public void mo1191a(byte[] bArr) {
        this.f1737b = bArr;
    }

    /* renamed from: f */
    public long mo19f() {
        int i = 8;
        long length = (long) (this.f1737b.length + 8);
        if (this.f7513r || 8 + length >= 4294967296L) {
            i = 16;
        }
        return length + ((long) i);
    }
}
