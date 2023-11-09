package atakplugin.UASTool;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface bzl {
    /* renamed from: a */
    String mo4168a();

    /* renamed from: b */
    String mo4169b();

    /* renamed from: c */
    boolean mo4170c();
}
