package atakplugin.UASTool;

import java.io.InputStream;

public class byi extends byo {
    public byi(InputStream inputStream) {
        this(inputStream, false);
    }

    public byi(InputStream inputStream, boolean z) {
        super(inputStream, new byh(false), z);
    }

    public byi(InputStream inputStream, boolean z, int i, byte[] bArr) {
        super(inputStream, new byh(i, bArr), z);
    }
}
