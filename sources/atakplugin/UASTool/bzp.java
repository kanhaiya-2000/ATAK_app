package atakplugin.UASTool;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface bzp {
    /* renamed from: a */
    int mo4177a();

    /* renamed from: b */
    String mo4178b();

    /* renamed from: c */
    String mo4179c();
}
