package atakplugin.UASTool;

import indago.serialization.JsonKeyConstants;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

@aot(mo1534a = 1, mo1535b = {1, 1, 11}, mo1536c = {1, 0, 2}, mo1537d = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000 \u00172\u00020\u0001:\u0002\u0017\u0018B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\b\u001a\u00020\tJ\u0006\u0010\n\u001a\u00020\u0004J\u0015\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0000¢\u0006\u0002\b\rJ\u0015\u0010\n\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\rJ\u0012\u0010\u000f\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0014J\u0010\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0007H\u0002J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0015J\b\u0010\u0016\u001a\u00020\tH\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0000X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, mo1538e = {"Lokio/AsyncTimeout;", "Lokio/Timeout;", "()V", "inQueue", "", "next", "timeoutAt", "", "enter", "", "exit", "Ljava/io/IOException;", "cause", "exit$jvm", "throwOnTimeout", "newTimeoutException", "remainingNanos", "now", "sink", "Lokio/Sink;", "source", "Lokio/Source;", "timedOut", "Companion", "Watchdog", "jvm"})
public class bwh extends bxs {

    /* renamed from: b */
    public static final C0273a f4108b = new C0273a((bfd) null);

    /* renamed from: g */
    private static final int f4109g = 65536;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public static final long f4110h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public static final long f4111i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public static bwh f4112j;

    /* renamed from: a */
    private boolean f4113a;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public bwh f4114e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public long f4115f;

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo3614a() {
    }

    /* renamed from: c_ */
    public final void mo3760c_() {
        if (!this.f4113a) {
            long f_ = mo3988f_();
            boolean g_ = mo3990g_();
            if (f_ != 0 || g_) {
                this.f4113a = true;
                f4108b.m9976a(this, f_, g_);
                return;
            }
            return;
        }
        throw new IllegalStateException("Unbalanced enter/exit".toString());
    }

    /* renamed from: e_ */
    public final boolean mo3761e_() {
        if (!this.f4113a) {
            return false;
        }
        this.f4113a = false;
        return f4108b.m9978a(this);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final long m9960b(long j) {
        return this.f4115f - j;
    }

    /* renamed from: a */
    public final bxp mo3756a(bxp bxp) {
        bfq.m6567f(bxp, "sink");
        return new bwi(this, bxp);
    }

    /* renamed from: a */
    public final bxr mo3757a(bxr bxr) {
        bfq.m6567f(bxr, JsonKeyConstants.SOURCE);
        return new bwj(this, bxr);
    }

    /* renamed from: a */
    public final void mo3758a(boolean z) {
        if (mo3761e_() && z) {
            throw mo3613a((IOException) null);
        }
    }

    /* renamed from: b */
    public final IOException mo3759b(IOException iOException) {
        bfq.m6567f(iOException, "cause");
        return !mo3761e_() ? iOException : mo3613a(iOException);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public IOException mo3613a(IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    @aot(mo1534a = 1, mo1535b = {1, 1, 11}, mo1536c = {1, 0, 2}, mo1537d = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0000¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, mo1538e = {"Lokio/AsyncTimeout$Watchdog;", "Ljava/lang/Thread;", "()V", "run", "", "jvm"})
    /* renamed from: atakplugin.UASTool.bwh$b */
    private static final class C0274b extends Thread {
        public C0274b() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:16:0x001d, code lost:
            if (r2 == null) goto L_0x0000;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x001f, code lost:
            r2.mo3614a();
         */
        /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r4 = this;
            L_0x0000:
                r0 = 0
                r1 = r0
                atakplugin.UASTool.bwh r1 = (atakplugin.UASTool.bwh) r1     // Catch:{ InterruptedException -> 0x0000 }
                java.lang.Class<atakplugin.UASTool.bwh> r1 = atakplugin.UASTool.bwh.class
                monitor-enter(r1)     // Catch:{ InterruptedException -> 0x0000 }
                atakplugin.UASTool.bwh$a r2 = atakplugin.UASTool.bwh.f4108b     // Catch:{ all -> 0x0023 }
                atakplugin.UASTool.bwh r2 = r2.mo3762a()     // Catch:{ all -> 0x0023 }
                atakplugin.UASTool.bwh r3 = atakplugin.UASTool.bwh.f4112j     // Catch:{ all -> 0x0023 }
                if (r2 != r3) goto L_0x001a
                atakplugin.UASTool.bwh r0 = (atakplugin.UASTool.bwh) r0     // Catch:{ all -> 0x0023 }
                atakplugin.UASTool.bwh.f4112j = r0     // Catch:{ all -> 0x0023 }
                monitor-exit(r1)     // Catch:{ InterruptedException -> 0x0000 }
                return
            L_0x001a:
                atakplugin.UASTool.aqr r0 = atakplugin.UASTool.aqr.f2177a     // Catch:{ all -> 0x0023 }
                monitor-exit(r1)     // Catch:{ InterruptedException -> 0x0000 }
                if (r2 == 0) goto L_0x0000
                r2.mo3614a()     // Catch:{ InterruptedException -> 0x0000 }
                goto L_0x0000
            L_0x0023:
                r0 = move-exception
                monitor-exit(r1)     // Catch:{ InterruptedException -> 0x0000 }
                throw r0     // Catch:{ InterruptedException -> 0x0000 }
            */
            throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.bwh.C0274b.run():void");
        }
    }

    @aot(mo1534a = 1, mo1535b = {1, 1, 11}, mo1536c = {1, 0, 2}, mo1537d = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\n\u001a\u0004\u0018\u00010\tH\u0000¢\u0006\u0002\b\u000bJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\tH\u0002J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\rH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, mo1538e = {"Lokio/AsyncTimeout$Companion;", "", "()V", "IDLE_TIMEOUT_MILLIS", "", "IDLE_TIMEOUT_NANOS", "TIMEOUT_WRITE_SIZE", "", "head", "Lokio/AsyncTimeout;", "awaitTimeout", "awaitTimeout$jvm", "cancelScheduledTimeout", "", "node", "scheduleTimeout", "", "timeoutNanos", "hasDeadline", "jvm"})
    /* renamed from: atakplugin.UASTool.bwh$a */
    public static final class C0273a {
        private C0273a() {
        }

        public /* synthetic */ C0273a(bfd bfd) {
            this();
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public final void m9976a(bwh bwh, long j, boolean z) {
            synchronized (bwh.class) {
                if (bwh.f4112j == null) {
                    bwh.f4112j = new bwh();
                    new C0274b().start();
                }
                long nanoTime = System.nanoTime();
                int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
                if (i != 0 && z) {
                    bwh.f4115f = Math.min(j, bwh.mo3986c() - nanoTime) + nanoTime;
                } else if (i != 0) {
                    bwh.f4115f = j + nanoTime;
                } else if (z) {
                    bwh.f4115f = bwh.mo3986c();
                } else {
                    throw new AssertionError();
                }
                long b = bwh.m9960b(nanoTime);
                bwh e = bwh.f4112j;
                if (e == null) {
                    bfq.m6538a();
                }
                while (true) {
                    if (e.f4114e == null) {
                        break;
                    }
                    bwh c = e.f4114e;
                    if (c == null) {
                        bfq.m6538a();
                    }
                    if (b < c.m9960b(nanoTime)) {
                        break;
                    }
                    e = e.f4114e;
                    if (e == null) {
                        bfq.m6538a();
                    }
                }
                bwh.f4114e = e.f4114e;
                e.f4114e = bwh;
                if (e == bwh.f4112j) {
                    bwh.class.notify();
                }
                aqr aqr = aqr.f2177a;
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public final boolean m9978a(bwh bwh) {
            synchronized (bwh.class) {
                for (bwh e = bwh.f4112j; e != null; e = e.f4114e) {
                    if (e.f4114e == bwh) {
                        e.f4114e = bwh.f4114e;
                        bwh.f4114e = null;
                        return false;
                    }
                }
                return true;
            }
        }

        /* renamed from: a */
        public final bwh mo3762a() {
            bwh e = bwh.f4112j;
            if (e == null) {
                bfq.m6538a();
            }
            bwh c = e.f4114e;
            if (c == null) {
                long nanoTime = System.nanoTime();
                bwh.class.wait(bwh.f4110h);
                bwh e2 = bwh.f4112j;
                if (e2 == null) {
                    bfq.m6538a();
                }
                if (e2.f4114e != null || System.nanoTime() - nanoTime < bwh.f4111i) {
                    return null;
                }
                return bwh.f4112j;
            }
            long b = c.m9960b(System.nanoTime());
            if (b > 0) {
                long j = b / 1000000;
                bwh.class.wait(j, (int) (b - (1000000 * j)));
                return null;
            }
            bwh e3 = bwh.f4112j;
            if (e3 == null) {
                bfq.m6538a();
            }
            e3.f4114e = c.f4114e;
            c.f4114e = null;
            return c;
        }
    }

    static {
        long millis = TimeUnit.SECONDS.toMillis(60);
        f4110h = millis;
        f4111i = TimeUnit.MILLISECONDS.toNanos(millis);
    }
}
