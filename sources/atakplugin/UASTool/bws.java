package atakplugin.UASTool;

import indago.serialization.JsonKeyConstants;

@aot(mo1534a = 1, mo1535b = {1, 1, 11}, mo1536c = {1, 0, 2}, mo1537d = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\r\u0010\u0002\u001a\u00020\u0001H\u0007¢\u0006\u0002\b\u0007J\b\u0010\b\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u0013\u0010\u0002\u001a\u00020\u00018\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0004¨\u0006\u0012"}, mo1538e = {"Lokio/ForwardingSink;", "Lokio/Sink;", "delegate", "(Lokio/Sink;)V", "()Lokio/Sink;", "close", "", "-deprecated_delegate", "flush", "timeout", "Lokio/Timeout;", "toString", "", "write", "source", "Lokio/Buffer;", "byteCount", "", "jvm"})
public abstract class bws implements bxp {
    private final bxp delegate;

    public bws(bxp bxp) {
        bfq.m6567f(bxp, "delegate");
        this.delegate = bxp;
    }

    public final bxp delegate() {
        return this.delegate;
    }

    public void write(bwl bwl, long j) {
        bfq.m6567f(bwl, JsonKeyConstants.SOURCE);
        this.delegate.write(bwl, j);
    }

    public void flush() {
        this.delegate.flush();
    }

    public bxs timeout() {
        return this.delegate.timeout();
    }

    public void close() {
        this.delegate.close();
    }

    public String toString() {
        return getClass().getSimpleName() + '(' + this.delegate + ')';
    }

    @anx(mo1516a = "moved to val", mo1517b = @C0081api(mo1552a = "delegate", mo1553b = {}), mo1518c = any.ERROR)
    /* renamed from: -deprecated_delegate  reason: not valid java name */
    public final bxp m15277deprecated_delegate() {
        return this.delegate;
    }
}
