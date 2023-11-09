package atakplugin.UASTool;

import atakplugin.UASTool.C1088zi;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* renamed from: atakplugin.UASTool.zj */
class C1091zj {

    /* renamed from: a */
    int f7946a;

    /* renamed from: b */
    int f7947b;

    /* renamed from: c */
    boolean f7948c;

    /* renamed from: d */
    boolean f7949d;

    /* renamed from: e */
    int f7950e;

    /* renamed from: f */
    int f7951f;

    /* renamed from: g */
    int f7952g;

    /* renamed from: h */
    int f7953h;

    /* renamed from: i */
    int f7954i;

    /* renamed from: j */
    int f7955j;

    /* renamed from: k */
    boolean f7956k;

    /* renamed from: l */
    int f7957l;

    /* renamed from: m */
    final /* synthetic */ C1088zi f7958m;

    public C1091zj(C1088zi ziVar, ByteBuffer byteBuffer, int i, int i2) {
        this.f7958m = ziVar;
        C1092zk zkVar = new C1092zk(C1088zi.m14713a((InputStream) new C1088zi.C1089a(byteBuffer)), ziVar.f7909l, ziVar.f7911n, i2 == 5);
        this.f7946a = zkVar.f7963e;
        this.f7947b = zkVar.f7961c;
        this.f7948c = zkVar.f7964f;
        this.f7949d = zkVar.f7965g;
        this.f7950e = i;
        this.f7951f = ziVar.f7909l.get(Integer.valueOf(ziVar.f7911n.get(Integer.valueOf(zkVar.f7961c)).f742f)).f783a;
        this.f7952g = zkVar.f7968j;
        this.f7953h = zkVar.f7967i;
        this.f7954i = zkVar.f7969k;
        this.f7955j = zkVar.f7970l;
        this.f7957l = zkVar.f7966h;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo6324a(C1091zj zjVar) {
        boolean z;
        boolean z2;
        boolean z3;
        if (zjVar.f7946a != this.f7946a || zjVar.f7947b != this.f7947b || (z = zjVar.f7948c) != this.f7948c) {
            return true;
        }
        if ((z && zjVar.f7949d != this.f7949d) || zjVar.f7950e != this.f7950e) {
            return true;
        }
        int i = zjVar.f7951f;
        if (i == 0 && this.f7951f == 0 && (zjVar.f7953h != this.f7953h || zjVar.f7952g != this.f7952g)) {
            return true;
        }
        if ((i == 1 && this.f7951f == 1 && (zjVar.f7954i != this.f7954i || zjVar.f7955j != this.f7955j)) || (z2 = zjVar.f7956k) != (z3 = this.f7956k)) {
            return true;
        }
        if (!z2 || !z3 || zjVar.f7957l == this.f7957l) {
            return false;
        }
        return true;
    }
}
