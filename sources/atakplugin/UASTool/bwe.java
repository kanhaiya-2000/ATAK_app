package atakplugin.UASTool;

import java.util.zip.Inflater;

@aot(mo1534a = 2, mo1535b = {1, 1, 11}, mo1536c = {1, 0, 2}, mo1537d = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0017\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\b¨\u0006\u0005"}, mo1538e = {"inflate", "Lokio/InflaterSource;", "Lokio/Source;", "inflater", "Ljava/util/zip/Inflater;", "jvm"})
public final class bwe {
    /* renamed from: a */
    public static /* synthetic */ bwz m9941a(bxr bxr, Inflater inflater, int i, Object obj) {
        if ((i & 1) != 0) {
            inflater = new Inflater();
        }
        bfq.m6567f(bxr, "$receiver");
        bfq.m6567f(inflater, "inflater");
        return new bwz(bxr, inflater);
    }

    /* renamed from: a */
    public static final bwz m9940a(bxr bxr, Inflater inflater) {
        bfq.m6567f(bxr, "$receiver");
        bfq.m6567f(inflater, "inflater");
        return new bwz(bxr, inflater);
    }
}
