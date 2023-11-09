package atakplugin.UASTool;

import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbDeviceConnection;
import android.hardware.usb.UsbEndpoint;
import android.hardware.usb.UsbRequest;
import android.os.Build;
import atakplugin.UASTool.C0847ss;

/* renamed from: atakplugin.UASTool.sq */
public abstract class C0842sq implements C0847ss {

    /* renamed from: o */
    public static final String f6431o = "cdc";

    /* renamed from: p */
    public static final String f6432p = "ch34x";

    /* renamed from: q */
    public static final String f6433q = "cp210x";

    /* renamed from: r */
    public static final String f6434r = "ftdi";

    /* renamed from: s */
    public static final String f6435s = "pl2303";

    /* renamed from: t */
    protected static final String f6436t = "COM ";

    /* renamed from: u */
    static final boolean f6437u = (Build.VERSION.SDK_INT > 17);

    /* renamed from: x */
    protected static final int f6438x = 0;

    /* renamed from: A */
    protected C0845c f6439A;

    /* renamed from: B */
    protected C0843a f6440B;

    /* renamed from: C */
    protected C0833sk f6441C;

    /* renamed from: D */
    protected C0834sl f6442D;

    /* renamed from: E */
    protected boolean f6443E;

    /* renamed from: F */
    protected boolean f6444F;

    /* renamed from: a */
    private UsbEndpoint f6445a;

    /* renamed from: b */
    private UsbEndpoint f6446b;

    /* renamed from: c */
    private String f6447c = "";

    /* renamed from: v */
    protected final UsbDevice f6448v;

    /* renamed from: w */
    protected final UsbDeviceConnection f6449w;

    /* renamed from: y */
    protected C0831sj f6450y;

    /* renamed from: z */
    protected C0844b f6451z;

    /* renamed from: a */
    public abstract void mo5682a(int i);

    /* renamed from: a */
    public abstract void mo5689a(boolean z);

    /* renamed from: a */
    public abstract boolean mo5690a();

    /* renamed from: b */
    public abstract void mo5691b();

    /* renamed from: b */
    public abstract void mo5692b(int i);

    /* renamed from: c */
    public abstract void mo5694c(int i);

    /* renamed from: c */
    public abstract boolean mo5696c();

    /* renamed from: d */
    public abstract void mo5697d();

    /* renamed from: d */
    public abstract void mo5698d(int i);

    /* renamed from: e */
    public int mo5701e() {
        return -1;
    }

    /* renamed from: e */
    public abstract void mo5699e(int i);

    /* renamed from: f */
    public void mo5702f(int i) {
    }

    public C0842sq(UsbDevice usbDevice, UsbDeviceConnection usbDeviceConnection) {
        this.f6448v = usbDevice;
        this.f6449w = usbDeviceConnection;
        this.f6443E = true;
        this.f6450y = new C0831sj(f6437u);
    }

    /* renamed from: a */
    public static C0842sq m13735a(UsbDevice usbDevice, UsbDeviceConnection usbDeviceConnection) {
        return m13736a(usbDevice, usbDeviceConnection, -1);
    }

    /* renamed from: a */
    public static C0842sq m13736a(UsbDevice usbDevice, UsbDeviceConnection usbDeviceConnection, int i) {
        int vendorId = usbDevice.getVendorId();
        int productId = usbDevice.getProductId();
        if (C0811rt.m13460a(usbDevice)) {
            return new C0827sg(usbDevice, usbDeviceConnection, i);
        }
        if (C0809rr.m13457a(vendorId, productId)) {
            return new C0823sd(usbDevice, usbDeviceConnection, i);
        }
        if (C0813rv.m13465a(vendorId, productId)) {
            return new C0829sh(usbDevice, usbDeviceConnection, i);
        }
        if (C0808rq.m13456a(vendorId, productId)) {
            return new C0820sb(usbDevice, usbDeviceConnection, i);
        }
        if (m13740b(usbDevice)) {
            return new C0819sa(usbDevice, usbDeviceConnection, i);
        }
        return null;
    }

    /* renamed from: a */
    public static C0842sq m13737a(String str, UsbDevice usbDevice, UsbDeviceConnection usbDeviceConnection, int i) {
        if (str.equals(f6434r)) {
            return new C0827sg(usbDevice, usbDeviceConnection, i);
        }
        if (str.equals(f6433q)) {
            return new C0823sd(usbDevice, usbDeviceConnection, i);
        }
        if (str.equals(f6435s)) {
            return new C0829sh(usbDevice, usbDeviceConnection, i);
        }
        if (str.equals(f6432p)) {
            return new C0820sb(usbDevice, usbDeviceConnection, i);
        }
        if (str.equals(f6431o)) {
            return new C0819sa(usbDevice, usbDeviceConnection, i);
        }
        throw new IllegalArgumentException("Invalid type argument. Must be:cdc, ch34x, cp210x, ftdi or pl2303");
    }

    /* renamed from: a */
    public static boolean m13738a(UsbDevice usbDevice) {
        int vendorId = usbDevice.getVendorId();
        int productId = usbDevice.getProductId();
        if (!C0811rt.m13460a(usbDevice) && !C0809rr.m13457a(vendorId, productId) && !C0813rv.m13465a(vendorId, productId) && !C0808rq.m13456a(vendorId, productId) && !m13740b(usbDevice)) {
            return false;
        }
        return true;
    }

    /* renamed from: b */
    public void mo5754b(byte[] bArr) {
        if (this.f6443E) {
            this.f6450y.mo5721a(bArr);
        }
    }

    /* renamed from: a */
    public int mo5748a(C0847ss.C0854g gVar) {
        if (!this.f6443E) {
            return -1;
        }
        if (f6437u) {
            C0844b bVar = this.f6451z;
            if (bVar == null) {
                return 0;
            }
            bVar.mo5770a(gVar);
            this.f6451z.mo5771c().queue(this.f6450y.mo5719a(), 16384);
            return 0;
        }
        this.f6440B.mo5768a(gVar);
        return 0;
    }

    /* renamed from: b */
    public int mo5752b(byte[] bArr, int i) {
        if (this.f6443E) {
            return -1;
        }
        if (bArr == null) {
            return 0;
        }
        return this.f6449w.bulkTransfer(this.f6446b, bArr, bArr.length, i);
    }

    /* renamed from: a */
    public int mo5715a(byte[] bArr, int i) {
        if (this.f6443E) {
            return -1;
        }
        if (bArr == null) {
            return 0;
        }
        return this.f6449w.bulkTransfer(this.f6445a, bArr, bArr.length, i);
    }

    /* renamed from: b */
    public int mo5753b(byte[] bArr, int i, int i2, int i3) {
        if (this.f6443E) {
            return -1;
        }
        if (bArr == null) {
            return 0;
        }
        return this.f6449w.bulkTransfer(this.f6446b, bArr, i, i2, i3);
    }

    /* renamed from: a */
    public int mo5716a(byte[] bArr, int i, int i2, int i3) {
        if (this.f6443E) {
            return -1;
        }
        if (bArr == null) {
            return 0;
        }
        return this.f6449w.bulkTransfer(this.f6445a, bArr, i, i2, i3);
    }

    /* renamed from: g */
    public C0833sk mo5756g() {
        if (!this.f6443E) {
            return this.f6441C;
        }
        throw new IllegalStateException("InputStream only available in Sync mode. \nOpen the port with syncOpen()");
    }

    /* renamed from: h */
    public C0834sl mo5757h() {
        if (!this.f6443E) {
            return this.f6442D;
        }
        throw new IllegalStateException("OutputStream only available in Sync mode. \nOpen the port with syncOpen()");
    }

    /* renamed from: i */
    public int mo5758i() {
        return this.f6448v.getVendorId();
    }

    /* renamed from: j */
    public int mo5759j() {
        return this.f6448v.getProductId();
    }

    /* renamed from: k */
    public int mo5760k() {
        return this.f6448v.getDeviceId();
    }

    /* renamed from: d */
    public void mo5755d(boolean z) {
        C0831sj sjVar = this.f6450y;
        if (sjVar != null) {
            sjVar.mo5720a(z);
        }
    }

    /* renamed from: a */
    public void mo5751a(String str) {
        this.f6447c = str;
    }

    /* renamed from: l */
    public String mo5761l() {
        return this.f6447c;
    }

    /* renamed from: m */
    public boolean mo5762m() {
        return this.f6444F;
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public boolean mo5703f() {
        return this instanceof C0827sg;
    }

    /* renamed from: b */
    public static boolean m13740b(UsbDevice usbDevice) {
        int interfaceCount = usbDevice.getInterfaceCount();
        for (int i = 0; i <= interfaceCount - 1; i++) {
            if (usbDevice.getInterface(i).getInterfaceClass() == 10) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: atakplugin.UASTool.sq$b */
    protected class C0844b extends C0815rx {

        /* renamed from: c */
        private final C0842sq f6457c;

        /* renamed from: d */
        private C0847ss.C0854g f6458d;

        /* renamed from: e */
        private UsbRequest f6459e;

        public C0844b(C0842sq sqVar) {
            this.f6457c = sqVar;
        }

        /* renamed from: b */
        public void mo5680b() {
            UsbRequest requestWait = C0842sq.this.f6449w.requestWait();
            if (requestWait != null && requestWait.getEndpoint().getType() == 2 && requestWait.getEndpoint().getDirection() == 128) {
                byte[] b = C0842sq.this.f6450y.mo5723b();
                if (C0842sq.this.mo5703f()) {
                    ((C0827sg) this.f6457c).f6371n.mo5718b(b);
                    C0842sq.this.f6450y.mo5724c();
                    if (b.length > 2) {
                        m13779a(C0827sg.m13625a(b));
                    }
                } else {
                    C0842sq.this.f6450y.mo5724c();
                    m13779a(b);
                }
                this.f6459e.queue(C0842sq.this.f6450y.mo5719a(), 16384);
            }
        }

        /* renamed from: a */
        public void mo5770a(C0847ss.C0854g gVar) {
            this.f6458d = gVar;
        }

        /* renamed from: a */
        public void mo5769a(UsbRequest usbRequest) {
            this.f6459e = usbRequest;
        }

        /* renamed from: c */
        public UsbRequest mo5771c() {
            return this.f6459e;
        }

        /* renamed from: a */
        private void m13779a(byte[] bArr) {
            C0847ss.C0854g gVar = this.f6458d;
            if (gVar != null) {
                gVar.mo5779a(bArr);
            }
        }
    }

    /* renamed from: atakplugin.UASTool.sq$c */
    private class C0845c extends C0815rx {

        /* renamed from: c */
        private UsbEndpoint f6461c;

        private C0845c() {
        }

        /* renamed from: b */
        public void mo5680b() {
            byte[] d = C0842sq.this.f6450y.mo5725d();
            if (d.length > 0) {
                C0842sq.this.f6449w.bulkTransfer(this.f6461c, d, d.length, 0);
            }
        }

        /* renamed from: a */
        public void mo5772a(UsbEndpoint usbEndpoint) {
            this.f6461c = usbEndpoint;
        }
    }

    /* renamed from: atakplugin.UASTool.sq$a */
    protected class C0843a extends C0815rx {

        /* renamed from: c */
        private final C0842sq f6453c;

        /* renamed from: d */
        private C0847ss.C0854g f6454d;

        /* renamed from: e */
        private UsbEndpoint f6455e;

        public C0843a(C0842sq sqVar) {
            this.f6453c = sqVar;
        }

        /* renamed from: a */
        public void mo5768a(C0847ss.C0854g gVar) {
            this.f6454d = gVar;
        }

        /* renamed from: b */
        public void mo5680b() {
            int i = 0;
            if (this.f6455e != null) {
                i = C0842sq.this.f6449w.bulkTransfer(this.f6455e, C0842sq.this.f6450y.mo5726e(), 16384, 0);
            }
            if (i > 0) {
                byte[] a = C0842sq.this.f6450y.mo5722a(i);
                if (C0842sq.this.mo5703f()) {
                    ((C0827sg) this.f6453c).f6371n.mo5718b(a);
                    if (a.length > 2) {
                        m13775a(C0827sg.m13625a(a));
                        return;
                    }
                    return;
                }
                m13775a(a);
            }
        }

        /* renamed from: a */
        public void mo5767a(UsbEndpoint usbEndpoint) {
            this.f6455e = usbEndpoint;
        }

        /* renamed from: a */
        private void m13775a(byte[] bArr) {
            C0847ss.C0854g gVar = this.f6454d;
            if (gVar != null) {
                gVar.mo5779a(bArr);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo5749a(UsbEndpoint usbEndpoint, UsbEndpoint usbEndpoint2) {
        this.f6445a = usbEndpoint;
        this.f6446b = usbEndpoint2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo5750a(UsbRequest usbRequest, UsbEndpoint usbEndpoint) {
        this.f6439A.mo5772a(usbEndpoint);
        if (f6437u) {
            this.f6451z.mo5769a(usbRequest);
        } else {
            this.f6440B.mo5767a(usbRequest.getEndpoint());
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: n */
    public void mo5763n() {
        C0843a aVar;
        C0844b bVar;
        boolean z = f6437u;
        if (z && (bVar = this.f6451z) != null) {
            bVar.mo5679a();
            this.f6451z = null;
        } else if (!z && (aVar = this.f6440B) != null) {
            aVar.mo5679a();
            this.f6440B = null;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: o */
    public void mo5764o() {
        boolean z = f6437u;
        if (z && this.f6451z == null) {
            C0844b bVar = new C0844b(this);
            this.f6451z = bVar;
            bVar.start();
            do {
            } while (!this.f6451z.isAlive());
        } else if (!z && this.f6440B == null) {
            C0843a aVar = new C0843a(this);
            this.f6440B = aVar;
            aVar.start();
            do {
            } while (!this.f6440B.isAlive());
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: p */
    public void mo5765p() {
        C0845c cVar = this.f6439A;
        if (cVar != null) {
            cVar.mo5679a();
            this.f6439A = null;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: q */
    public void mo5766q() {
        if (this.f6439A == null) {
            C0845c cVar = new C0845c();
            this.f6439A = cVar;
            cVar.start();
            do {
            } while (!this.f6439A.isAlive());
        }
    }
}
