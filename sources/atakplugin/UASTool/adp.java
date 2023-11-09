package atakplugin.UASTool;

import java.nio.ByteBuffer;

@adm(mo342a = {19})
public class adp extends adh {

    /* renamed from: a */
    byte[] f575a;

    public adp() {
        this.f537Z = 19;
    }

    /* renamed from: a */
    public void mo294a(ByteBuffer byteBuffer) {
        if (mo314k() > 0) {
            byte[] bArr = new byte[mo314k()];
            this.f575a = bArr;
            byteBuffer.get(bArr);
        }
    }

    /* renamed from: b */
    public ByteBuffer mo295b() {
        throw new RuntimeException("Not Implemented");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo292a() {
        throw new RuntimeException("Not Implemented");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ExtensionDescriptor");
        sb.append("{bytes=");
        byte[] bArr = this.f575a;
        sb.append(bArr == null ? "null" : C0677ni.m12484a(bArr));
        sb.append('}');
        return sb.toString();
    }
}
