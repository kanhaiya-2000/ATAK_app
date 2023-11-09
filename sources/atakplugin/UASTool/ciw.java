package atakplugin.UASTool;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Target({ElementType.TYPE_USE, ElementType.TYPE_PARAMETER})
@coe(mo4804a = {cpk.IMPLICIT_UPPER_BOUND, cpk.IMPLICIT_LOWER_BOUND, cpk.EXCEPTION_PARAMETER})
@cph(mo4832a = {cjb.class})
@coh
@Retention(RetentionPolicy.RUNTIME)
public @interface ciw {
}
