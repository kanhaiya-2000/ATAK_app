package atakplugin.UASTool;

import java.util.SortedSet;
import java.util.TreeSet;

@aot(mo1534a = 5, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\u0018\n\u0000\n\u0002\u0010\f\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\b\u001a\u0010\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006*\u00020\u0002¨\u0006\u0007"}, mo1538e = {"elementAt", "", "", "index", "", "toSortedSet", "Ljava/util/SortedSet;", "kotlin-stdlib"}, mo1539f = "kotlin/text/StringsKt", mo1541h = 1)
class bou extends boo {
    /* renamed from: c */
    private static final char m8243c(CharSequence charSequence, int i) {
        return charSequence.charAt(i);
    }

    /* renamed from: j */
    public static final SortedSet<Character> m8244j(CharSequence charSequence) {
        bfq.m6567f(charSequence, "$this$toSortedSet");
        return (SortedSet) boc.m8273a(charSequence, new TreeSet());
    }
}
