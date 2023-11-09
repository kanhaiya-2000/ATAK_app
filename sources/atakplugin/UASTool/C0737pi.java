package atakplugin.UASTool;

import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import java.util.Iterator;

/* renamed from: atakplugin.UASTool.pi */
public class C0737pi extends C1003wo implements C0709ol {

    /* renamed from: a */
    public static final String f5666a = "stsd";

    /* renamed from: b */
    private int f5667b;

    /* renamed from: c */
    private int f5668c;

    public C0737pi() {
        super(f5666a);
    }

    /* renamed from: a_ */
    public int mo5157a_() {
        return this.f5667b;
    }

    /* renamed from: a_ */
    public void mo5158a_(int i) {
        this.f5667b = i;
    }

    /* renamed from: b_ */
    public int mo456b_() {
        return this.f5668c;
    }

    /* renamed from: b */
    public void mo5159b(int i) {
        this.f5668c = i;
    }

    /* renamed from: a */
    public void mo105a(C1007ws wsVar, ByteBuffer byteBuffer, long j, C0675ng ngVar) {
        ByteBuffer allocate = ByteBuffer.allocate(8);
        wsVar.mo5650a(allocate);
        allocate.rewind();
        this.f5667b = C0679nk.m12499f(allocate);
        this.f5668c = C0679nk.m12496c(allocate);
        mo6123a(wsVar, j - 8, ngVar);
    }

    /* renamed from: a */
    public void mo18a(WritableByteChannel writableByteChannel) {
        writableByteChannel.write(mo6124t());
        ByteBuffer allocate = ByteBuffer.allocate(8);
        C0681nm.m12521d(allocate, this.f5667b);
        C0681nm.m12510a(allocate, this.f5668c);
        C0681nm.m12515b(allocate, (long) mo36c().size());
        writableByteChannel.write((ByteBuffer) allocate.rewind());
        mo209b(writableByteChannel);
    }

    /* renamed from: d */
    public C0791rb mo5316d() {
        Iterator<C0791rb> it = mo202a(C0791rb.class).iterator();
        if (it.hasNext()) {
            return it.next();
        }
        return null;
    }

    /* renamed from: f */
    public long mo19f() {
        long u = mo6130u() + 8;
        return u + ((long) ((this.f7513r || 8 + u >= 4294967296L) ? 16 : 8));
    }
}
