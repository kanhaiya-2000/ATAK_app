package atakplugin.UASTool;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class amj implements alw {

    /* renamed from: a */
    public static Map<Long, amj> f2084a = Collections.synchronizedMap(new HashMap());

    /* renamed from: b */
    private byte f2085b;

    /* renamed from: c */
    private byte f2086c;

    /* renamed from: d */
    private byte f2087d;

    /* renamed from: e */
    private byte f2088e;

    /* renamed from: f */
    private byte f2089f;

    /* renamed from: g */
    private boolean f2090g;

    /* renamed from: h */
    private int f2091h;

    /* renamed from: a */
    public static amj m2416a(byte b, byte b2, byte b3, byte b4, byte b5, boolean z, int i) {
        long j = ((long) ((b2 << 2) + b + (b3 << 4) + (b4 << 6))) + ((long) (b5 << 8)) + ((long) (i << 11)) + ((long) ((z ? 1 : 0) << true));
        amj amj = f2084a.get(Long.valueOf(j));
        if (amj != null) {
            return amj;
        }
        amj amj2 = new amj();
        amj2.f2085b = b;
        amj2.f2086c = b2;
        amj2.f2087d = b3;
        amj2.f2088e = b4;
        amj2.f2089f = b5;
        amj2.f2090g = z;
        amj2.f2091h = i;
        f2084a.put(Long.valueOf(j), amj2);
        return amj2;
    }

    /* renamed from: a */
    public byte mo1479a() {
        return this.f2085b;
    }

    /* renamed from: a */
    public void mo1480a(byte b) {
        this.f2085b = b;
    }

    /* renamed from: b */
    public byte mo1483b() {
        return this.f2086c;
    }

    /* renamed from: b */
    public void mo1484b(byte b) {
        this.f2086c = b;
    }

    /* renamed from: c */
    public byte mo1485c() {
        return this.f2087d;
    }

    /* renamed from: c */
    public void mo1486c(byte b) {
        this.f2087d = b;
    }

    /* renamed from: d */
    public byte mo1487d() {
        return this.f2088e;
    }

    /* renamed from: d */
    public void mo1488d(byte b) {
        this.f2088e = b;
    }

    /* renamed from: e */
    public byte mo1489e() {
        return this.f2089f;
    }

    /* renamed from: e */
    public void mo1490e(byte b) {
        this.f2089f = b;
    }

    /* renamed from: f */
    public boolean mo1491f() {
        return this.f2090g;
    }

    /* renamed from: g */
    public boolean mo1492g() {
        return !this.f2090g;
    }

    /* renamed from: a */
    public void mo1482a(boolean z) {
        this.f2090g = z;
    }

    /* renamed from: h */
    public int mo1493h() {
        return this.f2091h;
    }

    /* renamed from: a */
    public void mo1481a(int i) {
        this.f2091h = i;
    }
}
