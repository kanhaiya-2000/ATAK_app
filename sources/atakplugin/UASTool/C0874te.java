package atakplugin.UASTool;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.hardware.usb.UsbDevice;

/* renamed from: atakplugin.UASTool.te */
class C0874te extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ C0870td f6640a;

    C0874te(C0870td tdVar) {
        this.f6640a = tdVar;
    }

    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if ("android.hardware.usb.action.USB_DEVICE_DETACHED".equals(action)) {
            UsbDevice usbDevice = (UsbDevice) intent.getParcelableExtra("device");
            C0879tj a = this.f6640a.m13894c(usbDevice);
            while (a != null) {
                a.mo5865g();
                synchronized (this.f6640a.f6621ah) {
                    this.f6640a.f6621ah.remove(a);
                }
                a = this.f6640a.m13894c(usbDevice);
            }
        } else if ("android.hardware.usb.action.USB_DEVICE_ATTACHED".equals(action)) {
            this.f6640a.mo5814b((UsbDevice) intent.getParcelableExtra("device"));
        }
    }
}
