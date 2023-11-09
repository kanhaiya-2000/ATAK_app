package atakplugin.UASTool;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@cph(mo4832a = {cgz.class})
@Target({ElementType.TYPE_USE, ElementType.TYPE_PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface cgy {
    @cov
    /* renamed from: a */
    String[] mo4661a();
}
