package atakplugin.UASTool;

import java.security.MessageDigest;

class ako {

    /* renamed from: a */
    private static final int f1710a = 64;

    /* renamed from: b */
    private byte[] f1711b = null;

    /* renamed from: c */
    private byte[] f1712c = null;

    /* renamed from: d */
    private MessageDigest f1713d = null;

    /* renamed from: e */
    private int f1714e = 0;

    /* renamed from: f */
    private final byte[] f1715f = new byte[4];

    ako() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo1181a(MessageDigest messageDigest) {
        this.f1713d = messageDigest;
        this.f1714e = messageDigest.getDigestLength();
    }

    /* renamed from: b */
    public int mo1185b() {
        return this.f1714e;
    }

    /* renamed from: a */
    public void mo1182a(byte[] bArr) {
        this.f1713d.reset();
        int length = bArr.length;
        int i = this.f1714e;
        if (length > i) {
            byte[] bArr2 = new byte[i];
            System.arraycopy(bArr, 0, bArr2, 0, i);
            bArr = bArr2;
        }
        if (bArr.length > 64) {
            this.f1713d.update(bArr, 0, bArr.length);
            bArr = this.f1713d.digest();
        }
        byte[] bArr3 = new byte[64];
        this.f1711b = bArr3;
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        byte[] bArr4 = new byte[64];
        this.f1712c = bArr4;
        System.arraycopy(bArr, 0, bArr4, 0, bArr.length);
        for (int i2 = 0; i2 < 64; i2++) {
            byte[] bArr5 = this.f1711b;
            bArr5[i2] = (byte) (bArr5[i2] ^ 54);
            byte[] bArr6 = this.f1712c;
            bArr6[i2] = (byte) (bArr6[i2] ^ 92);
        }
        this.f1713d.update(this.f1711b, 0, 64);
    }

    /* renamed from: a */
    public void mo1180a(int i) {
        byte[] bArr = this.f1715f;
        bArr[0] = (byte) (i >>> 24);
        bArr[1] = (byte) (i >>> 16);
        bArr[2] = (byte) (i >>> 8);
        bArr[3] = (byte) i;
        mo1184a(bArr, 0, 4);
    }

    /* renamed from: a */
    public void mo1184a(byte[] bArr, int i, int i2) {
        this.f1713d.update(bArr, i, i2);
    }

    /* renamed from: a */
    public void mo1183a(byte[] bArr, int i) {
        byte[] digest = this.f1713d.digest();
        this.f1713d.update(this.f1712c, 0, 64);
        this.f1713d.update(digest, 0, this.f1714e);
        try {
            this.f1713d.digest(bArr, i, this.f1714e);
        } catch (Exception unused) {
        }
        this.f1713d.update(this.f1711b, 0, 64);
    }
}
