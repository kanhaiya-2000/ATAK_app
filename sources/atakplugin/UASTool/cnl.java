package atakplugin.UASTool;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@coc(mo4802a = cnr.class)
@Target({ElementType.METHOD, ElementType.CONSTRUCTOR})
@cot
@Retention(RetentionPolicy.RUNTIME)
public @interface cnl {
    /* renamed from: a */
    String[] mo4791a();

    /* renamed from: b */
    boolean mo4792b();

    @cpc(mo4826a = "value")
    /* renamed from: c */
    int mo4793c() default 0;
}
