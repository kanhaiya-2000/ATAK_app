package atakplugin.UASTool;

import atakplugin.UASTool.cbr;
import java.lang.annotation.Annotation;

public class bzt implements cbr {

    /* renamed from: a */
    private Annotation f4379a;

    /* renamed from: b */
    private String f4380b;

    /* renamed from: c */
    private cbm<?> f4381c;

    /* renamed from: d */
    private cbr.C0298a f4382d;

    /* renamed from: e */
    private cco f4383e;

    /* renamed from: f */
    private ccm f4384f;

    public bzt(cbm<?> cbm, String str, String str2, Annotation annotation, String str3) {
        this.f4381c = cbm;
        if (str.equals("at_type")) {
            this.f4382d = cbr.C0298a.Type;
        } else if (str.equals("at_field")) {
            this.f4382d = cbr.C0298a.Field;
        } else if (str.equals("at_method")) {
            this.f4382d = cbr.C0298a.Method;
        } else if (str.equals("at_constructor")) {
            this.f4382d = cbr.C0298a.Constructor;
        } else {
            throw new IllegalStateException("Unknown declare annotation kind: " + str);
        }
        if (this.f4382d == cbr.C0298a.Type) {
            this.f4383e = new cak(str2);
        } else {
            this.f4384f = new cag(str2);
        }
        this.f4379a = annotation;
        this.f4380b = str3;
    }

    /* renamed from: a */
    public cbm<?> mo4258a() {
        return this.f4381c;
    }

    /* renamed from: b */
    public cbr.C0298a mo4259b() {
        return this.f4382d;
    }

    /* renamed from: c */
    public ccm mo4260c() {
        return this.f4384f;
    }

    /* renamed from: d */
    public cco mo4261d() {
        return this.f4383e;
    }

    /* renamed from: e */
    public Annotation mo4262e() {
        return this.f4379a;
    }

    /* renamed from: f */
    public String mo4263f() {
        return this.f4380b;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("declare @");
        int i = C02911.f4385a[mo4259b().ordinal()];
        if (i == 1) {
            stringBuffer.append("type : ");
            stringBuffer.append(mo4261d().mo4321a());
        } else if (i == 2) {
            stringBuffer.append("method : ");
            stringBuffer.append(mo4260c().mo4315a());
        } else if (i == 3) {
            stringBuffer.append("field : ");
            stringBuffer.append(mo4260c().mo4315a());
        } else if (i == 4) {
            stringBuffer.append("constructor : ");
            stringBuffer.append(mo4260c().mo4315a());
        }
        stringBuffer.append(" : ");
        stringBuffer.append(mo4263f());
        return stringBuffer.toString();
    }

    /* renamed from: atakplugin.UASTool.bzt$1 */
    /* synthetic */ class C02911 {

        /* renamed from: a */
        static final /* synthetic */ int[] f4385a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                atakplugin.UASTool.cbr$a[] r0 = atakplugin.UASTool.cbr.C0298a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f4385a = r0
                atakplugin.UASTool.cbr$a r1 = atakplugin.UASTool.cbr.C0298a.Type     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f4385a     // Catch:{ NoSuchFieldError -> 0x001d }
                atakplugin.UASTool.cbr$a r1 = atakplugin.UASTool.cbr.C0298a.Method     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f4385a     // Catch:{ NoSuchFieldError -> 0x0028 }
                atakplugin.UASTool.cbr$a r1 = atakplugin.UASTool.cbr.C0298a.Field     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f4385a     // Catch:{ NoSuchFieldError -> 0x0033 }
                atakplugin.UASTool.cbr$a r1 = atakplugin.UASTool.cbr.C0298a.Constructor     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.bzt.C02911.<clinit>():void");
        }
    }
}
