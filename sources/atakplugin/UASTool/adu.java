package atakplugin.UASTool;

import java.nio.ByteBuffer;

@adm(mo342a = {6})
public class adu extends adh {

    /* renamed from: a */
    int f592a;

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo292a() {
        return 1;
    }

    public adu() {
        this.f537Z = 6;
    }

    /* renamed from: c */
    public int mo374c() {
        return this.f592a;
    }

    /* renamed from: a */
    public void mo373a(int i) {
        this.f592a = i;
    }

    /* renamed from: a */
    public void mo294a(ByteBuffer byteBuffer) {
        this.f592a = C0679nk.m12499f(byteBuffer);
    }

    /* renamed from: b */
    public ByteBuffer mo295b() {
        ByteBuffer allocate = ByteBuffer.allocate(mo314k());
        C0681nm.m12521d(allocate, 6);
        mo311a(allocate, mo292a());
        C0681nm.m12521d(allocate, this.f592a);
        return allocate;
    }

    public String toString() {
        return "SLConfigDescriptor" + "{predefined=" + this.f592a + '}';
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.f592a == ((adu) obj).f592a;
    }

    public int hashCode() {
        return this.f592a;
    }
}
