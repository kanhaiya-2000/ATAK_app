package atakplugin.UASTool;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Target({ElementType.METHOD, ElementType.CONSTRUCTOR})
@Retention(RetentionPolicy.RUNTIME)
public @interface cpe {
    /* renamed from: a */
    String[] mo4828a();

    /* renamed from: b */
    Class<? extends Annotation> mo4829b();
}
