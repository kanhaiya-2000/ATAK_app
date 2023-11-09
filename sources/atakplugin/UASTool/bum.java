package atakplugin.UASTool;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public final class bum {

    /* renamed from: a */
    private final CountDownLatch f3919a = new CountDownLatch(1);

    /* renamed from: b */
    private long f3920b = -1;

    /* renamed from: c */
    private long f3921c = -1;

    bum() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3647a() {
        if (this.f3920b == -1) {
            this.f3920b = System.nanoTime();
            return;
        }
        throw new IllegalStateException();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo3648b() {
        if (this.f3921c != -1 || this.f3920b == -1) {
            throw new IllegalStateException();
        }
        this.f3921c = System.nanoTime();
        this.f3919a.countDown();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo3649c() {
        if (this.f3921c == -1) {
            long j = this.f3920b;
            if (j != -1) {
                this.f3921c = j - 1;
                this.f3919a.countDown();
                return;
            }
        }
        throw new IllegalStateException();
    }

    /* renamed from: d */
    public long mo3650d() {
        this.f3919a.await();
        return this.f3921c - this.f3920b;
    }

    /* renamed from: a */
    public long mo3646a(long j, TimeUnit timeUnit) {
        if (this.f3919a.await(j, timeUnit)) {
            return this.f3921c - this.f3920b;
        }
        return -2;
    }
}
