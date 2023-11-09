package atakplugin.UASTool;

import java.util.Arrays;

public class bfq {
    /* renamed from: a */
    public static int m6533a(int i, int i2) {
        if (i < i2) {
            return -1;
        }
        return i == i2 ? 0 : 1;
    }

    /* renamed from: a */
    public static int m6534a(long j, long j2) {
        int i = (j > j2 ? 1 : (j == j2 ? 0 : -1));
        if (i < 0) {
            return -1;
        }
        return i == 0 ? 0 : 1;
    }

    private bfq() {
    }

    /* renamed from: a */
    public static String m6535a(String str, Object obj) {
        return str + obj;
    }

    /* renamed from: a */
    public static void m6541a(Object obj) {
        if (obj == null) {
            m6553b();
        }
    }

    /* renamed from: a */
    public static void m6542a(Object obj, String str) {
        if (obj == null) {
            m6556b(str);
        }
    }

    /* renamed from: a */
    public static void m6538a() {
        throw ((aok) m6536a(new aok()));
    }

    /* renamed from: a */
    public static void m6544a(String str) {
        throw ((aok) m6536a(new aok(str)));
    }

    /* renamed from: b */
    public static void m6553b() {
        throw ((NullPointerException) m6536a(new NullPointerException()));
    }

    /* renamed from: b */
    public static void m6556b(String str) {
        throw ((NullPointerException) m6536a(new NullPointerException(str)));
    }

    /* renamed from: c */
    public static void m6559c(String str) {
        throw ((aqq) m6536a(new aqq(str)));
    }

    /* renamed from: d */
    public static void m6562d(String str) {
        m6559c("lateinit property " + str + " has not been initialized");
    }

    /* renamed from: c */
    public static void m6557c() {
        throw ((AssertionError) m6536a(new AssertionError()));
    }

    /* renamed from: e */
    public static void m6565e(String str) {
        throw ((AssertionError) m6536a(new AssertionError(str)));
    }

    /* renamed from: d */
    public static void m6560d() {
        throw ((IllegalArgumentException) m6536a(new IllegalArgumentException()));
    }

    /* renamed from: f */
    public static void m6568f(String str) {
        throw ((IllegalArgumentException) m6536a(new IllegalArgumentException(str)));
    }

    /* renamed from: e */
    public static void m6563e() {
        throw ((IllegalStateException) m6536a(new IllegalStateException()));
    }

    /* renamed from: g */
    public static void m6571g(String str) {
        throw ((IllegalStateException) m6536a(new IllegalStateException(str)));
    }

    /* renamed from: b */
    public static void m6554b(Object obj, String str) {
        if (obj == null) {
            throw ((IllegalStateException) m6536a(new IllegalStateException(str + " must not be null")));
        }
    }

    /* renamed from: c */
    public static void m6558c(Object obj, String str) {
        if (obj == null) {
            throw ((NullPointerException) m6536a(new NullPointerException(str + " must not be null")));
        }
    }

    /* renamed from: a */
    public static void m6543a(Object obj, String str, String str2) {
        if (obj == null) {
            throw ((IllegalStateException) m6536a(new IllegalStateException("Method specified as non-null returned null: " + str + "." + str2)));
        }
    }

    /* renamed from: d */
    public static void m6561d(Object obj, String str) {
        if (obj == null) {
            throw ((IllegalStateException) m6536a(new IllegalStateException(str)));
        }
    }

    /* renamed from: b */
    public static void m6555b(Object obj, String str, String str2) {
        if (obj == null) {
            throw ((IllegalStateException) m6536a(new IllegalStateException("Field specified as non-null is null: " + str + "." + str2)));
        }
    }

    /* renamed from: e */
    public static void m6564e(Object obj, String str) {
        if (obj == null) {
            throw ((IllegalStateException) m6536a(new IllegalStateException(str)));
        }
    }

    /* renamed from: f */
    public static void m6567f(Object obj, String str) {
        if (obj == null) {
            m6575k(str);
        }
    }

    /* renamed from: g */
    public static void m6570g(Object obj, String str) {
        if (obj == null) {
            throw ((NullPointerException) m6536a(new NullPointerException(str)));
        }
    }

    /* renamed from: k */
    private static void m6575k(String str) {
        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
        String className = stackTraceElement.getClassName();
        String methodName = stackTraceElement.getMethodName();
        throw ((IllegalArgumentException) m6536a(new IllegalArgumentException("Parameter specified as non-null is null: method " + className + "." + methodName + ", parameter " + str)));
    }

    /* renamed from: a */
    public static boolean m6552a(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    /* renamed from: a */
    public static boolean m6549a(Double d, Double d2) {
        if (d != null) {
            return d2 != null && d.doubleValue() == d2.doubleValue();
        }
        if (d2 == null) {
            return true;
        }
    }

    /* renamed from: a */
    public static boolean m6548a(Double d, double d2) {
        return d != null && d.doubleValue() == d2;
    }

    /* renamed from: a */
    public static boolean m6546a(double d, Double d2) {
        return d2 != null && d == d2.doubleValue();
    }

    /* renamed from: a */
    public static boolean m6551a(Float f, Float f2) {
        if (f != null) {
            return f2 != null && f.floatValue() == f2.floatValue();
        }
        if (f2 == null) {
            return true;
        }
    }

    /* renamed from: a */
    public static boolean m6550a(Float f, float f2) {
        return f != null && f.floatValue() == f2;
    }

    /* renamed from: a */
    public static boolean m6547a(float f, Float f2) {
        return f2 != null && f == f2.floatValue();
    }

    /* renamed from: f */
    public static void m6566f() {
        m6572h("This function has a reified type parameter and thus can only be inlined at compilation time, not called directly.");
    }

    /* renamed from: h */
    public static void m6572h(String str) {
        throw new UnsupportedOperationException(str);
    }

    /* renamed from: a */
    public static void m6539a(int i, String str) {
        m6566f();
    }

    /* renamed from: a */
    public static void m6540a(int i, String str, String str2) {
        m6572h(str2);
    }

    /* renamed from: g */
    public static void m6569g() {
        m6566f();
    }

    /* renamed from: i */
    public static void m6573i(String str) {
        m6572h(str);
    }

    /* renamed from: j */
    public static void m6574j(String str) {
        String replace = str.replace('/', '.');
        try {
            Class.forName(replace);
        } catch (ClassNotFoundException e) {
            throw ((ClassNotFoundException) m6536a(new ClassNotFoundException("Class " + replace + " is not found. Please update the Kotlin runtime to the latest version", e)));
        }
    }

    /* renamed from: a */
    public static void m6545a(String str, String str2) {
        String replace = str.replace('/', '.');
        try {
            Class.forName(replace);
        } catch (ClassNotFoundException e) {
            throw ((ClassNotFoundException) m6536a(new ClassNotFoundException("Class " + replace + " is not found: this code requires the Kotlin runtime of version at least " + str2, e)));
        }
    }

    /* renamed from: a */
    private static <T extends Throwable> T m6536a(T t) {
        return m6537a(t, bfq.class.getName());
    }

    /* renamed from: a */
    static <T extends Throwable> T m6537a(T t, String str) {
        StackTraceElement[] stackTrace = t.getStackTrace();
        int length = stackTrace.length;
        int i = -1;
        for (int i2 = 0; i2 < length; i2++) {
            if (str.equals(stackTrace[i2].getClassName())) {
                i = i2;
            }
        }
        t.setStackTrace((StackTraceElement[]) Arrays.copyOfRange(stackTrace, i + 1, length));
        return t;
    }
}
