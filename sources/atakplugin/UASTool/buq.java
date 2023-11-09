package atakplugin.UASTool;

import atakplugin.UASTool.bto;
import com.atakmap.android.uastool.MAVLink.enums.ACCELCAL_VEHICLE_POS;
import java.io.Closeable;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.ProtocolException;
import java.util.List;
import java.util.zip.Deflater;

public final class buq implements bus {

    /* renamed from: a */
    static final int f3946a = 0;

    /* renamed from: b */
    static final int f3947b = 1;

    /* renamed from: c */
    static final int f3948c = 2;

    /* renamed from: d */
    static final int f3949d = 3;

    /* renamed from: e */
    static final int f3950e = 4;

    /* renamed from: f */
    static final int f3951f = 6;

    /* renamed from: g */
    static final int f3952g = 7;

    /* renamed from: h */
    static final int f3953h = 8;

    /* renamed from: i */
    static final int f3954i = 9;

    /* renamed from: j */
    static final int f3955j = 1;

    /* renamed from: k */
    static final int f3956k = 2;

    /* renamed from: l */
    static final int f3957l = 3;

    /* renamed from: m */
    static final byte[] f3958m;

    /* renamed from: a */
    public bry mo3632a() {
        return bry.SPDY_3;
    }

    static {
        try {
            f3958m = "\u0000\u0000\u0000\u0007options\u0000\u0000\u0000\u0004head\u0000\u0000\u0000\u0004post\u0000\u0000\u0000\u0003put\u0000\u0000\u0000\u0006delete\u0000\u0000\u0000\u0005trace\u0000\u0000\u0000\u0006accept\u0000\u0000\u0000\u000eaccept-charset\u0000\u0000\u0000\u000faccept-encoding\u0000\u0000\u0000\u000faccept-language\u0000\u0000\u0000\raccept-ranges\u0000\u0000\u0000\u0003age\u0000\u0000\u0000\u0005allow\u0000\u0000\u0000\rauthorization\u0000\u0000\u0000\rcache-control\u0000\u0000\u0000\nconnection\u0000\u0000\u0000\fcontent-base\u0000\u0000\u0000\u0010content-encoding\u0000\u0000\u0000\u0010content-language\u0000\u0000\u0000\u000econtent-length\u0000\u0000\u0000\u0010content-location\u0000\u0000\u0000\u000bcontent-md5\u0000\u0000\u0000\rcontent-range\u0000\u0000\u0000\fcontent-type\u0000\u0000\u0000\u0004date\u0000\u0000\u0000\u0004etag\u0000\u0000\u0000\u0006expect\u0000\u0000\u0000\u0007expires\u0000\u0000\u0000\u0004from\u0000\u0000\u0000\u0004host\u0000\u0000\u0000\bif-match\u0000\u0000\u0000\u0011if-modified-since\u0000\u0000\u0000\rif-none-match\u0000\u0000\u0000\bif-range\u0000\u0000\u0000\u0013if-unmodified-since\u0000\u0000\u0000\rlast-modified\u0000\u0000\u0000\blocation\u0000\u0000\u0000\fmax-forwards\u0000\u0000\u0000\u0006pragma\u0000\u0000\u0000\u0012proxy-authenticate\u0000\u0000\u0000\u0013proxy-authorization\u0000\u0000\u0000\u0005range\u0000\u0000\u0000\u0007referer\u0000\u0000\u0000\u000bretry-after\u0000\u0000\u0000\u0006server\u0000\u0000\u0000\u0002te\u0000\u0000\u0000\u0007trailer\u0000\u0000\u0000\u0011transfer-encoding\u0000\u0000\u0000\u0007upgrade\u0000\u0000\u0000\nuser-agent\u0000\u0000\u0000\u0004vary\u0000\u0000\u0000\u0003via\u0000\u0000\u0000\u0007warning\u0000\u0000\u0000\u0010www-authenticate\u0000\u0000\u0000\u0006method\u0000\u0000\u0000\u0003get\u0000\u0000\u0000\u0006status\u0000\u0000\u0000\u0006200 OK\u0000\u0000\u0000\u0007version\u0000\u0000\u0000\bHTTP/1.1\u0000\u0000\u0000\u0003url\u0000\u0000\u0000\u0006public\u0000\u0000\u0000\nset-cookie\u0000\u0000\u0000\nkeep-alive\u0000\u0000\u0000\u0006origin100101201202205206300302303304305306307402405406407408409410411412413414415416417502504505203 Non-Authoritative Information204 No Content301 Moved Permanently400 Bad Request401 Unauthorized403 Forbidden404 Not Found500 Internal Server Error501 Not Implemented503 Service UnavailableJan Feb Mar Apr May Jun Jul Aug Sept Oct Nov Dec 00:00:00 Mon, Tue, Wed, Thu, Fri, Sat, Sun, GMTchunked,text/html,image/png,image/jpg,image/gif,application/xml,application/xhtml+xml,text/plain,text/javascript,publicprivatemax-age=gzip,deflate,sdchcharset=utf-8charset=iso-8859-1,utf-,*,enq=0.".getBytes(bsp.f3584c.name());
        } catch (UnsupportedEncodingException unused) {
            throw new AssertionError();
        }
    }

    /* renamed from: a */
    public bto mo3633a(bwp bwp, boolean z) {
        return new C0256a(bwp, z);
    }

    /* renamed from: a */
    public btp mo3634a(bwo bwo, boolean z) {
        return new C0257b(bwo, z);
    }

    /* renamed from: atakplugin.UASTool.buq$a */
    static final class C0256a implements bto {

        /* renamed from: a */
        private final bwp f3959a;

        /* renamed from: b */
        private final boolean f3960b;

        /* renamed from: c */
        private final buj f3961c;

        /* renamed from: a */
        public void mo3494a() {
        }

        C0256a(bwp bwp, boolean z) {
            this.f3959a = bwp;
            this.f3961c = new buj(bwp);
            this.f3960b = z;
        }

        /* renamed from: a */
        public boolean mo3495a(bto.C0241a aVar) {
            boolean z = false;
            try {
                int o = this.f3959a.mo3872o();
                int o2 = this.f3959a.mo3872o();
                boolean z2 = (Integer.MIN_VALUE & o) != 0;
                int i = (-16777216 & o2) >>> 24;
                int i2 = o2 & ACCELCAL_VEHICLE_POS.ACCELCAL_VEHICLE_POS_SUCCESS;
                if (z2) {
                    int i3 = (2147418112 & o) >>> 16;
                    int i4 = o & 65535;
                    if (i3 == 3) {
                        switch (i4) {
                            case 1:
                                m9695a(aVar, i, i2);
                                return true;
                            case 2:
                                m9696b(aVar, i, i2);
                                return true;
                            case 3:
                                m9697c(aVar, i, i2);
                                return true;
                            case 4:
                                m9702h(aVar, i, i2);
                                return true;
                            case 6:
                                m9700f(aVar, i, i2);
                                return true;
                            case 7:
                                m9701g(aVar, i, i2);
                                return true;
                            case 8:
                                m9698d(aVar, i, i2);
                                return true;
                            case 9:
                                m9699e(aVar, i, i2);
                                return true;
                            default:
                                this.f3959a.mo3859j((long) i2);
                                return true;
                        }
                    } else {
                        throw new ProtocolException("version != 3: " + i3);
                    }
                } else {
                    int i5 = o & Integer.MAX_VALUE;
                    if ((i & 1) != 0) {
                        z = true;
                    }
                    aVar.mo3504a(z, i5, this.f3959a, i2);
                    return true;
                }
            } catch (IOException unused) {
                return false;
            }
        }

        /* renamed from: a */
        private void m9695a(bto.C0241a aVar, int i, int i2) {
            int o = this.f3959a.mo3872o() & Integer.MAX_VALUE;
            int o2 = this.f3959a.mo3872o() & Integer.MAX_VALUE;
            this.f3959a.mo3871n();
            List<bue> a = this.f3961c.mo3643a(i2 - 10);
            aVar.mo3506a((i & 2) != 0, (i & 1) != 0, o, o2, a, buf.SPDY_SYN_STREAM);
        }

        /* renamed from: b */
        private void m9696b(bto.C0241a aVar, int i, int i2) {
            aVar.mo3506a(false, (i & 1) != 0, this.f3959a.mo3872o() & Integer.MAX_VALUE, -1, this.f3961c.mo3643a(i2 - 4), buf.SPDY_REPLY);
        }

        /* renamed from: c */
        private void m9697c(bto.C0241a aVar, int i, int i2) {
            if (i2 == 8) {
                int o = this.f3959a.mo3872o() & Integer.MAX_VALUE;
                int o2 = this.f3959a.mo3872o();
                btn a = btn.m9334a(o2);
                if (a != null) {
                    aVar.mo3500a(o, a);
                } else {
                    throw m9694a("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(o2));
                }
            } else {
                throw m9694a("TYPE_RST_STREAM length: %d != 8", Integer.valueOf(i2));
            }
        }

        /* renamed from: d */
        private void m9698d(bto.C0241a aVar, int i, int i2) {
            aVar.mo3506a(false, false, this.f3959a.mo3872o() & Integer.MAX_VALUE, -1, this.f3961c.mo3643a(i2 - 4), buf.SPDY_HEADERS);
        }

        /* renamed from: e */
        private void m9699e(bto.C0241a aVar, int i, int i2) {
            if (i2 == 8) {
                int o = this.f3959a.mo3872o() & Integer.MAX_VALUE;
                long o2 = (long) (this.f3959a.mo3872o() & Integer.MAX_VALUE);
                if (o2 != 0) {
                    aVar.mo3499a(o, o2);
                } else {
                    throw m9694a("windowSizeIncrement was 0", Long.valueOf(o2));
                }
            } else {
                throw m9694a("TYPE_WINDOW_UPDATE length: %d != 8", Integer.valueOf(i2));
            }
        }

        /* renamed from: f */
        private void m9700f(bto.C0241a aVar, int i, int i2) {
            boolean z = true;
            if (i2 == 4) {
                int o = this.f3959a.mo3872o();
                if (this.f3960b != ((o & 1) == 1)) {
                    z = false;
                }
                aVar.mo3503a(z, o, 0);
                return;
            }
            throw m9694a("TYPE_PING length: %d != 4", Integer.valueOf(i2));
        }

        /* renamed from: g */
        private void m9701g(bto.C0241a aVar, int i, int i2) {
            if (i2 == 8) {
                int o = this.f3959a.mo3872o() & Integer.MAX_VALUE;
                int o2 = this.f3959a.mo3872o();
                btn c = btn.m9336c(o2);
                if (c != null) {
                    aVar.mo3501a(o, c, bwq.f4133a);
                } else {
                    throw m9694a("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(o2));
                }
            } else {
                throw m9694a("TYPE_GOAWAY length: %d != 8", Integer.valueOf(i2));
            }
        }

        /* renamed from: h */
        private void m9702h(bto.C0241a aVar, int i, int i2) {
            int o = this.f3959a.mo3872o();
            boolean z = false;
            if (i2 == (o * 8) + 4) {
                bup bup = new bup();
                for (int i3 = 0; i3 < o; i3++) {
                    int o2 = this.f3959a.mo3872o();
                    int o3 = this.f3959a.mo3872o();
                    bup.mo3655a(o2 & ACCELCAL_VEHICLE_POS.ACCELCAL_VEHICLE_POS_SUCCESS, (-16777216 & o2) >>> 24, o3);
                }
                if ((i & 1) != 0) {
                    z = true;
                }
                aVar.mo3505a(z, bup);
                return;
            }
            throw m9694a("TYPE_SETTINGS length: %d != 4 + 8 * %d", Integer.valueOf(i2), Integer.valueOf(o));
        }

        /* renamed from: a */
        private static IOException m9694a(String str, Object... objArr) {
            throw new IOException(bsp.m9152a(str, objArr));
        }

        public void close() {
            this.f3961c.mo3644a();
        }
    }

    /* renamed from: atakplugin.UASTool.buq$b */
    static final class C0257b implements btp {

        /* renamed from: a */
        private final bwo f3962a;

        /* renamed from: b */
        private final bwl f3963b;

        /* renamed from: c */
        private final bwo f3964c;

        /* renamed from: d */
        private final boolean f3965d;

        /* renamed from: e */
        private boolean f3966e;

        /* renamed from: a */
        public void mo3508a(int i, int i2, List<bue> list) {
        }

        /* renamed from: a */
        public void mo3513a(bup bup) {
        }

        /* renamed from: c */
        public int mo3520c() {
            return 16383;
        }

        C0257b(bwo bwo, boolean z) {
            this.f3962a = bwo;
            this.f3965d = z;
            Deflater deflater = new Deflater();
            deflater.setDictionary(buq.f3958m);
            bwl bwl = new bwl();
            this.f3963b = bwl;
            this.f3964c = bxb.m10329a((bxp) new bwr((bxp) bwl, deflater));
        }

        /* renamed from: a */
        public synchronized void mo3507a() {
        }

        /* renamed from: b */
        public synchronized void mo3518b() {
            if (!this.f3966e) {
                this.f3962a.flush();
            } else {
                throw new IOException("closed");
            }
        }

        /* renamed from: a */
        public synchronized void mo3517a(boolean z, boolean z2, int i, int i2, List<bue> list) {
            if (!this.f3966e) {
                m9705a(list);
                int a = (int) (this.f3963b.mo3783a() + 10);
                boolean z3 = z | (z2 ? (char) 2 : 0);
                this.f3962a.mo3857j(-2147287039);
                this.f3962a.mo3857j(((z3 & true ? 1 : 0) << true) | (a & ACCELCAL_VEHICLE_POS.ACCELCAL_VEHICLE_POS_SUCCESS));
                this.f3962a.mo3857j(i & Integer.MAX_VALUE);
                this.f3962a.mo3857j(Integer.MAX_VALUE & i2);
                this.f3962a.mo3842f(0);
                this.f3962a.mo3789a(this.f3963b);
                this.f3962a.flush();
            } else {
                throw new IOException("closed");
            }
        }

        /* renamed from: a */
        public synchronized void mo3516a(boolean z, int i, List<bue> list) {
            if (!this.f3966e) {
                m9705a(list);
                int i2 = z ? 1 : 0;
                int a = (int) (this.f3963b.mo3783a() + 4);
                this.f3962a.mo3857j(-2147287038);
                this.f3962a.mo3857j(((i2 & 255) << 24) | (a & ACCELCAL_VEHICLE_POS.ACCELCAL_VEHICLE_POS_SUCCESS));
                this.f3962a.mo3857j(i & Integer.MAX_VALUE);
                this.f3962a.mo3789a(this.f3963b);
                this.f3962a.flush();
            } else {
                throw new IOException("closed");
            }
        }

        /* renamed from: a */
        public synchronized void mo3512a(int i, List<bue> list) {
            if (!this.f3966e) {
                m9705a(list);
                int a = (int) (this.f3963b.mo3783a() + 4);
                this.f3962a.mo3857j(-2147287032);
                this.f3962a.mo3857j((a & ACCELCAL_VEHICLE_POS.ACCELCAL_VEHICLE_POS_SUCCESS) | 0);
                this.f3962a.mo3857j(i & Integer.MAX_VALUE);
                this.f3962a.mo3789a(this.f3963b);
            } else {
                throw new IOException("closed");
            }
        }

        /* renamed from: a */
        public synchronized void mo3510a(int i, btn btn) {
            if (this.f3966e) {
                throw new IOException("closed");
            } else if (btn.f3728t != -1) {
                this.f3962a.mo3857j(-2147287037);
                this.f3962a.mo3857j(8);
                this.f3962a.mo3857j(i & Integer.MAX_VALUE);
                this.f3962a.mo3857j(btn.f3728t);
                this.f3962a.flush();
            } else {
                throw new IllegalArgumentException();
            }
        }

        /* renamed from: a */
        public synchronized void mo3515a(boolean z, int i, bwl bwl, int i2) {
            mo3678a(i, z ? 1 : 0, bwl, i2);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo3678a(int i, int i2, bwl bwl, int i3) {
            if (!this.f3966e) {
                long j = (long) i3;
                if (j <= 16777215) {
                    this.f3962a.mo3857j(i & Integer.MAX_VALUE);
                    this.f3962a.mo3857j(((i2 & 255) << 24) | (16777215 & i3));
                    if (i3 > 0) {
                        this.f3962a.write(bwl, j);
                        return;
                    }
                    return;
                }
                throw new IllegalArgumentException("FRAME_TOO_LARGE max size is 16Mib: " + i3);
            }
            throw new IOException("closed");
        }

        /* renamed from: a */
        private void m9705a(List<bue> list) {
            this.f3964c.mo3857j(list.size());
            int size = list.size();
            for (int i = 0; i < size; i++) {
                bwq bwq = list.get(i).f3834h;
                this.f3964c.mo3857j(bwq.mo3951n());
                this.f3964c.mo3816b(bwq);
                bwq bwq2 = list.get(i).f3835i;
                this.f3964c.mo3857j(bwq2.mo3951n());
                this.f3964c.mo3816b(bwq2);
            }
            this.f3964c.flush();
        }

        /* renamed from: b */
        public synchronized void mo3519b(bup bup) {
            if (!this.f3966e) {
                int b = bup.mo3660b();
                this.f3962a.mo3857j(-2147287036);
                this.f3962a.mo3857j((((b * 8) + 4) & ACCELCAL_VEHICLE_POS.ACCELCAL_VEHICLE_POS_SUCCESS) | 0);
                this.f3962a.mo3857j(b);
                for (int i = 0; i <= 10; i++) {
                    if (bup.mo3658a(i)) {
                        this.f3962a.mo3857j(((bup.mo3663c(i) & 255) << 24) | (i & ACCELCAL_VEHICLE_POS.ACCELCAL_VEHICLE_POS_SUCCESS));
                        this.f3962a.mo3857j(bup.mo3661b(i));
                    }
                }
                this.f3962a.flush();
            } else {
                throw new IOException("closed");
            }
        }

        /* renamed from: a */
        public synchronized void mo3514a(boolean z, int i, int i2) {
            if (!this.f3966e) {
                boolean z2 = false;
                if (this.f3965d != ((i & 1) == 1)) {
                    z2 = true;
                }
                if (z == z2) {
                    this.f3962a.mo3857j(-2147287034);
                    this.f3962a.mo3857j(4);
                    this.f3962a.mo3857j(i);
                    this.f3962a.flush();
                } else {
                    throw new IllegalArgumentException("payload != reply");
                }
            } else {
                throw new IOException("closed");
            }
        }

        /* renamed from: a */
        public synchronized void mo3511a(int i, btn btn, byte[] bArr) {
            if (this.f3966e) {
                throw new IOException("closed");
            } else if (btn.f3729u != -1) {
                this.f3962a.mo3857j(-2147287033);
                this.f3962a.mo3857j(8);
                this.f3962a.mo3857j(i);
                this.f3962a.mo3857j(btn.f3729u);
                this.f3962a.flush();
            } else {
                throw new IllegalArgumentException("errorCode.spdyGoAwayCode == -1");
            }
        }

        /* renamed from: a */
        public synchronized void mo3509a(int i, long j) {
            if (this.f3966e) {
                throw new IOException("closed");
            } else if (j == 0 || j > 2147483647L) {
                throw new IllegalArgumentException("windowSizeIncrement must be between 1 and 0x7fffffff: " + j);
            } else {
                this.f3962a.mo3857j(-2147287031);
                this.f3962a.mo3857j(8);
                this.f3962a.mo3857j(i);
                this.f3962a.mo3857j((int) j);
                this.f3962a.flush();
            }
        }

        public synchronized void close() {
            this.f3966e = true;
            bsp.m9159a((Closeable) this.f3962a, (Closeable) this.f3964c);
        }
    }
}
