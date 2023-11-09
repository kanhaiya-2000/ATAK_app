package atakplugin.UASTool;

import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbDeviceConnection;
import android.hardware.usb.UsbEndpoint;
import atakplugin.UASTool.C0858su;

/* renamed from: atakplugin.UASTool.st */
public abstract class C0855st implements C0858su {

    /* renamed from: i */
    protected static final int f6478i = 5000;

    /* renamed from: a */
    private UsbEndpoint f6479a;

    /* renamed from: b */
    private UsbEndpoint f6480b;

    /* renamed from: j */
    protected final UsbDevice f6481j;

    /* renamed from: k */
    protected final UsbDeviceConnection f6482k;

    /* renamed from: l */
    protected C0831sj f6483l = new C0831sj(false);

    /* renamed from: m */
    protected C0857b f6484m;

    /* renamed from: n */
    protected C0856a f6485n;

    /* renamed from: a */
    public abstract void mo5706a(int i);

    /* renamed from: a */
    public abstract void mo5707a(byte[] bArr);

    /* renamed from: a */
    public abstract void mo5708a(byte[] bArr, int i);

    /* renamed from: a */
    public abstract boolean mo5709a();

    /* renamed from: b */
    public abstract int mo5710b();

    /* renamed from: b */
    public abstract void mo5711b(int i);

    /* renamed from: c */
    public abstract int mo5712c();

    /* renamed from: c */
    public abstract void mo5713c(int i);

    /* renamed from: d */
    public abstract void mo5714d();

    public C0855st(UsbDevice usbDevice, UsbDeviceConnection usbDeviceConnection) {
        this.f6481j = usbDevice;
        this.f6482k = usbDeviceConnection;
    }

    /* renamed from: a */
    public static C0855st m13817a(UsbDevice usbDevice, UsbDeviceConnection usbDeviceConnection) {
        return m13818a(usbDevice, usbDeviceConnection, -1);
    }

    /* renamed from: a */
    public static C0855st m13818a(UsbDevice usbDevice, UsbDeviceConnection usbDeviceConnection, int i) {
        if (C0810rs.m13458a(usbDevice.getVendorId(), usbDevice.getProductId())) {
            return new C0826sf(usbDevice, usbDeviceConnection, i);
        }
        return null;
    }

    /* renamed from: a */
    public void mo5781a(C0858su.C0859a aVar) {
        this.f6485n.mo5787a(aVar);
    }

    /* renamed from: atakplugin.UASTool.st$b */
    protected class C0857b extends C0815rx {

        /* renamed from: c */
        private UsbEndpoint f6490c;

        protected C0857b() {
        }

        /* renamed from: b */
        public void mo5680b() {
            byte[] d = C0855st.this.f6483l.mo5725d();
            if (d.length > 0) {
                C0855st.this.f6482k.bulkTransfer(this.f6490c, d, d.length, 5000);
            }
        }

        /* renamed from: a */
        public void mo5788a(UsbEndpoint usbEndpoint) {
            this.f6490c = usbEndpoint;
        }
    }

    /* renamed from: atakplugin.UASTool.st$a */
    protected class C0856a extends C0815rx {

        /* renamed from: c */
        private C0858su.C0859a f6487c;

        /* renamed from: d */
        private UsbEndpoint f6488d;

        protected C0856a() {
        }

        /* renamed from: a */
        public void mo5787a(C0858su.C0859a aVar) {
            this.f6487c = aVar;
        }

        /* renamed from: b */
        public void mo5680b() {
            int i = 0;
            if (this.f6488d != null) {
                i = C0855st.this.f6482k.bulkTransfer(this.f6488d, C0855st.this.f6483l.mo5726e(), 16384, 0);
            }
            if (i > 0) {
                m13834a(C0855st.this.f6483l.mo5722a(i));
            }
        }

        /* renamed from: a */
        public void mo5786a(UsbEndpoint usbEndpoint) {
            this.f6488d = usbEndpoint;
        }

        /* renamed from: a */
        private void m13834a(byte[] bArr) {
            C0858su.C0859a aVar = this.f6487c;
            if (aVar != null) {
                aVar.mo5789a(bArr);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo5780a(UsbEndpoint usbEndpoint, UsbEndpoint usbEndpoint2) {
        C0857b bVar = this.f6484m;
        if (bVar != null) {
            bVar.mo5788a(usbEndpoint2);
        }
        C0856a aVar = this.f6485n;
        if (aVar != null) {
            aVar.mo5786a(usbEndpoint);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public void mo5782e() {
        C0856a aVar = this.f6485n;
        if (aVar != null) {
            aVar.mo5679a();
            this.f6485n = null;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public void mo5783f() {
        C0856a aVar = new C0856a();
        this.f6485n = aVar;
        aVar.start();
        do {
        } while (!this.f6485n.isAlive());
    }

    /* access modifiers changed from: protected */
    /* renamed from: g */
    public void mo5784g() {
        C0857b bVar = this.f6484m;
        if (bVar != null) {
            bVar.mo5679a();
            this.f6484m = null;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: h */
    public void mo5785h() {
        if (this.f6484m == null) {
            C0857b bVar = new C0857b();
            this.f6484m = bVar;
            bVar.start();
            do {
            } while (!this.f6484m.isAlive());
        }
    }
}
