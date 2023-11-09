package atakplugin.UASTool;

import java.lang.ref.Reference;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class bra {

    /* renamed from: c */
    static final /* synthetic */ boolean f3334c = true;

    /* renamed from: d */
    private static final Executor f3335d = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), bsp.m9156a("OkHttp ConnectionPool", true));

    /* renamed from: a */
    final btj f3336a;

    /* renamed from: b */
    boolean f3337b;

    /* renamed from: e */
    private final int f3338e;

    /* renamed from: f */
    private final long f3339f;

    /* renamed from: g */
    private final Runnable f3340g;

    /* renamed from: h */
    private final Deque<bti> f3341h;

    public bra() {
        this(5, 5, TimeUnit.MINUTES);
    }

    public bra(int i, long j, TimeUnit timeUnit) {
        this.f3340g = new brb(this);
        this.f3341h = new ArrayDeque();
        this.f3336a = new btj();
        this.f3338e = i;
        this.f3339f = timeUnit.toNanos(j);
        if (j <= 0) {
            throw new IllegalArgumentException("keepAliveDuration <= 0: " + j);
        }
    }

    /* renamed from: a */
    public synchronized int mo3084a() {
        int i;
        i = 0;
        for (bti bti : this.f3341h) {
            if (bti.f3680g.isEmpty()) {
                i++;
            }
        }
        return i;
    }

    /* renamed from: b */
    public synchronized int mo3088b() {
        return this.f3341h.size();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public bti mo3086a(bqj bqj, btm btm) {
        if (f3334c || Thread.holdsLock(this)) {
            for (bti next : this.f3341h) {
                if (next.f3680g.size() < next.f3679f && bqj.equals(next.mo3080a().f3571a) && !next.f3681h) {
                    btm.mo3485a(next);
                    return next;
                }
            }
            return null;
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3087a(bti bti) {
        if (f3334c || Thread.holdsLock(this)) {
            if (!this.f3337b) {
                this.f3337b = true;
                f3335d.execute(this.f3340g);
            }
            this.f3341h.add(bti);
            return;
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo3089b(bti bti) {
        if (!f3334c && !Thread.holdsLock(this)) {
            throw new AssertionError();
        } else if (bti.f3681h || this.f3338e == 0) {
            this.f3341h.remove(bti);
            return true;
        } else {
            notifyAll();
            return false;
        }
    }

    /* renamed from: c */
    public void mo3090c() {
        ArrayList<bti> arrayList = new ArrayList<>();
        synchronized (this) {
            Iterator<bti> it = this.f3341h.iterator();
            while (it.hasNext()) {
                bti next = it.next();
                if (next.f3680g.isEmpty()) {
                    next.f3681h = true;
                    arrayList.add(next);
                    it.remove();
                }
            }
        }
        for (bti b : arrayList) {
            bsp.m9161a(b.mo3081b());
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public long mo3085a(long j) {
        synchronized (this) {
            bti bti = null;
            long j2 = Long.MIN_VALUE;
            int i = 0;
            int i2 = 0;
            for (bti next : this.f3341h) {
                if (m8676a(next, j) > 0) {
                    i2++;
                } else {
                    i++;
                    long j3 = j - next.f3682i;
                    if (j3 > j2) {
                        bti = next;
                        j2 = j3;
                    }
                }
            }
            long j4 = this.f3339f;
            if (j2 < j4) {
                if (i <= this.f3338e) {
                    if (i > 0) {
                        long j5 = j4 - j2;
                        return j5;
                    } else if (i2 > 0) {
                        return j4;
                    } else {
                        this.f3337b = false;
                        return -1;
                    }
                }
            }
            this.f3341h.remove(bti);
            bsp.m9161a(bti.mo3081b());
            return 0;
        }
    }

    /* renamed from: a */
    private int m8676a(bti bti, long j) {
        List<Reference<btm>> list = bti.f3680g;
        int i = 0;
        while (i < list.size()) {
            if (list.get(i).get() != null) {
                i++;
            } else {
                bvp b = bvp.m9870b();
                b.mo3721a(5, "A connection to " + bti.mo3080a().mo3416a().mo2984a() + " was leaked. Did you forget to close a response body?", (Throwable) null);
                list.remove(i);
                bti.f3681h = true;
                if (list.isEmpty()) {
                    bti.f3682i = j - this.f3339f;
                    return 0;
                }
            }
        }
        return list.size();
    }
}
