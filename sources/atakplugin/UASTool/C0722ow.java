package atakplugin.UASTool;

import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

/* renamed from: atakplugin.UASTool.ow */
public class C0722ow extends C1003wo {

    /* renamed from: a */
    public static final String f5559a = "meta";

    /* renamed from: b */
    private int f5560b;

    /* renamed from: c */
    private int f5561c;

    /* renamed from: a */
    public int mo5239a() {
        return this.f5560b;
    }

    /* renamed from: a */
    public void mo5241a(int i) {
        this.f5560b = i;
    }

    /* renamed from: b */
    public int mo5242b() {
        return this.f5561c;
    }

    /* renamed from: b */
    public void mo5243b(int i) {
        this.f5561c = i;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final long mo5240a(ByteBuffer byteBuffer) {
        this.f5560b = C0679nk.m12499f(byteBuffer);
        this.f5561c = C0679nk.m12496c(byteBuffer);
        return 4;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public final void mo5244b(ByteBuffer byteBuffer) {
        C0681nm.m12521d(byteBuffer, this.f5560b);
        C0681nm.m12510a(byteBuffer, this.f5561c);
    }

    public C0722ow() {
        super(f5559a);
    }

    /* renamed from: a */
    public void mo105a(C1007ws wsVar, ByteBuffer byteBuffer, long j, C0675ng ngVar) {
        ByteBuffer allocate = ByteBuffer.allocate(4);
        wsVar.mo5650a(allocate);
        mo5240a((ByteBuffer) allocate.rewind());
        mo6123a(wsVar, j - 4, ngVar);
    }

    /* renamed from: a */
    public void mo18a(WritableByteChannel writableByteChannel) {
        writableByteChannel.write(mo6124t());
        ByteBuffer allocate = ByteBuffer.allocate(4);
        mo5244b(allocate);
        writableByteChannel.write((ByteBuffer) allocate.rewind());
        mo209b(writableByteChannel);
    }

    /* renamed from: f */
    public long mo19f() {
        long u = mo6130u() + 4;
        return u + ((long) ((this.f7513r || u >= 4294967296L) ? 16 : 8));
    }
}
