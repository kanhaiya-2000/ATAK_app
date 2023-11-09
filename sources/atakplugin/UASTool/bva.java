package atakplugin.UASTool;

import atakplugin.UASTool.brp;
import com.google.common.net.HttpHeaders;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public final class bva {
    private bva() {
    }

    /* renamed from: a */
    public static long m9775a(bsh bsh) {
        return m9774a(bsh.mo3383g());
    }

    /* renamed from: a */
    public static long m9774a(brp brp) {
        return m9776a(brp.mo3170a("Content-Length"));
    }

    /* renamed from: a */
    private static long m9776a(String str) {
        if (str == null) {
            return -1;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    /* renamed from: a */
    public static boolean m9780a(bsh bsh, brp brp, bsb bsb) {
        for (String next : m9787e(bsh)) {
            if (!bsp.m9164a((Object) brp.mo3175c(next), (Object) bsb.mo3346b(next))) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: b */
    public static boolean m9783b(bsh bsh) {
        return m9782b(bsh.mo3383g());
    }

    /* renamed from: b */
    public static boolean m9782b(brp brp) {
        return m9785c(brp).contains("*");
    }

    /* renamed from: e */
    private static Set<String> m9787e(bsh bsh) {
        return m9785c(bsh.mo3383g());
    }

    /* renamed from: c */
    public static Set<String> m9785c(brp brp) {
        Set<String> emptySet = Collections.emptySet();
        int a = brp.mo3168a();
        for (int i = 0; i < a; i++) {
            if (HttpHeaders.VARY.equalsIgnoreCase(brp.mo3169a(i))) {
                String b = brp.mo3171b(i);
                if (emptySet.isEmpty()) {
                    emptySet = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
                }
                for (String trim : b.split(",")) {
                    emptySet.add(trim.trim());
                }
            }
        }
        return emptySet;
    }

    /* renamed from: c */
    public static brp m9784c(bsh bsh) {
        return m9777a(bsh.mo3387k().mo3372a().mo3347c(), bsh.mo3383g());
    }

    /* renamed from: a */
    public static brp m9777a(brp brp, brp brp2) {
        Set<String> c = m9785c(brp2);
        if (c.isEmpty()) {
            return new brp.C0225a().mo3182a();
        }
        brp.C0225a aVar = new brp.C0225a();
        int a = brp.mo3168a();
        for (int i = 0; i < a; i++) {
            String a2 = brp.mo3169a(i);
            if (c.contains(a2)) {
                aVar.mo3181a(a2, brp.mo3171b(i));
            }
        }
        return aVar.mo3182a();
    }

    /* renamed from: a */
    public static List<bqx> m9778a(brp brp, String str) {
        ArrayList arrayList = new ArrayList();
        int a = brp.mo3168a();
        for (int i = 0; i < a; i++) {
            if (str.equalsIgnoreCase(brp.mo3169a(i))) {
                String b = brp.mo3171b(i);
                int i2 = 0;
                while (i2 < b.length()) {
                    int a2 = m9773a(b, i2, " ");
                    String trim = b.substring(i2, a2).trim();
                    int a3 = m9772a(b, a2);
                    if (!b.regionMatches(true, a3, "realm=\"", 0, 7)) {
                        break;
                    }
                    int i3 = a3 + 7;
                    int a4 = m9773a(b, i3, "\"");
                    String substring = b.substring(i3, a4);
                    i2 = m9772a(b, m9773a(b, a4 + 1, ",") + 1);
                    arrayList.add(new bqx(trim, substring));
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public static void m9779a(brg brg, brr brr, brp brp) {
        if (brg != brg.f3377a) {
            List<bre> a = bre.m8713a(brr, brp);
            if (!a.isEmpty()) {
                brg.mo3132a(brr, a);
            }
        }
    }

    /* renamed from: d */
    public static boolean m9786d(bsh bsh) {
        if (bsh.mo3372a().mo3345b().equals("HEAD")) {
            return false;
        }
        int c = bsh.mo3378c();
        if (((c >= 100 && c < 200) || c == 204 || c == 304) && m9775a(bsh) == -1 && !"chunked".equalsIgnoreCase(bsh.mo3377b(HttpHeaders.TRANSFER_ENCODING))) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    public static int m9773a(String str, int i, String str2) {
        while (i < str.length() && str2.indexOf(str.charAt(i)) == -1) {
            i++;
        }
        return i;
    }

    /* renamed from: a */
    public static int m9772a(String str, int i) {
        while (i < str.length() && ((r0 = str.charAt(i)) == ' ' || r0 == 9)) {
            i++;
        }
        return i;
    }

    /* renamed from: b */
    public static int m9781b(String str, int i) {
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong > 2147483647L) {
                return Integer.MAX_VALUE;
            }
            if (parseLong < 0) {
                return 0;
            }
            return (int) parseLong;
        } catch (NumberFormatException unused) {
            return i;
        }
    }
}
