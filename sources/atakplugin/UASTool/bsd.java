package atakplugin.UASTool;

import java.io.File;
import java.nio.charset.Charset;
import java.util.Objects;

public abstract class bsd {
    public long contentLength() {
        return -1;
    }

    public abstract bru contentType();

    public abstract void writeTo(bwo bwo);

    public static bsd create(bru bru, String str) {
        Charset charset = bsp.f3584c;
        if (bru != null && (charset = bru.mo3255c()) == null) {
            charset = bsp.f3584c;
            bru = bru.m8896a(bru + "; charset=utf-8");
        }
        return create(bru, str.getBytes(charset));
    }

    public static bsd create(bru bru, bwq bwq) {
        return new bse(bru, bwq);
    }

    public static bsd create(bru bru, byte[] bArr) {
        return create(bru, bArr, 0, bArr.length);
    }

    public static bsd create(bru bru, byte[] bArr, int i, int i2) {
        Objects.requireNonNull(bArr, "content == null");
        bsp.m9157a((long) bArr.length, (long) i, (long) i2);
        return new bsf(bru, i2, bArr, i);
    }

    public static bsd create(bru bru, File file) {
        Objects.requireNonNull(file, "content == null");
        return new bsg(bru, file);
    }
}
