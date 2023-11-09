package atakplugin.UASTool;

import javax.crypto.Mac;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.SecretKeySpec;

abstract class ajv implements ahv {

    /* renamed from: a */
    protected String f1669a;

    /* renamed from: b */
    protected int f1670b;

    /* renamed from: c */
    protected String f1671c;

    /* renamed from: d */
    private Mac f1672d;

    /* renamed from: e */
    private final byte[] f1673e = new byte[4];

    ajv() {
    }

    /* renamed from: b */
    public int mo993b() {
        return this.f1670b;
    }

    /* renamed from: a */
    public void mo990a(byte[] bArr) {
        int length = bArr.length;
        int i = this.f1670b;
        if (length > i) {
            byte[] bArr2 = new byte[i];
            System.arraycopy(bArr, 0, bArr2, 0, i);
            bArr = bArr2;
        }
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, this.f1671c);
        Mac instance = Mac.getInstance(this.f1671c);
        this.f1672d = instance;
        instance.init(secretKeySpec);
    }

    /* renamed from: a */
    public void mo989a(int i) {
        byte[] bArr = this.f1673e;
        bArr[0] = (byte) (i >>> 24);
        bArr[1] = (byte) (i >>> 16);
        bArr[2] = (byte) (i >>> 8);
        bArr[3] = (byte) i;
        mo992a(bArr, 0, 4);
    }

    /* renamed from: a */
    public void mo992a(byte[] bArr, int i, int i2) {
        this.f1672d.update(bArr, i, i2);
    }

    /* renamed from: a */
    public void mo991a(byte[] bArr, int i) {
        try {
            this.f1672d.doFinal(bArr, i);
        } catch (ShortBufferException e) {
            System.err.println(e);
        }
    }

    /* renamed from: a */
    public String mo988a() {
        return this.f1669a;
    }
}
