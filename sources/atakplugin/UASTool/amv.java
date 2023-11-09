package atakplugin.UASTool;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Documented
@anq(mo1514a = Number.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface amv {
    /* renamed from: a */
    anu mo1502a() default anu.ALWAYS;

    /* renamed from: atakplugin.UASTool.amv$a */
    public static class C0073a implements ant<amv> {
        /* renamed from: a */
        public anu mo1501a(amv amv, Object obj) {
            if (!(obj instanceof Number)) {
                return anu.NEVER;
            }
            Number number = (Number) obj;
            boolean z = true;
            if (!(number instanceof Long) ? !(number instanceof Double) ? !(number instanceof Float) ? number.intValue() >= 0 : number.floatValue() >= 0.0f : number.doubleValue() >= 0.0d : number.longValue() >= 0) {
                z = false;
            }
            if (z) {
                return anu.NEVER;
            }
            return anu.ALWAYS;
        }
    }
}
