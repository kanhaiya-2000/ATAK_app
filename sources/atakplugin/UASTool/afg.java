package atakplugin.UASTool;

import android.util.Log;

public class afg extends afp {

    /* renamed from: b */
    private static final String f852b = "isoparser";

    /* renamed from: a */
    String f853a;

    public afg(String str) {
        this.f853a = str;
    }

    /* renamed from: a */
    public void mo574a(String str) {
        Log.d(f852b, String.valueOf(this.f853a) + ":" + str);
    }

    /* renamed from: b */
    public void mo575b(String str) {
        Log.w(f852b, String.valueOf(this.f853a) + ":" + str);
    }

    /* renamed from: c */
    public void mo576c(String str) {
        Log.e(f852b, String.valueOf(this.f853a) + ":" + str);
    }
}
