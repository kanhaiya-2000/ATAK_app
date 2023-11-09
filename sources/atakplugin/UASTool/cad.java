package atakplugin.UASTool;

public class cad extends cac implements cck {

    /* renamed from: a */
    private final ccl f4421a;

    public cad(cci cci, String str) {
        super(cci);
        this.f4421a = new cae(str);
    }

    /* renamed from: b */
    public ccl mo4305b() {
        return this.f4421a;
    }

    /* renamed from: atakplugin.UASTool.cad$1 */
    /* synthetic */ class C02941 {

        /* renamed from: a */
        static final /* synthetic */ int[] f4422a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                atakplugin.UASTool.cci[] r0 = atakplugin.UASTool.cci.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f4422a = r0
                atakplugin.UASTool.cci r1 = atakplugin.UASTool.cci.PERCFLOW     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f4422a     // Catch:{ NoSuchFieldError -> 0x001d }
                atakplugin.UASTool.cci r1 = atakplugin.UASTool.cci.PERCFLOWBELOW     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f4422a     // Catch:{ NoSuchFieldError -> 0x0028 }
                atakplugin.UASTool.cci r1 = atakplugin.UASTool.cci.PERTARGET     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f4422a     // Catch:{ NoSuchFieldError -> 0x0033 }
                atakplugin.UASTool.cci r1 = atakplugin.UASTool.cci.PERTHIS     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.cad.C02941.<clinit>():void");
        }
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        int i = C02941.f4422a[mo4303a().ordinal()];
        if (i == 1) {
            stringBuffer.append("percflow(");
        } else if (i == 2) {
            stringBuffer.append("percflowbelow(");
        } else if (i == 3) {
            stringBuffer.append("pertarget(");
        } else if (i == 4) {
            stringBuffer.append("perthis(");
        }
        stringBuffer.append(this.f4421a.mo4306a());
        stringBuffer.append(")");
        return stringBuffer.toString();
    }
}
