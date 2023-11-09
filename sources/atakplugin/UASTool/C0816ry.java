package atakplugin.UASTool;

import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbDeviceConnection;
import android.hardware.usb.UsbEndpoint;
import android.hardware.usb.UsbInterface;
import android.hardware.usb.UsbRequest;
import android.util.Log;
import atakplugin.UASTool.C0847ss;

@Deprecated
/* renamed from: atakplugin.UASTool.ry */
public class C0816ry extends C0842sq {

    /* renamed from: a */
    private static final String f6160a = "ry";

    /* renamed from: b */
    private static final int f6161b = 33;

    /* renamed from: c */
    private static final int f6162c = 161;

    /* renamed from: d */
    private static final int f6163d = 32;

    /* renamed from: e */
    private static final int f6164e = 33;

    /* renamed from: f */
    private static final int f6165f = 34;

    /* renamed from: g */
    private static final byte[] f6166g = {0, 1, -62, 0, 0, 0, 8};

    /* renamed from: h */
    private static final int f6167h = 3;

    /* renamed from: i */
    private static final int f6168i = 2;

    /* renamed from: j */
    private final UsbInterface f6169j;

    /* renamed from: k */
    private UsbEndpoint f6170k;

    /* renamed from: l */
    private UsbEndpoint f6171l;

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

    /* renamed from: b */
    public void mo5693b(boolean z) {
    }

    /* renamed from: c */
    public void mo5695c(boolean z) {
    }

    /* renamed from: c */
    public boolean mo5696c() {
        return false;
    }

    /* renamed from: d */
    public void mo5697d() {
    }

    /* renamed from: e */
    public void mo5699e(int i) {
    }

    @Deprecated
    public C0816ry(UsbDevice usbDevice, UsbDeviceConnection usbDeviceConnection) {
        super(usbDevice, usbDeviceConnection);
        this.f6169j = usbDevice.getInterface(1);
    }

    /* renamed from: a */
    public boolean mo5690a() {
        mo5764o();
        mo5766q();
        if (this.f6449w.claimInterface(this.f6169j, true)) {
            Log.i(f6160a, "Interface succesfully claimed");
        } else {
            Log.i(f6160a, "Interface could not be claimed");
        }
        int endpointCount = this.f6169j.getEndpointCount();
        for (int i = 0; i <= endpointCount - 1; i++) {
            UsbEndpoint endpoint = this.f6169j.getEndpoint(i);
            if (endpoint.getType() == 2 && endpoint.getDirection() == 128) {
                this.f6170k = endpoint;
            } else {
                this.f6171l = endpoint;
            }
        }
        m13469a(32, 0, f6166g);
        m13469a(34, 3, (byte[]) null);
        UsbRequest usbRequest = new UsbRequest();
        usbRequest.initialize(this.f6449w, this.f6170k);
        mo5750a(usbRequest, this.f6171l);
        return true;
    }

    /* renamed from: b */
    public void mo5691b() {
        m13469a(34, 2, (byte[]) null);
        mo5763n();
        mo5765p();
        this.f6449w.releaseInterface(this.f6169j);
    }

    /* renamed from: a */
    public void mo5682a(int i) {
        byte[] f = m13470f();
        f[3] = (byte) (i & 255);
        f[2] = (byte) ((i >> 8) & 255);
        f[1] = (byte) ((i >> 16) & 255);
        f[0] = (byte) ((i >> 24) & 255);
        m13469a(32, 0, f);
    }

    /* renamed from: b */
    public void mo5692b(int i) {
        byte[] f = m13470f();
        if (i == 5) {
            f[6] = 5;
        } else if (i == 6) {
            f[6] = 6;
        } else if (i == 7) {
            f[6] = 7;
        } else if (i == 8) {
            f[6] = 8;
        }
        m13469a(32, 0, f);
    }

    /* renamed from: c */
    public void mo5694c(int i) {
        byte[] f = m13470f();
        if (i == 1) {
            f[4] = 0;
        } else if (i == 2) {
            f[4] = 2;
        } else if (i == 3) {
            f[4] = 1;
        }
        m13469a(32, 0, f);
    }

    /* renamed from: d */
    public void mo5698d(int i) {
        byte[] f = m13470f();
        if (i == 0) {
            f[5] = 0;
        } else if (i == 1) {
            f[5] = 1;
        } else if (i == 2) {
            f[5] = 2;
        } else if (i == 3) {
            f[5] = 3;
        } else if (i == 4) {
            f[5] = 4;
        }
        m13469a(32, 0, f);
    }

    /* renamed from: a */
    private int m13469a(int i, int i2, byte[] bArr) {
        int controlTransfer = this.f6449w.controlTransfer(33, i, i2, 0, bArr, bArr != null ? bArr.length : 0, 0);
        String str = f6160a;
        Log.i(str, "Control Transfer Response: " + String.valueOf(controlTransfer));
        return controlTransfer;
    }

    /* renamed from: f */
    private byte[] m13470f() {
        byte[] bArr = new byte[7];
        int controlTransfer = this.f6449w.controlTransfer(161, 33, 0, 0, bArr, 7, 0);
        String str = f6160a;
        Log.i(str, "Control Transfer Response: " + String.valueOf(controlTransfer));
        return bArr;
    }
}
