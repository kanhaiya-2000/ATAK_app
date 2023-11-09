package atakplugin.UASTool;

class cdg extends cdq implements cbo {

    /* renamed from: a */
    Class f4523a;

    /* renamed from: b */
    String f4524b;

    cdg(Class cls, Class cls2, String str) {
        super(0, "catch", cls);
        this.f4523a = cls2;
        this.f4524b = str;
    }

    cdg(String str) {
        super(str);
    }

    /* renamed from: g */
    public Class mo4410g() {
        if (this.f4523a == null) {
            this.f4523a = mo4549c(3);
        }
        return this.f4523a;
    }

    /* renamed from: h */
    public String mo4413h() {
        if (this.f4524b == null) {
            this.f4524b = mo4540a(4);
        }
        return this.f4524b;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String mo4505a(cds cds) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("catch(");
        stringBuffer.append(cds.mo4557a(mo4410g()));
        stringBuffer.append(")");
        return stringBuffer.toString();
    }
}
