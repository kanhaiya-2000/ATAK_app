package atakplugin.UASTool;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

@Documented
@ane(mo1510a = "RegEx")
@Retention(RetentionPolicy.RUNTIME)
public @interface anc {
    /* renamed from: a */
    anu mo1508a() default anu.ALWAYS;

    /* renamed from: atakplugin.UASTool.anc$a */
    public static class C0076a implements ant<anc> {
        /* renamed from: a */
        public anu mo1501a(anc anc, Object obj) {
            if (!(obj instanceof String)) {
                return anu.NEVER;
            }
            try {
                Pattern.compile((String) obj);
                return anu.ALWAYS;
            } catch (PatternSyntaxException unused) {
                return anu.NEVER;
            }
        }
    }
}
