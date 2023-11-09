package atakplugin.UASTool;

import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;

@aot(mo1534a = 2, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000>\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0000\u001a-\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0014\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\b\u001a\u001e\u0010\u0007\u001a\u0004\u0018\u00010\b*\u00020\t2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0002\u001a\u0016\u0010\r\u001a\u0004\u0018\u00010\b*\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0002\u001a\f\u0010\u000e\u001a\u00020\u000f*\u00020\u0010H\u0002\u001a\u0014\u0010\u000e\u001a\u00020\u000f*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0006H\u0002\u001a\u0012\u0010\u0012\u001a\u00020\u0006*\b\u0012\u0004\u0012\u00020\u00030\u0013H\u0002¨\u0006\u0014"}, mo1538e = {"fromInt", "", "T", "Lkotlin/text/FlagEnum;", "", "value", "", "findNext", "Lkotlin/text/MatchResult;", "Ljava/util/regex/Matcher;", "from", "input", "", "matchEntire", "range", "Lkotlin/ranges/IntRange;", "Ljava/util/regex/MatchResult;", "groupIndex", "toInt", "", "kotlin-stdlib"})
public final class bny {
    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final /* synthetic */ <T extends Enum<T> & bnl> Set<T> m7860b(int i) {
        bfq.m6539a(4, "T");
        EnumSet<E> allOf = EnumSet.allOf(Enum.class);
        ato.m4659b(allOf, new bnz(i));
        Set<T> unmodifiableSet = Collections.unmodifiableSet(allOf);
        bfq.m6554b(unmodifiableSet, "Collections.unmodifiable…mask == it.value }\n    })");
        return unmodifiableSet;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final bnp m7858b(Matcher matcher, int i, CharSequence charSequence) {
        if (!matcher.find(i)) {
            return null;
        }
        return new bnq(matcher, charSequence);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final bnp m7859b(Matcher matcher, CharSequence charSequence) {
        if (!matcher.matches()) {
            return null;
        }
        return new bnq(matcher, charSequence);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final biq m7856b(MatchResult matchResult) {
        return biu.m7151b(matchResult.start(), matchResult.end());
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final biq m7857b(MatchResult matchResult, int i) {
        return biu.m7151b(matchResult.start(i), matchResult.end(i));
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final int m7855b(Iterable<? extends bnl> iterable) {
        int i = 0;
        for (bnl a : iterable) {
            i |= a.mo2835a();
        }
        return i;
    }
}
