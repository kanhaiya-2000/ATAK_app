package atakplugin.UASTool;

import java.util.LinkedHashSet;
import java.util.Set;

public final class btj {

    /* renamed from: a */
    private final Set<bsl> f3687a = new LinkedHashSet();

    /* renamed from: a */
    public synchronized void mo3475a(bsl bsl) {
        this.f3687a.add(bsl);
    }

    /* renamed from: b */
    public synchronized void mo3476b(bsl bsl) {
        this.f3687a.remove(bsl);
    }

    /* renamed from: c */
    public synchronized boolean mo3477c(bsl bsl) {
        return this.f3687a.contains(bsl);
    }
}
