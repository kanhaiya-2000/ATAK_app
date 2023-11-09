package atakplugin.UASTool;

public class ahy {

    /* renamed from: c */
    private static aie f1375c;

    /* renamed from: a */
    afx f1376a;

    /* renamed from: b */
    byte[] f1377b = new byte[4];

    /* renamed from: a */
    static void m1561a(aie aie) {
        f1375c = aie;
    }

    public ahy(afx afx) {
        this.f1376a = afx;
    }

    /* renamed from: a */
    public void mo996a() {
        this.f1376a.f889c = 5;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo998a(int i) {
        int i2 = this.f1376a.f889c;
        int i3 = (-i2) & (i - 1);
        if (i3 < i) {
            i3 += i;
        }
        int i4 = (i2 + i3) - 4;
        byte[] bArr = this.f1377b;
        bArr[0] = (byte) (i4 >>> 24);
        bArr[1] = (byte) (i4 >>> 16);
        bArr[2] = (byte) (i4 >>> 8);
        bArr[3] = (byte) i4;
        System.arraycopy(bArr, 0, this.f1376a.f888b, 0, 4);
        this.f1376a.f888b[4] = (byte) i3;
        synchronized (f1375c) {
            f1375c.mo1012a(this.f1376a.f888b, this.f1376a.f889c, i3);
        }
        this.f1376a.mo626b(i3);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo995a(int i, int i2, int i3) {
        int i4 = i + 5 + 9;
        int i5 = (-i4) & (i2 - 1);
        if (i5 < i2) {
            i5 += i2;
        }
        int i6 = i5 + i4 + i3 + 32;
        if (this.f1376a.f888b.length < (((this.f1376a.f889c + i6) - 5) - 9) - i) {
            byte[] bArr = new byte[((((this.f1376a.f889c + i6) - 5) - 9) - i)];
            System.arraycopy(this.f1376a.f888b, 0, bArr, 0, this.f1376a.f888b.length);
            this.f1376a.f888b = bArr;
        }
        System.arraycopy(this.f1376a.f888b, i4, this.f1376a.f888b, i6, ((this.f1376a.f889c - 5) - 9) - i);
        this.f1376a.f889c = 10;
        this.f1376a.mo619a(i);
        this.f1376a.f889c = i4;
        return i6;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo997a(byte b, int i, int i2, int i3) {
        System.arraycopy(this.f1376a.f888b, i2, this.f1376a.f888b, 14, i3);
        this.f1376a.f888b[5] = b;
        this.f1376a.f889c = 6;
        this.f1376a.mo619a(i);
        this.f1376a.mo619a(i3);
        this.f1376a.f889c = i3 + 5 + 9;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public afx mo999b() {
        return this.f1376a;
    }
}
