package atakplugin.UASTool;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

class cdl extends cdh implements cbx {

    /* renamed from: a */
    private Constructor f4538a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    cdl(int i, Class cls) {
        super(i, Modifier.isStatic(i) ? "<clinit>" : "<init>", cls, cdq.f4554m, cdq.f4553l, cdq.f4554m);
    }

    cdl(String str) {
        super(str);
    }

    /* renamed from: c */
    public String mo4346c() {
        return Modifier.isStatic(mo4347d()) ? "<clinit>" : "<init>";
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String mo4505a(cds cds) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(cds.mo4556a(mo4347d()));
        stringBuffer.append(cds.mo4558a(mo4348e(), mo4349f()));
        stringBuffer.append(".");
        stringBuffer.append(mo4346c());
        return stringBuffer.toString();
    }

    /* renamed from: g */
    public Constructor mo4410g() {
        if (this.f4538a == null) {
            try {
                this.f4538a = mo4348e().getDeclaredConstructor(mo4414i());
            } catch (Exception unused) {
            }
        }
        return this.f4538a;
    }
}
