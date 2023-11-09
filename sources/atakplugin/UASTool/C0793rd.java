package atakplugin.UASTool;

import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

/* renamed from: atakplugin.UASTool.rd */
public final class C0793rd extends C0791rb {

    /* renamed from: b */
    public static final String f6032b = "samr";

    /* renamed from: c */
    public static final String f6033c = "sawb";

    /* renamed from: d */
    public static final String f6034d = "mp4a";

    /* renamed from: e */
    public static final String f6035e = "drms";

    /* renamed from: f */
    public static final String f6036f = "alac";

    /* renamed from: g */
    public static final String f6037g = "owma";

    /* renamed from: h */
    public static final String f6038h = "ac-3";

    /* renamed from: i */
    public static final String f6039i = "ec-3";

    /* renamed from: j */
    public static final String f6040j = "mlpa";

    /* renamed from: k */
    public static final String f6041k = "dtsl";

    /* renamed from: l */
    public static final String f6042l = "dtsh";

    /* renamed from: m */
    public static final String f6043m = "dtse";

    /* renamed from: n */
    public static final String f6044n = "enca";

    /* renamed from: o */
    static final /* synthetic */ boolean f6045o = true;

    /* renamed from: A */
    private long f6046A;

    /* renamed from: B */
    private int f6047B;

    /* renamed from: C */
    private int f6048C;

    /* renamed from: D */
    private int f6049D;

    /* renamed from: E */
    private long f6050E;

    /* renamed from: F */
    private long f6051F;

    /* renamed from: G */
    private long f6052G;

    /* renamed from: H */
    private long f6053H;

    /* renamed from: I */
    private int f6054I;

    /* renamed from: J */
    private long f6055J;

    /* renamed from: K */
    private byte[] f6056K;

    /* renamed from: y */
    private int f6057y;

    /* renamed from: z */
    private int f6058z;

    public C0793rd(String str) {
        super(str);
    }

    /* renamed from: a */
    public void mo5574a(String str) {
        this.f7512q = str;
    }

    /* renamed from: b */
    public int mo5576b() {
        return this.f6057y;
    }

    /* renamed from: d */
    public int mo5581d() {
        return this.f6058z;
    }

    /* renamed from: i */
    public long mo5589i() {
        return this.f6046A;
    }

    /* renamed from: j */
    public int mo5590j() {
        return this.f6047B;
    }

    /* renamed from: k */
    public int mo5591k() {
        return this.f6048C;
    }

    /* renamed from: l */
    public int mo5592l() {
        return this.f6049D;
    }

    /* renamed from: m */
    public long mo5593m() {
        return this.f6050E;
    }

    /* renamed from: n */
    public long mo5594n() {
        return this.f6051F;
    }

    /* renamed from: o */
    public long mo5595o() {
        return this.f6052G;
    }

    /* renamed from: p */
    public long mo5596p() {
        return this.f6053H;
    }

    /* renamed from: q */
    public byte[] mo5597q() {
        return this.f6056K;
    }

    /* renamed from: r */
    public int mo5598r() {
        return this.f6054I;
    }

    /* renamed from: s */
    public long mo5599s() {
        return this.f6055J;
    }

    /* renamed from: b */
    public void mo5577b(int i) {
        this.f6057y = i;
    }

    /* renamed from: c */
    public void mo5579c(int i) {
        this.f6058z = i;
    }

    /* renamed from: a */
    public void mo5573a(long j) {
        this.f6046A = j;
    }

    /* renamed from: d */
    public void mo5582d(int i) {
        this.f6047B = i;
    }

    /* renamed from: e */
    public void mo5584e(int i) {
        this.f6048C = i;
    }

    /* renamed from: f */
    public void mo5586f(int i) {
        this.f6049D = i;
    }

    /* renamed from: b */
    public void mo5578b(long j) {
        this.f6050E = j;
    }

    /* renamed from: c */
    public void mo5580c(long j) {
        this.f6051F = j;
    }

    /* renamed from: d */
    public void mo5583d(long j) {
        this.f6052G = j;
    }

    /* renamed from: e */
    public void mo5585e(long j) {
        this.f6053H = j;
    }

    /* renamed from: g */
    public void mo5588g(int i) {
        this.f6054I = i;
    }

    /* renamed from: f */
    public void mo5587f(long j) {
        this.f6055J = j;
    }

    /* renamed from: a */
    public void mo5575a(byte[] bArr) {
        this.f6056K = bArr;
    }

    /* renamed from: a */
    public void mo105a(C1007ws wsVar, ByteBuffer byteBuffer, long j, C0675ng ngVar) {
        ByteBuffer allocate = ByteBuffer.allocate(28);
        wsVar.mo5650a(allocate);
        allocate.position(6);
        this.f6018a = C0679nk.m12497d(allocate);
        this.f6047B = C0679nk.m12497d(allocate);
        this.f6054I = C0679nk.m12497d(allocate);
        this.f6055J = C0679nk.m12495b(allocate);
        this.f6057y = C0679nk.m12497d(allocate);
        this.f6058z = C0679nk.m12497d(allocate);
        this.f6048C = C0679nk.m12497d(allocate);
        this.f6049D = C0679nk.m12497d(allocate);
        this.f6046A = C0679nk.m12495b(allocate);
        int i = 16;
        if (!this.f7512q.equals(f6040j)) {
            this.f6046A >>>= 16;
        }
        if (this.f6047B == 1) {
            ByteBuffer allocate2 = ByteBuffer.allocate(16);
            wsVar.mo5650a(allocate2);
            allocate2.rewind();
            this.f6050E = C0679nk.m12495b(allocate2);
            this.f6051F = C0679nk.m12495b(allocate2);
            this.f6052G = C0679nk.m12495b(allocate2);
            this.f6053H = C0679nk.m12495b(allocate2);
        }
        int i2 = 36;
        if (this.f6047B == 2) {
            ByteBuffer allocate3 = ByteBuffer.allocate(36);
            wsVar.mo5650a(allocate3);
            allocate3.rewind();
            this.f6050E = C0679nk.m12495b(allocate3);
            this.f6051F = C0679nk.m12495b(allocate3);
            this.f6052G = C0679nk.m12495b(allocate3);
            this.f6053H = C0679nk.m12495b(allocate3);
            byte[] bArr = new byte[20];
            this.f6056K = bArr;
            allocate3.get(bArr);
        }
        if (f6037g.equals(this.f7512q)) {
            System.err.println(f6037g);
            long j2 = j - 28;
            int i3 = this.f6047B;
            if (i3 != 1) {
                i = 0;
            }
            long j3 = j2 - ((long) i);
            if (i3 != 2) {
                i2 = 0;
            }
            long j4 = j3 - ((long) i2);
            ByteBuffer allocate4 = ByteBuffer.allocate(afi.m847a(j4));
            wsVar.mo5650a(allocate4);
            mo170a((C0688nt) new C0794re(this, j4, allocate4));
            return;
        }
        long j5 = j - 28;
        int i4 = this.f6047B;
        if (i4 != 1) {
            i = 0;
        }
        long j6 = j5 - ((long) i);
        if (i4 != 2) {
            i2 = 0;
        }
        mo6123a(wsVar, j6 - ((long) i2), ngVar);
    }

    /* renamed from: a */
    public void mo18a(WritableByteChannel writableByteChannel) {
        writableByteChannel.write(mo6124t());
        int i = this.f6047B;
        int i2 = 0;
        int i3 = (i == 1 ? 16 : 0) + 28;
        if (i == 2) {
            i2 = 36;
        }
        ByteBuffer allocate = ByteBuffer.allocate(i3 + i2);
        allocate.position(6);
        C0681nm.m12514b(allocate, this.f6018a);
        C0681nm.m12514b(allocate, this.f6047B);
        C0681nm.m12514b(allocate, this.f6054I);
        C0681nm.m12515b(allocate, this.f6055J);
        C0681nm.m12514b(allocate, this.f6057y);
        C0681nm.m12514b(allocate, this.f6058z);
        C0681nm.m12514b(allocate, this.f6048C);
        C0681nm.m12514b(allocate, this.f6049D);
        if (this.f7512q.equals(f6040j)) {
            C0681nm.m12515b(allocate, mo5589i());
        } else {
            C0681nm.m12515b(allocate, mo5589i() << 16);
        }
        if (this.f6047B == 1) {
            C0681nm.m12515b(allocate, this.f6050E);
            C0681nm.m12515b(allocate, this.f6051F);
            C0681nm.m12515b(allocate, this.f6052G);
            C0681nm.m12515b(allocate, this.f6053H);
        }
        if (this.f6047B == 2) {
            C0681nm.m12515b(allocate, this.f6050E);
            C0681nm.m12515b(allocate, this.f6051F);
            C0681nm.m12515b(allocate, this.f6052G);
            C0681nm.m12515b(allocate, this.f6053H);
            allocate.put(this.f6056K);
        }
        writableByteChannel.write((ByteBuffer) allocate.rewind());
        mo209b(writableByteChannel);
    }

    /* renamed from: f */
    public long mo19f() {
        int i = this.f6047B;
        int i2 = 16;
        int i3 = 0;
        int i4 = (i == 1 ? 16 : 0) + 28;
        if (i == 2) {
            i3 = 36;
        }
        long u = ((long) (i4 + i3)) + mo6130u();
        if (!this.f7513r && 8 + u < 4294967296L) {
            i2 = 8;
        }
        return u + ((long) i2);
    }

    public String toString() {
        return "AudioSampleEntry{bytesPerSample=" + this.f6053H + ", bytesPerFrame=" + this.f6052G + ", bytesPerPacket=" + this.f6051F + ", samplesPerPacket=" + this.f6050E + ", packetSize=" + this.f6049D + ", compressionId=" + this.f6048C + ", soundVersion=" + this.f6047B + ", sampleRate=" + this.f6046A + ", sampleSize=" + this.f6058z + ", channelCount=" + this.f6057y + ", boxes=" + mo36c() + '}';
    }
}
