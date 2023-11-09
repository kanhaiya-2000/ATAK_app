package atakplugin.UASTool;

import android.content.Intent;
import android.util.Log;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import atakplugin.UASTool.C0870td;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: atakplugin.UASTool.ue */
class C0910ue {

    /* renamed from: a */
    private static final byte f7087a = 64;

    /* renamed from: b */
    private static final int f7088b = 512;

    /* renamed from: c */
    private static final byte f7089c = 2;

    /* renamed from: d */
    private static final int f7090d = 256;

    /* renamed from: e */
    private Semaphore[] f7091e;

    /* renamed from: f */
    private Semaphore[] f7092f;

    /* renamed from: g */
    private C0909ud[] f7093g;

    /* renamed from: h */
    private ByteBuffer f7094h;

    /* renamed from: i */
    private ByteBuffer[] f7095i;

    /* renamed from: j */
    private Pipe f7096j;

    /* renamed from: k */
    private Pipe.SinkChannel f7097k;

    /* renamed from: l */
    private Pipe.SourceChannel f7098l;

    /* renamed from: m */
    private int f7099m;

    /* renamed from: n */
    private int f7100n;

    /* renamed from: o */
    private Object f7101o;

    /* renamed from: p */
    private C0879tj f7102p;

    /* renamed from: q */
    private C0870td.C0872b f7103q;

    /* renamed from: r */
    private Lock f7104r;

    /* renamed from: s */
    private Condition f7105s;

    /* renamed from: t */
    private boolean f7106t;

    /* renamed from: u */
    private Lock f7107u;

    /* renamed from: v */
    private Condition f7108v;

    /* renamed from: w */
    private Object f7109w;

    /* renamed from: x */
    private int f7110x = this.f7102p.mo5832D();

    public C0910ue(C0879tj tjVar) {
        this.f7102p = tjVar;
        C0870td.C0872b d = tjVar.mo5862d();
        this.f7103q = d;
        this.f7099m = d.mo5823c();
        int a = this.f7103q.mo5819a();
        int i = this.f7099m;
        this.f7091e = new Semaphore[i];
        this.f7092f = new Semaphore[i];
        this.f7093g = new C0909ud[i];
        this.f7095i = new ByteBuffer[256];
        ReentrantLock reentrantLock = new ReentrantLock();
        this.f7104r = reentrantLock;
        this.f7105s = reentrantLock.newCondition();
        this.f7106t = false;
        ReentrantLock reentrantLock2 = new ReentrantLock();
        this.f7107u = reentrantLock2;
        this.f7108v = reentrantLock2.newCondition();
        this.f7101o = new Object();
        this.f7109w = new Object();
        m14085h();
        this.f7094h = ByteBuffer.allocateDirect(a);
        try {
            Pipe open = Pipe.open();
            this.f7096j = open;
            this.f7097k = open.sink();
            this.f7098l = this.f7096j.source();
        } catch (IOException e) {
            Log.d("ProcessInCtrl", "Create mMainPipe failed!");
            e.printStackTrace();
        }
        for (int i2 = 0; i2 < this.f7099m; i2++) {
            this.f7093g[i2] = new C0909ud(a);
            this.f7092f[i2] = new Semaphore(1);
            this.f7091e[i2] = new Semaphore(1);
            try {
                mo5928c(i2);
            } catch (Exception e2) {
                Log.d("ProcessInCtrl", "Acquire read buffer " + i2 + " failed!");
                e2.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo5924a() {
        return this.f7106t;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public C0870td.C0872b mo5925b() {
        return this.f7103q;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C0909ud mo5922a(int i) {
        C0909ud udVar;
        synchronized (this.f7093g) {
            if (i >= 0) {
                if (i < this.f7099m) {
                    udVar = this.f7093g[i];
                }
            }
            udVar = null;
        }
        return udVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public C0909ud mo5926b(int i) {
        this.f7091e[i].acquire();
        C0909ud a = mo5922a(i);
        if (a.mo5916c(i) == null) {
            return null;
        }
        return a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public C0909ud mo5928c(int i) {
        this.f7092f[i].acquire();
        return mo5922a(i);
    }

    /* renamed from: d */
    public void mo5930d(int i) {
        synchronized (this.f7093g) {
            this.f7093g[i].mo5918d(i);
        }
        this.f7091e[i].release();
    }

    /* renamed from: e */
    public void mo5932e(int i) {
        this.f7092f[i].release();
    }

    /* renamed from: a */
    public void mo5923a(C0909ud udVar) {
        int d;
        int i;
        try {
            int c = udVar.mo5915c();
            if (c < 2) {
                udVar.mo5913b().clear();
                return;
            }
            synchronized (this.f7109w) {
                d = mo5929d();
                i = c - 2;
                if (d < i) {
                    Log.d("ProcessBulkIn::", " Buffer is full, waiting for read....");
                    mo5920a(false, 0, 0);
                    this.f7104r.lock();
                    this.f7106t = true;
                }
            }
            if (d < i) {
                this.f7105s.await();
                this.f7104r.unlock();
            }
            m14082b(udVar);
        } catch (InterruptedException e) {
            this.f7104r.unlock();
            Log.e("ProcessInCtrl", "Exception in Full await!");
            e.printStackTrace();
        } catch (Exception e2) {
            Log.e("ProcessInCtrl", "Exception in ProcessBulkIN");
            e2.printStackTrace();
            throw new C0870td.C0871a("Fatal error in BulkIn.");
        }
    }

    /* renamed from: b */
    private void m14082b(C0909ud udVar) {
        int i;
        short s;
        int i2;
        ByteBuffer b = udVar.mo5913b();
        int c = udVar.mo5915c();
        if (c > 0) {
            int i3 = this.f7110x;
            boolean z = true;
            int i4 = (c / i3) + (c % i3 > 0 ? 1 : 0);
            int i5 = 0;
            int i6 = 0;
            short s2 = 0;
            short s3 = 0;
            while (i5 < i4) {
                if (i5 == i4 - 1) {
                    b.limit(c);
                    int i7 = this.f7110x * i5;
                    b.position(i7);
                    short s4 = (short) (b.get() & 240);
                    s = (short) (this.f7102p.f6672g.f6638k ^ s4);
                    this.f7102p.f6672g.f6638k = s4;
                    this.f7102p.f6672g.f6639l = (short) (b.get() & 255);
                    i2 = i7 + 2;
                    if (b.hasRemaining()) {
                        s3 = (short) (this.f7102p.f6672g.f6639l & 30);
                        i = c;
                    } else {
                        i = c;
                        s3 = 0;
                    }
                } else {
                    int i8 = (i5 + 1) * this.f7110x;
                    b.limit(i8);
                    int i9 = (this.f7110x * i5) + 2;
                    b.position(i9);
                    int i10 = i8;
                    s = s2;
                    i2 = i9;
                    i = i10;
                }
                i6 += i - i2;
                this.f7095i[i5] = b.slice();
                i5++;
                s2 = s;
            }
            if (i6 != 0) {
                try {
                    long write = this.f7097k.write(this.f7095i, 0, i4);
                    if (write != ((long) i6)) {
                        Log.d("extractReadData::", "written != totalData, written= " + write + " totalData=" + i6);
                    }
                    m14083f((int) write);
                    this.f7107u.lock();
                    this.f7108v.signalAll();
                    this.f7107u.unlock();
                } catch (Exception e) {
                    Log.d("extractReadData::", "Write data to sink failed!!");
                    e.printStackTrace();
                }
            } else {
                z = false;
            }
            b.clear();
            mo5920a(z, s2, s3);
        }
    }

    /* renamed from: a */
    public int mo5921a(byte[] bArr, int i, long j) {
        this.f7103q.mo5819a();
        long currentTimeMillis = System.currentTimeMillis();
        ByteBuffer wrap = ByteBuffer.wrap(bArr, 0, i);
        if (j == 0) {
            j = (long) this.f7103q.mo5825d();
        }
        while (this.f7102p.mo5864f()) {
            if (mo5927c() < i) {
                try {
                    this.f7107u.lock();
                    this.f7108v.await(System.currentTimeMillis() - currentTimeMillis, TimeUnit.MILLISECONDS);
                    this.f7107u.unlock();
                } catch (InterruptedException e) {
                    Log.d("readBulkInData::", "Cannot wait to read data!!");
                    e.printStackTrace();
                    this.f7107u.unlock();
                }
                if (System.currentTimeMillis() - currentTimeMillis >= j) {
                    break;
                }
            } else {
                synchronized (this.f7098l) {
                    try {
                        this.f7098l.read(wrap);
                        m14084g(i);
                    } catch (Exception e2) {
                        Log.d("readBulkInData::", "Cannot read data from Source!!");
                        e2.printStackTrace();
                    }
                }
                synchronized (this.f7109w) {
                    if (this.f7106t) {
                        Log.i("FTDI debug::", "buffer is full , and also re start buffer");
                        this.f7104r.lock();
                        this.f7105s.signalAll();
                        this.f7106t = false;
                        this.f7104r.unlock();
                    }
                }
                return i;
            }
        }
        return 0;
    }

    /* renamed from: f */
    private int m14083f(int i) {
        int i2;
        synchronized (this.f7101o) {
            i2 = this.f7100n + i;
            this.f7100n = i2;
        }
        return i2;
    }

    /* renamed from: g */
    private int m14084g(int i) {
        int i2;
        synchronized (this.f7101o) {
            i2 = this.f7100n - i;
            this.f7100n = i2;
        }
        return i2;
    }

    /* renamed from: h */
    private void m14085h() {
        synchronized (this.f7101o) {
            this.f7100n = 0;
        }
    }

    /* renamed from: c */
    public int mo5927c() {
        int i;
        synchronized (this.f7101o) {
            i = this.f7100n;
        }
        return i;
    }

    /* renamed from: d */
    public int mo5929d() {
        return (this.f7103q.mo5819a() - mo5927c()) - 1;
    }

    /* renamed from: e */
    public int mo5931e() {
        int read;
        int c = this.f7103q.mo5823c();
        synchronized (this.f7094h) {
            do {
                try {
                    this.f7098l.configureBlocking(false);
                    read = this.f7098l.read(this.f7094h);
                    this.f7094h.clear();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } while (read != 0);
            m14085h();
            for (int i = 0; i < c; i++) {
                C0909ud a = mo5922a(i);
                if (a.mo5919e() && a.mo5915c() > 2) {
                    a.mo5917d();
                }
            }
        }
        return 0;
    }

    /* renamed from: a */
    public int mo5920a(boolean z, short s, short s2) {
        C0912ug ugVar = new C0912ug();
        ugVar.f7114b = this.f7102p.f6674i.f7114b;
        if (z && (ugVar.f7114b & 1) != 0 && (this.f7102p.f6666a ^ 1) == 1) {
            this.f7102p.f6666a |= 1;
            Intent intent = new Intent("FT_EVENT_RXCHAR");
            intent.putExtra("message", "FT_EVENT_RXCHAR");
            LocalBroadcastManager.getInstance(this.f7102p.f6675j).sendBroadcast(intent);
        }
        if (!(s == 0 || (ugVar.f7114b & 2) == 0 || (this.f7102p.f6666a ^ 2) != 2)) {
            C0879tj tjVar = this.f7102p;
            tjVar.f6666a = 2 | tjVar.f6666a;
            Intent intent2 = new Intent("FT_EVENT_MODEM_STATUS");
            intent2.putExtra("message", "FT_EVENT_MODEM_STATUS");
            LocalBroadcastManager.getInstance(this.f7102p.f6675j).sendBroadcast(intent2);
        }
        if (s2 == 0 || (ugVar.f7114b & 4) == 0 || (this.f7102p.f6666a ^ 4) != 4) {
            return 0;
        }
        this.f7102p.f6666a |= 4;
        Intent intent3 = new Intent("FT_EVENT_LINE_STATUS");
        intent3.putExtra("message", "FT_EVENT_LINE_STATUS");
        LocalBroadcastManager.getInstance(this.f7102p.f6675j).sendBroadcast(intent3);
        return 0;
    }

    /* renamed from: f */
    public void mo5933f() {
        int c = this.f7103q.mo5823c();
        for (int i = 0; i < c; i++) {
            if (mo5922a(i).mo5919e()) {
                mo5930d(i);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public void mo5934g() {
        for (int i = 0; i < this.f7099m; i++) {
            try {
                mo5932e(i);
            } catch (Exception e) {
                Log.d("ProcessInCtrl", "Acquire read buffer " + i + " failed!");
                e.printStackTrace();
            }
            this.f7093g[i] = null;
            this.f7092f[i] = null;
            this.f7091e[i] = null;
        }
        for (int i2 = 0; i2 < 256; i2++) {
            this.f7095i[i2] = null;
        }
        this.f7091e = null;
        this.f7092f = null;
        this.f7093g = null;
        this.f7095i = null;
        this.f7094h = null;
        if (this.f7106t) {
            this.f7104r.lock();
            this.f7105s.signalAll();
            this.f7104r.unlock();
        }
        this.f7107u.lock();
        this.f7108v.signalAll();
        this.f7107u.unlock();
        this.f7104r = null;
        this.f7105s = null;
        this.f7101o = null;
        this.f7107u = null;
        this.f7108v = null;
        try {
            this.f7097k.close();
            this.f7097k = null;
            this.f7098l.close();
            this.f7098l = null;
            this.f7096j = null;
        } catch (IOException e2) {
            Log.d("ProcessInCtrl", "Close mMainPipe failed!");
            e2.printStackTrace();
        }
        this.f7102p = null;
        this.f7103q = null;
    }
}
