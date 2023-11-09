package atakplugin.UASTool;

import java.lang.reflect.Field;

public class cdk extends cdo implements cbw {

    /* renamed from: a */
    Class f4536a;

    /* renamed from: b */
    private Field f4537b;

    cdk(int i, String str, Class cls, Class cls2) {
        super(i, str, cls);
        this.f4536a = cls2;
    }

    cdk(String str) {
        super(str);
    }

    /* renamed from: g */
    public Class mo4410g() {
        if (this.f4536a == null) {
            this.f4536a = mo4549c(3);
        }
        return this.f4536a;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String mo4505a(cds cds) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(cds.mo4556a(mo4347d()));
        if (cds.f4571b) {
            stringBuffer.append(cds.mo4557a(mo4410g()));
        }
        if (cds.f4571b) {
            stringBuffer.append(" ");
        }
        stringBuffer.append(cds.mo4558a(mo4348e(), mo4349f()));
        stringBuffer.append(".");
        stringBuffer.append(mo4346c());
        return stringBuffer.toString();
    }

    /* renamed from: h */
    public Field mo4419h() {
        if (this.f4537b == null) {
            try {
                this.f4537b = mo4348e().getDeclaredField(mo4346c());
            } catch (Exception unused) {
            }
        }
        return this.f4537b;
    }
}
