package atakplugin.UASTool;

import java.nio.ByteBuffer;

public class adj {

    /* renamed from: c */
    static final /* synthetic */ boolean f543c = true;

    /* renamed from: a */
    int f544a;

    /* renamed from: b */
    int f545b = 0;

    /* renamed from: d */
    private ByteBuffer f546d;

    public adj(ByteBuffer byteBuffer) {
        this.f546d = byteBuffer;
        this.f544a = byteBuffer.position();
    }

    /* renamed from: a */
    public void mo321a(boolean z) {
        mo320a(z ? 1 : 0, 1);
    }

    /* renamed from: a */
    public void mo320a(int i, int i2) {
        int i3;
        int i4 = 0;
        if (f543c || i <= (i3 = (1 << i2) - 1)) {
            int i5 = this.f545b;
            int i6 = 8 - (i5 % 8);
            if (i2 <= i6) {
                int i7 = this.f546d.get(this.f544a + (i5 / 8));
                if (i7 < 0) {
                    i7 += 256;
                }
                int i8 = i7 + (i << (i6 - i2));
                ByteBuffer byteBuffer = this.f546d;
                int i9 = this.f544a + (this.f545b / 8);
                if (i8 > 127) {
                    i8 -= 256;
                }
                byteBuffer.put(i9, (byte) i8);
                this.f545b += i2;
            } else {
                int i10 = i2 - i6;
                mo320a(i >> i10, i6);
                mo320a(i & ((1 << i10) - 1), i10);
            }
            ByteBuffer byteBuffer2 = this.f546d;
            int i11 = this.f544a;
            int i12 = this.f545b;
            int i13 = i11 + (i12 / 8);
            if (i12 % 8 > 0) {
                i4 = 1;
            }
            byteBuffer2.position(i13 + i4);
            return;
        }
        throw new AssertionError(String.format("Trying to write a value bigger (%s) than the number bits (%s) allows. Please mask the value before writing it and make your code is really working as intended.", new Object[]{Integer.valueOf(i), Integer.valueOf(i3)}));
    }
}
