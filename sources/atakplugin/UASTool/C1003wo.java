package atakplugin.UASTool;

import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

/* renamed from: atakplugin.UASTool.wo */
public class C1003wo extends C1005wq implements C0688nt {

    /* renamed from: a */
    private long f7510a;

    /* renamed from: p */
    C0695nz f7511p;

    /* renamed from: q */
    protected String f7512q;

    /* renamed from: r */
    protected boolean f7513r;

    public C1003wo(String str) {
        this.f7512q = str;
    }

    /* renamed from: e */
    public C0695nz mo1474e() {
        return this.f7511p;
    }

    /* renamed from: g */
    public long mo1475g() {
        return this.f7510a;
    }

    /* renamed from: a */
    public void mo1473a(C0695nz nzVar) {
        this.f7511p = nzVar;
    }

    /* renamed from: f */
    public long mo19f() {
        long u = mo6130u();
        return u + ((long) ((this.f7513r || 8 + u >= 4294967296L) ? 16 : 8));
    }

    /* renamed from: h */
    public String mo1476h() {
        return this.f7512q;
    }

    /* access modifiers changed from: protected */
    /* renamed from: t */
    public ByteBuffer mo6124t() {
        ByteBuffer byteBuffer;
        if (this.f7513r || mo19f() >= 4294967296L) {
            byte[] bArr = new byte[16];
            bArr[3] = 1;
            bArr[4] = this.f7512q.getBytes()[0];
            bArr[5] = this.f7512q.getBytes()[1];
            bArr[6] = this.f7512q.getBytes()[2];
            bArr[7] = this.f7512q.getBytes()[3];
            byteBuffer = ByteBuffer.wrap(bArr);
            byteBuffer.position(8);
            C0681nm.m12511a(byteBuffer, mo19f());
        } else {
            byte[] bArr2 = new byte[8];
            bArr2[4] = this.f7512q.getBytes()[0];
            bArr2[5] = this.f7512q.getBytes()[1];
            bArr2[6] = this.f7512q.getBytes()[2];
            bArr2[7] = this.f7512q.getBytes()[3];
            byteBuffer = ByteBuffer.wrap(bArr2);
            C0681nm.m12515b(byteBuffer, mo19f());
        }
        byteBuffer.rewind();
        return byteBuffer;
    }

    /* renamed from: a */
    public void mo105a(C1007ws wsVar, ByteBuffer byteBuffer, long j, C0675ng ngVar) {
        this.f7510a = wsVar.mo5655b() - ((long) byteBuffer.remaining());
        this.f7513r = byteBuffer.remaining() == 16;
        mo6123a(wsVar, j, ngVar);
    }

    /* renamed from: a */
    public void mo18a(WritableByteChannel writableByteChannel) {
        writableByteChannel.write(mo6124t());
        mo209b(writableByteChannel);
    }

    /* renamed from: a */
    public void mo6123a(C1007ws wsVar, long j, C0675ng ngVar) {
        this.f7522t = wsVar;
        this.f7524v = wsVar.mo5655b();
        this.f7525w = this.f7524v - ((long) ((this.f7513r || 8 + j >= 4294967296L) ? 16 : 8));
        wsVar.mo5654a(wsVar.mo5655b() + j);
        this.f7526x = wsVar.mo5655b();
        this.f7521s = ngVar;
    }
}
