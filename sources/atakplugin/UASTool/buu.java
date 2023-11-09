package atakplugin.UASTool;

import atakplugin.UASTool.brt;
import com.autel.util.okhttp.model.Headers;
import java.net.ProtocolException;

public final class buu implements brt {

    /* renamed from: a */
    private final boolean f3969a;

    public buu(boolean z) {
        this.f3969a = z;
    }

    /* renamed from: a */
    public bsh mo3248a(brt.C0228a aVar) {
        bvd bvd = (bvd) aVar;
        bvc d = bvd.mo3702d();
        btm c = bvd.mo3701c();
        bsb a = aVar.mo3249a();
        long currentTimeMillis = System.currentTimeMillis();
        d.mo3686a(a);
        if (bvb.m9790c(a.mo3345b()) && a.mo3348d() != null) {
            bwo a2 = bxb.m10329a(d.mo3682a(a, a.mo3348d().contentLength()));
            a.mo3348d().writeTo(a2);
            a2.close();
        }
        d.mo3690d();
        bsh a3 = d.mo3687b().mo3400a(a).mo3397a(c.mo3488b().mo3082c()).mo3396a(currentTimeMillis).mo3406b(System.currentTimeMillis()).mo3405a();
        if (!this.f3969a || a3.mo3378c() != 101) {
            a3 = a3.mo3385i().mo3402a(d.mo3680a(a3)).mo3405a();
        }
        if (Headers.HEAD_VALUE_CONNECTION_CLOSE.equalsIgnoreCase(a3.mo3372a().mo3344a("Connection")) || Headers.HEAD_VALUE_CONNECTION_CLOSE.equalsIgnoreCase(a3.mo3377b("Connection"))) {
            c.mo3490d();
        }
        int c2 = a3.mo3378c();
        if ((c2 != 204 && c2 != 205) || a3.mo3384h().mo3017b() <= 0) {
            return a3;
        }
        throw new ProtocolException("HTTP " + c2 + " had non-zero Content-Length: " + a3.mo3384h().mo3017b());
    }
}
