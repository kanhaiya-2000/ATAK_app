package atakplugin.UASTool;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Inherited
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface coo {
    /* renamed from: a */
    Class<? extends Annotation>[] mo4816a();

    /* renamed from: b */
    String[] mo4817b();
}
