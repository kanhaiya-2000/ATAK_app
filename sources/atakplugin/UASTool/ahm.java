package atakplugin.UASTool;

import com.google.common.base.Ascii;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Hashtable;
import java.util.Vector;

public abstract class ahm {

    /* renamed from: a */
    public static final int f1286a = 0;

    /* renamed from: b */
    public static final int f1287b = 1;

    /* renamed from: c */
    public static final int f1288c = 2;

    /* renamed from: d */
    public static final int f1289d = 3;

    /* renamed from: e */
    static final int f1290e = 0;

    /* renamed from: f */
    static final int f1291f = 1;

    /* renamed from: g */
    static final int f1292g = 2;

    /* renamed from: h */
    static final int f1293h = 3;

    /* renamed from: l */
    static byte[][] f1294l = {aji.m1820c("Proc-Type: 4,ENCRYPTED"), aji.m1820c("DEK-Info: DES-EDE3-CBC,")};

    /* renamed from: o */
    private static final byte[] f1295o = aji.m1820c("\n");

    /* renamed from: t */
    private static byte[] f1296t = aji.m1820c(" ");

    /* renamed from: w */
    private static final String[] f1297w = {"PuTTY-User-Key-File-2: ", "Encryption: ", "Comment: ", "Public-Lines: "};

    /* renamed from: x */
    private static final String[] f1298x = {"Private-Lines: "};

    /* renamed from: y */
    private static final String[] f1299y = {"Private-MAC: "};

    /* renamed from: i */
    int f1300i = 0;

    /* renamed from: j */
    protected String f1301j = "no comment";

    /* renamed from: k */
    ahg f1302k = null;

    /* renamed from: m */
    protected boolean f1303m = false;

    /* renamed from: n */
    protected byte[] f1304n = null;

    /* renamed from: p */
    private agm f1305p;

    /* renamed from: q */
    private agz f1306q;

    /* renamed from: r */
    private aie f1307r;

    /* renamed from: s */
    private byte[] f1308s;

    /* renamed from: u */
    private byte[] f1309u = null;

    /* renamed from: v */
    private byte[] f1310v = null;

    /* renamed from: a */
    private static byte m1390a(byte b) {
        return (byte) ((48 > b || b > 57) ? (b - 97) + 10 : b - 48);
    }

    /* renamed from: b */
    private static byte m1401b(byte b) {
        return (byte) ((b < 0 || b > 9) ? (b - 10) + 65 : b + 48);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract void mo920a(int i);

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract byte[] mo928a();

    /* renamed from: a */
    public abstract byte[] mo929a(byte[] bArr);

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo931b(int i) {
        int i2 = 1;
        if (i <= 127) {
            return 1;
        }
        while (i > 0) {
            i >>>= 8;
            i2++;
        }
        return i2;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public abstract boolean mo936b(byte[] bArr);

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public abstract byte[] mo937b();

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public abstract int mo938c();

    /* renamed from: d */
    public abstract aiw mo941d();

    /* renamed from: e */
    public abstract byte[] mo944e();

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public abstract byte[] mo947g();

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public abstract byte[] mo948h();

    /* renamed from: i */
    public abstract int mo949i();

    /* renamed from: a */
    public static ahm m1391a(ahg ahg, int i) {
        return m1392a(ahg, i, 1024);
    }

    /* renamed from: a */
    public static ahm m1392a(ahg ahg, int i, int i2) {
        ahm ahm;
        if (i == 1) {
            ahm = new ahn(ahg);
        } else {
            ahm = i == 2 ? new ahr(ahg) : null;
        }
        if (ahm != null) {
            ahm.mo920a(i2);
        }
        return ahm;
    }

    /* renamed from: f */
    public String mo945f() {
        return this.f1301j;
    }

    /* renamed from: a */
    public void mo925a(String str) {
        this.f1301j = str;
    }

    public ahm(ahg ahg) {
        this.f1302k = ahg;
    }

    /* renamed from: a */
    public void mo922a(OutputStream outputStream) {
        mo924a(outputStream, (byte[]) null);
    }

    /* renamed from: a */
    public void mo924a(OutputStream outputStream, byte[] bArr) {
        if (bArr == null) {
            bArr = this.f1308s;
        }
        byte[] g = mo947g();
        byte[][] bArr2 = new byte[1][];
        byte[] a = m1400a(g, bArr2, bArr);
        if (a != g) {
            aji.m1822d(g);
        }
        int i = 0;
        byte[] bArr3 = bArr2[0];
        byte[] b = aji.m1817b(a, 0, a.length);
        try {
            outputStream.write(mo928a());
            byte[] bArr4 = f1295o;
            outputStream.write(bArr4);
            if (bArr != null) {
                outputStream.write(f1294l[0]);
                outputStream.write(bArr4);
                outputStream.write(f1294l[1]);
                for (int i2 = 0; i2 < bArr3.length; i2++) {
                    outputStream.write(m1401b((byte) ((bArr3[i2] >>> 4) & 15)));
                    outputStream.write(m1401b((byte) (bArr3[i2] & Ascii.f8523SI)));
                }
                byte[] bArr5 = f1295o;
                outputStream.write(bArr5);
                outputStream.write(bArr5);
            }
            while (true) {
                if (i < b.length) {
                    int i3 = i + 64;
                    if (i3 >= b.length) {
                        outputStream.write(b, i, b.length - i);
                        outputStream.write(f1295o);
                        break;
                    }
                    outputStream.write(b, i, 64);
                    outputStream.write(f1295o);
                    i = i3;
                } else {
                    break;
                }
            }
            outputStream.write(mo937b());
            outputStream.write(f1295o);
        } catch (Exception unused) {
        }
    }

    /* renamed from: j */
    public byte[] mo950j() {
        return this.f1310v;
    }

    /* renamed from: a */
    public void mo923a(OutputStream outputStream, String str) {
        byte[] j = mo950j();
        byte[] b = aji.m1817b(j, 0, j.length);
        try {
            outputStream.write(mo948h());
            outputStream.write(f1296t);
            outputStream.write(b, 0, b.length);
            outputStream.write(f1296t);
            outputStream.write(aji.m1820c(str));
            outputStream.write(f1295o);
        } catch (Exception unused) {
        }
    }

    /* renamed from: a */
    public void mo926a(String str, String str2) {
        FileOutputStream fileOutputStream = new FileOutputStream(str);
        mo923a((OutputStream) fileOutputStream, str2);
        fileOutputStream.close();
    }

    /* renamed from: b */
    public void mo933b(OutputStream outputStream, String str) {
        byte[] j = mo950j();
        int i = 0;
        byte[] b = aji.m1817b(j, 0, j.length);
        try {
            outputStream.write(aji.m1820c("---- BEGIN SSH2 PUBLIC KEY ----"));
            byte[] bArr = f1295o;
            outputStream.write(bArr);
            outputStream.write(aji.m1820c("Comment: \"" + str + "\""));
            outputStream.write(bArr);
            while (i < b.length) {
                int i2 = 70;
                if (b.length - i < 70) {
                    i2 = b.length - i;
                }
                outputStream.write(b, i, i2);
                outputStream.write(f1295o);
                i += i2;
            }
            outputStream.write(aji.m1820c("---- END SSH2 PUBLIC KEY ----"));
            outputStream.write(f1295o);
        } catch (Exception unused) {
        }
    }

    /* renamed from: b */
    public void mo935b(String str, String str2) {
        FileOutputStream fileOutputStream = new FileOutputStream(str);
        mo933b((OutputStream) fileOutputStream, str2);
        fileOutputStream.close();
    }

    /* renamed from: b */
    public void mo934b(String str) {
        mo927a(str, (byte[]) null);
    }

    /* renamed from: a */
    public void mo927a(String str, byte[] bArr) {
        FileOutputStream fileOutputStream = new FileOutputStream(str);
        mo924a((OutputStream) fileOutputStream, bArr);
        fileOutputStream.close();
    }

    /* renamed from: k */
    public String mo951k() {
        if (this.f1306q == null) {
            this.f1306q = m1403o();
        }
        byte[] j = mo950j();
        if (j == null) {
            return null;
        }
        return aji.m1800a(this.f1306q, j);
    }

    /* renamed from: a */
    private byte[] m1400a(byte[] bArr, byte[][] bArr2, byte[] bArr3) {
        if (bArr3 == null) {
            return bArr;
        }
        if (this.f1305p == null) {
            this.f1305p = m1404p();
        }
        int a = this.f1305p.mo803a();
        byte[] bArr4 = new byte[a];
        bArr2[0] = bArr4;
        if (this.f1307r == null) {
            this.f1307r = m1402n();
        }
        this.f1307r.mo1012a(bArr4, 0, a);
        byte[] a2 = mo930a(bArr3, bArr4);
        int a3 = this.f1305p.mo803a();
        int length = ((bArr.length / a3) + 1) * a3;
        byte[] bArr5 = new byte[length];
        System.arraycopy(bArr, 0, bArr5, 0, bArr.length);
        int length2 = a3 - (bArr.length % a3);
        for (int i = length - 1; length - length2 <= i; i--) {
            bArr5[i] = (byte) length2;
        }
        try {
            this.f1305p.mo804a(0, a2, bArr4);
            this.f1305p.mo805a(bArr5, 0, length, bArr5, 0);
        } catch (Exception unused) {
        }
        aji.m1822d(a2);
        return bArr5;
    }

    /* renamed from: a */
    private byte[] m1399a(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        try {
            byte[] a = mo930a(bArr2, bArr3);
            this.f1305p.mo804a(1, a, bArr3);
            aji.m1822d(a);
            byte[] bArr4 = new byte[bArr.length];
            this.f1305p.mo805a(bArr, 0, bArr.length, bArr4, 0);
            return bArr4;
        } catch (Exception unused) {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo918a(byte[] bArr, int i, int i2) {
        bArr[i] = 48;
        return mo932b(bArr, i + 1, i2);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo919a(byte[] bArr, int i, byte[] bArr2) {
        bArr[i] = 2;
        int b = mo932b(bArr, i + 1, bArr2.length);
        System.arraycopy(bArr2, 0, bArr, b, bArr2.length);
        return b + bArr2.length;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo932b(byte[] bArr, int i, int i2) {
        int b = mo931b(i2) - 1;
        if (b == 0) {
            int i3 = i + 1;
            bArr[i] = (byte) i2;
            return i3;
        }
        int i4 = i + 1;
        bArr[i] = (byte) (b | 128);
        int i5 = i4 + b;
        while (b > 0) {
            bArr[(i4 + b) - 1] = (byte) (i2 & 255);
            i2 >>>= 8;
            b--;
        }
        return i5;
    }

    /* renamed from: n */
    private aie m1402n() {
        if (this.f1307r == null) {
            try {
                this.f1307r = (aie) Class.forName(ahg.m1350e("random")).newInstance();
            } catch (Exception e) {
                PrintStream printStream = System.err;
                printStream.println("connect: random " + e);
            }
        }
        return this.f1307r;
    }

    /* renamed from: o */
    private agz m1403o() {
        try {
            agz agz = (agz) Class.forName(ahg.m1350e("md5")).newInstance();
            this.f1306q = agz;
            agz.mo834a();
        } catch (Exception unused) {
        }
        return this.f1306q;
    }

    /* renamed from: p */
    private agm m1404p() {
        try {
            this.f1305p = (agm) Class.forName(ahg.m1350e("3des-cbc")).newInstance();
        } catch (Exception unused) {
        }
        return this.f1305p;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized byte[] mo930a(byte[] bArr, byte[] bArr2) {
        byte[] bArr3;
        if (this.f1305p == null) {
            this.f1305p = m1404p();
        }
        if (this.f1306q == null) {
            this.f1306q = m1403o();
        }
        int b = this.f1305p.mo806b();
        bArr3 = new byte[b];
        int b2 = this.f1306q.mo836b();
        int i = ((b / b2) * b2) + (b % b2 == 0 ? 0 : b2);
        byte[] bArr4 = new byte[i];
        byte[] bArr5 = null;
        try {
            int i2 = this.f1300i;
            if (i2 == 0) {
                int i3 = 0;
                while (i3 + b2 <= i) {
                    if (bArr5 != null) {
                        this.f1306q.mo835a(bArr5, 0, bArr5.length);
                    }
                    this.f1306q.mo835a(bArr, 0, bArr.length);
                    agz agz = this.f1306q;
                    int i4 = 8;
                    if (bArr2.length <= 8) {
                        i4 = bArr2.length;
                    }
                    agz.mo835a(bArr2, 0, i4);
                    bArr5 = this.f1306q.mo837c();
                    System.arraycopy(bArr5, 0, bArr4, i3, bArr5.length);
                    i3 += bArr5.length;
                }
                System.arraycopy(bArr4, 0, bArr3, 0, b);
            } else if (i2 == 1) {
                int i5 = 0;
                while (i5 + b2 <= i) {
                    if (bArr5 != null) {
                        this.f1306q.mo835a(bArr5, 0, bArr5.length);
                    }
                    this.f1306q.mo835a(bArr, 0, bArr.length);
                    bArr5 = this.f1306q.mo837c();
                    System.arraycopy(bArr5, 0, bArr4, i5, bArr5.length);
                    i5 += bArr5.length;
                }
                System.arraycopy(bArr4, 0, bArr3, 0, b);
            } else if (i2 == 2) {
                agz agz2 = (agz) Class.forName(ahg.m1350e("sha-1")).newInstance();
                byte[] bArr6 = new byte[4];
                bArr3 = new byte[40];
                for (int i6 = 0; i6 < 2; i6++) {
                    agz2.mo834a();
                    bArr6[3] = (byte) i6;
                    agz2.mo835a(bArr6, 0, 4);
                    agz2.mo835a(bArr, 0, bArr.length);
                    System.arraycopy(agz2.mo837c(), 0, bArr3, i6 * 20, 20);
                }
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        return bArr3;
    }

    /* renamed from: c */
    public void mo939c(String str) {
        if (str == null || str.length() == 0) {
            mo940c((byte[]) null);
        } else {
            mo940c(aji.m1820c(str));
        }
    }

    /* renamed from: c */
    public void mo940c(byte[] bArr) {
        if (bArr != null && bArr.length == 0) {
            bArr = null;
        }
        this.f1308s = bArr;
    }

    /* renamed from: l */
    public boolean mo952l() {
        return this.f1303m;
    }

    /* renamed from: d */
    public boolean mo942d(String str) {
        if (str == null || str.length() == 0) {
            return !this.f1303m;
        }
        return mo943d(aji.m1820c(str));
    }

    /* renamed from: d */
    public boolean mo943d(byte[] bArr) {
        boolean z = this.f1303m;
        if (!z) {
            return true;
        }
        if (bArr == null) {
            return !z;
        }
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        byte[] a = m1399a(this.f1304n, bArr2, this.f1309u);
        aji.m1822d(bArr2);
        if (mo936b(a)) {
            this.f1303m = false;
        }
        return !this.f1303m;
    }

    /* renamed from: a */
    public static ahm m1393a(ahg ahg, String str) {
        String str2 = str + ".pub";
        if (!new File(str2).exists()) {
            str2 = null;
        }
        return m1394a(ahg, str, str2);
    }

    /* renamed from: a */
    public static ahm m1394a(ahg ahg, String str, String str2) {
        String str3;
        byte[] bArr;
        try {
            byte[] e = aji.m1823e(str);
            if (str2 == null) {
                str3 = str + ".pub";
            } else {
                str3 = str2;
            }
            try {
                bArr = aji.m1823e(str3);
            } catch (IOException e2) {
                if (str2 == null) {
                    bArr = null;
                } else {
                    throw new ahj(e2.toString(), e2);
                }
            }
            try {
                return m1396a(ahg, e, bArr);
            } finally {
                aji.m1822d(e);
            }
        } catch (IOException e3) {
            throw new ahj(e3.toString(), e3);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:125:0x01ad, code lost:
        throw new atakplugin.UASTool.ahj("invalid privatekey: " + r1);
     */
    /* JADX WARNING: Removed duplicated region for block: B:323:0x0506 A[SYNTHETIC, Splitter:B:323:0x0506] */
    /* JADX WARNING: Removed duplicated region for block: B:452:0x063f  */
    /* JADX WARNING: Removed duplicated region for block: B:456:0x0645  */
    /* JADX WARNING: Removed duplicated region for block: B:457:0x064b  */
    /* JADX WARNING: Removed duplicated region for block: B:465:0x0660  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static atakplugin.UASTool.ahm m1396a(atakplugin.UASTool.ahg r19, byte[] r20, byte[] r21) {
        /*
            r0 = r19
            r1 = r20
            r2 = r21
            r3 = 8
            byte[] r4 = new byte[r3]
            r5 = 7
            r6 = 4
            r7 = 2
            r8 = 3
            r9 = 0
            r10 = 1
            if (r2 != 0) goto L_0x0074
            if (r1 == 0) goto L_0x0074
            int r11 = r1.length
            r12 = 11
            if (r11 <= r12) goto L_0x0074
            byte r11 = r1[r9]
            if (r11 != 0) goto L_0x0074
            byte r11 = r1[r10]
            if (r11 != 0) goto L_0x0074
            byte r11 = r1[r7]
            if (r11 != 0) goto L_0x0074
            byte r11 = r1[r8]
            if (r11 != r5) goto L_0x0074
            atakplugin.UASTool.afx r2 = new atakplugin.UASTool.afx
            r2.<init>((byte[]) r1)
            int r3 = r1.length
            r2.mo626b((int) r3)
            java.lang.String r3 = new java.lang.String
            byte[] r4 = r2.mo643j()
            r3.<init>(r4)
            r2.mo646m()
            java.lang.String r4 = "ssh-rsa"
            boolean r4 = r3.equals(r4)
            if (r4 == 0) goto L_0x004b
            atakplugin.UASTool.ahm r0 = atakplugin.UASTool.ahr.m1491a(r0, r2)
            goto L_0x0057
        L_0x004b:
            java.lang.String r4 = "ssh-dss"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0058
            atakplugin.UASTool.ahm r0 = atakplugin.UASTool.ahn.m1448a(r0, r2)
        L_0x0057:
            return r0
        L_0x0058:
            atakplugin.UASTool.ahj r0 = new atakplugin.UASTool.ahj
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "privatekey: invalid key "
            r2.append(r3)
            java.lang.String r3 = new java.lang.String
            r3.<init>(r1, r6, r5)
            r2.append(r3)
            java.lang.String r1 = r2.toString()
            r0.<init>(r1)
            throw r0
        L_0x0074:
            if (r1 == 0) goto L_0x0080
            atakplugin.UASTool.ahm r11 = m1395a((atakplugin.UASTool.ahg) r19, (byte[]) r20)     // Catch:{ Exception -> 0x007d }
            if (r11 == 0) goto L_0x0080
            return r11
        L_0x007d:
            r0 = move-exception
            goto L_0x04e1
        L_0x0080:
            if (r1 == 0) goto L_0x0084
            int r11 = r1.length     // Catch:{ Exception -> 0x007d }
            goto L_0x0085
        L_0x0084:
            r11 = 0
        L_0x0085:
            r12 = 0
        L_0x0086:
            r13 = 45
            if (r12 >= r11) goto L_0x00ac
            byte r14 = r1[r12]     // Catch:{ Exception -> 0x007d }
            if (r14 != r13) goto L_0x00a9
            int r14 = r12 + 4
            if (r14 >= r11) goto L_0x00a9
            int r15 = r12 + 1
            byte r15 = r1[r15]     // Catch:{ Exception -> 0x007d }
            if (r15 != r13) goto L_0x00a9
            int r15 = r12 + 2
            byte r15 = r1[r15]     // Catch:{ Exception -> 0x007d }
            if (r15 != r13) goto L_0x00a9
            int r15 = r12 + 3
            byte r15 = r1[r15]     // Catch:{ Exception -> 0x007d }
            if (r15 != r13) goto L_0x00a9
            byte r14 = r1[r14]     // Catch:{ Exception -> 0x007d }
            if (r14 != r13) goto L_0x00a9
            goto L_0x00ac
        L_0x00a9:
            int r12 = r12 + 1
            goto L_0x0086
        L_0x00ac:
            r14 = 0
            r15 = 0
            r16 = 1
            r17 = 0
        L_0x00b2:
            java.lang.String r3 = "invalid privatekey: "
            if (r12 >= r11) goto L_0x03d9
            byte r10 = r1[r12]     // Catch:{ Exception -> 0x007d }
            r9 = 66
            r7 = 67
            r5 = 65
            r6 = 83
            r13 = 69
            if (r10 != r9) goto L_0x01c3
            int r10 = r12 + 3
            if (r10 >= r11) goto L_0x01c3
            int r18 = r12 + 1
            byte r9 = r1[r18]     // Catch:{ Exception -> 0x007d }
            if (r9 != r13) goto L_0x01c3
            int r9 = r12 + 2
            byte r9 = r1[r9]     // Catch:{ Exception -> 0x007d }
            r8 = 71
            if (r9 != r8) goto L_0x01c3
            byte r8 = r1[r10]     // Catch:{ Exception -> 0x007d }
            r9 = 73
            if (r8 != r9) goto L_0x01c3
            int r12 = r12 + 6
            int r8 = r12 + 2
            if (r8 >= r11) goto L_0x01ae
            byte r9 = r1[r12]     // Catch:{ Exception -> 0x007d }
            r10 = 68
            if (r9 != r10) goto L_0x00f6
            int r9 = r12 + 1
            byte r9 = r1[r9]     // Catch:{ Exception -> 0x007d }
            if (r9 != r6) goto L_0x00f6
            byte r9 = r1[r8]     // Catch:{ Exception -> 0x007d }
            if (r9 != r5) goto L_0x00f6
            r3 = 3
            r15 = 1
            goto L_0x0196
        L_0x00f6:
            byte r9 = r1[r12]     // Catch:{ Exception -> 0x007d }
            r10 = 82
            if (r9 != r10) goto L_0x010a
            int r9 = r12 + 1
            byte r9 = r1[r9]     // Catch:{ Exception -> 0x007d }
            if (r9 != r6) goto L_0x010a
            byte r9 = r1[r8]     // Catch:{ Exception -> 0x007d }
            if (r9 != r5) goto L_0x010a
            r3 = 3
            r15 = 2
            goto L_0x0196
        L_0x010a:
            byte r9 = r1[r12]     // Catch:{ Exception -> 0x007d }
            if (r9 != r6) goto L_0x011f
            int r9 = r12 + 1
            byte r9 = r1[r9]     // Catch:{ Exception -> 0x007d }
            if (r9 != r6) goto L_0x011f
            byte r6 = r1[r8]     // Catch:{ Exception -> 0x007d }
            r9 = 72
            if (r6 != r9) goto L_0x011f
            r3 = 3
            r14 = 1
        L_0x011c:
            r15 = 3
            goto L_0x0196
        L_0x011f:
            int r6 = r12 + 6
            if (r6 >= r11) goto L_0x0156
            byte r9 = r1[r12]     // Catch:{ Exception -> 0x007d }
            r14 = 80
            if (r9 != r14) goto L_0x0156
            int r9 = r12 + 1
            byte r9 = r1[r9]     // Catch:{ Exception -> 0x007d }
            if (r9 != r10) goto L_0x0156
            byte r9 = r1[r8]     // Catch:{ Exception -> 0x007d }
            r14 = 73
            if (r9 != r14) goto L_0x0156
            int r9 = r12 + 3
            byte r14 = r1[r9]     // Catch:{ Exception -> 0x007d }
            r15 = 86
            if (r14 != r15) goto L_0x0156
            int r14 = r12 + 4
            byte r14 = r1[r14]     // Catch:{ Exception -> 0x007d }
            if (r14 != r5) goto L_0x0156
            int r5 = r12 + 5
            byte r5 = r1[r5]     // Catch:{ Exception -> 0x007d }
            r14 = 84
            if (r5 != r14) goto L_0x0156
            byte r5 = r1[r6]     // Catch:{ Exception -> 0x007d }
            if (r5 != r13) goto L_0x0156
            r12 = r9
            r3 = 3
            r14 = 3
            r15 = 3
            r16 = 0
            goto L_0x0196
        L_0x0156:
            int r5 = r12 + 8
            if (r5 >= r11) goto L_0x0199
            byte r9 = r1[r12]     // Catch:{ Exception -> 0x007d }
            if (r9 != r13) goto L_0x0199
            int r9 = r12 + 1
            byte r9 = r1[r9]     // Catch:{ Exception -> 0x007d }
            r14 = 78
            if (r9 != r14) goto L_0x0199
            byte r8 = r1[r8]     // Catch:{ Exception -> 0x007d }
            if (r8 != r7) goto L_0x0199
            int r7 = r12 + 3
            byte r7 = r1[r7]     // Catch:{ Exception -> 0x007d }
            if (r7 != r10) goto L_0x0199
            int r7 = r12 + 4
            byte r7 = r1[r7]     // Catch:{ Exception -> 0x007d }
            r8 = 89
            if (r7 != r8) goto L_0x0199
            int r7 = r12 + 5
            byte r8 = r1[r7]     // Catch:{ Exception -> 0x007d }
            r9 = 80
            if (r8 != r9) goto L_0x0199
            byte r6 = r1[r6]     // Catch:{ Exception -> 0x007d }
            r8 = 84
            if (r6 != r8) goto L_0x0199
            int r12 = r12 + 7
            byte r6 = r1[r12]     // Catch:{ Exception -> 0x007d }
            if (r6 != r13) goto L_0x0199
            byte r5 = r1[r5]     // Catch:{ Exception -> 0x007d }
            r6 = 68
            if (r5 != r6) goto L_0x0199
            r12 = r7
            r3 = 3
            r14 = 3
            goto L_0x011c
        L_0x0196:
            int r12 = r12 + r3
            goto L_0x03ce
        L_0x0199:
            atakplugin.UASTool.ahj r0 = new atakplugin.UASTool.ahj     // Catch:{ Exception -> 0x007d }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x007d }
            r2.<init>()     // Catch:{ Exception -> 0x007d }
            r2.append(r3)     // Catch:{ Exception -> 0x007d }
            r2.append(r1)     // Catch:{ Exception -> 0x007d }
            java.lang.String r1 = r2.toString()     // Catch:{ Exception -> 0x007d }
            r0.<init>(r1)     // Catch:{ Exception -> 0x007d }
            throw r0     // Catch:{ Exception -> 0x007d }
        L_0x01ae:
            atakplugin.UASTool.ahj r0 = new atakplugin.UASTool.ahj     // Catch:{ Exception -> 0x007d }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x007d }
            r2.<init>()     // Catch:{ Exception -> 0x007d }
            r2.append(r3)     // Catch:{ Exception -> 0x007d }
            r2.append(r1)     // Catch:{ Exception -> 0x007d }
            java.lang.String r1 = r2.toString()     // Catch:{ Exception -> 0x007d }
            r0.<init>(r1)     // Catch:{ Exception -> 0x007d }
            throw r0     // Catch:{ Exception -> 0x007d }
        L_0x01c3:
            byte r8 = r1[r12]     // Catch:{ Exception -> 0x007d }
            r9 = 50
            if (r8 != r5) goto L_0x023e
            int r8 = r12 + 7
            if (r8 >= r11) goto L_0x023e
            int r10 = r12 + 1
            byte r10 = r1[r10]     // Catch:{ Exception -> 0x007d }
            if (r10 != r13) goto L_0x023e
            int r10 = r12 + 2
            byte r10 = r1[r10]     // Catch:{ Exception -> 0x007d }
            if (r10 != r6) goto L_0x023e
            int r10 = r12 + 3
            byte r10 = r1[r10]     // Catch:{ Exception -> 0x007d }
            r7 = 45
            if (r10 != r7) goto L_0x023e
            int r7 = r12 + 4
            byte r7 = r1[r7]     // Catch:{ Exception -> 0x007d }
            if (r7 != r9) goto L_0x023e
            int r7 = r12 + 5
            byte r7 = r1[r7]     // Catch:{ Exception -> 0x007d }
            r10 = 53
            if (r7 != r10) goto L_0x023e
            int r7 = r12 + 6
            byte r7 = r1[r7]     // Catch:{ Exception -> 0x007d }
            r10 = 54
            if (r7 != r10) goto L_0x023e
            byte r7 = r1[r8]     // Catch:{ Exception -> 0x007d }
            r8 = 45
            if (r7 != r8) goto L_0x023e
            int r12 = r12 + 8
            java.lang.String r3 = "aes256-cbc"
            java.lang.String r3 = atakplugin.UASTool.ahg.m1350e(r3)     // Catch:{ Exception -> 0x007d }
            boolean r3 = atakplugin.UASTool.air.m1640l(r3)     // Catch:{ Exception -> 0x007d }
            if (r3 == 0) goto L_0x0227
            java.lang.String r3 = "aes256-cbc"
            java.lang.String r3 = atakplugin.UASTool.ahg.m1350e(r3)     // Catch:{ Exception -> 0x007d }
            java.lang.Class r3 = java.lang.Class.forName(r3)     // Catch:{ Exception -> 0x007d }
            java.lang.Object r3 = r3.newInstance()     // Catch:{ Exception -> 0x007d }
            atakplugin.UASTool.agm r3 = (atakplugin.UASTool.agm) r3     // Catch:{ Exception -> 0x007d }
            r17 = r3
            atakplugin.UASTool.agm r17 = (atakplugin.UASTool.agm) r17     // Catch:{ Exception -> 0x007d }
            int r3 = r17.mo803a()     // Catch:{ Exception -> 0x007d }
            byte[] r4 = new byte[r3]     // Catch:{ Exception -> 0x007d }
            goto L_0x03ce
        L_0x0227:
            atakplugin.UASTool.ahj r0 = new atakplugin.UASTool.ahj     // Catch:{ Exception -> 0x007d }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x007d }
            r2.<init>()     // Catch:{ Exception -> 0x007d }
            java.lang.String r3 = "privatekey: aes256-cbc is not available "
            r2.append(r3)     // Catch:{ Exception -> 0x007d }
            r2.append(r1)     // Catch:{ Exception -> 0x007d }
            java.lang.String r1 = r2.toString()     // Catch:{ Exception -> 0x007d }
            r0.<init>(r1)     // Catch:{ Exception -> 0x007d }
            throw r0     // Catch:{ Exception -> 0x007d }
        L_0x023e:
            byte r7 = r1[r12]     // Catch:{ Exception -> 0x007d }
            if (r7 != r5) goto L_0x02b7
            int r7 = r12 + 7
            if (r7 >= r11) goto L_0x02b7
            int r8 = r12 + 1
            byte r8 = r1[r8]     // Catch:{ Exception -> 0x007d }
            if (r8 != r13) goto L_0x02b7
            int r8 = r12 + 2
            byte r8 = r1[r8]     // Catch:{ Exception -> 0x007d }
            if (r8 != r6) goto L_0x02b7
            int r8 = r12 + 3
            byte r8 = r1[r8]     // Catch:{ Exception -> 0x007d }
            r10 = 45
            if (r8 != r10) goto L_0x02b7
            int r8 = r12 + 4
            byte r8 = r1[r8]     // Catch:{ Exception -> 0x007d }
            r10 = 49
            if (r8 != r10) goto L_0x02b7
            int r8 = r12 + 5
            byte r8 = r1[r8]     // Catch:{ Exception -> 0x007d }
            r10 = 57
            if (r8 != r10) goto L_0x02b7
            int r8 = r12 + 6
            byte r8 = r1[r8]     // Catch:{ Exception -> 0x007d }
            if (r8 != r9) goto L_0x02b7
            byte r7 = r1[r7]     // Catch:{ Exception -> 0x007d }
            r8 = 45
            if (r7 != r8) goto L_0x02b7
            int r12 = r12 + 8
            java.lang.String r3 = "aes192-cbc"
            java.lang.String r3 = atakplugin.UASTool.ahg.m1350e(r3)     // Catch:{ Exception -> 0x007d }
            boolean r3 = atakplugin.UASTool.air.m1640l(r3)     // Catch:{ Exception -> 0x007d }
            if (r3 == 0) goto L_0x02a0
            java.lang.String r3 = "aes192-cbc"
            java.lang.String r3 = atakplugin.UASTool.ahg.m1350e(r3)     // Catch:{ Exception -> 0x007d }
            java.lang.Class r3 = java.lang.Class.forName(r3)     // Catch:{ Exception -> 0x007d }
            java.lang.Object r3 = r3.newInstance()     // Catch:{ Exception -> 0x007d }
            atakplugin.UASTool.agm r3 = (atakplugin.UASTool.agm) r3     // Catch:{ Exception -> 0x007d }
            r17 = r3
            atakplugin.UASTool.agm r17 = (atakplugin.UASTool.agm) r17     // Catch:{ Exception -> 0x007d }
            int r3 = r17.mo803a()     // Catch:{ Exception -> 0x007d }
            byte[] r4 = new byte[r3]     // Catch:{ Exception -> 0x007d }
            goto L_0x03ce
        L_0x02a0:
            atakplugin.UASTool.ahj r0 = new atakplugin.UASTool.ahj     // Catch:{ Exception -> 0x007d }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x007d }
            r2.<init>()     // Catch:{ Exception -> 0x007d }
            java.lang.String r3 = "privatekey: aes192-cbc is not available "
            r2.append(r3)     // Catch:{ Exception -> 0x007d }
            r2.append(r1)     // Catch:{ Exception -> 0x007d }
            java.lang.String r1 = r2.toString()     // Catch:{ Exception -> 0x007d }
            r0.<init>(r1)     // Catch:{ Exception -> 0x007d }
            throw r0     // Catch:{ Exception -> 0x007d }
        L_0x02b7:
            byte r7 = r1[r12]     // Catch:{ Exception -> 0x007d }
            if (r7 != r5) goto L_0x0330
            int r5 = r12 + 7
            if (r5 >= r11) goto L_0x0330
            int r7 = r12 + 1
            byte r7 = r1[r7]     // Catch:{ Exception -> 0x007d }
            if (r7 != r13) goto L_0x0330
            int r7 = r12 + 2
            byte r7 = r1[r7]     // Catch:{ Exception -> 0x007d }
            if (r7 != r6) goto L_0x0330
            int r6 = r12 + 3
            byte r6 = r1[r6]     // Catch:{ Exception -> 0x007d }
            r7 = 45
            if (r6 != r7) goto L_0x0330
            int r6 = r12 + 4
            byte r6 = r1[r6]     // Catch:{ Exception -> 0x007d }
            r7 = 49
            if (r6 != r7) goto L_0x0330
            int r6 = r12 + 5
            byte r6 = r1[r6]     // Catch:{ Exception -> 0x007d }
            if (r6 != r9) goto L_0x0330
            int r6 = r12 + 6
            byte r6 = r1[r6]     // Catch:{ Exception -> 0x007d }
            r7 = 56
            if (r6 != r7) goto L_0x0330
            byte r5 = r1[r5]     // Catch:{ Exception -> 0x007d }
            r6 = 45
            if (r5 != r6) goto L_0x0330
            int r12 = r12 + 8
            java.lang.String r3 = "aes128-cbc"
            java.lang.String r3 = atakplugin.UASTool.ahg.m1350e(r3)     // Catch:{ Exception -> 0x007d }
            boolean r3 = atakplugin.UASTool.air.m1640l(r3)     // Catch:{ Exception -> 0x007d }
            if (r3 == 0) goto L_0x0319
            java.lang.String r3 = "aes128-cbc"
            java.lang.String r3 = atakplugin.UASTool.ahg.m1350e(r3)     // Catch:{ Exception -> 0x007d }
            java.lang.Class r3 = java.lang.Class.forName(r3)     // Catch:{ Exception -> 0x007d }
            java.lang.Object r3 = r3.newInstance()     // Catch:{ Exception -> 0x007d }
            atakplugin.UASTool.agm r3 = (atakplugin.UASTool.agm) r3     // Catch:{ Exception -> 0x007d }
            r17 = r3
            atakplugin.UASTool.agm r17 = (atakplugin.UASTool.agm) r17     // Catch:{ Exception -> 0x007d }
            int r3 = r17.mo803a()     // Catch:{ Exception -> 0x007d }
            byte[] r4 = new byte[r3]     // Catch:{ Exception -> 0x007d }
            goto L_0x03ce
        L_0x0319:
            atakplugin.UASTool.ahj r0 = new atakplugin.UASTool.ahj     // Catch:{ Exception -> 0x007d }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x007d }
            r2.<init>()     // Catch:{ Exception -> 0x007d }
            java.lang.String r3 = "privatekey: aes128-cbc is not available "
            r2.append(r3)     // Catch:{ Exception -> 0x007d }
            r2.append(r1)     // Catch:{ Exception -> 0x007d }
            java.lang.String r1 = r2.toString()     // Catch:{ Exception -> 0x007d }
            r0.<init>(r1)     // Catch:{ Exception -> 0x007d }
            throw r0     // Catch:{ Exception -> 0x007d }
        L_0x0330:
            byte r5 = r1[r12]     // Catch:{ Exception -> 0x007d }
            r6 = 67
            if (r5 != r6) goto L_0x0373
            int r5 = r12 + 3
            if (r5 >= r11) goto L_0x0373
            int r6 = r12 + 1
            byte r6 = r1[r6]     // Catch:{ Exception -> 0x007d }
            r7 = 66
            if (r6 != r7) goto L_0x0373
            int r6 = r12 + 2
            byte r6 = r1[r6]     // Catch:{ Exception -> 0x007d }
            r7 = 67
            if (r6 != r7) goto L_0x0373
            byte r5 = r1[r5]     // Catch:{ Exception -> 0x007d }
            r6 = 44
            if (r5 != r6) goto L_0x0373
            int r12 = r12 + 4
            r3 = 0
        L_0x0353:
            int r5 = r4.length     // Catch:{ Exception -> 0x007d }
            if (r3 >= r5) goto L_0x03ce
            int r5 = r12 + 1
            byte r6 = r1[r12]     // Catch:{ Exception -> 0x007d }
            byte r6 = m1390a((byte) r6)     // Catch:{ Exception -> 0x007d }
            r7 = 4
            int r6 = r6 << r7
            r6 = r6 & 240(0xf0, float:3.36E-43)
            int r12 = r5 + 1
            byte r5 = r1[r5]     // Catch:{ Exception -> 0x007d }
            byte r5 = m1390a((byte) r5)     // Catch:{ Exception -> 0x007d }
            r5 = r5 & 15
            int r6 = r6 + r5
            byte r5 = (byte) r6     // Catch:{ Exception -> 0x007d }
            r4[r3] = r5     // Catch:{ Exception -> 0x007d }
            int r3 = r3 + 1
            goto L_0x0353
        L_0x0373:
            byte r5 = r1[r12]     // Catch:{ Exception -> 0x007d }
            r6 = 13
            if (r5 != r6) goto L_0x0386
            int r5 = r12 + 1
            int r6 = r1.length     // Catch:{ Exception -> 0x007d }
            if (r5 >= r6) goto L_0x0386
            byte r6 = r1[r5]     // Catch:{ Exception -> 0x007d }
            r7 = 10
            if (r6 != r7) goto L_0x0388
            r12 = r5
            goto L_0x03ce
        L_0x0386:
            r7 = 10
        L_0x0388:
            byte r5 = r1[r12]     // Catch:{ Exception -> 0x007d }
            if (r5 != r7) goto L_0x03cc
            int r5 = r12 + 1
            int r6 = r1.length     // Catch:{ Exception -> 0x007d }
            if (r5 >= r6) goto L_0x03cc
            byte r6 = r1[r5]     // Catch:{ Exception -> 0x007d }
            if (r6 != r7) goto L_0x0398
            int r12 = r12 + 2
            goto L_0x03d9
        L_0x0398:
            byte r6 = r1[r5]     // Catch:{ Exception -> 0x007d }
            r7 = 13
            if (r6 != r7) goto L_0x03ac
            int r6 = r12 + 2
            int r7 = r1.length     // Catch:{ Exception -> 0x007d }
            if (r6 >= r7) goto L_0x03ac
            byte r6 = r1[r6]     // Catch:{ Exception -> 0x007d }
            r7 = 10
            if (r6 != r7) goto L_0x03ac
            int r12 = r12 + 3
            goto L_0x03d9
        L_0x03ac:
            r6 = r5
        L_0x03ad:
            int r7 = r1.length     // Catch:{ Exception -> 0x007d }
            if (r6 >= r7) goto L_0x03c2
            byte r7 = r1[r6]     // Catch:{ Exception -> 0x007d }
            r8 = 10
            if (r7 != r8) goto L_0x03b7
            goto L_0x03c2
        L_0x03b7:
            byte r7 = r1[r6]     // Catch:{ Exception -> 0x007d }
            r8 = 58
            if (r7 != r8) goto L_0x03bf
            r6 = 1
            goto L_0x03c3
        L_0x03bf:
            int r6 = r6 + 1
            goto L_0x03ad
        L_0x03c2:
            r6 = 0
        L_0x03c3:
            if (r6 != 0) goto L_0x03cc
            r6 = 3
            r12 = r5
            if (r14 == r6) goto L_0x03d9
            r16 = 0
            goto L_0x03d9
        L_0x03cc:
            int r12 = r12 + 1
        L_0x03ce:
            r3 = 8
            r6 = 4
            r7 = 2
            r8 = 3
            r9 = 0
            r10 = 1
            r13 = 45
            goto L_0x00b2
        L_0x03d9:
            if (r1 == 0) goto L_0x0461
            if (r15 == 0) goto L_0x044c
            r5 = r12
        L_0x03de:
            if (r5 >= r11) goto L_0x03ea
            byte r6 = r1[r5]     // Catch:{ Exception -> 0x007d }
            r7 = 45
            if (r6 != r7) goto L_0x03e7
            goto L_0x03ea
        L_0x03e7:
            int r5 = r5 + 1
            goto L_0x03de
        L_0x03ea:
            int r11 = r11 - r5
            if (r11 == 0) goto L_0x0437
            int r5 = r5 - r12
            if (r5 == 0) goto L_0x0437
            byte[] r6 = new byte[r5]     // Catch:{ Exception -> 0x007d }
            r7 = 0
            java.lang.System.arraycopy(r1, r12, r6, r7, r5)     // Catch:{ Exception -> 0x007d }
            r7 = 0
        L_0x03f7:
            if (r7 >= r5) goto L_0x0429
            byte r8 = r6[r7]     // Catch:{ Exception -> 0x007d }
            r9 = 10
            if (r8 != r9) goto L_0x041f
            int r8 = r7 + -1
            byte r8 = r6[r8]     // Catch:{ Exception -> 0x007d }
            r9 = 13
            if (r8 != r9) goto L_0x0409
            r8 = 1
            goto L_0x040a
        L_0x0409:
            r8 = 0
        L_0x040a:
            int r9 = r7 + 1
            if (r8 == 0) goto L_0x0410
            r10 = 1
            goto L_0x0411
        L_0x0410:
            r10 = 0
        L_0x0411:
            int r10 = r7 - r10
            int r11 = r5 - r9
            java.lang.System.arraycopy(r6, r9, r6, r10, r11)     // Catch:{ Exception -> 0x007d }
            if (r8 == 0) goto L_0x041c
            int r5 = r5 + -1
        L_0x041c:
            int r5 = r5 + -1
            goto L_0x03f7
        L_0x041f:
            byte r8 = r6[r7]     // Catch:{ Exception -> 0x007d }
            r9 = 45
            if (r8 != r9) goto L_0x0426
            goto L_0x0429
        L_0x0426:
            int r7 = r7 + 1
            goto L_0x03f7
        L_0x0429:
            r5 = 0
            int r7 = r7 - r5
            if (r7 <= 0) goto L_0x0432
            byte[] r7 = atakplugin.UASTool.aji.m1809a((byte[]) r6, (int) r5, (int) r7)     // Catch:{ Exception -> 0x007d }
            goto L_0x0433
        L_0x0432:
            r7 = 0
        L_0x0433:
            atakplugin.UASTool.aji.m1822d((byte[]) r6)     // Catch:{ Exception -> 0x007d }
            goto L_0x0462
        L_0x0437:
            atakplugin.UASTool.ahj r0 = new atakplugin.UASTool.ahj     // Catch:{ Exception -> 0x007d }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x007d }
            r2.<init>()     // Catch:{ Exception -> 0x007d }
            r2.append(r3)     // Catch:{ Exception -> 0x007d }
            r2.append(r1)     // Catch:{ Exception -> 0x007d }
            java.lang.String r1 = r2.toString()     // Catch:{ Exception -> 0x007d }
            r0.<init>(r1)     // Catch:{ Exception -> 0x007d }
            throw r0     // Catch:{ Exception -> 0x007d }
        L_0x044c:
            atakplugin.UASTool.ahj r0 = new atakplugin.UASTool.ahj     // Catch:{ Exception -> 0x007d }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x007d }
            r2.<init>()     // Catch:{ Exception -> 0x007d }
            r2.append(r3)     // Catch:{ Exception -> 0x007d }
            r2.append(r1)     // Catch:{ Exception -> 0x007d }
            java.lang.String r1 = r2.toString()     // Catch:{ Exception -> 0x007d }
            r0.<init>(r1)     // Catch:{ Exception -> 0x007d }
            throw r0     // Catch:{ Exception -> 0x007d }
        L_0x0461:
            r7 = 0
        L_0x0462:
            if (r7 == 0) goto L_0x0500
            int r5 = r7.length     // Catch:{ Exception -> 0x007d }
            r6 = 4
            if (r5 <= r6) goto L_0x0500
            r5 = 0
            byte r6 = r7[r5]     // Catch:{ Exception -> 0x007d }
            r5 = 63
            if (r6 != r5) goto L_0x0500
            r5 = 1
            byte r6 = r7[r5]     // Catch:{ Exception -> 0x007d }
            r5 = 111(0x6f, float:1.56E-43)
            if (r6 != r5) goto L_0x0500
            r5 = 2
            byte r6 = r7[r5]     // Catch:{ Exception -> 0x007d }
            r5 = -7
            if (r6 != r5) goto L_0x0500
            r5 = 3
            byte r6 = r7[r5]     // Catch:{ Exception -> 0x007d }
            r5 = -21
            if (r6 != r5) goto L_0x0500
            atakplugin.UASTool.afx r5 = new atakplugin.UASTool.afx     // Catch:{ Exception -> 0x007d }
            r5.<init>((byte[]) r7)     // Catch:{ Exception -> 0x007d }
            r5.mo633d()     // Catch:{ Exception -> 0x007d }
            r5.mo633d()     // Catch:{ Exception -> 0x007d }
            r5.mo643j()     // Catch:{ Exception -> 0x007d }
            byte[] r6 = r5.mo643j()     // Catch:{ Exception -> 0x007d }
            java.lang.String r6 = atakplugin.UASTool.aji.m1813b((byte[]) r6)     // Catch:{ Exception -> 0x007d }
            java.lang.String r8 = "3des-cbc"
            boolean r8 = r6.equals(r8)     // Catch:{ Exception -> 0x007d }
            if (r8 != 0) goto L_0x04bc
            java.lang.String r8 = "none"
            boolean r6 = r6.equals(r8)     // Catch:{ Exception -> 0x007d }
            if (r6 == 0) goto L_0x0500
            r5.mo633d()     // Catch:{ Exception -> 0x007d }
            r5.mo633d()     // Catch:{ Exception -> 0x007d }
            int r6 = r7.length     // Catch:{ Exception -> 0x007d }
            int r7 = r5.mo625b()     // Catch:{ Exception -> 0x007d }
            int r6 = r6 - r7
            byte[] r7 = new byte[r6]     // Catch:{ Exception -> 0x007d }
            r5.mo635d((byte[]) r7)     // Catch:{ Exception -> 0x007d }
            r5 = 0
            goto L_0x0502
        L_0x04bc:
            r5.mo633d()     // Catch:{ Exception -> 0x007d }
            int r0 = r7.length     // Catch:{ Exception -> 0x007d }
            int r2 = r5.mo625b()     // Catch:{ Exception -> 0x007d }
            int r0 = r0 - r2
            byte[] r0 = new byte[r0]     // Catch:{ Exception -> 0x007d }
            r5.mo635d((byte[]) r0)     // Catch:{ Exception -> 0x007d }
            atakplugin.UASTool.ahj r0 = new atakplugin.UASTool.ahj     // Catch:{ Exception -> 0x007d }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x007d }
            r2.<init>()     // Catch:{ Exception -> 0x007d }
            java.lang.String r3 = "unknown privatekey format: "
            r2.append(r3)     // Catch:{ Exception -> 0x007d }
            r2.append(r1)     // Catch:{ Exception -> 0x007d }
            java.lang.String r1 = r2.toString()     // Catch:{ Exception -> 0x007d }
            r0.<init>(r1)     // Catch:{ Exception -> 0x007d }
            throw r0     // Catch:{ Exception -> 0x007d }
        L_0x04e1:
            boolean r1 = r0 instanceof atakplugin.UASTool.ahj
            if (r1 != 0) goto L_0x04fd
            boolean r1 = r0 instanceof java.lang.Throwable
            if (r1 == 0) goto L_0x04f3
            atakplugin.UASTool.ahj r1 = new atakplugin.UASTool.ahj
            java.lang.String r2 = r0.toString()
            r1.<init>(r2, r0)
            throw r1
        L_0x04f3:
            atakplugin.UASTool.ahj r1 = new atakplugin.UASTool.ahj
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            throw r1
        L_0x04fd:
            atakplugin.UASTool.ahj r0 = (atakplugin.UASTool.ahj) r0
            throw r0
        L_0x0500:
            r5 = r16
        L_0x0502:
            java.lang.String r6 = ""
            if (r2 == 0) goto L_0x063f
            int r8 = r2.length     // Catch:{ Exception -> 0x0638 }
            int r9 = r2.length     // Catch:{ Exception -> 0x0638 }
            r10 = 4
            if (r9 <= r10) goto L_0x05b1
            r9 = 0
            byte r10 = r2[r9]     // Catch:{ Exception -> 0x0638 }
            r9 = 45
            if (r10 != r9) goto L_0x05b1
            r10 = 1
            byte r11 = r2[r10]     // Catch:{ Exception -> 0x0638 }
            if (r11 != r9) goto L_0x05b1
            r11 = 2
            byte r12 = r2[r11]     // Catch:{ Exception -> 0x0638 }
            if (r12 != r9) goto L_0x05b1
            r11 = 3
            byte r12 = r2[r11]     // Catch:{ Exception -> 0x0638 }
            if (r12 != r9) goto L_0x05b1
            r9 = 0
        L_0x0522:
            int r9 = r9 + r10
            int r10 = r2.length     // Catch:{ Exception -> 0x0638 }
            if (r10 <= r9) goto L_0x052f
            byte r10 = r2[r9]     // Catch:{ Exception -> 0x0638 }
            r11 = 10
            if (r10 != r11) goto L_0x052d
            goto L_0x052f
        L_0x052d:
            r10 = 1
            goto L_0x0522
        L_0x052f:
            int r10 = r2.length     // Catch:{ Exception -> 0x0638 }
            if (r10 > r9) goto L_0x0534
            r10 = 0
            goto L_0x0535
        L_0x0534:
            r10 = 1
        L_0x0535:
            if (r10 == 0) goto L_0x0567
            byte r11 = r2[r9]     // Catch:{ Exception -> 0x0638 }
            r12 = 10
            if (r11 != r12) goto L_0x0560
            int r11 = r9 + 1
            r13 = r11
        L_0x0540:
            int r12 = r2.length     // Catch:{ Exception -> 0x0638 }
            if (r13 >= r12) goto L_0x0559
            byte r12 = r2[r13]     // Catch:{ Exception -> 0x0638 }
            r16 = r6
            r6 = 10
            if (r12 != r6) goto L_0x054c
            goto L_0x055b
        L_0x054c:
            byte r6 = r2[r13]     // Catch:{ Exception -> 0x05ae }
            r12 = 58
            if (r6 != r12) goto L_0x0554
            r6 = 1
            goto L_0x055c
        L_0x0554:
            int r13 = r13 + 1
            r6 = r16
            goto L_0x0540
        L_0x0559:
            r16 = r6
        L_0x055b:
            r6 = 0
        L_0x055c:
            if (r6 != 0) goto L_0x0562
            r9 = r11
            goto L_0x0569
        L_0x0560:
            r16 = r6
        L_0x0562:
            int r9 = r9 + 1
            r6 = r16
            goto L_0x0535
        L_0x0567:
            r16 = r6
        L_0x0569:
            int r6 = r2.length     // Catch:{ Exception -> 0x05ae }
            if (r6 > r9) goto L_0x056d
            r10 = 0
        L_0x056d:
            r6 = r9
        L_0x056e:
            if (r10 == 0) goto L_0x058e
            if (r6 >= r8) goto L_0x058e
            byte r11 = r2[r6]     // Catch:{ Exception -> 0x05ae }
            r12 = 10
            if (r11 != r12) goto L_0x0584
            int r11 = r6 + 1
            int r12 = r8 - r6
            r13 = 1
            int r12 = r12 - r13
            java.lang.System.arraycopy(r2, r11, r2, r6, r12)     // Catch:{ Exception -> 0x05ae }
            int r8 = r8 + -1
            goto L_0x056e
        L_0x0584:
            byte r11 = r2[r6]     // Catch:{ Exception -> 0x05ae }
            r12 = 45
            if (r11 != r12) goto L_0x058b
            goto L_0x058e
        L_0x058b:
            int r6 = r6 + 1
            goto L_0x056e
        L_0x058e:
            if (r10 == 0) goto L_0x05ae
            int r6 = r6 - r9
            byte[] r2 = atakplugin.UASTool.aji.m1809a((byte[]) r2, (int) r9, (int) r6)     // Catch:{ Exception -> 0x05ae }
            if (r1 == 0) goto L_0x059a
            r6 = 3
            if (r15 != r6) goto L_0x063c
        L_0x059a:
            r6 = 8
            byte r8 = r2[r6]     // Catch:{ Exception -> 0x063c }
            r9 = 100
            if (r8 != r9) goto L_0x05a5
            r15 = 1
            goto L_0x063c
        L_0x05a5:
            byte r6 = r2[r6]     // Catch:{ Exception -> 0x063c }
            r8 = 114(0x72, float:1.6E-43)
            if (r6 != r8) goto L_0x063c
            r15 = 2
            goto L_0x063c
        L_0x05ae:
            r2 = 0
            goto L_0x063c
        L_0x05b1:
            r16 = r6
            r6 = 0
            byte r9 = r2[r6]     // Catch:{ Exception -> 0x05ae }
            r6 = 115(0x73, float:1.61E-43)
            if (r9 != r6) goto L_0x0635
            r6 = 1
            byte r9 = r2[r6]     // Catch:{ Exception -> 0x05ae }
            r6 = 115(0x73, float:1.61E-43)
            if (r9 != r6) goto L_0x0635
            r6 = 2
            byte r9 = r2[r6]     // Catch:{ Exception -> 0x05ae }
            r6 = 104(0x68, float:1.46E-43)
            if (r9 != r6) goto L_0x0635
            r6 = 3
            byte r9 = r2[r6]     // Catch:{ Exception -> 0x05ae }
            r6 = 45
            if (r9 != r6) goto L_0x0635
            if (r1 != 0) goto L_0x05e5
            int r6 = r2.length     // Catch:{ Exception -> 0x05ae }
            r9 = 7
            if (r6 <= r9) goto L_0x05e5
            r6 = 4
            byte r9 = r2[r6]     // Catch:{ Exception -> 0x05ae }
            r10 = 100
            if (r9 != r10) goto L_0x05de
            r15 = 1
            goto L_0x05e5
        L_0x05de:
            byte r6 = r2[r6]     // Catch:{ Exception -> 0x05ae }
            r9 = 114(0x72, float:1.6E-43)
            if (r6 != r9) goto L_0x05e5
            r15 = 2
        L_0x05e5:
            r6 = 0
        L_0x05e6:
            if (r6 >= r8) goto L_0x05f2
            byte r9 = r2[r6]     // Catch:{ Exception -> 0x05ae }
            r10 = 32
            if (r9 != r10) goto L_0x05ef
            goto L_0x05f2
        L_0x05ef:
            int r6 = r6 + 1
            goto L_0x05e6
        L_0x05f2:
            r9 = 1
            int r6 = r6 + r9
            r9 = r6
            if (r6 >= r8) goto L_0x060a
        L_0x05f7:
            if (r9 >= r8) goto L_0x0603
            byte r10 = r2[r9]     // Catch:{ Exception -> 0x05ae }
            r11 = 32
            if (r10 != r11) goto L_0x0600
            goto L_0x0603
        L_0x0600:
            int r9 = r9 + 1
            goto L_0x05f7
        L_0x0603:
            int r10 = r9 - r6
            byte[] r6 = atakplugin.UASTool.aji.m1809a((byte[]) r2, (int) r6, (int) r10)     // Catch:{ Exception -> 0x05ae }
            goto L_0x060b
        L_0x060a:
            r6 = 0
        L_0x060b:
            int r10 = r9 + 1
            if (r9 >= r8) goto L_0x0633
            r9 = r10
        L_0x0610:
            if (r9 >= r8) goto L_0x061c
            byte r11 = r2[r9]     // Catch:{ Exception -> 0x0633 }
            r12 = 10
            if (r11 != r12) goto L_0x0619
            goto L_0x061c
        L_0x0619:
            int r9 = r9 + 1
            goto L_0x0610
        L_0x061c:
            if (r9 <= 0) goto L_0x0628
            int r8 = r9 + -1
            byte r8 = r2[r8]     // Catch:{ Exception -> 0x0633 }
            r11 = 13
            if (r8 != r11) goto L_0x0628
            int r9 = r9 + -1
        L_0x0628:
            if (r10 >= r9) goto L_0x0633
            java.lang.String r8 = new java.lang.String     // Catch:{ Exception -> 0x0633 }
            int r9 = r9 - r10
            r8.<init>(r2, r10, r9)     // Catch:{ Exception -> 0x0633 }
            r2 = r6
            r6 = r8
            goto L_0x0642
        L_0x0633:
            r2 = r6
            goto L_0x063c
        L_0x0635:
            r6 = r16
            goto L_0x0641
        L_0x0638:
            r16 = r6
            goto L_0x05ae
        L_0x063c:
            r6 = r16
            goto L_0x0642
        L_0x063f:
            r16 = r6
        L_0x0641:
            r2 = 0
        L_0x0642:
            r8 = 1
            if (r15 != r8) goto L_0x064b
            atakplugin.UASTool.ahn r8 = new atakplugin.UASTool.ahn
            r8.<init>(r0)
            goto L_0x065e
        L_0x064b:
            r8 = 2
            if (r15 != r8) goto L_0x0654
            atakplugin.UASTool.ahr r8 = new atakplugin.UASTool.ahr
            r8.<init>(r0)
            goto L_0x065e
        L_0x0654:
            r8 = 3
            if (r14 != r8) goto L_0x065d
            atakplugin.UASTool.ahq r8 = new atakplugin.UASTool.ahq
            r8.<init>(r0)
            goto L_0x065e
        L_0x065d:
            r8 = 0
        L_0x065e:
            if (r8 == 0) goto L_0x0695
            r8.f1303m = r5
            r8.f1310v = r2
            r8.f1300i = r14
            r8.f1301j = r6
            r14 = r17
            r8.f1305p = r14
            if (r5 == 0) goto L_0x0676
            r0 = 1
            r8.f1303m = r0
            r8.f1309u = r4
            r8.f1304n = r7
            goto L_0x0695
        L_0x0676:
            boolean r0 = r8.mo936b((byte[]) r7)
            if (r0 == 0) goto L_0x0680
            r0 = 0
            r8.f1303m = r0
            return r8
        L_0x0680:
            atakplugin.UASTool.ahj r0 = new atakplugin.UASTool.ahj
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r3)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            r0.<init>(r1)
            throw r0
        L_0x0695:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.ahm.m1396a(atakplugin.UASTool.ahg, byte[], byte[]):atakplugin.UASTool.ahm");
    }

    /* renamed from: m */
    public void mo953m() {
        aji.m1822d(this.f1308s);
    }

    public void finalize() {
        mo953m();
    }

    /* JADX WARNING: type inference failed for: r1v9, types: [atakplugin.UASTool.ahr] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static atakplugin.UASTool.ahm m1395a(atakplugin.UASTool.ahg r10, byte[] r11) {
        /*
            atakplugin.UASTool.afx r0 = new atakplugin.UASTool.afx
            r0.<init>((byte[]) r11)
            java.util.Hashtable r11 = new java.util.Hashtable
            r11.<init>()
        L_0x000a:
            boolean r1 = m1397a((atakplugin.UASTool.afx) r0, (java.util.Hashtable) r11)
            if (r1 != 0) goto L_0x000a
            java.lang.String r1 = "PuTTY-User-Key-File-2"
            java.lang.Object r1 = r11.get(r1)
            java.lang.String r1 = (java.lang.String) r1
            r2 = 0
            if (r1 != 0) goto L_0x001c
            return r2
        L_0x001c:
            java.lang.String r3 = "Public-Lines"
            java.lang.Object r3 = r11.get(r3)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = java.lang.Integer.parseInt(r3)
            byte[] r3 = m1398a((atakplugin.UASTool.afx) r0, (int) r3)
        L_0x002c:
            boolean r4 = m1397a((atakplugin.UASTool.afx) r0, (java.util.Hashtable) r11)
            if (r4 != 0) goto L_0x002c
            java.lang.String r4 = "Private-Lines"
            java.lang.Object r4 = r11.get(r4)
            java.lang.String r4 = (java.lang.String) r4
            int r4 = java.lang.Integer.parseInt(r4)
            byte[] r4 = m1398a((atakplugin.UASTool.afx) r0, (int) r4)
        L_0x0042:
            boolean r5 = m1397a((atakplugin.UASTool.afx) r0, (java.util.Hashtable) r11)
            if (r5 != 0) goto L_0x0042
            int r0 = r4.length
            r5 = 0
            byte[] r0 = atakplugin.UASTool.aji.m1809a((byte[]) r4, (int) r5, (int) r0)
            int r4 = r3.length
            byte[] r3 = atakplugin.UASTool.aji.m1809a((byte[]) r3, (int) r5, (int) r4)
            java.lang.String r4 = "ssh-rsa"
            boolean r4 = r1.equals(r4)
            if (r4 == 0) goto L_0x0085
            atakplugin.UASTool.afx r1 = new atakplugin.UASTool.afx
            r1.<init>((byte[]) r3)
            int r3 = r3.length
            r1.mo626b((int) r3)
            int r3 = r1.mo633d()
            byte[] r3 = new byte[r3]
            r1.mo635d((byte[]) r3)
            int r3 = r1.mo633d()
            byte[] r3 = new byte[r3]
            r1.mo635d((byte[]) r3)
            int r4 = r1.mo633d()
            byte[] r4 = new byte[r4]
            r1.mo635d((byte[]) r4)
            atakplugin.UASTool.ahr r1 = new atakplugin.UASTool.ahr
            r1.<init>(r10, r4, r3, r2)
            goto L_0x00cb
        L_0x0085:
            java.lang.String r4 = "ssh-dss"
            boolean r1 = r1.equals(r4)
            if (r1 == 0) goto L_0x0129
            atakplugin.UASTool.afx r1 = new atakplugin.UASTool.afx
            r1.<init>((byte[]) r3)
            int r2 = r3.length
            r1.mo626b((int) r2)
            int r2 = r1.mo633d()
            byte[] r2 = new byte[r2]
            r1.mo635d((byte[]) r2)
            int r2 = r1.mo633d()
            byte[] r5 = new byte[r2]
            r1.mo635d((byte[]) r5)
            int r2 = r1.mo633d()
            byte[] r6 = new byte[r2]
            r1.mo635d((byte[]) r6)
            int r2 = r1.mo633d()
            byte[] r7 = new byte[r2]
            r1.mo635d((byte[]) r7)
            int r2 = r1.mo633d()
            byte[] r8 = new byte[r2]
            r1.mo635d((byte[]) r8)
            atakplugin.UASTool.ahn r1 = new atakplugin.UASTool.ahn
            r9 = 0
            r3 = r1
            r4 = r10
            r3.<init>(r4, r5, r6, r7, r8, r9)
        L_0x00cb:
            java.lang.String r10 = "Encryption"
            java.lang.Object r10 = r11.get(r10)
            java.lang.String r2 = "none"
            boolean r10 = r10.equals(r2)
            r10 = r10 ^ 1
            r1.f1303m = r10
            r10 = 2
            r1.f1300i = r10
            java.lang.String r10 = "Comment"
            java.lang.Object r10 = r11.get(r10)
            java.lang.String r10 = (java.lang.String) r10
            r1.f1301j = r10
            boolean r10 = r1.f1303m
            if (r10 == 0) goto L_0x0123
            java.lang.String r10 = "aes256-cbc"
            java.lang.String r11 = atakplugin.UASTool.ahg.m1350e(r10)
            boolean r11 = atakplugin.UASTool.air.m1640l(r11)
            java.lang.String r2 = "The cipher 'aes256-cbc' is required, but it is not available."
            if (r11 == 0) goto L_0x011d
            java.lang.String r10 = atakplugin.UASTool.ahg.m1350e(r10)     // Catch:{ Exception -> 0x0117 }
            java.lang.Class r10 = java.lang.Class.forName(r10)     // Catch:{ Exception -> 0x0117 }
            java.lang.Object r10 = r10.newInstance()     // Catch:{ Exception -> 0x0117 }
            atakplugin.UASTool.agm r10 = (atakplugin.UASTool.agm) r10     // Catch:{ Exception -> 0x0117 }
            atakplugin.UASTool.agm r10 = (atakplugin.UASTool.agm) r10     // Catch:{ Exception -> 0x0117 }
            r1.f1305p = r10     // Catch:{ Exception -> 0x0117 }
            int r10 = r10.mo803a()     // Catch:{ Exception -> 0x0117 }
            byte[] r10 = new byte[r10]     // Catch:{ Exception -> 0x0117 }
            r1.f1309u = r10     // Catch:{ Exception -> 0x0117 }
            r1.f1304n = r0
            goto L_0x0128
        L_0x0117:
            atakplugin.UASTool.ahj r10 = new atakplugin.UASTool.ahj
            r10.<init>(r2)
            throw r10
        L_0x011d:
            atakplugin.UASTool.ahj r10 = new atakplugin.UASTool.ahj
            r10.<init>(r2)
            throw r10
        L_0x0123:
            r1.f1304n = r0
            r1.mo936b((byte[]) r0)
        L_0x0128:
            return r1
        L_0x0129:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.ahm.m1395a(atakplugin.UASTool.ahg, byte[]):atakplugin.UASTool.ahm");
    }

    /* renamed from: a */
    private static byte[] m1398a(afx afx, int i) {
        byte[] bArr;
        byte[] bArr2 = afx.f888b;
        int i2 = afx.f889c;
        byte[] bArr3 = null;
        while (true) {
            int i3 = i - 1;
            if (i <= 0) {
                break;
            }
            int i4 = i2;
            while (true) {
                if (bArr2.length <= i4) {
                    break;
                }
                int i5 = i4 + 1;
                if (bArr2[i4] == 13) {
                    if (bArr3 == null) {
                        int i6 = (i5 - i2) - 1;
                        bArr = new byte[i6];
                        System.arraycopy(bArr2, i2, bArr, 0, i6);
                    } else {
                        bArr = new byte[(((bArr3.length + i5) - i2) - 1)];
                        System.arraycopy(bArr3, 0, bArr, 0, bArr3.length);
                        System.arraycopy(bArr2, i2, bArr, bArr3.length, (i5 - i2) - 1);
                        for (int i7 = 0; i7 < bArr3.length; i7++) {
                            bArr3[i7] = 0;
                        }
                    }
                    i4 = i5;
                    bArr3 = bArr;
                } else {
                    i4 = i5;
                }
            }
            if (bArr2[i4] == 10) {
                i4++;
            }
            i2 = i4;
            i = i3;
        }
        if (bArr3 != null) {
            afx.f889c = i2;
        }
        return bArr3;
    }

    /* renamed from: a */
    private static boolean m1397a(afx afx, Hashtable hashtable) {
        String str;
        String str2;
        byte[] bArr = afx.f888b;
        int i = afx.f889c;
        int i2 = i;
        while (true) {
            str = null;
            if (i2 >= bArr.length || bArr[i2] == 13) {
                str2 = null;
            } else if (bArr[i2] == 58) {
                str2 = new String(bArr, i, i2 - i);
                int i3 = i2 + 1;
                if (i3 < bArr.length && bArr[i3] == 32) {
                    i3++;
                }
                i = i3;
            } else {
                i2++;
            }
        }
        str2 = null;
        if (str2 == null) {
            return false;
        }
        int i4 = i;
        while (true) {
            if (i4 >= bArr.length) {
                break;
            } else if (bArr[i4] == 13) {
                str = new String(bArr, i, i4 - i);
                int i5 = i4 + 1;
                if (i5 < bArr.length && bArr[i5] == 10) {
                    i5++;
                }
                i = i5;
            } else {
                i4++;
            }
        }
        if (str != null) {
            hashtable.put(str2, str);
            afx.f889c = i;
        }
        if (str2 == null || str == null) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo921a(ahm ahm) {
        this.f1310v = ahm.f1310v;
        this.f1300i = ahm.f1300i;
        this.f1301j = ahm.f1301j;
        this.f1305p = ahm.f1305p;
    }

    /* renamed from: atakplugin.UASTool.ahm$b */
    class C0045b extends Exception {
        C0045b() {
        }
    }

    /* renamed from: atakplugin.UASTool.ahm$a */
    class C0044a {

        /* renamed from: a */
        byte[] f1311a;

        /* renamed from: b */
        int f1312b;

        /* renamed from: c */
        int f1313c;

        C0044a(ahm ahm, byte[] bArr) {
            this(bArr, 0, bArr.length);
        }

        C0044a(byte[] bArr, int i, int i2) {
            this.f1311a = bArr;
            this.f1312b = i;
            this.f1313c = i2;
            if (i + i2 > bArr.length) {
                throw new C0045b();
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public int mo954a() {
            return this.f1311a[this.f1312b] & 255;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public boolean mo955b() {
            return mo954a() == 48;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public boolean mo956c() {
            return mo954a() == 2;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public boolean mo957d() {
            return mo954a() == 6;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: e */
        public boolean mo958e() {
            return mo954a() == 4;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: byte} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: byte} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v8, resolved type: byte} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private int m1440a(int[] r7) {
            /*
                r6 = this;
                r0 = 0
                r1 = r7[r0]
                byte[] r2 = r6.f1311a
                int r3 = r1 + 1
                byte r1 = r2[r1]
                r1 = r1 & 255(0xff, float:3.57E-43)
                r2 = r1 & 128(0x80, float:1.794E-43)
                if (r2 == 0) goto L_0x0025
                r1 = r1 & 127(0x7f, float:1.78E-43)
                r2 = 0
            L_0x0012:
                int r4 = r1 + -1
                if (r1 <= 0) goto L_0x0024
                int r1 = r2 << 8
                byte[] r2 = r6.f1311a
                int r5 = r3 + 1
                byte r2 = r2[r3]
                r2 = r2 & 255(0xff, float:3.57E-43)
                int r2 = r2 + r1
                r1 = r4
                r3 = r5
                goto L_0x0012
            L_0x0024:
                r1 = r2
            L_0x0025:
                r7[r0] = r3
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.ahm.C0044a.m1440a(int[]):int");
        }

        /* access modifiers changed from: package-private */
        /* renamed from: f */
        public byte[] mo959f() {
            int[] iArr = {this.f1312b + 1};
            int a = m1440a(iArr);
            byte[] bArr = new byte[a];
            System.arraycopy(this.f1311a, iArr[0], bArr, 0, a);
            return bArr;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: g */
        public C0044a[] mo960g() {
            byte[] bArr = this.f1311a;
            int i = this.f1312b;
            byte b = bArr[i];
            int[] iArr = {i + 1};
            int a = m1440a(iArr);
            if (b == 5) {
                return new C0044a[0];
            }
            int i2 = iArr[0];
            Vector vector = new Vector();
            while (a > 0) {
                int i3 = i2 + 1;
                iArr[0] = i3;
                int a2 = m1440a(iArr);
                int i4 = iArr[0];
                int i5 = i4 - i3;
                vector.addElement(new C0044a(this.f1311a, i3 - 1, i5 + 1 + a2));
                i2 = i4 + a2;
                a = ((a - 1) - i5) - a2;
            }
            C0044a[] aVarArr = new C0044a[vector.size()];
            for (int i6 = 0; i6 < vector.size(); i6++) {
                aVarArr[i6] = (C0044a) vector.elementAt(i6);
            }
            return aVarArr;
        }
    }
}
