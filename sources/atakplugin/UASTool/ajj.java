package atakplugin.UASTool;

import java.net.Socket;

final class ajj implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Socket[] f1624a;

    /* renamed from: b */
    final /* synthetic */ String f1625b;

    /* renamed from: c */
    final /* synthetic */ int f1626c;

    /* renamed from: d */
    final /* synthetic */ Exception[] f1627d;

    ajj(Socket[] socketArr, String str, int i, Exception[] excArr) {
        this.f1624a = socketArr;
        this.f1625b = str;
        this.f1626c = i;
        this.f1627d = excArr;
    }

    public void run() {
        Socket[] socketArr = this.f1624a;
        socketArr[0] = null;
        try {
            socketArr[0] = new Socket(this.f1625b, this.f1626c);
        } catch (Exception e) {
            this.f1627d[0] = e;
            Socket[] socketArr2 = this.f1624a;
            if (socketArr2[0] != null && socketArr2[0].isConnected()) {
                try {
                    this.f1624a[0].close();
                } catch (Exception unused) {
                }
            }
            this.f1624a[0] = null;
        }
    }
}
