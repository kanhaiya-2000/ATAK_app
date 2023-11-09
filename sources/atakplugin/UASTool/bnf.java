package atakplugin.UASTool;

@aot(mo1534a = 5, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0011\u001a\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0001\u001a\u0018\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0000\u001a\r\u0010\u000e\u001a\u00020\u000f*\u00020\u0002H\b\u001a\r\u0010\u0010\u001a\u00020\u000f*\u00020\u0002H\b\u001a\r\u0010\u0011\u001a\u00020\u000f*\u00020\u0002H\b\u001a\r\u0010\u0012\u001a\u00020\u000f*\u00020\u0002H\b\u001a\r\u0010\u0013\u001a\u00020\u000f*\u00020\u0002H\b\u001a\r\u0010\u0014\u001a\u00020\u000f*\u00020\u0002H\b\u001a\r\u0010\u0015\u001a\u00020\u000f*\u00020\u0002H\b\u001a\r\u0010\u0016\u001a\u00020\u000f*\u00020\u0002H\b\u001a\r\u0010\u0017\u001a\u00020\u000f*\u00020\u0002H\b\u001a\r\u0010\u0018\u001a\u00020\u000f*\u00020\u0002H\b\u001a\r\u0010\u0019\u001a\u00020\u000f*\u00020\u0002H\b\u001a\r\u0010\u001a\u001a\u00020\u000f*\u00020\u0002H\b\u001a\r\u0010\u001b\u001a\u00020\u000f*\u00020\u0002H\b\u001a\n\u0010\u001c\u001a\u00020\u000f*\u00020\u0002\u001a\r\u0010\u001d\u001a\u00020\u0002*\u00020\u0002H\b\u001a\r\u0010\u001e\u001a\u00020\u0002*\u00020\u0002H\b\u001a\r\u0010\u001f\u001a\u00020\u0002*\u00020\u0002H\b\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0015\u0010\u0005\u001a\u00020\u0006*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006 "}, mo1538e = {"category", "Lkotlin/text/CharCategory;", "", "getCategory", "(C)Lkotlin/text/CharCategory;", "directionality", "Lkotlin/text/CharDirectionality;", "getDirectionality", "(C)Lkotlin/text/CharDirectionality;", "checkRadix", "", "radix", "digitOf", "char", "isDefined", "", "isDigit", "isHighSurrogate", "isISOControl", "isIdentifierIgnorable", "isJavaIdentifierPart", "isJavaIdentifierStart", "isLetter", "isLetterOrDigit", "isLowSurrogate", "isLowerCase", "isTitleCase", "isUpperCase", "isWhitespace", "toLowerCase", "toTitleCase", "toUpperCase", "kotlin-stdlib"}, mo1539f = "kotlin/text/CharsKt", mo1541h = 1)
class bnf {
    /* renamed from: d */
    private static final boolean m7734d(char c) {
        return Character.isDefined(c);
    }

    /* renamed from: e */
    private static final boolean m7735e(char c) {
        return Character.isLetter(c);
    }

    /* renamed from: f */
    private static final boolean m7736f(char c) {
        return Character.isLetterOrDigit(c);
    }

    /* renamed from: g */
    private static final boolean m7737g(char c) {
        return Character.isDigit(c);
    }

    /* renamed from: h */
    private static final boolean m7738h(char c) {
        return Character.isIdentifierIgnorable(c);
    }

    /* renamed from: i */
    private static final boolean m7739i(char c) {
        return Character.isISOControl(c);
    }

    /* renamed from: j */
    private static final boolean m7740j(char c) {
        return Character.isJavaIdentifierPart(c);
    }

    /* renamed from: k */
    private static final boolean m7741k(char c) {
        return Character.isJavaIdentifierStart(c);
    }

    /* renamed from: a */
    public static final boolean m7731a(char c) {
        return Character.isWhitespace(c) || Character.isSpaceChar(c);
    }

    /* renamed from: l */
    private static final boolean m7742l(char c) {
        return Character.isUpperCase(c);
    }

    /* renamed from: m */
    private static final boolean m7743m(char c) {
        return Character.isLowerCase(c);
    }

    /* renamed from: n */
    private static final char m7744n(char c) {
        return Character.toUpperCase(c);
    }

    /* renamed from: o */
    private static final char m7745o(char c) {
        return Character.toLowerCase(c);
    }

    /* renamed from: p */
    private static final boolean m7746p(char c) {
        return Character.isTitleCase(c);
    }

    /* renamed from: q */
    private static final char m7747q(char c) {
        return Character.toTitleCase(c);
    }

    /* renamed from: b */
    public static final bna m7732b(char c) {
        return bna.f2937E.mo2813a(Character.getType(c));
    }

    /* renamed from: c */
    public static final bnc m7733c(char c) {
        return bnc.f2990u.mo2816a(Character.getDirectionality(c));
    }

    /* renamed from: r */
    private static final boolean m7748r(char c) {
        return Character.isHighSurrogate(c);
    }

    /* renamed from: s */
    private static final boolean m7749s(char c) {
        return Character.isLowSurrogate(c);
    }

    /* renamed from: a */
    public static final int m7729a(char c, int i) {
        return Character.digit(c, i);
    }

    /* renamed from: a */
    public static final int m7730a(int i) {
        if (2 <= i && 36 >= i) {
            return i;
        }
        throw new IllegalArgumentException("radix " + i + " was not in valid range " + new biq(2, 36));
    }
}
