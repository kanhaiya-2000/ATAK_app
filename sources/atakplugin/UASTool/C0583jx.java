package atakplugin.UASTool;

import atakplugin.UASTool.C0552jb;
import atakplugin.UASTool.C0560jd;
import java.util.Arrays;

/* renamed from: atakplugin.UASTool.jx */
public class C0583jx extends C0552jb.C0553a {

    /* renamed from: d */
    private final C0560jd.C0561a f5105d;

    /* renamed from: e */
    private int f5106e = 0;

    /* renamed from: f */
    private double[] f5107f;

    public C0583jx(C0560jd.C0561a aVar) {
        this.f5105d = aVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo5002b() {
        if (!this.f5040c) {
            double[] a = C0537ir.m12283a(this.f5105d);
            this.f5107f = a;
            Arrays.sort(a);
        }
        this.f5039b = this.f5106e < this.f5107f.length;
        if (this.f5039b) {
            double[] dArr = this.f5107f;
            int i = this.f5106e;
            this.f5106e = i + 1;
            this.f5038a = dArr[i];
        }
    }
}
