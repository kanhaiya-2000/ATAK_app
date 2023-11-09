package atakplugin.UASTool;

import java.lang.annotation.Annotation;
import java.util.List;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u001b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\u0017\u001a\u00020\u0013H\u0002J\u0013\u0010\u0018\u001a\u00020\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u0013H\u0016J\f\u0010\u0017\u001a\u00020\u0013*\u00020\u0006H\u0002R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00058VX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0011R\u001c\u0010\u0012\u001a\u00020\u0013*\u0006\u0012\u0002\b\u00030\u00148BX\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001e"}, mo1538e = {"Lkotlin/jvm/internal/TypeReference;", "Lkotlin/reflect/KType;", "classifier", "Lkotlin/reflect/KClassifier;", "arguments", "", "Lkotlin/reflect/KTypeProjection;", "isMarkedNullable", "", "(Lkotlin/reflect/KClassifier;Ljava/util/List;Z)V", "annotations", "", "getAnnotations", "()Ljava/util/List;", "getArguments", "getClassifier", "()Lkotlin/reflect/KClassifier;", "()Z", "arrayClassName", "", "Ljava/lang/Class;", "getArrayClassName", "(Ljava/lang/Class;)Ljava/lang/String;", "asString", "equals", "other", "", "hashCode", "", "toString", "kotlin-stdlib"})
public final class bgw implements bjv {

    /* renamed from: a */
    private final bjj f2682a;

    /* renamed from: b */
    private final List<bjx> f2683b;

    /* renamed from: c */
    private final boolean f2684c;

    public bgw(bjj bjj, List<bjx> list, boolean z) {
        bfq.m6567f(bjj, "classifier");
        bfq.m6567f(list, "arguments");
        this.f2682a = bjj;
        this.f2683b = list;
        this.f2684c = z;
    }

    /* renamed from: a */
    public bjj mo2508a() {
        return this.f2682a;
    }

    /* renamed from: b */
    public List<bjx> mo2509b() {
        return this.f2683b;
    }

    /* renamed from: c */
    public boolean mo2510c() {
        return this.f2684c;
    }

    public List<Annotation> getAnnotations() {
        return ato.m4604a();
    }

    public boolean equals(Object obj) {
        if (obj instanceof bgw) {
            bgw bgw = (bgw) obj;
            return bfq.m6552a((Object) mo2508a(), (Object) bgw.mo2508a()) && bfq.m6552a((Object) mo2509b(), (Object) bgw.mo2509b()) && mo2510c() == bgw.mo2510c();
        }
    }

    public int hashCode() {
        return (((mo2508a().hashCode() * 31) + mo2509b().hashCode()) * 31) + Boolean.valueOf(mo2510c()).hashCode();
    }

    public String toString() {
        return m6789d() + " (Kotlin reflection is not available)";
    }

    /* renamed from: d */
    private final String m6789d() {
        String str;
        String str2;
        bjj a = mo2508a();
        Class cls = null;
        if (!(a instanceof bji)) {
            a = null;
        }
        bji bji = (bji) a;
        if (bji != null) {
            cls = bcs.m6381b(bji);
        }
        if (cls == null) {
            str = mo2508a().toString();
        } else if (cls.isArray()) {
            str = m6788a((Class<?>) cls);
        } else {
            str = cls.getName();
        }
        String str3 = "";
        if (mo2509b().isEmpty()) {
            str2 = str3;
        } else {
            str2 = ato.m4738a(mo2509b(), ", ", "<", ">", 0, (CharSequence) null, new bgy(this), 24, (Object) null);
        }
        if (mo2510c()) {
            str3 = "?";
        }
        return str + str2 + str3;
    }

    /* renamed from: a */
    private final String m6788a(Class<?> cls) {
        if (bfq.m6552a((Object) cls, (Object) boolean[].class)) {
            return "kotlin.BooleanArray";
        }
        if (bfq.m6552a((Object) cls, (Object) char[].class)) {
            return "kotlin.CharArray";
        }
        if (bfq.m6552a((Object) cls, (Object) byte[].class)) {
            return "kotlin.ByteArray";
        }
        if (bfq.m6552a((Object) cls, (Object) short[].class)) {
            return "kotlin.ShortArray";
        }
        if (bfq.m6552a((Object) cls, (Object) int[].class)) {
            return "kotlin.IntArray";
        }
        if (bfq.m6552a((Object) cls, (Object) float[].class)) {
            return "kotlin.FloatArray";
        }
        if (bfq.m6552a((Object) cls, (Object) long[].class)) {
            return "kotlin.LongArray";
        }
        return bfq.m6552a((Object) cls, (Object) double[].class) ? "kotlin.DoubleArray" : "kotlin.Array";
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final String m6787a(bjx bjx) {
        String str;
        if (bjx.mo2665a() == null) {
            return "*";
        }
        bjv b = bjx.mo2666b();
        if (!(b instanceof bgw)) {
            b = null;
        }
        bgw bgw = (bgw) b;
        if (bgw == null || (str = bgw.m6789d()) == null) {
            str = String.valueOf(bjx.mo2666b());
        }
        bjy a = bjx.mo2665a();
        if (a != null) {
            int i = bgx.f2685a[a.ordinal()];
            if (i == 1) {
                return str;
            }
            if (i == 2) {
                return "in " + str;
            } else if (i == 3) {
                return "out " + str;
            }
        }
        throw new aou();
    }
}
