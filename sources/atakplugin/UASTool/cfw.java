package atakplugin.UASTool;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Target({ElementType.METHOD, ElementType.CONSTRUCTOR})
@cot
@cpa(mo4824a = cge.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface cfw {
    /* renamed from: a */
    String[] mo4627a();

    @cov
    @cpc(mo4826a = "value")
    /* renamed from: b */
    String[] mo4628b();

    @cov
    @cpc(mo4826a = "offset")
    /* renamed from: c */
    String[] mo4629c() default {};
}
