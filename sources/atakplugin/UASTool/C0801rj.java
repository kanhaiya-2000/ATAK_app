package atakplugin.UASTool;

import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

/* renamed from: atakplugin.UASTool.rj */
public final class C0801rj extends C0791rb implements C0695nz {

    /* renamed from: b */
    public static final String f6082b = "mp4v";

    /* renamed from: c */
    public static final String f6083c = "s263";

    /* renamed from: d */
    public static final String f6084d = "avc1";

    /* renamed from: e */
    public static final String f6085e = "avc3";

    /* renamed from: f */
    public static final String f6086f = "drmi";

    /* renamed from: g */
    public static final String f6087g = "hvc1";

    /* renamed from: h */
    public static final String f6088h = "hev1";

    /* renamed from: i */
    public static final String f6089i = "encv";

    /* renamed from: j */
    static final /* synthetic */ boolean f6090j = true;

    /* renamed from: A */
    private long[] f6091A = new long[3];

    /* renamed from: k */
    private int f6092k;

    /* renamed from: l */
    private int f6093l;

    /* renamed from: m */
    private double f6094m = 72.0d;

    /* renamed from: n */
    private double f6095n = 72.0d;

    /* renamed from: o */
    private int f6096o = 1;

    /* renamed from: y */
    private String f6097y = "";

    /* renamed from: z */
    private int f6098z = 24;

    public C0801rj() {
        super(f6084d);
    }

    public C0801rj(String str) {
        super(str);
    }

    /* renamed from: a */
    public void mo5636a(String str) {
        this.f7512q = str;
    }

    /* renamed from: b */
    public int mo5637b() {
        return this.f6092k;
    }

    /* renamed from: b */
    public void mo5639b(int i) {
        this.f6092k = i;
    }

    /* renamed from: d */
    public int mo5642d() {
        return this.f6093l;
    }

    /* renamed from: c */
    public void mo5641c(int i) {
        this.f6093l = i;
    }

    /* renamed from: i */
    public double mo5645i() {
        return this.f6094m;
    }

    /* renamed from: a */
    public void mo5635a(double d) {
        this.f6094m = d;
    }

    /* renamed from: j */
    public double mo5646j() {
        return this.f6095n;
    }

    /* renamed from: b */
    public void mo5638b(double d) {
        this.f6095n = d;
    }

    /* renamed from: k */
    public int mo5647k() {
        return this.f6096o;
    }

    /* renamed from: d */
    public void mo5643d(int i) {
        this.f6096o = i;
    }

    /* renamed from: l */
    public String mo5648l() {
        return this.f6097y;
    }

    /* renamed from: b */
    public void mo5640b(String str) {
        this.f6097y = str;
    }

    /* renamed from: m */
    public int mo5649m() {
        return this.f6098z;
    }

    /* renamed from: e */
    public void mo5644e(int i) {
        this.f6098z = i;
    }

    /* renamed from: a */
    public void mo105a(C1007ws wsVar, ByteBuffer byteBuffer, long j, C0675ng ngVar) {
        long b = wsVar.mo5655b() + j;
        ByteBuffer allocate = ByteBuffer.allocate(78);
        wsVar.mo5650a(allocate);
        allocate.position(6);
        this.f6018a = C0679nk.m12497d(allocate);
        long d = (long) C0679nk.m12497d(allocate);
        boolean z = f6090j;
        if (z || 0 == d) {
            long d2 = (long) C0679nk.m12497d(allocate);
            if (z || 0 == d2) {
                this.f6091A[0] = C0679nk.m12495b(allocate);
                this.f6091A[1] = C0679nk.m12495b(allocate);
                this.f6091A[2] = C0679nk.m12495b(allocate);
                this.f6092k = C0679nk.m12497d(allocate);
                this.f6093l = C0679nk.m12497d(allocate);
                this.f6094m = C0679nk.m12502i(allocate);
                this.f6095n = C0679nk.m12502i(allocate);
                long b2 = C0679nk.m12495b(allocate);
                if (z || 0 == b2) {
                    this.f6096o = C0679nk.m12497d(allocate);
                    int f = C0679nk.m12499f(allocate);
                    if (f > 31) {
                        f = 31;
                    }
                    byte[] bArr = new byte[f];
                    allocate.get(bArr);
                    this.f6097y = C0684np.m12527a(bArr);
                    if (f < 31) {
                        allocate.get(new byte[(31 - f)]);
                    }
                    this.f6098z = C0679nk.m12497d(allocate);
                    long d3 = (long) C0679nk.m12497d(allocate);
                    if (z || 65535 == d3) {
                        mo6123a(new C0802rk(this, b, wsVar), j - 78, ngVar);
                        return;
                    }
                    throw new AssertionError();
                }
                throw new AssertionError("reserved byte not 0");
            }
            throw new AssertionError("reserved byte not 0");
        }
        throw new AssertionError("reserved byte not 0");
    }

    /* renamed from: a */
    public void mo18a(WritableByteChannel writableByteChannel) {
        writableByteChannel.write(mo6124t());
        ByteBuffer allocate = ByteBuffer.allocate(78);
        allocate.position(6);
        C0681nm.m12514b(allocate, this.f6018a);
        C0681nm.m12514b(allocate, 0);
        C0681nm.m12514b(allocate, 0);
        C0681nm.m12515b(allocate, this.f6091A[0]);
        C0681nm.m12515b(allocate, this.f6091A[1]);
        C0681nm.m12515b(allocate, this.f6091A[2]);
        C0681nm.m12514b(allocate, mo5637b());
        C0681nm.m12514b(allocate, mo5642d());
        C0681nm.m12509a(allocate, mo5645i());
        C0681nm.m12509a(allocate, mo5646j());
        C0681nm.m12515b(allocate, 0);
        C0681nm.m12514b(allocate, mo5647k());
        C0681nm.m12521d(allocate, C0684np.m12529b(mo5648l()));
        allocate.put(C0684np.m12528a(mo5648l()));
        int b = C0684np.m12529b(mo5648l());
        while (b < 31) {
            b++;
            allocate.put((byte) 0);
        }
        C0681nm.m12514b(allocate, mo5649m());
        C0681nm.m12514b(allocate, 65535);
        writableByteChannel.write((ByteBuffer) allocate.rewind());
        mo209b(writableByteChannel);
    }

    /* renamed from: f */
    public long mo19f() {
        long u = mo6130u() + 78;
        return u + ((long) ((this.f7513r || 8 + u >= 4294967296L) ? 16 : 8));
    }
}
