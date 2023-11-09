package atakplugin.UASTool;

import com.autel.downloader.bean.DownloadTask;
import java.io.File;

@aot(mo1534a = 5, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000$\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u001a\u0011\u0010\u000b\u001a\u00020\f*\u00020\bH\u0002¢\u0006\u0002\b\r\u001a\u001c\u0010\u000e\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\fH\u0000\u001a\f\u0010\u0011\u001a\u00020\u0012*\u00020\u0002H\u0000\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0000\u0010\u0003\"\u0018\u0010\u0004\u001a\u00020\u0002*\u00020\u00028@X\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\"\u0018\u0010\u0007\u001a\u00020\b*\u00020\u00028@X\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, mo1538e = {"isRooted", "", "Ljava/io/File;", "(Ljava/io/File;)Z", "root", "getRoot", "(Ljava/io/File;)Ljava/io/File;", "rootName", "", "getRootName", "(Ljava/io/File;)Ljava/lang/String;", "getRootLength", "", "getRootLength$FilesKt__FilePathComponentsKt", "subPath", "beginIndex", "endIndex", "toComponents", "Lkotlin/io/FilePathComponents;", "kotlin-stdlib"}, mo1539f = "kotlin/io/FilesKt", mo1541h = 1)
class bcc {
    /* renamed from: a */
    private static final int m6283a(String str) {
        int a;
        CharSequence charSequence = str;
        int a2 = boc.m8080a(charSequence, File.separatorChar, 0, false, 4, (Object) null);
        if (a2 == 0) {
            if (str.length() <= 1 || str.charAt(1) != File.separatorChar || (a = boc.m8080a(charSequence, File.separatorChar, 2, false, 4, (Object) null)) < 0) {
                return 1;
            }
            int i = a + 1;
            int a3 = boc.m8080a(charSequence, File.separatorChar, i, false, 4, (Object) null);
            if (a3 >= 0) {
                return a3 + 1;
            }
            return str.length();
        } else if (a2 > 0 && str.charAt(a2 - 1) == ':') {
            return a2 + 1;
        } else {
            if (a2 != -1 || !boc.m8176b(charSequence, ':', false, 2, (Object) null)) {
                return 0;
            }
            return str.length();
        }
    }

    /* renamed from: a */
    public static final String m6285a(File file) {
        bfq.m6567f(file, "$this$rootName");
        String path = file.getPath();
        bfq.m6554b(path, DownloadTask.PATH);
        String path2 = file.getPath();
        bfq.m6554b(path2, DownloadTask.PATH);
        int a = m6283a(path2);
        if (path != null) {
            String substring = path.substring(0, a);
            bfq.m6554b(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            return substring;
        }
        throw new apx("null cannot be cast to non-null type java.lang.String");
    }

    /* renamed from: b */
    public static final File m6286b(File file) {
        bfq.m6567f(file, "$this$root");
        return new File(bcb.m6285a(file));
    }

    /* renamed from: c */
    public static final boolean m6287c(File file) {
        bfq.m6567f(file, "$this$isRooted");
        String path = file.getPath();
        bfq.m6554b(path, DownloadTask.PATH);
        return m6283a(path) > 0;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: java.util.Collection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v10, resolved type: java.util.List} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final atakplugin.UASTool.bbw m6288d(java.io.File r9) {
        /*
            java.lang.String r0 = "$this$toComponents"
            atakplugin.UASTool.bfq.m6567f(r9, r0)
            java.lang.String r9 = r9.getPath()
            java.lang.String r0 = "path"
            atakplugin.UASTool.bfq.m6554b(r9, r0)
            int r0 = m6283a((java.lang.String) r9)
            r1 = 0
            java.lang.String r2 = r9.substring(r1, r0)
            java.lang.String r3 = "(this as java.lang.Strin…ing(startIndex, endIndex)"
            atakplugin.UASTool.bfq.m6554b(r2, r3)
            java.lang.String r9 = r9.substring(r0)
            java.lang.String r0 = "(this as java.lang.String).substring(startIndex)"
            atakplugin.UASTool.bfq.m6554b(r9, r0)
            r3 = r9
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            int r9 = r3.length()
            r0 = 1
            if (r9 != 0) goto L_0x0031
            r9 = 1
            goto L_0x0032
        L_0x0031:
            r9 = 0
        L_0x0032:
            if (r9 == 0) goto L_0x0039
            java.util.List r9 = atakplugin.UASTool.ato.m4604a()
            goto L_0x0072
        L_0x0039:
            char[] r4 = new char[r0]
            char r9 = java.io.File.separatorChar
            r4[r1] = r9
            r5 = 0
            r6 = 0
            r7 = 6
            r8 = 0
            java.util.List r9 = atakplugin.UASTool.boc.m8172b((java.lang.CharSequence) r3, (char[]) r4, (boolean) r5, (int) r6, (int) r7, (java.lang.Object) r8)
            java.lang.Iterable r9 = (java.lang.Iterable) r9
            java.util.ArrayList r0 = new java.util.ArrayList
            r1 = 10
            int r1 = atakplugin.UASTool.ato.m4625a(r9, (int) r1)
            r0.<init>(r1)
            java.util.Collection r0 = (java.util.Collection) r0
            java.util.Iterator r9 = r9.iterator()
        L_0x005a:
            boolean r1 = r9.hasNext()
            if (r1 == 0) goto L_0x006f
            java.lang.Object r1 = r9.next()
            java.lang.String r1 = (java.lang.String) r1
            java.io.File r3 = new java.io.File
            r3.<init>(r1)
            r0.add(r3)
            goto L_0x005a
        L_0x006f:
            r9 = r0
            java.util.List r9 = (java.util.List) r9
        L_0x0072:
            atakplugin.UASTool.bbw r0 = new atakplugin.UASTool.bbw
            java.io.File r1 = new java.io.File
            r1.<init>(r2)
            r0.<init>(r1, r9)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.bcc.m6288d(java.io.File):atakplugin.UASTool.bbw");
    }

    /* renamed from: a */
    public static final File m6284a(File file, int i, int i2) {
        bfq.m6567f(file, "$this$subPath");
        return bcb.m6288d(file).mo2254a(i, i2);
    }
}
