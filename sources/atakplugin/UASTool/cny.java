package atakplugin.UASTool;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Target({ElementType.METHOD, ElementType.CONSTRUCTOR})
@Retention(RetentionPolicy.RUNTIME)
public @interface cny {

    /* renamed from: atakplugin.UASTool.cny$a */
    public enum C0326a {
        SIDE_EFFECT_FREE,
        DETERMINISTIC
    }
}
