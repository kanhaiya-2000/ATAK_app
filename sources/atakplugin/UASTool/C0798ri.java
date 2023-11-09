package atakplugin.UASTool;

import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import java.util.Arrays;

/* renamed from: atakplugin.UASTool.ri */
public class C0798ri extends C0791rb {

    /* renamed from: b */
    public static final String f6064b = "tx3g";

    /* renamed from: c */
    public static final String f6065c = "enct";

    /* renamed from: d */
    private long f6066d;

    /* renamed from: e */
    private int f6067e;

    /* renamed from: f */
    private int f6068f;

    /* renamed from: g */
    private int[] f6069g = new int[4];

    /* renamed from: h */
    private C0799a f6070h = new C0799a();

    /* renamed from: i */
    private C0800b f6071i = new C0800b();

    public String toString() {
        return "TextSampleEntry";
    }

    public C0798ri() {
        super(f6064b);
    }

    public C0798ri(String str) {
        super(str);
    }

    /* renamed from: a */
    public void mo5604a(String str) {
        this.f7512q = str;
    }

    /* renamed from: a */
    public void mo105a(C1007ws wsVar, ByteBuffer byteBuffer, long j, C0675ng ngVar) {
        ByteBuffer allocate = ByteBuffer.allocate(38);
        wsVar.mo5650a(allocate);
        allocate.position(6);
        this.f6018a = C0679nk.m12497d(allocate);
        this.f6066d = C0679nk.m12495b(allocate);
        this.f6067e = C0679nk.m12499f(allocate);
        this.f6068f = C0679nk.m12499f(allocate);
        int[] iArr = new int[4];
        this.f6069g = iArr;
        iArr[0] = C0679nk.m12499f(allocate);
        this.f6069g[1] = C0679nk.m12499f(allocate);
        this.f6069g[2] = C0679nk.m12499f(allocate);
        this.f6069g[3] = C0679nk.m12499f(allocate);
        C0799a aVar = new C0799a();
        this.f6070h = aVar;
        aVar.mo5626a(allocate);
        C0800b bVar = new C0800b();
        this.f6071i = bVar;
        bVar.mo5631a(allocate);
        mo6123a(wsVar, j - 38, ngVar);
    }

    /* renamed from: a */
    public void mo18a(WritableByteChannel writableByteChannel) {
        writableByteChannel.write(mo6124t());
        ByteBuffer allocate = ByteBuffer.allocate(38);
        allocate.position(6);
        C0681nm.m12514b(allocate, this.f6018a);
        C0681nm.m12515b(allocate, this.f6066d);
        C0681nm.m12521d(allocate, this.f6067e);
        C0681nm.m12521d(allocate, this.f6068f);
        C0681nm.m12521d(allocate, this.f6069g[0]);
        C0681nm.m12521d(allocate, this.f6069g[1]);
        C0681nm.m12521d(allocate, this.f6069g[2]);
        C0681nm.m12521d(allocate, this.f6069g[3]);
        this.f6070h.mo5627b(allocate);
        this.f6071i.mo5632b(allocate);
        writableByteChannel.write((ByteBuffer) allocate.rewind());
        mo209b(writableByteChannel);
    }

    /* renamed from: b */
    public C0799a mo5607b() {
        return this.f6070h;
    }

    /* renamed from: a */
    public void mo5602a(C0799a aVar) {
        this.f6070h = aVar;
    }

    /* renamed from: d */
    public C0800b mo5612d() {
        return this.f6071i;
    }

    /* renamed from: a */
    public void mo5603a(C0800b bVar) {
        this.f6071i = bVar;
    }

    /* renamed from: i */
    public boolean mo5616i() {
        return (this.f6066d & 32) == 32;
    }

    /* renamed from: a */
    public void mo5605a(boolean z) {
        if (z) {
            this.f6066d |= 32;
        } else {
            this.f6066d &= -33;
        }
    }

    /* renamed from: j */
    public boolean mo5617j() {
        return (this.f6066d & 64) == 64;
    }

    /* renamed from: b */
    public void mo5609b(boolean z) {
        if (z) {
            this.f6066d |= 64;
        } else {
            this.f6066d &= -65;
        }
    }

    /* renamed from: k */
    public boolean mo5618k() {
        return (this.f6066d & 384) == 384;
    }

    /* renamed from: c */
    public void mo5611c(boolean z) {
        if (z) {
            this.f6066d |= 384;
        } else {
            this.f6066d &= -385;
        }
    }

    /* renamed from: l */
    public boolean mo5619l() {
        return (this.f6066d & 2048) == 2048;
    }

    /* renamed from: d */
    public void mo5613d(boolean z) {
        if (z) {
            this.f6066d |= 2048;
        } else {
            this.f6066d &= -2049;
        }
    }

    /* renamed from: m */
    public boolean mo5620m() {
        return (this.f6066d & 131072) == 131072;
    }

    /* renamed from: e */
    public void mo5614e(boolean z) {
        if (z) {
            this.f6066d |= 131072;
        } else {
            this.f6066d &= -131073;
        }
    }

    /* renamed from: n */
    public boolean mo5621n() {
        return (this.f6066d & 262144) == 262144;
    }

    /* renamed from: f */
    public void mo5615f(boolean z) {
        if (z) {
            this.f6066d |= 262144;
        } else {
            this.f6066d &= -262145;
        }
    }

    /* renamed from: o */
    public int mo5622o() {
        return this.f6067e;
    }

    /* renamed from: b */
    public void mo5608b(int i) {
        this.f6067e = i;
    }

    /* renamed from: p */
    public int mo5623p() {
        return this.f6068f;
    }

    /* renamed from: c */
    public void mo5610c(int i) {
        this.f6068f = i;
    }

    /* renamed from: q */
    public int[] mo5624q() {
        return this.f6069g;
    }

    /* renamed from: a */
    public void mo5606a(int[] iArr) {
        this.f6069g = iArr;
    }

    /* renamed from: atakplugin.UASTool.ri$a */
    public static class C0799a {

        /* renamed from: a */
        int f6072a;

        /* renamed from: b */
        int f6073b;

        /* renamed from: c */
        int f6074c;

        /* renamed from: d */
        int f6075d;

        /* renamed from: a */
        public int mo5625a() {
            return 8;
        }

        public C0799a() {
        }

        public C0799a(int i, int i2, int i3, int i4) {
            this.f6072a = i;
            this.f6073b = i2;
            this.f6074c = i3;
            this.f6075d = i4;
        }

        /* renamed from: a */
        public void mo5626a(ByteBuffer byteBuffer) {
            this.f6072a = C0679nk.m12497d(byteBuffer);
            this.f6073b = C0679nk.m12497d(byteBuffer);
            this.f6074c = C0679nk.m12497d(byteBuffer);
            this.f6075d = C0679nk.m12497d(byteBuffer);
        }

        /* renamed from: b */
        public void mo5627b(ByteBuffer byteBuffer) {
            C0681nm.m12514b(byteBuffer, this.f6072a);
            C0681nm.m12514b(byteBuffer, this.f6073b);
            C0681nm.m12514b(byteBuffer, this.f6074c);
            C0681nm.m12514b(byteBuffer, this.f6075d);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            C0799a aVar = (C0799a) obj;
            return this.f6074c == aVar.f6074c && this.f6073b == aVar.f6073b && this.f6075d == aVar.f6075d && this.f6072a == aVar.f6072a;
        }

        public int hashCode() {
            return (((((this.f6072a * 31) + this.f6073b) * 31) + this.f6074c) * 31) + this.f6075d;
        }
    }

    /* renamed from: atakplugin.UASTool.ri$b */
    public static class C0800b {

        /* renamed from: a */
        int f6076a;

        /* renamed from: b */
        int f6077b;

        /* renamed from: c */
        int f6078c;

        /* renamed from: d */
        int f6079d;

        /* renamed from: e */
        int f6080e;

        /* renamed from: f */
        int[] f6081f = {255, 255, 255, 255};

        /* renamed from: a */
        public int mo5630a() {
            return 12;
        }

        public C0800b() {
        }

        public C0800b(int i, int i2, int i3, int i4, int i5, int[] iArr) {
            this.f6076a = i;
            this.f6077b = i2;
            this.f6078c = i3;
            this.f6079d = i4;
            this.f6080e = i5;
            this.f6081f = iArr;
        }

        /* renamed from: a */
        public void mo5631a(ByteBuffer byteBuffer) {
            this.f6076a = C0679nk.m12497d(byteBuffer);
            this.f6077b = C0679nk.m12497d(byteBuffer);
            this.f6078c = C0679nk.m12497d(byteBuffer);
            this.f6079d = C0679nk.m12499f(byteBuffer);
            this.f6080e = C0679nk.m12499f(byteBuffer);
            int[] iArr = new int[4];
            this.f6081f = iArr;
            iArr[0] = C0679nk.m12499f(byteBuffer);
            this.f6081f[1] = C0679nk.m12499f(byteBuffer);
            this.f6081f[2] = C0679nk.m12499f(byteBuffer);
            this.f6081f[3] = C0679nk.m12499f(byteBuffer);
        }

        /* renamed from: b */
        public void mo5632b(ByteBuffer byteBuffer) {
            C0681nm.m12514b(byteBuffer, this.f6076a);
            C0681nm.m12514b(byteBuffer, this.f6077b);
            C0681nm.m12514b(byteBuffer, this.f6078c);
            C0681nm.m12521d(byteBuffer, this.f6079d);
            C0681nm.m12521d(byteBuffer, this.f6080e);
            C0681nm.m12521d(byteBuffer, this.f6081f[0]);
            C0681nm.m12521d(byteBuffer, this.f6081f[1]);
            C0681nm.m12521d(byteBuffer, this.f6081f[2]);
            C0681nm.m12521d(byteBuffer, this.f6081f[3]);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            C0800b bVar = (C0800b) obj;
            return this.f6077b == bVar.f6077b && this.f6079d == bVar.f6079d && this.f6078c == bVar.f6078c && this.f6080e == bVar.f6080e && this.f6076a == bVar.f6076a && Arrays.equals(this.f6081f, bVar.f6081f);
        }

        public int hashCode() {
            int i = ((((((((this.f6076a * 31) + this.f6077b) * 31) + this.f6078c) * 31) + this.f6079d) * 31) + this.f6080e) * 31;
            int[] iArr = this.f6081f;
            return i + (iArr != null ? Arrays.hashCode(iArr) : 0);
        }
    }

    /* renamed from: f */
    public long mo19f() {
        long u = mo6130u() + 38;
        return u + ((long) ((this.f7513r || u >= 4294967296L) ? 16 : 8));
    }
}
