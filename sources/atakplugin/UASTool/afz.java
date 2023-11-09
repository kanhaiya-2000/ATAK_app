package atakplugin.UASTool;

import java.io.IOException;
import java.io.OutputStream;

class afz extends OutputStream {

    /* renamed from: a */
    byte[] f927a = new byte[1];

    /* renamed from: b */
    final /* synthetic */ afy f928b;

    /* renamed from: c */
    final /* synthetic */ afy f929c;

    /* renamed from: d */
    private int f930d = 0;

    /* renamed from: e */
    private afx f931e = null;

    /* renamed from: f */
    private ahy f932f = null;

    /* renamed from: g */
    private boolean f933g = false;

    afz(afy afy, afy afy2) {
        this.f929c = afy;
        this.f928b = afy2;
    }

    /* renamed from: a */
    private synchronized void m979a() {
        this.f931e = new afx(this.f929c.f909p);
        this.f932f = new ahy(this.f931e);
        if ((this.f931e.f888b.length - 14) - 84 <= 0) {
            this.f931e = null;
            this.f932f = null;
            throw new IOException("failed to initialize the channel.");
        }
    }

    public void write(int i) {
        byte[] bArr = this.f927a;
        bArr[0] = (byte) i;
        write(bArr, 0, 1);
    }

    public void write(byte[] bArr, int i, int i2) {
        if (this.f932f == null) {
            m979a();
        }
        if (!this.f933g) {
            byte[] bArr2 = this.f931e.f888b;
            int length = bArr2.length;
            while (i2 > 0) {
                int i3 = this.f930d;
                int i4 = i2 > (length - (i3 + 14)) + -84 ? (length - (i3 + 14)) - 84 : i2;
                if (i4 <= 0) {
                    flush();
                } else {
                    System.arraycopy(bArr, i, bArr2, i3 + 14, i4);
                    this.f930d += i4;
                    i += i4;
                    i2 -= i4;
                }
            }
            return;
        }
        throw new IOException("Already closed");
    }

    public void flush() {
        if (this.f933g) {
            throw new IOException("Already closed");
        } else if (this.f930d != 0) {
            this.f932f.mo996a();
            this.f931e.mo618a((byte) 94);
            this.f931e.mo619a(this.f929c.f903j);
            this.f931e.mo619a(this.f930d);
            this.f931e.mo626b(this.f930d);
            try {
                int i = this.f930d;
                this.f930d = 0;
                synchronized (this.f928b) {
                    if (!this.f928b.f914u) {
                        this.f929c.mo686p().mo1042a(this.f932f, this.f928b, i);
                    }
                }
            } catch (Exception e) {
                close();
                throw new IOException(e.toString());
            }
        }
    }

    public void close() {
        if (this.f932f == null) {
            try {
                m979a();
            } catch (IOException unused) {
                return;
            }
        }
        if (!this.f933g) {
            if (this.f930d > 0) {
                flush();
            }
            this.f928b.mo680j();
            this.f933g = true;
        }
    }
}
