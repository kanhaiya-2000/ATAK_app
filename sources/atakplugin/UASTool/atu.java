package atakplugin.UASTool;

import java.util.Enumeration;
import java.util.Iterator;

@aot(mo1534a = 5, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\u000e\n\u0000\n\u0002\u0010(\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001f\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0002¨\u0006\u0004"}, mo1538e = {"iterator", "", "T", "Ljava/util/Enumeration;", "kotlin-stdlib"}, mo1539f = "kotlin/collections/CollectionsKt", mo1541h = 1)
class atu extends ats {
    /* renamed from: a */
    public static final <T> Iterator<T> m4633a(Enumeration<T> enumeration) {
        bfq.m6567f(enumeration, "$this$iterator");
        return new atv(enumeration);
    }
}
