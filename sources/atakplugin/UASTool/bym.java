package atakplugin.UASTool;

import java.io.OutputStream;

public class bym extends byp {
    public bym(OutputStream outputStream) {
        this(outputStream, true);
    }

    public bym(OutputStream outputStream, boolean z) {
        super(outputStream, new byk(false), z);
    }

    public bym(OutputStream outputStream, boolean z, int i, byte[] bArr) {
        super(outputStream, new byk(i, bArr), z);
    }
}
