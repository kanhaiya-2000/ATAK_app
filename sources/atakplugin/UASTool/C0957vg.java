package atakplugin.UASTool;

import android.os.Handler;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: atakplugin.UASTool.vg */
public abstract class C0957vg extends Thread {

    /* renamed from: a */
    public static final int f7411a = 0;

    /* renamed from: b */
    public static final int f7412b = 1;

    /* renamed from: c */
    public static final int f7413c = 2;

    /* renamed from: d */
    private Handler f7414d;

    /* renamed from: e */
    private Queue<C0953vc> f7415e = new LinkedList();

    /* renamed from: f */
    private Lock f7416f = new ReentrantLock();

    /* renamed from: g */
    private Object f7417g = new Object();

    /* renamed from: h */
    private Object f7418h = new Object();

    /* renamed from: i */
    private boolean f7419i;

    /* renamed from: j */
    private boolean f7420j;

    /* renamed from: k */
    private int f7421k = 0;

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo6004a(C0953vc vcVar);

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract boolean mo6007b(C0953vc vcVar);

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public abstract boolean mo6008c();

    public C0957vg() {
        setName("SpiSlaveThread");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:26|27|28|29|44|41|23) */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x004e, code lost:
        continue;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:28:0x005a */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo6021c(atakplugin.UASTool.C0953vc r5) {
        /*
            r4 = this;
        L_0x0000:
            int r0 = r4.f7421k
            r1 = 1
            if (r0 != r1) goto L_0x0061
            java.util.concurrent.locks.Lock r0 = r4.f7416f
            r0.lock()
            java.util.Queue<atakplugin.UASTool.vc> r0 = r4.f7415e
            int r0 = r0.size()
            r2 = 10
            r3 = 0
            if (r0 <= r2) goto L_0x0022
            java.util.concurrent.locks.Lock r5 = r4.f7416f
            r5.unlock()
            java.lang.String r5 = "FTDI"
            java.lang.String r0 = "SpiSlaveThread sendMessage Buffer full!!"
            android.util.Log.d(r5, r0)
            return r3
        L_0x0022:
            java.util.Queue<atakplugin.UASTool.vc> r0 = r4.f7415e
            r0.add(r5)
            java.util.Queue<atakplugin.UASTool.vc> r0 = r4.f7415e
            int r0 = r0.size()
            if (r0 != r1) goto L_0x003e
            java.lang.Object r0 = r4.f7417g
            monitor-enter(r0)
            r4.f7419i = r1     // Catch:{ all -> 0x003b }
            java.lang.Object r2 = r4.f7417g     // Catch:{ all -> 0x003b }
            r2.notify()     // Catch:{ all -> 0x003b }
            monitor-exit(r0)     // Catch:{ all -> 0x003b }
            goto L_0x003e
        L_0x003b:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x003b }
            throw r5
        L_0x003e:
            java.util.concurrent.locks.Lock r0 = r4.f7416f
            r0.unlock()
            boolean r5 = r5.mo6018e()
            if (r5 == 0) goto L_0x0060
            java.lang.Object r5 = r4.f7418h
            monitor-enter(r5)
            r4.f7420j = r3     // Catch:{ all -> 0x005d }
        L_0x004e:
            boolean r0 = r4.f7420j     // Catch:{ all -> 0x005d }
            if (r0 == 0) goto L_0x0054
            monitor-exit(r5)     // Catch:{ all -> 0x005d }
            goto L_0x0060
        L_0x0054:
            java.lang.Object r0 = r4.f7418h     // Catch:{ InterruptedException -> 0x005a }
            r0.wait()     // Catch:{ InterruptedException -> 0x005a }
            goto L_0x004e
        L_0x005a:
            r4.f7420j = r1     // Catch:{ all -> 0x005d }
            goto L_0x004e
        L_0x005d:
            r0 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x005d }
            throw r0
        L_0x0060:
            return r1
        L_0x0061:
            r0 = 100
            java.lang.Thread.sleep(r0)     // Catch:{ InterruptedException -> 0x0067 }
            goto L_0x0000
        L_0x0067:
            goto L_0x0000
        */
        throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.C0957vg.mo6021c(atakplugin.UASTool.vc):boolean");
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0041 */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0041 A[LOOP:1: B:11:0x0041->B:31:0x0041, LOOP_START, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r5 = this;
            r0 = 1
            r5.f7421k = r0
            r1 = 0
        L_0x0004:
            boolean r2 = java.lang.Thread.interrupted()
            if (r2 != 0) goto L_0x005c
            if (r1 == 0) goto L_0x000d
            goto L_0x005c
        L_0x000d:
            r5.mo6008c()
            java.util.concurrent.locks.Lock r2 = r5.f7416f
            r2.lock()
            java.util.Queue<atakplugin.UASTool.vc> r2 = r5.f7415e
            int r2 = r2.size()
            if (r2 > 0) goto L_0x0023
            java.util.concurrent.locks.Lock r2 = r5.f7416f
            r2.unlock()
            goto L_0x0004
        L_0x0023:
            java.util.Queue<atakplugin.UASTool.vc> r1 = r5.f7415e
            java.lang.Object r1 = r1.peek()
            atakplugin.UASTool.vc r1 = (atakplugin.UASTool.C0953vc) r1
            java.util.Queue<atakplugin.UASTool.vc> r2 = r5.f7415e
            r2.remove()
            java.util.concurrent.locks.Lock r2 = r5.f7416f
            r2.unlock()
            r5.mo6004a(r1)
            boolean r2 = r1.mo6018e()
            if (r2 == 0) goto L_0x0057
            java.lang.Object r2 = r5.f7418h
            monitor-enter(r2)
        L_0x0041:
            boolean r3 = r5.f7420j     // Catch:{ all -> 0x0054 }
            if (r3 != 0) goto L_0x004e
            r5.f7420j = r0     // Catch:{ all -> 0x0054 }
            java.lang.Object r3 = r5.f7418h     // Catch:{ all -> 0x0054 }
            r3.notify()     // Catch:{ all -> 0x0054 }
            monitor-exit(r2)     // Catch:{ all -> 0x0054 }
            goto L_0x0057
        L_0x004e:
            r3 = 100
            java.lang.Thread.sleep(r3)     // Catch:{ InterruptedException -> 0x0041 }
            goto L_0x0041
        L_0x0054:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0054 }
            throw r0
        L_0x0057:
            boolean r1 = r5.mo6007b(r1)
            goto L_0x0004
        L_0x005c:
            r0 = 2
            r5.f7421k = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.C0957vg.run():void");
    }
}
