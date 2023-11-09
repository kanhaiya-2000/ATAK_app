package atakplugin.UASTool;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Vector;

public class ahs implements ahb {

    /* renamed from: d */
    private static final String f1348d = "known_hosts";

    /* renamed from: i */
    private static final byte[] f1349i = {32};

    /* renamed from: j */
    private static final byte[] f1350j = aji.m1820c("\n");

    /* renamed from: e */
    private ahg f1351e = null;

    /* renamed from: f */
    private String f1352f = null;

    /* renamed from: g */
    private Vector f1353g = null;

    /* renamed from: h */
    private ahv f1354h = null;

    ahs(ahg ahg) {
        this.f1351e = ahg;
        this.f1353g = new Vector();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo979a(String str) {
        try {
            this.f1352f = str;
            mo977a((InputStream) new FileInputStream(aji.m1821d(str)));
        } catch (FileNotFoundException e) {
            throw new ahj(e.toString(), e);
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x012f, code lost:
        if (r3 != 10) goto L_0x0132;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x0132, code lost:
        if (r3 == 32) goto L_0x013d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x0134, code lost:
        if (r3 != 9) goto L_0x0137;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x0137, code lost:
        r0.append((char) r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x013b, code lost:
        r3 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x013d, code lost:
        r3 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x013e, code lost:
        r4 = r0.toString();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x0146, code lost:
        if (r4.length() != 0) goto L_0x0150;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x0148, code lost:
        m1511c(atakplugin.UASTool.aji.m1819c(r9, 0, r1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x0150, code lost:
        if (r3 >= r1) goto L_0x015b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x0152, code lost:
        r14 = r9[r3];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x0154, code lost:
        if (r14 == 32) goto L_0x0158;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x0156, code lost:
        if (r14 != 9) goto L_0x015b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x0158, code lost:
        r3 = r3 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x015c, code lost:
        if (r3 >= r1) goto L_0x0179;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x015e, code lost:
        r0.setLength(0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x0161, code lost:
        if (r3 >= r1) goto L_0x0173;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x0163, code lost:
        r10 = r3 + 1;
        r3 = r9[r3];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x0167, code lost:
        if (r3 != 13) goto L_0x016a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x016a, code lost:
        if (r3 != 10) goto L_0x016d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x016d, code lost:
        r0.append((char) r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x0171, code lost:
        r3 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x0173, code lost:
        r7 = r0.toString();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x0179, code lost:
        r7 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x017a, code lost:
        r8.f1353g.addElement(new atakplugin.UASTool.ahs.C0046a(r17, r12, r13, r5, atakplugin.UASTool.aji.m1809a(atakplugin.UASTool.aji.m1820c(r4), 0, r4.length()), r7));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x0196, code lost:
        m1511c(atakplugin.UASTool.aji.m1819c(r9, 0, r1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x005c, code lost:
        if (r3 < r1) goto L_0x0067;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x005e, code lost:
        m1511c(atakplugin.UASTool.aji.m1819c(r9, 0, r1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0067, code lost:
        r0.setLength(0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x006a, code lost:
        if (r3 >= r1) goto L_0x007c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x006c, code lost:
        r12 = r3 + 1;
        r3 = r9[r3];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0070, code lost:
        if (r3 == 32) goto L_0x007b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0072, code lost:
        if (r3 != 9) goto L_0x0075;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0075, code lost:
        r0.append((char) r3);
        r3 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x007b, code lost:
        r3 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x007c, code lost:
        r12 = r0.toString();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0080, code lost:
        if (r3 >= r1) goto L_0x0196;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0086, code lost:
        if (r12.length() != 0) goto L_0x008a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x008a, code lost:
        if (r3 >= r1) goto L_0x0095;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x008c, code lost:
        r13 = r9[r3];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x008e, code lost:
        if (r13 == 32) goto L_0x0092;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0090, code lost:
        if (r13 != 9) goto L_0x0095;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0092, code lost:
        r3 = r3 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x009d, code lost:
        if (r12.charAt(0) != '@') goto L_0x00d5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x009f, code lost:
        r0.setLength(0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00a2, code lost:
        if (r3 >= r1) goto L_0x00b4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00a4, code lost:
        r13 = r3 + 1;
        r3 = r9[r3];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00a8, code lost:
        if (r3 == 32) goto L_0x00b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00aa, code lost:
        if (r3 != 9) goto L_0x00ad;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00ad, code lost:
        r0.append((char) r3);
        r3 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x00b3, code lost:
        r3 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x00b4, code lost:
        r13 = r0.toString();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x00b8, code lost:
        if (r3 >= r1) goto L_0x00cc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x00be, code lost:
        if (r13.length() != 0) goto L_0x00c1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x00c1, code lost:
        if (r3 >= r1) goto L_0x00da;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x00c3, code lost:
        r14 = r9[r3];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x00c5, code lost:
        if (r14 == 32) goto L_0x00c9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x00c7, code lost:
        if (r14 != 9) goto L_0x00da;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x00c9, code lost:
        r3 = r3 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x00cc, code lost:
        m1511c(atakplugin.UASTool.aji.m1819c(r9, 0, r1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x00d5, code lost:
        r13 = r12;
        r12 = "";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x00da, code lost:
        r0.setLength(0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x00dd, code lost:
        if (r3 >= r1) goto L_0x00ef;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x00df, code lost:
        r14 = r3 + 1;
        r3 = r9[r3];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x00e3, code lost:
        if (r3 == 32) goto L_0x00ee;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x00e5, code lost:
        if (r3 != 9) goto L_0x00e8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x00e8, code lost:
        r0.append((char) r3);
        r3 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x00ee, code lost:
        r3 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x00f9, code lost:
        if (r0.toString().equals("ssh-dss") == false) goto L_0x00fe;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x00fb, code lost:
        r5 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x0108, code lost:
        if (r0.toString().equals("ssh-rsa") == false) goto L_0x010c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x010a, code lost:
        r5 = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x010c, code lost:
        r3 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x010d, code lost:
        if (r3 < r1) goto L_0x0118;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x010f, code lost:
        m1511c(atakplugin.UASTool.aji.m1819c(r9, 0, r1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x0118, code lost:
        if (r3 >= r1) goto L_0x0123;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x011a, code lost:
        r4 = r9[r3];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x011c, code lost:
        if (r4 == 32) goto L_0x0120;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x011e, code lost:
        if (r4 != 9) goto L_0x0123;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x0120, code lost:
        r3 = r3 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x0123, code lost:
        r0.setLength(0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x0126, code lost:
        if (r3 >= r1) goto L_0x013e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x0128, code lost:
        r4 = r3 + 1;
        r3 = r9[r3];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x012c, code lost:
        if (r3 != 13) goto L_0x012f;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo977a(java.io.InputStream r18) {
        /*
            r17 = this;
            r8 = r17
            java.util.Vector r0 = r8.f1353g
            r0.removeAllElements()
            java.lang.StringBuffer r0 = new java.lang.StringBuffer
            r0.<init>()
            r1 = 1024(0x400, float:1.435E-42)
            byte[] r1 = new byte[r1]     // Catch:{ Exception -> 0x01b4 }
        L_0x0010:
            r2 = 0
            r9 = r1
            r1 = 0
        L_0x0013:
            int r3 = r18.read()     // Catch:{ Exception -> 0x01b4 }
            r4 = 2
            r5 = -1
            r6 = 10
            r7 = 13
            if (r3 != r5) goto L_0x0031
            if (r1 != 0) goto L_0x003e
            r18.close()     // Catch:{ IOException -> 0x0025 }
            return
        L_0x0025:
            r0 = move-exception
            r1 = r0
            atakplugin.UASTool.ahj r0 = new atakplugin.UASTool.ahj
            java.lang.String r2 = r1.toString()
            r0.<init>(r2, r1)
            throw r0
        L_0x0031:
            if (r3 != r7) goto L_0x0034
            goto L_0x0013
        L_0x0034:
            if (r3 != r6) goto L_0x0037
            goto L_0x003e
        L_0x0037:
            int r10 = r9.length     // Catch:{ Exception -> 0x01b4 }
            if (r10 > r1) goto L_0x01aa
            r10 = 10240(0x2800, float:1.4349E-41)
            if (r1 <= r10) goto L_0x01a0
        L_0x003e:
            r3 = 0
        L_0x003f:
            r10 = 9
            r11 = 32
            if (r3 >= r1) goto L_0x005c
            byte r12 = r9[r3]     // Catch:{ Exception -> 0x01b4 }
            if (r12 == r11) goto L_0x0059
            if (r12 != r10) goto L_0x004c
            goto L_0x0059
        L_0x004c:
            r13 = 35
            if (r12 != r13) goto L_0x005c
            java.lang.String r1 = atakplugin.UASTool.aji.m1819c(r9, r2, r1)     // Catch:{ Exception -> 0x01b4 }
            r8.m1511c(r1)     // Catch:{ Exception -> 0x01b4 }
            goto L_0x019d
        L_0x0059:
            int r3 = r3 + 1
            goto L_0x003f
        L_0x005c:
            if (r3 < r1) goto L_0x0067
            java.lang.String r1 = atakplugin.UASTool.aji.m1819c(r9, r2, r1)     // Catch:{ Exception -> 0x01b4 }
            r8.m1511c(r1)     // Catch:{ Exception -> 0x01b4 }
            goto L_0x019d
        L_0x0067:
            r0.setLength(r2)     // Catch:{ Exception -> 0x01b4 }
        L_0x006a:
            if (r3 >= r1) goto L_0x007c
            int r12 = r3 + 1
            byte r3 = r9[r3]     // Catch:{ Exception -> 0x01b4 }
            if (r3 == r11) goto L_0x007b
            if (r3 != r10) goto L_0x0075
            goto L_0x007b
        L_0x0075:
            char r3 = (char) r3     // Catch:{ Exception -> 0x01b4 }
            r0.append(r3)     // Catch:{ Exception -> 0x01b4 }
            r3 = r12
            goto L_0x006a
        L_0x007b:
            r3 = r12
        L_0x007c:
            java.lang.String r12 = r0.toString()     // Catch:{ Exception -> 0x01b4 }
            if (r3 >= r1) goto L_0x0196
            int r13 = r12.length()     // Catch:{ Exception -> 0x01b4 }
            if (r13 != 0) goto L_0x008a
            goto L_0x0196
        L_0x008a:
            if (r3 >= r1) goto L_0x0095
            byte r13 = r9[r3]     // Catch:{ Exception -> 0x01b4 }
            if (r13 == r11) goto L_0x0092
            if (r13 != r10) goto L_0x0095
        L_0x0092:
            int r3 = r3 + 1
            goto L_0x008a
        L_0x0095:
            java.lang.String r13 = ""
            char r14 = r12.charAt(r2)     // Catch:{ Exception -> 0x01b4 }
            r15 = 64
            if (r14 != r15) goto L_0x00d5
            r0.setLength(r2)     // Catch:{ Exception -> 0x01b4 }
        L_0x00a2:
            if (r3 >= r1) goto L_0x00b4
            int r13 = r3 + 1
            byte r3 = r9[r3]     // Catch:{ Exception -> 0x01b4 }
            if (r3 == r11) goto L_0x00b3
            if (r3 != r10) goto L_0x00ad
            goto L_0x00b3
        L_0x00ad:
            char r3 = (char) r3     // Catch:{ Exception -> 0x01b4 }
            r0.append(r3)     // Catch:{ Exception -> 0x01b4 }
            r3 = r13
            goto L_0x00a2
        L_0x00b3:
            r3 = r13
        L_0x00b4:
            java.lang.String r13 = r0.toString()     // Catch:{ Exception -> 0x01b4 }
            if (r3 >= r1) goto L_0x00cc
            int r14 = r13.length()     // Catch:{ Exception -> 0x01b4 }
            if (r14 != 0) goto L_0x00c1
            goto L_0x00cc
        L_0x00c1:
            if (r3 >= r1) goto L_0x00da
            byte r14 = r9[r3]     // Catch:{ Exception -> 0x01b4 }
            if (r14 == r11) goto L_0x00c9
            if (r14 != r10) goto L_0x00da
        L_0x00c9:
            int r3 = r3 + 1
            goto L_0x00c1
        L_0x00cc:
            java.lang.String r1 = atakplugin.UASTool.aji.m1819c(r9, r2, r1)     // Catch:{ Exception -> 0x01b4 }
            r8.m1511c(r1)     // Catch:{ Exception -> 0x01b4 }
            goto L_0x019d
        L_0x00d5:
            r16 = r13
            r13 = r12
            r12 = r16
        L_0x00da:
            r0.setLength(r2)     // Catch:{ Exception -> 0x01b4 }
        L_0x00dd:
            if (r3 >= r1) goto L_0x00ef
            int r14 = r3 + 1
            byte r3 = r9[r3]     // Catch:{ Exception -> 0x01b4 }
            if (r3 == r11) goto L_0x00ee
            if (r3 != r10) goto L_0x00e8
            goto L_0x00ee
        L_0x00e8:
            char r3 = (char) r3     // Catch:{ Exception -> 0x01b4 }
            r0.append(r3)     // Catch:{ Exception -> 0x01b4 }
            r3 = r14
            goto L_0x00dd
        L_0x00ee:
            r3 = r14
        L_0x00ef:
            java.lang.String r14 = r0.toString()     // Catch:{ Exception -> 0x01b4 }
            java.lang.String r15 = "ssh-dss"
            boolean r14 = r14.equals(r15)     // Catch:{ Exception -> 0x01b4 }
            if (r14 == 0) goto L_0x00fe
            r4 = 1
            r5 = 1
            goto L_0x010d
        L_0x00fe:
            java.lang.String r14 = r0.toString()     // Catch:{ Exception -> 0x01b4 }
            java.lang.String r15 = "ssh-rsa"
            boolean r14 = r14.equals(r15)     // Catch:{ Exception -> 0x01b4 }
            if (r14 == 0) goto L_0x010c
            r5 = 2
            goto L_0x010d
        L_0x010c:
            r3 = r1
        L_0x010d:
            if (r3 < r1) goto L_0x0118
            java.lang.String r1 = atakplugin.UASTool.aji.m1819c(r9, r2, r1)     // Catch:{ Exception -> 0x01b4 }
            r8.m1511c(r1)     // Catch:{ Exception -> 0x01b4 }
            goto L_0x019d
        L_0x0118:
            if (r3 >= r1) goto L_0x0123
            byte r4 = r9[r3]     // Catch:{ Exception -> 0x01b4 }
            if (r4 == r11) goto L_0x0120
            if (r4 != r10) goto L_0x0123
        L_0x0120:
            int r3 = r3 + 1
            goto L_0x0118
        L_0x0123:
            r0.setLength(r2)     // Catch:{ Exception -> 0x01b4 }
        L_0x0126:
            if (r3 >= r1) goto L_0x013e
            int r4 = r3 + 1
            byte r3 = r9[r3]     // Catch:{ Exception -> 0x01b4 }
            if (r3 != r7) goto L_0x012f
            goto L_0x013b
        L_0x012f:
            if (r3 != r6) goto L_0x0132
            goto L_0x013d
        L_0x0132:
            if (r3 == r11) goto L_0x013d
            if (r3 != r10) goto L_0x0137
            goto L_0x013d
        L_0x0137:
            char r3 = (char) r3     // Catch:{ Exception -> 0x01b4 }
            r0.append(r3)     // Catch:{ Exception -> 0x01b4 }
        L_0x013b:
            r3 = r4
            goto L_0x0126
        L_0x013d:
            r3 = r4
        L_0x013e:
            java.lang.String r4 = r0.toString()     // Catch:{ Exception -> 0x01b4 }
            int r14 = r4.length()     // Catch:{ Exception -> 0x01b4 }
            if (r14 != 0) goto L_0x0150
            java.lang.String r1 = atakplugin.UASTool.aji.m1819c(r9, r2, r1)     // Catch:{ Exception -> 0x01b4 }
            r8.m1511c(r1)     // Catch:{ Exception -> 0x01b4 }
            goto L_0x019d
        L_0x0150:
            if (r3 >= r1) goto L_0x015b
            byte r14 = r9[r3]     // Catch:{ Exception -> 0x01b4 }
            if (r14 == r11) goto L_0x0158
            if (r14 != r10) goto L_0x015b
        L_0x0158:
            int r3 = r3 + 1
            goto L_0x0150
        L_0x015b:
            r10 = 0
            if (r3 >= r1) goto L_0x0179
            r0.setLength(r2)     // Catch:{ Exception -> 0x01b4 }
        L_0x0161:
            if (r3 >= r1) goto L_0x0173
            int r10 = r3 + 1
            byte r3 = r9[r3]     // Catch:{ Exception -> 0x01b4 }
            if (r3 != r7) goto L_0x016a
            goto L_0x0171
        L_0x016a:
            if (r3 != r6) goto L_0x016d
            goto L_0x0173
        L_0x016d:
            char r3 = (char) r3     // Catch:{ Exception -> 0x01b4 }
            r0.append(r3)     // Catch:{ Exception -> 0x01b4 }
        L_0x0171:
            r3 = r10
            goto L_0x0161
        L_0x0173:
            java.lang.String r1 = r0.toString()     // Catch:{ Exception -> 0x01b4 }
            r7 = r1
            goto L_0x017a
        L_0x0179:
            r7 = r10
        L_0x017a:
            atakplugin.UASTool.ahs$a r10 = new atakplugin.UASTool.ahs$a     // Catch:{ Exception -> 0x01b4 }
            byte[] r1 = atakplugin.UASTool.aji.m1820c((java.lang.String) r4)     // Catch:{ Exception -> 0x01b4 }
            int r3 = r4.length()     // Catch:{ Exception -> 0x01b4 }
            byte[] r6 = atakplugin.UASTool.aji.m1809a((byte[]) r1, (int) r2, (int) r3)     // Catch:{ Exception -> 0x01b4 }
            r1 = r10
            r2 = r17
            r3 = r12
            r4 = r13
            r1.<init>(r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x01b4 }
            java.util.Vector r1 = r8.f1353g     // Catch:{ Exception -> 0x01b4 }
            r1.addElement(r10)     // Catch:{ Exception -> 0x01b4 }
            goto L_0x019d
        L_0x0196:
            java.lang.String r1 = atakplugin.UASTool.aji.m1819c(r9, r2, r1)     // Catch:{ Exception -> 0x01b4 }
            r8.m1511c(r1)     // Catch:{ Exception -> 0x01b4 }
        L_0x019d:
            r1 = r9
            goto L_0x0010
        L_0x01a0:
            int r5 = r9.length     // Catch:{ Exception -> 0x01b4 }
            int r5 = r5 * 2
            byte[] r4 = new byte[r5]     // Catch:{ Exception -> 0x01b4 }
            int r5 = r9.length     // Catch:{ Exception -> 0x01b4 }
            java.lang.System.arraycopy(r9, r2, r4, r2, r5)     // Catch:{ Exception -> 0x01b4 }
            r9 = r4
        L_0x01aa:
            int r4 = r1 + 1
            byte r3 = (byte) r3     // Catch:{ Exception -> 0x01b4 }
            r9[r1] = r3     // Catch:{ Exception -> 0x01b4 }
            r1 = r4
            goto L_0x0013
        L_0x01b2:
            r0 = move-exception
            goto L_0x01d4
        L_0x01b4:
            r0 = move-exception
            boolean r1 = r0 instanceof atakplugin.UASTool.ahj     // Catch:{ all -> 0x01b2 }
            if (r1 != 0) goto L_0x01d1
            boolean r1 = r0 instanceof java.lang.Throwable     // Catch:{ all -> 0x01b2 }
            if (r1 == 0) goto L_0x01c7
            atakplugin.UASTool.ahj r1 = new atakplugin.UASTool.ahj     // Catch:{ all -> 0x01b2 }
            java.lang.String r2 = r0.toString()     // Catch:{ all -> 0x01b2 }
            r1.<init>(r2, r0)     // Catch:{ all -> 0x01b2 }
            throw r1     // Catch:{ all -> 0x01b2 }
        L_0x01c7:
            atakplugin.UASTool.ahj r1 = new atakplugin.UASTool.ahj     // Catch:{ all -> 0x01b2 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x01b2 }
            r1.<init>(r0)     // Catch:{ all -> 0x01b2 }
            throw r1     // Catch:{ all -> 0x01b2 }
        L_0x01d1:
            atakplugin.UASTool.ahj r0 = (atakplugin.UASTool.ahj) r0     // Catch:{ all -> 0x01b2 }
            throw r0     // Catch:{ all -> 0x01b2 }
        L_0x01d4:
            r18.close()     // Catch:{ IOException -> 0x01d8 }
            throw r0
        L_0x01d8:
            r0 = move-exception
            r1 = r0
            atakplugin.UASTool.ahj r0 = new atakplugin.UASTool.ahj
            java.lang.String r2 = r1.toString()
            r0.<init>(r2, r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.ahs.mo977a(java.io.InputStream):void");
    }

    /* renamed from: c */
    private void m1511c(String str) {
        this.f1353g.addElement(new aha(str, 3, (byte[]) null));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public String mo982c() {
        return this.f1352f;
    }

    /* renamed from: a */
    public String mo847a() {
        return this.f1352f;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0039, code lost:
        if (r5 != 1) goto L_0x005a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0041, code lost:
        if (r9.startsWith("[") == false) goto L_0x005a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0049, code lost:
        if (r9.indexOf("]:") <= 1) goto L_0x005a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0059, code lost:
        return mo846a(r9.substring(1, r9.indexOf("]:")), r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x005a, code lost:
        return r5;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int mo846a(java.lang.String r9, byte[] r10) {
        /*
            r8 = this;
            r0 = 1
            if (r9 != 0) goto L_0x0004
            return r0
        L_0x0004:
            int r1 = r8.m1508a((byte[]) r10)
            java.util.Vector r2 = r8.f1353g
            monitor-enter(r2)
            r3 = 0
            r4 = 0
            r5 = 1
        L_0x000e:
            java.util.Vector r6 = r8.f1353g     // Catch:{ all -> 0x005b }
            int r6 = r6.size()     // Catch:{ all -> 0x005b }
            if (r4 >= r6) goto L_0x0038
            java.util.Vector r6 = r8.f1353g     // Catch:{ all -> 0x005b }
            java.lang.Object r6 = r6.elementAt(r4)     // Catch:{ all -> 0x005b }
            atakplugin.UASTool.aha r6 = (atakplugin.UASTool.aha) r6     // Catch:{ all -> 0x005b }
            atakplugin.UASTool.aha r6 = (atakplugin.UASTool.aha) r6     // Catch:{ all -> 0x005b }
            boolean r7 = r6.mo841a((java.lang.String) r9)     // Catch:{ all -> 0x005b }
            if (r7 == 0) goto L_0x0035
            int r7 = r6.f1228g     // Catch:{ all -> 0x005b }
            if (r7 != r1) goto L_0x0035
            byte[] r5 = r6.f1229h     // Catch:{ all -> 0x005b }
            boolean r5 = atakplugin.UASTool.aji.m1815b((byte[]) r5, (byte[]) r10)     // Catch:{ all -> 0x005b }
            if (r5 == 0) goto L_0x0034
            monitor-exit(r2)     // Catch:{ all -> 0x005b }
            return r3
        L_0x0034:
            r5 = 2
        L_0x0035:
            int r4 = r4 + 1
            goto L_0x000e
        L_0x0038:
            monitor-exit(r2)     // Catch:{ all -> 0x005b }
            if (r5 != r0) goto L_0x005a
            java.lang.String r1 = "["
            boolean r1 = r9.startsWith(r1)
            if (r1 == 0) goto L_0x005a
            java.lang.String r1 = "]:"
            int r1 = r9.indexOf(r1)
            if (r1 <= r0) goto L_0x005a
            java.lang.String r1 = "]:"
            int r1 = r9.indexOf(r1)
            java.lang.String r9 = r9.substring(r0, r1)
            int r9 = r8.mo846a((java.lang.String) r9, (byte[]) r10)
            return r9
        L_0x005a:
            return r5
        L_0x005b:
            r9 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x005b }
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.ahs.mo846a(java.lang.String, byte[]):int");
    }

    /* renamed from: a */
    public void mo848a(aha aha, ajh ajh) {
        boolean z;
        int i = aha.f1228g;
        String a = aha.mo839a();
        byte[] bArr = aha.f1229h;
        synchronized (this.f1353g) {
            z = false;
            for (int i2 = 0; i2 < this.f1353g.size(); i2++) {
                aha aha2 = (aha) this.f1353g.elementAt(i2);
                if (aha2.mo841a(a)) {
                    int i3 = aha2.f1228g;
                }
            }
        }
        this.f1353g.addElement(aha);
        String a2 = mo847a();
        if (a2 != null) {
            File file = new File(aji.m1821d(a2));
            if (file.exists()) {
                z = true;
            } else if (ajh != null) {
                boolean c = ajh.mo1173c(a2 + " does not exist.\n" + "Are you sure you want to create it?");
                File parentFile = file.getParentFile();
                if (c && parentFile != null && !parentFile.exists()) {
                    c = ajh.mo1173c("The parent directory " + parentFile + " does not exist.\n" + "Are you sure you want to create it?");
                    if (c) {
                        if (!parentFile.mkdirs()) {
                            ajh.mo1174d(parentFile + " has not been created.");
                            c = false;
                        } else {
                            ajh.mo1174d(parentFile + " has been succesfully created.\nPlease check its access permission.");
                        }
                    }
                }
                if (parentFile != null) {
                    z = c;
                }
            }
            if (z) {
                try {
                    mo981b(a2);
                } catch (Exception e) {
                    PrintStream printStream = System.err;
                    printStream.println("sync known_hosts: " + e);
                }
            }
        }
    }

    /* renamed from: b */
    public aha[] mo851b() {
        return mo852b((String) null, (String) null);
    }

    /* renamed from: b */
    public aha[] mo852b(String str, String str2) {
        aha[] ahaArr;
        synchronized (this.f1353g) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < this.f1353g.size(); i++) {
                aha aha = (aha) this.f1353g.elementAt(i);
                if (aha.f1228g != 3) {
                    if (str == null || (aha.mo841a(str) && (str2 == null || aha.mo842b().equals(str2)))) {
                        arrayList.add(aha);
                    }
                }
            }
            int size = arrayList.size();
            ahaArr = new aha[size];
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                ahaArr[i2] = (aha) arrayList.get(i2);
            }
            if (str != null && str.startsWith("[") && str.indexOf("]:") > 1) {
                aha[] b = mo852b(str.substring(1, str.indexOf("]:")), str2);
                if (b.length > 0) {
                    aha[] ahaArr2 = new aha[(b.length + size)];
                    System.arraycopy(ahaArr, 0, ahaArr2, 0, size);
                    System.arraycopy(b, 0, ahaArr2, size, b.length);
                    ahaArr = ahaArr2;
                }
            }
        }
        return ahaArr;
    }

    /* renamed from: a */
    public void mo849a(String str, String str2) {
        mo850a(str, str2, (byte[]) null);
    }

    /* renamed from: a */
    public void mo850a(String str, String str2, byte[] bArr) {
        boolean z;
        synchronized (this.f1353g) {
            z = false;
            for (int i = 0; i < this.f1353g.size(); i++) {
                aha aha = (aha) this.f1353g.elementAt(i);
                if (str == null || (aha.mo841a(str) && (str2 == null || (aha.mo842b().equals(str2) && (bArr == null || aji.m1815b(bArr, aha.f1229h)))))) {
                    String a = aha.mo839a();
                    if (!a.equals(str)) {
                        if (!(aha instanceof C0046a) || !((C0046a) aha).mo984f()) {
                            aha.f1227f = m1510c(a, str);
                            z = true;
                        }
                    }
                    this.f1353g.removeElement(aha);
                    z = true;
                }
            }
        }
        if (z) {
            try {
                mo983d();
            } catch (Exception unused) {
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public void mo983d() {
        String str = this.f1352f;
        if (str != null) {
            mo981b(str);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public synchronized void mo981b(String str) {
        if (str != null) {
            FileOutputStream fileOutputStream = new FileOutputStream(aji.m1821d(str));
            mo978a((OutputStream) fileOutputStream);
            fileOutputStream.close();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo978a(OutputStream outputStream) {
        try {
            synchronized (this.f1353g) {
                for (int i = 0; i < this.f1353g.size(); i++) {
                    aha aha = (aha) this.f1353g.elementAt(i);
                    String e = aha.mo845e();
                    String a = aha.mo839a();
                    String b = aha.mo842b();
                    String d = aha.mo844d();
                    if (b.equals("UNKNOWN")) {
                        outputStream.write(aji.m1820c(a));
                        outputStream.write(f1350j);
                    } else {
                        if (e.length() != 0) {
                            outputStream.write(aji.m1820c(e));
                            outputStream.write(f1349i);
                        }
                        outputStream.write(aji.m1820c(a));
                        byte[] bArr = f1349i;
                        outputStream.write(bArr);
                        outputStream.write(aji.m1820c(b));
                        outputStream.write(bArr);
                        outputStream.write(aji.m1820c(aha.mo843c()));
                        if (d != null) {
                            outputStream.write(bArr);
                            outputStream.write(aji.m1820c(d));
                        }
                        outputStream.write(f1350j);
                    }
                }
            }
        } catch (Exception e2) {
            System.err.println(e2);
        }
    }

    /* renamed from: a */
    private int m1508a(byte[] bArr) {
        if (bArr[8] == 100) {
            return 1;
        }
        return bArr[8] == 114 ? 2 : 3;
    }

    /* renamed from: c */
    private String m1510c(String str, String str2) {
        int length = str2.length();
        int length2 = str.length();
        int i = 0;
        while (i < length2) {
            int indexOf = str.indexOf(44, i);
            if (indexOf == -1) {
                break;
            } else if (!str2.equals(str.substring(i, indexOf))) {
                i = indexOf + 1;
            } else {
                return str.substring(0, i) + str.substring(indexOf + 1);
            }
        }
        if (!str.endsWith(str2) || length2 - i != length) {
            return str;
        }
        return str.substring(0, length == length2 ? 0 : (length2 - length) - 1);
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public synchronized ahv m1512e() {
        if (this.f1354h == null) {
            try {
                this.f1354h = (ahv) Class.forName(ahg.m1350e("hmac-sha1")).newInstance();
            } catch (Exception e) {
                PrintStream printStream = System.err;
                printStream.println("hmacsha1: " + e);
            }
        }
        return this.f1354h;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public aha mo980b(String str, byte[] bArr) {
        C0046a aVar = new C0046a(this, str, bArr);
        aVar.mo985g();
        return aVar;
    }

    /* renamed from: atakplugin.UASTool.ahs$a */
    class C0046a extends aha {

        /* renamed from: m */
        private static final String f1355m = "|1|";

        /* renamed from: n */
        private static final String f1356n = "|";

        /* renamed from: j */
        byte[] f1357j;

        /* renamed from: k */
        byte[] f1358k;

        /* renamed from: o */
        private boolean f1360o;

        C0046a(ahs ahs, String str, byte[] bArr) {
            this(ahs, str, 0, bArr);
        }

        C0046a(ahs ahs, String str, int i, byte[] bArr) {
            this("", str, i, bArr, (String) null);
        }

        C0046a(String str, String str2, int i, byte[] bArr, String str3) {
            super(str, str2, i, bArr, str3);
            this.f1360o = false;
            this.f1357j = null;
            this.f1358k = null;
            if (this.f1227f.startsWith(f1355m) && this.f1227f.substring(3).indexOf(f1356n) > 0) {
                String substring = this.f1227f.substring(3);
                String substring2 = substring.substring(0, substring.indexOf(f1356n));
                String substring3 = substring.substring(substring.indexOf(f1356n) + 1);
                this.f1357j = aji.m1809a(aji.m1820c(substring2), 0, substring2.length());
                byte[] a = aji.m1809a(aji.m1820c(substring3), 0, substring3.length());
                this.f1358k = a;
                if (this.f1357j.length == 20 && a.length == 20) {
                    this.f1360o = true;
                    return;
                }
                this.f1357j = null;
                this.f1358k = null;
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public boolean mo841a(String str) {
            boolean b;
            if (!this.f1360o) {
                return super.mo841a(str);
            }
            ahv a = ahs.this.m1512e();
            try {
                synchronized (a) {
                    a.mo990a(this.f1357j);
                    byte[] c = aji.m1820c(str);
                    a.mo992a(c, 0, c.length);
                    byte[] bArr = new byte[a.mo993b()];
                    a.mo991a(bArr, 0);
                    b = aji.m1815b(this.f1358k, bArr);
                }
                return b;
            } catch (Exception e) {
                System.out.println(e);
                return false;
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: f */
        public boolean mo984f() {
            return this.f1360o;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: g */
        public void mo985g() {
            if (!this.f1360o) {
                ahv a = ahs.this.m1512e();
                if (this.f1357j == null) {
                    aie aie = air.f1433H;
                    synchronized (aie) {
                        byte[] bArr = new byte[a.mo993b()];
                        this.f1357j = bArr;
                        aie.mo1012a(bArr, 0, bArr.length);
                    }
                }
                try {
                    synchronized (a) {
                        a.mo990a(this.f1357j);
                        byte[] c = aji.m1820c(this.f1227f);
                        a.mo992a(c, 0, c.length);
                        byte[] bArr2 = new byte[a.mo993b()];
                        this.f1358k = bArr2;
                        a.mo991a(bArr2, 0);
                    }
                } catch (Exception unused) {
                }
                StringBuilder sb = new StringBuilder();
                sb.append(f1355m);
                byte[] bArr3 = this.f1357j;
                sb.append(aji.m1813b(aji.m1817b(bArr3, 0, bArr3.length)));
                sb.append(f1356n);
                byte[] bArr4 = this.f1358k;
                sb.append(aji.m1813b(aji.m1817b(bArr4, 0, bArr4.length)));
                this.f1227f = sb.toString();
                this.f1360o = true;
            }
        }
    }
}
