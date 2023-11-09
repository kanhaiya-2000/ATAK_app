package atakplugin.UASTool;

import java.nio.ByteBuffer;
import java.util.logging.Logger;

@adm(mo342a = {19, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 123, 124, 125, 126, 127, 128, 129, 130, 131, 132, 133, 134, 135, 136, 137, 138, 139, 140, 141, 142, 143, 144, 145, 146, 147, 148, 149, 150, 151, 152, 153, 154, 155, 156, 157, 158, 159, 160, 161, 162, 163, 164, 165, 166, 167, 168, 169, 170, 171, 172, 173, 174, 175, 176, 177, 178, 179, 180, 181, 182, 183, 184, 185, 186, 187, 188, 189, 190, 191, 192, 193, 194, 195, 196, 197, 198, 199, 200, 201, 202, 203, 204, 205, 206, 207, 208, 209, 210, 211, 212, 213, 214, 215, 216, 217, 218, 219, 220, 221, 222, 223, 224, 225, 226, 227, 228, 229, 230, 231, 232, 233, 234, 235, 236, 237, 238, 239, 240, 241, 242, 243, 244, 245, 246, 247, 248, 249, 250, 251, 252, 253})
public class ado extends adh {

    /* renamed from: b */
    private static Logger f573b = Logger.getLogger(ado.class.getName());

    /* renamed from: a */
    ByteBuffer f574a;

    /* renamed from: c */
    static int[] m566c() {
        int[] iArr = new int[148];
        for (int i = 106; i < 254; i++) {
            int i2 = i - 106;
            f573b.finest("pos:" + i2);
            iArr[i2] = i;
        }
        return iArr;
    }

    /* renamed from: a */
    public void mo294a(ByteBuffer byteBuffer) {
        this.f574a = byteBuffer.slice();
        byteBuffer.position(byteBuffer.position() + this.f574a.remaining());
    }

    public String toString() {
        return "ExtensionDescriptor" + "tag=" + this.f537Z + ",bytes=" + C0677ni.m12484a(this.f574a.array()) + '}';
    }

    /* renamed from: b */
    public ByteBuffer mo295b() {
        ByteBuffer allocate = ByteBuffer.allocate(mo314k());
        C0681nm.m12521d(allocate, this.f537Z);
        mo311a(allocate, mo292a());
        allocate.put(this.f574a.duplicate());
        return allocate;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo292a() {
        return this.f574a.remaining();
    }
}
