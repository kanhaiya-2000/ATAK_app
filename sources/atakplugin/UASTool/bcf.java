package atakplugin.UASTool;

import java.io.File;

@aot(mo1534a = 5, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u001a\n\u0010\u0005\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0006\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0007"}, mo1538e = {"walk", "Lkotlin/io/FileTreeWalk;", "Ljava/io/File;", "direction", "Lkotlin/io/FileWalkDirection;", "walkBottomUp", "walkTopDown", "kotlin-stdlib"}, mo1539f = "kotlin/io/FilesKt", mo1541h = 1)
class bcf extends bcd {
    /* renamed from: a */
    public static /* synthetic */ bby m6320a(File file, bca bca, int i, Object obj) {
        if ((i & 1) != 0) {
            bca = bca.TOP_DOWN;
        }
        return bcb.m6319a(file, bca);
    }

    /* renamed from: a */
    public static final bby m6319a(File file, bca bca) {
        bfq.m6567f(file, "$this$walk");
        bfq.m6567f(bca, "direction");
        return new bby(file, bca);
    }

    /* renamed from: f */
    public static final bby m6321f(File file) {
        bfq.m6567f(file, "$this$walkTopDown");
        return bcb.m6319a(file, bca.TOP_DOWN);
    }

    /* renamed from: g */
    public static final bby m6322g(File file) {
        bfq.m6567f(file, "$this$walkBottomUp");
        return bcb.m6319a(file, bca.BOTTOM_UP);
    }
}
