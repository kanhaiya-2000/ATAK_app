package atakplugin.UASTool;

import com.MAVLink.Messages.ardupilotmega.msg_roll_pitch_yaw_speed_thrust_setpoint;
import javax.security.auth.x500.X500Principal;

final class bvs {

    /* renamed from: a */
    private final String f4071a;

    /* renamed from: b */
    private final int f4072b;

    /* renamed from: c */
    private int f4073c;

    /* renamed from: d */
    private int f4074d;

    /* renamed from: e */
    private int f4075e;

    /* renamed from: f */
    private int f4076f;

    /* renamed from: g */
    private char[] f4077g;

    public bvs(X500Principal x500Principal) {
        String name = x500Principal.getName("RFC2253");
        this.f4071a = name;
        this.f4072b = name.length();
    }

    /* JADX WARNING: Removed duplicated region for block: B:6:0x0015 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x0017  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String m9887a() {
        /*
            r7 = this;
        L_0x0000:
            int r0 = r7.f4073c
            int r1 = r7.f4072b
            r2 = 32
            if (r0 >= r1) goto L_0x0013
            char[] r3 = r7.f4077g
            char r3 = r3[r0]
            if (r3 != r2) goto L_0x0013
            int r0 = r0 + 1
            r7.f4073c = r0
            goto L_0x0000
        L_0x0013:
            if (r0 != r1) goto L_0x0017
            r0 = 0
            return r0
        L_0x0017:
            r7.f4074d = r0
            int r0 = r0 + 1
            r7.f4073c = r0
        L_0x001d:
            int r0 = r7.f4073c
            int r1 = r7.f4072b
            r3 = 61
            if (r0 >= r1) goto L_0x0034
            char[] r4 = r7.f4077g
            char r5 = r4[r0]
            if (r5 == r3) goto L_0x0034
            char r4 = r4[r0]
            if (r4 == r2) goto L_0x0034
            int r0 = r0 + 1
            r7.f4073c = r0
            goto L_0x001d
        L_0x0034:
            java.lang.String r4 = "Unexpected end of DN: "
            if (r0 >= r1) goto L_0x00da
            r7.f4075e = r0
            char[] r1 = r7.f4077g
            char r0 = r1[r0]
            if (r0 != r2) goto L_0x0075
        L_0x0040:
            int r0 = r7.f4073c
            int r1 = r7.f4072b
            if (r0 >= r1) goto L_0x0055
            char[] r5 = r7.f4077g
            char r6 = r5[r0]
            if (r6 == r3) goto L_0x0055
            char r5 = r5[r0]
            if (r5 != r2) goto L_0x0055
            int r0 = r0 + 1
            r7.f4073c = r0
            goto L_0x0040
        L_0x0055:
            char[] r5 = r7.f4077g
            char r5 = r5[r0]
            if (r5 != r3) goto L_0x005e
            if (r0 == r1) goto L_0x005e
            goto L_0x0075
        L_0x005e:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r4)
            java.lang.String r2 = r7.f4071a
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0075:
            int r0 = r7.f4073c
            int r0 = r0 + 1
            r7.f4073c = r0
        L_0x007b:
            int r0 = r7.f4073c
            int r1 = r7.f4072b
            if (r0 >= r1) goto L_0x008c
            char[] r1 = r7.f4077g
            char r1 = r1[r0]
            if (r1 != r2) goto L_0x008c
            int r0 = r0 + 1
            r7.f4073c = r0
            goto L_0x007b
        L_0x008c:
            int r0 = r7.f4075e
            int r1 = r7.f4074d
            int r0 = r0 - r1
            r2 = 4
            if (r0 <= r2) goto L_0x00cd
            char[] r0 = r7.f4077g
            int r3 = r1 + 3
            char r3 = r0[r3]
            r4 = 46
            if (r3 != r4) goto L_0x00cd
            char r3 = r0[r1]
            r4 = 79
            if (r3 == r4) goto L_0x00aa
            char r3 = r0[r1]
            r4 = 111(0x6f, float:1.56E-43)
            if (r3 != r4) goto L_0x00cd
        L_0x00aa:
            int r3 = r1 + 1
            char r3 = r0[r3]
            r4 = 73
            if (r3 == r4) goto L_0x00ba
            int r3 = r1 + 1
            char r3 = r0[r3]
            r4 = 105(0x69, float:1.47E-43)
            if (r3 != r4) goto L_0x00cd
        L_0x00ba:
            int r3 = r1 + 2
            char r3 = r0[r3]
            r4 = 68
            if (r3 == r4) goto L_0x00ca
            int r3 = r1 + 2
            char r0 = r0[r3]
            r3 = 100
            if (r0 != r3) goto L_0x00cd
        L_0x00ca:
            int r1 = r1 + r2
            r7.f4074d = r1
        L_0x00cd:
            java.lang.String r0 = new java.lang.String
            char[] r1 = r7.f4077g
            int r2 = r7.f4074d
            int r3 = r7.f4075e
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        L_0x00da:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r4)
            java.lang.String r2 = r7.f4071a
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.bvs.m9887a():java.lang.String");
    }

    /* renamed from: b */
    private String m9888b() {
        int i = this.f4073c + 1;
        this.f4073c = i;
        this.f4074d = i;
        this.f4075e = i;
        while (true) {
            int i2 = this.f4073c;
            if (i2 != this.f4072b) {
                char[] cArr = this.f4077g;
                if (cArr[i2] == '\"') {
                    this.f4073c = i2 + 1;
                    while (true) {
                        int i3 = this.f4073c;
                        if (i3 >= this.f4072b || this.f4077g[i3] != ' ') {
                            char[] cArr2 = this.f4077g;
                            int i4 = this.f4074d;
                        } else {
                            this.f4073c = i3 + 1;
                        }
                    }
                    char[] cArr22 = this.f4077g;
                    int i42 = this.f4074d;
                    return new String(cArr22, i42, this.f4075e - i42);
                }
                if (cArr[i2] == '\\') {
                    cArr[this.f4075e] = m9891e();
                } else {
                    cArr[this.f4075e] = cArr[i2];
                }
                this.f4073c++;
                this.f4075e++;
            } else {
                throw new IllegalStateException("Unexpected end of DN: " + this.f4071a);
            }
        }
    }

    /* renamed from: c */
    private String m9889c() {
        int i;
        int i2 = this.f4073c;
        if (i2 + 4 < this.f4072b) {
            this.f4074d = i2;
            this.f4073c = i2 + 1;
            while (true) {
                i = this.f4073c;
                if (i == this.f4072b) {
                    break;
                }
                char[] cArr = this.f4077g;
                if (cArr[i] == '+' || cArr[i] == ',' || cArr[i] == ';') {
                    break;
                } else if (cArr[i] == ' ') {
                    this.f4075e = i;
                    this.f4073c = i + 1;
                    while (true) {
                        int i3 = this.f4073c;
                        if (i3 >= this.f4072b || this.f4077g[i3] != ' ') {
                            break;
                        }
                        this.f4073c = i3 + 1;
                    }
                } else {
                    if (cArr[i] >= 'A' && cArr[i] <= 'F') {
                        cArr[i] = (char) (cArr[i] + ' ');
                    }
                    this.f4073c = i + 1;
                }
            }
            this.f4075e = i;
            int i4 = this.f4075e;
            int i5 = this.f4074d;
            int i6 = i4 - i5;
            if (i6 < 5 || (i6 & 1) == 0) {
                throw new IllegalStateException("Unexpected end of DN: " + this.f4071a);
            }
            int i7 = i6 / 2;
            byte[] bArr = new byte[i7];
            int i8 = i5 + 1;
            for (int i9 = 0; i9 < i7; i9++) {
                bArr[i9] = (byte) m9886a(i8);
                i8 += 2;
            }
            return new String(this.f4077g, this.f4074d, i6);
        }
        throw new IllegalStateException("Unexpected end of DN: " + this.f4071a);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0097, code lost:
        r1 = r8.f4077g;
        r2 = r8.f4074d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00a3, code lost:
        return new java.lang.String(r1, r2, r8.f4076f - r2);
     */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String m9890d() {
        /*
            r8 = this;
            int r0 = r8.f4073c
            r8.f4074d = r0
            r8.f4075e = r0
        L_0x0006:
            int r0 = r8.f4073c
            int r1 = r8.f4072b
            if (r0 < r1) goto L_0x0019
            java.lang.String r0 = new java.lang.String
            char[] r1 = r8.f4077g
            int r2 = r8.f4074d
            int r3 = r8.f4075e
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        L_0x0019:
            char[] r1 = r8.f4077g
            char r2 = r1[r0]
            r3 = 44
            r4 = 43
            r5 = 59
            r6 = 32
            if (r2 == r6) goto L_0x0060
            if (r2 == r5) goto L_0x0053
            r5 = 92
            if (r2 == r5) goto L_0x0040
            if (r2 == r4) goto L_0x0053
            if (r2 == r3) goto L_0x0053
            int r2 = r8.f4075e
            int r3 = r2 + 1
            r8.f4075e = r3
            char r3 = r1[r0]
            r1[r2] = r3
            int r0 = r0 + 1
            r8.f4073c = r0
            goto L_0x0006
        L_0x0040:
            int r0 = r8.f4075e
            int r2 = r0 + 1
            r8.f4075e = r2
            char r2 = r8.m9891e()
            r1[r0] = r2
            int r0 = r8.f4073c
            int r0 = r0 + 1
            r8.f4073c = r0
            goto L_0x0006
        L_0x0053:
            java.lang.String r0 = new java.lang.String
            char[] r1 = r8.f4077g
            int r2 = r8.f4074d
            int r3 = r8.f4075e
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        L_0x0060:
            int r2 = r8.f4075e
            r8.f4076f = r2
            int r0 = r0 + 1
            r8.f4073c = r0
            int r0 = r2 + 1
            r8.f4075e = r0
            r1[r2] = r6
        L_0x006e:
            int r0 = r8.f4073c
            int r1 = r8.f4072b
            if (r0 >= r1) goto L_0x0087
            char[] r2 = r8.f4077g
            char r7 = r2[r0]
            if (r7 != r6) goto L_0x0087
            int r1 = r8.f4075e
            int r7 = r1 + 1
            r8.f4075e = r7
            r2[r1] = r6
            int r0 = r0 + 1
            r8.f4073c = r0
            goto L_0x006e
        L_0x0087:
            if (r0 == r1) goto L_0x0097
            char[] r1 = r8.f4077g
            char r2 = r1[r0]
            if (r2 == r3) goto L_0x0097
            char r2 = r1[r0]
            if (r2 == r4) goto L_0x0097
            char r0 = r1[r0]
            if (r0 != r5) goto L_0x0006
        L_0x0097:
            java.lang.String r0 = new java.lang.String
            char[] r1 = r8.f4077g
            int r2 = r8.f4074d
            int r3 = r8.f4076f
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.bvs.m9890d():java.lang.String");
    }

    /* renamed from: e */
    private char m9891e() {
        int i = this.f4073c + 1;
        this.f4073c = i;
        if (i != this.f4072b) {
            char[] cArr = this.f4077g;
            char c = cArr[i];
            if (!(c == ' ' || c == '%' || c == '\\' || c == '_' || c == '\"' || c == '#')) {
                switch (c) {
                    case '*':
                    case '+':
                    case ',':
                        break;
                    default:
                        switch (c) {
                            case msg_roll_pitch_yaw_speed_thrust_setpoint.MAVLINK_MSG_ID_ROLL_PITCH_YAW_SPEED_THRUST_SETPOINT /*59*/:
                            case '<':
                            case '=':
                            case '>':
                                break;
                            default:
                                return m9892f();
                        }
                }
            }
            return cArr[i];
        }
        throw new IllegalStateException("Unexpected end of DN: " + this.f4071a);
    }

    /* renamed from: f */
    private char m9892f() {
        int i;
        int i2;
        int a = m9886a(this.f4073c);
        this.f4073c++;
        if (a < 128) {
            return (char) a;
        }
        if (a < 192 || a > 247) {
            return '?';
        }
        if (a <= 223) {
            i2 = a & 31;
            i = 1;
        } else if (a <= 239) {
            i = 2;
            i2 = a & 15;
        } else {
            i = 3;
            i2 = a & 7;
        }
        for (int i3 = 0; i3 < i; i3++) {
            int i4 = this.f4073c + 1;
            this.f4073c = i4;
            if (i4 == this.f4072b || this.f4077g[i4] != '\\') {
                return '?';
            }
            int i5 = i4 + 1;
            this.f4073c = i5;
            int a2 = m9886a(i5);
            this.f4073c++;
            if ((a2 & 192) != 128) {
                return '?';
            }
            i2 = (i2 << 6) + (a2 & 63);
        }
        return (char) i2;
    }

    /* renamed from: a */
    private int m9886a(int i) {
        int i2;
        int i3;
        int i4 = i + 1;
        if (i4 < this.f4072b) {
            char[] cArr = this.f4077g;
            char c = cArr[i];
            if (c >= '0' && c <= '9') {
                i2 = c - '0';
            } else if (c >= 'a' && c <= 'f') {
                i2 = c - 'W';
            } else if (c < 'A' || c > 'F') {
                throw new IllegalStateException("Malformed DN: " + this.f4071a);
            } else {
                i2 = c - '7';
            }
            char c2 = cArr[i4];
            if (c2 >= '0' && c2 <= '9') {
                i3 = c2 - '0';
            } else if (c2 >= 'a' && c2 <= 'f') {
                i3 = c2 - 'W';
            } else if (c2 < 'A' || c2 > 'F') {
                throw new IllegalStateException("Malformed DN: " + this.f4071a);
            } else {
                i3 = c2 - '7';
            }
            return (i2 << 4) + i3;
        }
        throw new IllegalStateException("Malformed DN: " + this.f4071a);
    }

    /* renamed from: a */
    public String mo3734a(String str) {
        String str2;
        this.f4073c = 0;
        this.f4074d = 0;
        this.f4075e = 0;
        this.f4076f = 0;
        this.f4077g = this.f4071a.toCharArray();
        String a = m9887a();
        if (a == null) {
            return null;
        }
        do {
            int i = this.f4073c;
            if (i == this.f4072b) {
                return null;
            }
            char c = this.f4077g[i];
            if (c != '\"') {
                str2 = c != '#' ? (c == '+' || c == ',' || c == ';') ? "" : m9890d() : m9889c();
            } else {
                str2 = m9888b();
            }
            if (str.equalsIgnoreCase(a)) {
                return str2;
            }
            int i2 = this.f4073c;
            if (i2 >= this.f4072b) {
                return null;
            }
            char[] cArr = this.f4077g;
            if (cArr[i2] == ',' || cArr[i2] == ';' || cArr[i2] == '+') {
                this.f4073c = i2 + 1;
                a = m9887a();
            } else {
                throw new IllegalStateException("Malformed DN: " + this.f4071a);
            }
        } while (a != null);
        throw new IllegalStateException("Malformed DN: " + this.f4071a);
    }
}
