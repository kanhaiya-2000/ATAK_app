package atakplugin.UASTool;

import com.autel.util.log.LogTask;
import java.io.File;
import java.io.IOException;

@aot(mo1534a = 3, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, mo1538e = {"<anonymous>", "", "f", "Ljava/io/File;", "e", "Ljava/io/IOException;", "invoke"})
final class bci extends bfr implements bdw<File, IOException, aqr> {

    /* renamed from: a */
    final /* synthetic */ bdw f2548a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    bci(bdw bdw) {
        super(2);
        this.f2548a = bdw;
    }

    /* renamed from: a */
    public /* bridge */ /* synthetic */ Object mo2065a(Object obj, Object obj2) {
        mo2277a((File) obj, (IOException) obj2);
        return aqr.f2177a;
    }

    /* renamed from: a */
    public final void mo2277a(File file, IOException iOException) {
        bfq.m6567f(file, "f");
        bfq.m6567f(iOException, LogTask.LOG_TYPE_ERROR);
        if (((bcm) this.f2548a.mo2065a(file, iOException)) == bcm.TERMINATE) {
            throw new bco(file);
        }
    }
}
