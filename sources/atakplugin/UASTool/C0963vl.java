package atakplugin.UASTool;

import atakplugin.UASTool.C0968vn;
import java.util.Arrays;

/* renamed from: atakplugin.UASTool.vl */
public class C0963vl extends C0961vj {

    /* renamed from: a */
    private final Character f7427a;

    /* renamed from: b */
    private final int f7428b;

    /* renamed from: c */
    private final C0968vn.C0970a[] f7429c;

    C0963vl(C1001wm wmVar) {
        this.f7428b = wmVar.mo6116b();
        this.f7427a = (Character) wmVar.mo6115a();
        this.f7429c = (C0968vn.C0970a[]) wmVar.mo6117c();
    }

    C0963vl(Character ch, int i, C0968vn.C0970a... aVarArr) {
        this.f7427a = ch;
        this.f7428b = i;
        this.f7429c = aVarArr;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Character mo6042a() {
        return this.f7427a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo6043b() {
        return this.f7428b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public C0968vn.C0970a[] mo6044c() {
        return this.f7429c;
    }

    public String toString() {
        String format = String.format("Unexpected character '%s(%s)' at position '%d'", new Object[]{C0968vn.C0970a.m14299a(this.f7427a), this.f7427a, Integer.valueOf(this.f7428b)});
        if (this.f7429c.length <= 0) {
            return format;
        }
        return format + String.format(", expecting '%s'", new Object[]{Arrays.toString(this.f7429c)});
    }
}
