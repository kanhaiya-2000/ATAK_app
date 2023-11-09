package atakplugin.UASTool;

import com.atakmap.android.uastool.flightlog.FlightLogger;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public enum cfo {
    UNUSED((String) null, (int) null),
    GENERAL((String) null, (int) null),
    DATE(new Class[]{Date.class, Number.class}, new String[]{FlightLogger.LOCS_DATE, "time"}),
    NUMBER(new Class[]{Number.class}, new String[]{"number", "choice"});
    

    /* renamed from: e */
    public final Class<? extends Object>[] f4636e;

    /* renamed from: f */
    public final String[] f4637f;

    private cfo(Class<? extends Object>[] clsArr, String[] strArr) {
        this.f4636e = clsArr;
        this.f4637f = strArr;
    }

    /* renamed from: a */
    public static cfo m11564a(String str) {
        String lowerCase = str.toLowerCase();
        cfo[] cfoArr = {DATE, NUMBER};
        for (int i = 0; i < 2; i++) {
            cfo cfo = cfoArr[i];
            for (String equals : cfo.f4637f) {
                if (equals.equals(lowerCase)) {
                    return cfo;
                }
            }
        }
        throw new IllegalArgumentException("Invalid format type " + lowerCase);
    }

    /* renamed from: a */
    private static <E> Set<E> m11565a(E[] eArr) {
        return new HashSet(Arrays.asList(eArr));
    }

    /* renamed from: a */
    public static boolean m11566a(cfo cfo, cfo cfo2) {
        return m11567b(cfo, cfo2) == cfo;
    }

    /* renamed from: b */
    public static cfo m11567b(cfo cfo, cfo cfo2) {
        cfo cfo3 = UNUSED;
        if (cfo == cfo3) {
            return cfo2;
        }
        if (cfo2 == cfo3) {
            return cfo;
        }
        cfo cfo4 = GENERAL;
        if (cfo == cfo4) {
            return cfo2;
        }
        if (cfo2 == cfo4) {
            return cfo;
        }
        Set a = m11565a((E[]) cfo.f4636e);
        a.retainAll(m11565a((E[]) cfo2.f4636e));
        cfo[] cfoArr = {DATE, NUMBER};
        for (int i = 0; i < 2; i++) {
            cfo cfo5 = cfoArr[i];
            if (m11565a((E[]) cfo5.f4636e).equals(a)) {
                return cfo5;
            }
        }
        throw new RuntimeException();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0007, code lost:
        r0 = f4632b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000e, code lost:
        r0 = f4633c;
     */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static atakplugin.UASTool.cfo m11568c(atakplugin.UASTool.cfo r1, atakplugin.UASTool.cfo r2) {
        /*
            atakplugin.UASTool.cfo r0 = UNUSED
            if (r1 == r0) goto L_0x0018
            if (r2 != r0) goto L_0x0007
            goto L_0x0018
        L_0x0007:
            atakplugin.UASTool.cfo r0 = GENERAL
            if (r1 == r0) goto L_0x0018
            if (r2 != r0) goto L_0x000e
            goto L_0x0018
        L_0x000e:
            atakplugin.UASTool.cfo r0 = DATE
            if (r1 == r0) goto L_0x0018
            if (r2 != r0) goto L_0x0015
            goto L_0x0018
        L_0x0015:
            atakplugin.UASTool.cfo r1 = NUMBER
            return r1
        L_0x0018:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.cfo.m11568c(atakplugin.UASTool.cfo, atakplugin.UASTool.cfo):atakplugin.UASTool.cfo");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(name());
        if (this.f4636e == null) {
            sb.append(" conversion category (all types)");
        } else {
            sb.append(" conversion category (one of: ");
            Class<? extends Object>[] clsArr = this.f4636e;
            int length = clsArr.length;
            boolean z = true;
            int i = 0;
            while (i < length) {
                Class<? extends Object> cls = clsArr[i];
                if (!z) {
                    sb.append(", ");
                }
                sb.append(cls.getCanonicalName());
                i++;
                z = false;
            }
            sb.append(")");
        }
        return sb.toString();
    }
}
