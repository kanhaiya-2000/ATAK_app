package atakplugin.UASTool;

import java.io.EOFException;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* renamed from: atakplugin.UASTool.sj */
public class C0831sj {

    /* renamed from: a */
    static final int f6384a = 16384;

    /* renamed from: b */
    static final int f6385b = 16384;

    /* renamed from: c */
    private ByteBuffer f6386c;

    /* renamed from: d */
    private final C0832a f6387d = new C0832a();

    /* renamed from: e */
    private byte[] f6388e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public boolean f6389f = false;

    public C0831sj(boolean z) {
        if (z) {
            this.f6386c = ByteBuffer.allocate(16384);
        } else {
            this.f6388e = new byte[16384];
        }
    }

    /* renamed from: a */
    public void mo5720a(boolean z) {
        this.f6389f = z;
    }

    /* renamed from: a */
    public ByteBuffer mo5719a() {
        ByteBuffer byteBuffer;
        synchronized (this) {
            byteBuffer = this.f6386c;
        }
        return byteBuffer;
    }

    /* renamed from: b */
    public byte[] mo5723b() {
        byte[] bArr;
        synchronized (this) {
            int position = this.f6386c.position();
            bArr = new byte[position];
            this.f6386c.position(0);
            this.f6386c.get(bArr, 0, position);
            if (this.f6389f) {
                C0841sp.m13733c(bArr, true);
            }
        }
        return bArr;
    }

    /* renamed from: c */
    public void mo5724c() {
        synchronized (this) {
            this.f6386c.clear();
        }
    }

    /* renamed from: d */
    public byte[] mo5725d() {
        return this.f6387d.mo5728a();
    }

    /* renamed from: a */
    public void mo5721a(byte[] bArr) {
        this.f6387d.mo5727a(bArr);
    }

    /* renamed from: e */
    public byte[] mo5726e() {
        return this.f6388e;
    }

    /* renamed from: a */
    public byte[] mo5722a(int i) {
        return Arrays.copyOfRange(this.f6388e, 0, i);
    }

    /* renamed from: atakplugin.UASTool.sj$a */
    private class C0832a {

        /* renamed from: b */
        private final bwl f6391b = new bwl();

        C0832a() {
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0021, code lost:
            return;
         */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public synchronized void mo5727a(byte[] r2) {
            /*
                r1 = this;
                monitor-enter(r1)
                if (r2 == 0) goto L_0x0020
                int r0 = r2.length     // Catch:{ all -> 0x001d }
                if (r0 != 0) goto L_0x0007
                goto L_0x0020
            L_0x0007:
                atakplugin.UASTool.sj r0 = atakplugin.UASTool.C0831sj.this     // Catch:{ all -> 0x001d }
                boolean r0 = r0.f6389f     // Catch:{ all -> 0x001d }
                if (r0 == 0) goto L_0x0013
                r0 = 1
                atakplugin.UASTool.C0841sp.m13732b(r2, r0)     // Catch:{ all -> 0x001d }
            L_0x0013:
                atakplugin.UASTool.bwl r0 = r1.f6391b     // Catch:{ all -> 0x001d }
                r0.mo3834d((byte[]) r2)     // Catch:{ all -> 0x001d }
                r1.notify()     // Catch:{ all -> 0x001d }
                monitor-exit(r1)
                return
            L_0x001d:
                r2 = move-exception
                monitor-exit(r1)
                throw r2
            L_0x0020:
                monitor-exit(r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.C0831sj.C0832a.mo5727a(byte[]):void");
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public synchronized byte[] mo5728a() {
            byte[] bArr;
            if (this.f6391b.mo3783a() == 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    Thread.currentThread().interrupt();
                }
            }
            if (this.f6391b.mo3783a() <= 16384) {
                bArr = this.f6391b.mo3768A();
            } else {
                try {
                    bArr = this.f6391b.mo3855i(16384);
                } catch (EOFException e2) {
                    e2.printStackTrace();
                    return new byte[0];
                }
            }
            if (C0831sj.this.f6389f) {
                C0841sp.m13731a(bArr, true);
            }
            return bArr;
        }
    }
}
