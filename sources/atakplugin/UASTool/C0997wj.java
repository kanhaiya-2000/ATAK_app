package atakplugin.UASTool;

import atakplugin.UASTool.C0990we;
import java.util.Arrays;

/* renamed from: atakplugin.UASTool.wj */
public class C0997wj extends C0961vj {

    /* renamed from: a */
    private final C0990we.C0991a f7488a;

    /* renamed from: b */
    private final C0990we.C0991a.C0992a[] f7489b;

    C0997wj(C1001wm wmVar) {
        this.f7488a = (C0990we.C0991a) wmVar.mo6115a();
        this.f7489b = (C0990we.C0991a.C0992a[]) wmVar.mo6117c();
    }

    C0997wj(C0990we.C0991a aVar, C0990we.C0991a.C0992a... aVarArr) {
        this.f7488a = aVar;
        this.f7489b = aVarArr;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C0990we.C0991a mo6099a() {
        return this.f7488a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public C0990we.C0991a.C0992a[] mo6100b() {
        return this.f7489b;
    }

    public String toString() {
        String format = String.format("Unexpected token '%s'", new Object[]{this.f7488a});
        if (this.f7489b.length <= 0) {
            return format;
        }
        return format + String.format(", expecting '%s'", new Object[]{Arrays.toString(this.f7489b)});
    }
}
