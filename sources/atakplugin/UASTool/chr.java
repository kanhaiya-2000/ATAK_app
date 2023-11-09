package atakplugin.UASTool;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Target({ElementType.TYPE_USE})
@cph(mo4832a = {chu.class})
@cpi(mo4833a = {cpk.RECEIVER, cpk.PARAMETER, cpk.RETURN})
@Retention(RetentionPolicy.RUNTIME)
public @interface chr {
    /* renamed from: a */
    int mo4670a() default -1;
}
