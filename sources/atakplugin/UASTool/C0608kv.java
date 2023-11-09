package atakplugin.UASTool;

import atakplugin.UASTool.C0552jb;
import atakplugin.UASTool.C0560jd;
import java.util.Arrays;

/* renamed from: atakplugin.UASTool.kv */
public class C0608kv extends C0552jb.C0554b {

    /* renamed from: d */
    private final C0560jd.C0562b f5169d;

    /* renamed from: e */
    private int f5170e = 0;

    /* renamed from: f */
    private int[] f5171f;

    public C0608kv(C0560jd.C0562b bVar) {
        this.f5169d = bVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo5004b() {
        if (!this.f5043c) {
            int[] a = C0537ir.m12284a(this.f5169d);
            this.f5171f = a;
            Arrays.sort(a);
        }
        this.f5042b = this.f5170e < this.f5171f.length;
        if (this.f5042b) {
            int[] iArr = this.f5171f;
            int i = this.f5170e;
            this.f5170e = i + 1;
            this.f5041a = iArr[i];
        }
    }
}
