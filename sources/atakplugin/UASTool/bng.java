package atakplugin.UASTool;

@aot(mo1534a = 5, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\f\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u0001\u001a\n\u0010\u0005\u001a\u00020\u0001*\u00020\u0002\u001a\u0015\u0010\u0006\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0007H\n¨\u0006\b"}, mo1538e = {"equals", "", "", "other", "ignoreCase", "isSurrogate", "plus", "", "kotlin-stdlib"}, mo1539f = "kotlin/text/CharsKt", mo1541h = 1)
class bng extends bnf {
    /* renamed from: d */
    public static final boolean m7753d(char c) {
        return 55296 <= c && 57343 >= c;
    }

    /* renamed from: a */
    private static final String m7750a(char c, String str) {
        return String.valueOf(c) + str;
    }

    /* renamed from: a */
    public static /* synthetic */ boolean m7752a(char c, char c2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return bne.m7751a(c, c2, z);
    }

    /* renamed from: a */
    public static final boolean m7751a(char c, char c2, boolean z) {
        if (c == c2) {
            return true;
        }
        if (!z) {
            return false;
        }
        return Character.toUpperCase(c) == Character.toUpperCase(c2) || Character.toLowerCase(c) == Character.toLowerCase(c2);
    }
}
