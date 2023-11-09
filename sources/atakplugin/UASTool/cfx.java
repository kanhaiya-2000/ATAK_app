package atakplugin.UASTool;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@coc(mo4802a = cge.class)
@Documented
@Target({ElementType.METHOD, ElementType.CONSTRUCTOR})
@cot
@Retention(RetentionPolicy.RUNTIME)
public @interface cfx {
    /* renamed from: a */
    String[] mo4630a();

    /* renamed from: b */
    boolean mo4631b();

    @cov
    @cpc(mo4826a = "value")
    /* renamed from: c */
    String[] mo4632c();

    @cov
    @cpc(mo4826a = "offset")
    /* renamed from: d */
    String[] mo4633d() default {};
}
