package atakplugin.UASTool;

import atakplugin.UASTool.brp;
import atakplugin.UASTool.brt;
import atakplugin.UASTool.bsh;
import atakplugin.UASTool.bsw;
import com.google.common.net.HttpHeaders;
import java.io.Closeable;
import java.io.IOException;
import java.util.Date;

public final class bss implements brt {

    /* renamed from: b */
    private static final bsj f3589b = new bst();

    /* renamed from: a */
    final btf f3590a;

    public bss(btf btf) {
        this.f3590a = btf;
    }

    /* renamed from: a */
    public bsh mo3248a(brt.C0228a aVar) {
        btf btf = this.f3590a;
        bsh a = btf != null ? btf.mo3022a(aVar.mo3249a()) : null;
        bsw a2 = new bsw.C0236a(System.currentTimeMillis(), aVar.mo3249a(), a).mo3427a();
        bsb bsb = a2.f3596a;
        bsh bsh = a2.f3597b;
        btf btf2 = this.f3590a;
        if (btf2 != null) {
            btf2.mo3026a(a2);
        }
        if (a != null && bsh == null) {
            bsp.m9158a((Closeable) a.mo3384h());
        }
        if (bsb == null && bsh == null) {
            return new bsh.C0235a().mo3400a(aVar.mo3249a()).mo3399a(bry.HTTP_1_1).mo3395a(504).mo3403a("Unsatisfiable Request (only-if-cached)").mo3402a(f3589b).mo3396a(-1).mo3406b(System.currentTimeMillis()).mo3405a();
        }
        if (bsb == null) {
            return bsh.mo3385i().mo3407b(m9178a(bsh)).mo3405a();
        }
        try {
            bsh a3 = aVar.mo3250a(bsb);
            if (a3 == null && a != null) {
            }
            if (bsh != null) {
                if (m9181a(bsh, a3)) {
                    bsh a4 = bsh.mo3385i().mo3398a(m9177a(bsh.mo3383g(), a3.mo3383g())).mo3407b(m9178a(bsh)).mo3401a(m9178a(a3)).mo3405a();
                    a3.mo3384h().close();
                    this.f3590a.mo3024a();
                    this.f3590a.mo3025a(bsh, a4);
                    return a4;
                }
                bsp.m9158a((Closeable) bsh.mo3384h());
            }
            bsh a5 = a3.mo3385i().mo3407b(m9178a(bsh)).mo3401a(m9178a(a3)).mo3405a();
            if (bva.m9786d(a5)) {
                return m9179a(m9180a(a5, a3.mo3372a(), this.f3590a), a5);
            }
            return a5;
        } finally {
            if (a != null) {
                bsp.m9158a((Closeable) a.mo3384h());
            }
        }
    }

    /* renamed from: a */
    private static bsh m9178a(bsh bsh) {
        return (bsh == null || bsh.mo3384h() == null) ? bsh : bsh.mo3385i().mo3402a((bsj) null).mo3405a();
    }

    /* renamed from: a */
    private bsv m9180a(bsh bsh, bsb bsb, btf btf) {
        if (btf == null) {
            return null;
        }
        if (bsw.m9190a(bsh, bsb)) {
            return btf.mo3023a(bsh);
        }
        if (bvb.m9788a(bsb.mo3345b())) {
            try {
                btf.mo3027b(bsb);
            } catch (IOException unused) {
            }
        }
        return null;
    }

    /* renamed from: a */
    private bsh m9179a(bsv bsv, bsh bsh) {
        bxp b;
        if (bsv == null || (b = bsv.mo3015b()) == null) {
            return bsh;
        }
        return bsh.mo3385i().mo3402a((bsj) new bve(bsh.mo3383g(), bxb.m10330a((bxr) new bsu(this, bsh.mo3384h().mo3018c(), bsv, bxb.m10329a(b))))).mo3405a();
    }

    /* renamed from: a */
    private static boolean m9181a(bsh bsh, bsh bsh2) {
        Date b;
        if (bsh2.mo3378c() == 304) {
            return true;
        }
        Date b2 = bsh.mo3383g().mo3172b("Last-Modified");
        if (b2 == null || (b = bsh2.mo3383g().mo3172b("Last-Modified")) == null || b.getTime() >= b2.getTime()) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    private static brp m9177a(brp brp, brp brp2) {
        brp.C0225a aVar = new brp.C0225a();
        int a = brp.mo3168a();
        for (int i = 0; i < a; i++) {
            String a2 = brp.mo3169a(i);
            String b = brp.mo3171b(i);
            if ((!HttpHeaders.WARNING.equalsIgnoreCase(a2) || !b.startsWith("1")) && (!m9182a(a2) || brp2.mo3170a(a2) == null)) {
                bsn.f3580a.mo3330a(aVar, a2, b);
            }
        }
        int a3 = brp2.mo3168a();
        for (int i2 = 0; i2 < a3; i2++) {
            String a4 = brp2.mo3169a(i2);
            if (!"Content-Length".equalsIgnoreCase(a4) && m9182a(a4)) {
                bsn.f3580a.mo3330a(aVar, a4, brp2.mo3171b(i2));
            }
        }
        return aVar.mo3182a();
    }

    /* renamed from: a */
    static boolean m9182a(String str) {
        return !"Connection".equalsIgnoreCase(str) && !"Keep-Alive".equalsIgnoreCase(str) && !HttpHeaders.PROXY_AUTHENTICATE.equalsIgnoreCase(str) && !HttpHeaders.PROXY_AUTHORIZATION.equalsIgnoreCase(str) && !HttpHeaders.f8597TE.equalsIgnoreCase(str) && !"Trailers".equalsIgnoreCase(str) && !HttpHeaders.TRANSFER_ENCODING.equalsIgnoreCase(str) && !HttpHeaders.UPGRADE.equalsIgnoreCase(str);
    }
}
