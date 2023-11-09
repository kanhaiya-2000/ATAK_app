package atakplugin.UASTool;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE_PARAMETER, ElementType.TYPE_USE})
@cph(mo4832a = {cnw.class})
@Retention(RetentionPolicy.RUNTIME)
public @interface cnm {
    /* renamed from: a */
    long mo4794a() default Long.MIN_VALUE;

    /* renamed from: b */
    long mo4795b() default Long.MAX_VALUE;
}
