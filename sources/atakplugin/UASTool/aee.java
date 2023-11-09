package atakplugin.UASTool;

import java.nio.ByteBuffer;

public class aee extends adx {

    /* renamed from: a */
    public static final String f639a = "rap ";

    /* renamed from: b */
    private boolean f640b;

    /* renamed from: c */
    private short f641c;

    /* renamed from: a */
    public String mo377a() {
        return f639a;
    }

    /* renamed from: c */
    public boolean mo443c() {
        return this.f640b;
    }

    /* renamed from: a */
    public void mo442a(boolean z) {
        this.f640b = z;
    }

    /* renamed from: d */
    public short mo444d() {
        return this.f641c;
    }

    /* renamed from: a */
    public void mo441a(short s) {
        this.f641c = s;
    }

    /* renamed from: a */
    public void mo379a(ByteBuffer byteBuffer) {
        byte b = byteBuffer.get();
        this.f640b = (b & 128) == 128;
        this.f641c = (short) (b & Byte.MAX_VALUE);
    }

    /* renamed from: b */
    public ByteBuffer mo382b() {
        ByteBuffer allocate = ByteBuffer.allocate(1);
        allocate.put((byte) ((this.f640b ? (short) 128 : 0) | (this.f641c & 127)));
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
        aee aee = (aee) obj;
        return this.f641c == aee.f641c && this.f640b == aee.f640b;
    }

    public int hashCode() {
        return ((this.f640b ? 1 : 0) * true) + this.f641c;
    }

    public String toString() {
        return "VisualRandomAccessEntry" + "{numLeadingSamplesKnown=" + this.f640b + ", numLeadingSamples=" + this.f641c + '}';
    }
}
