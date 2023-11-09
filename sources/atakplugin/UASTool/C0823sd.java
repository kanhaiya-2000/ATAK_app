package atakplugin.UASTool;

import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbDeviceConnection;
import android.hardware.usb.UsbEndpoint;
import android.hardware.usb.UsbInterface;
import android.hardware.usb.UsbRequest;
import android.util.Log;
import atakplugin.UASTool.C0847ss;

/* renamed from: atakplugin.UASTool.sd */
public class C0823sd extends C0842sq {

    /* renamed from: W */
    private static final int f6251W = 16;

    /* renamed from: X */
    private static final int f6252X = 65;

    /* renamed from: Y */
    private static final int f6253Y = 193;

    /* renamed from: Z */
    private static final int f6254Z = 1;

    /* renamed from: a */
    private static final String f6255a = "sd";

    /* renamed from: aa */
    private static final int f6256aa = 0;

    /* renamed from: ab */
    private static final int f6257ab = 514;

    /* renamed from: ac */
    private static final int f6258ac = 512;

    /* renamed from: ad */
    private static final int f6259ad = 257;

    /* renamed from: ae */
    private static final int f6260ae = 256;

    /* renamed from: af */
    private static final int f6261af = 15;

    /* renamed from: ag */
    private static final int f6262ag = 1;

    /* renamed from: ah */
    private static final int f6263ah = 0;

    /* renamed from: ai */
    private static final int f6264ai = 2048;

    /* renamed from: aj */
    private static final int f6265aj = 0;

    /* renamed from: ak */
    private static final int f6266ak = 1;

    /* renamed from: al */
    private static final int f6267al = 16;

    /* renamed from: am */
    private static final int f6268am = 17;

    /* renamed from: an */
    private static final int f6269an = 0;

    /* renamed from: ao */
    private static final int f6270ao = 0;

    /* renamed from: ap */
    private static final int f6271ap = 9600;

    /* renamed from: b */
    private static final int f6272b = 18;

    /* renamed from: c */
    private static final int f6273c = 0;

    /* renamed from: d */
    private static final int f6274d = 1;

    /* renamed from: e */
    private static final int f6275e = 3;

    /* renamed from: f */
    private static final int f6276f = 4;

    /* renamed from: g */
    private static final int f6277g = 5;

    /* renamed from: h */
    private static final int f6278h = 7;

    /* renamed from: i */
    private static final int f6279i = 30;

    /* renamed from: j */
    private static final int f6280j = 19;

    /* renamed from: k */
    private static final int f6281k = 9;

    /* renamed from: l */
    private static final int f6282l = 10;

    /* renamed from: m */
    private static final int f6283m = 25;

    /* renamed from: n */
    private static final int f6284n = 8;
    /* access modifiers changed from: private */

    /* renamed from: aA */
    public C0847ss.C0853f f6285aA;
    /* access modifiers changed from: private */

    /* renamed from: aB */
    public C0847ss.C0848a f6286aB;
    /* access modifiers changed from: private */

    /* renamed from: aC */
    public C0847ss.C0851d f6287aC;
    /* access modifiers changed from: private */

    /* renamed from: aD */
    public C0847ss.C0852e f6288aD;
    /* access modifiers changed from: private */

    /* renamed from: aq */
    public boolean f6289aq;
    /* access modifiers changed from: private */

    /* renamed from: ar */
    public boolean f6290ar;
    /* access modifiers changed from: private */

    /* renamed from: as */
    public boolean f6291as;
    /* access modifiers changed from: private */

    /* renamed from: at */
    public boolean f6292at;
    /* access modifiers changed from: private */

    /* renamed from: au */
    public C0847ss.C0849b f6293au;
    /* access modifiers changed from: private */

    /* renamed from: av */
    public C0847ss.C0850c f6294av;

    /* renamed from: aw */
    private final UsbInterface f6295aw;

    /* renamed from: ax */
    private UsbEndpoint f6296ax;

    /* renamed from: ay */
    private UsbEndpoint f6297ay;

    /* renamed from: az */
    private C0824a f6298az;

    public C0823sd(UsbDevice usbDevice, UsbDeviceConnection usbDeviceConnection) {
        this(usbDevice, usbDeviceConnection, -1);
    }

    public C0823sd(UsbDevice usbDevice, UsbDeviceConnection usbDeviceConnection, int i) {
        super(usbDevice, usbDeviceConnection);
        this.f6289aq = false;
        this.f6290ar = false;
        this.f6291as = true;
        this.f6292at = true;
        this.f6295aw = usbDevice.getInterface(i < 0 ? 0 : i);
    }

    /* renamed from: a */
    public boolean mo5690a() {
        if (m13569f()) {
            C0865sz szVar = new C0865sz();
            szVar.initialize(this.f6449w, this.f6296ax);
            mo5764o();
            mo5766q();
            m13577r();
            mo5750a((UsbRequest) szVar, this.f6297ay);
            this.f6443E = true;
            this.f6444F = true;
            return true;
        }
        this.f6444F = false;
        return false;
    }

    /* renamed from: b */
    public void mo5691b() {
        m13561a(18, 15, (byte[]) null);
        m13561a(0, 0, (byte[]) null);
        mo5763n();
        mo5765p();
        m13579t();
        this.f6449w.releaseInterface(this.f6295aw);
        this.f6444F = false;
    }

    /* renamed from: c */
    public boolean mo5696c() {
        if (m13569f()) {
            m13577r();
            mo5749a(this.f6296ax, this.f6297ay);
            this.f6443E = false;
            this.f6444F = true;
            this.f6441C = new C0833sk(this);
            this.f6442D = new C0834sl(this);
            return true;
        }
        this.f6444F = false;
        return false;
    }

    /* renamed from: d */
    public void mo5697d() {
        m13561a(18, 15, (byte[]) null);
        m13561a(0, 0, (byte[]) null);
        m13579t();
        this.f6449w.releaseInterface(this.f6295aw);
        this.f6444F = false;
    }

    /* renamed from: a */
    public void mo5682a(int i) {
        m13561a(30, 0, new byte[]{(byte) (i & 255), (byte) ((i >> 8) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 24) & 255)});
    }

    /* renamed from: b */
    public void mo5692b(int i) {
        short s;
        short w = (short) (m13582w() & -3841);
        if (i == 5) {
            s = w | 1280;
        } else if (i == 6) {
            s = w | 1536;
        } else if (i == 7) {
            s = w | 1792;
        } else if (i == 8) {
            s = w | 2048;
        } else {
            return;
        }
        m13561a(3, (short) s, (byte[]) null);
    }

    /* renamed from: c */
    public void mo5694c(int i) {
        short s;
        short w = (short) (m13582w() & -4);
        if (i == 1) {
            s = w | 0;
        } else if (i == 2) {
            s = w | 2;
        } else if (i == 3) {
            s = w | 1;
        } else {
            return;
        }
        m13561a(3, (short) s, (byte[]) null);
    }

    /* renamed from: d */
    public void mo5698d(int i) {
        short s;
        short w = (short) (m13582w() & -241);
        if (i == 0) {
            s = w | 0;
        } else if (i == 1) {
            s = w | 16;
        } else if (i == 2) {
            s = w | 32;
        } else if (i == 3) {
            s = w | 48;
        } else if (i == 4) {
            s = w | 64;
        } else {
            return;
        }
        m13561a(3, (short) s, (byte[]) null);
    }

    /* renamed from: e */
    public void mo5699e(int i) {
        boolean z = false;
        if (i == 0) {
            this.f6289aq = false;
            this.f6290ar = false;
            m13561a(19, 0, new byte[]{1, 0, 0, 0, 64, 0, 0, 0, 0, Byte.MIN_VALUE, 0, 0, 0, 32, 0, 0});
        } else if (i == 1) {
            this.f6289aq = true;
            this.f6290ar = false;
            m13561a(19, 0, new byte[]{9, 0, 0, 0, 64, 0, 0, 0, 0, Byte.MIN_VALUE, 0, 0, 0, 32, 0, 0});
            m13561a(7, f6257ab, (byte[]) null);
            if ((m13581v()[4] & 1) == 0) {
                z = true;
            }
            this.f6291as = z;
            m13578s();
        } else if (i == 2) {
            this.f6290ar = true;
            this.f6289aq = false;
            m13561a(19, 0, new byte[]{17, 0, 0, 0, 64, 0, 0, 0, 0, Byte.MIN_VALUE, 0, 0, 0, 32, 0, 0});
            m13561a(7, f6259ad, (byte[]) null);
            if ((m13581v()[4] & 2) == 0) {
                z = true;
            }
            this.f6292at = z;
            m13578s();
        } else if (i == 3) {
            m13561a(25, 0, new byte[]{0, 0, 0, 0, 17, 19});
            m13561a(19, 0, new byte[]{1, 0, 0, 0, 67, 0, 0, 0, 0, Byte.MIN_VALUE, 0, 0, 0, 32, 0, 0});
        }
    }

    /* renamed from: a */
    public void mo5689a(boolean z) {
        if (z) {
            m13561a(5, 1, (byte[]) null);
        } else {
            m13561a(5, 0, (byte[]) null);
        }
    }

    /* renamed from: b */
    public void mo5693b(boolean z) {
        if (z) {
            m13561a(7, f6257ab, (byte[]) null);
        } else {
            m13561a(7, 512, (byte[]) null);
        }
    }

    /* renamed from: c */
    public void mo5695c(boolean z) {
        if (z) {
            m13561a(7, f6259ad, (byte[]) null);
        } else {
            m13561a(7, 256, (byte[]) null);
        }
    }

    /* renamed from: a */
    public void mo5684a(C0847ss.C0849b bVar) {
        this.f6293au = bVar;
    }

    /* renamed from: a */
    public void mo5685a(C0847ss.C0850c cVar) {
        this.f6294av = cVar;
    }

    /* renamed from: a */
    public void mo5683a(C0847ss.C0848a aVar) {
        this.f6286aB = aVar;
    }

    /* renamed from: a */
    public void mo5686a(C0847ss.C0851d dVar) {
        this.f6287aC = dVar;
    }

    /* renamed from: a */
    public void mo5687a(C0847ss.C0852e eVar) {
        this.f6288aD = eVar;
    }

    /* renamed from: a */
    public void mo5688a(C0847ss.C0853f fVar) {
        this.f6285aA = fVar;
        m13578s();
    }

    /* renamed from: atakplugin.UASTool.sd$a */
    private class C0824a extends C0815rx {

        /* renamed from: c */
        private final long f6300c;

        private C0824a() {
            this.f6300c = 40;
        }

        /* renamed from: b */
        public void mo5680b() {
            if (!this.f6157a) {
                byte[] c = m13601c();
                byte[] a = C0823sd.this.m13581v();
                if (C0823sd.this.f6289aq) {
                    if (C0823sd.this.f6291as != ((c[0] & 16) == 16)) {
                        C0823sd sdVar = C0823sd.this;
                        boolean unused = sdVar.f6291as = !sdVar.f6291as;
                        if (C0823sd.this.f6293au != null) {
                            C0823sd.this.f6293au.mo5774a(C0823sd.this.f6291as);
                        }
                    }
                }
                if (C0823sd.this.f6290ar) {
                    if (C0823sd.this.f6292at != ((c[0] & 32) == 32)) {
                        C0823sd sdVar2 = C0823sd.this;
                        boolean unused2 = sdVar2.f6292at = !sdVar2.f6292at;
                        if (C0823sd.this.f6294av != null) {
                            C0823sd.this.f6294av.mo5775a(C0823sd.this.f6292at);
                        }
                    }
                }
                if (C0823sd.this.f6285aA != null && (a[0] & 16) == 16) {
                    C0823sd.this.f6285aA.mo5778a();
                }
                if (C0823sd.this.f6287aC != null && (a[0] & 2) == 2) {
                    C0823sd.this.f6287aC.mo5776a();
                }
                if (C0823sd.this.f6286aB != null && (a[0] & 1) == 1) {
                    C0823sd.this.f6286aB.mo5773a();
                }
                if (C0823sd.this.f6288aD == null) {
                    return;
                }
                if ((a[0] & 4) == 4 || (a[0] & 8) == 8) {
                    C0823sd.this.f6288aD.mo5777a();
                    return;
                }
                return;
            }
            if (C0823sd.this.f6289aq && C0823sd.this.f6293au != null) {
                C0823sd.this.f6293au.mo5774a(C0823sd.this.f6291as);
            }
            if (C0823sd.this.f6290ar && C0823sd.this.f6294av != null) {
                C0823sd.this.f6294av.mo5775a(C0823sd.this.f6292at);
            }
            this.f6157a = false;
        }

        /* renamed from: c */
        private byte[] m13601c() {
            synchronized (this) {
                try {
                    wait(40);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return C0823sd.this.m13580u();
        }
    }

    /* renamed from: f */
    private boolean m13569f() {
        if (this.f6449w.claimInterface(this.f6295aw, true)) {
            Log.i(f6255a, "Interface succesfully claimed");
            int endpointCount = this.f6295aw.getEndpointCount();
            for (int i = 0; i <= endpointCount - 1; i++) {
                UsbEndpoint endpoint = this.f6295aw.getEndpoint(i);
                if (endpoint.getType() == 2 && endpoint.getDirection() == 128) {
                    this.f6296ax = endpoint;
                } else {
                    this.f6297ay = endpoint;
                }
            }
            if (m13561a(0, 1, (byte[]) null) < 0) {
                return false;
            }
            mo5682a((int) f6271ap);
            if (m13561a(3, 2048, (byte[]) null) < 0) {
                return false;
            }
            mo5699e(0);
            return m13561a(7, 0, (byte[]) null) >= 0;
        }
        Log.i(f6255a, "Interface could not be claimed");
        return false;
    }

    /* renamed from: r */
    private void m13577r() {
        this.f6298az = new C0824a();
    }

    /* renamed from: s */
    private void m13578s() {
        if (!this.f6298az.isAlive()) {
            this.f6298az.start();
        }
    }

    /* renamed from: t */
    private void m13579t() {
        C0824a aVar = this.f6298az;
        if (aVar != null) {
            aVar.mo5679a();
            this.f6298az = null;
        }
    }

    /* renamed from: a */
    private int m13561a(int i, int i2, byte[] bArr) {
        int controlTransfer = this.f6449w.controlTransfer(65, i, i2, this.f6295aw.getId(), bArr, bArr != null ? bArr.length : 0, 0);
        String str = f6255a;
        Log.i(str, "Control Transfer Response: " + String.valueOf(controlTransfer));
        return controlTransfer;
    }

    /* access modifiers changed from: private */
    /* renamed from: u */
    public byte[] m13580u() {
        byte[] bArr = new byte[1];
        this.f6449w.controlTransfer(193, 8, 0, this.f6295aw.getId(), bArr, 1, 0);
        return bArr;
    }

    /* access modifiers changed from: private */
    /* renamed from: v */
    public byte[] m13581v() {
        byte[] bArr = new byte[19];
        int controlTransfer = this.f6449w.controlTransfer(193, 16, 0, this.f6295aw.getId(), bArr, 19, 0);
        String str = f6255a;
        Log.i(str, "Control Transfer Response (Comm status): " + String.valueOf(controlTransfer));
        return bArr;
    }

    /* renamed from: w */
    private short m13582w() {
        byte[] bArr = new byte[2];
        int controlTransfer = this.f6449w.controlTransfer(193, 4, 0, this.f6295aw.getId(), bArr, 2, 0);
        String str = f6255a;
        Log.i(str, "Control Transfer Response: " + String.valueOf(controlTransfer));
        return (short) ((bArr[0] & 255) | (bArr[1] << 8));
    }
}
