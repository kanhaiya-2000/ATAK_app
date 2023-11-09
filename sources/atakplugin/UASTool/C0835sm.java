package atakplugin.UASTool;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbDeviceConnection;
import android.hardware.usb.UsbManager;
import atakplugin.UASTool.C0835sm;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

/* renamed from: atakplugin.UASTool.sm */
public class C0835sm {

    /* renamed from: a */
    private static final String f6400a = "com.felhr.usbserial.USB_PERMISSION";

    /* renamed from: b */
    private static final int f6401b = 0;

    /* renamed from: c */
    private static final int f6402c = 1;

    /* renamed from: d */
    private static C0835sm f6403d;

    /* renamed from: e */
    private List<C0838c> f6404e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public List<C0842sq> f6405f = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final ArrayBlockingQueue<C0837b> f6406g = new ArrayBlockingQueue<>(100);
    /* access modifiers changed from: private */

    /* renamed from: h */
    public volatile boolean f6407h = false;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public C0837b f6408i;

    /* renamed from: j */
    private UsbManager f6409j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public final C0840so f6410k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public int f6411l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public int f6412m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public int f6413n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public int f6414o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public int f6415p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public int f6416q = 0;

    /* renamed from: r */
    private boolean f6417r = false;

    /* renamed from: s */
    private final BroadcastReceiver f6418s = new C0839sn(this);

    private C0835sm(C0840so soVar) {
        this.f6410k = soVar;
    }

    /* renamed from: a */
    public static C0835sm m13702a(C0840so soVar) {
        C0835sm smVar = f6403d;
        if (smVar != null) {
            return smVar;
        }
        C0835sm smVar2 = new C0835sm(soVar);
        f6403d = smVar2;
        return smVar2;
    }

    /* renamed from: a */
    public List<UsbDevice> mo5738a(Context context) {
        UsbManager usbManager = (UsbManager) context.getSystemService("usb");
        this.f6409j = usbManager;
        return C0325cn.m11782a(usbManager.getDeviceList().values()).mo4725a($$Lambda$whroLhWjCc_3tpj4KZe0fiqj_ng.INSTANCE).mo4779i();
    }

    /* renamed from: b */
    public boolean mo5742b(Context context) {
        m13716d(context);
        List<C0838c> list = this.f6404e;
        if (list == null || list.size() == 0) {
            List<R> i = C0325cn.m11782a(mo5738a(context)).mo4743b(new C0391ei() {
                public final Object apply(Object obj) {
                    return C0835sm.this.m13713c((UsbDevice) obj);
                }
            }).mo4779i();
            this.f6404e = i;
            if (i.size() == 0) {
                return false;
            }
            for (C0838c a : this.f6404e) {
                this.f6406g.add(m13700a(context, a));
            }
            if (this.f6407h) {
                return true;
            }
            m13703a();
            return true;
        }
        List<R> i2 = C0325cn.m11782a(mo5738a(context)).mo4743b(new C0391ei() {
            public final Object apply(Object obj) {
                return C0835sm.this.m13709b((UsbDevice) obj);
            }
        }).mo4725a(new C0496hg() {
            public final boolean test(Object obj) {
                return C0835sm.this.m13712b((C0835sm.C0838c) obj);
            }
        }).mo4779i();
        if (i2.size() == 0) {
            return false;
        }
        for (R a2 : i2) {
            this.f6406g.add(m13700a(context, (C0838c) a2));
        }
        this.f6404e.addAll(i2);
        if (this.f6407h) {
            return true;
        }
        m13703a();
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public /* synthetic */ C0838c m13713c(UsbDevice usbDevice) {
        return new C0838c(usbDevice);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ C0838c m13709b(UsbDevice usbDevice) {
        return new C0838c(usbDevice);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ boolean m13712b(C0838c cVar) {
        return !this.f6404e.contains(cVar);
    }

    /* renamed from: a */
    public boolean mo5739a(Context context, int i, int i2, int i3, int i4, int i5) {
        this.f6411l = i;
        this.f6412m = i2;
        this.f6413n = i3;
        this.f6414o = i4;
        this.f6415p = i5;
        this.f6416q = 1;
        return mo5742b(context);
    }

    /* renamed from: a */
    public boolean mo5741a(C0842sq sqVar) {
        sqVar.mo5697d();
        this.f6405f = C0867ta.m13885a(this.f6405f, new C0496hg() {
            public final boolean test(Object obj) {
                return C0835sm.m13708a(C0842sq.this, (C0842sq) obj);
            }
        });
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ boolean m13708a(C0842sq sqVar, C0842sq sqVar2) {
        return sqVar.mo5760k() == sqVar2.mo5760k();
    }

    /* renamed from: a */
    public boolean mo5740a(UsbDevice usbDevice) {
        List<T> i = C0325cn.m11782a(this.f6405f).mo4725a(new C0496hg(usbDevice) {
            public final /* synthetic */ UsbDevice f$0;

            {
                this.f$0 = r1;
            }

            public final boolean test(Object obj) {
                return C0835sm.m13711b(this.f$0, (C0842sq) obj);
            }
        }).mo4779i();
        int i2 = 0;
        for (T d : i) {
            d.mo5697d();
            this.f6405f = C0867ta.m13885a(this.f6405f, new C0496hg(usbDevice) {
                public final /* synthetic */ UsbDevice f$0;

                {
                    this.f$0 = r1;
                }

                public final boolean test(Object obj) {
                    return C0835sm.m13706a(this.f$0, (C0842sq) obj);
                }
            });
            i2++;
        }
        if (i2 == i.size()) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static /* synthetic */ boolean m13711b(UsbDevice usbDevice, C0842sq sqVar) {
        return usbDevice.getDeviceId() == sqVar.mo5760k();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ boolean m13706a(UsbDevice usbDevice, C0842sq sqVar) {
        return usbDevice.getDeviceId() == sqVar.mo5760k();
    }

    /* renamed from: c */
    public void mo5743c(Context context) {
        if (this.f6417r) {
            context.unregisterReceiver(this.f6418s);
            this.f6417r = false;
        }
    }

    /* renamed from: a */
    private C0837b m13700a(Context context, C0838c cVar) {
        PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, new Intent(f6400a), 0);
        C0837b bVar = new C0837b(this, (C0839sn) null);
        bVar.f6421a = broadcast;
        bVar.f6422b = cVar;
        return bVar;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m13703a() {
        try {
            this.f6407h = true;
            C0837b take = this.f6406g.take();
            this.f6408i = take;
            this.f6409j.requestPermission(take.f6422b.f6424a, this.f6408i.f6421a);
        } catch (InterruptedException e) {
            e.printStackTrace();
            this.f6407h = false;
        }
    }

    /* renamed from: d */
    private void m13716d(Context context) {
        if (!this.f6417r) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(f6400a);
            context.registerReceiver(this.f6418s, intentFilter);
            this.f6417r = true;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m13704a(C0838c cVar) {
        int interfaceCount = cVar.f6424a.getInterfaceCount();
        for (int i = 0; i <= interfaceCount - 1; i++) {
            if (cVar.f6425b == null) {
                cVar.f6425b = this.f6409j.openDevice(cVar.f6424a);
            }
            this.f6405f.add(C0842sq.m13736a(cVar.f6424a, cVar.f6425b, i));
        }
    }

    /* renamed from: atakplugin.UASTool.sm$a */
    private class C0836a extends Thread {

        /* renamed from: b */
        private final List<C0842sq> f6420b;

        public C0836a(List<C0842sq> list) {
            this.f6420b = list;
        }

        public void run() {
            int i = 1;
            for (C0842sq next : this.f6420b) {
                if (!next.f6444F && next.mo5696c()) {
                    next.mo5682a(C0835sm.this.f6411l);
                    next.mo5692b(C0835sm.this.f6412m);
                    next.mo5694c(C0835sm.this.f6413n);
                    next.mo5698d(C0835sm.this.f6414o);
                    next.mo5699e(C0835sm.this.f6415p);
                    next.mo5751a("COM " + String.valueOf(i));
                    i++;
                }
            }
            C0835sm.this.f6410k.mo5747a(C0835sm.this.f6405f);
        }
    }

    /* renamed from: atakplugin.UASTool.sm$c */
    private class C0838c {

        /* renamed from: a */
        public UsbDevice f6424a;

        /* renamed from: b */
        public UsbDeviceConnection f6425b;

        /* renamed from: c */
        public boolean f6426c;

        public C0838c(UsbDevice usbDevice) {
            this.f6424a = usbDevice;
        }

        public boolean equals(Object obj) {
            return ((C0838c) obj).f6424a.getDeviceId() == this.f6424a.getDeviceId();
        }
    }

    /* renamed from: atakplugin.UASTool.sm$b */
    private class C0837b {

        /* renamed from: a */
        public PendingIntent f6421a;

        /* renamed from: b */
        public C0838c f6422b;

        private C0837b() {
        }

        /* synthetic */ C0837b(C0835sm smVar, C0839sn snVar) {
            this();
        }
    }
}
