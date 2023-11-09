package atakplugin.UASTool;

import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import java.util.List;

public class acm extends C0791rb {

    /* renamed from: b */
    public static final String f267b = "text";

    /* renamed from: A */
    int f268A;

    /* renamed from: c */
    int f269c;

    /* renamed from: d */
    int f270d;

    /* renamed from: e */
    int f271e;

    /* renamed from: f */
    int f272f;

    /* renamed from: g */
    int f273g;

    /* renamed from: h */
    long f274h;

    /* renamed from: i */
    long f275i;

    /* renamed from: j */
    short f276j;

    /* renamed from: k */
    short f277k;

    /* renamed from: l */
    byte f278l;

    /* renamed from: m */
    short f279m;

    /* renamed from: n */
    int f280n = 65535;

    /* renamed from: o */
    int f281o = 65535;

    /* renamed from: y */
    int f282y = 65535;

    /* renamed from: z */
    String f283z = "";

    public acm() {
        super("text");
    }

    /* renamed from: a */
    public void mo105a(C1007ws wsVar, ByteBuffer byteBuffer, long j, C0675ng ngVar) {
        ByteBuffer allocate = ByteBuffer.allocate(afi.m847a(j));
        wsVar.mo5650a(allocate);
        allocate.position(6);
        this.f268A = C0679nk.m12497d(allocate);
        this.f269c = allocate.getInt();
        this.f270d = allocate.getInt();
        this.f271e = C0679nk.m12497d(allocate);
        this.f272f = C0679nk.m12497d(allocate);
        this.f273g = C0679nk.m12497d(allocate);
        this.f274h = C0679nk.m12501h(allocate);
        this.f275i = C0679nk.m12501h(allocate);
        this.f276j = allocate.getShort();
        this.f277k = allocate.getShort();
        this.f278l = allocate.get();
        this.f279m = allocate.getShort();
        this.f280n = C0679nk.m12497d(allocate);
        this.f281o = C0679nk.m12497d(allocate);
        this.f282y = C0679nk.m12497d(allocate);
        if (allocate.remaining() > 0) {
            byte[] bArr = new byte[C0679nk.m12499f(allocate)];
            allocate.get(bArr);
            this.f283z = new String(bArr);
            return;
        }
        this.f283z = null;
    }

    /* renamed from: a */
    public void mo172a(List<C0688nt> list) {
        throw new RuntimeException("QuicktimeTextSampleEntries may not have child boxes");
    }

    /* renamed from: a */
    public void mo170a(C0688nt ntVar) {
        throw new RuntimeException("QuicktimeTextSampleEntries may not have child boxes");
    }

    /* renamed from: a */
    public void mo18a(WritableByteChannel writableByteChannel) {
        writableByteChannel.write(mo6124t());
        String str = this.f283z;
        ByteBuffer allocate = ByteBuffer.allocate((str != null ? str.length() : 0) + 52);
        allocate.position(6);
        C0681nm.m12514b(allocate, this.f268A);
        allocate.putInt(this.f269c);
        allocate.putInt(this.f270d);
        C0681nm.m12514b(allocate, this.f271e);
        C0681nm.m12514b(allocate, this.f272f);
        C0681nm.m12514b(allocate, this.f273g);
        C0681nm.m12511a(allocate, this.f274h);
        C0681nm.m12511a(allocate, this.f275i);
        allocate.putShort(this.f276j);
        allocate.putShort(this.f277k);
        allocate.put(this.f278l);
        allocate.putShort(this.f279m);
        C0681nm.m12514b(allocate, this.f280n);
        C0681nm.m12514b(allocate, this.f281o);
        C0681nm.m12514b(allocate, this.f282y);
        String str2 = this.f283z;
        if (str2 != null) {
            C0681nm.m12521d(allocate, str2.length());
            allocate.put(this.f283z.getBytes());
        }
        writableByteChannel.write((ByteBuffer) allocate.rewind());
    }

    /* renamed from: f */
    public long mo19f() {
        long u = mo6130u() + 52;
        String str = this.f283z;
        long length = u + ((long) (str != null ? str.length() : 0));
        return length + ((long) ((this.f7513r || 8 + length >= 4294967296L) ? 16 : 8));
    }

    /* renamed from: b */
    public int mo174b() {
        return this.f269c;
    }

    /* renamed from: b */
    public void mo175b(int i) {
        this.f269c = i;
    }

    /* renamed from: d */
    public int mo180d() {
        return this.f270d;
    }

    /* renamed from: c */
    public void mo178c(int i) {
        this.f270d = i;
    }

    /* renamed from: i */
    public int mo186i() {
        return this.f271e;
    }

    /* renamed from: d */
    public void mo181d(int i) {
        this.f271e = i;
    }

    /* renamed from: j */
    public int mo188j() {
        return this.f272f;
    }

    /* renamed from: e */
    public void mo182e(int i) {
        this.f272f = i;
    }

    /* renamed from: k */
    public int mo189k() {
        return this.f273g;
    }

    /* renamed from: f */
    public void mo183f(int i) {
        this.f273g = i;
    }

    /* renamed from: l */
    public long mo190l() {
        return this.f274h;
    }

    /* renamed from: a */
    public void mo169a(long j) {
        this.f274h = j;
    }

    /* renamed from: m */
    public long mo191m() {
        return this.f275i;
    }

    /* renamed from: b */
    public void mo176b(long j) {
        this.f275i = j;
    }

    /* renamed from: n */
    public short mo192n() {
        return this.f276j;
    }

    /* renamed from: a */
    public void mo173a(short s) {
        this.f276j = s;
    }

    /* renamed from: o */
    public short mo193o() {
        return this.f277k;
    }

    /* renamed from: b */
    public void mo177b(short s) {
        this.f277k = s;
    }

    /* renamed from: p */
    public byte mo194p() {
        return this.f278l;
    }

    /* renamed from: a */
    public void mo168a(byte b) {
        this.f278l = b;
    }

    /* renamed from: q */
    public short mo195q() {
        return this.f279m;
    }

    /* renamed from: c */
    public void mo179c(short s) {
        this.f279m = s;
    }

    /* renamed from: r */
    public int mo196r() {
        return this.f280n;
    }

    /* renamed from: g */
    public void mo184g(int i) {
        this.f280n = i;
    }

    /* renamed from: s */
    public int mo197s() {
        return this.f281o;
    }

    /* renamed from: h */
    public void mo185h(int i) {
        this.f281o = i;
    }

    /* renamed from: w */
    public int mo198w() {
        return this.f282y;
    }

    /* renamed from: i */
    public void mo187i(int i) {
        this.f282y = i;
    }

    /* renamed from: x */
    public String mo199x() {
        return this.f283z;
    }

    /* renamed from: a */
    public void mo171a(String str) {
        this.f283z = str;
    }
}
