package atakplugin.UASTool;

import java.lang.reflect.Method;
import java.lang.reflect.Type;

public class bzr implements cbj {

    /* renamed from: a */
    private static final String f4358a = "org.aspectj.runtime.internal";

    /* renamed from: b */
    private final cbk f4359b;

    /* renamed from: c */
    private final Method f4360c;

    /* renamed from: d */
    private ccl f4361d;

    /* renamed from: e */
    private boolean f4362e = false;

    /* renamed from: f */
    private Type[] f4363f;

    /* renamed from: g */
    private cbm[] f4364g;

    /* renamed from: h */
    private cbm[] f4365h;

    protected bzr(Method method, String str, cbk cbk) {
        this.f4359b = cbk;
        this.f4360c = method;
        this.f4361d = new cae(str);
    }

    protected bzr(Method method, String str, cbk cbk, String str2) {
        this(method, str, cbk);
    }

    /* renamed from: a */
    public cbm mo4180a() {
        return cbn.m11175a(this.f4360c.getDeclaringClass());
    }

    /* renamed from: b */
    public Type[] mo4181b() {
        if (this.f4363f == null) {
            Type[] genericParameterTypes = this.f4360c.getGenericParameterTypes();
            int i = 0;
            int i2 = 0;
            for (Type type : genericParameterTypes) {
                if ((type instanceof Class) && ((Class) type).getPackage().getName().equals(f4358a)) {
                    i2++;
                }
            }
            this.f4363f = new Type[(genericParameterTypes.length - i2)];
            while (true) {
                Type[] typeArr = this.f4363f;
                if (i >= typeArr.length) {
                    break;
                }
                if (genericParameterTypes[i] instanceof Class) {
                    typeArr[i] = cbn.m11175a((Class) genericParameterTypes[i]);
                } else {
                    typeArr[i] = genericParameterTypes[i];
                }
                i++;
            }
        }
        return this.f4363f;
    }

    /* renamed from: c */
    public cbm<?>[] mo4182c() {
        if (this.f4364g == null) {
            Class[] parameterTypes = this.f4360c.getParameterTypes();
            int i = 0;
            int i2 = 0;
            for (Class cls : parameterTypes) {
                if (cls.getPackage().getName().equals(f4358a)) {
                    i2++;
                }
            }
            this.f4364g = new cbm[(parameterTypes.length - i2)];
            while (true) {
                cbm[] cbmArr = this.f4364g;
                if (i >= cbmArr.length) {
                    break;
                }
                cbmArr[i] = cbn.m11175a(parameterTypes[i]);
                i++;
            }
        }
        return this.f4364g;
    }

    /* renamed from: d */
    public cbm<?>[] mo4183d() {
        if (this.f4365h == null) {
            Class[] exceptionTypes = this.f4360c.getExceptionTypes();
            this.f4365h = new cbm[exceptionTypes.length];
            for (int i = 0; i < exceptionTypes.length; i++) {
                this.f4365h[i] = cbn.m11175a(exceptionTypes[i]);
            }
        }
        return this.f4365h;
    }

    /* renamed from: e */
    public cbk mo4184e() {
        return this.f4359b;
    }

    /* renamed from: f */
    public String mo4185f() {
        String name = this.f4360c.getName();
        if (!name.startsWith("ajc$")) {
            return name;
        }
        cas cas = (cas) this.f4360c.getAnnotation(cas.class);
        return cas != null ? cas.mo4356a() : "";
    }

    /* renamed from: g */
    public ccl mo4186g() {
        return this.f4361d;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00a6, code lost:
        if (r10 != 3) goto L_0x00dc;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String toString() {
        /*
            r12 = this;
            java.lang.StringBuffer r0 = new java.lang.StringBuffer
            r0.<init>()
            java.lang.String r1 = r12.mo4185f()
            int r1 = r1.length()
            if (r1 <= 0) goto L_0x0020
            java.lang.String r1 = "@AdviceName(\""
            r0.append(r1)
            java.lang.String r1 = r12.mo4185f()
            r0.append(r1)
            java.lang.String r1 = "\") "
            r0.append(r1)
        L_0x0020:
            atakplugin.UASTool.cbk r1 = r12.mo4184e()
            atakplugin.UASTool.cbk r2 = atakplugin.UASTool.cbk.AROUND
            java.lang.String r3 = " "
            if (r1 != r2) goto L_0x003a
            java.lang.reflect.Method r1 = r12.f4360c
            java.lang.reflect.Type r1 = r1.getGenericReturnType()
            java.lang.String r1 = r1.toString()
            r0.append(r1)
            r0.append(r3)
        L_0x003a:
            int[] r1 = atakplugin.UASTool.bzr.C02901.f4366a
            atakplugin.UASTool.cbk r2 = r12.mo4184e()
            int r2 = r2.ordinal()
            r1 = r1[r2]
            r2 = 3
            r4 = 2
            java.lang.String r5 = "after("
            r6 = 1
            if (r1 == r6) goto L_0x006c
            if (r1 == r4) goto L_0x0068
            if (r1 == r2) goto L_0x0064
            r5 = 4
            if (r1 == r5) goto L_0x005e
            r5 = 5
            if (r1 == r5) goto L_0x0058
            goto L_0x006f
        L_0x0058:
            java.lang.String r1 = "before("
            r0.append(r1)
            goto L_0x006f
        L_0x005e:
            java.lang.String r1 = "around("
            r0.append(r1)
            goto L_0x006f
        L_0x0064:
            r0.append(r5)
            goto L_0x006f
        L_0x0068:
            r0.append(r5)
            goto L_0x006f
        L_0x006c:
            r0.append(r5)
        L_0x006f:
            atakplugin.UASTool.cbm[] r1 = r12.mo4182c()
            int r5 = r1.length
            boolean r7 = r12.f4362e
            if (r7 == 0) goto L_0x007a
            int r5 = r5 + -1
        L_0x007a:
            r7 = 0
            r8 = 0
        L_0x007c:
            java.lang.String r9 = ","
            if (r8 >= r5) goto L_0x0091
            r10 = r1[r8]
            java.lang.String r10 = r10.mo4209a()
            r0.append(r10)
            int r8 = r8 + 1
            if (r8 >= r5) goto L_0x007c
            r0.append(r9)
            goto L_0x007c
        L_0x0091:
            java.lang.String r8 = ") "
            r0.append(r8)
            int[] r10 = atakplugin.UASTool.bzr.C02901.f4366a
            atakplugin.UASTool.cbk r11 = r12.mo4184e()
            int r11 = r11.ordinal()
            r10 = r10[r11]
            java.lang.String r11 = "("
            if (r10 == r4) goto L_0x00a9
            if (r10 == r2) goto L_0x00c3
            goto L_0x00dc
        L_0x00a9:
            java.lang.String r2 = "returning"
            r0.append(r2)
            boolean r2 = r12.f4362e
            if (r2 == 0) goto L_0x00c3
            r0.append(r11)
            int r2 = r5 + -1
            r2 = r1[r2]
            java.lang.String r2 = r2.mo4209a()
            r0.append(r2)
            r0.append(r8)
        L_0x00c3:
            java.lang.String r2 = "throwing"
            r0.append(r2)
            boolean r2 = r12.f4362e
            if (r2 == 0) goto L_0x00dc
            r0.append(r11)
            int r5 = r5 - r6
            r1 = r1[r5]
            java.lang.String r1 = r1.mo4209a()
            r0.append(r1)
            r0.append(r8)
        L_0x00dc:
            atakplugin.UASTool.cbm[] r1 = r12.mo4183d()
            int r2 = r1.length
            if (r2 <= 0) goto L_0x0100
            java.lang.String r2 = "throws "
            r0.append(r2)
        L_0x00e8:
            int r2 = r1.length
            if (r7 >= r2) goto L_0x00fd
            r2 = r1[r7]
            java.lang.String r2 = r2.mo4209a()
            r0.append(r2)
            int r7 = r7 + 1
            int r2 = r1.length
            if (r7 >= r2) goto L_0x00e8
            r0.append(r9)
            goto L_0x00e8
        L_0x00fd:
            r0.append(r3)
        L_0x0100:
            java.lang.String r1 = ": "
            r0.append(r1)
            atakplugin.UASTool.ccl r1 = r12.mo4186g()
            java.lang.String r1 = r1.mo4306a()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.bzr.toString():java.lang.String");
    }

    /* renamed from: atakplugin.UASTool.bzr$1 */
    /* synthetic */ class C02901 {

        /* renamed from: a */
        static final /* synthetic */ int[] f4366a;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                atakplugin.UASTool.cbk[] r0 = atakplugin.UASTool.cbk.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f4366a = r0
                atakplugin.UASTool.cbk r1 = atakplugin.UASTool.cbk.AFTER     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f4366a     // Catch:{ NoSuchFieldError -> 0x001d }
                atakplugin.UASTool.cbk r1 = atakplugin.UASTool.cbk.AFTER_RETURNING     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f4366a     // Catch:{ NoSuchFieldError -> 0x0028 }
                atakplugin.UASTool.cbk r1 = atakplugin.UASTool.cbk.AFTER_THROWING     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f4366a     // Catch:{ NoSuchFieldError -> 0x0033 }
                atakplugin.UASTool.cbk r1 = atakplugin.UASTool.cbk.AROUND     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f4366a     // Catch:{ NoSuchFieldError -> 0x003e }
                atakplugin.UASTool.cbk r1 = atakplugin.UASTool.cbk.BEFORE     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.bzr.C02901.<clinit>():void");
        }
    }
}
