package atakplugin.UASTool;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE_PARAMETER, ElementType.TYPE_USE})
@cph(mo4832a = {cnw.class})
@Retention(RetentionPolicy.RUNTIME)
public @interface cnh {
    /* renamed from: a */
    int mo4787a() default 0;

    /* renamed from: b */
    int mo4788b() default Integer.MAX_VALUE;
}
