package atakplugin.UASTool;

import com.atakmap.android.uastool.MAVLink.enums.MAV_CMD;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.Objects;

public final class bsl {

    /* renamed from: a */
    final bqj f3571a;

    /* renamed from: b */
    final Proxy f3572b;

    /* renamed from: c */
    final InetSocketAddress f3573c;

    public bsl(bqj bqj, Proxy proxy, InetSocketAddress inetSocketAddress) {
        Objects.requireNonNull(bqj, "address == null");
        Objects.requireNonNull(proxy, "proxy == null");
        Objects.requireNonNull(inetSocketAddress, "inetSocketAddress == null");
        this.f3571a = bqj;
        this.f3572b = proxy;
        this.f3573c = inetSocketAddress;
    }

    /* renamed from: a */
    public bqj mo3416a() {
        return this.f3571a;
    }

    /* renamed from: b */
    public Proxy mo3417b() {
        return this.f3572b;
    }

    /* renamed from: c */
    public InetSocketAddress mo3418c() {
        return this.f3573c;
    }

    /* renamed from: d */
    public boolean mo3419d() {
        return this.f3571a.f3157i != null && this.f3572b.type() == Proxy.Type.HTTP;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof bsl)) {
            return false;
        }
        bsl bsl = (bsl) obj;
        if (!this.f3571a.equals(bsl.f3571a) || !this.f3572b.equals(bsl.f3572b) || !this.f3573c.equals(bsl.f3573c)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((((MAV_CMD.MAV_CMD_REQUEST_CAMERA_CAPTURE_STATUS + this.f3571a.hashCode()) * 31) + this.f3572b.hashCode()) * 31) + this.f3573c.hashCode();
    }
}
