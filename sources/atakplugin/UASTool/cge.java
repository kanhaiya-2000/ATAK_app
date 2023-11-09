package atakplugin.UASTool;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE_USE, ElementType.TYPE_PARAMETER})
@cph(mo4832a = {cgd.class})
@Retention(RetentionPolicy.RUNTIME)
public @interface cge {
    @cov
    /* renamed from: a */
    String[] mo4654a();

    @cov
    /* renamed from: b */
    String[] mo4655b() default {};
}
