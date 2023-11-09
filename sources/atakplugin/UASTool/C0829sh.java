package atakplugin.UASTool;

import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbDeviceConnection;
import android.hardware.usb.UsbEndpoint;
import android.hardware.usb.UsbInterface;
import android.hardware.usb.UsbRequest;
import android.util.Log;
import atakplugin.UASTool.C0847ss;

/* renamed from: atakplugin.UASTool.sh */
public class C0829sh extends C0842sq {

    /* renamed from: a */
    private static final String f6373a = "sh";

    /* renamed from: b */
    private static final int f6374b = 64;

    /* renamed from: c */
    private static final int f6375c = 192;

    /* renamed from: d */
    private static final int f6376d = 33;

    /* renamed from: e */
    private static final int f6377e = 1;

    /* renamed from: f */
    private static final int f6378f = 32;

    /* renamed from: g */
    private static final int f6379g = 34;

    /* renamed from: h */
    private final byte[] f6380h;

    /* renamed from: i */
    private final UsbInterface f6381i;

    /* renamed from: j */
    private UsbEndpoint f6382j;

    /* renamed from: k */
    private UsbEndpoint f6383k;

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

    /* renamed from: e */
    public void mo5699e(int i) {
    }

    public C0829sh(UsbDevice usbDevice, UsbDeviceConnection usbDeviceConnection) {
        this(usbDevice, usbDeviceConnection, -1);
    }

    public C0829sh(UsbDevice usbDevice, UsbDeviceConnection usbDeviceConnection, int i) {
        super(usbDevice, usbDeviceConnection);
        this.f6380h = new byte[]{Byte.MIN_VALUE, 37, 0, 0, 0, 0, 8};
        if (i <= 1) {
            this.f6381i = usbDevice.getInterface(i < 0 ? 0 : i);
            return;
        }
        throw new IllegalArgumentException("Multi-interface PL2303 devices not supported!");
    }

    /* renamed from: a */
    public boolean mo5690a() {
        if (m13667f()) {
            C0865sz szVar = new C0865sz();
            szVar.initialize(this.f6449w, this.f6382j);
            mo5764o();
            mo5766q();
            mo5750a((UsbRequest) szVar, this.f6383k);
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
        this.f6449w.releaseInterface(this.f6381i);
        this.f6444F = false;
    }

    /* renamed from: c */
    public boolean mo5696c() {
        if (m13667f()) {
            mo5749a(this.f6382j, this.f6383k);
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
        this.f6449w.releaseInterface(this.f6381i);
        this.f6444F = false;
    }

    /* renamed from: a */
    public void mo5682a(int i) {
        byte[] bArr = {(byte) (i & 255), (byte) ((i >> 8) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 24) & 255)};
        byte b = bArr[0];
        byte[] bArr2 = this.f6380h;
        if (b != bArr2[0] || bArr[1] != bArr2[1] || bArr[2] != bArr2[2] || bArr[3] != bArr2[3]) {
            bArr2[0] = bArr[0];
            bArr2[1] = bArr[1];
            bArr2[2] = bArr[2];
            bArr2[3] = bArr[3];
            m13666a(33, 32, 0, 0, bArr2);
        }
    }

    /* renamed from: b */
    public void mo5692b(int i) {
        if (i == 5) {
            byte[] bArr = this.f6380h;
            if (bArr[6] != 5) {
                bArr[6] = 5;
                m13666a(33, 32, 0, 0, bArr);
            }
        } else if (i == 6) {
            byte[] bArr2 = this.f6380h;
            if (bArr2[6] != 6) {
                bArr2[6] = 6;
                m13666a(33, 32, 0, 0, bArr2);
            }
        } else if (i == 7) {
            byte[] bArr3 = this.f6380h;
            if (bArr3[6] != 7) {
                bArr3[6] = 7;
                m13666a(33, 32, 0, 0, bArr3);
            }
        } else if (i == 8) {
            byte[] bArr4 = this.f6380h;
            if (bArr4[6] != 8) {
                bArr4[6] = 8;
                m13666a(33, 32, 0, 0, bArr4);
            }
        }
    }

    /* renamed from: c */
    public void mo5694c(int i) {
        if (i == 1) {
            byte[] bArr = this.f6380h;
            if (bArr[4] != 0) {
                bArr[4] = 0;
                m13666a(33, 32, 0, 0, bArr);
            }
        } else if (i == 2) {
            byte[] bArr2 = this.f6380h;
            if (bArr2[4] != 2) {
                bArr2[4] = 2;
                m13666a(33, 32, 0, 0, bArr2);
            }
        } else if (i == 3) {
            byte[] bArr3 = this.f6380h;
            if (bArr3[4] != 1) {
                bArr3[4] = 1;
                m13666a(33, 32, 0, 0, bArr3);
            }
        }
    }

    /* renamed from: d */
    public void mo5698d(int i) {
        if (i == 0) {
            byte[] bArr = this.f6380h;
            if (bArr[5] != 0) {
                bArr[5] = 0;
                m13666a(33, 32, 0, 0, bArr);
            }
        } else if (i == 1) {
            byte[] bArr2 = this.f6380h;
            if (bArr2[5] != 1) {
                bArr2[5] = 1;
                m13666a(33, 32, 0, 0, bArr2);
            }
        } else if (i == 2) {
            byte[] bArr3 = this.f6380h;
            if (bArr3[5] != 2) {
                bArr3[5] = 2;
                m13666a(33, 32, 0, 0, bArr3);
            }
        } else if (i == 3) {
            byte[] bArr4 = this.f6380h;
            if (bArr4[5] != 3) {
                bArr4[5] = 3;
                m13666a(33, 32, 0, 0, bArr4);
            }
        } else if (i == 4) {
            byte[] bArr5 = this.f6380h;
            if (bArr5[5] != 4) {
                bArr5[5] = 4;
                m13666a(33, 32, 0, 0, bArr5);
            }
        }
    }

    /* renamed from: f */
    private boolean m13667f() {
        if (this.f6449w.claimInterface(this.f6381i, true)) {
            Log.i(f6373a, "Interface succesfully claimed");
            int endpointCount = this.f6381i.getEndpointCount();
            for (int i = 0; i <= endpointCount - 1; i++) {
                UsbEndpoint endpoint = this.f6381i.getEndpoint(i);
                if (endpoint.getType() == 2 && endpoint.getDirection() == 128) {
                    this.f6382j = endpoint;
                } else if (endpoint.getType() == 2 && endpoint.getDirection() == 0) {
                    this.f6383k = endpoint;
                }
            }
            byte[] bArr = new byte[1];
            if (m13666a(192, 1, 33924, 0, bArr) < 0 || m13666a(64, 1, 1028, 0, (byte[]) null) < 0 || m13666a(192, 1, 33924, 0, bArr) < 0 || m13666a(192, 1, 33667, 0, bArr) < 0 || m13666a(192, 1, 33924, 0, bArr) < 0 || m13666a(64, 1, 1028, 1, (byte[]) null) < 0 || m13666a(192, 1, 33924, 0, bArr) < 0 || m13666a(192, 1, 33667, 0, bArr) < 0 || m13666a(64, 1, 0, 1, (byte[]) null) < 0 || m13666a(64, 1, 1, 0, (byte[]) null) < 0 || m13666a(64, 1, 2, 68, (byte[]) null) < 0 || m13666a(33, 34, 3, 0, (byte[]) null) < 0) {
                return false;
            }
            return m13666a(33, 32, 0, 0, this.f6380h) >= 0 && m13666a(64, 1, 1285, 4881, (byte[]) null) >= 0;
        }
        Log.i(f6373a, "Interface could not be claimed");
        return false;
    }

    /* renamed from: a */
    private int m13666a(int i, int i2, int i3, int i4, byte[] bArr) {
        int controlTransfer = this.f6449w.controlTransfer(i, i2, i3, i4, bArr, bArr != null ? bArr.length : 0, 0);
        String str = f6373a;
        Log.i(str, "Control Transfer Response: " + String.valueOf(controlTransfer));
        return controlTransfer;
    }
}
