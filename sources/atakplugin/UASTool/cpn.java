package atakplugin.UASTool;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.CLASS)
public @interface cpn {
    /* renamed from: a */
    String mo4835a() default "";

    /* renamed from: b */
    boolean mo4836b() default false;
}
