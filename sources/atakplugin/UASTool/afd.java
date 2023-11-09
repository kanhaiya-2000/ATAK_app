package atakplugin.UASTool;

import java.io.OutputStream;

public class afd {

    /* renamed from: a */
    private final OutputStream f849a;

    /* renamed from: b */
    private int[] f850b = new int[8];

    /* renamed from: c */
    private int f851c;

    public afd(OutputStream outputStream) {
        this.f849a = outputStream;
    }

    /* renamed from: a */
    public void mo560a() {
        for (int i = this.f851c; i < 8; i++) {
            this.f850b[i] = 0;
        }
        this.f851c = 0;
        mo571c();
    }

    /* renamed from: c */
    private void mo571c() {
        int[] iArr = this.f850b;
        this.f849a.write(iArr[7] | (iArr[0] << 7) | (iArr[1] << 6) | (iArr[2] << 5) | (iArr[3] << 4) | (iArr[4] << 3) | (iArr[5] << 2) | (iArr[6] << 1));
    }

    /* renamed from: a */
    public void mo561a(int i) {
        aer.m771a(i);
        if (this.f851c == 8) {
            this.f851c = 0;
            mo571c();
        }
        int[] iArr = this.f850b;
        int i2 = this.f851c;
        this.f851c = i2 + 1;
        iArr[i2] = i;
    }

    /* renamed from: a */
    public void mo562a(long j, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            mo561a(((int) (j >> ((i - i2) - 1))) & 1);
        }
    }

    /* renamed from: b */
    public void mo563b() {
        mo562a(0, 8 - this.f851c);
    }

    /* renamed from: b */
    public void mo564b(int i) {
        this.f849a.write(i);
    }
}
