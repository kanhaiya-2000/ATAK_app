package atakplugin.UASTool;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class cal {

    /* renamed from: a */
    private static final Class[] f4434a = new Class[0];

    /* renamed from: b */
    private static final Class[] f4435b = {Object.class};

    /* renamed from: c */
    private static final Class[] f4436c = {Class.class};

    /* renamed from: d */
    private static final Object[] f4437d = new Object[0];

    /* renamed from: e */
    private static final String f4438e = "aspectOf";

    /* renamed from: f */
    private static final String f4439f = "hasAspect";

    /* renamed from: a */
    public static <T> T m10995a(Class<T> cls) {
        try {
            return m11003c(cls).invoke((Object) null, f4437d);
        } catch (InvocationTargetException e) {
            throw new cao(cls.getName(), e);
        } catch (Exception e2) {
            throw new cao(cls.getName(), e2);
        }
    }

    /* renamed from: a */
    public static <T> T m10997a(Class<T> cls, Object obj) {
        try {
            return m11004d(cls).invoke((Object) null, new Object[]{obj});
        } catch (InvocationTargetException e) {
            throw new cao(cls.getName(), e);
        } catch (Exception e2) {
            throw new cao(cls.getName(), e2);
        }
    }

    /* renamed from: a */
    public static <T> T m10996a(Class<T> cls, Class<?> cls2) {
        try {
            return m11005e(cls).invoke((Object) null, new Object[]{cls2});
        } catch (InvocationTargetException e) {
            throw new cao(cls.getName(), e);
        } catch (Exception e2) {
            throw new cao(cls.getName(), e2);
        }
    }

    /* renamed from: b */
    public static boolean m11000b(Class<?> cls) {
        try {
            return ((Boolean) m11006f(cls).invoke((Object) null, f4437d)).booleanValue();
        } catch (Exception unused) {
            return false;
        }
    }

    /* renamed from: b */
    public static boolean m11002b(Class<?> cls, Object obj) {
        try {
            return ((Boolean) m11007g(cls).invoke((Object) null, new Object[]{obj})).booleanValue();
        } catch (Exception unused) {
            return false;
        }
    }

    /* renamed from: b */
    public static boolean m11001b(Class<?> cls, Class<?> cls2) {
        try {
            return ((Boolean) m11008h(cls).invoke((Object) null, new Object[]{cls2})).booleanValue();
        } catch (Exception unused) {
            return false;
        }
    }

    /* renamed from: c */
    private static Method m11003c(Class<?> cls) {
        return m10998a(cls.getDeclaredMethod(f4438e, f4434a), cls);
    }

    /* renamed from: d */
    private static Method m11004d(Class<?> cls) {
        return m10998a(cls.getDeclaredMethod(f4438e, f4435b), cls);
    }

    /* renamed from: e */
    private static Method m11005e(Class<?> cls) {
        return m10998a(cls.getDeclaredMethod(f4438e, f4436c), cls);
    }

    /* renamed from: a */
    private static Method m10998a(Method method, Class<?> cls) {
        method.setAccessible(true);
        if (method.isAccessible() && Modifier.isPublic(method.getModifiers()) && Modifier.isStatic(method.getModifiers())) {
            return method;
        }
        throw new NoSuchMethodException(cls.getName() + ".aspectOf(..) is not accessible public static");
    }

    /* renamed from: f */
    private static Method m11006f(Class cls) {
        return m10999b(cls.getDeclaredMethod(f4439f, f4434a), cls);
    }

    /* renamed from: g */
    private static Method m11007g(Class cls) {
        return m10999b(cls.getDeclaredMethod(f4439f, f4435b), cls);
    }

    /* renamed from: h */
    private static Method m11008h(Class cls) {
        return m10999b(cls.getDeclaredMethod(f4439f, f4436c), cls);
    }

    /* renamed from: b */
    private static Method m10999b(Method method, Class cls) {
        method.setAccessible(true);
        if (method.isAccessible() && Modifier.isPublic(method.getModifiers()) && Modifier.isStatic(method.getModifiers())) {
            return method;
        }
        throw new NoSuchMethodException(cls.getName() + ".hasAspect(..) is not accessible public static");
    }
}
