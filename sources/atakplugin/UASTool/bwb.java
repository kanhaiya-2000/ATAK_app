package atakplugin.UASTool;

@aot(mo1534a = 1, mo1535b = {1, 1, 11}, mo1536c = {1, 0, 2}, mo1537d = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0007¨\u0006\n"}, mo1538e = {"Lokio/-DeprecatedUtf8;", "", "()V", "size", "", "string", "", "beginIndex", "", "endIndex", "jvm"})
public final class bwb {

    /* renamed from: a */
    public static final bwb f4099a = new bwb();

    private bwb() {
    }

    @anx(mo1516a = "moved to extension function", mo1517b = @C0081api(mo1552a = "string.utf8Size()", mo1553b = {"okio.utf8Size"}), mo1518c = any.ERROR)
    /* renamed from: a */
    public final long mo3754a(String str) {
        bfq.m6567f(str, "string");
        return bxu.m10501a(str, 0, 0, 3, (Object) null);
    }

    @anx(mo1516a = "moved to extension function", mo1517b = @C0081api(mo1552a = "string.utf8Size(beginIndex, endIndex)", mo1553b = {"okio.utf8Size"}), mo1518c = any.ERROR)
    /* renamed from: a */
    public final long mo3755a(String str, int i, int i2) {
        bfq.m6567f(str, "string");
        return bxu.m10500a(str, i, i2);
    }
}
