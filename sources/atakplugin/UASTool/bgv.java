package atakplugin.UASTool;

import atakplugin.UASTool.bhf;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

public class bgv {
    /* renamed from: a */
    private static <T extends Throwable> T m6748a(T t) {
        return bfq.m6537a(t, bgv.class.getName());
    }

    /* renamed from: a */
    public static void m6749a(Object obj, String str) {
        String name = obj == null ? "null" : obj.getClass().getName();
        m6750a(name + " cannot be cast to " + str);
    }

    /* renamed from: a */
    public static void m6750a(String str) {
        throw m6746a(new ClassCastException(str));
    }

    /* renamed from: a */
    public static ClassCastException m6746a(ClassCastException classCastException) {
        throw ((ClassCastException) m6748a(classCastException));
    }

    /* renamed from: a */
    public static boolean m6751a(Object obj) {
        return (obj instanceof Iterator) && (!(obj instanceof bgz) || (obj instanceof bhc));
    }

    /* renamed from: b */
    public static Iterator m6754b(Object obj) {
        if ((obj instanceof bgz) && !(obj instanceof bhc)) {
            m6749a(obj, "kotlin.collections.MutableIterator");
        }
        return m6756c(obj);
    }

    /* renamed from: b */
    public static Iterator m6755b(Object obj, String str) {
        if ((obj instanceof bgz) && !(obj instanceof bhc)) {
            m6750a(str);
        }
        return m6756c(obj);
    }

    /* renamed from: c */
    public static Iterator m6756c(Object obj) {
        try {
            return (Iterator) obj;
        } catch (ClassCastException e) {
            throw m6746a(e);
        }
    }

    /* renamed from: d */
    public static boolean m6759d(Object obj) {
        return (obj instanceof ListIterator) && (!(obj instanceof bgz) || (obj instanceof bhe));
    }

    /* renamed from: e */
    public static ListIterator m6761e(Object obj) {
        if ((obj instanceof bgz) && !(obj instanceof bhe)) {
            m6749a(obj, "kotlin.collections.MutableListIterator");
        }
        return m6763f(obj);
    }

    /* renamed from: c */
    public static ListIterator m6757c(Object obj, String str) {
        if ((obj instanceof bgz) && !(obj instanceof bhe)) {
            m6750a(str);
        }
        return m6763f(obj);
    }

    /* renamed from: f */
    public static ListIterator m6763f(Object obj) {
        try {
            return (ListIterator) obj;
        } catch (ClassCastException e) {
            throw m6746a(e);
        }
    }

    /* renamed from: g */
    public static boolean m6765g(Object obj) {
        return (obj instanceof Iterable) && (!(obj instanceof bgz) || (obj instanceof bhb));
    }

    /* renamed from: h */
    public static Iterable m6766h(Object obj) {
        if ((obj instanceof bgz) && !(obj instanceof bhb)) {
            m6749a(obj, "kotlin.collections.MutableIterable");
        }
        return m6768i(obj);
    }

    /* renamed from: d */
    public static Iterable m6758d(Object obj, String str) {
        if ((obj instanceof bgz) && !(obj instanceof bhb)) {
            m6750a(str);
        }
        return m6768i(obj);
    }

    /* renamed from: i */
    public static Iterable m6768i(Object obj) {
        try {
            return (Iterable) obj;
        } catch (ClassCastException e) {
            throw m6746a(e);
        }
    }

    /* renamed from: j */
    public static boolean m6770j(Object obj) {
        return (obj instanceof Collection) && (!(obj instanceof bgz) || (obj instanceof bha));
    }

    /* renamed from: k */
    public static Collection m6771k(Object obj) {
        if ((obj instanceof bgz) && !(obj instanceof bha)) {
            m6749a(obj, "kotlin.collections.MutableCollection");
        }
        return m6772l(obj);
    }

    /* renamed from: e */
    public static Collection m6760e(Object obj, String str) {
        if ((obj instanceof bgz) && !(obj instanceof bha)) {
            m6750a(str);
        }
        return m6772l(obj);
    }

    /* renamed from: l */
    public static Collection m6772l(Object obj) {
        try {
            return (Collection) obj;
        } catch (ClassCastException e) {
            throw m6746a(e);
        }
    }

    /* renamed from: m */
    public static boolean m6773m(Object obj) {
        return (obj instanceof List) && (!(obj instanceof bgz) || (obj instanceof bhd));
    }

    /* renamed from: n */
    public static List m6774n(Object obj) {
        if ((obj instanceof bgz) && !(obj instanceof bhd)) {
            m6749a(obj, "kotlin.collections.MutableList");
        }
        return m6775o(obj);
    }

    /* renamed from: f */
    public static List m6762f(Object obj, String str) {
        if ((obj instanceof bgz) && !(obj instanceof bhd)) {
            m6750a(str);
        }
        return m6775o(obj);
    }

    /* renamed from: o */
    public static List m6775o(Object obj) {
        try {
            return (List) obj;
        } catch (ClassCastException e) {
            throw m6746a(e);
        }
    }

    /* renamed from: p */
    public static boolean m6776p(Object obj) {
        return (obj instanceof Set) && (!(obj instanceof bgz) || (obj instanceof bhg));
    }

    /* renamed from: q */
    public static Set m6777q(Object obj) {
        if ((obj instanceof bgz) && !(obj instanceof bhg)) {
            m6749a(obj, "kotlin.collections.MutableSet");
        }
        return m6778r(obj);
    }

    /* renamed from: g */
    public static Set m6764g(Object obj, String str) {
        if ((obj instanceof bgz) && !(obj instanceof bhg)) {
            m6750a(str);
        }
        return m6778r(obj);
    }

    /* renamed from: r */
    public static Set m6778r(Object obj) {
        try {
            return (Set) obj;
        } catch (ClassCastException e) {
            throw m6746a(e);
        }
    }

    /* renamed from: s */
    public static boolean m6779s(Object obj) {
        return (obj instanceof Map) && (!(obj instanceof bgz) || (obj instanceof bhf));
    }

    /* renamed from: t */
    public static Map m6780t(Object obj) {
        if ((obj instanceof bgz) && !(obj instanceof bhf)) {
            m6749a(obj, "kotlin.collections.MutableMap");
        }
        return m6781u(obj);
    }

    /* renamed from: h */
    public static Map m6767h(Object obj, String str) {
        if ((obj instanceof bgz) && !(obj instanceof bhf)) {
            m6750a(str);
        }
        return m6781u(obj);
    }

    /* renamed from: u */
    public static Map m6781u(Object obj) {
        try {
            return (Map) obj;
        } catch (ClassCastException e) {
            throw m6746a(e);
        }
    }

    /* renamed from: v */
    public static boolean m6782v(Object obj) {
        return (obj instanceof Map.Entry) && (!(obj instanceof bgz) || (obj instanceof bhf.C0161a));
    }

    /* renamed from: w */
    public static Map.Entry m6783w(Object obj) {
        if ((obj instanceof bgz) && !(obj instanceof bhf.C0161a)) {
            m6749a(obj, "kotlin.collections.MutableMap.MutableEntry");
        }
        return m6784x(obj);
    }

    /* renamed from: i */
    public static Map.Entry m6769i(Object obj, String str) {
        if ((obj instanceof bgz) && !(obj instanceof bhf.C0161a)) {
            m6750a(str);
        }
        return m6784x(obj);
    }

    /* renamed from: x */
    public static Map.Entry m6784x(Object obj) {
        try {
            return (Map.Entry) obj;
        } catch (ClassCastException e) {
            throw m6746a(e);
        }
    }

    /* renamed from: y */
    public static int m6785y(Object obj) {
        if (obj instanceof bfj) {
            return ((bfj) obj).getArity();
        }
        if (obj instanceof bdk) {
            return 0;
        }
        if (obj instanceof bdl) {
            return 1;
        }
        if (obj instanceof bdw) {
            return 2;
        }
        if (obj instanceof bea) {
            return 3;
        }
        if (obj instanceof beb) {
            return 4;
        }
        if (obj instanceof bec) {
            return 5;
        }
        if (obj instanceof bed) {
            return 6;
        }
        if (obj instanceof bee) {
            return 7;
        }
        if (obj instanceof bef) {
            return 8;
        }
        if (obj instanceof beg) {
            return 9;
        }
        if (obj instanceof bdm) {
            return 10;
        }
        if (obj instanceof bdn) {
            return 11;
        }
        if (obj instanceof bdo) {
            return 12;
        }
        if (obj instanceof bdp) {
            return 13;
        }
        if (obj instanceof bdq) {
            return 14;
        }
        if (obj instanceof bdr) {
            return 15;
        }
        if (obj instanceof bds) {
            return 16;
        }
        if (obj instanceof bdt) {
            return 17;
        }
        if (obj instanceof bdu) {
            return 18;
        }
        if (obj instanceof bdv) {
            return 19;
        }
        if (obj instanceof bdx) {
            return 20;
        }
        if (obj instanceof bdy) {
            return 21;
        }
        return obj instanceof bdz ? 22 : -1;
    }

    /* renamed from: a */
    public static boolean m6752a(Object obj, int i) {
        return (obj instanceof aoh) && m6785y(obj) == i;
    }

    /* renamed from: b */
    public static Object m6753b(Object obj, int i) {
        if (obj != null && !m6752a(obj, i)) {
            m6749a(obj, "kotlin.jvm.functions.Function" + i);
        }
        return obj;
    }

    /* renamed from: a */
    public static Object m6747a(Object obj, int i, String str) {
        if (obj != null && !m6752a(obj, i)) {
            m6750a(str);
        }
        return obj;
    }
}
