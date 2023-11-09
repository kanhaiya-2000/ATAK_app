package atakplugin.UASTool;

import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbDeviceConnection;
import android.hardware.usb.UsbEndpoint;
import android.hardware.usb.UsbInterface;
import android.hardware.usb.UsbRequest;
import android.util.Log;
import atakplugin.UASTool.C0847ss;

/* renamed from: atakplugin.UASTool.sa */
public class C0819sa extends C0842sq {

    /* renamed from: a */
    private static final String f6179a = "sa";

    /* renamed from: b */
    private static final int f6180b = 33;

    /* renamed from: c */
    private static final int f6181c = 161;

    /* renamed from: d */
    private static final int f6182d = 32;

    /* renamed from: e */
    private static final int f6183e = 33;

    /* renamed from: f */
    private static final int f6184f = 34;

    /* renamed from: g */
    private static final int f6185g = 2;

    /* renamed from: h */
    private static final int f6186h = 1;

    /* renamed from: i */
    private static final byte[] f6187i = {0, -62, 1, 0, 0, 0, 8};

    /* renamed from: j */
    private static final int f6188j = 3;

    /* renamed from: k */
    private static final int f6189k = 0;

    /* renamed from: W */
    private int f6190W;

    /* renamed from: X */
    private int f6191X;

    /* renamed from: l */
    private final UsbInterface f6192l;

    /* renamed from: m */
    private UsbEndpoint f6193m;

    /* renamed from: n */
    private UsbEndpoint f6194n;

    /* renamed from: a */
    public void mo5683a(C0847ss.C0848a aVar) {
    }

    /* renamed from: a */
    public void mo5684a(C0847ss.C0849b bVar) {
    }

    /* renamed from: a */
    public void mo5685a(C0847ss.C0850c cVar) {
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

    /* renamed from: e */
    public void mo5699e(int i) {
    }

    public C0819sa(UsbDevice usbDevice, UsbDeviceConnection usbDeviceConnection) {
        this(usbDevice, usbDeviceConnection, -1);
    }

    public C0819sa(UsbDevice usbDevice, UsbDeviceConnection usbDeviceConnection, int i) {
        super(usbDevice, usbDeviceConnection);
        this.f6190W = 0;
        this.f6191X = 3;
        this.f6192l = usbDevice.getInterface(i < 0 ? m13492c(usbDevice) : i);
    }

    /* renamed from: f */
    public void mo5702f(int i) {
        this.f6190W = i;
    }

    /* renamed from: e */
    public int mo5701e() {
        return this.f6190W;
    }

    /* renamed from: a */
    public boolean mo5690a() {
        if (m13493r()) {
            C0865sz szVar = new C0865sz();
            szVar.initialize(this.f6449w, this.f6193m);
            mo5764o();
            mo5766q();
            mo5750a((UsbRequest) szVar, this.f6194n);
            this.f6443E = true;
            this.f6444F = true;
            return true;
        }
        this.f6444F = false;
        return false;
    }

    /* renamed from: b */
    public void mo5691b() {
        m13491a(34, 0, (byte[]) null);
        mo5763n();
        mo5765p();
        this.f6449w.releaseInterface(this.f6192l);
        this.f6449w.close();
        this.f6444F = false;
    }

    /* renamed from: c */
    public boolean mo5696c() {
        if (m13493r()) {
            mo5749a(this.f6193m, this.f6194n);
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
        m13491a(34, 0, (byte[]) null);
        this.f6449w.releaseInterface(this.f6192l);
        this.f6449w.close();
        this.f6444F = false;
    }

    /* renamed from: a */
    public void mo5682a(int i) {
        byte[] s = m13494s();
        s[0] = (byte) (i & 255);
        s[1] = (byte) ((i >> 8) & 255);
        s[2] = (byte) ((i >> 16) & 255);
        s[3] = (byte) ((i >> 24) & 255);
        m13491a(32, 0, s);
    }

    /* renamed from: b */
    public void mo5692b(int i) {
        byte[] s = m13494s();
        if (i == 5) {
            s[6] = 5;
        } else if (i == 6) {
            s[6] = 6;
        } else if (i == 7) {
            s[6] = 7;
        } else if (i == 8) {
            s[6] = 8;
        } else {
            return;
        }
        m13491a(32, 0, s);
    }

    /* renamed from: c */
    public void mo5694c(int i) {
        byte[] s = m13494s();
        if (i == 1) {
            s[4] = 0;
        } else if (i == 2) {
            s[4] = 2;
        } else if (i == 3) {
            s[4] = 1;
        } else {
            return;
        }
        m13491a(32, 0, s);
    }

    /* renamed from: d */
    public void mo5698d(int i) {
        byte[] s = m13494s();
        if (i == 0) {
            s[5] = 0;
        } else if (i == 1) {
            s[5] = 1;
        } else if (i == 2) {
            s[5] = 2;
        } else if (i == 3) {
            s[5] = 3;
        } else if (i == 4) {
            s[5] = 4;
        } else {
            return;
        }
        m13491a(32, 0, s);
    }

    /* renamed from: b */
    public void mo5693b(boolean z) {
        if (z) {
            this.f6191X |= 2;
        } else {
            this.f6191X &= -3;
        }
        m13491a(34, this.f6191X, (byte[]) null);
    }

    /* renamed from: c */
    public void mo5695c(boolean z) {
        if (z) {
            this.f6191X |= 1;
        } else {
            this.f6191X &= -2;
        }
        m13491a(34, this.f6191X, (byte[]) null);
    }

    /* renamed from: r */
    private boolean m13493r() {
        if (this.f6449w.claimInterface(this.f6192l, true)) {
            Log.i(f6179a, "Interface succesfully claimed");
            int endpointCount = this.f6192l.getEndpointCount();
            for (int i = 0; i <= endpointCount - 1; i++) {
                UsbEndpoint endpoint = this.f6192l.getEndpoint(i);
                if (endpoint.getType() == 2 && endpoint.getDirection() == 128) {
                    this.f6193m = endpoint;
                } else if (endpoint.getType() == 2 && endpoint.getDirection() == 0) {
                    this.f6194n = endpoint;
                }
            }
            if (this.f6194n == null || this.f6193m == null) {
                Log.i(f6179a, "Interface does not have an IN or OUT interface");
                return false;
            }
            m13491a(32, 0, mo5703f());
            m13491a(34, 3, (byte[]) null);
            return true;
        }
        Log.i(f6179a, "Interface could not be claimed");
        return false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public byte[] mo5703f() {
        int e = mo5701e();
        if (e <= 0) {
            return f6187i;
        }
        byte[] bArr = (byte[]) f6187i.clone();
        for (int i = 0; i < 4; i++) {
            bArr[i] = (byte) ((e >> (i * 8)) & 255);
        }
        return bArr;
    }

    /* renamed from: a */
    private int m13491a(int i, int i2, byte[] bArr) {
        int controlTransfer = this.f6449w.controlTransfer(33, i, i2, 0, bArr, bArr != null ? bArr.length : 0, 0);
        String str = f6179a;
        Log.i(str, "Control Transfer Response: " + String.valueOf(controlTransfer));
        return controlTransfer;
    }

    /* renamed from: s */
    private byte[] m13494s() {
        byte[] bArr = new byte[7];
        int controlTransfer = this.f6449w.controlTransfer(161, 33, 0, 0, bArr, 7, 0);
        String str = f6179a;
        Log.i(str, "Control Transfer Response: " + String.valueOf(controlTransfer));
        return bArr;
    }

    /* renamed from: c */
    private static int m13492c(UsbDevice usbDevice) {
        int interfaceCount = usbDevice.getInterfaceCount();
        for (int i = 0; i < interfaceCount; i++) {
            if (usbDevice.getInterface(i).getInterfaceClass() == 10) {
                return i;
            }
        }
        Log.i(f6179a, "There is no CDC class interface");
        return -1;
    }
}
