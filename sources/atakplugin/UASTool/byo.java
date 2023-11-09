package atakplugin.UASTool;

import java.io.FilterInputStream;
import java.io.InputStream;
import java.util.Objects;

public class byo extends FilterInputStream {

    /* renamed from: a */
    private final boolean f4285a;

    /* renamed from: b */
    private final byn f4286b;

    /* renamed from: c */
    private final byte[] f4287c = new byte[1];

    public boolean markSupported() {
        return false;
    }

    protected byo(InputStream inputStream, byn byn, boolean z) {
        super(inputStream);
        this.f4285a = z;
        this.f4286b = byn;
    }

    public int read() {
        int read = read(this.f4287c, 0, 1);
        while (read == 0) {
            read = read(this.f4287c, 0, 1);
        }
        if (read <= 0) {
            return -1;
        }
        byte[] bArr = this.f4287c;
        return bArr[0] < 0 ? bArr[0] + 256 : bArr[0];
    }

    public int read(byte[] bArr, int i, int i2) {
        Objects.requireNonNull(bArr);
        if (i < 0 || i2 < 0) {
            throw new IndexOutOfBoundsException();
        } else if (i > bArr.length || i + i2 > bArr.length) {
            throw new IndexOutOfBoundsException();
        } else if (i2 == 0) {
            return 0;
        } else {
            int i3 = 0;
            while (i3 == 0) {
                if (!this.f4286b.mo4082b()) {
                    byte[] bArr2 = new byte[(this.f4285a ? 4096 : 8192)];
                    int read = this.in.read(bArr2);
                    if (this.f4285a) {
                        this.f4286b.mo4079b(bArr2, 0, read);
                    } else {
                        this.f4286b.mo4077a(bArr2, 0, read);
                    }
                }
                i3 = this.f4286b.mo4085c(bArr, i, i2);
            }
            return i3;
        }
    }
}
