package atakplugin.UASTool;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@coc(mo4802a = cis.class)
@Documented
@Target({ElementType.METHOD, ElementType.CONSTRUCTOR})
@cot
@Retention(RetentionPolicy.RUNTIME)
public @interface cip {
    /* renamed from: a */
    boolean mo4679a();

    /* renamed from: b */
    String[] mo4680b();

    @cov
    @cpc(mo4826a = "value")
    /* renamed from: c */
    String[] mo4681c();
}
