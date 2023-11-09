package atakplugin.UASTool;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@coc(mo4802a = civ.class)
@Documented
@Target({ElementType.METHOD, ElementType.CONSTRUCTOR})
@cot
@Retention(RetentionPolicy.RUNTIME)
public @interface cir {
    /* renamed from: a */
    String[] mo4683a();

    /* renamed from: b */
    boolean mo4684b();
}
