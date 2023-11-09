package atakplugin.UASTool;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@coc(mo4802a = chw.class)
@Documented
@Target({ElementType.METHOD, ElementType.CONSTRUCTOR})
@cot
@Retention(RetentionPolicy.RUNTIME)
public @interface chq {
    /* renamed from: a */
    String[] mo4668a();

    /* renamed from: b */
    boolean mo4669b();
}
