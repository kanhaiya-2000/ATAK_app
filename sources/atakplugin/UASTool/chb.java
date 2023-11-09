package atakplugin.UASTool;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@cph(mo4832a = {chc.class})
@Target({ElementType.TYPE_USE, ElementType.TYPE_PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface chb {
    @cov
    /* renamed from: a */
    String[] mo4663a();

    @cov
    /* renamed from: b */
    String[] mo4664b();
}
