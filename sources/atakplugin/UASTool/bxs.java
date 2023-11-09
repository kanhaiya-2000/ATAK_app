package atakplugin.UASTool;

import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

@aot(mo1534a = 1, mo1535b = {1, 1, 11}, mo1536c = {1, 0, 2}, mo1537d = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\b\u001a\u00020\u0000H\u0016J\b\u0010\t\u001a\u00020\u0000H\u0016J\u0016\u0010\n\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rJ\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\u000e\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0001R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, mo1538e = {"Lokio/Timeout;", "", "()V", "deadlineNanoTime", "", "hasDeadline", "", "timeoutNanos", "clearDeadline", "clearTimeout", "deadline", "duration", "unit", "Ljava/util/concurrent/TimeUnit;", "throwIfReached", "", "timeout", "waitUntilNotified", "monitor", "Companion", "jvm"})
public class bxs {

    /* renamed from: c */
    public static final bxs f4214c = new bxt();

    /* renamed from: d */
    public static final C0283a f4215d = new C0283a((bfd) null);

    /* renamed from: a */
    private boolean f4216a;

    /* renamed from: b */
    private long f4217b;

    /* renamed from: e */
    private long f4218e;

    /* renamed from: a */
    public bxs mo3984a(long j, TimeUnit timeUnit) {
        bfq.m6567f(timeUnit, "unit");
        if (j >= 0) {
            this.f4218e = timeUnit.toNanos(j);
            return this;
        }
        throw new IllegalArgumentException(("timeout < 0: " + j).toString());
    }

    /* renamed from: f_ */
    public long mo3988f_() {
        return this.f4218e;
    }

    /* renamed from: g_ */
    public boolean mo3990g_() {
        return this.f4216a;
    }

    /* renamed from: c */
    public long mo3986c() {
        if (this.f4216a) {
            return this.f4217b;
        }
        throw new IllegalStateException("No deadline".toString());
    }

    /* renamed from: a */
    public bxs mo3983a(long j) {
        this.f4216a = true;
        this.f4217b = j;
        return this;
    }

    /* renamed from: b */
    public final bxs mo4069b(long j, TimeUnit timeUnit) {
        bfq.m6567f(timeUnit, "unit");
        if (j > 0) {
            return mo3983a(System.nanoTime() + timeUnit.toNanos(j));
        }
        throw new IllegalArgumentException(("duration <= 0: " + j).toString());
    }

    /* renamed from: d */
    public bxs mo3987d() {
        this.f4218e = 0;
        return this;
    }

    /* renamed from: h_ */
    public bxs mo3991h_() {
        this.f4216a = false;
        return this;
    }

    /* renamed from: i_ */
    public void mo3992i_() {
        if (Thread.interrupted()) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException("interrupted");
        } else if (this.f4216a && this.f4217b - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }

    /* renamed from: a */
    public final void mo4068a(Object obj) {
        bfq.m6567f(obj, "monitor");
        try {
            boolean g_ = mo3990g_();
            long f_ = mo3988f_();
            long j = 0;
            if (g_ || f_ != 0) {
                long nanoTime = System.nanoTime();
                if (g_ && f_ != 0) {
                    f_ = Math.min(f_, mo3986c() - nanoTime);
                } else if (g_) {
                    f_ = mo3986c() - nanoTime;
                }
                if (f_ > 0) {
                    long j2 = f_ / 1000000;
                    Long.signum(j2);
                    obj.wait(j2, (int) (f_ - (1000000 * j2)));
                    j = System.nanoTime() - nanoTime;
                }
                if (j >= f_) {
                    throw new InterruptedIOException("timeout");
                }
                return;
            }
            obj.wait();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException("interrupted");
        }
    }

    @aot(mo1534a = 1, mo1535b = {1, 1, 11}, mo1536c = {1, 0, 2}, mo1537d = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo1538e = {"Lokio/Timeout$Companion;", "", "()V", "NONE", "Lokio/Timeout;", "jvm"})
    /* renamed from: atakplugin.UASTool.bxs$a */
    public static final class C0283a {
        private C0283a() {
        }

        public /* synthetic */ C0283a(bfd bfd) {
            this();
        }
    }
}
