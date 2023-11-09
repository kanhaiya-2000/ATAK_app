package atakplugin.UASTool;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Target({ElementType.TYPE_USE, ElementType.TYPE_PARAMETER})
@cph(mo4832a = {chj.class})
@Retention(RetentionPolicy.RUNTIME)
public @interface chi {
    /* renamed from: a */
    Class<?> mo4665a() default Object.class;
}
