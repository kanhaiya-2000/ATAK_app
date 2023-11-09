package atakplugin.UASTool;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00152\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0015B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\u0011\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0003H\u0002J\u0013\u0010\r\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u000bH\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u0014\u0010\u0005\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0004\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\b¨\u0006\u0016"}, mo1538e = {"Lkotlin/ranges/CharRange;", "Lkotlin/ranges/CharProgression;", "Lkotlin/ranges/ClosedRange;", "", "start", "endInclusive", "(CC)V", "getEndInclusive", "()Ljava/lang/Character;", "getStart", "contains", "", "value", "equals", "other", "", "hashCode", "", "isEmpty", "toString", "", "Companion", "kotlin-stdlib"})
public final class bii extends big implements bim<Character> {

    /* renamed from: b */
    public static final C0166a f2726b = new C0166a((bfd) null);
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static final bii f2727c = new bii((char) 1, (char) 0);

    public bii(char c, char c2) {
        super(c, c2, 1);
    }

    /* renamed from: a */
    public /* synthetic */ boolean mo2567a(Comparable comparable) {
        return mo2566a(((Character) comparable).charValue());
    }

    /* renamed from: f */
    public Character mo2569g() {
        return Character.valueOf(mo2554a());
    }

    /* renamed from: h */
    public Character mo2571i() {
        return Character.valueOf(mo2555b());
    }

    /* renamed from: a */
    public boolean mo2566a(char c) {
        return mo2554a() <= c && c <= mo2555b();
    }

    /* renamed from: e */
    public boolean mo2558e() {
        return mo2554a() > mo2555b();
    }

    public boolean equals(Object obj) {
        if (obj instanceof bii) {
            if (!mo2558e() || !((bii) obj).mo2558e()) {
                bii bii = (bii) obj;
                if (!(mo2554a() == bii.mo2554a() && mo2555b() == bii.mo2555b())) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (mo2558e()) {
            return -1;
        }
        return (mo2554a() * 31) + mo2555b();
    }

    public String toString() {
        return mo2554a() + ".." + mo2555b();
    }

    @aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, mo1538e = {"Lkotlin/ranges/CharRange$Companion;", "", "()V", "EMPTY", "Lkotlin/ranges/CharRange;", "getEMPTY", "()Lkotlin/ranges/CharRange;", "kotlin-stdlib"})
    /* renamed from: atakplugin.UASTool.bii$a */
    public static final class C0166a {
        private C0166a() {
        }

        public /* synthetic */ C0166a(bfd bfd) {
            this();
        }

        /* renamed from: a */
        public final bii mo2572a() {
            return bii.f2727c;
        }
    }
}
