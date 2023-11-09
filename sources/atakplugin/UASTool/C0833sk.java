package atakplugin.UASTool;

import java.io.InputStream;

/* renamed from: atakplugin.UASTool.sk */
public class C0833sk extends InputStream {

    /* renamed from: a */
    protected final C0847ss f6392a;

    /* renamed from: b */
    private int f6393b = 0;

    /* renamed from: c */
    private int f6394c = 16384;

    /* renamed from: d */
    private final byte[] f6395d;

    /* renamed from: e */
    private int f6396e;

    /* renamed from: f */
    private int f6397f;

    public C0833sk(C0847ss ssVar) {
        this.f6392a = ssVar;
        this.f6395d = new byte[16384];
        this.f6396e = 0;
        this.f6397f = -1;
    }

    public C0833sk(C0847ss ssVar, int i) {
        this.f6392a = ssVar;
        this.f6394c = i;
        this.f6395d = new byte[i];
        this.f6396e = 0;
        this.f6397f = -1;
    }

    public int read() {
        int a = m13697a();
        if (a >= 0) {
            return a;
        }
        int a2 = this.f6392a.mo5715a(this.f6395d, this.f6393b);
        if (a2 < 0) {
            return -1;
        }
        this.f6397f = a2;
        byte[] bArr = this.f6395d;
        int i = this.f6396e;
        this.f6396e = i + 1;
        return bArr[i] & 255;
    }

    public int read(byte[] bArr) {
        return this.f6392a.mo5715a(bArr, this.f6393b);
    }

    public int read(byte[] bArr, int i, int i2) {
        if (i < 0) {
            throw new IndexOutOfBoundsException("Offset must be >= 0");
        } else if (i2 < 0) {
            throw new IndexOutOfBoundsException("Length must positive");
        } else if (i2 > bArr.length - i) {
            throw new IndexOutOfBoundsException("Length greater than b.length - off");
        } else if (i == 0 && i2 == bArr.length) {
            return read(bArr);
        } else {
            return this.f6392a.mo5716a(bArr, i, i2, this.f6393b);
        }
    }

    public int available() {
        int i = this.f6397f;
        if (i > 0) {
            return i - this.f6396e;
        }
        return 0;
    }

    /* renamed from: a */
    public void mo5729a(int i) {
        this.f6393b = i;
    }

    /* renamed from: a */
    private int m13697a() {
        int i;
        int i2 = this.f6397f;
        if (i2 <= 0 || (i = this.f6396e) >= i2) {
            this.f6396e = 0;
            this.f6397f = -1;
            return -1;
        }
        byte[] bArr = this.f6395d;
        this.f6396e = i + 1;
        return bArr[i] & 255;
    }
}
