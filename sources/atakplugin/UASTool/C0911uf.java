package atakplugin.UASTool;

import android.util.Log;

/* renamed from: atakplugin.UASTool.uf */
class C0911uf implements Runnable {

    /* renamed from: a */
    int f7111a;

    /* renamed from: b */
    private C0910ue f7112b;

    C0911uf(C0910ue ueVar) {
        this.f7112b = ueVar;
        this.f7111a = ueVar.mo5925b().mo5823c();
    }

    public void run() {
        int i = 0;
        while (true) {
            try {
                C0909ud c = this.f7112b.mo5928c(i);
                if (c.mo5915c() > 0) {
                    this.f7112b.mo5923a(c);
                    c.mo5917d();
                }
                this.f7112b.mo5930d(i);
                i = (i + 1) % this.f7111a;
                if (Thread.interrupted()) {
                    throw new InterruptedException();
                }
            } catch (InterruptedException e) {
                Log.d("ProcessRequestThread::", "Device has been closed.");
                e.printStackTrace();
                return;
            } catch (Exception e2) {
                Log.e("ProcessRequestThread::", "Fatal error!");
                e2.printStackTrace();
                return;
            }
        }
    }
}
