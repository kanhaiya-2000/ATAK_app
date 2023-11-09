package atakplugin.UASTool;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public enum ceq {
    GENERAL((String) null, "bBhHsS"),
    CHAR(new Class[]{Character.class, Byte.class, Short.class, Integer.class}, "cC"),
    INT(new Class[]{Byte.class, Short.class, Integer.class, Long.class, BigInteger.class}, "doxX"),
    FLOAT(new Class[]{Float.class, Double.class, BigDecimal.class}, "eEfgGaA"),
    TIME(new Class[]{Long.class, Calendar.class, Date.class}, "tT"),
    CHAR_AND_INT(new Class[]{Byte.class, Short.class, Integer.class}, (int) null),
    INT_AND_TIME(new Class[]{Long.class}, (int) null),
    NULL(new Class[0], (int) null),
    UNUSED((String) null, (int) null);
    

    /* renamed from: j */
    public final Class<? extends Object>[] f4603j;

    /* renamed from: k */
    public final String f4604k;

    private ceq(Class<? extends Object>[] clsArr, String str) {
        this.f4603j = clsArr;
        this.f4604k = str;
    }

    /* renamed from: a */
    public static ceq m11526a(char c) {
        ceq[] ceqArr = {GENERAL, CHAR, INT, FLOAT, TIME};
        for (int i = 0; i < 5; i++) {
            ceq ceq = ceqArr[i];
            if (ceq.f4604k.contains(String.valueOf(c))) {
                return ceq;
            }
        }
        throw new IllegalArgumentException("Bad conversion character " + c);
    }

    /* renamed from: a */
    private static <E> Set<E> m11528a(E[] eArr) {
        return new HashSet(Arrays.asList(eArr));
    }

    /* renamed from: a */
    public static boolean m11529a(ceq ceq, ceq ceq2) {
        return m11530b(ceq, ceq2) == ceq;
    }

    /* renamed from: b */
    public static ceq m11530b(ceq ceq, ceq ceq2) {
        ceq ceq3 = UNUSED;
        if (ceq == ceq3) {
            return ceq2;
        }
        if (ceq2 == ceq3) {
            return ceq;
        }
        ceq ceq4 = GENERAL;
        if (ceq == ceq4) {
            return ceq2;
        }
        if (ceq2 == ceq4) {
            return ceq;
        }
        Set a = m11528a((E[]) ceq.f4603j);
        a.retainAll(m11528a((E[]) ceq2.f4603j));
        ceq[] ceqArr = {CHAR, INT, FLOAT, TIME, CHAR_AND_INT, INT_AND_TIME, NULL};
        for (int i = 0; i < 7; i++) {
            ceq ceq5 = ceqArr[i];
            if (m11528a((E[]) ceq5.f4603j).equals(a)) {
                return ceq5;
            }
        }
        throw new RuntimeException();
    }

    /* renamed from: c */
    public static ceq m11531c(ceq ceq, ceq ceq2) {
        ceq ceq3;
        ceq ceq4 = UNUSED;
        if (ceq == ceq4 || ceq2 == ceq4 || ceq == (ceq4 = GENERAL) || ceq2 == ceq4) {
            return ceq4;
        }
        ceq ceq5 = CHAR_AND_INT;
        if ((ceq == ceq5 && ceq2 == INT_AND_TIME) || (ceq == (ceq3 = INT_AND_TIME) && ceq2 == ceq5)) {
            return INT;
        }
        Set a = m11528a((E[]) ceq.f4603j);
        a.addAll(m11528a((E[]) ceq2.f4603j));
        ceq[] ceqArr = {NULL, ceq5, ceq3, CHAR, INT, FLOAT, TIME};
        for (int i = 0; i < 7; i++) {
            ceq ceq6 = ceqArr[i];
            if (m11528a((E[]) ceq6.f4603j).equals(a)) {
                return ceq6;
            }
        }
        return GENERAL;
    }

    /* renamed from: a */
    private String m11527a(Class<?> cls) {
        if (cls == Boolean.class) {
            return "boolean";
        }
        if (cls == Character.class) {
            return "char";
        }
        if (cls == Byte.class) {
            return "byte";
        }
        if (cls == Short.class) {
            return "short";
        }
        if (cls == Integer.class) {
            return "int";
        }
        if (cls == Long.class) {
            return "long";
        }
        if (cls == Float.class) {
            return "float";
        }
        if (cls == Double.class) {
            return "double";
        }
        return cls.getSimpleName();
    }

    @cny
    public String toString() {
        StringBuilder sb = new StringBuilder(name());
        sb.append(" conversion category (one of: ");
        Class<? extends Object>[] clsArr = this.f4603j;
        int length = clsArr.length;
        boolean z = true;
        int i = 0;
        while (i < length) {
            Class<? extends Object> cls = clsArr[i];
            if (!z) {
                sb.append(", ");
            }
            sb.append(m11527a((Class<?>) cls));
            i++;
            z = false;
        }
        sb.append(")");
        return sb.toString();
    }
}
