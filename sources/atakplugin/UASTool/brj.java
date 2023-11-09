package atakplugin.UASTool;

import atakplugin.UASTool.brz;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class brj {

    /* renamed from: a */
    private int f3378a = 64;

    /* renamed from: b */
    private int f3379b = 5;

    /* renamed from: c */
    private Runnable f3380c;

    /* renamed from: d */
    private ExecutorService f3381d;

    /* renamed from: e */
    private final Deque<brz.C0232a> f3382e = new ArrayDeque();

    /* renamed from: f */
    private final Deque<brz.C0232a> f3383f = new ArrayDeque();

    /* renamed from: g */
    private final Deque<brz> f3384g = new ArrayDeque();

    public brj(ExecutorService executorService) {
        this.f3381d = executorService;
    }

    public brj() {
    }

    /* renamed from: a */
    public synchronized ExecutorService mo3133a() {
        if (this.f3381d == null) {
            this.f3381d = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), bsp.m9156a("OkHttp Dispatcher", false));
        }
        return this.f3381d;
    }

    /* renamed from: a */
    public synchronized void mo3134a(int i) {
        if (i >= 1) {
            this.f3378a = i;
            m8744i();
        } else {
            throw new IllegalArgumentException("max < 1: " + i);
        }
    }

    /* renamed from: b */
    public synchronized int mo3138b() {
        return this.f3378a;
    }

    /* renamed from: b */
    public synchronized void mo3139b(int i) {
        if (i >= 1) {
            this.f3379b = i;
            m8744i();
        } else {
            throw new IllegalArgumentException("max < 1: " + i);
        }
    }

    /* renamed from: c */
    public synchronized int mo3142c() {
        return this.f3379b;
    }

    /* renamed from: a */
    public synchronized void mo3137a(Runnable runnable) {
        this.f3380c = runnable;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized void mo3135a(brz.C0232a aVar) {
        if (this.f3383f.size() >= this.f3378a || m8743c(aVar) >= this.f3379b) {
            this.f3382e.add(aVar);
        } else {
            this.f3383f.add(aVar);
            mo3133a().execute(aVar);
        }
    }

    /* renamed from: d */
    public synchronized void mo3143d() {
        for (brz.C0232a c : this.f3382e) {
            c.mo3341c().mo3057c();
        }
        for (brz.C0232a c2 : this.f3383f) {
            c2.mo3341c().mo3057c();
        }
        for (brz c3 : this.f3384g) {
            c3.mo3057c();
        }
    }

    /* renamed from: i */
    private void m8744i() {
        if (this.f3383f.size() < this.f3378a && !this.f3382e.isEmpty()) {
            Iterator<brz.C0232a> it = this.f3382e.iterator();
            while (it.hasNext()) {
                brz.C0232a next = it.next();
                if (m8743c(next) < this.f3379b) {
                    it.remove();
                    this.f3383f.add(next);
                    mo3133a().execute(next);
                }
                if (this.f3383f.size() >= this.f3378a) {
                    return;
                }
            }
        }
    }

    /* renamed from: c */
    private int m8743c(brz.C0232a aVar) {
        int i = 0;
        for (brz.C0232a a : this.f3383f) {
            if (a.mo3339a().equals(aVar.mo3339a())) {
                i++;
            }
        }
        return i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized void mo3136a(brz brz) {
        this.f3384g.add(brz);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo3140b(brz.C0232a aVar) {
        m8742a(this.f3383f, aVar, true);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo3141b(brz brz) {
        m8742a(this.f3384g, brz, false);
    }

    /* renamed from: a */
    private <T> void m8742a(Deque<T> deque, T t, boolean z) {
        int h;
        Runnable runnable;
        synchronized (this) {
            if (deque.remove(t)) {
                if (z) {
                    m8744i();
                }
                h = mo3147h();
                runnable = this.f3380c;
            } else {
                throw new AssertionError("Call wasn't in-flight!");
            }
        }
        if (h == 0 && runnable != null) {
            runnable.run();
        }
    }

    /* renamed from: e */
    public synchronized List<bqt> mo3144e() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (brz.C0232a c : this.f3382e) {
            arrayList.add(c.mo3341c());
        }
        return Collections.unmodifiableList(arrayList);
    }

    /* renamed from: f */
    public synchronized List<bqt> mo3145f() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        arrayList.addAll(this.f3384g);
        for (brz.C0232a c : this.f3383f) {
            arrayList.add(c.mo3341c());
        }
        return Collections.unmodifiableList(arrayList);
    }

    /* renamed from: g */
    public synchronized int mo3146g() {
        return this.f3382e.size();
    }

    /* renamed from: h */
    public synchronized int mo3147h() {
        return this.f3383f.size() + this.f3384g.size();
    }
}
