package atakplugin.UASTool;

import java.io.File;
import java.util.List;
import org.droidplanner.services.android.impl.core.drone.autopilot.apm.solo.SoloComp;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\r\b\b\u0018\u00002\u00020\u0001B\u001d\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J#\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0013HÖ\u0001J\u0016\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u0013J\t\u0010\u001f\u001a\u00020\rHÖ\u0001R\u0011\u0010\u0007\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006 "}, mo1538e = {"Lkotlin/io/FilePathComponents;", "", "root", "Ljava/io/File;", "segments", "", "(Ljava/io/File;Ljava/util/List;)V", "isRooted", "", "()Z", "getRoot", "()Ljava/io/File;", "rootName", "", "getRootName", "()Ljava/lang/String;", "getSegments", "()Ljava/util/List;", "size", "", "getSize", "()I", "component1", "component2", "copy", "equals", "other", "hashCode", "subPath", "beginIndex", "endIndex", "toString", "kotlin-stdlib"})
public final class bbw {

    /* renamed from: a */
    private final File f2516a;

    /* renamed from: b */
    private final List<File> f2517b;

    /* renamed from: a */
    public static /* synthetic */ bbw m6251a(bbw bbw, File file, List<File> list, int i, Object obj) {
        if ((i & 1) != 0) {
            file = bbw.f2516a;
        }
        if ((i & 2) != 0) {
            list = bbw.f2517b;
        }
        return bbw.mo2253a(file, (List<? extends File>) list);
    }

    /* renamed from: a */
    public final bbw mo2253a(File file, List<? extends File> list) {
        bfq.m6567f(file, SoloComp.SSH_USERNAME);
        bfq.m6567f(list, "segments");
        return new bbw(file, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof bbw)) {
            return false;
        }
        bbw bbw = (bbw) obj;
        return bfq.m6552a((Object) this.f2516a, (Object) bbw.f2516a) && bfq.m6552a((Object) this.f2517b, (Object) bbw.f2517b);
    }

    /* renamed from: f */
    public final File mo2261f() {
        return this.f2516a;
    }

    /* renamed from: g */
    public final List<File> mo2262g() {
        return this.f2517b;
    }

    public int hashCode() {
        File file = this.f2516a;
        int i = 0;
        int hashCode = (file != null ? file.hashCode() : 0) * 31;
        List<File> list = this.f2517b;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "FilePathComponents(root=" + this.f2516a + ", segments=" + this.f2517b + ")";
    }

    public bbw(File file, List<? extends File> list) {
        bfq.m6567f(file, SoloComp.SSH_USERNAME);
        bfq.m6567f(list, "segments");
        this.f2516a = file;
        this.f2517b = list;
    }

    /* renamed from: d */
    public final File mo2258d() {
        return this.f2516a;
    }

    /* renamed from: e */
    public final List<File> mo2259e() {
        return this.f2517b;
    }

    /* renamed from: a */
    public final String mo2255a() {
        String path = this.f2516a.getPath();
        bfq.m6554b(path, "root.path");
        return path;
    }

    /* renamed from: b */
    public final boolean mo2256b() {
        String path = this.f2516a.getPath();
        bfq.m6554b(path, "root.path");
        return path.length() > 0;
    }

    /* renamed from: c */
    public final int mo2257c() {
        return this.f2517b.size();
    }

    /* renamed from: a */
    public final File mo2254a(int i, int i2) {
        if (i < 0 || i > i2 || i2 > mo2257c()) {
            throw new IllegalArgumentException();
        }
        String str = File.separator;
        bfq.m6554b(str, "File.separator");
        return new File(ato.m4738a(this.f2517b.subList(i, i2), str, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (bdl) null, 62, (Object) null));
    }
}
