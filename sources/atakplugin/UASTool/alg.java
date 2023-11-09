package atakplugin.UASTool;

import java.nio.ByteBuffer;

public class alg extends adx {

    /* renamed from: a */
    public static final String f1892a = "tscl";

    /* renamed from: b */
    int f1893b;

    /* renamed from: c */
    int f1894c;

    /* renamed from: d */
    boolean f1895d;

    /* renamed from: e */
    int f1896e;

    /* renamed from: f */
    long f1897f;

    /* renamed from: g */
    long f1898g;

    /* renamed from: h */
    int f1899h;

    /* renamed from: i */
    int f1900i;

    /* renamed from: j */
    int f1901j;

    /* renamed from: k */
    int f1902k;

    /* renamed from: l */
    int f1903l;

    /* renamed from: a */
    public String mo377a() {
        return f1892a;
    }

    /* renamed from: f */
    public int mo389f() {
        return 20;
    }

    /* renamed from: c */
    public int mo1337c() {
        return this.f1893b;
    }

    /* renamed from: a */
    public void mo1332a(int i) {
        this.f1893b = i;
    }

    /* renamed from: d */
    public int mo1339d() {
        return this.f1894c;
    }

    /* renamed from: b */
    public void mo1335b(int i) {
        this.f1894c = i;
    }

    /* renamed from: e */
    public boolean mo1342e() {
        return this.f1895d;
    }

    /* renamed from: a */
    public void mo1334a(boolean z) {
        this.f1895d = z;
    }

    /* renamed from: g */
    public int mo1345g() {
        return this.f1896e;
    }

    /* renamed from: c */
    public void mo1338c(int i) {
        this.f1896e = i;
    }

    /* renamed from: h */
    public long mo1347h() {
        return this.f1897f;
    }

    /* renamed from: a */
    public void mo1333a(long j) {
        this.f1897f = j;
    }

    /* renamed from: i */
    public long mo1350i() {
        return this.f1898g;
    }

    /* renamed from: b */
    public void mo1336b(long j) {
        this.f1898g = j;
    }

    /* renamed from: j */
    public int mo1351j() {
        return this.f1899h;
    }

    /* renamed from: d */
    public void mo1340d(int i) {
        this.f1899h = i;
    }

    /* renamed from: k */
    public int mo1352k() {
        return this.f1900i;
    }

    /* renamed from: e */
    public void mo1341e(int i) {
        this.f1900i = i;
    }

    /* renamed from: l */
    public int mo1353l() {
        return this.f1901j;
    }

    /* renamed from: f */
    public void mo1344f(int i) {
        this.f1901j = i;
    }

    /* renamed from: m */
    public int mo1354m() {
        return this.f1902k;
    }

    /* renamed from: g */
    public void mo1346g(int i) {
        this.f1902k = i;
    }

    /* renamed from: n */
    public int mo1355n() {
        return this.f1903l;
    }

    /* renamed from: h */
    public void mo1348h(int i) {
        this.f1903l = i;
    }

    /* renamed from: a */
    public void mo379a(ByteBuffer byteBuffer) {
        this.f1893b = C0679nk.m12499f(byteBuffer);
        int f = C0679nk.m12499f(byteBuffer);
        this.f1894c = (f & 192) >> 6;
        this.f1895d = (f & 32) > 0;
        this.f1896e = f & 31;
        this.f1897f = C0679nk.m12495b(byteBuffer);
        this.f1898g = C0679nk.m12507n(byteBuffer);
        this.f1899h = C0679nk.m12499f(byteBuffer);
        this.f1900i = C0679nk.m12497d(byteBuffer);
        this.f1901j = C0679nk.m12497d(byteBuffer);
        this.f1902k = C0679nk.m12499f(byteBuffer);
        this.f1903l = C0679nk.m12497d(byteBuffer);
    }

    /* renamed from: b */
    public ByteBuffer mo382b() {
        ByteBuffer allocate = ByteBuffer.allocate(20);
        C0681nm.m12521d(allocate, this.f1893b);
        C0681nm.m12521d(allocate, (this.f1894c << 6) + (this.f1895d ? 32 : 0) + this.f1896e);
        C0681nm.m12515b(allocate, this.f1897f);
        C0681nm.m12522d(allocate, this.f1898g);
        C0681nm.m12521d(allocate, this.f1899h);
        C0681nm.m12514b(allocate, this.f1900i);
        C0681nm.m12514b(allocate, this.f1901j);
        C0681nm.m12521d(allocate, this.f1902k);
        C0681nm.m12514b(allocate, this.f1903l);
        return (ByteBuffer) allocate.rewind();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        alg alg = (alg) obj;
        return this.f1893b == alg.f1893b && this.f1901j == alg.f1901j && this.f1903l == alg.f1903l && this.f1902k == alg.f1902k && this.f1900i == alg.f1900i && this.f1898g == alg.f1898g && this.f1899h == alg.f1899h && this.f1897f == alg.f1897f && this.f1896e == alg.f1896e && this.f1894c == alg.f1894c && this.f1895d == alg.f1895d;
    }

    public int hashCode() {
        long j = this.f1897f;
        long j2 = this.f1898g;
        return (((((((((((((((((((this.f1893b * 31) + this.f1894c) * 31) + (this.f1895d ? 1 : 0)) * 31) + this.f1896e) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + this.f1899h) * 31) + this.f1900i) * 31) + this.f1901j) * 31) + this.f1902k) * 31) + this.f1903l;
    }

    public String toString() {
        return "TemporalLayerSampleGroup{temporalLayerId=" + this.f1893b + ", tlprofile_space=" + this.f1894c + ", tltier_flag=" + this.f1895d + ", tlprofile_idc=" + this.f1896e + ", tlprofile_compatibility_flags=" + this.f1897f + ", tlconstraint_indicator_flags=" + this.f1898g + ", tllevel_idc=" + this.f1899h + ", tlMaxBitRate=" + this.f1900i + ", tlAvgBitRate=" + this.f1901j + ", tlConstantFrameRate=" + this.f1902k + ", tlAvgFrameRate=" + this.f1903l + '}';
    }
}
