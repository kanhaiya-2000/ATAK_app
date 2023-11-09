package atakplugin.UASTool;

import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

/* renamed from: atakplugin.UASTool.rg */
public class C0796rg extends C0791rb {

    /* renamed from: b */
    public static final String f6062b = "ovc1";

    /* renamed from: c */
    private byte[] f6063c = new byte[0];

    public C0796rg() {
        super(f6062b);
    }

    /* renamed from: b */
    public byte[] mo5601b() {
        return this.f6063c;
    }

    /* renamed from: a */
    public void mo5600a(byte[] bArr) {
        this.f6063c = bArr;
    }

    /* renamed from: a */
    public void mo105a(C1007ws wsVar, ByteBuffer byteBuffer, long j, C0675ng ngVar) {
        ByteBuffer allocate = ByteBuffer.allocate(afi.m847a(j));
        wsVar.mo5650a(allocate);
        allocate.position(6);
        this.f6018a = C0679nk.m12497d(allocate);
        byte[] bArr = new byte[allocate.remaining()];
        this.f6063c = bArr;
        allocate.get(bArr);
    }

    /* renamed from: a */
    public void mo18a(WritableByteChannel writableByteChannel) {
        writableByteChannel.write(mo6124t());
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.position(6);
        C0681nm.m12514b(allocate, this.f6018a);
        writableByteChannel.write((ByteBuffer) allocate.rewind());
        writableByteChannel.write(ByteBuffer.wrap(this.f6063c));
    }

    /* renamed from: f */
    public long mo19f() {
        int i = 16;
        if (!this.f7513r && ((long) (this.f6063c.length + 16)) < 4294967296L) {
            i = 8;
        }
        return ((long) i) + ((long) this.f6063c.length) + 8;
    }
}
