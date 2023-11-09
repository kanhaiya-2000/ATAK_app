package atakplugin.UASTool;

import indago.serialization.JsonValueConstants;
import java.util.Stack;

public class ccv {

    /* renamed from: a */
    private static cdb f4502a;

    /* renamed from: b */
    private cda f4503b = f4502a.mo4500a();

    static {
        m11284k();
    }

    /* renamed from: h */
    private Stack m11281h() {
        return this.f4503b.mo4498a();
    }

    /* renamed from: a */
    public void mo4463a(Object obj) {
        m11281h().push(obj);
    }

    /* renamed from: b */
    public void mo4466b(Object obj) {
        m11281h().push(new ccr(obj));
    }

    /* renamed from: a */
    public void mo4464a(Object[] objArr) {
        m11281h().push(new ccu(objArr));
    }

    /* renamed from: a */
    public void mo4462a() {
        Stack h = m11281h();
        h.pop();
        if (h.isEmpty()) {
            this.f4503b.mo4499b();
        }
    }

    /* renamed from: b */
    public Object mo4465b() {
        Stack h = m11281h();
        if (!h.isEmpty()) {
            return h.peek();
        }
        throw new cao();
    }

    /* renamed from: a */
    public Object mo4461a(int i) {
        ccr d = mo4468d();
        if (d == null) {
            return null;
        }
        return d.mo4450a(i);
    }

    /* renamed from: c */
    public Object mo4467c() {
        ccr d = mo4468d();
        if (d != null) {
            return d.mo4449a();
        }
        throw new cao();
    }

    /* renamed from: d */
    public ccr mo4468d() {
        Stack h = m11281h();
        if (h.isEmpty()) {
            return null;
        }
        return (ccr) h.peek();
    }

    /* renamed from: e */
    public ccr mo4469e() {
        Stack h = m11281h();
        if (h.isEmpty()) {
            return null;
        }
        return (ccr) h.elementAt(0);
    }

    /* renamed from: f */
    public boolean mo4470f() {
        return !m11281h().isEmpty();
    }

    /* renamed from: i */
    private static cdb m11282i() {
        return new cdc();
    }

    /* renamed from: j */
    private static cdb m11283j() {
        return new cdd();
    }

    /* renamed from: k */
    private static void m11284k() {
        String a = m11279a("aspectj.runtime.cflowstack.usethreadlocal", "unspecified");
        boolean z = false;
        if (!a.equals("unspecified") ? a.equals("yes") || a.equals("true") : System.getProperty("java.class.version", JsonValueConstants.VERSION).compareTo("46.0") >= 0) {
            z = true;
        }
        if (z) {
            f4502a = m11282i();
        } else {
            f4502a = m11283j();
        }
    }

    /* renamed from: a */
    private static String m11279a(String str, String str2) {
        try {
            return System.getProperty(str, str2);
        } catch (SecurityException unused) {
            return str2;
        }
    }

    /* renamed from: g */
    public static String m11280g() {
        return f4502a.getClass().getName();
    }
}
