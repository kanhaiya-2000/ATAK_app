package atakplugin.UASTool;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo1538e = {"Lkotlin/text/SystemProperties;", "", "()V", "LINE_SEPARATOR", "", "kotlin-stdlib"})
final class bpe {

    /* renamed from: a */
    public static final String f3077a;

    /* renamed from: b */
    public static final bpe f3078b = new bpe();

    static {
        String property = System.getProperty("line.separator");
        if (property == null) {
            bfq.m6538a();
        }
        f3077a = property;
    }

    private bpe() {
    }
}
