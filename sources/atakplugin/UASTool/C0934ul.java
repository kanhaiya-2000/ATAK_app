package atakplugin.UASTool;

import android.util.Log;
import atakplugin.UASTool.C0915uj;
import com.google.common.base.Ascii;

/* renamed from: atakplugin.UASTool.ul */
public class C0934ul implements C0945uw {

    /* renamed from: a */
    static final int f7312a = 4;

    /* renamed from: c */
    static final int f7313c = 32;

    /* renamed from: d */
    static final int f7314d = 33;

    /* renamed from: e */
    static final int f7315e = 33;

    /* renamed from: f */
    static final int f7316f = 34;

    /* renamed from: g */
    static final int f7317g = 34;

    /* renamed from: h */
    static final int f7318h = 35;

    /* renamed from: i */
    static final int f7319i = 35;

    /* renamed from: j */
    static final int f7320j = 36;

    /* renamed from: k */
    static final int f7321k = 36;

    /* renamed from: b */
    boolean f7322b = true;

    /* renamed from: l */
    private C0933uk f7323l;

    /* renamed from: m */
    private C0879tj f7324m;

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public boolean mo5962e(int i) {
        return i != 0;
    }

    public C0934ul(C0933uk ukVar) {
        this.f7323l = ukVar;
        this.f7324m = ukVar.f7308b;
    }

    /* renamed from: a */
    public int mo5948a(int i, int i2) {
        return this.f7324m.mo5833a(33, i | (i2 << 8));
    }

    /* renamed from: a */
    public int mo5949a(int i, int i2, byte[] bArr, int i3) {
        return this.f7324m.mo5834a(33, i | (i2 << 8), bArr, i3);
    }

    /* renamed from: b */
    public int mo5955b(int i, int i2, byte[] bArr, int i3) {
        return this.f7324m.mo5854b(32, i | (i2 << 8), bArr, i3);
    }

    /* renamed from: a */
    public int mo5953a(int[] iArr) {
        C0940ur urVar = this.f7323l.f7309c;
        C0942ut utVar = new C0942ut();
        byte[] bArr = new byte[1];
        C0943uu uuVar = new C0943uu();
        mo5948a(7, 0);
        mo5948a(6, 0);
        int a = this.f7323l.mo5936a();
        if (a != 0) {
            Log.e("GPIO_M", "FT4222_GPIO init - 1 NG ftStatus:" + a);
            return a;
        } else if (urVar.f7342a == 2 || urVar.f7342a == 3) {
            return C0915uj.C0923h.f7217H;
        } else {
            mo5952a(utVar);
            byte b = utVar.f7358c;
            bArr[0] = utVar.f7359d[0];
            for (int i = 0; i < 4; i++) {
                b = (byte) ((iArr[i] == 1 ? b | (1 << i) : b & (~(1 << i))) & Ascii.f8523SI);
            }
            uuVar.f7362c = bArr[0];
            mo5948a(33, (int) b);
            return 0;
        }
    }

    /* renamed from: a */
    public int mo5951a(int i, boolean[] zArr) {
        C0942ut utVar = new C0942ut();
        int a = mo5947a(i);
        if (a != 0) {
            return a;
        }
        int a2 = mo5952a(utVar);
        if (a2 != 0) {
            return a2;
        }
        mo5954a(i, utVar.f7359d[0], zArr);
        return 0;
    }

    /* renamed from: b */
    public int mo5957b(int i, boolean[] zArr) {
        int a = mo5947a(i);
        if (a != 0) {
            return a;
        }
        int l = this.f7324m.mo5870l();
        if (l <= 0) {
            return -1;
        }
        byte[] bArr = new byte[l];
        this.f7324m.mo5837a(bArr, l);
        mo5954a(i, bArr[l - 1], zArr);
        return l;
    }

    /* renamed from: a */
    public int mo5950a(int i, boolean z) {
        C0942ut utVar = new C0942ut();
        int a = mo5947a(i);
        if (a != 0) {
            return a;
        }
        if (!mo5960c(i)) {
            return C0915uj.C0923h.f7219J;
        }
        mo5952a(utVar);
        if (z) {
            byte[] bArr = utVar.f7359d;
            bArr[0] = (byte) ((1 << i) | bArr[0]);
        } else {
            byte[] bArr2 = utVar.f7359d;
            bArr2[0] = (byte) ((~(1 << i)) & Ascii.f8523SI & bArr2[0]);
        }
        return this.f7324m.mo5856b(utVar.f7359d, 1);
    }

    /* renamed from: b */
    public int mo5956b(int i, boolean z) {
        C0942ut utVar = new C0942ut();
        int a = mo5947a(i);
        if (a != 0) {
            return a;
        }
        if (!mo5960c(i)) {
            return C0915uj.C0923h.f7219J;
        }
        mo5952a(utVar);
        if (z) {
            byte[] bArr = utVar.f7359d;
            bArr[0] = (byte) ((1 << i) | bArr[0]);
        } else {
            byte[] bArr2 = utVar.f7359d;
            bArr2[0] = (byte) ((~(1 << i)) & Ascii.f8523SI & bArr2[0]);
        }
        if (this.f7322b) {
            byte[] bArr3 = utVar.f7359d;
            bArr3[0] = (byte) (bArr3[0] | 8);
        } else {
            byte[] bArr4 = utVar.f7359d;
            bArr4[0] = (byte) (bArr4[0] & 7);
        }
        int b = this.f7324m.mo5856b(utVar.f7359d, 1);
        this.f7322b = !this.f7322b;
        return b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo5947a(int i) {
        C0940ur urVar = this.f7323l.f7309c;
        if (urVar.f7342a == 2 || urVar.f7342a == 3) {
            return C0915uj.C0923h.f7217H;
        }
        if (i >= 4) {
            return C0915uj.C0923h.f7218I;
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo5952a(C0942ut utVar) {
        byte[] bArr = new byte[8];
        int b = mo5955b(32, 0, bArr, 8);
        utVar.f7356a.f7353a = bArr[0];
        utVar.f7356a.f7354b = bArr[1];
        utVar.f7357b = bArr[5];
        utVar.f7358c = bArr[6];
        utVar.f7359d[0] = bArr[7];
        if (b == 8) {
            return 0;
        }
        return b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5954a(int i, byte b, boolean[] zArr) {
        zArr[0] = mo5962e(((b & (1 << i)) >> i) & 1);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo5958b(int i) {
        C0940ur urVar = this.f7323l.f7309c;
        byte b = urVar.f7342a;
        boolean z = true;
        if (b == 0) {
            if ((i == 0 || i == 1) && (urVar.f7348g == 1 || urVar.f7348g == 2)) {
                z = false;
            }
            if (mo5962e(urVar.f7350i) && i == 2) {
                z = false;
            }
            if (!mo5962e(urVar.f7351j) || i != 3) {
                return z;
            }
        } else if (b != 1) {
            return (b == 2 || b == 3) ? false : true;
        } else {
            if (i == 0 || i == 1) {
                z = false;
            }
            if (mo5962e(urVar.f7350i) && i == 2) {
                z = false;
            }
            if (!mo5962e(urVar.f7351j) || i != 3) {
                return z;
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public boolean mo5960c(int i) {
        C0942ut utVar = new C0942ut();
        boolean b = mo5958b(i);
        mo5952a(utVar);
        if (!b || ((utVar.f7358c >> i) & 1) == 1) {
            return b;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public boolean mo5961d(int i) {
        C0942ut utVar = new C0942ut();
        boolean b = mo5958b(i);
        mo5952a(utVar);
        if (!b || ((utVar.f7358c >> i) & 1) == 0) {
            return b;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo5959b(int i, int i2) {
        C0943uu uuVar = new C0943uu();
        if (uuVar.f7360a[i] == i2) {
            return true;
        }
        uuVar.f7360a[i] = i2;
        char c = 0;
        char c2 = 0;
        char c3 = 0;
        for (int i3 = 0; i3 < 4; i3++) {
            int i4 = uuVar.f7360a[i3];
            if (i4 == 1) {
                c = (char) (c + (1 << i3));
            } else if (i4 == 2) {
                c2 = (char) (c2 + (1 << i3));
            } else if (i4 == 3) {
                c3 = (char) (c3 + (1 << i3));
            }
        }
        int a = mo5948a(34, (int) c) | mo5948a(36, (int) c2) | mo5948a(35, (int) c3);
        if (a == 0) {
            uuVar.f7360a[i] = i2;
        }
        if (a == 0) {
            return true;
        }
        return false;
    }
}
