package atakplugin.UASTool;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

class cdp extends cdh implements cce {

    /* renamed from: a */
    Class f4549a;

    /* renamed from: o */
    private Method f4550o;

    cdp(int i, String str, Class cls, Class[] clsArr, String[] strArr, Class[] clsArr2, Class cls2) {
        super(i, str, cls, clsArr, strArr, clsArr2);
        this.f4549a = cls2;
    }

    cdp(String str) {
        super(str);
    }

    /* renamed from: g */
    public Class mo4410g() {
        if (this.f4549a == null) {
            this.f4549a = mo4549c(6);
        }
        return this.f4549a;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String mo4505a(cds cds) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(cds.mo4556a(mo4347d()));
        if (cds.f4571b) {
            stringBuffer.append(cds.mo4557a(mo4410g()));
        }
        if (cds.f4571b) {
            stringBuffer.append(" ");
        }
        stringBuffer.append(cds.mo4558a(mo4348e(), mo4349f()));
        stringBuffer.append(".");
        stringBuffer.append(mo4346c());
        cds.mo4563b(stringBuffer, mo4414i());
        cds.mo4564c(stringBuffer, mo4416k());
        return stringBuffer.toString();
    }

    /* renamed from: h */
    public Method mo4442h() {
        if (this.f4550o == null) {
            Class e = mo4348e();
            try {
                this.f4550o = e.getDeclaredMethod(mo4346c(), mo4414i());
            } catch (NoSuchMethodException unused) {
                HashSet hashSet = new HashSet();
                hashSet.add(e);
                this.f4550o = m11442a(e, mo4346c(), mo4414i(), hashSet);
            }
        }
        return this.f4550o;
    }

    /* renamed from: a */
    private Method m11442a(Class cls, String str, Class[] clsArr, Set set) {
        if (cls == null) {
            return null;
        }
        if (!set.contains(cls)) {
            set.add(cls);
            try {
                return cls.getDeclaredMethod(str, clsArr);
            } catch (NoSuchMethodException unused) {
            }
        }
        Method a = m11442a(cls.getSuperclass(), str, clsArr, set);
        if (a != null) {
            return a;
        }
        Class[] interfaces = cls.getInterfaces();
        if (interfaces != null) {
            for (Class a2 : interfaces) {
                Method a3 = m11442a(a2, str, clsArr, set);
                if (a3 != null) {
                    return a3;
                }
            }
        }
        return null;
    }
}
