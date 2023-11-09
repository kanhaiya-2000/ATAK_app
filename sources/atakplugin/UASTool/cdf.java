package atakplugin.UASTool;

import java.lang.reflect.Method;

class cdf extends cdh implements cbl {

    /* renamed from: a */
    Class f4521a;

    /* renamed from: o */
    private Method f4522o = null;

    cdf(int i, String str, Class cls, Class[] clsArr, String[] strArr, Class[] clsArr2, Class cls2) {
        super(i, str, cls, clsArr, strArr, clsArr2);
        this.f4521a = cls2;
    }

    cdf(String str) {
        super(str);
    }

    /* renamed from: g */
    public Class mo4410g() {
        if (this.f4521a == null) {
            this.f4521a = mo4549c(6);
        }
        return this.f4521a;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String mo4505a(cds cds) {
        StringBuffer stringBuffer = new StringBuffer();
        if (cds.f4571b) {
            stringBuffer.append(cds.mo4557a(mo4410g()));
        }
        if (cds.f4571b) {
            stringBuffer.append(" ");
        }
        stringBuffer.append(cds.mo4558a(mo4348e(), mo4349f()));
        stringBuffer.append(".");
        stringBuffer.append(m11362b(mo4346c()));
        cds.mo4563b(stringBuffer, mo4414i());
        cds.mo4564c(stringBuffer, mo4416k());
        return stringBuffer.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:6:0x0017  */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String m11362b(java.lang.String r4) {
        /*
            r3 = this;
            r0 = 36
            int r0 = r4.indexOf(r0)
            r1 = -1
            if (r0 != r1) goto L_0x000a
            return r4
        L_0x000a:
            java.util.StringTokenizer r0 = new java.util.StringTokenizer
            java.lang.String r1 = "$"
            r0.<init>(r4, r1)
        L_0x0011:
            boolean r1 = r0.hasMoreTokens()
            if (r1 == 0) goto L_0x0034
            java.lang.String r1 = r0.nextToken()
            java.lang.String r2 = "before"
            boolean r2 = r1.startsWith(r2)
            if (r2 != 0) goto L_0x0033
            java.lang.String r2 = "after"
            boolean r2 = r1.startsWith(r2)
            if (r2 != 0) goto L_0x0033
            java.lang.String r2 = "around"
            boolean r2 = r1.startsWith(r2)
            if (r2 == 0) goto L_0x0011
        L_0x0033:
            return r1
        L_0x0034:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.cdf.m11362b(java.lang.String):java.lang.String");
    }

    /* renamed from: h */
    public Method mo4411h() {
        if (this.f4522o == null) {
            try {
                this.f4522o = mo4348e().getDeclaredMethod(mo4346c(), mo4414i());
            } catch (Exception unused) {
            }
        }
        return this.f4522o;
    }
}
