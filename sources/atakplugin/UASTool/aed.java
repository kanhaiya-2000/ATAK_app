package atakplugin.UASTool;

import java.nio.ByteBuffer;

public class aed extends adx {

    /* renamed from: a */
    private ByteBuffer f637a;

    /* renamed from: b */
    private String f638b;

    public aed(String str) {
        this.f638b = str;
    }

    /* renamed from: a */
    public String mo377a() {
        return this.f638b;
    }

    /* renamed from: c */
    public ByteBuffer mo437c() {
        return this.f637a;
    }

    /* renamed from: b */
    public void mo436b(ByteBuffer byteBuffer) {
        this.f637a = (ByteBuffer) byteBuffer.duplicate().rewind();
    }

    /* renamed from: a */
    public void mo379a(ByteBuffer byteBuffer) {
        this.f637a = (ByteBuffer) byteBuffer.duplicate().rewind();
    }

    /* renamed from: b */
    public ByteBuffer mo382b() {
        return this.f637a.duplicate();
    }

    public String toString() {
        ByteBuffer duplicate = this.f637a.duplicate();
        duplicate.rewind();
        byte[] bArr = new byte[duplicate.limit()];
        duplicate.get(bArr);
        return "UnknownEntry{content=" + C0677ni.m12484a(bArr) + '}';
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ByteBuffer byteBuffer = this.f637a;
        ByteBuffer byteBuffer2 = ((aed) obj).f637a;
        return byteBuffer == null ? byteBuffer2 == null : byteBuffer.equals(byteBuffer2);
    }

    public int hashCode() {
        ByteBuffer byteBuffer = this.f637a;
        if (byteBuffer != null) {
            return byteBuffer.hashCode();
        }
        return 0;
    }
}
