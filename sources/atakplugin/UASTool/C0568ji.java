package atakplugin.UASTool;

import atakplugin.UASTool.C0556jc;
import atakplugin.UASTool.C0560jd;
import java.util.NoSuchElementException;

/* renamed from: atakplugin.UASTool.ji */
public class C0568ji extends C0560jd.C0561a {

    /* renamed from: a */
    private final C0556jc.C0557a f5068a;

    /* renamed from: b */
    private final C0409ev f5069b;

    /* renamed from: c */
    private boolean f5070c;

    /* renamed from: d */
    private boolean f5071d;

    /* renamed from: e */
    private double f5072e;

    public C0568ji(C0556jc.C0557a aVar, C0409ev evVar) {
        this.f5068a = aVar;
        this.f5069b = evVar;
    }

    public boolean hasNext() {
        if (!this.f5071d) {
            m12361b();
            this.f5071d = true;
        }
        return this.f5070c;
    }

    /* renamed from: a */
    public double mo2515a() {
        if (!this.f5071d) {
            this.f5070c = hasNext();
        }
        if (this.f5070c) {
            this.f5071d = false;
            return this.f5072e;
        }
        throw new NoSuchElementException();
    }

    /* renamed from: b */
    private void m12361b() {
        while (this.f5068a.hasNext()) {
            int b = this.f5068a.mo5008b();
            double doubleValue = this.f5068a.next().doubleValue();
            this.f5072e = doubleValue;
            if (this.f5069b.mo4910a(b, doubleValue)) {
                this.f5070c = true;
                return;
            }
        }
        this.f5070c = false;
    }
}
