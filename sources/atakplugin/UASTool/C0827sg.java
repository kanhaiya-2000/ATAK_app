package atakplugin.UASTool;

import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbDeviceConnection;
import android.hardware.usb.UsbEndpoint;
import android.hardware.usb.UsbInterface;
import android.hardware.usb.UsbRequest;
import android.os.Build;
import android.util.Log;
import atakplugin.UASTool.C0847ss;
import com.google.common.base.Ascii;
import java.util.Arrays;

/* renamed from: atakplugin.UASTool.sg */
public class C0827sg extends C0842sq {

    /* renamed from: W */
    private static final String f6320W = "sg";

    /* renamed from: X */
    private static final int f6321X = 0;

    /* renamed from: Y */
    private static final int f6322Y = 1;

    /* renamed from: Z */
    private static final int f6323Z = 2;

    /* renamed from: a */
    public static final int f6324a = 10000;

    /* renamed from: aH */
    private static final byte[] f6325aH = new byte[2];

    /* renamed from: aa */
    private static final int f6326aa = 3;

    /* renamed from: ab */
    private static final int f6327ab = 4;

    /* renamed from: ac */
    private static final int f6328ac = 64;

    /* renamed from: ad */
    private static final int f6329ad = 1;

    /* renamed from: ae */
    private static final int f6330ae = 257;

    /* renamed from: af */
    private static final int f6331af = 256;

    /* renamed from: ag */
    private static final int f6332ag = 2;

    /* renamed from: ah */
    private static final int f6333ah = 514;

    /* renamed from: ai */
    private static final int f6334ai = 512;

    /* renamed from: aj */
    private static final int f6335aj = 16384;

    /* renamed from: ak */
    private static final int f6336ak = 0;

    /* renamed from: al */
    private static final int f6337al = 8;

    /* renamed from: am */
    private static final int f6338am = 257;

    /* renamed from: an */
    private static final int f6339an = 514;

    /* renamed from: ao */
    private static final int f6340ao = 256;

    /* renamed from: ap */
    private static final int f6341ap = 512;

    /* renamed from: aq */
    private static final int f6342aq = 0;

    /* renamed from: ar */
    private static final byte[] f6343ar = new byte[0];

    /* renamed from: b */
    public static final int f6344b = 5000;

    /* renamed from: c */
    public static final int f6345c = 2500;

    /* renamed from: d */
    public static final int f6346d = 1250;

    /* renamed from: e */
    public static final int f6347e = 625;

    /* renamed from: f */
    public static final int f6348f = 16696;

    /* renamed from: g */
    public static final int f6349g = 32924;

    /* renamed from: h */
    public static final int f6350h = 49230;

    /* renamed from: i */
    public static final int f6351i = 52;

    /* renamed from: j */
    public static final int f6352j = 26;

    /* renamed from: k */
    public static final int f6353k = 13;

    /* renamed from: l */
    public static final int f6354l = 16390;

    /* renamed from: m */
    public static final int f6355m = 32771;

    /* renamed from: aA */
    private final UsbInterface f6356aA;

    /* renamed from: aB */
    private UsbEndpoint f6357aB;

    /* renamed from: aC */
    private UsbEndpoint f6358aC;
    /* access modifiers changed from: private */

    /* renamed from: aD */
    public C0847ss.C0853f f6359aD;
    /* access modifiers changed from: private */

    /* renamed from: aE */
    public C0847ss.C0851d f6360aE;
    /* access modifiers changed from: private */

    /* renamed from: aF */
    public C0847ss.C0852e f6361aF;
    /* access modifiers changed from: private */

    /* renamed from: aG */
    public C0847ss.C0848a f6362aG;

    /* renamed from: as */
    private int f6363as;
    /* access modifiers changed from: private */

    /* renamed from: at */
    public boolean f6364at;
    /* access modifiers changed from: private */

    /* renamed from: au */
    public boolean f6365au;
    /* access modifiers changed from: private */

    /* renamed from: av */
    public boolean f6366av;
    /* access modifiers changed from: private */

    /* renamed from: aw */
    public boolean f6367aw;
    /* access modifiers changed from: private */

    /* renamed from: ax */
    public boolean f6368ax;
    /* access modifiers changed from: private */

    /* renamed from: ay */
    public C0847ss.C0849b f6369ay;
    /* access modifiers changed from: private */

    /* renamed from: az */
    public C0847ss.C0850c f6370az;

    /* renamed from: n */
    public C0828a f6371n;

    public C0827sg(UsbDevice usbDevice, UsbDeviceConnection usbDeviceConnection) {
        this(usbDevice, usbDeviceConnection, -1);
    }

    public C0827sg(UsbDevice usbDevice, UsbDeviceConnection usbDeviceConnection, int i) {
        super(usbDevice, usbDeviceConnection);
        this.f6363as = 0;
        this.f6371n = new C0828a();
        this.f6364at = false;
        this.f6365au = false;
        this.f6366av = true;
        this.f6367aw = true;
        this.f6368ax = true;
        this.f6356aA = usbDevice.getInterface(i < 0 ? 0 : i);
    }

    /* renamed from: a */
    public boolean mo5690a() {
        if (m13634f()) {
            C0865sz szVar = new C0865sz();
            szVar.initialize(this.f6449w, this.f6357aB);
            mo5764o();
            mo5766q();
            mo5750a((UsbRequest) szVar, this.f6358aC);
            this.f6443E = true;
            this.f6444F = true;
            return true;
        }
        this.f6444F = false;
        return false;
    }

    /* renamed from: b */
    public void mo5691b() {
        m13618a(1, 256, 0);
        m13618a(1, 512, 0);
        this.f6363as = 0;
        mo5763n();
        mo5765p();
        this.f6449w.releaseInterface(this.f6356aA);
        this.f6444F = false;
    }

    /* renamed from: c */
    public boolean mo5696c() {
        if (m13634f()) {
            mo5749a(this.f6357aB, this.f6358aC);
            this.f6443E = false;
            this.f6441C = new C0833sk(this);
            this.f6442D = new C0834sl(this);
            this.f6444F = true;
            return true;
        }
        this.f6444F = false;
        return false;
    }

    /* renamed from: d */
    public void mo5697d() {
        m13618a(1, 256, 0);
        m13618a(1, 512, 0);
        this.f6363as = 0;
        this.f6449w.releaseInterface(this.f6356aA);
        this.f6444F = false;
    }

    /* renamed from: a */
    public void mo5682a(int i) {
        short[] g = m13636g(i);
        if (g != null) {
            m13621a(g);
        } else {
            m13638h(i);
        }
    }

    /* renamed from: b */
    public void mo5692b(int i) {
        if (i == 5) {
            int i2 = this.f6363as | 1;
            this.f6363as = i2;
            int i3 = i2 & -3;
            this.f6363as = i3;
            int i4 = i3 | 4;
            this.f6363as = i4;
            int i5 = i4 & -9;
            this.f6363as = i5;
            m13618a(4, i5, 0);
        } else if (i == 6) {
            int i6 = this.f6363as & -2;
            this.f6363as = i6;
            int i7 = i6 | 2;
            this.f6363as = i7;
            int i8 = i7 | 4;
            this.f6363as = i8;
            int i9 = i8 & -9;
            this.f6363as = i9;
            m13618a(4, i9, 0);
        } else if (i == 7) {
            int i10 = this.f6363as | 1;
            this.f6363as = i10;
            int i11 = i10 | 2;
            this.f6363as = i11;
            int i12 = i11 | 4;
            this.f6363as = i12;
            int i13 = i12 & -9;
            this.f6363as = i13;
            m13618a(4, i13, 0);
        } else if (i != 8) {
            int i14 = this.f6363as & -2;
            this.f6363as = i14;
            int i15 = i14 & -3;
            this.f6363as = i15;
            int i16 = i15 & -5;
            this.f6363as = i16;
            int i17 = i16 | 8;
            this.f6363as = i17;
            m13618a(4, i17, 0);
        } else {
            int i18 = this.f6363as & -2;
            this.f6363as = i18;
            int i19 = i18 & -3;
            this.f6363as = i19;
            int i20 = i19 & -5;
            this.f6363as = i20;
            int i21 = i20 | 8;
            this.f6363as = i21;
            m13618a(4, i21, 0);
        }
    }

    /* renamed from: c */
    public void mo5694c(int i) {
        if (i == 1) {
            int i2 = this.f6363as & -2049;
            this.f6363as = i2;
            int i3 = i2 & -4097;
            this.f6363as = i3;
            int i4 = i3 & -8193;
            this.f6363as = i4;
            m13618a(4, i4, 0);
        } else if (i == 2) {
            int i5 = this.f6363as & -2049;
            this.f6363as = i5;
            int i6 = i5 | 4096;
            this.f6363as = i6;
            int i7 = i6 & -8193;
            this.f6363as = i7;
            m13618a(4, i7, 0);
        } else if (i != 3) {
            int i8 = this.f6363as & -2049;
            this.f6363as = i8;
            int i9 = i8 & -4097;
            this.f6363as = i9;
            int i10 = i9 & -8193;
            this.f6363as = i10;
            m13618a(4, i10, 0);
        } else {
            int i11 = this.f6363as | 2048;
            this.f6363as = i11;
            int i12 = i11 & -4097;
            this.f6363as = i12;
            int i13 = i12 & -8193;
            this.f6363as = i13;
            m13618a(4, i13, 0);
        }
    }

    /* renamed from: d */
    public void mo5698d(int i) {
        if (i == 0) {
            int i2 = this.f6363as & -257;
            this.f6363as = i2;
            int i3 = i2 & -513;
            this.f6363as = i3;
            int i4 = i3 & -1025;
            this.f6363as = i4;
            m13618a(4, i4, 0);
        } else if (i == 1) {
            int i5 = this.f6363as | 256;
            this.f6363as = i5;
            int i6 = i5 & -513;
            this.f6363as = i6;
            int i7 = i6 & -1025;
            this.f6363as = i7;
            m13618a(4, i7, 0);
        } else if (i == 2) {
            int i8 = this.f6363as & -257;
            this.f6363as = i8;
            int i9 = i8 | 512;
            this.f6363as = i9;
            int i10 = i9 & -1025;
            this.f6363as = i10;
            m13618a(4, i10, 0);
        } else if (i == 3) {
            int i11 = this.f6363as | 256;
            this.f6363as = i11;
            int i12 = i11 | 512;
            this.f6363as = i12;
            int i13 = i12 & -1025;
            this.f6363as = i13;
            m13618a(4, i13, 0);
        } else if (i != 4) {
            int i14 = this.f6363as & -257;
            this.f6363as = i14;
            int i15 = i14 & -513;
            this.f6363as = i15;
            int i16 = i15 & -1025;
            this.f6363as = i16;
            m13618a(4, i16, 0);
        } else {
            int i17 = this.f6363as & -257;
            this.f6363as = i17;
            int i18 = i17 & -513;
            this.f6363as = i18;
            int i19 = i18 | 1024;
            this.f6363as = i19;
            m13618a(4, i19, 0);
        }
    }

    /* renamed from: e */
    public void mo5699e(int i) {
        if (i == 0) {
            m13618a(2, 0, 0);
            this.f6364at = false;
            this.f6365au = false;
        } else if (i == 1) {
            this.f6364at = true;
            this.f6365au = false;
            m13618a(2, 0, 1);
        } else if (i == 2) {
            this.f6365au = true;
            this.f6364at = false;
            m13618a(2, 0, 2);
        } else if (i != 3) {
            m13618a(2, 0, 0);
        } else {
            m13618a(2, 4881, 4);
        }
    }

    /* renamed from: a */
    public void mo5689a(boolean z) {
        if (z) {
            this.f6363as |= 16384;
        } else {
            this.f6363as &= -16385;
        }
        m13618a(4, this.f6363as, 0);
    }

    /* renamed from: b */
    public void mo5693b(boolean z) {
        if (z) {
            m13618a(1, 514, 0);
        } else {
            m13618a(1, 512, 0);
        }
    }

    /* renamed from: c */
    public void mo5695c(boolean z) {
        if (z) {
            m13618a(1, 257, 0);
        } else {
            m13618a(1, 256, 0);
        }
    }

    /* renamed from: a */
    public void mo5684a(C0847ss.C0849b bVar) {
        this.f6369ay = bVar;
    }

    /* renamed from: a */
    public void mo5685a(C0847ss.C0850c cVar) {
        this.f6370az = cVar;
    }

    /* renamed from: a */
    public void mo5683a(C0847ss.C0848a aVar) {
        this.f6362aG = aVar;
    }

    /* renamed from: a */
    public void mo5686a(C0847ss.C0851d dVar) {
        this.f6360aE = dVar;
    }

    /* renamed from: a */
    public void mo5687a(C0847ss.C0852e eVar) {
        this.f6361aF = eVar;
    }

    /* renamed from: a */
    public void mo5688a(C0847ss.C0853f fVar) {
        this.f6359aD = fVar;
    }

    /* renamed from: f */
    private boolean m13634f() {
        if (this.f6449w.claimInterface(this.f6356aA, true)) {
            Log.i(f6320W, "Interface succesfully claimed");
            int endpointCount = this.f6356aA.getEndpointCount();
            for (int i = 0; i <= endpointCount - 1; i++) {
                UsbEndpoint endpoint = this.f6356aA.getEndpoint(i);
                if (endpoint.getType() == 2 && endpoint.getDirection() == 128) {
                    this.f6357aB = endpoint;
                } else {
                    this.f6358aC = endpoint;
                }
            }
            this.f6368ax = true;
            if (m13618a(0, 0, 0) < 0 || m13618a(4, 8, 0) < 0) {
                return false;
            }
            this.f6363as = 8;
            if (m13618a(1, 257, 0) < 0 || m13618a(1, 514, 0) < 0 || m13618a(2, 0, 0) < 0 || m13618a(3, (int) f6348f, 0) < 0) {
                return false;
            }
            this.f6364at = false;
            this.f6365au = false;
            return true;
        }
        Log.i(f6320W, "Interface could not be claimed");
        return false;
    }

    /* renamed from: a */
    private int m13618a(int i, int i2, int i3) {
        int controlTransfer = this.f6449w.controlTransfer(64, i, i2, this.f6356aA.getId() + 1 + i3, (byte[]) null, 0, 0);
        String str = f6320W;
        Log.i(str, "Control Transfer Response: " + String.valueOf(controlTransfer));
        return controlTransfer;
    }

    /* renamed from: a */
    static byte[] m13625a(byte[] bArr) {
        int length = bArr.length;
        int i = 64;
        if (length > 64) {
            int i2 = 1;
            while (i < length) {
                i2++;
                i = i2 * 64;
            }
            byte[] bArr2 = new byte[(length - (i2 * 2))];
            m13626b(bArr, bArr2);
            return bArr2;
        } else if (length == 2) {
            return f6343ar;
        } else {
            return Arrays.copyOfRange(bArr, 2, length);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m13626b(byte[] bArr, byte[] bArr2) {
        int i = 0;
        int i2 = 2;
        while (i2 - 2 <= bArr.length - 64) {
            System.arraycopy(bArr, i2, bArr2, i, 62);
            i2 += 64;
            i += 62;
        }
        int length = (bArr.length - i2) + 2;
        if (length > 0) {
            System.arraycopy(bArr, i2, bArr2, i, length - 2);
        }
    }

    /* renamed from: atakplugin.UASTool.sg$a */
    public class C0828a {
        public C0828a() {
        }

        /* renamed from: a */
        public byte[] mo5717a(byte[] bArr) {
            int length = bArr.length;
            int i = 64;
            if (length <= 64) {
                return Arrays.copyOfRange(bArr, 2, length);
            }
            int i2 = 1;
            while (i < length) {
                i2++;
                i = i2 * 64;
            }
            byte[] bArr2 = new byte[(length - (i2 * 2))];
            C0827sg.m13626b(bArr, bArr2);
            return bArr2;
        }

        /* renamed from: b */
        public void mo5718b(byte[] bArr) {
            if (bArr.length != 0) {
                boolean z = (bArr[0] & 16) == 16;
                boolean z2 = (bArr[0] & 32) == 32;
                if (C0827sg.this.f6368ax) {
                    boolean unused = C0827sg.this.f6366av = z;
                    boolean unused2 = C0827sg.this.f6367aw = z2;
                    if (C0827sg.this.f6364at && C0827sg.this.f6369ay != null) {
                        C0827sg.this.f6369ay.mo5774a(C0827sg.this.f6366av);
                    }
                    if (C0827sg.this.f6365au && C0827sg.this.f6370az != null) {
                        C0827sg.this.f6370az.mo5775a(C0827sg.this.f6367aw);
                    }
                    boolean unused3 = C0827sg.this.f6368ax = false;
                    return;
                }
                if (!(!C0827sg.this.f6364at || z == C0827sg.this.f6366av || C0827sg.this.f6369ay == null)) {
                    C0827sg sgVar = C0827sg.this;
                    boolean unused4 = sgVar.f6366av = !sgVar.f6366av;
                    C0827sg.this.f6369ay.mo5774a(C0827sg.this.f6366av);
                }
                if (!(!C0827sg.this.f6365au || z2 == C0827sg.this.f6367aw || C0827sg.this.f6370az == null)) {
                    C0827sg sgVar2 = C0827sg.this;
                    boolean unused5 = sgVar2.f6367aw = !sgVar2.f6367aw;
                    C0827sg.this.f6370az.mo5775a(C0827sg.this.f6367aw);
                }
                if (C0827sg.this.f6359aD != null && (bArr[1] & 4) == 4) {
                    C0827sg.this.f6359aD.mo5778a();
                }
                if (C0827sg.this.f6360aE != null && (bArr[1] & 8) == 8) {
                    C0827sg.this.f6360aE.mo5776a();
                }
                if (C0827sg.this.f6361aF != null && (bArr[1] & 2) == 2) {
                    C0827sg.this.f6361aF.mo5777a();
                }
                if (C0827sg.this.f6362aG != null && (bArr[1] & 16) == 16) {
                    C0827sg.this.f6362aG.mo5773a();
                }
            }
        }
    }

    /* renamed from: a */
    public int mo5715a(byte[] bArr, int i) {
        int i2;
        long currentTimeMillis = System.currentTimeMillis() + ((long) i);
        if (this.f6443E) {
            return -1;
        }
        if (bArr == null) {
            return 0;
        }
        int length = bArr.length / 62;
        if (bArr.length % 62 != 0) {
            length++;
        }
        int length2 = bArr.length + (length * 2);
        byte[] bArr2 = new byte[length2];
        int i3 = 0;
        do {
            if (i > 0) {
                i2 = (int) (currentTimeMillis - System.currentTimeMillis());
                if (i2 <= 0) {
                    break;
                }
            } else {
                i2 = 0;
            }
            int bulkTransfer = this.f6449w.bulkTransfer(this.f6357aB, bArr2, length2, i2);
            if (bulkTransfer > 2) {
                System.arraycopy(this.f6371n.mo5717a(bArr2), 0, bArr, 0, bArr.length);
                int i4 = bulkTransfer / 64;
                if (bulkTransfer % 64 != 0) {
                    i4++;
                }
                i3 = bulkTransfer - (i4 * 2);
                continue;
            }
        } while (i3 <= 0);
        return i3;
    }

    /* renamed from: a */
    public int mo5716a(byte[] bArr, int i, int i2, int i3) {
        int i4;
        long currentTimeMillis = System.currentTimeMillis() + ((long) i3);
        if (this.f6443E) {
            return -1;
        }
        if (bArr == null) {
            return 0;
        }
        int i5 = i2 / 62;
        if (i2 % 62 != 0) {
            i5++;
        }
        int i6 = (i5 * 2) + i2;
        byte[] bArr2 = new byte[i6];
        int i7 = 0;
        do {
            if (i3 > 0) {
                i4 = (int) (currentTimeMillis - System.currentTimeMillis());
                if (i4 <= 0) {
                    break;
                }
            } else {
                i4 = 0;
            }
            int bulkTransfer = this.f6449w.bulkTransfer(this.f6357aB, bArr2, i6, i4);
            if (bulkTransfer > 2) {
                System.arraycopy(this.f6371n.mo5717a(bArr2), 0, bArr, i, i2);
                int i8 = bulkTransfer / 64;
                if (bulkTransfer % 64 != 0) {
                    i8++;
                }
                i7 = bulkTransfer - (i8 * 2);
                continue;
            }
        } while (i7 <= 0);
        return i7;
    }

    /* renamed from: a */
    private int m13619a(byte[] bArr, int i, long j) {
        int i2;
        int i3 = 0;
        do {
            if (i <= 0) {
                i2 = 0;
            } else {
                int currentTimeMillis = (int) (j - System.currentTimeMillis());
                if (currentTimeMillis <= 0) {
                    break;
                }
                i2 = currentTimeMillis;
            }
            UsbDeviceConnection usbDeviceConnection = this.f6449w;
            UsbEndpoint usbEndpoint = this.f6357aB;
            byte[] bArr2 = f6325aH;
            if (usbDeviceConnection.bulkTransfer(usbEndpoint, bArr2, bArr2.length, i2) > 2) {
                i3 += this.f6449w.bulkTransfer(this.f6357aB, bArr, i3, 62, i2);
                continue;
            }
        } while (i3 <= 0);
        return i3;
    }

    /* renamed from: r */
    private short m13642r() {
        if (Build.VERSION.SDK_INT < 13) {
            return -1;
        }
        byte[] rawDescriptors = this.f6449w.getRawDescriptors();
        return (short) ((rawDescriptors[12] << 8) + rawDescriptors[13]);
    }

    /* renamed from: s */
    private byte m13643s() {
        if (Build.VERSION.SDK_INT >= 13) {
            return this.f6449w.getRawDescriptors()[16];
        }
        return -1;
    }

    /* renamed from: a */
    private boolean m13622a(long j, long j2) {
        long j3 = j2 * 100;
        return j >= j3 / 103 && j <= j3 / 97;
    }

    /* renamed from: g */
    private short[] m13636g(int i) {
        int i2;
        int i3;
        int i4;
        int i5 = i;
        short[] sArr = new short[2];
        byte[] bArr = {0, 3, 2, 4, 1, 5, 6, 7};
        byte[] bArr2 = {0, 1, 0, 1, 0, -1, 2, 1, 0, -1, -2, -3, 4, 3, 2, 1};
        short r = m13642r();
        if (r == -1) {
            return null;
        }
        boolean z = r == 512 && m13643s() == 0;
        boolean z2 = r == 1280 || r == 1792 || r == 2048 || r == 2304 || r == 4096;
        boolean z3 = r == 1792 || r == 2048 || r == 2304;
        if (i5 < 1200 || !z3) {
            i3 = 3000000;
            i2 = 0;
        } else {
            i3 = 12000000;
            i2 = 131072;
        }
        if (i5 < (i3 >> 14) || i5 > i3) {
            return null;
        }
        int i6 = (i3 << 4) / i5;
        int i7 = i6 & 15;
        if (i7 == 1) {
            i4 = i6 & -8;
        } else {
            i4 = z ? bArr2[i7] + i6 : i6 + 1;
        }
        int i8 = i4 >> 1;
        byte[] bArr3 = bArr;
        long j = (long) i5;
        if (!m13622a((long) ((i3 << 3) / i8), j)) {
            return null;
        }
        int i9 = i8 & 7;
        int i10 = i8 >> 3;
        if (i10 == 1) {
            if (i9 == 0) {
                i10 = 0;
            } else {
                i9 = 0;
            }
        }
        int i11 = (bArr3[i9] << Ascii.f8524SO) | i2 | i10;
        sArr[0] = (short) i11;
        sArr[1] = (short) (i11 >> 16);
        if (z2) {
            sArr[1] = (short) (sArr[1] << 8);
        }
        return sArr;
    }

    /* renamed from: a */
    private void m13621a(short[] sArr) {
        this.f6449w.controlTransfer(64, 3, sArr[0], sArr[1], (byte[]) null, 0, 0);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0081, code lost:
        if (r5 <= 921600) goto L_0x0086;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0084, code lost:
        if (r5 > 921600) goto L_0x0086;
     */
    /* renamed from: h */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m13638h(int r5) {
        /*
            r4 = this;
            r0 = 32771(0x8003, float:4.5922E-41)
            r1 = 16696(0x4138, float:2.3396E-41)
            r2 = 300(0x12c, float:4.2E-43)
            if (r5 < 0) goto L_0x000f
            if (r5 > r2) goto L_0x000f
            r0 = 10000(0x2710, float:1.4013E-41)
            goto L_0x0086
        L_0x000f:
            r3 = 600(0x258, float:8.41E-43)
            if (r5 <= r2) goto L_0x0019
            if (r5 > r3) goto L_0x0019
            r0 = 5000(0x1388, float:7.006E-42)
            goto L_0x0086
        L_0x0019:
            r2 = 1200(0x4b0, float:1.682E-42)
            if (r5 <= r3) goto L_0x0023
            if (r5 > r2) goto L_0x0023
            r0 = 2500(0x9c4, float:3.503E-42)
            goto L_0x0086
        L_0x0023:
            r3 = 2400(0x960, float:3.363E-42)
            if (r5 <= r2) goto L_0x002d
            if (r5 > r3) goto L_0x002d
            r0 = 1250(0x4e2, float:1.752E-42)
            goto L_0x0086
        L_0x002d:
            r2 = 4800(0x12c0, float:6.726E-42)
            if (r5 <= r3) goto L_0x0036
            if (r5 > r2) goto L_0x0036
            r0 = 625(0x271, float:8.76E-43)
            goto L_0x0086
        L_0x0036:
            r3 = 9600(0x2580, float:1.3452E-41)
            if (r5 <= r2) goto L_0x003f
            if (r5 > r3) goto L_0x003f
        L_0x003c:
            r0 = 16696(0x4138, float:2.3396E-41)
            goto L_0x0086
        L_0x003f:
            r2 = 19200(0x4b00, float:2.6905E-41)
            if (r5 <= r3) goto L_0x0049
            if (r5 > r2) goto L_0x0049
            r0 = 32924(0x809c, float:4.6136E-41)
            goto L_0x0086
        L_0x0049:
            if (r5 <= r2) goto L_0x0054
            r3 = 38400(0x9600, float:5.381E-41)
            if (r5 > r3) goto L_0x0054
            r0 = 49230(0xc04e, float:6.8986E-41)
            goto L_0x0086
        L_0x0054:
            r3 = 57600(0xe100, float:8.0715E-41)
            if (r5 <= r2) goto L_0x005e
            if (r5 > r3) goto L_0x005e
            r0 = 52
            goto L_0x0086
        L_0x005e:
            r2 = 115200(0x1c200, float:1.6143E-40)
            if (r5 <= r3) goto L_0x0068
            if (r5 > r2) goto L_0x0068
            r0 = 26
            goto L_0x0086
        L_0x0068:
            r3 = 230400(0x38400, float:3.22859E-40)
            if (r5 <= r2) goto L_0x0072
            if (r5 > r3) goto L_0x0072
            r0 = 13
            goto L_0x0086
        L_0x0072:
            r2 = 460800(0x70800, float:6.45718E-40)
            if (r5 <= r3) goto L_0x007c
            if (r5 > r2) goto L_0x007c
            r0 = 16390(0x4006, float:2.2967E-41)
            goto L_0x0086
        L_0x007c:
            r3 = 921600(0xe1000, float:1.291437E-39)
            if (r5 <= r2) goto L_0x0084
            if (r5 > r3) goto L_0x0084
            goto L_0x0086
        L_0x0084:
            if (r5 <= r3) goto L_0x003c
        L_0x0086:
            r5 = 3
            r1 = 0
            r4.m13618a((int) r5, (int) r0, (int) r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.C0827sg.m13638h(int):void");
    }
}
