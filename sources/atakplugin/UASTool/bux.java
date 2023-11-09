package atakplugin.UASTool;

import atakplugin.UASTool.brp;
import atakplugin.UASTool.bsh;
import com.autel.util.okhttp.model.Headers;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public final class bux implements bvc {

    /* renamed from: b */
    private static final bwq f4001b;

    /* renamed from: c */
    private static final bwq f4002c;

    /* renamed from: d */
    private static final bwq f4003d;

    /* renamed from: e */
    private static final bwq f4004e;

    /* renamed from: f */
    private static final bwq f4005f;

    /* renamed from: g */
    private static final bwq f4006g;

    /* renamed from: h */
    private static final bwq f4007h;

    /* renamed from: i */
    private static final bwq f4008i;

    /* renamed from: j */
    private static final List<bwq> f4009j;

    /* renamed from: k */
    private static final List<bwq> f4010k;

    /* renamed from: l */
    private static final List<bwq> f4011l;

    /* renamed from: m */
    private static final List<bwq> f4012m;

    /* renamed from: n */
    private final brw f4013n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public final btm f4014o;

    /* renamed from: p */
    private final btq f4015p;

    /* renamed from: q */
    private buc f4016q;

    static {
        bwq b = bwq.m10196b("connection");
        f4001b = b;
        bwq b2 = bwq.m10196b("host");
        f4002c = b2;
        bwq b3 = bwq.m10196b(Headers.HEAD_VALUE_CONNECTION_KEEP_ALIVE);
        f4003d = b3;
        bwq b4 = bwq.m10196b("proxy-connection");
        f4004e = b4;
        bwq b5 = bwq.m10196b("transfer-encoding");
        f4005f = b5;
        bwq b6 = bwq.m10196b("te");
        f4006g = b6;
        bwq b7 = bwq.m10196b("encoding");
        f4007h = b7;
        bwq b8 = bwq.m10196b("upgrade");
        f4008i = b8;
        f4009j = bsp.m9154a((T[]) new bwq[]{b, b2, b3, b4, b5, bue.f3828b, bue.f3829c, bue.f3830d, bue.f3831e, bue.f3832f, bue.f3833g});
        f4010k = bsp.m9154a((T[]) new bwq[]{b, b2, b3, b4, b5});
        f4011l = bsp.m9154a((T[]) new bwq[]{b, b2, b3, b4, b6, b5, b7, b8, bue.f3828b, bue.f3829c, bue.f3830d, bue.f3831e, bue.f3832f, bue.f3833g});
        f4012m = bsp.m9154a((T[]) new bwq[]{b, b2, b3, b4, b6, b5, b7, b8});
    }

    public bux(brw brw, btm btm, btq btq) {
        this.f4013n = brw;
        this.f4014o = btm;
        this.f4015p = btq;
    }

    /* renamed from: a */
    public bxp mo3682a(bsb bsb, long j) {
        return this.f4016q.mo3610k();
    }

    /* renamed from: a */
    public void mo3686a(bsb bsb) {
        List<bue> list;
        if (this.f4016q == null) {
            boolean c = bvb.m9790c(bsb.mo3345b());
            if (this.f4015p.mo3521a() == bry.HTTP_2) {
                list = m9761c(bsb);
            } else {
                list = m9760b(bsb);
            }
            buc a = this.f4015p.mo3524a(list, c, true);
            this.f4016q = a;
            a.mo3607h().mo3984a((long) this.f4013n.mo3272b(), TimeUnit.MILLISECONDS);
            this.f4016q.mo3608i().mo3984a((long) this.f4013n.mo3273c(), TimeUnit.MILLISECONDS);
        }
    }

    /* renamed from: d */
    public void mo3690d() {
        this.f4016q.mo3610k().close();
    }

    /* renamed from: b */
    public bsh.C0235a mo3687b() {
        if (this.f4015p.mo3521a() == bry.HTTP_2) {
            return m9759b(this.f4016q.mo3605f());
        }
        return m9756a(this.f4016q.mo3605f());
    }

    /* renamed from: b */
    public static List<bue> m9760b(bsb bsb) {
        brp c = bsb.mo3347c();
        ArrayList arrayList = new ArrayList(c.mo3168a() + 5);
        arrayList.add(new bue(bue.f3828b, bsb.mo3345b()));
        arrayList.add(new bue(bue.f3829c, bvf.m9808a(bsb.mo3343a())));
        arrayList.add(new bue(bue.f3833g, "HTTP/1.1"));
        arrayList.add(new bue(bue.f3832f, bsp.m9150a(bsb.mo3343a(), false)));
        arrayList.add(new bue(bue.f3830d, bsb.mo3343a().mo3192c()));
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        int a = c.mo3168a();
        for (int i = 0; i < a; i++) {
            bwq b = bwq.m10196b(c.mo3169a(i).toLowerCase(Locale.US));
            if (!f4009j.contains(b)) {
                String b2 = c.mo3171b(i);
                if (linkedHashSet.add(b)) {
                    arrayList.add(new bue(b, b2));
                } else {
                    int i2 = 0;
                    while (true) {
                        if (i2 >= arrayList.size()) {
                            break;
                        } else if (((bue) arrayList.get(i2)).f3834h.equals(b)) {
                            arrayList.set(i2, new bue(b, m9758a(((bue) arrayList.get(i2)).f3835i.mo3929c(), b2)));
                            break;
                        } else {
                            i2++;
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private static String m9758a(String str, String str2) {
        return str + 0 + str2;
    }

    /* renamed from: c */
    public static List<bue> m9761c(bsb bsb) {
        brp c = bsb.mo3347c();
        ArrayList arrayList = new ArrayList(c.mo3168a() + 4);
        arrayList.add(new bue(bue.f3828b, bsb.mo3345b()));
        arrayList.add(new bue(bue.f3829c, bvf.m9808a(bsb.mo3343a())));
        arrayList.add(new bue(bue.f3831e, bsp.m9150a(bsb.mo3343a(), false)));
        arrayList.add(new bue(bue.f3830d, bsb.mo3343a().mo3192c()));
        int a = c.mo3168a();
        for (int i = 0; i < a; i++) {
            bwq b = bwq.m10196b(c.mo3169a(i).toLowerCase(Locale.US));
            if (!f4011l.contains(b)) {
                arrayList.add(new bue(b, c.mo3171b(i)));
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public static bsh.C0235a m9756a(List<bue> list) {
        brp.C0225a aVar = new brp.C0225a();
        int size = list.size();
        String str = null;
        String str2 = "HTTP/1.1";
        for (int i = 0; i < size; i++) {
            bwq bwq = list.get(i).f3834h;
            String c = list.get(i).f3835i.mo3929c();
            int i2 = 0;
            while (i2 < c.length()) {
                int indexOf = c.indexOf(0, i2);
                if (indexOf == -1) {
                    indexOf = c.length();
                }
                String substring = c.substring(i2, indexOf);
                if (bwq.equals(bue.f3827a)) {
                    str = substring;
                } else if (bwq.equals(bue.f3833g)) {
                    str2 = substring;
                } else if (!f4010k.contains(bwq)) {
                    bsn.f3580a.mo3330a(aVar, bwq.mo3929c(), substring);
                }
                i2 = indexOf + 1;
            }
        }
        if (str != null) {
            bvh a = bvh.m9824a(str2 + " " + str);
            return new bsh.C0235a().mo3399a(bry.SPDY_3).mo3395a(a.f4041e).mo3403a(a.f4042f).mo3398a(aVar.mo3182a());
        }
        throw new ProtocolException("Expected ':status' header not present");
    }

    /* renamed from: b */
    public static bsh.C0235a m9759b(List<bue> list) {
        brp.C0225a aVar = new brp.C0225a();
        int size = list.size();
        String str = null;
        for (int i = 0; i < size; i++) {
            bwq bwq = list.get(i).f3834h;
            String c = list.get(i).f3835i.mo3929c();
            if (bwq.equals(bue.f3827a)) {
                str = c;
            } else if (!f4012m.contains(bwq)) {
                bsn.f3580a.mo3330a(aVar, bwq.mo3929c(), c);
            }
        }
        if (str != null) {
            bvh a = bvh.m9824a("HTTP/1.1 " + str);
            return new bsh.C0235a().mo3399a(bry.HTTP_2).mo3395a(a.f4041e).mo3403a(a.f4042f).mo3398a(aVar.mo3182a());
        }
        throw new ProtocolException("Expected ':status' header not present");
    }

    /* renamed from: a */
    public bsj mo3680a(bsh bsh) {
        return new bve(bsh.mo3383g(), bxb.m10330a((bxr) new C0264a(this.f4016q.mo3609j())));
    }

    /* renamed from: a */
    public void mo3684a() {
        buc buc = this.f4016q;
        if (buc != null) {
            buc.mo3599b(btn.CANCEL);
        }
    }

    /* renamed from: atakplugin.UASTool.bux$a */
    class C0264a extends bwt {
        public C0264a(bxr bxr) {
            super(bxr);
        }

        public void close() {
            bux.this.f4014o.mo3487a(false, (bvc) bux.this);
            super.close();
        }
    }
}
