package atakplugin.UASTool;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, mo1538e = {"Lkotlin/NotImplementedError;", "Ljava/lang/Error;", "Lkotlin/Error;", "message", "", "(Ljava/lang/String;)V", "kotlin-stdlib"})
public final class aov extends Error {
    public aov() {
        this((String) null, 1, (bfd) null);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public aov(String str) {
        super(str);
        bfq.m6567f(str, "message");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ aov(String str, int i, bfd bfd) {
        this((i & 1) != 0 ? "An operation is not implemented." : str);
    }
}
