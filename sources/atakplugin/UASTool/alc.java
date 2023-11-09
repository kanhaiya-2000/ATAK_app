package atakplugin.UASTool;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class alc {

    /* renamed from: A */
    boolean f1844A;

    /* renamed from: a */
    int f1845a;

    /* renamed from: b */
    int f1846b;

    /* renamed from: c */
    boolean f1847c;

    /* renamed from: d */
    int f1848d;

    /* renamed from: e */
    long f1849e;

    /* renamed from: f */
    long f1850f;

    /* renamed from: g */
    int f1851g;

    /* renamed from: h */
    int f1852h = 15;

    /* renamed from: i */
    int f1853i;

    /* renamed from: j */
    int f1854j = 63;

    /* renamed from: k */
    int f1855k;

    /* renamed from: l */
    int f1856l = 63;

    /* renamed from: m */
    int f1857m;

    /* renamed from: n */
    int f1858n = 31;

    /* renamed from: o */
    int f1859o;

    /* renamed from: p */
    int f1860p = 31;

    /* renamed from: q */
    int f1861q;

    /* renamed from: r */
    int f1862r;

    /* renamed from: s */
    int f1863s;

    /* renamed from: t */
    int f1864t;

    /* renamed from: u */
    boolean f1865u;

    /* renamed from: v */
    int f1866v;

    /* renamed from: w */
    List<C0055a> f1867w = new ArrayList();

    /* renamed from: x */
    boolean f1868x;

    /* renamed from: y */
    boolean f1869y;

    /* renamed from: z */
    boolean f1870z;

    /* renamed from: a */
    public void mo1267a(ByteBuffer byteBuffer) {
        this.f1845a = C0679nk.m12499f(byteBuffer);
        int f = C0679nk.m12499f(byteBuffer);
        this.f1846b = (f & 192) >> 6;
        this.f1847c = (f & 32) > 0;
        this.f1848d = f & 31;
        this.f1849e = C0679nk.m12495b(byteBuffer);
        long n = C0679nk.m12507n(byteBuffer);
        this.f1850f = n;
        this.f1868x = ((n >> 44) & 8) > 0;
        this.f1869y = ((n >> 44) & 4) > 0;
        this.f1870z = ((n >> 44) & 2) > 0;
        this.f1844A = ((n >> 44) & 1) > 0;
        this.f1850f = n & 140737488355327L;
        this.f1851g = C0679nk.m12499f(byteBuffer);
        int d = C0679nk.m12497d(byteBuffer);
        this.f1852h = (61440 & d) >> 12;
        this.f1853i = d & 4095;
        int f2 = C0679nk.m12499f(byteBuffer);
        this.f1854j = (f2 & 252) >> 2;
        this.f1855k = f2 & 3;
        int f3 = C0679nk.m12499f(byteBuffer);
        this.f1856l = (f3 & 252) >> 2;
        this.f1857m = f3 & 3;
        int f4 = C0679nk.m12499f(byteBuffer);
        this.f1858n = (f4 & 248) >> 3;
        this.f1859o = f4 & 7;
        int f5 = C0679nk.m12499f(byteBuffer);
        this.f1860p = (f5 & 248) >> 3;
        this.f1861q = f5 & 7;
        this.f1862r = C0679nk.m12497d(byteBuffer);
        int f6 = C0679nk.m12499f(byteBuffer);
        this.f1863s = (f6 & 192) >> 6;
        this.f1864t = (f6 & 56) >> 3;
        this.f1865u = (f6 & 4) > 0;
        this.f1866v = f6 & 3;
        int f7 = C0679nk.m12499f(byteBuffer);
        this.f1867w = new ArrayList();
        for (int i = 0; i < f7; i++) {
            C0055a aVar = new C0055a();
            int f8 = C0679nk.m12499f(byteBuffer);
            aVar.f1871a = (f8 & 128) > 0;
            aVar.f1872b = (f8 & 64) > 0;
            aVar.f1873c = f8 & 63;
            int d2 = C0679nk.m12497d(byteBuffer);
            aVar.f1874d = new ArrayList();
            for (int i2 = 0; i2 < d2; i2++) {
                byte[] bArr = new byte[C0679nk.m12497d(byteBuffer)];
                byteBuffer.get(bArr);
                aVar.f1874d.add(bArr);
            }
            this.f1867w.add(aVar);
        }
    }

    /* renamed from: b */
    public void mo1273b(ByteBuffer byteBuffer) {
        C0681nm.m12521d(byteBuffer, this.f1845a);
        C0681nm.m12521d(byteBuffer, (this.f1846b << 6) + (this.f1847c ? 32 : 0) + this.f1848d);
        C0681nm.m12515b(byteBuffer, this.f1849e);
        long j = this.f1850f;
        if (this.f1868x) {
            j |= 140737488355328L;
        }
        if (this.f1869y) {
            j |= 70368744177664L;
        }
        if (this.f1870z) {
            j |= 35184372088832L;
        }
        if (this.f1844A) {
            j |= 17592186044416L;
        }
        C0681nm.m12522d(byteBuffer, j);
        C0681nm.m12521d(byteBuffer, this.f1851g);
        C0681nm.m12514b(byteBuffer, (this.f1852h << 12) + this.f1853i);
        C0681nm.m12521d(byteBuffer, (this.f1854j << 2) + this.f1855k);
        C0681nm.m12521d(byteBuffer, (this.f1856l << 2) + this.f1857m);
        C0681nm.m12521d(byteBuffer, (this.f1858n << 3) + this.f1859o);
        C0681nm.m12521d(byteBuffer, (this.f1860p << 3) + this.f1861q);
        C0681nm.m12514b(byteBuffer, this.f1862r);
        C0681nm.m12521d(byteBuffer, (this.f1863s << 6) + (this.f1864t << 3) + (this.f1865u ? 4 : 0) + this.f1866v);
        C0681nm.m12521d(byteBuffer, this.f1867w.size());
        for (C0055a next : this.f1867w) {
            C0681nm.m12521d(byteBuffer, (next.f1871a ? 128 : 0) + (next.f1872b ? 64 : 0) + next.f1873c);
            C0681nm.m12514b(byteBuffer, next.f1874d.size());
            for (byte[] next2 : next.f1874d) {
                C0681nm.m12514b(byteBuffer, next2.length);
                byteBuffer.put(next2);
            }
        }
    }

    /* renamed from: a */
    public int mo1264a() {
        int i = 23;
        for (C0055a aVar : this.f1867w) {
            i += 3;
            for (byte[] length : aVar.f1874d) {
                i = i + 2 + length.length;
            }
        }
        return i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        alc alc = (alc) obj;
        if (this.f1862r != alc.f1862r || this.f1861q != alc.f1861q || this.f1859o != alc.f1859o || this.f1857m != alc.f1857m || this.f1845a != alc.f1845a || this.f1863s != alc.f1863s || this.f1850f != alc.f1850f || this.f1851g != alc.f1851g || this.f1849e != alc.f1849e || this.f1848d != alc.f1848d || this.f1846b != alc.f1846b || this.f1847c != alc.f1847c || this.f1866v != alc.f1866v || this.f1853i != alc.f1853i || this.f1864t != alc.f1864t || this.f1855k != alc.f1855k || this.f1852h != alc.f1852h || this.f1854j != alc.f1854j || this.f1856l != alc.f1856l || this.f1858n != alc.f1858n || this.f1860p != alc.f1860p || this.f1865u != alc.f1865u) {
            return false;
        }
        List<C0055a> list = this.f1867w;
        List<C0055a> list2 = alc.f1867w;
        return list == null ? list2 == null : list.equals(list2);
    }

    public int hashCode() {
        long j = this.f1849e;
        long j2 = this.f1850f;
        int i = ((((((((((((((((((((((((((((((((((((((((((this.f1845a * 31) + this.f1846b) * 31) + (this.f1847c ? 1 : 0)) * 31) + this.f1848d) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + this.f1851g) * 31) + this.f1852h) * 31) + this.f1853i) * 31) + this.f1854j) * 31) + this.f1855k) * 31) + this.f1856l) * 31) + this.f1857m) * 31) + this.f1858n) * 31) + this.f1859o) * 31) + this.f1860p) * 31) + this.f1861q) * 31) + this.f1862r) * 31) + this.f1863s) * 31) + this.f1864t) * 31) + (this.f1865u ? 1 : 0)) * 31) + this.f1866v) * 31;
        List<C0055a> list = this.f1867w;
        return i + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        String str;
        String str2;
        String str3;
        String str4;
        StringBuilder sb = new StringBuilder("HEVCDecoderConfigurationRecord{configurationVersion=");
        sb.append(this.f1845a);
        sb.append(", general_profile_space=");
        sb.append(this.f1846b);
        sb.append(", general_tier_flag=");
        sb.append(this.f1847c);
        sb.append(", general_profile_idc=");
        sb.append(this.f1848d);
        sb.append(", general_profile_compatibility_flags=");
        sb.append(this.f1849e);
        sb.append(", general_constraint_indicator_flags=");
        sb.append(this.f1850f);
        sb.append(", general_level_idc=");
        sb.append(this.f1851g);
        String str5 = "";
        if (this.f1852h != 15) {
            str = ", reserved1=" + this.f1852h;
        } else {
            str = str5;
        }
        sb.append(str);
        sb.append(", min_spatial_segmentation_idc=");
        sb.append(this.f1853i);
        if (this.f1854j != 63) {
            str2 = ", reserved2=" + this.f1854j;
        } else {
            str2 = str5;
        }
        sb.append(str2);
        sb.append(", parallelismType=");
        sb.append(this.f1855k);
        if (this.f1856l != 63) {
            str3 = ", reserved3=" + this.f1856l;
        } else {
            str3 = str5;
        }
        sb.append(str3);
        sb.append(", chromaFormat=");
        sb.append(this.f1857m);
        if (this.f1858n != 31) {
            str4 = ", reserved4=" + this.f1858n;
        } else {
            str4 = str5;
        }
        sb.append(str4);
        sb.append(", bitDepthLumaMinus8=");
        sb.append(this.f1859o);
        if (this.f1860p != 31) {
            str5 = ", reserved5=" + this.f1860p;
        }
        sb.append(str5);
        sb.append(", bitDepthChromaMinus8=");
        sb.append(this.f1861q);
        sb.append(", avgFrameRate=");
        sb.append(this.f1862r);
        sb.append(", constantFrameRate=");
        sb.append(this.f1863s);
        sb.append(", numTemporalLayers=");
        sb.append(this.f1864t);
        sb.append(", temporalIdNested=");
        sb.append(this.f1865u);
        sb.append(", lengthSizeMinusOne=");
        sb.append(this.f1866v);
        sb.append(", arrays=");
        sb.append(this.f1867w);
        sb.append('}');
        return sb.toString();
    }

    /* renamed from: b */
    public int mo1270b() {
        return this.f1845a;
    }

    /* renamed from: a */
    public void mo1265a(int i) {
        this.f1845a = i;
    }

    /* renamed from: c */
    public int mo1275c() {
        return this.f1846b;
    }

    /* renamed from: b */
    public void mo1271b(int i) {
        this.f1846b = i;
    }

    /* renamed from: d */
    public boolean mo1280d() {
        return this.f1847c;
    }

    /* renamed from: a */
    public void mo1269a(boolean z) {
        this.f1847c = z;
    }

    /* renamed from: e */
    public int mo1281e() {
        return this.f1848d;
    }

    /* renamed from: c */
    public void mo1276c(int i) {
        this.f1848d = i;
    }

    /* renamed from: f */
    public long mo1285f() {
        return this.f1849e;
    }

    /* renamed from: a */
    public void mo1266a(long j) {
        this.f1849e = j;
    }

    /* renamed from: g */
    public long mo1288g() {
        return this.f1850f;
    }

    /* renamed from: b */
    public void mo1272b(long j) {
        this.f1850f = j;
    }

    /* renamed from: h */
    public int mo1290h() {
        return this.f1851g;
    }

    /* renamed from: d */
    public void mo1278d(int i) {
        this.f1851g = i;
    }

    /* renamed from: i */
    public int mo1293i() {
        return this.f1853i;
    }

    /* renamed from: e */
    public void mo1282e(int i) {
        this.f1853i = i;
    }

    /* renamed from: j */
    public int mo1295j() {
        return this.f1855k;
    }

    /* renamed from: f */
    public void mo1286f(int i) {
        this.f1855k = i;
    }

    /* renamed from: k */
    public int mo1297k() {
        return this.f1857m;
    }

    /* renamed from: g */
    public void mo1289g(int i) {
        this.f1857m = i;
    }

    /* renamed from: l */
    public int mo1299l() {
        return this.f1859o;
    }

    /* renamed from: h */
    public void mo1291h(int i) {
        this.f1859o = i;
    }

    /* renamed from: m */
    public int mo1301m() {
        return this.f1861q;
    }

    /* renamed from: i */
    public void mo1294i(int i) {
        this.f1861q = i;
    }

    /* renamed from: n */
    public int mo1303n() {
        return this.f1862r;
    }

    /* renamed from: j */
    public void mo1296j(int i) {
        this.f1862r = i;
    }

    /* renamed from: o */
    public int mo1304o() {
        return this.f1864t;
    }

    /* renamed from: k */
    public void mo1298k(int i) {
        this.f1864t = i;
    }

    /* renamed from: p */
    public int mo1305p() {
        return this.f1866v;
    }

    /* renamed from: l */
    public void mo1300l(int i) {
        this.f1866v = i;
    }

    /* renamed from: q */
    public boolean mo1306q() {
        return this.f1865u;
    }

    /* renamed from: b */
    public void mo1274b(boolean z) {
        this.f1865u = z;
    }

    /* renamed from: r */
    public int mo1307r() {
        return this.f1863s;
    }

    /* renamed from: m */
    public void mo1302m(int i) {
        this.f1863s = i;
    }

    /* renamed from: s */
    public List<C0055a> mo1308s() {
        return this.f1867w;
    }

    /* renamed from: a */
    public void mo1268a(List<C0055a> list) {
        this.f1867w = list;
    }

    /* renamed from: t */
    public boolean mo1309t() {
        return this.f1868x;
    }

    /* renamed from: c */
    public void mo1277c(boolean z) {
        this.f1868x = z;
    }

    /* renamed from: u */
    public boolean mo1311u() {
        return this.f1869y;
    }

    /* renamed from: d */
    public void mo1279d(boolean z) {
        this.f1869y = z;
    }

    /* renamed from: v */
    public boolean mo1312v() {
        return this.f1870z;
    }

    /* renamed from: e */
    public void mo1283e(boolean z) {
        this.f1870z = z;
    }

    /* renamed from: w */
    public boolean mo1313w() {
        return this.f1844A;
    }

    /* renamed from: f */
    public void mo1287f(boolean z) {
        this.f1844A = z;
    }

    /* renamed from: atakplugin.UASTool.alc$a */
    public static class C0055a {

        /* renamed from: a */
        public boolean f1871a;

        /* renamed from: b */
        public boolean f1872b;

        /* renamed from: c */
        public int f1873c;

        /* renamed from: d */
        public List<byte[]> f1874d;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            C0055a aVar = (C0055a) obj;
            if (this.f1871a != aVar.f1871a || this.f1873c != aVar.f1873c || this.f1872b != aVar.f1872b) {
                return false;
            }
            ListIterator<byte[]> listIterator = this.f1874d.listIterator();
            ListIterator<byte[]> listIterator2 = aVar.f1874d.listIterator();
            while (listIterator.hasNext() && listIterator2.hasNext()) {
                byte[] next = listIterator.next();
                byte[] next2 = listIterator2.next();
                if (next == null) {
                    if (next2 != null) {
                    }
                } else if (!Arrays.equals(next, next2)) {
                }
                return false;
            }
            if (listIterator.hasNext() || listIterator2.hasNext()) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            int i = (((((this.f1871a ? 1 : 0) * true) + (this.f1872b ? 1 : 0)) * 31) + this.f1873c) * 31;
            List<byte[]> list = this.f1874d;
            return i + (list != null ? list.hashCode() : 0);
        }

        public String toString() {
            return "Array{nal_unit_type=" + this.f1873c + ", reserved=" + this.f1872b + ", array_completeness=" + this.f1871a + ", num_nals=" + this.f1874d.size() + '}';
        }
    }
}
