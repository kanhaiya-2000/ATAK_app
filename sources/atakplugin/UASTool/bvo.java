package atakplugin.UASTool;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class bvo<T> {

    /* renamed from: a */
    private final Class<?> f4062a;

    /* renamed from: b */
    private final String f4063b;

    /* renamed from: c */
    private final Class[] f4064c;

    public bvo(Class<?> cls, String str, Class... clsArr) {
        this.f4062a = cls;
        this.f4063b = str;
        this.f4064c = clsArr;
    }

    /* renamed from: a */
    public boolean mo3729a(T t) {
        return m9860a(t.getClass()) != null;
    }

    /* renamed from: a */
    public Object mo3728a(T t, Object... objArr) {
        Method a = m9860a(t.getClass());
        if (a == null) {
            return null;
        }
        try {
            return a.invoke(t, objArr);
        } catch (IllegalAccessException unused) {
            return null;
        }
    }

    /* renamed from: b */
    public Object mo3730b(T t, Object... objArr) {
        try {
            return mo3728a(t, objArr);
        } catch (InvocationTargetException e) {
            Throwable targetException = e.getTargetException();
            if (targetException instanceof RuntimeException) {
                throw ((RuntimeException) targetException);
            }
            AssertionError assertionError = new AssertionError("Unexpected exception");
            assertionError.initCause(targetException);
            throw assertionError;
        }
    }

    /* renamed from: c */
    public Object mo3731c(T t, Object... objArr) {
        Method a = m9860a(t.getClass());
        if (a != null) {
            try {
                return a.invoke(t, objArr);
            } catch (IllegalAccessException e) {
                AssertionError assertionError = new AssertionError("Unexpectedly could not call: " + a);
                assertionError.initCause(e);
                throw assertionError;
            }
        } else {
            throw new AssertionError("Method " + this.f4063b + " not supported for object " + t);
        }
    }

    /* renamed from: d */
    public Object mo3732d(T t, Object... objArr) {
        try {
            return mo3731c(t, objArr);
        } catch (InvocationTargetException e) {
            Throwable targetException = e.getTargetException();
            if (targetException instanceof RuntimeException) {
                throw ((RuntimeException) targetException);
            }
            AssertionError assertionError = new AssertionError("Unexpected exception");
            assertionError.initCause(targetException);
            throw assertionError;
        }
    }

    /* renamed from: a */
    private Method m9860a(Class<?> cls) {
        Class<?> cls2;
        String str = this.f4063b;
        if (str == null) {
            return null;
        }
        Method a = m9861a(cls, str, this.f4064c);
        if (a == null || (cls2 = this.f4062a) == null || cls2.isAssignableFrom(a.getReturnType())) {
            return a;
        }
        return null;
    }

    /* renamed from: a */
    private static Method m9861a(Class<?> cls, String str, Class[] clsArr) {
        try {
            Method method = cls.getMethod(str, clsArr);
            try {
                if ((method.getModifiers() & 1) == 0) {
                    return null;
                }
            } catch (NoSuchMethodException unused) {
            }
            return method;
        } catch (NoSuchMethodException unused2) {
            return null;
        }
    }
}
