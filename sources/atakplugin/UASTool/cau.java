package atakplugin.UASTool;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface cau {
    /* renamed from: a */
    String mo4359a() default "";

    /* renamed from: b */
    String mo4360b() default "";

    /* renamed from: c */
    String mo4361c() default "";

    /* renamed from: d */
    String mo4362d() default "";
}
