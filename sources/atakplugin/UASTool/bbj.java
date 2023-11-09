package atakplugin.UASTool;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@arb
@arc(mo1692a = aqy.SOURCE)
@ard(mo1693a = {aqz.CLASS, aqz.FUNCTION, aqz.PROPERTY, aqz.CONSTRUCTOR, aqz.TYPEALIAS})
@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B0\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\nR\u000f\u0010\t\u001a\u00020\n¢\u0006\u0006\u001a\u0004\b\t\u0010\u000bR\u000f\u0010\u0005\u001a\u00020\u0006¢\u0006\u0006\u001a\u0004\b\u0005\u0010\fR\u000f\u0010\u0004\u001a\u00020\u0003¢\u0006\u0006\u001a\u0004\b\u0004\u0010\rR\u000f\u0010\u0002\u001a\u00020\u0003¢\u0006\u0006\u001a\u0004\b\u0002\u0010\rR\u000f\u0010\u0007\u001a\u00020\b¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u000e¨\u0006\u000f"}, mo1538e = {"Lkotlin/internal/RequireKotlin;", "", "version", "", "message", "level", "Lkotlin/DeprecationLevel;", "versionKind", "Lkotlin/internal/RequireKotlinVersionKind;", "errorCode", "", "()I", "()Lkotlin/DeprecationLevel;", "()Ljava/lang/String;", "()Lkotlin/internal/RequireKotlinVersionKind;", "kotlin-stdlib"})
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR})
@Retention(RetentionPolicy.SOURCE)
public @interface bbj {
    /* renamed from: a */
    String mo2239a();

    /* renamed from: b */
    String mo2240b() default "";

    /* renamed from: c */
    any mo2241c() default any.ERROR;

    /* renamed from: d */
    bbk mo2242d() default bbk.LANGUAGE_VERSION;

    /* renamed from: e */
    int mo2243e() default -1;
}
