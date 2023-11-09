package atakplugin.UASTool;

import java.nio.ByteBuffer;

/* renamed from: atakplugin.UASTool.nn */
public final class C0682nn {
    /* renamed from: a */
    public static void m12524a(long j, ByteBuffer byteBuffer, int i) {
        if (i == 1) {
            C0681nm.m12521d(byteBuffer, (int) (j & 255));
        } else if (i == 2) {
            C0681nm.m12514b(byteBuffer, (int) (j & 65535));
        } else if (i == 3) {
            C0681nm.m12510a(byteBuffer, (int) (j & 16777215));
        } else if (i == 4) {
            C0681nm.m12515b(byteBuffer, j);
        } else if (i == 8) {
            C0681nm.m12511a(byteBuffer, j);
        } else {
            throw new RuntimeException("I don't know how to read " + i + " bytes");
        }
    }
}
