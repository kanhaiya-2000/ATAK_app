package atakplugin.UASTool;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE_USE, ElementType.TYPE_PARAMETER})
@cph(mo4832a = {cjp.class})
@Retention(RetentionPolicy.RUNTIME)
public @interface cjn {
    /* renamed from: a */
    int mo4694a() default 0;
}
