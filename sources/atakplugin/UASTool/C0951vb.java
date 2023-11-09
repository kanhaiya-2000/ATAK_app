package atakplugin.UASTool;

import atakplugin.UASTool.C0915uj;
import junit.framework.Assert;

/* renamed from: atakplugin.UASTool.vb */
public class C0951vb extends C0957vg {

    /* renamed from: d */
    private static final int f7367d = 90;

    /* renamed from: e */
    private static final int f7368e = 128;

    /* renamed from: f */
    private static final int f7369f = 129;

    /* renamed from: g */
    private static final int f7370g = 130;

    /* renamed from: h */
    private static final int f7371h = 131;

    /* renamed from: i */
    private static final int f7372i = 132;

    /* renamed from: j */
    private static final int f7373j = 136;

    /* renamed from: w */
    private static /* synthetic */ int[] f7374w;

    /* renamed from: k */
    private C0952a f7375k = C0952a.STATE_SYNC;

    /* renamed from: l */
    private int f7376l;

    /* renamed from: m */
    private int f7377m;

    /* renamed from: n */
    private int f7378n;

    /* renamed from: o */
    private int f7379o;

    /* renamed from: p */
    private int f7380p;

    /* renamed from: q */
    private byte[] f7381q;

    /* renamed from: r */
    private int f7382r;

    /* renamed from: s */
    private int f7383s;

    /* renamed from: t */
    private C0950va f7384t;

    /* renamed from: u */
    private C0954vd f7385u;

    /* renamed from: v */
    private boolean f7386v;

    /* renamed from: atakplugin.UASTool.vb$a */
    private enum C0952a {
        STATE_SYNC,
        STATE_CMD,
        STATE_SN,
        STATE_SIZE_HIGH,
        STATE_SIZE_LOW,
        STATE_COLLECT_DATA,
        STATE_CHECKSUM_HIGH,
        STATE_CHECKSUM_LOW
    }

    /* renamed from: a */
    private boolean m14198a(int i) {
        return i == 128 || i == 130 || i == 136;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(18:3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|(2:18|19)|20|22) */
    /* JADX WARNING: Can't wrap try/catch for region: R(19:3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|22) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0028 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0031 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x003a */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x0043 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x004c */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0015 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x001f */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ int[] m14200d() {
        /*
            int[] r0 = f7374w
            if (r0 == 0) goto L_0x0005
            return r0
        L_0x0005:
            atakplugin.UASTool.vb$a[] r0 = atakplugin.UASTool.C0951vb.C0952a.values()
            int r0 = r0.length
            int[] r0 = new int[r0]
            atakplugin.UASTool.vb$a r1 = atakplugin.UASTool.C0951vb.C0952a.STATE_CHECKSUM_HIGH     // Catch:{ NoSuchFieldError -> 0x0015 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0015 }
            r2 = 7
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0015 }
        L_0x0015:
            atakplugin.UASTool.vb$a r1 = atakplugin.UASTool.C0951vb.C0952a.STATE_CHECKSUM_LOW     // Catch:{ NoSuchFieldError -> 0x001f }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
            r2 = 8
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
        L_0x001f:
            atakplugin.UASTool.vb$a r1 = atakplugin.UASTool.C0951vb.C0952a.STATE_CMD     // Catch:{ NoSuchFieldError -> 0x0028 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
            r2 = 2
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
        L_0x0028:
            atakplugin.UASTool.vb$a r1 = atakplugin.UASTool.C0951vb.C0952a.STATE_COLLECT_DATA     // Catch:{ NoSuchFieldError -> 0x0031 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0031 }
            r2 = 6
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0031 }
        L_0x0031:
            atakplugin.UASTool.vb$a r1 = atakplugin.UASTool.C0951vb.C0952a.STATE_SIZE_HIGH     // Catch:{ NoSuchFieldError -> 0x003a }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003a }
            r2 = 4
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003a }
        L_0x003a:
            atakplugin.UASTool.vb$a r1 = atakplugin.UASTool.C0951vb.C0952a.STATE_SIZE_LOW     // Catch:{ NoSuchFieldError -> 0x0043 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
            r2 = 5
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0043 }
        L_0x0043:
            atakplugin.UASTool.vb$a r1 = atakplugin.UASTool.C0951vb.C0952a.STATE_SN     // Catch:{ NoSuchFieldError -> 0x004c }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004c }
            r2 = 3
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x004c }
        L_0x004c:
            atakplugin.UASTool.vb$a r1 = atakplugin.UASTool.C0951vb.C0952a.STATE_SYNC     // Catch:{ NoSuchFieldError -> 0x0055 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0055 }
            r2 = 1
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0055 }
        L_0x0055:
            f7374w = r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.C0951vb.m14200d():int[]");
    }

    public C0951vb(C0950va vaVar) {
        this.f7384t = vaVar;
    }

    /* renamed from: a */
    public void mo6005a(C0954vd vdVar) {
        this.f7385u = vdVar;
    }

    /* renamed from: a */
    public int mo6002a() {
        if (this.f7386v) {
            return 1;
        }
        this.f7386v = true;
        this.f7384t.mo5994a();
        start();
        return 0;
    }

    /* renamed from: b */
    public int mo6006b() {
        if (!this.f7386v) {
            return 3;
        }
        mo6021c(new C0955ve(-1, true, (Object) null, (Object) null, (Object) null));
        this.f7386v = false;
        return 0;
    }

    /* renamed from: a */
    public int mo6003a(byte[] bArr) {
        if (!this.f7386v) {
            return 3;
        }
        if (bArr.length > 65536) {
            return C0915uj.C0923h.f7214E;
        }
        int[] iArr = new int[1];
        int length = bArr.length;
        int a = m14197a(bArr, 90, 129, this.f7383s, length);
        int length2 = bArr.length + 8;
        byte[] bArr2 = new byte[length2];
        bArr2[0] = 0;
        bArr2[1] = 90;
        bArr2[2] = -127;
        bArr2[3] = (byte) this.f7383s;
        bArr2[4] = (byte) ((length & 65280) >> 8);
        int i = 6;
        bArr2[5] = (byte) (length & 255);
        int i2 = 0;
        while (i2 < bArr.length) {
            bArr2[i] = bArr[i2];
            i2++;
            i++;
        }
        bArr2[i] = (byte) ((a & 65280) >> 8);
        bArr2[i + 1] = (byte) (a & 255);
        this.f7384t.mo5999b(bArr2, length2, iArr);
        if (iArr[0] != length2) {
            return 4;
        }
        int i3 = this.f7383s + 1;
        this.f7383s = i3;
        if (i3 >= 256) {
            this.f7383s = 0;
        }
        return 0;
    }

    /* renamed from: a */
    private int m14197a(byte[] bArr, int i, int i2, int i3, int i4) {
        int i5 = 0;
        if (bArr != null) {
            int i6 = 0;
            while (i5 < bArr.length) {
                i6 += bArr[i5] & 255;
                i5++;
            }
            i5 = i6;
        }
        return i5 + i + i2 + i3 + ((65280 & i4) >> 8) + (i4 & 255);
    }

    /* renamed from: e */
    private void m14201e() {
        int i = this.f7378n;
        int a = m14197a((byte[]) null, 90, 132, i, 0);
        C0950va vaVar = this.f7384t;
        vaVar.mo5999b(new byte[]{0, 90, -124, (byte) i, 0, 0, (byte) ((65280 & a) >> 8), (byte) (a & 255)}, 8, new int[1]);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m14199b(byte[] r14) {
        /*
            r13 = this;
            r0 = 0
            r1 = 0
            r2 = 0
            r3 = 0
        L_0x0004:
            int r4 = r14.length
            if (r1 < r4) goto L_0x0008
            return
        L_0x0008:
            byte r4 = r14[r1]
            r4 = r4 & 255(0xff, float:3.57E-43)
            int[] r5 = m14200d()
            atakplugin.UASTool.vb$a r6 = r13.f7375k
            int r6 = r6.ordinal()
            r5 = r5[r6]
            r6 = 1
            switch(r5) {
                case 1: goto L_0x00a4;
                case 2: goto L_0x0094;
                case 3: goto L_0x008d;
                case 4: goto L_0x0084;
                case 5: goto L_0x0074;
                case 6: goto L_0x0060;
                case 7: goto L_0x0057;
                case 8: goto L_0x001e;
                default: goto L_0x001c;
            }
        L_0x001c:
            goto L_0x00b0
        L_0x001e:
            int r2 = r13.f7382r
            int r2 = r2 + r4
            r13.f7382r = r2
            byte[] r8 = r13.f7381q
            int r9 = r13.f7376l
            int r10 = r13.f7377m
            int r11 = r13.f7378n
            int r12 = r13.f7379o
            r7 = r13
            int r2 = r7.m14197a(r8, r9, r10, r11, r12)
            int r4 = r13.f7382r
            if (r4 != r2) goto L_0x0055
            int r2 = r13.f7377m
            r4 = 128(0x80, float:1.794E-43)
            if (r2 != r4) goto L_0x00a8
            r13.m14201e()
            atakplugin.UASTool.vd r2 = r13.f7385u
            if (r2 == 0) goto L_0x00a8
            atakplugin.UASTool.vf r2 = new atakplugin.UASTool.vf
            r8 = 3
            r9 = 0
            byte[] r10 = r13.f7381q
            r11 = 0
            r12 = 0
            r7 = r2
            r7.<init>(r8, r9, r10, r11, r12)
            atakplugin.UASTool.vd r4 = r13.f7385u
            r4.mo6019a(r2)
            goto L_0x00a8
        L_0x0055:
            r3 = 1
            goto L_0x00a8
        L_0x0057:
            int r4 = r4 * 256
            r13.f7382r = r4
            atakplugin.UASTool.vb$a r4 = atakplugin.UASTool.C0951vb.C0952a.STATE_CHECKSUM_LOW
            r13.f7375k = r4
            goto L_0x00b0
        L_0x0060:
            byte[] r4 = r13.f7381q
            int r5 = r13.f7380p
            byte r7 = r14[r1]
            r4[r5] = r7
            int r5 = r5 + r6
            r13.f7380p = r5
            int r4 = r13.f7379o
            if (r5 != r4) goto L_0x00b0
            atakplugin.UASTool.vb$a r4 = atakplugin.UASTool.C0951vb.C0952a.STATE_CHECKSUM_HIGH
            r13.f7375k = r4
            goto L_0x00b0
        L_0x0074:
            int r5 = r13.f7379o
            int r5 = r5 + r4
            r13.f7379o = r5
            r13.f7380p = r0
            byte[] r4 = new byte[r5]
            r13.f7381q = r4
            atakplugin.UASTool.vb$a r4 = atakplugin.UASTool.C0951vb.C0952a.STATE_COLLECT_DATA
            r13.f7375k = r4
            goto L_0x00b0
        L_0x0084:
            int r4 = r4 * 256
            r13.f7379o = r4
            atakplugin.UASTool.vb$a r4 = atakplugin.UASTool.C0951vb.C0952a.STATE_SIZE_LOW
            r13.f7375k = r4
            goto L_0x00b0
        L_0x008d:
            r13.f7378n = r4
            atakplugin.UASTool.vb$a r4 = atakplugin.UASTool.C0951vb.C0952a.STATE_SIZE_HIGH
            r13.f7375k = r4
            goto L_0x00b0
        L_0x0094:
            boolean r5 = r13.m14198a((int) r4)
            if (r5 != 0) goto L_0x009d
            r2 = 1
            r3 = 1
            goto L_0x009f
        L_0x009d:
            r13.f7377m = r4
        L_0x009f:
            atakplugin.UASTool.vb$a r4 = atakplugin.UASTool.C0951vb.C0952a.STATE_SN
            r13.f7375k = r4
            goto L_0x00b0
        L_0x00a4:
            r5 = 90
            if (r4 == r5) goto L_0x00aa
        L_0x00a8:
            r2 = 1
            goto L_0x00b0
        L_0x00aa:
            atakplugin.UASTool.vb$a r5 = atakplugin.UASTool.C0951vb.C0952a.STATE_CMD
            r13.f7375k = r5
            r13.f7376l = r4
        L_0x00b0:
            if (r3 == 0) goto L_0x00c6
            atakplugin.UASTool.vd r4 = r13.f7385u
            if (r4 == 0) goto L_0x00c6
            atakplugin.UASTool.vf r4 = new atakplugin.UASTool.vf
            r6 = 3
            r7 = 1
            r8 = 0
            r9 = 0
            r10 = 0
            r5 = r4
            r5.<init>(r6, r7, r8, r9, r10)
            atakplugin.UASTool.vd r5 = r13.f7385u
            r5.mo6019a(r4)
        L_0x00c6:
            if (r2 == 0) goto L_0x00dd
            atakplugin.UASTool.vb$a r2 = atakplugin.UASTool.C0951vb.C0952a.STATE_SYNC
            r13.f7375k = r2
            r13.f7376l = r0
            r13.f7377m = r0
            r13.f7378n = r0
            r13.f7379o = r0
            r13.f7380p = r0
            r13.f7382r = r0
            r2 = 0
            r13.f7381q = r2
            r2 = 0
            r3 = 0
        L_0x00dd:
            int r1 = r1 + 1
            goto L_0x0004
        */
        throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.C0951vb.m14199b(byte[]):void");
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0010, code lost:
        r2 = r1[0];
        r3 = new byte[r2];
     */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo6008c() {
        /*
            r8 = this;
            r0 = 1
            int[] r1 = new int[r0]
            atakplugin.UASTool.va r2 = r8.f7384t
            int r2 = r2.mo5997a(r1)
            r3 = 0
            r4 = r1[r3]
            if (r4 <= 0) goto L_0x001f
            if (r2 != 0) goto L_0x001f
            r2 = r1[r3]
            byte[] r3 = new byte[r2]
            atakplugin.UASTool.va r4 = r8.f7384t
            int r2 = r4.mo5996a(r3, r2, r1)
            if (r2 != 0) goto L_0x001f
            r8.m14199b((byte[]) r3)
        L_0x001f:
            r1 = 4
            if (r2 != r1) goto L_0x0037
            atakplugin.UASTool.vd r1 = r8.f7385u
            if (r1 == 0) goto L_0x0037
            atakplugin.UASTool.vf r1 = new atakplugin.UASTool.vf
            r3 = 3
            r4 = 2
            byte[] r5 = r8.f7381q
            r6 = 0
            r7 = 0
            r2 = r1
            r2.<init>(r3, r4, r5, r6, r7)
            atakplugin.UASTool.vd r2 = r8.f7385u
            r2.mo6019a(r1)
        L_0x0037:
            r1 = 10
            java.lang.Thread.sleep(r1)     // Catch:{ InterruptedException -> 0x003c }
        L_0x003c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.C0951vb.mo6008c():boolean");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo6004a(C0953vc vcVar) {
        if (vcVar instanceof C0955ve) {
            vcVar.mo6017d();
            return;
        }
        Assert.assertTrue("processEvent wrong type" + vcVar.mo6017d(), false);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public boolean mo6007b(C0953vc vcVar) {
        if (!Thread.interrupted()) {
            return true;
        }
        if (!(vcVar instanceof C0955ve)) {
            Assert.assertTrue("processEvent wrong type" + vcVar.mo6017d(), false);
        } else if (vcVar.mo6017d() != -1) {
            return false;
        } else {
            return true;
        }
        return false;
    }
}
