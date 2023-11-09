package atakplugin.UASTool;

import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

/* renamed from: atakplugin.UASTool.ya */
class C1045ya implements C1024xh {

    /* renamed from: a */
    final /* synthetic */ C1043xz f7630a;

    /* renamed from: b */
    private final /* synthetic */ long f7631b;

    /* renamed from: c */
    private final /* synthetic */ ByteBuffer f7632c;

    /* renamed from: d */
    private final /* synthetic */ long f7633d;

    C1045ya(C1043xz xzVar, long j, ByteBuffer byteBuffer, long j2) {
        this.f7630a = xzVar;
        this.f7631b = j;
        this.f7632c = byteBuffer;
        this.f7633d = j2;
    }

    /* renamed from: a */
    public void mo8a(WritableByteChannel writableByteChannel) {
        writableByteChannel.write(mo9b());
    }

    /* renamed from: a */
    public long mo7a() {
        return this.f7631b;
    }

    /* renamed from: b */
    public ByteBuffer mo9b() {
        return (ByteBuffer) ((ByteBuffer) this.f7632c.position(afi.m847a(this.f7633d))).slice().limit(afi.m847a(this.f7631b));
    }

    public String toString() {
        return "DefaultMp4Sample(size:" + this.f7631b + ")";
    }
}
