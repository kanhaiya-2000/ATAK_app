package atakplugin.UASTool;

import java.nio.charset.Charset;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class bru {

    /* renamed from: a */
    private static final String f3432a = "([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)";

    /* renamed from: b */
    private static final String f3433b = "\"([^\"]*)\"";

    /* renamed from: c */
    private static final Pattern f3434c = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");

    /* renamed from: d */
    private static final Pattern f3435d = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");

    /* renamed from: e */
    private final String f3436e;

    /* renamed from: f */
    private final String f3437f;

    /* renamed from: g */
    private final String f3438g;

    /* renamed from: h */
    private final String f3439h;

    private bru(String str, String str2, String str3, String str4) {
        this.f3436e = str;
        this.f3437f = str2;
        this.f3438g = str3;
        this.f3439h = str4;
    }

    /* renamed from: a */
    public static bru m8896a(String str) {
        String str2;
        Matcher matcher = f3434c.matcher(str);
        if (!matcher.lookingAt()) {
            return null;
        }
        String lowerCase = matcher.group(1).toLowerCase(Locale.US);
        String lowerCase2 = matcher.group(2).toLowerCase(Locale.US);
        Matcher matcher2 = f3435d.matcher(str);
        String str3 = null;
        for (int end = matcher.end(); end < str.length(); end = matcher2.end()) {
            matcher2.region(end, str.length());
            if (!matcher2.lookingAt()) {
                return null;
            }
            String group = matcher2.group(1);
            if (group != null && group.equalsIgnoreCase("charset")) {
                if (matcher2.group(2) != null) {
                    str2 = matcher2.group(2);
                } else {
                    str2 = matcher2.group(3);
                }
                if (str3 == null || str2.equalsIgnoreCase(str3)) {
                    str3 = str2;
                } else {
                    throw new IllegalArgumentException("Multiple different charsets: " + str);
                }
            }
        }
        return new bru(str, lowerCase, lowerCase2, str3);
    }

    /* renamed from: a */
    public String mo3252a() {
        return this.f3437f;
    }

    /* renamed from: b */
    public String mo3254b() {
        return this.f3438g;
    }

    /* renamed from: c */
    public Charset mo3255c() {
        String str = this.f3439h;
        if (str != null) {
            return Charset.forName(str);
        }
        return null;
    }

    /* renamed from: a */
    public Charset mo3253a(Charset charset) {
        String str = this.f3439h;
        return str != null ? Charset.forName(str) : charset;
    }

    public String toString() {
        return this.f3436e;
    }

    public boolean equals(Object obj) {
        return (obj instanceof bru) && ((bru) obj).f3436e.equals(this.f3436e);
    }

    public int hashCode() {
        return this.f3436e.hashCode();
    }
}
