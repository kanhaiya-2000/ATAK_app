package atakplugin.UASTool;

import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

/* renamed from: atakplugin.UASTool.oe */
public class C0701oe extends C1003wo implements C0709ol {

    /* renamed from: a */
    public static final String f5421a = "dref";

    /* renamed from: b */
    private int f5422b;

    /* renamed from: c */
    private int f5423c;

    public C0701oe() {
        super(f5421a);
    }

    /* renamed from: a_ */
    public int mo5157a_() {
        return this.f5422b;
    }

    /* renamed from: a_ */
    public void mo5158a_(int i) {
        this.f5422b = i;
    }

    /* renamed from: b_ */
    public int mo456b_() {
        return this.f5423c;
    }

    /* renamed from: b */
    public void mo5159b(int i) {
        this.f5423c = i;
    }

    /* renamed from: a */
    public void mo105a(C1007ws wsVar, ByteBuffer byteBuffer, long j, C0675ng ngVar) {
        ByteBuffer allocate = ByteBuffer.allocate(8);
        wsVar.mo5650a(allocate);
        allocate.rewind();
        this.f5422b = C0679nk.m12499f(allocate);
        this.f5423c = C0679nk.m12496c(allocate);
        mo6123a(wsVar, j - 8, ngVar);
    }

    /* renamed from: a */
    public void mo18a(WritableByteChannel writableByteChannel) {
        writableByteChannel.write(mo6124t());
        ByteBuffer allocate = ByteBuffer.allocate(8);
        C0681nm.m12521d(allocate, this.f5422b);
        C0681nm.m12510a(allocate, this.f5423c);
        C0681nm.m12515b(allocate, (long) mo36c().size());
        writableByteChannel.write((ByteBuffer) allocate.rewind());
        mo209b(writableByteChannel);
    }

    /* renamed from: f */
    public long mo19f() {
        long u = mo6130u() + 8;
        return u + ((long) ((this.f7513r || 8 + u >= 4294967296L) ? 16 : 8));
    }
}
