package atakplugin.UASTool;

import java.util.zip.Deflater;

@aot(mo1534a = 2, mo1535b = {1, 1, 11}, mo1536c = {1, 0, 2}, mo1537d = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0017\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\b¨\u0006\u0005"}, mo1538e = {"deflate", "Lokio/DeflaterSink;", "Lokio/Sink;", "deflater", "Ljava/util/zip/Deflater;", "jvm"})
public final class bvy {
    /* renamed from: a */
    public static /* synthetic */ bwr m9918a(bxp bxp, Deflater deflater, int i, Object obj) {
        if ((i & 1) != 0) {
            deflater = new Deflater();
        }
        bfq.m6567f(bxp, "$receiver");
        bfq.m6567f(deflater, "deflater");
        return new bwr(bxp, deflater);
    }

    /* renamed from: a */
    public static final bwr m9917a(bxp bxp, Deflater deflater) {
        bfq.m6567f(bxp, "$receiver");
        bfq.m6567f(deflater, "deflater");
        return new bwr(bxp, deflater);
    }
}
