package atakplugin.UASTool;

import java.nio.ByteBuffer;

public class alf extends adx {

    /* renamed from: a */
    public static final String f1889a = "sync";

    /* renamed from: b */
    int f1890b;

    /* renamed from: c */
    int f1891c;

    /* renamed from: a */
    public String mo377a() {
        return f1889a;
    }

    /* renamed from: a */
    public void mo379a(ByteBuffer byteBuffer) {
        int f = C0679nk.m12499f(byteBuffer);
        this.f1890b = (f & 192) >> 6;
        this.f1891c = f & 63;
    }

    /* renamed from: b */
    public ByteBuffer mo382b() {
        ByteBuffer allocate = ByteBuffer.allocate(1);
        C0681nm.m12521d(allocate, this.f1891c + (this.f1890b << 6));
        return (ByteBuffer) allocate.rewind();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        alf alf = (alf) obj;
        return this.f1891c == alf.f1891c && this.f1890b == alf.f1890b;
    }

    public int hashCode() {
        return (this.f1890b * 31) + this.f1891c;
    }

    /* renamed from: c */
    public int mo1327c() {
        return this.f1890b;
    }

    /* renamed from: a */
    public void mo1325a(int i) {
        this.f1890b = i;
    }

    /* renamed from: d */
    public int mo1328d() {
        return this.f1891c;
    }

    /* renamed from: b */
    public void mo1326b(int i) {
        this.f1891c = i;
    }

    public String toString() {
        return "SyncSampleEntry{reserved=" + this.f1890b + ", nalUnitType=" + this.f1891c + '}';
    }
}
