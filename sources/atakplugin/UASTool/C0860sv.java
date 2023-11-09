package atakplugin.UASTool;

import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbDeviceConnection;
import android.hardware.usb.UsbEndpoint;
import android.hardware.usb.UsbInterface;
import android.hardware.usb.UsbRequest;
import android.util.Log;
import atakplugin.UASTool.C0847ss;
import com.google.common.base.Ascii;

@Deprecated
/* renamed from: atakplugin.UASTool.sv */
public class C0860sv extends C0842sq {

    /* renamed from: W */
    private static final int f6498W = 0;

    /* renamed from: X */
    private static final int f6499X = 2048;

    /* renamed from: Y */
    private static final int f6500Y = 0;

    /* renamed from: Z */
    private static final int f6501Z = 1;

    /* renamed from: a */
    private static final String f6502a = "sv";

    /* renamed from: aa */
    private static final int f6503aa = 16;

    /* renamed from: ab */
    private static final int f6504ab = 17;

    /* renamed from: ac */
    private static final int f6505ac = 0;

    /* renamed from: ad */
    private static final int f6506ad = 0;

    /* renamed from: ae */
    private static final int f6507ae = 115200;

    /* renamed from: b */
    private static final int f6508b = 0;

    /* renamed from: c */
    private static final int f6509c = 1;

    /* renamed from: d */
    private static final int f6510d = 3;

    /* renamed from: e */
    private static final int f6511e = 4;

    /* renamed from: f */
    private static final int f6512f = 7;

    /* renamed from: g */
    private static final int f6513g = 30;

    /* renamed from: h */
    private static final int f6514h = 19;

    /* renamed from: i */
    private static final int f6515i = 9;

    /* renamed from: j */
    private static final int f6516j = 10;

    /* renamed from: k */
    private static final int f6517k = 25;

    /* renamed from: l */
    private static final int f6518l = 65;

    /* renamed from: m */
    private static final int f6519m = 193;

    /* renamed from: n */
    private static final int f6520n = 1;

    /* renamed from: af */
    private final UsbInterface f6521af;

    /* renamed from: ag */
    private UsbEndpoint f6522ag;

    /* renamed from: ah */
    private UsbEndpoint f6523ah;

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

    public C0860sv(UsbDevice usbDevice, UsbDeviceConnection usbDeviceConnection) {
        this(usbDevice, usbDeviceConnection, -1);
    }

    public C0860sv(UsbDevice usbDevice, UsbDeviceConnection usbDeviceConnection, int i) {
        super(usbDevice, usbDeviceConnection);
        this.f6521af = usbDevice.getInterface(i < 0 ? 0 : i);
    }

    /* renamed from: a */
    public boolean mo5690a() {
        mo5764o();
        mo5766q();
        if (this.f6449w.claimInterface(this.f6521af, true)) {
            Log.i(f6502a, "Interface succesfully claimed");
            int endpointCount = this.f6521af.getEndpointCount();
            for (int i = 0; i <= endpointCount - 1; i++) {
                UsbEndpoint endpoint = this.f6521af.getEndpoint(i);
                if (endpoint.getType() == 2 && endpoint.getDirection() == 128) {
                    this.f6522ag = endpoint;
                } else {
                    this.f6523ah = endpoint;
                }
            }
            if (m13851a(0, 1, (byte[]) null) < 0) {
                return false;
            }
            mo5682a((int) f6507ae);
            if (m13851a(3, 2048, (byte[]) null) < 0) {
                return false;
            }
            mo5699e(0);
            if (m13851a(7, 0, (byte[]) null) < 0) {
                return false;
            }
            UsbRequest usbRequest = new UsbRequest();
            usbRequest.initialize(this.f6449w, this.f6522ag);
            mo5750a(usbRequest, this.f6523ah);
            return true;
        }
        Log.i(f6502a, "Interface could not be claimed");
        return false;
    }

    /* renamed from: b */
    public void mo5691b() {
        m13851a(0, 0, (byte[]) null);
        mo5763n();
        mo5765p();
        this.f6449w.releaseInterface(this.f6521af);
    }

    /* renamed from: a */
    public void mo5682a(int i) {
        m13851a(30, 0, new byte[]{(byte) (i & 255), (byte) ((i >> 8) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 24) & 255)});
    }

    /* renamed from: b */
    public void mo5692b(int i) {
        byte[] f = m13852f();
        if (i == 5) {
            f[1] = 5;
        } else if (i == 6) {
            f[1] = 6;
        } else if (i == 7) {
            f[1] = 7;
        } else if (i == 8) {
            f[1] = 8;
        } else {
            return;
        }
        m13851a(3, (byte) ((f[1] << 8) | (f[0] & 255)), (byte[]) null);
    }

    /* renamed from: c */
    public void mo5694c(int i) {
        byte[] f = m13852f();
        if (i == 1) {
            f[0] = (byte) (f[0] & -2);
            f[0] = (byte) (f[0] & -3);
        } else if (i == 2) {
            f[0] = (byte) (f[0] & -2);
            f[0] = (byte) (f[0] | 2);
        } else if (i == 3) {
            f[0] = (byte) (f[0] | 1);
            f[0] = (byte) (f[0] & -3);
        } else {
            return;
        }
        m13851a(3, (byte) ((f[1] << 8) | (f[0] & 255)), (byte[]) null);
    }

    /* renamed from: d */
    public void mo5698d(int i) {
        byte[] f = m13852f();
        if (i == 0) {
            f[0] = (byte) (f[0] & -17);
            f[0] = (byte) (f[0] & -33);
            f[0] = (byte) (f[0] & -65);
            f[0] = (byte) (f[0] & -129);
        } else if (i == 1) {
            f[0] = (byte) (f[0] | 16);
            f[0] = (byte) (f[0] & -33);
            f[0] = (byte) (f[0] & -65);
            f[0] = (byte) (f[0] & -129);
        } else if (i == 2) {
            f[0] = (byte) (f[0] & -17);
            f[0] = (byte) (f[0] | 32);
            f[0] = (byte) (f[0] & -65);
            f[0] = (byte) (f[0] & -129);
        } else if (i == 3) {
            f[0] = (byte) (f[0] | 16);
            f[0] = (byte) (f[0] | 32);
            f[0] = (byte) (f[0] & -65);
            f[0] = (byte) (f[0] & -129);
        } else if (i == 4) {
            f[0] = (byte) (f[0] & -17);
            f[0] = (byte) (f[0] & -33);
            f[0] = (byte) (f[0] | 64);
            f[0] = (byte) (f[0] & -129);
        } else {
            return;
        }
        m13851a(3, (byte) ((f[1] << 8) | (f[0] & 255)), (byte[]) null);
    }

    /* renamed from: e */
    public void mo5699e(int i) {
        if (i == 0) {
            m13851a(19, 0, new byte[]{1, 0, 0, 0, 64, 0, 0, 0, 0, Byte.MIN_VALUE, 0, 0, 0, 32, 0, 0});
        } else if (i == 1) {
            m13851a(19, 0, new byte[]{9, 0, 0, 0, Byte.MIN_VALUE, 0, 0, 0, 0, Byte.MIN_VALUE, 0, 0, 0, 32, 0, 0});
        } else if (i == 2) {
            m13851a(19, 0, new byte[]{Ascii.DC2, 0, 0, 0, 64, 0, 0, 0, 0, Byte.MIN_VALUE, 0, 0, 0, 32, 0, 0});
        } else if (i == 3) {
            m13851a(25, 0, new byte[]{0, 0, 0, 0, 17, 19});
            m13851a(19, 0, new byte[]{1, 0, 0, 0, 67, 0, 0, 0, 0, Byte.MIN_VALUE, 0, 0, 0, 32, 0, 0});
        }
    }

    /* renamed from: a */
    private int m13851a(int i, int i2, byte[] bArr) {
        int controlTransfer = this.f6449w.controlTransfer(65, i, i2, this.f6521af.getId(), bArr, bArr != null ? bArr.length : 0, 0);
        String str = f6502a;
        Log.i(str, "Control Transfer Response: " + String.valueOf(controlTransfer));
        return controlTransfer;
    }

    /* renamed from: f */
    private byte[] m13852f() {
        byte[] bArr = new byte[2];
        int controlTransfer = this.f6449w.controlTransfer(193, 4, 0, this.f6521af.getId(), bArr, 2, 0);
        String str = f6502a;
        Log.i(str, "Control Transfer Response: " + String.valueOf(controlTransfer));
        return bArr;
    }
}
