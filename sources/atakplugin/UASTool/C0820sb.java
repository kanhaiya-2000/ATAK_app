package atakplugin.UASTool;

import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbDeviceConnection;
import android.hardware.usb.UsbEndpoint;
import android.hardware.usb.UsbInterface;
import android.hardware.usb.UsbRequest;
import android.util.Log;
import atakplugin.UASTool.C0847ss;

/* renamed from: atakplugin.UASTool.sb */
public class C0820sb extends C0842sq {

    /* renamed from: W */
    private static final int f6195W = 45697;

    /* renamed from: X */
    private static final int f6196X = 59;

    /* renamed from: Y */
    private static final int f6197Y = 55681;

    /* renamed from: Z */
    private static final int f6198Z = 30;

    /* renamed from: a */
    private static final String f6199a = "sb";

    /* renamed from: aa */
    private static final int f6200aa = 25730;

    /* renamed from: ab */
    private static final int f6201ab = 15;

    /* renamed from: ac */
    private static final int f6202ac = 45698;

    /* renamed from: ad */
    private static final int f6203ad = 8;

    /* renamed from: ae */
    private static final int f6204ae = 55682;

    /* renamed from: af */
    private static final int f6205af = 7;

    /* renamed from: ag */
    private static final int f6206ag = 25731;

    /* renamed from: ah */
    private static final int f6207ah = 39043;

    /* renamed from: ai */
    private static final int f6208ai = 52355;

    /* renamed from: aj */
    private static final int f6209aj = 59011;

    /* renamed from: ak */
    private static final int f6210ak = 62339;

    /* renamed from: al */
    private static final int f6211al = 62343;

    /* renamed from: am */
    private static final int f6212am = 64259;

    /* renamed from: an */
    private static final int f6213an = 33;

    /* renamed from: ao */
    private static final int f6214ao = 64771;

    /* renamed from: ap */
    private static final int f6215ap = 2;

    /* renamed from: aq */
    private static final int f6216aq = 195;

    /* renamed from: ar */
    private static final int f6217ar = 203;

    /* renamed from: as */
    private static final int f6218as = 219;

    /* renamed from: at */
    private static final int f6219at = 235;

    /* renamed from: au */
    private static final int f6220au = 251;

    /* renamed from: av */
    private static final int f6221av = 0;

    /* renamed from: aw */
    private static final int f6222aw = 257;

    /* renamed from: ax */
    private static final int f6223ax = 514;

    /* renamed from: b */
    private static final int f6224b = 9600;

    /* renamed from: c */
    private static final int f6225c = 192;

    /* renamed from: d */
    private static final int f6226d = 64;

    /* renamed from: e */
    private static final int f6227e = 154;

    /* renamed from: f */
    private static final int f6228f = 149;

    /* renamed from: g */
    private static final int f6229g = 5;

    /* renamed from: h */
    private static final int f6230h = 24;

    /* renamed from: i */
    private static final int f6231i = 1;

    /* renamed from: j */
    private static final int f6232j = 64;

    /* renamed from: k */
    private static final int f6233k = 55680;

    /* renamed from: l */
    private static final int f6234l = 235;

    /* renamed from: m */
    private static final int f6235m = 25729;

    /* renamed from: n */
    private static final int f6236n = 118;

    /* renamed from: aA */
    private UsbEndpoint f6237aA;

    /* renamed from: aB */
    private C0821a f6238aB;
    /* access modifiers changed from: private */

    /* renamed from: aC */
    public C0847ss.C0849b f6239aC;
    /* access modifiers changed from: private */

    /* renamed from: aD */
    public C0847ss.C0850c f6240aD;
    /* access modifiers changed from: private */

    /* renamed from: aE */
    public boolean f6241aE;
    /* access modifiers changed from: private */

    /* renamed from: aF */
    public boolean f6242aF;

    /* renamed from: aG */
    private boolean f6243aG;

    /* renamed from: aH */
    private boolean f6244aH;
    /* access modifiers changed from: private */

    /* renamed from: aI */
    public boolean f6245aI;
    /* access modifiers changed from: private */

    /* renamed from: aJ */
    public boolean f6246aJ;

    /* renamed from: ay */
    private UsbInterface f6247ay;

    /* renamed from: az */
    private UsbEndpoint f6248az;

    /* renamed from: a */
    public void mo5683a(C0847ss.C0848a aVar) {
    }

    /* renamed from: a */
    public void mo5686a(C0847ss.C0851d dVar) {
    }

    /* renamed from: a */
    public void mo5687a(C0847ss.C0852e eVar) {
    }

    /* renamed from: a */
    public void mo5688a(C0847ss.C0853f fVar) {
    }

    /* renamed from: a */
    public void mo5689a(boolean z) {
    }

    /* renamed from: b */
    public void mo5692b(int i) {
    }

    /* renamed from: c */
    public void mo5694c(int i) {
    }

    public C0820sb(UsbDevice usbDevice, UsbDeviceConnection usbDeviceConnection) {
        super(usbDevice, usbDeviceConnection);
        this.f6243aG = false;
        this.f6244aH = false;
        this.f6245aI = false;
        this.f6246aJ = false;
    }

    public C0820sb(UsbDevice usbDevice, UsbDeviceConnection usbDeviceConnection, int i) {
        super(usbDevice, usbDeviceConnection);
        this.f6243aG = false;
        this.f6244aH = false;
        this.f6245aI = false;
        this.f6246aJ = false;
        this.f6241aE = false;
        this.f6242aF = false;
        this.f6247ay = usbDevice.getInterface(i < 0 ? 0 : i);
    }

    /* renamed from: a */
    public boolean mo5690a() {
        if (m13528f()) {
            C0865sz szVar = new C0865sz();
            szVar.initialize(this.f6449w, this.f6248az);
            mo5764o();
            mo5766q();
            m13537v();
            mo5750a((UsbRequest) szVar, this.f6237aA);
            this.f6443E = true;
            this.f6444F = true;
            return true;
        }
        this.f6444F = false;
        return false;
    }

    /* renamed from: b */
    public void mo5691b() {
        mo5763n();
        mo5765p();
        m13539x();
        this.f6449w.releaseInterface(this.f6247ay);
        this.f6444F = false;
    }

    /* renamed from: c */
    public boolean mo5696c() {
        if (m13528f()) {
            m13537v();
            mo5749a(this.f6248az, this.f6237aA);
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
        m13539x();
        this.f6449w.releaseInterface(this.f6247ay);
        this.f6444F = false;
    }

    /* renamed from: a */
    public void mo5682a(int i) {
        if (i <= 300) {
            if (m13516a((int) f6233k, 235) == -1) {
                Log.i(f6199a, "SetBaudRate failed!");
            }
        } else if (i <= 300 || i > 600) {
            if (i <= 600 || i > 1200) {
                if (i <= 1200 || i > 2400) {
                    if (i <= 2400 || i > 4800) {
                        if (i <= 4800 || i > f6224b) {
                            if (i <= f6224b || i > 19200) {
                                if (i <= 19200 || i > 38400) {
                                    if (i <= 38400 || i > 57600) {
                                        if (i <= 57600 || i > 115200) {
                                            if (i <= 115200 || i > 230400) {
                                                if (i <= 230400 || i > 460800) {
                                                    if (i <= 460800 || i > 921600) {
                                                        if (i <= 921600 || i > 1228800) {
                                                            if (i > 1228800 && i <= 2000000 && m13516a((int) f6214ao, 2) == -1) {
                                                                Log.i(f6199a, "SetBaudRate failed!");
                                                            }
                                                        } else if (m13516a((int) f6212am, 33) == -1) {
                                                            Log.i(f6199a, "SetBaudRate failed!");
                                                        }
                                                    } else if (m13516a((int) f6211al, 7) == -1) {
                                                        Log.i(f6199a, "SetBaudRate failed!");
                                                    }
                                                } else if (m13516a((int) f6210ak, 7) == -1) {
                                                    Log.i(f6199a, "SetBaudRate failed!");
                                                }
                                            } else if (m13516a((int) f6209aj, 7) == -1) {
                                                Log.i(f6199a, "SetBaudRate failed!");
                                            }
                                        } else if (m13516a((int) f6208ai, 7) == -1) {
                                            Log.i(f6199a, "SetBaudRate failed!");
                                        }
                                    } else if (m13516a((int) f6207ah, 7) == -1) {
                                        Log.i(f6199a, "SetBaudRate failed!");
                                    }
                                } else if (m13516a((int) f6206ag, 7) == -1) {
                                    Log.i(f6199a, "SetBaudRate failed!");
                                }
                            } else if (m13516a((int) f6204ae, 7) == -1) {
                                Log.i(f6199a, "SetBaudRate failed!");
                            }
                        } else if (m13516a((int) f6202ac, 8) == -1) {
                            Log.i(f6199a, "SetBaudRate failed!");
                        }
                    } else if (m13516a((int) f6200aa, 15) == -1) {
                        Log.i(f6199a, "SetBaudRate failed!");
                    }
                } else if (m13516a((int) f6197Y, 30) == -1) {
                    Log.i(f6199a, "SetBaudRate failed!");
                }
            } else if (m13516a((int) f6195W, 59) == -1) {
                Log.i(f6199a, "SetBaudRate failed!");
            }
        } else if (m13516a((int) f6235m, 118) == -1) {
            Log.i(f6199a, "SetBaudRate failed!");
        }
    }

    /* renamed from: d */
    public void mo5698d(int i) {
        if (i == 0) {
            m13529g(195);
        } else if (i == 1) {
            m13529g(203);
        } else if (i == 2) {
            m13529g(219);
        } else if (i == 3) {
            m13529g(235);
        } else if (i == 4) {
            m13529g(251);
        }
    }

    /* renamed from: e */
    public void mo5699e(int i) {
        if (i == 0) {
            this.f6241aE = false;
            this.f6242aF = false;
            m13531h(0);
        } else if (i == 1) {
            this.f6241aE = true;
            this.f6242aF = false;
            m13531h((int) f6222aw);
            this.f6245aI = m13534s();
            m13538w();
        } else if (i == 2) {
            this.f6241aE = false;
            this.f6242aF = true;
            m13531h((int) f6223ax);
            this.f6246aJ = m13535t();
            m13538w();
        }
    }

    /* renamed from: b */
    public void mo5693b(boolean z) {
        this.f6244aH = z;
        m13536u();
    }

    /* renamed from: c */
    public void mo5695c(boolean z) {
        this.f6243aG = z;
        m13536u();
    }

    /* renamed from: a */
    public void mo5684a(C0847ss.C0849b bVar) {
        this.f6239aC = bVar;
    }

    /* renamed from: a */
    public void mo5685a(C0847ss.C0850c cVar) {
        this.f6240aD = cVar;
    }

    /* renamed from: f */
    private boolean m13528f() {
        if (this.f6449w.claimInterface(this.f6247ay, true)) {
            Log.i(f6199a, "Interface succesfully claimed");
            int endpointCount = this.f6247ay.getEndpointCount();
            for (int i = 0; i <= endpointCount - 1; i++) {
                UsbEndpoint endpoint = this.f6247ay.getEndpoint(i);
                if (endpoint.getType() == 2 && endpoint.getDirection() == 128) {
                    this.f6248az = endpoint;
                } else if (endpoint.getType() == 2 && endpoint.getDirection() == 0) {
                    this.f6237aA = endpoint;
                }
            }
            if (m13533r() == 0) {
                return true;
            }
            return false;
        }
        Log.i(f6199a, "Interface could not be claimed");
        return false;
    }

    /* renamed from: r */
    private int m13533r() {
        if (m13517a(161, 49820, 45753, (byte[]) null) < 0) {
            Log.i(f6199a, "init failed! #1");
            return -1;
        } else if (m13517a(164, 223, 0, (byte[]) null) < 0) {
            Log.i(f6199a, "init failed! #2");
            return -1;
        } else if (m13517a(164, 159, 0, (byte[]) null) < 0) {
            Log.i(f6199a, "init failed! #3");
            return -1;
        } else if (m13518a("init #4", 149, 1798, new int[]{159, 238}) == -1) {
            return -1;
        } else {
            if (m13517a(154, 10023, 0, (byte[]) null) < 0) {
                Log.i(f6199a, "init failed! #5");
                return -1;
            } else if (m13517a(154, 4882, (int) f6202ac, (byte[]) null) < 0) {
                Log.i(f6199a, "init failed! #6");
                return -1;
            } else if (m13517a(154, 3884, 8, (byte[]) null) < 0) {
                Log.i(f6199a, "init failed! #7");
                return -1;
            } else if (m13517a(154, 9496, 195, (byte[]) null) < 0) {
                Log.i(f6199a, "init failed! #8");
                return -1;
            } else if (m13518a("init #9", 149, 1798, new int[]{159, 238}) == -1) {
                return -1;
            } else {
                if (m13517a(154, 10023, 0, (byte[]) null) >= 0) {
                    return 0;
                }
                Log.i(f6199a, "init failed! #10");
                return -1;
            }
        }
    }

    /* renamed from: a */
    private int m13516a(int i, int i2) {
        if (m13517a(154, 4882, i, (byte[]) null) >= 0 && m13517a(154, 3884, i2, (byte[]) null) >= 0 && m13518a("set_baud_rate", 149, 1798, new int[]{159, 238}) != -1 && m13517a(154, 10023, 0, (byte[]) null) >= 0) {
            return 0;
        }
        return -1;
    }

    /* renamed from: g */
    private int m13529g(int i) {
        if (m13517a(154, 9496, i, (byte[]) null) >= 0 && m13518a("set_parity", 149, 1798, new int[]{159, 238}) != -1 && m13517a(154, 10023, 0, (byte[]) null) >= 0) {
            return 0;
        }
        return -1;
    }

    /* renamed from: h */
    private int m13531h(int i) {
        if (m13518a("set_flow_control", 149, 1798, new int[]{159, 238}) == -1 || m13517a(154, 10023, i, (byte[]) null) == -1) {
            return -1;
        }
        return 0;
    }

    /* renamed from: a */
    private int m13518a(String str, int i, int i2, int[] iArr) {
        int b = m13521b(i, i2, 0, new byte[iArr.length]);
        if (b == iArr.length) {
            return 0;
        }
        String str2 = f6199a;
        Log.i(str2, "Expected " + iArr.length + " bytes, but get " + b + " [" + str + "]");
        return -1;
    }

    /* access modifiers changed from: private */
    /* renamed from: s */
    public boolean m13534s() {
        byte[] bArr = new byte[2];
        int b = m13521b(149, 1798, 0, bArr);
        if (b != 2) {
            String str = f6199a;
            Log.i(str, "Expected 2 bytes, but get " + b);
            return false;
        } else if ((bArr[0] & 1) == 0) {
            return true;
        } else {
            return false;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: t */
    public boolean m13535t() {
        byte[] bArr = new byte[2];
        int b = m13521b(149, 1798, 0, bArr);
        if (b != 2) {
            String str = f6199a;
            Log.i(str, "Expected 2 bytes, but get " + b);
            return false;
        } else if ((2 & bArr[0]) == 0) {
            return true;
        } else {
            return false;
        }
    }

    /* renamed from: u */
    private int m13536u() {
        if (m13517a(164, ~((this.f6243aG ? 32 : 0) | (this.f6244aH ? 64 : 0)), 0, (byte[]) null) >= 0) {
            return 0;
        }
        Log.i(f6199a, "Failed to set handshake byte");
        return -1;
    }

    /* renamed from: a */
    private int m13517a(int i, int i2, int i3, byte[] bArr) {
        int controlTransfer = this.f6449w.controlTransfer(64, i, i2, i3, bArr, bArr != null ? bArr.length : 0, 0);
        String str = f6199a;
        Log.i(str, "Control Transfer Response: " + String.valueOf(controlTransfer));
        return controlTransfer;
    }

    /* renamed from: b */
    private int m13521b(int i, int i2, int i3, byte[] bArr) {
        int controlTransfer = this.f6449w.controlTransfer(192, i, i2, i3, bArr, bArr != null ? bArr.length : 0, 0);
        String str = f6199a;
        Log.i(str, "Control Transfer Response: " + String.valueOf(controlTransfer));
        return controlTransfer;
    }

    /* renamed from: v */
    private void m13537v() {
        this.f6238aB = new C0821a();
    }

    /* renamed from: w */
    private void m13538w() {
        if (!this.f6238aB.isAlive()) {
            this.f6238aB.start();
        }
    }

    /* renamed from: x */
    private void m13539x() {
        C0821a aVar = this.f6238aB;
        if (aVar != null) {
            aVar.mo5679a();
            this.f6238aB = null;
        }
    }

    /* renamed from: atakplugin.UASTool.sb$a */
    private class C0821a extends C0815rx {

        /* renamed from: c */
        private final long f6250c;

        private C0821a() {
            this.f6250c = 100;
        }

        /* renamed from: b */
        public void mo5680b() {
            if (!this.f6157a) {
                if (C0820sb.this.f6241aE && C0820sb.this.f6245aI != mo5704c()) {
                    C0820sb sbVar = C0820sb.this;
                    boolean unused = sbVar.f6245aI = !sbVar.f6245aI;
                    if (C0820sb.this.f6239aC != null) {
                        C0820sb.this.f6239aC.mo5774a(C0820sb.this.f6245aI);
                    }
                }
                if (C0820sb.this.f6242aF && C0820sb.this.f6246aJ != mo5705d()) {
                    C0820sb sbVar2 = C0820sb.this;
                    boolean unused2 = sbVar2.f6246aJ = !sbVar2.f6246aJ;
                    if (C0820sb.this.f6240aD != null) {
                        C0820sb.this.f6240aD.mo5775a(C0820sb.this.f6246aJ);
                        return;
                    }
                    return;
                }
                return;
            }
            if (C0820sb.this.f6241aE && C0820sb.this.f6239aC != null) {
                C0820sb.this.f6239aC.mo5774a(C0820sb.this.f6245aI);
            }
            if (C0820sb.this.f6242aF && C0820sb.this.f6240aD != null) {
                C0820sb.this.f6240aD.mo5775a(C0820sb.this.f6246aJ);
            }
            this.f6157a = false;
        }

        /* renamed from: c */
        public boolean mo5704c() {
            synchronized (this) {
                try {
                    wait(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return C0820sb.this.m13534s();
        }

        /* renamed from: d */
        public boolean mo5705d() {
            synchronized (this) {
                try {
                    wait(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return C0820sb.this.m13535t();
        }
    }
}
