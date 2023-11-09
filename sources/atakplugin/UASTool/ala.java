package atakplugin.UASTool;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public class ala {

    /* renamed from: a */
    public int f1803a;

    /* renamed from: b */
    public int f1804b;

    /* renamed from: c */
    public int f1805c;

    /* renamed from: d */
    public int f1806d;

    /* renamed from: e */
    public int f1807e;

    /* renamed from: f */
    public List<byte[]> f1808f;

    /* renamed from: g */
    public List<byte[]> f1809g;

    /* renamed from: h */
    public boolean f1810h;

    /* renamed from: i */
    public int f1811i;

    /* renamed from: j */
    public int f1812j;

    /* renamed from: k */
    public int f1813k;

    /* renamed from: l */
    public List<byte[]> f1814l;

    /* renamed from: m */
    public int f1815m;

    /* renamed from: n */
    public int f1816n;

    /* renamed from: o */
    public int f1817o;

    /* renamed from: p */
    public int f1818p;

    /* renamed from: q */
    public int f1819q;

    public ala() {
        this.f1808f = new ArrayList();
        this.f1809g = new ArrayList();
        this.f1810h = true;
        this.f1811i = 1;
        this.f1812j = 0;
        this.f1813k = 0;
        this.f1814l = new ArrayList();
        this.f1815m = 63;
        this.f1816n = 7;
        this.f1817o = 31;
        this.f1818p = 31;
        this.f1819q = 31;
    }

    public ala(ByteBuffer byteBuffer) {
        int i;
        this.f1808f = new ArrayList();
        this.f1809g = new ArrayList();
        this.f1810h = true;
        this.f1811i = 1;
        this.f1812j = 0;
        this.f1813k = 0;
        this.f1814l = new ArrayList();
        this.f1815m = 63;
        this.f1816n = 7;
        this.f1817o = 31;
        this.f1818p = 31;
        this.f1819q = 31;
        this.f1803a = C0679nk.m12499f(byteBuffer);
        this.f1804b = C0679nk.m12499f(byteBuffer);
        this.f1805c = C0679nk.m12499f(byteBuffer);
        this.f1806d = C0679nk.m12499f(byteBuffer);
        adi adi = new adi(byteBuffer);
        this.f1815m = adi.mo315a(6);
        this.f1807e = adi.mo315a(2);
        this.f1816n = adi.mo315a(3);
        int a = adi.mo315a(5);
        for (int i2 = 0; i2 < a; i2++) {
            byte[] bArr = new byte[C0679nk.m12497d(byteBuffer)];
            byteBuffer.get(bArr);
            this.f1808f.add(bArr);
        }
        long f = (long) C0679nk.m12499f(byteBuffer);
        for (int i3 = 0; ((long) i3) < f; i3++) {
            byte[] bArr2 = new byte[C0679nk.m12497d(byteBuffer)];
            byteBuffer.get(bArr2);
            this.f1809g.add(bArr2);
        }
        if (byteBuffer.remaining() < 4) {
            this.f1810h = false;
        }
        if (!this.f1810h || !((i = this.f1804b) == 100 || i == 110 || i == 122 || i == 144)) {
            this.f1811i = -1;
            this.f1812j = -1;
            this.f1813k = -1;
            return;
        }
        adi adi2 = new adi(byteBuffer);
        this.f1817o = adi2.mo315a(6);
        this.f1811i = adi2.mo315a(2);
        this.f1818p = adi2.mo315a(5);
        this.f1812j = adi2.mo315a(3);
        this.f1819q = adi2.mo315a(5);
        this.f1813k = adi2.mo315a(3);
        long f2 = (long) C0679nk.m12499f(byteBuffer);
        for (int i4 = 0; ((long) i4) < f2; i4++) {
            byte[] bArr3 = new byte[C0679nk.m12497d(byteBuffer)];
            byteBuffer.get(bArr3);
            this.f1814l.add(bArr3);
        }
    }

    /* renamed from: a */
    public void mo1237a(ByteBuffer byteBuffer) {
        C0681nm.m12521d(byteBuffer, this.f1803a);
        C0681nm.m12521d(byteBuffer, this.f1804b);
        C0681nm.m12521d(byteBuffer, this.f1805c);
        C0681nm.m12521d(byteBuffer, this.f1806d);
        adj adj = new adj(byteBuffer);
        adj.mo320a(this.f1815m, 6);
        adj.mo320a(this.f1807e, 2);
        adj.mo320a(this.f1816n, 3);
        adj.mo320a(this.f1809g.size(), 5);
        for (byte[] next : this.f1808f) {
            C0681nm.m12514b(byteBuffer, next.length);
            byteBuffer.put(next);
        }
        C0681nm.m12521d(byteBuffer, this.f1809g.size());
        for (byte[] next2 : this.f1809g) {
            C0681nm.m12514b(byteBuffer, next2.length);
            byteBuffer.put(next2);
        }
        if (this.f1810h) {
            int i = this.f1804b;
            if (i == 100 || i == 110 || i == 122 || i == 144) {
                adj adj2 = new adj(byteBuffer);
                adj2.mo320a(this.f1817o, 6);
                adj2.mo320a(this.f1811i, 2);
                adj2.mo320a(this.f1818p, 5);
                adj2.mo320a(this.f1812j, 3);
                adj2.mo320a(this.f1819q, 5);
                adj2.mo320a(this.f1813k, 3);
                for (byte[] next3 : this.f1814l) {
                    C0681nm.m12514b(byteBuffer, next3.length);
                    byteBuffer.put(next3);
                }
            }
        }
    }

    /* renamed from: a */
    public long mo1236a() {
        long j;
        int i;
        long j2 = 6;
        for (byte[] length : this.f1808f) {
            j2 = j2 + 2 + ((long) length.length);
        }
        long j3 = j2 + 1;
        for (byte[] length2 : this.f1809g) {
            j3 = j + 2 + ((long) length2.length);
        }
        if (this.f1810h && ((i = this.f1804b) == 100 || i == 110 || i == 122 || i == 144)) {
            j += 4;
            for (byte[] length3 : this.f1814l) {
                j = j + 2 + ((long) length3.length);
            }
        }
        return j;
    }

    /* renamed from: b */
    public String[] mo1238b() {
        ArrayList arrayList = new ArrayList();
        for (byte[] next : this.f1809g) {
            try {
                arrayList.add(aew.m786a((InputStream) new ByteArrayInputStream(next, 1, next.length - 1)).toString());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    /* renamed from: c */
    public String[] mo1239c() {
        String str;
        ArrayList arrayList = new ArrayList();
        for (byte[] next : this.f1808f) {
            try {
                str = aez.m791a((InputStream) new C1066ys(new ByteArrayInputStream(next, 1, next.length - 1))).toString();
            } catch (IOException unused) {
                str = "not parsable";
            }
            arrayList.add(str);
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    /* renamed from: d */
    public List<String> mo1240d() {
        ArrayList arrayList = new ArrayList(this.f1808f.size());
        for (byte[] a : this.f1808f) {
            arrayList.add(C0677ni.m12484a(a));
        }
        return arrayList;
    }

    /* renamed from: e */
    public List<String> mo1241e() {
        ArrayList arrayList = new ArrayList(this.f1814l.size());
        for (byte[] a : this.f1814l) {
            arrayList.add(C0677ni.m12484a(a));
        }
        return arrayList;
    }

    /* renamed from: f */
    public List<String> mo1242f() {
        ArrayList arrayList = new ArrayList(this.f1809g.size());
        for (byte[] a : this.f1809g) {
            arrayList.add(C0677ni.m12484a(a));
        }
        return arrayList;
    }

    public String toString() {
        return "AvcDecoderConfigurationRecord{configurationVersion=" + this.f1803a + ", avcProfileIndication=" + this.f1804b + ", profileCompatibility=" + this.f1805c + ", avcLevelIndication=" + this.f1806d + ", lengthSizeMinusOne=" + this.f1807e + ", hasExts=" + this.f1810h + ", chromaFormat=" + this.f1811i + ", bitDepthLumaMinus8=" + this.f1812j + ", bitDepthChromaMinus8=" + this.f1813k + ", lengthSizeMinusOnePaddingBits=" + this.f1815m + ", numberOfSequenceParameterSetsPaddingBits=" + this.f1816n + ", chromaFormatPaddingBits=" + this.f1817o + ", bitDepthLumaMinus8PaddingBits=" + this.f1818p + ", bitDepthChromaMinus8PaddingBits=" + this.f1819q + '}';
    }
}
