package atakplugin.UASTool;

import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.List;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0011\u0012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005¢\u0006\u0002\u0010\u0006J\u0013\u0010B\u001a\u00020\u00122\b\u0010C\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010D\u001a\u00020EH\u0002J\b\u0010F\u001a\u00020GH\u0016J\u0012\u0010H\u001a\u00020\u00122\b\u0010I\u001a\u0004\u0018\u00010\u0002H\u0017J\b\u0010J\u001a\u00020-H\u0016R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR \u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u000e0\r8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u00128VX\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u00128VX\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\u0014\u001a\u0004\b\u0016\u0010\u0015R\u001a\u0010\u0018\u001a\u00020\u00128VX\u0004¢\u0006\f\u0012\u0004\b\u0019\u0010\u0014\u001a\u0004\b\u0018\u0010\u0015R\u001a\u0010\u001a\u001a\u00020\u00128VX\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010\u0014\u001a\u0004\b\u001a\u0010\u0015R\u001a\u0010\u001c\u001a\u00020\u00128VX\u0004¢\u0006\f\u0012\u0004\b\u001d\u0010\u0014\u001a\u0004\b\u001c\u0010\u0015R\u001a\u0010\u001e\u001a\u00020\u00128VX\u0004¢\u0006\f\u0012\u0004\b\u001f\u0010\u0014\u001a\u0004\b\u001e\u0010\u0015R\u001a\u0010 \u001a\u00020\u00128VX\u0004¢\u0006\f\u0012\u0004\b!\u0010\u0014\u001a\u0004\b \u0010\u0015R\u0018\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u001e\u0010$\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030%0\r8VX\u0004¢\u0006\u0006\u001a\u0004\b&\u0010\u0010R\u001e\u0010'\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00010\r8VX\u0004¢\u0006\u0006\u001a\u0004\b(\u0010\u0010R\u0016\u0010)\u001a\u0004\u0018\u00010\u00028VX\u0004¢\u0006\u0006\u001a\u0004\b*\u0010+R\u0016\u0010,\u001a\u0004\u0018\u00010-8VX\u0004¢\u0006\u0006\u001a\u0004\b.\u0010/R(\u00100\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u00010\b8VX\u0004¢\u0006\f\u0012\u0004\b1\u0010\u0014\u001a\u0004\b2\u0010\u000bR\u0016\u00103\u001a\u0004\u0018\u00010-8VX\u0004¢\u0006\u0006\u001a\u0004\b4\u0010/R \u00105\u001a\b\u0012\u0004\u0012\u0002060\b8VX\u0004¢\u0006\f\u0012\u0004\b7\u0010\u0014\u001a\u0004\b8\u0010\u000bR \u00109\u001a\b\u0012\u0004\u0012\u00020:0\b8VX\u0004¢\u0006\f\u0012\u0004\b;\u0010\u0014\u001a\u0004\b<\u0010\u000bR\u001c\u0010=\u001a\u0004\u0018\u00010>8VX\u0004¢\u0006\f\u0012\u0004\b?\u0010\u0014\u001a\u0004\b@\u0010A¨\u0006K"}, mo1538e = {"Lkotlin/jvm/internal/ClassReference;", "Lkotlin/reflect/KClass;", "", "Lkotlin/jvm/internal/ClassBasedDeclarationContainer;", "jClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)V", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "constructors", "", "Lkotlin/reflect/KFunction;", "getConstructors", "()Ljava/util/Collection;", "isAbstract", "", "isAbstract$annotations", "()V", "()Z", "isCompanion", "isCompanion$annotations", "isData", "isData$annotations", "isFinal", "isFinal$annotations", "isInner", "isInner$annotations", "isOpen", "isOpen$annotations", "isSealed", "isSealed$annotations", "getJClass", "()Ljava/lang/Class;", "members", "Lkotlin/reflect/KCallable;", "getMembers", "nestedClasses", "getNestedClasses", "objectInstance", "getObjectInstance", "()Ljava/lang/Object;", "qualifiedName", "", "getQualifiedName", "()Ljava/lang/String;", "sealedSubclasses", "sealedSubclasses$annotations", "getSealedSubclasses", "simpleName", "getSimpleName", "supertypes", "Lkotlin/reflect/KType;", "supertypes$annotations", "getSupertypes", "typeParameters", "Lkotlin/reflect/KTypeParameter;", "typeParameters$annotations", "getTypeParameters", "visibility", "Lkotlin/reflect/KVisibility;", "visibility$annotations", "getVisibility", "()Lkotlin/reflect/KVisibility;", "equals", "other", "error", "", "hashCode", "", "isInstance", "value", "toString", "kotlin-stdlib"})
public final class bfb implements bfa, bji<Object> {

    /* renamed from: a */
    private final Class<?> f2601a;

    /* renamed from: B */
    public static /* synthetic */ void m6446B() {
    }

    /* renamed from: h */
    public static /* synthetic */ void m6448h() {
    }

    /* renamed from: j */
    public static /* synthetic */ void m6449j() {
    }

    /* renamed from: l */
    public static /* synthetic */ void m6450l() {
    }

    /* renamed from: n */
    public static /* synthetic */ void m6451n() {
    }

    /* renamed from: p */
    public static /* synthetic */ void m6452p() {
    }

    /* renamed from: r */
    public static /* synthetic */ void m6453r() {
    }

    /* renamed from: t */
    public static /* synthetic */ void m6454t() {
    }

    /* renamed from: v */
    public static /* synthetic */ void m6455v() {
    }

    /* renamed from: x */
    public static /* synthetic */ void m6456x() {
    }

    /* renamed from: z */
    public static /* synthetic */ void m6457z() {
    }

    public bfb(Class<?> cls) {
        bfq.m6567f(cls, "jClass");
        this.f2601a = cls;
    }

    /* renamed from: a */
    public Class<?> mo2350a() {
        return this.f2601a;
    }

    /* renamed from: b */
    public String mo2354b() {
        m6447D();
        throw null;
    }

    /* renamed from: c */
    public String mo2355c() {
        m6447D();
        throw null;
    }

    /* renamed from: d */
    public Collection<bjh<?>> mo2356d() {
        m6447D();
        throw null;
    }

    /* renamed from: e */
    public Collection<bjl<Object>> mo2357e() {
        m6447D();
        throw null;
    }

    /* renamed from: f */
    public Collection<bji<?>> mo2359f() {
        m6447D();
        throw null;
    }

    public List<Annotation> getAnnotations() {
        m6447D();
        throw null;
    }

    /* renamed from: g */
    public Object mo2360g() {
        m6447D();
        throw null;
    }

    /* renamed from: a */
    public boolean mo2353a(Object obj) {
        m6447D();
        throw null;
    }

    /* renamed from: i */
    public List<bjw> mo2362i() {
        m6447D();
        throw null;
    }

    /* renamed from: k */
    public List<bjv> mo2363k() {
        m6447D();
        throw null;
    }

    /* renamed from: m */
    public List<bji<? extends Object>> mo2364m() {
        m6447D();
        throw null;
    }

    /* renamed from: o */
    public bjz mo2365o() {
        m6447D();
        throw null;
    }

    /* renamed from: q */
    public boolean mo2366q() {
        m6447D();
        throw null;
    }

    /* renamed from: s */
    public boolean mo2367s() {
        m6447D();
        throw null;
    }

    /* renamed from: u */
    public boolean mo2369u() {
        m6447D();
        throw null;
    }

    /* renamed from: w */
    public boolean mo2370w() {
        m6447D();
        throw null;
    }

    /* renamed from: y */
    public boolean mo2371y() {
        m6447D();
        throw null;
    }

    /* renamed from: A */
    public boolean mo2351A() {
        m6447D();
        throw null;
    }

    /* renamed from: C */
    public boolean mo2352C() {
        m6447D();
        throw null;
    }

    /* renamed from: D */
    private final Void m6447D() {
        throw new bdd();
    }

    public boolean equals(Object obj) {
        return (obj instanceof bfb) && bfq.m6552a((Object) bcs.m6383d(this), (Object) bcs.m6383d((bji) obj));
    }

    public int hashCode() {
        return bcs.m6383d(this).hashCode();
    }

    public String toString() {
        return mo2350a().toString() + " (Kotlin reflection is not available)";
    }
}
