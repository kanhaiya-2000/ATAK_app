package atakplugin.UASTool;

@aot(mo1534a = 3, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0005\u0010\u0000\u001a\u00020\u0001\"\u0014\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00042\u000e\u0010\u0005\u001a\n \u0006*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, mo1538e = {"<anonymous>", "", "T", "Lkotlin/text/FlagEnum;", "", "it", "kotlin.jvm.PlatformType", "invoke", "(Ljava/lang/Enum;)Z", "kotlin/text/RegexKt$fromInt$1$1"})
public final class bnx extends bfr implements bdl<T, Boolean> {

    /* renamed from: a */
    final /* synthetic */ int f3037a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public bnx(int i) {
        super(1);
        this.f3037a = i;
    }

    public /* synthetic */ Object invoke(Object obj) {
        return Boolean.valueOf(mo2881a((Enum) obj));
    }

    /* renamed from: a */
    public final boolean mo2881a(T t) {
        bnl bnl = (bnl) t;
        return (this.f3037a & bnl.mo2836b()) == bnl.mo2835a();
    }
}
