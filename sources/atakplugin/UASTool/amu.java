package atakplugin.UASTool;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.regex.Pattern;

@Documented
@anq(mo1514a = String.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface amu {
    @anc
    /* renamed from: a */
    String mo1498a();

    /* renamed from: b */
    int mo1499b() default 0;

    /* renamed from: atakplugin.UASTool.amu$a */
    public static class C0072a implements ant<amu> {
        /* renamed from: a */
        public anu mo1501a(amu amu, Object obj) {
            if (Pattern.compile(amu.mo1498a(), amu.mo1499b()).matcher((String) obj).matches()) {
                return anu.ALWAYS;
            }
            return anu.NEVER;
        }
    }
}
