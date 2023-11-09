package atakplugin.UASTool;

import android.util.Log;
import com.atakmap.android.uastool.MAVLink.common.msg_collision;

/* renamed from: atakplugin.UASTool.ua */
class C0905ua {

    /* renamed from: d */
    private static final short f7033d = 1024;

    /* renamed from: e */
    private static final int f7034e = 4;

    /* renamed from: f */
    private static final int f7035f = 8;

    /* renamed from: g */
    private static final int f7036g = 64;

    /* renamed from: h */
    private static final int f7037h = 128;

    /* renamed from: i */
    private static final int f7038i = 32;

    /* renamed from: a */
    short f7039a;

    /* renamed from: b */
    int f7040b;

    /* renamed from: c */
    boolean f7041c;

    /* renamed from: j */
    private C0879tj f7042j;

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo5885a(byte[] bArr) {
        return 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C0880tk mo5886a() {
        return null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public short mo5887a(C0880tk tkVar) {
        return 1;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public byte[] mo5888a(int i) {
        return null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo5889b() {
        return 0;
    }

    /* renamed from: atakplugin.UASTool.ua$a */
    static final class C0906a {

        /* renamed from: a */
        static final short f7043a = 70;

        /* renamed from: b */
        static final short f7044b = 82;

        /* renamed from: c */
        static final short f7045c = 86;

        /* renamed from: d */
        static final short f7046d = 102;

        /* renamed from: e */
        static final short f7047e = 1;

        /* renamed from: f */
        static final short f7048f = 255;

        C0906a() {
        }
    }

    C0905ua(C0879tj tjVar) {
        this.f7042j = tjVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo5895a(short s) {
        byte[] bArr = new byte[2];
        if (s >= 1024) {
            return -1;
        }
        this.f7042j.mo5861c().controlTransfer(-64, 144, 0, s, bArr, 2, 0);
        return ((bArr[1] & 255) << 8) | (bArr[0] & 255);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo5890a(short s, short s2) {
        return s < 1024 && this.f7042j.mo5861c().controlTransfer(64, 145, s2 & 65535, s & 65535, (byte[]) null, 0, 0) == 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public int mo5902c() {
        return this.f7042j.mo5861c().controlTransfer(64, 146, 0, 0, (byte[]) null, 0, 0);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo5900a(int[] iArr, int i) {
        short s = 43690;
        int i2 = 0;
        while (i2 < i) {
            mo5890a((short) i2, (short) iArr[i2]);
            short s2 = (s ^ iArr[i2]) & 65535;
            s = (((short) ((s2 >> 15) & 65535)) | ((short) ((s2 << 1) & 65535))) & 65535;
            i2++;
            Log.d("FT_EE_Ctrl", "Entered WriteWord Checksum : " + s);
        }
        mo5890a((short) i, (short) s);
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo5893a(Object obj) {
        C0880tk tkVar = (C0880tk) obj;
        int i = tkVar.f6696j ? 160 : 128;
        if (tkVar.f6695i) {
            i |= 64;
        }
        return ((tkVar.f6694h / 2) << 8) | i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5898a(C0880tk tkVar, int i) {
        tkVar.f6694h = (short) (((byte) (i >> 8)) * 2);
        byte b = (byte) i;
        if ((b & 64) == 64 && (b & 128) == 128) {
            tkVar.f6695i = true;
        } else {
            tkVar.f6695i = false;
        }
        if ((b & 32) == 32) {
            tkVar.f6696j = true;
        } else {
            tkVar.f6696j = false;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo5901b(Object obj) {
        C0880tk tkVar = (C0880tk) obj;
        int i = tkVar.f6697k ? 4 : 0;
        return tkVar.f6693g ? i | 8 : i & msg_collision.MAVLINK_MSG_ID_COLLISION;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5899a(Object obj, int i) {
        C0880tk tkVar = (C0880tk) obj;
        if ((i & 4) > 0) {
            tkVar.f6697k = true;
        } else {
            tkVar.f6697k = false;
        }
        if ((i & 8) > 0) {
            tkVar.f6693g = true;
        } else {
            tkVar.f6693g = false;
        }
    }

    /* JADX WARNING: type inference failed for: r4v1, types: [char[]] */
    /* JADX WARNING: type inference failed for: r1v2, types: [char] */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int mo5894a(java.lang.String r4, int[] r5, int r6, int r7, boolean r8) {
        /*
            r3 = this;
            int r0 = r4.length()
            int r0 = r0 * 2
            int r0 = r0 + 2
            int r1 = r0 << 8
            int r2 = r6 * 2
            r1 = r1 | r2
            r5[r7] = r1
            if (r8 == 0) goto L_0x0017
            r8 = r5[r7]
            int r8 = r8 + 128
            r5[r7] = r8
        L_0x0017:
            char[] r4 = r4.toCharArray()
            int r7 = r6 + 1
            r8 = r0 | 768(0x300, float:1.076E-42)
            r5[r6] = r8
            int r0 = r0 + -2
            int r0 = r0 / 2
            r6 = 0
        L_0x0026:
            int r8 = r7 + 1
            char r1 = r4[r6]
            r5[r7] = r1
            int r6 = r6 + 1
            if (r6 < r0) goto L_0x0031
            return r8
        L_0x0031:
            r7 = r8
            goto L_0x0026
        */
        throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.C0905ua.mo5894a(java.lang.String, int[], int, int, boolean):int");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String mo5896a(int i, int[] iArr) {
        int i2 = i + 1;
        int i3 = (((iArr[i] & 255) / 2) - 1) + i2;
        String str = "";
        while (i2 < i3) {
            str = String.valueOf(str) + ((char) iArr[i2]);
            i2++;
        }
        return str;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5897a(int i, int i2, int[] iArr) {
        while (i < i2) {
            iArr[i] = 0;
            i++;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo5892a(byte b) {
        short a = (short) mo5895a((short) (b & -1));
        if (a == 65535) {
            boolean a2 = mo5890a(192, (short) 192);
            mo5895a(192);
            mo5895a(64);
            mo5895a(0);
            if (!a2) {
                this.f7039a = 255;
                this.f7040b = 0;
                return 0;
            }
            this.f7041c = true;
            if ((mo5895a(0) & 255) == 192) {
                mo5902c();
                this.f7039a = 70;
                this.f7040b = 64;
                return 64;
            } else if ((mo5895a(64) & 255) == 192) {
                mo5902c();
                this.f7039a = 86;
                this.f7040b = 128;
                return 128;
            } else if ((mo5895a(192) & 255) == 192) {
                mo5902c();
                this.f7039a = 102;
                this.f7040b = 128;
                return 256;
            } else {
                mo5902c();
                return 0;
            }
        } else if (a == 70) {
            this.f7039a = 70;
            this.f7040b = 64;
            this.f7041c = false;
            return 64;
        } else if (a == 82) {
            this.f7039a = 82;
            this.f7040b = 1024;
            this.f7041c = false;
            return 1024;
        } else if (a == 86) {
            this.f7039a = 86;
            this.f7040b = 128;
            this.f7041c = false;
            return 128;
        } else if (a != 102) {
            return 0;
        } else {
            this.f7039a = 102;
            this.f7040b = 128;
            this.f7041c = false;
            return 256;
        }
    }
}
