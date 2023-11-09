package atakplugin.UASTool;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

public final class btl {

    /* renamed from: a */
    private final bqj f3690a;

    /* renamed from: b */
    private final btj f3691b;

    /* renamed from: c */
    private Proxy f3692c;

    /* renamed from: d */
    private InetSocketAddress f3693d;

    /* renamed from: e */
    private List<Proxy> f3694e = Collections.emptyList();

    /* renamed from: f */
    private int f3695f;

    /* renamed from: g */
    private List<InetSocketAddress> f3696g = Collections.emptyList();

    /* renamed from: h */
    private int f3697h;

    /* renamed from: i */
    private final List<bsl> f3698i = new ArrayList();

    public btl(bqj bqj, btj btj) {
        this.f3690a = bqj;
        this.f3691b = btj;
        m9308a(bqj.mo2984a(), bqj.mo2992h());
    }

    /* renamed from: a */
    public boolean mo3481a() {
        return m9312e() || m9310c() || m9314g();
    }

    /* renamed from: b */
    public bsl mo3482b() {
        if (!m9312e()) {
            if (m9310c()) {
                this.f3692c = m9311d();
            } else if (m9314g()) {
                return m9315h();
            } else {
                throw new NoSuchElementException();
            }
        }
        InetSocketAddress f = m9313f();
        this.f3693d = f;
        bsl bsl = new bsl(this.f3690a, this.f3692c, f);
        if (!this.f3691b.mo3477c(bsl)) {
            return bsl;
        }
        this.f3698i.add(bsl);
        return mo3482b();
    }

    /* renamed from: a */
    public void mo3480a(bsl bsl, IOException iOException) {
        if (!(bsl.mo3417b().type() == Proxy.Type.DIRECT || this.f3690a.mo2991g() == null)) {
            this.f3690a.mo2991g().connectFailed(this.f3690a.mo2984a().mo3191b(), bsl.mo3417b().address(), iOException);
        }
        this.f3691b.mo3475a(bsl);
    }

    /* renamed from: a */
    private void m9308a(brr brr, Proxy proxy) {
        if (proxy != null) {
            this.f3694e = Collections.singletonList(proxy);
        } else {
            this.f3694e = new ArrayList();
            List<Proxy> select = this.f3690a.mo2991g().select(brr.mo3191b());
            if (select != null) {
                this.f3694e.addAll(select);
            }
            this.f3694e.removeAll(Collections.singleton(Proxy.NO_PROXY));
            this.f3694e.add(Proxy.NO_PROXY);
        }
        this.f3695f = 0;
    }

    /* renamed from: c */
    private boolean m9310c() {
        return this.f3695f < this.f3694e.size();
    }

    /* renamed from: d */
    private Proxy m9311d() {
        if (m9310c()) {
            List<Proxy> list = this.f3694e;
            int i = this.f3695f;
            this.f3695f = i + 1;
            Proxy proxy = list.get(i);
            m9309a(proxy);
            return proxy;
        }
        throw new SocketException("No route to " + this.f3690a.mo2984a().mo3204i() + "; exhausted proxy configurations: " + this.f3694e);
    }

    /* renamed from: a */
    private void m9309a(Proxy proxy) {
        String str;
        int i;
        this.f3696g = new ArrayList();
        if (proxy.type() == Proxy.Type.DIRECT || proxy.type() == Proxy.Type.SOCKS) {
            str = this.f3690a.mo2984a().mo3204i();
            i = this.f3690a.mo2984a().mo3205j();
        } else {
            SocketAddress address = proxy.address();
            if (address instanceof InetSocketAddress) {
                InetSocketAddress inetSocketAddress = (InetSocketAddress) address;
                str = m9307a(inetSocketAddress);
                i = inetSocketAddress.getPort();
            } else {
                throw new IllegalArgumentException("Proxy.address() is not an InetSocketAddress: " + address.getClass());
            }
        }
        if (i < 1 || i > 65535) {
            throw new SocketException("No route to " + str + ":" + i + "; port is out of range");
        }
        if (proxy.type() == Proxy.Type.SOCKS) {
            this.f3696g.add(InetSocketAddress.createUnresolved(str, i));
        } else {
            List<InetAddress> a = this.f3690a.mo2985b().mo3148a(str);
            int size = a.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.f3696g.add(new InetSocketAddress(a.get(i2), i));
            }
        }
        this.f3697h = 0;
    }

    /* renamed from: a */
    static String m9307a(InetSocketAddress inetSocketAddress) {
        InetAddress address = inetSocketAddress.getAddress();
        if (address == null) {
            return inetSocketAddress.getHostName();
        }
        return address.getHostAddress();
    }

    /* renamed from: e */
    private boolean m9312e() {
        return this.f3697h < this.f3696g.size();
    }

    /* renamed from: f */
    private InetSocketAddress m9313f() {
        if (m9312e()) {
            List<InetSocketAddress> list = this.f3696g;
            int i = this.f3697h;
            this.f3697h = i + 1;
            return list.get(i);
        }
        throw new SocketException("No route to " + this.f3690a.mo2984a().mo3204i() + "; exhausted inet socket addresses: " + this.f3696g);
    }

    /* renamed from: g */
    private boolean m9314g() {
        return !this.f3698i.isEmpty();
    }

    /* renamed from: h */
    private bsl m9315h() {
        return this.f3698i.remove(0);
    }
}
