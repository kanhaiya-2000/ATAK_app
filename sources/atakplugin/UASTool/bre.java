package atakplugin.UASTool;

import com.atakmap.android.uastool.MAVLink.enums.MAV_CMD;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class bre {

    /* renamed from: a */
    private static final Pattern f3355a = Pattern.compile("(\\d{2,4})[^\\d]*");

    /* renamed from: b */
    private static final Pattern f3356b = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");

    /* renamed from: c */
    private static final Pattern f3357c = Pattern.compile("(\\d{1,2})[^\\d]*");

    /* renamed from: d */
    private static final Pattern f3358d = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");

    /* renamed from: e */
    private final String f3359e;

    /* renamed from: f */
    private final String f3360f;

    /* renamed from: g */
    private final long f3361g;

    /* renamed from: h */
    private final String f3362h;

    /* renamed from: i */
    private final String f3363i;

    /* renamed from: j */
    private final boolean f3364j;

    /* renamed from: k */
    private final boolean f3365k;

    /* renamed from: l */
    private final boolean f3366l;

    /* renamed from: m */
    private final boolean f3367m;

    private bre(String str, String str2, long j, String str3, String str4, boolean z, boolean z2, boolean z3, boolean z4) {
        this.f3359e = str;
        this.f3360f = str2;
        this.f3361g = j;
        this.f3362h = str3;
        this.f3363i = str4;
        this.f3364j = z;
        this.f3365k = z2;
        this.f3367m = z3;
        this.f3366l = z4;
    }

    private bre(C0223a aVar) {
        Objects.requireNonNull(aVar.f3368a, "builder.name == null");
        Objects.requireNonNull(aVar.f3369b, "builder.value == null");
        Objects.requireNonNull(aVar.f3371d, "builder.domain == null");
        this.f3359e = aVar.f3368a;
        this.f3360f = aVar.f3369b;
        this.f3361g = aVar.f3370c;
        this.f3362h = aVar.f3371d;
        this.f3363i = aVar.f3372e;
        this.f3364j = aVar.f3373f;
        this.f3365k = aVar.f3374g;
        this.f3366l = aVar.f3375h;
        this.f3367m = aVar.f3376i;
    }

    /* renamed from: a */
    public String mo3109a() {
        return this.f3359e;
    }

    /* renamed from: b */
    public String mo3111b() {
        return this.f3360f;
    }

    /* renamed from: c */
    public boolean mo3112c() {
        return this.f3366l;
    }

    /* renamed from: d */
    public long mo3113d() {
        return this.f3361g;
    }

    /* renamed from: e */
    public boolean mo3114e() {
        return this.f3367m;
    }

    /* renamed from: f */
    public String mo3116f() {
        return this.f3362h;
    }

    /* renamed from: g */
    public String mo3117g() {
        return this.f3363i;
    }

    /* renamed from: h */
    public boolean mo3118h() {
        return this.f3365k;
    }

    /* renamed from: i */
    public boolean mo3120i() {
        return this.f3364j;
    }

    /* renamed from: a */
    public boolean mo3110a(brr brr) {
        boolean z;
        if (this.f3367m) {
            z = brr.mo3204i().equals(this.f3362h);
        } else {
            z = m8715b(brr, this.f3362h);
        }
        if (!z || !m8716c(brr, this.f3363i)) {
            return false;
        }
        if (!this.f3364j || brr.mo3195d()) {
            return true;
        }
        return false;
    }

    /* renamed from: b */
    private static boolean m8715b(brr brr, String str) {
        String i = brr.mo3204i();
        if (i.equals(str)) {
            return true;
        }
        if (!i.endsWith(str) || i.charAt((i.length() - str.length()) - 1) != '.' || bsp.m9174e(i)) {
            return false;
        }
        return true;
    }

    /* renamed from: c */
    private static boolean m8716c(brr brr, String str) {
        String l = brr.mo3207l();
        if (l.equals(str)) {
            return true;
        }
        if (!l.startsWith(str)) {
            return false;
        }
        if (!str.endsWith("/") && l.charAt(str.length()) != '/') {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    public static bre m8712a(brr brr, String str) {
        return m8711a(System.currentTimeMillis(), brr, str);
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00da  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00e2  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00f8  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00fa  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static atakplugin.UASTool.bre m8711a(long r23, atakplugin.UASTool.brr r25, java.lang.String r26) {
        /*
            r0 = r26
            int r1 = r26.length()
            r2 = 0
            r3 = 59
            int r4 = atakplugin.UASTool.bsp.m9146a((java.lang.String) r0, (int) r2, (int) r1, (char) r3)
            r5 = 61
            int r6 = atakplugin.UASTool.bsp.m9146a((java.lang.String) r0, (int) r2, (int) r4, (char) r5)
            r7 = 0
            if (r6 != r4) goto L_0x0017
            return r7
        L_0x0017:
            java.lang.String r9 = atakplugin.UASTool.bsp.m9172c(r0, r2, r6)
            boolean r8 = r9.isEmpty()
            if (r8 == 0) goto L_0x0022
            return r7
        L_0x0022:
            r8 = 1
            int r6 = r6 + r8
            java.lang.String r10 = atakplugin.UASTool.bsp.m9172c(r0, r6, r4)
            int r4 = r4 + r8
            r11 = -1
            r13 = 253402300799999(0xe677d21fdbff, double:1.251973714024093E-309)
            r6 = r7
            r8 = r6
            r19 = r11
            r21 = r13
            r15 = 0
            r16 = 0
            r17 = 1
            r18 = 0
        L_0x003d:
            if (r4 >= r1) goto L_0x00ab
            int r7 = atakplugin.UASTool.bsp.m9146a((java.lang.String) r0, (int) r4, (int) r1, (char) r3)
            int r3 = atakplugin.UASTool.bsp.m9146a((java.lang.String) r0, (int) r4, (int) r7, (char) r5)
            java.lang.String r4 = atakplugin.UASTool.bsp.m9172c(r0, r4, r3)
            if (r3 >= r7) goto L_0x0054
            int r3 = r3 + 1
            java.lang.String r3 = atakplugin.UASTool.bsp.m9172c(r0, r3, r7)
            goto L_0x0056
        L_0x0054:
            java.lang.String r3 = ""
        L_0x0056:
            java.lang.String r5 = "expires"
            boolean r5 = r4.equalsIgnoreCase(r5)
            if (r5 == 0) goto L_0x0067
            int r4 = r3.length()     // Catch:{ IllegalArgumentException -> 0x00a3 }
            long r21 = m8710a((java.lang.String) r3, (int) r2, (int) r4)     // Catch:{ IllegalArgumentException -> 0x00a3 }
            goto L_0x0073
        L_0x0067:
            java.lang.String r5 = "max-age"
            boolean r5 = r4.equalsIgnoreCase(r5)
            if (r5 == 0) goto L_0x0076
            long r19 = m8709a((java.lang.String) r3)     // Catch:{  }
        L_0x0073:
            r18 = 1
            goto L_0x00a3
        L_0x0076:
            java.lang.String r5 = "domain"
            boolean r5 = r4.equalsIgnoreCase(r5)
            if (r5 == 0) goto L_0x0085
            java.lang.String r6 = m8714b(r3)     // Catch:{ IllegalArgumentException -> 0x00a3 }
            r17 = 0
            goto L_0x00a3
        L_0x0085:
            java.lang.String r5 = "path"
            boolean r5 = r4.equalsIgnoreCase(r5)
            if (r5 == 0) goto L_0x008f
            r8 = r3
            goto L_0x00a3
        L_0x008f:
            java.lang.String r3 = "secure"
            boolean r3 = r4.equalsIgnoreCase(r3)
            if (r3 == 0) goto L_0x0099
            r15 = 1
            goto L_0x00a3
        L_0x0099:
            java.lang.String r3 = "httponly"
            boolean r3 = r4.equalsIgnoreCase(r3)
            if (r3 == 0) goto L_0x00a3
            r16 = 1
        L_0x00a3:
            int r4 = r7 + 1
            r3 = 59
            r5 = 61
            r7 = 0
            goto L_0x003d
        L_0x00ab:
            r0 = -9223372036854775808
            int r3 = (r19 > r0 ? 1 : (r19 == r0 ? 0 : -1))
            if (r3 != 0) goto L_0x00b3
        L_0x00b1:
            r11 = r0
            goto L_0x00d8
        L_0x00b3:
            int r0 = (r19 > r11 ? 1 : (r19 == r11 ? 0 : -1))
            if (r0 == 0) goto L_0x00d6
            r0 = 9223372036854775(0x20c49ba5e353f7, double:4.663754807431093E-308)
            int r3 = (r19 > r0 ? 1 : (r19 == r0 ? 0 : -1))
            if (r3 > 0) goto L_0x00c5
            r0 = 1000(0x3e8, double:4.94E-321)
            long r19 = r19 * r0
            goto L_0x00ca
        L_0x00c5:
            r19 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
        L_0x00ca:
            long r0 = r23 + r19
            int r3 = (r0 > r23 ? 1 : (r0 == r23 ? 0 : -1))
            if (r3 < 0) goto L_0x00d4
            int r3 = (r0 > r13 ? 1 : (r0 == r13 ? 0 : -1))
            if (r3 <= 0) goto L_0x00b1
        L_0x00d4:
            r11 = r13
            goto L_0x00d8
        L_0x00d6:
            r11 = r21
        L_0x00d8:
            if (r6 != 0) goto L_0x00e2
            java.lang.String r0 = r25.mo3204i()
            r13 = r0
            r0 = r25
            goto L_0x00ed
        L_0x00e2:
            r0 = r25
            boolean r1 = m8715b(r0, r6)
            if (r1 != 0) goto L_0x00ec
            r1 = 0
            return r1
        L_0x00ec:
            r13 = r6
        L_0x00ed:
            java.lang.String r1 = "/"
            if (r8 == 0) goto L_0x00fa
            boolean r3 = r8.startsWith(r1)
            if (r3 != 0) goto L_0x00f8
            goto L_0x00fa
        L_0x00f8:
            r14 = r8
            goto L_0x010b
        L_0x00fa:
            java.lang.String r0 = r25.mo3207l()
            r3 = 47
            int r3 = r0.lastIndexOf(r3)
            if (r3 == 0) goto L_0x010a
            java.lang.String r1 = r0.substring(r2, r3)
        L_0x010a:
            r14 = r1
        L_0x010b:
            atakplugin.UASTool.bre r0 = new atakplugin.UASTool.bre
            r8 = r0
            r8.<init>(r9, r10, r11, r13, r14, r15, r16, r17, r18)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.bre.m8711a(long, atakplugin.UASTool.brr, java.lang.String):atakplugin.UASTool.bre");
    }

    /* renamed from: a */
    private static long m8710a(String str, int i, int i2) {
        int a = m8708a(str, i, i2, false);
        Matcher matcher = f3358d.matcher(str);
        int i3 = -1;
        int i4 = -1;
        int i5 = -1;
        int i6 = -1;
        int i7 = -1;
        int i8 = -1;
        while (a < i2) {
            int a2 = m8708a(str, a + 1, i2, true);
            matcher.region(a, a2);
            if (i4 == -1 && matcher.usePattern(f3358d).matches()) {
                i4 = Integer.parseInt(matcher.group(1));
                i7 = Integer.parseInt(matcher.group(2));
                i8 = Integer.parseInt(matcher.group(3));
            } else if (i5 != -1 || !matcher.usePattern(f3357c).matches()) {
                if (i6 == -1) {
                    Pattern pattern = f3356b;
                    if (matcher.usePattern(pattern).matches()) {
                        i6 = pattern.pattern().indexOf(matcher.group(1).toLowerCase(Locale.US)) / 4;
                    }
                }
                if (i3 == -1 && matcher.usePattern(f3355a).matches()) {
                    i3 = Integer.parseInt(matcher.group(1));
                }
            } else {
                i5 = Integer.parseInt(matcher.group(1));
            }
            a = m8708a(str, a2 + 1, i2, false);
        }
        if (i3 >= 70 && i3 <= 99) {
            i3 += 1900;
        }
        if (i3 >= 0 && i3 <= 69) {
            i3 += 2000;
        }
        if (i3 < 1601) {
            throw new IllegalArgumentException();
        } else if (i6 == -1) {
            throw new IllegalArgumentException();
        } else if (i5 < 1 || i5 > 31) {
            throw new IllegalArgumentException();
        } else if (i4 < 0 || i4 > 23) {
            throw new IllegalArgumentException();
        } else if (i7 < 0 || i7 > 59) {
            throw new IllegalArgumentException();
        } else if (i8 < 0 || i8 > 59) {
            throw new IllegalArgumentException();
        } else {
            GregorianCalendar gregorianCalendar = new GregorianCalendar(bsp.f3585d);
            gregorianCalendar.setLenient(false);
            gregorianCalendar.set(1, i3);
            gregorianCalendar.set(2, i6 - 1);
            gregorianCalendar.set(5, i5);
            gregorianCalendar.set(11, i4);
            gregorianCalendar.set(12, i7);
            gregorianCalendar.set(13, i8);
            gregorianCalendar.set(14, 0);
            return gregorianCalendar.getTimeInMillis();
        }
    }

    /* renamed from: a */
    private static int m8708a(String str, int i, int i2, boolean z) {
        while (i < i2) {
            char charAt = str.charAt(i);
            if (((charAt < ' ' && charAt != 9) || charAt >= 127 || (charAt >= '0' && charAt <= '9') || ((charAt >= 'a' && charAt <= 'z') || ((charAt >= 'A' && charAt <= 'Z') || charAt == ':'))) == (!z)) {
                return i;
            }
            i++;
        }
        return i2;
    }

    /* renamed from: a */
    private static long m8709a(String str) {
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong <= 0) {
                return Long.MIN_VALUE;
            }
            return parseLong;
        } catch (NumberFormatException e) {
            if (!str.matches("-?\\d+")) {
                throw e;
            } else if (str.startsWith("-")) {
                return Long.MIN_VALUE;
            } else {
                return bfu.f2629b;
            }
        }
    }

    /* renamed from: b */
    private static String m8714b(String str) {
        if (!str.endsWith(".")) {
            if (str.startsWith(".")) {
                str = str.substring(1);
            }
            String d = bsp.m9173d(str);
            if (d != null) {
                return d;
            }
            throw new IllegalArgumentException();
        }
        throw new IllegalArgumentException();
    }

    /* renamed from: a */
    public static List<bre> m8713a(brr brr, brp brp) {
        List<String> c = brp.mo3175c("Set-Cookie");
        int size = c.size();
        ArrayList arrayList = null;
        for (int i = 0; i < size; i++) {
            bre a = m8712a(brr, c.get(i));
            if (a != null) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(a);
            }
        }
        if (arrayList != null) {
            return Collections.unmodifiableList(arrayList);
        }
        return Collections.emptyList();
    }

    /* renamed from: atakplugin.UASTool.bre$a */
    public static final class C0223a {

        /* renamed from: a */
        String f3368a;

        /* renamed from: b */
        String f3369b;

        /* renamed from: c */
        long f3370c = buy.f4018a;

        /* renamed from: d */
        String f3371d;

        /* renamed from: e */
        String f3372e = "/";

        /* renamed from: f */
        boolean f3373f;

        /* renamed from: g */
        boolean f3374g;

        /* renamed from: h */
        boolean f3375h;

        /* renamed from: i */
        boolean f3376i;

        /* renamed from: a */
        public C0223a mo3124a(String str) {
            Objects.requireNonNull(str, "name == null");
            if (str.trim().equals(str)) {
                this.f3368a = str;
                return this;
            }
            throw new IllegalArgumentException("name is not trimmed");
        }

        /* renamed from: b */
        public C0223a mo3126b(String str) {
            Objects.requireNonNull(str, "value == null");
            if (str.trim().equals(str)) {
                this.f3369b = str;
                return this;
            }
            throw new IllegalArgumentException("value is not trimmed");
        }

        /* renamed from: a */
        public C0223a mo3123a(long j) {
            if (j <= 0) {
                j = Long.MIN_VALUE;
            }
            if (j > buy.f4018a) {
                j = 253402300799999L;
            }
            this.f3370c = j;
            this.f3375h = true;
            return this;
        }

        /* renamed from: c */
        public C0223a mo3127c(String str) {
            return m8727a(str, false);
        }

        /* renamed from: d */
        public C0223a mo3129d(String str) {
            return m8727a(str, true);
        }

        /* renamed from: a */
        private C0223a m8727a(String str, boolean z) {
            Objects.requireNonNull(str, "domain == null");
            String d = bsp.m9173d(str);
            if (d != null) {
                this.f3371d = d;
                this.f3376i = z;
                return this;
            }
            throw new IllegalArgumentException("unexpected domain: " + str);
        }

        /* renamed from: e */
        public C0223a mo3130e(String str) {
            if (str.startsWith("/")) {
                this.f3372e = str;
                return this;
            }
            throw new IllegalArgumentException("path must start with '/'");
        }

        /* renamed from: a */
        public C0223a mo3122a() {
            this.f3373f = true;
            return this;
        }

        /* renamed from: b */
        public C0223a mo3125b() {
            this.f3374g = true;
            return this;
        }

        /* renamed from: c */
        public bre mo3128c() {
            return new bre(this);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f3359e);
        sb.append('=');
        sb.append(this.f3360f);
        if (this.f3366l) {
            if (this.f3361g == Long.MIN_VALUE) {
                sb.append("; max-age=0");
            } else {
                sb.append("; expires=");
                sb.append(buy.m9768a(new Date(this.f3361g)));
            }
        }
        if (!this.f3367m) {
            sb.append("; domain=");
            sb.append(this.f3362h);
        }
        sb.append("; path=");
        sb.append(this.f3363i);
        if (this.f3364j) {
            sb.append("; secure");
        }
        if (this.f3365k) {
            sb.append("; httponly");
        }
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof bre)) {
            return false;
        }
        bre bre = (bre) obj;
        if (bre.f3359e.equals(this.f3359e) && bre.f3360f.equals(this.f3360f) && bre.f3362h.equals(this.f3362h) && bre.f3363i.equals(this.f3363i) && bre.f3361g == this.f3361g && bre.f3364j == this.f3364j && bre.f3365k == this.f3365k && bre.f3366l == this.f3366l && bre.f3367m == this.f3367m) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        long j = this.f3361g;
        return ((((((((((((((((MAV_CMD.MAV_CMD_REQUEST_CAMERA_CAPTURE_STATUS + this.f3359e.hashCode()) * 31) + this.f3360f.hashCode()) * 31) + this.f3362h.hashCode()) * 31) + this.f3363i.hashCode()) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + (this.f3364j ^ true ? 1 : 0)) * 31) + (this.f3365k ^ true ? 1 : 0)) * 31) + (this.f3366l ^ true ? 1 : 0)) * 31) + (this.f3367m ^ true ? 1 : 0);
    }
}
