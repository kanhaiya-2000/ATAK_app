package atakplugin.UASTool;

import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

/* renamed from: atakplugin.UASTool.yv */
class C1070yv implements C1024xh {

    /* renamed from: a */
    final /* synthetic */ C1068yu f7789a;

    /* renamed from: b */
    private final /* synthetic */ ByteBuffer f7790b;

    C1070yv(C1068yu yuVar, ByteBuffer byteBuffer) {
        this.f7789a = yuVar;
        this.f7790b = byteBuffer;
    }

    /* renamed from: a */
    public void mo8a(WritableByteChannel writableByteChannel) {
        writableByteChannel.write((ByteBuffer) this.f7790b.rewind());
    }

    /* renamed from: a */
    public long mo7a() {
        return (long) this.f7790b.rewind().remaining();
    }

    /* renamed from: b */
    public ByteBuffer mo9b() {
        return this.f7790b;
    }
}
