package atakplugin.UASTool;

import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import java.util.List;
import java.util.logging.Logger;

/* renamed from: atakplugin.UASTool.wv */
public abstract class C1010wv extends C1003wo implements C0709ol {

    /* renamed from: a */
    private static Logger f7532a = Logger.getLogger(C1010wv.class.getName());

    /* renamed from: b */
    private int f7533b;

    /* renamed from: c */
    private int f7534c;

    /* renamed from: a_ */
    public int mo5157a_() {
        return this.f7533b;
    }

    /* renamed from: a_ */
    public void mo5158a_(int i) {
        this.f7533b = i;
    }

    /* renamed from: b_ */
    public int mo456b_() {
        return this.f7534c;
    }

    /* renamed from: b */
    public void mo5159b(int i) {
        this.f7534c = i;
    }

    /* renamed from: a */
    public <T extends C0688nt> List<T> mo202a(Class<T> cls) {
        return mo203a(cls, false);
    }

    public C1010wv(String str) {
        super(str);
    }

    /* renamed from: a */
    public void mo105a(C1007ws wsVar, ByteBuffer byteBuffer, long j, C0675ng ngVar) {
        ByteBuffer allocate = ByteBuffer.allocate(4);
        wsVar.mo5650a(allocate);
        mo6135a((ByteBuffer) allocate.rewind());
        super.mo105a(wsVar, byteBuffer, j, ngVar);
    }

    /* renamed from: a */
    public void mo18a(WritableByteChannel writableByteChannel) {
        super.mo18a(writableByteChannel);
    }

    public String toString() {
        return String.valueOf(getClass().getSimpleName()) + "[childBoxes]";
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final long mo6135a(ByteBuffer byteBuffer) {
        this.f7533b = C0679nk.m12499f(byteBuffer);
        this.f7534c = C0679nk.m12496c(byteBuffer);
        return 4;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public final void mo6136b(ByteBuffer byteBuffer) {
        C0681nm.m12521d(byteBuffer, this.f7533b);
        C0681nm.m12510a(byteBuffer, this.f7534c);
    }

    /* access modifiers changed from: protected */
    /* renamed from: t */
    public ByteBuffer mo6124t() {
        ByteBuffer byteBuffer;
        if (this.f7513r || mo19f() >= 4294967296L) {
            byte[] bArr = new byte[20];
            bArr[3] = 1;
            bArr[4] = this.f7512q.getBytes()[0];
            bArr[5] = this.f7512q.getBytes()[1];
            bArr[6] = this.f7512q.getBytes()[2];
            bArr[7] = this.f7512q.getBytes()[3];
            byteBuffer = ByteBuffer.wrap(bArr);
            byteBuffer.position(8);
            C0681nm.m12511a(byteBuffer, mo19f());
            mo6136b(byteBuffer);
        } else {
            byte[] bArr2 = new byte[12];
            bArr2[4] = this.f7512q.getBytes()[0];
            bArr2[5] = this.f7512q.getBytes()[1];
            bArr2[6] = this.f7512q.getBytes()[2];
            bArr2[7] = this.f7512q.getBytes()[3];
            byteBuffer = ByteBuffer.wrap(bArr2);
            C0681nm.m12515b(byteBuffer, mo19f());
            byteBuffer.position(8);
            mo6136b(byteBuffer);
        }
        byteBuffer.rewind();
        return byteBuffer;
    }
}
