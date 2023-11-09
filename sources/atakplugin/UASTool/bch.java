package atakplugin.UASTool;

import java.io.File;
import java.io.IOException;

@aot(mo1534a = 3, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, mo1538e = {"<anonymous>", "", "<anonymous parameter 0>", "Ljava/io/File;", "exception", "Ljava/io/IOException;", "invoke"})
final class bch extends bfr implements bdw {

    /* renamed from: a */
    public static final bch f2547a = new bch();

    bch() {
        super(2);
    }

    /* renamed from: a */
    public final Void mo2065a(File file, IOException iOException) {
        bfq.m6567f(file, "<anonymous parameter 0>");
        bfq.m6567f(iOException, "exception");
        throw iOException;
    }
}
