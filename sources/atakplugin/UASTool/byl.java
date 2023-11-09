package atakplugin.UASTool;

import java.io.InputStream;

public class byl extends byo {
    public byl(InputStream inputStream) {
        this(inputStream, false);
    }

    public byl(InputStream inputStream, boolean z) {
        super(inputStream, new byk(false), z);
    }

    public byl(InputStream inputStream, boolean z, int i, byte[] bArr) {
        super(inputStream, new byk(i, bArr), z);
    }
}
