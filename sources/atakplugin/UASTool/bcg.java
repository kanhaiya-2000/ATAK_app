package atakplugin.UASTool;

import com.atakmap.android.uastool.tasks.UASTask;
import com.autel.downloader.bean.DownloadTask;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@aot(mo1534a = 5, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000<\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u001a(\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002\u001a(\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002\u001a8\u0010\u000e\u001a\u00020\u000f*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u000f2\u001a\b\u0002\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0013\u001a&\u0010\u0016\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u000f2\b\b\u0002\u0010\u0017\u001a\u00020\u0018\u001a\n\u0010\u0019\u001a\u00020\u000f*\u00020\u0002\u001a\u0012\u0010\u001a\u001a\u00020\u000f*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0002\u001a\u0012\u0010\u001a\u001a\u00020\u000f*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0001\u001a\n\u0010\u001c\u001a\u00020\u0002*\u00020\u0002\u001a\u001d\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00020\u001d*\b\u0012\u0004\u0012\u00020\u00020\u001dH\u0002¢\u0006\u0002\b\u001e\u001a\u0011\u0010\u001c\u001a\u00020\u001f*\u00020\u001fH\u0002¢\u0006\u0002\b\u001e\u001a\u0012\u0010 \u001a\u00020\u0002*\u00020\u00022\u0006\u0010!\u001a\u00020\u0002\u001a\u0014\u0010\"\u001a\u0004\u0018\u00010\u0002*\u00020\u00022\u0006\u0010!\u001a\u00020\u0002\u001a\u0012\u0010#\u001a\u00020\u0002*\u00020\u00022\u0006\u0010!\u001a\u00020\u0002\u001a\u0012\u0010$\u001a\u00020\u0002*\u00020\u00022\u0006\u0010%\u001a\u00020\u0002\u001a\u0012\u0010$\u001a\u00020\u0002*\u00020\u00022\u0006\u0010%\u001a\u00020\u0001\u001a\u0012\u0010&\u001a\u00020\u0002*\u00020\u00022\u0006\u0010%\u001a\u00020\u0002\u001a\u0012\u0010&\u001a\u00020\u0002*\u00020\u00022\u0006\u0010%\u001a\u00020\u0001\u001a\u0012\u0010'\u001a\u00020\u000f*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0002\u001a\u0012\u0010'\u001a\u00020\u000f*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0001\u001a\u0012\u0010(\u001a\u00020\u0001*\u00020\u00022\u0006\u0010!\u001a\u00020\u0002\u001a\u001b\u0010)\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010!\u001a\u00020\u0002H\u0002¢\u0006\u0002\b*\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0015\u0010\u0005\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004\"\u0015\u0010\u0007\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\b\u0010\u0004¨\u0006+"}, mo1538e = {"extension", "", "Ljava/io/File;", "getExtension", "(Ljava/io/File;)Ljava/lang/String;", "invariantSeparatorsPath", "getInvariantSeparatorsPath", "nameWithoutExtension", "getNameWithoutExtension", "createTempDir", "prefix", "suffix", "directory", "createTempFile", "copyRecursively", "", "target", "overwrite", "onError", "Lkotlin/Function2;", "Ljava/io/IOException;", "Lkotlin/io/OnErrorAction;", "copyTo", "bufferSize", "", "deleteRecursively", "endsWith", "other", "normalize", "", "normalize$FilesKt__UtilsKt", "Lkotlin/io/FilePathComponents;", "relativeTo", "base", "relativeToOrNull", "relativeToOrSelf", "resolve", "relative", "resolveSibling", "startsWith", "toRelativeString", "toRelativeStringOrNull", "toRelativeStringOrNull$FilesKt__UtilsKt", "kotlin-stdlib"}, mo1539f = "kotlin/io/FilesKt", mo1541h = 1)
class bcg extends bcf {
    /* renamed from: a */
    public static /* synthetic */ File m6327a(String str, String str2, File file, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "tmp";
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            file = null;
        }
        return bcb.m6326a(str, str2, file);
    }

    /* renamed from: a */
    public static final File m6326a(String str, String str2, File file) {
        bfq.m6567f(str, "prefix");
        File createTempFile = File.createTempFile(str, str2, file);
        createTempFile.delete();
        if (createTempFile.mkdir()) {
            bfq.m6554b(createTempFile, "dir");
            return createTempFile;
        }
        throw new IOException("Unable to create temporary directory " + createTempFile + '.');
    }

    /* renamed from: b */
    public static /* synthetic */ File m6335b(String str, String str2, File file, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "tmp";
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            file = null;
        }
        return bcb.m6334b(str, str2, file);
    }

    /* renamed from: b */
    public static final File m6334b(String str, String str2, File file) {
        bfq.m6567f(str, "prefix");
        File createTempFile = File.createTempFile(str, str2, file);
        bfq.m6554b(createTempFile, "File.createTempFile(prefix, suffix, directory)");
        return createTempFile;
    }

    /* renamed from: h */
    public static final String m6345h(File file) {
        bfq.m6567f(file, "$this$extension");
        String name = file.getName();
        bfq.m6554b(name, UASTask.COTDETAIL_NAME);
        return boc.m8210d(name, '.', "");
    }

    /* renamed from: i */
    public static final String m6346i(File file) {
        bfq.m6567f(file, "$this$invariantSeparatorsPath");
        if (File.separatorChar != '/') {
            String path = file.getPath();
            bfq.m6554b(path, DownloadTask.PATH);
            return boc.m8006a(path, File.separatorChar, '/', false, 4, (Object) null);
        }
        String path2 = file.getPath();
        bfq.m6554b(path2, DownloadTask.PATH);
        return path2;
    }

    /* renamed from: j */
    public static final String m6348j(File file) {
        bfq.m6567f(file, "$this$nameWithoutExtension");
        String name = file.getName();
        bfq.m6554b(name, UASTask.COTDETAIL_NAME);
        return boc.m8215d(name, ".", (String) null, 2, (Object) null);
    }

    /* renamed from: a */
    public static final String m6328a(File file, File file2) {
        bfq.m6567f(file, "$this$toRelativeString");
        bfq.m6567f(file2, "base");
        String i = m6347i(file, file2);
        if (i != null) {
            return i;
        }
        throw new IllegalArgumentException("this and base files have different roots: " + file + " and " + file2 + '.');
    }

    /* renamed from: b */
    public static final File m6333b(File file, File file2) {
        bfq.m6567f(file, "$this$relativeTo");
        bfq.m6567f(file2, "base");
        return new File(bcb.m6328a(file, file2));
    }

    /* renamed from: c */
    public static final File m6337c(File file, File file2) {
        bfq.m6567f(file, "$this$relativeToOrSelf");
        bfq.m6567f(file2, "base");
        String i = m6347i(file, file2);
        return i != null ? new File(i) : file;
    }

    /* renamed from: d */
    public static final File m6339d(File file, File file2) {
        bfq.m6567f(file, "$this$relativeToOrNull");
        bfq.m6567f(file2, "base");
        String i = m6347i(file, file2);
        if (i != null) {
            return new File(i);
        }
        return null;
    }

    /* renamed from: i */
    private static final String m6347i(File file, File file2) {
        bbw a = m6323a(bcb.m6288d(file));
        bbw a2 = m6323a(bcb.m6288d(file2));
        if (!bfq.m6552a((Object) a.mo2258d(), (Object) a2.mo2258d())) {
            return null;
        }
        int c = a2.mo2257c();
        int c2 = a.mo2257c();
        int i = 0;
        int min = Math.min(c2, c);
        while (i < min && bfq.m6552a((Object) a.mo2259e().get(i), (Object) a2.mo2259e().get(i))) {
            i++;
        }
        StringBuilder sb = new StringBuilder();
        int i2 = c - 1;
        if (i2 >= i) {
            while (!bfq.m6552a((Object) a2.mo2259e().get(i2).getName(), (Object) "..")) {
                sb.append("..");
                if (i2 != i) {
                    sb.append(File.separatorChar);
                }
                if (i2 != i) {
                    i2--;
                }
            }
            return null;
        }
        if (i < c2) {
            if (i < c) {
                sb.append(File.separatorChar);
            }
            String str = File.separator;
            bfq.m6554b(str, "File.separator");
            ato.m4726a(ato.m4794d(a.mo2259e(), i), sb, str, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (bdl) null, 124, (Object) null);
        }
        return sb.toString();
    }

    /* renamed from: a */
    public static /* synthetic */ File m6325a(File file, File file2, boolean z, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            i = 8192;
        }
        return bcb.m6324a(file, file2, z, i);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x007d, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
        atakplugin.UASTool.bbp.m6218a(r2, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0081, code lost:
        throw r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0084, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0085, code lost:
        atakplugin.UASTool.bbp.m6218a(r8, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0088, code lost:
        throw r7;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.io.File m6324a(java.io.File r6, java.io.File r7, boolean r8, int r9) {
        /*
            java.lang.String r0 = "$this$copyTo"
            atakplugin.UASTool.bfq.m6567f(r6, r0)
            java.lang.String r0 = "target"
            atakplugin.UASTool.bfq.m6567f(r7, r0)
            boolean r0 = r6.exists()
            if (r0 == 0) goto L_0x0089
            boolean r0 = r7.exists()
            if (r0 == 0) goto L_0x0033
            if (r8 == 0) goto L_0x0029
            boolean r8 = r7.delete()
            if (r8 == 0) goto L_0x001f
            goto L_0x0033
        L_0x001f:
            atakplugin.UASTool.bbv r8 = new atakplugin.UASTool.bbv
            java.lang.String r9 = "Tried to overwrite the destination, but failed to delete it."
            r8.<init>(r6, r7, r9)
            java.lang.Throwable r8 = (java.lang.Throwable) r8
            throw r8
        L_0x0029:
            atakplugin.UASTool.bbv r8 = new atakplugin.UASTool.bbv
            java.lang.String r9 = "The destination file already exists."
            r8.<init>(r6, r7, r9)
            java.lang.Throwable r8 = (java.lang.Throwable) r8
            throw r8
        L_0x0033:
            boolean r8 = r6.isDirectory()
            if (r8 == 0) goto L_0x004a
            boolean r8 = r7.mkdirs()
            if (r8 == 0) goto L_0x0040
            goto L_0x007a
        L_0x0040:
            atakplugin.UASTool.bbx r8 = new atakplugin.UASTool.bbx
            java.lang.String r9 = "Failed to create target directory."
            r8.<init>(r6, r7, r9)
            java.lang.Throwable r8 = (java.lang.Throwable) r8
            throw r8
        L_0x004a:
            java.io.File r8 = r7.getParentFile()
            if (r8 == 0) goto L_0x0053
            r8.mkdirs()
        L_0x0053:
            java.io.FileInputStream r8 = new java.io.FileInputStream
            r8.<init>(r6)
            java.io.Closeable r8 = (java.io.Closeable) r8
            r6 = 0
            r0 = r6
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            r1 = r8
            java.io.FileInputStream r1 = (java.io.FileInputStream) r1     // Catch:{ all -> 0x0082 }
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ all -> 0x0082 }
            r2.<init>(r7)     // Catch:{ all -> 0x0082 }
            java.io.Closeable r2 = (java.io.Closeable) r2     // Catch:{ all -> 0x0082 }
            java.lang.Throwable r6 = (java.lang.Throwable) r6     // Catch:{ all -> 0x0082 }
            r3 = r2
            java.io.FileOutputStream r3 = (java.io.FileOutputStream) r3     // Catch:{ all -> 0x007b }
            java.io.InputStream r1 = (java.io.InputStream) r1     // Catch:{ all -> 0x007b }
            java.io.OutputStream r3 = (java.io.OutputStream) r3     // Catch:{ all -> 0x007b }
            atakplugin.UASTool.C0138bbn.m6187a((java.io.InputStream) r1, (java.io.OutputStream) r3, (int) r9)     // Catch:{ all -> 0x007b }
            atakplugin.UASTool.bbp.m6218a((java.io.Closeable) r2, (java.lang.Throwable) r6)     // Catch:{ all -> 0x0082 }
            atakplugin.UASTool.bbp.m6218a((java.io.Closeable) r8, (java.lang.Throwable) r0)
        L_0x007a:
            return r7
        L_0x007b:
            r6 = move-exception
            throw r6     // Catch:{ all -> 0x007d }
        L_0x007d:
            r7 = move-exception
            atakplugin.UASTool.bbp.m6218a((java.io.Closeable) r2, (java.lang.Throwable) r6)     // Catch:{ all -> 0x0082 }
            throw r7     // Catch:{ all -> 0x0082 }
        L_0x0082:
            r6 = move-exception
            throw r6     // Catch:{ all -> 0x0084 }
        L_0x0084:
            r7 = move-exception
            atakplugin.UASTool.bbp.m6218a((java.io.Closeable) r8, (java.lang.Throwable) r6)
            throw r7
        L_0x0089:
            atakplugin.UASTool.bcl r7 = new atakplugin.UASTool.bcl
            r2 = 0
            r4 = 2
            r5 = 0
            java.lang.String r3 = "The source file doesn't exist."
            r0 = r7
            r1 = r6
            r0.<init>(r1, r2, r3, r4, r5)
            java.lang.Throwable r7 = (java.lang.Throwable) r7
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.bcg.m6324a(java.io.File, java.io.File, boolean, int):java.io.File");
    }

    /* renamed from: a */
    public static /* synthetic */ boolean m6331a(File file, File file2, boolean z, bdw bdw, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            bdw = bch.f2547a;
        }
        return bcb.m6330a(file, file2, z, (bdw<? super File, ? super IOException, ? extends bcm>) bdw);
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x00a2 A[Catch:{ bco -> 0x00e6 }] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean m6330a(java.io.File r11, java.io.File r12, boolean r13, atakplugin.UASTool.bdw<? super java.io.File, ? super java.io.IOException, ? extends atakplugin.UASTool.bcm> r14) {
        /*
            java.lang.String r0 = "$this$copyRecursively"
            atakplugin.UASTool.bfq.m6567f(r11, r0)
            java.lang.String r0 = "target"
            atakplugin.UASTool.bfq.m6567f(r12, r0)
            java.lang.String r0 = "onError"
            atakplugin.UASTool.bfq.m6567f(r14, r0)
            boolean r0 = r11.exists()
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L_0x0030
            atakplugin.UASTool.bcl r12 = new atakplugin.UASTool.bcl
            r5 = 0
            r7 = 2
            r8 = 0
            java.lang.String r6 = "The source file doesn't exist."
            r3 = r12
            r4 = r11
            r3.<init>(r4, r5, r6, r7, r8)
            java.lang.Object r11 = r14.mo2065a(r11, r12)
            atakplugin.UASTool.bcm r11 = (atakplugin.UASTool.bcm) r11
            atakplugin.UASTool.bcm r12 = atakplugin.UASTool.bcm.TERMINATE
            if (r11 == r12) goto L_0x002e
            goto L_0x002f
        L_0x002e:
            r1 = 0
        L_0x002f:
            return r1
        L_0x0030:
            atakplugin.UASTool.bby r0 = atakplugin.UASTool.bcb.m6321f(r11)     // Catch:{ bco -> 0x00e6 }
            atakplugin.UASTool.bci r3 = new atakplugin.UASTool.bci     // Catch:{ bco -> 0x00e6 }
            r3.<init>(r14)     // Catch:{ bco -> 0x00e6 }
            atakplugin.UASTool.bdw r3 = (atakplugin.UASTool.bdw) r3     // Catch:{ bco -> 0x00e6 }
            atakplugin.UASTool.bby r0 = r0.mo2270a((atakplugin.UASTool.bdw<? super java.io.File, ? super java.io.IOException, atakplugin.UASTool.aqr>) r3)     // Catch:{ bco -> 0x00e6 }
            java.util.Iterator r0 = r0.mo1859a()     // Catch:{ bco -> 0x00e6 }
        L_0x0043:
            boolean r3 = r0.hasNext()     // Catch:{ bco -> 0x00e6 }
            if (r3 == 0) goto L_0x00e5
            java.lang.Object r3 = r0.next()     // Catch:{ bco -> 0x00e6 }
            java.io.File r3 = (java.io.File) r3     // Catch:{ bco -> 0x00e6 }
            boolean r4 = r3.exists()     // Catch:{ bco -> 0x00e6 }
            if (r4 != 0) goto L_0x006c
            atakplugin.UASTool.bcl r10 = new atakplugin.UASTool.bcl     // Catch:{ bco -> 0x00e6 }
            r6 = 0
            java.lang.String r7 = "The source file doesn't exist."
            r8 = 2
            r9 = 0
            r4 = r10
            r5 = r3
            r4.<init>(r5, r6, r7, r8, r9)     // Catch:{ bco -> 0x00e6 }
            java.lang.Object r3 = r14.mo2065a(r3, r10)     // Catch:{ bco -> 0x00e6 }
            atakplugin.UASTool.bcm r3 = (atakplugin.UASTool.bcm) r3     // Catch:{ bco -> 0x00e6 }
            atakplugin.UASTool.bcm r4 = atakplugin.UASTool.bcm.TERMINATE     // Catch:{ bco -> 0x00e6 }
            if (r3 != r4) goto L_0x0043
            return r2
        L_0x006c:
            java.lang.String r4 = atakplugin.UASTool.bcb.m6328a((java.io.File) r3, (java.io.File) r11)     // Catch:{ bco -> 0x00e6 }
            java.io.File r5 = new java.io.File     // Catch:{ bco -> 0x00e6 }
            r5.<init>(r12, r4)     // Catch:{ bco -> 0x00e6 }
            boolean r4 = r5.exists()     // Catch:{ bco -> 0x00e6 }
            if (r4 == 0) goto L_0x00b4
            boolean r4 = r3.isDirectory()     // Catch:{ bco -> 0x00e6 }
            if (r4 == 0) goto L_0x0087
            boolean r4 = r5.isDirectory()     // Catch:{ bco -> 0x00e6 }
            if (r4 != 0) goto L_0x00b4
        L_0x0087:
            if (r13 != 0) goto L_0x008b
        L_0x0089:
            r4 = 1
            goto L_0x00a0
        L_0x008b:
            boolean r4 = r5.isDirectory()     // Catch:{ bco -> 0x00e6 }
            if (r4 == 0) goto L_0x0098
            boolean r4 = atakplugin.UASTool.bcb.m6349k(r5)     // Catch:{ bco -> 0x00e6 }
            if (r4 != 0) goto L_0x009f
            goto L_0x0089
        L_0x0098:
            boolean r4 = r5.delete()     // Catch:{ bco -> 0x00e6 }
            if (r4 != 0) goto L_0x009f
            goto L_0x0089
        L_0x009f:
            r4 = 0
        L_0x00a0:
            if (r4 == 0) goto L_0x00b4
            atakplugin.UASTool.bbv r4 = new atakplugin.UASTool.bbv     // Catch:{ bco -> 0x00e6 }
            java.lang.String r6 = "The destination file already exists."
            r4.<init>(r3, r5, r6)     // Catch:{ bco -> 0x00e6 }
            java.lang.Object r3 = r14.mo2065a(r5, r4)     // Catch:{ bco -> 0x00e6 }
            atakplugin.UASTool.bcm r3 = (atakplugin.UASTool.bcm) r3     // Catch:{ bco -> 0x00e6 }
            atakplugin.UASTool.bcm r4 = atakplugin.UASTool.bcm.TERMINATE     // Catch:{ bco -> 0x00e6 }
            if (r3 != r4) goto L_0x0043
            return r2
        L_0x00b4:
            boolean r4 = r3.isDirectory()     // Catch:{ bco -> 0x00e6 }
            if (r4 == 0) goto L_0x00be
            r5.mkdirs()     // Catch:{ bco -> 0x00e6 }
            goto L_0x0043
        L_0x00be:
            r7 = 0
            r8 = 4
            r9 = 0
            r4 = r3
            r6 = r13
            java.io.File r4 = atakplugin.UASTool.bcb.m6325a((java.io.File) r4, (java.io.File) r5, (boolean) r6, (int) r7, (int) r8, (java.lang.Object) r9)     // Catch:{ bco -> 0x00e6 }
            long r4 = r4.length()     // Catch:{ bco -> 0x00e6 }
            long r6 = r3.length()     // Catch:{ bco -> 0x00e6 }
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x0043
            java.io.IOException r4 = new java.io.IOException     // Catch:{ bco -> 0x00e6 }
            java.lang.String r5 = "Source file wasn't copied completely, length of destination file differs."
            r4.<init>(r5)     // Catch:{ bco -> 0x00e6 }
            java.lang.Object r3 = r14.mo2065a(r3, r4)     // Catch:{ bco -> 0x00e6 }
            atakplugin.UASTool.bcm r3 = (atakplugin.UASTool.bcm) r3     // Catch:{ bco -> 0x00e6 }
            atakplugin.UASTool.bcm r4 = atakplugin.UASTool.bcm.TERMINATE     // Catch:{ bco -> 0x00e6 }
            if (r3 != r4) goto L_0x0043
            return r2
        L_0x00e5:
            return r1
        L_0x00e6:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.bcg.m6330a(java.io.File, java.io.File, boolean, atakplugin.UASTool.bdw):boolean");
    }

    /* renamed from: k */
    public static final boolean m6349k(File file) {
        bfq.m6567f(file, "$this$deleteRecursively");
        Iterator a = bcb.m6322g(file).mo1859a();
        while (true) {
            boolean z = true;
            while (true) {
                if (!a.hasNext()) {
                    return z;
                }
                File file2 = (File) a.next();
                if (file2.delete() || !file2.exists()) {
                    if (z) {
                    }
                }
                z = false;
            }
        }
    }

    /* renamed from: e */
    public static final boolean m6341e(File file, File file2) {
        bfq.m6567f(file, "$this$startsWith");
        bfq.m6567f(file2, "other");
        bbw d = bcb.m6288d(file);
        bbw d2 = bcb.m6288d(file2);
        if (!(!bfq.m6552a((Object) d.mo2258d(), (Object) d2.mo2258d())) && d.mo2257c() >= d2.mo2257c()) {
            return d.mo2259e().subList(0, d2.mo2257c()).equals(d2.mo2259e());
        }
        return false;
    }

    /* renamed from: a */
    public static final boolean m6332a(File file, String str) {
        bfq.m6567f(file, "$this$startsWith");
        bfq.m6567f(str, "other");
        return bcb.m6341e(file, new File(str));
    }

    /* renamed from: f */
    public static final boolean m6342f(File file, File file2) {
        bfq.m6567f(file, "$this$endsWith");
        bfq.m6567f(file2, "other");
        bbw d = bcb.m6288d(file);
        bbw d2 = bcb.m6288d(file2);
        if (d2.mo2256b()) {
            return bfq.m6552a((Object) file, (Object) file2);
        }
        int c = d.mo2257c() - d2.mo2257c();
        if (c < 0) {
            return false;
        }
        return d.mo2259e().subList(c, d.mo2257c()).equals(d2.mo2259e());
    }

    /* renamed from: b */
    public static final boolean m6336b(File file, String str) {
        bfq.m6567f(file, "$this$endsWith");
        bfq.m6567f(str, "other");
        return bcb.m6342f(file, new File(str));
    }

    /* renamed from: l */
    public static final File m6350l(File file) {
        bfq.m6567f(file, "$this$normalize");
        bbw d = bcb.m6288d(file);
        File d2 = d.mo2258d();
        String str = File.separator;
        bfq.m6554b(str, "File.separator");
        return bcb.m6338c(d2, ato.m4738a(m6329a((List<? extends File>) d.mo2259e()), str, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (bdl) null, 62, (Object) null));
    }

    /* renamed from: a */
    private static final bbw m6323a(bbw bbw) {
        return new bbw(bbw.mo2258d(), m6329a((List<? extends File>) bbw.mo2259e()));
    }

    /* renamed from: a */
    private static final List<File> m6329a(List<? extends File> list) {
        List<File> arrayList = new ArrayList<>(list.size());
        for (File file : list) {
            String name = file.getName();
            if (name != null) {
                int hashCode = name.hashCode();
                if (hashCode != 46) {
                    if (hashCode == 1472 && name.equals("..")) {
                        if (arrayList.isEmpty() || !(!bfq.m6552a((Object) ((File) ato.m4836i(arrayList)).getName(), (Object) ".."))) {
                            arrayList.add(file);
                        } else {
                            arrayList.remove(arrayList.size() - 1);
                        }
                    }
                } else if (name.equals(".")) {
                }
            }
            arrayList.add(file);
        }
        return arrayList;
    }

    /* renamed from: g */
    public static final File m6343g(File file, File file2) {
        bfq.m6567f(file, "$this$resolve");
        bfq.m6567f(file2, "relative");
        if (bcb.m6287c(file2)) {
            return file2;
        }
        String file3 = file.toString();
        bfq.m6554b(file3, "this.toString()");
        CharSequence charSequence = file3;
        if ((charSequence.length() == 0) || boc.m8176b(charSequence, File.separatorChar, false, 2, (Object) null)) {
            return new File(file3 + file2);
        }
        return new File(file3 + File.separatorChar + file2);
    }

    /* renamed from: c */
    public static final File m6338c(File file, String str) {
        bfq.m6567f(file, "$this$resolve");
        bfq.m6567f(str, "relative");
        return bcb.m6343g(file, new File(str));
    }

    /* renamed from: h */
    public static final File m6344h(File file, File file2) {
        bfq.m6567f(file, "$this$resolveSibling");
        bfq.m6567f(file2, "relative");
        bbw d = bcb.m6288d(file);
        return bcb.m6343g(bcb.m6343g(d.mo2258d(), d.mo2257c() == 0 ? new File("..") : d.mo2254a(0, d.mo2257c() - 1)), file2);
    }

    /* renamed from: d */
    public static final File m6340d(File file, String str) {
        bfq.m6567f(file, "$this$resolveSibling");
        bfq.m6567f(str, "relative");
        return bcb.m6344h(file, new File(str));
    }
}
