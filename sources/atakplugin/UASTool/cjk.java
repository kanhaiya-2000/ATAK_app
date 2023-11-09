package atakplugin.UASTool;

import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public final class cjk {
    private cjk() {
        throw new Error("do not instantiate");
    }

    /* renamed from: atakplugin.UASTool.cjk$a */
    public static class C0321a extends Exception {

        /* renamed from: a */
        private static final long f4643a = 6266881831979001480L;

        /* renamed from: b */
        private final PatternSyntaxException f4644b;

        public C0321a(PatternSyntaxException patternSyntaxException) {
            this.f4644b = patternSyntaxException;
        }

        public C0321a(String str, String str2, int i) {
            this(new PatternSyntaxException(str, str2, i));
        }

        /* renamed from: a */
        public String mo4689a() {
            return this.f4644b.getDescription();
        }

        /* renamed from: b */
        public int mo4690b() {
            return this.f4644b.getIndex();
        }

        @cny
        public String getMessage() {
            return this.f4644b.getMessage();
        }

        /* renamed from: c */
        public String mo4691c() {
            return this.f4644b.getPattern();
        }
    }

    @cny
    @col(mo4811a = {"#1"}, mo4812b = cjn.class, mo4813c = true)
    /* renamed from: a */
    public static boolean m11654a(String str) {
        return m11655a(str, 0);
    }

    @cny
    @col(mo4811a = {"#1"}, mo4812b = cjn.class, mo4813c = true)
    /* renamed from: a */
    public static boolean m11655a(String str, int i) {
        try {
            if (m11651a(Pattern.compile(str)) >= i) {
                return true;
            }
            return false;
        } catch (PatternSyntaxException unused) {
            return false;
        }
    }

    @cny
    @col(mo4811a = {"#1"}, mo4812b = cjn.class, mo4813c = true)
    /* renamed from: a */
    public static boolean m11653a(char c) {
        return m11654a(Character.toString(c));
    }

    @cnz
    /* renamed from: b */
    public static String m11656b(String str) {
        return m11657b(str, 0);
    }

    @cnz
    /* renamed from: b */
    public static String m11657b(String str, int i) {
        try {
            int a = m11651a(Pattern.compile(str));
            if (a < i) {
                return m11652a(str, i, a);
            }
            return null;
        } catch (PatternSyntaxException e) {
            return e.getMessage();
        }
    }

    @cnz
    /* renamed from: c */
    public static PatternSyntaxException m11658c(String str) {
        return m11659c(str, 0);
    }

    @cnz
    /* renamed from: c */
    public static PatternSyntaxException m11659c(String str, int i) {
        try {
            int a = m11651a(Pattern.compile(str));
            if (a < i) {
                return new PatternSyntaxException(m11652a(str, i, a), str, -1);
            }
            return null;
        } catch (PatternSyntaxException e) {
            return e;
        }
    }

    @cnz
    /* renamed from: d */
    public static String m11660d(String str) {
        return m11661d(str, 0);
    }

    @cnz
    /* renamed from: d */
    public static String m11661d(String str, int i) {
        try {
            int a = m11651a(Pattern.compile(str));
            if (a >= i) {
                return str;
            }
            throw new Error(m11652a(str, i, a));
        } catch (PatternSyntaxException e) {
            throw new Error(e);
        }
    }

    @cnz
    /* renamed from: a */
    private static String m11652a(String str, int i, int i2) {
        return "regex \"" + str + "\" has " + i2 + " groups, but " + i + " groups are needed.";
    }

    @cny
    /* renamed from: a */
    private static int m11651a(Pattern pattern) {
        return pattern.matcher("").groupCount();
    }
}
