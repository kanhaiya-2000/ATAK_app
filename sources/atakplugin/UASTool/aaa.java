package atakplugin.UASTool;

import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

class aaa implements C1024xh {

    /* renamed from: a */
    final /* synthetic */ C1112zz f0a;

    /* renamed from: b */
    private final /* synthetic */ byte[] f1b;

    aaa(C1112zz zzVar, byte[] bArr) {
        this.f0a = zzVar;
        this.f1b = bArr;
    }

    /* renamed from: a */
    public void mo8a(WritableByteChannel writableByteChannel) {
        writableByteChannel.write(ByteBuffer.wrap(this.f1b));
    }

    /* renamed from: a */
    public long mo7a() {
        return (long) this.f1b.length;
    }

    /* renamed from: b */
    public ByteBuffer mo9b() {
        return ByteBuffer.wrap(this.f1b);
    }
}
