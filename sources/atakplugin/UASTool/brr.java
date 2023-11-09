package atakplugin.UASTool;

import com.google.common.base.Ascii;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public final class brr {

    /* renamed from: a */
    static final String f3397a = " \"':;<=>@[]^`{}|/\\?#";

    /* renamed from: b */
    static final String f3398b = " \"':;<=>@[]^`{}|/\\?#";

    /* renamed from: c */
    static final String f3399c = " \"<>^`{}|/\\?#";

    /* renamed from: d */
    static final String f3400d = "[]";

    /* renamed from: e */
    static final String f3401e = " \"'<>#";

    /* renamed from: f */
    static final String f3402f = " \"'<>#&=";

    /* renamed from: g */
    static final String f3403g = "\\^`{|}";

    /* renamed from: h */
    static final String f3404h = " \"':;<=>@[]^`{}|/\\?#&!$(),~";

    /* renamed from: i */
    static final String f3405i = "";

    /* renamed from: j */
    static final String f3406j = " \"#<>\\^`{|}";

    /* renamed from: k */
    private static final char[] f3407k = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    /* access modifiers changed from: private */

    /* renamed from: l */
    public final String f3408l;

    /* renamed from: m */
    private final String f3409m;

    /* renamed from: n */
    private final String f3410n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public final String f3411o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public final int f3412p;

    /* renamed from: q */
    private final List<String> f3413q;

    /* renamed from: r */
    private final List<String> f3414r;

    /* renamed from: s */
    private final String f3415s;

    /* renamed from: t */
    private final String f3416t;

    /* renamed from: a */
    static int m8801a(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        }
        char c2 = 'a';
        if (c < 'a' || c > 'f') {
            c2 = 'A';
            if (c < 'A' || c > 'F') {
                return -1;
            }
        }
        return (c - c2) + 10;
    }

    /* synthetic */ brr(C0226a aVar, brs brs) {
        this(aVar);
    }

    private brr(C0226a aVar) {
        this.f3408l = aVar.f3417a;
        this.f3409m = m8809a(aVar.f3418b, false);
        this.f3410n = m8809a(aVar.f3419c, false);
        this.f3411o = aVar.f3420d;
        this.f3412p = aVar.mo3218a();
        this.f3413q = m8810a(aVar.f3422f, false);
        String str = null;
        this.f3414r = aVar.f3423g != null ? m8810a(aVar.f3423g, true) : null;
        this.f3415s = aVar.f3424h != null ? m8809a(aVar.f3424h, false) : str;
        this.f3416t = aVar.toString();
    }

    /* renamed from: a */
    public URL mo3189a() {
        try {
            return new URL(this.f3416t);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    /* renamed from: b */
    public URI mo3191b() {
        String aVar = mo3217u().mo3224b().toString();
        try {
            return new URI(aVar);
        } catch (URISyntaxException e) {
            try {
                return URI.create(aVar.replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", ""));
            } catch (Exception unused) {
                throw new RuntimeException(e);
            }
        }
    }

    /* renamed from: c */
    public String mo3192c() {
        return this.f3408l;
    }

    /* renamed from: d */
    public boolean mo3195d() {
        return this.f3408l.equals("https");
    }

    /* renamed from: e */
    public String mo3197e() {
        if (this.f3409m.isEmpty()) {
            return "";
        }
        int length = this.f3408l.length() + 3;
        String str = this.f3416t;
        return this.f3416t.substring(length, bsp.m9147a(str, length, str.length(), ":@"));
    }

    /* renamed from: f */
    public String mo3200f() {
        return this.f3409m;
    }

    /* renamed from: g */
    public String mo3201g() {
        if (this.f3410n.isEmpty()) {
            return "";
        }
        int indexOf = this.f3416t.indexOf(64);
        return this.f3416t.substring(this.f3416t.indexOf(58, this.f3408l.length() + 3) + 1, indexOf);
    }

    /* renamed from: h */
    public String mo3202h() {
        return this.f3410n;
    }

    /* renamed from: i */
    public String mo3204i() {
        return this.f3411o;
    }

    /* renamed from: j */
    public int mo3205j() {
        return this.f3412p;
    }

    /* renamed from: a */
    public static int m8802a(String str) {
        if (str.equals("http")) {
            return 80;
        }
        return str.equals("https") ? 443 : -1;
    }

    /* renamed from: k */
    public int mo3206k() {
        return this.f3413q.size();
    }

    /* renamed from: l */
    public String mo3207l() {
        int indexOf = this.f3416t.indexOf(47, this.f3408l.length() + 3);
        String str = this.f3416t;
        return this.f3416t.substring(indexOf, bsp.m9147a(str, indexOf, str.length(), "?#"));
    }

    /* renamed from: a */
    static void m8813a(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            sb.append('/');
            sb.append(list.get(i));
        }
    }

    /* renamed from: m */
    public List<String> mo3208m() {
        int indexOf = this.f3416t.indexOf(47, this.f3408l.length() + 3);
        String str = this.f3416t;
        int a = bsp.m9147a(str, indexOf, str.length(), "?#");
        ArrayList arrayList = new ArrayList();
        while (indexOf < a) {
            int i = indexOf + 1;
            int a2 = bsp.m9146a(this.f3416t, i, a, '/');
            arrayList.add(this.f3416t.substring(i, a2));
            indexOf = a2;
        }
        return arrayList;
    }

    /* renamed from: n */
    public List<String> mo3209n() {
        return this.f3413q;
    }

    /* renamed from: o */
    public String mo3210o() {
        if (this.f3414r == null) {
            return null;
        }
        int indexOf = this.f3416t.indexOf(63) + 1;
        String str = this.f3416t;
        return this.f3416t.substring(indexOf, bsp.m9146a(str, indexOf + 1, str.length(), '#'));
    }

    /* renamed from: b */
    static void m8817b(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i = 0; i < size; i += 2) {
            String str = list.get(i);
            String str2 = list.get(i + 1);
            if (i > 0) {
                sb.append(bpg.f3095c);
            }
            sb.append(str);
            if (str2 != null) {
                sb.append('=');
                sb.append(str2);
            }
        }
    }

    /* renamed from: b */
    static List<String> m8816b(String str) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i <= str.length()) {
            int indexOf = str.indexOf(38, i);
            if (indexOf == -1) {
                indexOf = str.length();
            }
            int indexOf2 = str.indexOf(61, i);
            if (indexOf2 == -1 || indexOf2 > indexOf) {
                arrayList.add(str.substring(i, indexOf));
                arrayList.add((Object) null);
            } else {
                arrayList.add(str.substring(i, indexOf2));
                arrayList.add(str.substring(indexOf2 + 1, indexOf));
            }
            i = indexOf + 1;
        }
        return arrayList;
    }

    /* renamed from: p */
    public String mo3211p() {
        if (this.f3414r == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        m8817b(sb, this.f3414r);
        return sb.toString();
    }

    /* renamed from: q */
    public int mo3212q() {
        List<String> list = this.f3414r;
        if (list != null) {
            return list.size() / 2;
        }
        return 0;
    }

    /* renamed from: c */
    public String mo3193c(String str) {
        List<String> list = this.f3414r;
        if (list == null) {
            return null;
        }
        int size = list.size();
        for (int i = 0; i < size; i += 2) {
            if (str.equals(this.f3414r.get(i))) {
                return this.f3414r.get(i + 1);
            }
        }
        return null;
    }

    /* renamed from: r */
    public Set<String> mo3213r() {
        if (this.f3414r == null) {
            return Collections.emptySet();
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        int size = this.f3414r.size();
        for (int i = 0; i < size; i += 2) {
            linkedHashSet.add(this.f3414r.get(i));
        }
        return Collections.unmodifiableSet(linkedHashSet);
    }

    /* renamed from: d */
    public List<String> mo3194d(String str) {
        if (this.f3414r == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        int size = this.f3414r.size();
        for (int i = 0; i < size; i += 2) {
            if (str.equals(this.f3414r.get(i))) {
                arrayList.add(this.f3414r.get(i + 1));
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    /* renamed from: a */
    public String mo3188a(int i) {
        List<String> list = this.f3414r;
        if (list != null) {
            return list.get(i * 2);
        }
        throw new IndexOutOfBoundsException();
    }

    /* renamed from: b */
    public String mo3190b(int i) {
        List<String> list = this.f3414r;
        if (list != null) {
            return list.get((i * 2) + 1);
        }
        throw new IndexOutOfBoundsException();
    }

    /* renamed from: s */
    public String mo3214s() {
        if (this.f3415s == null) {
            return null;
        }
        return this.f3416t.substring(this.f3416t.indexOf(35) + 1);
    }

    /* renamed from: t */
    public String mo3215t() {
        return this.f3415s;
    }

    /* renamed from: e */
    public brr mo3196e(String str) {
        C0226a f = mo3199f(str);
        if (f != null) {
            return f.mo3231c();
        }
        return null;
    }

    /* renamed from: u */
    public C0226a mo3217u() {
        C0226a aVar = new C0226a();
        aVar.f3417a = this.f3408l;
        aVar.f3418b = mo3197e();
        aVar.f3419c = mo3201g();
        aVar.f3420d = this.f3411o;
        aVar.f3421e = this.f3412p != m8802a(this.f3408l) ? this.f3412p : -1;
        aVar.f3422f.clear();
        aVar.f3422f.addAll(mo3208m());
        aVar.mo3242m(mo3210o());
        aVar.f3424h = mo3214s();
        return aVar;
    }

    /* renamed from: f */
    public C0226a mo3199f(String str) {
        C0226a aVar = new C0226a();
        if (aVar.mo3219a(this, str) == C0226a.C0227a.SUCCESS) {
            return aVar;
        }
        return null;
    }

    /* renamed from: g */
    public static brr m8819g(String str) {
        C0226a aVar = new C0226a();
        if (aVar.mo3219a((brr) null, str) == C0226a.C0227a.SUCCESS) {
            return aVar.mo3231c();
        }
        return null;
    }

    /* renamed from: a */
    public static brr m8804a(URL url) {
        return m8819g(url.toString());
    }

    /* renamed from: h */
    static brr m8820h(String str) {
        C0226a aVar = new C0226a();
        C0226a.C0227a a = aVar.mo3219a((brr) null, str);
        int i = brs.f3431a[a.ordinal()];
        if (i == 1) {
            return aVar.mo3231c();
        }
        if (i != 2) {
            throw new MalformedURLException("Invalid URL: " + a + " for " + str);
        }
        throw new UnknownHostException("Invalid host: " + str);
    }

    /* renamed from: a */
    public static brr m8803a(URI uri) {
        return m8819g(uri.toString());
    }

    public boolean equals(Object obj) {
        return (obj instanceof brr) && ((brr) obj).f3416t.equals(this.f3416t);
    }

    public int hashCode() {
        return this.f3416t.hashCode();
    }

    public String toString() {
        return this.f3416t;
    }

    /* renamed from: atakplugin.UASTool.brr$a */
    public static final class C0226a {

        /* renamed from: a */
        String f3417a;

        /* renamed from: b */
        String f3418b = "";

        /* renamed from: c */
        String f3419c = "";

        /* renamed from: d */
        String f3420d;

        /* renamed from: e */
        int f3421e = -1;

        /* renamed from: f */
        final List<String> f3422f;

        /* renamed from: g */
        List<String> f3423g;

        /* renamed from: h */
        String f3424h;

        /* renamed from: atakplugin.UASTool.brr$a$a */
        enum C0227a {
            SUCCESS,
            MISSING_SCHEME,
            UNSUPPORTED_SCHEME,
            INVALID_PORT,
            INVALID_HOST
        }

        public C0226a() {
            ArrayList arrayList = new ArrayList();
            this.f3422f = arrayList;
            arrayList.add("");
        }

        /* renamed from: a */
        public C0226a mo3222a(String str) {
            Objects.requireNonNull(str, "scheme == null");
            if (str.equalsIgnoreCase("http")) {
                this.f3417a = "http";
            } else if (str.equalsIgnoreCase("https")) {
                this.f3417a = "https";
            } else {
                throw new IllegalArgumentException("unexpected scheme: " + str);
            }
            return this;
        }

        /* renamed from: b */
        public C0226a mo3227b(String str) {
            Objects.requireNonNull(str, "username == null");
            this.f3418b = brr.m8808a(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
            return this;
        }

        /* renamed from: c */
        public C0226a mo3229c(String str) {
            Objects.requireNonNull(str, "encodedUsername == null");
            this.f3418b = brr.m8808a(str, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
            return this;
        }

        /* renamed from: d */
        public C0226a mo3232d(String str) {
            Objects.requireNonNull(str, "password == null");
            this.f3419c = brr.m8808a(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
            return this;
        }

        /* renamed from: e */
        public C0226a mo3234e(String str) {
            Objects.requireNonNull(str, "encodedPassword == null");
            this.f3419c = brr.m8808a(str, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
            return this;
        }

        /* renamed from: f */
        public C0226a mo3235f(String str) {
            Objects.requireNonNull(str, "host == null");
            String e = m8857e(str, 0, str.length());
            if (e != null) {
                this.f3420d = e;
                return this;
            }
            throw new IllegalArgumentException("unexpected host: " + str);
        }

        /* renamed from: a */
        public C0226a mo3220a(int i) {
            if (i <= 0 || i > 65535) {
                throw new IllegalArgumentException("unexpected port: " + i);
            }
            this.f3421e = i;
            return this;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public int mo3218a() {
            int i = this.f3421e;
            return i != -1 ? i : brr.m8802a(this.f3417a);
        }

        /* renamed from: g */
        public C0226a mo3236g(String str) {
            Objects.requireNonNull(str, "pathSegment == null");
            m8851a(str, 0, str.length(), false, false);
            return this;
        }

        /* renamed from: h */
        public C0226a mo3237h(String str) {
            Objects.requireNonNull(str, "pathSegments == null");
            return m8848a(str, false);
        }

        /* renamed from: i */
        public C0226a mo3238i(String str) {
            Objects.requireNonNull(str, "encodedPathSegment == null");
            m8851a(str, 0, str.length(), false, true);
            return this;
        }

        /* renamed from: j */
        public C0226a mo3239j(String str) {
            Objects.requireNonNull(str, "encodedPathSegments == null");
            return m8848a(str, true);
        }

        /* renamed from: a */
        private C0226a m8848a(String str, boolean z) {
            int i = 0;
            do {
                int a = bsp.m9147a(str, i, str.length(), "/\\");
                m8851a(str, i, a, a < str.length(), z);
                i = a + 1;
            } while (i <= str.length());
            return this;
        }

        /* renamed from: a */
        public C0226a mo3221a(int i, String str) {
            Objects.requireNonNull(str, "pathSegment == null");
            String a = brr.m8806a(str, 0, str.length(), brr.f3399c, false, false, false, true);
            if (m8861s(a) || m8862t(a)) {
                throw new IllegalArgumentException("unexpected path segment: " + str);
            }
            this.f3422f.set(i, a);
            return this;
        }

        /* renamed from: b */
        public C0226a mo3226b(int i, String str) {
            Objects.requireNonNull(str, "encodedPathSegment == null");
            String a = brr.m8806a(str, 0, str.length(), brr.f3399c, true, false, false, true);
            this.f3422f.set(i, a);
            if (!m8861s(a) && !m8862t(a)) {
                return this;
            }
            throw new IllegalArgumentException("unexpected path segment: " + str);
        }

        /* renamed from: b */
        public C0226a mo3225b(int i) {
            this.f3422f.remove(i);
            if (this.f3422f.isEmpty()) {
                this.f3422f.add("");
            }
            return this;
        }

        /* renamed from: k */
        public C0226a mo3240k(String str) {
            Objects.requireNonNull(str, "encodedPath == null");
            if (str.startsWith("/")) {
                m8850a(str, 0, str.length());
                return this;
            }
            throw new IllegalArgumentException("unexpected encodedPath: " + str);
        }

        /* renamed from: l */
        public C0226a mo3241l(String str) {
            this.f3423g = str != null ? brr.m8816b(brr.m8808a(str, brr.f3401e, false, false, true, true)) : null;
            return this;
        }

        /* renamed from: m */
        public C0226a mo3242m(String str) {
            this.f3423g = str != null ? brr.m8816b(brr.m8808a(str, brr.f3401e, true, false, true, true)) : null;
            return this;
        }

        /* renamed from: a */
        public C0226a mo3223a(String str, String str2) {
            Objects.requireNonNull(str, "name == null");
            if (this.f3423g == null) {
                this.f3423g = new ArrayList();
            }
            this.f3423g.add(brr.m8808a(str, brr.f3402f, false, false, true, true));
            this.f3423g.add(str2 != null ? brr.m8808a(str2, brr.f3402f, false, false, true, true) : null);
            return this;
        }

        /* renamed from: b */
        public C0226a mo3228b(String str, String str2) {
            Objects.requireNonNull(str, "encodedName == null");
            if (this.f3423g == null) {
                this.f3423g = new ArrayList();
            }
            this.f3423g.add(brr.m8808a(str, brr.f3402f, true, false, true, true));
            this.f3423g.add(str2 != null ? brr.m8808a(str2, brr.f3402f, true, false, true, true) : null);
            return this;
        }

        /* renamed from: c */
        public C0226a mo3230c(String str, String str2) {
            mo3243n(str);
            mo3223a(str, str2);
            return this;
        }

        /* renamed from: d */
        public C0226a mo3233d(String str, String str2) {
            mo3244o(str);
            mo3228b(str, str2);
            return this;
        }

        /* renamed from: n */
        public C0226a mo3243n(String str) {
            Objects.requireNonNull(str, "name == null");
            if (this.f3423g == null) {
                return this;
            }
            m8860r(brr.m8808a(str, brr.f3402f, false, false, true, true));
            return this;
        }

        /* renamed from: o */
        public C0226a mo3244o(String str) {
            Objects.requireNonNull(str, "encodedName == null");
            if (this.f3423g == null) {
                return this;
            }
            m8860r(brr.m8808a(str, brr.f3402f, true, false, true, true));
            return this;
        }

        /* renamed from: r */
        private void m8860r(String str) {
            for (int size = this.f3423g.size() - 2; size >= 0; size -= 2) {
                if (str.equals(this.f3423g.get(size))) {
                    this.f3423g.remove(size + 1);
                    this.f3423g.remove(size);
                    if (this.f3423g.isEmpty()) {
                        this.f3423g = null;
                        return;
                    }
                }
            }
        }

        /* renamed from: p */
        public C0226a mo3245p(String str) {
            this.f3424h = str != null ? brr.m8808a(str, "", false, false, false, false) : null;
            return this;
        }

        /* renamed from: q */
        public C0226a mo3246q(String str) {
            this.f3424h = str != null ? brr.m8808a(str, "", true, false, false, false) : null;
            return this;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public C0226a mo3224b() {
            int size = this.f3422f.size();
            for (int i = 0; i < size; i++) {
                this.f3422f.set(i, brr.m8808a(this.f3422f.get(i), brr.f3400d, true, true, false, true));
            }
            List<String> list = this.f3423g;
            if (list != null) {
                int size2 = list.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    String str = this.f3423g.get(i2);
                    if (str != null) {
                        this.f3423g.set(i2, brr.m8808a(str, brr.f3403g, true, true, true, true));
                    }
                }
            }
            String str2 = this.f3424h;
            if (str2 != null) {
                this.f3424h = brr.m8808a(str2, brr.f3406j, true, true, false, false);
            }
            return this;
        }

        /* renamed from: c */
        public brr mo3231c() {
            if (this.f3417a == null) {
                throw new IllegalStateException("scheme == null");
            } else if (this.f3420d != null) {
                return new brr(this, (brs) null);
            } else {
                throw new IllegalStateException("host == null");
            }
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f3417a);
            sb.append("://");
            if (!this.f3418b.isEmpty() || !this.f3419c.isEmpty()) {
                sb.append(this.f3418b);
                if (!this.f3419c.isEmpty()) {
                    sb.append(':');
                    sb.append(this.f3419c);
                }
                sb.append('@');
            }
            if (this.f3420d.indexOf(58) != -1) {
                sb.append('[');
                sb.append(this.f3420d);
                sb.append(']');
            } else {
                sb.append(this.f3420d);
            }
            int a = mo3218a();
            if (a != brr.m8802a(this.f3417a)) {
                sb.append(':');
                sb.append(a);
            }
            brr.m8813a(sb, this.f3422f);
            if (this.f3423g != null) {
                sb.append('?');
                brr.m8817b(sb, this.f3423g);
            }
            if (this.f3424h != null) {
                sb.append('#');
                sb.append(this.f3424h);
            }
            return sb.toString();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public C0227a mo3219a(brr brr, String str) {
            int a;
            int i;
            String str2 = str;
            int a2 = bsp.m9145a(str2, 0, str.length());
            int b = bsp.m9167b(str2, a2, str.length());
            if (m8853b(str2, a2, b) != -1) {
                if (str.regionMatches(true, a2, "https:", 0, 6)) {
                    this.f3417a = "https";
                    a2 += 6;
                } else if (!str.regionMatches(true, a2, "http:", 0, 5)) {
                    return C0227a.UNSUPPORTED_SCHEME;
                } else {
                    this.f3417a = "http";
                    a2 += 5;
                }
            } else if (brr == null) {
                return C0227a.MISSING_SCHEME;
            } else {
                this.f3417a = brr.f3408l;
            }
            int c = m8854c(str2, a2, b);
            char c2 = '?';
            char c3 = '#';
            if (c >= 2 || brr == null || !brr.f3408l.equals(this.f3417a)) {
                int i2 = a2 + c;
                boolean z = false;
                boolean z2 = false;
                while (true) {
                    a = bsp.m9147a(str2, i2, b, "@/\\?#");
                    char charAt = a != b ? str2.charAt(a) : 65535;
                    if (charAt == 65535 || charAt == c3 || charAt == '/' || charAt == '\\' || charAt == c2) {
                        int i3 = a;
                        int d = m8855d(str2, i2, i3);
                        int i4 = d + 1;
                    } else {
                        if (charAt == '@') {
                            if (!z) {
                                int a3 = bsp.m9146a(str2, i2, a, ':');
                                int i5 = a3;
                                String str3 = "%40";
                                i = a;
                                String a4 = brr.m8806a(str, i2, a3, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
                                if (z2) {
                                    a4 = this.f3418b + str3 + a4;
                                }
                                this.f3418b = a4;
                                if (i5 != i) {
                                    this.f3419c = brr.m8806a(str, i5 + 1, i, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
                                    z = true;
                                }
                                z2 = true;
                            } else {
                                i = a;
                                this.f3419c += "%40" + brr.m8806a(str, i2, i, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
                            }
                            i2 = i + 1;
                        }
                        c2 = '?';
                        c3 = '#';
                    }
                }
                int i32 = a;
                int d2 = m8855d(str2, i2, i32);
                int i42 = d2 + 1;
                if (i42 < i32) {
                    this.f3420d = m8857e(str2, i2, d2);
                    int g = m8859g(str2, i42, i32);
                    this.f3421e = g;
                    if (g == -1) {
                        return C0227a.INVALID_PORT;
                    }
                } else {
                    this.f3420d = m8857e(str2, i2, d2);
                    this.f3421e = brr.m8802a(this.f3417a);
                }
                if (this.f3420d == null) {
                    return C0227a.INVALID_HOST;
                }
                a2 = i32;
            } else {
                this.f3418b = brr.mo3197e();
                this.f3419c = brr.mo3201g();
                this.f3420d = brr.f3411o;
                this.f3421e = brr.f3412p;
                this.f3422f.clear();
                this.f3422f.addAll(brr.mo3208m());
                if (a2 == b || str2.charAt(a2) == '#') {
                    mo3242m(brr.mo3210o());
                }
            }
            int a5 = bsp.m9147a(str2, a2, b, "?#");
            m8850a(str2, a2, a5);
            if (a5 < b && str2.charAt(a5) == '?') {
                int a6 = bsp.m9146a(str2, a5, b, '#');
                this.f3423g = brr.m8816b(brr.m8806a(str, a5 + 1, a6, brr.f3401e, true, false, true, true));
                a5 = a6;
            }
            if (a5 < b && str2.charAt(a5) == '#') {
                this.f3424h = brr.m8806a(str, 1 + a5, b, "", true, false, false, false);
            }
            return C0227a.SUCCESS;
        }

        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
            	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
            */
        /* JADX WARNING: Removed duplicated region for block: B:10:0x002c  */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x0044 A[SYNTHETIC] */
        /* renamed from: a */
        private void m8850a(java.lang.String r11, int r12, int r13) {
            /*
                r10 = this;
                if (r12 != r13) goto L_0x0003
                return
            L_0x0003:
                char r0 = r11.charAt(r12)
                r1 = 47
                java.lang.String r2 = ""
                r3 = 1
                if (r0 == r1) goto L_0x001e
                r1 = 92
                if (r0 != r1) goto L_0x0013
                goto L_0x001e
            L_0x0013:
                java.util.List<java.lang.String> r0 = r10.f3422f
                int r1 = r0.size()
                int r1 = r1 - r3
                r0.set(r1, r2)
                goto L_0x0029
            L_0x001e:
                java.util.List<java.lang.String> r0 = r10.f3422f
                r0.clear()
                java.util.List<java.lang.String> r0 = r10.f3422f
                r0.add(r2)
                goto L_0x0041
            L_0x0029:
                r6 = r12
                if (r6 >= r13) goto L_0x0044
                java.lang.String r12 = "/\\"
                int r12 = atakplugin.UASTool.bsp.m9147a((java.lang.String) r11, (int) r6, (int) r13, (java.lang.String) r12)
                if (r12 >= r13) goto L_0x0036
                r0 = 1
                goto L_0x0037
            L_0x0036:
                r0 = 0
            L_0x0037:
                r9 = 1
                r4 = r10
                r5 = r11
                r7 = r12
                r8 = r0
                r4.m8851a((java.lang.String) r5, (int) r6, (int) r7, (boolean) r8, (boolean) r9)
                if (r0 == 0) goto L_0x0029
            L_0x0041:
                int r12 = r12 + 1
                goto L_0x0029
            L_0x0044:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.brr.C0226a.m8850a(java.lang.String, int, int):void");
        }

        /* renamed from: a */
        private void m8851a(String str, int i, int i2, boolean z, boolean z2) {
            String a = brr.m8806a(str, i, i2, brr.f3399c, z2, false, false, true);
            if (!m8861s(a)) {
                if (m8862t(a)) {
                    m8856d();
                    return;
                }
                List<String> list = this.f3422f;
                if (list.get(list.size() - 1).isEmpty()) {
                    List<String> list2 = this.f3422f;
                    list2.set(list2.size() - 1, a);
                } else {
                    this.f3422f.add(a);
                }
                if (z) {
                    this.f3422f.add("");
                }
            }
        }

        /* renamed from: s */
        private boolean m8861s(String str) {
            return str.equals(".") || str.equalsIgnoreCase("%2e");
        }

        /* renamed from: t */
        private boolean m8862t(String str) {
            return str.equals("..") || str.equalsIgnoreCase("%2e.") || str.equalsIgnoreCase(".%2e") || str.equalsIgnoreCase("%2e%2e");
        }

        /* renamed from: d */
        private void m8856d() {
            List<String> list = this.f3422f;
            if (!list.remove(list.size() - 1).isEmpty() || this.f3422f.isEmpty()) {
                this.f3422f.add("");
                return;
            }
            List<String> list2 = this.f3422f;
            list2.set(list2.size() - 1, "");
        }

        /* renamed from: b */
        private static int m8853b(String str, int i, int i2) {
            if (i2 - i < 2) {
                return -1;
            }
            char charAt = str.charAt(i);
            if ((charAt >= 'a' && charAt <= 'z') || (charAt >= 'A' && charAt <= 'Z')) {
                while (true) {
                    i++;
                    if (i >= i2) {
                        break;
                    }
                    char charAt2 = str.charAt(i);
                    if ((charAt2 < 'a' || charAt2 > 'z') && ((charAt2 < 'A' || charAt2 > 'Z') && !((charAt2 >= '0' && charAt2 <= '9') || charAt2 == '+' || charAt2 == '-' || charAt2 == '.'))) {
                        if (charAt2 == ':') {
                            return i;
                        }
                    }
                }
            }
            return -1;
        }

        /* renamed from: c */
        private static int m8854c(String str, int i, int i2) {
            int i3 = 0;
            while (i < i2) {
                char charAt = str.charAt(i);
                if (charAt != '\\' && charAt != '/') {
                    break;
                }
                i3++;
                i++;
            }
            return i3;
        }

        /* renamed from: d */
        private static int m8855d(String str, int i, int i2) {
            while (i < i2) {
                char charAt = str.charAt(i);
                if (charAt == ':') {
                    return i;
                }
                if (charAt == '[') {
                    do {
                        i++;
                        if (i >= i2) {
                            break;
                        }
                    } while (str.charAt(i) == ']');
                }
                i++;
            }
            return i2;
        }

        /* renamed from: e */
        private static String m8857e(String str, int i, int i2) {
            InetAddress inetAddress;
            String a = brr.m8807a(str, i, i2, false);
            if (!a.contains(":")) {
                return bsp.m9173d(a);
            }
            if (!a.startsWith("[") || !a.endsWith("]")) {
                inetAddress = m8858f(a, 0, a.length());
            } else {
                inetAddress = m8858f(a, 1, a.length() - 1);
            }
            if (inetAddress == null) {
                return null;
            }
            byte[] address = inetAddress.getAddress();
            if (address.length == 16) {
                return m8849a(address);
            }
            throw new AssertionError();
        }

        /* renamed from: f */
        private static InetAddress m8858f(String str, int i, int i2) {
            byte[] bArr = new byte[16];
            int i3 = 0;
            int i4 = -1;
            int i5 = -1;
            while (true) {
                if (i >= i2) {
                    break;
                } else if (i3 == 16) {
                    return null;
                } else {
                    int i6 = i + 2;
                    if (i6 > i2 || !str.regionMatches(i, "::", 0, 2)) {
                        if (i3 != 0) {
                            if (str.regionMatches(i, ":", 0, 1)) {
                                i++;
                            } else if (!str.regionMatches(i, ".", 0, 1) || !m8852a(str, i5, i2, bArr, i3 - 2)) {
                                return null;
                            } else {
                                i3 += 2;
                            }
                        }
                        i5 = i;
                    } else if (i4 != -1) {
                        return null;
                    } else {
                        i3 += 2;
                        i4 = i3;
                        if (i6 == i2) {
                            break;
                        }
                        i5 = i6;
                    }
                    i = i5;
                    int i7 = 0;
                    while (i < i2) {
                        int a = brr.m8801a(str.charAt(i));
                        if (a == -1) {
                            break;
                        }
                        i7 = (i7 << 4) + a;
                        i++;
                    }
                    int i8 = i - i5;
                    if (i8 == 0 || i8 > 4) {
                        return null;
                    }
                    int i9 = i3 + 1;
                    bArr[i3] = (byte) ((i7 >>> 8) & 255);
                    i3 = i9 + 1;
                    bArr[i9] = (byte) (i7 & 255);
                }
            }
            if (i3 != 16) {
                if (i4 == -1) {
                    return null;
                }
                int i10 = i3 - i4;
                System.arraycopy(bArr, i4, bArr, 16 - i10, i10);
                Arrays.fill(bArr, i4, (16 - i3) + i4, (byte) 0);
            }
            try {
                return InetAddress.getByAddress(bArr);
            } catch (UnknownHostException unused) {
                throw new AssertionError();
            }
        }

        /* renamed from: a */
        private static boolean m8852a(String str, int i, int i2, byte[] bArr, int i3) {
            int i4 = i3;
            while (i < i2) {
                if (i4 == bArr.length) {
                    return false;
                }
                if (i4 != i3) {
                    if (str.charAt(i) != '.') {
                        return false;
                    }
                    i++;
                }
                int i5 = i;
                int i6 = 0;
                while (i5 < i2) {
                    char charAt = str.charAt(i5);
                    if (charAt < '0' || charAt > '9') {
                        break;
                    } else if ((i6 == 0 && i != i5) || (i6 = ((i6 * 10) + charAt) - 48) > 255) {
                        return false;
                    } else {
                        i5++;
                    }
                }
                if (i5 - i == 0) {
                    return false;
                }
                bArr[i4] = (byte) i6;
                i4++;
                i = i5;
            }
            if (i4 != i3 + 4) {
                return false;
            }
            return true;
        }

        /* renamed from: a */
        private static String m8849a(byte[] bArr) {
            int i = 0;
            int i2 = -1;
            int i3 = 0;
            int i4 = 0;
            while (i3 < bArr.length) {
                int i5 = i3;
                while (i5 < 16 && bArr[i5] == 0 && bArr[i5 + 1] == 0) {
                    i5 += 2;
                }
                int i6 = i5 - i3;
                if (i6 > i4) {
                    i2 = i3;
                    i4 = i6;
                }
                i3 = i5 + 2;
            }
            bwl bwl = new bwl();
            while (i < bArr.length) {
                if (i == i2) {
                    bwl.mo3833d(58);
                    i += i4;
                    if (i == 16) {
                        bwl.mo3833d(58);
                    }
                } else {
                    if (i > 0) {
                        bwl.mo3833d(58);
                    }
                    bwl.mo3879r((long) (((bArr[i] & 255) << 8) | (bArr[i + 1] & 255)));
                    i += 2;
                }
            }
            return bwl.mo3887w();
        }

        /* renamed from: g */
        private static int m8859g(String str, int i, int i2) {
            try {
                int parseInt = Integer.parseInt(brr.m8806a(str, i, i2, "", false, false, false, true));
                if (parseInt <= 0 || parseInt > 65535) {
                    return -1;
                }
                return parseInt;
            } catch (NumberFormatException unused) {
            }
        }
    }

    /* renamed from: a */
    static String m8809a(String str, boolean z) {
        return m8807a(str, 0, str.length(), z);
    }

    /* renamed from: a */
    private List<String> m8810a(List<String> list, boolean z) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String next = it.next();
            arrayList.add(next != null ? m8809a(next, z) : null);
        }
        return Collections.unmodifiableList(arrayList);
    }

    /* renamed from: a */
    static String m8807a(String str, int i, int i2, boolean z) {
        for (int i3 = i; i3 < i2; i3++) {
            char charAt = str.charAt(i3);
            if (charAt == '%' || (charAt == '+' && z)) {
                bwl bwl = new bwl();
                bwl.mo3818b(str, i, i3);
                m8812a(bwl, str, i3, i2, z);
                return bwl.mo3887w();
            }
        }
        return str.substring(i, i2);
    }

    /* renamed from: a */
    static void m8812a(bwl bwl, String str, int i, int i2, boolean z) {
        int i3;
        while (i < i2) {
            int codePointAt = str.codePointAt(i);
            if (codePointAt == 37 && (i3 = i + 2) < i2) {
                int a = m8801a(str.charAt(i + 1));
                int a2 = m8801a(str.charAt(i3));
                if (!(a == -1 || a2 == -1)) {
                    bwl.mo3833d((a << 4) + a2);
                    i = i3;
                    i += Character.charCount(codePointAt);
                }
            } else if (codePointAt == 43 && z) {
                bwl.mo3833d(32);
                i += Character.charCount(codePointAt);
            }
            bwl.mo3815b(codePointAt);
            i += Character.charCount(codePointAt);
        }
    }

    /* renamed from: a */
    static boolean m8814a(String str, int i, int i2) {
        int i3 = i + 2;
        if (i3 >= i2 || str.charAt(i) != '%' || m8801a(str.charAt(i + 1)) == -1 || m8801a(str.charAt(i3)) == -1) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    static String m8806a(String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        String str3 = str;
        int i3 = i2;
        int i4 = i;
        while (i4 < i3) {
            int codePointAt = str.codePointAt(i4);
            if (codePointAt < 32 || codePointAt == 127 || (codePointAt >= 128 && z4)) {
                String str4 = str2;
            } else {
                String str5 = str2;
                if (str2.indexOf(codePointAt) == -1 && ((codePointAt != 37 || (z && (!z2 || m8814a(str, i4, i2)))) && (codePointAt != 43 || !z3))) {
                    i4 += Character.charCount(codePointAt);
                }
            }
            bwl bwl = new bwl();
            int i5 = i;
            bwl.mo3818b(str, i, i4);
            m8811a(bwl, str, i4, i2, str2, z, z2, z3, z4);
            return bwl.mo3887w();
        }
        int i6 = i;
        return str.substring(i, i2);
    }

    /* renamed from: a */
    static void m8811a(bwl bwl, String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        bwl bwl2 = null;
        while (i < i2) {
            int codePointAt = str.codePointAt(i);
            if (!z || !(codePointAt == 9 || codePointAt == 10 || codePointAt == 12 || codePointAt == 13)) {
                if (codePointAt == 43 && z3) {
                    bwl.mo3817b(z ? "+" : "%2B");
                } else if (codePointAt < 32 || codePointAt == 127 || ((codePointAt >= 128 && z4) || str2.indexOf(codePointAt) != -1 || (codePointAt == 37 && (!z || (z2 && !m8814a(str, i, i2)))))) {
                    if (bwl2 == null) {
                        bwl2 = new bwl();
                    }
                    bwl2.mo3815b(codePointAt);
                    while (!bwl2.mo3854i()) {
                        byte m = bwl2.mo3866m() & 255;
                        bwl.mo3833d(37);
                        char[] cArr = f3407k;
                        bwl.mo3833d((int) cArr[(m >> 4) & 15]);
                        bwl.mo3833d((int) cArr[m & Ascii.f8523SI]);
                    }
                } else {
                    bwl.mo3815b(codePointAt);
                }
            }
            i += Character.charCount(codePointAt);
        }
    }

    /* renamed from: a */
    static String m8808a(String str, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        return m8806a(str, 0, str.length(), str2, z, z2, z3, z4);
    }
}
