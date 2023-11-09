package atakplugin.UASTool;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class cam {

    /* renamed from: a */
    static Class f4440a = null;

    /* renamed from: b */
    static Class f4441b = null;

    /* renamed from: c */
    private static final Class[] f4442c = new Class[0];

    /* renamed from: d */
    private static final Class[] f4443d;

    /* renamed from: e */
    private static final Class[] f4444e;

    /* renamed from: f */
    private static final Object[] f4445f = new Object[0];

    /* renamed from: g */
    private static final String f4446g = "aspectOf";

    /* renamed from: h */
    private static final String f4447h = "hasAspect";

    static {
        Class[] clsArr = new Class[1];
        Class cls = f4440a;
        if (cls == null) {
            cls = m11009a("java.lang.Object");
            f4440a = cls;
        }
        clsArr[0] = cls;
        f4443d = clsArr;
        Class[] clsArr2 = new Class[1];
        Class cls2 = f4441b;
        if (cls2 == null) {
            cls2 = m11009a("java.lang.Class");
            f4441b = cls2;
        }
        clsArr2[0] = cls2;
        f4444e = clsArr2;
    }

    /* renamed from: a */
    static Class m11009a(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    /* renamed from: a */
    public static Object m11010a(Class cls) {
        try {
            return m11018c(cls).invoke((Object) null, f4445f);
        } catch (InvocationTargetException e) {
            throw new cao(cls.getName(), e);
        } catch (Exception e2) {
            throw new cao(cls.getName(), e2);
        }
    }

    /* renamed from: a */
    public static Object m11012a(Class cls, Object obj) {
        try {
            return m11019d(cls).invoke((Object) null, new Object[]{obj});
        } catch (InvocationTargetException e) {
            throw new cao(cls.getName(), e);
        } catch (Exception e2) {
            throw new cao(cls.getName(), e2);
        }
    }

    /* renamed from: a */
    public static Object m11011a(Class cls, Class cls2) {
        try {
            return m11020e(cls).invoke((Object) null, new Object[]{cls2});
        } catch (InvocationTargetException e) {
            throw new cao(cls.getName(), e);
        } catch (Exception e2) {
            throw new cao(cls.getName(), e2);
        }
    }

    /* renamed from: b */
    public static boolean m11015b(Class cls) {
        try {
            return ((Boolean) m11021f(cls).invoke((Object) null, f4445f)).booleanValue();
        } catch (Exception unused) {
            return false;
        }
    }

    /* renamed from: b */
    public static boolean m11017b(Class cls, Object obj) {
        try {
            return ((Boolean) m11022g(cls).invoke((Object) null, new Object[]{obj})).booleanValue();
        } catch (Exception unused) {
            return false;
        }
    }

    /* renamed from: b */
    public static boolean m11016b(Class cls, Class cls2) {
        try {
            return ((Boolean) m11023h(cls).invoke((Object) null, new Object[]{cls2})).booleanValue();
        } catch (Exception unused) {
            return false;
        }
    }

    /* renamed from: c */
    private static Method m11018c(Class cls) {
        return m11013a(cls.getDeclaredMethod(f4446g, f4442c), cls);
    }

    /* renamed from: d */
    private static Method m11019d(Class cls) {
        return m11013a(cls.getDeclaredMethod(f4446g, f4443d), cls);
    }

    /* renamed from: e */
    private static Method m11020e(Class cls) {
        return m11013a(cls.getDeclaredMethod(f4446g, f4444e), cls);
    }

    /* renamed from: a */
    private static Method m11013a(Method method, Class cls) {
        method.setAccessible(true);
        if (method.isAccessible() && Modifier.isPublic(method.getModifiers()) && Modifier.isStatic(method.getModifiers())) {
            return method;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(cls.getName());
        stringBuffer.append(".aspectOf(..) is not accessible public static");
        throw new NoSuchMethodException(stringBuffer.toString());
    }

    /* renamed from: f */
    private static Method m11021f(Class cls) {
        return m11014b(cls.getDeclaredMethod(f4447h, f4442c), cls);
    }

    /* renamed from: g */
    private static Method m11022g(Class cls) {
        return m11014b(cls.getDeclaredMethod(f4447h, f4443d), cls);
    }

    /* renamed from: h */
    private static Method m11023h(Class cls) {
        return m11014b(cls.getDeclaredMethod(f4447h, f4444e), cls);
    }

    /* renamed from: b */
    private static Method m11014b(Method method, Class cls) {
        method.setAccessible(true);
        if (method.isAccessible() && Modifier.isPublic(method.getModifiers()) && Modifier.isStatic(method.getModifiers())) {
            return method;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(cls.getName());
        stringBuffer.append(".hasAspect(..) is not accessible public static");
        throw new NoSuchMethodException(stringBuffer.toString());
    }
}
