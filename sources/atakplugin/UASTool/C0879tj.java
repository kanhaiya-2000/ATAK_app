package atakplugin.UASTool;

import android.content.Context;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbDeviceConnection;
import android.hardware.usb.UsbEndpoint;
import android.hardware.usb.UsbInterface;
import android.hardware.usb.UsbManager;
import android.hardware.usb.UsbRequest;
import android.util.Log;
import atakplugin.UASTool.C0870td;
import com.autel.internal.video.core.decoder2.common.VideoDefaultParams;
import com.google.common.base.Ascii;
import com.o3dr.services.android.lib.drone.connection.ConnectionType;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* renamed from: atakplugin.UASTool.tj */
public class C0879tj {

    /* renamed from: k */
    private static final String f6665k = "FTDI_Device::";

    /* renamed from: a */
    long f6666a;

    /* renamed from: b */
    Boolean f6667b;

    /* renamed from: c */
    UsbDevice f6668c;

    /* renamed from: d */
    UsbInterface f6669d;

    /* renamed from: e */
    UsbEndpoint f6670e;

    /* renamed from: f */
    UsbEndpoint f6671f;

    /* renamed from: g */
    C0870td.C0873c f6672g;

    /* renamed from: h */
    C0913uh f6673h;

    /* renamed from: i */
    C0912ug f6674i;

    /* renamed from: j */
    Context f6675j;

    /* renamed from: l */
    private UsbRequest f6676l;

    /* renamed from: m */
    private UsbDeviceConnection f6677m;

    /* renamed from: n */
    private C0869tc f6678n;

    /* renamed from: o */
    private Thread f6679o;

    /* renamed from: p */
    private Thread f6680p;

    /* renamed from: q */
    private C0910ue f6681q;

    /* renamed from: r */
    private C0905ua f6682r;

    /* renamed from: s */
    private byte f6683s;

    /* renamed from: t */
    private C0870td.C0872b f6684t;

    /* renamed from: u */
    private int f6685u = 0;

    /* renamed from: v */
    private int f6686v;

    public C0879tj(Context context, UsbManager usbManager, UsbDevice usbDevice, UsbInterface usbInterface) {
        byte[] bArr = new byte[255];
        this.f6675j = context;
        this.f6684t = new C0870td.C0872b();
        try {
            this.f6668c = usbDevice;
            this.f6669d = usbInterface;
            this.f6670e = null;
            this.f6671f = null;
            this.f6686v = 0;
            this.f6673h = new C0913uh();
            this.f6674i = new C0912ug();
            this.f6672g = new C0870td.C0873c();
            this.f6676l = new UsbRequest();
            mo5841a(usbManager.openDevice(this.f6668c));
            if (mo5861c() != null) {
                mo5861c().claimInterface(this.f6669d, false);
                byte[] rawDescriptors = mo5861c().getRawDescriptors();
                int deviceId = this.f6668c.getDeviceId();
                int id = this.f6669d.getId() + 1;
                this.f6685u = id;
                this.f6672g.f6633f = (deviceId << 4) | (id & 15);
                ByteBuffer allocate = ByteBuffer.allocate(2);
                allocate.order(ByteOrder.LITTLE_ENDIAN);
                allocate.put(rawDescriptors[12]);
                allocate.put(rawDescriptors[13]);
                this.f6672g.f6629b = allocate.getShort(0);
                this.f6672g.f6631d = rawDescriptors[16];
                this.f6672g.f6634g = mo5861c().getSerial();
                this.f6672g.f6632e = (this.f6668c.getVendorId() << 16) | this.f6668c.getProductId();
                this.f6672g.f6637j = 8;
                mo5861c().controlTransfer(-128, 6, rawDescriptors[15] | 768, 0, bArr, 255, 0);
                this.f6672g.f6635h = m13945d(bArr);
                switch (this.f6672g.f6629b & 65280) {
                    case 512:
                        if (this.f6672g.f6631d != 0) {
                            this.f6672g.f6630c = 1;
                            this.f6682r = new C0898tu(this);
                            break;
                        } else {
                            this.f6682r = new C0899tv(this);
                            this.f6672g.f6630c = 0;
                            break;
                        }
                    case 1024:
                        this.f6682r = new C0899tv(this);
                        this.f6672g.f6630c = 0;
                        break;
                    case VideoDefaultParams.mFormatWidth /*1280*/:
                        this.f6682r = new C0897tt(this);
                        this.f6672g.f6630c = 4;
                        m13939N();
                        break;
                    case 1536:
                        C0905ua uaVar = new C0905ua(this);
                        this.f6682r = uaVar;
                        short a = (short) (uaVar.mo5895a(0) & 1);
                        this.f6682r = null;
                        if (a != 0) {
                            this.f6672g.f6630c = 5;
                            this.f6682r = new C0902ty(this);
                            break;
                        } else {
                            this.f6672g.f6630c = 5;
                            this.f6682r = new C0901tx(this);
                            break;
                        }
                    case 1792:
                        this.f6672g.f6630c = 6;
                        m13939N();
                        this.f6682r = new C0896ts(this);
                        break;
                    case 2048:
                        this.f6672g.f6630c = 7;
                        m13939N();
                        this.f6682r = new C0903tz(this);
                        break;
                    case 2304:
                        this.f6672g.f6630c = 8;
                        this.f6682r = new C0900tw(this);
                        break;
                    case 4096:
                        this.f6672g.f6630c = 9;
                        this.f6682r = new C0907ub(this);
                        break;
                    case 5888:
                        this.f6672g.f6630c = 12;
                        this.f6672g.f6628a = 2;
                        break;
                    case 6144:
                        this.f6672g.f6630c = 10;
                        if (this.f6685u != 1) {
                            this.f6672g.f6628a = 0;
                            break;
                        } else {
                            this.f6672g.f6628a = 2;
                            break;
                        }
                    case 6400:
                        this.f6672g.f6630c = 11;
                        int i = this.f6685u;
                        if (i != 4) {
                            this.f6672g.f6628a = 2;
                            break;
                        } else {
                            int maxPacketSize = this.f6668c.getInterface(i - 1).getEndpoint(0).getMaxPacketSize();
                            Log.e("dev", "mInterfaceID : " + this.f6685u + "   iMaxPacketSize : " + maxPacketSize);
                            if (maxPacketSize != 8) {
                                this.f6672g.f6628a = 2;
                                break;
                            } else {
                                this.f6672g.f6628a = 0;
                                break;
                            }
                        }
                    default:
                        this.f6672g.f6630c = 3;
                        this.f6682r = new C0905ua(this);
                        break;
                }
                short s = this.f6672g.f6629b & 65280;
                if (s == 5888 || s == 6144 || s == 6400) {
                    if (this.f6672g.f6634g == null) {
                        byte[] bArr2 = new byte[16];
                        mo5861c().controlTransfer(-64, 144, 0, 27, bArr2, 16, 0);
                        String str = "";
                        for (int i2 = 0; i2 < 8; i2++) {
                            str = String.valueOf(str) + ((char) bArr2[i2 * 2]);
                        }
                        this.f6672g.f6634g = new String(str);
                    }
                }
                short s2 = this.f6672g.f6629b & 65280;
                if (s2 == 6144 || s2 == 6400) {
                    int i3 = this.f6685u;
                    if (i3 == 1) {
                        C0870td.C0873c cVar = this.f6672g;
                        cVar.f6635h = String.valueOf(cVar.f6635h) + " A";
                        C0870td.C0873c cVar2 = this.f6672g;
                        cVar2.f6634g = String.valueOf(cVar2.f6634g) + "A";
                    } else if (i3 == 2) {
                        C0870td.C0873c cVar3 = this.f6672g;
                        cVar3.f6635h = String.valueOf(cVar3.f6635h) + " B";
                        C0870td.C0873c cVar4 = this.f6672g;
                        cVar4.f6634g = String.valueOf(cVar4.f6634g) + "B";
                    } else if (i3 == 3) {
                        C0870td.C0873c cVar5 = this.f6672g;
                        cVar5.f6635h = String.valueOf(cVar5.f6635h) + " C";
                        C0870td.C0873c cVar6 = this.f6672g;
                        cVar6.f6634g = String.valueOf(cVar6.f6634g) + "C";
                    } else if (i3 == 4) {
                        C0870td.C0873c cVar7 = this.f6672g;
                        cVar7.f6635h = String.valueOf(cVar7.f6635h) + " D";
                        C0870td.C0873c cVar8 = this.f6672g;
                        cVar8.f6634g = String.valueOf(cVar8.f6634g) + "D";
                    }
                }
                mo5861c().releaseInterface(this.f6669d);
                mo5861c().close();
                mo5841a((UsbDeviceConnection) null);
                m13941P();
                return;
            }
            Log.e(f6665k, "Failed to open the device!");
            throw new C0870td.C0871a("Failed to open the device!");
        } catch (Exception e) {
            if (e.getMessage() != null) {
                Log.e(f6665k, e.getMessage());
            }
        }
    }

    /* renamed from: E */
    private final boolean m13930E() {
        return m13933H() || m13934I() || mo5857b();
    }

    /* renamed from: F */
    private final boolean m13931F() {
        return m13937L() || m13936K() || m13935J() || m13934I() || mo5857b() || m13933H() || m13932G();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final boolean mo5843a() {
        return m13936K() || m13934I() || mo5857b();
    }

    /* renamed from: G */
    private final boolean m13932G() {
        return (this.f6672g.f6629b & 65280) == 4096;
    }

    /* renamed from: H */
    private final boolean m13933H() {
        return (this.f6672g.f6629b & 65280) == 2304;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final boolean mo5857b() {
        return (this.f6672g.f6629b & 65280) == 2048;
    }

    /* renamed from: I */
    private final boolean m13934I() {
        return (this.f6672g.f6629b & 65280) == 1792;
    }

    /* renamed from: J */
    private final boolean m13935J() {
        return (this.f6672g.f6629b & 65280) == 1536;
    }

    /* renamed from: K */
    private final boolean m13936K() {
        return (this.f6672g.f6629b & 65280) == 1280;
    }

    /* renamed from: L */
    private final boolean m13937L() {
        if ((this.f6672g.f6629b & 65280) != 1024) {
            return (this.f6672g.f6629b & 65280) == 512 && this.f6672g.f6631d == 0;
        }
        return true;
    }

    /* renamed from: M */
    private final boolean m13938M() {
        return (this.f6672g.f6629b & 65280) == 512 && this.f6672g.f6631d != 0;
    }

    /* renamed from: d */
    private final String m13945d(byte[] bArr) {
        return new String(bArr, 2, bArr[0] - 2, bxz.f4233e);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public UsbDeviceConnection mo5861c() {
        return this.f6677m;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5841a(UsbDeviceConnection usbDeviceConnection) {
        this.f6677m = usbDeviceConnection;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized boolean mo5850a(Context context) {
        boolean z;
        z = false;
        if (context != null) {
            this.f6675j = context;
            z = true;
        }
        return z;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo5842a(C0870td.C0872b bVar) {
        this.f6684t.mo5820a(bVar.mo5819a());
        this.f6684t.mo5822b(bVar.mo5821b());
        this.f6684t.mo5824c(bVar.mo5823c());
        this.f6684t.mo5826d(bVar.mo5825d());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public C0870td.C0872b mo5862d() {
        return this.f6684t;
    }

    /* renamed from: e */
    public int mo5863e() {
        return this.f6684t.mo5825d();
    }

    /* renamed from: N */
    private void m13939N() {
        int i = this.f6685u;
        if (i == 1) {
            C0870td.C0873c cVar = this.f6672g;
            cVar.f6634g = String.valueOf(cVar.f6634g) + "A";
            C0870td.C0873c cVar2 = this.f6672g;
            cVar2.f6635h = String.valueOf(cVar2.f6635h) + " A";
        } else if (i == 2) {
            C0870td.C0873c cVar3 = this.f6672g;
            cVar3.f6634g = String.valueOf(cVar3.f6634g) + "B";
            C0870td.C0873c cVar4 = this.f6672g;
            cVar4.f6635h = String.valueOf(cVar4.f6635h) + " B";
        } else if (i == 3) {
            C0870td.C0873c cVar5 = this.f6672g;
            cVar5.f6634g = String.valueOf(cVar5.f6634g) + "C";
            C0870td.C0873c cVar6 = this.f6672g;
            cVar6.f6635h = String.valueOf(cVar6.f6635h) + " C";
        } else if (i == 4) {
            C0870td.C0873c cVar7 = this.f6672g;
            cVar7.f6634g = String.valueOf(cVar7.f6634g) + "D";
            C0870td.C0873c cVar8 = this.f6672g;
            cVar8.f6635h = String.valueOf(cVar8.f6635h) + " D";
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized boolean mo5851a(UsbManager usbManager) {
        if (mo5864f()) {
            return false;
        }
        if (usbManager == null) {
            Log.e(f6665k, "UsbManager cannot be null.");
            return false;
        } else if (mo5861c() != null) {
            Log.e(f6665k, "There should not have an UsbConnection.");
            return false;
        } else {
            mo5841a(usbManager.openDevice(this.f6668c));
            if (mo5861c() == null) {
                Log.e(f6665k, "UsbConnection cannot be null.");
                return false;
            } else if (!mo5861c().claimInterface(this.f6669d, true)) {
                Log.e(f6665k, "ClaimInteface returned false.");
                return false;
            } else {
                Log.d(f6665k, "open SUCCESS");
                if (!m13942Q()) {
                    Log.e(f6665k, "Failed to find endpoints.");
                    return false;
                }
                this.f6676l.initialize(this.f6677m, this.f6670e);
                Log.d("D2XX::", "**********************Device Opened**********************");
                C0910ue ueVar = new C0910ue(this);
                this.f6681q = ueVar;
                this.f6678n = new C0869tc(this, ueVar, mo5861c(), this.f6671f);
                Thread thread = new Thread(this.f6678n);
                this.f6680p = thread;
                thread.setName("bulkInThread");
                Thread thread2 = new Thread(new C0911uf(this.f6681q));
                this.f6679o = thread2;
                thread2.setName("processRequestThread");
                m13943a(true, true);
                this.f6680p.start();
                this.f6679o.start();
                m13940O();
                return true;
            }
        }
    }

    /* renamed from: f */
    public synchronized boolean mo5864f() {
        return this.f6667b.booleanValue();
    }

    /* renamed from: O */
    private synchronized void m13940O() {
        this.f6667b = true;
        C0870td.C0873c cVar = this.f6672g;
        cVar.f6628a = 1 | cVar.f6628a;
    }

    /* renamed from: P */
    private synchronized void m13941P() {
        this.f6667b = false;
        this.f6672g.f6628a &= 2;
    }

    /* renamed from: g */
    public synchronized void mo5865g() {
        Thread thread = this.f6679o;
        if (thread != null) {
            thread.interrupt();
        }
        Thread thread2 = this.f6680p;
        if (thread2 != null) {
            thread2.interrupt();
        }
        UsbDeviceConnection usbDeviceConnection = this.f6677m;
        if (usbDeviceConnection != null) {
            usbDeviceConnection.releaseInterface(this.f6669d);
            this.f6677m.close();
            this.f6677m = null;
        }
        C0910ue ueVar = this.f6681q;
        if (ueVar != null) {
            ueVar.mo5934g();
        }
        this.f6679o = null;
        this.f6680p = null;
        this.f6678n = null;
        this.f6681q = null;
        m13941P();
    }

    /* access modifiers changed from: protected */
    /* renamed from: h */
    public UsbDevice mo5866h() {
        return this.f6668c;
    }

    /* renamed from: i */
    public C0870td.C0873c mo5867i() {
        return this.f6672g;
    }

    /* renamed from: a */
    public int mo5838a(byte[] bArr, int i, long j) {
        if (!mo5864f()) {
            return -1;
        }
        if (i <= 0) {
            return -2;
        }
        C0910ue ueVar = this.f6681q;
        if (ueVar == null) {
            return -3;
        }
        return ueVar.mo5921a(bArr, i, j);
    }

    /* renamed from: a */
    public int mo5837a(byte[] bArr, int i) {
        return mo5838a(bArr, i, (long) this.f6684t.mo5825d());
    }

    /* renamed from: a */
    public int mo5836a(byte[] bArr) {
        return mo5838a(bArr, bArr.length, (long) this.f6684t.mo5825d());
    }

    /* renamed from: b */
    public int mo5856b(byte[] bArr, int i) {
        return mo5839a(bArr, i, true);
    }

    /* renamed from: a */
    public int mo5839a(byte[] bArr, int i, boolean z) {
        UsbRequest requestWait;
        if (!mo5864f() || i < 0) {
            return -1;
        }
        UsbRequest usbRequest = this.f6676l;
        if (z) {
            usbRequest.setClientData(this);
        }
        if (i != 0 ? !usbRequest.queue(ByteBuffer.wrap(bArr), i) : !usbRequest.queue(ByteBuffer.wrap(new byte[1]), i)) {
            i = -1;
        }
        if (z) {
            do {
                requestWait = this.f6677m.requestWait();
                if (requestWait == null) {
                    Log.e(f6665k, "UsbConnection.requestWait() == null");
                    return -99;
                }
            } while (requestWait.getClientData() != this);
        }
        return i;
    }

    /* renamed from: b */
    public int mo5855b(byte[] bArr) {
        return mo5839a(bArr, bArr.length, true);
    }

    /* renamed from: j */
    public short mo5868j() {
        if (!mo5864f()) {
            return -1;
        }
        if (this.f6681q == null) {
            return -2;
        }
        this.f6666a &= -3;
        return (short) (this.f6672g.f6638k & 255);
    }

    /* renamed from: k */
    public short mo5869k() {
        if (!mo5864f()) {
            return -1;
        }
        if (this.f6681q == null) {
            return -2;
        }
        return this.f6672g.f6639l;
    }

    /* renamed from: l */
    public int mo5870l() {
        if (!mo5864f()) {
            return -1;
        }
        C0910ue ueVar = this.f6681q;
        if (ueVar == null) {
            return -2;
        }
        return ueVar.mo5927c();
    }

    /* renamed from: m */
    public boolean mo5871m() {
        return this.f6681q.mo5924a();
    }

    /* renamed from: n */
    public long mo5872n() {
        if (!mo5864f()) {
            return -1;
        }
        if (this.f6681q == null) {
            return -2;
        }
        long j = this.f6666a;
        this.f6666a = 0;
        return j;
    }

    /* renamed from: a */
    public boolean mo5848a(int i) {
        byte b;
        int[] iArr = new int[2];
        if (!mo5864f()) {
            return false;
        }
        switch (i) {
            case 300:
                iArr[0] = 10000;
                break;
            case 600:
                iArr[0] = 5000;
                break;
            case 1200:
                iArr[0] = 2500;
                break;
            case 2400:
                iArr[0] = 1250;
                break;
            case 4800:
                iArr[0] = 625;
                break;
            case 9600:
                iArr[0] = 16696;
                break;
            case 19200:
                iArr[0] = 32924;
                break;
            case 38400:
                iArr[0] = 49230;
                break;
            case ConnectionType.DEFAULT_USB_BAUD_RATE /*57600*/:
                iArr[0] = 52;
                break;
            case 115200:
                iArr[0] = 26;
                break;
            case 230400:
                iArr[0] = 13;
                break;
            case 460800:
                iArr[0] = 16390;
                break;
            case 921600:
                iArr[0] = 32771;
                break;
            default:
                if (m13930E() && i >= 1200) {
                    b = C0878ti.m13924a(i, iArr);
                    break;
                } else {
                    b = C0878ti.m13925a(i, iArr, m13931F());
                    break;
                }
                break;
        }
        b = 1;
        if (mo5843a() || m13933H() || m13932G()) {
            iArr[1] = iArr[1] << 8;
            iArr[1] = iArr[1] & 65280;
            iArr[1] = iArr[1] | this.f6685u;
        }
        if (b == 1 && mo5861c().controlTransfer(64, 3, iArr[0], iArr[1], (byte[]) null, 0, 0) == 0) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    public boolean mo5846a(byte b, byte b2, byte b3) {
        if (!mo5864f()) {
            return false;
        }
        short s = (short) (((short) (b | (b3 << 8))) | (b2 << Ascii.f8527VT));
        this.f6672g.f6637j = s;
        if (mo5861c().controlTransfer(64, 4, s, this.f6685u, (byte[]) null, 0, 0) == 0) {
            return true;
        }
        return false;
    }

    /* renamed from: o */
    public boolean mo5873o() {
        return m13944c(16384);
    }

    /* renamed from: p */
    public boolean mo5874p() {
        return m13944c(0);
    }

    /* renamed from: c */
    private boolean m13944c(int i) {
        int i2 = this.f6672g.f6637j | i;
        if (mo5864f() && mo5861c().controlTransfer(64, 4, i2, this.f6685u, (byte[]) null, 0, 0) == 0) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    public boolean mo5852a(short s, byte b, byte b2) {
        short s2;
        if (!mo5864f()) {
            return false;
        }
        if (s == 1024) {
            s2 = (short) ((b & 255) | ((short) (b2 << 8)));
        } else {
            s2 = 0;
        }
        if (mo5861c().controlTransfer(64, 2, s2, this.f6685u | s, (byte[]) null, 0, 0) != 0) {
            return false;
        }
        if (s == 256) {
            return mo5875q();
        }
        if (s == 512) {
            return mo5877s();
        }
        return true;
    }

    /* renamed from: q */
    public boolean mo5875q() {
        if (mo5864f() && mo5861c().controlTransfer(64, 1, 514, this.f6685u, (byte[]) null, 0, 0) == 0) {
            return true;
        }
        return false;
    }

    /* renamed from: r */
    public boolean mo5876r() {
        if (mo5864f() && mo5861c().controlTransfer(64, 1, 512, this.f6685u, (byte[]) null, 0, 0) == 0) {
            return true;
        }
        return false;
    }

    /* renamed from: s */
    public boolean mo5877s() {
        if (mo5864f() && mo5861c().controlTransfer(64, 1, 257, this.f6685u, (byte[]) null, 0, 0) == 0) {
            return true;
        }
        return false;
    }

    /* renamed from: t */
    public boolean mo5878t() {
        if (mo5864f() && mo5861c().controlTransfer(64, 1, 256, this.f6685u, (byte[]) null, 0, 0) == 0) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    public boolean mo5847a(byte b, byte b2, byte b3, byte b4) {
        C0913uh uhVar = new C0913uh();
        uhVar.f7116a = b;
        uhVar.f7117b = b2;
        uhVar.f7118c = b3;
        uhVar.f7119d = b4;
        if (!mo5864f()) {
            return false;
        }
        byte b5 = b & 255;
        if (b2 != 0) {
            b5 |= 256;
        }
        if (mo5861c().controlTransfer(64, 6, b5, this.f6685u, (byte[]) null, 0, 0) != 0) {
            return false;
        }
        byte b6 = b3 & 255;
        if (b4 > 0) {
            b6 |= 256;
        }
        if (mo5861c().controlTransfer(64, 7, b6, this.f6685u, (byte[]) null, 0, 0) != 0) {
            return false;
        }
        this.f6673h = uhVar;
        return true;
    }

    /* renamed from: a */
    public boolean mo5845a(byte b, byte b2) {
        int i = this.f6672g.f6630c;
        if (!mo5864f() || i == 1) {
            return false;
        }
        if (i != 0 || b2 == 0) {
            if (i != 4 || b2 == 0) {
                if (i != 5 || b2 == 0) {
                    if (i != 6 || b2 == 0) {
                        if (i != 7 || b2 == 0) {
                            if (i == 8 && b2 != 0 && b2 > 64) {
                                return false;
                            }
                        } else if ((b2 & 7) == 0) {
                            return false;
                        } else {
                            if (((b2 == 2) & (this.f6669d.getId() != 0)) && (this.f6669d.getId() != 1)) {
                                return false;
                            }
                        }
                    } else if ((b2 & 95) == 0) {
                        return false;
                    } else {
                        if (((b2 & 72) > 0) && (this.f6669d.getId() != 0)) {
                            return false;
                        }
                    }
                } else if ((b2 & 37) == 0) {
                    return false;
                }
            } else if ((b2 & Ascii.f8526US) == 0) {
                return false;
            } else {
                if ((b2 == 2) && (this.f6669d.getId() != 0)) {
                    return false;
                }
            }
        } else if ((b2 & 1) == 0) {
            return false;
        }
        if (mo5861c().controlTransfer(64, 11, (b2 << 8) | (b & 255), this.f6685u, (byte[]) null, 0, 0) == 0) {
            return true;
        }
        return false;
    }

    /* renamed from: u */
    public byte mo5879u() {
        byte[] bArr = new byte[1];
        if (!mo5864f()) {
            return -1;
        }
        if (!m13931F()) {
            return -2;
        }
        if (mo5861c().controlTransfer(-64, 12, 0, this.f6685u, bArr, 1, 0) == 1) {
            return bArr[0];
        }
        return -3;
    }

    /* renamed from: v */
    public boolean mo5880v() {
        if (mo5864f() && mo5861c().controlTransfer(64, 0, 0, 0, (byte[]) null, 0, 0) == 0) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    public int mo5833a(int i, int i2) {
        if (!mo5864f()) {
            return -1;
        }
        return mo5861c().controlTransfer(64, i, i2, this.f6685u, (byte[]) null, 0, 0);
    }

    /* renamed from: a */
    public int mo5834a(int i, int i2, byte[] bArr, int i3) {
        if (!mo5864f()) {
            Log.e(f6665k, "VendorCmdSet: Device not open");
            return -1;
        } else if (i3 < 0) {
            Log.e(f6665k, "VendorCmdSet: Invalid data length");
            return -1;
        } else {
            if (bArr == null) {
                if (i3 > 0) {
                    Log.e(f6665k, "VendorCmdSet: buf is null!");
                    return -1;
                }
            } else if (bArr.length < i3) {
                Log.e(f6665k, "VendorCmdSet: length of buffer is smaller than data length to set");
                return -1;
            }
            return mo5861c().controlTransfer(64, i, i2, this.f6685u, bArr, i3, 0);
        }
    }

    /* renamed from: b */
    public int mo5854b(int i, int i2, byte[] bArr, int i3) {
        if (!mo5864f()) {
            Log.e(f6665k, "VendorCmdGet: Device not open");
            return -1;
        } else if (i3 < 0) {
            Log.e(f6665k, "VendorCmdGet: Invalid data length");
            return -1;
        } else if (bArr == null) {
            Log.e(f6665k, "VendorCmdGet: buf is null");
            return -1;
        } else if (bArr.length < i3) {
            Log.e(f6665k, "VendorCmdGet: length of buffer is smaller than data length to get");
            return -1;
        } else {
            return mo5861c().controlTransfer(-64, i, i2, this.f6685u, bArr, i3, 0);
        }
    }

    /* renamed from: w */
    public void mo5881w() {
        try {
            if (!this.f6678n.mo5800c()) {
                this.f6678n.mo5798a();
            }
        } catch (InterruptedException e) {
            Log.d(f6665k, "stopInTask called!");
            e.printStackTrace();
        }
    }

    /* renamed from: x */
    public void mo5882x() {
        this.f6678n.mo5799b();
    }

    /* renamed from: y */
    public boolean mo5883y() {
        return this.f6678n.mo5800c();
    }

    /* renamed from: a */
    public boolean mo5844a(byte b) {
        boolean z = false;
        boolean z2 = (b & 1) == 1;
        if ((b & 2) == 2) {
            z = true;
        }
        return m13943a(z2, z);
    }

    /* renamed from: a */
    private boolean m13943a(boolean z, boolean z2) {
        if (!mo5864f()) {
            return false;
        }
        if (z) {
            int i = 0;
            for (int i2 = 0; i2 < 6; i2++) {
                i = mo5861c().controlTransfer(64, 0, 1, this.f6685u, (byte[]) null, 0, 0);
            }
            if (i > 0) {
                return false;
            }
            this.f6681q.mo5931e();
        }
        if (!z2 || mo5861c().controlTransfer(64, 0, 2, this.f6685u, (byte[]) null, 0, 0) != 0) {
            return false;
        }
        return true;
    }

    /* renamed from: b */
    public boolean mo5858b(byte b) {
        byte b2 = b & 255;
        if (!mo5864f() || mo5861c().controlTransfer(64, 9, b2, this.f6685u, (byte[]) null, 0, 0) != 0) {
            return false;
        }
        this.f6683s = b;
        return true;
    }

    /* renamed from: z */
    public byte mo5884z() {
        byte[] bArr = new byte[1];
        if (!mo5864f()) {
            return -1;
        }
        if (mo5861c().controlTransfer(-64, 10, 0, this.f6685u, bArr, 1, 0) == 1) {
            return bArr[0];
        }
        return 0;
    }

    /* renamed from: a */
    public boolean mo5849a(long j) {
        if (!mo5864f() || j == 0) {
            return false;
        }
        this.f6666a = 0;
        this.f6674i.f7114b = j;
        return true;
    }

    /* renamed from: Q */
    private boolean m13942Q() {
        for (int i = 0; i < this.f6669d.getEndpointCount(); i++) {
            Log.i(f6665k, "EP: " + String.format("0x%02X", new Object[]{Integer.valueOf(this.f6669d.getEndpoint(i).getAddress())}));
            if (this.f6669d.getEndpoint(i).getType() != 2) {
                Log.i(f6665k, "Not Bulk Endpoint");
            } else if (this.f6669d.getEndpoint(i).getDirection() == 128) {
                UsbEndpoint endpoint = this.f6669d.getEndpoint(i);
                this.f6671f = endpoint;
                this.f6686v = endpoint.getMaxPacketSize();
            } else {
                this.f6670e = this.f6669d.getEndpoint(i);
            }
        }
        if (this.f6670e == null || this.f6671f == null) {
            return false;
        }
        return true;
    }

    /* renamed from: A */
    public C0880tk mo5829A() {
        if (!mo5864f()) {
            return null;
        }
        return this.f6682r.mo5886a();
    }

    /* renamed from: a */
    public short mo5840a(C0880tk tkVar) {
        if (!mo5864f()) {
            return -1;
        }
        return this.f6682r.mo5887a(tkVar);
    }

    /* renamed from: B */
    public boolean mo5830B() {
        if (mo5864f() && this.f6682r.mo5902c() == 0) {
            return true;
        }
        return false;
    }

    /* renamed from: c */
    public int mo5860c(byte[] bArr) {
        if (!mo5864f()) {
            return 0;
        }
        return this.f6682r.mo5885a(bArr);
    }

    /* renamed from: b */
    public byte[] mo5859b(int i) {
        if (!mo5864f()) {
            return null;
        }
        return this.f6682r.mo5888a(i);
    }

    /* renamed from: C */
    public int mo5831C() {
        if (!mo5864f()) {
            return -1;
        }
        return this.f6682r.mo5889b();
    }

    /* renamed from: a */
    public int mo5835a(short s) {
        if (!mo5864f()) {
            return -1;
        }
        return this.f6682r.mo5895a(s);
    }

    /* renamed from: a */
    public boolean mo5853a(short s, short s2) {
        if (!mo5864f()) {
            return false;
        }
        return this.f6682r.mo5890a(s, s2);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: D */
    public int mo5832D() {
        return this.f6686v;
    }
}
