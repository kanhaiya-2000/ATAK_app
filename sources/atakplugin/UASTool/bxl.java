package atakplugin.UASTool;

import java.io.IOException;
import java.io.InputStream;

@aot(mo1534a = 1, mo1535b = {1, 1, 11}, mo1536c = {1, 0, 2}, mo1537d = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J \u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0003H\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, mo1538e = {"okio/RealBufferedSource$inputStream$1", "Ljava/io/InputStream;", "available", "", "close", "", "read", "data", "", "offset", "byteCount", "toString", "", "jvm"})
public final class bxl extends InputStream {

    /* renamed from: a */
    final /* synthetic */ bxk f4195a;

    bxl(bxk bxk) {
        this.f4195a = bxk;
    }

    public int read() {
        if (this.f4195a.f4193b) {
            throw new IOException("closed");
        } else if (this.f4195a.f4192a.mo3783a() == 0 && this.f4195a.f4194c.mo3425a(this.f4195a.f4192a, (long) 8192) == -1) {
            return -1;
        } else {
            return this.f4195a.f4192a.mo3866m() & 255;
        }
    }

    public int read(byte[] bArr, int i, int i2) {
        bfq.m6567f(bArr, "data");
        if (!this.f4195a.f4193b) {
            bwg.m9952a((long) bArr.length, (long) i, (long) i2);
            if (this.f4195a.f4192a.mo3783a() == 0 && this.f4195a.f4194c.mo3425a(this.f4195a.f4192a, (long) 8192) == -1) {
                return -1;
            }
            return this.f4195a.f4192a.mo3782a(bArr, i, i2);
        }
        throw new IOException("closed");
    }

    public int available() {
        if (!this.f4195a.f4193b) {
            return (int) Math.min(this.f4195a.f4192a.mo3783a(), (long) Integer.MAX_VALUE);
        }
        throw new IOException("closed");
    }

    public void close() {
        this.f4195a.close();
    }

    public String toString() {
        return this.f4195a + ".inputStream()";
    }
}
