package atakplugin.UASTool;

import atakplugin.UASTool.bto;
import atakplugin.UASTool.bug;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class buh implements bus {

    /* renamed from: a */
    static final int f3867a = 16384;

    /* renamed from: b */
    static final byte f3868b = 0;

    /* renamed from: c */
    static final byte f3869c = 1;

    /* renamed from: d */
    static final byte f3870d = 2;

    /* renamed from: e */
    static final byte f3871e = 3;

    /* renamed from: f */
    static final byte f3872f = 4;

    /* renamed from: g */
    static final byte f3873g = 5;

    /* renamed from: h */
    static final byte f3874h = 6;

    /* renamed from: i */
    static final byte f3875i = 7;

    /* renamed from: j */
    static final byte f3876j = 8;

    /* renamed from: k */
    static final byte f3877k = 9;

    /* renamed from: l */
    static final byte f3878l = 0;

    /* renamed from: m */
    static final byte f3879m = 1;

    /* renamed from: n */
    static final byte f3880n = 1;

    /* renamed from: o */
    static final byte f3881o = 4;

    /* renamed from: p */
    static final byte f3882p = 4;

    /* renamed from: q */
    static final byte f3883q = 8;

    /* renamed from: r */
    static final byte f3884r = 32;

    /* renamed from: s */
    static final byte f3885s = 32;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public static final Logger f3886t = Logger.getLogger(C0252b.class.getName());
    /* access modifiers changed from: private */

    /* renamed from: u */
    public static final bwq f3887u = bwq.m10196b("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");

    /* renamed from: a */
    public bry mo3632a() {
        return bry.HTTP_2;
    }

    /* renamed from: a */
    public bto mo3633a(bwp bwp, boolean z) {
        return new C0253c(bwp, 4096, z);
    }

    /* renamed from: a */
    public btp mo3634a(bwo bwo, boolean z) {
        return new C0254d(bwo, z);
    }

    /* renamed from: atakplugin.UASTool.buh$c */
    static final class C0253c implements bto {

        /* renamed from: a */
        final bug.C0249a f3897a;

        /* renamed from: b */
        private final bwp f3898b;

        /* renamed from: c */
        private final C0251a f3899c;

        /* renamed from: d */
        private final boolean f3900d;

        C0253c(bwp bwp, int i, boolean z) {
            this.f3898b = bwp;
            this.f3900d = z;
            C0251a aVar = new C0251a(bwp);
            this.f3899c = aVar;
            this.f3897a = new bug.C0249a(i, aVar);
        }

        /* renamed from: a */
        public void mo3494a() {
            if (!this.f3900d) {
                bwq e = this.f3898b.mo3838e((long) buh.f3887u.mo3951n());
                if (buh.f3886t.isLoggable(Level.FINE)) {
                    buh.f3886t.fine(bsp.m9152a("<< CONNECTION %s", e.mo3947j()));
                }
                if (!buh.f3887u.equals(e)) {
                    throw buh.m9601d("Expected a connection header but was %s", e.mo3929c());
                }
            }
        }

        /* renamed from: a */
        public boolean mo3495a(bto.C0241a aVar) {
            try {
                this.f3898b.mo3821b(9);
                int a = buh.m9595b(this.f3898b);
                if (a < 0 || a > 16384) {
                    throw buh.m9601d("FRAME_SIZE_ERROR: %s", Integer.valueOf(a));
                }
                byte m = (byte) (this.f3898b.mo3866m() & 255);
                byte m2 = (byte) (this.f3898b.mo3866m() & 255);
                int o = this.f3898b.mo3872o() & Integer.MAX_VALUE;
                if (buh.f3886t.isLoggable(Level.FINE)) {
                    buh.f3886t.fine(C0252b.m9608a(true, o, a, m, m2));
                }
                switch (m) {
                    case 0:
                        m9612b(aVar, a, m2, o);
                        break;
                    case 1:
                        m9611a(aVar, a, m2, o);
                        break;
                    case 2:
                        m9613c(aVar, a, m2, o);
                        break;
                    case 3:
                        m9614d(aVar, a, m2, o);
                        break;
                    case 4:
                        m9615e(aVar, a, m2, o);
                        break;
                    case 5:
                        m9616f(aVar, a, m2, o);
                        break;
                    case 6:
                        m9617g(aVar, a, m2, o);
                        break;
                    case 7:
                        m9618h(aVar, a, m2, o);
                        break;
                    case 8:
                        m9619i(aVar, a, m2, o);
                        break;
                    default:
                        this.f3898b.mo3859j((long) a);
                        break;
                }
                return true;
            } catch (IOException unused) {
                return false;
            }
        }

        /* renamed from: a */
        private void m9611a(bto.C0241a aVar, int i, byte b, int i2) {
            short s = 0;
            if (i2 != 0) {
                boolean z = (b & 1) != 0;
                if ((b & 8) != 0) {
                    s = (short) (this.f3898b.mo3866m() & 255);
                }
                if ((b & 32) != 0) {
                    m9610a(aVar, i2);
                    i -= 5;
                }
                aVar.mo3506a(false, z, i2, -1, m9609a(buh.m9594b(i, b, s), s, b, i2), buf.HTTP_20_HEADERS);
                return;
            }
            throw buh.m9601d("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
        }

        /* renamed from: a */
        private List<bue> m9609a(int i, short s, byte b, int i2) {
            C0251a aVar = this.f3899c;
            aVar.f3891d = i;
            aVar.f3888a = i;
            this.f3899c.f3892e = s;
            this.f3899c.f3889b = b;
            this.f3899c.f3890c = i2;
            this.f3897a.mo3625b();
            return this.f3897a.mo3626c();
        }

        /* renamed from: b */
        private void m9612b(bto.C0241a aVar, int i, byte b, int i2) {
            boolean z = true;
            short s = 0;
            boolean z2 = (b & 1) != 0;
            if ((b & 32) == 0) {
                z = false;
            }
            if (!z) {
                if ((b & 8) != 0) {
                    s = (short) (this.f3898b.mo3866m() & 255);
                }
                aVar.mo3504a(z2, i2, this.f3898b, buh.m9594b(i, b, s));
                this.f3898b.mo3859j((long) s);
                return;
            }
            throw buh.m9601d("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
        }

        /* renamed from: c */
        private void m9613c(bto.C0241a aVar, int i, byte b, int i2) {
            if (i != 5) {
                throw buh.m9601d("TYPE_PRIORITY length: %d != 5", Integer.valueOf(i));
            } else if (i2 != 0) {
                m9610a(aVar, i2);
            } else {
                throw buh.m9601d("TYPE_PRIORITY streamId == 0", new Object[0]);
            }
        }

        /* renamed from: a */
        private void m9610a(bto.C0241a aVar, int i) {
            int o = this.f3898b.mo3872o();
            aVar.mo3497a(i, o & Integer.MAX_VALUE, (this.f3898b.mo3866m() & 255) + 1, (Integer.MIN_VALUE & o) != 0);
        }

        /* renamed from: d */
        private void m9614d(bto.C0241a aVar, int i, byte b, int i2) {
            if (i != 4) {
                throw buh.m9601d("TYPE_RST_STREAM length: %d != 4", Integer.valueOf(i));
            } else if (i2 != 0) {
                int o = this.f3898b.mo3872o();
                btn b2 = btn.m9335b(o);
                if (b2 != null) {
                    aVar.mo3500a(i2, b2);
                } else {
                    throw buh.m9601d("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(o));
                }
            } else {
                throw buh.m9601d("TYPE_RST_STREAM streamId == 0", new Object[0]);
            }
        }

        /* renamed from: e */
        private void m9615e(bto.C0241a aVar, int i, byte b, int i2) {
            if (i2 != 0) {
                throw buh.m9601d("TYPE_SETTINGS streamId != 0", new Object[0]);
            } else if ((b & 1) != 0) {
                if (i == 0) {
                    aVar.mo3496a();
                    return;
                }
                throw buh.m9601d("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
            } else if (i % 6 == 0) {
                bup bup = new bup();
                for (int i3 = 0; i3 < i; i3 += 6) {
                    short n = this.f3898b.mo3871n();
                    int o = this.f3898b.mo3872o();
                    if (n != 2) {
                        if (n == 3) {
                            n = 4;
                        } else if (n == 4) {
                            n = 7;
                            if (o < 0) {
                                throw buh.m9601d("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
                            }
                        } else if (n == 5 && (o < 16384 || o > 16777215)) {
                            throw buh.m9601d("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", Integer.valueOf(o));
                        }
                    } else if (!(o == 0 || o == 1)) {
                        throw buh.m9601d("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
                    }
                    bup.mo3655a(n, 0, o);
                }
                aVar.mo3505a(false, bup);
            } else {
                throw buh.m9601d("TYPE_SETTINGS length %% 6 != 0: %s", Integer.valueOf(i));
            }
        }

        /* renamed from: f */
        private void m9616f(bto.C0241a aVar, int i, byte b, int i2) {
            short s = 0;
            if (i2 != 0) {
                if ((b & 8) != 0) {
                    s = (short) (this.f3898b.mo3866m() & 255);
                }
                aVar.mo3498a(i2, this.f3898b.mo3872o() & Integer.MAX_VALUE, m9609a(buh.m9594b(i - 4, b, s), s, b, i2));
                return;
            }
            throw buh.m9601d("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
        }

        /* renamed from: g */
        private void m9617g(bto.C0241a aVar, int i, byte b, int i2) {
            boolean z = false;
            if (i != 8) {
                throw buh.m9601d("TYPE_PING length != 8: %s", Integer.valueOf(i));
            } else if (i2 == 0) {
                int o = this.f3898b.mo3872o();
                int o2 = this.f3898b.mo3872o();
                if ((b & 1) != 0) {
                    z = true;
                }
                aVar.mo3503a(z, o, o2);
            } else {
                throw buh.m9601d("TYPE_PING streamId != 0", new Object[0]);
            }
        }

        /* renamed from: h */
        private void m9618h(bto.C0241a aVar, int i, byte b, int i2) {
            if (i < 8) {
                throw buh.m9601d("TYPE_GOAWAY length < 8: %s", Integer.valueOf(i));
            } else if (i2 == 0) {
                int o = this.f3898b.mo3872o();
                int o2 = this.f3898b.mo3872o();
                int i3 = i - 8;
                btn b2 = btn.m9335b(o2);
                if (b2 != null) {
                    bwq bwq = bwq.f4133a;
                    if (i3 > 0) {
                        bwq = this.f3898b.mo3838e((long) i3);
                    }
                    aVar.mo3501a(o, b2, bwq);
                    return;
                }
                throw buh.m9601d("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(o2));
            } else {
                throw buh.m9601d("TYPE_GOAWAY streamId != 0", new Object[0]);
            }
        }

        /* renamed from: i */
        private void m9619i(bto.C0241a aVar, int i, byte b, int i2) {
            if (i == 4) {
                long o = ((long) this.f3898b.mo3872o()) & 2147483647L;
                if (o != 0) {
                    aVar.mo3499a(i2, o);
                } else {
                    throw buh.m9601d("windowSizeIncrement was 0", Long.valueOf(o));
                }
            } else {
                throw buh.m9601d("TYPE_WINDOW_UPDATE length !=4: %s", Integer.valueOf(i));
            }
        }

        public void close() {
            this.f3898b.close();
        }
    }

    /* renamed from: atakplugin.UASTool.buh$d */
    static final class C0254d implements btp {

        /* renamed from: a */
        final bug.C0250b f3901a;

        /* renamed from: b */
        private final bwo f3902b;

        /* renamed from: c */
        private final boolean f3903c;

        /* renamed from: d */
        private final bwl f3904d;

        /* renamed from: e */
        private int f3905e = 16384;

        /* renamed from: f */
        private boolean f3906f;

        C0254d(bwo bwo, boolean z) {
            this.f3902b = bwo;
            this.f3903c = z;
            bwl bwl = new bwl();
            this.f3904d = bwl;
            this.f3901a = new bug.C0250b(bwl);
        }

        /* renamed from: b */
        public synchronized void mo3518b() {
            if (!this.f3906f) {
                this.f3902b.flush();
            } else {
                throw new IOException("closed");
            }
        }

        /* renamed from: a */
        public synchronized void mo3513a(bup bup) {
            if (!this.f3906f) {
                this.f3905e = bup.mo3670i(this.f3905e);
                if (bup.mo3662c() > -1) {
                    this.f3901a.mo3628a(bup.mo3662c());
                }
                mo3637a(0, 0, (byte) 4, (byte) 1);
                this.f3902b.flush();
            } else {
                throw new IOException("closed");
            }
        }

        /* renamed from: a */
        public synchronized void mo3507a() {
            if (this.f3906f) {
                throw new IOException("closed");
            } else if (this.f3903c) {
                if (buh.f3886t.isLoggable(Level.FINE)) {
                    buh.f3886t.fine(bsp.m9152a(">> CONNECTION %s", buh.f3887u.mo3947j()));
                }
                this.f3902b.mo3834d(buh.f3887u.mo3953p());
                this.f3902b.flush();
            }
        }

        /* renamed from: a */
        public synchronized void mo3517a(boolean z, boolean z2, int i, int i2, List<bue> list) {
            if (!z2) {
                try {
                    if (!this.f3906f) {
                        mo3638b(z, i, list);
                    } else {
                        throw new IOException("closed");
                    }
                } catch (Throwable th) {
                    throw th;
                }
            } else {
                throw new UnsupportedOperationException();
            }
        }

        /* renamed from: a */
        public synchronized void mo3516a(boolean z, int i, List<bue> list) {
            if (!this.f3906f) {
                mo3638b(z, i, list);
            } else {
                throw new IOException("closed");
            }
        }

        /* renamed from: a */
        public synchronized void mo3512a(int i, List<bue> list) {
            if (!this.f3906f) {
                mo3638b(false, i, list);
            } else {
                throw new IOException("closed");
            }
        }

        /* renamed from: a */
        public synchronized void mo3508a(int i, int i2, List<bue> list) {
            if (!this.f3906f) {
                this.f3901a.mo3631a(list);
                long a = this.f3904d.mo3783a();
                int min = (int) Math.min((long) (this.f3905e - 4), a);
                long j = (long) min;
                int i3 = (a > j ? 1 : (a == j ? 0 : -1));
                mo3637a(i, min + 4, (byte) 5, i3 == 0 ? (byte) 4 : 0);
                this.f3902b.mo3857j(i2 & Integer.MAX_VALUE);
                this.f3902b.write(this.f3904d, j);
                if (i3 > 0) {
                    m9622b(i, a - j);
                }
            } else {
                throw new IOException("closed");
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo3638b(boolean z, int i, List<bue> list) {
            if (!this.f3906f) {
                this.f3901a.mo3631a(list);
                long a = this.f3904d.mo3783a();
                int min = (int) Math.min((long) this.f3905e, a);
                long j = (long) min;
                int i2 = (a > j ? 1 : (a == j ? 0 : -1));
                byte b = i2 == 0 ? (byte) 4 : 0;
                if (z) {
                    b = (byte) (b | 1);
                }
                mo3637a(i, min, (byte) 1, b);
                this.f3902b.write(this.f3904d, j);
                if (i2 > 0) {
                    m9622b(i, a - j);
                    return;
                }
                return;
            }
            throw new IOException("closed");
        }

        /* renamed from: b */
        private void m9622b(int i, long j) {
            while (j > 0) {
                int min = (int) Math.min((long) this.f3905e, j);
                long j2 = (long) min;
                j -= j2;
                mo3637a(i, min, (byte) 9, j == 0 ? (byte) 4 : 0);
                this.f3902b.write(this.f3904d, j2);
            }
        }

        /* renamed from: a */
        public synchronized void mo3510a(int i, btn btn) {
            if (this.f3906f) {
                throw new IOException("closed");
            } else if (btn.f3727s != -1) {
                mo3637a(i, 4, (byte) 3, (byte) 0);
                this.f3902b.mo3857j(btn.f3727s);
                this.f3902b.flush();
            } else {
                throw new IllegalArgumentException();
            }
        }

        /* renamed from: c */
        public int mo3520c() {
            return this.f3905e;
        }

        /* renamed from: a */
        public synchronized void mo3515a(boolean z, int i, bwl bwl, int i2) {
            if (!this.f3906f) {
                byte b = 0;
                if (z) {
                    b = (byte) 1;
                }
                mo3636a(i, b, bwl, i2);
            } else {
                throw new IOException("closed");
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo3636a(int i, byte b, bwl bwl, int i2) {
            mo3637a(i, i2, (byte) 0, b);
            if (i2 > 0) {
                this.f3902b.write(bwl, (long) i2);
            }
        }

        /* renamed from: b */
        public synchronized void mo3519b(bup bup) {
            if (!this.f3906f) {
                int i = 0;
                mo3637a(0, bup.mo3660b() * 6, (byte) 4, (byte) 0);
                while (i < 10) {
                    if (bup.mo3658a(i)) {
                        this.f3902b.mo3842f(i == 4 ? 3 : i == 7 ? 4 : i);
                        this.f3902b.mo3857j(bup.mo3661b(i));
                    }
                    i++;
                }
                this.f3902b.flush();
            } else {
                throw new IOException("closed");
            }
        }

        /* renamed from: a */
        public synchronized void mo3514a(boolean z, int i, int i2) {
            if (!this.f3906f) {
                mo3637a(0, 8, (byte) 6, z ? (byte) 1 : 0);
                this.f3902b.mo3857j(i);
                this.f3902b.mo3857j(i2);
                this.f3902b.flush();
            } else {
                throw new IOException("closed");
            }
        }

        /* renamed from: a */
        public synchronized void mo3511a(int i, btn btn, byte[] bArr) {
            if (this.f3906f) {
                throw new IOException("closed");
            } else if (btn.f3727s != -1) {
                mo3637a(0, bArr.length + 8, (byte) 7, (byte) 0);
                this.f3902b.mo3857j(i);
                this.f3902b.mo3857j(btn.f3727s);
                if (bArr.length > 0) {
                    this.f3902b.mo3834d(bArr);
                }
                this.f3902b.flush();
            } else {
                throw buh.m9599c("errorCode.httpCode == -1", new Object[0]);
            }
        }

        /* renamed from: a */
        public synchronized void mo3509a(int i, long j) {
            if (this.f3906f) {
                throw new IOException("closed");
            } else if (j == 0 || j > 2147483647L) {
                throw buh.m9599c("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", Long.valueOf(j));
            } else {
                mo3637a(i, 4, (byte) 8, (byte) 0);
                this.f3902b.mo3857j((int) j);
                this.f3902b.flush();
            }
        }

        public synchronized void close() {
            this.f3906f = true;
            this.f3902b.close();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo3637a(int i, int i2, byte b, byte b2) {
            if (buh.f3886t.isLoggable(Level.FINE)) {
                buh.f3886t.fine(C0252b.m9608a(false, i, i2, b, b2));
            }
            int i3 = this.f3905e;
            if (i2 > i3) {
                throw buh.m9599c("FRAME_SIZE_ERROR length > %d: %d", Integer.valueOf(i3), Integer.valueOf(i2));
            } else if ((Integer.MIN_VALUE & i) == 0) {
                buh.m9598b(this.f3902b, i2);
                this.f3902b.mo3833d((int) b & 255);
                this.f3902b.mo3833d((int) b2 & 255);
                this.f3902b.mo3857j(i & Integer.MAX_VALUE);
            } else {
                throw buh.m9599c("reserved bit set: %s", Integer.valueOf(i));
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static IllegalArgumentException m9599c(String str, Object... objArr) {
        throw new IllegalArgumentException(bsp.m9152a(str, objArr));
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public static IOException m9601d(String str, Object... objArr) {
        throw new IOException(bsp.m9152a(str, objArr));
    }

    /* renamed from: atakplugin.UASTool.buh$a */
    static final class C0251a implements bxr {

        /* renamed from: a */
        int f3888a;

        /* renamed from: b */
        byte f3889b;

        /* renamed from: c */
        int f3890c;

        /* renamed from: d */
        int f3891d;

        /* renamed from: e */
        short f3892e;

        /* renamed from: f */
        private final bwp f3893f;

        public void close() {
        }

        public C0251a(bwp bwp) {
            this.f3893f = bwp;
        }

        /* renamed from: a */
        public long mo3425a(bwl bwl, long j) {
            while (true) {
                int i = this.f3891d;
                if (i == 0) {
                    this.f3893f.mo3859j((long) this.f3892e);
                    this.f3892e = 0;
                    if ((this.f3889b & 4) != 0) {
                        return -1;
                    }
                    m9605a();
                } else {
                    long a = this.f3893f.mo3425a(bwl, Math.min(j, (long) i));
                    if (a == -1) {
                        return -1;
                    }
                    this.f3891d = (int) (((long) this.f3891d) - a);
                    return a;
                }
            }
        }

        public bxs timeout() {
            return this.f3893f.timeout();
        }

        /* renamed from: a */
        private void m9605a() {
            int i = this.f3890c;
            int a = buh.m9595b(this.f3893f);
            this.f3891d = a;
            this.f3888a = a;
            byte m = (byte) (this.f3893f.mo3866m() & 255);
            this.f3889b = (byte) (this.f3893f.mo3866m() & 255);
            if (buh.f3886t.isLoggable(Level.FINE)) {
                buh.f3886t.fine(C0252b.m9608a(true, this.f3890c, this.f3888a, m, this.f3889b));
            }
            int o = this.f3893f.mo3872o() & Integer.MAX_VALUE;
            this.f3890c = o;
            if (m != 9) {
                throw buh.m9601d("%s != TYPE_CONTINUATION", Byte.valueOf(m));
            } else if (o != i) {
                throw buh.m9601d("TYPE_CONTINUATION streamId changed", new Object[0]);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static int m9594b(int i, byte b, short s) {
        if ((b & 8) != 0) {
            i--;
        }
        if (s <= i) {
            return (short) (i - s);
        }
        throw m9601d("PROTOCOL_ERROR padding %s > remaining length %s", Short.valueOf(s), Integer.valueOf(i));
    }

    /* renamed from: atakplugin.UASTool.buh$b */
    static final class C0252b {

        /* renamed from: a */
        private static final String[] f3894a = {"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};

        /* renamed from: b */
        private static final String[] f3895b = new String[64];

        /* renamed from: c */
        private static final String[] f3896c = new String[256];

        C0252b() {
        }

        /* renamed from: a */
        static String m9608a(boolean z, int i, int i2, byte b, byte b2) {
            String[] strArr = f3894a;
            String a = b < strArr.length ? strArr[b] : bsp.m9152a("0x%02x", Byte.valueOf(b));
            String a2 = m9607a(b, b2);
            Object[] objArr = new Object[5];
            objArr[0] = z ? "<<" : ">>";
            objArr[1] = Integer.valueOf(i);
            objArr[2] = Integer.valueOf(i2);
            objArr[3] = a;
            objArr[4] = a2;
            return bsp.m9152a("%s 0x%08x %5d %-13s %s", objArr);
        }

        /* renamed from: a */
        static String m9607a(byte b, byte b2) {
            if (b2 == 0) {
                return "";
            }
            if (!(b == 2 || b == 3)) {
                if (b == 4 || b == 6) {
                    return b2 == 1 ? "ACK" : f3896c[b2];
                }
                if (!(b == 7 || b == 8)) {
                    String[] strArr = f3895b;
                    String str = b2 < strArr.length ? strArr[b2] : f3896c[b2];
                    if (b == 5 && (b2 & 4) != 0) {
                        return str.replace("HEADERS", "PUSH_PROMISE");
                    }
                    if (b != 0 || (b2 & 32) == 0) {
                        return str;
                    }
                    return str.replace("PRIORITY", "COMPRESSED");
                }
            }
            return f3896c[b2];
        }

        static {
            int i = 0;
            int i2 = 0;
            while (true) {
                String[] strArr = f3896c;
                if (i2 >= strArr.length) {
                    break;
                }
                strArr[i2] = bsp.m9152a("%8s", Integer.toBinaryString(i2)).replace(' ', '0');
                i2++;
            }
            String[] strArr2 = f3895b;
            strArr2[0] = "";
            strArr2[1] = "END_STREAM";
            int[] iArr = {1};
            strArr2[8] = "PADDED";
            for (int i3 = 0; i3 < 1; i3++) {
                int i4 = iArr[i3];
                String[] strArr3 = f3895b;
                strArr3[i4 | 8] = strArr3[i4] + "|PADDED";
            }
            String[] strArr4 = f3895b;
            strArr4[4] = "END_HEADERS";
            strArr4[32] = "PRIORITY";
            strArr4[36] = "END_HEADERS|PRIORITY";
            int[] iArr2 = {4, 32, 36};
            for (int i5 = 0; i5 < 3; i5++) {
                int i6 = iArr2[i5];
                for (int i7 = 0; i7 < 1; i7++) {
                    int i8 = iArr[i7];
                    String[] strArr5 = f3895b;
                    int i9 = i8 | i6;
                    strArr5[i9] = strArr5[i8] + '|' + strArr5[i6];
                    strArr5[i9 | 8] = strArr5[i8] + '|' + strArr5[i6] + "|PADDED";
                }
            }
            while (true) {
                String[] strArr6 = f3895b;
                if (i < strArr6.length) {
                    if (strArr6[i] == null) {
                        strArr6[i] = f3896c[i];
                    }
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static int m9595b(bwp bwp) {
        return (bwp.mo3866m() & 255) | ((bwp.mo3866m() & 255) << 16) | ((bwp.mo3866m() & 255) << 8);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m9598b(bwo bwo, int i) {
        bwo.mo3833d((i >>> 16) & 255);
        bwo.mo3833d((i >>> 8) & 255);
        bwo.mo3833d(i & 255);
    }
}
