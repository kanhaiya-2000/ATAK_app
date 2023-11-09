package atakplugin.UASTool;

import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

/* renamed from: atakplugin.UASTool.re */
class C0794re implements C0688nt {

    /* renamed from: a */
    final /* synthetic */ C0793rd f6059a;

    /* renamed from: b */
    private final /* synthetic */ long f6060b;

    /* renamed from: c */
    private final /* synthetic */ ByteBuffer f6061c;

    C0794re(C0793rd rdVar, long j, ByteBuffer byteBuffer) {
        this.f6059a = rdVar;
        this.f6060b = j;
        this.f6061c = byteBuffer;
    }

    /* renamed from: g */
    public long mo1475g() {
        return 0;
    }

    /* renamed from: h */
    public String mo1476h() {
        return "----";
    }

    /* renamed from: e */
    public C0695nz mo1474e() {
        return this.f6059a;
    }

    /* renamed from: a */
    public void mo1473a(C0695nz nzVar) {
        if (!C0793rd.f6045o && nzVar != this.f6059a) {
            throw new AssertionError("you cannot diswown this special box");
        }
    }

    /* renamed from: f */
    public long mo19f() {
        return this.f6060b;
    }

    /* renamed from: a */
    public void mo18a(WritableByteChannel writableByteChannel) {
        this.f6061c.rewind();
        writableByteChannel.write(this.f6061c);
    }

    /* renamed from: a */
    public void mo105a(C1007ws wsVar, ByteBuffer byteBuffer, long j, C0675ng ngVar) {
        throw new RuntimeException("NotImplemented");
    }
}
