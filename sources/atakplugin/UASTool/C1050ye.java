package atakplugin.UASTool;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

/* renamed from: atakplugin.UASTool.ye */
class C1050ye implements C1024xh {

    /* renamed from: a */
    final /* synthetic */ C1048yd f7674a;

    /* renamed from: b */
    private final /* synthetic */ long f7675b;

    /* renamed from: c */
    private final /* synthetic */ long f7676c;

    C1050ye(C1048yd ydVar, long j, long j2) {
        this.f7674a = ydVar;
        this.f7675b = j;
        this.f7676c = j2;
    }

    /* renamed from: a */
    public void mo8a(WritableByteChannel writableByteChannel) {
        this.f7674a.f7656m.mo5652a(this.f7675b, this.f7676c, writableByteChannel);
    }

    /* renamed from: a */
    public long mo7a() {
        return this.f7676c;
    }

    /* renamed from: b */
    public ByteBuffer mo9b() {
        try {
            return this.f7674a.f7656m.mo5653a(this.f7675b, this.f7676c);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
