package atakplugin.UASTool;

import java.nio.ByteBuffer;

public class adz extends adx {

    /* renamed from: a */
    public static final String f608a = "roll";

    /* renamed from: b */
    private short f609b;

    /* renamed from: a */
    public String mo377a() {
        return f608a;
    }

    /* renamed from: c */
    public short mo412c() {
        return this.f609b;
    }

    /* renamed from: a */
    public void mo411a(short s) {
        this.f609b = s;
    }

    /* renamed from: a */
    public void mo379a(ByteBuffer byteBuffer) {
        this.f609b = byteBuffer.getShort();
    }

    /* renamed from: b */
    public ByteBuffer mo382b() {
        ByteBuffer allocate = ByteBuffer.allocate(2);
        allocate.putShort(this.f609b);
        allocate.rewind();
        return allocate;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.f609b == ((adz) obj).f609b;
    }

    public int hashCode() {
        return this.f609b;
    }
}
