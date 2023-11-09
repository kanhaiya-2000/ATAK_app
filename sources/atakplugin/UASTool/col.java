package atakplugin.UASTool;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Target({ElementType.METHOD})
@cot
@Retention(RetentionPolicy.RUNTIME)
public @interface col {
    /* renamed from: a */
    String[] mo4811a();

    /* renamed from: b */
    Class<? extends Annotation> mo4812b();

    /* renamed from: c */
    boolean mo4813c();
}
