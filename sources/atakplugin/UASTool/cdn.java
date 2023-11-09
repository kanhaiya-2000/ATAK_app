package atakplugin.UASTool;

class cdn extends cdq implements ccc {

    /* renamed from: a */
    private Class f4548a;

    cdn(Class cls) {
        super(8, can.f4458k, cls);
        this.f4548a = cls;
    }

    cdn(String str) {
        super(str);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String mo4505a(cds cds) {
        if (this.f4548a == null) {
            this.f4548a = mo4549c(3);
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("lock(");
        stringBuffer.append(cds.mo4557a(this.f4548a));
        stringBuffer.append(")");
        return stringBuffer.toString();
    }

    /* renamed from: g */
    public Class mo4410g() {
        if (this.f4548a == null) {
            this.f4548a = mo4549c(3);
        }
        return this.f4548a;
    }
}
