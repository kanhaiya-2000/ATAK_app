package atakplugin.UASTool;

import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbDeviceConnection;
import android.hardware.usb.UsbEndpoint;
import android.hardware.usb.UsbInterface;
import android.hardware.usb.UsbRequest;
import android.util.Log;

/* renamed from: atakplugin.UASTool.sf */
public class C0826sf extends C0855st {

    /* renamed from: A */
    private static final int f6301A = 48;

    /* renamed from: a */
    public static final int f6302a = 0;

    /* renamed from: b */
    public static final int f6303b = 1;

    /* renamed from: c */
    public static final int f6304c = 2;

    /* renamed from: d */
    public static final int f6305d = 3;

    /* renamed from: e */
    public static final int f6306e = 4;

    /* renamed from: f */
    public static final int f6307f = 5;

    /* renamed from: g */
    public static final int f6308g = 6;

    /* renamed from: h */
    public static final int f6309h = 7;

    /* renamed from: v */
    private static final String f6310v = "sf";

    /* renamed from: w */
    private static final int f6311w = 192;

    /* renamed from: x */
    private static final int f6312x = 64;

    /* renamed from: y */
    private static final int f6313y = 49;

    /* renamed from: z */
    private static final int f6314z = 37;

    /* renamed from: B */
    private final UsbInterface f6315B;

    /* renamed from: C */
    private UsbEndpoint f6316C;

    /* renamed from: D */
    private UsbEndpoint f6317D;

    /* renamed from: E */
    private UsbRequest f6318E;

    /* renamed from: F */
    private int f6319F;

    public C0826sf(UsbDevice usbDevice, UsbDeviceConnection usbDeviceConnection) {
        this(usbDevice, usbDeviceConnection, -1);
    }

    public C0826sf(UsbDevice usbDevice, UsbDeviceConnection usbDeviceConnection, int i) {
        super(usbDevice, usbDeviceConnection);
        this.f6315B = usbDevice.getInterface(i < 0 ? 0 : i);
        this.f6319F = 0;
    }

    /* renamed from: a */
    public boolean mo5709a() {
        if (!m13607i()) {
            return false;
        }
        mo5783f();
        mo5785h();
        mo5780a(this.f6316C, this.f6317D);
        return true;
    }

    /* renamed from: b */
    public int mo5710b() {
        return this.f6319F;
    }

    /* renamed from: a */
    public void mo5707a(byte[] bArr) {
        byte[] bArr2 = new byte[(bArr.length + 8)];
        bArr2[0] = 0;
        bArr2[1] = 0;
        bArr2[2] = 1;
        bArr2[3] = Byte.MIN_VALUE;
        bArr2[4] = (byte) (bArr.length & 255);
        bArr2[5] = (byte) ((bArr.length >> 8) & 255);
        bArr2[6] = (byte) ((bArr.length >> 16) & 255);
        bArr2[7] = (byte) ((bArr.length >> 24) & 255);
        System.arraycopy(bArr, 0, bArr2, 8, bArr.length);
        this.f6483l.mo5721a(bArr2);
    }

    /* renamed from: a */
    public void mo5706a(int i) {
        switch (i) {
            case 0:
                m13604a(this.f6319F, 0);
                return;
            case 1:
                m13604a(this.f6319F, 1);
                return;
            case 2:
                m13604a(this.f6319F, 2);
                return;
            case 3:
                m13604a(this.f6319F, 3);
                return;
            case 4:
                m13604a(this.f6319F, 4);
                return;
            case 5:
                m13604a(this.f6319F, 5);
                return;
            case 6:
                m13604a(this.f6319F, 6);
                return;
            case 7:
                m13604a(this.f6319F, 7);
                return;
            default:
                return;
        }
    }

    /* renamed from: b */
    public void mo5711b(int i) {
        this.f6483l.mo5721a(new byte[]{0, 0, 0, Byte.MIN_VALUE, (byte) (i & 255), (byte) ((i >> 8) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 24) & 255)});
    }

    /* renamed from: a */
    public void mo5708a(byte[] bArr, int i) {
        byte[] bArr2 = new byte[(bArr.length + 8)];
        bArr2[0] = 0;
        bArr2[1] = 0;
        bArr2[2] = 2;
        bArr2[3] = Byte.MIN_VALUE;
        bArr2[4] = (byte) (i & 255);
        bArr2[5] = (byte) ((i >> 8) & 255);
        bArr2[6] = (byte) ((i >> 16) & 255);
        bArr2[7] = (byte) ((i >> 24) & 255);
        System.arraycopy(bArr, 0, bArr2, 8, bArr.length);
        this.f6483l.mo5721a(bArr2);
    }

    /* renamed from: c */
    public void mo5713c(int i) {
        if (i > 10 || i < 0) {
            Log.i(f6310v, "selected slave must be in 0-10 range");
        } else {
            m13605a(i, true);
        }
    }

    /* renamed from: c */
    public int mo5712c() {
        return m13608j()[this.f6319F] & 7;
    }

    /* renamed from: d */
    public void mo5714d() {
        mo5782e();
        mo5784g();
        this.f6482k.releaseInterface(this.f6315B);
    }

    /* renamed from: i */
    private boolean m13607i() {
        if (this.f6482k.claimInterface(this.f6315B, true)) {
            Log.i(f6310v, "Interface succesfully claimed");
            int endpointCount = this.f6315B.getEndpointCount();
            for (int i = 0; i <= endpointCount - 1; i++) {
                UsbEndpoint endpoint = this.f6315B.getEndpoint(i);
                if (endpoint.getType() == 2 && endpoint.getDirection() == 128) {
                    this.f6316C = endpoint;
                } else {
                    this.f6317D = endpoint;
                }
            }
            return true;
        }
        Log.i(f6310v, "Interface could not be claimed");
        return false;
    }

    /* renamed from: a */
    private void m13604a(int i, int i2) {
        byte[] bArr = new byte[2];
        if (i < 0 || i > 10) {
            Log.i(f6310v, "Channel not valid");
            return;
        }
        bArr[0] = (byte) i;
        bArr[1] = (byte) i2;
        bArr[1] = (byte) (bArr[1] | 8);
        m13603a(49, 0, 0, bArr);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: InitCodeVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Several immutable types in one variable: [int, byte], vars: [r0v0 ?, r0v1 ?, r0v3 ?]
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVarType(InitCodeVariables.java:102)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:78)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:69)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:51)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:32)
        */
    /* renamed from: a */
    private void m13605a(int r5, boolean r6) {
        /*
            r4 = this;
            r0 = 2
            byte[] r1 = new byte[r0]
            if (r5 < 0) goto L_0x0020
            r2 = 10
            if (r5 > r2) goto L_0x0020
            byte r2 = (byte) r5
            r3 = 0
            r1[r3] = r2
            r2 = 1
            if (r6 == 0) goto L_0x0011
            goto L_0x0012
        L_0x0011:
            r0 = 1
        L_0x0012:
            r1[r2] = r0
            r6 = 37
            int r6 = r4.m13603a((int) r6, (int) r3, (int) r3, (byte[]) r1)
            r0 = -1
            if (r6 == r0) goto L_0x001f
            r4.f6319F = r5
        L_0x001f:
            return
        L_0x0020:
            java.lang.String r5 = f6310v
            java.lang.String r6 = "Channel not valid"
            android.util.Log.i(r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.C0826sf.m13605a(int, boolean):void");
    }

    /* renamed from: j */
    private byte[] m13608j() {
        return m13606a(48, 0, 0, 2);
    }

    /* renamed from: a */
    private int m13603a(int i, int i2, int i3, byte[] bArr) {
        int controlTransfer = this.f6482k.controlTransfer(64, i, i2, this.f6315B.getId(), bArr, bArr != null ? bArr.length : 0, 5000);
        String str = f6310v;
        Log.i(str, "Control Transfer Response: " + String.valueOf(controlTransfer));
        return controlTransfer;
    }

    /* renamed from: a */
    private byte[] m13606a(int i, int i2, int i3, int i4) {
        byte[] bArr = new byte[i4];
        int controlTransfer = this.f6482k.controlTransfer(192, i, i2, this.f6315B.getId(), bArr, i4, 5000);
        String str = f6310v;
        Log.i(str, "Control Transfer Response: " + String.valueOf(controlTransfer));
        return bArr;
    }
}
