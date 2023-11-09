package atakplugin.UASTool;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class btk extends RuntimeException {

    /* renamed from: a */
    private static final Method f3688a;

    /* renamed from: b */
    private IOException f3689b;

    static {
        Method method;
        try {
            method = Throwable.class.getDeclaredMethod("addSuppressed", new Class[]{Throwable.class});
        } catch (Exception unused) {
            method = null;
        }
        f3688a = method;
    }

    public btk(IOException iOException) {
        super(iOException);
        this.f3689b = iOException;
    }

    /* renamed from: a */
    public IOException mo3478a() {
        return this.f3689b;
    }

    /* renamed from: a */
    public void mo3479a(IOException iOException) {
        m9304a(iOException, this.f3689b);
        this.f3689b = iOException;
    }

    /* renamed from: a */
    private void m9304a(IOException iOException, IOException iOException2) {
        Method method = f3688a;
        if (method != null) {
            try {
                method.invoke(iOException, new Object[]{iOException2});
            } catch (IllegalAccessException | InvocationTargetException unused) {
            }
        }
    }
}
