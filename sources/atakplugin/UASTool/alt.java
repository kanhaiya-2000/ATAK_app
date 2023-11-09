package atakplugin.UASTool;

import java.util.HashMap;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public abstract class alt implements amc {

    /* renamed from: a */
    protected BlockingQueue<ama> f2048a = new ArrayBlockingQueue(1000);

    /* renamed from: b */
    protected C0755pw f2049b;

    /* renamed from: c */
    protected C0737pi f2050c;

    /* renamed from: d */
    protected HashMap<Class<? extends amd>, amd> f2051d = new HashMap<>();

    /* renamed from: b */
    public boolean mo1430b() {
        return false;
    }

    public alt() {
        C0755pw pwVar = new C0755pw();
        this.f2049b = pwVar;
        pwVar.mo5382a(1);
    }

    /* renamed from: a */
    public BlockingQueue<ama> mo1427a() {
        return this.f2048a;
    }

    /* renamed from: c */
    public C0755pw mo1431c() {
        return this.f2049b;
    }

    /* renamed from: d */
    public C0737pi mo1432d() {
        return this.f2050c;
    }

    /* renamed from: a */
    public <T extends amd> T mo1426a(Class<T> cls) {
        return (amd) this.f2051d.get(cls);
    }

    /* renamed from: a */
    public void mo1428a(amd amd) {
        this.f2051d.put(amd.getClass(), amd);
    }

    /* renamed from: b */
    public void mo1429b(Class<? extends amd> cls) {
        this.f2051d.remove(cls);
    }
}
