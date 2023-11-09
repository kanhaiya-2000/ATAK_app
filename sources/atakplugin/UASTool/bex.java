package atakplugin.UASTool;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;

public abstract class bex implements bjh, Serializable {
    public static final Object NO_RECEIVER = C0148a.f2586a;
    protected final Object receiver;
    private transient bjh reflected;

    /* access modifiers changed from: protected */
    public abstract bjh computeReflected();

    /* renamed from: atakplugin.UASTool.bex$a */
    private static class C0148a implements Serializable {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public static final C0148a f2586a = new C0148a();

        private C0148a() {
        }

        /* renamed from: b */
        private Object m6440b() {
            return f2586a;
        }
    }

    public bex() {
        this(NO_RECEIVER);
    }

    protected bex(Object obj) {
        this.receiver = obj;
    }

    public Object getBoundReceiver() {
        return this.receiver;
    }

    public bjh compute() {
        bjh bjh = this.reflected;
        if (bjh != null) {
            return bjh;
        }
        bjh computeReflected = computeReflected();
        this.reflected = computeReflected;
        return computeReflected;
    }

    /* access modifiers changed from: protected */
    public bjh getReflected() {
        bjh compute = compute();
        if (compute != this) {
            return compute;
        }
        throw new bdd();
    }

    public bjk getOwner() {
        throw new AbstractMethodError();
    }

    public String getName() {
        throw new AbstractMethodError();
    }

    public String getSignature() {
        throw new AbstractMethodError();
    }

    public List<bjq> getParameters() {
        return getReflected().getParameters();
    }

    public bjv getReturnType() {
        return getReflected().getReturnType();
    }

    public List<Annotation> getAnnotations() {
        return getReflected().getAnnotations();
    }

    public List<bjw> getTypeParameters() {
        return getReflected().getTypeParameters();
    }

    public Object call(Object... objArr) {
        return getReflected().call(objArr);
    }

    public Object callBy(Map map) {
        return getReflected().callBy(map);
    }

    public bjz getVisibility() {
        return getReflected().getVisibility();
    }

    public boolean isFinal() {
        return getReflected().isFinal();
    }

    public boolean isOpen() {
        return getReflected().isOpen();
    }

    public boolean isAbstract() {
        return getReflected().isAbstract();
    }

    public boolean isSuspend() {
        return getReflected().isSuspend();
    }
}
