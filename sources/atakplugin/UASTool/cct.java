package atakplugin.UASTool;

import indago.serialization.JsonValueConstants;

public class cct {

    /* renamed from: a */
    private static cdb f4499a;

    /* renamed from: b */
    private ccy f4500b = f4499a.mo4501b();

    static {
        m11274g();
    }

    /* renamed from: a */
    public void mo4458a() {
        this.f4500b.mo4471a();
    }

    /* renamed from: b */
    public void mo4459b() {
        this.f4500b.mo4472b();
        if (!this.f4500b.mo4473c()) {
            this.f4500b.mo4474d();
        }
    }

    /* renamed from: c */
    public boolean mo4460c() {
        return this.f4500b.mo4473c();
    }

    /* renamed from: e */
    private static cdb m11272e() {
        return new cdc();
    }

    /* renamed from: f */
    private static cdb m11273f() {
        return new cdd();
    }

    /* renamed from: g */
    private static void m11274g() {
        String a = m11270a("aspectj.runtime.cflowstack.usethreadlocal", "unspecified");
        boolean z = false;
        if (!a.equals("unspecified") ? a.equals("yes") || a.equals("true") : System.getProperty("java.class.version", JsonValueConstants.VERSION).compareTo("46.0") >= 0) {
            z = true;
        }
        if (z) {
            f4499a = m11272e();
        } else {
            f4499a = m11273f();
        }
    }

    /* renamed from: a */
    private static String m11270a(String str, String str2) {
        try {
            return System.getProperty(str, str2);
        } catch (SecurityException unused) {
            return str2;
        }
    }

    /* renamed from: d */
    public static String m11271d() {
        return f4499a.getClass().getName();
    }
}
