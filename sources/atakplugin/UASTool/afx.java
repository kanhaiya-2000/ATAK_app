package atakplugin.UASTool;

public class afx {

    /* renamed from: a */
    final byte[] f887a;

    /* renamed from: b */
    byte[] f888b;

    /* renamed from: c */
    int f889c;

    /* renamed from: d */
    int f890d;

    public afx(int i) {
        this.f887a = new byte[4];
        this.f888b = new byte[i];
        this.f889c = 0;
        this.f890d = 0;
    }

    public afx(byte[] bArr) {
        this.f887a = new byte[4];
        this.f888b = bArr;
        this.f889c = 0;
        this.f890d = 0;
    }

    public afx() {
        this(20480);
    }

    /* renamed from: a */
    public void mo618a(byte b) {
        byte[] bArr = this.f888b;
        int i = this.f889c;
        this.f889c = i + 1;
        bArr[i] = b;
    }

    /* renamed from: a */
    public void mo621a(byte[] bArr) {
        mo622a(bArr, 0, bArr.length);
    }

    /* renamed from: a */
    public void mo622a(byte[] bArr, int i, int i2) {
        System.arraycopy(bArr, i, this.f888b, this.f889c, i2);
        this.f889c += i2;
    }

    /* renamed from: b */
    public void mo627b(byte[] bArr) {
        mo628b(bArr, 0, bArr.length);
    }

    /* renamed from: b */
    public void mo628b(byte[] bArr, int i, int i2) {
        mo619a(i2);
        mo622a(bArr, i, i2);
    }

    /* renamed from: a */
    public void mo619a(int i) {
        byte[] bArr = this.f887a;
        bArr[0] = (byte) (i >>> 24);
        bArr[1] = (byte) (i >>> 16);
        bArr[2] = (byte) (i >>> 8);
        bArr[3] = (byte) i;
        System.arraycopy(bArr, 0, this.f888b, this.f889c, 4);
        this.f889c += 4;
    }

    /* renamed from: a */
    public void mo620a(long j) {
        byte[] bArr = this.f887a;
        bArr[0] = (byte) ((int) (j >>> 56));
        bArr[1] = (byte) ((int) (j >>> 48));
        bArr[2] = (byte) ((int) (j >>> 40));
        bArr[3] = (byte) ((int) (j >>> 32));
        System.arraycopy(bArr, 0, this.f888b, this.f889c, 4);
        byte[] bArr2 = this.f887a;
        bArr2[0] = (byte) ((int) (j >>> 24));
        bArr2[1] = (byte) ((int) (j >>> 16));
        bArr2[2] = (byte) ((int) (j >>> 8));
        bArr2[3] = (byte) ((int) j);
        System.arraycopy(bArr2, 0, this.f888b, this.f889c + 4, 4);
        this.f889c += 8;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo626b(int i) {
        this.f889c += i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo630c(int i) {
        while (i > 0) {
            byte[] bArr = this.f888b;
            int i2 = this.f889c;
            this.f889c = i2 + 1;
            bArr[i2] = 0;
            i--;
        }
    }

    /* renamed from: c */
    public void mo631c(byte[] bArr) {
        int length = bArr.length;
        if ((bArr[0] & 128) != 0) {
            mo619a(length + 1);
            mo618a((byte) 0);
        } else {
            mo619a(length);
        }
        mo621a(bArr);
    }

    /* renamed from: a */
    public int mo617a() {
        return this.f889c - this.f890d;
    }

    /* renamed from: b */
    public int mo625b() {
        return this.f890d;
    }

    /* renamed from: d */
    public void mo634d(int i) {
        this.f890d = i;
    }

    /* renamed from: c */
    public long mo629c() {
        return ((((long) mo633d()) & 4294967295L) << 32) | (4294967295L & ((long) mo633d()));
    }

    /* renamed from: d */
    public int mo633d() {
        return ((mo638f() << 16) & -65536) | (mo638f() & 65535);
    }

    /* renamed from: e */
    public long mo637e() {
        return (((((((long) mo640g()) << 8) & 65280) | ((long) (mo640g() & 255))) << 16) & -65536) | ((((((long) mo640g()) << 8) & 65280) | ((long) (mo640g() & 255))) & 65535);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public int mo638f() {
        return ((mo640g() << 8) & 65280) | (mo640g() & 255);
    }

    /* renamed from: g */
    public int mo640g() {
        byte[] bArr = this.f888b;
        int i = this.f890d;
        this.f890d = i + 1;
        return bArr[i] & 255;
    }

    /* renamed from: d */
    public void mo635d(byte[] bArr) {
        mo632c(bArr, 0, bArr.length);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo632c(byte[] bArr, int i, int i2) {
        System.arraycopy(this.f888b, this.f890d, bArr, i, i2);
        this.f890d += i2;
    }

    /* renamed from: e */
    public int mo636e(int i) {
        int i2 = this.f890d;
        this.f890d = i + i2;
        return i2;
    }

    /* renamed from: h */
    public byte[] mo641h() {
        int d = mo633d();
        if (d < 0 || d > 8192) {
            d = 8192;
        }
        byte[] bArr = new byte[d];
        mo632c(bArr, 0, d);
        return bArr;
    }

    /* renamed from: i */
    public byte[] mo642i() {
        int d = (mo633d() + 7) / 8;
        byte[] bArr = new byte[d];
        mo632c(bArr, 0, d);
        if ((bArr[0] & 128) == 0) {
            return bArr;
        }
        byte[] bArr2 = new byte[(d + 1)];
        bArr2[0] = 0;
        System.arraycopy(bArr, 0, bArr2, 1, d);
        return bArr2;
    }

    /* renamed from: j */
    public byte[] mo643j() {
        int d = mo633d();
        if (d < 0 || d > 262144) {
            d = 262144;
        }
        byte[] bArr = new byte[d];
        mo632c(bArr, 0, d);
        return bArr;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public byte[] mo623a(int[] iArr, int[] iArr2) {
        int d = mo633d();
        iArr[0] = mo636e(d);
        iArr2[0] = d;
        return this.f888b;
    }

    /* renamed from: k */
    public void mo644k() {
        this.f889c = 0;
        this.f890d = 0;
    }

    /* renamed from: l */
    public void mo645l() {
        int i = this.f890d;
        if (i != 0) {
            byte[] bArr = this.f888b;
            System.arraycopy(bArr, i, bArr, 0, this.f889c - i);
            this.f889c -= this.f890d;
            this.f890d = 0;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: m */
    public void mo646m() {
        this.f890d = 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: n */
    public byte mo647n() {
        return this.f888b[5];
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public void mo639f(int i) {
        int i2 = this.f889c;
        int i3 = i + i2 + 84;
        byte[] bArr = this.f888b;
        if (bArr.length < i3) {
            int length = bArr.length * 2;
            if (length >= i3) {
                i3 = length;
            }
            byte[] bArr2 = new byte[i3];
            System.arraycopy(bArr, 0, bArr2, 0, i2);
            this.f888b = bArr2;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public byte[][] mo624a(int i, String str) {
        byte[][] bArr = new byte[i][];
        int i2 = 0;
        while (i2 < i) {
            int d = mo633d();
            if (mo617a() >= d) {
                bArr[i2] = new byte[d];
                mo635d(bArr[i2]);
                i2++;
            } else {
                throw new ahj(str);
            }
        }
        return bArr;
    }

    /* renamed from: a */
    static afx m897a(byte[][] bArr) {
        int length = bArr.length * 4;
        for (byte[] length2 : bArr) {
            length += length2.length;
        }
        afx afx = new afx(length);
        for (byte[] b : bArr) {
            afx.mo627b(b);
        }
        return afx;
    }
}
