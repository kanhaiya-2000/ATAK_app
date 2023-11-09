package atakplugin.UASTool;

import atakplugin.UASTool.brt;
import atakplugin.UASTool.bsb;
import atakplugin.UASTool.bsh;
import com.google.common.net.HttpHeaders;
import java.util.List;

public final class but implements brt {

    /* renamed from: a */
    private final brg f3968a;

    public but(brg brg) {
        this.f3968a = brg;
    }

    /* renamed from: a */
    public bsh mo3248a(brt.C0228a aVar) {
        bsb a = aVar.mo3249a();
        bsb.C0234a f = a.mo3350f();
        bsd d = a.mo3348d();
        if (d != null) {
            bru contentType = d.contentType();
            if (contentType != null) {
                f.mo3362a("Content-Type", contentType.toString());
            }
            long contentLength = d.contentLength();
            if (contentLength != -1) {
                f.mo3362a("Content-Length", Long.toString(contentLength));
                f.mo3366b(HttpHeaders.TRANSFER_ENCODING);
            } else {
                f.mo3362a(HttpHeaders.TRANSFER_ENCODING, "chunked");
                f.mo3366b("Content-Length");
            }
        }
        boolean z = false;
        if (a.mo3344a(HttpHeaders.HOST) == null) {
            f.mo3362a(HttpHeaders.HOST, bsp.m9150a(a.mo3343a(), false));
        }
        if (a.mo3344a("Connection") == null) {
            f.mo3362a("Connection", "Keep-Alive");
        }
        if (a.mo3344a(HttpHeaders.ACCEPT_ENCODING) == null) {
            z = true;
            f.mo3362a(HttpHeaders.ACCEPT_ENCODING, "gzip");
        }
        List<bre> a2 = this.f3968a.mo3131a(a.mo3343a());
        if (!a2.isEmpty()) {
            f.mo3362a("Cookie", m9724a(a2));
        }
        if (a.mo3344a("User-Agent") == null) {
            f.mo3362a("User-Agent", bsr.m9176a());
        }
        bsh a3 = aVar.mo3250a(f.mo3371d());
        bva.m9779a(this.f3968a, a.mo3343a(), a3.mo3383g());
        bsh.C0235a a4 = a3.mo3385i().mo3400a(a);
        if (z && "gzip".equalsIgnoreCase(a3.mo3377b(HttpHeaders.CONTENT_ENCODING)) && bva.m9786d(a3)) {
            bww bww = new bww(a3.mo3384h().mo3018c());
            brp a5 = a3.mo3383g().mo3174c().mo3185c(HttpHeaders.CONTENT_ENCODING).mo3185c("Content-Length").mo3182a();
            a4.mo3398a(a5);
            a4.mo3402a((bsj) new bve(a5, bxb.m10330a((bxr) bww)));
        }
        return a4.mo3405a();
    }

    /* renamed from: a */
    private String m9724a(List<bre> list) {
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                sb.append("; ");
            }
            bre bre = list.get(i);
            sb.append(bre.mo3109a());
            sb.append('=');
            sb.append(bre.mo3111b());
        }
        return sb.toString();
    }
}
