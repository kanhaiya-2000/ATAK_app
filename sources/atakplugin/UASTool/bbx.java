package atakplugin.UASTool;

import java.io.File;
import java.io.IOException;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, mo1538e = {"Lkotlin/io/FileSystemException;", "Ljava/io/IOException;", "file", "Ljava/io/File;", "other", "reason", "", "(Ljava/io/File;Ljava/io/File;Ljava/lang/String;)V", "getFile", "()Ljava/io/File;", "getOther", "getReason", "()Ljava/lang/String;", "kotlin-stdlib"})
public class bbx extends IOException {

    /* renamed from: a */
    private final File f2518a;

    /* renamed from: b */
    private final File f2519b;

    /* renamed from: c */
    private final String f2520c;

    /* renamed from: a */
    public final File mo2265a() {
        return this.f2518a;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ bbx(File file, File file2, String str, int i, bfd bfd) {
        this(file, (i & 2) != 0 ? null : file2, (i & 4) != 0 ? null : str);
    }

    /* renamed from: b */
    public final File mo2266b() {
        return this.f2519b;
    }

    /* renamed from: c */
    public final String mo2267c() {
        return this.f2520c;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public bbx(File file, File file2, String str) {
        super(bbt.m6249b(file, file2, str));
        bfq.m6567f(file, "file");
        this.f2518a = file;
        this.f2519b = file2;
        this.f2520c = str;
    }
}
