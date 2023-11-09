package atakplugin.UASTool;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;

public class ccz implements ccy {

    /* renamed from: e */
    private static final int f4504e = 20000;

    /* renamed from: f */
    private static final int f4505f = 100;

    /* renamed from: a */
    private Hashtable f4506a = new Hashtable();

    /* renamed from: b */
    private Thread f4507b;

    /* renamed from: c */
    private C0300a f4508c;

    /* renamed from: d */
    private int f4509d = 0;

    /* renamed from: d */
    public void mo4474d() {
    }

    /* renamed from: atakplugin.UASTool.ccz$a */
    static class C0300a {

        /* renamed from: a */
        protected int f4510a = 0;

        C0300a() {
        }
    }

    /* renamed from: e */
    private synchronized C0300a m11317e() {
        if (Thread.currentThread() != this.f4507b) {
            Thread currentThread = Thread.currentThread();
            this.f4507b = currentThread;
            C0300a aVar = (C0300a) this.f4506a.get(currentThread);
            this.f4508c = aVar;
            if (aVar == null) {
                C0300a aVar2 = new C0300a();
                this.f4508c = aVar2;
                this.f4506a.put(this.f4507b, aVar2);
            }
            this.f4509d++;
            if (this.f4509d > Math.max(100, f4504e / Math.max(1, this.f4506a.size()))) {
                ArrayList<Thread> arrayList = new ArrayList<>();
                Enumeration keys = this.f4506a.keys();
                while (keys.hasMoreElements()) {
                    Thread thread = (Thread) keys.nextElement();
                    if (!thread.isAlive()) {
                        arrayList.add(thread);
                    }
                }
                for (Thread remove : arrayList) {
                    this.f4506a.remove(remove);
                }
                this.f4509d = 0;
            }
        }
        return this.f4508c;
    }

    /* renamed from: a */
    public void mo4471a() {
        m11317e().f4510a++;
    }

    /* renamed from: b */
    public void mo4472b() {
        C0300a e = m11317e();
        e.f4510a--;
    }

    /* renamed from: c */
    public boolean mo4473c() {
        return m11317e().f4510a != 0;
    }
}
