package atakplugin.UASTool;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

public class bzs<T> implements cbm<T> {

    /* renamed from: a */
    private static final String f4367a = "ajc$";

    /* renamed from: b */
    private Class<T> f4368b;

    /* renamed from: c */
    private ccj[] f4369c = null;

    /* renamed from: d */
    private ccj[] f4370d = null;

    /* renamed from: e */
    private cbj[] f4371e = null;

    /* renamed from: f */
    private cbj[] f4372f = null;

    /* renamed from: g */
    private ccb[] f4373g = null;

    /* renamed from: h */
    private ccb[] f4374h = null;

    /* renamed from: i */
    private cca[] f4375i = null;

    /* renamed from: j */
    private cca[] f4376j = null;

    /* renamed from: k */
    private cby[] f4377k = null;

    /* renamed from: l */
    private cby[] f4378l = null;

    /* renamed from: b */
    private void m10858b(List<cca> list, boolean z) {
    }

    public bzs(Class<T> cls) {
        this.f4368b = cls;
    }

    /* renamed from: a */
    public String mo4209a() {
        return this.f4368b.getName();
    }

    /* renamed from: b */
    public Package mo4218b() {
        return this.f4368b.getPackage();
    }

    /* renamed from: c */
    public cbm<?>[] mo4224c() {
        return m10856a((Class<?>[]) this.f4368b.getInterfaces());
    }

    /* renamed from: d */
    public int mo4225d() {
        return this.f4368b.getModifiers();
    }

    /* renamed from: e */
    public Class<T> mo4228e() {
        return this.f4368b;
    }

    /* renamed from: f */
    public cbm<? super T> mo4231f() {
        Class<? super T> superclass = this.f4368b.getSuperclass();
        if (superclass == null) {
            return null;
        }
        return new bzs(superclass);
    }

    /* renamed from: g */
    public Type mo4232g() {
        return this.f4368b.getGenericSuperclass();
    }

    /* renamed from: h */
    public Method mo4236h() {
        return this.f4368b.getEnclosingMethod();
    }

    /* renamed from: i */
    public Constructor mo4238i() {
        return this.f4368b.getEnclosingConstructor();
    }

    /* renamed from: j */
    public cbm<?> mo4240j() {
        Class<?> enclosingClass = this.f4368b.getEnclosingClass();
        if (enclosingClass != null) {
            return new bzs(enclosingClass);
        }
        return null;
    }

    /* renamed from: k */
    public cbm<?> mo4241k() {
        Class<?> declaringClass = this.f4368b.getDeclaringClass();
        if (declaringClass != null) {
            return new bzs(declaringClass);
        }
        return null;
    }

    /* renamed from: l */
    public cch mo4242l() {
        if (!mo4203P()) {
            return null;
        }
        String a = ((cax) this.f4368b.getAnnotation(cax.class)).mo4369a();
        if (a.equals("")) {
            if (mo4231f().mo4203P()) {
                return mo4231f().mo4242l();
            }
            return new cac(cci.SINGLETON);
        } else if (a.startsWith("perthis(")) {
            return new cad(cci.PERTHIS, a.substring(8, a.length() - 1));
        } else {
            if (a.startsWith("pertarget(")) {
                return new cad(cci.PERTARGET, a.substring(10, a.length() - 1));
            }
            if (a.startsWith("percflow(")) {
                return new cad(cci.PERCFLOW, a.substring(9, a.length() - 1));
            }
            if (a.startsWith("percflowbelow(")) {
                return new cad(cci.PERCFLOWBELOW, a.substring(14, a.length() - 1));
            }
            if (a.startsWith("pertypewithin")) {
                return new caj(cci.PERTYPEWITHIN, a.substring(14, a.length() - 1));
            }
            throw new IllegalStateException("Per-clause not recognized: " + a);
        }
    }

    public boolean isAnnotationPresent(Class<? extends Annotation> cls) {
        return this.f4368b.isAnnotationPresent(cls);
    }

    public <A extends Annotation> A getAnnotation(Class<A> cls) {
        return this.f4368b.getAnnotation(cls);
    }

    public Annotation[] getAnnotations() {
        return this.f4368b.getAnnotations();
    }

    public Annotation[] getDeclaredAnnotations() {
        return this.f4368b.getDeclaredAnnotations();
    }

    /* renamed from: m */
    public cbm<?>[] mo4243m() {
        return m10856a((Class<?>[]) this.f4368b.getClasses());
    }

    /* renamed from: n */
    public cbm<?>[] mo4244n() {
        return m10856a((Class<?>[]) this.f4368b.getDeclaredClasses());
    }

    /* renamed from: a */
    public Constructor mo4210a(cbm<?>... cbmArr) {
        return this.f4368b.getConstructor(m10861c(cbmArr));
    }

    /* renamed from: o */
    public Constructor[] mo4245o() {
        return this.f4368b.getConstructors();
    }

    /* renamed from: b */
    public Constructor mo4219b(cbm<?>... cbmArr) {
        return this.f4368b.getDeclaredConstructor(m10861c(cbmArr));
    }

    /* renamed from: p */
    public Constructor[] mo4246p() {
        return this.f4368b.getDeclaredConstructors();
    }

    /* renamed from: a */
    public Field mo4211a(String str) {
        Field declaredField = this.f4368b.getDeclaredField(str);
        if (!declaredField.getName().startsWith(f4367a)) {
            return declaredField;
        }
        throw new NoSuchFieldException(str);
    }

    /* renamed from: q */
    public Field[] mo4247q() {
        Field[] declaredFields = this.f4368b.getDeclaredFields();
        ArrayList arrayList = new ArrayList();
        for (Field field : declaredFields) {
            if (!field.getName().startsWith(f4367a) && !field.isAnnotationPresent(cbe.class) && !field.isAnnotationPresent(cba.class)) {
                arrayList.add(field);
            }
        }
        Field[] fieldArr = new Field[arrayList.size()];
        arrayList.toArray(fieldArr);
        return fieldArr;
    }

    /* renamed from: b */
    public Field mo4220b(String str) {
        Field field = this.f4368b.getField(str);
        if (!field.getName().startsWith(f4367a)) {
            return field;
        }
        throw new NoSuchFieldException(str);
    }

    /* renamed from: r */
    public Field[] mo4248r() {
        Field[] fields = this.f4368b.getFields();
        ArrayList arrayList = new ArrayList();
        for (Field field : fields) {
            if (!field.getName().startsWith(f4367a) && !field.isAnnotationPresent(cbe.class) && !field.isAnnotationPresent(cba.class)) {
                arrayList.add(field);
            }
        }
        Field[] fieldArr = new Field[arrayList.size()];
        arrayList.toArray(fieldArr);
        return fieldArr;
    }

    /* renamed from: a */
    public Method mo4212a(String str, cbm<?>... cbmArr) {
        Method declaredMethod = this.f4368b.getDeclaredMethod(str, m10861c(cbmArr));
        if (m10854a(declaredMethod)) {
            return declaredMethod;
        }
        throw new NoSuchMethodException(str);
    }

    /* renamed from: b */
    public Method mo4221b(String str, cbm<?>... cbmArr) {
        Method method = this.f4368b.getMethod(str, m10861c(cbmArr));
        if (m10854a(method)) {
            return method;
        }
        throw new NoSuchMethodException(str);
    }

    /* renamed from: s */
    public Method[] mo4249s() {
        Method[] declaredMethods = this.f4368b.getDeclaredMethods();
        ArrayList arrayList = new ArrayList();
        for (Method method : declaredMethods) {
            if (m10854a(method)) {
                arrayList.add(method);
            }
        }
        Method[] methodArr = new Method[arrayList.size()];
        arrayList.toArray(methodArr);
        return methodArr;
    }

    /* renamed from: t */
    public Method[] mo4250t() {
        Method[] methods = this.f4368b.getMethods();
        ArrayList arrayList = new ArrayList();
        for (Method method : methods) {
            if (m10854a(method)) {
                arrayList.add(method);
            }
        }
        Method[] methodArr = new Method[arrayList.size()];
        arrayList.toArray(methodArr);
        return methodArr;
    }

    /* renamed from: a */
    private boolean m10854a(Method method) {
        if (method.getName().startsWith(f4367a)) {
            return false;
        }
        if (method.getAnnotations().length == 0) {
            return true;
        }
        if (!method.isAnnotationPresent(cbf.class) && !method.isAnnotationPresent(cay.class) && !method.isAnnotationPresent(cat.class) && !method.isAnnotationPresent(cau.class) && !method.isAnnotationPresent(cav.class) && !method.isAnnotationPresent(caw.class)) {
            return true;
        }
        return false;
    }

    /* renamed from: c */
    public ccj mo4223c(String str) {
        for (ccj ccj : mo4252u()) {
            if (ccj.mo4309b().equals(str)) {
                return ccj;
            }
        }
        throw new ccg(str);
    }

    /* renamed from: d */
    public ccj mo4226d(String str) {
        for (ccj ccj : mo4253v()) {
            if (ccj.mo4309b().equals(str)) {
                return ccj;
            }
        }
        throw new ccg(str);
    }

    /* renamed from: u */
    public ccj[] mo4252u() {
        ccj[] ccjArr = this.f4369c;
        if (ccjArr != null) {
            return ccjArr;
        }
        ArrayList arrayList = new ArrayList();
        for (Method b : this.f4368b.getDeclaredMethods()) {
            ccj b2 = m10857b(b);
            if (b2 != null) {
                arrayList.add(b2);
            }
        }
        ccj[] ccjArr2 = new ccj[arrayList.size()];
        arrayList.toArray(ccjArr2);
        this.f4369c = ccjArr2;
        return ccjArr2;
    }

    /* renamed from: v */
    public ccj[] mo4253v() {
        ccj[] ccjArr = this.f4370d;
        if (ccjArr != null) {
            return ccjArr;
        }
        ArrayList arrayList = new ArrayList();
        for (Method b : this.f4368b.getMethods()) {
            ccj b2 = m10857b(b);
            if (b2 != null) {
                arrayList.add(b2);
            }
        }
        ccj[] ccjArr2 = new ccj[arrayList.size()];
        arrayList.toArray(ccjArr2);
        this.f4370d = ccjArr2;
        return ccjArr2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0016, code lost:
        r1 = r1.substring(r1.indexOf("$$") + 2, r1.length());
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private atakplugin.UASTool.ccj m10857b(java.lang.reflect.Method r9) {
        /*
            r8 = this;
            java.lang.Class<atakplugin.UASTool.cbf> r0 = atakplugin.UASTool.cbf.class
            java.lang.annotation.Annotation r0 = r9.getAnnotation(r0)
            atakplugin.UASTool.cbf r0 = (atakplugin.UASTool.cbf) r0
            if (r0 == 0) goto L_0x004d
            java.lang.String r1 = r9.getName()
            java.lang.String r2 = "ajc$"
            boolean r2 = r1.startsWith(r2)
            if (r2 == 0) goto L_0x0034
            java.lang.String r2 = "$$"
            int r2 = r1.indexOf(r2)
            int r2 = r2 + 2
            int r3 = r1.length()
            java.lang.String r1 = r1.substring(r2, r3)
            java.lang.String r2 = "$"
            int r2 = r1.indexOf(r2)
            r3 = -1
            if (r2 == r3) goto L_0x0034
            r3 = 0
            java.lang.String r1 = r1.substring(r3, r2)
        L_0x0034:
            r3 = r1
            atakplugin.UASTool.caf r1 = new atakplugin.UASTool.caf
            java.lang.String r4 = r0.mo4406a()
            java.lang.Class r2 = r9.getDeclaringClass()
            atakplugin.UASTool.cbm r6 = atakplugin.UASTool.cbn.m11175a(r2)
            java.lang.String r7 = r0.mo4407b()
            r2 = r1
            r5 = r9
            r2.<init>(r3, r4, r5, r6, r7)
            return r1
        L_0x004d:
            r9 = 0
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.bzs.m10857b(java.lang.reflect.Method):atakplugin.UASTool.ccj");
    }

    /* renamed from: a */
    public cbj[] mo4214a(cbk... cbkArr) {
        EnumSet<E> enumSet;
        if (cbkArr.length == 0) {
            enumSet = EnumSet.allOf(cbk.class);
        } else {
            EnumSet<E> noneOf = EnumSet.noneOf(cbk.class);
            noneOf.addAll(Arrays.asList(cbkArr));
            enumSet = noneOf;
        }
        return m10855a((Set) enumSet);
    }

    /* renamed from: b */
    public cbj[] mo4222b(cbk... cbkArr) {
        EnumSet<E> enumSet;
        if (cbkArr.length == 0) {
            enumSet = EnumSet.allOf(cbk.class);
        } else {
            EnumSet<E> noneOf = EnumSet.noneOf(cbk.class);
            noneOf.addAll(Arrays.asList(cbkArr));
            enumSet = noneOf;
        }
        return m10859b((Set) enumSet);
    }

    /* renamed from: a */
    private cbj[] m10855a(Set set) {
        if (this.f4371e == null) {
            m10850S();
        }
        ArrayList arrayList = new ArrayList();
        for (cbj cbj : this.f4371e) {
            if (set.contains(cbj.mo4184e())) {
                arrayList.add(cbj);
            }
        }
        cbj[] cbjArr = new cbj[arrayList.size()];
        arrayList.toArray(cbjArr);
        return cbjArr;
    }

    /* renamed from: S */
    private void m10850S() {
        Method[] declaredMethods = this.f4368b.getDeclaredMethods();
        ArrayList arrayList = new ArrayList();
        for (Method c : declaredMethods) {
            cbj c2 = m10860c(c);
            if (c2 != null) {
                arrayList.add(c2);
            }
        }
        cbj[] cbjArr = new cbj[arrayList.size()];
        this.f4371e = cbjArr;
        arrayList.toArray(cbjArr);
    }

    /* renamed from: b */
    private cbj[] m10859b(Set set) {
        if (this.f4372f == null) {
            m10851T();
        }
        ArrayList arrayList = new ArrayList();
        for (cbj cbj : this.f4372f) {
            if (set.contains(cbj.mo4184e())) {
                arrayList.add(cbj);
            }
        }
        cbj[] cbjArr = new cbj[arrayList.size()];
        arrayList.toArray(cbjArr);
        return cbjArr;
    }

    /* renamed from: T */
    private void m10851T() {
        Method[] methods = this.f4368b.getMethods();
        ArrayList arrayList = new ArrayList();
        for (Method c : methods) {
            cbj c2 = m10860c(c);
            if (c2 != null) {
                arrayList.add(c2);
            }
        }
        cbj[] cbjArr = new cbj[arrayList.size()];
        this.f4372f = cbjArr;
        arrayList.toArray(cbjArr);
    }

    /* renamed from: e */
    public cbj mo4227e(String str) {
        if (!str.equals("")) {
            if (this.f4372f == null) {
                m10851T();
            }
            for (cbj cbj : this.f4372f) {
                if (cbj.mo4185f().equals(str)) {
                    return cbj;
                }
            }
            throw new ccf(str);
        }
        throw new IllegalArgumentException("use getAdvice(AdviceType...) instead for un-named advice");
    }

    /* renamed from: f */
    public cbj mo4230f(String str) {
        if (!str.equals("")) {
            if (this.f4371e == null) {
                m10850S();
            }
            for (cbj cbj : this.f4371e) {
                if (cbj.mo4185f().equals(str)) {
                    return cbj;
                }
            }
            throw new ccf(str);
        }
        throw new IllegalArgumentException("use getAdvice(AdviceType...) instead for un-named advice");
    }

    /* renamed from: c */
    private cbj m10860c(Method method) {
        if (method.getAnnotations().length == 0) {
            return null;
        }
        cay cay = (cay) method.getAnnotation(cay.class);
        if (cay != null) {
            return new bzr(method, cay.mo4370a(), cbk.BEFORE);
        }
        cat cat = (cat) method.getAnnotation(cat.class);
        if (cat != null) {
            return new bzr(method, cat.mo4357a(), cbk.AFTER);
        }
        cau cau = (cau) method.getAnnotation(cau.class);
        if (cau != null) {
            String b = cau.mo4360b();
            if (b.equals("")) {
                b = cau.mo4359a();
            }
            return new bzr(method, b, cbk.AFTER_RETURNING, cau.mo4361c());
        }
        cav cav = (cav) method.getAnnotation(cav.class);
        if (cav != null) {
            String b2 = cav.mo4364b();
            if (b2 == null) {
                b2 = cav.mo4363a();
            }
            return new bzr(method, b2, cbk.AFTER_THROWING, cav.mo4365c());
        }
        caw caw = (caw) method.getAnnotation(caw.class);
        if (caw != null) {
            return new bzr(method, caw.mo4367a(), cbk.AROUND);
        }
        return null;
    }

    /* renamed from: a */
    public ccb mo4208a(String str, cbm<?> cbm, cbm<?>... cbmArr) {
        for (ccb ccb : mo4254w()) {
            try {
                if (ccb.mo4295a().equals(str)) {
                    if (ccb.mo4288e().equals(cbm)) {
                        cbm[] g = ccb.mo4298g();
                        if (g.length == cbmArr.length) {
                            int i = 0;
                            while (i < g.length) {
                                if (g[i].equals(cbmArr[i])) {
                                    i++;
                                }
                            }
                            return ccb;
                        }
                        continue;
                    } else {
                        continue;
                    }
                }
            } catch (ClassNotFoundException unused) {
            }
        }
        throw new NoSuchMethodException(str);
    }

    /* renamed from: w */
    public ccb[] mo4254w() {
        if (this.f4373g == null) {
            ArrayList arrayList = new ArrayList();
            for (Method method : this.f4368b.getDeclaredMethods()) {
                if (method.getName().contains("ajc$interMethodDispatch1$") && method.isAnnotationPresent(bzp.class)) {
                    bzp bzp = (bzp) method.getAnnotation(bzp.class);
                    arrayList.add(new cab(this, bzp.mo4178b(), bzp.mo4177a(), bzp.mo4179c(), method));
                }
            }
            m10853a((List<ccb>) arrayList, false);
            ccb[] ccbArr = new ccb[arrayList.size()];
            this.f4373g = ccbArr;
            arrayList.toArray(ccbArr);
        }
        return this.f4373g;
    }

    /* renamed from: b */
    public ccb mo4217b(String str, cbm<?> cbm, cbm<?>... cbmArr) {
        for (ccb ccb : mo4255x()) {
            try {
                if (ccb.mo4295a().equals(str)) {
                    if (ccb.mo4288e().equals(cbm)) {
                        cbm[] g = ccb.mo4298g();
                        if (g.length == cbmArr.length) {
                            int i = 0;
                            while (i < g.length) {
                                if (g[i].equals(cbmArr[i])) {
                                    i++;
                                }
                            }
                            return ccb;
                        }
                        continue;
                    } else {
                        continue;
                    }
                }
            } catch (ClassNotFoundException unused) {
            }
        }
        throw new NoSuchMethodException(str);
    }

    /* renamed from: x */
    public ccb[] mo4255x() {
        if (this.f4374h == null) {
            ArrayList arrayList = new ArrayList();
            for (Method method : this.f4368b.getDeclaredMethods()) {
                if (method.getName().contains("ajc$interMethod$") && method.isAnnotationPresent(bzp.class)) {
                    bzp bzp = (bzp) method.getAnnotation(bzp.class);
                    if (Modifier.isPublic(bzp.mo4177a())) {
                        arrayList.add(new cab(this, bzp.mo4178b(), bzp.mo4177a(), bzp.mo4179c(), method));
                    }
                }
            }
            m10853a((List<ccb>) arrayList, true);
            ccb[] ccbArr = new ccb[arrayList.size()];
            this.f4374h = ccbArr;
            arrayList.toArray(ccbArr);
        }
        return this.f4374h;
    }

    /* renamed from: a */
    private void m10853a(List<ccb> list, boolean z) {
        if (mo4203P()) {
            for (Field field : this.f4368b.getDeclaredFields()) {
                if (field.getType().isInterface() && field.isAnnotationPresent(cbc.class)) {
                    Class cls = cbc.class;
                    if (((cbc) field.getAnnotation(cls)).mo4403b() != cls) {
                        for (Method method : field.getType().getDeclaredMethods()) {
                            if (Modifier.isPublic(method.getModifiers()) || !z) {
                                list.add(new cab(this, cbn.m11175a(field.getType()), method, 1));
                            }
                        }
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public cby mo4206a(cbm<?> cbm, cbm<?>... cbmArr) {
        for (cby cby : mo4256y()) {
            try {
                if (cby.mo4288e().equals(cbm)) {
                    cbm[] a = cby.mo4283a();
                    if (a.length == cbmArr.length) {
                        int i = 0;
                        while (i < a.length) {
                            if (a[i].equals(cbmArr[i])) {
                                i++;
                            }
                        }
                        return cby;
                    }
                    continue;
                } else {
                    continue;
                }
            } catch (ClassNotFoundException unused) {
            }
        }
        throw new NoSuchMethodException();
    }

    /* renamed from: y */
    public cby[] mo4256y() {
        if (this.f4378l == null) {
            ArrayList arrayList = new ArrayList();
            for (Method method : this.f4368b.getDeclaredMethods()) {
                if (method.getName().contains("ajc$postInterConstructor") && method.isAnnotationPresent(bzp.class)) {
                    bzp bzp = (bzp) method.getAnnotation(bzp.class);
                    arrayList.add(new bzy(this, bzp.mo4178b(), bzp.mo4177a(), method));
                }
            }
            cby[] cbyArr = new cby[arrayList.size()];
            this.f4378l = cbyArr;
            arrayList.toArray(cbyArr);
        }
        return this.f4378l;
    }

    /* renamed from: b */
    public cby mo4215b(cbm<?> cbm, cbm<?>... cbmArr) {
        for (cby cby : mo4257z()) {
            try {
                if (cby.mo4288e().equals(cbm)) {
                    cbm[] a = cby.mo4283a();
                    if (a.length == cbmArr.length) {
                        int i = 0;
                        while (i < a.length) {
                            if (a[i].equals(cbmArr[i])) {
                                i++;
                            }
                        }
                        return cby;
                    }
                    continue;
                } else {
                    continue;
                }
            } catch (ClassNotFoundException unused) {
            }
        }
        throw new NoSuchMethodException();
    }

    /* renamed from: z */
    public cby[] mo4257z() {
        if (this.f4377k == null) {
            ArrayList arrayList = new ArrayList();
            for (Method method : this.f4368b.getMethods()) {
                if (method.getName().contains("ajc$postInterConstructor") && method.isAnnotationPresent(bzp.class)) {
                    bzp bzp = (bzp) method.getAnnotation(bzp.class);
                    if (Modifier.isPublic(bzp.mo4177a())) {
                        arrayList.add(new bzy(this, bzp.mo4178b(), bzp.mo4177a(), method));
                    }
                }
            }
            cby[] cbyArr = new cby[arrayList.size()];
            this.f4377k = cbyArr;
            arrayList.toArray(cbyArr);
        }
        return this.f4377k;
    }

    /* renamed from: a */
    public cca mo4207a(String str, cbm<?> cbm) {
        for (cca cca : mo4188A()) {
            if (cca.mo4291a().equals(str)) {
                try {
                    if (cca.mo4288e().equals(cbm)) {
                        return cca;
                    }
                } catch (ClassNotFoundException unused) {
                    continue;
                }
            }
        }
        throw new NoSuchFieldException(str);
    }

    /* renamed from: A */
    public cca[] mo4188A() {
        ArrayList arrayList = new ArrayList();
        if (this.f4375i == null) {
            for (Method method : this.f4368b.getDeclaredMethods()) {
                if (method.isAnnotationPresent(bzp.class) && method.getName().contains("ajc$interFieldInit")) {
                    bzp bzp = (bzp) method.getAnnotation(bzp.class);
                    try {
                        Method declaredMethod = this.f4368b.getDeclaredMethod(method.getName().replace("FieldInit", "FieldGetDispatch"), method.getParameterTypes());
                        arrayList.add(new caa(this, bzp.mo4178b(), bzp.mo4177a(), bzp.mo4179c(), cbn.m11175a(declaredMethod.getReturnType()), declaredMethod.getGenericReturnType()));
                    } catch (NoSuchMethodException unused) {
                        throw new IllegalStateException("Can't find field get dispatch method for " + method.getName());
                    }
                }
            }
            m10858b((List<cca>) arrayList, false);
            cca[] ccaArr = new cca[arrayList.size()];
            this.f4375i = ccaArr;
            arrayList.toArray(ccaArr);
        }
        return this.f4375i;
    }

    /* renamed from: b */
    public cca mo4216b(String str, cbm<?> cbm) {
        for (cca cca : mo4189B()) {
            if (cca.mo4291a().equals(str)) {
                try {
                    if (cca.mo4288e().equals(cbm)) {
                        return cca;
                    }
                } catch (ClassNotFoundException unused) {
                    continue;
                }
            }
        }
        throw new NoSuchFieldException(str);
    }

    /* renamed from: B */
    public cca[] mo4189B() {
        ArrayList arrayList = new ArrayList();
        if (this.f4376j == null) {
            for (Method method : this.f4368b.getMethods()) {
                if (method.isAnnotationPresent(bzp.class)) {
                    bzp bzp = (bzp) method.getAnnotation(bzp.class);
                    if (method.getName().contains("ajc$interFieldInit") && Modifier.isPublic(bzp.mo4177a())) {
                        try {
                            Method declaredMethod = method.getDeclaringClass().getDeclaredMethod(method.getName().replace("FieldInit", "FieldGetDispatch"), method.getParameterTypes());
                            arrayList.add(new caa(this, bzp.mo4178b(), bzp.mo4177a(), bzp.mo4179c(), cbn.m11175a(declaredMethod.getReturnType()), declaredMethod.getGenericReturnType()));
                        } catch (NoSuchMethodException unused) {
                            throw new IllegalStateException("Can't find field get dispatch method for " + method.getName());
                        }
                    }
                }
            }
            m10858b((List<cca>) arrayList, true);
            cca[] ccaArr = new cca[arrayList.size()];
            this.f4376j = ccaArr;
            arrayList.toArray(ccaArr);
        }
        return this.f4376j;
    }

    /* renamed from: C */
    public cbs[] mo4190C() {
        ArrayList arrayList = new ArrayList();
        for (Field field : this.f4368b.getDeclaredFields()) {
            try {
                if (field.isAnnotationPresent(cbe.class)) {
                    cbe cbe = (cbe) field.getAnnotation(cbe.class);
                    if (Modifier.isPublic(field.getModifiers()) && Modifier.isStatic(field.getModifiers())) {
                        arrayList.add(new bzu(cbe.mo4405a(), (String) field.get((Object) null), false, this));
                    }
                } else if (field.isAnnotationPresent(cba.class)) {
                    cba cba = (cba) field.getAnnotation(cba.class);
                    if (Modifier.isPublic(field.getModifiers()) && Modifier.isStatic(field.getModifiers())) {
                        arrayList.add(new bzu(cba.mo4399a(), (String) field.get((Object) null), true, this));
                    }
                }
            } catch (IllegalAccessException | IllegalArgumentException unused) {
            }
        }
        for (Method method : this.f4368b.getDeclaredMethods()) {
            if (method.isAnnotationPresent(bzl.class)) {
                bzl bzl = (bzl) method.getAnnotation(bzl.class);
                arrayList.add(new bzu(bzl.mo4169b(), bzl.mo4168a(), bzl.mo4170c(), this));
            }
        }
        cbs[] cbsArr = new cbs[arrayList.size()];
        arrayList.toArray(cbsArr);
        return cbsArr;
    }

    /* renamed from: D */
    public cbt[] mo4191D() {
        ArrayList arrayList = new ArrayList();
        for (Method method : this.f4368b.getDeclaredMethods()) {
            if (method.isAnnotationPresent(bzm.class)) {
                bzm bzm = (bzm) method.getAnnotation(bzm.class);
                arrayList.add(new bzv(bzm.mo4171a(), bzm.mo4172b(), bzm.mo4173c(), this));
            }
        }
        m10852a((List<cbt>) arrayList);
        if (mo4231f().mo4203P()) {
            arrayList.addAll(Arrays.asList(mo4231f().mo4191D()));
        }
        cbt[] cbtArr = new cbt[arrayList.size()];
        arrayList.toArray(cbtArr);
        return cbtArr;
    }

    /* renamed from: a */
    private void m10852a(List<cbt> list) {
        for (Field field : this.f4368b.getDeclaredFields()) {
            if (field.isAnnotationPresent(cbc.class) && field.getType().isInterface()) {
                list.add(new bzv(((cbc) field.getAnnotation(cbc.class)).mo4402a(), field.getType().getName(), false, this));
            }
        }
    }

    /* renamed from: E */
    public cbv[] mo4192E() {
        ArrayList arrayList = new ArrayList();
        for (Method method : this.f4368b.getDeclaredMethods()) {
            if (method.isAnnotationPresent(bzo.class)) {
                bzo bzo = (bzo) method.getAnnotation(bzo.class);
                arrayList.add(new bzx(this, bzo.mo4176b(), bzo.mo4175a()));
            }
        }
        if (mo4231f().mo4203P()) {
            arrayList.addAll(Arrays.asList(mo4231f().mo4192E()));
        }
        cbv[] cbvArr = new cbv[arrayList.size()];
        arrayList.toArray(cbvArr);
        return cbvArr;
    }

    /* renamed from: F */
    public cbr[] mo4193F() {
        Annotation annotation;
        ArrayList arrayList = new ArrayList();
        for (Method method : this.f4368b.getDeclaredMethods()) {
            if (method.isAnnotationPresent(bzk.class)) {
                bzk bzk = (bzk) method.getAnnotation(bzk.class);
                Annotation[] annotations = method.getAnnotations();
                int length = annotations.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        annotation = null;
                        break;
                    }
                    Annotation annotation2 = annotations[i];
                    if (annotation2.annotationType() != bzk.class) {
                        annotation = annotation2;
                        break;
                    }
                    i++;
                }
                arrayList.add(new bzt(this, bzk.mo4167c(), bzk.mo4165a(), annotation, bzk.mo4166b()));
            }
        }
        if (mo4231f().mo4203P()) {
            arrayList.addAll(Arrays.asList(mo4231f().mo4193F()));
        }
        cbr[] cbrArr = new cbr[arrayList.size()];
        arrayList.toArray(cbrArr);
        return cbrArr;
    }

    /* renamed from: G */
    public cbu[] mo4194G() {
        ArrayList arrayList = new ArrayList();
        if (this.f4368b.isAnnotationPresent(cbd.class)) {
            arrayList.add(new bzw(((cbd) this.f4368b.getAnnotation(cbd.class)).mo4404a(), this));
        }
        for (Method method : this.f4368b.getDeclaredMethods()) {
            if (method.isAnnotationPresent(bzn.class)) {
                arrayList.add(new bzw(((bzn) method.getAnnotation(bzn.class)).mo4174a(), this));
            }
        }
        if (mo4231f().mo4203P()) {
            arrayList.addAll(Arrays.asList(mo4231f().mo4194G()));
        }
        cbu[] cbuArr = new cbu[arrayList.size()];
        arrayList.toArray(cbuArr);
        return cbuArr;
    }

    /* renamed from: H */
    public T[] mo4195H() {
        return this.f4368b.getEnumConstants();
    }

    /* renamed from: I */
    public TypeVariable<Class<T>>[] mo4196I() {
        return this.f4368b.getTypeParameters();
    }

    /* renamed from: J */
    public boolean mo4197J() {
        return this.f4368b.isEnum();
    }

    /* renamed from: a */
    public boolean mo4213a(Object obj) {
        return this.f4368b.isInstance(obj);
    }

    /* renamed from: K */
    public boolean mo4198K() {
        return this.f4368b.isInterface();
    }

    /* renamed from: L */
    public boolean mo4199L() {
        return this.f4368b.isLocalClass() && !mo4203P();
    }

    /* renamed from: M */
    public boolean mo4200M() {
        return this.f4368b.isMemberClass() && !mo4203P();
    }

    /* renamed from: N */
    public boolean mo4201N() {
        return this.f4368b.isArray();
    }

    /* renamed from: O */
    public boolean mo4202O() {
        return this.f4368b.isPrimitive();
    }

    /* renamed from: P */
    public boolean mo4203P() {
        return this.f4368b.getAnnotation(cax.class) != null;
    }

    /* renamed from: Q */
    public boolean mo4204Q() {
        return this.f4368b.isMemberClass() && mo4203P();
    }

    /* renamed from: R */
    public boolean mo4205R() {
        return mo4203P() && this.f4368b.isAnnotationPresent(bzq.class);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof bzs)) {
            return false;
        }
        return ((bzs) obj).f4368b.equals(this.f4368b);
    }

    public int hashCode() {
        return this.f4368b.hashCode();
    }

    /* renamed from: a */
    private cbm<?>[] m10856a(Class<?>[] clsArr) {
        int length = clsArr.length;
        cbm<?>[] cbmArr = new cbm[length];
        for (int i = 0; i < length; i++) {
            cbmArr[i] = cbn.m11175a(clsArr[i]);
        }
        return cbmArr;
    }

    /* renamed from: c */
    private Class<?>[] m10861c(cbm<?>[] cbmArr) {
        int length = cbmArr.length;
        Class<?>[] clsArr = new Class[length];
        for (int i = 0; i < length; i++) {
            clsArr[i] = cbmArr[i].mo4228e();
        }
        return clsArr;
    }

    public String toString() {
        return mo4209a();
    }
}
