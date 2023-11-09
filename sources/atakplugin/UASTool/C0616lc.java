package atakplugin.UASTool;

import atakplugin.UASTool.C0556jc;
import atakplugin.UASTool.C0560jd;
import java.util.NoSuchElementException;

/* renamed from: atakplugin.UASTool.lc */
public class C0616lc extends C0560jd.C0563c {

    /* renamed from: a */
    private final C0556jc.C0559c f5188a;

    /* renamed from: b */
    private final C0436fn f5189b;

    /* renamed from: c */
    private boolean f5190c;

    /* renamed from: d */
    private boolean f5191d;

    /* renamed from: e */
    private long f5192e;

    public C0616lc(C0556jc.C0559c cVar, C0436fn fnVar) {
        this.f5188a = cVar;
        this.f5189b = fnVar;
    }

    public boolean hasNext() {
        if (!this.f5191d) {
            m12415b();
            this.f5191d = true;
        }
        return this.f5190c;
    }

    /* renamed from: a */
    public long mo3698a() {
        if (!this.f5191d) {
            this.f5190c = hasNext();
        }
        if (this.f5190c) {
            this.f5191d = false;
            return this.f5192e;
        }
        throw new NoSuchElementException();
    }

    /* renamed from: b */
    private void m12415b() {
        while (this.f5188a.hasNext()) {
            int b = this.f5188a.mo5012b();
            long longValue = this.f5188a.next().longValue();
            this.f5192e = longValue;
            if (this.f5189b.mo4918a(b, longValue)) {
                this.f5190c = true;
                return;
            }
        }
        this.f5190c = false;
    }
}
