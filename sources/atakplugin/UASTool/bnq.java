package atakplugin.UASTool;

import atakplugin.UASTool.bnp;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\n\u0010\u001c\u001a\u0004\u0018\u00010\u0001H\u0016R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u00128BX\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\u00020\u00168VX\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\t8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001d"}, mo1538e = {"Lkotlin/text/MatcherMatchResult;", "Lkotlin/text/MatchResult;", "matcher", "Ljava/util/regex/Matcher;", "input", "", "(Ljava/util/regex/Matcher;Ljava/lang/CharSequence;)V", "groupValues", "", "", "getGroupValues", "()Ljava/util/List;", "groupValues_", "groups", "Lkotlin/text/MatchGroupCollection;", "getGroups", "()Lkotlin/text/MatchGroupCollection;", "matchResult", "Ljava/util/regex/MatchResult;", "getMatchResult", "()Ljava/util/regex/MatchResult;", "range", "Lkotlin/ranges/IntRange;", "getRange", "()Lkotlin/ranges/IntRange;", "value", "getValue", "()Ljava/lang/String;", "next", "kotlin-stdlib"})
final class bnq implements bnp {

    /* renamed from: a */
    private final bnn f3019a = new bns(this);

    /* renamed from: b */
    private List<String> f3020b;

    /* renamed from: c */
    private final Matcher f3021c;

    /* renamed from: d */
    private final CharSequence f3022d;

    public bnq(Matcher matcher, CharSequence charSequence) {
        bfq.m6567f(matcher, "matcher");
        bfq.m6567f(charSequence, "input");
        this.f3021c = matcher;
        this.f3022d = charSequence;
    }

    /* renamed from: e */
    public bnp.C0202b mo2851e() {
        return bnp.C0201a.m7791a(this);
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public final MatchResult m7805g() {
        return this.f3021c;
    }

    /* renamed from: a */
    public biq mo2847a() {
        return bny.m7856b(m7805g());
    }

    /* renamed from: b */
    public String mo2848b() {
        String group = m7805g().group();
        bfq.m6554b(group, "matchResult.group()");
        return group;
    }

    /* renamed from: c */
    public bnn mo2849c() {
        return this.f3019a;
    }

    /* renamed from: d */
    public List<String> mo2850d() {
        if (this.f3020b == null) {
            this.f3020b = new bnr(this);
        }
        List<String> list = this.f3020b;
        if (list == null) {
            bfq.m6538a();
        }
        return list;
    }

    /* renamed from: f */
    public bnp mo2852f() {
        int end = m7805g().end() + (m7805g().end() == m7805g().start() ? 1 : 0);
        if (end > this.f3022d.length()) {
            return null;
        }
        Matcher matcher = this.f3021c.pattern().matcher(this.f3022d);
        bfq.m6554b(matcher, "matcher.pattern().matcher(input)");
        return bny.m7858b(matcher, end, this.f3022d);
    }
}
