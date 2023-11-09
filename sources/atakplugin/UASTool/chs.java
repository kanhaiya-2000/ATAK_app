package atakplugin.UASTool;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@cos(mo4819b = {cpj.BOOLEAN, cpj.BYTE, cpj.CHAR, cpj.DOUBLE, cpj.FLOAT, cpj.INT, cpj.LONG, cpj.SHORT}, mo4820c = {String.class})
@Documented
@Target({ElementType.TYPE_USE, ElementType.TYPE_PARAMETER})
@coe(mo4804a = {cpk.EXCEPTION_PARAMETER, cpk.UPPER_BOUND})
@cof(mo4805a = {cpk.PARAMETER})
@cph(mo4832a = {chu.class})
@coh
@Retention(RetentionPolicy.RUNTIME)
public @interface chs {
    @cov
    /* renamed from: a */
    String[] mo4671a() default {};
}
