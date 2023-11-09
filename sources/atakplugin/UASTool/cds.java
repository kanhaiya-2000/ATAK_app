package atakplugin.UASTool;

import java.lang.reflect.Modifier;

class cds {

    /* renamed from: j */
    static cds f4567j;

    /* renamed from: k */
    static cds f4568k;

    /* renamed from: l */
    static cds f4569l;

    /* renamed from: a */
    boolean f4570a = true;

    /* renamed from: b */
    boolean f4571b = true;

    /* renamed from: c */
    boolean f4572c = false;

    /* renamed from: d */
    boolean f4573d = false;

    /* renamed from: e */
    boolean f4574e = false;

    /* renamed from: f */
    boolean f4575f = true;

    /* renamed from: g */
    boolean f4576g = true;

    /* renamed from: h */
    boolean f4577h = true;

    /* renamed from: i */
    int f4578i;

    cds() {
    }

    static {
        cds cds = new cds();
        f4567j = cds;
        cds.f4570a = true;
        cds.f4571b = false;
        cds.f4572c = false;
        cds.f4573d = false;
        cds.f4574e = true;
        cds.f4575f = false;
        cds.f4576g = false;
        cds.f4578i = 0;
        cds cds2 = new cds();
        f4568k = cds2;
        cds2.f4570a = true;
        cds2.f4571b = true;
        cds2.f4572c = false;
        cds2.f4573d = false;
        cds2.f4574e = false;
        f4567j.f4578i = 1;
        cds cds3 = new cds();
        f4569l = cds3;
        cds3.f4570a = false;
        cds3.f4571b = true;
        cds3.f4572c = false;
        cds3.f4573d = true;
        cds3.f4574e = false;
        cds3.f4577h = false;
        cds3.f4578i = 2;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String mo4560a(String str) {
        int lastIndexOf = str.lastIndexOf(45);
        if (lastIndexOf == -1) {
            return str;
        }
        return str.substring(lastIndexOf + 1);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String mo4556a(int i) {
        if (!this.f4573d) {
            return "";
        }
        String modifier = Modifier.toString(i);
        if (modifier.length() == 0) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(modifier);
        stringBuffer.append(" ");
        return stringBuffer.toString();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public String mo4562b(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf == -1) {
            return str;
        }
        return str.substring(lastIndexOf + 1);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String mo4559a(Class cls, String str, boolean z) {
        if (cls == null) {
            return "ANONYMOUS";
        }
        if (cls.isArray()) {
            Class<?> componentType = cls.getComponentType();
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(mo4559a(componentType, componentType.getName(), z));
            stringBuffer.append("[]");
            return stringBuffer.toString();
        } else if (z) {
            return mo4562b(str).replace(bpg.f3094b, '.');
        } else {
            return str.replace(bpg.f3094b, '.');
        }
    }

    /* renamed from: a */
    public String mo4557a(Class cls) {
        return mo4559a(cls, cls.getName(), this.f4570a);
    }

    /* renamed from: a */
    public String mo4558a(Class cls, String str) {
        return mo4559a(cls, str, this.f4574e);
    }

    /* renamed from: a */
    public void mo4561a(StringBuffer stringBuffer, Class[] clsArr) {
        for (int i = 0; i < clsArr.length; i++) {
            if (i > 0) {
                stringBuffer.append(", ");
            }
            stringBuffer.append(mo4557a(clsArr[i]));
        }
    }

    /* renamed from: b */
    public void mo4563b(StringBuffer stringBuffer, Class[] clsArr) {
        if (clsArr != null) {
            if (this.f4571b) {
                stringBuffer.append("(");
                mo4561a(stringBuffer, clsArr);
                stringBuffer.append(")");
            } else if (clsArr.length == 0) {
                stringBuffer.append("()");
            } else {
                stringBuffer.append("(..)");
            }
        }
    }

    /* renamed from: c */
    public void mo4564c(StringBuffer stringBuffer, Class[] clsArr) {
        if (this.f4572c && clsArr != null && clsArr.length != 0) {
            stringBuffer.append(" throws ");
            mo4561a(stringBuffer, clsArr);
        }
    }
}
