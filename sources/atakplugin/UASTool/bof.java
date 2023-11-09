package atakplugin.UASTool;

@aot(mo1534a = 3, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, mo1538e = {"<anonymous>", "", "line", "invoke"})
final class bof extends bfr implements bdl<String, String> {

    /* renamed from: a */
    final /* synthetic */ String f3056a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    bof(String str) {
        super(1);
        this.f3056a = str;
    }

    /* renamed from: a */
    public final String invoke(String str) {
        bfq.m6567f(str, "line");
        return this.f3056a + str;
    }
}
