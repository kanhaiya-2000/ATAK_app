package atakplugin.UASTool;

import java.util.concurrent.TimeUnit;

@aot(mo1534a = 1, mo1535b = {1, 1, 11}, mo1536c = {1, 0, 2}, mo1537d = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0001H\u0016J\b\u0010\u0007\u001a\u00020\u0001H\u0016J\b\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\b\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\u000e\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001J\b\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\tH\u0016R\u001c\u0010\u0002\u001a\u00020\u00018\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\u0004\"\u0004\b\u0005\u0010\u0003¨\u0006\u0012"}, mo1538e = {"Lokio/ForwardingTimeout;", "Lokio/Timeout;", "delegate", "(Lokio/Timeout;)V", "()Lokio/Timeout;", "setDelegate", "clearDeadline", "clearTimeout", "deadlineNanoTime", "", "hasDeadline", "", "throwIfReached", "", "timeout", "unit", "Ljava/util/concurrent/TimeUnit;", "timeoutNanos", "jvm"})
public class bwu extends bxs {

    /* renamed from: a */
    private bxs f4143a;

    /* renamed from: b */
    public final /* synthetic */ void mo3985b(bxs bxs) {
        bfq.m6567f(bxs, "<set-?>");
        this.f4143a = bxs;
    }

    /* renamed from: g */
    public final bxs mo3989g() {
        return this.f4143a;
    }

    public bwu(bxs bxs) {
        bfq.m6567f(bxs, "delegate");
        this.f4143a = bxs;
    }

    /* renamed from: a */
    public final bwu mo3982a(bxs bxs) {
        bfq.m6567f(bxs, "delegate");
        this.f4143a = bxs;
        return this;
    }

    /* renamed from: a */
    public bxs mo3984a(long j, TimeUnit timeUnit) {
        bfq.m6567f(timeUnit, "unit");
        return this.f4143a.mo3984a(j, timeUnit);
    }

    /* renamed from: f_ */
    public long mo3988f_() {
        return this.f4143a.mo3988f_();
    }

    /* renamed from: g_ */
    public boolean mo3990g_() {
        return this.f4143a.mo3990g_();
    }

    /* renamed from: c */
    public long mo3986c() {
        return this.f4143a.mo3986c();
    }

    /* renamed from: a */
    public bxs mo3983a(long j) {
        return this.f4143a.mo3983a(j);
    }

    /* renamed from: d */
    public bxs mo3987d() {
        return this.f4143a.mo3987d();
    }

    /* renamed from: h_ */
    public bxs mo3991h_() {
        return this.f4143a.mo3991h_();
    }

    /* renamed from: i_ */
    public void mo3992i_() {
        this.f4143a.mo3992i_();
    }
}
