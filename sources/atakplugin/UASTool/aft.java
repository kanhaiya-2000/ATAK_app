package atakplugin.UASTool;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class aft {

    /* renamed from: a */
    static Pattern f883a = Pattern.compile("(....|\\.\\.)(\\[(.*)\\])?");

    /* renamed from: b */
    static final /* synthetic */ boolean f884b = true;

    private aft() {
    }

    /* renamed from: a */
    public static String m884a(C0688nt ntVar) {
        return m892d(ntVar, "");
    }

    /* renamed from: d */
    private static String m892d(C0688nt ntVar, String str) {
        C0695nz e = ntVar.mo1474e();
        int i = 0;
        for (C0688nt next : e.mo36c()) {
            if (next.mo1476h().equals(ntVar.mo1476h())) {
                if (next == ntVar) {
                    break;
                }
                i++;
            }
        }
        String str2 = String.valueOf(String.format("/%s[%d]", new Object[]{ntVar.mo1476h(), Integer.valueOf(i)})) + str;
        return e instanceof C0688nt ? m892d((C0688nt) e, str2) : str2;
    }

    /* renamed from: a */
    public static <T extends C0688nt> T m881a(C0688nt ntVar, String str) {
        List a = m885a(ntVar, str, true);
        if (a.isEmpty()) {
            return null;
        }
        return (C0688nt) a.get(0);
    }

    /* renamed from: a */
    public static <T extends C0688nt> T m882a(C0695nz nzVar, String str) {
        List a = m886a(nzVar, str, true);
        if (a.isEmpty()) {
            return null;
        }
        return (C0688nt) a.get(0);
    }

    /* renamed from: a */
    public static <T extends C0688nt> T m883a(C1003wo woVar, String str) {
        List a = m887a(woVar, str, true);
        if (a.isEmpty()) {
            return null;
        }
        return (C0688nt) a.get(0);
    }

    /* renamed from: b */
    public static <T extends C0688nt> List<T> m889b(C0688nt ntVar, String str) {
        return m885a(ntVar, str, false);
    }

    /* renamed from: b */
    public static <T extends C0688nt> List<T> m890b(C0695nz nzVar, String str) {
        return m886a(nzVar, str, false);
    }

    /* renamed from: a */
    private static <T extends C0688nt> List<T> m887a(C1003wo woVar, String str, boolean z) {
        return m888a((Object) woVar, str, z);
    }

    /* renamed from: a */
    private static <T extends C0688nt> List<T> m886a(C0695nz nzVar, String str, boolean z) {
        return m888a((Object) nzVar, str, z);
    }

    /* renamed from: a */
    private static <T extends C0688nt> List<T> m885a(C0688nt ntVar, String str, boolean z) {
        return m888a((Object) ntVar, str, z);
    }

    /* renamed from: a */
    private static <T extends C0688nt> List<T> m888a(Object obj, String str, boolean z) {
        String str2;
        if (str.startsWith("/")) {
            String substring = str.substring(1);
            while (obj instanceof C0688nt) {
                obj = ((C0688nt) obj).mo1474e();
            }
            str = substring;
        }
        if (str.length() != 0) {
            int i = 0;
            if (str.contains("/")) {
                str2 = str.substring(str.indexOf(47) + 1);
                str = str.substring(0, str.indexOf(47));
            } else {
                str2 = "";
            }
            Matcher matcher = f883a.matcher(str);
            if (matcher.matches()) {
                String group = matcher.group(1);
                if ("..".equals(group)) {
                    if (obj instanceof C0688nt) {
                        return m886a(((C0688nt) obj).mo1474e(), str2, z);
                    }
                    return Collections.emptyList();
                } else if (!(obj instanceof C0695nz)) {
                    return Collections.emptyList();
                } else {
                    int parseInt = matcher.group(2) != null ? Integer.parseInt(matcher.group(3)) : -1;
                    LinkedList linkedList = new LinkedList();
                    for (C0688nt next : ((C0695nz) obj).mo36c()) {
                        if (next.mo1476h().matches(group)) {
                            if (parseInt == -1 || parseInt == i) {
                                linkedList.addAll(m885a(next, str2, z));
                            }
                            i++;
                        }
                        if ((z || parseInt >= 0) && !linkedList.isEmpty()) {
                            return linkedList;
                        }
                    }
                    return linkedList;
                }
            } else {
                throw new RuntimeException(String.valueOf(str) + " is invalid path.");
            }
        } else if (obj instanceof C0688nt) {
            return Collections.singletonList((C0688nt) obj);
        } else {
            throw new RuntimeException("Result of path expression seems to be the root container. This is not allowed!");
        }
    }

    /* renamed from: c */
    public static boolean m891c(C0688nt ntVar, String str) {
        if (f884b || str.startsWith("/")) {
            return m889b(ntVar, str).contains(ntVar);
        }
        throw new AssertionError("Absolute path required");
    }
}
