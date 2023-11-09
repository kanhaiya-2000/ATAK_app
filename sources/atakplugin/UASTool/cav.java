package atakplugin.UASTool;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface cav {
    /* renamed from: a */
    String mo4363a() default "";

    /* renamed from: b */
    String mo4364b() default "";

    /* renamed from: c */
    String mo4365c() default "";

    /* renamed from: d */
    String mo4366d() default "";
}
