package atakplugin.UASTool;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Target({ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.FIELD})
@Retention(RetentionPolicy.CLASS)
public @interface cps {
    /* renamed from: a */
    String mo4839a();
}
