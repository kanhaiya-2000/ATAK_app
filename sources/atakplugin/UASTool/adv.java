package atakplugin.UASTool;

import java.nio.ByteBuffer;
import java.util.logging.Logger;

public class adv extends adh {

    /* renamed from: a */
    private static Logger f593a = Logger.getLogger(adv.class.getName());

    /* renamed from: b */
    private ByteBuffer f594b;

    /* renamed from: a */
    public void mo294a(ByteBuffer byteBuffer) {
        this.f594b = byteBuffer.slice();
    }

    public String toString() {
        return "UnknownDescriptor" + "{tag=" + this.f537Z + ", sizeOfInstance=" + this.f538aa + ", data=" + this.f594b + '}';
    }

    /* renamed from: b */
    public ByteBuffer mo295b() {
        throw new RuntimeException("sdjlhfl");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo292a() {
        throw new RuntimeException("sdjlhfl");
    }
}
