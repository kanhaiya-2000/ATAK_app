package atakplugin.UASTool;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface bzm {
    /* renamed from: a */
    String mo4171a();

    /* renamed from: b */
    String mo4172b();

    /* renamed from: c */
    boolean mo4173c();
}
