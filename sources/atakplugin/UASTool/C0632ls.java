package atakplugin.UASTool;

import atakplugin.UASTool.C0552jb;
import atakplugin.UASTool.C0560jd;
import java.util.Arrays;

/* renamed from: atakplugin.UASTool.ls */
public class C0632ls extends C0552jb.C0555c {

    /* renamed from: d */
    private final C0560jd.C0563c f5228d;

    /* renamed from: e */
    private int f5229e = 0;

    /* renamed from: f */
    private long[] f5230f;

    public C0632ls(C0560jd.C0563c cVar) {
        this.f5228d = cVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo5006b() {
        if (!this.f5046c) {
            long[] a = C0537ir.m12285a(this.f5228d);
            this.f5230f = a;
            Arrays.sort(a);
        }
        this.f5045b = this.f5229e < this.f5230f.length;
        if (this.f5045b) {
            long[] jArr = this.f5230f;
            int i = this.f5229e;
            this.f5229e = i + 1;
            this.f5044a = jArr[i];
        }
    }
}
