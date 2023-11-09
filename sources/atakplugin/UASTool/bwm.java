package atakplugin.UASTool;

import java.io.InputStream;

@aot(mo1534a = 1, mo1535b = {1, 1, 11}, mo1536c = {1, 0, 2}, mo1537d = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J \u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0003H\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, mo1538e = {"okio/Buffer$inputStream$1", "Ljava/io/InputStream;", "available", "", "close", "", "read", "sink", "", "offset", "byteCount", "toString", "", "jvm"})
public final class bwm extends InputStream {

    /* renamed from: a */
    final /* synthetic */ bwl f4131a;

    public void close() {
    }

    bwm(bwl bwl) {
        this.f4131a = bwl;
    }

    public int read() {
        if (this.f4131a.mo3783a() > 0) {
            return this.f4131a.mo3866m() & 255;
        }
        return -1;
    }

    public int read(byte[] bArr, int i, int i2) {
        bfq.m6567f(bArr, "sink");
        return this.f4131a.mo3782a(bArr, i, i2);
    }

    public int available() {
        return (int) Math.min(this.f4131a.mo3783a(), (long) Integer.MAX_VALUE);
    }

    public String toString() {
        return this.f4131a + ".inputStream()";
    }
}
