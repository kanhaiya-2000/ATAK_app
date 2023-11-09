package atakplugin.UASTool;

import android.util.Log;
import atakplugin.UASTool.C0915uj;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: atakplugin.UASTool.up */
public class C0938up implements C0950va {

    /* renamed from: d */
    private static final String f7333d = "FTDI_Device::";

    /* renamed from: a */
    private C0933uk f7334a;

    /* renamed from: b */
    private C0879tj f7335b;

    /* renamed from: c */
    private Lock f7336c = new ReentrantLock();

    public C0938up(C0933uk ukVar) {
        this.f7334a = ukVar;
        this.f7335b = ukVar.f7308b;
    }

    /* renamed from: a */
    public int mo5994a() {
        C0940ur urVar = this.f7334a.f7309c;
        C0939uq uqVar = this.f7334a.f7310d;
        uqVar.f7337a = 1;
        uqVar.f7338b = 2;
        int i = 0;
        uqVar.f7339c = 0;
        uqVar.f7340d = 0;
        uqVar.f7341e = 1;
        this.f7336c.lock();
        this.f7334a.mo5939b();
        if (this.f7335b.mo5833a(33, (uqVar.f7337a << 8) | 66) < 0) {
            i = 4;
        }
        if (this.f7335b.mo5833a(33, (uqVar.f7338b << 8) | 68) < 0) {
            i = 4;
        }
        if (this.f7335b.mo5833a(33, (uqVar.f7339c << 8) | 69) < 0) {
            i = 4;
        }
        if (this.f7335b.mo5833a(33, (uqVar.f7340d << 8) | 70) < 0) {
            i = 4;
        }
        if (this.f7335b.mo5833a(33, 67) < 0) {
            i = 4;
        }
        if (this.f7335b.mo5833a(33, (uqVar.f7341e << 8) | 72) < 0) {
            i = 4;
        }
        if (this.f7335b.mo5833a(33, 1029) < 0) {
            i = 4;
        }
        this.f7336c.unlock();
        urVar.f7348g = 4;
        return i;
    }

    /* renamed from: a */
    public int mo5997a(int[] iArr) {
        if (iArr == null) {
            return C0915uj.C0923h.f7213D;
        }
        int c = m14163c();
        if (c != 0) {
            return c;
        }
        this.f7336c.lock();
        int l = this.f7335b.mo5870l();
        this.f7336c.unlock();
        if (l >= 0) {
            iArr[0] = l;
            return 0;
        }
        iArr[0] = -1;
        return 4;
    }

    /* renamed from: a */
    public int mo5996a(byte[] bArr, int i, int[] iArr) {
        this.f7336c.lock();
        C0879tj tjVar = this.f7335b;
        if (tjVar == null || !tjVar.mo5864f()) {
            this.f7336c.unlock();
            return 3;
        }
        int a = this.f7335b.mo5837a(bArr, i);
        this.f7336c.unlock();
        iArr[0] = a;
        if (a >= 0) {
            return 0;
        }
        return 4;
    }

    /* renamed from: b */
    public int mo5999b(byte[] bArr, int i, int[] iArr) {
        if (iArr == null || bArr == null) {
            return C0915uj.C0923h.f7213D;
        }
        int c = m14163c();
        if (c != 0) {
            return c;
        }
        if (i > 512) {
            return C0915uj.C0923h.f7214E;
        }
        this.f7336c.lock();
        iArr[0] = this.f7335b.mo5856b(bArr, i);
        this.f7336c.unlock();
        if (iArr[0] == i) {
            return c;
        }
        Log.e(f7333d, "Error write =" + i + " tx=" + iArr[0]);
        return 4;
    }

    /* renamed from: c */
    private int m14163c() {
        if (this.f7334a.f7309c.f7348g != 4) {
            return C0915uj.C0923h.f7249x;
        }
        return 0;
    }

    /* renamed from: b */
    public int mo5998b() {
        this.f7336c.lock();
        int i = this.f7335b.mo5833a(33, 74) < 0 ? 4 : 0;
        this.f7336c.unlock();
        return i;
    }

    /* renamed from: a */
    public int mo5995a(int i, int i2, int i3) {
        C0940ur urVar = this.f7334a.f7309c;
        int i4 = 3;
        int i5 = 4;
        if (urVar.f7348g != 3 && urVar.f7348g != 4) {
            return C0915uj.C0923h.f7249x;
        }
        int i6 = (i << 4) | (i2 << 2) | i3;
        if (urVar.f7348g != 3) {
            i4 = 4;
        }
        this.f7336c.lock();
        int i7 = this.f7335b.mo5833a(33, (i6 << 8) | 160) < 0 ? 4 : 0;
        if (this.f7335b.mo5833a(33, (i4 << 8) | 5) >= 0) {
            i5 = i7;
        }
        this.f7336c.unlock();
        return i5;
    }
}
