package atakplugin.UASTool;

public class cao extends RuntimeException {

    /* renamed from: a */
    Throwable f4461a;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public cao(java.lang.String r3, java.lang.Throwable r4) {
        /*
            r2 = this;
            if (r4 != 0) goto L_0x0003
            goto L_0x001c
        L_0x0003:
            java.lang.StringBuffer r0 = new java.lang.StringBuffer
            r0.<init>()
            java.lang.String r1 = "Exception while initializing "
            r0.append(r1)
            r0.append(r3)
            java.lang.String r3 = ": "
            r0.append(r3)
            r0.append(r4)
            java.lang.String r3 = r0.toString()
        L_0x001c:
            r2.<init>(r3)
            r2.f4461a = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.cao.<init>(java.lang.String, java.lang.Throwable):void");
    }

    public cao() {
    }

    public Throwable getCause() {
        return this.f4461a;
    }
}
