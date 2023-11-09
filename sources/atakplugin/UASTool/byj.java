package atakplugin.UASTool;

import java.io.OutputStream;

public class byj extends byp {
    public byj(OutputStream outputStream) {
        this(outputStream, true);
    }

    public byj(OutputStream outputStream, boolean z) {
        super(outputStream, new byh(false), z);
    }

    public byj(OutputStream outputStream, boolean z, int i, byte[] bArr) {
        super(outputStream, new byh(i, bArr), z);
    }
}
