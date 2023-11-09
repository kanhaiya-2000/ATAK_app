package atakplugin.UASTool;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.Objects;

public abstract class bsj implements Closeable {

    /* renamed from: a */
    private Reader f3567a;

    /* renamed from: a */
    public abstract bru mo3016a();

    /* renamed from: b */
    public abstract long mo3017b();

    /* renamed from: c */
    public abstract bwp mo3018c();

    /* renamed from: d */
    public final InputStream mo3412d() {
        return mo3018c().mo3862k();
    }

    /* JADX INFO: finally extract failed */
    /* renamed from: e */
    public final byte[] mo3413e() {
        long b = mo3017b();
        if (b <= 2147483647L) {
            bwp c = mo3018c();
            try {
                byte[] A = c.mo3768A();
                bsp.m9158a((Closeable) c);
                if (b == -1 || b == ((long) A.length)) {
                    return A;
                }
                throw new IOException("Content-Length and stream length disagree");
            } catch (Throwable th) {
                bsp.m9158a((Closeable) c);
                throw th;
            }
        } else {
            throw new IOException("Cannot buffer entire body for content length: " + b);
        }
    }

    /* renamed from: f */
    public final Reader mo3414f() {
        Reader reader = this.f3567a;
        if (reader != null) {
            return reader;
        }
        InputStreamReader inputStreamReader = new InputStreamReader(mo3412d(), m9115h());
        this.f3567a = inputStreamReader;
        return inputStreamReader;
    }

    /* renamed from: g */
    public final String mo3415g() {
        return new String(mo3413e(), m9115h().name());
    }

    /* renamed from: h */
    private Charset m9115h() {
        bru a = mo3016a();
        return a != null ? a.mo3253a(bsp.f3584c) : bsp.f3584c;
    }

    public void close() {
        bsp.m9158a((Closeable) mo3018c());
    }

    /* renamed from: a */
    public static bsj m9113a(bru bru, String str) {
        Charset charset = bsp.f3584c;
        if (bru != null && (charset = bru.mo3255c()) == null) {
            charset = bsp.f3584c;
            bru = bru.m8896a(bru + "; charset=utf-8");
        }
        bwl a = new bwl().mo3820b(str, charset);
        return m9112a(bru, a.mo3783a(), a);
    }

    /* renamed from: a */
    public static bsj m9114a(bru bru, byte[] bArr) {
        return m9112a(bru, (long) bArr.length, new bwl().mo3834d(bArr));
    }

    /* renamed from: a */
    public static bsj m9112a(bru bru, long j, bwp bwp) {
        Objects.requireNonNull(bwp, "source == null");
        return new bsk(bru, j, bwp);
    }
}
