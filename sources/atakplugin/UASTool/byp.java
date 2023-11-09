package atakplugin.UASTool;

import java.io.FilterOutputStream;
import java.io.OutputStream;
import java.util.Objects;

public class byp extends FilterOutputStream {

    /* renamed from: a */
    private final boolean f4288a;

    /* renamed from: b */
    private final byn f4289b;

    /* renamed from: c */
    private final byte[] f4290c = new byte[1];

    public byp(OutputStream outputStream, byn byn, boolean z) {
        super(outputStream);
        this.f4289b = byn;
        this.f4288a = z;
    }

    public void write(int i) {
        byte[] bArr = this.f4290c;
        bArr[0] = (byte) i;
        write(bArr, 0, 1);
    }

    public void write(byte[] bArr, int i, int i2) {
        Objects.requireNonNull(bArr);
        if (i < 0 || i2 < 0) {
            throw new IndexOutOfBoundsException();
        } else if (i > bArr.length || i + i2 > bArr.length) {
            throw new IndexOutOfBoundsException();
        } else if (i2 > 0) {
            if (this.f4288a) {
                this.f4289b.mo4079b(bArr, i, i2);
            } else {
                this.f4289b.mo4077a(bArr, i, i2);
            }
            m10594a(false);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0008, code lost:
        r1 = new byte[r0];
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m10594a(boolean r5) {
        /*
            r4 = this;
            atakplugin.UASTool.byn r0 = r4.f4289b
            int r0 = r0.mo4084c()
            if (r0 <= 0) goto L_0x0018
            byte[] r1 = new byte[r0]
            atakplugin.UASTool.byn r2 = r4.f4289b
            r3 = 0
            int r0 = r2.mo4085c(r1, r3, r0)
            if (r0 <= 0) goto L_0x0018
            java.io.OutputStream r2 = r4.out
            r2.write(r1, r3, r0)
        L_0x0018:
            if (r5 == 0) goto L_0x001f
            java.io.OutputStream r5 = r4.out
            r5.flush()
        L_0x001f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.byp.m10594a(boolean):void");
    }

    public void flush() {
        m10594a(true);
    }

    public void close() {
        if (this.f4288a) {
            this.f4289b.mo4079b(this.f4290c, 0, -1);
        } else {
            this.f4289b.mo4077a(this.f4290c, 0, -1);
        }
        flush();
        this.out.close();
    }
}
