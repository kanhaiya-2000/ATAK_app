package atakplugin.UASTool;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

/* renamed from: atakplugin.UASTool.yg */
class C1052yg implements C1024xh {

    /* renamed from: a */
    final /* synthetic */ C1051yf f7683a;

    /* renamed from: b */
    private final long f7684b;

    /* renamed from: c */
    private final long f7685c;

    /* renamed from: d */
    private final C1007ws f7686d;

    public C1052yg(C1051yf yfVar, long j, long j2, C1007ws wsVar) {
        this.f7683a = yfVar;
        this.f7684b = j;
        this.f7685c = j2;
        this.f7686d = wsVar;
    }

    /* renamed from: a */
    public void mo8a(WritableByteChannel writableByteChannel) {
        this.f7686d.mo5652a(this.f7684b, this.f7685c, writableByteChannel);
    }

    /* renamed from: a */
    public long mo7a() {
        return this.f7685c;
    }

    /* renamed from: b */
    public ByteBuffer mo9b() {
        try {
            return this.f7686d.mo5653a(this.f7684b, this.f7685c);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
