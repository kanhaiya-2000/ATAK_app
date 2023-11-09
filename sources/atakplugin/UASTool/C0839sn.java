package atakplugin.UASTool;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import atakplugin.UASTool.C0835sm;

/* renamed from: atakplugin.UASTool.sn */
class C0839sn extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ C0835sm f6428a;

    C0839sn(C0835sm smVar) {
        this.f6428a = smVar;
    }

    public void onReceive(Context context, Intent intent) {
        if (!intent.getAction().equals("com.felhr.usbserial.USB_PERMISSION")) {
            return;
        }
        if (intent.getExtras().getBoolean("permission")) {
            C0835sm smVar = this.f6428a;
            smVar.m13704a(smVar.f6408i.f6422b);
            if (this.f6428a.f6406g.size() > 0) {
                this.f6428a.m13703a();
                return;
            }
            boolean unused = this.f6428a.f6407h = false;
            if (this.f6428a.f6416q == 0) {
                this.f6428a.f6410k.mo5747a(this.f6428a.f6405f);
                return;
            }
            C0835sm smVar2 = this.f6428a;
            new C0835sm.C0836a(smVar2.f6405f).start();
        } else if (this.f6428a.f6406g.size() > 0) {
            this.f6428a.m13703a();
        } else {
            boolean unused2 = this.f6428a.f6407h = false;
            if (this.f6428a.f6416q == 0) {
                this.f6428a.f6410k.mo5747a(this.f6428a.f6405f);
                return;
            }
            C0835sm smVar3 = this.f6428a;
            new C0835sm.C0836a(smVar3.f6405f).start();
        }
    }
}
