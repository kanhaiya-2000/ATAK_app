package atakplugin.UASTool;

import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import java.util.Arrays;
import java.util.List;

/* renamed from: atakplugin.UASTool.rf */
public class C0795rf extends C0791rb {
    public C0795rf() {
        super("mp4s");
    }

    public C0795rf(String str) {
        super(str);
    }

    /* renamed from: a */
    public void mo105a(C1007ws wsVar, ByteBuffer byteBuffer, long j, C0675ng ngVar) {
        ByteBuffer allocate = ByteBuffer.allocate(8);
        wsVar.mo5650a(allocate);
        allocate.position(6);
        this.f6018a = C0679nk.m12497d(allocate);
        mo6123a(wsVar, j - 8, ngVar);
    }

    /* renamed from: a */
    public void mo18a(WritableByteChannel writableByteChannel) {
        writableByteChannel.write(mo6124t());
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.position(6);
        C0681nm.m12514b(allocate, this.f6018a);
        writableByteChannel.write((ByteBuffer) allocate.rewind());
        mo209b(writableByteChannel);
    }

    public String toString() {
        return "MpegSampleEntry" + Arrays.asList(new List[]{mo36c()});
    }

    /* renamed from: f */
    public long mo19f() {
        long u = mo6130u() + 8;
        return u + ((long) ((this.f7513r || u >= 4294967296L) ? 16 : 8));
    }
}
