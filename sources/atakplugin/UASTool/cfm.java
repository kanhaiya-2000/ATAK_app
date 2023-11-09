package atakplugin.UASTool;

import com.atakmap.android.uastool.flightlog.FlightLogger;
import java.text.ChoiceFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public class cfm {
    /* renamed from: a */
    public static void m11556a(String str) {
        MessageFormat.format(str, (Object[]) null);
    }

    /* renamed from: b */
    public static cfo[] m11558b(String str) {
        m11556a(str);
        C0315a[] a = C0316b.m11562a(str);
        HashMap hashMap = new HashMap();
        int i = -1;
        for (C0315a aVar : a) {
            int i2 = aVar.f4608a;
            hashMap.put(Integer.valueOf(i2), cfo.m11567b(aVar.f4609b, hashMap.containsKey(Integer.valueOf(i2)) ? (cfo) hashMap.get(Integer.valueOf(i2)) : cfo.UNUSED));
            i = Math.max(i, i2);
        }
        cfo[] cfoArr = new cfo[(i + 1)];
        for (int i3 = 0; i3 <= i; i3++) {
            cfoArr[i3] = hashMap.containsKey(Integer.valueOf(i3)) ? (cfo) hashMap.get(Integer.valueOf(i3)) : cfo.UNUSED;
        }
        return cfoArr;
    }

    @cfn
    /* renamed from: a */
    public static boolean m11557a(String str, cfo... cfoArr) {
        cfo[] b = m11558b(str);
        if (b.length != cfoArr.length) {
            return false;
        }
        for (int i = 0; i < cfoArr.length; i++) {
            if (!cfo.m11566a(cfoArr[i], b[i])) {
                return false;
            }
        }
        return true;
    }

    @cfv
    /* renamed from: c */
    public static boolean m11559c(String str) {
        try {
            m11558b(str);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    /* renamed from: atakplugin.UASTool.cfm$a */
    private static class C0315a {

        /* renamed from: a */
        public int f4608a;

        /* renamed from: b */
        public cfo f4609b;

        public C0315a(int i, cfo cfo) {
            this.f4608a = i;
            this.f4609b = cfo;
        }

        public String toString() {
            return this.f4609b.toString() + "(index: " + this.f4608a + ")";
        }
    }

    /* renamed from: atakplugin.UASTool.cfm$b */
    private static class C0316b {

        /* renamed from: a */
        public static int f4610a = 0;

        /* renamed from: b */
        private static Locale f4611b = null;

        /* renamed from: c */
        private static List<cfo> f4612c = null;

        /* renamed from: d */
        private static List<Integer> f4613d = null;

        /* renamed from: e */
        private static int f4614e = 0;

        /* renamed from: f */
        private static final int f4615f = 0;

        /* renamed from: g */
        private static final int f4616g = 1;

        /* renamed from: h */
        private static final int f4617h = 2;

        /* renamed from: i */
        private static final int f4618i = 3;

        /* renamed from: j */
        private static final int f4619j = 0;

        /* renamed from: k */
        private static final int f4620k = 1;

        /* renamed from: l */
        private static final int f4621l = 2;

        /* renamed from: m */
        private static final int f4622m = 3;

        /* renamed from: n */
        private static final int f4623n = 4;

        /* renamed from: o */
        private static final String[] f4624o = {"", "number", FlightLogger.LOCS_DATE, "time", "choice"};

        /* renamed from: p */
        private static final int f4625p = 0;

        /* renamed from: q */
        private static final int f4626q = 1;

        /* renamed from: r */
        private static final int f4627r = 2;

        /* renamed from: s */
        private static final int f4628s = 3;

        /* renamed from: t */
        private static final String[] f4629t = {"", "currency", "percent", "integer"};

        /* renamed from: u */
        private static final String[] f4630u = {"", "short", "medium", "long", "full"};

        private C0316b() {
        }

        /* renamed from: a */
        public static C0315a[] m11562a(String str) {
            f4612c = new ArrayList();
            f4613d = new ArrayList();
            f4611b = Locale.getDefault(Locale.Category.FORMAT);
            m11563b(str);
            C0315a[] aVarArr = new C0315a[f4614e];
            for (int i = 0; i < f4614e; i++) {
                aVarArr[i] = new C0315a(f4613d.get(i).intValue(), f4612c.get(i));
            }
            return aVarArr;
        }

        /* renamed from: b */
        private static void m11563b(String str) {
            StringBuilder[] sbArr = new StringBuilder[4];
            sbArr[0] = new StringBuilder();
            f4614e = 0;
            f4610a = -1;
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            boolean z = false;
            while (i < str.length()) {
                char charAt = str.charAt(i);
                if (i3 == 0) {
                    if (charAt == '\'') {
                        int i4 = i + 1;
                        if (i4 >= str.length() || str.charAt(i4) != '\'') {
                            z = !z;
                        } else {
                            sbArr[i3].append(charAt);
                            i = i4;
                        }
                    } else if (charAt != '{' || z) {
                        sbArr[i3].append(charAt);
                    } else {
                        if (sbArr[1] == null) {
                            sbArr[1] = new StringBuilder();
                        }
                        i3 = 1;
                    }
                } else if (z) {
                    sbArr[i3].append(charAt);
                    if (charAt == '\'') {
                        z = false;
                    }
                } else if (charAt != ' ') {
                    if (charAt == '\'') {
                        sbArr[i3].append(charAt);
                        z = true;
                    } else if (charAt != ',') {
                        if (charAt == '{') {
                            i2++;
                            sbArr[i3].append(charAt);
                        } else if (charAt != '}') {
                            sbArr[i3].append(charAt);
                        } else if (i2 == 0) {
                            m11561a(i, f4614e, sbArr);
                            f4614e++;
                            sbArr[1] = null;
                            sbArr[2] = null;
                            sbArr[3] = null;
                            i3 = 0;
                        } else {
                            i2--;
                            sbArr[i3].append(charAt);
                        }
                    } else if (i3 < 3) {
                        i3++;
                        if (sbArr[i3] == null) {
                            sbArr[i3] = new StringBuilder();
                        }
                    } else {
                        sbArr[i3].append(charAt);
                    }
                } else if (i3 != 2 || sbArr[2].length() > 0) {
                    sbArr[i3].append(charAt);
                }
                i++;
            }
            if (i2 == 0 && i3 != 0) {
                f4610a = -1;
                throw new IllegalArgumentException("Unmatched braces in the pattern");
            }
        }

        /* renamed from: a */
        private static void m11561a(int i, int i2, StringBuilder[] sbArr) {
            cfo cfo;
            String[] strArr = new String[sbArr.length];
            for (int i3 = 0; i3 < sbArr.length; i3++) {
                StringBuilder sb = sbArr[i3];
                strArr[i3] = sb != null ? sb.toString() : "";
            }
            try {
                int parseInt = Integer.parseInt(strArr[1]);
                if (parseInt >= 0) {
                    int i4 = f4610a;
                    f4610a = i2;
                    f4613d.add(Integer.valueOf(parseInt));
                    if (strArr[2].length() != 0) {
                        int a = m11560a(strArr[2], f4624o);
                        if (a == 0) {
                            cfo = cfo.GENERAL;
                        } else if (a == 1) {
                            int a2 = m11560a(strArr[3], f4629t);
                            if (!(a2 == 0 || a2 == 1 || a2 == 2 || a2 == 3)) {
                                try {
                                    new DecimalFormat(strArr[3], DecimalFormatSymbols.getInstance(f4611b));
                                } catch (IllegalArgumentException e) {
                                    f4610a = i4;
                                    throw e;
                                }
                            }
                            cfo = cfo.NUMBER;
                        } else if (a == 2 || a == 3) {
                            String str = strArr[3];
                            String[] strArr2 = f4630u;
                            int a3 = m11560a(str, strArr2);
                            if (a3 < 0 || a3 >= strArr2.length) {
                                try {
                                    new SimpleDateFormat(strArr[3], f4611b);
                                } catch (IllegalArgumentException e2) {
                                    f4610a = i4;
                                    throw e2;
                                }
                            }
                            cfo = cfo.DATE;
                        } else if (a != 4) {
                            f4610a = i4;
                            throw new IllegalArgumentException("unknown format type: " + strArr[2]);
                        } else if (strArr[3].length() != 0) {
                            try {
                                new ChoiceFormat(strArr[3]);
                                cfo = cfo.NUMBER;
                            } catch (Exception e3) {
                                f4610a = i4;
                                throw new IllegalArgumentException("Choice Pattern incorrect: " + strArr[3], e3);
                            }
                        } else {
                            throw new IllegalArgumentException("Choice Pattern requires Subformat Pattern: " + strArr[3]);
                        }
                    } else {
                        cfo = cfo.GENERAL;
                    }
                    f4612c.add(cfo);
                    return;
                }
                throw new IllegalArgumentException("negative argument number: " + parseInt);
            } catch (NumberFormatException e4) {
                throw new IllegalArgumentException("can't parse argument number: " + strArr[1], e4);
            }
        }

        /* renamed from: a */
        private static final int m11560a(String str, String[] strArr) {
            for (int i = 0; i < strArr.length; i++) {
                if (str.equals(strArr[i])) {
                    return i;
                }
            }
            String lowerCase = str.trim().toLowerCase(Locale.ROOT);
            if (lowerCase == str) {
                return -1;
            }
            for (int i2 = 0; i2 < strArr.length; i2++) {
                if (lowerCase.equals(strArr[i2])) {
                    return i2;
                }
            }
            return -1;
        }
    }
}
