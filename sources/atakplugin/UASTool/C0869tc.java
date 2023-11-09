package atakplugin.UASTool;

import android.hardware.usb.UsbDeviceConnection;
import android.hardware.usb.UsbEndpoint;
import java.util.concurrent.Semaphore;

/* renamed from: atakplugin.UASTool.tc */
class C0869tc implements Runnable {

    /* renamed from: a */
    UsbDeviceConnection f6551a;

    /* renamed from: b */
    UsbEndpoint f6552b;

    /* renamed from: c */
    C0910ue f6553c;

    /* renamed from: d */
    C0879tj f6554d;

    /* renamed from: e */
    int f6555e;

    /* renamed from: f */
    int f6556f = this.f6553c.mo5925b().mo5821b();

    /* renamed from: g */
    int f6557g = this.f6554d.mo5862d().mo5825d();

    /* renamed from: h */
    Semaphore f6558h = new Semaphore(1);

    /* renamed from: i */
    boolean f6559i = false;

    C0869tc(C0879tj tjVar, C0910ue ueVar, UsbDeviceConnection usbDeviceConnection, UsbEndpoint usbEndpoint) {
        this.f6554d = tjVar;
        this.f6552b = usbEndpoint;
        this.f6551a = usbDeviceConnection;
        this.f6553c = ueVar;
        this.f6555e = ueVar.mo5925b().mo5823c();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5798a() {
        this.f6558h.acquire();
        this.f6559i = true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo5799b() {
        this.f6559i = false;
        this.f6558h.release();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public boolean mo5800c() {
        return this.f6559i;
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0063 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r9 = this;
            java.lang.String r0 = "BulkIn::"
            r1 = 0
        L_0x0003:
            boolean r2 = r9.f6559i     // Catch:{ InterruptedException -> 0x0063, Exception -> 0x0059 }
            if (r2 == 0) goto L_0x0011
            java.util.concurrent.Semaphore r2 = r9.f6558h     // Catch:{ InterruptedException -> 0x0063, Exception -> 0x0059 }
            r2.acquire()     // Catch:{ InterruptedException -> 0x0063, Exception -> 0x0059 }
            java.util.concurrent.Semaphore r2 = r9.f6558h     // Catch:{ InterruptedException -> 0x0063, Exception -> 0x0059 }
            r2.release()     // Catch:{ InterruptedException -> 0x0063, Exception -> 0x0059 }
        L_0x0011:
            atakplugin.UASTool.ue r2 = r9.f6553c     // Catch:{ InterruptedException -> 0x0063, Exception -> 0x0059 }
            atakplugin.UASTool.ud r2 = r2.mo5926b((int) r1)     // Catch:{ InterruptedException -> 0x0063, Exception -> 0x0059 }
            int r3 = r2.mo5915c()     // Catch:{ InterruptedException -> 0x0063, Exception -> 0x0059 }
            if (r3 != 0) goto L_0x0047
            java.nio.ByteBuffer r3 = r2.mo5913b()     // Catch:{ InterruptedException -> 0x0063, Exception -> 0x0059 }
            r3.clear()     // Catch:{ InterruptedException -> 0x0063, Exception -> 0x0059 }
            r2.mo5912a(r1)     // Catch:{ InterruptedException -> 0x0063, Exception -> 0x0059 }
            byte[] r4 = r3.array()     // Catch:{ InterruptedException -> 0x0063, Exception -> 0x0059 }
            android.hardware.usb.UsbDeviceConnection r5 = r9.f6551a     // Catch:{ InterruptedException -> 0x0063, Exception -> 0x0059 }
            android.hardware.usb.UsbEndpoint r6 = r9.f6552b     // Catch:{ InterruptedException -> 0x0063, Exception -> 0x0059 }
            int r7 = r9.f6556f     // Catch:{ InterruptedException -> 0x0063, Exception -> 0x0059 }
            int r8 = r9.f6557g     // Catch:{ InterruptedException -> 0x0063, Exception -> 0x0059 }
            int r4 = r5.bulkTransfer(r6, r4, r7, r8)     // Catch:{ InterruptedException -> 0x0063, Exception -> 0x0059 }
            if (r4 <= 0) goto L_0x0047
            r3.position(r4)     // Catch:{ InterruptedException -> 0x0063, Exception -> 0x0059 }
            r3.flip()     // Catch:{ InterruptedException -> 0x0063, Exception -> 0x0059 }
            r2.mo5914b(r4)     // Catch:{ InterruptedException -> 0x0063, Exception -> 0x0059 }
            atakplugin.UASTool.ue r2 = r9.f6553c     // Catch:{ InterruptedException -> 0x0063, Exception -> 0x0059 }
            r2.mo5932e(r1)     // Catch:{ InterruptedException -> 0x0063, Exception -> 0x0059 }
        L_0x0047:
            int r1 = r1 + 1
            int r2 = r9.f6555e     // Catch:{ InterruptedException -> 0x0063, Exception -> 0x0059 }
            int r1 = r1 % r2
            boolean r2 = java.lang.Thread.interrupted()     // Catch:{ InterruptedException -> 0x0063, Exception -> 0x0059 }
            if (r2 != 0) goto L_0x0053
            goto L_0x0003
        L_0x0053:
            java.lang.InterruptedException r1 = new java.lang.InterruptedException     // Catch:{ InterruptedException -> 0x0063, Exception -> 0x0059 }
            r1.<init>()     // Catch:{ InterruptedException -> 0x0063, Exception -> 0x0059 }
            throw r1     // Catch:{ InterruptedException -> 0x0063, Exception -> 0x0059 }
        L_0x0059:
            r1 = move-exception
            r1.printStackTrace()
            java.lang.String r1 = "Fatal error in BulkIn thread"
            android.util.Log.e(r0, r1)
            goto L_0x0077
        L_0x0063:
            atakplugin.UASTool.ue r1 = r9.f6553c     // Catch:{ Exception -> 0x006e }
            r1.mo5933f()     // Catch:{ Exception -> 0x006e }
            atakplugin.UASTool.ue r1 = r9.f6553c     // Catch:{ Exception -> 0x006e }
            r1.mo5931e()     // Catch:{ Exception -> 0x006e }
            goto L_0x0077
        L_0x006e:
            r1 = move-exception
            java.lang.String r2 = "Stop BulkIn thread"
            android.util.Log.d(r0, r2)
            r1.printStackTrace()
        L_0x0077:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.C0869tc.run():void");
    }
}
