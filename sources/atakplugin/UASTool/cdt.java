package atakplugin.UASTool;

class cdt extends cdq implements ccq {

    /* renamed from: a */
    private Class f4579a;

    cdt(Class cls) {
        super(8, can.f4459l, cls);
        this.f4579a = cls;
    }

    cdt(String str) {
        super(str);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String mo4505a(cds cds) {
        if (this.f4579a == null) {
            this.f4579a = mo4549c(3);
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("unlock(");
        stringBuffer.append(cds.mo4557a(this.f4579a));
        stringBuffer.append(")");
        return stringBuffer.toString();
    }

    /* renamed from: g */
    public Class mo4410g() {
        if (this.f4579a == null) {
            this.f4579a = mo4549c(3);
        }
        return this.f4579a;
    }
}
