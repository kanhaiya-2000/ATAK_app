package atakplugin.UASTool;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

/* renamed from: atakplugin.UASTool.yy */
class C1074yy implements C1024xh {

    /* renamed from: a */
    final /* synthetic */ C1072yx f7808a;

    /* renamed from: b */
    private final /* synthetic */ int f7809b;

    C1074yy(C1072yx yxVar, int i) {
        this.f7808a = yxVar;
        this.f7809b = i;
    }

    /* renamed from: a */
    public void mo8a(WritableByteChannel writableByteChannel) {
        this.f7808a.f7796g.mo5652a((long) this.f7809b, (long) this.f7808a.f7798i, writableByteChannel);
    }

    /* renamed from: a */
    public long mo7a() {
        return (long) this.f7808a.f7798i;
    }

    /* renamed from: b */
    public ByteBuffer mo9b() {
        try {
            return this.f7808a.f7796g.mo5653a((long) this.f7809b, (long) this.f7808a.f7798i);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
