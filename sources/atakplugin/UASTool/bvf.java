package atakplugin.UASTool;

import java.net.Proxy;

public final class bvf {
    private bvf() {
    }

    /* renamed from: a */
    static String m9809a(bsb bsb, Proxy.Type type) {
        StringBuilder sb = new StringBuilder();
        sb.append(bsb.mo3345b());
        sb.append(' ');
        if (m9810b(bsb, type)) {
            sb.append(bsb.mo3343a());
        } else {
            sb.append(m9808a(bsb.mo3343a()));
        }
        sb.append(" HTTP/1.1");
        return sb.toString();
    }

    /* renamed from: b */
    private static boolean m9810b(bsb bsb, Proxy.Type type) {
        return !bsb.mo3352h() && type == Proxy.Type.HTTP;
    }

    /* renamed from: a */
    public static String m9808a(brr brr) {
        String l = brr.mo3207l();
        String o = brr.mo3210o();
        if (o == null) {
            return l;
        }
        return l + '?' + o;
    }
}
