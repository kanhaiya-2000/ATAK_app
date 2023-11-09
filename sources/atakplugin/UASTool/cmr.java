package atakplugin.UASTool;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@cph(mo4832a = {cmv.class})
@Target({ElementType.TYPE_USE, ElementType.TYPE_PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface cmr {
    /* renamed from: a */
    String[] mo4711a();

    /* renamed from: b */
    String[] mo4712b();

    /* renamed from: c */
    int[] mo4713c();
}
