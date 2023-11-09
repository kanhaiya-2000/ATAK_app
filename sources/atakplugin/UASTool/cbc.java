package atakplugin.UASTool;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface cbc {
    /* renamed from: a */
    String mo4402a();

    /* renamed from: b */
    Class mo4403b() default cbc.class;
}
