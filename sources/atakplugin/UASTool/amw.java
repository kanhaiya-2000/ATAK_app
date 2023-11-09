package atakplugin.UASTool;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Documented
@anq
@Retention(RetentionPolicy.RUNTIME)
public @interface amw {
    /* renamed from: a */
    anu mo1504a() default anu.ALWAYS;

    /* renamed from: atakplugin.UASTool.amw$a */
    public static class C0074a implements ant<amw> {
        /* renamed from: a */
        public anu mo1501a(amw amw, Object obj) {
            if (obj == null) {
                return anu.NEVER;
            }
            return anu.ALWAYS;
        }
    }
}
