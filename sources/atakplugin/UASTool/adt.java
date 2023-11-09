package atakplugin.UASTool;

import java.nio.ByteBuffer;

@adm(mo342a = {20})
public class adt extends adh {

    /* renamed from: a */
    int f591a;

    /* renamed from: a */
    public int mo292a() {
        return 1;
    }

    public adt() {
        this.f537Z = 20;
    }

    /* renamed from: a */
    public void mo294a(ByteBuffer byteBuffer) {
        this.f591a = C0679nk.m12499f(byteBuffer);
    }

    /* renamed from: b */
    public ByteBuffer mo295b() {
        ByteBuffer allocate = ByteBuffer.allocate(mo314k());
        C0681nm.m12521d(allocate, 20);
        mo311a(allocate, mo292a());
        C0681nm.m12521d(allocate, this.f591a);
        return allocate;
    }

    public String toString() {
        return "ProfileLevelIndicationDescriptor" + "{profileLevelIndicationIndex=" + Integer.toHexString(this.f591a) + '}';
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.f591a == ((adt) obj).f591a;
    }

    public int hashCode() {
        return this.f591a;
    }
}
