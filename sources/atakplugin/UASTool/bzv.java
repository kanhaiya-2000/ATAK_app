package atakplugin.UASTool;

import java.lang.reflect.Type;

public class bzv implements cbt {

    /* renamed from: a */
    private cbm<?> f4390a;

    /* renamed from: b */
    private cco f4391b;

    /* renamed from: c */
    private Type[] f4392c;

    /* renamed from: d */
    private String f4393d;

    /* renamed from: e */
    private String f4394e;

    /* renamed from: f */
    private boolean f4395f;

    /* renamed from: g */
    private boolean f4396g = false;

    public bzv(String str, String str2, boolean z, cbm<?> cbm) {
        this.f4391b = new cak(str);
        this.f4395f = z;
        this.f4390a = cbm;
        this.f4393d = str2;
        try {
            this.f4392c = cah.m10990a(str2, cbm.mo4228e());
        } catch (ClassNotFoundException e) {
            this.f4396g = true;
            this.f4394e = e.getMessage();
        }
    }

    /* renamed from: a */
    public cbm mo4270a() {
        return this.f4390a;
    }

    /* renamed from: b */
    public cco mo4271b() {
        return this.f4391b;
    }

    /* renamed from: c */
    public boolean mo4272c() {
        return this.f4395f;
    }

    /* renamed from: d */
    public boolean mo4273d() {
        return !this.f4395f;
    }

    /* renamed from: e */
    public Type[] mo4274e() {
        if (!this.f4396g) {
            return this.f4392c;
        }
        throw new ClassNotFoundException(this.f4394e);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("declare parents : ");
        stringBuffer.append(mo4271b().mo4321a());
        stringBuffer.append(mo4272c() ? " extends " : " implements ");
        stringBuffer.append(this.f4393d);
        return stringBuffer.toString();
    }
}
