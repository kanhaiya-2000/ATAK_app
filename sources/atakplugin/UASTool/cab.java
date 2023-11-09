package atakplugin.UASTool;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

public class cab extends bzz implements ccb {

    /* renamed from: b */
    private String f4412b;

    /* renamed from: c */
    private Method f4413c;

    /* renamed from: d */
    private int f4414d;

    /* renamed from: e */
    private cbm<?>[] f4415e;

    /* renamed from: f */
    private Type[] f4416f;

    /* renamed from: g */
    private cbm<?> f4417g;

    /* renamed from: h */
    private Type f4418h;

    /* renamed from: i */
    private cbm<?>[] f4419i;

    public cab(cbm<?> cbm, String str, int i, String str2, Method method) {
        super(cbm, str, i);
        this.f4414d = 1;
        this.f4412b = str2;
        this.f4413c = method;
    }

    public cab(cbm<?> cbm, cbm<?> cbm2, Method method, int i) {
        super(cbm, cbm2, i);
        this.f4414d = 1;
        this.f4414d = 0;
        this.f4412b = method.getName();
        this.f4413c = method;
    }

    /* renamed from: a */
    public String mo4295a() {
        return this.f4412b;
    }

    /* renamed from: b */
    public cbm<?> mo4296b() {
        return cbn.m11175a(this.f4413c.getReturnType());
    }

    /* renamed from: c */
    public Type mo4297c() {
        Type genericReturnType = this.f4413c.getGenericReturnType();
        return genericReturnType instanceof Class ? cbn.m11175a((Class) genericReturnType) : genericReturnType;
    }

    /* renamed from: g */
    public cbm<?>[] mo4298g() {
        Class[] parameterTypes = this.f4413c.getParameterTypes();
        int length = parameterTypes.length;
        int i = this.f4414d;
        cbm<?>[] cbmArr = new cbm[(length - i)];
        while (i < parameterTypes.length) {
            cbmArr[i - this.f4414d] = cbn.m11175a(parameterTypes[i]);
            i++;
        }
        return cbmArr;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: atakplugin.UASTool.cbm[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: h */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.reflect.Type[] mo4299h() {
        /*
            r5 = this;
            java.lang.reflect.Method r0 = r5.f4413c
            java.lang.reflect.Type[] r0 = r0.getGenericParameterTypes()
            int r1 = r0.length
            int r2 = r5.f4414d
            int r1 = r1 - r2
            atakplugin.UASTool.cbm[] r1 = new atakplugin.UASTool.cbm[r1]
        L_0x000c:
            int r3 = r0.length
            if (r2 >= r3) goto L_0x002f
            r3 = r0[r2]
            boolean r3 = r3 instanceof java.lang.Class
            if (r3 == 0) goto L_0x0024
            int r3 = r5.f4414d
            int r3 = r2 - r3
            r4 = r0[r2]
            java.lang.Class r4 = (java.lang.Class) r4
            atakplugin.UASTool.cbm r4 = atakplugin.UASTool.cbn.m11175a(r4)
            r1[r3] = r4
            goto L_0x002c
        L_0x0024:
            int r3 = r5.f4414d
            int r3 = r2 - r3
            r4 = r0[r2]
            r1[r3] = r4
        L_0x002c:
            int r2 = r2 + 1
            goto L_0x000c
        L_0x002f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.cab.mo4299h():java.lang.reflect.Type[]");
    }

    /* renamed from: i */
    public TypeVariable<Method>[] mo4300i() {
        return this.f4413c.getTypeParameters();
    }

    /* renamed from: j */
    public cbm<?>[] mo4301j() {
        Class[] exceptionTypes = this.f4413c.getExceptionTypes();
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
        stringBuffer.append(mo4296b().toString());
        stringBuffer.append(" ");
        stringBuffer.append(this.f4405a);
        stringBuffer.append(".");
        stringBuffer.append(mo4295a());
        stringBuffer.append("(");
        cbm[] g = mo4298g();
        for (int i = 0; i < g.length - 1; i++) {
            stringBuffer.append(g[i].toString());
            stringBuffer.append(", ");
        }
        if (g.length > 0) {
            stringBuffer.append(g[g.length - 1].toString());
        }
        stringBuffer.append(")");
        return stringBuffer.toString();
    }
}
