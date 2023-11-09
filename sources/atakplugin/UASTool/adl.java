package atakplugin.UASTool;

import java.nio.ByteBuffer;
import java.util.Arrays;

@adm(mo342a = {5})
public class adl extends adh {

    /* renamed from: a */
    byte[] f558a;

    public adl() {
        this.f537Z = 5;
    }

    /* renamed from: a */
    public void mo294a(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[byteBuffer.remaining()];
        this.f558a = bArr;
        byteBuffer.get(bArr);
    }

    /* renamed from: a */
    public void mo339a(byte[] bArr) {
        this.f558a = bArr;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo292a() {
        return this.f558a.length;
    }

    /* renamed from: b */
    public ByteBuffer mo295b() {
        ByteBuffer allocate = ByteBuffer.allocate(mo314k());
        C0681nm.m12521d(allocate, this.f537Z);
        mo311a(allocate, mo292a());
        allocate.put(this.f558a);
        return (ByteBuffer) allocate.rewind();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DecoderSpecificInfo");
        sb.append("{bytes=");
        byte[] bArr = this.f558a;
        sb.append(bArr == null ? "null" : C0677ni.m12484a(bArr));
        sb.append('}');
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && Arrays.equals(this.f558a, ((adl) obj).f558a);
    }

    public int hashCode() {
        byte[] bArr = this.f558a;
        if (bArr != null) {
            return Arrays.hashCode(bArr);
        }
        return 0;
    }
}
