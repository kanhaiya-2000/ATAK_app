package atakplugin.UASTool;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.hardware.usb.UsbDevice;
import android.util.Log;

/* renamed from: atakplugin.UASTool.tf */
class C0875tf extends BroadcastReceiver {
    C0875tf() {
    }

    public void onReceive(Context context, Intent intent) {
        if ("com.ftdi.j2xx".equals(intent.getAction())) {
            synchronized (this) {
                UsbDevice usbDevice = (UsbDevice) intent.getParcelableExtra("device");
                if (!intent.getBooleanExtra("permission", false)) {
                    Log.d("D2xx::", "permission denied for device " + usbDevice);
                }
            }
        }
    }
}
