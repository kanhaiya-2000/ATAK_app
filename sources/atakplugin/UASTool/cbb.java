package atakplugin.UASTool;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface cbb {
    /* renamed from: a */
    String mo4400a();

    /* renamed from: b */
    Class[] mo4401b() default {Object.class};
}
