package atakplugin.UASTool;

import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

/* renamed from: atakplugin.UASTool.xs */
class C1036xs implements C0688nt {

    /* renamed from: a */
    C0695nz f7607a;

    /* renamed from: b */
    long f7608b = -1;

    /* renamed from: c */
    final /* synthetic */ C1034xq f7609c;

    /* renamed from: d */
    private final /* synthetic */ long f7610d;

    /* renamed from: e */
    private final /* synthetic */ long f7611e;

    /* renamed from: f */
    private final /* synthetic */ C1026xj f7612f;

    /* renamed from: a */
    public void mo105a(C1007ws wsVar, ByteBuffer byteBuffer, long j, C0675ng ngVar) {
    }

    /* renamed from: h */
    public String mo1476h() {
        return C0788qz.f6010a;
    }

    C1036xs(C1034xq xqVar, long j, long j2, C1026xj xjVar) {
        this.f7609c = xqVar;
        this.f7610d = j;
        this.f7611e = j2;
        this.f7612f = xjVar;
    }

    /* renamed from: e */
    public C0695nz mo1474e() {
        return this.f7607a;
    }

    /* renamed from: a */
    public void mo1473a(C0695nz nzVar) {
        this.f7607a = nzVar;
    }

    /* renamed from: g */
    public long mo1475g() {
        throw new RuntimeException("Doesn't have any meaning for programmatically created boxes");
    }

    /* renamed from: f */
    public long mo19f() {
        long j = this.f7608b;
        if (j != -1) {
            return j;
        }
        long j2 = 8;
        for (C1024xh a : this.f7609c.mo6227a(this.f7610d, this.f7611e, this.f7612f)) {
            j2 += a.mo7a();
        }
        this.f7608b = j2;
        return j2;
    }

    /* renamed from: a */
    public void mo18a(WritableByteChannel writableByteChannel) {
        ByteBuffer allocate = ByteBuffer.allocate(8);
        C0681nm.m12515b(allocate, (long) afi.m847a(mo19f()));
        allocate.put(C0678nj.m12488a(mo1476h()));
        allocate.rewind();
        writableByteChannel.write(allocate);
        for (C1024xh a : this.f7609c.mo6227a(this.f7610d, this.f7611e, this.f7612f)) {
            a.mo8a(writableByteChannel);
        }
    }
}
