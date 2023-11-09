package atakplugin.UASTool;

import java.io.OutputStream;

@aot(mo1534a = 1, mo1535b = {1, 1, 11}, mo1536c = {1, 0, 2}, mo1537d = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J \u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000bH\u0016¨\u0006\u000e"}, mo1538e = {"okio/Buffer$outputStream$1", "Ljava/io/OutputStream;", "close", "", "flush", "toString", "", "write", "data", "", "offset", "", "byteCount", "b", "jvm"})
public final class bwn extends OutputStream {

    /* renamed from: a */
    final /* synthetic */ bwl f4132a;

    public void close() {
    }

    public void flush() {
    }

    bwn(bwl bwl) {
        this.f4132a = bwl;
    }

    public void write(int i) {
        this.f4132a.mo3833d(i);
    }

    public void write(byte[] bArr, int i, int i2) {
        bfq.m6567f(bArr, "data");
        this.f4132a.mo3828c(bArr, i, i2);
    }

    public String toString() {
        return this.f4132a + ".outputStream()";
    }
}
