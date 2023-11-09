package atakplugin.UASTool;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Target({ElementType.TYPE_USE, ElementType.TYPE_PARAMETER})
@coe(mo4804a = {cpk.LOCAL_VARIABLE, cpk.RESOURCE_VARIABLE})
@cph(mo4832a = {})
@cpi(mo4833a = {cpk.EXPLICIT_LOWER_BOUND, cpk.EXPLICIT_UPPER_BOUND})
@Retention(RetentionPolicy.RUNTIME)
public @interface ced {
}
