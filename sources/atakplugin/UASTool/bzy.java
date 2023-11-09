package atakplugin.UASTool;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class bzy extends bzz implements cby {

    /* renamed from: b */
    private Method f4404b;

    public bzy(cbm<?> cbm, String str, int i, Method method) {
        super(cbm, str, i);
        this.f4404b = method;
    }

    /* renamed from: a */
    public cbm<?>[] mo4283a() {
        Class[] parameterTypes = this.f4404b.getParameterTypes();
        cbm<?>[] cbmArr = new cbm[(parameterTypes.length - 1)];
        for (int i = 1; i < parameterTypes.length; i++) {
            cbmArr[i - 1] = cbn.m11175a(parameterTypes[i]);
        }
        return cbmArr;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: atakplugin.UASTool.cbm[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.reflect.Type[] mo4284b() {
        /*
            r5 = this;
            java.lang.reflect.Method r0 = r5.f4404b
            java.lang.reflect.Type[] r0 = r0.getGenericParameterTypes()
            int r1 = r0.length
            r2 = 1
            int r1 = r1 - r2
            atakplugin.UASTool.cbm[] r1 = new atakplugin.UASTool.cbm[r1]
        L_0x000b:
            int r3 = r0.length
            if (r2 >= r3) goto L_0x002a
            r3 = r0[r2]
            boolean r3 = r3 instanceof java.lang.Class
            if (r3 == 0) goto L_0x0021
            int r3 = r2 + -1
            r4 = r0[r2]
            java.lang.Class r4 = (java.lang.Class) r4
            atakplugin.UASTool.cbm r4 = atakplugin.UASTool.cbn.m11175a(r4)
            r1[r3] = r4
            goto L_0x0027
        L_0x0021:
            int r3 = r2 + -1
            r4 = r0[r2]
            r1[r3] = r4
        L_0x0027:
            int r2 = r2 + 1
            goto L_0x000b
        L_0x002a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.bzy.mo4284b():java.lang.reflect.Type[]");
    }

    /* renamed from: c */
    public cbm<?>[] mo4285c() {
        Class[] exceptionTypes = this.f4404b.getExceptionTypes();
        cbm<?>[] cbmArr = new cbm[exceptionTypes.length];
        for (int i = 0; i < exceptionTypes.length; i++) {
            cbmArr[i] = cbn.m11175a(exceptionTypes[i]);
        }
        return cbmArr;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(Modifier.toString(mo4289f()));
        stringBuffer.append(" ");
        stringBuffer.append(this.f4405a);
        stringBuffer.append(".new");
        stringBuffer.append("(");
        cbm[] a = mo4283a();
        for (int i = 0; i < a.length - 1; i++) {
            stringBuffer.append(a[i].toString());
            stringBuffer.append(", ");
        }
        if (a.length > 0) {
            stringBuffer.append(a[a.length - 1].toString());
        }
        stringBuffer.append(")");
        return stringBuffer.toString();
    }
}
