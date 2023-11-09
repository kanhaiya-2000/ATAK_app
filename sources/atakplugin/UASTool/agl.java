package atakplugin.UASTool;

import com.google.common.base.Ascii;
import java.io.IOException;
import java.net.Socket;
import java.util.Hashtable;

class agl extends afy {

    /* renamed from: B */
    static byte[] f1123B = null;

    /* renamed from: C */
    private static final int f1124C = 131072;

    /* renamed from: D */
    private static final int f1125D = 16384;

    /* renamed from: E */
    private static final int f1126E = 10000;

    /* renamed from: F */
    private static String f1127F = "127.0.0.1";

    /* renamed from: G */
    private static int f1128G = 6000;

    /* renamed from: I */
    private static byte[] f1129I;

    /* renamed from: J */
    private static Hashtable f1130J = new Hashtable();

    /* renamed from: K */
    private static Hashtable f1131K = new Hashtable();

    /* renamed from: L */
    private static byte[] f1132L = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};

    /* renamed from: H */
    private boolean f1133H = true;

    /* renamed from: M */
    private Socket f1134M = null;

    /* renamed from: N */
    private byte[] f1135N = new byte[0];

    /* renamed from: a */
    static int m1217a(byte b) {
        int i = 0;
        while (true) {
            byte[] bArr = f1132L;
            if (i >= bArr.length) {
                return 0;
            }
            if (bArr[i] == b) {
                return i;
            }
            i++;
        }
    }

    /* renamed from: c */
    static void m1219c(String str) {
        f1129I = aji.m1820c(str);
        f1123B = new byte[16];
        for (int i = 0; i < 16; i++) {
            int i2 = i * 2;
            f1123B[i] = (byte) (((m1217a(f1129I[i2]) << 4) & 240) | (m1217a(f1129I[i2 + 1]) & 15));
        }
    }

    /* renamed from: d */
    static void m1223d(String str) {
        f1127F = str;
    }

    /* renamed from: i */
    static void m1224i(int i) {
        f1128G = i;
    }

    /* renamed from: c */
    static byte[] m1220c(air air) {
        byte[] bArr;
        int i;
        synchronized (f1131K) {
            bArr = (byte[]) f1131K.get(air);
            if (bArr == null) {
                aie aie = air.f1433H;
                byte[] bArr2 = new byte[16];
                synchronized (aie) {
                    aie.mo1012a(bArr2, 0, 16);
                }
                f1130J.put(air, bArr2);
                bArr = new byte[32];
                for (i = 0; i < 16; i++) {
                    int i2 = i * 2;
                    byte[] bArr3 = f1132L;
                    bArr[i2] = bArr3[(bArr2[i] >>> 4) & 15];
                    bArr[i2 + 1] = bArr3[bArr2[i] & Ascii.f8523SI];
                }
                f1131K.put(air, bArr);
            }
        }
        return bArr;
    }

    /* renamed from: d */
    static void m1222d(air air) {
        synchronized (f1131K) {
            f1131K.remove(air);
            f1130J.remove(air);
        }
    }

    agl() {
        mo668c(131072);
        mo670d(131072);
        mo671e(16384);
        this.f904k = aji.m1820c("x11");
        this.f915v = true;
    }

    public void run() {
        try {
            Socket a = aji.m1805a(f1127F, f1128G, 10000);
            this.f1134M = a;
            a.setTcpNoDelay(true);
            this.f910q = new ahc();
            this.f910q.mo855a(this.f1134M.getInputStream());
            this.f910q.mo857a(this.f1134M.getOutputStream());
            mo688r();
            this.f911r = Thread.currentThread();
            afx afx = new afx(this.f909p);
            ahy ahy = new ahy(afx);
            while (true) {
                try {
                    if (this.f911r == null || this.f910q == null || this.f910q.f1234a == null) {
                        break;
                    }
                    int read = this.f910q.f1234a.read(afx.f888b, 14, (afx.f888b.length - 14) - 84);
                    if (read <= 0) {
                        mo680j();
                        break;
                    } else if (this.f914u) {
                        break;
                    } else {
                        ahy.mo996a();
                        afx.mo618a((byte) 94);
                        afx.mo619a(this.f903j);
                        afx.mo619a(read);
                        afx.mo626b(read);
                        mo686p().mo1042a(ahy, (afy) this, read);
                    }
                } catch (Exception unused) {
                }
            }
            mo683m();
        } catch (Exception unused2) {
            mo678h(1);
            this.f914u = true;
            mo683m();
        }
    }

    /* renamed from: c */
    private byte[] m1221c(byte[] bArr, int i, int i2) {
        byte[] bArr2 = this.f1135N;
        byte[] bArr3 = new byte[(bArr2.length + i2)];
        System.arraycopy(bArr, i, bArr3, bArr2.length, i2);
        byte[] bArr4 = this.f1135N;
        if (bArr4.length > 0) {
            System.arraycopy(bArr4, 0, bArr3, 0, bArr4.length);
        }
        this.f1135N = bArr3;
        return bArr3;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo658a(byte[] bArr, int i, int i2) {
        byte[] bArr2;
        if (this.f1133H) {
            try {
                air p = mo686p();
                byte[] c = m1221c(bArr, i, i2);
                int length = c.length;
                if (length >= 9) {
                    int i3 = ((c[6] & 255) * 256) + (c[7] & 255);
                    int i4 = ((c[8] & 255) * 256) + (c[9] & 255);
                    if ((c[0] & 255) != 66 && (c[0] & 255) == 108) {
                        i3 = ((i3 << 8) & 65280) | ((i3 >>> 8) & 255);
                        i4 = ((i4 << 8) & 65280) | ((i4 >>> 8) & 255);
                    }
                    int i5 = (-i3) & 3;
                    if (length >= i3 + 12 + i5 + i4) {
                        byte[] bArr3 = new byte[i4];
                        int i6 = 12 + i3 + i5;
                        System.arraycopy(c, i6, bArr3, 0, i4);
                        synchronized (f1130J) {
                            bArr2 = (byte[]) f1130J.get(p);
                        }
                        if (m1218a(bArr3, bArr2)) {
                            byte[] bArr4 = f1123B;
                            if (bArr4 != null) {
                                System.arraycopy(bArr4, 0, c, i6, i4);
                            }
                        } else {
                            this.f911r = null;
                            mo680j();
                            this.f910q.mo865c();
                            mo683m();
                        }
                        this.f1133H = false;
                        this.f910q.mo860a(c, 0, length);
                        this.f1135N = null;
                    }
                }
            } catch (ahj e) {
                throw new IOException(e.toString());
            }
        } else {
            this.f910q.mo860a(bArr, i, i2);
        }
    }

    /* renamed from: a */
    private static boolean m1218a(byte[] bArr, byte[] bArr2) {
        if (bArr.length != bArr2.length) {
            return false;
        }
        for (int i = 0; i < bArr.length; i++) {
            if (bArr[i] != bArr2[i]) {
                return false;
            }
        }
        return true;
    }
}
