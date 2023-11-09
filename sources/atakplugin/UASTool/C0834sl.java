package atakplugin.UASTool;

import java.io.OutputStream;

/* renamed from: atakplugin.UASTool.sl */
public class C0834sl extends OutputStream {

    /* renamed from: a */
    protected final C0847ss f6398a;

    /* renamed from: b */
    private int f6399b = 0;

    public C0834sl(C0847ss ssVar) {
        this.f6398a = ssVar;
    }

    public void write(int i) {
        this.f6398a.mo5752b(new byte[]{(byte) i}, this.f6399b);
    }

    public void write(byte[] bArr) {
        this.f6398a.mo5752b(bArr, this.f6399b);
    }

    public void write(byte[] bArr, int i, int i2) {
        if (i < 0) {
            throw new IndexOutOfBoundsException("Offset must be >= 0");
        } else if (i2 < 0) {
            throw new IndexOutOfBoundsException("Length must positive");
        } else if (i + i2 > bArr.length) {
            throw new IndexOutOfBoundsException("off + length greater than buffer length");
        } else if (i == 0 && i2 == bArr.length) {
            write(bArr);
        } else {
            this.f6398a.mo5753b(bArr, i, i2, this.f6399b);
        }
    }

    /* renamed from: a */
    public void mo5734a(int i) {
        this.f6399b = i;
    }
}
