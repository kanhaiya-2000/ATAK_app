package atakplugin.UASTool;

import java.nio.ByteBuffer;

/* renamed from: atakplugin.UASTool.nl */
public final class C0680nl {
    /* renamed from: a */
    public static long m12508a(ByteBuffer byteBuffer, int i) {
        int f;
        if (i == 1) {
            f = C0679nk.m12499f(byteBuffer);
        } else if (i == 2) {
            f = C0679nk.m12497d(byteBuffer);
        } else if (i == 3) {
            f = C0679nk.m12496c(byteBuffer);
        } else if (i == 4) {
            return C0679nk.m12495b(byteBuffer);
        } else {
            if (i == 8) {
                return C0679nk.m12501h(byteBuffer);
            }
            throw new RuntimeException("I don't know how to read " + i + " bytes");
        }
        return (long) f;
    }
}
