package atakplugin.UASTool;

import android.util.Log;
import atakplugin.UASTool.C0915uj;
import com.google.common.base.Ascii;
import junit.framework.Assert;

/* renamed from: atakplugin.UASTool.uo */
public class C0937uo implements C0948uz {

    /* renamed from: c */
    private static final String f7330c = "FTDI_Device::";

    /* renamed from: a */
    private C0933uk f7331a;

    /* renamed from: b */
    private C0879tj f7332b;

    public C0937uo(C0933uk ukVar) {
        this.f7331a = ukVar;
        this.f7332b = ukVar.f7308b;
    }

    /* renamed from: a */
    public int mo5989a(int i, int i2, int i3, int i4, byte b) {
        C0940ur urVar = this.f7331a.f7309c;
        C0939uq uqVar = this.f7331a.f7310d;
        uqVar.f7337a = i;
        uqVar.f7338b = i2;
        uqVar.f7339c = i3;
        uqVar.f7340d = i4;
        uqVar.f7341e = b;
        byte b2 = 1;
        if (uqVar.f7337a != 1 && uqVar.f7337a != 2 && uqVar.f7337a != 4) {
            return 6;
        }
        this.f7331a.mo5939b();
        byte b3 = urVar.f7342a;
        if (b3 != 0) {
            if (b3 == 1) {
                b2 = 7;
            } else if (b3 == 2) {
                b2 = Ascii.f8523SI;
            } else if (b3 != 3) {
                b2 = 0;
            }
        }
        if ((uqVar.f7341e & b2) == 0) {
            return 6;
        }
        uqVar.f7341e = (byte) (uqVar.f7341e & b2);
        if (this.f7332b.mo5833a(33, (uqVar.f7337a << 8) | 66) < 0 || this.f7332b.mo5833a(33, (uqVar.f7338b << 8) | 68) < 0 || this.f7332b.mo5833a(33, (uqVar.f7339c << 8) | 69) < 0 || this.f7332b.mo5833a(33, (uqVar.f7340d << 8) | 70) < 0 || this.f7332b.mo5833a(33, 67) < 0 || this.f7332b.mo5833a(33, (uqVar.f7341e << 8) | 72) < 0 || this.f7332b.mo5833a(33, 773) < 0) {
            return 4;
        }
        urVar.f7348g = 3;
        return 0;
    }

    /* renamed from: a */
    public int mo5987a(int i) {
        if (this.f7331a.f7309c.f7348g != 3) {
            return C0915uj.C0923h.f7249x;
        }
        if (i == 0) {
            return 17;
        }
        if (this.f7332b.mo5833a(33, (i << 8) | 66) < 0 || this.f7332b.mo5833a(33, 330) < 0) {
            return 4;
        }
        this.f7331a.f7310d.f7337a = i;
        return 0;
    }

    /* renamed from: a */
    public int mo5990a(byte[] bArr, int i, int[] iArr, boolean z) {
        return mo5992a(new byte[bArr.length], bArr, i, iArr, z);
    }

    /* renamed from: b */
    public int mo5993b(byte[] bArr, int i, int[] iArr, boolean z) {
        return mo5992a(bArr, new byte[bArr.length], i, iArr, z);
    }

    /* renamed from: a */
    public int mo5992a(byte[] bArr, byte[] bArr2, int i, int[] iArr, boolean z) {
        C0940ur urVar = this.f7331a.f7309c;
        C0939uq uqVar = this.f7331a.f7310d;
        if (bArr2 == null || bArr == null || iArr == null) {
            return C0915uj.C0923h.f7213D;
        }
        iArr[0] = 0;
        if (urVar.f7348g != 3 || uqVar.f7337a != 1) {
            return C0915uj.C0923h.f7251z;
        }
        if (i == 0) {
            return 6;
        }
        if (i > bArr2.length || i > bArr.length) {
            Assert.assertTrue("sizeToTransfer > writeBuffer.length || sizeToTransfer > readBuffer.length", false);
        }
        if (bArr2.length != bArr.length || bArr2.length == 0) {
            Assert.assertTrue("writeBuffer.length != readBuffer.length || writeBuffer.length == 0", false);
        }
        iArr[0] = m14153a(this.f7332b, bArr2, bArr, i);
        if (z) {
            this.f7332b.mo5856b((byte[]) null, 0);
        }
        return 0;
    }

    /* renamed from: a */
    public int mo5991a(byte[] bArr, byte[] bArr2, int i, int i2, int i3, int[] iArr) {
        C0940ur urVar = this.f7331a.f7309c;
        C0939uq uqVar = this.f7331a.f7310d;
        if (i3 > 0 && bArr == null) {
            return C0915uj.C0923h.f7213D;
        }
        int i4 = i + i2;
        if (i4 > 0 && bArr2 == null) {
            return C0915uj.C0923h.f7213D;
        }
        if (i3 > 0 && iArr == null) {
            return C0915uj.C0923h.f7213D;
        }
        if (urVar.f7348g != 3 || uqVar.f7337a == 1) {
            return C0915uj.C0923h.f7210A;
        }
        if (i > 15) {
            Log.e(f7330c, "The maxium single write bytes are 15 bytes");
            return 6;
        }
        byte[] bArr3 = new byte[(i + 5 + i2)];
        bArr3[0] = (byte) ((i & 15) | 128);
        bArr3[1] = (byte) ((i2 & 65280) >> 8);
        bArr3[2] = (byte) (i2 & 255);
        bArr3[3] = (byte) ((65280 & i3) >> 8);
        bArr3[4] = (byte) (i3 & 255);
        for (int i5 = 0; i5 < i4; i5++) {
            bArr3[i5 + 5] = bArr2[i5];
        }
        iArr[0] = m14152a(this.f7332b, bArr3, bArr);
        return 0;
    }

    /* renamed from: a */
    public int mo5986a() {
        return this.f7332b.mo5833a(33, 74) < 0 ? 4 : 0;
    }

    /* renamed from: a */
    public int mo5988a(int i, int i2, int i3) {
        C0940ur urVar = this.f7331a.f7309c;
        int i4 = 3;
        if (urVar.f7348g != 3 && urVar.f7348g != 4) {
            return C0915uj.C0923h.f7249x;
        }
        int i5 = (i << 4) | (i2 << 2) | i3;
        if (urVar.f7348g != 3) {
            i4 = 4;
        }
        if (this.f7332b.mo5833a(33, (i5 << 8) | 160) >= 0 && this.f7332b.mo5833a(33, (i4 << 8) | 5) >= 0) {
            return 0;
        }
        return 4;
    }

    /* renamed from: a */
    private int m14152a(C0879tj tjVar, byte[] bArr, byte[] bArr2) {
        if (tjVar != null && tjVar.mo5864f()) {
            tjVar.mo5856b(bArr, bArr.length);
            int i = 0;
            int i2 = 0;
            while (i < bArr2.length && i2 < 30000) {
                int l = tjVar.mo5870l();
                if (l > 0) {
                    byte[] bArr3 = new byte[l];
                    int a = tjVar.mo5837a(bArr3, l);
                    Assert.assertEquals(l == a, true);
                    for (int i3 = 0; i3 < l; i3++) {
                        int i4 = i + i3;
                        if (i4 < bArr2.length) {
                            bArr2[i4] = bArr3[i3];
                        }
                    }
                    i += a;
                    i2 = 0;
                }
                try {
                    Thread.sleep((long) 10);
                    i2 += 10;
                } catch (InterruptedException unused) {
                    i2 = 30000;
                }
            }
            if (bArr2.length == i && i2 <= 30000) {
                return i;
            }
            Log.e(f7330c, "MultiReadWritePackage timeout!!!!");
        }
        return -1;
    }

    /* renamed from: a */
    private int m14153a(C0879tj tjVar, byte[] bArr, byte[] bArr2, int i) {
        byte[] bArr3 = new byte[16384];
        byte[] bArr4 = new byte[16384];
        int i2 = i / 16384;
        int i3 = i % 16384;
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < i2; i6++) {
            for (int i7 = 0; i7 < 16384; i7++) {
                bArr3[i7] = bArr[i4];
                i4++;
            }
            if (m14154b(tjVar, bArr3, bArr4) <= 0) {
                return -1;
            }
            for (int i8 = 0; i8 < 16384; i8++) {
                bArr2[i5] = bArr4[i8];
                i5++;
            }
        }
        if (i3 > 0) {
            byte[] bArr5 = new byte[i3];
            byte[] bArr6 = new byte[i3];
            for (int i9 = 0; i9 < i3; i9++) {
                bArr5[i9] = bArr[i4];
                i4++;
            }
            if (m14154b(tjVar, bArr5, bArr6) <= 0) {
                return -1;
            }
            for (int i10 = 0; i10 < i3; i10++) {
                bArr2[i5] = bArr6[i10];
                i5++;
            }
        }
        return i5;
    }

    /* renamed from: b */
    private int m14154b(C0879tj tjVar, byte[] bArr, byte[] bArr2) {
        if (tjVar != null && tjVar.mo5864f()) {
            Assert.assertEquals(bArr.length == bArr2.length, true);
            if (bArr.length != tjVar.mo5856b(bArr, bArr.length)) {
                Log.e(f7330c, "setReadWritePackage Incomplete Write Error!!!");
                return -1;
            }
            int i = 0;
            int i2 = 0;
            while (i < bArr2.length && i2 < 30000) {
                int l = tjVar.mo5870l();
                if (l > 0) {
                    byte[] bArr3 = new byte[l];
                    int a = tjVar.mo5837a(bArr3, l);
                    Assert.assertEquals(l == a, true);
                    for (int i3 = 0; i3 < l; i3++) {
                        int i4 = i + i3;
                        if (i4 < bArr2.length) {
                            bArr2[i4] = bArr3[i3];
                        }
                    }
                    i += a;
                    i2 = 0;
                }
                try {
                    Thread.sleep((long) 10);
                    i2 += 10;
                } catch (InterruptedException unused) {
                    i2 = 30000;
                }
            }
            if (bArr2.length == i && i2 <= 30000) {
                return i;
            }
            Log.e(f7330c, "SingleReadWritePackage timeout!!!!");
        }
        return -1;
    }
}
