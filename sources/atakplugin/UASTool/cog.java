package atakplugin.UASTool;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Target({ElementType.PACKAGE, ElementType.TYPE, ElementType.CONSTRUCTOR, ElementType.METHOD, ElementType.FIELD, ElementType.LOCAL_VARIABLE, ElementType.PARAMETER})
@Retention(RetentionPolicy.SOURCE)
public @interface cog {
    /* renamed from: a */
    Class<? extends Annotation> mo4806a();

    /* renamed from: b */
    cpk[] mo4807b() default {cpk.ALL};
}
