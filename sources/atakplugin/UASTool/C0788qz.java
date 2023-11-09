package atakplugin.UASTool;

import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import java.util.logging.Logger;

/* renamed from: atakplugin.UASTool.qz */
public final class C0788qz implements C0688nt {

    /* renamed from: a */
    public static final String f6010a = "mdat";

    /* renamed from: d */
    private static Logger f6011d = Logger.getLogger(C0788qz.class.getName());

    /* renamed from: b */
    C0695nz f6012b;

    /* renamed from: c */
    boolean f6013c = false;

    /* renamed from: e */
    private C1007ws f6014e;

    /* renamed from: f */
    private long f6015f;

    /* renamed from: g */
    private long f6016g;

    /* renamed from: h */
    public String mo1476h() {
        return f6010a;
    }

    /* renamed from: e */
    public C0695nz mo1474e() {
        return this.f6012b;
    }

    /* renamed from: a */
    public void mo1473a(C0695nz nzVar) {
        this.f6012b = nzVar;
    }

    /* renamed from: a */
    private static void m13284a(C1007ws wsVar, long j, long j2, WritableByteChannel writableByteChannel) {
        long j3 = 0;
        while (j3 < j2) {
            j3 += wsVar.mo5652a(j + j3, Math.min(67076096, j2 - j3), writableByteChannel);
        }
    }

    /* renamed from: a */
    public void mo18a(WritableByteChannel writableByteChannel) {
        m13284a(this.f6014e, this.f6015f, this.f6016g, writableByteChannel);
    }

    /* renamed from: f */
    public long mo19f() {
        return this.f6016g;
    }

    /* renamed from: g */
    public long mo1475g() {
        return this.f6015f;
    }

    /* renamed from: a */
    public void mo105a(C1007ws wsVar, ByteBuffer byteBuffer, long j, C0675ng ngVar) {
        this.f6015f = wsVar.mo5655b() - ((long) byteBuffer.remaining());
        this.f6014e = wsVar;
        this.f6016g = ((long) byteBuffer.remaining()) + j;
        wsVar.mo5654a(wsVar.mo5655b() + j);
    }

    public String toString() {
        return "MediaDataBox{size=" + this.f6016g + '}';
    }
}
