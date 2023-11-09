package atakplugin.UASTool;

import java.nio.ByteBuffer;

public abstract class ame implements C0688nt {

    /* renamed from: a */
    private final String f2079a;

    /* renamed from: b */
    private C0695nz f2080b;

    /* renamed from: e */
    public C0695nz mo1474e() {
        return this.f2080b;
    }

    /* renamed from: a */
    public void mo1473a(C0695nz nzVar) {
        this.f2080b = nzVar;
    }

    /* renamed from: g */
    public long mo1475g() {
        throw new RuntimeException("It's a´write only box");
    }

    /* renamed from: a */
    public void mo105a(C1007ws wsVar, ByteBuffer byteBuffer, long j, C0675ng ngVar) {
        throw new RuntimeException("It's a´write only box");
    }

    public ame(String str) {
        this.f2079a = str;
    }

    /* renamed from: h */
    public String mo1476h() {
        return this.f2079a;
    }
}
