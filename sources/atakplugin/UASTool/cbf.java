package atakplugin.UASTool;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface cbf {
    /* renamed from: a */
    String mo4406a() default "";

    /* renamed from: b */
    String mo4407b() default "";
}
