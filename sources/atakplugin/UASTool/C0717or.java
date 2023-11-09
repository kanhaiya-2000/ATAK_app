package atakplugin.UASTool;

import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

/* renamed from: atakplugin.UASTool.or */
public class C0717or extends C1003wo implements C0709ol {

    /* renamed from: a */
    public static final String f5528a = "ipro";

    /* renamed from: b */
    private int f5529b;

    /* renamed from: c */
    private int f5530c;

    public C0717or() {
        super(f5528a);
    }

    /* renamed from: a_ */
    public int mo5157a_() {
        return this.f5529b;
    }

    /* renamed from: a_ */
    public void mo5158a_(int i) {
        this.f5529b = i;
    }

    /* renamed from: b_ */
    public int mo456b_() {
        return this.f5530c;
    }

    /* renamed from: b */
    public void mo5159b(int i) {
        this.f5530c = i;
    }

    /* renamed from: d */
    public C0742pm mo5221d() {
        if (!mo202a(C0742pm.class).isEmpty()) {
            return mo202a(C0742pm.class).get(0);
        }
        return null;
    }

    /* renamed from: a */
    public void mo105a(C1007ws wsVar, ByteBuffer byteBuffer, long j, C0675ng ngVar) {
        ByteBuffer allocate = ByteBuffer.allocate(6);
        wsVar.mo5650a(allocate);
        allocate.rewind();
        this.f5529b = C0679nk.m12499f(allocate);
        this.f5530c = C0679nk.m12496c(allocate);
        mo6123a(wsVar, j - 6, ngVar);
    }

    /* renamed from: a */
    public void mo18a(WritableByteChannel writableByteChannel) {
        writableByteChannel.write(mo6124t());
        ByteBuffer allocate = ByteBuffer.allocate(6);
        C0681nm.m12521d(allocate, this.f5529b);
        C0681nm.m12510a(allocate, this.f5530c);
        C0681nm.m12514b(allocate, mo36c().size());
        writableByteChannel.write((ByteBuffer) allocate.rewind());
        mo209b(writableByteChannel);
    }

    /* renamed from: f */
    public long mo19f() {
        long u = mo6130u() + 6;
        return u + ((long) ((this.f7513r || u >= 4294967296L) ? 16 : 8));
    }
}
