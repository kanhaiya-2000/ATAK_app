package atakplugin.UASTool;

import java.nio.ByteBuffer;

public class adi {

    /* renamed from: a */
    int f540a;

    /* renamed from: b */
    int f541b;

    /* renamed from: c */
    private ByteBuffer f542c;

    public adi(ByteBuffer byteBuffer) {
        this.f542c = byteBuffer;
        this.f540a = byteBuffer.position();
    }

    /* renamed from: a */
    public boolean mo316a() {
        return mo315a(1) == 1;
    }

    /* renamed from: a */
    public int mo315a(int i) {
        int i2;
        int i3 = this.f542c.get(this.f540a + (this.f541b / 8));
        if (i3 < 0) {
            i3 += 256;
        }
        int i4 = this.f541b;
        int i5 = 8 - (i4 % 8);
        if (i <= i5) {
            i2 = ((i3 << (i4 % 8)) & 255) >> ((i4 % 8) + (i5 - i));
            this.f541b = i4 + i;
        } else {
            int i6 = i - i5;
            i2 = (mo315a(i5) << i6) + mo315a(i6);
        }
        this.f542c.position(this.f540a + ((int) Math.ceil(((double) this.f541b) / 8.0d)));
        return i2;
    }

    /* renamed from: b */
    public int mo317b() {
        return this.f541b;
    }

    /* renamed from: c */
    public int mo318c() {
        int i = 8 - (this.f541b % 8);
        if (i == 8) {
            i = 0;
        }
        mo315a(i);
        return i;
    }

    /* renamed from: d */
    public int mo319d() {
        return (this.f542c.limit() * 8) - this.f541b;
    }
}
