package atakplugin.UASTool;

import com.autel.camera.protocol.protocol20.entity.CameraParamsConfig;
import java.util.Locale;

public class byz implements byf {

    /* renamed from: a */
    private static final String f4317a = "AEIOUY";

    /* renamed from: b */
    private static final String[] f4318b = {"GN", "KN", "PN", "WR", "PS"};

    /* renamed from: c */
    private static final String[] f4319c = {"L", "R", "N", "M", "B", "H", "F", "V", "W", " "};

    /* renamed from: d */
    private static final String[] f4320d = {"ES", "EP", "EB", "EL", "EY", "IB", "IL", "IN", "IE", "EI", "ER"};

    /* renamed from: e */
    private static final String[] f4321e = {"L", "T", "K", "S", "N", "M", "B", "Z"};

    /* renamed from: f */
    private int f4322f = 4;

    /* renamed from: a */
    public String mo4118a(String str) {
        return mo4119a(str, false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0058, code lost:
        if (mo4116a(r8, r3) == 'V') goto L_0x005a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x005a, code lost:
        r1 = r1 + 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x005d, code lost:
        r1 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0079, code lost:
        if (mo4116a(r8, r3) == 'Q') goto L_0x005a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x008a, code lost:
        if (mo4116a(r8, r3) == 'N') goto L_0x005a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0096, code lost:
        if (m10721f(r8, r1) != false) goto L_0x005a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00a8, code lost:
        if (mo4116a(r8, r3) == 'K') goto L_0x005a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00c6, code lost:
        if (mo4116a(r8, r3) == 'F') goto L_0x005a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00e2, code lost:
        if (mo4116a(r8, r3) == 'B') goto L_0x005a;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String mo4119a(java.lang.String r8, boolean r9) {
        /*
            r7 = this;
            java.lang.String r8 = r7.m10718e(r8)
            if (r8 != 0) goto L_0x0008
            r8 = 0
            return r8
        L_0x0008:
            boolean r0 = r7.m10710c(r8)
            boolean r1 = r7.m10714d(r8)
            atakplugin.UASTool.byz$a r2 = new atakplugin.UASTool.byz$a
            int r3 = r7.mo4117a()
            r2.<init>(r7, r3)
        L_0x0019:
            boolean r3 = r2.mo4133c()
            if (r3 != 0) goto L_0x00f9
            int r3 = r8.length()
            int r3 = r3 + -1
            if (r1 > r3) goto L_0x00f9
            char r3 = r8.charAt(r1)
            r4 = 199(0xc7, float:2.79E-43)
            if (r3 == r4) goto L_0x00f0
            r4 = 209(0xd1, float:2.93E-43)
            r5 = 78
            if (r3 == r4) goto L_0x00ec
            r4 = 75
            r6 = 70
            switch(r3) {
                case 65: goto L_0x00e6;
                case 66: goto L_0x00d5;
                case 67: goto L_0x00cf;
                case 68: goto L_0x00c9;
                case 69: goto L_0x00e6;
                case 70: goto L_0x00bd;
                case 71: goto L_0x00b7;
                case 72: goto L_0x00b1;
                case 73: goto L_0x00e6;
                case 74: goto L_0x00ab;
                case 75: goto L_0x009f;
                case 76: goto L_0x0099;
                case 77: goto L_0x008d;
                case 78: goto L_0x0081;
                case 79: goto L_0x00e6;
                case 80: goto L_0x007c;
                case 81: goto L_0x006e;
                case 82: goto L_0x0069;
                case 83: goto L_0x0064;
                case 84: goto L_0x005f;
                case 85: goto L_0x00e6;
                case 86: goto L_0x004d;
                case 87: goto L_0x0048;
                case 88: goto L_0x0043;
                case 89: goto L_0x00e6;
                case 90: goto L_0x003e;
                default: goto L_0x003c;
            }
        L_0x003c:
            goto L_0x00f5
        L_0x003e:
            int r1 = r7.m10717e(r8, r2, r1, r0)
            goto L_0x0019
        L_0x0043:
            int r1 = r7.m10727l(r8, r2, r1)
            goto L_0x0019
        L_0x0048:
            int r1 = r7.m10726k(r8, r2, r1)
            goto L_0x0019
        L_0x004d:
            r2.mo4124a((char) r6)
            int r3 = r1 + 1
            char r4 = r7.mo4116a((java.lang.String) r8, (int) r3)
            r5 = 86
            if (r4 != r5) goto L_0x005d
        L_0x005a:
            int r1 = r1 + 2
            goto L_0x0019
        L_0x005d:
            r1 = r3
            goto L_0x0019
        L_0x005f:
            int r1 = r7.m10725j(r8, r2, r1)
            goto L_0x0019
        L_0x0064:
            int r1 = r7.m10713d(r8, r2, r1, r0)
            goto L_0x0019
        L_0x0069:
            int r1 = r7.m10709c(r8, r2, r1, r0)
            goto L_0x0019
        L_0x006e:
            r2.mo4124a((char) r4)
            int r3 = r1 + 1
            char r4 = r7.mo4116a((java.lang.String) r8, (int) r3)
            r5 = 81
            if (r4 != r5) goto L_0x005d
            goto L_0x005a
        L_0x007c:
            int r1 = r7.m10723h(r8, r2, r1)
            goto L_0x0019
        L_0x0081:
            r2.mo4124a((char) r5)
            int r3 = r1 + 1
            char r4 = r7.mo4116a((java.lang.String) r8, (int) r3)
            if (r4 != r5) goto L_0x005d
            goto L_0x005a
        L_0x008d:
            r3 = 77
            r2.mo4124a((char) r3)
            boolean r3 = r7.m10721f(r8, r1)
            if (r3 == 0) goto L_0x00f5
            goto L_0x005a
        L_0x0099:
            int r1 = r7.m10722g(r8, r2, r1)
            goto L_0x0019
        L_0x009f:
            r2.mo4124a((char) r4)
            int r3 = r1 + 1
            char r5 = r7.mo4116a((java.lang.String) r8, (int) r3)
            if (r5 != r4) goto L_0x005d
            goto L_0x005a
        L_0x00ab:
            int r1 = r7.m10706b(r8, r2, r1, r0)
            goto L_0x0019
        L_0x00b1:
            int r1 = r7.m10720f(r8, r2, r1)
            goto L_0x0019
        L_0x00b7:
            int r1 = r7.m10696a((java.lang.String) r8, (atakplugin.UASTool.byz.C0288a) r2, (int) r1, (boolean) r0)
            goto L_0x0019
        L_0x00bd:
            r2.mo4124a((char) r6)
            int r3 = r1 + 1
            char r4 = r7.mo4116a((java.lang.String) r8, (int) r3)
            if (r4 != r6) goto L_0x005d
            goto L_0x005a
        L_0x00c9:
            int r1 = r7.m10712d(r8, r2, r1)
            goto L_0x0019
        L_0x00cf:
            int r1 = r7.m10695a((java.lang.String) r8, (atakplugin.UASTool.byz.C0288a) r2, (int) r1)
            goto L_0x0019
        L_0x00d5:
            r3 = 80
            r2.mo4124a((char) r3)
            int r3 = r1 + 1
            char r4 = r7.mo4116a((java.lang.String) r8, (int) r3)
            r5 = 66
            if (r4 != r5) goto L_0x005d
            goto L_0x005a
        L_0x00e6:
            int r1 = r7.m10694a((atakplugin.UASTool.byz.C0288a) r2, (int) r1)
            goto L_0x0019
        L_0x00ec:
            r2.mo4124a((char) r5)
            goto L_0x00f5
        L_0x00f0:
            r3 = 83
            r2.mo4124a((char) r3)
        L_0x00f5:
            int r1 = r1 + 1
            goto L_0x0019
        L_0x00f9:
            if (r9 == 0) goto L_0x0100
            java.lang.String r8 = r2.mo4128b()
            goto L_0x0104
        L_0x0100:
            java.lang.String r8 = r2.mo4123a()
        L_0x0104:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.byz.mo4119a(java.lang.String, boolean):java.lang.String");
    }

    /* renamed from: b */
    public Object mo4073b(Object obj) {
        if (obj instanceof String) {
            return mo4118a((String) obj);
        }
        throw new byd("DoubleMetaphone encode parameter is not of type String");
    }

    /* renamed from: b */
    public String mo4075b(String str) {
        return mo4118a(str);
    }

    /* renamed from: a */
    public boolean mo4121a(String str, String str2) {
        return mo4122a(str, str2, false);
    }

    /* renamed from: a */
    public boolean mo4122a(String str, String str2, boolean z) {
        return mo4119a(str, z).equals(mo4119a(str2, z));
    }

    /* renamed from: a */
    public int mo4117a() {
        return this.f4322f;
    }

    /* renamed from: a */
    public void mo4120a(int i) {
        this.f4322f = i;
    }

    /* renamed from: a */
    private int m10694a(C0288a aVar, int i) {
        if (i == 0) {
            aVar.mo4124a('A');
        }
        return i + 1;
    }

    /* renamed from: a */
    private int m10695a(String str, C0288a aVar, int i) {
        String str2 = str;
        C0288a aVar2 = aVar;
        int i2 = i;
        if (m10707b(str2, i2)) {
            aVar2.mo4124a('K');
        } else if (i2 == 0 && m10698a(str2, i2, 6, "CAESAR")) {
            aVar2.mo4124a('S');
        } else if (m10698a(str2, i2, 2, "CH")) {
            return m10708c(str, aVar, i);
        } else {
            if (!m10698a(str2, i2, 2, "CZ") || m10698a(str2, i2 - 2, 4, "WICZ")) {
                int i3 = i2 + 1;
                if (m10698a(str2, i3, 3, "CIA")) {
                    aVar2.mo4124a('X');
                } else if (m10698a(str2, i2, 2, "CC") && (i2 != 1 || mo4116a(str2, 0) != 'M')) {
                    return m10705b(str, aVar, i);
                } else {
                    if (m10700a(str, i, 2, "CK", "CG", "CQ")) {
                        aVar2.mo4124a('K');
                    } else if (!m10700a(str, i, 2, "CI", "CE", "CY")) {
                        aVar2.mo4124a('K');
                        if (!m10700a(str, i3, 2, " C", " Q", " G")) {
                            if (!m10700a(str, i3, 1, "C", "K", "Q") || m10699a(str2, i3, 2, "CE", "CI")) {
                                return i3;
                            }
                        }
                    } else if (m10700a(str, i, 3, "CIO", "CIE", "CIA")) {
                        aVar2.mo4125a('S', 'X');
                    } else {
                        aVar2.mo4124a('S');
                    }
                }
                return i2 + 3;
            }
            aVar2.mo4125a('S', 'X');
        }
        return i2 + 2;
    }

    /* renamed from: b */
    private int m10705b(String str, C0288a aVar, int i) {
        int i2 = i + 2;
        if (!m10700a(str, i2, 1, "I", "E", "H") || m10698a(str, i2, 2, "HU")) {
            aVar.mo4124a('K');
            return i2;
        }
        if (!(i == 1 && mo4116a(str, i - 1) == 'A') && !m10699a(str, i - 1, 5, "UCCEE", "UCCES")) {
            aVar.mo4124a('X');
        } else {
            aVar.mo4126a("KS");
        }
        return i + 3;
    }

    /* renamed from: c */
    private int m10708c(String str, C0288a aVar, int i) {
        if (i > 0 && m10698a(str, i, 4, "CHAE")) {
            aVar.mo4125a('K', 'X');
        } else if (m10711c(str, i)) {
            aVar.mo4124a('K');
        } else if (m10715d(str, i)) {
            aVar.mo4124a('K');
        } else {
            if (i <= 0) {
                aVar.mo4124a('X');
            } else if (m10698a(str, 0, 2, "MC")) {
                aVar.mo4124a('K');
            } else {
                aVar.mo4125a('X', 'K');
            }
            return i + 2;
        }
        return i + 2;
    }

    /* renamed from: d */
    private int m10712d(String str, C0288a aVar, int i) {
        if (m10698a(str, i, 2, "DG")) {
            int i2 = i + 2;
            if (m10700a(str, i2, 1, "I", "E", CameraParamsConfig.param_Y)) {
                aVar.mo4124a('J');
                return i + 3;
            }
            aVar.mo4126a("TK");
            return i2;
        } else if (m10699a(str, i, 2, "DT", "DD")) {
            aVar.mo4124a('T');
            return 2 + i;
        } else {
            aVar.mo4124a('T');
            return i + 1;
        }
    }

    /* renamed from: a */
    private int m10696a(String str, C0288a aVar, int i, boolean z) {
        int i2;
        String str2 = str;
        C0288a aVar2 = aVar;
        int i3 = i;
        int i4 = i3 + 1;
        if (mo4116a(str2, i4) == 'H') {
            return m10716e(str, aVar, i);
        }
        if (mo4116a(str2, i4) == 'N') {
            if (i3 == 1 && m10697a(mo4116a(str2, 0)) && !z) {
                aVar2.mo4127a("KN", "N");
            } else if (m10698a(str2, i3 + 2, 2, "EY") || mo4116a(str2, i4) == 'Y' || z) {
                aVar2.mo4126a("KN");
            } else {
                aVar2.mo4127a("N", "KN");
            }
        } else if (m10698a(str2, i4, 2, "LI") && !z) {
            aVar2.mo4127a("KL", "L");
        } else if (i3 != 0 || (mo4116a(str2, i4) != 'Y' && !m10704a(str2, i4, 2, f4320d))) {
            if (m10698a(str2, i4, 2, "ER") || mo4116a(str2, i4) == 'Y') {
                i2 = 3;
                if (!m10700a(str, 0, 6, "DANGER", "RANGER", "MANGER")) {
                    int i5 = i3 - 1;
                    if (!m10699a(str2, i5, 1, "E", "I") && !m10699a(str2, i5, 3, "RGY", "OGY")) {
                        aVar2.mo4125a('K', 'J');
                    }
                }
            } else {
                i2 = 3;
            }
            if (m10700a(str, i4, 1, "E", "I", CameraParamsConfig.param_Y) || m10699a(str2, i3 - 1, 4, "AGGI", "OGGI")) {
                if (m10699a(str2, 0, 4, "VAN ", "VON ") || m10698a(str2, 0, i2, "SCH") || m10698a(str2, i4, 2, "ET")) {
                    aVar2.mo4124a('K');
                } else if (m10698a(str2, i4, i2, "IER")) {
                    aVar2.mo4124a('J');
                } else {
                    aVar2.mo4125a('J', 'K');
                }
            } else if (mo4116a(str2, i4) == 'G') {
                int i6 = i3 + 2;
                aVar2.mo4124a('K');
                return i6;
            } else {
                aVar2.mo4124a('K');
                return i4;
            }
        } else {
            aVar2.mo4125a('K', 'J');
        }
        return i3 + 2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0049, code lost:
        if (m10700a(r16, r11 - 2, 1, "B", "H", "D") == false) goto L_0x004b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x005c, code lost:
        if (m10700a(r16, r11 - 3, 1, "B", "H", "D") == false) goto L_0x005e;
     */
    /* renamed from: e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int m10716e(java.lang.String r16, atakplugin.UASTool.byz.C0288a r17, int r18) {
        /*
            r15 = this;
            r0 = r15
            r9 = r16
            r10 = r17
            r11 = r18
            r12 = 75
            r13 = 2
            if (r11 <= 0) goto L_0x001f
            int r1 = r11 + -1
            char r1 = r15.mo4116a((java.lang.String) r9, (int) r1)
            boolean r1 = r15.m10697a((char) r1)
            if (r1 != 0) goto L_0x001f
            r10.mo4124a((char) r12)
        L_0x001b:
            int r1 = r11 + 2
            goto L_0x00a4
        L_0x001f:
            r14 = 73
            if (r11 != 0) goto L_0x0037
            int r1 = r11 + 2
            char r2 = r15.mo4116a((java.lang.String) r9, (int) r1)
            if (r2 != r14) goto L_0x0032
            r2 = 74
            r10.mo4124a((char) r2)
            goto L_0x00a4
        L_0x0032:
            r10.mo4124a((char) r12)
            goto L_0x00a4
        L_0x0037:
            r7 = 1
            if (r11 <= r7) goto L_0x004b
            int r2 = r11 + -2
            r3 = 1
            java.lang.String r4 = "B"
            java.lang.String r5 = "H"
            java.lang.String r6 = "D"
            r1 = r16
            boolean r1 = m10700a(r1, r2, r3, r4, r5, r6)
            if (r1 != 0) goto L_0x001b
        L_0x004b:
            if (r11 <= r13) goto L_0x005e
            int r2 = r11 + -3
            r3 = 1
            java.lang.String r4 = "B"
            java.lang.String r5 = "H"
            java.lang.String r6 = "D"
            r1 = r16
            boolean r1 = m10700a(r1, r2, r3, r4, r5, r6)
            if (r1 != 0) goto L_0x001b
        L_0x005e:
            r1 = 3
            if (r11 <= r1) goto L_0x006e
            int r1 = r11 + -4
            java.lang.String r2 = "B"
            java.lang.String r3 = "H"
            boolean r1 = m10699a(r9, r1, r7, r2, r3)
            if (r1 == 0) goto L_0x006e
            goto L_0x001b
        L_0x006e:
            if (r11 <= r13) goto L_0x0095
            int r1 = r11 + -1
            char r1 = r15.mo4116a((java.lang.String) r9, (int) r1)
            r2 = 85
            if (r1 != r2) goto L_0x0095
            int r2 = r11 + -3
            r3 = 1
            java.lang.String r4 = "C"
            java.lang.String r5 = "G"
            java.lang.String r6 = "L"
            java.lang.String r7 = "R"
            java.lang.String r8 = "T"
            r1 = r16
            boolean r1 = m10702a(r1, r2, r3, r4, r5, r6, r7, r8)
            if (r1 == 0) goto L_0x0095
            r1 = 70
            r10.mo4124a((char) r1)
            goto L_0x001b
        L_0x0095:
            if (r11 <= 0) goto L_0x001b
            int r1 = r11 + -1
            char r1 = r15.mo4116a((java.lang.String) r9, (int) r1)
            if (r1 == r14) goto L_0x001b
            r10.mo4124a((char) r12)
            goto L_0x001b
        L_0x00a4:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.byz.m10716e(java.lang.String, atakplugin.UASTool.byz$a, int):int");
    }

    /* renamed from: f */
    private int m10720f(String str, C0288a aVar, int i) {
        if ((i != 0 && !m10697a(mo4116a(str, i - 1))) || !m10697a(mo4116a(str, i + 1))) {
            return i + 1;
        }
        aVar.mo4124a('H');
        return i + 2;
    }

    /* renamed from: b */
    private int m10706b(String str, C0288a aVar, int i, boolean z) {
        String str2 = str;
        C0288a aVar2 = aVar;
        int i2 = i;
        if (m10698a(str, i2, 4, "JOSE") || m10698a(str, 0, 4, "SAN ")) {
            if ((i2 == 0 && mo4116a(str, i2 + 4) == ' ') || str.length() == 4 || m10698a(str, 0, 4, "SAN ")) {
                aVar.mo4124a('H');
            } else {
                aVar.mo4125a('J', 'H');
            }
            return i2 + 1;
        }
        if (i2 != 0 || m10698a(str, i2, 4, "JOSE")) {
            int i3 = i2 - 1;
            if (m10697a(mo4116a(str, i3)) && !z) {
                int i4 = i2 + 1;
                if (mo4116a(str, i4) == 'A' || mo4116a(str, i4) == 'O') {
                    aVar.mo4125a('J', 'H');
                }
            }
            if (i2 == str.length() - 1) {
                aVar.mo4125a('J', ' ');
            } else if (!m10704a(str, i2 + 1, 1, f4321e) && !m10700a(str, i3, 1, "S", "K", "L")) {
                aVar.mo4124a('J');
            }
        } else {
            aVar.mo4125a('J', 'A');
        }
        int i5 = i2 + 1;
        if (mo4116a(str, i5) == 'J') {
            return i2 + 2;
        }
        return i5;
    }

    /* renamed from: g */
    private int m10722g(String str, C0288a aVar, int i) {
        int i2 = i + 1;
        if (mo4116a(str, i2) == 'L') {
            if (m10719e(str, i)) {
                aVar.mo4129b('L');
            } else {
                aVar.mo4124a('L');
            }
            return i + 2;
        }
        aVar.mo4124a('L');
        return i2;
    }

    /* renamed from: h */
    private int m10723h(String str, C0288a aVar, int i) {
        int i2 = i + 1;
        if (mo4116a(str, i2) == 'H') {
            aVar.mo4124a('F');
            return i + 2;
        }
        aVar.mo4124a('P');
        if (m10699a(str, i2, 1, "P", "B")) {
            i2 = i + 2;
        }
        return i2;
    }

    /* renamed from: c */
    private int m10709c(String str, C0288a aVar, int i, boolean z) {
        if (i != str.length() - 1 || z || !m10698a(str, i - 2, 2, "IE") || m10699a(str, i - 4, 2, "ME", "MA")) {
            aVar.mo4124a('R');
        } else {
            aVar.mo4131c('R');
        }
        int i2 = i + 1;
        return mo4116a(str, i2) == 'R' ? i + 2 : i2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x007b, code lost:
        if (m10701a(r16, r9 + 1, 1, "M", "N", "L", "W") == false) goto L_0x007d;
     */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int m10713d(java.lang.String r16, atakplugin.UASTool.byz.C0288a r17, int r18, boolean r19) {
        /*
            r15 = this;
            r7 = r16
            r8 = r17
            r9 = r18
            int r0 = r9 + -1
            r1 = 3
            java.lang.String r2 = "ISL"
            java.lang.String r3 = "YSL"
            boolean r0 = m10699a(r7, r0, r1, r2, r3)
            r10 = 1
            if (r0 == 0) goto L_0x0018
        L_0x0014:
            int r0 = r9 + 1
            goto L_0x00cc
        L_0x0018:
            r11 = 88
            r12 = 83
            if (r9 != 0) goto L_0x002b
            r0 = 5
            java.lang.String r2 = "SUGAR"
            boolean r0 = m10698a((java.lang.String) r7, (int) r9, (int) r0, (java.lang.String) r2)
            if (r0 == 0) goto L_0x002b
            r8.mo4125a((char) r11, (char) r12)
            goto L_0x0014
        L_0x002b:
            r13 = 2
            java.lang.String r0 = "SH"
            boolean r0 = m10698a((java.lang.String) r7, (int) r9, (int) r13, (java.lang.String) r0)
            if (r0 == 0) goto L_0x0052
            int r1 = r9 + 1
            r2 = 4
            java.lang.String r3 = "HEIM"
            java.lang.String r4 = "HOEK"
            java.lang.String r5 = "HOLM"
            java.lang.String r6 = "HOLZ"
            r0 = r16
            boolean r0 = m10701a(r0, r1, r2, r3, r4, r5, r6)
            if (r0 == 0) goto L_0x004b
            r8.mo4124a((char) r12)
            goto L_0x004e
        L_0x004b:
            r8.mo4124a((char) r11)
        L_0x004e:
            int r0 = r9 + 2
            goto L_0x00cc
        L_0x0052:
            java.lang.String r0 = "SIO"
            java.lang.String r2 = "SIA"
            boolean r0 = m10699a(r7, r9, r1, r0, r2)
            if (r0 != 0) goto L_0x00c1
            r0 = 4
            java.lang.String r2 = "SIAN"
            boolean r0 = m10698a((java.lang.String) r7, (int) r9, (int) r0, (java.lang.String) r2)
            if (r0 == 0) goto L_0x0066
            goto L_0x00c1
        L_0x0066:
            java.lang.String r14 = "Z"
            if (r9 != 0) goto L_0x007d
            int r1 = r9 + 1
            r2 = 1
            java.lang.String r3 = "M"
            java.lang.String r4 = "N"
            java.lang.String r5 = "L"
            java.lang.String r6 = "W"
            r0 = r16
            boolean r0 = m10701a(r0, r1, r2, r3, r4, r5, r6)
            if (r0 != 0) goto L_0x0085
        L_0x007d:
            int r0 = r9 + 1
            boolean r1 = m10698a((java.lang.String) r7, (int) r0, (int) r10, (java.lang.String) r14)
            if (r1 == 0) goto L_0x0091
        L_0x0085:
            r8.mo4125a((char) r12, (char) r11)
            int r0 = r9 + 1
            boolean r1 = m10698a((java.lang.String) r7, (int) r0, (int) r10, (java.lang.String) r14)
            if (r1 == 0) goto L_0x00cc
            goto L_0x004e
        L_0x0091:
            java.lang.String r1 = "SC"
            boolean r1 = m10698a((java.lang.String) r7, (int) r9, (int) r13, (java.lang.String) r1)
            if (r1 == 0) goto L_0x009e
            int r0 = r15.m10724i(r16, r17, r18)
            goto L_0x00cc
        L_0x009e:
            int r1 = r16.length()
            int r1 = r1 - r10
            if (r9 != r1) goto L_0x00b5
            int r1 = r9 + -2
            java.lang.String r2 = "AI"
            java.lang.String r3 = "OI"
            boolean r1 = m10699a(r7, r1, r13, r2, r3)
            if (r1 == 0) goto L_0x00b5
            r8.mo4131c((char) r12)
            goto L_0x00b8
        L_0x00b5:
            r8.mo4124a((char) r12)
        L_0x00b8:
            java.lang.String r1 = "S"
            boolean r1 = m10699a(r7, r0, r10, r1, r14)
            if (r1 == 0) goto L_0x00cc
            goto L_0x004e
        L_0x00c1:
            if (r19 == 0) goto L_0x00c7
            r8.mo4124a((char) r12)
            goto L_0x00ca
        L_0x00c7:
            r8.mo4125a((char) r12, (char) r11)
        L_0x00ca:
            int r0 = r9 + 3
        L_0x00cc:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.byz.m10713d(java.lang.String, atakplugin.UASTool.byz$a, int, boolean):int");
    }

    /* renamed from: i */
    private int m10724i(String str, C0288a aVar, int i) {
        String str2 = str;
        C0288a aVar2 = aVar;
        int i2 = i + 2;
        if (mo4116a(str2, i2) == 'H') {
            int i3 = i + 3;
            if (m10703a(str, i3, 2, "OO", "ER", "EN", "UY", "ED", "EM")) {
                if (m10699a(str2, i3, 2, "ER", "EN")) {
                    aVar2.mo4127a(CameraParamsConfig.param_X, "SK");
                } else {
                    aVar2.mo4126a("SK");
                }
            } else if (i != 0 || m10697a(mo4116a(str2, 3)) || mo4116a(str2, 3) == 'W') {
                aVar2.mo4124a('X');
            } else {
                aVar2.mo4125a('X', 'S');
            }
        } else if (m10700a(str, i2, 1, "I", "E", CameraParamsConfig.param_Y)) {
            aVar2.mo4124a('S');
        } else {
            aVar2.mo4126a("SK");
        }
        return i + 3;
    }

    /* renamed from: j */
    private int m10725j(String str, C0288a aVar, int i) {
        if (m10698a(str, i, 4, "TION")) {
            aVar.mo4124a('X');
        } else if (m10699a(str, i, 3, "TIA", "TCH")) {
            aVar.mo4124a('X');
        } else if (m10698a(str, i, 2, "TH") || m10698a(str, i, 3, "TTH")) {
            int i2 = i + 2;
            if (m10699a(str, i2, 2, "OM", "AM") || m10699a(str, 0, 4, "VAN ", "VON ") || m10698a(str, 0, 3, "SCH")) {
                aVar.mo4124a('T');
                return i2;
            }
            aVar.mo4125a('0', 'T');
            return i2;
        } else {
            aVar.mo4124a('T');
            int i3 = i + 1;
            return m10699a(str, i3, 1, "T", "D") ? i + 2 : i3;
        }
        return i + 3;
    }

    /* renamed from: k */
    private int m10726k(String str, C0288a aVar, int i) {
        int i2 = 2;
        if (m10698a(str, i, 2, "WR")) {
            aVar.mo4124a('R');
        } else {
            if (i == 0) {
                int i3 = i + 1;
                if (m10697a(mo4116a(str, i3)) || m10698a(str, i, 2, "WH")) {
                    if (m10697a(mo4116a(str, i3))) {
                        aVar.mo4125a('A', 'F');
                    } else {
                        aVar.mo4124a('A');
                    }
                    return i3;
                }
            }
            if (i != str.length() - 1 || !m10697a(mo4116a(str, i - 1))) {
                if (!m10701a(str, i - 1, 5, "EWSKI", "EWSKY", "OWSKI", "OWSKY") && !m10698a(str, 0, 3, "SCH")) {
                    i2 = 4;
                    if (m10699a(str, i, 4, "WICZ", "WITZ")) {
                        aVar.mo4127a("TS", "FX");
                    }
                    return i + 1;
                }
            }
            aVar.mo4131c('F');
            return i + 1;
        }
        return i + i2;
    }

    /* renamed from: l */
    private int m10727l(String str, C0288a aVar, int i) {
        if (i == 0) {
            aVar.mo4124a('S');
            return i + 1;
        }
        if (i != str.length() - 1 || (!m10699a(str, i - 3, 3, "IAU", "EAU") && !m10699a(str, i - 2, 2, "AU", "OU"))) {
            aVar.mo4126a("KS");
        }
        int i2 = i + 1;
        return m10699a(str, i2, 1, "C", CameraParamsConfig.param_X) ? i + 2 : i2;
    }

    /* renamed from: e */
    private int m10717e(String str, C0288a aVar, int i, boolean z) {
        int i2 = i + 1;
        if (mo4116a(str, i2) == 'H') {
            aVar.mo4124a('J');
            return i + 2;
        }
        if (m10700a(str, i2, 2, "ZO", "ZI", "ZA") || (z && i > 0 && mo4116a(str, i - 1) != 'T')) {
            aVar.mo4127a("S", "TS");
        } else {
            aVar.mo4124a('S');
        }
        if (mo4116a(str, i2) == 'Z') {
            i2 = i + 2;
        }
        return i2;
    }

    /* renamed from: b */
    private boolean m10707b(String str, int i) {
        if (m10698a(str, i, 4, "CHIA")) {
            return true;
        }
        if (i <= 1) {
            return false;
        }
        int i2 = i - 2;
        if (m10697a(mo4116a(str, i2)) || !m10698a(str, i - 1, 3, "ACH")) {
            return false;
        }
        char a = mo4116a(str, i + 2);
        if ((a == 'I' || a == 'E') && !m10699a(str, i2, 6, "BACHER", "MACHER")) {
            return false;
        }
        return true;
    }

    /* renamed from: c */
    private boolean m10711c(String str, int i) {
        if (i != 0) {
            return false;
        }
        int i2 = i + 1;
        return (m10699a(str, i2, 5, "HARAC", "HARIS") || m10701a(str, i2, 3, "HOR", "HYM", "HIA", "HEM")) && !m10698a(str, 0, 5, "CHORE");
    }

    /* renamed from: d */
    private boolean m10715d(String str, int i) {
        if (!m10699a(str, 0, 4, "VAN ", "VON ") && !m10698a(str, 0, 3, "SCH")) {
            if (!m10700a(str, i - 2, 6, "ORCHES", "ARCHIT", "ORCHID")) {
                int i2 = i + 2;
                if (!m10699a(str, i2, 1, "T", "S")) {
                    if (m10701a(str, i - 1, 1, "A", "O", "U", "E") || i == 0) {
                        return m10704a(str, i2, 1, f4319c) || i + 1 == str.length() - 1;
                    }
                    return false;
                }
            }
        }
    }

    /* renamed from: e */
    private boolean m10719e(String str, int i) {
        if (i == str.length() - 3) {
            if (m10700a(str, i - 1, 4, "ILLO", "ILLA", "ALLE")) {
                return true;
            }
        }
        if ((m10699a(str, str.length() - 2, 2, "AS", "OS") || m10699a(str, str.length() - 1, 1, "A", "O")) && m10698a(str, i - 1, 4, "ALLE")) {
            return true;
        }
        return false;
    }

    /* renamed from: f */
    private boolean m10721f(String str, int i) {
        int i2 = i + 1;
        if (mo4116a(str, i2) == 'M') {
            return true;
        }
        if (!m10698a(str, i - 1, 3, "UMB") || (i2 != str.length() - 1 && !m10698a(str, i + 2, 2, "ER"))) {
            return false;
        }
        return true;
    }

    /* renamed from: c */
    private boolean m10710c(String str) {
        return str.indexOf(87) > -1 || str.indexOf(75) > -1 || str.indexOf("CZ") > -1 || str.indexOf("WITZ") > -1;
    }

    /* renamed from: a */
    private boolean m10697a(char c) {
        return f4317a.indexOf(c) != -1;
    }

    /* renamed from: d */
    private boolean m10714d(String str) {
        int i = 0;
        while (true) {
            String[] strArr = f4318b;
            if (i >= strArr.length) {
                return false;
            }
            if (str.startsWith(strArr[i])) {
                return true;
            }
            i++;
        }
    }

    /* renamed from: e */
    private String m10718e(String str) {
        if (str == null) {
            return null;
        }
        String trim = str.trim();
        if (trim.length() == 0) {
            return null;
        }
        return trim.toUpperCase(Locale.ENGLISH);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public char mo4116a(String str, int i) {
        if (i < 0 || i >= str.length()) {
            return 0;
        }
        return str.charAt(i);
    }

    /* renamed from: a */
    private static boolean m10698a(String str, int i, int i2, String str2) {
        return m10704a(str, i, i2, new String[]{str2});
    }

    /* renamed from: a */
    private static boolean m10699a(String str, int i, int i2, String str2, String str3) {
        return m10704a(str, i, i2, new String[]{str2, str3});
    }

    /* renamed from: a */
    private static boolean m10700a(String str, int i, int i2, String str2, String str3, String str4) {
        return m10704a(str, i, i2, new String[]{str2, str3, str4});
    }

    /* renamed from: a */
    private static boolean m10701a(String str, int i, int i2, String str2, String str3, String str4, String str5) {
        return m10704a(str, i, i2, new String[]{str2, str3, str4, str5});
    }

    /* renamed from: a */
    private static boolean m10702a(String str, int i, int i2, String str2, String str3, String str4, String str5, String str6) {
        return m10704a(str, i, i2, new String[]{str2, str3, str4, str5, str6});
    }

    /* renamed from: a */
    private static boolean m10703a(String str, int i, int i2, String str2, String str3, String str4, String str5, String str6, String str7) {
        return m10704a(str, i, i2, new String[]{str2, str3, str4, str5, str6, str7});
    }

    /* renamed from: a */
    protected static boolean m10704a(String str, int i, int i2, String[] strArr) {
        int i3;
        if (i < 0 || (i3 = i2 + i) > str.length()) {
            return false;
        }
        String substring = str.substring(i, i3);
        for (String equals : strArr) {
            if (substring.equals(equals)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: atakplugin.UASTool.byz$a */
    public class C0288a {

        /* renamed from: a */
        private StringBuffer f4323a;

        /* renamed from: b */
        private StringBuffer f4324b;

        /* renamed from: c */
        private int f4325c;

        /* renamed from: d */
        private final byz f4326d;

        public C0288a(byz byz, int i) {
            this.f4326d = byz;
            this.f4323a = new StringBuffer(byz.mo4117a());
            this.f4324b = new StringBuffer(byz.mo4117a());
            this.f4325c = i;
        }

        /* renamed from: a */
        public void mo4124a(char c) {
            mo4129b(c);
            mo4131c(c);
        }

        /* renamed from: a */
        public void mo4125a(char c, char c2) {
            mo4129b(c);
            mo4131c(c2);
        }

        /* renamed from: b */
        public void mo4129b(char c) {
            if (this.f4323a.length() < this.f4325c) {
                this.f4323a.append(c);
            }
        }

        /* renamed from: c */
        public void mo4131c(char c) {
            if (this.f4324b.length() < this.f4325c) {
                this.f4324b.append(c);
            }
        }

        /* renamed from: a */
        public void mo4126a(String str) {
            mo4130b(str);
            mo4132c(str);
        }

        /* renamed from: a */
        public void mo4127a(String str, String str2) {
            mo4130b(str);
            mo4132c(str2);
        }

        /* renamed from: b */
        public void mo4130b(String str) {
            int length = this.f4325c - this.f4323a.length();
            if (str.length() <= length) {
                this.f4323a.append(str);
            } else {
                this.f4323a.append(str.substring(0, length));
            }
        }

        /* renamed from: c */
        public void mo4132c(String str) {
            int length = this.f4325c - this.f4324b.length();
            if (str.length() <= length) {
                this.f4324b.append(str);
            } else {
                this.f4324b.append(str.substring(0, length));
            }
        }

        /* renamed from: a */
        public String mo4123a() {
            return this.f4323a.toString();
        }

        /* renamed from: b */
        public String mo4128b() {
            return this.f4324b.toString();
        }

        /* renamed from: c */
        public boolean mo4133c() {
            return this.f4323a.length() >= this.f4325c && this.f4324b.length() >= this.f4325c;
        }
    }
}
