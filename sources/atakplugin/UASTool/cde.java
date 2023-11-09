package atakplugin.UASTool;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Stack;

public class cde implements cda {

    /* renamed from: e */
    private static final int f4515e = 20000;

    /* renamed from: f */
    private static final int f4516f = 100;

    /* renamed from: a */
    private Hashtable f4517a = new Hashtable();

    /* renamed from: b */
    private Thread f4518b;

    /* renamed from: c */
    private Stack f4519c;

    /* renamed from: d */
    private int f4520d = 0;

    /* renamed from: b */
    public void mo4499b() {
    }

    /* renamed from: a */
    public synchronized Stack mo4498a() {
        if (Thread.currentThread() != this.f4518b) {
            Thread currentThread = Thread.currentThread();
            this.f4518b = currentThread;
            Stack stack = (Stack) this.f4517a.get(currentThread);
            this.f4519c = stack;
            if (stack == null) {
                Stack stack2 = new Stack();
                this.f4519c = stack2;
                this.f4517a.put(this.f4518b, stack2);
            }
            this.f4520d++;
            if (this.f4520d > Math.max(100, f4515e / Math.max(1, this.f4517a.size()))) {
                Stack stack3 = new Stack();
                Enumeration keys = this.f4517a.keys();
                while (keys.hasMoreElements()) {
                    Thread thread = (Thread) keys.nextElement();
                    if (!thread.isAlive()) {
                        stack3.push(thread);
                    }
                }
                Enumeration elements = stack3.elements();
                while (elements.hasMoreElements()) {
                    this.f4517a.remove((Thread) elements.nextElement());
                }
                this.f4520d = 0;
            }
        }
        return this.f4519c;
    }
}
