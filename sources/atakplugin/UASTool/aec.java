package atakplugin.UASTool;

import java.nio.ByteBuffer;

public class aec extends adx {

    /* renamed from: a */
    public static final String f634a = "tele";

    /* renamed from: b */
    private boolean f635b;

    /* renamed from: c */
    private short f636c;

    /* renamed from: a */
    public String mo377a() {
        return f634a;
    }

    /* renamed from: c */
    public boolean mo432c() {
        return this.f635b;
    }

    /* renamed from: a */
    public void mo431a(boolean z) {
        this.f635b = z;
    }

    /* renamed from: a */
    public void mo379a(ByteBuffer byteBuffer) {
        this.f635b = (byteBuffer.get() & 128) == 128;
    }

    /* renamed from: b */
    public ByteBuffer mo382b() {
        ByteBuffer allocate = ByteBuffer.allocate(1);
        allocate.put((byte) (this.f635b ? 128 : 0));
        allocate.rewind();
        return allocate;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        aec aec = (aec) obj;
        return this.f635b == aec.f635b && this.f636c == aec.f636c;
    }

    public int hashCode() {
        return ((this.f635b ? 1 : 0) * true) + this.f636c;
    }

    public String toString() {
        return "TemporalLevelEntry" + "{levelIndependentlyDecodable=" + this.f635b + '}';
    }
}
