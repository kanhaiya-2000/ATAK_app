package atakplugin.UASTool;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

/* renamed from: atakplugin.UASTool.ys */
public class C1066ys extends FilterInputStream {

    /* renamed from: a */
    int f7736a = -1;

    /* renamed from: b */
    int f7737b = -1;

    public boolean markSupported() {
        return false;
    }

    public C1066ys(InputStream inputStream) {
        super(inputStream);
    }

    public int read() {
        int read = super.read();
        if (read == 3 && this.f7736a == 0 && this.f7737b == 0) {
            this.f7736a = -1;
            this.f7737b = -1;
            read = super.read();
        }
        this.f7736a = this.f7737b;
        this.f7737b = read;
        return read;
    }

    public int read(byte[] bArr, int i, int i2) {
        Objects.requireNonNull(bArr);
        if (i < 0 || i2 < 0 || i2 > bArr.length - i) {
            throw new IndexOutOfBoundsException();
        } else if (i2 == 0) {
            return 0;
        } else {
            int read = read();
            if (read == -1) {
                return -1;
            }
            bArr[i] = (byte) read;
            int i3 = 1;
            while (true) {
                if (i3 >= i2) {
                    break;
                }
                try {
                    int read2 = read();
                    if (read2 == -1) {
                        break;
                    }
                    bArr[i + i3] = (byte) read2;
                    i3++;
                } catch (IOException unused) {
                }
            }
            return i3;
        }
    }
}
