package atakplugin.UASTool;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 ,2\u00060\u0001j\u0002`\u0002:\u0002,-B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0017\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB\u001d\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\n¢\u0006\u0002\u0010\u000bB\u000f\b\u0001\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\u001a\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u001a\u001a\u00020\u001bJ\u001e\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00190\u001d2\u0006\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u001a\u001a\u00020\u001bJ\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0016\u001a\u00020\u0017J\u0011\u0010\u001f\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0004J\"\u0010 \u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00172\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00170\"J\u0016\u0010 \u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010#\u001a\u00020\u0004J\u0016\u0010$\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010#\u001a\u00020\u0004J\u001e\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00040&2\u0006\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010'\u001a\u00020\u001bJ\u0006\u0010(\u001a\u00020\rJ\b\u0010)\u001a\u00020\u0004H\u0016J\b\u0010*\u001a\u00020+H\u0002R\u0016\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\n8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006."}, mo1538e = {"Lkotlin/text/Regex;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "pattern", "", "(Ljava/lang/String;)V", "option", "Lkotlin/text/RegexOption;", "(Ljava/lang/String;Lkotlin/text/RegexOption;)V", "options", "", "(Ljava/lang/String;Ljava/util/Set;)V", "nativePattern", "Ljava/util/regex/Pattern;", "(Ljava/util/regex/Pattern;)V", "_options", "getOptions", "()Ljava/util/Set;", "getPattern", "()Ljava/lang/String;", "containsMatchIn", "", "input", "", "find", "Lkotlin/text/MatchResult;", "startIndex", "", "findAll", "Lkotlin/sequences/Sequence;", "matchEntire", "matches", "replace", "transform", "Lkotlin/Function1;", "replacement", "replaceFirst", "split", "", "limit", "toPattern", "toString", "writeReplace", "", "Companion", "Serialized", "kotlin-stdlib"})
public final class bnu implements Serializable {

    /* renamed from: a */
    public static final C0203a f3026a = new C0203a((bfd) null);

    /* renamed from: b */
    private Set<? extends boa> f3027b;

    /* renamed from: c */
    private final Pattern f3028c;

    public bnu(Pattern pattern) {
        bfq.m6567f(pattern, "nativePattern");
        this.f3028c = pattern;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public bnu(java.lang.String r2) {
        /*
            r1 = this;
            java.lang.String r0 = "pattern"
            atakplugin.UASTool.bfq.m6567f(r2, r0)
            java.util.regex.Pattern r2 = java.util.regex.Pattern.compile(r2)
            java.lang.String r0 = "Pattern.compile(pattern)"
            atakplugin.UASTool.bfq.m6554b(r2, r0)
            r1.<init>((java.util.regex.Pattern) r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.bnu.<init>(java.lang.String):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public bnu(java.lang.String r2, atakplugin.UASTool.boa r3) {
        /*
            r1 = this;
            java.lang.String r0 = "pattern"
            atakplugin.UASTool.bfq.m6567f(r2, r0)
            java.lang.String r0 = "option"
            atakplugin.UASTool.bfq.m6567f(r3, r0)
            atakplugin.UASTool.bnu$a r0 = f3026a
            int r3 = r3.mo2835a()
            int r3 = r0.m7838a((int) r3)
            java.util.regex.Pattern r2 = java.util.regex.Pattern.compile(r2, r3)
            java.lang.String r3 = "Pattern.compile(pattern,…nicodeCase(option.value))"
            atakplugin.UASTool.bfq.m6554b(r2, r3)
            r1.<init>((java.util.regex.Pattern) r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.bnu.<init>(java.lang.String, atakplugin.UASTool.boa):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public bnu(java.lang.String r2, java.util.Set<? extends atakplugin.UASTool.boa> r3) {
        /*
            r1 = this;
            java.lang.String r0 = "pattern"
            atakplugin.UASTool.bfq.m6567f(r2, r0)
            java.lang.String r0 = "options"
            atakplugin.UASTool.bfq.m6567f(r3, r0)
            atakplugin.UASTool.bnu$a r0 = f3026a
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            int r3 = atakplugin.UASTool.bny.m7855b((java.lang.Iterable<? extends atakplugin.UASTool.bnl>) r3)
            int r3 = r0.m7838a((int) r3)
            java.util.regex.Pattern r2 = java.util.regex.Pattern.compile(r2, r3)
            java.lang.String r3 = "Pattern.compile(pattern,…odeCase(options.toInt()))"
            atakplugin.UASTool.bfq.m6554b(r2, r3)
            r1.<init>((java.util.regex.Pattern) r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.bnu.<init>(java.lang.String, java.util.Set):void");
    }

    /* renamed from: a */
    public final String mo2862a() {
        String pattern = this.f3028c.pattern();
        bfq.m6554b(pattern, "nativePattern.pattern()");
        return pattern;
    }

    /* renamed from: b */
    public final Set<boa> mo2868b() {
        Set<? extends boa> set = this.f3027b;
        if (set != null) {
            return set;
        }
        int flags = this.f3028c.flags();
        EnumSet<E> allOf = EnumSet.allOf(boa.class);
        ato.m4659b(allOf, new bnx(flags));
        Set<? extends boa> unmodifiableSet = Collections.unmodifiableSet(allOf);
        bfq.m6554b(unmodifiableSet, "Collections.unmodifiable…mask == it.value }\n    })");
        this.f3027b = unmodifiableSet;
        return unmodifiableSet;
    }

    /* renamed from: a */
    public final boolean mo2865a(CharSequence charSequence) {
        bfq.m6567f(charSequence, "input");
        return this.f3028c.matcher(charSequence).matches();
    }

    /* renamed from: b */
    public final boolean mo2869b(CharSequence charSequence) {
        bfq.m6567f(charSequence, "input");
        return this.f3028c.matcher(charSequence).find();
    }

    /* renamed from: a */
    public static /* synthetic */ bnp m7822a(bnu bnu, CharSequence charSequence, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return bnu.mo2861a(charSequence, i);
    }

    /* renamed from: a */
    public final bnp mo2861a(CharSequence charSequence, int i) {
        bfq.m6567f(charSequence, "input");
        Matcher matcher = this.f3028c.matcher(charSequence);
        bfq.m6554b(matcher, "nativePattern.matcher(input)");
        return bny.m7858b(matcher, i, charSequence);
    }

    /* renamed from: b */
    public static /* synthetic */ bku m7823b(bnu bnu, CharSequence charSequence, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return bnu.mo2866b(charSequence, i);
    }

    /* renamed from: b */
    public final bku<bnp> mo2866b(CharSequence charSequence, int i) {
        bfq.m6567f(charSequence, "input");
        return bkx.m7461a(new bnv(this, charSequence, i), bnw.f3036a);
    }

    /* renamed from: c */
    public final bnp mo2870c(CharSequence charSequence) {
        bfq.m6567f(charSequence, "input");
        Matcher matcher = this.f3028c.matcher(charSequence);
        bfq.m6554b(matcher, "nativePattern.matcher(input)");
        return bny.m7859b(matcher, charSequence);
    }

    /* renamed from: a */
    public final String mo2864a(CharSequence charSequence, String str) {
        bfq.m6567f(charSequence, "input");
        bfq.m6567f(str, "replacement");
        String replaceAll = this.f3028c.matcher(charSequence).replaceAll(str);
        bfq.m6554b(replaceAll, "nativePattern.matcher(in…).replaceAll(replacement)");
        return replaceAll;
    }

    /* renamed from: a */
    public final String mo2863a(CharSequence charSequence, bdl<? super bnp, ? extends CharSequence> bdl) {
        bfq.m6567f(charSequence, "input");
        bfq.m6567f(bdl, "transform");
        int i = 0;
        bnp a = m7822a(this, charSequence, 0, 2, (Object) null);
        if (a == null) {
            return charSequence.toString();
        }
        int length = charSequence.length();
        StringBuilder sb = new StringBuilder(length);
        do {
            if (a == null) {
                bfq.m6538a();
            }
            sb.append(charSequence, i, a.mo2847a().mo2569g().intValue());
            sb.append((CharSequence) bdl.invoke(a));
            i = a.mo2847a().mo2571i().intValue() + 1;
            a = a.mo2852f();
            if (i >= length) {
                break;
            }
        } while (a != null);
        if (i < length) {
            sb.append(charSequence, i, length);
        }
        String sb2 = sb.toString();
        bfq.m6554b(sb2, "sb.toString()");
        return sb2;
    }

    /* renamed from: b */
    public final String mo2867b(CharSequence charSequence, String str) {
        bfq.m6567f(charSequence, "input");
        bfq.m6567f(str, "replacement");
        String replaceFirst = this.f3028c.matcher(charSequence).replaceFirst(str);
        bfq.m6554b(replaceFirst, "nativePattern.matcher(in…replaceFirst(replacement)");
        return replaceFirst;
    }

    /* renamed from: c */
    public static /* synthetic */ List m7824c(bnu bnu, CharSequence charSequence, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return bnu.mo2871c(charSequence, i);
    }

    /* renamed from: c */
    public final List<String> mo2871c(CharSequence charSequence, int i) {
        bfq.m6567f(charSequence, "input");
        int i2 = 0;
        if (i >= 0) {
            Matcher matcher = this.f3028c.matcher(charSequence);
            if (!matcher.find() || i == 1) {
                return ato.m4586a(charSequence.toString());
            }
            int i3 = 10;
            if (i > 0) {
                i3 = biu.m7191d(i, 10);
            }
            ArrayList arrayList = new ArrayList(i3);
            int i4 = i - 1;
            do {
                arrayList.add(charSequence.subSequence(i2, matcher.start()).toString());
                i2 = matcher.end();
                if ((i4 >= 0 && arrayList.size() == i4) || !matcher.find()) {
                    arrayList.add(charSequence.subSequence(i2, charSequence.length()).toString());
                }
                arrayList.add(charSequence.subSequence(i2, matcher.start()).toString());
                i2 = matcher.end();
                break;
            } while (!matcher.find());
            arrayList.add(charSequence.subSequence(i2, charSequence.length()).toString());
            return arrayList;
        }
        throw new IllegalArgumentException(("Limit must be non-negative, but was " + i + '.').toString());
    }

    public String toString() {
        String pattern = this.f3028c.toString();
        bfq.m6554b(pattern, "nativePattern.toString()");
        return pattern;
    }

    /* renamed from: c */
    public final Pattern mo2872c() {
        return this.f3028c;
    }

    /* renamed from: d */
    private final Object m7825d() {
        String pattern = this.f3028c.pattern();
        bfq.m6554b(pattern, "nativePattern.pattern()");
        return new C0204b(pattern, this.f3028c.flags());
    }

    @aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0002\u0018\u0000 \u000e2\u00060\u0001j\u0002`\u0002:\u0001\u000eB\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\f\u001a\u00020\rH\u0002R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, mo1538e = {"Lkotlin/text/Regex$Serialized;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "pattern", "", "flags", "", "(Ljava/lang/String;I)V", "getFlags", "()I", "getPattern", "()Ljava/lang/String;", "readResolve", "", "Companion", "kotlin-stdlib"})
    /* renamed from: atakplugin.UASTool.bnu$b */
    private static final class C0204b implements Serializable {

        /* renamed from: a */
        public static final C0205a f3029a = new C0205a((bfd) null);

        /* renamed from: d */
        private static final long f3030d = 0;

        /* renamed from: b */
        private final String f3031b;

        /* renamed from: c */
        private final int f3032c;

        @aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo1538e = {"Lkotlin/text/Regex$Serialized$Companion;", "", "()V", "serialVersionUID", "", "kotlin-stdlib"})
        /* renamed from: atakplugin.UASTool.bnu$b$a */
        public static final class C0205a {
            private C0205a() {
            }

            public /* synthetic */ C0205a(bfd bfd) {
                this();
            }
        }

        public C0204b(String str, int i) {
            bfq.m6567f(str, "pattern");
            this.f3031b = str;
            this.f3032c = i;
        }

        /* renamed from: a */
        public final String mo2877a() {
            return this.f3031b;
        }

        /* renamed from: b */
        public final int mo2878b() {
            return this.f3032c;
        }

        /* renamed from: c */
        private final Object m7843c() {
            Pattern compile = Pattern.compile(this.f3031b, this.f3032c);
            bfq.m6554b(compile, "Pattern.compile(pattern, flags)");
            return new bnu(compile);
        }
    }

    @aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\t\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0007¨\u0006\f"}, mo1538e = {"Lkotlin/text/Regex$Companion;", "", "()V", "ensureUnicodeCase", "", "flags", "escape", "", "literal", "escapeReplacement", "fromLiteral", "Lkotlin/text/Regex;", "kotlin-stdlib"})
    /* renamed from: atakplugin.UASTool.bnu$a */
    public static final class C0203a {
        /* access modifiers changed from: private */
        /* renamed from: a */
        public final int m7838a(int i) {
            return (i & 2) != 0 ? i | 64 : i;
        }

        private C0203a() {
        }

        public /* synthetic */ C0203a(bfd bfd) {
            this();
        }

        /* renamed from: a */
        public final bnu mo2874a(String str) {
            bfq.m6567f(str, "literal");
            return new bnu(str, boa.LITERAL);
        }

        /* renamed from: b */
        public final String mo2875b(String str) {
            bfq.m6567f(str, "literal");
            String quote = Pattern.quote(str);
            bfq.m6554b(quote, "Pattern.quote(literal)");
            return quote;
        }

        /* renamed from: c */
        public final String mo2876c(String str) {
            bfq.m6567f(str, "literal");
            String quoteReplacement = Matcher.quoteReplacement(str);
            bfq.m6554b(quoteReplacement, "Matcher.quoteReplacement(literal)");
            return quoteReplacement;
        }
    }
}
