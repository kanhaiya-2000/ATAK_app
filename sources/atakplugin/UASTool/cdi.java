package atakplugin.UASTool;

import java.lang.reflect.Constructor;

class cdi extends cdh implements cbq {

    /* renamed from: a */
    private Constructor f4528a;

    /* renamed from: c */
    public String mo4346c() {
        return "<init>";
    }

    cdi(int i, Class cls, Class[] clsArr, String[] strArr, Class[] clsArr2) {
        super(i, "<init>", cls, clsArr, strArr, clsArr2);
    }

    cdi(String str) {
        super(str);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String mo4505a(cds cds) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(cds.mo4556a(mo4347d()));
        stringBuffer.append(cds.mo4558a(mo4348e(), mo4349f()));
        cds.mo4563b(stringBuffer, mo4414i());
        cds.mo4564c(stringBuffer, mo4416k());
        return stringBuffer.toString();
    }

    /* renamed from: g */
    public Constructor mo4410g() {
        if (this.f4528a == null) {
            try {
                this.f4528a = mo4348e().getDeclaredConstructor(mo4414i());
            } catch (Exception unused) {
            }
        }
        return this.f4528a;
    }
}
