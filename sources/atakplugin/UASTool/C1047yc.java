package atakplugin.UASTool;

import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

/* renamed from: atakplugin.UASTool.yc */
class C1047yc implements C1024xh {

    /* renamed from: a */
    final /* synthetic */ C1046yb f7643a;

    /* renamed from: b */
    private final /* synthetic */ long f7644b;

    /* renamed from: c */
    private final /* synthetic */ ByteBuffer f7645c;

    /* renamed from: d */
    private final /* synthetic */ int f7646d;

    C1047yc(C1046yb ybVar, long j, ByteBuffer byteBuffer, int i) {
        this.f7643a = ybVar;
        this.f7644b = j;
        this.f7645c = byteBuffer;
        this.f7646d = i;
    }

    /* renamed from: a */
    public void mo8a(WritableByteChannel writableByteChannel) {
        writableByteChannel.write(mo9b());
    }

    /* renamed from: a */
    public long mo7a() {
        return this.f7644b;
    }

    /* renamed from: b */
    public ByteBuffer mo9b() {
        return (ByteBuffer) ((ByteBuffer) this.f7645c.position(this.f7646d)).slice().limit(afi.m847a(this.f7644b));
    }
}
