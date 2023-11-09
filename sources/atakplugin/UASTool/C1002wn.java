package atakplugin.UASTool;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

/* renamed from: atakplugin.UASTool.wn */
public abstract class C1002wn implements C0688nt {

    /* renamed from: a */
    private static afp f7497a = afp.m867a(C1002wn.class);

    /* renamed from: n */
    static final /* synthetic */ boolean f7498n = true;

    /* renamed from: b */
    private byte[] f7499b;

    /* renamed from: c */
    private C0695nz f7500c;

    /* renamed from: d */
    private ByteBuffer f7501d;

    /* renamed from: e */
    private ByteBuffer f7502e = null;

    /* renamed from: g */
    protected String f7503g;

    /* renamed from: h */
    boolean f7504h;

    /* renamed from: i */
    boolean f7505i;

    /* renamed from: j */
    long f7506j;

    /* renamed from: k */
    long f7507k;

    /* renamed from: l */
    long f7508l = -1;

    /* renamed from: m */
    C1007ws f7509m;

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo32a(ByteBuffer byteBuffer);

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract void mo35b(ByteBuffer byteBuffer);

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public abstract long mo38d();

    /* renamed from: c */
    private synchronized void mo36c() {
        if (!this.f7505i) {
            try {
                afp afp = f7497a;
                afp.mo574a("mem mapping " + mo1476h());
                this.f7501d = this.f7509m.mo5653a(this.f7506j, this.f7508l);
                this.f7505i = true;
            } catch (IOException e) {
                throw new RuntimeException("contentStartPosition: " + this.f7506j + " memMapSize: " + this.f7508l, e);
            }
        }
    }

    /* renamed from: g */
    public long mo1475g() {
        return this.f7507k;
    }

    protected C1002wn(String str) {
        this.f7503g = str;
        this.f7505i = true;
        this.f7504h = true;
    }

    protected C1002wn(String str, byte[] bArr) {
        this.f7503g = str;
        this.f7499b = bArr;
        this.f7505i = true;
        this.f7504h = true;
    }

    @C1016xa
    /* renamed from: a */
    public void mo105a(C1007ws wsVar, ByteBuffer byteBuffer, long j, C0675ng ngVar) {
        long b = wsVar.mo5655b();
        this.f7506j = b;
        this.f7507k = b - ((long) byteBuffer.remaining());
        this.f7508l = j;
        this.f7509m = wsVar;
        wsVar.mo5654a(wsVar.mo5655b() + j);
        this.f7505i = false;
        this.f7504h = false;
    }

    /* renamed from: a */
    public void mo18a(WritableByteChannel writableByteChannel) {
        int i = 8;
        int i2 = 0;
        int i3 = 16;
        if (!this.f7505i) {
            if (!mo43i()) {
                i = 16;
            }
            if (C0758pz.f5795b.equals(mo1476h())) {
                i2 = 16;
            }
            ByteBuffer allocate = ByteBuffer.allocate(i + i2);
            mo115d(allocate);
            writableByteChannel.write((ByteBuffer) allocate.rewind());
            this.f7509m.mo5652a(this.f7506j, this.f7508l, writableByteChannel);
        } else if (this.f7504h) {
            ByteBuffer allocate2 = ByteBuffer.allocate(afi.m847a(mo19f()));
            mo115d(allocate2);
            mo35b(allocate2);
            ByteBuffer byteBuffer = this.f7502e;
            if (byteBuffer != null) {
                byteBuffer.rewind();
                while (this.f7502e.remaining() > 0) {
                    allocate2.put(this.f7502e);
                }
            }
            writableByteChannel.write((ByteBuffer) allocate2.rewind());
        } else {
            if (!mo43i()) {
                i = 16;
            }
            if (!C0758pz.f5795b.equals(mo1476h())) {
                i3 = 0;
            }
            ByteBuffer allocate3 = ByteBuffer.allocate(i + i3);
            mo115d(allocate3);
            writableByteChannel.write((ByteBuffer) allocate3.rewind());
            writableByteChannel.write((ByteBuffer) this.f7501d.position(0));
        }
    }

    /* renamed from: v */
    public final synchronized void mo6120v() {
        mo36c();
        afp afp = f7497a;
        afp.mo574a("parsing details of " + mo1476h());
        ByteBuffer byteBuffer = this.f7501d;
        if (byteBuffer != null) {
            this.f7504h = true;
            byteBuffer.rewind();
            mo32a(byteBuffer);
            if (byteBuffer.remaining() > 0) {
                this.f7502e = byteBuffer.slice();
            }
            this.f7501d = null;
            if (!f7498n) {
                if (!mo112c(byteBuffer)) {
                    throw new AssertionError();
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public void mo6119e(ByteBuffer byteBuffer) {
        this.f7502e = byteBuffer;
    }

    /* renamed from: f */
    public long mo19f() {
        long j;
        int i = 0;
        if (!this.f7505i) {
            j = this.f7508l;
        } else if (this.f7504h) {
            j = mo38d();
        } else {
            ByteBuffer byteBuffer = this.f7501d;
            j = (long) (byteBuffer != null ? byteBuffer.limit() : 0);
        }
        long j2 = j + ((long) ((j >= 4294967288L ? 8 : 0) + 8 + (C0758pz.f5795b.equals(mo1476h()) ? 16 : 0)));
        ByteBuffer byteBuffer2 = this.f7502e;
        if (byteBuffer2 != null) {
            i = byteBuffer2.limit();
        }
        return j2 + ((long) i);
    }

    @C1016xa
    /* renamed from: h */
    public String mo1476h() {
        return this.f7503g;
    }

    @C1016xa
    /* renamed from: w */
    public byte[] mo455w() {
        return this.f7499b;
    }

    @C1016xa
    /* renamed from: e */
    public C0695nz mo1474e() {
        return this.f7500c;
    }

    @C1016xa
    /* renamed from: a */
    public void mo1473a(C0695nz nzVar) {
        this.f7500c = nzVar;
    }

    /* renamed from: x */
    public boolean mo6121x() {
        return this.f7504h;
    }

    /* renamed from: c */
    private boolean mo112c(ByteBuffer byteBuffer) {
        long d = mo38d();
        ByteBuffer byteBuffer2 = this.f7502e;
        ByteBuffer allocate = ByteBuffer.allocate(afi.m847a(d + ((long) (byteBuffer2 != null ? byteBuffer2.limit() : 0))));
        mo35b(allocate);
        ByteBuffer byteBuffer3 = this.f7502e;
        if (byteBuffer3 != null) {
            byteBuffer3.rewind();
            while (this.f7502e.remaining() > 0) {
                allocate.put(this.f7502e);
            }
        }
        byteBuffer.rewind();
        allocate.rewind();
        if (byteBuffer.remaining() != allocate.remaining()) {
            System.err.print(String.valueOf(mo1476h()) + ": remaining differs " + byteBuffer.remaining() + " vs. " + allocate.remaining());
            f7497a.mo576c(String.valueOf(mo1476h()) + ": remaining differs " + byteBuffer.remaining() + " vs. " + allocate.remaining());
            return false;
        }
        int position = byteBuffer.position();
        int limit = byteBuffer.limit() - 1;
        int limit2 = allocate.limit() - 1;
        while (limit >= position) {
            byte b = byteBuffer.get(limit);
            byte b2 = allocate.get(limit2);
            if (b != b2) {
                f7497a.mo576c(String.format("%s: buffers differ at %d: %2X/%2X", new Object[]{mo1476h(), Integer.valueOf(limit), Byte.valueOf(b), Byte.valueOf(b2)}));
                byte[] bArr = new byte[byteBuffer.remaining()];
                byte[] bArr2 = new byte[allocate.remaining()];
                byteBuffer.get(bArr);
                allocate.get(bArr2);
                System.err.println("original      : " + C0677ni.m12485a(bArr, 4));
                System.err.println("reconstructed : " + C0677ni.m12485a(bArr2, 4));
                return false;
            }
            limit--;
            limit2--;
        }
        return true;
    }

    /* renamed from: i */
    private boolean mo43i() {
        int i = C0758pz.f5795b.equals(mo1476h()) ? 24 : 8;
        if (!this.f7505i) {
            return this.f7508l + ((long) i) < 4294967296L;
        }
        if (!this.f7504h) {
            return ((long) (this.f7501d.limit() + i)) < 4294967296L;
        }
        long d = mo38d();
        ByteBuffer byteBuffer = this.f7502e;
        return (d + ((long) (byteBuffer != null ? byteBuffer.limit() : 0))) + ((long) i) < 4294967296L;
    }

    /* renamed from: d */
    private void mo115d(ByteBuffer byteBuffer) {
        if (mo43i()) {
            C0681nm.m12515b(byteBuffer, mo19f());
            byteBuffer.put(C0678nj.m12488a(mo1476h()));
        } else {
            C0681nm.m12515b(byteBuffer, 1);
            byteBuffer.put(C0678nj.m12488a(mo1476h()));
            C0681nm.m12511a(byteBuffer, mo19f());
        }
        if (C0758pz.f5795b.equals(mo1476h())) {
            byteBuffer.put(mo455w());
        }
    }

    @C1016xa
    /* renamed from: y */
    public String mo6122y() {
        return aft.m884a(this);
    }
}
