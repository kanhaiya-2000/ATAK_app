package atakplugin.UASTool;

import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

public class aln extends C0791rb {

    /* renamed from: b */
    public static final String f1968b = "stpp";

    /* renamed from: c */
    private String f1969c = "";

    /* renamed from: d */
    private String f1970d = "";

    /* renamed from: e */
    private String f1971e = "";

    public aln() {
        super(f1968b);
    }

    /* renamed from: f */
    public long mo19f() {
        int i = 8;
        long u = mo6130u() + ((long) (this.f1969c.length() + 8 + this.f1970d.length() + this.f1971e.length() + 3));
        if (this.f7513r || 8 + u >= 4294967296L) {
            i = 16;
        }
        return u + ((long) i);
    }

    /* renamed from: a */
    public void mo105a(C1007ws wsVar, ByteBuffer byteBuffer, long j, C0675ng ngVar) {
        ByteBuffer allocate = ByteBuffer.allocate(8);
        wsVar.mo5650a((ByteBuffer) allocate.rewind());
        allocate.position(6);
        this.f6018a = C0679nk.m12497d(allocate);
        long b = wsVar.mo5655b();
        ByteBuffer allocate2 = ByteBuffer.allocate(1024);
        wsVar.mo5650a((ByteBuffer) allocate2.rewind());
        String g = C0679nk.m12500g((ByteBuffer) allocate2.rewind());
        this.f1969c = g;
        wsVar.mo5654a(((long) g.length()) + b + 1);
        wsVar.mo5650a((ByteBuffer) allocate2.rewind());
        this.f1970d = C0679nk.m12500g((ByteBuffer) allocate2.rewind());
        wsVar.mo5654a(((long) this.f1969c.length()) + b + ((long) this.f1970d.length()) + 2);
        wsVar.mo5650a((ByteBuffer) allocate2.rewind());
        this.f1971e = C0679nk.m12500g((ByteBuffer) allocate2.rewind());
        wsVar.mo5654a(b + ((long) this.f1969c.length()) + ((long) this.f1970d.length()) + ((long) this.f1971e.length()) + 3);
        mo6123a(wsVar, j - ((long) ((((byteBuffer.remaining() + this.f1969c.length()) + this.f1970d.length()) + this.f1971e.length()) + 3)), ngVar);
    }

    /* renamed from: a */
    public void mo18a(WritableByteChannel writableByteChannel) {
        writableByteChannel.write(mo6124t());
        ByteBuffer allocate = ByteBuffer.allocate(this.f1969c.length() + 8 + this.f1970d.length() + this.f1971e.length() + 3);
        allocate.position(6);
        C0681nm.m12514b(allocate, this.f6018a);
        C0681nm.m12520c(allocate, this.f1969c);
        C0681nm.m12520c(allocate, this.f1970d);
        C0681nm.m12520c(allocate, this.f1971e);
        writableByteChannel.write((ByteBuffer) allocate.rewind());
        mo209b(writableByteChannel);
    }

    /* renamed from: b */
    public String mo1396b() {
        return this.f1969c;
    }

    /* renamed from: a */
    public void mo1395a(String str) {
        this.f1969c = str;
    }

    /* renamed from: d */
    public String mo1399d() {
        return this.f1970d;
    }

    /* renamed from: b */
    public void mo1397b(String str) {
        this.f1970d = str;
    }

    /* renamed from: i */
    public String mo1400i() {
        return this.f1971e;
    }

    /* renamed from: c */
    public void mo1398c(String str) {
        this.f1971e = str;
    }
}
